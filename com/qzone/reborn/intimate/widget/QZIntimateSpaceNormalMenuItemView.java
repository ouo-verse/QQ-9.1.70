package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.utils.ViewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZIntimateSpaceNormalMenuItemView;", "Lcom/qzone/reborn/intimate/widget/QZIntimateSpaceBaseMenuItemView;", "Lij/e;", "bean", "", "A0", "z0", "", "colorArray", "Landroid/graphics/drawable/GradientDrawable;", "y0", "", "getLayoutId", "Landroid/view/View;", "p0", com.tencent.luggage.wxa.c8.c.G, "n0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateSpaceNormalMenuItemView extends QZIntimateSpaceBaseMenuItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateSpaceNormalMenuItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setName((TextView) findViewById(R.id.mhi));
        setState((TextView) findViewById(R.id.mhj));
        setIcon((ImageView) findViewById(R.id.mhg));
        setIconBg(findViewById(R.id.mhh));
        setItemBg(findViewById(R.id.mhf));
    }

    private final GradientDrawable y0(int[] colorArray, ij.e bean) {
        int parseColor;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colorArray);
        try {
            int a16 = ViewUtils.f352270a.a(0.3f);
            if (com.qzone.reborn.util.k.f59549a.f()) {
                parseColor = Color.parseColor(bean.getStrokeColorNight());
            } else {
                parseColor = Color.parseColor(bean.getStrokeColorDay());
            }
            gradientDrawable.setStroke(a16, parseColor);
        } catch (Exception e16) {
            com.tencent.qqcamerakit.common.e.d("QZIntimateSpaceNormalMenuItemView", 1, "exception is " + e16);
        }
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ef.d.b(8));
        return gradientDrawable;
    }

    private final void z0(ij.e bean) {
        List<String> a16;
        int[] intArray;
        Integer num;
        if (com.qzone.reborn.util.k.f59549a.f()) {
            a16 = bean.b();
        } else {
            a16 = bean.a();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a16.iterator();
        while (it.hasNext()) {
            try {
                num = Integer.valueOf(Color.parseColor((String) it.next()));
            } catch (IllegalArgumentException unused) {
                num = null;
            }
            if (num != null) {
                arrayList.add(num);
            }
        }
        intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
        if (intArray.length == 0) {
            com.tencent.qqcamerakit.common.e.d("QZIntimateSpaceNormalMenuItemView", 1, "color int array is empty");
            return;
        }
        View itemBg = getItemBg();
        if (itemBg == null) {
            return;
        }
        itemBg.setBackground(y0(intArray, bean));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cl5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.intimate.widget.QZIntimateSpaceBaseMenuItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(ij.e bean, int pos) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        super.bindData(bean, pos);
        z0(bean);
        A0(bean);
    }

    @Override // com.qzone.reborn.intimate.widget.QZIntimateSpaceBaseMenuItemView
    protected View p0() {
        return getItemBg();
    }

    private final void A0(ij.e bean) {
        int parseColor;
        try {
            if (com.qzone.reborn.util.k.f59549a.f()) {
                parseColor = Color.parseColor(bean.getIconBgNight());
            } else {
                parseColor = Color.parseColor(bean.getIconBgDay());
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(parseColor);
            View iconBg = getIconBg();
            if (iconBg == null) {
                return;
            }
            iconBg.setBackground(gradientDrawable);
        } catch (Exception e16) {
            com.tencent.qqcamerakit.common.e.d("QZIntimateSpaceNormalMenuItemView", 1, "exception is " + e16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateSpaceNormalMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setName((TextView) findViewById(R.id.mhi));
        setState((TextView) findViewById(R.id.mhj));
        setIcon((ImageView) findViewById(R.id.mhg));
        setIconBg(findViewById(R.id.mhh));
        setItemBg(findViewById(R.id.mhf));
    }
}
