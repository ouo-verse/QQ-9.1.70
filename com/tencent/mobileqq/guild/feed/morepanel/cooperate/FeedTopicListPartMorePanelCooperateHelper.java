package com.tencent.mobileqq.guild.feed.morepanel.cooperate;

import android.app.Activity;
import androidx.core.os.BundleKt;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher;
import com.tencent.mobileqq.guild.feed.morepanel.FeedSharePanelReportHelper;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u00020\u0004:\u0001\u0018B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\"\u0010#J(\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0007J:\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010!\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001e\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedTopicListPartMorePanelCooperateHelper;", "Lzp1/a;", "Lvn1/b;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/ioc/IMorePanelLauncherIoc;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Lvk1/a;", "feedSourceDataProvider", "", "topicId", "", "topicName", "", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "position", "data", "Landroidx/core/util/Supplier;", "", "", "dtParamSupplier", "mediaIndex", "a", "Landroidx/fragment/app/Fragment;", "d", "Landroidx/fragment/app/Fragment;", "fragment", "Lyl1/k;", "Lcom/tencent/mobileqq/guild/feed/morepanel/f;", "e", "Lyl1/k;", "morePanelHandle", "<init>", "(Landroidx/fragment/app/Fragment;)V", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedTopicListPartMorePanelCooperateHelper implements zp1.a<vn1.b>, LifecycleObserver {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f220228f = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment fragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> morePanelHandle;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedTopicListPartMorePanelCooperateHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedTopicListPartMorePanelCooperateHelper$b", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider$c;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements FeedMorePanelBusiImpl.OperationListProvider.c {
        b() {
        }
    }

    public FeedTopicListPartMorePanelCooperateHelper(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        fragment.getViewLifecycleOwner().getLifecycle().addObserver(this);
    }

    private final void b(com.tencent.mobileqq.guild.feed.morepanel.k launchParam, vk1.a feedSourceDataProvider, long topicId, String topicName) {
        PanelContext<Activity, vk1.b> e16 = launchParam.e();
        e16.getExtra().putInt("src_business_type", 20);
        e16.getExtra().putBoolean("preserve_edit_action", true);
        e16.getExtra().putBoolean("extra_key_is_whole_feed", false);
        e16.getExtra().putBundle("topic_element_append", BundleKt.bundleOf(TuplesKt.to("topic_id", Long.valueOf(topicId)), TuplesKt.to("topic_name", topicName), TuplesKt.to("topic_auto_insert", Boolean.FALSE)));
        e16.getApiRouter().a(com.tencent.mobileqq.guild.feed.morepanel.g.class, new FeedSharePanelReportHelper(feedSourceDataProvider, launchParam.getOperationListProvider(), null, 4, null));
        e16.getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.c.class, new b());
        com.tencent.mobileqq.guild.feed.morepanel.i.c(e16.getApiRouter(), LifecycleOwnerKt.getLifecycleScope(this.fragment));
    }

    @Override // zp1.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void f(int position, @NotNull vn1.b data, @NotNull Supplier<Map<String, Object>> dtParamSupplier, int mediaIndex) {
        com.tencent.mobileqq.guild.feed.morepanel.f b16;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(dtParamSupplier, "dtParamSupplier");
        yl1.k<? extends com.tencent.mobileqq.guild.feed.morepanel.f> kVar = this.morePanelHandle;
        boolean z16 = false;
        if (kVar != null && (b16 = kVar.b()) != null && b16.isShowing()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("FeedTopicListPartMorePanelCooperateHelper", 1, "morePanel is already showing");
            return;
        }
        vk1.a aVar = new vk1.a(data.d());
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        FeedMorePanelLauncher feedMorePanelLauncher = new FeedMorePanelLauncher("pindao_feed");
        com.tencent.mobileqq.guild.feed.morepanel.k d16 = feedMorePanelLauncher.d(requireActivity, aVar, new Function2<com.tencent.mobileqq.guild.feed.morepanel.k, PanelContext<Activity, vk1.b>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedTopicListPartMorePanelCooperateHelper$openMorePanel$1$1

            @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedTopicListPartMorePanelCooperateHelper$openMorePanel$1$1$a", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider;", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a extends FeedMorePanelBusiImpl.OperationListProvider {
                a(PanelContext<Activity, vk1.b> panelContext) {
                    super(panelContext);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider
                @NotNull
                public List<ShareActionSheetBuilder.ActionSheetItem> f() {
                    AppInterface appInterface;
                    IRuntimeService iRuntimeService;
                    String r16 = k().j().r();
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    String str = null;
                    if (peekAppRuntime instanceof AppInterface) {
                        appInterface = (AppInterface) peekAppRuntime;
                    } else {
                        appInterface = null;
                    }
                    if (appInterface != null) {
                        iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
                    } else {
                        iRuntimeService = null;
                    }
                    IGPSService iGPSService = (IGPSService) iRuntimeService;
                    if (iGPSService != null) {
                        str = iGPSService.getSelfTinyId();
                    }
                    boolean areEqual = Intrinsics.areEqual(r16, str);
                    LinkedList<ShareActionSheetBuilder.ActionSheetItem> c16 = c(new int[]{94, 153, 1, 11});
                    if (!areEqual) {
                        l(c16, 94);
                    } else {
                        l(c16, 11);
                    }
                    return c16;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.guild.feed.morepanel.k kVar2, PanelContext<Activity, vk1.b> panelContext) {
                invoke2(kVar2, panelContext);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.guild.feed.morepanel.k buildLaunchParam, @NotNull PanelContext<Activity, vk1.b> it) {
                Intrinsics.checkNotNullParameter(buildLaunchParam, "$this$buildLaunchParam");
                Intrinsics.checkNotNullParameter(it, "it");
                buildLaunchParam.f(new FeedMorePanelBusiImpl.a(it));
                buildLaunchParam.i(new a(it));
            }
        });
        d16.h(new com.tencent.mobileqq.guild.feed.morepanel.impl.k(d16.e()));
        b(d16, aVar, data.getExt().getTopicId(), "");
        this.morePanelHandle = feedMorePanelLauncher.h();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.morePanelHandle = null;
    }
}
