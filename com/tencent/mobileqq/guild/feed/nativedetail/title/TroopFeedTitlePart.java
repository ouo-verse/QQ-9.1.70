package com.tencent.mobileqq.guild.feed.nativedetail.title;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.morepanel.cooperate.TroopFeedMorePanelCooperateHelper;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.title.TroopFeedTitlePart;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarViewWithPendant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import tl1.g;
import yl1.n;
import zp1.a;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0019\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\u001bR\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/title/TroopFeedTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "I9", "F9", "Ltl1/g$l;", "msg", "C9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "feedDetailMainData", "", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "action", "", "args", "handleBroadcastMessage", "d", "Ljava/lang/String;", "troopUin", "e", "Landroid/view/View;", "backBtn", "f", "moreBtn", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", h.F, "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarViewWithPendant;", "avatar", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "nickTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "posterId", "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/TroopFeedMorePanelCooperateHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/TroopFeedMorePanelCooperateHelper;", "morePanelCooperateHelper", "<init>", "(Ljava/lang/String;)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TroopFeedTitlePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private TroopFeedMorePanelCooperateHelper morePanelCooperateHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View backBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View moreBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildUserAvatarViewWithPendant avatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView nickTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String posterId;

    public TroopFeedTitlePart(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.troopUin = troopUin;
    }

    private final void C9(g.OnDataListChangedMessage msg2) {
        FeedDetailMainData feedDetailMainData;
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = null;
        if (msg2 != null) {
            feedDetailMainData = n.j(msg2);
        } else {
            feedDetailMainData = null;
        }
        if (feedDetailMainData == null) {
            QLog.e("TroopFeedTitlePart", 1, "bindData feedDetailMainData is null");
            return;
        }
        TextView textView = this.nickTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTv");
            textView = null;
        }
        textView.setText(feedDetailMainData.getFeedDetail().L());
        if (E9(feedDetailMainData)) {
            final String u16 = feedDetailMainData.getFeedDetail().u();
            GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant2 = this.avatar;
            if (guildUserAvatarViewWithPendant2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatar");
            } else {
                guildUserAvatarViewWithPendant = guildUserAvatarViewWithPendant2;
            }
            guildUserAvatarViewWithPendant.getAvatarView().post(new Runnable() { // from class: xl1.d
                @Override // java.lang.Runnable
                public final void run() {
                    TroopFeedTitlePart.D9(u16, this);
                }
            });
        }
        this.posterId = feedDetailMainData.getFeedDetail().F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(String str, TroopFeedTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Option url = Option.obtain().setUrl(str);
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant = this$0.avatar;
        if (guildUserAvatarViewWithPendant == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            guildUserAvatarViewWithPendant = null;
        }
        e.a().f(url.setTargetView(guildUserAvatarViewWithPendant.getAvatarView()).setLoadingDrawable(BaseImageUtil.getDefaultFaceDrawable()), null);
    }

    private final boolean E9(FeedDetailMainData feedDetailMainData) {
        try {
            String str = this.posterId;
            if (str != null) {
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("posterId");
                    str = null;
                }
                if (Intrinsics.areEqual(str, feedDetailMainData.getFeedDetail().F())) {
                    return false;
                }
            }
        } catch (Exception e16) {
            QLog.e("TroopFeedTitlePart", 1, "needLoadAvatar exception: " + e16.getMessage());
        }
        return true;
    }

    private final void F9() {
        qj1.h p16 = n.p(this);
        if (p16 != null) {
            TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper = this.morePanelCooperateHelper;
            if (troopFeedMorePanelCooperateHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
                troopFeedMorePanelCooperateHelper = null;
            }
            a.C11708a.a(troopFeedMorePanelCooperateHelper, -1, p16, new Supplier() { // from class: xl1.f
                @Override // androidx.core.util.Supplier
                public final Object get() {
                    Map G9;
                    G9 = TroopFeedTitlePart.G9();
                    return G9;
                }
            }, 0, 8, null);
        }
        View view = this.moreBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
            view = null;
        }
        VideoReport.reportEvent("clck", view, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map G9() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(TroopFeedTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            QLog.i("TroopFeedTitlePart", 2, "more click");
            this$0.F9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        String str = this.troopUin;
        String str2 = this.posterId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("posterId");
            str2 = null;
        }
        ax.M(str, str2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper = null;
        g.OnDataListChangedMessage onDataListChangedMessage = null;
        if (Intrinsics.areEqual(action, "message_data_list_changed")) {
            if (args instanceof g.OnDataListChangedMessage) {
                onDataListChangedMessage = (g.OnDataListChangedMessage) args;
            }
            C9(onDataListChangedMessage);
            return;
        }
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper2 = this.morePanelCooperateHelper;
        if (troopFeedMorePanelCooperateHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
        } else {
            troopFeedMorePanelCooperateHelper = troopFeedMorePanelCooperateHelper2;
        }
        if (action == null) {
            action = "";
        }
        troopFeedMorePanelCooperateHelper.c(action, args);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
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
        final View view2 = this.backBtn;
        final TextView textView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            view2 = null;
        }
        final long j3 = 200;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TroopFeedTitlePart$onInitView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                view2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                QLog.i("TroopFeedTitlePart", 2, "back click");
                this.getPartHost().getHostActivity().onBackPressed();
                final View view3 = view2;
                view3.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TroopFeedTitlePart$onInitView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view3.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        View view3 = this.moreBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
            view3 = null;
        }
        view3.setOnClickListener(new View.OnClickListener() { // from class: xl1.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                TroopFeedTitlePart.H9(TroopFeedTitlePart.this, view4);
            }
        });
        bt btVar = bt.f235484a;
        View view4 = this.moreBtn;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
            view = null;
        } else {
            view = view4;
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        bt.d(view, "em_sgrp_more_action", null, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        final GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant2 = this.avatar;
        if (guildUserAvatarViewWithPendant2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            guildUserAvatarViewWithPendant2 = null;
        }
        guildUserAvatarViewWithPendant2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TroopFeedTitlePart$onInitView$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                guildUserAvatarViewWithPendant2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.I9();
                final View view5 = guildUserAvatarViewWithPendant2;
                view5.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TroopFeedTitlePart$onInitView$$inlined$setSingleClickListener$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view5.setClickable(true);
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
        bt.d(guildUserAvatarViewWithPendant, "em_sgrp_forum_avatar", null, null, exposurePolicy, endExposurePolicy, 12, null);
        GuildUserAvatarViewWithPendant guildUserAvatarViewWithPendant4 = this.avatar;
        if (guildUserAvatarViewWithPendant4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatar");
            guildUserAvatarViewWithPendant4 = null;
        }
        VideoReport.reportEvent("imp", guildUserAvatarViewWithPendant4, null);
        TextView textView2 = this.nickTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTv");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TroopFeedTitlePart$onInitView$$inlined$setSingleClickListener$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                textView.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.I9();
                final View view5 = textView;
                view5.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.title.TroopFeedTitlePart$onInitView$$inlined$setSingleClickListener$3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view5.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper = new TroopFeedMorePanelCooperateHelper(this, this.troopUin, false, 4, null);
        getPartHost().getLifecycleOwner().getLifecycle().addObserver(troopFeedMorePanelCooperateHelper);
        this.morePanelCooperateHelper = troopFeedMorePanelCooperateHelper;
        RFWIocAbilityProvider g16 = RFWIocAbilityProvider.g();
        View partRootView = getPartRootView();
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper2 = this.morePanelCooperateHelper;
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper3 = null;
        if (troopFeedMorePanelCooperateHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
            troopFeedMorePanelCooperateHelper2 = null;
        }
        g16.registerIoc(partRootView, troopFeedMorePanelCooperateHelper2, a.class);
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper4 = this.morePanelCooperateHelper;
        if (troopFeedMorePanelCooperateHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
        } else {
            troopFeedMorePanelCooperateHelper3 = troopFeedMorePanelCooperateHelper4;
        }
        troopFeedMorePanelCooperateHelper3.r();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        TroopFeedMorePanelCooperateHelper troopFeedMorePanelCooperateHelper = this.morePanelCooperateHelper;
        if (troopFeedMorePanelCooperateHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("morePanelCooperateHelper");
            troopFeedMorePanelCooperateHelper = null;
        }
        troopFeedMorePanelCooperateHelper.onDestroy();
    }
}
