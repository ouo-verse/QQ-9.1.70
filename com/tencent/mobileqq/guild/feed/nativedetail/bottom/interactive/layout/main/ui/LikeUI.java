package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.util.bc;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;
import wk1.FeedReferRequestArgs;
import wk1.InputStyleConfig;
import wk1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001MB\u000f\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\"\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0014\u0010!\u001a\u00020\u00042\n\u0010 \u001a\u00060\u001ej\u0002`\u001fH\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0019H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0019H\u0016J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010/\u001a\u00020\u00042\n\u0010.\u001a\u00060\u001ej\u0002`\u001fH\u0016R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010CR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010CR\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010ER\u001d\u0010J\u001a\u0004\u0018\u00010F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010G\u001a\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/LikeUI;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/d;", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "v", "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "from", "p", "y", UserInfo.SEX_FEMALE, "result", "Lwk1/b;", "args", "", "rsp", "o", DomainData.DOMAIN_NAME, "", "feedId", "", "isPrefer", "preferCount", HippyTKDListViewAdapter.X, "w", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "data", BdhLogUtil.LogTag.Tag_Conn, "E", "D", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "prefer", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "init", "enable", "u1", "action", "msg", "c", "bottomInteractData", "b", "Lwk1/h;", "d", "Lwk1/h;", "inputContext", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "likeTv", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "likeIv", tl.h.F, "Landroid/view/ViewGroup;", "likeLayout", "Lcom/airbnb/lottie/LottieAnimationView;", "i", "Lcom/airbnb/lottie/LottieAnimationView;", "likeAnimView", "Z", "hasInitPrefer", "I", "Lwk1/f;", "Lkotlin/Lazy;", "l", "()Lwk1/f;", "feedLikeManage", "<init>", "(Lwk1/h;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LikeUI implements d {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isPrefer;

    /* renamed from: D, reason: from kotlin metadata */
    private int preferCount;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedLikeManage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.h inputContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView likeTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView likeIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup likeLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView likeAnimView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasInitPrefer;

    public LikeUI(@NotNull wk1.h inputContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<wk1.f>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.LikeUI$feedLikeManage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final wk1.f invoke() {
                wk1.h hVar;
                hVar = LikeUI.this.inputContext;
                return hVar.f();
            }
        });
        this.feedLikeManage = lazy;
    }

    private final void A(boolean prefer) {
        Integer iconColor;
        ImageView imageView = null;
        if (prefer) {
            ImageView imageView2 = this.likeIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeIv");
            } else {
                imageView = imageView2;
            }
            imageView.setImageDrawable(GuildUIUtils.w(this.inputContext.getContext(), R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error)));
            return;
        }
        InputStyleConfig d16 = this.inputContext.d();
        if (d16 != null && (iconColor = d16.getIconColor()) != null) {
            int intValue = iconColor.intValue();
            ImageView imageView3 = this.likeIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeIv");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(GuildUIUtils.y(this.inputContext.getContext(), R.drawable.guild_feed_item_up_vote_icon_normal, intValue));
            iconColor.intValue();
            return;
        }
        ImageView imageView4 = this.likeIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeIv");
            imageView4 = null;
        }
        imageView4.setImageDrawable(GuildUIUtils.x(this.inputContext.getContext(), R.drawable.guild_feed_item_up_vote_icon_normal, null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        A(true);
    }

    private final void C(qj1.b data) {
        boolean z16;
        boolean z17;
        wk1.f l3 = l();
        boolean z18 = false;
        if (l3 != null && l3.isRequesting(this.inputContext.getFeedId())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.hasInitPrefer = true;
        if (this.preferCount == data.e()) {
            boolean z19 = this.isPrefer;
            if (data.getPreferStatus() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z19 == z17) {
                return;
            }
        }
        this.preferCount = data.e();
        D();
        if (data.getPreferStatus() == 1) {
            z18 = true;
        }
        this.isPrefer = z18;
        E();
    }

    private final void D() {
        boolean z16;
        String h16 = bl1.b.h(bl1.b.f28597a, this.preferCount, null, null, 6, null);
        TextView textView = this.likeTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeTv");
            textView = null;
        }
        if (h16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h16 = this.inputContext.getContext().getString(R.string.f144510oz);
            Intrinsics.checkNotNullExpressionValue(h16, "inputContext.context.get\u2026_native_detail_like_tips)");
        }
        textView.setText(h16);
    }

    private final void E() {
        if (this.isPrefer) {
            B();
        } else {
            z();
        }
    }

    private final void F() {
        if (this.isPrefer) {
            this.isPrefer = false;
            this.preferCount--;
            z();
            D();
            return;
        }
        this.isPrefer = true;
        this.preferCount++;
        LottieAnimationView lottieAnimationView = this.likeAnimView;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeAnimView");
            lottieAnimationView = null;
        }
        lottieAnimationView.setVisibility(0);
        LottieAnimationView lottieAnimationView3 = this.likeAnimView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeAnimView");
        } else {
            lottieAnimationView2 = lottieAnimationView3;
        }
        lottieAnimationView2.playAnimation();
        D();
    }

    private final wk1.f l() {
        return (wk1.f) this.feedLikeManage.getValue();
    }

    private final void m() {
        p(2);
    }

    private final void n(FeedReferRequestArgs args) {
        if (!Intrinsics.areEqual(args.getFeedId(), this.inputContext.getFeedId())) {
            QLog.i("MainInputLikeUI", 1, "handleDoFeedPreferRsp curFeedId:" + this.inputContext.getFeedId() + " args:" + args + " ");
            x(args.getFeedId(), args.getIsPrefer(), args.getPreferCount());
            return;
        }
        if (this.isPrefer && args.getIsPrefer()) {
            this.isPrefer = false;
            this.preferCount--;
            z();
            D();
        } else if (!this.isPrefer && !args.getIsPrefer()) {
            this.isPrefer = true;
            this.preferCount++;
            B();
            D();
        }
        x(this.inputContext.getFeedId(), this.isPrefer, this.preferCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int result, FeedReferRequestArgs args, Object rsp) {
        if (result != 0) {
            n(args);
        }
    }

    private final void p(int from) {
        GuildFeedPublishInfo guildFeedPublishInfo;
        boolean z16;
        InputStyleConfig d16;
        Long likeVibrate;
        QLog.i("MainInputLikeUI", 1, "handleLikeLayoutClick from:" + from);
        Object obj = this.inputContext.a().get("Feed_Publish_Info");
        ViewGroup viewGroup = null;
        if (obj instanceof GuildFeedPublishInfo) {
            guildFeedPublishInfo = (GuildFeedPublishInfo) obj;
        } else {
            guildFeedPublishInfo = null;
        }
        if (bn.f223895a.i(guildFeedPublishInfo)) {
            QLog.i("MainInputLikeUI", 1, "handleLikeLayoutClick showToast");
            return;
        }
        ViewGroup viewGroup2 = this.likeLayout;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeLayout");
            viewGroup2 = null;
        }
        if (o.a(viewGroup2)) {
            QLog.i("MainInputLikeUI", 1, "handleLikeLayoutClick isFastClick");
            return;
        }
        y(from);
        if (this.isPrefer && from == 2) {
            QLog.i("MainInputLikeUI", 1, "handleDoExecuteLike isPrefer return");
            return;
        }
        if (l() == null) {
            QLog.i("MainInputLikeUI", 1, "handleLikeLayoutClick feedLikeManage is null");
            return;
        }
        if (this.hasInitPrefer) {
            wk1.f l3 = l();
            Intrinsics.checkNotNull(l3);
            if (!l3.isRequesting(this.inputContext.getFeedId())) {
                LottieAnimationView lottieAnimationView = this.likeAnimView;
                if (lottieAnimationView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("likeAnimView");
                    lottieAnimationView = null;
                }
                if (!lottieAnimationView.isAnimating()) {
                    if (!this.isPrefer && (d16 = this.inputContext.d()) != null && (likeVibrate = d16.getLikeVibrate()) != null) {
                        QQGuildUIUtil.T(likeVibrate.longValue());
                    }
                    F();
                    x(this.inputContext.getFeedId(), this.isPrefer, this.preferCount);
                    w();
                    boolean z17 = false;
                    if (guildFeedPublishInfo != null && guildFeedPublishInfo.isLocalFeed()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        wk1.f l16 = l();
                        Intrinsics.checkNotNull(l16);
                        ViewGroup viewGroup3 = this.likeLayout;
                        if (viewGroup3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("likeLayout");
                        } else {
                            viewGroup = viewGroup3;
                        }
                        Context context = viewGroup.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "likeLayout.context");
                        String feedId = this.inputContext.getFeedId();
                        long parseLong = Long.parseLong(this.inputContext.getGuildId());
                        long parseLong2 = Long.parseLong(this.inputContext.getChannelId());
                        int i3 = this.preferCount;
                        boolean z18 = this.isPrefer;
                        wk1.f l17 = l();
                        Intrinsics.checkNotNull(l17);
                        l16.a(new FeedReferRequestArgs(context, feedId, parseLong, parseLong2, i3, z18, l17.b()), new LikeUI$handleLikeLayoutClick$2(this));
                        return;
                    }
                    if (guildFeedPublishInfo.getMainTaskId().length() > 0) {
                        z17 = true;
                    }
                    if (z17) {
                        bc.p(guildFeedPublishInfo.getMainTaskId(), this.isPrefer);
                        QLog.i("MainInputLikeUI", 1, "handleLikeLayoutClick isLocalFeed idd:" + this.inputContext.getFeedId() + " mainTaskId:" + guildFeedPublishInfo.getMainTaskId());
                        return;
                    }
                    QLog.e("MainInputLikeUI", 1, "handleLikeLayoutClick isLocalFeed idd:" + this.inputContext.getFeedId() + " no mainTaskId");
                    return;
                }
            }
        }
        QLog.i("MainInputLikeUI", 1, "handleLikeLayoutClick return");
    }

    private final void q(ViewGroup rootView) {
        View findViewById = rootView.findViewById(R.id.yi5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.like_anim_view)");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById;
        this.likeAnimView = lottieAnimationView;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeAnimView");
            lottieAnimationView = null;
        }
        lottieAnimationView.setAnimation("feed/feed_item/feed_native_detail_like_anim.json");
        LottieAnimationView lottieAnimationView3 = this.likeAnimView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeAnimView");
        } else {
            lottieAnimationView2 = lottieAnimationView3;
        }
        lottieAnimationView2.addAnimatorListener(new b());
    }

    private final void r(ViewGroup rootView) {
        View findViewById = rootView.findViewById(R.id.e9k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.like_iv)");
        this.likeIv = (ImageView) findViewById;
        z();
    }

    private final void s(ViewGroup rootView) {
        View findViewById = rootView.findViewById(R.id.e9l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.like_layout)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.likeLayout = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeLayout");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LikeUI.t(LikeUI.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(LikeUI this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u() {
        FeedDetailMainData feedDetailMainData;
        g.OnGetFeedDetailMainDataMessage onGetFeedDetailMainDataMessage = null;
        Object I2 = this.inputContext.getDelegate().I2("action_get_detail_main_data", null);
        if (I2 instanceof g.OnGetFeedDetailMainDataMessage) {
            onGetFeedDetailMainDataMessage = (g.OnGetFeedDetailMainDataMessage) I2;
        }
        if (onGetFeedDetailMainDataMessage != null && (feedDetailMainData = onGetFeedDetailMainDataMessage.getFeedDetailMainData()) != null) {
            C(feedDetailMainData.getBottomInteractiveDisplayable());
        }
    }

    private final void v(ViewGroup rootView) {
        Integer iconColor;
        View findViewById = rootView.findViewById(R.id.e9q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.like_tv)");
        this.likeTv = (TextView) findViewById;
        InputStyleConfig d16 = this.inputContext.d();
        if (d16 != null && (iconColor = d16.getIconColor()) != null) {
            int intValue = iconColor.intValue();
            TextView textView = this.likeTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeTv");
                textView = null;
            }
            textView.setTextColor(intValue);
        }
    }

    private final void w() {
        int i3;
        if (this.isPrefer) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        this.inputContext.getDelegate().lh("message_on_do_prefer", new a.OnDoPreferMessage(this.inputContext.getFeedId(), i3));
    }

    private final void x(String feedId, boolean isPrefer, int preferCount) {
        int i3;
        if (isPrefer) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        wk1.i delegate = this.inputContext.getDelegate();
        a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = new a.ModifyBottomInteractiveDataMessage(null, false, null, null, null, null, 61, null);
        modifyBottomInteractiveDataMessage.h(feedId);
        modifyBottomInteractiveDataMessage.i(Integer.valueOf(preferCount));
        modifyBottomInteractiveDataMessage.j(Integer.valueOf(i3));
        Unit unit = Unit.INSTANCE;
        delegate.lh("message_modify_bottom_interact_data", modifyBottomInteractiveDataMessage);
    }

    private final void y(int from) {
        Map<String, Object> hashMap;
        wk1.e c16 = this.inputContext.c();
        if (c16 == null || (hashMap = c16.b()) == null) {
            hashMap = new HashMap<>();
        }
        boolean z16 = this.isPrefer;
        hashMap.put("sgrp_state", Integer.valueOf(z16 ? 1 : 0));
        hashMap.put("sgrp_action_result", Integer.valueOf(z16 ? 1 : 0));
        hashMap.put("sgrp_click_region", Integer.valueOf(from));
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.likeLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeLayout");
            view = null;
        }
        iGuildDTReportApi.reportDtEventManual(view, "em_sgrp_forum_up", "clck", hashMap);
    }

    private final void z() {
        A(false);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void a() {
        d.a.d(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void b(@NotNull qj1.b bottomInteractData) {
        Intrinsics.checkNotNullParameter(bottomInteractData, "bottomInteractData");
        C(bottomInteractData);
    }

    @Override // wk1.j
    public void c(@NotNull String action, @Nullable Object msg2) {
        wk1.e c16;
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, "message_on_do_execute_like")) {
            m();
            return;
        }
        if (Intrinsics.areEqual(action, "message_on_bottom_interact_exposure") && (c16 = this.inputContext.c()) != null) {
            ViewGroup viewGroup = this.likeLayout;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeLayout");
                viewGroup = null;
            }
            e.a.c(c16, viewGroup, 2, null, 4, null);
        }
    }

    @Override // wk1.j
    @Nullable
    public Object d(@NotNull String str, @Nullable Object obj) {
        return d.a.b(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void e(@NotNull SpeakPermissionType speakPermissionType) {
        d.a.e(this, speakPermissionType);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void init(@NotNull ViewGroup rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        v(rootView);
        r(rootView);
        s(rootView);
        q(rootView);
        u();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.d
    public void u1(boolean enable) {
        bl1.d dVar = bl1.d.f28604a;
        ViewGroup viewGroup = this.likeLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("likeLayout");
            viewGroup = null;
        }
        dVar.a(viewGroup, enable);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/ui/LikeUI$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            LottieAnimationView lottieAnimationView = LikeUI.this.likeAnimView;
            ImageView imageView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeAnimView");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(4);
            ImageView imageView2 = LikeUI.this.likeIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeIv");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            ImageView imageView = LikeUI.this.likeIv;
            LottieAnimationView lottieAnimationView = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeIv");
                imageView = null;
            }
            imageView.setVisibility(4);
            LikeUI.this.B();
            LottieAnimationView lottieAnimationView2 = LikeUI.this.likeAnimView;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("likeAnimView");
            } else {
                lottieAnimationView = lottieAnimationView2;
            }
            lottieAnimationView.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
