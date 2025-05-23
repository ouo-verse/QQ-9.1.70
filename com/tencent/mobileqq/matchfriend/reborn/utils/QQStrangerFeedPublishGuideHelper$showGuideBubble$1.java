package com.tencent.mobileqq.matchfriend.reborn.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.matchfriend.reborn.publish.config.TipsBean;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;", "it", "", "invoke", "(Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerFeedPublishGuideHelper$showGuideBubble$1 extends Lambda implements Function1<TipsBean, Unit> {
    final /* synthetic */ View $anchorView;
    final /* synthetic */ IOrderElement $element;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerFeedPublishGuideHelper$showGuideBubble$1(View view, IOrderElement iOrderElement) {
        super(1);
        this.$anchorView = view;
        this.$element = iOrderElement;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TipsBean tipsBean, final View anchorView, final IOrderElement element, final LoadState loadState, final Option option) {
        Object first;
        Intrinsics.checkNotNullParameter(anchorView, "$anchorView");
        Intrinsics.checkNotNullParameter(element, "$element");
        QLog.i("QQStrangerFeedPublishGuideHelper", 1, "[showGuideBubble] state = " + loadState);
        if (!loadState.isFinishSuccess() || option.getResultBitMap() == null) {
            return;
        }
        if (option.getResultBitMap() != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) tipsBean.b());
            final String str = (String) first;
            if (str.length() == 0) {
                QLog.e("QQStrangerFeedPublishGuideHelper", 1, "[showGuideBubble] tip is empty.");
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQStrangerFeedPublishGuideHelper$showGuideBubble$1.d(LoadState.this, anchorView, element, option, str);
                    }
                });
                return;
            }
        }
        QLog.e("QQStrangerFeedPublishGuideHelper", 1, "[showGuideBubble] resultBitmap is null.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LoadState loadState, View anchorView, IOrderElement element, Option option, String tip) {
        com.tencent.mobileqq.widget.tip.a d16;
        Intrinsics.checkNotNullParameter(anchorView, "$anchorView");
        Intrinsics.checkNotNullParameter(element, "$element");
        Intrinsics.checkNotNullParameter(tip, "$tip");
        QLog.i("QQStrangerFeedPublishGuideHelper", 1, "[showGuideBubble] state = " + loadState);
        View contentView = LayoutInflater.from(anchorView.getContext()).inflate(R.layout.f167365cx3, (ViewGroup) null);
        QQStrangerFeedPublishGuideHelper qQStrangerFeedPublishGuideHelper = QQStrangerFeedPublishGuideHelper.f245463a;
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        d16 = qQStrangerFeedPublishGuideHelper.d(anchorView, contentView, element);
        qQStrangerFeedPublishGuideHelper.e((RoundCornerImageView) contentView.findViewById(R.id.f163148ok2), option.getResultBitMap());
        qQStrangerFeedPublishGuideHelper.f((TextView) contentView.findViewById(R.id.f163149ok3), tip);
        d16.s0();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TipsBean tipsBean) {
        invoke2(tipsBean);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final TipsBean tipsBean) {
        if (tipsBean == null) {
            QLog.e("QQStrangerFeedPublishGuideHelper", 1, "[showGuideBubble] but tips config is null.");
            return;
        }
        Option requestHeight = Option.obtain().setUrl(tipsBean.getImageUrl()).setRequestWidth(com.tencent.qqnt.aio.utils.l.b(32)).setRequestHeight(com.tencent.qqnt.aio.utils.l.b(32));
        IPicLoader d16 = QQPicLoader.f201806a.d();
        final View view = this.$anchorView;
        final IOrderElement iOrderElement = this.$element;
        d16.loadImage(requestHeight, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.e
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QQStrangerFeedPublishGuideHelper$showGuideBubble$1.c(TipsBean.this, view, iOrderElement, loadState, option);
            }
        });
    }
}
