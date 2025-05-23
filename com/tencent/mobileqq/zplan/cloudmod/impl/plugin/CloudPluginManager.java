package com.tencent.mobileqq.zplan.cloudmod.impl.plugin;

import androidx.fragment.app.FragmentActivity;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.lua.ZPlanThirdAuthLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaGameLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaShareArkPlugin;
import com.tencent.mobileqq.zootopia.lua.ZootopiaSsoLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ag;
import com.tencent.mobileqq.zootopia.lua.ai;
import com.tencent.mobileqq.zootopia.lua.al;
import com.tencent.mobileqq.zootopia.lua.ao;
import com.tencent.mobileqq.zootopia.lua.ap;
import com.tencent.mobileqq.zootopia.lua.aq;
import com.tencent.mobileqq.zootopia.lua.bb;
import com.tencent.mobileqq.zootopia.lua.be;
import com.tencent.mobileqq.zootopia.lua.g;
import com.tencent.mobileqq.zootopia.lua.o;
import com.tencent.mobileqq.zootopia.lua.z;
import com.tencent.mobileqq.zootopia.ue.UEActivityViewManager;
import com.tencent.mobileqq.zplan.lua.plugins.i;
import com.tencent.mobileqq.zplan.web.impl.c;
import ke3.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import ux4.b;

