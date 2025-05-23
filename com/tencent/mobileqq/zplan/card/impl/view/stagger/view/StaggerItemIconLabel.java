package com.tencent.mobileqq.zplan.card.impl.view.stagger.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.o;
import com.tencent.sqshow.zootopia.utils.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pv4.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J&\u0010\r\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000ej\b\u0012\u0004\u0012\u00020\u0003`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemIconLabel;", "Landroid/widget/LinearLayout;", "", "Lpv4/p;", "newData", "", "a", "data", "", "sizeInPix", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "mData", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "e", "Landroid/graphics/drawable/Drawable;", "mDefaultDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StaggerItemIconLabel extends LinearLayout {

    /* renamed from: d, reason: from kotlin metadata */
    private final ArrayList<p> mData;

    /* renamed from: e, reason: from kotlin metadata */
    private final Drawable mDefaultDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaggerItemIconLabel(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = new ArrayList<>();
        this.mDefaultDrawable = q.b(R.drawable.gym);
        setOrientation(0);
    }

    private final boolean a(List<p> newData) {
        if (this.mData.size() != newData.size()) {
            return true;
        }
        int size = this.mData.size();
        for (int i3 = 0; i3 < size; i3++) {
            p pVar = this.mData.get(i3);
            Intrinsics.checkNotNullExpressionValue(pVar, "mData[i]");
            if (o.f(pVar, newData.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public final void b(List<p> data, int sizeInPix, ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        if (a(data)) {
            this.mData.clear();
            this.mData.addAll(data);
            removeAllViews();
            for (p pVar : data) {
                URLImageView uRLImageView = new URLImageView(getContext());
                g gVar = pVar.f427651a;
                Drawable mDefaultDrawable = this.mDefaultDrawable;
                Intrinsics.checkNotNullExpressionValue(mDefaultDrawable, "mDefaultDrawable");
                CommonExKt.r(uRLImageView, gVar, mDefaultDrawable);
                uRLImageView.setScaleType(scaleType);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, sizeInPix);
                layoutParams.rightMargin = i.b(2);
                layoutParams.gravity = 16;
                addView(uRLImageView, layoutParams);
            }
        }
    }

    public static /* synthetic */ void c(StaggerItemIconLabel staggerItemIconLabel, List list, int i3, ImageView.ScaleType scaleType, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            scaleType = ImageView.ScaleType.FIT_START;
        }
        staggerItemIconLabel.b(list, i3, scaleType);
    }
}
