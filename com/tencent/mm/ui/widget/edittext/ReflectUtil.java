package com.tencent.mm.ui.widget.edittext;

import android.widget.TextView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mm/ui/widget/edittext/ReflectUtil;", "", "()V", "disableSysHandle", "", "textView", "Landroid/widget/TextView;", "setSysInsertionEnabled", NodeProps.ENABLED, "", "stopSelectionMode", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class ReflectUtil {

    @NotNull
    public static final ReflectUtil INSTANCE = new ReflectUtil();

    ReflectUtil() {
    }

    public final void disableSysHandle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        try {
            Field declaredField = TextView.class.getDeclaredField("mTextSelectHandleRes");
            declaredField.setAccessible(true);
            declaredField.set(textView, Integer.valueOf(R.drawable.lvi));
        } catch (Exception e16) {
            n.a(SelectableEditTextHelper.TAG, e16, "disableSysHandleErr", new Object[0]);
        }
    }

    public final void setSysInsertionEnabled(@NotNull TextView textView, boolean enabled) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        try {
            n.a(SelectableEditTextHelper.TAG, "setInsertionDisabled", new Object[0]);
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(textView);
            Class<?> cls = Class.forName("android.widget.Editor");
            Field declaredField2 = cls.getDeclaredField("mInsertionControllerEnabled");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, Boolean.valueOf(enabled));
            Field declaredField3 = cls.getDeclaredField("mSelectionControllerEnabled");
            declaredField3.setAccessible(true);
            declaredField3.set(obj, Boolean.valueOf(enabled));
        } catch (Exception e16) {
            n.b(SelectableEditTextHelper.TAG, "setInsertionDisabled error msg:%s", e16.getMessage());
        }
    }

    public final void stopSelectionMode(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        try {
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(textView);
            Method declaredMethod = Class.forName("android.widget.Editor").getDeclaredMethod("stopSelectionActionMode", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[0]);
        } catch (Throwable th5) {
            th5.printStackTrace();
            n.b(SelectableEditTextHelper.TAG, "stopSelectionMode err:%s", th5.getMessage());
        }
    }
}
