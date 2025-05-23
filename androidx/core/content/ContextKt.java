package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b\u00a2\u0006\u0002\u0010\u0004\u001aQ\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\f2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f\u00a2\u0006\u0002\b\u0011H\u0086\b\u00f8\u0001\u0000\u001a;\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f\u00a2\u0006\u0002\b\u0011H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0013"}, d2 = {"getSystemService", "T", "", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context getSystemService) {
        Intrinsics.checkNotNullParameter(getSystemService, "$this$getSystemService");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) ContextCompat.getSystemService(getSystemService, Object.class);
    }

    public static final void withStyledAttributes(@NotNull Context withStyledAttributes, @Nullable AttributeSet attributeSet, @NotNull int[] attrs, @AttrRes int i3, @StyleRes int i16, @NotNull Function1<? super TypedArray, Unit> block) {
        Intrinsics.checkNotNullParameter(withStyledAttributes, "$this$withStyledAttributes");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i3, i16);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s\u2026efStyleAttr, defStyleRes)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context withStyledAttributes, AttributeSet attributeSet, int[] attrs, int i3, int i16, Function1 block, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            attributeSet = null;
        }
        if ((i17 & 4) != 0) {
            i3 = 0;
        }
        if ((i17 & 8) != 0) {
            i16 = 0;
        }
        Intrinsics.checkNotNullParameter(withStyledAttributes, "$this$withStyledAttributes");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i3, i16);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s\u2026efStyleAttr, defStyleRes)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@NotNull Context withStyledAttributes, @StyleRes int i3, @NotNull int[] attrs, @NotNull Function1<? super TypedArray, Unit> block) {
        Intrinsics.checkNotNullParameter(withStyledAttributes, "$this$withStyledAttributes");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(i3, attrs);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
