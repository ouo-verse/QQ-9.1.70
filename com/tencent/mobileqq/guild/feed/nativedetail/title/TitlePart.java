package com.tencent.mobileqq.guild.feed.nativedetail.title;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedChannelTopEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishState;
import com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedDetailMorePanelCooperateHelper;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.title.TitlePart;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import ol1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import tl1.g;
import yl1.n;
import zp1.a;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018`\u0019H\u0016R\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00102\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/title/TitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "E9", "Ltl1/g$l;", "msg", "C9", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Landroid/view/View;", "backBtn", "e", "moreBtn", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "f", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "avatar", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "nickTv", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "svipNamePlate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "roleTv", BdhLogUtil.LogTag.Tag_Conn, "medalIv", "D", "Ljava/lang/String;", "feedPosterId", "E", "feedChannelId", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedDetailMorePanelCooperateHelper;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedDetailMorePanelCooperateHelper;", "morePanelCooperateHelper", "<init>", "()V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TitlePart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView medalIv;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String feedPosterId = "";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String feedChannelId = "";

    /* renamed from: F, reason: from kotlin metadata */
    private FeedDetailMorePanelCooperateHelper morePanelCooperateHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View backBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View moreBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarViewWithPendant avatar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView nickTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView svipNamePlate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView roleTv;

    private final void C9(g.OnDataListChangedMessage msg2) {
        FeedDetailMainData feedDetailMainData;
        boolean isBlank;
        boolean isBlank2;
        ImageView imageView = null;
        if (msg2 != null) {
            feedDetailMainData = n.j(msg2);
        } else {
            feedDetailMainData = null;
        }
        if (feedDetailMainData == null) {
            QLog.e("TitlePart", 1, "bindData feedDetailMainData is null");
            return;
        }
        TextView textView = this.nickTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTv");
            textView = null;
        }
        textView.setText(feedDetailMainData.getFeedDetail().L());
        final String u16 = feedDetailMainData.getFeedDetail().u();
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = this.avatar;
        if (guildUserAvatarViewWithPendant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            guildUserAvatarViewWithPendant = null;
        }
        guildUserAvatarViewWithPendant.getAvatarView().post(new Runnable() { // from class: xl1.b
            @Override // java.lang.Runnable
            public final void run() {
                TitlePart.D9(u16, this);
            }
        });
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant2 = this.avatar;
        if (guildUserAvatarViewWithPendant2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            guildUserAvatarViewWithPendant2 = null;
        }
        guildUserAvatarViewWithPendant2.getPendantView().setUrl(feedDetailMainData.getFeedDetail().t());
        Triple<Long, Long, String> personalMedal = feedDetailMainData.getFeedDetail().getPersonalMedal();
        personalMedal.component1().longValue();
        personalMedal.component2().longValue();
        String component3 = personalMedal.component3();
        isBlank = StringsKt__StringsJVMKt.isBlank(component3);
        if (!isBlank) {
            ImageView imageView2 = this.medalIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("medalIv");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.medalIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("medalIv");
                imageView3 = null;
            }
            imageView3.setImageDrawable(null);
            e a16 = e.a();
            Option url = Option.obtain().setUrl(component3);
            ImageView imageView4 = this.medalIv;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("medalIv");
                imageView4 = null;
            }
            a16.e(url.setTargetView(imageView4));
        } else {
            ImageView imageView5 = this.medalIv;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("medalIv");
                imageView5 = null;
            }
            imageView5.setVisibility(8);
        }
        Triple<Integer, Integer, String> roleInfo = feedDetailMainData.getFeedDetail().getRoleInfo();
        int intValue = roleInfo.component1().intValue();
        roleInfo.component2().intValue();
        String component32 = roleInfo.component3();
        isBlank2 = StringsKt__StringsJVMKt.isBlank(component32);
        if (true ^ isBlank2) {
            TextView textView2 = this.roleTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleTv");
                textView2 = null;
            }
            textView2.setText(component32);
            TextView textView3 = this.roleTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleTv");
                textView3 = null;
            }
            textView3.setBackground(b.f423088a.b(intValue | (-16777216)));
            TextView textView4 = this.roleTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleTv");
                textView4 = null;
            }
            textView4.setVisibility(0);
        } else {
            TextView textView5 = this.roleTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleTv");
                textView5 = null;
            }
            textView5.setVisibility(8);
        }
        long channelId = feedDetailMainData.getFeedDetail().getChannelId();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(channelId);
        this.feedChannelId = sb5.toString();
        String r16 = feedDetailMainData.getFeedDetail().r();
        if (r16 == null) {
            r16 = "";
        }
        this.feedPosterId = r16;
        ImageView imageView6 = this.medalIv;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("medalIv");
        } else {
            imageView = imageView6;
        }
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(String str, TitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Option url = Option.obtain().setUrl(str);
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = this$0.avatar;
        if (guildUserAvatarViewWithPendant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            guildUserAvatarViewWithPendant = null;
        }
        e.a().f(url.setTargetView(guildUserAvatarViewWithPendant.getAvatarView()).setLoadingDrawable(BaseImageUtil.getDefaultFaceDrawable()), null);
    }

    private final void E9() {
        boolean z16;
        boolean z17;
        GuildFeedPublishInfo q16 = n.q(GuildSplitViewUtils.f235370a.h(getPartHost()));
        boolean z18 = true;
        if (q16 != null && q16.isLocalFeed()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (q16.getMainStatus() == GuildFeedPublishState.STATE_PUBLISHING) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (q16.getMainStatus() != GuildFeedPublishState.STATE_PUBLISH_FAIL) {
                z18 = false;
            }
            if (bn.h(z17, z18)) {
                return;
            }
        }
        qj1.h p16 = n.p(this);
        if (p16 != null) {
            FeedDetailMorePanelCooperateHelper feedDetailMorePanelCooperateHelper = this.morePanelCooperateHelper;
            if (feedDetailMorePanelCooperateHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
                feedDetailMorePanelCooperateHelper = null;
            }
            a.C11708a.a(feedDetailMorePanelCooperateHelper, -1, p16, new Supplier() { // from class: xl1.c
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Map F9;
                    F9 = TitlePart.F9();
                    return F9;
                }
            }, 0, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map F9() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(TitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            QLog.i("TitlePart", 2, "more click");
            this$0.E9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        boolean z16;
        QLog.i("TitlePart", 2, "openProfileCard feedPosterId=" + this.feedPosterId);
        if (getPartHost().getHostActivity() != null) {
            if (this.feedPosterId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                GuildProfileData guildProfileData = new GuildProfileData(n.r(this), "", this.feedPosterId, 0, 8);
                guildProfileData.getGuildBaseProfileData().r(n.l(this));
                guildProfileData.setFeedImpeachData(new FeedImpeachData(0, n.o(this), "", ""));
                GuildProfileCard.Lh(getPartHost().getHostActivity(), guildProfileData);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedChannelTopEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        FeedDetailMorePanelCooperateHelper feedDetailMorePanelCooperateHelper = null;
        g.OnDataListChangedMessage onDataListChangedMessage = null;
        if (Intrinsics.areEqual(action, "message_data_list_changed")) {
            if (args instanceof g.OnDataListChangedMessage) {
                onDataListChangedMessage = (g.OnDataListChangedMessage) args;
            }
            C9(onDataListChangedMessage);
            return;
        }
        FeedDetailMorePanelCooperateHelper feedDetailMorePanelCooperateHelper2 = this.morePanelCooperateHelper;
        if (feedDetailMorePanelCooperateHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
        } else {
            feedDetailMorePanelCooperateHelper = feedDetailMorePanelCooperateHelper2;
        }
        if (action == null) {
            action = "";
        }
        feedDetailMorePanelCooperateHelper.c(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant;
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.t2o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.back_icn)");
        this.backBtn = findViewById;
        View findViewById2 = rootView.findViewById(R.id.zen);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.more_icn)");
        this.moreBtn = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f115206ve);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.user_avatar)");
        this.avatar = (GuildUserAvatarViewWithPendant) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f115656wm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.user_nickname)");
        this.nickTv = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f9103543);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.svip_nameplate)");
        this.svipNamePlate = (ImageView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f115766wx);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.user_role)");
        this.roleTv = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f115596wg);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.user_medal)");
        this.medalIv = (ImageView) findViewById7;
        final View view = this.backBtn;
        FeedDetailMorePanelCooperateHelper feedDetailMorePanelCooperateHelper = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            view = null;
        }
        final long j3 = 200;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TitlePart$onInitView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                view.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                QLog.i("TitlePart", 2, "back click");
                this.getPartHost().getHostActivity().onBackPressed();
                final View view2 = view;
                view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TitlePart$onInitView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view2.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        View view2 = this.moreBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: xl1.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TitlePart.G9(TitlePart.this, view3);
            }
        });
        View view3 = this.moreBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
            view3 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(view3, "em_sgrp_more_action", clickPolicy, exposurePolicy);
        final GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant2 = this.avatar;
        if (guildUserAvatarViewWithPendant2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            guildUserAvatarViewWithPendant2 = null;
        }
        guildUserAvatarViewWithPendant2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TitlePart$onInitView$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                guildUserAvatarViewWithPendant2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.H9();
                final View view4 = guildUserAvatarViewWithPendant2;
                view4.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TitlePart$onInitView$$inlined$setSingleClickListener$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view4.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant3 = this.avatar;
        if (guildUserAvatarViewWithPendant3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            guildUserAvatarViewWithPendant = null;
        } else {
            guildUserAvatarViewWithPendant = guildUserAvatarViewWithPendant3;
        }
        bt.d(guildUserAvatarViewWithPendant, "em_sgrp_forum_avatar", null, null, exposurePolicy, EndExposurePolicy.REPORT_NONE, 12, null);
        final TextView textView = this.nickTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTv");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TitlePart$onInitView$$inlined$setSingleClickListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                textView.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.H9();
                final View view4 = textView;
                view4.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TitlePart$onInitView$$inlined$setSingleClickListener$3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view4.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        FeedDetailMorePanelCooperateHelper feedDetailMorePanelCooperateHelper2 = new FeedDetailMorePanelCooperateHelper(this);
        getPartHost().getLifecycleOwner().getLifecycle().addObserver(feedDetailMorePanelCooperateHelper2);
        this.morePanelCooperateHelper = feedDetailMorePanelCooperateHelper2;
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        FeedDetailMorePanelCooperateHelper feedDetailMorePanelCooperateHelper3 = this.morePanelCooperateHelper;
        if (feedDetailMorePanelCooperateHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
        } else {
            feedDetailMorePanelCooperateHelper = feedDetailMorePanelCooperateHelper3;
        }
        g16.registerIoc(rootView, feedDetailMorePanelCooperateHelper, a.class);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), a.class);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildFeedChannelTopEvent) {
            GuildFeedChannelTopEvent guildFeedChannelTopEvent = (GuildFeedChannelTopEvent) event;
            if (Intrinsics.areEqual(guildFeedChannelTopEvent.getFeedId(), n.o(this))) {
                broadcastMessage("message_update_feed_channel_top_state", new g.UpdateFeedChannelTopStateMessage(guildFeedChannelTopEvent.getTopState()));
            }
        }
    }
}
