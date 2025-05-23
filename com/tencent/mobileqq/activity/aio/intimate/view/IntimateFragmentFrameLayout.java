package com.tencent.mobileqq.activity.aio.intimate.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IntimateFragmentFrameLayout extends FrameLayout {
    public IntimateFragmentFrameLayout(@NonNull Context context) {
        super(context);
    }

    private void a() {
        try {
            if (getClass().getSuperclass() != null) {
                Field declaredField = getClass().getSuperclass().getDeclaredField("mMatchParentChildren");
                declaredField.setAccessible(true);
                declaredField.set(this, null);
                QLog.d("IntimateFragmentFrameLayout", 1, "clearChildViewRef");
            }
        } catch (Exception e16) {
            QLog.e("IntimateFragmentFrameLayout", 1, e16, new Object[0]);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        a();
    }

    public IntimateFragmentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IntimateFragmentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
