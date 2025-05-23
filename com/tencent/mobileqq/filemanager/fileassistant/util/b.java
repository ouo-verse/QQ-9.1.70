package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private List<FileManagerEntity> f208050a = null;

    /* renamed from: b, reason: collision with root package name */
    private FileManagerEntity f208051b = null;

    /* renamed from: c, reason: collision with root package name */
    private List<ChatMessage> f208052c = null;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f208053d = null;

    /* renamed from: e, reason: collision with root package name */
    private Set<FileInfo> f208054e = null;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<ForwardFileInfo> f208055f = null;

    /* renamed from: g, reason: collision with root package name */
    private ForwardFileOption f208056g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f208057d;

        a(c cVar) {
            this.f208057d = cVar;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            this.f208057d.onDismiss();
            if (QLog.isColorLevel()) {
                QLog.d("DatalineDeviceChooseModel<FileAssistant>.ACT", 2, "dismiss");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileassistant.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7558b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f208059d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f208060e;

        C7558b(c cVar, ActionSheet actionSheet) {
            this.f208059d = cVar;
            this.f208060e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    this.f208059d.onDismiss();
                } else {
                    h.z(1);
                    this.f208059d.a();
                    if (QLog.isColorLevel()) {
                        QLog.d("DatalineDeviceChooseModel<FileAssistant>.ACT", 2, "onClickSend2Pad");
                    }
                }
            } else {
                h.z(0);
                this.f208059d.a();
                if (QLog.isColorLevel()) {
                    QLog.d("DatalineDeviceChooseModel<FileAssistant>.ACT", 2, "onClickSend2Pc");
                }
            }
            this.f208060e.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a();

        void b();

        void onDismiss();
    }

    b() {
    }

    private void c(Context context, QQAppInterface qQAppInterface, c cVar) {
        boolean z16;
        List<FileManagerEntity> list = this.f208050a;
        if (list != null) {
            Iterator<FileManagerEntity> it = list.iterator();
            while (it.hasNext()) {
                if (h(qQAppInterface, it.next())) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        FileManagerEntity fileManagerEntity = this.f208051b;
        if (fileManagerEntity != null && !z16 && h(qQAppInterface, fileManagerEntity)) {
            z16 = true;
        }
        if (((IQFileConfigManager) qQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).isWlanOnly()) {
            z16 = true;
        }
        boolean d16 = d(qQAppInterface, e(qQAppInterface, f(qQAppInterface, g(qQAppInterface, z16))));
        if (this.f208056g != null && !d16) {
            if (this.f208056g.u() > h.i(qQAppInterface)) {
                d16 = true;
            }
        }
        if (!d16) {
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkFiles isNeedCheckIpadStatus is false ");
            cVar.a();
        } else if (!h.n(qQAppInterface)) {
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkFiles isNeedShowPadOpts is false ");
            cVar.a();
        } else {
            n(context, cVar);
        }
    }

    public static b i(FileManagerEntity fileManagerEntity) {
        b bVar = new b();
        bVar.f208051b = fileManagerEntity;
        return bVar;
    }

    public static b j(ArrayList<ForwardFileInfo> arrayList) {
        b bVar = new b();
        bVar.f208055f = arrayList;
        return bVar;
    }

    public static b k(List<ChatMessage> list) {
        b bVar = new b();
        bVar.f208052c = list;
        return bVar;
    }

    public static b l(List<FileManagerEntity> list, Set<FileInfo> set) {
        b bVar = new b();
        bVar.f208050a = list;
        bVar.f208054e = set;
        return bVar;
    }

    public static b m(ForwardFileOption forwardFileOption) {
        b bVar = new b();
        bVar.f208056g = forwardFileOption;
        return bVar;
    }

    private void n(Context context, c cVar) {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(context, null);
        actionSheet.setMainTitle(q.g(h.i((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime())).replace(".00", "") + context.getResources().getString(R.string.f187483u4));
        actionSheet.addButton(R.string.f187473u3, 5);
        actionSheet.addButton(R.string.f187463u2, 5);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnDismissListener(new a(cVar));
        actionSheet.setOnButtonClickListener(new C7558b(cVar, actionSheet));
        actionSheet.show();
    }

    public void a(Context context, QQAppInterface qQAppInterface, c cVar) {
        if (!h.p(qQAppInterface)) {
            cVar.b();
        } else {
            c(context, qQAppInterface, cVar);
        }
    }

    public void b(Context context, String str, c cVar) {
        if (!h.k(str)) {
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkFileAssistantAndChooseDevice switch is not open!");
            cVar.b();
        } else {
            c(context, (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), cVar);
        }
    }

    protected boolean d(QQAppInterface qQAppInterface, boolean z16) {
        ArrayList<ForwardFileInfo> arrayList = this.f208055f;
        if (arrayList != null && arrayList.size() != 0 && !z16) {
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo forwardFileInfos size : " + this.f208055f.size());
            Iterator<ForwardFileInfo> it = this.f208055f.iterator();
            while (it.hasNext()) {
                ForwardFileInfo next = it.next();
                int type = next.getType();
                long i3 = h.i(qQAppInterface);
                if (type != 10000 && type != 10001 && type != 10006) {
                    QLog.w("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo unknow type:" + type);
                } else {
                    boolean f16 = q.f(next.l());
                    long g16 = next.g();
                    if (f16 && next.g() > i3) {
                        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo size[" + g16 + " > onlyOfflineLimitSize[" + i3 + "] ");
                        z16 = true;
                    }
                }
            }
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo return : " + z16);
            return z16;
        }
        QLog.w("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkForwardFileInfo forwardFileInfos is null or isNeedCheckIpadStatus : " + z16);
        return z16;
    }

    protected boolean e(QQAppInterface qQAppInterface, boolean z16) {
        if (this.f208054e != null && !z16) {
            long i3 = h.i(qQAppInterface);
            Iterator<FileInfo> it = this.f208054e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FileInfo next = it.next();
                long l3 = next.l();
                if (next.l() > i3) {
                    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalFileInfos troopFileStatusInfo size[" + l3 + " > onlyOfflineLimitSize[" + i3 + "] ");
                    z16 = true;
                    break;
                }
            }
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalFileInfos return : " + z16);
            return z16;
        }
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalFileInfos lstLocals is null or isNeedCheckIpadStatus : " + z16);
        return z16;
    }

    protected boolean f(QQAppInterface qQAppInterface, boolean z16) {
        if (this.f208053d != null && !z16) {
            long i3 = h.i(qQAppInterface);
            Iterator<String> it = this.f208053d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!q.f(next)) {
                    QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalPaths file NotExisited:" + next);
                } else {
                    long fileSizes = FileManagerUtil.getFileSizes(next);
                    if (fileSizes > i3) {
                        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalPaths troopFileStatusInfo size[" + fileSizes + " > onlyOfflineLimitSize[" + i3 + "] ");
                        z16 = true;
                        break;
                    }
                }
            }
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalPaths return:" + z16);
            return z16;
        }
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkLocalPaths lstPaths null ro isNeedCheckIpadStatus:" + z16);
        return z16;
    }

    protected boolean g(QQAppInterface qQAppInterface, boolean z16) {
        if (this.f208052c != null && !z16) {
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList: lstMsg size : " + this.f208052c.size());
            long i3 = h.i(qQAppInterface);
            for (ChatMessage chatMessage : this.f208052c) {
                if (chatMessage instanceof MessageForFile) {
                    if (h(qQAppInterface, FileManagerUtil.getFileManagerEntityByMsgFile(qQAppInterface, (MessageForFile) chatMessage))) {
                        z16 = true;
                        break;
                    }
                } else if (chatMessage instanceof MessageForTroopFile) {
                    t m3 = TroopFileUtils.m(qQAppInterface, (MessageForTroopFile) chatMessage);
                    if (m3 == null) {
                        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList: troopFileStatusInfo null ");
                    } else if (!q.f(m3.f294978l)) {
                        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList troopFileStatusInfo not localFile ");
                    } else if (m3.f294976j > i3) {
                        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList troopFileStatusInfo size[" + m3.f294976j + " > onlyOfflineLimitSize[" + i3 + "] ");
                        z16 = true;
                        break;
                    }
                } else {
                    continue;
                }
            }
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList return:" + z16);
            return z16;
        }
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkMsgList: lstMsg is null or isNeedCheckIpadStatus : " + z16);
        return z16;
    }

    protected boolean h(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        if (!q.f(fileManagerEntity.getFilePath())) {
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkEntity:" + fileManagerEntity.nSessionId + ", not LocalFile!");
            return false;
        }
        long i3 = h.i(qQAppInterface);
        if (fileManagerEntity.fileSize < i3) {
            QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkEntity:" + fileManagerEntity.nSessionId + ", fileSize[" + fileManagerEntity.fileSize + "] < limitSize[" + i3 + "]");
            return false;
        }
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "checkEntity:" + fileManagerEntity.nSessionId + ", is LocalFile,and size is Over:" + fileManagerEntity.fileSize);
        return true;
    }

    public void o() {
        this.f208050a = null;
        this.f208051b = null;
        this.f208052c = null;
        this.f208053d = null;
        this.f208054e = null;
        this.f208055f = null;
        this.f208056g = null;
        QLog.i("DatalineDeviceChooseModel<FileAssistant>.ACT", 1, "setHideActionSheet clear all parames");
    }
}
