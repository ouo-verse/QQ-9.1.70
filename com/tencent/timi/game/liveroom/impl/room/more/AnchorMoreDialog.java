package com.tencent.timi.game.liveroom.impl.room.more;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfig;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveFeedback;
import com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.widget.resolution.ResolutionSettingDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.impl.room.notice.TimiMessagePushDialog;
import com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.utils.w;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kl4.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import pj4.i;
import pj4.j;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AnchorMoreDialog extends BaseSlideUpDialog implements View.OnClickListener {
    private IAegisLogApi T;
    private long U;
    private int V;
    private boolean W;
    private i X;
    private j Y;
    private View Z;

    /* renamed from: a0, reason: collision with root package name */
    private AnchorMoreOpeItemView f378105a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Observer<Boolean> f378106b0;

    /* renamed from: c0, reason: collision with root package name */
    private AnchorMoreOpeItemView f378107c0;

    /* renamed from: d0, reason: collision with root package name */
    private final Observer<Boolean> f378108d0;

    /* renamed from: e0, reason: collision with root package name */
    private final Observer<Boolean> f378109e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f378110f0;

    /* renamed from: g0, reason: collision with root package name */
    private View f378111g0;

    /* renamed from: h0, reason: collision with root package name */
    private View f378112h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f378113i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f378114j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f378115k0;

    /* renamed from: l0, reason: collision with root package name */
    private e f378116l0;

    /* renamed from: m0, reason: collision with root package name */
    private AnchorPlayTogetherPresenter f378117m0;

    /* renamed from: n0, reason: collision with root package name */
    private pj4.a f378118n0;

    /* renamed from: o0, reason: collision with root package name */
    @Nullable
    private LiveRoomExtraInfo f378119o0;

    /* renamed from: p0, reason: collision with root package name */
    private ResolutionSettingDialog f378120p0;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            int i3;
            AnchorMoreOpeItemView anchorMoreOpeItemView = AnchorMoreDialog.this.f378105a0;
            if (bool.booleanValue()) {
                i3 = R.drawable.f162534o60;
            } else {
                i3 = R.drawable.o5z;
            }
            anchorMoreOpeItemView.setIconDrawable(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements Observer<Boolean> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            int i3;
            int visibility = AnchorMoreDialog.this.f378107c0.getVisibility();
            AnchorMoreOpeItemView anchorMoreOpeItemView = AnchorMoreDialog.this.f378107c0;
            if (bool.booleanValue()) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            anchorMoreOpeItemView.setVisibility(i3);
            if (visibility == 0 && !bool.booleanValue()) {
                VideoReport.traverseExposure();
            } else if (visibility == 8 && bool.booleanValue()) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c implements Observer<Boolean> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            int i3;
            AnchorMoreOpeItemView anchorMoreOpeItemView = AnchorMoreDialog.this.f378107c0;
            if (bool.booleanValue()) {
                i3 = R.drawable.f162540ov4;
            } else {
                i3 = R.drawable.f162539ov3;
            }
            anchorMoreOpeItemView.setIconDrawable(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public Context f378127a;

        /* renamed from: b, reason: collision with root package name */
        public long f378128b;

        /* renamed from: c, reason: collision with root package name */
        public int f378129c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f378130d = false;

        public static d b(Context context, long j3, int i3, boolean z16) {
            d dVar = new d();
            dVar.f378127a = context;
            dVar.f378128b = j3;
            dVar.f378129c = i3;
            dVar.f378130d = z16;
            return dVar;
        }

        public AnchorMoreDialog a() {
            AnchorMoreDialog anchorMoreDialog = new AnchorMoreDialog(this.f378127a);
            anchorMoreDialog.K0(this.f378128b);
            anchorMoreDialog.F0(this.f378129c);
            anchorMoreDialog.L0(this.f378130d);
            return anchorMoreDialog;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface e {
        void a();
    }

    public AnchorMoreDialog(Context context) {
        super(context);
        this.T = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.W = false;
        this.f378106b0 = new a();
        this.f378108d0 = new b();
        this.f378109e0 = new c();
    }

    public static AnchorMoreDialog A0(Context context, long j3, int i3, @Nullable LiveRoomExtraInfo liveRoomExtraInfo, boolean z16, j jVar, AnchorPlayTogetherPresenter anchorPlayTogetherPresenter, pj4.a aVar) {
        if (context == null) {
            if (ui4.a.f439039a.c()) {
                ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).w("toast_d", 1, "launchNew:\u53c2\u6570\u4e3a\u7a7a");
            }
            QLog.w("AnchorMoreDialog", 1, "launchNew:\u53c2\u6570\u4e3a\u7a7a");
            return null;
        }
        AnchorMoreDialog a16 = d.b(context, j3, i3, z16).a();
        a16.Y = jVar;
        a16.c0(false);
        a16.I0(aVar);
        a16.E0(anchorPlayTogetherPresenter);
        a16.H0(liveRoomExtraInfo);
        a16.show();
        return a16;
    }

    private void B0() {
        if (this.X == null) {
            this.X = new i();
        }
        this.X.b(this.G, this.U, this.V, this.f378118n0, this.Y);
    }

    private void C0(boolean z16) {
        String str;
        if (z16) {
            str = "imp";
        } else {
            str = "imp_end";
        }
        ConcurrentHashMap<String, String> s06 = s0();
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent(str, this.Z, s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent(str, this.f378105a0, s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent(str, this.f378110f0, s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent(str, this.f378111g0, s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent(str, this.f378112h0, s06);
    }

    private void J0(boolean z16) {
        int i3;
        int i16;
        View findViewById = findViewById(R.id.sog);
        int i17 = 0;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        findViewById.setVisibility(i3);
        View findViewById2 = findViewById(R.id.son);
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        findViewById2.setVisibility(i16);
        View findViewById3 = findViewById(R.id.f165214v72);
        if (!z16) {
            i17 = 8;
        }
        findViewById3.setVisibility(i17);
    }

    private void M0() {
        if (this.f378120p0 == null) {
            this.f378120p0 = new ResolutionSettingDialog(ResolutionLevelType.INSTANCE.getSupportResLevelsForCapture(this.G), new Function1() { // from class: com.tencent.timi.game.liveroom.impl.room.more.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit y06;
                    y06 = AnchorMoreDialog.this.y0((ResolutionLevelType) obj);
                    return y06;
                }
            }, new Function0() { // from class: com.tencent.timi.game.liveroom.impl.room.more.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit z06;
                    z06 = AnchorMoreDialog.this.z0();
                    return z06;
                }
            });
        }
        this.f378120p0.f();
    }

    private String q0() {
        try {
            return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        } catch (Exception e16) {
            QLog.w("AnchorMoreDialog", 1, "getAccount, error ", e16);
            return "";
        }
    }

    private ConcurrentHashMap<String, String> s0() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("zengzhi_moduleid", "em_qqlive_morefunction_entrance");
        return concurrentHashMap;
    }

    private void u0() {
        int i3;
        int b16 = ht3.a.b("qqlive_need_feedback_button", 1);
        QLog.d("AnchorMoreDialog", 1, "initFeedbackData, showFeedbackBtn: " + b16);
        View view = this.f378114j0;
        if (b16 == 1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        ConcurrentHashMap<String, String> s06 = s0();
        s06.put("em_qqlive_guide_livestatus", "1");
        ((ug4.a) mm4.b.b(ug4.a.class)).a(this.f378114j0, true, null, "em_qqlive_feedback", s06);
    }

    private void w0() {
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(this.U);
        View findViewById = findViewById(R.id.f164321sp0);
        if (!(J3 instanceof IQQLiveAnchorTRTCRoom)) {
            findViewById.setVisibility(4);
        } else {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.more.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnchorMoreDialog.this.x0(view);
                }
            });
            ((ug4.a) mm4.b.b(ug4.a.class)).a(findViewById, true, null, "em_qqlive_clarity", new HashMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        M0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit y0(ResolutionLevelType resolutionLevelType) {
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(this.U);
        if (J3 instanceof IQQLiveAnchorTRTCRoom) {
            LiveMediaConfigManager liveMediaConfigManager = LiveMediaConfigManager.INSTANCE;
            LiveMediaConfig liveMediaConfig = liveMediaConfigManager.getLiveMediaConfig(0, resolutionLevelType);
            TRTCVideoQualityParams.Builder builder = new TRTCVideoQualityParams.Builder();
            builder.setVideoResolution(liveMediaConfig.getResolution()).setVideoFps(liveMediaConfig.getFps()).setVideoBitRate(liveMediaConfig.getBitRate()).setMinVideoBitRate(liveMediaConfig.getMinBitRate()).setVideoResolutionMode(1);
            TRTCVideoQualityParams build = builder.build();
            this.T.i("AnchorMoreDialog", "updateMediaConfig params:" + build.toString());
            ((IQQLiveAnchorTRTCRoom) J3).setVideoQuality(build);
            tk4.a.a(build, QQLiveReportConstants.Event.E_ANCHOR_CHANGE_PUSH_ENCODE_PARAMS);
            liveMediaConfigManager.setResolutionLevelTypeCache(resolutionLevelType);
            QQToastUtil.showQQToast(0, String.format("\u5df2\u4e3a\u4f60\u5207\u6362\u81f3%s\u753b\u8d28", resolutionLevelType.getTerm()));
            HashMap hashMap = new HashMap();
            hashMap.put("qqlive_clarity_success", String.valueOf(resolutionLevelType.getCode()));
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_clarity_live", hashMap);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit z0() {
        ResolutionSettingDialog resolutionSettingDialog = this.f378120p0;
        if (resolutionSettingDialog != null) {
            resolutionSettingDialog.e();
            return null;
        }
        return null;
    }

    public void D0(e eVar) {
        this.f378116l0 = eVar;
    }

    public void E0(AnchorPlayTogetherPresenter anchorPlayTogetherPresenter) {
        this.f378117m0 = anchorPlayTogetherPresenter;
    }

    public void F0(int i3) {
        this.V = i3;
    }

    public void H0(LiveRoomExtraInfo liveRoomExtraInfo) {
        this.f378119o0 = liveRoomExtraInfo;
    }

    public void I0(pj4.a aVar) {
        this.f378118n0 = aVar;
    }

    public void K0(long j3) {
        this.U = j3;
    }

    public void L0(boolean z16) {
        this.W = z16;
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = this.f378117m0;
        if (anchorPlayTogetherPresenter != null) {
            anchorPlayTogetherPresenter.t().removeObserver(this.f378108d0);
            this.f378117m0.w().removeObserver(this.f378109e0);
        }
        pj4.a aVar = this.f378118n0;
        if (aVar != null) {
            aVar.b().removeObserver(this.f378106b0);
        }
        C0(false);
        if (this.f378107c0.getVisibility() == 0) {
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("imp_end", this.f378107c0, new HashMap());
        }
        super.dismiss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.sod) {
            dismiss();
        } else if (id5 != R.id.soe && !o.f("anchor_more_item", 300L)) {
            if (id5 == R.id.sok) {
                AnchorRoomSettingFragment.rh(this.G, this.U);
                dismiss();
            } else if (id5 == R.id.sol) {
                final Context context = this.G;
                final long j3 = this.U;
                dismiss();
                w.d(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.more.AnchorMoreDialog.5
                    @Override // java.lang.Runnable
                    public void run() {
                        wk4.a.h(context, j3, AnchorMoreDialog.this.f378119o0);
                    }
                }, 300L);
            } else if (id5 == R.id.sog) {
                B0();
                dismiss();
            } else if (id5 == R.id.soj) {
                com.tencent.timi.game.liveroom.impl.room.notice.i.q0(this.G, this.U);
                dismiss();
            } else if (id5 == R.id.sow) {
                dismiss();
                e eVar = this.f378116l0;
                if (eVar != null) {
                    eVar.a();
                }
            } else if (id5 == R.id.soc) {
                TimiMessagePushDialog.INSTANCE.f(this.G, this.U, r0());
                dismiss();
            } else if (id5 == R.id.sof) {
                ((IQQLiveFeedback) QRoute.api(IQQLiveFeedback.class)).openFeedbackActivity(this.G, q0());
                dismiss();
            } else if (id5 == R.id.soi) {
                s.k(this.U);
                dismiss();
            } else if (id5 == R.id.f164318so2) {
                mj4.a.INSTANCE.a(this.G);
                dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.f169112ht2);
        findViewById(R.id.soe).setOnClickListener(this);
        findViewById(R.id.sod).setOnClickListener(this);
        this.f378105a0 = (AnchorMoreOpeItemView) findViewById(R.id.sog);
        this.f378107c0 = (AnchorMoreOpeItemView) findViewById(R.id.sow);
        this.f378110f0 = findViewById(R.id.sol);
        this.f378111g0 = findViewById(R.id.sok);
        this.f378112h0 = findViewById(R.id.soj);
        this.f378113i0 = findViewById(R.id.soc);
        View findViewById = findViewById(R.id.soi);
        this.f378115k0 = findViewById;
        findViewById.setOnClickListener(this);
        this.f378105a0.setOnClickListener(this);
        this.f378110f0.setOnClickListener(this);
        this.f378111g0.setOnClickListener(this);
        this.f378112h0.setOnClickListener(this);
        this.f378107c0.setOnClickListener(this);
        this.f378113i0.setOnClickListener(this);
        w0();
        findViewById(R.id.f164318so2).setOnClickListener(this);
        View findViewById2 = findViewById(R.id.sof);
        this.f378114j0 = findViewById2;
        findViewById2.setOnClickListener(this);
        u0();
        J0(false);
        View findViewById3 = findViewById(R.id.soe);
        this.Z = findViewById3;
        e0(findViewById3);
        f0();
        ConcurrentHashMap a16 = com.tencent.timi.game.liveroom.impl.room.more.d.a(this.U);
        a16.put("qqlive_coming_way", "");
        ((ug4.a) mm4.b.b(ug4.a.class)).b(this, IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID, a16);
        ConcurrentHashMap<String, String> s06 = s0();
        ((ug4.a) mm4.b.b(ug4.a.class)).c(this.Z, true, null, "em_qqlive_morefunction_board", s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).c(this.f378105a0, true, null, "em_qqlive_equipshow_entrance", s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).c(this.f378110f0, true, null, "em_qqlive_share", s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).c(this.f378111g0, true, null, "em_qqlive_roomset_entrance", s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).c(this.f378112h0, true, null, "em_qqlive_announceset_entrance", s06);
        ((ug4.a) mm4.b.b(ug4.a.class)).a(this.f378107c0, true, null, "em_qqlive_palysetting", new HashMap());
        VideoReport.setEventDynamicParams(this.f378107c0, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.more.AnchorMoreDialog.4
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public Map<String, Object> getDynamicParams(String str) {
                return new HashMap<String, Object>() { // from class: com.tencent.timi.game.liveroom.impl.room.more.AnchorMoreDialog.4.1
                    {
                        String str2;
                        if (AnchorMoreDialog.this.f378117m0.F()) {
                            str2 = "1";
                        } else {
                            str2 = "0";
                        }
                        put("qqlive_play_setstatus", str2);
                        put("zengzhi_moduleid", "em_qqlive_morefunction_entrance");
                    }
                };
            }
        });
        C0(true);
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = this.f378117m0;
        if (anchorPlayTogetherPresenter != null) {
            anchorPlayTogetherPresenter.t().observeForever(this.f378108d0);
            this.f378117m0.w().observeForever(this.f378109e0);
        }
    }

    public long r0() {
        jg4.b bVar = (jg4.b) mm4.b.b(jg4.b.class);
        if (bVar != null && bVar.n(this.U) != null) {
            return bVar.n(this.U).getAnchorUid();
        }
        return 0L;
    }
}
