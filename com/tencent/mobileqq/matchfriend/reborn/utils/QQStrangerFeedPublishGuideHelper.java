package com.tencent.mobileqq.matchfriend.reborn.utils;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManager;
import com.tencent.mobileqq.matchfriend.reborn.publish.config.QQStrangerSquarePublishConfigMgr;
import com.tencent.mobileqq.matchfriend.reborn.publish.config.TipsBean;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001c\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/utils/QQStrangerFeedPublishGuideHelper;", "", "Landroid/view/View;", "anchorView", "customView", "Lcom/tencent/biz/richframework/order/IOrderElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/mobileqq/widget/tip/a;", "d", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "imageView", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "e", "Landroid/widget/TextView;", "textView", "", "tip", "f", "g", tl.h.F, "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerFeedPublishGuideHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerFeedPublishGuideHelper f245463a = new QQStrangerFeedPublishGuideHelper();

    QQStrangerFeedPublishGuideHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.tip.a d(View anchorView, View customView, IOrderElement element) {
        com.tencent.mobileqq.widget.tip.a f16 = com.tencent.mobileqq.widget.tip.a.r(anchorView.getContext()).S(anchorView).a0(customView).i0(0.0f, -16.0f).Z(1, 0).f(new a(element));
        Intrinsics.checkNotNullExpressionValue(f16, "element: IOrderElement):\u2026         }\n            })");
        return f16;
    }

    public final void g() {
        QQStrangerSquarePublishConfigMgr.f245289a.f(new Function1<TipsBean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.utils.QQStrangerFeedPublishGuideHelper$preload$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TipsBean tipsBean) {
                invoke2(tipsBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TipsBean tipsBean) {
                String imageUrl;
                if (QLog.isColorLevel()) {
                    QLog.i("QQStrangerFeedPublishGuideHelper", 2, "[preload] tipsBean ready=" + (tipsBean != null));
                }
                if (tipsBean == null || (imageUrl = tipsBean.getImageUrl()) == null) {
                    return;
                }
                QQPicLoader.f201806a.d().download(Option.obtainDownloadOption().setUrl(imageUrl), null);
            }
        });
    }

    public final void h(View anchorView, IOrderElement element) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(element, "element");
        QQStrangerSquarePublishConfigMgr.f245289a.f(new QQStrangerFeedPublishGuideHelper$showGuideBubble$1(anchorView, element));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(RoundCornerImageView imageView, Bitmap bitmap) {
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setCorner(com.tencent.qqnt.aio.utils.l.b(4));
            imageView.setBorder(true);
            imageView.setBorderWidth(com.tencent.qqnt.aio.utils.l.b(1));
            imageView.setColor(imageView.getContext().getResources().getColor(R.color.qui_common_icon_allwhite_primary, null));
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(TextView textView, String tip) {
        int coerceAtMost;
        if (textView != null) {
            if (tip == null || tip.length() == 0) {
                return;
            }
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(com.tencent.qqnt.aio.utils.l.a(14.0f));
            textPaint.setTypeface(Typeface.defaultFromStyle(1));
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(10, tip.length());
            String substring = tip.substring(0, coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            float measureText = textPaint.measureText(substring);
            textView.setText(tip);
            textView.setWidth((int) measureText);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/utils/QQStrangerFeedPublishGuideHelper$a", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IOrderElement f245464a;

        a(IOrderElement iOrderElement) {
            this.f245464a = iOrderElement;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            ScheduleManager.b(m82.a.f416439a.a(), this.f245464a, null, null, 6, null);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
        }
    }
}
