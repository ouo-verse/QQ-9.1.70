package com.tencent.av.ui.notdisturb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.InviteMemberObserverWithoutCache;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.e;
import com.tencent.av.gaudio.GaInviteLockActivity;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.at;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116$MemberInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116$MsgBody;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GaInviteFloatBarUICtr extends BaseGaInviteFloatBarUICtr {

    /* renamed from: t, reason: collision with root package name */
    Intent f76166t;

    /* renamed from: r, reason: collision with root package name */
    int f76164r = -1;

    /* renamed from: s, reason: collision with root package name */
    String f76165s = "";

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<com.tencent.av.gaudio.a> f76167u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    private long[] f76168v = null;

    /* renamed from: w, reason: collision with root package name */
    BroadcastReceiver f76169w = new a();

    /* renamed from: x, reason: collision with root package name */
    private InviteMemberObserverWithoutCache f76170x = new b();

    /* renamed from: y, reason: collision with root package name */
    GAudioUIObserver f76171y = new c();

    /* renamed from: z, reason: collision with root package name */
    private boolean f76172z = false;
    private BroadcastReceiver A = new d();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends InviteMemberObserverWithoutCache {
        b() {
        }

        @Override // com.tencent.av.app.InviteMemberObserverWithoutCache
        protected void c(long j3, long j16, ArrayList<com.tencent.av.gaudio.a> arrayList) {
            GaInviteFloatBarUICtr.this.f76167u.clear();
            GaInviteFloatBarUICtr.this.f76167u.addAll(arrayList);
            GaInviteFloatBarUICtr.this.t();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends GAudioUIObserver {
        c() {
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void A(long j3, long j16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBarUICtr.troopgroup_vedio.invite", 2, "groupId:" + j3 + ", memUin:" + j16 + ",invitedId:" + str + ", mInviterUin:" + GaInviteFloatBarUICtr.this.f76135h + ", mGroupId:" + GaInviteFloatBarUICtr.this.f76129b);
            }
            GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
            if (j16 == gaInviteFloatBarUICtr.f76135h && j3 == gaInviteFloatBarUICtr.f76129b) {
                gaInviteFloatBarUICtr.c();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void L(long j3, boolean z16, int i3) {
            super.L(j3, z16, i3);
            GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
            if (j3 == gaInviteFloatBarUICtr.f76129b) {
                if (i3 == 10 || i3 == 1) {
                    gaInviteFloatBarUICtr.o(i3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.GAudioUIObserver
        public void O() {
            super.O();
            GaInviteFloatBarUICtr.this.f();
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void S(long j3, ArrayList<e> arrayList, int i3, int i16) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                if (String.valueOf(it.next().f73701a).equalsIgnoreCase(GaInviteFloatBarUICtr.this.f76128a.getAccount())) {
                    GaInviteFloatBarUICtr.this.c();
                }
            }
            GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
            if (j3 == gaInviteFloatBarUICtr.f76129b && (i3 == 10 || i3 == 1)) {
                gaInviteFloatBarUICtr.t();
            }
            QLog.d("GaInviteFloatBarUICtr", 1, "onUserListALLUpdate userCount=" + i16 + " simpleData=" + arrayList.size());
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void b(long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBarUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->notifyByGroupId=" + j3);
            }
            GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
            long j16 = gaInviteFloatBarUICtr.f76129b;
            gaInviteFloatBarUICtr.c();
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void c(long j3) {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->groupId=" + j3);
            }
            GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
            if (gaInviteFloatBarUICtr.f76129b == j3) {
                gaInviteFloatBarUICtr.c();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void d(long j3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->groupId=" + j3 + " inviteId=" + str);
            }
            GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
            if (gaInviteFloatBarUICtr.f76129b == j3 && String.valueOf(gaInviteFloatBarUICtr.f76135h).equals(str)) {
                GaInviteFloatBarUICtr.this.c();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void g(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBarUICtr", 2, "onCreateRoomSuc-->GroupID=" + j16);
            }
            GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
            gaInviteFloatBarUICtr.f76137j.f73097x1 = true;
            if (gaInviteFloatBarUICtr.f76133f == 1) {
                gaInviteFloatBarUICtr.f76128a.V(j16);
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void h(long j3, int i3) {
            super.i(j3);
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBarUICtr", 2, "onDestroyInviteUI-->reason=" + i3);
            }
            GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
            if (gaInviteFloatBarUICtr.f76129b == j3 || 0 == j3) {
                gaInviteFloatBarUICtr.c();
            }
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void k(long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.w("GaInviteFloatBarUICtr", 1, "onEnterRoomSuc, groupId[" + j16 + "], seq[" + j3 + "]");
            }
        }
    }

    public GaInviteFloatBarUICtr(VideoAppInterface videoAppInterface, Intent intent) {
        this.f76128a = videoAppInterface;
        this.f76166t = intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        long j3;
        try {
            j3 = Long.parseLong(this.f76137j.Y0);
        } catch (Throwable th5) {
            th5.printStackTrace();
            j3 = 0;
        }
        Context applicationContext = this.f76128a.getApp().getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) GaInviteLockActivity.class);
        ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).setIntentFrom(intent, "FloatBarInvite");
        intent.addFlags(268435456);
        intent.putExtra("uinType", this.f76137j.f73067q);
        intent.putExtra("peerUin", this.f76137j.Y0);
        intent.putExtra("friendUin", j3);
        intent.putExtra("relationType", this.f76137j.S0);
        intent.putExtra("MultiAVType", this.f76137j.f73063p);
        intent.putExtra("discussId", this.f76137j.P0);
        intent.putExtra("memberList", this.f76137j.Q0);
        intent.putExtra("isDoubleVideoMeeting", this.f76137j.f73060o0);
        intent.putExtra(ServiceConst.PARA_SESSION_ID, this.f76137j.f73030h);
        intent.putExtra("showHalfScreenTimestamp", this.f76141n);
        try {
            applicationContext.startActivity(intent);
            QLog.d("GaInviteFloatBarUICtr", 1, "enterInviteActivity intent: " + intent.getExtras());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GaInviteFloatBarUICtr", 2, "enterInviteActivity e = " + e16);
            }
        }
    }

    private void n() {
        VideoAppInterface videoAppInterface = this.f76128a;
        if (videoAppInterface != null && videoAppInterface.getApp() != null) {
            SessionInfo sessionInfo = this.f76137j;
            long j3 = sessionInfo.P0;
            int i3 = sessionInfo.S0;
            if (j3 != 0) {
                Context applicationContext = this.f76128a.getApp().getApplicationContext();
                Intent intent = new Intent(applicationContext, (Class<?>) AVActivity.class);
                intent.addFlags(262144);
                intent.addFlags(268435456);
                intent.addFlags(4194304);
                intent.putExtra("GroupId", String.valueOf(j3));
                intent.putExtra("Type", 2);
                intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, this.f76137j.f73035i);
                intent.putExtra("uinType", ba.avRelationType2UinType(i3));
                intent.putExtra("isDoubleVideoMeeting", this.f76137j.f73060o0);
                intent.putExtra("MultiAVType", this.f76137j.f73063p);
                intent.putExtra("Fromwhere", "AV_INVITE_HALF_SCREEN");
                try {
                    applicationContext.startActivity(intent);
                    QLog.d("GaInviteFloatBarUICtr", 1, "enterVideo intent: " + intent.getExtras());
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("GaInviteFloatBarUICtr", 2, "enterVideo e = " + e16);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        QLog.d("GaInviteFloatBarUICtr", 1, "enterVideo failed.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(int i3) {
        boolean d06 = r.h0().d0(this.f76134g, this.f76129b, i3);
        if (QLog.isColorLevel()) {
            QLog.d("GaInviteFloatBarUICtr", 2, "getGAudioRoomMemList " + d06);
        }
        return d06;
    }

    private boolean q(long[] jArr) {
        boolean z16;
        long[] jArr2 = this.f76168v;
        if (jArr2 == null || jArr2.length != jArr.length) {
            return true;
        }
        for (long j3 : jArr2) {
            int length = jArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z16 = false;
                    break;
                }
                if (j3 == jArr[i3]) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        int i3;
        ArrayList<e> B0 = r.h0().B0();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator<e> it = B0.iterator();
        while (it.hasNext()) {
            e next = it.next();
            long j3 = next.f73701a;
            if (j3 != this.f76135h) {
                arrayList.add(Long.valueOf(j3));
            }
            hashSet.add(Long.valueOf(next.f73701a));
        }
        Iterator<com.tencent.av.gaudio.a> it5 = this.f76167u.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            com.tencent.av.gaudio.a next2 = it5.next();
            if (!hashSet.contains(Long.valueOf(next2.f73825a))) {
                if (next2.f73825a == this.f76128a.getLongAccountUin()) {
                    arrayList.add(0, Long.valueOf(next2.f73825a));
                } else {
                    arrayList.add(Long.valueOf(next2.f73825a));
                }
            }
        }
        long[] jArr = new long[arrayList.size()];
        for (i3 = 0; i3 < arrayList.size(); i3++) {
            jArr[i3] = ((Long) arrayList.get(i3)).longValue();
        }
        QLog.d("GaInviteFloatBarUICtr", 1, "refreshMemberList attends=" + B0.size() + " mInvitesMembers=" + this.f76167u.size() + " mergeData=" + arrayList.size());
        SessionInfo sessionInfo = this.f76137j;
        if (sessionInfo != null) {
            u(jArr, sessionInfo.P0, sessionInfo.S0);
        }
    }

    private void u(final long[] jArr, final long j3, final int i3) {
        if (!q(jArr)) {
            QLog.d("GaInviteFloatBarUICtr", 1, "refreshMemberList failed for same list.");
        } else {
            this.f76168v = jArr;
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.av.ui.notdisturb.GaInviteFloatBarUICtr.4
                @Override // java.lang.Runnable
                public void run() {
                    GaInviteFloatBar gaInviteFloatBar = GaInviteFloatBarUICtr.this.f76140m;
                    if (gaInviteFloatBar == null) {
                        return;
                    }
                    gaInviteFloatBar.B(jArr, j3, i3);
                }
            });
        }
    }

    private void v() {
        t();
        ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.av.ui.notdisturb.GaInviteFloatBarUICtr.6
            @Override // java.lang.Runnable
            public void run() {
                GaInviteFloatBar gaInviteFloatBar;
                GaInviteFloatBarUICtr gaInviteFloatBarUICtr = GaInviteFloatBarUICtr.this;
                GaInviteFloatBar gaInviteFloatBar2 = gaInviteFloatBarUICtr.f76140m;
                if (gaInviteFloatBar2 != null) {
                    gaInviteFloatBar2.A(gaInviteFloatBarUICtr.f76134g, String.valueOf(gaInviteFloatBarUICtr.f76135h));
                }
                GaInviteFloatBarUICtr gaInviteFloatBarUICtr2 = GaInviteFloatBarUICtr.this;
                if (gaInviteFloatBarUICtr2.f76137j.f73042j2 != 4 || (gaInviteFloatBar = gaInviteFloatBarUICtr2.f76140m) == null) {
                    return;
                }
                gaInviteFloatBar.D(HardCodeUtil.qqStr(R.string.dep));
            }
        });
    }

    @Override // com.tencent.av.ui.notdisturb.BaseGaInviteFloatBarUICtr
    public void c() {
        super.c();
        VideoAppInterface videoAppInterface = this.f76128a;
        if (videoAppInterface != null) {
            try {
                videoAppInterface.getApplication().unregisterReceiver(this.f76169w);
                if (this.f76172z) {
                    this.f76128a.getApplication().unregisterReceiver(this.A);
                    this.A = null;
                    this.f76172z = false;
                }
                this.f76128a.deleteObserver(this.f76171y);
                this.f76128a.deleteObserver(this.f76170x);
            } catch (Exception e16) {
                QLog.d("GaInviteFloatBarUICtr", 1, "onDestroy error : " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.ui.notdisturb.BaseGaInviteFloatBarUICtr
    public void f() {
        super.f();
    }

    public void r() {
        QLog.d("GaInviteFloatBarUICtr", 1, "onCreate start");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.addAction("tencent.video.notdisturb.invite.gaaccept");
        intentFilter.addAction("tencent.video.notdisturb.invite.gaignore");
        intentFilter.addAction("tencent.video.notdisturb.invite.enter");
        intentFilter.addAction("tencent.video.q2v.sdk.onRequestVideo");
        this.f76128a.getApplication().registerReceiver(this.f76169w, intentFilter);
        this.f76128a.getApplication().registerReceiver(this.A, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
        this.f76172z = true;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                long a16 = at.a(intent);
                if (action.equals("tencent.video.notdisturb.invite.gaaccept")) {
                    GaInviteFloatBarUICtr.this.k(a16);
                    return;
                }
                if (action.equals("tencent.video.notdisturb.invite.gaignore")) {
                    GaInviteFloatBarUICtr.this.p(a16);
                } else if (action.equals("tencent.video.notdisturb.invite.enter")) {
                    GaInviteFloatBarUICtr.this.m();
                    GaInviteFloatBarUICtr.this.c();
                }
            }
        }
    }

    @Override // com.tencent.av.ui.notdisturb.BaseGaInviteFloatBarUICtr
    void d() {
        p(-1039L);
    }

    public void k(long j3) {
        QLog.w("GaInviteFloatBarUICtr", 1, "acceptGAudioChat, seq[" + j3 + "]");
        GaInviteFloatBar gaInviteFloatBar = this.f76140m;
        if (gaInviteFloatBar != null) {
            gaInviteFloatBar.D(HardCodeUtil.qqStr(R.string.v4l));
        }
        r.h0().a(j3, this.f76134g, this.f76137j.P0, this.f76136i, false);
        ReportController.o(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
        n();
        c();
    }

    public void p(long j3) {
        QLog.w("GaInviteFloatBarUICtr", 1, "ignoreGAInvite, seq[" + j3 + "]");
        ReportController.o(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
        if (!l(0)) {
            r.h0().P0(j3, this.f76134g, this.f76129b);
        }
        c();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            boolean z16;
            int i3;
            String str2;
            String action = intent.getAction();
            boolean z17 = GaInviteFloatBarUICtr.this.f76129b == intent.getLongExtra("groupId", 0L);
            String str3 = "GaInviteFloatBarUICtr";
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteFloatBarUICtr", 2, "handleMsgType0x210SuMsgType0x116 mMemberChangeEventReceiver fit=" + z17 + ";current groupId=" + GaInviteFloatBarUICtr.this.f76129b);
            }
            if ("tencent.video.q2v.GvideoMemInviteUpdate".equals(action)) {
                AVUtil.b(intent);
            }
            if (action.equalsIgnoreCase("tencent.video.q2v.GvideoMemInviteUpdate") && z17) {
                submsgtype0x116$MsgBody submsgtype0x116_msgbody = new submsgtype0x116$MsgBody();
                try {
                    submsgtype0x116_msgbody.mergeFrom(intent.getByteArrayExtra("pushData"));
                    HashSet hashSet = new HashSet();
                    Iterator it = GaInviteFloatBarUICtr.this.f76167u.iterator();
                    while (it.hasNext()) {
                        com.tencent.av.gaudio.a aVar = (com.tencent.av.gaudio.a) it.next();
                        QLog.d("GaInviteFloatBarUICtr", 1, "mInvitesMembers friend uin=" + aVar.f73825a);
                        hashSet.add(Long.valueOf(aVar.f73825a));
                    }
                    int i16 = submsgtype0x116_msgbody.enum_event_type.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("GaInviteFloatBarUICtr", 2, "mMemberChangeEventReceiver before totalCount:" + submsgtype0x116_msgbody.uint32_invite_list_total_count.get() + ";currentInviteMembers=" + hashSet.size());
                    }
                    VideoAppInterface b16 = nw.b.b();
                    if (b16 == null) {
                        str = "GaInviteFloatBarUICtr";
                        z16 = false;
                    } else {
                        int i17 = 0;
                        z16 = false;
                        while (i17 < submsgtype0x116_msgbody.rpt_msg_member_join.size()) {
                            submsgtype0x116$MemberInfo submsgtype0x116_memberinfo = submsgtype0x116_msgbody.rpt_msg_member_join.get(i17);
                            long j3 = submsgtype0x116_memberinfo.uint64_member_uin.get();
                            boolean z18 = (j3 == b16.getLongAccountUin() || j3 == GaInviteFloatBarUICtr.this.f76135h) ? false : true;
                            if (hashSet.contains(Long.valueOf(j3)) || !z18) {
                                str2 = str3;
                            } else {
                                String str4 = str3;
                                GaInviteFloatBarUICtr.this.f76167u.add(new com.tencent.av.gaudio.a(submsgtype0x116_memberinfo.uint64_member_uin.get(), submsgtype0x116_memberinfo.uint32_invite_timestamp.get()));
                                if (QLog.isColorLevel()) {
                                    str2 = str4;
                                    QLog.d(str2, 2, "mMemberChangeEventReceiver add member UIN:" + j3);
                                } else {
                                    str2 = str4;
                                }
                                z16 = true;
                            }
                            i17++;
                            str3 = str2;
                        }
                        str = str3;
                    }
                    for (int i18 = 0; i18 < submsgtype0x116_msgbody.rpt_msg_member_quit.size(); i18++) {
                        long j16 = submsgtype0x116_msgbody.rpt_msg_member_quit.get(i18).uint64_member_uin.get();
                        Iterator it5 = GaInviteFloatBarUICtr.this.f76167u.iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                com.tencent.av.gaudio.a aVar2 = (com.tencent.av.gaudio.a) it5.next();
                                if (aVar2.f73825a == j16) {
                                    GaInviteFloatBarUICtr.this.f76167u.remove(aVar2);
                                    if (QLog.isColorLevel()) {
                                        i3 = 2;
                                        QLog.d(str, 2, "mMemberChangeEventReceiver remove member UIN:" + aVar2.f73825a);
                                    } else {
                                        i3 = 2;
                                    }
                                    if (i16 != i3) {
                                        z16 = true;
                                    }
                                }
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(str, 2, "mMemberChangeEventReceiver after totalCount:" + submsgtype0x116_msgbody.uint32_invite_list_total_count.get() + ";currentInviteMembers=" + hashSet.size() + ";eventType=" + submsgtype0x116_msgbody.enum_event_type.get());
                    }
                    if (z16) {
                        GaInviteFloatBarUICtr.this.t();
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("GaInviteFloatBarUICtr", 2, "mMemberChangeEventReceiver throw exception");
                    }
                }
            }
        }
    }

    private boolean l(int i3) {
        String str;
        if (this.f76134g != 1 || TextUtils.isEmpty(this.f76165s)) {
            return false;
        }
        Intent intent = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
        intent.putExtra("relationId", this.f76129b + "");
        intent.putExtra("dealResult", i3);
        intent.putExtra("inviteId", this.f76165s);
        intent.putExtra("friendUin", this.f76135h);
        intent.setPackage(this.f76128a.getApp().getPackageName());
        this.f76128a.getApp().sendBroadcast(intent);
        if (QLog.isDevelopLevel()) {
            QLog.d("GaInviteFloatBarUICtr", 2, "sendBroadcast, qav_gaudio_join");
        }
        if (i3 == 1) {
            str = "tip_in";
        } else {
            str = "tip_no";
        }
        ReportController.o(null, "dc00899", "Grp_video", "", "invite", str, 0, 0, String.valueOf(n.e().f().P0), this.f76164r + "", "", "");
        return true;
    }

    public int s(long j3, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.w("GaInviteFloatBarUICtr", 1, "onStartCommand, seq[" + j3 + "]");
            com.tencent.av.utils.e.m("VideoInviteFloatBarUICtr.onStartCommand", intent.getExtras());
        }
        this.f76133f = intent.getIntExtra("uinType", 0);
        this.f76134g = intent.getIntExtra("relationType", 0);
        if (AVUtil.o(this.f76133f)) {
            this.f76135h = intent.getLongExtra("friendUin", 0L);
            this.f76165s = intent.getStringExtra("inviteId");
            this.f76129b = intent.getLongExtra("discussId", 0L);
            this.f76164r = intent.getIntExtra("memberType", -1);
            this.f76136i = intent.getLongArrayExtra("memberList");
            this.f76138k = intent.getStringExtra("peerUin");
            this.f76128a.addObserver(this.f76171y);
            this.f76128a.addObserver(this.f76170x);
            String b16 = n.b(this.f76134g, String.valueOf(this.f76129b), new int[0]);
            if (n.e().j(b16)) {
                this.f76137j = n.e().i(b16);
            } else {
                this.f76137j = n.e().f();
            }
            v();
            int i3 = this.f76134g == 1 ? 10 : 1;
            long c06 = r.h0().c0(this.f76134g, i3, this.f76129b);
            if (c06 > 0) {
                r.h0().l0().m(this.f76129b, c06, true);
            }
            o(i3);
        }
        if (this.f76137j == null) {
            return 2;
        }
        QLog.w("GaInviteFloatBarUICtr", 1, "onStartCommand[" + AVUtil.o(this.f76133f) + "], UinType[" + this.f76133f + "], InviteListSize[" + this.f76136i.length + "], isDoubleVideoMeeting[" + this.f76137j.f73060o0 + "], SessionState[" + this.f76137j.f73043k + "], SessionStatus[" + this.f76137j.f73025g + "], isInMeetingRoom[" + this.f76137j.f73064p0 + "], Original[" + this.f76137j.f73042j2 + "], session[" + this.f76137j + "]");
        return 2;
    }
}
