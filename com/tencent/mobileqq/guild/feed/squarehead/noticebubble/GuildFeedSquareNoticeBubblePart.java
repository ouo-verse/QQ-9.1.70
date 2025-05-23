package com.tencent.mobileqq.guild.feed.squarehead.noticebubble;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareNoticeViewModel;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.richframework.data.base.UIStateData;
import ef1.c;
import ij1.GuildFeedsHeaderData;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\u0015R#\u0010.\u001a\n )*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/noticebubble/GuildFeedSquareNoticeBubblePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "uiData", "", "C9", "E9", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "e", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "userAvatarImage", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tipText", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", h.F, "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "redBadge", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "jumpImage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "contentContainer", BdhLogUtil.LogTag.Tag_Conn, "guildAvatarView", "", "kotlin.jvm.PlatformType", "D", "Lkotlin/Lazy;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareNoticeViewModel;", "E", "B9", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareNoticeViewModel;", "viewModel", "", UserInfo.SEX_FEMALE, "I", "type", "<init>", "()V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareNoticeBubblePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private RFWRoundImageView guildAvatarView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RFWRoundImageView userAvatarImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tipText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIBadge redBadge;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView jumpImage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View contentContainer;

    public GuildFeedSquareNoticeBubblePart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.noticebubble.GuildFeedSquareNoticeBubblePart$guildId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return ax.o(GuildFeedSquareNoticeBubblePart.this.getHostFragment()).getGuildId();
            }
        });
        this.guildId = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedSquareNoticeViewModel>() { // from class: com.tencent.mobileqq.guild.feed.squarehead.noticebubble.GuildFeedSquareNoticeBubblePart$viewModel$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements ViewModelProvider.Factory {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ViewModelStoreOwner f223472a;

                public a(ViewModelStoreOwner viewModelStoreOwner) {
                    this.f223472a = viewModelStoreOwner;
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                @NotNull
                public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    TimedValue timedValue = new TimedValue(new GuildFeedSquareNoticeViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                    }
                    return (T) timedValue.getValue();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedSquareNoticeViewModel invoke() {
                c.Companion companion = c.INSTANCE;
                IPartHost partHost = GuildFeedSquareNoticeBubblePart.this.getPartHost();
                Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
                ViewModel viewModel = new ViewModelProvider(partHost, new a(partHost)).get(GuildFeedSquareNoticeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
                return (GuildFeedSquareNoticeViewModel) viewModel;
            }
        });
        this.viewModel = lazy2;
        this.type = -1;
    }

    private final GuildFeedSquareNoticeViewModel B9() {
        return (GuildFeedSquareNoticeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0097, code lost:
    
        if ((!r0) != false) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [android.widget.FrameLayout] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C9(UIStateData<GuildInteractiveNotificationItem> uiData) {
        boolean z16;
        int i3;
        RFWRoundImageView rFWRoundImageView;
        boolean isBlank;
        int i16 = 8;
        boolean z17 = true;
        RFWRoundImageView rFWRoundImageView2 = null;
        if (uiData.getData().count > 0) {
            String str = uiData.getData().highLightStr;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.type = uiData.getData().reportType;
                FrameLayout frameLayout = this.container;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    frameLayout = null;
                }
                frameLayout.setVisibility(0);
                TextView textView = this.tipText;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipText");
                    textView = null;
                }
                textView.setText(uiData.getData().highLightStr);
                QUIBadge qUIBadge = this.redBadge;
                if (qUIBadge == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("redBadge");
                    qUIBadge = null;
                }
                qUIBadge.setRedDot();
                QUIBadge qUIBadge2 = this.redBadge;
                if (qUIBadge2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("redBadge");
                    qUIBadge2 = null;
                }
                qUIBadge2.setRedNum(uiData.getData().count);
                if (uiData.getData().replyTinyId > 0) {
                    String str2 = uiData.getData().avatarMeta;
                    Intrinsics.checkNotNullExpressionValue(str2, "uiData.data.avatarMeta");
                    isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                }
                z17 = false;
                RFWRoundImageView rFWRoundImageView3 = this.userAvatarImage;
                if (rFWRoundImageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userAvatarImage");
                    rFWRoundImageView3 = null;
                }
                if (z17) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                rFWRoundImageView3.setVisibility(i3);
                RFWRoundImageView rFWRoundImageView4 = this.guildAvatarView;
                if (rFWRoundImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildAvatarView");
                    rFWRoundImageView4 = null;
                }
                if (!z17) {
                    i16 = 0;
                }
                rFWRoundImageView4.setVisibility(i16);
                if (z17) {
                    if (!TextUtils.isEmpty(uiData.getData().avatarMeta)) {
                        IGuildQCircleAvatarApi iGuildQCircleAvatarApi = (IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class);
                        String str3 = uiData.getData().guildId;
                        String valueOf = String.valueOf(uiData.getData().replyTinyId);
                        String str4 = uiData.getData().avatarMeta;
                        RFWRoundImageView rFWRoundImageView5 = this.userAvatarImage;
                        if (rFWRoundImageView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("userAvatarImage");
                            rFWRoundImageView = null;
                        } else {
                            rFWRoundImageView = rFWRoundImageView5;
                        }
                        iGuildQCircleAvatarApi.loadAvatarByTinyIdAndAvatarMeta(str3, valueOf, str4, 3, rFWRoundImageView);
                        return;
                    }
                    IGuildQCircleAvatarApi iGuildQCircleAvatarApi2 = (IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class);
                    String str5 = uiData.getData().guildId;
                    String valueOf2 = String.valueOf(uiData.getData().replyTinyId);
                    RFWRoundImageView rFWRoundImageView6 = this.userAvatarImage;
                    if (rFWRoundImageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userAvatarImage");
                    } else {
                        rFWRoundImageView2 = rFWRoundImageView6;
                    }
                    iGuildQCircleAvatarApi2.loadAvatarByTinyId(str5, valueOf2, 3, rFWRoundImageView2);
                    return;
                }
                RFWRoundImageView rFWRoundImageView7 = this.guildAvatarView;
                if (rFWRoundImageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildAvatarView");
                } else {
                    rFWRoundImageView2 = rFWRoundImageView7;
                }
                rFWRoundImageView2.setImageResource(R.drawable.guild_feed_square_notice_bubble_manager_avatar);
                return;
            }
        }
        QLog.d("GuildFeedSquareNoticeBubblePart", 1, "NoticeBubble GONE--count:" + uiData.getData().count + ",highlightStr:" + uiData.getData().highLightStr);
        ?? r122 = this.container;
        if (r122 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            rFWRoundImageView2 = r122;
        }
        rFWRoundImageView2.setVisibility(8);
    }

    private final void D9() {
        Map mapOf;
        View view = this.contentContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            view = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_state", Integer.valueOf(this.type)));
        ch.T0(view, "em_sgrp_notice_shortcut_entry", clickPolicy, exposurePolicy, mapOf);
    }

    private final void E9() {
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
        String guildId = getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        iGuildFeedLauncherApi.launchGuildFeedNoticeFragment(new JumpGuildNoticeMsg(0, guildId, null, null, false, 0, 61, null), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(GuildFeedSquareNoticeBubblePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            this$0.E9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String getGuildId() {
        return (String) this.guildId.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        int i3;
        UIStateData<GuildFeedsHeaderData> value;
        GuildFeedsHeaderData data;
        GuildInteractiveNotificationItem noticeData;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
        k vmApi;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View inflate = ((ViewStub) rootView.findViewById(R.id.wer)).inflate();
        View findViewById = inflate.findViewById(R.id.b8q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "inflatedView.findViewById(R.id.container)");
        this.container = (FrameLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f114856ug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "inflatedView.findViewById(R.id.userAvatarImage)");
        this.userAvatarImage = (RFWRoundImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f97675l1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "inflatedView.findViewById(R.id.tipText)");
        this.tipText = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f71993pn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "inflatedView.findViewById(R.id.redBadge)");
        this.redBadge = (QUIBadge) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.yaq);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "inflatedView.findViewById(R.id.jumpImage)");
        this.jumpImage = (ImageView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.b9n);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "inflatedView.findViewById(R.id.contentContainer)");
        this.contentContainer = findViewById6;
        View findViewById7 = inflate.findViewById(R.id.f165415vw0);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "inflatedView.findViewById(R.id.guildAvatarImage)");
        this.guildAvatarView = (RFWRoundImageView) findViewById7;
        View view = this.contentContainer;
        MutableLiveData<UIStateData<GuildFeedsHeaderData>> mutableLiveData = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.squarehead.noticebubble.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildFeedSquareNoticeBubblePart.F9(GuildFeedSquareNoticeBubblePart.this, view2);
            }
        });
        g gVar = (g) PartIOCKt.getIocInterface(this, g.class);
        if (gVar != null && (context = gVar.getContext()) != null && (vmApi = context.getVmApi()) != null) {
            mutableLiveData = vmApi.X();
        }
        GuildFeedSquareNoticeViewModel B9 = B9();
        String guildId = getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        B9.W1(guildId, mutableLiveData, com.tencent.mobileqq.guild.feed.part.a.c(this));
        MutableLiveData<UIStateData<GuildInteractiveNotificationItem>> U1 = B9().U1();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final GuildFeedSquareNoticeBubblePart$onInitView$2 guildFeedSquareNoticeBubblePart$onInitView$2 = new GuildFeedSquareNoticeBubblePart$onInitView$2(this);
        U1.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.squarehead.noticebubble.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedSquareNoticeBubblePart.G9(Function1.this, obj);
            }
        });
        if (mutableLiveData != null && (value = mutableLiveData.getValue()) != null && (data = value.getData()) != null && (noticeData = data.getNoticeData()) != null) {
            i3 = noticeData.reportType;
        } else {
            i3 = -1;
        }
        this.type = i3;
        D9();
        QLog.d("GuildFeedSquareNoticeBubblePart", 1, "onInitView");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        QLog.d("GuildFeedSquareNoticeBubblePart", 1, "onPartResume");
        GuildFeedSquareNoticeViewModel B9 = B9();
        if (B9 != null) {
            B9.b2();
        }
    }
}
