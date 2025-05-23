package kotlin;

import android.graphics.Outline;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001a\u0010\f\u001a\u00020\u0004*\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\"(\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"(\u0010\u0015\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f\"\u0015\u0010\u0019\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Landroid/view/View;", "", "width", "height", "", "g", "", "radius", "c", "Landroid/widget/TextView;", "weight", "style", "d", "value", "getMarginHorizontal", "(Landroid/view/View;)I", "e", "(Landroid/view/View;I)V", NodeProps.MARGIN_HORIZONTAL, "getMarginVertical", "f", NodeProps.MARGIN_VERTICAL, "a", NodeProps.PADDING_HORIZONTAL, "b", NodeProps.PADDING_VERTICAL, "qqguild-component_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"sg1/h$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f433790a;

        a(float f16) {
            this.f433790a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f433790a);
            view.getVisibility();
        }
    }

    public static final int a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingLeft() + view.getPaddingRight();
    }

    public static final int b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getPaddingTop() + view.getPaddingBottom();
    }

    public static final void c(@NotNull View view, float f16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setClipToOutline(true);
        view.setOutlineProvider(new a(f16));
    }

    public static final void d(@NotNull TextView textView, int i3, int i16) {
        Object m476constructorimpl;
        Typeface create;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Result.Companion companion = Result.INSTANCE;
                create = Typeface.create(null, i3, false);
                textView.setTypeface(create);
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                C11734b c11734b = C11734b.f433780a;
                QLog.e("Guild.component.TextViewEx", 1, "set fontWeight fail..", m479exceptionOrNullimpl);
                return;
            }
            return;
        }
        textView.setTypeface(null, i16);
    }

    public static final void e(@NotNull View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i16;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i17 = -2;
            if (layoutParams2 != null) {
                i16 = layoutParams2.width;
            } else {
                i16 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 != null) {
                i17 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
        }
        marginLayoutParams.leftMargin = i3;
        marginLayoutParams.rightMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }

    public static final void f(@NotNull View view, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i16;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            int i17 = -2;
            if (layoutParams2 != null) {
                i16 = layoutParams2.width;
            } else {
                i16 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 != null) {
                i17 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
        }
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.bottomMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }

    public static final void g(@NotNull View view, int i3, int i16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(i3, i16));
        } else {
            view.getLayoutParams().width = i3;
            view.getLayoutParams().height = i16;
        }
        view.setLayoutParams(view.getLayoutParams());
    }
}
