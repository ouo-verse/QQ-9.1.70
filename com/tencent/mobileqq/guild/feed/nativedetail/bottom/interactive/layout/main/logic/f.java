package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic;

import android.animation.Animator;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.f;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDoFeedPreferReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDoFeedPreferRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoFeedPreferCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.FeedReferRequestArgs;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJy\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062U\u0010\u000e\u001aQ\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016Jg\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042U\u0010\u000e\u001aQ\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00120\u0017j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0012`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/f;", "Lwk1/f;", "", "result", "Lwk1/b;", "args", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProDoFeedPreferRsp;", "rsp", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/LikeCallBack;", "callback", "e", "", "feedId", "", "isRequesting", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStCommonExt;", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "requestingMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements wk1.f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Boolean> requestingMap = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J;\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/f$a;", "", "Landroid/widget/ImageView;", "iv", "Lcom/airbnb/lottie/LottieAnimationView;", "likeAnimView", "Landroid/widget/TextView;", "tv", "", "like", "", "currentCount", "", "a", "(Landroid/widget/ImageView;Lcom/airbnb/lottie/LottieAnimationView;Landroid/widget/TextView;ZLjava/lang/Long;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.f$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull ImageView iv5, @Nullable LottieAnimationView likeAnimView, @Nullable TextView tv5, boolean like, @Nullable Long currentCount) {
            Intrinsics.checkNotNullParameter(iv5, "iv");
            boolean z16 = true;
            Unit unit = null;
            if (like) {
                if (likeAnimView != null) {
                    if (likeAnimView.getComposition() == null) {
                        likeAnimView.setVisibility(4);
                        likeAnimView.setAnimation("feed/feed_item/feed_native_detail_like_anim.json");
                    }
                    likeAnimView.removeAllAnimatorListeners();
                    likeAnimView.addAnimatorListener(new C7750a(iv5, likeAnimView));
                    likeAnimView.setVisibility(0);
                    likeAnimView.playAnimation();
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    Context context = iv5.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "iv.context");
                    iv5.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error)));
                }
                if (currentCount != null && tv5 != null) {
                    String h16 = bl1.b.h(bl1.b.f28597a, (int) currentCount.longValue(), null, null, 6, null);
                    if (h16.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        h16 = tv5.getContext().getString(R.string.f144510oz);
                        Intrinsics.checkNotNullExpressionValue(h16, "tv.context.getString(R.s\u2026_native_detail_like_tips)");
                    }
                    tv5.setText(h16);
                    return;
                }
                return;
            }
            if (likeAnimView != null) {
                likeAnimView.setVisibility(8);
            }
            Context context2 = iv5.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "iv.context");
            iv5.setImageDrawable(GuildUIUtils.x(context2, R.drawable.guild_feed_item_up_vote_icon_token_selector, null, 4, null));
            if (tv5 != null && currentCount != null) {
                String h17 = bl1.b.h(bl1.b.f28597a, (int) currentCount.longValue(), null, null, 6, null);
                if (h17.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    h17 = tv5.getContext().getString(R.string.f144510oz);
                    Intrinsics.checkNotNullExpressionValue(h17, "noNoneTv.context.getStri\u2026_native_detail_like_tips)");
                }
                tv5.setText(h17);
            }
        }

        Companion() {
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/f$a$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7750a implements Animator.AnimatorListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ImageView f220660d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ LottieAnimationView f220661e;

            C7750a(ImageView imageView, LottieAnimationView lottieAnimationView) {
                this.f220660d = imageView;
                this.f220661e = lottieAnimationView;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(ImageView iv5) {
                Intrinsics.checkNotNullParameter(iv5, "$iv");
                Context context = iv5.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "iv.context");
                iv5.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error)));
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@Nullable Animator animation) {
                this.f220661e.setVisibility(4);
                this.f220660d.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@Nullable Animator animation) {
                this.f220660d.setVisibility(4);
                this.f220661e.setVisibility(0);
                LottieAnimationView lottieAnimationView = this.f220661e;
                final ImageView imageView = this.f220660d;
                lottieAnimationView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.Companion.C7750a.b(imageView);
                    }
                }, 200L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@Nullable Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@Nullable Animator animation) {
            }
        }
    }

    private final void e(int result, FeedReferRequestArgs args, GProDoFeedPreferRsp rsp, Function3<? super Integer, ? super FeedReferRequestArgs, Object, Unit> callback) {
        QLog.i("FeedLikeManage", 1, "DoFeedPrefer result = " + result + " feedId = " + args.getFeedId());
        this.requestingMap.remove(args.getFeedId());
        if (callback != null) {
            callback.invoke(Integer.valueOf(result), args, rsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(IPerformanceReportTask reportTask, final f this$0, final FeedReferRequestArgs args, final Function3 function3, final int i3, String str, boolean z16, final GProDoFeedPreferRsp gProDoFeedPreferRsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        com.tencent.mobileqq.guild.feed.report.c.E(com.tencent.mobileqq.guild.feed.report.c.f223280a, reportTask, i3, str, false, 8, null);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.d
            @Override // java.lang.Runnable
            public final void run() {
                f.g(f.this, i3, args, gProDoFeedPreferRsp, function3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(f this$0, int i3, FeedReferRequestArgs args, GProDoFeedPreferRsp gProDoFeedPreferRsp, Function3 function3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        this$0.e(i3, args, gProDoFeedPreferRsp, function3);
    }

    @Override // wk1.f
    public void a(@NotNull final FeedReferRequestArgs args, @Nullable final Function3<? super Integer, ? super FeedReferRequestArgs, Object, Unit> callback) {
        int i3;
        Intrinsics.checkNotNullParameter(args, "args");
        this.requestingMap.put(args.getFeedId(), Boolean.TRUE);
        GProDoFeedPreferReq gProDoFeedPreferReq = new GProDoFeedPreferReq();
        gProDoFeedPreferReq.feedId = args.getFeedId();
        gProDoFeedPreferReq.guildId = args.getGuildId();
        gProDoFeedPreferReq.channelId = args.getChannelId();
        if (args.getIsPrefer()) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        gProDoFeedPreferReq.action = i3;
        gProDoFeedPreferReq.extInfo = args.getStCommonExt();
        QLog.i("FeedLikeManage", 1, "doFeedPrefer feedId = " + args.getFeedId() + " isPrefer = " + args.getIsPrefer());
        final IPerformanceReportTask i16 = com.tencent.mobileqq.guild.feed.report.c.f223280a.i(gProDoFeedPreferReq);
        o c16 = l.c();
        if (c16 != null) {
            c16.doFeedPrefer(gProDoFeedPreferReq, new IGProDoFeedPreferCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.c
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoFeedPreferCallback
                public final void onResult(int i17, String str, boolean z16, GProDoFeedPreferRsp gProDoFeedPreferRsp) {
                    f.f(IPerformanceReportTask.this, this, args, callback, i17, str, z16, gProDoFeedPreferRsp);
                }
            });
        }
    }

    @Override // wk1.f
    @NotNull
    public GProStCommonExt b() {
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        gProStCommonExt.mapInfoList.addAll(yl1.i.f450608a.f());
        return gProStCommonExt;
    }

    @Override // wk1.f
    public boolean isRequesting(@NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        return this.requestingMap.containsKey(feedId);
    }
}
