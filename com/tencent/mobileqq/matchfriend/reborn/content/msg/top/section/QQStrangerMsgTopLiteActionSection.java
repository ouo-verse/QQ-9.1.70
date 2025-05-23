package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.config.b;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.QQStrangerMsgBaseSection;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgNoLongerRecommendEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgUserCardRemoveEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerSendEmojiMsgEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J(\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00032\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/section/QQStrangerMsgTopLiteActionSection;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/QQStrangerMsgBaseSection;", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "", "emojiId", "Landroid/graphics/drawable/Drawable;", HippyTKDListViewAdapter.X, "Landroid/content/Context;", "context", "", "tinyId", "", "nick", "traceId", "", "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "y", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "actionIv", "Lcom/airbnb/lottie/LottieAnimationView;", "f", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "<init>", "()V", tl.h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgTopLiteActionSection extends QQStrangerMsgBaseSection<Prompt$CardInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView actionIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView lottieView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/top/section/QQStrangerMsgTopLiteActionSection$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.d("QQStrangerMsgTopLiteActionSection", 1, "lottie animation end");
            LottieAnimationView lottieAnimationView = QQStrangerMsgTopLiteActionSection.this.lottieView;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(8);
        }
    }

    private final void A(int emojiId) {
        b.C8009b c8009b = com.tencent.mobileqq.matchfriend.reborn.config.c.f244198a.c().d().get(Integer.valueOf(emojiId));
        LottieAnimationView lottieAnimationView = null;
        String lottieUrl = c8009b != null ? c8009b.getLottieUrl() : null;
        if (lottieUrl == null || lottieUrl.length() == 0) {
            QLog.w("QQStrangerMsgTopLiteActionSection", 1, "startLottieAnimation url is null");
            return;
        }
        LottieAnimationView lottieAnimationView2 = this.lottieView;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationView2 = null;
        }
        lottieAnimationView2.addAnimatorListener(new b());
        LottieAnimationView lottieAnimationView3 = this.lottieView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationView3 = null;
        }
        lottieAnimationView3.setAnimationFromUrl(lottieUrl);
        LottieAnimationView lottieAnimationView4 = this.lottieView;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            lottieAnimationView4 = null;
        }
        lottieAnimationView4.setVisibility(0);
        LottieAnimationView lottieAnimationView5 = this.lottieView;
        if (lottieAnimationView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
        } else {
            lottieAnimationView = lottieAnimationView5;
        }
        lottieAnimationView.playAnimation();
    }

    private final void v(Context context, long tinyId, String nick, String traceId) {
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        Bundle bundle = new Bundle();
        bundle.putString("recom_trace", traceId);
        Unit unit = Unit.INSTANCE;
        iMatchFriendEntryApi.enterMatchFriendAIO(context, tinyId, nick, 12, bundle);
    }

    private final Drawable x(int emojiId) {
        int convertToLocal = QQSysFaceUtil.convertToLocal(emojiId);
        if (convertToLocal >= 0) {
            return QQSysFaceUtil.getFaceDrawable(convertToLocal);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.okj);
        ImageView imageView = (ImageView) findViewById;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(ViewUtils.dpToPx(1.0f), ContextCompat.getColorStateList(imageView.getContext(), R.color.qui_common_fill_standard_secondary));
        imageView.setBackground(gradientDrawable);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026)\n            }\n        }");
        this.actionIv = imageView;
        View findViewById2 = containerView.findViewById(R.id.ols);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.lottie)");
        this.lottieView = (LottieAnimationView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(final Prompt$CardInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        final int i3 = data.emoji_id.get();
        if (i3 > 0) {
            ImageView imageView = this.actionIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionIv");
                imageView = null;
            }
            imageView.setImageDrawable(x(i3));
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
            ImageView imageView2 = this.actionIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionIv");
                imageView2 = null;
            }
            Context context = imageView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "actionIv.context");
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.e(aVar, context, "em_kl_recommend_user_interact", null, 4, null);
        } else {
            ImageView imageView3 = this.actionIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionIv");
                imageView3 = null;
            }
            imageView3.setImageResource(R.drawable.qui_chat_testing);
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar2 = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
            ImageView imageView4 = this.actionIv;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actionIv");
                imageView4 = null;
            }
            Context context2 = imageView4.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "actionIv.context");
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.e(aVar2, context2, "em_kl_recommend_user_aio", null, 4, null);
        }
        ImageView imageView5 = this.actionIv;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionIv");
            imageView5 = null;
        }
        imageView5.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerMsgTopLiteActionSection.z(i3, this, data, view);
            }
        }, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.or8};
    }

    static /* synthetic */ void w(QQStrangerMsgTopLiteActionSection qQStrangerMsgTopLiteActionSection, Context context, long j3, String str, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str2 = "";
        }
        qQStrangerMsgTopLiteActionSection.v(context, j3, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(int i3, QQStrangerMsgTopLiteActionSection this$0, final Prompt$CardInfo data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (i3 > 0) {
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToast.makeText(view.getContext(), 1, view.getContext().getString(R.string.x0e), 0).show();
                return;
            }
            LottieAnimationView lottieAnimationView = this$0.lottieView;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                lottieAnimationView = null;
            }
            if (lottieAnimationView.getVisibility() == 0) {
                return;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerSendEmojiMsgEvent(c82.a.d(data), i3));
            this$0.A(i3);
            this$0.r(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section.QQStrangerMsgTopLiteActionSection$onBindData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgUserCardRemoveEvent(c82.a.d(Prompt$CardInfo.this)));
                }
            }, 2000L);
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgNoLongerRecommendEvent(data));
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.c(aVar, context, "em_kl_recommend_user_interact", null, 4, null);
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgNoLongerRecommendEvent(data));
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "it.context");
        w(this$0, context2, c82.a.d(data), c82.a.b(data), null, 8, null);
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar2 = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "it.context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.c(aVar2, context3, "em_kl_recommend_user_aio", null, 4, null);
    }
}
