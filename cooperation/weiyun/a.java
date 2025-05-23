package cooperation.weiyun;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    private static boolean c(int i3) {
        if (i3 != 0) {
            if (i3 != 16) {
                return true;
            }
            d.e(R.string.bet);
            return false;
        }
        d.e(R.string.b_r);
        return false;
    }

    public static boolean d(QQAppInterface qQAppInterface, List<AIOMsgItem> list, ArrayList<AIOMsgItem> arrayList, ArrayList<AIOMsgItem> arrayList2) {
        FileManagerEntity E;
        if (qQAppInterface == null || list == null || list.isEmpty()) {
            return false;
        }
        MsgRecord msgRecord = list.get(0).getMsgRecord();
        String valueOf = String.valueOf(msgRecord.getPeerUin());
        int chatType = msgRecord.getChatType();
        ArrayList arrayList3 = new ArrayList();
        Iterator<AIOMsgItem> it = list.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            MsgElement firstTypeElement = it.next().getFirstTypeElement(3);
            if (firstTypeElement != null && (E = qQAppInterface.getFileManagerDataCenter().E(firstTypeElement.getElementId(), valueOf, chatType)) != null && c(E.getCloudType())) {
                arrayList3.add(E);
                j3 += E.fileSize;
            }
        }
        if (arrayList3.isEmpty()) {
            d.e(R.string.b_r);
            return false;
        }
        if (!AppNetConnInfo.isWifiConn() && j3 > ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            FMDialogUtil.a(BaseActivity.sTopActivity, R.string.b_v, R.string.f170958ba0, new b(qQAppInterface, valueOf, arrayList3, arrayList, arrayList2));
            return true;
        }
        return f(qQAppInterface, valueOf, arrayList3, arrayList, arrayList2);
    }

    public static boolean e(QQAppInterface qQAppInterface, AIOMsgItem aIOMsgItem, String str, int i3) {
        MsgElement firstTypeElement;
        FileManagerEntity E;
        if (aIOMsgItem != null && qQAppInterface != null && (firstTypeElement = aIOMsgItem.getFirstTypeElement(3)) != null && (E = qQAppInterface.getFileManagerDataCenter().E(firstTypeElement.getElementId(), str, i3)) != null && c(E.cloudType)) {
            String valueOf = String.valueOf(aIOMsgItem.getMsgRecord().getSenderUin());
            if (kc1.a.c(E).c(false)) {
                FMDialogUtil.a(BaseActivity.sTopActivity, R.string.b_v, R.string.b_y, new C10132a(qQAppInterface, E, valueOf));
            } else {
                QQToastUtil.showQQToast(0, R.string.f170978be3);
                g(qQAppInterface, E, valueOf);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(QQAppInterface qQAppInterface, String str, List<FileManagerEntity> list, ArrayList<AIOMsgItem> arrayList, ArrayList<AIOMsgItem> arrayList2) {
        if (qQAppInterface == null || list == null) {
            return false;
        }
        Iterator<FileManagerEntity> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            z16 |= g(qQAppInterface, it.next(), str);
        }
        boolean k3 = WeiyunAIOUtils.k(qQAppInterface, arrayList, arrayList2);
        if (!z16 && !k3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, String str) {
        if (qQAppInterface == null || fileManagerEntity == null) {
            return false;
        }
        int cloudType = fileManagerEntity.getCloudType();
        if (cloudType != 1) {
            if (cloudType != 3 && cloudType != 5) {
                return false;
            }
            qQAppInterface.getFileManagerEngine().F0(fileManagerEntity.getFilePath(), null, qQAppInterface.getAccount(), "", 0, false);
        } else if (fileManagerEntity.ntChatType == 8 && TextUtils.isEmpty(fileManagerEntity.Uuid) && new File(fileManagerEntity.getFilePath()).exists()) {
            qQAppInterface.getFileManagerEngine().F0(fileManagerEntity.getFilePath(), null, qQAppInterface.getAccount(), "", 0, false);
        } else {
            qQAppInterface.getFileManagerEngine().v0(fileManagerEntity, str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cooperation.weiyun.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class C10132a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f391503a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f391504b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f391505c;

        C10132a(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity, String str) {
            this.f391503a = qQAppInterface;
            this.f391504b = fileManagerEntity;
            this.f391505c = str;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            QQToastUtil.showQQToast(0, R.string.f170978be3);
            a.g(this.f391503a, this.f391504b, this.f391505c);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f391506a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f391507b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f391508c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f391509d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f391510e;

        b(QQAppInterface qQAppInterface, String str, List list, ArrayList arrayList, ArrayList arrayList2) {
            this.f391506a = qQAppInterface;
            this.f391507b = str;
            this.f391508c = list;
            this.f391509d = arrayList;
            this.f391510e = arrayList2;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            if (!a.f(this.f391506a, this.f391507b, this.f391508c, this.f391509d, this.f391510e)) {
                QQToastUtil.showQQToast(0, R.string.bfg);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
