package com.qzone.reborn.feedpro.widget.userhome;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qzone.reborn.feedpro.utils.aa;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellSealOffMemory;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/userhome/QzoneFeedProMemorySealView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellSealOffMemory;", "sealOffMemory", "", "f", "Landroid/view/View;", "view", "d", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "b", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mMsgText", "mSettingText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QzoneFeedProMemorySealView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mMsgText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mSettingText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProMemorySealView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QzoneFeedProMemorySealView this$0, CommonCellSealOffMemory commonCellSealOffMemory, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f(commonCellSealOffMemory);
        this$0.d(this$0.mSettingText);
    }

    private final void f(CommonCellSealOffMemory sealOffMemory) {
        RFWLog.d("QzoneFeedProMemorySealView", RFWLog.USR, "onSettingClick:" + sealOffMemory.getActionUrl());
        yo.d.c(sealOffMemory.getActionUrl(), getContext());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProMemorySealView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QzoneFeedProMemorySealView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void d(View view) {
        if (view != null) {
            fo.c.b("dt_clck", view, "em_qz_seal_line", null);
        }
    }

    private final void e(View view) {
        if (view != null) {
            fo.c.r(view, "em_qz_seal_line", null);
        }
    }

    public final void b(CommonFeed feedData) {
        final CommonCellSealOffMemory cellMemory = feedData != null ? feedData.getCellMemory() : null;
        if (cellMemory == null) {
            RFWLog.e("QzoneFeedProMemorySealView", RFWLog.USR, "bindData memory info is null");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        TextView textView = this.mMsgText;
        if (textView != null) {
            textView.setText(cellMemory.getSummary());
        }
        if (!TextUtils.isEmpty(cellMemory.getButtonText())) {
            TextView textView2 = this.mSettingText;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.mSettingText;
            if (textView3 != null) {
                textView3.setText(cellMemory.getButtonText());
            }
            TextView textView4 = this.mSettingText;
            if (textView4 != null) {
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.userhome.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QzoneFeedProMemorySealView.c(QzoneFeedProMemorySealView.this, cellMemory, view);
                    }
                });
            }
        } else {
            TextView textView5 = this.mSettingText;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        e(this.mSettingText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProMemorySealView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.f1301580, this);
        setVisibility(8);
        this.mMsgText = (TextView) findViewById(R.id.f162841mx2);
        TextView textView = (TextView) findViewById(R.id.f162843mx4);
        this.mSettingText = textView;
        if (textView != null) {
            aa.e(aa.f54263a, textView, 0.0f, 1, null);
        }
    }
}
