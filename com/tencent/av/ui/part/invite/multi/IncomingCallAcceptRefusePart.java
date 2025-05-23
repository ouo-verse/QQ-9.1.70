package com.tencent.av.ui.part.invite.multi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.u;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.fragment.invite.mav.NTGaInviteBaseFragment;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.ba;
import com.tencent.av.utils.i;
import com.tencent.avcore.rtc.node.report.data.NodeModel$NodeEndReason;
import com.tencent.avcore.rtc.node.report.utils.RtcNodeReportReceiverHelper;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class IncomingCallAcceptRefusePart extends Part {
    private String C;
    private String D;
    private int E;
    private long F;
    private long[] H;
    private String I;
    private c J;

    /* renamed from: e, reason: collision with root package name */
    private SessionInfo f76506e;

    /* renamed from: f, reason: collision with root package name */
    private int f76507f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f76508h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f76509i;

    /* renamed from: m, reason: collision with root package name */
    private String f76510m;

    /* renamed from: d, reason: collision with root package name */
    private View f76505d = null;
    private boolean G = false;

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76512d;

        a(long j3) {
            this.f76512d = j3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.av.ui.part.invite.multi.c.a(2);
            IncomingCallAcceptRefusePart.this.D9(this.f76512d, "onClickIgnore", true, null, -1);
            if (IncomingCallAcceptRefusePart.this.J != null) {
                IncomingCallAcceptRefusePart.this.J.a("onClickIgnore");
            }
        }
    }

    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76514d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SessionInfo f76515e;

        b(long j3, SessionInfo sessionInfo) {
            this.f76514d = j3;
            this.f76515e = sessionInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IncomingCallAcceptRefusePart incomingCallAcceptRefusePart = IncomingCallAcceptRefusePart.this;
            incomingCallAcceptRefusePart.B9(this.f76514d, incomingCallAcceptRefusePart.getActivity() == null ? null : IncomingCallAcceptRefusePart.this.getActivity().getIntent(), this.f76515e);
        }
    }

    /* loaded from: classes32.dex */
    public interface c {
        void a(String str);
    }

    public IncomingCallAcceptRefusePart(SessionInfo sessionInfo, int i3, boolean z16, boolean z17, String str, String str2, String str3, int i16, long j3, long[] jArr, String str4) {
        this.f76506e = sessionInfo;
        this.f76507f = i3;
        this.f76508h = z16;
        this.f76509i = z17;
        this.f76510m = str;
        this.C = str2;
        this.D = str3;
        this.E = i16;
        this.F = j3;
        this.H = jArr;
        this.I = str4;
    }

    public boolean E9() {
        return this.G;
    }

    void F9(SessionInfo sessionInfo) {
        if (r.h0() == null || sessionInfo == null) {
            return;
        }
        Intent intent = new Intent();
        VideoAppInterface b16 = nw.b.b();
        if (b16 != null && b16.getApp() != null) {
            intent.setPackage(b16.getApp().getPackageName());
            intent.setAction("tencent.av.v2q.StopVideoChat");
            intent.putExtra("stopReason3rd", 1);
            intent.putExtra("groupId", sessionInfo.P0);
            intent.putExtra("peerUin", sessionInfo.f73091w);
            b16.getApp().sendBroadcast(intent);
            return;
        }
        QLog.e("IncomingCallAcceptRefusePart", 1, "notifyOtherClose error.");
    }

    public void H9(c cVar) {
        this.J = cVar;
    }

    public void I9(View view) {
        this.f76505d = view;
    }

    void K9() {
        QLog.d("IncomingCallAcceptRefusePart", 1, "startGActivity");
        Activity activity = getActivity();
        Context context = activity == null ? BaseApplication.getContext() : activity;
        Intent intent = new Intent(context, (Class<?>) AVActivity.class);
        intent.addFlags(262144);
        intent.addFlags(268435456);
        intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
        intent.putExtra("GroupId", String.valueOf(this.F));
        intent.putExtra("Type", 1);
        intent.putExtra("DiscussUinList", this.H);
        intent.putExtra("needStartTRAE", true);
        intent.putExtra("MultiAVType", this.f76506e.f73063p);
        intent.putExtra("uin", String.valueOf(this.F));
        intent.putExtra("uinType", this.f76507f);
        intent.putExtra("isFromInviteDialog", true);
        if (activity == null) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        long b16 = QQAudioHelper.b();
        Button button = (Button) this.f76505d.findViewById(R.id.gaq);
        button.setOnClickListener(new a(b16));
        SessionInfo f16 = n.e().f();
        Button button2 = (Button) this.f76505d.findViewById(R.id.gam);
        button2.setOnClickListener(new b(b16, f16));
        boolean xh5 = NTGaInviteBaseFragment.xh(this.f76507f);
        button2.setText(R.string.f171246df2);
        if (xh5) {
            button.setText(R.string.df8);
        } else {
            button.setText(R.string.df9);
        }
        if (getContext() == null) {
            QLog.d("IncomingCallAcceptRefusePart", 1, "onInitView error : context is null.");
            return;
        }
        Resources resources = getContext().getResources();
        if (resources == null) {
            QLog.d("IncomingCallAcceptRefusePart", 1, "onInitView error : res is null.");
            return;
        }
        if (!this.f76508h && !this.f76509i) {
            button2.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.qui_video_on_filled_feedback_success), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (ThemeUtil.isInNightMode(nw.b.b())) {
            int parseColor = Color.parseColor("#A8A8A8");
            this.f76505d.findViewById(xh5 ? R.id.f166581m14 : R.id.m0v).setBackgroundDrawable(resources.getDrawable(R.drawable.hj9));
            View findViewById = this.f76505d.findViewById(R.id.f166582m15);
            findViewById.setBackgroundDrawable(ba.getOvalDrawable(67.2f, getContext()));
            findViewById.setVisibility(0);
            this.f76505d.findViewById(R.id.biw).setBackgroundColor(Color.parseColor("#262626"));
            Drawable drawable = resources.getDrawable(R.drawable.f161351hs4);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            button.setCompoundDrawables(drawable, null, null, null);
            button.setCompoundDrawablePadding(0);
            button.setTextColor(parseColor);
            this.f76505d.findViewById(R.id.m17).setBackgroundColor(Color.parseColor("#262626"));
            Drawable drawable2 = resources.getDrawable(R.drawable.qui_telephone_filled_feedback_success);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            button2.setCompoundDrawables(drawable2, null, null, null);
            button2.setCompoundDrawablePadding(0);
            button2.setTextColor(parseColor);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        this.J = null;
        this.f76505d = null;
    }

    public void B9(long j3, Intent intent, SessionInfo sessionInfo) {
        cp.c.c(true);
        Activity activity = getActivity();
        if (activity == null) {
            QLog.d("IncomingCallAcceptRefusePart", 1, "doAccept error for null activity.");
            return;
        }
        activity.sendBroadcast(new Intent("com.tencent.werewoves.plugin"));
        activity.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
        activity.sendBroadcast(new Intent("tencent.video.v2g.match_friend.exit_voice_chat"));
        activity.sendBroadcast(new Intent("com.tencent.adelie.av.exit"));
        com.tencent.av.ui.part.invite.multi.c.a(1);
        if (u.d()) {
            activity.sendBroadcast(new Intent("tencent.av.EXIT_QZONE_LIVE_REQ_ACTION"));
            return;
        }
        A9(j3, "onClickAccept", intent, sessionInfo);
        if (nw.b.b() != null) {
            nw.b.b().k0(new Object[]{67, Long.valueOf(this.F), 3});
        }
        c cVar = this.J;
        if (cVar != null) {
            cVar.a("onClickAccept");
        }
    }

    void C9(long j3, int i3, long j16, boolean z16, int i16, boolean z17) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ignoreMultiCall, refuse3rd[");
        sb5.append(z17);
        sb5.append("], VideoController.getInstance()[");
        sb5.append(r.h0() != null);
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("]");
        QLog.w("IncomingCallAcceptRefusePart", 1, sb5.toString());
        if (r.h0() != null && getActivity() != null && !getActivity().isDestroyed()) {
            if (!z17) {
                r.h0().Q0(j3, i3, j16, 10, false);
            } else {
                r.h0().Q0(j3, i3, j16, i16, false);
            }
            if (!z16 || nw.b.b() == null) {
                return;
            }
            nw.b.b().k0(new Object[]{67, Long.valueOf(j16), 3});
            return;
        }
        QLog.e("IncomingCallAcceptRefusePart", 1, "ignoreMultiCall error.");
    }

    void J9(Intent intent) {
        int i3;
        byte[] bArr;
        String str;
        Activity activity;
        String str2;
        Object valueOf;
        VideoAppInterface b16 = nw.b.b();
        TraeHelper.I().F();
        if (b16 == null) {
            QLog.e("IncomingCallAcceptRefusePart", 1, "startVideoChatActivity error");
            return;
        }
        Activity activity2 = getActivity();
        QLog.d("IncomingCallAcceptRefusePart", 1, "startVideoChatActivity getAct=" + activity2 + " getContext=" + getContext() + " application=" + b16.getApplicationContext());
        if (r.h0() != null && r.h0().d1()) {
            b16.k0(new Object[]{113});
        }
        if (intent == null) {
            QLog.e("IncomingCallAcceptRefusePart", 1, "startDoubleActivity error.");
            return;
        }
        Context context = activity2 == null ? BaseApplication.getContext() : activity2;
        Intent intent2 = new Intent(context, (Class<?>) AVActivity.class);
        intent2.addFlags(262144);
        SessionInfo sessionInfo = this.f76506e;
        if (sessionInfo != null) {
            str = sessionInfo.D0;
            i3 = sessionInfo.B0;
            bArr = sessionInfo.J0;
        } else {
            i3 = -1;
            bArr = null;
            str = null;
        }
        int intExtra = intent.getIntExtra("uinType", -1);
        boolean booleanExtra = intent.getBooleanExtra("isAudioMode", false);
        Context context2 = context;
        if (this.f76509i) {
            String stringExtra = (activity2 == null || activity2.getIntent() == null) ? null : activity2.getIntent().getStringExtra("peerUin");
            intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 3);
            intent2.putExtra("Type", 1);
            intent2.putExtra("uin", stringExtra);
            intent2.putExtra("uinType", 0);
            intent2.putExtra("isDoubleVideoMeeting", true);
            intent2.putExtra("inviteUin", stringExtra);
            intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 1);
            intent2.putExtra("isSender", false);
            intent2.putExtra("isEnter", true);
            intent2.putExtra("name", this.C);
            activity = activity2;
        } else {
            activity = activity2;
            RtcNodeReportReceiverHelper.s(this.I, 1, NodeModel$NodeEndReason.K_NORMAL.ordinal());
            intent2.putExtra("uinType", intExtra);
            intent2.putExtra("bindType", i3);
            intent2.putExtra("bindId", str);
            intent2.putExtra("uin", this.f76510m);
            intent2.putExtra("name", this.C);
            intent2.putExtra("extraUin", this.D);
            intent2.putExtra("receive", true);
            intent2.putExtra("isAudioMode", booleanExtra);
            intent2.putExtra(PreloadTRTCPlayerParams.KEY_SIG, bArr);
            if (ax.a.c(b16)) {
                str2 = ShortVideoConstants.PARAM_KEY_SESSION_TYPE;
                intent2.putExtra("inviteScene", intent.getIntExtra("inviteScene", 0));
            } else {
                str2 = ShortVideoConstants.PARAM_KEY_SESSION_TYPE;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("startVideoChatActivity: bindType = ");
                sb5.append(i3);
                sb5.append(",bindId = ");
                sb5.append(str);
                sb5.append(",BindType = ");
                SessionInfo sessionInfo2 = this.f76506e;
                if (sessionInfo2 == null) {
                    valueOf = "session info null";
                } else {
                    valueOf = Integer.valueOf(sessionInfo2.B0);
                }
                sb5.append(valueOf);
                QLog.d("IncomingCallAcceptRefusePart", 2, sb5.toString());
            }
            if (intExtra == 0) {
                intent2.putExtra(IProfileProtocolConst.PARAM_IS_FRIEND, b16.isFriend(this.f76510m));
            }
            if (booleanExtra) {
                intent2.putExtra(str2, 1);
            } else {
                intent2.putExtra(str2, 2);
            }
            intent2.putExtra("isSender", false);
        }
        if (activity == null) {
            intent2.addFlags(268435456);
            context2.startActivity(intent2);
        } else {
            Activity activity3 = activity;
            activity3.startActivity(intent2);
            activity3.overridePendingTransition(R.anim.f154855e4, R.anim.f154854e3);
        }
    }

    public void A9(long j3, String str, final Intent intent, SessionInfo sessionInfo) {
        SessionInfo f16 = n.e().f();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("acceptRequest, from[");
        sb5.append(str);
        sb5.append("], HandleSessionInfo[");
        sb5.append(sessionInfo);
        sb5.append("], CurMainSession[");
        sb5.append(f16);
        sb5.append("], mSessionInfo[");
        sb5.append(this.f76506e);
        sb5.append("], SameSession[");
        sb5.append(sessionInfo == f16);
        sb5.append("], getAliveSessionCount[");
        sb5.append(n.e().c());
        sb5.append("], intent[");
        sb5.append(intent);
        sb5.append("] uinType[");
        sb5.append(intent.getIntExtra("uinType", -1));
        sb5.append("], seq[");
        sb5.append(j3);
        sb5.append("]");
        QLog.w("IncomingCallAcceptRefusePart", 1, sb5.toString());
        this.G = true;
        if (sessionInfo != null && f16 == sessionInfo && n.e().c() >= 2) {
            r.h0().D2(true);
            if (sessionInfo.u()) {
                D9(j3, str, false, sessionInfo, -1);
            } else {
                r.h0().p(true, 205, f16.f73063p);
                r.h0().j2(205);
            }
            F9(sessionInfo);
        }
        SessionInfo sessionInfo2 = this.f76506e;
        if (sessionInfo2 != null && !sessionInfo2.u()) {
            if (QLog.isColorLevel()) {
                QLog.d("IncomingCallAcceptRefusePart", 2, "Session already destroyed, id:" + this.f76506e.f73030h + ", status = " + this.f76506e.f73043k);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.invite.multi.IncomingCallAcceptRefusePart.3
            @Override // java.lang.Runnable
            public void run() {
                if (NTGaInviteBaseFragment.xh(IncomingCallAcceptRefusePart.this.f76507f)) {
                    IncomingCallAcceptRefusePart.this.K9();
                } else {
                    IncomingCallAcceptRefusePart.this.J9(intent);
                }
            }
        }, 500L);
    }

    public void D9(long j3, String str, boolean z16, SessionInfo sessionInfo, int i3) {
        QLog.w("IncomingCallAcceptRefusePart", 1, "ignoreRequest[" + str + "], refuse3rd[" + z16 + "], mainSessionInfo[" + sessionInfo + "], iFlag[" + i3 + "], seq[" + j3 + "]");
        if (z16) {
            this.G = false;
        }
        TraeHelper.n0(nw.b.b());
        String str2 = this.f76510m;
        boolean z17 = this.f76509i;
        int i16 = this.E;
        long j16 = this.F;
        if (!z16) {
            if (sessionInfo == null) {
                return;
            }
            str2 = sessionInfo.f73091w;
            if (TextUtils.isEmpty(str2)) {
                str2 = sessionInfo.Y0;
            }
            z17 = sessionInfo.f73060o0;
            i16 = sessionInfo.S0;
            j16 = sessionInfo.P0;
        }
        boolean xh5 = NTGaInviteBaseFragment.xh(ba.avRelationType2UinType(i16));
        boolean z18 = !z16 && (z17 || xh5);
        if (xh5) {
            C9(j3, i16, j16, z18, i3, z16);
        } else {
            RtcNodeReportReceiverHelper.s(this.f76506e.r("MultiIncomingInviteFloat_accept"), 2, NodeModel$NodeEndReason.K_INTERRUPTION.ordinal());
            G9(j3, z17, str2, z18, z16);
        }
    }

    void G9(long j3, boolean z16, String str, boolean z17, boolean z18) {
        char c16;
        long j16;
        if (r.h0() != null && getActivity() != null && !getActivity().isDestroyed()) {
            QLog.w("IncomingCallAcceptRefusePart", 1, "refuseDoubleCall, isDoubleVideoMeeting[" + z16 + "], peerUin[" + str + "], notifyDestroyUI[" + z17 + "], refuse3rd[" + z18 + "], seq[" + j3 + "]");
            if (z16) {
                r.h0().g(j3, str, 1, true);
                try {
                    j16 = i.g(str);
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("IncomingCallAcceptRefusePart", 2, "", e16);
                    }
                    j16 = -1;
                }
                if (!z18) {
                    c16 = 2;
                    r.h0().Q0(j3, 3, j16, 10, false);
                    r.h0().o(j3, j16, 23);
                } else {
                    c16 = 2;
                    r.h0().P0(j3, 3, j16);
                    r.h0().o(j3, j16, 1);
                }
            } else {
                c16 = 2;
                r.h0().g(j3, str, 1, false);
                r.h0().r(str, 242);
                r.h0().j2(242);
                if (!z18) {
                    r.h0().q(str, 23);
                } else {
                    r.h0().q(str, 1);
                }
            }
            if (!z17 || nw.b.b() == null) {
                return;
            }
            VideoAppInterface b16 = nw.b.b();
            Object[] objArr = new Object[3];
            objArr[0] = 28;
            objArr[1] = str;
            objArr[c16] = Boolean.TRUE;
            b16.k0(objArr);
            return;
        }
        QLog.d("IncomingCallAcceptRefusePart", 1, "refuseDoubleCall VideoController.getInstance() is null");
    }
}
