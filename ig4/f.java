package ig4;

import ag4.i;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.component.gamecore.impl.widget.GameAccountSelectView;
import com.tencent.timi.game.ui.widget.DragViewGroup;
import com.tencent.timi.game.utils.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\u00020\u0001:\u0001KBG\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010G\u001a\u00020F\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001f\u0012\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010$\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R#\u0010+\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00107R\u0016\u0010;\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006L"}, d2 = {"Lig4/f;", "Lcom/tencent/timi/game/ui/widget/h;", "", "initViews", "x0", "C0", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "account", "D0", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "n0", "Lcom/tencent/timi/game/ui/widget/DragViewGroup;", "p0", "", "m0", "Landroid/view/View;", "e0", "Y", BdhLogUtil.LogTag.Tag_Req, "I", "getYesGameId", "()I", "setYesGameId", "(I)V", "yesGameId", "", ExifInterface.LATITUDE_SOUTH, "Ljava/util/List;", "getAccountList", "()Ljava/util/List;", "accountList", "Lag4/i$d;", "T", "Lag4/i$d;", "getCb", "()Lag4/i$d;", "cb", "", "", "U", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "extraInfo", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "titleTxv", "Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView;", "W", "Lcom/tencent/timi/game/component/gamecore/impl/widget/GameAccountSelectView;", "accountSelectView", "X", "confirmTxv", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "closeArea", "Z", "Landroid/view/View;", "shadowView", "Landroid/widget/LinearLayout;", "a0", "Landroid/widget/LinearLayout;", "contentView", "b0", "Lcom/tencent/timi/game/ui/widget/DragViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "c0", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "loadingView", "Landroid/content/Context;", "context", "<init>", "(ILandroid/content/Context;Ljava/util/List;Lag4/i$d;Ljava/util/Map;)V", "d0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f extends com.tencent.timi.game.ui.widget.h {

    /* renamed from: R, reason: from kotlin metadata */
    private int yesGameId;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final List<YesGameInfoOuterClass$YesGameRoleAbsInfo> accountList;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private final i.d cb;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> extraInfo;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private TextView titleTxv;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private GameAccountSelectView accountSelectView;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private TextView confirmTxv;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private FrameLayout closeArea;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private View shadowView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout contentView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private DragViewGroup rootView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TimiGamePageLoadingView loadingView;

    public /* synthetic */ f(int i3, Context context, List list, i.d dVar, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, context, list, (i16 & 8) != 0 ? null : dVar, (i16 & 16) != 0 ? new HashMap() : map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.d dVar = this$0.cb;
        if (dVar != null) {
            dVar.b();
        }
        this$0.Z();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        l.i("GameAccountSelectDialog_", "clicked!");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C0() {
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
            aVar.reportEvent("ev_qqlive_bangding_success", f16);
        }
    }

    private final void D0(YesGameInfoOuterClass$YesGameRoleAbsInfo account) {
        wf4.a.f445618a.e(this);
        ((ag4.i) mm4.b.b(ag4.i.class)).e1(this.yesGameId, account, new i.b() { // from class: ig4.e
            @Override // ag4.i.b
            public final void i(boolean z16, int i3, String str, Object obj) {
                f.E0(f.this, z16, i3, str, (YesGameInfoOuterClass$SetUserGameDefaultRoleRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(f this$0, boolean z16, int i3, String str, YesGameInfoOuterClass$SetUserGameDefaultRoleRsp yesGameInfoOuterClass$SetUserGameDefaultRoleRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        wf4.a.f445618a.b(this$0);
        l.i("GameDialogUtils_", "result:" + z16 + ", errorCode:" + i3 + ", errorMsg:" + str + ", rsp:" + yesGameInfoOuterClass$SetUserGameDefaultRoleRsp);
        if (z16 && yesGameInfoOuterClass$SetUserGameDefaultRoleRsp != null) {
            Context context = this$0.G;
            QQToast.makeText(context, context.getResources().getString(R.string.f227886s9), 0).show();
            YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp = new YesGameInfoOuterClass$GetUserGameDefaultRoleRsp();
            yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info.set(yesGameInfoOuterClass$SetUserGameDefaultRoleRsp.role_info.get());
            i.d dVar = this$0.cb;
            if (dVar != null) {
                dVar.a(yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
            }
            ((ag4.i) mm4.b.b(ag4.i.class)).s3(this$0.yesGameId, null);
            this$0.C0();
            this$0.Z();
            return;
        }
        QQToast.makeText(this$0.G, str, 0).show();
        i.d dVar2 = this$0.cb;
        if (dVar2 != null) {
            dVar2.e(i3, str);
        }
    }

    private final void initViews() {
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(this.yesGameId);
        Intrinsics.checkNotNullExpressionValue(l16, "getService(IGameConfigSe\u2026GameConfigInfo(yesGameId)");
        String str = l16.game_name.get();
        this.titleTxv.setText("\u7ed1\u5b9a\u6211\u7684" + str + "\u8d26\u53f7");
        this.accountSelectView.setData(this.yesGameId, this.accountList);
        this.confirmTxv.setOnClickListener(new View.OnClickListener() { // from class: ig4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.y0(f.this, view);
            }
        });
        this.closeArea.setOnClickListener(new View.OnClickListener() { // from class: ig4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.z0(f.this, view);
            }
        });
        this.shadowView.setOnClickListener(new View.OnClickListener() { // from class: ig4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.A0(f.this, view);
            }
        });
        this.contentView.setOnClickListener(new View.OnClickListener() { // from class: ig4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.B0(view);
            }
        });
        x0();
    }

    private final void x0() {
        gh4.d dVar;
        String str = this.extraInfo.get("caller_scene");
        if (str == null) {
            str = "";
        }
        l.h("GameAccountSelectDialog_", 1, "callerScene:" + str);
        if (Intrinsics.areEqual(str, "")) {
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                dVar = I0.m0();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.b(this);
            }
            if (dVar != null) {
                dVar.a(this.confirmTxv, dVar.J());
            }
            if (dVar != null) {
                dVar.a(this.closeArea, dVar.K());
                return;
            }
            return;
        }
        ConcurrentHashMap<String, String> f16 = tk4.d.f436481a.f();
        f16.put("qqlive_shouquan_scene", str);
        ug4.a aVar = (ug4.a) mm4.b.b(ug4.a.class);
        DragViewGroup dragViewGroup = this.rootView;
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        aVar.b(dragViewGroup, IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID, f16);
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b16, this.confirmTxv, false, null, "em_qqlive_bangding_btn", null, 22, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        YesGameInfoOuterClass$YesGameRoleAbsInfo c16 = this$0.accountSelectView.c();
        if (c16 != null) {
            this$0.D0(c16);
        } else {
            l.e("GameAccountSelectDialog_", "selected account is null!");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.d dVar = this$0.cb;
        if (dVar != null) {
            dVar.b();
        }
        this$0.Z();
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

    @Override // com.tencent.timi.game.ui.widget.h
    public int m0() {
        return com.tencent.timi.game.utils.b.a(360);
    }

    @Override // com.tencent.timi.game.ui.widget.h
    @Nullable
    /* renamed from: n0, reason: from getter */
    public TimiGamePageLoadingView getLoadingView() {
        return this.loadingView;
    }

    @Override // com.tencent.timi.game.ui.widget.h
    @NotNull
    /* renamed from: p0, reason: from getter */
    public DragViewGroup getRootView() {
        return this.rootView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(int i3, @NotNull Context context, @NotNull List<YesGameInfoOuterClass$YesGameRoleAbsInfo> accountList, @Nullable i.d dVar, @NotNull Map<String, String> extraInfo) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountList, "accountList");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.yesGameId = i3;
        this.accountList = accountList;
        this.cb = dVar;
        this.extraInfo = extraInfo;
        setContentView(R.layout.hxm);
        View findViewById = findViewById(R.id.f98185me);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.titleTxv)");
        this.titleTxv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.s7v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.accountSelectView)");
        this.accountSelectView = (GameAccountSelectView) findViewById2;
        View findViewById3 = findViewById(R.id.u48);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.confirmTxv)");
        this.confirmTxv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.tz9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.closeArea)");
        this.closeArea = (FrameLayout) findViewById4;
        View findViewById5 = findViewById(R.id.f84014l4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.shadowView)");
        this.shadowView = findViewById5;
        View findViewById6 = findViewById(R.id.b9r);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.contentView)");
        this.contentView = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.iet);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.rootView)");
        this.rootView = (DragViewGroup) findViewById7;
        View findViewById8 = findViewById(R.id.ef6);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.loadingView)");
        this.loadingView = (TimiGamePageLoadingView) findViewById8;
        initViews();
    }
}
