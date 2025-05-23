package com.tencent.mobileqq.guild.discovery.publicaccount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.GuildPublicAccountParams;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart;
import com.tencent.mobileqq.guild.discoveryv2.content.preload.loadmore.PreloadMoreStrategyPart;
import com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart;
import com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends;
import com.tencent.mobileqq.guild.discoveryv2.fragment.d;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.picload.GuildFeedPicLoader;
import com.tencent.mobileqq.guild.theme.QuiBitmapResourceObtainColorHelper;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001#\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J&\u0010\u0019\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000eH\u0014R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/publicaccount/GuildPublicAccountDiscoveryFragmentV2;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "initViews", "Ih", "Lh", "initData", "Qh", "", "Mh", "Nh", "Oh", "Ph", "", "getContentLayoutId", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", "onResume", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "view", NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "resId", "yh", "com/tencent/mobileqq/guild/discovery/publicaccount/GuildPublicAccountDiscoveryFragmentV2$b", "T", "Lcom/tencent/mobileqq/guild/discovery/publicaccount/GuildPublicAccountDiscoveryFragmentV2$b;", "depends", "Lcom/tencent/mobileqq/guild/discovery/publicaccount/c;", "U", "Lcom/tencent/mobileqq/guild/discovery/publicaccount/c;", "viewModel", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "V", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "reportSourceInfo", "Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "W", "Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "pubAccountParams", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "()V", "X", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildPublicAccountDiscoveryFragmentV2 extends QQGuildTokenTitleBarFragment implements View.OnClickListener {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.discovery.publicaccount.c viewModel;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final b depends = new b(this);

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final GuildAppReportSourceInfo reportSourceInfo = new GuildAppReportSourceInfo("functional_channel_the_public", "");

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private GuildPublicAccountParams pubAccountParams = new GuildPublicAccountParams(0, null, 0, null, 0, 0, 63, null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/publicaccount/GuildPublicAccountDiscoveryFragmentV2$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/api/GuildPublicAccountParams;", "pubAccountParams", "", "a", "", "C2C_JUMP_TO_DIRECT_MSG", "Ljava/lang/String;", "C2C_JUMP_TO_NOTIFICATION", "C2C_JUMP_URL", "GUILD_PUBLIC_ACCOUNT_PARAMS", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discovery.publicaccount.GuildPublicAccountDiscoveryFragmentV2$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull GuildPublicAccountParams pubAccountParams) {
            Intrinsics.checkNotNullParameter(pubAccountParams, "pubAccountParams");
            Intent intent = new Intent();
            intent.setFlags(335544320);
            intent.putExtra("pubAccountParams", pubAccountParams);
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildPublicAccountDiscoveryFragmentV2.class, null, 8, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0005\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/discovery/publicaccount/GuildPublicAccountDiscoveryFragmentV2$b", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/MVPFeedsDepends;", "", "getContentWidth", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "c", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "e", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "clickProcessor", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/d;", "joinSourceDepends", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends MVPFeedsDepends {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.content.recommend.d clickProcessor = new com.tencent.mobileqq.guild.discoveryv2.content.recommend.d(2);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.fragment.d joinSourceDepends;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lkotlin/Pair;", "", "a", "(ILjava/lang/Object;)Lkotlin/Pair;"}, k = 3, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        static final class a implements com.tencent.mobileqq.guild.discoveryv2.fragment.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GuildPublicAccountDiscoveryFragmentV2 f216766a;

            a(GuildPublicAccountDiscoveryFragmentV2 guildPublicAccountDiscoveryFragmentV2) {
                this.f216766a = guildPublicAccountDiscoveryFragmentV2;
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.d
            @NotNull
            public final Pair<String, String> a(int i3, @Nullable Object obj) {
                String str;
                if (this.f216766a.Mh()) {
                    str = "recommend";
                } else {
                    str = "channel_the_public_channel";
                }
                return TuplesKt.to("channel_the_public", str);
            }

            @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.d
            @NotNull
            public Pair<String, String> b(int i3) {
                return d.a.a(this, i3);
            }
        }

        b(GuildPublicAccountDiscoveryFragmentV2 guildPublicAccountDiscoveryFragmentV2) {
            this.joinSourceDepends = new a(guildPublicAccountDiscoveryFragmentV2);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        /* renamed from: c, reason: from getter */
        public com.tencent.mobileqq.guild.discoveryv2.fragment.d getJoinSourceDepends() {
            return this.joinSourceDepends;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.e
        @NotNull
        /* renamed from: e, reason: from getter */
        public com.tencent.mobileqq.guild.discoveryv2.content.recommend.d getClickProcessor() {
            return this.clickProcessor;
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.fragment.MVPFeedsDepends, com.tencent.mobileqq.guild.discoveryv2.fragment.e
        public int getContentWidth() {
            return GuildSplitViewUtils.j(GuildSplitViewUtils.f235370a, true, null, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f216767a;

        public c(ViewModelStoreOwner viewModelStoreOwner) {
            this.f216767a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.discovery.publicaccount.c(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    private final void Ih() {
        this.C.setOnClickListener(this);
        this.C.setFocusable(false);
        TextView leftView = this.C;
        Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
        oh1.a.a(leftView, R.color.qui_common_text_primary);
        TextView centerView = this.E;
        Intrinsics.checkNotNullExpressionValue(centerView, "centerView");
        oh1.a.a(centerView, R.color.qui_common_text_primary);
        this.E.setText(R.string.f143300lp);
        getRootView().setVisibility(0);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        LiveData<Integer> g16 = QuiBitmapResourceObtainColorHelper.g(requireContext, R.drawable.qui_common_bg_bottom_standard_bg);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.publicaccount.GuildPublicAccountDiscoveryFragmentV2$initBaseViews$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num) {
                if (num != null) {
                    GuildPublicAccountDiscoveryFragmentV2.this.N.setBackgroundColor(kotlin.g.a(num.intValue(), 80));
                }
            }
        };
        g16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discovery.publicaccount.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildPublicAccountDiscoveryFragmentV2.Jh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Lh() {
        this.F.setFocusable(false);
        this.F.setVisibility(0);
        this.F.setOnClickListener(this);
        this.F.setText("");
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = QQGuildUIUtil.f(24.0f);
        layoutParams2.height = QQGuildUIUtil.f(24.0f);
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = QQGuildUIUtil.f(16.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Mh() {
        if ((this.pubAccountParams.getLastMsgType() == 4 || this.pubAccountParams.getLastMsgType() == 6) && this.pubAccountParams.getJumpDetail() != 2) {
            return true;
        }
        return false;
    }

    private final void Nh() {
        Intent intent = new Intent();
        intent.putExtra(IPublicAccountUtil.NEED_FINISH, true);
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent, ch.l(), getContext(), AppConstants.VALUE.UIN_GUILD_OFFICIAL_ACCOUNT, -1);
    }

    private final void Oh() {
        ch.Y0(this.F, "em_sgrp_public_accounts_more_icon", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        HashMap<String, Object> b16 = d.f216775a.b(this.pubAccountParams, this.reportSourceInfo);
        b16.put("dt_pgid", "pg_sgrp_public_accounts_scene");
        VideoReport.reportEvent("clck", this.F, b16);
    }

    private final void Ph() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_public_accounts_scene");
        com.tencent.mobileqq.guild.report.b.g("functional_channel_the_public", "Guild.discovery.GuildPublicAccountDiscoveryFragmentV2");
        com.tencent.mobileqq.guild.report.b.i("pg_sgrp_public_accounts_scene", "Guild.discovery.GuildPublicAccountDiscoveryFragmentV2");
        VideoReport.setPageParams(this.P, new PageParams(d.f216775a.b(this.pubAccountParams, this.reportSourceInfo)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh() {
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_primary);
        DrawableType drawableType = new DrawableType(R.drawable.guild_discovery_more_icon_black, valueOf);
        TextView rightViewText = this.F;
        Intrinsics.checkNotNullExpressionValue(rightViewText, "rightViewText");
        drawableType.a(rightViewText);
        DrawableType drawableType2 = new DrawableType(R.drawable.guild_audio_top_back_left_btn, valueOf);
        TextView leftView = this.C;
        Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
        drawableType2.a(leftView);
    }

    private final View getRootView() {
        View mContentView = this.P;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        return mContentView;
    }

    private final void initData() {
        GuildPublicAccountParams guildPublicAccountParams = (GuildPublicAccountParams) GuildSplitViewUtils.f235370a.g(this).getParcelable("pubAccountParams");
        if (guildPublicAccountParams != null) {
            this.pubAccountParams = guildPublicAccountParams;
        }
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new c(this)).get(com.tencent.mobileqq.guild.discovery.publicaccount.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        com.tencent.mobileqq.guild.discovery.publicaccount.c cVar = (com.tencent.mobileqq.guild.discovery.publicaccount.c) viewModel;
        this.viewModel = cVar;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cn<Boolean> N1 = cVar.N1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.discovery.publicaccount.GuildPublicAccountDiscoveryFragmentV2$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Logger.f235387a.d().i("Guild.discovery.GuildPublicAccountDiscoveryFragmentV2", 1, "themeChanged isNightMode=" + bool);
                GuildPublicAccountDiscoveryFragmentV2.this.Qh();
            }
        };
        N1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discovery.publicaccount.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildPublicAccountDiscoveryFragmentV2.Kh(Function1.this, obj);
            }
        });
        Logger.f235387a.d().d("Guild.discovery.GuildPublicAccountDiscoveryFragmentV2", 1, "initData pubAccountParams=" + this.pubAccountParams);
    }

    private final void initViews() {
        Ih();
        Lh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.guild.discoveryv2.tips.c(R.drawable.guild_discovery_v2_loading1), new ContentPart(com.tencent.mobileqq.guild.discoveryv2.fragment.g.b(), null, 2, 0 == true ? 1 : 0), new com.tencent.mobileqq.guild.discoveryv2.content.part.c(), new RefreshPart(com.tencent.mobileqq.guild.discoveryv2.fragment.g.b()), new PreloadMoreStrategyPart(), new e(this.pubAccountParams.getBusiInfo()), new PublicAccountMiscPart(Mh()), new com.tencent.mobileqq.guild.discoveryv2.content.part.e(0, 1, 0 == true ? 1 : 0));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initViews();
        Qh();
        initData();
        Ph();
        GuildSplitViewUtils.f235370a.B(this.N);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f2w;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.C) {
            if (!o.c("fastClickGuard")) {
                GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
            }
        } else if (view == this.F && !o.c("fastClickGuard")) {
            Nh();
            Oh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GuildFeedPicLoader.f231079a.f();
        fi1.b.f398763a.d();
        PartFragmentIOCKt.unregisterIoc(this, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
        PartFragmentIOCKt.unregisterIoc(this, com.tencent.mobileqq.guild.discoveryv2.fragment.d.class);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(getActivity(), true, true);
        com.tencent.mobileqq.guild.report.b.i("pg_sgrp_public_accounts_scene", "Guild.discovery.GuildPublicAccountDiscoveryFragmentV2");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        PartFragmentIOCKt.registerIoc(this, this.depends, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void yh(int resId) {
        QQGuildUIUtil.M(getActivity(), getResources().getColor(resId), false);
    }
}
