package com.tencent.mobileqq.guild.mainframe.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildDragTextView extends DragTextView {
    public rr1.a I;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a extends rr1.a {
        a() {
        }

        @Override // rr1.a
        public boolean b(MotionEvent motionEvent) {
            if (GuildDragTextView.this.getVisibility() != 0) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int[] iArr = new int[2];
            GuildDragTextView.this.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i16 = iArr[1];
            int measuredWidth = GuildDragTextView.this.getMeasuredWidth() + i3;
            int measuredHeight = GuildDragTextView.this.getMeasuredHeight() + i16;
            if (rawY < i16 || rawY > measuredHeight || rawX < i3 || rawX > measuredWidth) {
                return false;
            }
            return true;
        }
    }

    public GuildDragTextView(Context context) {
        super(context);
        this.I = new a();
        i();
    }

    private void i() {
        setDragGroup("guild");
    }

    public rr1.a g() {
        return this.I;
    }

    public void h() {
        setCompoundDrawables(null, null, null, null);
    }

    public void j(int i3, int i16) {
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), i3, null);
        if (drawable != null) {
            drawable.setBounds(0, 0, i16, i16);
            setCompoundDrawables(drawable, null, null, null);
            setCompoundDrawablePadding(ViewUtils.dpToPx(3.0f));
        }
    }

    public GuildDragTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = new a();
        i();
    }

    public GuildDragTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = new a();
        i();
    }
}
