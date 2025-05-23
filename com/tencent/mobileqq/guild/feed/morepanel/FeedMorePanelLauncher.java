package com.tencent.mobileqq.guild.feed.morepanel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.impl.NewFeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.k;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005H\u0002J\u0010\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0002JI\u0010\u0015\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r21\b\u0002\u0010\u0014\u001a+\u0012\u0004\u0012\u00020\u0010\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\u0005j\u0002`\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f\u00a2\u0006\u0002\b\u0013J\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/FeedMorePanelLauncher;", "", "Lyl1/k;", "Lcom/tencent/mobileqq/guild/feed/morepanel/f;", "k", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/content/Context;", "panelContext", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "f", "i", "Landroid/app/Activity;", "context", "Lvk1/b;", "feed", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "", "Lkotlin/ExtensionFunctionType;", "paramInit", "d", tl.h.F, "", "a", "Ljava/lang/String;", WadlProxyConsts.SCENE_ID, "b", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", "c", "Lkotlin/Lazy;", "g", "()Z", "useNewSharePanel", "<init>", "(Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMorePanelLauncher {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private k launchParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy useNewSharePanel;

    public FeedMorePanelLauncher(@NotNull String sceneId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        this.sceneId = sceneId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher$useNewSharePanel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                String str;
                ISharePanelApi iSharePanelApi = (ISharePanelApi) QRoute.api(ISharePanelApi.class);
                str = FeedMorePanelLauncher.this.sceneId;
                boolean useNewSharePanel = iSharePanelApi.useNewSharePanel(str);
                boolean f16 = FeedMorePanelUtils.f220193a.f();
                Logger.f235387a.d().i("FeedNativeDetailMorePanel", 1, "useNewSharePanel:" + useNewSharePanel + " useNewFeedShareArk:" + f16);
                return Boolean.valueOf(useNewSharePanel && f16);
            }
        });
        this.useNewSharePanel = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ k e(FeedMorePanelLauncher feedMorePanelLauncher, Activity activity, vk1.b bVar, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function2 = null;
        }
        return feedMorePanelLauncher.d(activity, bVar, function2);
    }

    private final ShareActionSheet f(PanelContext<? extends Context, ?> panelContext) {
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        g gVar = (g) panelContext.getApiRouter().b(g.class);
        param.context = panelContext.h();
        param.actionSheetRender = gVar;
        param.itemRender = gVar;
        ShareActionSheet shareActionSheet = ShareActionSheetFactory.create(param);
        shareActionSheet.setRowVisibility(0, 0, 0);
        shareActionSheet.setIntentForStartForwardRecentActivity(new Intent());
        Intrinsics.checkNotNullExpressionValue(shareActionSheet, "shareActionSheet");
        return shareActionSheet;
    }

    private final boolean g() {
        return ((Boolean) this.useNewSharePanel.getValue()).booleanValue();
    }

    private final yl1.k<? extends f> i() {
        k kVar = this.launchParam;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
            kVar = null;
        }
        PanelContext<Activity, vk1.b> e16 = kVar.e();
        ISharePanelApi iSharePanelApi = (ISharePanelApi) QRoute.api(ISharePanelApi.class);
        k kVar2 = this.launchParam;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
            kVar2 = null;
        }
        Activity h16 = kVar2.e().h();
        Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) h16;
        k kVar3 = this.launchParam;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
            kVar3 = null;
        }
        com.tencent.mobileqq.sharepanel.f createSharePanel = iSharePanelApi.createSharePanel(fragmentActivity, kVar3.c().c());
        k kVar4 = this.launchParam;
        if (kVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
            kVar4 = null;
        }
        com.tencent.mobileqq.sharepanel.j newItemClickListener = kVar4.getNewItemClickListener();
        if (newItemClickListener != null) {
            createSharePanel.t0(newItemClickListener);
        }
        createSharePanel.k0(new NewFeedMorePanelBusiImpl.FeedPrepareForwardHandler(e16));
        createSharePanel.f0(new NewFeedMorePanelBusiImpl.FeedPrepareForwardCallback(e16));
        k kVar5 = this.launchParam;
        if (kVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
            kVar5 = null;
        }
        k.b c16 = kVar5.c();
        c16.b(createSharePanel);
        c16.e(createSharePanel);
        c16.a(createSharePanel);
        c16.d(createSharePanel);
        createSharePanel.d0(c16.getReportParams());
        e16.e(null);
        createSharePanel.show();
        final yl1.k<? extends f> kVar6 = new yl1.k<>(new j(createSharePanel));
        e16.b(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.a
            @Override // java.lang.Runnable
            public final void run() {
                FeedMorePanelLauncher.j(yl1.k.this);
            }
        });
        return kVar6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(yl1.k this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        QLog.i("FeedNativeDetailMorePanel", 4, "onClear");
        this_apply.a();
    }

    private final yl1.k<? extends f> k() {
        k kVar = this.launchParam;
        k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
            kVar = null;
        }
        PanelContext<Activity, vk1.b> e16 = kVar.e();
        ShareActionSheet f16 = f(e16);
        e16.h().getIntent().putExtra("big_brother_source_key", e16.getExtra().getString("big_brother_source_key"));
        k kVar3 = this.launchParam;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
            kVar3 = null;
        }
        k.a operationListProvider = kVar3.getOperationListProvider();
        if (operationListProvider != null) {
            f16.setActionSheetItems(new ArrayList(operationListProvider.b()), new ArrayList(operationListProvider.a()));
        }
        k kVar4 = this.launchParam;
        if (kVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        } else {
            kVar2 = kVar4;
        }
        ShareActionSheet.c itemClickListener = kVar2.getItemClickListener();
        if (itemClickListener != null) {
            f16.setItemClickListenerV3(itemClickListener);
        }
        e16.e(f16);
        f16.show();
        final yl1.k<? extends f> kVar5 = new yl1.k<>(new l(f16));
        e16.b(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.b
            @Override // java.lang.Runnable
            public final void run() {
                FeedMorePanelLauncher.l(yl1.k.this);
            }
        });
        return kVar5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(yl1.k this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        QLog.i("FeedNativeDetailMorePanel", 4, "onClear");
        this_apply.a();
    }

    @NotNull
    public final k d(@NotNull Activity context, @NotNull vk1.b feed, @Nullable Function2<? super k, ? super PanelContext<Activity, vk1.b>, Unit> paramInit) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (g()) {
            this.launchParam = NewFeedMorePanelBusiImpl.INSTANCE.c(context, feed);
        } else {
            FeedMorePanelBusiImpl.Companion companion = FeedMorePanelBusiImpl.INSTANCE;
            if (paramInit == null) {
                paramInit = new Function2<k, PanelContext<Activity, vk1.b>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher$buildLaunchParam$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(k kVar, PanelContext<Activity, vk1.b> panelContext) {
                        invoke2(kVar, panelContext);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull k kVar, @NotNull PanelContext<Activity, vk1.b> it) {
                        Intrinsics.checkNotNullParameter(kVar, "$this$null");
                        Intrinsics.checkNotNullParameter(it, "it");
                        kVar.f(new FeedMorePanelBusiImpl.a(it));
                        kVar.i(new FeedMorePanelBusiImpl.OperationListProvider(it));
                    }
                };
            }
            this.launchParam = companion.h(context, feed, paramInit);
        }
        k kVar = this.launchParam;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
            return null;
        }
        return kVar;
    }

    @NotNull
    public final yl1.k<? extends f> h() {
        if (g()) {
            return i();
        }
        return k();
    }
}
