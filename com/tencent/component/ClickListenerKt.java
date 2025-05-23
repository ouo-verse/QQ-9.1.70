package com.tencent.component;

import android.view.View;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"clickItems", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "Lcom/tencent/component/ClickItem;", "canClick", "", "view", "isInvalidClick", "minIntervalTime", "", "isValidClick", "setCanClick", "", "qq-live-od-adapter-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class ClickListenerKt {

    @NotNull
    private static final WeakHashMap<View, ClickItem> clickItems = new WeakHashMap<>();

    public static final boolean canClick(@Nullable View view) {
        ClickItem clickItem;
        if (view == null || (clickItem = clickItems.get(view)) == null) {
            return false;
        }
        return clickItem.getCanClick();
    }

    @JvmOverloads
    public static final boolean isInvalidClick(@Nullable View view) {
        return isInvalidClick$default(view, 0L, 2, null);
    }

    public static /* synthetic */ boolean isInvalidClick$default(View view, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 1000;
        }
        return isInvalidClick(view, j3);
    }

    @JvmOverloads
    public static final boolean isValidClick(@Nullable View view) {
        return isValidClick$default(view, 0L, 2, null);
    }

    public static /* synthetic */ boolean isValidClick$default(View view, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 1000;
        }
        return isValidClick(view, j3);
    }

    public static final void setCanClick(@Nullable View view, boolean z16) {
        if (view == null) {
            return;
        }
        ClickItem clickItem = clickItems.get(view);
        if (clickItem == null) {
            clickItem = new ClickItem(0L);
        }
        clickItem.setCanClick(z16);
    }

    @JvmOverloads
    public static final boolean isInvalidClick(@Nullable View view, long j3) {
        return !isValidClick(view, j3);
    }

    @JvmOverloads
    public static final boolean isValidClick(@Nullable View view, long j3) {
        if (view == null) {
            return false;
        }
        WeakHashMap<View, ClickItem> weakHashMap = clickItems;
        ClickItem clickItem = weakHashMap.get(view);
        if (clickItem == null) {
            weakHashMap.put(view, new ClickItem(0L, 1, null));
            return true;
        }
        if (!clickItem.getCanClick()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - clickItem.getLastClickTime() <= j3) {
            return false;
        }
        clickItem.setLastClickTime(currentTimeMillis);
        return true;
    }
}
