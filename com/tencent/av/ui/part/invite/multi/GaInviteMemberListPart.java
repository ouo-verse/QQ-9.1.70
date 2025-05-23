package com.tencent.av.ui.part.invite.multi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.tencent.av.app.InviteMemberObserverWithoutCache;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.e;
import com.tencent.av.r;
import com.tencent.av.ui.MutiMemberThumbList;
import com.tencent.av.utils.AVUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116$MemberInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116$MsgBody;

/* loaded from: classes32.dex */
public class GaInviteMemberListPart extends Part {
    private long C;

    /* renamed from: e, reason: collision with root package name */
    private MqqHandler f76492e;

    /* renamed from: i, reason: collision with root package name */
    private long f76495i;

    /* renamed from: m, reason: collision with root package name */
    private int f76496m;

    /* renamed from: d, reason: collision with root package name */
    private MutiMemberThumbList f76491d = null;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<com.tencent.av.gaudio.a> f76493f = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private long f76494h = 0;
    private boolean D = false;
    private View E = null;
    private InviteMemberObserverWithoutCache F = new InviteMemberObserverWithoutCache() { // from class: com.tencent.av.ui.part.invite.multi.GaInviteMemberListPart.1
        @Override // com.tencent.av.app.InviteMemberObserverWithoutCache
        protected void c(long j3, long j16, final ArrayList<com.tencent.av.gaudio.a> arrayList) {
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteMemberListPart", 2, "onReceiveMemberList mMemberChangeEventReceiver size:" + arrayList.size());
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.part.invite.multi.GaInviteMemberListPart.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GaInviteMemberListPart.this.f76491d != null) {
                        GaInviteMemberListPart.this.f76493f.clear();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            com.tencent.av.gaudio.a aVar = (com.tencent.av.gaudio.a) it.next();
                            if (aVar.f73825a != GaInviteMemberListPart.this.C) {
                                GaInviteMemberListPart.this.f76493f.add(aVar);
                            }
                        }
                        GaInviteMemberListPart.this.K9("InviteMemberObserverWithoutCache" + GaInviteMemberListPart.this.f76493f.size());
                    }
                }
            });
        }
    };
    private Runnable G = new Runnable() { // from class: com.tencent.av.ui.part.invite.multi.GaInviteMemberListPart.2
        @Override // java.lang.Runnable
        public void run() {
            if (GaInviteMemberListPart.this.f76492e == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteMemberListPart", 2, "mTaskCheckRunnable before" + GaInviteMemberListPart.this.D + ";currentMemberSize=" + GaInviteMemberListPart.this.f76493f.size());
            }
            if (GaInviteMemberListPart.this.D) {
                long e16 = QQAudioHelper.e() / 1000;
                ArrayList arrayList = new ArrayList();
                Iterator it = GaInviteMemberListPart.this.f76493f.iterator();
                while (it.hasNext()) {
                    com.tencent.av.gaudio.a aVar = (com.tencent.av.gaudio.a) it.next();
                    if (aVar.f73826b + 60 > e16) {
                        arrayList.add(aVar);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("GaInviteMemberListPart", 2, "mTaskCheckRunnable " + aVar.f73826b + ";otherTimestamp=" + e16);
                    }
                }
                GaInviteMemberListPart.this.f76493f = arrayList;
            }
            GaInviteMemberListPart.this.f76492e.postDelayed(GaInviteMemberListPart.this.G, 10000L);
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteMemberListPart", 2, "mTaskCheckRunnable after" + GaInviteMemberListPart.this.D + ";currentMemberSize=" + GaInviteMemberListPart.this.f76493f.size());
            }
        }
    };
    private boolean H = false;
    private BroadcastReceiver I = new a();

    public GaInviteMemberListPart(int i3, long j3, long j16) {
        this.f76495i = 0L;
        this.f76496m = 0;
        this.C = 0L;
        this.f76496m = i3;
        this.f76495i = j3;
        this.C = j16;
        QLog.d("GaInviteMemberListPart", 1, "constructor relationType=" + i3 + " groupId=" + j3 + " inviterUin=" + j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K9(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("GaInviteMemberListPart", 2, "notifyDataChange mHasCallFromMemberList:=" + this.D + ":from=" + str);
        }
        M9();
        ArrayList<e> B0 = r.h0().B0();
        final ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator<e> it = B0.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f73701a != this.C) {
                arrayList.add(next);
            }
            hashSet.add(Long.valueOf(next.f73701a));
        }
        final int size = arrayList.size();
        Iterator<com.tencent.av.gaudio.a> it5 = this.f76493f.iterator();
        while (it5.hasNext()) {
            com.tencent.av.gaudio.a next2 = it5.next();
            if (!hashSet.contains(Long.valueOf(next2.f73825a))) {
                e eVar = new e();
                eVar.f73701a = next2.f73825a;
                eVar.f73725y = next2.f73826b;
                if (nw.b.b() != null && next2.f73825a == nw.b.b().getLongAccountUin()) {
                    arrayList.add(0, eVar);
                    size++;
                } else {
                    arrayList.add(eVar);
                }
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.part.invite.multi.GaInviteMemberListPart.4
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList<e> n16 = r.h0().n1(size, arrayList);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.part.invite.multi.GaInviteMemberListPart.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GaInviteMemberListPart.this.getActivity() == null || GaInviteMemberListPart.this.getActivity().isDestroyed() || GaInviteMemberListPart.this.f76491d == null) {
                            return;
                        }
                        GaInviteMemberListPart.this.f76491d.setDisPlayList(n16);
                    }
                });
            }
        }, 16, null, false);
    }

    private void M9() {
        MqqHandler mqqHandler = this.f76492e;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacks(this.G);
            this.f76492e.postDelayed(this.G, 10000L);
        }
    }

    public void I9(int i3) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        boolean d06 = r.h0().d0(this.f76496m, this.f76495i, i3);
        if (QLog.isColorLevel()) {
            QLog.d("GaInviteMemberListPart", 2, "getGAudioRoomMemList " + d06);
        }
        if (d06) {
            return;
        }
        QQToast.makeText(context, HardCodeUtil.qqStr(R.string.mve), 1).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public void J9(long j3, ArrayList<e> arrayList, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("GaInviteMemberListPart", 2, "handleMemberListUpdate");
        }
        if (j3 == this.f76495i) {
            if (i3 == 10 || i3 == 1) {
                this.D = true;
                K9("handleMemberListUpdate");
            }
        }
    }

    public void L9(View view) {
        this.E = view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        QLog.d("GaInviteMemberListPart", 1, "onInitView mRootView=" + this.E + " rootView=" + view);
        this.f76492e = ThreadManager.getUIHandler();
        View view2 = this.E;
        if (view2 != null) {
            view = view2;
        }
        MutiMemberThumbList mutiMemberThumbList = (MutiMemberThumbList) view.findViewById(R.id.gas);
        this.f76491d = mutiMemberThumbList;
        if (mutiMemberThumbList != null) {
            mutiMemberThumbList.setRelationShipInfo(this.f76495i, this.f76496m);
            this.f76491d.setMoreInfoDrawableColor("#4C000000");
            this.f76491d.setDisPlayList(null);
            int i3 = this.f76496m == 1 ? 10 : 1;
            long c06 = r.h0().c0(this.f76496m, i3, this.f76495i);
            this.f76494h = c06;
            if (c06 > 0) {
                r.h0().l0().m(this.f76495i, this.f76494h, true);
            }
            I9(i3);
        } else {
            QLog.d("GaInviteMemberListPart", 1, "can not find InviteList view.");
        }
        if (nw.b.b() != null) {
            nw.b.b().addObserver(this.F);
        }
        if (getActivity() != null) {
            getActivity().registerReceiver(this.I, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
            this.H = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (getActivity() != null && this.H) {
            getActivity().unregisterReceiver(this.I);
            this.I = null;
            this.H = false;
        }
        MutiMemberThumbList mutiMemberThumbList = this.f76491d;
        if (mutiMemberThumbList != null) {
            mutiMemberThumbList.h();
            this.f76491d = null;
        }
        MqqHandler mqqHandler = this.f76492e;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacks(this.G);
            this.f76492e = null;
        }
        this.f76493f.clear();
        this.f76493f = null;
        if (nw.b.b() != null) {
            nw.b.b().deleteObserver(this.F);
        }
        this.E = null;
    }

    /* loaded from: classes32.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i3;
            boolean z16;
            int i16;
            int i17;
            int i18;
            VideoAppInterface videoAppInterface;
            String action = intent.getAction();
            boolean z17 = GaInviteMemberListPart.this.f76495i == intent.getLongExtra("groupId", 0L) && GaInviteMemberListPart.this.f76494h == intent.getLongExtra("roomId", 0L);
            if (QLog.isColorLevel()) {
                QLog.d("GaInviteMemberListPart", 2, "handleMsgType0x210SuMsgType0x116 mMemberChangeEventReceiver fit=" + z17 + ";current roomId=" + GaInviteMemberListPart.this.f76494h + ";groupId=" + GaInviteMemberListPart.this.f76495i);
            }
            if ("tencent.video.q2v.GvideoMemInviteUpdate".equals(action)) {
                AVUtil.b(intent);
            }
            if (action.equalsIgnoreCase("tencent.video.q2v.GvideoMemInviteUpdate") && z17) {
                submsgtype0x116$MsgBody submsgtype0x116_msgbody = new submsgtype0x116$MsgBody();
                try {
                    submsgtype0x116_msgbody.mergeFrom(intent.getByteArrayExtra("pushData"));
                    HashSet hashSet = new HashSet();
                    Iterator it = GaInviteMemberListPart.this.f76493f.iterator();
                    while (it.hasNext()) {
                        hashSet.add(Long.valueOf(((com.tencent.av.gaudio.a) it.next()).f73825a));
                    }
                    int i19 = submsgtype0x116_msgbody.enum_event_type.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("GaInviteMemberListPart", 2, "mMemberChangeEventReceiver before totalCount:" + submsgtype0x116_msgbody.uint32_invite_list_total_count.get() + ";currentInviteMembers=" + GaInviteMemberListPart.this.f76493f.size());
                    }
                    VideoAppInterface b16 = nw.b.b();
                    if (b16 != null) {
                        int i26 = 0;
                        z16 = false;
                        while (i26 < submsgtype0x116_msgbody.rpt_msg_member_join.size()) {
                            submsgtype0x116$MemberInfo submsgtype0x116_memberinfo = submsgtype0x116_msgbody.rpt_msg_member_join.get(i26);
                            long j3 = submsgtype0x116_memberinfo.uint64_member_uin.get();
                            boolean z18 = (j3 == b16.getLongAccountUin() || j3 == GaInviteMemberListPart.this.C) ? false : true;
                            if (hashSet.contains(Long.valueOf(j3)) || !z18) {
                                i18 = i19;
                                videoAppInterface = b16;
                            } else {
                                i18 = i19;
                                videoAppInterface = b16;
                                GaInviteMemberListPart.this.f76493f.add(new com.tencent.av.gaudio.a(submsgtype0x116_memberinfo.uint64_member_uin.get(), submsgtype0x116_memberinfo.uint32_invite_timestamp.get()));
                                if (QLog.isColorLevel()) {
                                    QLog.d("GaInviteMemberListPart", 2, "mMemberChangeEventReceiver add member UIN:" + j3);
                                }
                                z16 = true;
                            }
                            i26++;
                            i19 = i18;
                            b16 = videoAppInterface;
                        }
                        i3 = i19;
                    } else {
                        i3 = i19;
                        z16 = false;
                    }
                    int i27 = 0;
                    while (i27 < submsgtype0x116_msgbody.rpt_msg_member_quit.size()) {
                        long j16 = submsgtype0x116_msgbody.rpt_msg_member_quit.get(i27).uint64_member_uin.get();
                        Iterator it5 = GaInviteMemberListPart.this.f76493f.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                i16 = i3;
                                break;
                            }
                            com.tencent.av.gaudio.a aVar = (com.tencent.av.gaudio.a) it5.next();
                            if (aVar.f73825a == j16) {
                                GaInviteMemberListPart.this.f76493f.remove(aVar);
                                if (QLog.isColorLevel()) {
                                    i17 = 2;
                                    QLog.d("GaInviteMemberListPart", 2, "mMemberChangeEventReceiver remove member UIN:" + aVar.f73825a);
                                } else {
                                    i17 = 2;
                                }
                                i16 = i3;
                                if (i16 != i17) {
                                    z16 = true;
                                }
                            }
                        }
                        i27++;
                        i3 = i16;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("GaInviteMemberListPart", 2, "mMemberChangeEventReceiver after totalCount:" + submsgtype0x116_msgbody.uint32_invite_list_total_count.get() + ";currentInviteMembers=" + GaInviteMemberListPart.this.f76493f.size() + ";eventType=" + submsgtype0x116_msgbody.enum_event_type.get());
                    }
                    if (z16) {
                        GaInviteMemberListPart.this.K9("mMemberChangeEventReceiver");
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("GaInviteMemberListPart", 2, "mMemberChangeEventReceiver throw exception");
                    }
                }
            }
        }
    }
}
