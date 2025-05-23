package com.qzone.reborn.publicaccount.area;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.util.ar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellPlainText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\bB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/publicaccount/area/RichContentAreaView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "b", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPlainText;", "info", "a", "d", "Landroid/content/Context;", "mContext", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "mContainerView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mFirstQuotesIcon", h.F, "mSecondQuotesIcon", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "mContentTextView", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class RichContentAreaView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mContainerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mFirstQuotesIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mSecondQuotesIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView mContentTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RichContentAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context);
    }

    private final void b(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.cnl, this);
        View findViewById = findViewById(R.id.nei);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rich_content_region)");
        this.mContainerView = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.f162739kc0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.icon_first_quotes)");
        this.mFirstQuotesIcon = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.ngp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.text_first_area)");
        this.mContentTextView = (QZoneRichTextView) findViewById3;
        View findViewById4 = findViewById(R.id.kdx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.icon_second_quotes)");
        this.mSecondQuotesIcon = (ImageView) findViewById4;
        QZoneRichTextView qZoneRichTextView = this.mContentTextView;
        QZoneRichTextView qZoneRichTextView2 = null;
        if (qZoneRichTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTextView");
            qZoneRichTextView = null;
        }
        qZoneRichTextView.setLineSpace(ar.e(2.0f));
        QZoneRichTextView qZoneRichTextView3 = this.mContentTextView;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTextView");
            qZoneRichTextView3 = null;
        }
        qZoneRichTextView3.setClickable(false);
        QZoneRichTextView qZoneRichTextView4 = this.mContentTextView;
        if (qZoneRichTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTextView");
            qZoneRichTextView4 = null;
        }
        qZoneRichTextView4.setLongclickable(false);
        QZoneRichTextView qZoneRichTextView5 = this.mContentTextView;
        if (qZoneRichTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentTextView");
        } else {
            qZoneRichTextView2 = qZoneRichTextView5;
        }
        qZoneRichTextView2.setCellClickable(false);
    }

    public final void a(QZoneOfficialAccountBase$CellPlainText info) {
        if (info != null && info.text.has()) {
            QZoneRichTextView qZoneRichTextView = this.mContentTextView;
            if (qZoneRichTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentTextView");
                qZoneRichTextView = null;
            }
            qZoneRichTextView.setRichText(info.text.get());
            return;
        }
        QLog.e("RichContentAreaView", 1, "[bindData] cellPlainText info:" + info);
    }
}
