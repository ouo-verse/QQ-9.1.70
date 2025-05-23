package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/i;", "", "Landroid/util/Property;", "Landroid/view/View;", "Landroid/graphics/Rect;", "b", "Landroid/util/Property;", "a", "()Landroid/util/Property;", "clipBoundsProperty", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f319307a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Property<View, Rect> clipBoundsProperty = new a(Rect.class);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/reorder/i$a", "Landroid/util/Property;", "Landroid/view/View;", "Landroid/graphics/Rect;", "view", "a", "value", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends Property<View, Rect> {
        a(Class<Rect> cls) {
            super(cls, "clipBounds");
        }

        @Override // android.util.Property
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getClipBounds();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NotNull View view, @NotNull Rect value) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(value, "value");
            view.setClipBounds(value);
        }
    }

    i() {
    }

    @NotNull
    public final Property<View, Rect> a() {
        return clipBoundsProperty;
    }
}
