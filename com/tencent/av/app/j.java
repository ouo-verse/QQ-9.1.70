package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.utils.at;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.utils.cp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: d, reason: collision with root package name */
    public static String f73170d = "GAudioMsgReceiver";

    /* renamed from: a, reason: collision with root package name */
    VideoAppInterface f73171a;

    /* renamed from: b, reason: collision with root package name */
    a f73172b;

    /* renamed from: c, reason: collision with root package name */
    boolean f73173c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        VideoAppInterface f73174a;

        a(VideoAppInterface videoAppInterface) {
            this.f73174a = videoAppInterface;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            if (intent == null || intent.getAction() == null) {
                return;
            }
            if (com.tencent.av.r.h0() != null && this.f73174a != null) {
                if (QLog.isColorLevel()) {
                    QLog.w(j.f73170d, 1, "GAudioMsgReceiver_onReceive[" + intent.getAction() + "]");
                }
                if (intent.getAction().equals("tencent.video.q2v.GvideoMemUntInvite")) {
                    this.f73174a.k0(new Object[]{513, Long.valueOf(intent.getLongExtra("groupId", 0L)), Long.valueOf(intent.getLongExtra("dealMemUin", 0L)), intent.getStringExtra("invitedId")});
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.close_invite_msg_box_by_invite_id")) {
                    this.f73174a.k0(new Object[]{516, Long.valueOf(intent.getLongExtra("groupId", 0L)), intent.getStringExtra("inviteId")});
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.MultiVideo")) {
                    int intExtra = intent.getIntExtra("type", -1);
                    if (QLog.isColorLevel()) {
                        QLog.d(j.f73170d, 2, "GAudioMsgReceiver type: " + intExtra);
                    }
                    if (intExtra == 26) {
                        long longExtra = intent.getLongExtra("discussId", 0L);
                        if (com.tencent.av.r.h0().W0() && com.tencent.av.r.h0().X() == longExtra) {
                            Intent intent2 = new Intent();
                            intent2.setAction("tencent.av.v2q.MultiVideo");
                            intent2.putExtra("type", 25);
                            intent2.putExtra("relationId", longExtra);
                            intent2.putExtra("relationType", 2);
                            intent2.putExtra("from", "VideoAppInterface1");
                            intent2.setPackage(this.f73174a.getApp().getPackageName());
                            this.f73174a.getApp().sendBroadcast(intent2);
                            com.tencent.av.r.h0().a2(com.tencent.av.r.h0().b0(), com.tencent.av.r.h0().X(), 88);
                            this.f73174a.k0(new Object[]{66, Long.valueOf(longExtra)});
                            return;
                        }
                        return;
                    }
                    if (intExtra == 27) {
                        com.tencent.av.r.h0().l0().receiveMultiVideoMsg(intent.getExtras());
                        return;
                    }
                    if (intExtra == 30) {
                        com.tencent.av.r.h0().l0().receiveMultiVideoAck(intent.getExtras());
                        return;
                    }
                    if (intExtra == 24) {
                        com.tencent.av.r.h0().z1(intent.getLongExtra("discussId", 0L), intent.getStringExtra("cmdUin"), intent.getStringArrayExtra("uins"));
                        return;
                    }
                    if (intExtra != 31) {
                        if (intExtra == 34) {
                            long longExtra2 = intent.getLongExtra("relationId", 0L);
                            if (com.tencent.av.r.h0().W0() && longExtra2 == com.tencent.av.r.h0().X()) {
                                com.tencent.av.r.h0().a2(1, longExtra2, 76);
                                Intent intent3 = new Intent();
                                intent3.setAction("tencent.av.v2q.MultiVideo");
                                intent3.putExtra("MultiAVType", com.tencent.av.n.e().f().f73063p);
                                intent3.putExtra("type", 25);
                                intent3.putExtra("relationId", longExtra2);
                                intent3.putExtra("relationType", 1);
                                intent3.putExtra("from", "VideoAppInterface3");
                                intent3.setPackage(this.f73174a.getApp().getPackageName());
                                this.f73174a.getApp().sendBroadcast(intent3);
                                return;
                            }
                            return;
                        }
                        if (intExtra == 35 && com.tencent.av.r.h0().W0()) {
                            com.tencent.av.r.h0().p1();
                            return;
                        }
                        return;
                    }
                    long longExtra3 = intent.getLongExtra("discussId", 0L);
                    String stringExtra = intent.getStringExtra("cmdUin");
                    String[] stringArrayExtra = intent.getStringArrayExtra("uins");
                    if (stringArrayExtra != null && stringArrayExtra.length != 0) {
                        String str2 = stringArrayExtra[0];
                        String currentAccountUin = this.f73174a.getCurrentAccountUin();
                        if (QLog.isColorLevel()) {
                            QLog.d(j.f73170d, 2, "TYPE_GAUDIO_MEMBER_KICKOUT-->discuss id = " + longExtra3 + ", cmdUin = " + stringExtra + ", outUin = " + str2 + ", selfUin = " + currentAccountUin + ", uinList.size = " + stringArrayExtra.length);
                        }
                        if (com.tencent.av.r.h0().W0() && com.tencent.av.r.h0().X() == longExtra3 && str2.compareTo(currentAccountUin) == 0) {
                            com.tencent.av.r.h0().a2(com.tencent.av.r.h0().b0(), com.tencent.av.r.h0().X(), 75);
                            Intent intent4 = new Intent();
                            intent4.setAction("tencent.av.v2q.MultiVideo");
                            intent4.putExtra("type", 25);
                            intent4.putExtra("relationId", longExtra3);
                            intent4.putExtra("relationType", 2);
                            intent4.putExtra("from", "VideoAppInterface2");
                            intent4.setPackage(this.f73174a.getApp().getPackageName());
                            this.f73174a.getApp().sendBroadcast(intent4);
                            return;
                        }
                        if (com.tencent.av.n.e().f().f73043k == 7 && com.tencent.av.r.h0().N() == longExtra3 && str2.compareTo(currentAccountUin) == 0) {
                            com.tencent.av.n.e().f().n0("GAudioMsgReceiver", 0);
                            this.f73174a.k0(new Object[]{67, Long.valueOf(com.tencent.av.r.h0().N()), 4});
                            com.tencent.av.r.h0().N2(0L);
                            com.tencent.av.r.h0().O2(0);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e(j.f73170d, 2, "GAudioMsgReceiver-->uinlist is null");
                        return;
                    }
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.AddDiscussMember")) {
                    if (intent.getBooleanExtra("result", false)) {
                        com.tencent.av.r.h0().x2(intent.getLongExtra("roomId", com.tencent.av.r.h0().X()), intent.getStringArrayListExtra("newMemberUin"));
                        return;
                    }
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.SwitchToMultiAudo")) {
                    if (intent.getBooleanExtra("result", false)) {
                        long longExtra4 = intent.getLongExtra("roomId", 0L);
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("memberUin");
                        int intExtra2 = intent.getIntExtra("uinType", 3000);
                        long a16 = at.a(intent);
                        long d16 = com.tencent.av.utils.e.d();
                        QLog.w(j.f73170d, 1, "switchToMultiAudio, seq[" + a16 + "], newseq[" + d16 + "], [discussion]");
                        com.tencent.av.r.h0().C3(d16, intExtra2, longExtra4, stringArrayListExtra);
                        return;
                    }
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.GroupInfoChanged")) {
                    this.f73174a.k0(new Object[]{169, cp.b.a(intent.getExtras())});
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.GroupSystemMsg")) {
                    int intExtra3 = intent.getIntExtra("type", -1);
                    int intExtra4 = intent.getIntExtra("relationType", -1);
                    long longExtra5 = intent.getLongExtra("relationId", -1L);
                    long longExtra6 = intent.getLongExtra("userUin", -1L);
                    boolean booleanExtra = intent.getBooleanExtra("needSendCmd", false);
                    if (QLog.isColorLevel()) {
                        String str3 = j.f73170d;
                        StringBuilder sb5 = new StringBuilder();
                        str = "from";
                        sb5.append("GAudioMsgReceiver_onReceive[tencent.video.q2v.GroupSystemMsg], type[");
                        sb5.append(intExtra3);
                        sb5.append("], relationType[");
                        sb5.append(intExtra4);
                        sb5.append("], relationId[");
                        sb5.append(longExtra5);
                        sb5.append("], userUin[");
                        sb5.append(longExtra6);
                        sb5.append("], needSendCmd[");
                        sb5.append(booleanExtra);
                        sb5.append("]");
                        QLog.w(str3, 1, sb5.toString());
                    } else {
                        str = "from";
                    }
                    if (intExtra3 != 7 && intExtra3 != 8) {
                        com.tencent.av.r.h0().G1(longExtra5, longExtra6, intExtra4, intExtra3, booleanExtra);
                        return;
                    }
                    if (com.tencent.av.r.h0().W0() && com.tencent.av.r.h0().X() == longExtra5) {
                        if (com.tencent.av.n.e().f().f73063p == 2) {
                            if (this.f73174a.m0(longExtra5 + "")) {
                                return;
                            }
                        }
                        com.tencent.av.r.h0().a2(1, longExtra5, 77);
                        com.tencent.av.r.h0().G1(longExtra5, longExtra6, intExtra4, intExtra3, booleanExtra);
                    }
                    Intent intent5 = new Intent();
                    intent5.setAction("tencent.av.v2q.MultiVideo");
                    intent5.putExtra("type", 25);
                    intent5.putExtra("relationId", longExtra5);
                    intent5.putExtra("relationType", intExtra4);
                    intent5.putExtra("MultiAVType", com.tencent.av.n.e().f().f73063p);
                    if (intExtra3 == 7) {
                        intent5.putExtra("reason", 4);
                    } else {
                        intent5.putExtra("reason", 8);
                    }
                    intent5.putExtra(str, "VideoAppInterface4");
                    intent5.setPackage(this.f73174a.getApp().getPackageName());
                    this.f73174a.getApp().sendBroadcast(intent5);
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.SelectMember")) {
                    if (QLog.isColorLevel()) {
                        QLog.d(j.f73170d, 2, "ACTION_SELECT_MEMBER");
                    }
                    int intExtra5 = intent.getIntExtra("InviteCount", 0);
                    String stringExtra2 = intent.getStringExtra("FirstName");
                    if (QLog.isColorLevel()) {
                        QLog.d(j.f73170d, 2, "ACTION_SELECT_MEMBER --> InviteCount = " + intExtra5 + " , FirstName = " + stringExtra2);
                    }
                    if (intExtra5 <= 0 || com.tencent.av.r.h0() == null) {
                        return;
                    }
                    com.tencent.av.r.h0().H1(intExtra5, stringExtra2);
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED")) {
                    com.tencent.av.r.h0().k3(intent.getBooleanExtra("isResume", false));
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.GvideoGift")) {
                    int intExtra6 = intent.getIntExtra("type", -1);
                    long longExtra7 = intent.getLongExtra("fromUin", -1L);
                    long longExtra8 = intent.getLongExtra("toUin", -1L);
                    int intExtra7 = intent.getIntExtra("count", -1);
                    long longExtra9 = intent.getLongExtra("seq", -1L);
                    long longExtra10 = intent.getLongExtra("groupId", -1L);
                    if (intExtra6 <= 0 || longExtra7 <= 0 || longExtra8 <= 0 || intExtra7 <= 0 || longExtra10 <= 0 || com.tencent.av.r.h0() == null) {
                        return;
                    }
                    com.tencent.av.r.h0().E1(intExtra6, longExtra7, longExtra8, intExtra7, longExtra9, longExtra10);
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.GvideoLevelUpgrade")) {
                    int intExtra8 = intent.getIntExtra("type", -1);
                    long longExtra11 = intent.getLongExtra("fromUin", -1L);
                    long longExtra12 = intent.getLongExtra("toUin", -1L);
                    int intExtra9 = intent.getIntExtra("enable", -1);
                    int intExtra10 = intent.getIntExtra("level", -1);
                    long longExtra13 = intent.getLongExtra("seq", -1L);
                    long longExtra14 = intent.getLongExtra("groupId", -1L);
                    if (intExtra8 <= 0 || longExtra11 <= 0 || longExtra12 <= 0 || intExtra10 <= 0 || longExtra14 <= 0 || com.tencent.av.r.h0() == null) {
                        return;
                    }
                    com.tencent.av.r.h0().F1(intExtra8, longExtra11, longExtra12, intExtra9, intExtra10, longExtra13, longExtra14);
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.AudioTransPush")) {
                    if (com.tencent.av.r.h0() != null && com.tencent.av.n.e().f() != null) {
                        int intExtra11 = intent.getIntExtra("rsptype", 0);
                        byte[] byteArrayExtra = intent.getByteArrayExtra("rspbody");
                        QLog.d(j.f73170d, 2, "ACTION_AUDIO_TRANS_PUSH rsptype=" + intExtra11 + "|" + byteArrayExtra.length);
                        return;
                    }
                    if (com.tencent.av.n.e().f() == null) {
                        AVCoreLog.printErrorLog(j.f73170d, " ACTION_AUDIO_TRANS_PUSH SessionMgr.getInstance().getMainSession() == null");
                        return;
                    }
                    return;
                }
                if (intent.getAction().equals("tencent.video.q2v.avreportOnlinePush")) {
                    if (com.tencent.av.r.h0() != null && com.tencent.av.n.e().f() != null) {
                        int intExtra12 = intent.getIntExtra("rsptype", 0);
                        if (intExtra12 == 1) {
                            zv.a.c(this.f73174a, intExtra12, intent.getStringExtra("rspbody"));
                            return;
                        }
                        return;
                    }
                    if (com.tencent.av.n.e().f() == null) {
                        AVCoreLog.printErrorLog(j.f73170d, "ACTION_AV_REPORT_PUSH SessionMgr.getInstance().getMainSession() == null");
                        return;
                    }
                    return;
                }
                if ("tencent.video.q2v.AudioEngineReady".equals(intent.getAction())) {
                    long longExtra15 = intent.getLongExtra("c2cuin", 0L);
                    long longExtra16 = intent.getLongExtra("c2croomid", 0L);
                    QLog.d(j.f73170d, 1, "ACTION_OPPOSITE_AUDIO_ENGINE_READY:" + longExtra15 + "|" + longExtra16);
                    if (longExtra15 == 0 || longExtra16 == 0) {
                        return;
                    }
                    com.tencent.av.r.h0().L1(longExtra15, longExtra16);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(j.f73170d, 2, " onReceive: " + intent.getAction());
            }
        }
    }

    public j(VideoAppInterface videoAppInterface) {
        this.f73171a = videoAppInterface;
        this.f73172b = new a(videoAppInterface);
    }

    public void a() {
        if (QLog.isColorLevel()) {
            QLog.d(f73170d, 2, "regist QQGAudioMsg Receiver");
        }
        IntentFilter intentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
        intentFilter.addAction("tencent.video.q2v.AddDiscussMember");
        intentFilter.addAction("tencent.video.q2v.SwitchToMultiAudo");
        intentFilter.addAction("tencent.video.q2v.GroupSystemMsg");
        intentFilter.addAction("tencent.video.q2v.SelectMember");
        intentFilter.addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
        intentFilter.addAction("tencent.video.q2v.GvideoGift");
        intentFilter.addAction("tencent.video.q2v.GvideoLevelUpgrade");
        intentFilter.addAction("tencent.video.q2v.GvideoMemUntInvite");
        intentFilter.addAction("tencent.video.q2v.close_invite_msg_box_by_invite_id");
        intentFilter.addAction("tencent.video.q2v.randomMultiOwnerOnlinePush");
        intentFilter.addAction("tencent.video.q2v.random1V1OnlinePush");
        intentFilter.addAction("tencent.video.q2v.avreportOnlinePush");
        intentFilter.addAction("tencent.video.q2v.AudioTransPush");
        intentFilter.addAction("tencent.video.q2v.AudioEngineReady");
        intentFilter.addAction("tencent.video.q2v.GroupInfoChanged");
        if (this.f73171a.getApplication().registerReceiver(this.f73172b, intentFilter) != null) {
            this.f73173c = true;
        }
    }

    public void b() {
        if (this.f73173c) {
            this.f73171a.getApplication().unregisterReceiver(this.f73172b);
            this.f73173c = false;
        }
    }
}
