package kc1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements kc1.b {

    /* renamed from: a, reason: collision with root package name */
    private FileManagerEntity f412004a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements IQQFileTempUtils.a {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils.a
        public void a(Activity activity, int i3) {
            c.this.p(activity, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: kc1.c$c, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C10646c implements IQQFileTempUtils.a {
        C10646c() {
        }

        @Override // com.tencent.mobileqq.filemanager.api.IQQFileTempUtils.a
        public void a(Activity activity, int i3) {
            c.this.p(activity, i3);
        }
    }

    c() {
    }

    private boolean f(Activity activity, int i3) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).checkFileWithCUKingCardHelper(activity, i3, new C10646c());
    }

    private boolean g(Activity activity, int i3) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).checkFileWithFreeWifiHelper(activity, i3, new b());
    }

    private boolean h(Activity activity, BaseQQAppInterface baseQQAppInterface) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).checkStatusToResume(activity, baseQQAppInterface, this.f412004a);
    }

    private boolean i(boolean z16, Activity activity, FMDialogUtil.c cVar) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).checkWifiWithCUKingCardHelper(z16, activity, cVar);
    }

    private boolean j(boolean z16, Activity activity, FMDialogUtil.c cVar) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).checkWifiWithFreeWifiHelper(z16, activity, cVar);
    }

    private void k(String str, String str2) {
        QLog.i("FileModel<FileAssistant>" + str, 1, "Id[" + this.f412004a.nSessionId + "]" + str2);
    }

    public static c l(MessageForFile messageForFile) {
        BaseQQAppInterface baseQQAppInterface;
        try {
            baseQQAppInterface = QQFileManagerUtilImpl.A0();
        } catch (Exception unused) {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null) {
            return m(QQFileManagerUtilImpl.L0(baseQQAppInterface, messageForFile));
        }
        throw new NullPointerException("newFileModel entity app null!");
    }

    public static c m(FileManagerEntity fileManagerEntity) {
        c cVar = new c();
        if (fileManagerEntity == null && QLog.isDevelopLevel()) {
            throw new NullPointerException("newFileModel entity is null!");
        }
        cVar.f412004a = fileManagerEntity;
        return cVar;
    }

    public static c n(String str) {
        try {
            return m(QQFileManagerUtilImpl.k2(new FileInfo(str)));
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
            if (!QLog.isDevelopLevel()) {
                return null;
            }
            throw new NullPointerException("check localPath");
        }
    }

    private void o(Activity activity, int i3, int i16) {
        BaseQQAppInterface baseQQAppInterface;
        String str;
        try {
            baseQQAppInterface = QQFileManagerUtilImpl.A0();
        } catch (Exception unused) {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
            return;
        }
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.N(i16);
        FileManagerEntity fileManagerEntity = this.f412004a;
        if (fileManagerEntity.bSend) {
            str = baseQQAppInterface.getAccount();
        } else {
            str = fileManagerEntity.peerUin;
        }
        forwardFileInfo.w(this.f412004a.getCloudType());
        if (str != null) {
            forwardFileInfo.B(Long.valueOf(str.replace(Marker.ANY_NON_NULL_MARKER, "")).longValue());
        }
        forwardFileInfo.V(this.f412004a.uniseq);
        forwardFileInfo.E(this.f412004a.nSessionId);
        forwardFileInfo.y(this.f412004a.fileName);
        forwardFileInfo.z(this.f412004a.fileSize);
        forwardFileInfo.Z(this.f412004a.Uuid);
        forwardFileInfo.C(this.f412004a.getFilePath());
        Intent intentForFileBrowserActivity = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getIntentForFileBrowserActivity(activity);
        intentForFileBrowserActivity.putExtra("fileinfo", forwardFileInfo);
        intentForFileBrowserActivity.putExtra("file_enter_file_browser_type", i3);
        intentForFileBrowserActivity.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.mjl));
        activity.startActivityForResult(intentForFileBrowserActivity, 102);
        activity.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Activity activity, int i3) {
        BaseQQAppInterface baseQQAppInterface;
        try {
            baseQQAppInterface = QQFileManagerUtilImpl.A0();
        } catch (Exception unused) {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        } else {
            if (h(activity, baseQQAppInterface)) {
                return;
            }
            o(activity, i3, 10004);
        }
    }

    @Override // kc1.b
    public void a(Activity activity, int i3) {
        if (this.f412004a.nFileType == 2) {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                d.e(R.string.cqv);
                return;
            }
            if (this.f412004a.getCloudType() == 1 && QQFileManagerUtilImpl.R1()) {
                FileManagerEntity fileManagerEntity = this.f412004a;
                if (fileManagerEntity.status != 2 && fileManagerEntity.fileSize > 1048576) {
                    a aVar = new a(activity, i3);
                    boolean f16 = f(activity, i3);
                    if (f16) {
                        f16 = g(activity, i3);
                    }
                    if (f16) {
                        FMDialogUtil.c(activity, activity.getString(R.string.b_v), activity.getString(R.string.b_x), aVar);
                        return;
                    }
                    return;
                }
            }
            p(activity, i3);
            return;
        }
        o(activity, i3, 10004);
    }

    @Override // kc1.b
    public void b(Activity activity, int i3, int i16) {
        o(activity, i16, i3);
    }

    @Override // kc1.b
    public boolean c(boolean z16) {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return false;
        }
        if (!QQFileManagerUtilImpl.R1()) {
            k("FlowShow", " donot ShowFlowDialog! Wi-Fi");
            return false;
        }
        long flowDialogSize = ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize();
        long flowDialogTime = ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogTime();
        k("FlowShow", "fileSize " + this.f412004a.fileSize + ",limit  " + flowDialogSize);
        FileManagerEntity fileManagerEntity = this.f412004a;
        if (fileManagerEntity.fileSize < flowDialogSize) {
            return false;
        }
        if (z16) {
            k("FlowShow", "download model so Show!");
            return true;
        }
        int i3 = fileManagerEntity.cloudType;
        if (i3 != 3 && i3 != 6) {
            k("FlowShow", "cloudeType " + this.f412004a.cloudType + " is not local File donot show!");
            return false;
        }
        long K0 = e.K0();
        k("FlowShow", "last Succ " + this.f412004a.lastSuccessTime + " now " + e.K0() + " = " + (K0 - this.f412004a.lastSuccessTime) + " limit[" + flowDialogTime + "]");
        if (K0 - this.f412004a.lastSuccessTime < flowDialogTime) {
            return false;
        }
        k("FlowShow", "Must show!");
        return true;
    }

    @Override // kc1.b
    public void d(boolean z16, Context context, FMDialogUtil.c cVar) {
        int i3;
        if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext())) {
            d.e(R.string.bqf);
            return;
        }
        if (c(!z16)) {
            Activity activity = (Activity) context;
            boolean i16 = i(z16, activity, cVar);
            if (i16) {
                i16 = j(z16, activity, cVar);
            }
            if (i16) {
                if (z16) {
                    i3 = R.string.f170958ba0;
                } else {
                    i3 = R.string.b_x;
                }
                FMDialogUtil.a(context, R.string.b_v, i3, cVar);
                return;
            }
            return;
        }
        cVar.b();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f412005a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f412006b;

        a(Activity activity, int i3) {
            this.f412005a = activity;
            this.f412006b = i3;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            c.this.p(this.f412005a, this.f412006b);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
