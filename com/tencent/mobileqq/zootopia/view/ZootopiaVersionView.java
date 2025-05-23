package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.sqshow.zootopia.data.ZootopiaVersionData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u001c\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u0005\u001a\u00020\u0004J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014R\u0016\u0010\u0017\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaVersionView;", "Landroid/widget/FrameLayout;", "", "e", "", "uploadLoadTime", "", "isTop", "c", "Lcom/tencent/sqshow/zootopia/data/aa;", "data", "", "index", "b", "d", "g", "", "dataList", tl.h.F, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Z", "needForceUpdateHeight", "I", "versionViewDefaultFoldHeight", "Lfi3/aj;", "f", "Lfi3/aj;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaVersionView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needForceUpdateHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int versionViewDefaultFoldHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final fi3.aj binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaVersionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(ZootopiaVersionData data, int index) {
        if (index == 0) {
            LinearLayout linearLayout = this.binding.f398823b;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ZootopiaVersionItemView zootopiaVersionItemView = new ZootopiaVersionItemView(context, data, null, 0, 12, null);
            zootopiaVersionItemView.setLocation(1);
            linearLayout.addView(zootopiaVersionItemView);
            return;
        }
        LinearLayout linearLayout2 = this.binding.f398823b;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        linearLayout2.addView(new ZootopiaVersionItemView(context2, data, null, 0, 12, null));
    }

    private final void d() {
        this.binding.f398826e.setVisibility(8);
        this.binding.f398824c.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    private final void e() {
        this.binding.f398825d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaVersionView.f(ZootopiaVersionView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ZootopiaVersionView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d();
    }

    private final void g() {
        if (!this.needForceUpdateHeight || getMeasuredHeight() == 0) {
            return;
        }
        this.needForceUpdateHeight = false;
        if (getMeasuredHeight() >= this.versionViewDefaultFoldHeight) {
            this.binding.f398824c.setLayoutParams(new FrameLayout.LayoutParams(-1, this.versionViewDefaultFoldHeight));
            this.binding.f398826e.setVisibility(0);
        } else {
            d();
        }
    }

    public final void h(List<ZootopiaVersionData> dataList, long uploadLoadTime) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.binding.f398823b.removeAllViews();
        if (!dataList.isEmpty()) {
            int i3 = 0;
            for (Object obj : dataList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                b((ZootopiaVersionData) obj, i3);
                i3 = i16;
            }
        }
        if (uploadLoadTime != 0) {
            c(uploadLoadTime, dataList.isEmpty());
        }
        this.needForceUpdateHeight = true;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaVersionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaVersionView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void c(long uploadLoadTime, boolean isTop) {
        LinearLayout linearLayout = this.binding.f398823b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ZootopiaVersionItemView zootopiaVersionItemView = new ZootopiaVersionItemView(context, null, null, 0, 14, null);
        zootopiaVersionItemView.setData(new ZootopiaVersionData(uploadLoadTime, null, 2, null), isTop ? -1 : 3);
        linearLayout.addView(zootopiaVersionItemView);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaVersionView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.needForceUpdateHeight = true;
        this.versionViewDefaultFoldHeight = com.tencent.sqshow.zootopia.utils.i.a(164.0f);
        fi3.aj g16 = fi3.aj.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        setBackgroundResource(R.drawable.h1c);
        e();
    }
}
