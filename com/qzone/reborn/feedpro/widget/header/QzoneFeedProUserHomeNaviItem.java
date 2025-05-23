package com.qzone.reborn.feedpro.widget.header;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviItem;", "Landroid/widget/FrameLayout;", "", "a", "", "strRes", "setName", "", "count", "", "textNumSize", "textSize", "setCount", "nameColor", "countColor", "setTextColor", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "mCountText", "e", "mNameText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProUserHomeNaviItem extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mCountText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mNameText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeNaviItem(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.f130428q, (ViewGroup) this, true);
        this.mCountText = (TextView) findViewById(R.id.mxl);
        this.mNameText = (TextView) findViewById(R.id.mxm);
        TextView textView = this.mCountText;
        if (textView != null) {
            com.qzone.reborn.feedpro.utils.aa.e(com.qzone.reborn.feedpro.utils.aa.f54263a, textView, 0.0f, 1, null);
        }
        TextView textView2 = this.mNameText;
        if (textView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.e(com.qzone.reborn.feedpro.utils.aa.f54263a, textView2, 0.0f, 1, null);
        }
    }

    public final void setCount(String count, float textNumSize, float textSize) {
        boolean endsWith$default;
        boolean endsWith$default2;
        Intrinsics.checkNotNullParameter(count, "count");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(count, "\u4e07", false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(count, "\u4ebf", false, 2, null);
            if (!endsWith$default2) {
                TextView textView = this.mCountText;
                if (textView != null) {
                    textView.setText(count);
                }
                TextView textView2 = this.mCountText;
                if (textView2 == null) {
                    return;
                }
                textView2.setTextSize(textNumSize);
                return;
            }
        }
        SpannableString spannableString = new SpannableString(count);
        spannableString.setSpan(new AbsoluteSizeSpan((int) ef.d.c(Float.valueOf(textNumSize))), 0, count.length() - 1, 33);
        spannableString.setSpan(new AbsoluteSizeSpan((int) ef.d.c(Float.valueOf(textSize))), count.length() - 1, count.length(), 33);
        TextView textView3 = this.mCountText;
        if (textView3 == null) {
            return;
        }
        textView3.setText(spannableString);
    }

    public final void setName(int strRes) {
        TextView textView = this.mNameText;
        if (textView == null) {
            return;
        }
        textView.setText(getContext().getResources().getText(strRes));
    }

    public final void setTextColor(int nameColor, int countColor) {
        TextView textView = this.mNameText;
        if (textView != null) {
            textView.setTextColor(nameColor);
        }
        TextView textView2 = this.mCountText;
        if (textView2 != null) {
            textView2.setTextColor(countColor);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeNaviItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeNaviItem(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QzoneFeedProUserHomeNaviItem(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeNaviItem(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }
}
