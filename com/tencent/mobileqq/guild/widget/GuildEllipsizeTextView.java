package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.text.DynamicLayout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildEllipsizeTextView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name */
    private StaticLayout f235849h;

    /* renamed from: i, reason: collision with root package name */
    private Field f235850i;

    public GuildEllipsizeTextView(Context context) {
        super(context);
        this.f235849h = null;
        this.f235850i = null;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i16) {
        Field field;
        if (QLog.isDebugVersion()) {
            QLog.d("EllipsizeTextView", 4, "onMeasure step1");
        }
        try {
            Field declaredField = DynamicLayout.class.getDeclaredField("sStaticLayout");
            declaredField.setAccessible(true);
            this.f235849h = (StaticLayout) declaredField.get(DynamicLayout.class);
        } catch (IllegalAccessException | NoSuchFieldException e16) {
            QLog.w("EllipsizeTextView", 1, "onMeasure getDeclaredField('sStaticLayout') error! ", e16);
        }
        if (this.f235849h != null) {
            try {
                Field declaredField2 = StaticLayout.class.getDeclaredField("mMaximumVisibleLineCount");
                this.f235850i = declaredField2;
                declaredField2.setAccessible(true);
                this.f235850i.setInt(this.f235849h, getMaxLines());
            } catch (IllegalAccessException | NoSuchFieldException e17) {
                QLog.w("EllipsizeTextView", 1, "onMeasure getDeclaredField('mMaximumVisibleLineCount') error! ", e17);
            }
        }
        super.onMeasure(i3, i16);
        if (QLog.isDebugVersion()) {
            QLog.d("EllipsizeTextView", 4, "onMeasure step2");
        }
        StaticLayout staticLayout = this.f235849h;
        if (staticLayout != null && (field = this.f235850i) != null) {
            try {
                field.setInt(staticLayout, Integer.MAX_VALUE);
            } catch (IllegalAccessException e18) {
                QLog.w("EllipsizeTextView", 1, "onMeasure mFieldMaximumVisibleLineCount.setInt error! ", e18);
            }
        }
    }

    public GuildEllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f235849h = null;
        this.f235850i = null;
    }

    public GuildEllipsizeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f235849h = null;
        this.f235850i = null;
    }
}
