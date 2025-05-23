package com.tencent.av.ui.part.mav;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.InviteMemberObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.e;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.m;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.y;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import mw.f;
import mw.i;
import mw.j;
import tencent.im.s2c.msgtype0x210.submsgtype0x116.submsgtype0x116$MsgBody;

/* loaded from: classes32.dex */
public class AVMemberListUIPart extends Part {

    /* renamed from: d, reason: collision with root package name */
    MultiMembersAudioUI f76545d = null;

    /* renamed from: e, reason: collision with root package name */
    ArrayList<e> f76546e = null;

    /* renamed from: f, reason: collision with root package name */
    Runnable f76547f = null;

    /* renamed from: h, reason: collision with root package name */
    final QavUpdateAvatarViewHelper f76548h = new QavUpdateAvatarViewHelper();

    /* renamed from: i, reason: collision with root package name */
    y f76549i = new a();

    /* renamed from: m, reason: collision with root package name */
    private ew.b f76550m = new b();
    private InviteMemberObserver C = new InviteMemberObserver() { // from class: com.tencent.av.ui.part.mav.AVMemberListUIPart.5
        @Override // com.tencent.av.app.InviteMemberObserver
        protected void c(long j3, long j16, ArrayList<e> arrayList) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.part.mav.AVMemberListUIPart.5.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AVMemberListUIPart.this.F9() != null && AVMemberListUIPart.this.F9().size() != 0) {
                        AVMemberListUIPart.this.C9(-1017L, "InviteMemberObserver");
                    } else {
                        QLog.d("AVMemberListUIPart", 1, "InviteMemberObserver null");
                    }
                }
            });
        }
    };
    private BroadcastReceiver D = new c();

    /* loaded from: classes32.dex */
    class RefreshFaceRunnable implements Runnable {
        RefreshFaceRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiMembersAudioUI multiMembersAudioUI = AVMemberListUIPart.this.f76545d;
            if (multiMembersAudioUI != null) {
                multiMembersAudioUI.o();
            }
            AVMemberListUIPart.this.getMainHandler().postDelayed(this, 2000L);
        }
    }

    /* loaded from: classes32.dex */
    class b implements ew.b {
        b() {
        }

        @Override // ew.b
        public void D1(ew.a aVar, Drawable drawable) {
            if (n.e().f().P()) {
                return;
            }
            View partRootView = AVMemberListUIPart.this.getPartRootView();
            if (partRootView == null) {
                QLog.e("AVMemberListUIPart", 1, "onGetFaceDrawable rootView is null.");
                return;
            }
            RelativeLayout relativeLayout = (RelativeLayout) partRootView.findViewById(R.id.g8b);
            if (relativeLayout != null) {
                relativeLayout.setBackground(drawable);
            } else {
                QLog.e("AVMemberListUIPart", 1, "onGetFaceDrawable background is null.");
            }
            View findViewById = partRootView.findViewById(R.id.f30100nf);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("AVMemberListUIPart", 1, "onGetFaceDrawable setbackground");
            }
        }
    }

    /* loaded from: classes32.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            long longExtra = intent.getLongExtra("groupId", 0L);
            long longExtra2 = intent.getLongExtra("roomId", 0L);
            long g06 = r.h0().g0();
            long j3 = n.e().f().P0;
            boolean z16 = j3 == longExtra;
            boolean z17 = g06 == longExtra2;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleMsgType0x210SuMsgType0x116 mMemberChangeEventReceiver fit=");
                sb5.append(z16 && z17);
                sb5.append(";current roomId=");
                sb5.append(g06);
                sb5.append(";groupId=");
                sb5.append(j3);
                QLog.d("AVMemberListUIPart", 2, sb5.toString());
            }
            if ("tencent.video.q2v.GvideoMemInviteUpdate".equals(action)) {
                AVUtil.b(intent);
            }
            if (action.equalsIgnoreCase("tencent.video.q2v.GvideoMemInviteUpdate") && z16 && z17) {
                submsgtype0x116$MsgBody submsgtype0x116_msgbody = new submsgtype0x116$MsgBody();
                try {
                    submsgtype0x116_msgbody.mergeFrom(intent.getByteArrayExtra("pushData"));
                    r.h0().J3(submsgtype0x116_msgbody.rpt_msg_member_join, submsgtype0x116_msgbody.rpt_msg_member_quit, submsgtype0x116_msgbody.uint32_invite_list_total_count.get(), submsgtype0x116_msgbody.enum_event_type.get());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("AVMemberListUIPart", 2, "mMemberChangeEventReceiver throw exception");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A9(final long j3, final ArrayList<e> arrayList) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.part.mav.AVMemberListUIPart.4
            @Override // java.lang.Runnable
            public void run() {
                if (AVMemberListUIPart.this.getActivity().isDestroyed()) {
                    return;
                }
                AVMemberListUIPart.this.z9(j3, arrayList);
            }
        });
    }

    void B9() {
        long j3;
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w("AVMemberListUIPart", 1, "initViewList, seq[" + d16 + "]");
        }
        SessionInfo f16 = n.e().f();
        int i3 = f16.R0;
        if (i3 != 0 && i3 != 1) {
            j3 = r.h0().X();
        } else {
            j3 = f16.P0;
        }
        this.f76545d.i(j3, f16.S0, false);
        this.f76545d.setOnItemClickListener(this.f76549i);
        C9(d16, "initViewList");
    }

    public void C9(final long j3, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.w("AVMemberListUIPart", 1, "notifyDataChange, from[" + str + "], seq[" + j3 + "]");
        }
        final Pair<Integer, ArrayList<e>> I3 = r.h0().I3();
        if (r.h0() != null && I3.second != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.part.mav.AVMemberListUIPart.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    long j16;
                    if (r.h0() == null || I3.second == 0) {
                        return;
                    }
                    ArrayList<e> n16 = r.h0().n1(((Integer) I3.first).intValue(), (ArrayList) I3.second);
                    if (n.e().f() != null) {
                        j16 = n.e().f().P0;
                        i3 = n.e().f().S0;
                    } else {
                        i3 = -1;
                        j16 = -1;
                    }
                    if (n16 != null && !n16.isEmpty() && j16 != -1 && i3 != -1) {
                        Iterator<e> it = n16.iterator();
                        int i16 = 0;
                        while (it.hasNext()) {
                            e next = it.next();
                            if (next != null) {
                                if (i16 >= 20) {
                                    break;
                                }
                                String V = r.h0().V(String.valueOf(next.f73701a), String.valueOf(j16), i3);
                                if (TextUtils.isEmpty(V)) {
                                    V = r.h0().U(String.valueOf(next.f73701a), String.valueOf(j16), i3);
                                    i16++;
                                }
                                next.f73702b = V;
                            }
                        }
                    }
                    if (r.h0() == null) {
                        return;
                    }
                    AVMemberListUIPart.this.A9(j3, n16);
                }
            }, 16, null, false);
            return;
        }
        QLog.w("AVMemberListUIPart", 1, "notifyDataChange, return isGAudioInRoom=" + r.h0().W0());
        if (r.h0().W0()) {
            return;
        }
        e eVar = new e();
        eVar.f73701a = Long.parseLong(nw.b.b().getCurrentAccountUin());
        eVar.f73702b = nw.b.b().getCurrentNickname();
        eVar.f73724x = false;
        ArrayList<e> arrayList = new ArrayList<>();
        arrayList.add(eVar);
        A9(j3, arrayList);
    }

    public void D9() {
        VideoLayerUI videoLayerUI = ((AVActivity) getActivity()).J0;
        if (videoLayerUI != null) {
            videoLayerUI.G2(this.f76546e);
        }
    }

    public void E9(long j3, boolean z16) {
        MultiMembersAudioUI multiMembersAudioUI = this.f76545d;
        if (multiMembersAudioUI != null) {
            multiMembersAudioUI.l(j3, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("AVMemberListUIPart", 2, "notifyMemberSpeak, MemberUI is null --> Uin = " + j3 + " , Speak = " + z16);
        }
    }

    ArrayList<e> F9() {
        if (r.h0() != null) {
            return r.h0().Y();
        }
        return null;
    }

    public void G9() {
        String str;
        AVPhoneUserInfo.TelInfo telInfo;
        ArrayList<e> arrayList = this.f76546e;
        if (arrayList == null || arrayList.size() == 0 || getPartRootView() == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) getPartRootView().findViewById(R.id.g8b);
        if (n.e().f().f73035i == 3) {
            e eVar = this.f76546e.get(0);
            String valueOf = String.valueOf(eVar.f73701a);
            AVPhoneUserInfo aVPhoneUserInfo = eVar.f73716p;
            if (aVPhoneUserInfo == null || (telInfo = aVPhoneUserInfo.telInfo) == null) {
                str = "";
            } else {
                str = telInfo.mobile;
            }
            VideoAppInterface b16 = nw.b.b();
            this.f76548h.i(b16, new ew.a(0, valueOf, "", false), b16.J(0, valueOf, str, false, false), this.f76550m);
            return;
        }
        View findViewById = getPartRootView().findViewById(R.id.f30100nf);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (relativeLayout != null) {
            relativeLayout.setBackground(null);
        }
    }

    public void H9(long j3, boolean z16) {
        this.f76545d.p(j3, 0, 0, z16);
        VideoLayerUI videoLayerUI = ((AVActivity) getActivity()).J0;
        if (videoLayerUI != null) {
            videoLayerUI.V2(j3, z16);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f76545d = (MultiMembersAudioUI) view.findViewById(m.d.f76005c);
        B9();
        if (com.tencent.av.utils.e.e(0) == 1) {
            this.f76545d.setBackgroundColor(531496751);
        }
        nw.b.b().addObserver(this.C);
        getActivity().registerReceiver(this.D, new IntentFilter("tencent.video.q2v.GvideoMemInviteUpdate"));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.f76545d = null;
        getMainHandler().removeCallbacks(this.f76547f);
        this.f76547f = null;
        ArrayList<e> arrayList = this.f76546e;
        if (arrayList != null) {
            arrayList.clear();
            this.f76546e = null;
        }
        if (getActivity() != null) {
            getActivity().unregisterReceiver(this.D);
        }
        nw.b.b().deleteObserver(this.C);
    }

    public void onResume() {
        if (this.f76547f == null) {
            this.f76547f = new RefreshFaceRunnable();
            getMainHandler().postDelayed(this.f76547f, 2000L);
        }
    }

    void z9(long j3, ArrayList<e> arrayList) {
        float f16;
        float f17;
        if (getActivity().isDestroyed()) {
            return;
        }
        int size = arrayList == null ? 0 : arrayList.size();
        if (QLog.isDevelopLevel()) {
            QLog.w("AVMemberListUIPart", 1, "doInternalUIFreash, gaFList[" + size + "], seq[" + j3 + "]");
        }
        f fVar = (f) RFWIocAbilityProvider.g().getIocInterface(f.class, getPartRootView(), null);
        if (fVar != null) {
            fVar.c2(j3, size <= 1 ? R.string.dcj : 0);
        }
        int screenHeight = ba.getScreenHeight(getActivity());
        if (size <= 3) {
            f16 = screenHeight;
            f17 = 0.29f;
        } else {
            f16 = screenHeight;
            f17 = 0.21f;
        }
        int i3 = (int) (f16 * f17);
        MultiMembersAudioUI multiMembersAudioUI = this.f76545d;
        if (multiMembersAudioUI != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) multiMembersAudioUI.getLayoutParams();
            if (marginLayoutParams.topMargin != i3) {
                marginLayoutParams.topMargin = i3;
                this.f76545d.requestLayout();
            }
            TextView textView = (TextView) getPartRootView().findViewById(m.h.f76035a);
            if (textView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                if (marginLayoutParams2.topMargin != i3 - BaseAIOUtils.f(56.0f, textView.getResources())) {
                    marginLayoutParams2.topMargin = i3 - BaseAIOUtils.f(56.0f, textView.getResources());
                    textView.requestLayout();
                }
            }
            this.f76545d.m(arrayList);
            ((i) RFWIocAbilityProvider.g().getIocInterface(i.class, getPartRootView(), null)).p();
        }
        AVActivity aVActivity = (AVActivity) getActivity();
        VideoLayerUI videoLayerUI = aVActivity.J0;
        if (videoLayerUI != null) {
            videoLayerUI.G2(arrayList);
        } else {
            aVActivity.V3();
        }
        ArrayList<e> arrayList2 = this.f76546e;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.f76546e = new ArrayList<>();
        }
        this.f76546e.addAll(arrayList);
        G9();
    }

    /* loaded from: classes32.dex */
    class a implements y {
        a() {
        }

        @Override // com.tencent.av.utils.y
        public void a() {
            ((j) RFWIocAbilityProvider.g().getIocInterface(j.class, AVMemberListUIPart.this.getPartRootView(), null)).resetToolBarTimer(com.tencent.av.utils.e.d());
        }

        @Override // com.tencent.av.utils.y
        public void b(long j3, int i3, int i16, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("AVMemberListUIPart", 2, "MultiVideoMembersClickListener , Uin = " + j3 + " , videoScr = " + i3 + " , isNeedRequest " + z16 + " , positon = " + i16);
            }
            nw.b.b().k0(new Object[]{110, Long.valueOf(com.tencent.av.utils.e.d())});
            if (i16 == 7 && z16) {
                c();
            }
        }

        private void c() {
            AVActivity aVActivity = (AVActivity) AVMemberListUIPart.this.getActivity();
            if (aVActivity != null) {
                VideoMsgTools.x(aVActivity, String.valueOf(n.e().f().P0), n.e().f().f73037i1 || n.e().f().f73041j1, true);
                ReportController.o(null, "CliOper", "", "", "0X8009E27", "0X8009E27", 0, 0, "", "", "", "");
            } else if (QLog.isColorLevel()) {
                QLog.e("AVMemberListUIPart", 2, "startMembersListViewPage-->can not get activity");
            }
        }
    }

    public void I9(int i3) {
        if (i3 == 4) {
            this.f76545d.setVisibility(8);
        } else {
            this.f76545d.setVisibility(0);
        }
    }
}
