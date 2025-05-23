package com.tencent.mobileqq.zootopia.ue;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.lua.ZPlanPortalStoreLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaGameLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaShareArkPlugin;
import com.tencent.mobileqq.zootopia.lua.ag;
import com.tencent.mobileqq.zootopia.lua.ai;
import com.tencent.mobileqq.zootopia.lua.ao;
import com.tencent.mobileqq.zootopia.lua.ap;
import com.tencent.mobileqq.zootopia.lua.aq;
import com.tencent.mobileqq.zootopia.lua.ba;
import com.tencent.mobileqq.zootopia.lua.bb;
import com.tencent.mobileqq.zootopia.lua.bc;
import com.tencent.mobileqq.zootopia.lua.be;
import com.tencent.mobileqq.zootopia.lua.o;
import com.tencent.mobileqq.zootopia.lua.z;
import com.tencent.mobileqq.zplan.lua.plugins.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.luabridge.ZPlanLuaBridge;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\\\u0010]J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b$\u0010%R\u001b\u0010*\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u0015\u001a\u0004\b2\u00103R\u001b\u00107\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b\u001f\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010\u0015\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010\u0015\u001a\u0004\b\u0014\u0010>R\u001b\u0010B\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u0015\u001a\u0004\b,\u0010AR\u001b\u0010E\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b1\u0010DR\u001b\u0010J\u001a\u00020F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010\u0015\u001a\u0004\bH\u0010IR\u001b\u0010M\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b\u001a\u0010LR\u001b\u0010Q\u001a\u00020N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\bO\u0010PR\u001b\u0010T\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010\u0015\u001a\u0004\b9\u0010SR\u001b\u0010X\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010\u0015\u001a\u0004\bV\u0010WR\u001b\u0010[\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010\u0015\u001a\u0004\bG\u0010Z\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "", "", "v", "y", "u", HippyTKDListViewAdapter.X, "", "isPortal", "w", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "b", "()Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "viewManager", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaGameLuaPlugin;", "c", "Lkotlin/Lazy;", "f", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaGameLuaPlugin;", "gamePlugin", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShareArkPlugin;", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShareArkPlugin;", "shareArkPlugin", "Lke3/e;", "e", "j", "()Lke3/e;", "miniAIOPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ao;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/zootopia/lua/ao;", "portalPlugin", "Lcom/tencent/mobileqq/zootopia/lua/a;", "g", "()Lcom/tencent/mobileqq/zootopia/lua/a;", "giftPackLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ba;", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/zootopia/lua/ba;", "permissionPlug", "Lcom/tencent/mobileqq/zootopia/lua/g;", "i", "l", "()Lcom/tencent/mobileqq/zootopia/lua/g;", "payViewLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ap;", "()Lcom/tencent/mobileqq/zootopia/lua/ap;", "friendInvitationPlugin", "Lcom/tencent/mobileqq/zootopia/lua/bb;", "k", "p", "()Lcom/tencent/mobileqq/zootopia/lua/bb;", "qzoneLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ai;", "()Lcom/tencent/mobileqq/zootopia/lua/ai;", "audioPlugin", "Lcom/tencent/mobileqq/zootopia/lua/aq;", "()Lcom/tencent/mobileqq/zootopia/lua/aq;", "handleLuaPlugin", "Lcom/tencent/mobileqq/zplan/video/impl/plugin/e;", "()Lcom/tencent/mobileqq/zplan/video/impl/plugin/e;", "mediaPlugin", "Lcom/tencent/mobileqq/zplan/web/impl/c;", "o", "r", "()Lcom/tencent/mobileqq/zplan/web/impl/c;", "webViewPlugin", "Lcom/tencent/mobileqq/zootopia/lua/be;", "()Lcom/tencent/mobileqq/zootopia/lua/be;", "cartShoppingLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/z;", "t", "()Lcom/tencent/mobileqq/zootopia/lua/z;", "zplanScreenParamsLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/o;", "()Lcom/tencent/mobileqq/zootopia/lua/o;", "overlapCheckPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ag;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/zootopia/lua/ag;", "wxMiniAppPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ZPlanPortalStoreLuaPlugin;", "()Lcom/tencent/mobileqq/zootopia/lua/ZPlanPortalStoreLuaPlugin;", "portalStorePlugin", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UEActivityPluginManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaUEActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final UEActivityViewManager viewManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy gamePlugin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy shareArkPlugin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy miniAIOPlugin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy portalPlugin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy giftPackLuaPlugin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy permissionPlug;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy payViewLuaPlugin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy friendInvitationPlugin;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Lazy qzoneLuaPlugin;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final Lazy audioPlugin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy handleLuaPlugin;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final Lazy mediaPlugin;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final Lazy webViewPlugin;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Lazy cartShoppingLuaPlugin;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Lazy zplanScreenParamsLuaPlugin;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Lazy overlapCheckPlugin;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final Lazy wxMiniAppPlugin;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Lazy portalStorePlugin;

    public UEActivityPluginManager(ZootopiaUEActivity activity, UEActivityViewManager viewManager) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        Lazy lazy16;
        Lazy lazy17;
        Lazy lazy18;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        this.activity = activity;
        this.viewManager = viewManager;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaGameLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$gamePlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaGameLuaPlugin invoke() {
                return new ZootopiaGameLuaPlugin(UEActivityPluginManager.this.getActivity());
            }
        });
        this.gamePlugin = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaShareArkPlugin>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$shareArkPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaShareArkPlugin invoke() {
                return new ZootopiaShareArkPlugin(UEActivityPluginManager.this.getActivity());
            }
        });
        this.shareArkPlugin = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ke3.e>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$miniAIOPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ke3.e invoke() {
                return new ke3.e(UEActivityPluginManager.this.getActivity());
            }
        });
        this.miniAIOPlugin = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ao>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$portalPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ao invoke() {
                return new ao(UEActivityPluginManager.this.getActivity(), UEActivityPluginManager.this.getActivity().getSource());
            }
        });
        this.portalPlugin = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zootopia.lua.a>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$giftPackLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zootopia.lua.a invoke() {
                return new com.tencent.mobileqq.zootopia.lua.a(UEActivityPluginManager.this.getActivity());
            }
        });
        this.giftPackLuaPlugin = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ba>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$permissionPlug$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ba invoke() {
                return new ba(UEActivityPluginManager.this.getActivity());
            }
        });
        this.permissionPlug = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zootopia.lua.g>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$payViewLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zootopia.lua.g invoke() {
                return new com.tencent.mobileqq.zootopia.lua.g(UEActivityPluginManager.this.getActivity());
            }
        });
        this.payViewLuaPlugin = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ap>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$friendInvitationPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ap invoke() {
                return new ap(UEActivityPluginManager.this.getActivity());
            }
        });
        this.friendInvitationPlugin = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<bb>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$qzoneLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final bb invoke() {
                return new bb(UEActivityPluginManager.this.getActivity());
            }
        });
        this.qzoneLuaPlugin = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ai>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$audioPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ai invoke() {
                return new ai(UEActivityPluginManager.this.getActivity());
            }
        });
        this.audioPlugin = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<aq>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$handleLuaPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final aq invoke() {
                return new aq();
            }
        });
        this.handleLuaPlugin = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zplan.video.impl.plugin.e>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$mediaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zplan.video.impl.plugin.e invoke() {
                UEActivityViewManager uEActivityViewManager;
                uEActivityViewManager = UEActivityPluginManager.this.viewManager;
                return new com.tencent.mobileqq.zplan.video.impl.plugin.e(uEActivityViewManager);
            }
        });
        this.mediaPlugin = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zplan.web.impl.c>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$webViewPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zplan.web.impl.c invoke() {
                UEActivityViewManager uEActivityViewManager;
                uEActivityViewManager = UEActivityPluginManager.this.viewManager;
                return new com.tencent.mobileqq.zplan.web.impl.c(uEActivityViewManager);
            }
        });
        this.webViewPlugin = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<be>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$cartShoppingLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final be invoke() {
                UEActivityViewManager uEActivityViewManager;
                uEActivityViewManager = UEActivityPluginManager.this.viewManager;
                return new be(uEActivityViewManager);
            }
        });
        this.cartShoppingLuaPlugin = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<z>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$zplanScreenParamsLuaPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final z invoke() {
                return new z();
            }
        });
        this.zplanScreenParamsLuaPlugin = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<o>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$overlapCheckPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final o invoke() {
                UEActivityViewManager uEActivityViewManager;
                ZootopiaUEActivity activity2 = UEActivityPluginManager.this.getActivity();
                uEActivityViewManager = UEActivityPluginManager.this.viewManager;
                return new o(activity2, uEActivityViewManager);
            }
        });
        this.overlapCheckPlugin = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<ag>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$wxMiniAppPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ag invoke() {
                return new ag(UEActivityPluginManager.this.getActivity());
            }
        });
        this.wxMiniAppPlugin = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanPortalStoreLuaPlugin>() { // from class: com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager$portalStorePlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanPortalStoreLuaPlugin invoke() {
                UEActivityViewManager uEActivityViewManager;
                uEActivityViewManager = UEActivityPluginManager.this.viewManager;
                return new ZPlanPortalStoreLuaPlugin(uEActivityViewManager);
            }
        });
        this.portalStorePlugin = lazy18;
    }

    private final ai c() {
        return (ai) this.audioPlugin.getValue();
    }

    private final be d() {
        return (be) this.cartShoppingLuaPlugin.getValue();
    }

    private final ap e() {
        return (ap) this.friendInvitationPlugin.getValue();
    }

    private final ZootopiaGameLuaPlugin f() {
        return (ZootopiaGameLuaPlugin) this.gamePlugin.getValue();
    }

    private final com.tencent.mobileqq.zootopia.lua.a g() {
        return (com.tencent.mobileqq.zootopia.lua.a) this.giftPackLuaPlugin.getValue();
    }

    private final aq h() {
        return (aq) this.handleLuaPlugin.getValue();
    }

    private final com.tencent.mobileqq.zplan.video.impl.plugin.e i() {
        return (com.tencent.mobileqq.zplan.video.impl.plugin.e) this.mediaPlugin.getValue();
    }

    private final ke3.e j() {
        return (ke3.e) this.miniAIOPlugin.getValue();
    }

    private final o k() {
        return (o) this.overlapCheckPlugin.getValue();
    }

    private final com.tencent.mobileqq.zootopia.lua.g l() {
        return (com.tencent.mobileqq.zootopia.lua.g) this.payViewLuaPlugin.getValue();
    }

    private final ba m() {
        return (ba) this.permissionPlug.getValue();
    }

    private final ao n() {
        return (ao) this.portalPlugin.getValue();
    }

    private final ZPlanPortalStoreLuaPlugin o() {
        return (ZPlanPortalStoreLuaPlugin) this.portalStorePlugin.getValue();
    }

    private final bb p() {
        return (bb) this.qzoneLuaPlugin.getValue();
    }

    private final ZootopiaShareArkPlugin q() {
        return (ZootopiaShareArkPlugin) this.shareArkPlugin.getValue();
    }

    private final com.tencent.mobileqq.zplan.web.impl.c r() {
        return (com.tencent.mobileqq.zplan.web.impl.c) this.webViewPlugin.getValue();
    }

    private final ag s() {
        return (ag) this.wxMiniAppPlugin.getValue();
    }

    private final z t() {
        return (z) this.zplanScreenParamsLuaPlugin.getValue();
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaUEActivity getActivity() {
        return this.activity;
    }

    public void u() {
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        ZPlanLuaBridge.evaluateWaitList$default(zPlanLuaBridge, false, 1, null);
        zPlanLuaBridge.registerPlugin(l());
    }

    public void v() {
        QLog.i("PluginManager_", 1, "registerPlugins");
        ZPlanServiceHelper.I.D0(this.activity);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        zPlanLuaBridge.registerPlugin(com.tencent.zplan.luabridge.plugins.a.f385727e);
        zPlanLuaBridge.registerPlugin(f());
        zPlanLuaBridge.registerPlugin(q());
        zPlanLuaBridge.registerPlugin(j());
        zPlanLuaBridge.registerPlugin(g());
        zPlanLuaBridge.registerPlugin(m());
        zPlanLuaBridge.registerPlugin(e());
        zPlanLuaBridge.registerPlugin(c());
        zPlanLuaBridge.registerPlugin(p());
        zPlanLuaBridge.registerPlugin(i());
        zPlanLuaBridge.registerPlugin(r());
        zPlanLuaBridge.registerPlugin(h());
        zPlanLuaBridge.registerPlugin(d());
        zPlanLuaBridge.registerPlugin(t());
        zPlanLuaBridge.registerPlugin(k());
        bc bcVar = bc.f328541d;
        bcVar.a(this.activity);
        zPlanLuaBridge.registerPlugin(bcVar);
        zPlanLuaBridge.registerPlugin(j.f333850d);
        zPlanLuaBridge.registerPlugin(s());
        zPlanLuaBridge.registerPlugin(o());
        ai.INSTANCE.l(true);
    }

    public void w(boolean isPortal) {
        f().k(isPortal);
    }

    public void x() {
        ZPlanLuaBridge.INSTANCE.removePlugin(l());
    }

    public void y() {
        QLog.i("PluginManager_", 1, "unRegisterPlugins");
        bc.f328541d.b(this.activity);
        ZPlanServiceHelper.I.Z0(this.activity);
        ZPlanLuaBridge zPlanLuaBridge = ZPlanLuaBridge.INSTANCE;
        zPlanLuaBridge.removePlugin(com.tencent.zplan.luabridge.plugins.a.f385727e);
        zPlanLuaBridge.removePlugin(f());
        zPlanLuaBridge.removePlugin(q());
        zPlanLuaBridge.removePlugin(j());
        zPlanLuaBridge.removePlugin(n());
        zPlanLuaBridge.removePlugin(g());
        zPlanLuaBridge.removePlugin(m());
        zPlanLuaBridge.removePlugin(e());
        zPlanLuaBridge.removePlugin(c());
        zPlanLuaBridge.removePlugin(p());
        zPlanLuaBridge.removePlugin(i());
        zPlanLuaBridge.removePlugin(r());
        zPlanLuaBridge.removePlugin(h());
        zPlanLuaBridge.removePlugin(d());
        zPlanLuaBridge.removePlugin(t());
        zPlanLuaBridge.removePlugin(k());
        zPlanLuaBridge.removePlugin(j.f333850d);
        ai.INSTANCE.l(false);
        zPlanLuaBridge.removePlugin(s());
        zPlanLuaBridge.removePlugin(o());
    }
}
