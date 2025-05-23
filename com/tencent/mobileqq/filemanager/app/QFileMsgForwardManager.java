package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.b;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper;
import com.tencent.mobileqq.filemanager.uftwrapper.b;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsCommonCode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileMsgForwardManager {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f207074a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f207075b = new Handler(ThreadManagerV2.getSubThreadLooper());

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, l> f207076c = new HashMap<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager$4, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f207080d;
        final /* synthetic */ QFileMsgForwardManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            l lVar;
            if (this.this$0.f207076c.containsKey(Long.valueOf(this.f207080d))) {
                lVar = (l) this.this$0.f207076c.get(Long.valueOf(this.f207080d));
            } else {
                lVar = null;
            }
            if (lVar != null) {
                lVar.d();
                lVar.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends ef0.n {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f207081d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f207082e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f207083f;

        a(String str, k kVar, long j3) {
            this.f207081d = str;
            this.f207082e = kVar;
            this.f207083f = j3;
        }

        @Override // ef0.n
        public void c(boolean z16, int i3, String str, int i16, int i17, Bundle bundle) {
            if (!z16) {
                QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult return failed fileid " + this.f207081d);
                this.f207082e.a(QFileMsgForwardManager.l(this.f207083f, false), true);
                return;
            }
            bundle.putString("_m_ForwardBusType", String.valueOf(i16));
            bundle.putString("_m_ForwardDeadTime", String.valueOf(i17));
            if (i3 == 0) {
                QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult success fileid " + this.f207081d);
                this.f207082e.b(this.f207081d, bundle);
                return;
            }
            QLog.d("FileMultiMsgManager<FileAssistant>", 1, "onReqFeedsResult return[" + i3 + "] fileid " + this.f207081d);
            this.f207082e.a(QFileMsgForwardManager.l(this.f207083f, false), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e extends m {

        /* renamed from: b, reason: collision with root package name */
        protected String f207121b;

        /* renamed from: c, reason: collision with root package name */
        protected String f207122c;

        /* renamed from: d, reason: collision with root package name */
        protected long f207123d;

        /* renamed from: e, reason: collision with root package name */
        private long f207124e;

        /* renamed from: f, reason: collision with root package name */
        private Bundle f207125f;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements QFileC2CTransferWrapper.g {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f207127a;

            a(k kVar) {
                this.f207127a = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileC2CTransferWrapper.g
            public void a(int i3, boolean z16, Bundle bundle) {
                if (i3 != 0) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "BuddyUploadTaskExcuter faild\uff0cretCode[" + i3 + "]" + e.this.f207121b);
                    this.f207127a.a(QFileMsgForwardManager.l(e.this.f207123d, false), z16);
                    return;
                }
                QLog.i("FileMultiMsgManager<FileAssistant>", 1, e.this.f207121b + " sendLocalFileToBuddyBySHA uploadFile success");
                String string = bundle.getString("strFileId");
                String string2 = bundle.getString("str10MMd5");
                String string3 = bundle.getString("strSha");
                e.this.f207125f.putString("_m_ForwardSize", e.this.f207123d + "");
                e.this.f207125f.putString("_m_ForwardSha", string3);
                e.this.f207125f.putString("_m_ForwardMd5", string2);
                e.this.f207125f.putString("_m_ForwardDeadTime", "0");
                e.this.f207125f.putString("_m_ForwardUuid", string);
                this.f207127a.b(string, e.this.f207125f);
            }
        }

        public e(MessageRecord messageRecord) {
            super();
            this.f207121b = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            this.f207123d = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
            this.f207122c = messageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            Bundle bundle = new Bundle();
            this.f207125f = bundle;
            bundle.putString("_m_ForwardImgWidth", extInfoFromExtStr);
            this.f207125f.putString("_m_ForwardImgHeight", extInfoFromExtStr2);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            this.f207125f.putString("_m_ForwardFileType", "1");
            this.f207125f.putString("_m_ForwardReceiverUin", str);
            this.f207125f.putString("_m_ForwardFileName", this.f207121b);
            this.f207123d = FileManagerUtil.getFileSizes(this.f207122c);
            QFileC2CTransferWrapper.d dVar = new QFileC2CTransferWrapper.d();
            dVar.f209051a = this.f207122c;
            dVar.f209053c = str;
            dVar.f209052b = i3;
            this.f207124e = QFileMsgForwardManager.this.f207074a.getFileManagerEngine().T().m(dVar, new a(kVar));
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
            QFileMsgForwardManager.this.f207074a.getFileManagerEngine().T().d(this.f207124e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i extends m {

        /* renamed from: b, reason: collision with root package name */
        protected String f207165b;

        /* renamed from: c, reason: collision with root package name */
        protected String f207166c;

        /* renamed from: d, reason: collision with root package name */
        protected long f207167d;

        /* renamed from: e, reason: collision with root package name */
        private Bundle f207168e;

        /* renamed from: f, reason: collision with root package name */
        private long f207169f;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements QFileDiscTransferWrapper.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f207171a;

            a(k kVar) {
                this.f207171a = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.f
            public void a(int i3, boolean z16, Bundle bundle) {
                if (i3 != 0) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "failed upload disk file, errCode=" + i3 + ", canResume=" + z16 + ", file=" + i.this.f207165b);
                    this.f207171a.a(QFileMsgForwardManager.l(i.this.f207167d, false), z16);
                    return;
                }
                QLog.i("FileMultiMsgManager<FileAssistant>", 1, i.this.f207165b + " start upload Discfile success");
                String string = bundle.getString("strFileId");
                String string2 = bundle.getString("str10MMd5");
                String string3 = bundle.getString("strSha");
                i.this.f207168e.putString("_m_ForwardSize", i.this.f207167d + "");
                i.this.f207168e.putString("_m_ForwardMd5", string2);
                i.this.f207168e.putString("_m_ForwardSha", string3);
                i.this.f207168e.putString("_m_ForwardDeadTime", "0");
                i.this.f207168e.putString("_m_ForwardUuid", string);
                this.f207171a.b(string, i.this.f207168e);
            }
        }

        i(MessageRecord messageRecord) {
            super();
            this.f207165b = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            this.f207167d = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
            this.f207166c = messageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            Bundle bundle = new Bundle();
            this.f207168e = bundle;
            bundle.putString("_m_ForwardImgWidth", extInfoFromExtStr);
            this.f207168e.putString("_m_ForwardImgHeight", extInfoFromExtStr2);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            this.f207168e.putString("_m_ForwardFileType", "2");
            this.f207168e.putString("_m_ForwardReceiverUin", str);
            this.f207168e.putString("_m_ForwardFileName", this.f207165b);
            this.f207167d = FileManagerUtil.getFileSizes(this.f207166c);
            this.f207169f = QFileMsgForwardManager.this.f207074a.getFileManagerEngine().U().n(this.f207166c, str, new a(kVar));
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
            QFileMsgForwardManager.this.f207074a.getFileManagerEngine().U().g(this.f207169f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j {

        /* renamed from: a, reason: collision with root package name */
        String f207173a;

        /* renamed from: b, reason: collision with root package name */
        m f207174b;

        /* renamed from: c, reason: collision with root package name */
        k f207175c;

        /* renamed from: d, reason: collision with root package name */
        MessageRecord f207176d;

        /* renamed from: e, reason: collision with root package name */
        String f207177e;

        /* renamed from: f, reason: collision with root package name */
        int f207178f;

        /* renamed from: g, reason: collision with root package name */
        int f207179g = 0;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements k {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QFileMsgForwardManager f207181a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ MessageRecord f207182b;

            a(QFileMsgForwardManager qFileMsgForwardManager, MessageRecord messageRecord) {
                this.f207181a = qFileMsgForwardManager;
                this.f207182b = messageRecord;
            }

            @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.k
            public void a(String str, boolean z16) {
                QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask fail, multiUniseq[ " + j.this.f207173a + "] fileMrUniseq[" + this.f207182b.uniseq + "] canResume[" + z16 + "] retMsg[" + str + "]");
                if (z16) {
                    j.this.f207179g = 4;
                } else {
                    this.f207182b.saveExtInfoToExtStr("_m_ForwardFaildReason", (HardCodeUtil.qqStr(R.string.qag) + this.f207182b.getExtInfoFromExtStr("_m_ForwardFileName")) + "\n" + str);
                    this.f207182b.saveExtInfoToExtStr("_m_ForwardFileStatus", "2");
                    j.this.f207179g = 3;
                }
                j jVar = j.this;
                QFileMsgForwardManager.this.w(jVar.f207173a);
            }

            @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.k
            public void b(String str, Bundle bundle) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask success, multiUniseq[ " + j.this.f207173a + "] uuid[" + str + "] fileMrUniseq[" + this.f207182b.uniseq + "]");
                }
                j jVar = j.this;
                jVar.f207179g = 2;
                QFileMsgForwardManager.this.v(this.f207182b, bundle);
                j jVar2 = j.this;
                QFileMsgForwardManager.this.w(jVar2.f207173a);
            }
        }

        j(String str, String str2, int i3, MessageRecord messageRecord) {
            this.f207173a = str;
            this.f207178f = i3;
            this.f207177e = str2;
            this.f207176d = messageRecord;
            this.f207175c = new a(QFileMsgForwardManager.this, messageRecord);
        }

        void a() {
            if (this.f207174b != null && this.f207179g == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task suc. status[" + this.f207179g + "]");
                }
                this.f207179g = 1;
                this.f207174b.a(this.f207177e, this.f207178f, this.f207175c);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("FileMultiMsgManager<FileAssistant>", 1, "task excute : run task fail. status[" + this.f207179g + "]");
            }
        }

        void b() {
            m mVar = this.f207174b;
            if (mVar != null) {
                int i3 = this.f207179g;
                if (i3 == 1 || i3 == 0) {
                    mVar.b(this.f207177e, this.f207178f);
                    this.f207179g = 4;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface k {
        void a(String str, boolean z16);

        void b(String str, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class l {

        /* renamed from: a, reason: collision with root package name */
        String f207184a;

        /* renamed from: b, reason: collision with root package name */
        tb1.b f207185b;

        /* renamed from: i, reason: collision with root package name */
        HashMap<String, ArrayList<MessageRecord>> f207192i;

        /* renamed from: c, reason: collision with root package name */
        int f207186c = 0;

        /* renamed from: e, reason: collision with root package name */
        List<j> f207188e = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        List<j> f207187d = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        List<j> f207189f = new ArrayList();

        /* renamed from: g, reason: collision with root package name */
        List<j> f207190g = new ArrayList();

        /* renamed from: h, reason: collision with root package name */
        List<j> f207191h = new ArrayList();

        l(String str, tb1.b bVar, HashMap<String, ArrayList<MessageRecord>> hashMap) {
            this.f207184a = str;
            this.f207185b = bVar;
            this.f207192i = hashMap;
        }

        void a(j jVar) {
            if (jVar != null) {
                this.f207188e.add(jVar);
            }
        }

        int b() {
            return this.f207188e.size();
        }

        void c() {
            f();
            Iterator<j> it = this.f207187d.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f207186c = 1;
        }

        void d() {
            Iterator<j> it = this.f207187d.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f207186c = 5;
        }

        void e() {
            int size = this.f207189f.size() + this.f207191h.size() + this.f207190g.size();
            Iterator<j> it = this.f207187d.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                j next = it.next();
                int i16 = next.f207179g;
                if (i16 == 2 || i16 == 3 || i16 == 4) {
                    it.remove();
                }
                int i17 = next.f207179g;
                if (i17 == 2) {
                    this.f207189f.add(next);
                } else if (i17 == 3) {
                    this.f207191h.add(next);
                } else if (i17 == 4) {
                    this.f207190g.add(next);
                }
                i3++;
            }
            f();
            if (QLog.isColorLevel()) {
                QLog.i("FileMultiMsgManager<FileAssistant>", 1, "request update, forwardSeq[ " + this.f207184a + "] removeCount[" + i3 + "] leftCount[" + (this.f207187d.size() + this.f207188e.size()) + "] finishCount[" + size + "]");
            }
            Iterator<j> it5 = this.f207187d.iterator();
            while (it5.hasNext()) {
                it5.next().a();
            }
            if (this.f207187d.size() <= 0 && this.f207188e.size() <= 0) {
                this.f207186c = 5;
                if (QLog.isDevelopLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "all task upload finish , remove multi request: forwardSeq[ " + this.f207184a + "]");
                }
                QFileMsgForwardManager.this.p(this.f207184a);
            }
        }

        void f() {
            int i3 = 10;
            if (10 > this.f207188e.size()) {
                i3 = this.f207188e.size();
            }
            ArrayList arrayList = new ArrayList(i3);
            for (int i16 = 0; i16 < i3; i16++) {
                j jVar = this.f207188e.get(i16);
                this.f207187d.add(jVar);
                arrayList.add(jVar);
            }
            this.f207188e.removeAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public abstract class m {
        m() {
        }

        abstract void a(String str, int i3, k kVar);

        abstract void b(String str, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n extends m {

        /* renamed from: b, reason: collision with root package name */
        private String f207195b;

        /* renamed from: c, reason: collision with root package name */
        private String f207196c;

        /* renamed from: d, reason: collision with root package name */
        private String f207197d;

        /* renamed from: e, reason: collision with root package name */
        private String f207198e;

        /* renamed from: f, reason: collision with root package name */
        private long f207199f;

        /* renamed from: g, reason: collision with root package name */
        private String f207200g;

        /* renamed from: h, reason: collision with root package name */
        private String f207201h;

        /* renamed from: i, reason: collision with root package name */
        private String f207202i;

        /* renamed from: j, reason: collision with root package name */
        private String f207203j;

        /* renamed from: k, reason: collision with root package name */
        private String f207204k;

        /* renamed from: l, reason: collision with root package name */
        private String f207205l;

        /* renamed from: m, reason: collision with root package name */
        private String f207206m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f207207n;

        /* renamed from: o, reason: collision with root package name */
        private int f207208o;

        /* renamed from: p, reason: collision with root package name */
        private Bundle f207209p;

        /* renamed from: q, reason: collision with root package name */
        private long f207210q;

        /* renamed from: r, reason: collision with root package name */
        private k f207211r;

        /* renamed from: s, reason: collision with root package name */
        private String f207212s;

        /* renamed from: t, reason: collision with root package name */
        private int f207213t;

        /* renamed from: u, reason: collision with root package name */
        private final ef0.l f207214u;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends ef0.l {
            a() {
            }

            /* JADX WARN: Removed duplicated region for block: B:37:0x0250  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x027f  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x01ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // ef0.l
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void c(boolean z16, int i3, int i16, String str, String str2, String str3, Bundle bundle) {
                int parseInt;
                int parseInt2;
                int parseInt3;
                if (n.this.f207207n) {
                    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult but has been stopped filename " + n.this.f207197d);
                    return;
                }
                if (i3 == -103) {
                    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + i3 + "] clientwording[" + str3 + "] filename " + n.this.f207197d);
                    n.this.f207211r.a(QFileMsgForwardManager.l(n.this.f207199f, true), false);
                    return;
                }
                if (i3 != -134 && !QFileMsgForwardManager.t()) {
                    if (i3 != 0 && i3 != -1) {
                        QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + i3 + "] clientwording[" + str3 + "] filename " + n.this.f207197d);
                        n.this.f207211r.a(QFileMsgForwardManager.l(n.this.f207199f, false), false);
                        return;
                    }
                    if (!z16) {
                        QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult return failed filename " + n.this.f207197d);
                        n.this.f207211r.a(QFileMsgForwardManager.l(n.this.f207199f, false), true);
                        return;
                    }
                    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult strNewPath[" + str + "] busId[" + i16 + "] mnDstBusId[" + n.this.f207208o + "] filename " + n.this.f207197d);
                    n.this.f207212s = str;
                    n.this.f207209p.putString("_m_ForwardUuid", n.this.f207212s);
                    if (n.this.f207208o == 102) {
                        n.this.f207213t = i16;
                        n.this.f207209p.putString("_m_ForwardBusType", String.valueOf(n.this.f207213t));
                        if (!n.this.f207201h.isEmpty()) {
                            try {
                                parseInt = Integer.parseInt(n.this.f207201h);
                            } catch (NumberFormatException unused) {
                                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageWidth[" + n.this.f207201h + "] is error filename " + n.this.f207197d);
                            }
                            if (!n.this.f207202i.isEmpty()) {
                                try {
                                    parseInt2 = Integer.parseInt(n.this.f207202i);
                                } catch (NumberFormatException unused2) {
                                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrImageHeight[" + n.this.f207202i + "] is error filename " + n.this.f207197d);
                                }
                                if (!n.this.f207203j.isEmpty()) {
                                    try {
                                        parseInt3 = Integer.parseInt(n.this.f207203j);
                                    } catch (NumberFormatException unused3) {
                                        QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mstrVideoDuration[" + n.this.f207203j + "] is error filename " + n.this.f207197d);
                                    }
                                    if (QFileMsgForwardManager.this.f207074a != null) {
                                        QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult mApp is null filename " + n.this.f207197d);
                                        n.this.f207211r.a(QFileMsgForwardManager.l(n.this.f207199f, false), false);
                                        return;
                                    }
                                    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult will call sendFeeds filename " + n.this.f207197d);
                                    QFileMsgForwardManager.r(QFileMsgForwardManager.this.f207074a, n.this.f207210q, n.this.f207213t, n.this.f207212s, n.this.f207199f, 0, parseInt, parseInt2, parseInt3, false, n.this.f207209p, n.this.f207211r);
                                    return;
                                }
                                parseInt3 = 0;
                                if (QFileMsgForwardManager.this.f207074a != null) {
                                }
                            }
                            parseInt2 = 0;
                            if (!n.this.f207203j.isEmpty()) {
                            }
                            parseInt3 = 0;
                            if (QFileMsgForwardManager.this.f207074a != null) {
                            }
                        }
                        parseInt = 0;
                        if (!n.this.f207202i.isEmpty()) {
                        }
                        parseInt2 = 0;
                        if (!n.this.f207203j.isEmpty()) {
                        }
                        parseInt3 = 0;
                        if (QFileMsgForwardManager.this.f207074a != null) {
                        }
                    } else {
                        n.this.f207211r.b(n.this.f207212s, n.this.f207209p);
                    }
                } else {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter onCopyToResult retCode[" + i3 + "] clientwording[" + str3 + "] filename " + n.this.f207197d);
                    n.this.f207211r.a(QFileMsgForwardManager.l(n.this.f207199f, false), true);
                }
            }
        }

        n(MessageRecord messageRecord, int i3) {
            super();
            this.f207207n = false;
            this.f207214u = new a();
            this.f207195b = messageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            this.f207196c = messageRecord.getExtInfoFromExtStr("_m_ForwardSha");
            this.f207197d = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardSize");
            this.f207198e = extInfoFromExtStr;
            this.f207199f = Long.parseLong(extInfoFromExtStr);
            this.f207200g = messageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
            this.f207201h = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            this.f207202i = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            this.f207203j = messageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
            this.f207204k = messageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
            this.f207205l = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
            this.f207206m = messageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
            QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter begin filename " + this.f207197d);
            this.f207208o = i3;
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            if (kVar == null) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter run but callback is null filename " + this.f207197d);
                return;
            }
            QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter run filename " + this.f207197d);
            if ("1".equals(this.f207206m)) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Troop2XXXTaskExcuter:" + this.f207197d + " faild, file is upload paused");
                }
                kVar.a(QFileMsgForwardManager.l(this.f207199f, false), false);
                return;
            }
            this.f207211r = kVar;
            this.f207210q = Long.parseLong(str);
            Bundle bundle = new Bundle();
            this.f207209p = bundle;
            bundle.putString("_m_ForwardReceiverUin", String.valueOf(this.f207210q));
            String str2 = this.f207196c;
            if (str2 != null && !str2.isEmpty()) {
                this.f207209p.putString("_m_ForwardSha", this.f207196c);
            }
            this.f207209p.putString("_m_ForwardFileName", this.f207197d);
            this.f207209p.putString("_m_ForwardSize", this.f207198e);
            if (FileManagerUtil.fileExist(this.f207200g)) {
                this.f207209p.putString("_m_ForwardFilePath", this.f207200g);
            }
            if (!this.f207201h.isEmpty()) {
                this.f207209p.putString("_m_ForwardImgWidth", this.f207203j);
            }
            if (!this.f207202i.isEmpty()) {
                this.f207209p.putString("_m_ForwardImgHeight", this.f207203j);
            }
            if (!this.f207203j.isEmpty()) {
                this.f207209p.putString("_m_ForwardDuration", this.f207203j);
            }
            if (i3 == 0) {
                this.f207209p.putString("_m_ForwardFileType", String.valueOf(1));
            } else if (i3 == 3000) {
                this.f207209p.putString("_m_ForwardFileType", String.valueOf(2));
            } else if (i3 == 1) {
                this.f207209p.putString("_m_ForwardFileType", String.valueOf(3));
            }
            try {
                long parseLong = Long.parseLong(this.f207195b);
                if (this.f207205l.isEmpty()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter run but mstrUrl is empty " + this.f207197d);
                    this.f207211r.a(QFileMsgForwardManager.l(this.f207199f, true), false);
                }
                try {
                    int parseInt = Integer.parseInt(this.f207204k);
                    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter will call reqCopyto filename[" + this.f207197d + "], fileuuid[" + this.f207205l + "]");
                    com.tencent.biz.troop.file.a.o(QFileMsgForwardManager.this.f207074a, parseLong, parseInt, this.f207205l, this.f207210q, this.f207208o, null, this.f207214u);
                } catch (NumberFormatException unused) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter run but nSrcBusId 0 is error filename " + this.f207197d);
                    this.f207211r.a(QFileMsgForwardManager.l(this.f207199f, false), false);
                }
            } catch (NumberFormatException unused2) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter run but TroopUin " + this.f207195b + " is error filename " + this.f207197d);
                this.f207211r.a(QFileMsgForwardManager.l(this.f207199f, false), false);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
            QLog.d("FileMultiMsgManager<FileAssistant>", 1, "Troop2XXXTaskExcuter stopped filename " + this.f207197d);
            this.f207207n = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class o extends m {

        /* renamed from: b, reason: collision with root package name */
        private String f207217b;

        /* renamed from: c, reason: collision with root package name */
        private String f207218c;

        /* renamed from: d, reason: collision with root package name */
        private long f207219d;

        /* renamed from: e, reason: collision with root package name */
        private Bundle f207220e;

        /* renamed from: f, reason: collision with root package name */
        private long f207221f;

        /* renamed from: g, reason: collision with root package name */
        private k f207222g;

        /* renamed from: h, reason: collision with root package name */
        private UUID f207223h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f207224i;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements b.c {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.uftwrapper.b.c
            public void a(int i3, boolean z16, Bundle bundle) {
                if (i3 != 0) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "failed to upload troop file, canResume[" + z16 + "] errCode[" + i3 + "] WorkerId[" + o.this.f207223h + "] filename " + o.this.f207217b);
                    o.this.f207222g.a(QFileMsgForwardManager.l(o.this.f207219d, false), z16);
                    return;
                }
                o.this.f207219d = bundle.getLong("fileSize");
                String string = bundle.getString("strFileId");
                String string2 = bundle.getString("strMd5");
                String string3 = bundle.getString("strSha");
                int i16 = bundle.getInt("width");
                int i17 = bundle.getInt("height");
                int i18 = bundle.getInt("duration");
                int i19 = bundle.getInt("busiId");
                o.this.f207220e.putString("_m_ForwardMd5", string2);
                o.this.f207220e.putString("_m_ForwardSha", string3);
                o.this.f207220e.putString("_m_ForwardBusType", String.valueOf(i19));
                o.this.f207220e.putString("_m_ForwardUuid", string);
                o.this.f207220e.putString("_m_ForwardSize", String.valueOf(o.this.f207219d));
                if (i16 != 0) {
                    o.this.f207220e.putString("_m_ForwardImgWidth", String.valueOf(i16));
                }
                if (i17 != 0) {
                    o.this.f207220e.putString("_m_ForwardImgHeight", String.valueOf(i17));
                }
                if (i18 != 0) {
                    o.this.f207220e.putString("_m_ForwardDuration", String.valueOf(i18));
                }
                o.this.f207220e.putString("_m_ForwardFileType", String.valueOf(3));
                QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter onWorkDone woll call sendFeeds WorkerId[" + o.this.f207223h + "] filename " + o.this.f207217b);
                QFileMsgForwardManager.r(QFileMsgForwardManager.this.f207074a, o.this.f207221f, i19, string, o.this.f207219d, 0, i16, i17, i18, false, o.this.f207220e, o.this.f207222g);
            }
        }

        o(String str, String str2) {
            super();
            this.f207224i = false;
            this.f207217b = str;
            this.f207218c = str2;
            Bundle bundle = new Bundle();
            this.f207220e = bundle;
            bundle.putString("_m_ForwardFileName", this.f207217b);
            this.f207220e.putString("_m_ForwardFilePath", this.f207218c);
            QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter begin filename " + this.f207217b);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            if (kVar == null) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run but callback is null filename " + this.f207217b);
                return;
            }
            this.f207222g = kVar;
            long parseLong = Long.parseLong(str);
            this.f207221f = parseLong;
            this.f207220e.putString("_m_ForwardReceiverUin", String.valueOf(parseLong));
            this.f207223h = QFileMsgForwardManager.this.f207074a.getFileManagerEngine().V().g(this.f207221f, this.f207218c, new a());
            QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run WorkerId[" + this.f207223h + "] filename " + this.f207217b);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
            QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter stopped WorkerId[" + this.f207223h + "] filename " + this.f207217b);
            this.f207224i = true;
            QFileMsgForwardManager.this.f207074a.getFileManagerEngine().V().c(this.f207223h);
        }
    }

    public QFileMsgForwardManager(QQAppInterface qQAppInterface) {
        this.f207074a = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j k(String str, int i3, String str2, MessageRecord messageRecord) {
        m mVar = null;
        if (TextUtils.isEmpty(str2)) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "createUploadTask: forwardRequestSeq is null");
            return null;
        }
        if (messageRecord == null) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "createUploadTask: file message record is null");
            return null;
        }
        j jVar = new j(str2, str, i3, messageRecord);
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
        if (!o(extInfoFromExtStr) && !n(messageRecord)) {
            try {
                int parseInt = Integer.parseInt(messageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
                if (parseInt != 1) {
                    if (parseInt != 2) {
                        int i16 = 3;
                        if (parseInt == 3) {
                            if (i3 != 0) {
                                if (i3 == 3000) {
                                    i16 = 106;
                                } else {
                                    if (i3 != 1) {
                                        return null;
                                    }
                                    i16 = 102;
                                }
                            }
                            mVar = new n(messageRecord, i16);
                        }
                    } else if (i3 == 0) {
                        mVar = new f(messageRecord);
                    } else if (i3 == 3000) {
                        mVar = new g(messageRecord);
                    } else if (i3 == 1) {
                        mVar = new h(messageRecord);
                    }
                } else if (i3 == 0) {
                    mVar = new b(messageRecord);
                } else if (i3 == 3000) {
                    mVar = new c(messageRecord);
                } else if (i3 == 1) {
                    mVar = new d(messageRecord);
                }
            } catch (NumberFormatException e16) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, e16.toString());
                return null;
            }
        } else if (i3 == 0) {
            mVar = new e(messageRecord);
        } else if (i3 == 3000) {
            mVar = new i(messageRecord);
        } else if (i3 == 1) {
            mVar = new o(messageRecord.getExtInfoFromExtStr("_m_ForwardFileName"), extInfoFromExtStr);
        }
        jVar.f207174b = mVar;
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l(long j3, boolean z16) {
        if (z16) {
            return BaseActivity.sTopActivity.app.getApplication().getResources().getString(R.string.b86);
        }
        if (j3 > 10485760) {
            return BaseActivity.sTopActivity.app.getApplication().getResources().getString(R.string.b88);
        }
        return BaseActivity.sTopActivity.app.getApplication().getResources().getString(R.string.b8u);
    }

    static boolean m(int i3) {
        if (!((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("block_multi_forward_with_unsafe_file", true)) {
            return false;
        }
        if (i3 == -98071 || i3 == -98075 || i3 == -134) {
            return true;
        }
        return false;
    }

    private boolean n(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForDLFile) {
            return true;
        }
        return false;
    }

    private boolean o(String str) {
        boolean z16 = false;
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "filePath[" + str + "] file is not existed");
            }
            return false;
        }
        if (FileManagerUtil.getFileSizes(str) <= 10485760) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "file is isSmall:" + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final String str) {
        this.f207075b.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.2
            @Override // java.lang.Runnable
            public void run() {
                l lVar;
                if (QFileMsgForwardManager.this.f207076c.containsKey(str)) {
                    lVar = (l) QFileMsgForwardManager.this.f207076c.remove(str);
                } else {
                    lVar = null;
                }
                if (lVar == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator<String> it = lVar.f207192i.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    ArrayList<MessageRecord> arrayList3 = lVar.f207192i.get(next);
                    for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                        MessageRecord messageRecord = arrayList3.get(i3);
                        if (FileManagerUtil.isMessageRecordOfFile(messageRecord)) {
                            if (String.valueOf(2).equalsIgnoreCase(messageRecord.getExtInfoFromExtStr("_m_ForwardFileStatus"))) {
                                lVar.f207185b.g(next, arrayList3, messageRecord, i3);
                                arrayList2.add(messageRecord);
                            } else {
                                arrayList.add(messageRecord);
                            }
                        }
                    }
                }
                if (lVar.f207190g.size() > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeForwardRequest : remove upload request forwardSeq = [" + str + "] resultCode[1]");
                    }
                    lVar.f207185b.f(1, arrayList, arrayList2);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "removeForwardRequest : remove upload request forwardSeq = [" + str + "] resultCode[0]");
                }
                lVar.f207185b.f(0, arrayList, arrayList2);
            }
        });
    }

    private static void q(MessageRecord messageRecord, Bundle bundle) {
        for (String str : bundle.keySet()) {
            messageRecord.saveExtInfoToExtStr(str, bundle.getString(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(QQAppInterface qQAppInterface, long j3, int i3, String str, long j16, int i16, int i17, int i18, int i19, boolean z16, Bundle bundle, k kVar) {
        if (kVar == null) {
            QLog.e("FileMultiMsgManager<FileAssistant>", 1, "sendFeeds but callback is null fileid " + str);
            return;
        }
        QLog.d("FileMultiMsgManager<FileAssistant>", 1, "sendFeeds will call reqFeeds fileid " + str);
        com.tencent.biz.troop.file.a.r(qQAppInterface, j3, i3, str, i16, i17, i18, i19, z16, bundle, new a(str, kVar, j16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(MessageRecord messageRecord) {
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardLasSuccess");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            if (com.tencent.mobileqq.service.message.e.K0() - Long.parseLong(extInfoFromExtStr) < 86400) {
                return false;
            }
            return true;
        }
        return true;
    }

    static boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(MessageRecord messageRecord, Bundle bundle) {
        if (messageRecord == null) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "updateFileMessageRecordWithUuid: MessageRecord is null.");
            return;
        }
        messageRecord.removeExtInfoToExtStr("_m_ForwardFileIdCrc");
        q(messageRecord, bundle);
        messageRecord.saveExtInfoToExtStr("_m_ForwardFileStatus", "1");
        messageRecord.saveExtInfoToExtStr("_m_ForwardLasSuccess", String.valueOf(com.tencent.mobileqq.service.message.e.K0()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(final String str) {
        this.f207075b.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.3
            @Override // java.lang.Runnable
            public void run() {
                l lVar;
                if (QFileMsgForwardManager.this.f207076c.containsKey(str)) {
                    lVar = (l) QFileMsgForwardManager.this.f207076c.get(str);
                } else {
                    lVar = null;
                }
                if (lVar != null) {
                    lVar.e();
                }
            }
        });
    }

    public void j(final tb1.b bVar, HashMap<String, ArrayList<MessageRecord>> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            QLog.i("FileMultiMsgManager<FileAssistant>", 1, "addMultiFileUploadRequest: file message record list is null");
        }
        this.f207075b.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                HashMap<String, ArrayList<MessageRecord>> hashMap2;
                boolean z17;
                boolean z18;
                HashMap<String, ArrayList<MessageRecord>> hashMap3;
                boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(null);
                boolean z19 = true;
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "isNetworkAvailable:" + isNetworkAvailable);
                }
                String e16 = bVar.e();
                String d16 = bVar.d();
                int c16 = bVar.c();
                HashMap<String, ArrayList<MessageRecord>> b16 = bVar.b();
                if (b16 != null && !b16.isEmpty()) {
                    l lVar = new l(e16, bVar, b16);
                    Iterator<String> it = b16.keySet().iterator();
                    long j3 = 0;
                    while (it.hasNext()) {
                        Iterator<MessageRecord> it5 = b16.get(it.next()).iterator();
                        while (it5.hasNext()) {
                            MessageRecord next = it5.next();
                            if (FileManagerUtil.isMessageRecordOfFile(next)) {
                                if (QFileMsgForwardManager.this.s(next)) {
                                    j k3 = QFileMsgForwardManager.this.k(d16, c16, e16, next);
                                    if (k3 != null) {
                                        lVar.a(k3);
                                        if (!isNetworkAvailable) {
                                            z18 = isNetworkAvailable;
                                            hashMap3 = b16;
                                            k3.f207175c.a("", true);
                                        } else {
                                            z18 = isNetworkAvailable;
                                            hashMap3 = b16;
                                        }
                                        String extInfoFromExtStr = next.getExtInfoFromExtStr("_m_ForwardSize");
                                        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                                            j3 += Long.valueOf(extInfoFromExtStr).longValue();
                                        }
                                        isNetworkAvailable = z18;
                                        b16 = hashMap3;
                                        z19 = true;
                                    } else {
                                        QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : createUploadTask failed. forwardMsgSeq[" + e16 + "] toUin[" + d16 + "] toType[" + c16 + "] ");
                                        bVar.f(1, new ArrayList(), new ArrayList());
                                        return;
                                    }
                                } else {
                                    z16 = isNetworkAvailable;
                                    hashMap2 = b16;
                                    z17 = true;
                                }
                            } else {
                                z16 = isNetworkAvailable;
                                hashMap2 = b16;
                                z17 = z19;
                            }
                            z19 = z17;
                            isNetworkAvailable = z16;
                            b16 = hashMap2;
                        }
                    }
                    if (lVar.b() > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.i("FileMultiMsgManager<FileAssistant>", 2, "addMultiRequest : forwardMsgSeq[" + e16 + "] toUin[" + d16 + "] toType[" + c16 + "] uploadCount[" + lVar.b() + "]");
                        }
                        ReportController.o(QFileMsgForwardManager.this.f207074a, "dc00898", "", "", "0X8009ABE", "0X8009ABE", 0, 0, "", "", new DecimalFormat("0.00").format((j3 / 1024.0d) / 1024.0d), "");
                        QFileMsgForwardManager.this.f207076c.put(e16, lVar);
                        lVar.c();
                        return;
                    }
                    bVar.f(0, new ArrayList(), new ArrayList());
                    return;
                }
                bVar.f(0, new ArrayList(), new ArrayList());
            }
        });
    }

    public void u(MessageRecord messageRecord, MessageRecord messageRecord2) {
        String str;
        int i3;
        QFileMsgForwardManager qFileMsgForwardManager = this;
        if (QFileUtils.d(messageRecord)) {
            messageRecord2.extStr = messageRecord.extStr;
            try {
                i3 = Integer.parseInt(messageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
            } catch (NumberFormatException e16) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, e16.toString());
                i3 = -1;
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", TroopFileUtils.m(qFileMsgForwardManager.f207074a, (MessageForTroopFile) FileManagerUtil.changeRealChatMessage((ChatMessage) messageRecord)).f294978l);
                }
            } else {
                FileManagerEntity E = qFileMsgForwardManager.f207074a.getFileManagerDataCenter().E(messageRecord.uniseq, messageRecord.frienduin, messageRecord.istroop);
                if (E != null) {
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", E.getFilePath());
                }
            }
        } else if (messageRecord instanceof MessageForFile) {
            FileManagerEntity E2 = qFileMsgForwardManager.f207074a.getFileManagerDataCenter().E(messageRecord.uniseq, messageRecord.frienduin, messageRecord.istroop);
            if (E2 != null) {
                messageRecord2.saveExtInfoToExtStr("_m_ForwardFileName", E2.fileName);
                messageRecord2.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(E2.fileSize));
                messageRecord2.saveExtInfoToExtStr("_m_ForwardUuid", E2.Uuid);
                messageRecord2.saveExtInfoToExtStr("_m_ForwardFileIdCrc", E2.fileIdCrc);
                messageRecord2.saveExtInfoToExtStr("_m_ForwardMd5", E2.strFileMd5);
                messageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", E2.getFilePath());
                messageRecord2.saveExtInfoToExtStr("_f_thumb_path_750_", E2.strLargeThumPath);
                messageRecord2.saveExtInfoToExtStr("_f_thumb_path_384_", E2.strMiddleThumPath);
                messageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(E2.imgWidth));
                messageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(E2.imgHeight));
                int i16 = E2.peerType;
                if (i16 != 0) {
                    str = "1";
                    if (i16 == 3000) {
                        messageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", E2.peerUin);
                        messageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "2");
                    } else if (i16 == 1) {
                        messageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "3");
                    }
                } else {
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", E2.peerUin);
                    str = "1";
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", str);
                }
                if (E2.status == 3) {
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardStatusPaused", str);
                }
            } else {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "cann't find Entity by msg:" + messageRecord.uniseq);
            }
            qFileMsgForwardManager = this;
        } else if (messageRecord instanceof MessageForTroopFile) {
            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) messageRecord;
            messageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "3");
            messageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", messageForTroopFile.frienduin);
            messageRecord2.saveExtInfoToExtStr("_m_ForwardSha", messageForTroopFile.sha1);
            messageRecord2.saveExtInfoToExtStr("_m_ForwardMd5", messageForTroopFile.md5);
            messageRecord2.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(messageForTroopFile.fileSize));
            messageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(messageForTroopFile.width));
            messageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(messageForTroopFile.height));
            messageRecord2.saveExtInfoToExtStr("_m_ForwardDuration", String.valueOf(messageForTroopFile.duration));
            messageRecord2.saveExtInfoToExtStr("_m_ForwardBusType", String.valueOf(messageForTroopFile.bisID));
            messageRecord2.saveExtInfoToExtStr("_m_ForwardUuid", messageForTroopFile.url);
            messageRecord2.saveExtInfoToExtStr("_m_ForwardFileName", messageForTroopFile.fileName);
            qFileMsgForwardManager = this;
            t m3 = TroopFileUtils.m(qFileMsgForwardManager.f207074a, messageForTroopFile);
            if (m3 != null) {
                messageRecord2.saveExtInfoToExtStr("_f_thumb_path_750_", m3.f294980n);
                messageRecord2.saveExtInfoToExtStr("_f_thumb_path_384_", m3.f294981o);
                int i17 = messageForTroopFile.width;
                if ((i17 == 0 || messageForTroopFile.height == 0) && m3.f294982p > 0 && m3.f294983q > 0) {
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(i17));
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(messageForTroopFile.height));
                }
                messageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", m3.f294978l);
                int i18 = m3.f294972f;
                if (i18 == 2 || i18 == 3) {
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardStatusPaused", "1");
                }
            }
        } else {
            qFileMsgForwardManager = this;
            if (messageRecord instanceof MessageForDLFile) {
                MessageForDLFile messageForDLFile = (MessageForDLFile) messageRecord;
                messageRecord2.saveExtInfoToExtStr("_m_ForwardFileType", "1");
                messageRecord2.saveExtInfoToExtStr("_m_ForwardReceiverUin", messageForDLFile.frienduin);
                messageRecord2.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(messageForDLFile.fileSize));
                messageRecord2.saveExtInfoToExtStr("_m_ForwardFileName", messageForDLFile.fileName);
                DataLineMsgRecord d16 = qFileMsgForwardManager.f207074a.getMessageFacade().t1(messageForDLFile.deviceType).d(messageForDLFile.associatedId);
                if (d16 != null) {
                    messageRecord2.saveExtInfoToExtStr("_m_ForwardFilePath", d16.path);
                }
            }
        }
        messageRecord2.saveExtInfoToExtStr("_m_ForwardSenderUin", qFileMsgForwardManager.f207074a.getCurrentAccountUin());
        messageRecord2.saveExtInfoToExtStr("_m_ForwardFileStatus", "4");
        messageRecord2.removeExtInfoToExtStr("_m_ForwardFaildReason");
        messageRecord2.removeExtInfoToExtStr("_m_ForwardLasSuccess");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends m {

        /* renamed from: b, reason: collision with root package name */
        protected String f207084b;

        /* renamed from: c, reason: collision with root package name */
        protected String f207085c;

        /* renamed from: d, reason: collision with root package name */
        protected String f207086d;

        /* renamed from: e, reason: collision with root package name */
        protected String f207087e;

        /* renamed from: f, reason: collision with root package name */
        protected String f207088f;

        /* renamed from: g, reason: collision with root package name */
        protected String f207089g;

        /* renamed from: h, reason: collision with root package name */
        protected String f207090h;

        /* renamed from: i, reason: collision with root package name */
        protected long f207091i;

        /* renamed from: j, reason: collision with root package name */
        protected String f207092j;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements b.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f207094a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ k f207095b;

            a(String str, k kVar) {
                this.f207094a = str;
                this.f207095b = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void a(int i3, String str) {
                boolean z16;
                QLog.i("FileMultiMsgManager<FileAssistant>", 1, "Buddy2BuddyTaskExcuter failed, ret-code=" + i3);
                boolean z17 = false;
                if (i3 != -100001 && i3 != -100002 && i3 != -100003 && !QFileMsgForwardManager.m(i3)) {
                    if (i3 != -6101 && i3 != -7003) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                } else {
                    z16 = false;
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + b.this.f207084b + "] faild:" + i3);
                }
                this.f207095b.a(QFileMsgForwardManager.l(b.this.f207091i, z16), z17);
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void onSuccess(String str, String str2) {
                if (QFileMsgForwardManager.t()) {
                    a(TbsCommonCode.DOWNLOAD_FLOW_CANCEL, "File is forbidden");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_m_ForwardFileType", "1");
                bundle.putString("_m_ForwardReceiverUin", this.f207094a);
                bundle.putString("_m_ForwardFileName", b.this.f207084b);
                bundle.putString("_m_ForwardSize", b.this.f207091i + "");
                bundle.putString("_m_ForwardMd5", b.this.f207087e);
                bundle.putString("_m_ForwardUuid", str);
                bundle.putString("_m_ForwardFileIdCrc", str2);
                bundle.putString("_m_ForwardDeadTime", "0");
                bundle.putString("_m_ForwardImgWidth", b.this.f207089g);
                bundle.putString("_m_ForwardImgHeight", b.this.f207090h);
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + b.this.f207084b + "] success");
                }
                this.f207095b.b(str, bundle);
            }
        }

        b(MessageRecord messageRecord) {
            super();
            this.f207084b = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            this.f207091i = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
            this.f207085c = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
            this.f207086d = messageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
            this.f207087e = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
            this.f207088f = messageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
            this.f207089g = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            this.f207090h = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            this.f207092j = messageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            if ("1".equals(this.f207092j)) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2BuddyTaskExcuter:" + this.f207084b + " faild, file is upload paused");
                }
                kVar.a(QFileMsgForwardManager.l(this.f207091i, false), false);
                return;
            }
            String str2 = this.f207085c;
            if (str2 != null && str2.length() != 0) {
                com.tencent.mobileqq.filemanager.app.b M = QFileMsgForwardManager.this.f207074a.getFileManagerEngine().M();
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + this.f207084b + "]");
                }
                M.b(str, i3, this.f207085c, this.f207086d, this.f207084b, this.f207091i, 3, new a(str, kVar));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2BuddyTaskExcuter:" + this.f207084b + " faild, file uuid is null");
            }
            kVar.a(QFileMsgForwardManager.l(this.f207091i, true), false);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends m {

        /* renamed from: b, reason: collision with root package name */
        protected String f207097b;

        /* renamed from: c, reason: collision with root package name */
        protected String f207098c;

        /* renamed from: d, reason: collision with root package name */
        protected String f207099d;

        /* renamed from: e, reason: collision with root package name */
        protected String f207100e;

        /* renamed from: f, reason: collision with root package name */
        protected String f207101f;

        /* renamed from: g, reason: collision with root package name */
        protected String f207102g;

        /* renamed from: h, reason: collision with root package name */
        protected long f207103h;

        /* renamed from: i, reason: collision with root package name */
        protected String f207104i;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements b.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f207106a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ k f207107b;

            a(String str, k kVar) {
                this.f207106a = str;
                this.f207107b = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void a(int i3, String str) {
                boolean z16;
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2DiscTaskExcuter faild");
                boolean z17 = false;
                if (i3 != -100001 && i3 != -100002 && i3 != -100003 && !QFileMsgForwardManager.m(i3)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (i3 == -6101 || i3 == -7003) {
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, c.this.f207097b + " Buddy2DiscTaskExcuter faild:" + i3);
                }
                this.f207107b.a(QFileMsgForwardManager.l(c.this.f207103h, z17), z16);
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void onSuccess(String str, String str2) {
                if (QFileMsgForwardManager.t()) {
                    a(TbsCommonCode.DOWNLOAD_FLOW_CANCEL, "File is forbidden");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_m_ForwardFileType", "2");
                bundle.putString("_m_ForwardReceiverUin", this.f207106a);
                bundle.putString("_m_ForwardFileName", c.this.f207097b);
                bundle.putString("_m_ForwardSize", c.this.f207103h + "");
                bundle.putString("_m_ForwardMd5", c.this.f207100e);
                bundle.putString("_m_ForwardDeadTime", "0");
                bundle.putString("_m_ForwardImgWidth", c.this.f207101f);
                bundle.putString("_m_ForwardImgHeight", c.this.f207102g);
                bundle.putString("_m_ForwardUuid", str);
                bundle.putString("_m_ForwardFileIdCrc", str2);
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, c.this.f207097b + " Buddy2DiscTaskExcuter success");
                }
                this.f207107b.b(str, bundle);
            }
        }

        c(MessageRecord messageRecord) {
            super();
            this.f207097b = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            this.f207103h = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
            this.f207098c = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
            this.f207099d = messageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
            this.f207100e = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
            this.f207101f = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            this.f207102g = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            this.f207104i = messageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            if ("1".equals(this.f207104i)) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2DiscTaskExcuter:" + this.f207097b + " faild, file is upload paused");
                }
                kVar.a(QFileMsgForwardManager.l(this.f207103h, false), false);
                return;
            }
            String str2 = this.f207098c;
            if (str2 != null && str2.length() != 0) {
                QFileMsgForwardManager.this.f207074a.getFileManagerEngine().M().b(str, i3, this.f207098c, this.f207099d, this.f207097b, this.f207103h, 106, new a(str, kVar));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.f207097b + " Buddy2DiscTaskExcuter faild,\u6587\u4ef6\u4e0d\u5b58\u5728\u6216\u5df2\u5931\u6548");
            }
            kVar.a(QFileMsgForwardManager.l(this.f207103h, true), false);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends m {

        /* renamed from: b, reason: collision with root package name */
        protected String f207109b;

        /* renamed from: c, reason: collision with root package name */
        protected String f207110c;

        /* renamed from: d, reason: collision with root package name */
        protected String f207111d;

        /* renamed from: e, reason: collision with root package name */
        protected String f207112e;

        /* renamed from: f, reason: collision with root package name */
        protected String f207113f;

        /* renamed from: g, reason: collision with root package name */
        protected String f207114g;

        /* renamed from: h, reason: collision with root package name */
        protected long f207115h;

        /* renamed from: i, reason: collision with root package name */
        protected String f207116i;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements b.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f207118a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ k f207119b;

            a(String str, k kVar) {
                this.f207118a = str;
                this.f207119b = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void a(int i3, String str) {
                boolean z16 = true;
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2TroopTaskExcuter onFaild retcode[" + i3 + "] retMsg[" + str + "]");
                boolean z17 = false;
                if (i3 != -100001 && i3 != -100002 && i3 != -100003 && !QFileMsgForwardManager.m(i3)) {
                    if (i3 != -6101 && i3 != -7003) {
                        z16 = false;
                    }
                } else {
                    z16 = false;
                    z17 = true;
                }
                this.f207119b.a(QFileMsgForwardManager.l(d.this.f207115h, z16), z17);
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void onSuccess(String str, String str2) {
                int parseInt;
                int parseInt2;
                if (QFileMsgForwardManager.t()) {
                    a(TbsCommonCode.DOWNLOAD_FLOW_CANCEL, "File is forbidden");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_m_ForwardFileType", "3");
                bundle.putString("_m_ForwardReceiverUin", this.f207118a);
                bundle.putString("_m_ForwardFileName", d.this.f207109b);
                bundle.putString("_m_ForwardSize", d.this.f207115h + "");
                bundle.putString("_m_ForwardMd5", d.this.f207112e);
                bundle.putString("_m_ForwardDeadTime", "0");
                bundle.putString("_m_ForwardImgWidth", d.this.f207113f);
                bundle.putString("_m_ForwardImgHeight", d.this.f207114g);
                bundle.putString("_m_ForwardUuid", str);
                bundle.putString("_m_ForwardFileIdCrc", str2);
                if (TextUtils.isEmpty(d.this.f207113f)) {
                    parseInt = 0;
                } else {
                    parseInt = Integer.parseInt(d.this.f207113f);
                }
                if (TextUtils.isEmpty(d.this.f207114g)) {
                    parseInt2 = 0;
                } else {
                    parseInt2 = Integer.parseInt(d.this.f207114g);
                }
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, d.this.f207109b + " Buddy2TroopTaskExcuter send success, send feeds");
                }
                QFileMsgForwardManager.r(QFileMsgForwardManager.this.f207074a, Long.parseLong(this.f207118a), 102, str, d.this.f207115h, 0, parseInt, parseInt2, 0, false, bundle, this.f207119b);
            }
        }

        d(MessageRecord messageRecord) {
            super();
            this.f207109b = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            this.f207115h = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
            this.f207110c = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
            this.f207111d = messageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
            this.f207112e = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
            this.f207113f = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            this.f207114g = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            this.f207116i = messageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            if ("1".equals(this.f207116i)) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2TroopTaskExcuter:" + this.f207109b + " faild, file is upload paused");
                }
                kVar.a(QFileMsgForwardManager.l(this.f207115h, false), false);
                return;
            }
            String str2 = this.f207110c;
            if (str2 != null && str2.length() != 0) {
                QFileMsgForwardManager.this.f207074a.getFileManagerEngine().M().b(str, i3, this.f207110c, this.f207111d, this.f207109b, this.f207115h, 102, new a(str, kVar));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.f207109b + " Buddy2TroopTaskExcuter faild uuid is null");
            }
            kVar.a(QFileMsgForwardManager.l(this.f207115h, true), false);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f extends m {

        /* renamed from: b, reason: collision with root package name */
        protected String f207129b;

        /* renamed from: c, reason: collision with root package name */
        protected String f207130c;

        /* renamed from: d, reason: collision with root package name */
        protected String f207131d;

        /* renamed from: e, reason: collision with root package name */
        protected String f207132e;

        /* renamed from: f, reason: collision with root package name */
        protected String f207133f;

        /* renamed from: g, reason: collision with root package name */
        protected String f207134g;

        /* renamed from: h, reason: collision with root package name */
        protected long f207135h;

        /* renamed from: i, reason: collision with root package name */
        protected String f207136i;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements b.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f207138a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ k f207139b;

            a(String str, k kVar) {
                this.f207138a = str;
                this.f207139b = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void a(int i3, String str) {
                boolean z16;
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2BuddyTaskExcuter onFaild\uff1a");
                boolean z17 = false;
                if (i3 != -100001 && i3 != -100002 && i3 != -100003 && !QFileMsgForwardManager.m(i3)) {
                    if (i3 != -6101 && i3 != -7003) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                } else {
                    z16 = false;
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, f.this.f207129b + " Disc2BuddyTaskExcuter send faild:" + i3);
                }
                this.f207139b.a(QFileMsgForwardManager.l(f.this.f207135h, z16), z17);
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void onSuccess(String str, String str2) {
                if (QFileMsgForwardManager.t()) {
                    a(TbsCommonCode.DOWNLOAD_FLOW_CANCEL, "file forbidden");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_m_ForwardFileType", "1");
                bundle.putString("_m_ForwardReceiverUin", this.f207138a);
                bundle.putString("_m_ForwardFileName", f.this.f207129b);
                bundle.putString("_m_ForwardSize", f.this.f207135h + "");
                bundle.putString("_m_ForwardMd5", f.this.f207131d);
                bundle.putString("_m_ForwardDeadTime", "0");
                bundle.putString("_m_ForwardImgWidth", f.this.f207133f);
                bundle.putString("_m_ForwardImgHeight", f.this.f207134g);
                bundle.putString("_m_ForwardUuid", str);
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, f.this.f207129b + " Disc2BuddyTaskExcuter send success");
                }
                this.f207139b.b(str, bundle);
            }
        }

        f(MessageRecord messageRecord) {
            super();
            this.f207129b = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            this.f207135h = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
            this.f207130c = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
            this.f207131d = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
            this.f207132e = messageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            this.f207133f = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            this.f207134g = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            this.f207136i = messageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            if ("1".equals(this.f207136i)) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Disc2BuddyTaskExcuter:" + this.f207129b + " faild, file is upload paused");
                }
                kVar.a(QFileMsgForwardManager.l(this.f207135h, false), false);
                return;
            }
            String str2 = this.f207130c;
            if (str2 != null && str2.length() != 0) {
                QFileMsgForwardManager.this.f207074a.getFileManagerEngine().M().a(str, i3, this.f207132e, 3, this.f207130c, this.f207129b, this.f207135h, this.f207131d, new a(str, kVar));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.f207129b + " Disc2BuddyTaskExcuter send faild uuid is null");
            }
            kVar.a(QFileMsgForwardManager.l(this.f207135h, true), false);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g extends m {

        /* renamed from: b, reason: collision with root package name */
        protected String f207141b;

        /* renamed from: c, reason: collision with root package name */
        protected String f207142c;

        /* renamed from: d, reason: collision with root package name */
        protected String f207143d;

        /* renamed from: e, reason: collision with root package name */
        protected String f207144e;

        /* renamed from: f, reason: collision with root package name */
        protected String f207145f;

        /* renamed from: g, reason: collision with root package name */
        protected String f207146g;

        /* renamed from: h, reason: collision with root package name */
        protected long f207147h;

        /* renamed from: i, reason: collision with root package name */
        protected String f207148i;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements b.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f207150a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ k f207151b;

            a(String str, k kVar) {
                this.f207150a = str;
                this.f207151b = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void a(int i3, String str) {
                boolean z16;
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2DiscTaskExcuter onFaild\uff1a");
                boolean z17 = false;
                if (i3 != -100001 && i3 != -100002 && i3 != -100003 && !QFileMsgForwardManager.m(i3)) {
                    if (i3 != -6101 && i3 != -7003) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                } else {
                    z16 = false;
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, g.this.f207141b + " Disc2DiscTaskExcuter send faild:" + i3);
                }
                this.f207151b.a(QFileMsgForwardManager.l(g.this.f207147h, z16), z17);
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void onSuccess(String str, String str2) {
                if (QFileMsgForwardManager.t()) {
                    a(TbsCommonCode.DOWNLOAD_FLOW_CANCEL, "file forbidden");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_m_ForwardFileType", "2");
                bundle.putString("_m_ForwardReceiverUin", this.f207150a);
                bundle.putString("_m_ForwardFileName", g.this.f207141b);
                bundle.putString("_m_ForwardSize", g.this.f207147h + "");
                bundle.putString("_m_ForwardMd5", g.this.f207143d);
                bundle.putString("_m_ForwardDeadTime", "0");
                bundle.putString("_m_ForwardImgWidth", g.this.f207145f);
                bundle.putString("_m_ForwardImgHeight", g.this.f207146g);
                bundle.putString("_m_ForwardUuid", str);
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, g.this.f207141b + " Disc2DiscTaskExcuter send success");
                }
                this.f207151b.b(str, bundle);
            }
        }

        g(MessageRecord messageRecord) {
            super();
            this.f207141b = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            this.f207147h = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
            this.f207142c = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
            this.f207143d = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
            this.f207144e = messageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            this.f207145f = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            this.f207146g = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            this.f207148i = messageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            if ("1".equals(this.f207148i)) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Disc2DiscTaskExcuter:" + this.f207141b + " faild, file is upload paused");
                }
                kVar.a(QFileMsgForwardManager.l(this.f207147h, false), false);
                return;
            }
            String str2 = this.f207142c;
            if (str2 != null && str2.length() != 0) {
                QFileMsgForwardManager.this.f207074a.getFileManagerEngine().M().a(str, i3, this.f207144e, 106, this.f207142c, this.f207141b, this.f207147h, this.f207143d, new a(str, kVar));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.f207141b + " Disc2DiscTaskExcuter send faild uuid is null");
            }
            kVar.a(QFileMsgForwardManager.l(this.f207147h, true), false);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h extends m {

        /* renamed from: b, reason: collision with root package name */
        protected String f207153b;

        /* renamed from: c, reason: collision with root package name */
        protected String f207154c;

        /* renamed from: d, reason: collision with root package name */
        protected String f207155d;

        /* renamed from: e, reason: collision with root package name */
        protected String f207156e;

        /* renamed from: f, reason: collision with root package name */
        protected String f207157f;

        /* renamed from: g, reason: collision with root package name */
        protected String f207158g;

        /* renamed from: h, reason: collision with root package name */
        protected long f207159h;

        /* renamed from: i, reason: collision with root package name */
        protected String f207160i;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements b.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f207162a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ k f207163b;

            a(String str, k kVar) {
                this.f207162a = str;
                this.f207163b = kVar;
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void a(int i3, String str) {
                boolean z16;
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2TroopTaskExcuter onFaild\uff1a");
                boolean z17 = false;
                if (i3 != -100001 && i3 != -100002 && i3 != -100003 && !QFileMsgForwardManager.m(i3)) {
                    if (i3 != -6101 && i3 != -7003) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                } else {
                    z16 = false;
                    z17 = true;
                }
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, h.this.f207153b + " Disc2TroopTaskExcuter send faild:" + i3);
                }
                this.f207163b.a(QFileMsgForwardManager.l(h.this.f207159h, z16), z17);
            }

            @Override // com.tencent.mobileqq.filemanager.app.b.e
            public void onSuccess(String str, String str2) {
                int parseInt;
                int parseInt2;
                if (QFileMsgForwardManager.t()) {
                    a(TbsCommonCode.DOWNLOAD_FLOW_CANCEL, "file forbidden");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("_m_ForwardFileType", "3");
                bundle.putString("_m_ForwardReceiverUin", this.f207162a);
                bundle.putString("_m_ForwardFileName", h.this.f207153b);
                bundle.putString("_m_ForwardSize", h.this.f207159h + "");
                bundle.putString("_m_ForwardMd5", h.this.f207155d);
                bundle.putString("_m_ForwardDeadTime", "0");
                bundle.putString("_m_ForwardImgWidth", h.this.f207157f);
                bundle.putString("_m_ForwardImgHeight", h.this.f207158g);
                bundle.putString("_m_ForwardUuid", str);
                if (TextUtils.isEmpty(h.this.f207157f)) {
                    parseInt = 0;
                } else {
                    parseInt = Integer.parseInt(h.this.f207157f);
                }
                if (TextUtils.isEmpty(h.this.f207158g)) {
                    parseInt2 = 0;
                } else {
                    parseInt2 = Integer.parseInt(h.this.f207158g);
                }
                if (QLog.isColorLevel()) {
                    QLog.e("FileMultiMsgManager<FileAssistant>", 1, h.this.f207153b + " Disc2TroopTaskExcuter send success send feeds");
                }
                QFileMsgForwardManager.r(QFileMsgForwardManager.this.f207074a, Long.parseLong(this.f207162a), 102, str, h.this.f207159h, 0, parseInt, parseInt2, 0, false, bundle, this.f207163b);
            }
        }

        h(MessageRecord messageRecord) {
            super();
            this.f207153b = messageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
            this.f207159h = Long.parseLong(messageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
            this.f207154c = messageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
            this.f207155d = messageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
            this.f207156e = messageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            this.f207157f = messageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
            this.f207158g = messageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
            this.f207160i = messageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void a(String str, int i3, k kVar) {
            if ("1".equals(this.f207160i)) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Disc2TroopTaskExcuter:" + this.f207153b + " faild, file is upload paused");
                }
                kVar.a(QFileMsgForwardManager.l(this.f207159h, false), false);
                return;
            }
            String str2 = this.f207154c;
            if (str2 != null && str2.length() != 0) {
                QFileMsgForwardManager.this.f207074a.getFileManagerEngine().M().a(str, i3, this.f207156e, 102, this.f207154c, this.f207153b, this.f207159h, this.f207155d, new a(str, kVar));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.f207153b + " Disc2TroopTaskExcuter send faild uuid is null");
            }
            kVar.a(QFileMsgForwardManager.l(this.f207159h, true), false);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.m
        void b(String str, int i3) {
        }
    }
}
