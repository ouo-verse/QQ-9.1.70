package com.tencent.mobileqq.zplan.card.impl.view.stagger.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l84.b;
import pv4.u;
import zf3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemRightBtmLabel;", "Landroid/widget/LinearLayout;", "Landroid/graphics/drawable/Drawable;", "b", "", "Lpv4/u;", "newData", "", "a", "dataList", "", "c", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "mData", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StaggerItemRightBtmLabel extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<u> mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaggerItemRightBtmLabel(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = new ArrayList<>();
    }

    private final boolean a(List<u> newData) {
        if (this.mData.size() != newData.size()) {
            return true;
        }
        int size = this.mData.size();
        for (int i3 = 0; i3 < size; i3++) {
            u uVar = this.mData.get(i3);
            Intrinsics.checkNotNullExpressionValue(uVar, "mData[i]");
            if (!o.g(uVar, newData.get(i3))) {
                return true;
            }
        }
        return false;
    }

    private final Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(d.f452428a.b() / 2);
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        return gradientDrawable;
    }

    public final void c(List<u> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        if (a(dataList)) {
            this.mData.clear();
            this.mData.addAll(dataList);
            removeAllViews();
            int i3 = 0;
            for (u uVar : dataList) {
                int i16 = i3 + 1;
                TextView textView = new TextView(getContext());
                textView.setBackground(b());
                textView.setGravity(17);
                textView.setPadding(i.b(7), i.b(1), i.b(7), i.b(1));
                textView.setTextSize(1, 9.0f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                b.a(textView, uVar, -1);
                textView.setIncludeFontPadding(false);
                if (i3 != 0) {
                    layoutParams.leftMargin = i.b(3);
                }
                addView(textView, layoutParams);
                i3 = i16;
            }
        }
    }
}
