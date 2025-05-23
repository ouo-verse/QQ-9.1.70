package dc1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends a {

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f393567i;

    /* renamed from: j, reason: collision with root package name */
    private Context f393568j;

    /* renamed from: k, reason: collision with root package name */
    private long f393569k;

    /* renamed from: l, reason: collision with root package name */
    private t f393570l;

    /* renamed from: m, reason: collision with root package name */
    private int f393571m;

    /* renamed from: n, reason: collision with root package name */
    private Bundle f393572n;

    /* renamed from: o, reason: collision with root package name */
    private long f393573o;

    /* renamed from: p, reason: collision with root package name */
    private String f393574p;

    /* renamed from: q, reason: collision with root package name */
    private long f393575q;

    /* renamed from: r, reason: collision with root package name */
    private int f393576r;

    /* renamed from: s, reason: collision with root package name */
    private int f393577s;

    public g(QQAppInterface qQAppInterface, Context context, long j3, t tVar, int i3) {
        super(qQAppInterface, context);
        this.f393567i = qQAppInterface;
        this.f393569k = j3;
        this.f393570l = tVar;
        this.f393571m = i3;
        this.f393568j = context;
    }

    private void A() {
        String str;
        t tVar = this.f393570l;
        if (tVar != null && !TextUtils.isEmpty(tVar.f294987u) && this.f393570l.f294987u.endsWith(".mp4")) {
            Context context = this.f393568j;
            if (context != null && (context instanceof SplashActivity)) {
                str = "1";
            } else {
                str = "3";
            }
            ShortVideoUtils.reportVideoPlay(this.f393567i.getCurrentAccountUin(), String.valueOf(this.f393569k), String.valueOf(0), 1, "3", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        TroopFileTransferManager.O(this.f393567i, this.f393569k).r();
    }

    public void B(Bundle bundle) {
        this.f393572n = bundle;
    }

    public void C(long j3) {
        this.f393573o = j3;
    }

    public void D(String str) {
        this.f393574p = str;
    }

    @Override // dc1.e
    public boolean a() {
        if (this.f393570l == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileVideo", 1, "mTroopFileInfo is null, return false,(check why is here!)");
            }
            return false;
        }
        int fileType = FileManagerUtil.getFileType(m());
        if (fileType != 2) {
            if (QLog.isColorLevel()) {
                QLog.i("FileVideo", 1, "id:" + this.f393570l.f294967a + " type is:" + fileType + " use old filebrowser:");
            }
            return false;
        }
        int i3 = this.f393570l.f294972f;
        if (i3 == 12) {
            if (QLog.isColorLevel()) {
                QLog.w("FileVideo", 1, "id:" + this.f393570l.f294967a + " is deleted, return false,(check why is here!)");
            }
            return false;
        }
        if (i3 != 4 && i3 != 5) {
            if (com.tencent.mobileqq.troop.data.a.b(i3)) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileVideo", 1, "id:" + this.f393570l.f294967a + " status:" + this.f393570l.f294972f + " use old browser!");
                }
                return false;
            }
            if (q.f(this.f393570l.f294978l) || QFileUtils.e0(this.f393567i)) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.i("FileVideo", 1, "use new filevideo browser switch is off!");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.w("FileVideo", 1, "id:" + this.f393570l.f294967a + " is forwarding, return false,(check why is here!)");
        }
        return false;
    }

    @Override // dc1.a, dc1.e
    public boolean b() {
        return super.b();
    }

    @Override // dc1.e
    public Intent d() {
        t y16 = y();
        if (y16 == null) {
            return null;
        }
        return x(y16);
    }

    @Override // dc1.e
    public boolean j() {
        int i3 = this.f393570l.f294972f;
        if (i3 != 10 && i3 != 9) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileVideo", 1, "id:" + this.f393570l.f294967a + " status:" + this.f393570l.f294972f + " resume");
        }
        TroopFileTransferManager.N(this.f393569k).e0(this.f393570l.f294967a);
        return true;
    }

    @Override // dc1.e
    public void k(Bundle bundle) {
        ChatMessage chatMessage = this.f393560a;
        if (chatMessage != null) {
            bundle.putLong("troopfile_shmsgseq", chatMessage.shmsgseq);
            bundle.putBoolean("is_multi_aio_msg", this.f393560a.isMultiMsg);
            Bundle bundle2 = this.f393572n;
            if (bundle2 != null && bundle2.containsKey("file_location_pos_entrance_multiseq")) {
                bundle.putBoolean("file_location_pos_entrance_multiseq", this.f393572n.getBoolean("file_location_pos_entrance_multiseq", false));
            }
        }
        Bundle bundle3 = this.f393572n;
        if (bundle3 != null) {
            bundle.putInt("key_source", bundle3.getInt("key_source", 0));
        }
    }

    @Override // dc1.a
    protected String m() {
        t tVar = this.f393570l;
        if (tVar != null && !TextUtils.isEmpty(tVar.f294987u)) {
            return this.f393570l.f294987u;
        }
        return "";
    }

    @Override // dc1.a
    protected String n() {
        t tVar = this.f393570l;
        if (tVar != null) {
            return tVar.f294978l;
        }
        return "";
    }

    @Override // dc1.a
    protected long o() {
        t tVar = this.f393570l;
        if (tVar != null) {
            return tVar.f294976j;
        }
        return 0L;
    }

    @Override // dc1.a
    protected int p() {
        int i3;
        t tVar = this.f393570l;
        if (tVar != null && ((i3 = tVar.f294972f) == 1 || i3 == 8 || i3 == 0)) {
            return 2;
        }
        return -1;
    }

    public FileManagerEntity w() {
        t y16 = y();
        if (y16 == null) {
            return null;
        }
        FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(y16);
        if (!TextUtils.isEmpty(this.f393574p)) {
            newEntityByTroopFileInfo.selfUin = this.f393574p;
        }
        long j3 = this.f393573o;
        if (j3 != 0) {
            newEntityByTroopFileInfo.lastTime = j3;
        }
        newEntityByTroopFileInfo.bSend = this.f393567i.getAccount().equals(newEntityByTroopFileInfo.selfUin);
        return newEntityByTroopFileInfo;
    }

    public Intent x(t tVar) {
        FileManagerEntity newEntityByTroopFileInfo;
        n A;
        int i3 = this.f393577s;
        if (i3 == 58) {
            newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar, this.f393575q, this.f393576r, i3);
        } else {
            newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar);
        }
        if (!TextUtils.isEmpty(this.f393574p)) {
            newEntityByTroopFileInfo.selfUin = this.f393574p;
        }
        long j3 = this.f393573o;
        if (j3 != 0) {
            newEntityByTroopFileInfo.lastTime = j3;
        }
        newEntityByTroopFileInfo.bSend = this.f393567i.getAccount().equals(newEntityByTroopFileInfo.selfUin);
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.E(newEntityByTroopFileInfo.nSessionId);
        if (this.f393577s != 58) {
            forwardFileInfo.w(4);
        }
        forwardFileInfo.N(10006);
        forwardFileInfo.C(tVar.f294978l);
        forwardFileInfo.y(tVar.f294987u);
        forwardFileInfo.z(tVar.f294976j);
        forwardFileInfo.B(this.f393569k);
        forwardFileInfo.V(tVar.f294970d);
        forwardFileInfo.x(tVar.f294985s);
        forwardFileInfo.D(this.f393574p);
        forwardFileInfo.v(tVar.f294988v);
        Intent intent = new Intent();
        if (this.f393571m == 1 && (A = TroopFileManager.F(this.f393567i, this.f393569k).A(this.f393570l.f294991y)) != null) {
            intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, A.f294917c);
        }
        intent.putExtra("fileinfo", forwardFileInfo);
        intent.putExtra("removemementity", true);
        intent.putExtra(AppConstants.Key.FORWARD_FROM_TROOP_FILE, true);
        intent.putExtra("not_forward", true);
        intent.putExtra("file_browser_extra_params_uin", String.valueOf(this.f393569k));
        long j16 = this.f393573o;
        if (j16 != 0) {
            intent.putExtra("last_time", j16);
        }
        intent.putExtra("from_type_troop", this.f393571m);
        Bundle bundle = this.f393572n;
        if (bundle != null) {
            intent.putExtra("key_source", bundle.getInt("key_source", 0));
        }
        A();
        return intent;
    }

    t y() {
        String str = "";
        if (!q.p(this.f393570l.f294978l)) {
            ThreadManagerV2.excute(new Runnable() { // from class: dc1.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.z();
                }
            }, 64, null, true);
            t tVar = this.f393570l;
            int i3 = tVar.f294972f;
            if (i3 == 2 || i3 == 3) {
                String str2 = tVar.f294978l;
                if (str2 != null) {
                    int lastIndexOf = str2.lastIndexOf("/") + 1;
                    if (lastIndexOf < this.f393570l.f294978l.length()) {
                        String str3 = this.f393570l.f294978l;
                        str = str3.substring(lastIndexOf, str3.length() - 1);
                    }
                } else {
                    QLog.e("TroopFileBrowserParams", 1, "LocalFile is null!");
                }
                TroopFileError.k(this.f393568j, String.format(this.f393568j.getString(R.string.ek9), TroopFileUtils.p(str)));
                return null;
            }
        }
        if (!TextUtils.isEmpty(this.f393570l.f294987u)) {
            str = this.f393570l.f294987u;
        }
        t tVar2 = new t();
        tVar2.f294987u = str;
        t tVar3 = this.f393570l;
        tVar2.f294978l = tVar3.f294978l;
        tVar2.f294976j = tVar3.f294976j;
        tVar2.f294977k = tVar3.f294977k;
        tVar2.f294967a = tVar3.f294967a;
        tVar2.f294970d = tVar3.f294970d;
        long j3 = this.f393569k;
        tVar2.f294971e = j3;
        tVar2.f294988v = tVar3.f294988v;
        tVar2.f294985s = tVar3.f294985s;
        tVar2.f294986t = tVar3.f294986t;
        tVar2.f294979m = tVar3.f294979m;
        tVar2.f294980n = tVar3.f294980n;
        tVar2.f294981o = tVar3.f294981o;
        tVar2.f294972f = tVar3.f294972f;
        tVar2.B = tVar3.B;
        tVar2.C = tVar3.C;
        tVar2.D = tVar3.D;
        tVar2.E = tVar3.E;
        tVar2.F = tVar3.F;
        tVar2.G = tVar3.G;
        tVar2.f294968b = tVar3.f294968b;
        TroopFileManager.F(this.f393567i, j3).c(this.f393570l.f294967a);
        return tVar2;
    }

    public g(QQAppInterface qQAppInterface, Context context, long j3, t tVar, int i3, long j16, int i16, int i17) {
        this(qQAppInterface, context, j3, tVar, i3);
        this.f393575q = j16;
        this.f393576r = i16;
        this.f393577s = i17;
    }
}
