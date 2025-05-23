package com.tencent.sqshow.zootopia.nativeui.view.customerface;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.utils.aa;
import g94.FaceResetInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.x;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/customerface/MakeFaceTabView;", "Landroid/widget/FrameLayout;", "", "g", "Landroid/view/View;", "bgView", "Landroid/widget/TextView;", "tv", "", "isChecked", DomainData.DOMAIN_NAME, "isSide", "l", "j", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "e", "f", "Ln74/x;", "d", "Ln74/x;", "binding", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Landroidx/lifecycle/Observer;", "Lg94/d;", "Landroidx/lifecycle/Observer;", "resetObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MakeFaceTabView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final x binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Observer<FaceResetInfo> resetObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MakeFaceTabView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MakeFaceTabView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        TextView textView = this$0.binding.f419465d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.side1Tv");
        this$0.n(it, textView, true);
        LinearLayout linearLayout = this$0.binding.f419466e;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.side2");
        TextView textView2 = this$0.binding.f419467f;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.side2Tv");
        this$0.n(linearLayout, textView2, false);
        g94.e.f401573a.e(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MakeFaceTabView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.binding.f419464c;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.side1");
        TextView textView = this$0.binding.f419465d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.side1Tv");
        this$0.n(linearLayout, textView, false);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        TextView textView2 = this$0.binding.f419467f;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.side2Tv");
        this$0.n(it, textView2, true);
        g94.e.f401573a.e(true);
    }

    private final void j() {
        LifecycleOwner lifecycleOwner;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (lifecycleOwner = jVar.getLifecycleOwner()) == null) {
            return;
        }
        g94.e.f401573a.a().observe(lifecycleOwner, this.resetObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MakeFaceTabView this$0, FaceResetInfo faceResetInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(faceResetInfo.getIsSide());
    }

    private final void l(final boolean isSide) {
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.b
            @Override // java.lang.Runnable
            public final void run() {
                MakeFaceTabView.m(isSide, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(boolean z16, MakeFaceTabView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            LinearLayout linearLayout = this$0.binding.f419464c;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.side1");
            TextView textView = this$0.binding.f419465d;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.side1Tv");
            this$0.n(linearLayout, textView, true);
            LinearLayout linearLayout2 = this$0.binding.f419466e;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.side2");
            TextView textView2 = this$0.binding.f419467f;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.side2Tv");
            this$0.n(linearLayout2, textView2, false);
            return;
        }
        LinearLayout linearLayout3 = this$0.binding.f419464c;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.side1");
        TextView textView3 = this$0.binding.f419465d;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.side1Tv");
        this$0.n(linearLayout3, textView3, false);
        LinearLayout linearLayout4 = this$0.binding.f419466e;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.side2");
        TextView textView4 = this$0.binding.f419467f;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.side2Tv");
        this$0.n(linearLayout4, textView4, true);
    }

    public final void e(com.tencent.sqshow.zootopia.nativeui.data.j mChannel) {
        this.mChannel = mChannel;
        j();
    }

    public final void f() {
        g94.e.f401573a.a().removeObserver(this.resetObserver);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MakeFaceTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void g() {
        l(false);
        LinearLayout linearLayout = this.binding.f419464c;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.side1");
        aa.d(linearLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MakeFaceTabView.h(MakeFaceTabView.this, view);
            }
        });
        LinearLayout linearLayout2 = this.binding.f419466e;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.side2");
        aa.d(linearLayout2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MakeFaceTabView.i(MakeFaceTabView.this, view);
            }
        });
        g94.e.f401573a.e(false);
    }

    public /* synthetic */ MakeFaceTabView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MakeFaceTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        x f16 = x.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.resetObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.customerface.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MakeFaceTabView.k(MakeFaceTabView.this, (FaceResetInfo) obj);
            }
        };
        g();
    }

    private final void n(View bgView, TextView tv5, boolean isChecked) {
        if (isChecked) {
            bgView.setBackgroundResource(R.drawable.f159870h45);
            tv5.setTextColor(getContext().getResources().getColor(R.color.black));
        } else {
            bgView.setBackground(null);
            tv5.setTextColor(getContext().getResources().getColor(R.color.f8326n));
        }
    }
}
