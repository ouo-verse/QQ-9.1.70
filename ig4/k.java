package ig4;

import ag4.i;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.ui.widget.m;
import com.tencent.timi.game.utils.l;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001SBW\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\b\u0010'\u001a\u0004\u0018\u00010\"\u0012\b\u0010-\u001a\u0004\u0018\u00010(\u0012\u0006\u00103\u001a\u00020.\u0012\u0014\b\u0002\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001604\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010'\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010-\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00103\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R#\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016048\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010C\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010<R\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010O\u00a8\u0006T"}, d2 = {"Lig4/k;", "Lcom/tencent/timi/game/ui/widget/m;", "", "initViews", "s0", "r0", "A0", "Ltrpc/yes/common/GameAuthOuterClass$AgreeGameAuthRsp;", "response", "q0", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "j0", "Landroid/view/View;", "e0", "Y", "", "J", "I", "getYesGameId", "()I", "yesGameId", "", "", "K", "Ljava/util/List;", "getDesc", "()Ljava/util/List;", "desc", "", "L", "Z", "getAutoShowAccountSelect", "()Z", "autoShowAccountSelect", "Lag4/i$a;", "M", "Lag4/i$a;", "u0", "()Lag4/i$a;", "cb", "Lag4/i$d;", "N", "Lag4/i$d;", "getBindAccountCallback", "()Lag4/i$d;", "bindAccountCallback", "Landroid/app/Activity;", "P", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "extraInfo", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "desc1Txv", ExifInterface.LATITUDE_SOUTH, "desc2Txv", "T", "giveUpTxv", "U", "authTxv", "V", "Landroid/view/View;", "shadowView", "Landroid/widget/RelativeLayout;", "W", "Landroid/widget/RelativeLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "X", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "loadingView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "contentView", "<init>", "(ILjava/util/List;ZLag4/i$a;Lag4/i$d;Landroid/app/Activity;Ljava/util/Map;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class k extends m {

    /* renamed from: J, reason: from kotlin metadata */
    private final int yesGameId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final List<String> desc;

    /* renamed from: L, reason: from kotlin metadata */
    private final boolean autoShowAccountSelect;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private final i.a cb;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private final i.d bindAccountCallback;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> extraInfo;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private TextView desc1Txv;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private TextView desc2Txv;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private TextView giveUpTxv;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private TextView authTxv;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private View shadowView;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private RelativeLayout rootView;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private TimiGamePageLoadingView loadingView;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private LinearLayout contentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"ig4/k$b", "Lpl4/d;", "Ltrpc/yes/common/GameAuthOuterClass$AgreeGameAuthRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements pl4.d<GameAuthOuterClass$AgreeGameAuthRsp> {
        b() {
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable GameAuthOuterClass$AgreeGameAuthRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            wf4.a.f445618a.b(k.this);
            l.e("GameDialogUtils_", "isMsfSuccess:" + isMsfSuccess + ", msfResultCode:" + msfResultCode + ", timiErrCode:" + timiErrCode + ", timiSubErrCode:" + timiSubErrCode + ", timiErrMsg:" + timiErrMsg + " timiDisplayErrMsg:" + timiDisplayErrMsg);
            i.a cb5 = k.this.getCb();
            if (cb5 != null) {
                cb5.d(timiErrCode, timiErrMsg);
            }
            QQToast.makeText(((com.tencent.timi.game.ui.widget.b) k.this).G, timiErrMsg, 0).show();
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable GameAuthOuterClass$AgreeGameAuthRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            k.this.q0(response);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(int i3, @NotNull List<String> desc, boolean z16, @Nullable i.a aVar, @Nullable i.d dVar, @NotNull Activity activity, @NotNull Map<String, String> extraInfo) {
        super(activity);
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.yesGameId = i3;
        this.desc = desc;
        this.autoShowAccountSelect = z16;
        this.cb = aVar;
        this.bindAccountCallback = dVar;
        this.activity = activity;
        this.extraInfo = extraInfo;
        setContentView(R.layout.hxo);
        View findViewById = findViewById(R.id.ug_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.desc1Txv)");
        this.desc1Txv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.uga);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.desc2Txv)");
        this.desc2Txv = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.vqh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.giveUpTxv)");
        this.giveUpTxv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.sxh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.authTxv)");
        this.authTxv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.f84014l4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.shadowView)");
        this.shadowView = findViewById5;
        View findViewById6 = findViewById(R.id.iet);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.rootView)");
        this.rootView = (RelativeLayout) findViewById6;
        View findViewById7 = findViewById(R.id.ef6);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.loadingView)");
        this.loadingView = (TimiGamePageLoadingView) findViewById7;
        View findViewById8 = findViewById(R.id.b9r);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.contentView)");
        this.contentView = (LinearLayout) findViewById8;
        initViews();
    }

    private final void A0() {
        String str = this.extraInfo.get("caller_scene");
        if (str == null) {
            str = "";
        }
        l.h("GameAuthHintDialog_", 1, "callerScene:" + str);
        if (!Intrinsics.areEqual(str, "")) {
            ConcurrentHashMap<String, String> f16 = tk4.d.f436481a.f();
            f16.put("qqlive_shouquan_scene", str);
            ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            aVar.reportEvent("ev_qqlive_shouquan_success", f16);
        }
    }

    private final void initViews() {
        if (!this.desc.isEmpty()) {
            this.desc1Txv.setText(this.desc.get(0));
        }
        if (this.desc.size() > 1) {
            this.desc2Txv.setText(this.desc.get(1));
        }
        this.giveUpTxv.setOnClickListener(new View.OnClickListener() { // from class: ig4.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.w0(k.this, view);
            }
        });
        this.authTxv.setOnClickListener(new View.OnClickListener() { // from class: ig4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.x0(k.this, view);
            }
        });
        this.shadowView.setOnClickListener(new View.OnClickListener() { // from class: ig4.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.y0(k.this, view);
            }
        });
        Y().setOnClickListener(new View.OnClickListener() { // from class: ig4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.z0(view);
            }
        });
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(GameAuthOuterClass$AgreeGameAuthRsp response) {
        A0();
        wf4.a.f445618a.b(this);
        Context context = this.G;
        QQToast.makeText(context, context.getResources().getString(R.string.f227906sa), 0).show();
        if (response != null) {
            i.a aVar = this.cb;
            if (aVar != null) {
                aVar.g(response);
            }
        } else {
            i.a aVar2 = this.cb;
            if (aVar2 != null) {
                aVar2.d(-1, "response is null");
            }
        }
        if (!this.autoShowAccountSelect) {
            dismiss();
        } else {
            hg4.c.f404865a.e(this.yesGameId, this.activity, this, this.bindAccountCallback, this.extraInfo);
        }
    }

    private final void r0() {
        wf4.a.f445618a.e(this);
        fg4.a.e(this.yesGameId, 0, new b());
    }

    private final void s0() {
        String str = this.extraInfo.get("caller_scene");
        if (str == null) {
            str = "";
        }
        l.h("GameAuthHintDialog_", 1, "callerScene:" + str);
        if (!Intrinsics.areEqual(str, "")) {
            ConcurrentHashMap<String, String> f16 = tk4.d.f436481a.f();
            f16.put("qqlive_shouquan_scene", str);
            ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
            RelativeLayout relativeLayout = this.rootView;
            Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            aVar.b(relativeLayout, IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID, f16);
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11346a.a((ug4.a) b16, this.authTxv, false, null, "em_qqlive_shouquan_btn", null, 22, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i("GameDialogUtils_", "user give up auth!");
        i.a aVar = this$0.cb;
        if (aVar != null) {
            aVar.f();
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i("GameDialogUtils_", "do auth!");
        this$0.r0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(k this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i("GameDialogUtils_", "user give up auth!");
        i.a aVar = this$0.cb;
        if (aVar != null) {
            aVar.f();
        }
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        l.i("GameAuthHintDialog_", "click intercept");
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    public View Y() {
        return this.contentView;
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    /* renamed from: e0, reason: from getter */
    public View getShadowView() {
        return this.shadowView;
    }

    @Override // com.tencent.timi.game.ui.widget.m
    @Nullable
    /* renamed from: j0, reason: from getter */
    public TimiGamePageLoadingView getLoadingView() {
        return this.loadingView;
    }

    @Nullable
    /* renamed from: u0, reason: from getter */
    public final i.a getCb() {
        return this.cb;
    }
}
