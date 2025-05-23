package com.tencent.robot.adelie.homepage.create.sound;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/sound/AdelieTtsPageBkgView;", "Landroid/widget/RelativeLayout;", "", "f", "", "", "c", "d", "e", "Landroid/view/View;", "a", "b", "g", h.F, "Landroid/view/View;", "contentView", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLightView", "backgroundView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieTtsPageBkgView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIPolarLightView polarLightView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View backgroundView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieTtsPageBkgView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final List<Integer> c() {
        if (je0.a.a(BaseApplication.getContext())) {
            return e();
        }
        return d();
    }

    private final List<Integer> d() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#7CB8FF")), Integer.valueOf(Color.parseColor("#68D2FC")), Integer.valueOf(Color.parseColor("#CC99FF")), Integer.valueOf(Color.parseColor("#51A1FF")), Integer.valueOf(Color.parseColor("#51A1FF")), Integer.valueOf(Color.parseColor("#7CB8FF")), Integer.valueOf(Color.parseColor("#D7E6FE"))});
        return listOf;
    }

    private final List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#0075FF")), Integer.valueOf(Color.parseColor("#0075FF")), Integer.valueOf(Color.parseColor("#951CDE")), Integer.valueOf(Color.parseColor("#12A6C6")), Integer.valueOf(Color.parseColor("#6100FF")), Integer.valueOf(Color.parseColor("#0075FF")), Integer.valueOf(Color.parseColor("#951CDE"))});
        return listOf;
    }

    private final void f() {
        QUIPolarLightView qUIPolarLightView;
        View view;
        PolarImageRender polarImageRender;
        PolarImageRender polarImageRender2;
        PolarImageRender polarImageRender3;
        View view2 = this.contentView;
        PolarImageRender polarImageRender4 = null;
        if (view2 != null) {
            qUIPolarLightView = (QUIPolarLightView) view2.findViewById(R.id.f26260d2);
        } else {
            qUIPolarLightView = null;
        }
        this.polarLightView = qUIPolarLightView;
        View view3 = this.contentView;
        if (view3 != null) {
            view = view3.findViewById(R.id.vry);
        } else {
            view = null;
        }
        this.backgroundView = view;
        QUIPolarLightView qUIPolarLightView2 = this.polarLightView;
        if (qUIPolarLightView2 != null) {
            polarImageRender = qUIPolarLightView2.getPolarLightRender();
        } else {
            polarImageRender = null;
        }
        if (polarImageRender != null) {
            polarImageRender.s(c());
        }
        QUIPolarLightView qUIPolarLightView3 = this.polarLightView;
        if (qUIPolarLightView3 != null) {
            polarImageRender2 = qUIPolarLightView3.getPolarLightRender();
        } else {
            polarImageRender2 = null;
        }
        if (polarImageRender2 != null) {
            polarImageRender2.p(0.025f);
        }
        QUIPolarLightView qUIPolarLightView4 = this.polarLightView;
        if (qUIPolarLightView4 != null) {
            polarImageRender3 = qUIPolarLightView4.getPolarLightRender();
        } else {
            polarImageRender3 = null;
        }
        if (polarImageRender3 != null) {
            polarImageRender3.r(0.5f);
        }
        QUIPolarLightView qUIPolarLightView5 = this.polarLightView;
        if (qUIPolarLightView5 != null) {
            polarImageRender4 = qUIPolarLightView5.getPolarLightRender();
        }
        if (polarImageRender4 != null) {
            polarImageRender4.q(new a.b(0.7f, 0.5f, 0.3f, 0.5f, 0.0f));
        }
        QUIPolarLightView qUIPolarLightView6 = this.polarLightView;
        if (qUIPolarLightView6 != null) {
            qUIPolarLightView6.m();
        }
        if (je0.a.a(BaseApplication.getContext())) {
            View view4 = this.backgroundView;
            if (view4 != null) {
                view4.setBackgroundColor(Color.parseColor("#14181F"));
                return;
            }
            return;
        }
        View view5 = this.backgroundView;
        if (view5 != null) {
            view5.setBackgroundColor(Color.parseColor("#CFEAFF"));
        }
    }

    @Nullable
    public final View a() {
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        this.contentView = LayoutInflater.from(getContext()).inflate(R.layout.dsy, this);
        f();
        return this.contentView;
    }

    public final void b() {
        h();
    }

    public final void g() {
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.m();
        }
    }

    public final void h() {
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.stopAnimation();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieTtsPageBkgView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieTtsPageBkgView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieTtsPageBkgView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
