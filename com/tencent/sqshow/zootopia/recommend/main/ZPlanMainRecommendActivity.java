package com.tencent.sqshow.zootopia.recommend.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.m;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.api.IZPlanUECacheHelper;
import com.tencent.mobileqq.zplan.api.IZootopiaPortalFilamentConfigHelper;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.utils.api.IZPlanNetSpeedHelper;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.database.ZplanDataBaseHelper;
import com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendActivity;
import com.tencent.sqshow.zootopia.recommend.main.tab.ZPlanTabContainerView;
import com.tencent.sqshow.zootopia.recommend.main.tab.network.ZPlanTabServerDataManager;
import com.tencent.sqshow.zootopia.report.ZootopiaStartUpReport;
import com.tencent.sqshow.zootopia.utils.VideoUtils;
import com.tencent.sqshow.zootopia.utils.ab;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import n74.g;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \\2\u00020\u0001:\u0002]^B\u0007\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u0006H\u0014J\b\u0010\u001e\u001a\u00020\u0006H\u0014J\b\u0010\u001f\u001a\u00020\u0006H\u0014J\b\u0010 \u001a\u00020\rH\u0014J\b\u0010!\u001a\u00020\rH\u0014J\b\u0010\"\u001a\u00020\u0006H\u0016J\u001a\u0010'\u001a\u00020\r2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010)\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\rJ\b\u0010*\u001a\u00020\rH\u0014J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\t2\u0006\u0010-\u001a\u00020,H\u0016J\"\u00102\u001a\u00020\u00062\u0006\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0014R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010;\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010>\u001a\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010X\u00a8\u0006_"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "P2", "Landroid/content/Intent;", "intent", "", "V2", "K2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "J2", "W2", "", "Y2", "b3", "Z2", "", "S2", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "R2", "doOnCreate", "Landroid/content/res/Resources;", "getResources", "name", "", "getSystemService", "onPostThemeChanged", "doOnNewIntent", "doOnResume", "doOnPause", "doOnDestroy", "isWrapContent", "onBackEvent", "finish", "", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "needDoubleCheck", "T2", "needRestoreFragmentAfterRecreate", "outState", "Landroid/os/PersistableBundle;", "outPersistentState", "onSaveInstanceState", "requestCode", "requestCode2", "data", "doOnActivityResult", "", "a0", "J", "backConfirmTime", "b0", "lastBackTime", "c0", "Ljava/lang/String;", "backConfirmToast", "Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendController;", "d0", "Lkotlin/Lazy;", "N2", "()Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendController;", "controller", "Lid3/d;", "e0", "Lid3/d;", "reporter", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReceiverRegister", "Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendActivity$HomeReceiver;", "g0", "Q2", "()Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendActivity$HomeReceiver;", "homeReceiver", "Lp74/a;", "h0", "Lp74/a;", "zplanTheme", "Ln74/g;", "i0", "Ln74/g;", "mViewBinding", "j0", "Z", "mBackToSource", "<init>", "()V", "k0", "a", "HomeReceiver", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMainRecommendActivity extends QBaseActivity {

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private long backConfirmTime;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private long lastBackTime;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String backConfirmToast = "\u8bf7\u518d\u64cd\u4f5c\u4e00\u6b21";

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final Lazy controller;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final id3.d reporter;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isReceiverRegister;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final Lazy homeReceiver;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final p74.a zplanTheme;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private g mViewBinding;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean mBackToSource;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "from", "Landroid/os/Bundle;", "bundle", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendActivity$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(intent, "$intent");
            context.startActivity(intent);
        }

        public final void b(final Context context, ZootopiaSource from, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(from, "from");
            final Intent intent = new Intent(context, (Class<?>) ZPlanMainRecommendActivity.class);
            intent.setFlags(65536);
            intent.putExtra("AvatarViewType", 1);
            intent.putExtra(ZootopiaSource.KEY_FRAGMENT_SOURCE, new FragmentSource(Source.PortalActivity, from));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("public_fragment_window_feature", 1);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.tencent.sqshow.zootopia.report.b.INSTANCE.b(intent);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.c
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanMainRecommendActivity.Companion.c(context, intent);
                }
            });
            ZootopiaStartUpReport.f372678a.c(bundle);
        }

        Companion() {
        }
    }

    public ZPlanMainRecommendActivity() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMainRecommendController>() { // from class: com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendActivity$controller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanMainRecommendController invoke() {
                FragmentSource P2;
                P2 = ZPlanMainRecommendActivity.this.P2();
                return new ZPlanMainRecommendController(P2);
            }
        });
        this.controller = lazy;
        this.reporter = new id3.d(null, 1, null);
        this.isReceiverRegister = new AtomicBoolean(false);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HomeReceiver>() { // from class: com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendActivity$homeReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanMainRecommendActivity.HomeReceiver invoke() {
                FragmentSource P2;
                id3.d dVar;
                ag agVar = ag.f373258a;
                P2 = ZPlanMainRecommendActivity.this.P2();
                ZootopiaSource c16 = agVar.c(P2.getFrom());
                if (c16 == null) {
                    c16 = ZootopiaSource.INSTANCE.i();
                }
                dVar = ZPlanMainRecommendActivity.this.reporter;
                return new ZPlanMainRecommendActivity.HomeReceiver(c16, dVar);
            }
        });
        this.homeReceiver = lazy2;
        this.zplanTheme = new p74.a(this);
    }

    private final void K2() {
        ZootopiaSource from;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        Intent intent = getIntent();
        Source source = null;
        FragmentSource f16 = companion.f(intent != null ? intent.getExtras() : null);
        if (f16 != null && (from = f16.getFrom()) != null) {
            source = from.getMainSource();
        }
        if (source == Source.DynamicEntry || source == Source.DRAWER_PORTAL) {
            overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M2(ZPlanMainRecommendActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isFinishing()) {
            return;
        }
        wa4.b.f445350a.o();
    }

    private final ZPlanMainRecommendController N2() {
        return (ZPlanMainRecommendController) this.controller.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSource P2() {
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getIntent().getExtras());
        return f16 == null ? new FragmentSource(Source.PortalActivity, companion.i()) : f16;
    }

    private final HomeReceiver Q2() {
        return (HomeReceiver) this.homeReceiver.getValue();
    }

    private final ZootopiaSource R2() {
        ZootopiaSource c16 = ag.f373258a.c(P2().getFrom());
        return c16 == null ? ZootopiaSource.INSTANCE.i() : c16;
    }

    private final String S2() {
        return ah.b(R2());
    }

    private final void V2(Intent intent) {
        ZootopiaSource R2 = R2();
        boolean booleanExtra = intent.getBooleanExtra("backToSource", m.a(R2));
        this.mBackToSource = booleanExtra;
        QLog.i("ZPlanMainRecommendActivity_", 1, "handleIntent mBackToSource:" + booleanExtra + ", rootSource:" + R2);
    }

    private final void W2() {
        try {
            JSONObject zootopiaBackConfig = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZootopiaBackConfig();
            this.backConfirmTime = zootopiaBackConfig != null ? zootopiaBackConfig.optLong("back_interval") : 0L;
            String optString = zootopiaBackConfig != null ? zootopiaBackConfig.optString("back_toast") : null;
            if (optString == null) {
                optString = "";
            }
            this.backConfirmToast = optString;
            QLog.i("ZPlanMainRecommendActivity_", 4, "initBackConfirmConfig backConfirmTime = " + this.backConfirmTime + " backConfirmToast = " + optString);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private final boolean Y2() {
        long currentTimeMillis = System.currentTimeMillis() - this.lastBackTime;
        long j3 = this.backConfirmTime;
        if (currentTimeMillis > j3 && j3 > 0) {
            QQToastUtil.showQQToast(-1, this.backConfirmToast);
            this.lastBackTime = System.currentTimeMillis();
            Z2();
            return true;
        }
        b3();
        return false;
    }

    private final void Z2() {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        id3.d dVar = this.reporter;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(R2())), TuplesKt.to("dt_pgid", "pg_zplan_paradise"), TuplesKt.to("zplan_return_to", "2"));
        dVar.d("ev_zplan_anti_mistouch_trigger", hashMapOf);
        mb4.c cVar = mb4.c.f416532a;
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_exit_mode", "1"));
        mb4.c.c(cVar, "e_zplan__exit", hashMapOf2, false, 4, null);
    }

    private final void b3() {
        HashMap hashMapOf;
        HashMap hashMapOf2;
        id3.d dVar = this.reporter;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(R2())), TuplesKt.to("dt_pgid", "pg_zplan_paradise"), TuplesKt.to("zplan_return_type", "2"), TuplesKt.to("zplan_return_to", "2"));
        dVar.d("ev_zplan_page_return", hashMapOf);
        mb4.c cVar = mb4.c.f416532a;
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_exit_mode", "2"));
        mb4.c.c(cVar, "e_zplan__exit", hashMapOf2, false, 4, null);
    }

    public final boolean T2(boolean needDoubleCheck) {
        if (onBackEvent()) {
            return true;
        }
        if (needDoubleCheck && Y2()) {
            return true;
        }
        if (!this.mBackToSource) {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).jumpToSplash();
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        ((IZootopiaPortalFilamentConfigHelper) QRoute.api(IZootopiaPortalFilamentConfigHelper.class)).refreshConfig();
        this.mActNeedImmersive = false;
        boolean doOnCreate = super.doOnCreate(savedInstanceState);
        QLog.i("ZPlanMainRecommendActivity_", 1, "doOnCreate - " + this + ", savedInstanceState= " + savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            V2(intent);
        }
        g g16 = g.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        setContentView(g16.getRoot());
        g16.f419341e.setMSourceId(S2());
        g16.f419338b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.recommend.main.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanMainRecommendActivity.L2(view);
            }
        });
        QRouteApi api = QRoute.api(IZplanCacheApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanCacheApi::class.java)");
        IZplanCacheApi iZplanCacheApi = (IZplanCacheApi) api;
        ZplanCacheComponentType zplanCacheComponentType = ZplanCacheComponentType.FACE_AD_CONTAINER;
        FrameLayout frameLayout = g16.f419339c;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.faceadContainer");
        iZplanCacheApi.saveCache(this, zplanCacheComponentType, frameLayout);
        ZplanCacheComponentType zplanCacheComponentType2 = ZplanCacheComponentType.MAIN_PAGE_CONTAINER;
        FrameLayout frameLayout2 = g16.f419340d;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.pageContainer");
        iZplanCacheApi.saveCache(this, zplanCacheComponentType2, frameLayout2);
        ZPlanMainRecommendController N2 = N2();
        int id5 = g16.f419340d.getId();
        ZPlanTabContainerView zPlanTabContainerView = g16.f419341e;
        Intrinsics.checkNotNullExpressionValue(zPlanTabContainerView, "binding.tabContainer");
        N2.m(id5, this, zPlanTabContainerView, getIntent());
        this.mViewBinding = g16;
        com.tencent.sqshow.zootopia.utils.a.a(this);
        ZPlanTabServerDataManager.q(ZPlanTabServerDataManager.f372670a, null, 1, null);
        ((IZPlanUECacheHelper) QRoute.api(IZPlanUECacheHelper.class)).refreshCache();
        ZootopiaStartUpReport.f372678a.d(getIntent().getExtras());
        ZplanDataBaseHelper.h();
        W2();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.recommend.main.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanMainRecommendActivity.M2(ZPlanMainRecommendActivity.this);
            }
        }, 1000L);
        QLog.i("ZPlanMainRecommendActivity_", 1, "printDebugQQVersion - " + ab.INSTANCE.a());
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        N2().n();
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).clearCache(this);
        wa4.b.f445350a.p();
        VideoUtils.f373236a.c();
        ((IZPlanNetSpeedHelper) QRoute.api(IZPlanNetSpeedHelper.class)).clearSpeed();
        ZPlanRedDotManager.f373437a.p();
        if (ZPlanQQMC.INSTANCE.destroyDataBaseHelper()) {
            ZplanDataBaseHelper.d();
        }
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).setPreRecordShareListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        setIntent(intent);
        N2().p(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        g gVar = this.mViewBinding;
        View view = gVar != null ? gVar.f419338b : null;
        if (view != null) {
            view.setVisibility(0);
        }
        N2().q();
        AbstractGifImage.pauseAll();
        if (this.isReceiverRegister.compareAndSet(true, false)) {
            unregisterReceiver(Q2());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        QLog.i("ZPlanMainRecommendActivity_", 1, "doOnResume - " + this);
        g gVar = this.mViewBinding;
        View view = gVar != null ? gVar.f419338b : null;
        if (view != null) {
            view.setVisibility(8);
        }
        N2().r();
        ZootopiaStartUpReport.f372678a.e(getIntent().getExtras());
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
        if (this.isReceiverRegister.compareAndSet(false, true)) {
            registerReceiver(Q2(), new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        N2().g();
        super.finish();
        N2().f();
        QLog.i("ZPlanMainRecommendActivity_", 1, "finish - " + this);
        K2();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        p74.a aVar = this.zplanTheme;
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
        return aVar.b(resources);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            Object systemService = super.getSystemService(name);
            if (systemService instanceof LayoutInflater) {
                return this.zplanTheme.a((LayoutInflater) systemService);
            }
        }
        return super.getSystemService(name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // mqq.app.AppActivity
    protected boolean needRestoreFragmentAfterRecreate() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        if (N2().onBackPressedEvent()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        QLog.i("ZPlanMainRecommendActivity_", 1, "onPostThemeChanged");
        com.tencent.sqshow.zootopia.utils.a.a(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        J2(outState);
        J2(outState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/main/ZPlanMainRecommendActivity$HomeReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "setSource", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "source", "Lid3/d;", "b", "Lid3/d;", "getReportHelper", "()Lid3/d;", "setReportHelper", "(Lid3/d;)V", "reportHelper", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Lid3/d;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class HomeReceiver extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private ZootopiaSource source;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private id3.d reportHelper;

        public HomeReceiver(ZootopiaSource source, id3.d reportHelper) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(reportHelper, "reportHelper");
            this.source = source;
            this.reportHelper = reportHelper;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            HashMap hashMapOf;
            HashMap hashMapOf2;
            if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                id3.d dVar = this.reportHelper;
                Pair[] pairArr = new Pair[4];
                ZootopiaSource c16 = ag.f373258a.c(this.source);
                if (c16 == null) {
                    c16 = ZootopiaSource.INSTANCE.i();
                }
                pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(c16));
                pairArr[1] = TuplesKt.to("dt_pgid", "pg_zplan_paradise");
                pairArr[2] = TuplesKt.to("zplan_return_type", "2");
                pairArr[3] = TuplesKt.to("zplan_return_to", "1");
                hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
                dVar.d("ev_zplan_page_return", hashMapOf);
                mb4.c cVar = mb4.c.f416532a;
                hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_exit_mode", "3"));
                mb4.c.c(cVar, "e_zplan__exit", hashMapOf2, false, 4, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L2(View view) {
        QLog.i("ZPlanMainRecommendActivity_", 1, "clickConsumer clicked!");
    }

    private final void J2(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        savedInstanceState.remove("android:viewHierarchyState");
        savedInstanceState.remove("android:fragments");
        savedInstanceState.remove("android:support:fragments");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int requestCode, int requestCode2, Intent data) {
        if (20001 == requestCode) {
            QLog.d("ZPlanMainRecommendActivity_", 1, "[doOnActivityResult] " + requestCode + ", " + requestCode2);
            if (-1 == requestCode2) {
                QQToastUtil.showQQToast(2, R.string.hj9);
            } else {
                QQToastUtil.showQQToast(1, R.string.hiu);
            }
        }
        super.doOnActivityResult(requestCode, requestCode2, data);
    }

    public static /* synthetic */ boolean U2(ZPlanMainRecommendActivity zPlanMainRecommendActivity, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return zPlanMainRecommendActivity.T2(z16);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return U2(this, false, 1, null);
        }
        return super.onKeyDown(keyCode, event);
    }
}