@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\bh\u0010iJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b+\u0010,R\u001b\u00101\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b/\u00100R\u001b\u00105\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\u0012\u001a\u0004\b&\u00104R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u0010\u0012\u001a\u0004\b8\u00109R\u001b\u0010=\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b\u0011\u0010<R\u001b\u0010A\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010\u0012\u001a\u0004\b3\u0010@R\u001b\u0010D\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b7\u0010CR\u001b\u0010H\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\bF\u0010GR\u001b\u0010K\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010\u0012\u001a\u0004\b\u0017\u0010JR\u001b\u0010O\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\bM\u0010NR\u001b\u0010S\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010\u0012\u001a\u0004\b?\u0010RR\u001b\u0010W\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010\u0012\u001a\u0004\b\u001c\u0010VR\u001b\u0010Z\u001a\u00020X8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b!\u0010YR\u001b\u0010]\u001a\u00020[8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u000b\u0010\\R\u001b\u0010`\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bQ\u0010_R\u001b\u0010d\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010\u0012\u001a\u0004\bU\u0010cR\u001b\u0010g\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010\u0012\u001a\u0004\bb\u0010f\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/zplan/cloudmod/impl/plugin/CloudPluginManager;", "", "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "()Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "b", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "u", "()Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "viewManager", "Lcom/tencent/mobileqq/zplan/lua/plugins/i;", "c", "Lkotlin/Lazy;", "t", "()Lcom/tencent/mobileqq/zplan/lua/plugins/i;", "toastPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaGameLuaPlugin;", "d", h.F, "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaGameLuaPlugin;", "gamePlugin", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShareArkPlugin;", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaShareArkPlugin;", "shareArkPlugin", "Lke3/e;", "f", "l", "()Lke3/e;", "miniAIOPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ao;", "g", "o", "()Lcom/tencent/mobileqq/zootopia/lua/ao;", "portalPlugin", "Lcom/tencent/mobileqq/zootopia/lua/a;", "i", "()Lcom/tencent/mobileqq/zootopia/lua/a;", "giftPackLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/g;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/zootopia/lua/g;", "payViewLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ap;", "j", "()Lcom/tencent/mobileqq/zootopia/lua/ap;", "friendInvitationPlugin", "Lcom/tencent/mobileqq/zootopia/lua/bb;", "k", "p", "()Lcom/tencent/mobileqq/zootopia/lua/bb;", "qzoneLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ai;", "()Lcom/tencent/mobileqq/zootopia/lua/ai;", "audioPlugin", "Lcom/tencent/mobileqq/zootopia/lua/aq;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/zootopia/lua/aq;", "handleLuaPlugin", "Lcom/tencent/mobileqq/zplan/video/impl/plugin/e;", "()Lcom/tencent/mobileqq/zplan/video/impl/plugin/e;", "mediaPlugin", "Lcom/tencent/mobileqq/zplan/web/impl/c;", "v", "()Lcom/tencent/mobileqq/zplan/web/impl/c;", "webViewPlugin", "Lcom/tencent/mobileqq/zootopia/lua/be;", "()Lcom/tencent/mobileqq/zootopia/lua/be;", "cartShoppingLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/z;", HippyTKDListViewAdapter.X, "()Lcom/tencent/mobileqq/zootopia/lua/z;", "zplanScreenParamsLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/o;", "r", "()Lcom/tencent/mobileqq/zootopia/lua/o;", "overlapCheckPlugin", "Lcom/tencent/mobileqq/zplan/cloudmod/impl/plugin/a;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/zplan/cloudmod/impl/plugin/a;", "cloudModPlugin", "Lcom/tencent/mobileqq/zootopia/lua/al;", "()Lcom/tencent/mobileqq/zootopia/lua/al;", "debugLuaPlugin", "Lcom/tencent/mobileqq/zplan/lua/plugins/a;", "()Lcom/tencent/mobileqq/zplan/lua/plugins/a;", "appInfoPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ZootopiaSsoLuaPlugin;", "()Lcom/tencent/mobileqq/zootopia/lua/ZootopiaSsoLuaPlugin;", "ssoLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ZPlanThirdAuthLuaPlugin;", "w", "()Lcom/tencent/mobileqq/zootopia/lua/ZPlanThirdAuthLuaPlugin;", "thirdAuthLuaPlugin", "Lcom/tencent/mobileqq/zootopia/lua/ag;", "()Lcom/tencent/mobileqq/zootopia/lua/ag;", "wxMiniAppPlugin", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CloudPluginManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final FragmentActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final UEActivityViewManager viewManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy toastPlugin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy gamePlugin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy shareArkPlugin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy miniAIOPlugin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy portalPlugin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy giftPackLuaPlugin;

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
    private final Lazy cloudModPlugin;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final Lazy debugLuaPlugin;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final Lazy appInfoPlugin;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final Lazy ssoLuaPlugin;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final Lazy thirdAuthLuaPlugin;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final Lazy wxMiniAppPlugin;

    public CloudPluginManager(FragmentActivity activity, UEActivityViewManager viewManager) {
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
        Lazy lazy19;
        Lazy lazy20;
        Lazy lazy21;
        Lazy lazy22;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        this.activity = activity;
        this.viewManager = viewManager;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$toastPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i invoke() {
                return i.f333849d;
            }
        });
        this.toastPlugin = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaGameLuaPlugin>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$gamePlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaGameLuaPlugin invoke() {
                return new ZootopiaGameLuaPlugin(CloudPluginManager.this.getActivity());
            }
        });
        this.gamePlugin = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaShareArkPlugin>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$shareArkPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaShareArkPlugin invoke() {
                return new ZootopiaShareArkPlugin(CloudPluginManager.this.getActivity());
            }
        });
        this.shareArkPlugin = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$miniAIOPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return new e(CloudPluginManager.this.getActivity());
            }
        });
        this.miniAIOPlugin = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ao>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$portalPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ao invoke() {
                return new ao(CloudPluginManager.this.getActivity(), ZootopiaSource.INSTANCE.g());
            }
        });
        this.portalPlugin = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zootopia.lua.a>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$giftPackLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zootopia.lua.a invoke() {
                return new com.tencent.mobileqq.zootopia.lua.a(CloudPluginManager.this.getActivity());
            }
        });
        this.giftPackLuaPlugin = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<g>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$payViewLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final g invoke() {
                return new g(CloudPluginManager.this.getActivity());
            }
        });
        this.payViewLuaPlugin = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ap>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$friendInvitationPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ap invoke() {
                return new ap(CloudPluginManager.this.getActivity());
            }
        });
        this.friendInvitationPlugin = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<bb>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$qzoneLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final bb invoke() {
                return new bb(CloudPluginManager.this.getActivity());
            }
        });
        this.qzoneLuaPlugin = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ai>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$audioPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ai invoke() {
                return new ai(CloudPluginManager.this.getActivity());
            }
        });
        this.audioPlugin = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<aq>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$handleLuaPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final aq invoke() {
                return new aq();
            }
        });
        this.handleLuaPlugin = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zplan.video.impl.plugin.e>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$mediaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zplan.video.impl.plugin.e invoke() {
                return new com.tencent.mobileqq.zplan.video.impl.plugin.e(CloudPluginManager.this.getViewManager());
            }
        });
        this.mediaPlugin = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$webViewPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return new c(CloudPluginManager.this.getViewManager());
            }
        });
        this.webViewPlugin = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<be>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$cartShoppingLuaPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final be invoke() {
                return new be(CloudPluginManager.this.getViewManager());
            }
        });
        this.cartShoppingLuaPlugin = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<z>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$zplanScreenParamsLuaPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final z invoke() {
                return new z();
            }
        });
        this.zplanScreenParamsLuaPlugin = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<o>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$overlapCheckPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final o invoke() {
                return new o(CloudPluginManager.this.getActivity(), CloudPluginManager.this.getViewManager());
            }
        });
        this.overlapCheckPlugin = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$cloudModPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(CloudPluginManager.this.getActivity());
            }
        });
        this.cloudModPlugin = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<al>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$debugLuaPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final al invoke() {
                return al.f328496d;
            }
        });
        this.debugLuaPlugin = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zplan.lua.plugins.a>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$appInfoPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zplan.lua.plugins.a invoke() {
                return com.tencent.mobileqq.zplan.lua.plugins.a.f333829d;
            }
        });
        this.appInfoPlugin = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSsoLuaPlugin>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$ssoLuaPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSsoLuaPlugin invoke() {
                return ZootopiaSsoLuaPlugin.INSTANCE.a();
            }
        });
        this.ssoLuaPlugin = lazy20;
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanThirdAuthLuaPlugin>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$thirdAuthLuaPlugin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanThirdAuthLuaPlugin invoke() {
                return ZPlanThirdAuthLuaPlugin.INSTANCE.a();
            }
        });
        this.thirdAuthLuaPlugin = lazy21;
        lazy22 = LazyKt__LazyJVMKt.lazy(new Function0<ag>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.plugin.CloudPluginManager$wxMiniAppPlugin$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ag invoke() {
                return new ag(CloudPluginManager.this.getActivity());
            }
        });
        this.wxMiniAppPlugin = lazy22;
    }

    private final com.tencent.mobileqq.zplan.lua.plugins.a b() {
        return (com.tencent.mobileqq.zplan.lua.plugins.a) this.appInfoPlugin.getValue();
    }

    private final ai c() {
        return (ai) this.audioPlugin.getValue();
    }

    private final be d() {
        return (be) this.cartShoppingLuaPlugin.getValue();
    }

    private final a e() {
        return (a) this.cloudModPlugin.getValue();
    }

    private final al f() {
        return (al) this.debugLuaPlugin.getValue();
    }

    private final ap g() {
        return (ap) this.friendInvitationPlugin.getValue();
    }

    private final ZootopiaGameLuaPlugin h() {
        return (ZootopiaGameLuaPlugin) this.gamePlugin.getValue();
    }

    private final com.tencent.mobileqq.zootopia.lua.a i() {
        return (com.tencent.mobileqq.zootopia.lua.a) this.giftPackLuaPlugin.getValue();
    }

    private final aq j() {
        return (aq) this.handleLuaPlugin.getValue();
    }

    private final com.tencent.mobileqq.zplan.video.impl.plugin.e k() {
        return (com.tencent.mobileqq.zplan.video.impl.plugin.e) this.mediaPlugin.getValue();
    }

    private final e l() {
        return (e) this.miniAIOPlugin.getValue();
    }

    private final o m() {
        return (o) this.overlapCheckPlugin.getValue();
    }

    private final g n() {
        return (g) this.payViewLuaPlugin.getValue();
    }

    private final ao o() {
        return (ao) this.portalPlugin.getValue();
    }

    private final bb p() {
        return (bb) this.qzoneLuaPlugin.getValue();
    }

    private final ZootopiaShareArkPlugin q() {
        return (ZootopiaShareArkPlugin) this.shareArkPlugin.getValue();
    }

    private final ZootopiaSsoLuaPlugin r() {
        return (ZootopiaSsoLuaPlugin) this.ssoLuaPlugin.getValue();
    }

    private final ZPlanThirdAuthLuaPlugin s() {
        return (ZPlanThirdAuthLuaPlugin) this.thirdAuthLuaPlugin.getValue();
    }

    private final i t() {
        return (i) this.toastPlugin.getValue();
    }

    private final c v() {
        return (c) this.webViewPlugin.getValue();
    }

    private final ag w() {
        return (ag) this.wxMiniAppPlugin.getValue();
    }

    private final z x() {
        return (z) this.zplanScreenParamsLuaPlugin.getValue();
    }

    /* renamed from: a, reason: from getter */
    public final FragmentActivity getActivity() {
        return this.activity;
    }

    /* renamed from: u, reason: from getter */
    public final UEActivityViewManager getViewManager() {
        return this.viewManager;
    }

    public final void y() {
        b bVar = b.f440566e;
        bVar.g(t());
        bVar.g(d());
        bVar.g(q());
        bVar.g(e());
        bVar.g(n());
        bVar.g(f());
        bVar.g(b());
        bVar.g(h());
        bVar.g(o());
        bVar.g(i());
        bVar.g(p());
        bVar.g(j());
        bVar.g(x());
        bVar.g(m());
        bVar.g(l());
        bVar.g(g());
        bVar.g(c());
        bVar.g(k());
        bVar.g(v());
        bVar.g(r());
        bVar.g(s());
        bVar.g(w());
    }

    public final void z() {
        b bVar = b.f440566e;
        bVar.h(t());
        bVar.h(d());
        bVar.h(q());
        bVar.h(e());
        bVar.h(n());
        bVar.h(f());
        bVar.h(b());
        bVar.h(h());
        bVar.h(o());
        bVar.h(i());
        bVar.h(p());
        bVar.h(j());
        bVar.h(x());
        bVar.h(m());
        bVar.h(l());
        bVar.h(g());
        bVar.h(c());
        bVar.h(k());
        bVar.h(v());
        bVar.h(r());
        bVar.h(s());
        bVar.h(w());
    }
}
