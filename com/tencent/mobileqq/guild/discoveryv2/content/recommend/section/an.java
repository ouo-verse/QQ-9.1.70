package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendHotLiveData;
import com.tencent.mobileqq.guild.discoveryv2.content.util.UpdateRecommendLivesData;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveFragment;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.data.OpenParam;
import com.tencent.mobileqq.guild.main.adapterdelegates.LottieAnimationViewEx;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 k2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001lB\u0007\u00a2\u0006\u0004\bi\u0010jJ\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000f\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0002J6\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0011`\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0018H\u0002J$\u0010\u001d\u001a\u00020\t2\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u001bH\u0002J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000bH\u0002J(\u0010(\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u0018\u0010*\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0006\u0010)\u001a\u00020\rH\u0002J\u0018\u0010+\u001a\u00020\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010)\u001a\u00020\rH\u0002J \u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0002J(\u00102\u001a\u00020\t2\u0006\u00100\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u00101\u001a\u00020\rH\u0002J(\u00104\u001a\u00020\t2\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001aj\b\u0012\u0004\u0012\u00020\u0007`\u001b2\u0006\u0010,\u001a\u00020\u001eH\u0002J\b\u00106\u001a\u000205H\u0014J\u0012\u00108\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u00109\u001a\u00020\tH\u0016J(\u0010=\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\r2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010;H\u0014J\u0010\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020\u001eH\u0016J\u0010\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u001eH\u0016J\u0012\u0010B\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050C0\u001aH\u0016J\b\u0010E\u001a\u00020\tH\u0016J\u0010\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020?H\u0016R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010JR\u0016\u0010Z\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010JR\u0016\u0010\\\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010JR\u0016\u0010_\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010^R\u0016\u0010a\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010^R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR&\u0010g\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u001aj\b\u0012\u0004\u0012\u00020\u000b`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010fR\u0016\u0010h\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010c\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/an;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/av;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendHotLiveData;", "Lcom/tencent/guild/aio/util/ex/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "", "event", "", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProHotLiveCard;", "liveInfo", "", "index", "H", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "M", "Landroid/content/Context;", "context", "O", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/discoveryv2/content/util/UpdateRecommendLivesData;", "N", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "hotLives", "B", "Landroid/view/View;", "cardView", "cardInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/ImageView;", "blurBg", "bgView", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarView", "cover", ExifInterface.LATITUDE_SOUTH, "color", "K", "J", "view", "channelType", "themeType", "U", "iconView", "type", "T", "avatarList", "G", "", "getViewStubLayoutId", "containerView", "onInitView", "onThemeChanged", "position", "", "payload", "P", "v", "", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, NodeProps.VISIBLE, "onVisibleChanged", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "mRoot", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "mCardsContainer", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "i", "Lcom/tencent/mobileqq/guild/component/RoundImageView;", "mBg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mTitle", BdhLogUtil.LogTag.Tag_Conn, "leftCardContainer", "D", "topCardContainer", "E", "bottomCardContainer", UserInfo.SEX_FEMALE, "Landroid/view/View;", "leftCard", "topCard", "bottomCard", "Lcom/tencent/mobileqq/guild/main/adapterdelegates/LottieAnimationViewEx;", "I", "Lcom/tencent/mobileqq/guild/main/adapterdelegates/LottieAnimationViewEx;", "mIconLottie", "Ljava/util/ArrayList;", VideoTemplateParser.ITEM_LIST, "voiceCount", "<init>", "()V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class an extends av<RecommendHotLiveData> implements com.tencent.guild.aio.util.ex.c, SimpleEventReceiver<SimpleBaseEvent> {
    private static final int M = Color.parseColor("#B7B5FF");
    private static final int N = Color.parseColor("#72AAFF");
    private static final int P = Color.parseColor("#8CE3FF");
    private static final int Q = Color.parseColor("#65B5FF");
    private static final int R = Color.parseColor("#7DEFC6");
    private static final int S = Color.parseColor("#43E1EC");
    private static final int T = Color.parseColor("#FFB682");
    private static final int U = Color.parseColor("#FF9B58");
    private static final int V = Color.parseColor("#8DAFFF");
    private static final int W = Color.parseColor("#74C7FF");
    private static final int X = Color.parseColor("#54E5E2");

    /* renamed from: C, reason: from kotlin metadata */
    private FrameLayout leftCardContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private FrameLayout topCardContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout bottomCardContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private View leftCard;

    /* renamed from: G, reason: from kotlin metadata */
    private View topCard;

    /* renamed from: H, reason: from kotlin metadata */
    private View bottomCard;

    /* renamed from: I, reason: from kotlin metadata */
    private LottieAnimationViewEx mIconLottie;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ArrayList<IGProHotLiveCard> itemList = new ArrayList<>();

    /* renamed from: K, reason: from kotlin metadata */
    private int voiceCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mCardsContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RoundImageView mBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mTitle;

    public an() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void A(View cardView, IGProHotLiveCard cardInfo) {
        boolean z16;
        ImageView cardBg = (ImageView) cardView.findViewById(R.id.f71363ny);
        ImageView cardBlurBg = (ImageView) cardView.findViewById(R.id.f71383o0);
        ImageView cardIconBg = (ImageView) cardView.findViewById(R.id.f71373nz);
        View findViewById = cardView.findViewById(R.id.f165475w70);
        Intrinsics.checkNotNullExpressionValue(findViewById, "cardView.findViewById(R.\u2026_recommend_voice_avatar2)");
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById;
        if (cardInfo.getChannelType() == 2) {
            ArrayList<String> memberAvatarList = cardInfo.getMemberAvatarList();
            Intrinsics.checkNotNullExpressionValue(memberAvatarList, "cardInfo.memberAvatarList");
            G(memberAvatarList, cardView);
        }
        String cover = cardInfo.getCover();
        Intrinsics.checkNotNullExpressionValue(cover, "cardInfo.cover");
        if (cover.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            cardBlurBg.setVisibility(0);
            cardIconBg.setVisibility(4);
            Intrinsics.checkNotNullExpressionValue(cardBlurBg, "cardBlurBg");
            Intrinsics.checkNotNullExpressionValue(cardBg, "cardBg");
            String cover2 = cardInfo.getCover();
            Intrinsics.checkNotNullExpressionValue(cover2, "cardInfo.cover");
            S(cardBlurBg, cardBg, qQProAvatarView, cover2);
        } else {
            Intrinsics.checkNotNullExpressionValue(cardIconBg, "cardIconBg");
            Intrinsics.checkNotNullExpressionValue(cardBg, "cardBg");
            T(cardIconBg, cardBg, qQProAvatarView, cardInfo.getChannelType());
        }
        U(cardView, cardInfo.getChannelType(), cardInfo.getThemeType());
    }

    private final void B(final ArrayList<IGProHotLiveCard> hotLives) {
        boolean z16;
        List take;
        Object orNull;
        Object orNull2;
        if (hotLives != null && !hotLives.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.itemList.clear();
        ArrayList<IGProHotLiveCard> arrayList = this.itemList;
        take = CollectionsKt___CollectionsKt.take(hotLives, 3);
        arrayList.addAll(take);
        this.voiceCount = 0;
        if (hotLives != null) {
            View view = this.leftCard;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftCard");
                view = null;
            }
            IGProHotLiveCard iGProHotLiveCard = hotLives.get(0);
            Intrinsics.checkNotNullExpressionValue(iGProHotLiveCard, "hotLives[0]");
            A(view, iGProHotLiveCard);
            View view3 = this.leftCard;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftCard");
                view3 = null;
            }
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.aj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    an.C(an.this, hotLives, view4);
                }
            });
            View view4 = this.leftCard;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftCard");
                view4 = null;
            }
            View findViewById = view4.findViewById(R.id.wmd);
            Intrinsics.checkNotNullExpressionValue(findViewById, "leftCard.findViewById(R.id.guild_live_desc_bg)");
            LinearLayout linearLayout = (LinearLayout) findViewById;
            View view5 = this.leftCard;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftCard");
                view5 = null;
            }
            View findViewById2 = view5.findViewById(R.id.wmc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "leftCard.findViewById(R.id.guild_live_desc)");
            linearLayout.setVisibility(0);
            ((TextView) findViewById2).setText(hotLives.get(0).getLiveTitle());
            orNull = CollectionsKt___CollectionsKt.getOrNull(hotLives, 1);
            if (((IGProHotLiveCard) orNull) != null) {
                View view6 = this.topCard;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topCard");
                    view6 = null;
                }
                IGProHotLiveCard iGProHotLiveCard2 = hotLives.get(1);
                Intrinsics.checkNotNullExpressionValue(iGProHotLiveCard2, "hotLives[1]");
                A(view6, iGProHotLiveCard2);
                View view7 = this.topCard;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topCard");
                    view7 = null;
                }
                view7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.ak
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view8) {
                        an.D(an.this, hotLives, view8);
                    }
                });
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(hotLives, 2);
            if (((IGProHotLiveCard) orNull2) != null) {
                View view8 = this.bottomCard;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomCard");
                    view8 = null;
                }
                IGProHotLiveCard iGProHotLiveCard3 = hotLives.get(2);
                Intrinsics.checkNotNullExpressionValue(iGProHotLiveCard3, "hotLives[2]");
                A(view8, iGProHotLiveCard3);
                View view9 = this.bottomCard;
                if (view9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomCard");
                } else {
                    view2 = view9;
                }
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.al
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view10) {
                        an.F(an.this, hotLives, view10);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(an this$0, ArrayList arrayList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this$0.O(context);
        this$0.H((IGProHotLiveCard) arrayList.get(0), 0, "clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(an this$0, ArrayList arrayList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this$0.O(context);
        this$0.H((IGProHotLiveCard) arrayList.get(1), 1, "clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(an this$0, ArrayList arrayList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this$0.O(context);
        this$0.H((IGProHotLiveCard) arrayList.get(2), 2, "clck");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G(ArrayList<String> avatarList, View view) {
        Object orNull;
        Object orNull2;
        View findViewById = view.findViewById(R.id.f71583oj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.recommend_voice_avatar)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.w6y);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.g\u2026_recommend_voice_avatar1)");
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f165475w70);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.g\u2026_recommend_voice_avatar2)");
        QQProAvatarView qQProAvatarView2 = (QQProAvatarView) findViewById3;
        View findViewById4 = view.findViewById(R.id.w6z);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.g\u2026commend_voice_avatar1_bg)");
        View findViewById5 = view.findViewById(R.id.f165476w71);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.g\u2026commend_voice_avatar2_bg)");
        relativeLayout.setVisibility(4);
        if (!avatarList.isEmpty()) {
            boolean z16 = false;
            relativeLayout.setVisibility(0);
            qQProAvatarView.setVisibility(0);
            qQProAvatarView2.setVisibility(0);
            orNull = CollectionsKt___CollectionsKt.getOrNull(avatarList, 0);
            qQProAvatarView.B((String) orNull);
            findViewById4.setVisibility(0);
            findViewById5.setVisibility(0);
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(avatarList, 1);
            CharSequence charSequence = (CharSequence) orNull2;
            if (charSequence == null || charSequence.length() == 0) {
                z16 = true;
            }
            if (z16) {
                qQProAvatarView2.B("https://downv6.qq.com/innovate/guild/sfeed/mvp_guild_recommend_avatar_default.png");
            } else {
                qQProAvatarView2.B(avatarList.get(1));
            }
        }
    }

    private final void H(IGProHotLiveCard liveInfo, int index, String event) {
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        LinearLayout linearLayout = this.mCardsContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardsContainer");
            linearLayout = null;
        }
        iGuildDTReportApi.reportDtEventManual(linearLayout, "em_sgrp_discover_wonderful_module_list", event, M(liveInfo, index));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(QQProAvatarView avatarView, int color) {
        if (avatarView.getVisibility() != 0) {
            return;
        }
        OvalShape ovalShape = new OvalShape();
        ovalShape.resize(avatarView.getWidth(), avatarView.getHeight());
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.getPaint().setColor(color);
        avatarView.setBackground(shapeDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(final ImageView blurBg, final int color) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.am
            @Override // java.lang.Runnable
            public final void run() {
                an.L(blurBg, color);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ImageView blurBg, int i3) {
        Intrinsics.checkNotNullParameter(blurBg, "$blurBg");
        blurBg.setVisibility(0);
        blurBg.setBackground(GuildUIUtils.f235378a.k(i3, kotlin.g.a(i3, 10), 255));
    }

    private final HashMap<String, Object> M(IGProHotLiveCard liveInfo, int index) {
        String str;
        Object obj;
        String str2;
        Object obj2;
        HashMap<String, Object> hashMap = new HashMap<>();
        Object obj3 = "";
        if (liveInfo == null || (str = Long.valueOf(liveInfo.getGuildId()).toString()) == null) {
            str = "";
        }
        hashMap.put("sgrp_channel_id", str);
        hashMap.put("sgrp_module_place", Integer.valueOf(index));
        if (liveInfo == null) {
            obj = "";
        } else {
            obj = Long.valueOf(liveInfo.getChannelId());
        }
        hashMap.put("sgrp_sub_channel_id", obj);
        if (liveInfo != null) {
            str2 = liveInfo.getThemeSessionId();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("sgrp_subchannel_session_id", str2);
        if (liveInfo == null) {
            obj2 = "";
        } else {
            obj2 = Long.valueOf(liveInfo.getRoomId());
        }
        hashMap.put("sgrp_live_room_id", obj2);
        if (liveInfo != null) {
            obj3 = Integer.valueOf(liveInfo.getThemeType());
        }
        hashMap.put("sgrp_content_card_type", obj3);
        return hashMap;
    }

    private final void N(UpdateRecommendLivesData event) {
        QLog.d("RecommendPopularLiveSection", 1, "handleUpdateRecommendLivesData");
        B(event.getData());
    }

    private final void O(Context context) {
        GuildHotLiveFragment.Companion.e(GuildHotLiveFragment.INSTANCE, context, new OpenParam(null, null, null, false, 0, 0, null, 10, 0, false, null, null, 3967, null), null, this.itemList, 4, null);
    }

    private final void Q() {
        RoundImageView roundImageView;
        String str;
        ImageView imageView;
        String str2;
        com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
        RoundImageView roundImageView2 = this.mBg;
        if (roundImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBg");
            roundImageView = null;
        } else {
            roundImageView = roundImageView2;
        }
        GuildThemeManager guildThemeManager = GuildThemeManager.f235286a;
        if (guildThemeManager.b()) {
            str = "https://downv6.qq.com/innovate/guild/sfeed/guild_discover_hotlive_bg_dark.png";
        } else {
            str = "https://downv6.qq.com/innovate/guild/sfeed/guild_discover_hotlive_bg.png";
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, roundImageView, str, 0, 0, false, 28, null);
        ImageView imageView2 = this.mTitle;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            imageView = null;
        } else {
            imageView = imageView2;
        }
        if (guildThemeManager.b()) {
            str2 = "https://downv6.qq.com/innovate/guild/sfeed/guild_discover_hotlive_title_dark.png";
        } else {
            str2 = "https://downv6.qq.com/innovate/guild/sfeed/guild_discover_hotlive_title.png";
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(dVar, imageView, str2, 0, 0, false, 28, null);
        FrameLayout frameLayout = this.mRoot;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            frameLayout = null;
        }
        RoundImageView roundImageView3 = this.mBg;
        if (roundImageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBg");
            roundImageView3 = null;
        }
        frameLayout.setBackground(ResourcesCompat.getDrawable(roundImageView3.getResources(), R.drawable.qui_common_fill_light_secondary_bg_corner_4, null));
    }

    private final void R(RecommendHotLiveData data, String event) {
        ArrayList<IGProHotLiveCard> hotLives = data.getHotLives();
        Intrinsics.checkNotNullExpressionValue(hotLives, "data.hotLives");
        int i3 = 0;
        for (Object obj : hotLives) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            H((IGProHotLiveCard) obj, i3, event);
            i3 = i16;
        }
    }

    private final void S(ImageView blurBg, ImageView bgView, QQProAvatarView avatarView, String cover) {
        if (!TextUtils.isEmpty(cover)) {
            com.tencent.mobileqq.guild.discoveryv2.util.d.c(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, bgView, cover, 0, 0, false, 28, null);
            d.Companion companion = vg1.d.INSTANCE;
            RoundImageView roundImageView = this.mBg;
            if (roundImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBg");
                roundImageView = null;
            }
            companion.k(cover, roundImageView.getWidth(), new b(blurBg, avatarView));
        }
    }

    private final void T(ImageView iconView, View bgView, QQProAvatarView avatarView, int type) {
        String str;
        boolean z16;
        int i3 = T;
        int i16 = U;
        int i17 = V;
        if (type == 2) {
            int i18 = this.voiceCount + 1;
            this.voiceCount = i18;
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 == 3) {
                        i3 = R;
                        i16 = S;
                        i17 = X;
                    }
                } else {
                    i3 = P;
                    i16 = Q;
                    i17 = W;
                }
            } else {
                i3 = M;
                i16 = N;
            }
            str = "https://downv6.qq.com/innovate/guild_mvp_voice_bg_icon.png";
            z16 = true;
        } else {
            str = "https://downv6.qq.com/innovate/guild_mvp_live_bg_icon.png";
            z16 = false;
        }
        bgView.setBackground(GuildUIUtils.f235378a.k(i3, i16, 255));
        iconView.setVisibility(0);
        com.tencent.mobileqq.guild.discoveryv2.util.d.c(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, iconView, str, 0, 0, false, 28, null);
        if (z16) {
            J(avatarView, i17);
        }
    }

    private final void U(View view, int channelType, int themeType) {
        View findViewById = view.findViewById(R.id.wvq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.guild_recommend_right_icon)");
        LottieAnimationViewEx lottieAnimationViewEx = (LottieAnimationViewEx) findViewById;
        this.mIconLottie = lottieAnimationViewEx;
        LottieAnimationViewEx lottieAnimationViewEx2 = null;
        if (channelType != 2) {
            if (channelType == 5) {
                if (lottieAnimationViewEx == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                    lottieAnimationViewEx = null;
                }
                lottieAnimationViewEx.setAnimation(getRootView().getContext().getString(R.string.f152801ad));
            }
        } else {
            if (themeType != 2) {
                if (themeType != 4) {
                    if (themeType != 6) {
                        if (themeType != 7) {
                            if (lottieAnimationViewEx == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                                lottieAnimationViewEx = null;
                            }
                            lottieAnimationViewEx.setAnimation(getRootView().getContext().getString(R.string.f152821af));
                        } else {
                            ImageView imageView = (ImageView) view.findViewById(R.id.wze);
                            imageView.setVisibility(0);
                            com.tencent.mobileqq.guild.discoveryv2.util.d.c(com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a, imageView, "https://downv6.qq.com/innovate/creen_share_icon.png", 0, 0, false, 28, null);
                            return;
                        }
                    }
                } else {
                    if (lottieAnimationViewEx == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                        lottieAnimationViewEx = null;
                    }
                    lottieAnimationViewEx.setAnimation(getRootView().getContext().getString(R.string.f152811ae));
                }
            }
            if (lottieAnimationViewEx == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                lottieAnimationViewEx = null;
            }
            lottieAnimationViewEx.setAnimation(getRootView().getContext().getString(R.string.f152791ac));
        }
        LottieAnimationViewEx lottieAnimationViewEx3 = this.mIconLottie;
        if (lottieAnimationViewEx3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            lottieAnimationViewEx3 = null;
        }
        lottieAnimationViewEx3.setVisibility(0);
        LottieAnimationViewEx lottieAnimationViewEx4 = this.mIconLottie;
        if (lottieAnimationViewEx4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
        } else {
            lottieAnimationViewEx2 = lottieAnimationViewEx4;
        }
        lottieAnimationViewEx2.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull RecommendHotLiveData data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("RecommendPopularLiveSection", 1, "RecommendHotLiveData data.hotLives: " + data.getHotLives());
        Q();
        B(data.getHotLives());
        R(data, "imp");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateRecommendLivesData.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        O(context);
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.av, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.vej);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.frame_layer)");
            this.mRoot = (FrameLayout) findViewById;
            View findViewById2 = containerView.findViewById(R.id.toq);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.cards_container)");
            this.mCardsContainer = (LinearLayout) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.w6r);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ry_v2_recommend_lives_bg)");
            this.mBg = (RoundImageView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.w6s);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026v2_recommend_lives_title)");
            this.mTitle = (ImageView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.f71263no);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026ecommend_hot_lives_card1)");
            this.leftCardContainer = (FrameLayout) findViewById5;
            LayoutInflater from = LayoutInflater.from(containerView.getContext());
            FrameLayout frameLayout = this.leftCardContainer;
            View view = null;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftCardContainer");
                frameLayout = null;
            }
            View inflate = from.inflate(R.layout.f168065em2, (ViewGroup) frameLayout, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(containerView.conte\u2026      false\n            )");
            this.leftCard = inflate;
            FrameLayout frameLayout2 = this.leftCardContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftCardContainer");
                frameLayout2 = null;
            }
            View view2 = this.leftCard;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("leftCard");
                view2 = null;
            }
            frameLayout2.addView(view2);
            View findViewById6 = containerView.findViewById(R.id.f71273np);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026ecommend_hot_lives_card2)");
            this.topCardContainer = (FrameLayout) findViewById6;
            LayoutInflater from2 = LayoutInflater.from(containerView.getContext());
            FrameLayout frameLayout3 = this.topCardContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
                frameLayout3 = null;
            }
            View inflate2 = from2.inflate(R.layout.elt, (ViewGroup) frameLayout3, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(containerView.conte\u2026      false\n            )");
            this.topCard = inflate2;
            FrameLayout frameLayout4 = this.topCardContainer;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topCardContainer");
                frameLayout4 = null;
            }
            View view3 = this.topCard;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topCard");
                view3 = null;
            }
            frameLayout4.addView(view3);
            View findViewById7 = containerView.findViewById(R.id.f71283nq);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026ecommend_hot_lives_card3)");
            this.bottomCardContainer = (FrameLayout) findViewById7;
            LayoutInflater from3 = LayoutInflater.from(containerView.getContext());
            FrameLayout frameLayout5 = this.bottomCardContainer;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomCardContainer");
                frameLayout5 = null;
            }
            View inflate3 = from3.inflate(R.layout.elt, (ViewGroup) frameLayout5, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "from(containerView.conte\u2026      false\n            )");
            this.bottomCard = inflate3;
            FrameLayout frameLayout6 = this.bottomCardContainer;
            if (frameLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomCardContainer");
                frameLayout6 = null;
            }
            View view4 = this.bottomCard;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomCard");
            } else {
                view = view4;
            }
            frameLayout6.addView(view);
            View rootView = getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            ViewExtKt.b(rootView, this);
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d p16 = p();
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        boolean i3 = p16.i((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData, v3, this.mPosition);
        EventCollector.getInstance().onViewLongClicked(v3);
        return i3;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof UpdateRecommendLivesData) {
            N((UpdateRecommendLivesData) event);
        }
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
        Q();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        LottieAnimationViewEx lottieAnimationViewEx = this.mIconLottie;
        if (lottieAnimationViewEx == null) {
            return;
        }
        LottieAnimationViewEx lottieAnimationViewEx2 = null;
        if (lottieAnimationViewEx == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            lottieAnimationViewEx = null;
        }
        if (lottieAnimationViewEx.getVisibility() == 0) {
            if (!visible) {
                LottieAnimationViewEx lottieAnimationViewEx3 = this.mIconLottie;
                if (lottieAnimationViewEx3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
                } else {
                    lottieAnimationViewEx2 = lottieAnimationViewEx3;
                }
                lottieAnimationViewEx2.pauseAnimation();
                return;
            }
            LottieAnimationViewEx lottieAnimationViewEx4 = this.mIconLottie;
            if (lottieAnimationViewEx4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconLottie");
            } else {
                lottieAnimationViewEx2 = lottieAnimationViewEx4;
            }
            lottieAnimationViewEx2.playAnimation();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/content/recommend/section/an$b", "Lvg1/d$c;", "", "mainColor", "", "c", "", "url", "Landroid/graphics/Bitmap;", "blurBitmap", "a", NodeProps.SHADOW_COLOR, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements d.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f217265b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQProAvatarView f217266c;

        b(ImageView imageView, QQProAvatarView qQProAvatarView) {
            this.f217265b = imageView;
            this.f217266c = qQProAvatarView;
        }

        @Override // vg1.d.c
        public void a(@NotNull String url, @Nullable Bitmap blurBitmap) {
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // vg1.d.c
        public void b(int shadowColor) {
            an.this.K(this.f217265b, shadowColor);
            an.this.J(this.f217266c, shadowColor);
        }

        @Override // vg1.d.c
        public void c(int mainColor) {
        }
    }
}
