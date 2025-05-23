package com.tencent.sqshow.zootopia.nativeui.view.detail.base;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m84.b;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/base/GoodsTagView;", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout$LayoutParams;", "params", "", "tagTxt", "", "a", "Luv4/az;", "itemData", "b", "", CustomImageProps.QUALITY, "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/base/GoodsTagView$a;", "e", "c", "Lcom/tencent/sqshow/zootopia/view/ZplanExcludeFontPaddingTextView;", "d", "f", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GoodsTagView extends LinearLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsTagView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setOrientation(0);
    }

    private final void a(LinearLayout.LayoutParams params, String tagTxt) {
        ZplanExcludeFontPaddingTextView d16 = d();
        addView(d16, params);
        d16.setText(tagTxt);
        d16.setBackgroundResource(R.drawable.h4t);
    }

    private final void b(az itemData, LinearLayout.LayoutParams params) {
        QualityRes e16 = e(itemData.f440281h);
        if (e16 != null) {
            ZplanExcludeFontPaddingTextView d16 = d();
            Drawable drawable = getContext().getResources().getDrawable(e16.getIconRes());
            drawable.setBounds(new Rect(0, 0, i.a(12.5f), i.b(12)));
            d16.setCompoundDrawables(drawable, null, null, null);
            d16.setText(e16.getTxt());
            d16.setTextColor(getContext().getResources().getColor(e16.getTxtColor()));
            d16.setBackgroundResource(e16.getBgRes());
            d16.setCompoundDrawablePadding(i.b(i.a(2.0f)));
            addView(d16, params);
        }
    }

    private final LinearLayout.LayoutParams c() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = i.b(8);
        return layoutParams;
    }

    private final ZplanExcludeFontPaddingTextView d() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = new ZplanExcludeFontPaddingTextView(context);
        zplanExcludeFontPaddingTextView.setGravity(17);
        zplanExcludeFontPaddingTextView.setTextSize(12.0f);
        b.g(zplanExcludeFontPaddingTextView, "#999999");
        return zplanExcludeFontPaddingTextView;
    }

    public final void f(az itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        removeAllViews();
        String[] strArr = itemData.f440284k;
        boolean z16 = true;
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                z16 = false;
            }
        }
        if (z16 && itemData.f440281h == 0) {
            setVisibility(8);
        }
        LinearLayout.LayoutParams c16 = c();
        b(itemData, c16);
        String[] strArr2 = itemData.f440284k;
        if (strArr2 != null) {
            for (String str : strArr2) {
                a(c16, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/base/GoodsTagView$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "iconRes", "bgRes", "c", "d", "txtColor", "Ljava/lang/String;", "()Ljava/lang/String;", FileReaderHelper.TXT_EXT, "<init>", "(IIILjava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.nativeui.view.detail.base.GoodsTagView$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class QualityRes {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int iconRes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bgRes;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int txtColor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String txt;

        public QualityRes(int i3, int i16, int i17, String txt) {
            Intrinsics.checkNotNullParameter(txt, "txt");
            this.iconRes = i3;
            this.bgRes = i16;
            this.txtColor = i17;
            this.txt = txt;
        }

        /* renamed from: a, reason: from getter */
        public final int getBgRes() {
            return this.bgRes;
        }

        /* renamed from: b, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* renamed from: c, reason: from getter */
        public final String getTxt() {
            return this.txt;
        }

        /* renamed from: d, reason: from getter */
        public final int getTxtColor() {
            return this.txtColor;
        }

        public int hashCode() {
            return (((((this.iconRes * 31) + this.bgRes) * 31) + this.txtColor) * 31) + this.txt.hashCode();
        }

        public String toString() {
            return "QualityRes(iconRes=" + this.iconRes + ", bgRes=" + this.bgRes + ", txtColor=" + this.txtColor + ", txt=" + this.txt + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QualityRes)) {
                return false;
            }
            QualityRes qualityRes = (QualityRes) other;
            return this.iconRes == qualityRes.iconRes && this.bgRes == qualityRes.bgRes && this.txtColor == qualityRes.txtColor && Intrinsics.areEqual(this.txt, qualityRes.txt);
        }
    }

    private final QualityRes e(int quality) {
        if (quality == 0) {
            return new QualityRes(R.drawable.ieq, R.drawable.h4t, R.color.f8777v, "\u6d41\u884c");
        }
        if (quality == 1) {
            return new QualityRes(R.drawable.ieo, R.drawable.h4r, R.color.f8767u, "\u7ecf\u5178");
        }
        if (quality == 2) {
            return new QualityRes(R.drawable.ien, R.drawable.h4q, R.color.f8757t, "\u4f73\u4f5c");
        }
        if (quality != 3) {
            return null;
        }
        return new QualityRes(R.drawable.iep, R.drawable.h4y, R.color.f8787w, "\u9650\u5b9a");
    }
}
