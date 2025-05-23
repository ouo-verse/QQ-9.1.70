package com.tencent.mobileqq.quibadge;

import android.graphics.drawable.Drawable;
import androidx.annotation.UiThread;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/quibadge/a;", "", "", "textColor", "Landroid/graphics/drawable/Drawable;", "background", "", "updateCustomStyle", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)V", "QUIBadge_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.quibadge.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8448a {
        public static /* synthetic */ void a(a aVar, Integer num, Drawable drawable, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    num = null;
                }
                if ((i3 & 2) != 0) {
                    drawable = null;
                }
                aVar.updateCustomStyle(num, drawable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCustomStyle");
        }
    }

    @UiThread
    void updateCustomStyle(@Nullable Integer textColor, @Nullable Drawable background);
}
