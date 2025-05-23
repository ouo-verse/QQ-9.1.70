package com.tencent.mobileqq.guild.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRedDotTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private int f235949d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f235950e;

    public GuildRedDotTextView(Context context) {
        this(context, null);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private void a() {
        this.f235950e = getResources().getDrawable(R.drawable.skin_tips_newmessage);
        int dpToPx = ViewUtils.dpToPx(9.0f);
        this.f235949d = dpToPx;
        this.f235950e.setBounds(0, 0, dpToPx, dpToPx);
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).setClipChildren(false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        super.onDraw(canvas);
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (QLog.isDebugVersion()) {
            for (Drawable drawable : compoundDrawables) {
                if (drawable != null) {
                    str = drawable.getBounds() + ", r:" + getRight() + ",b:" + getBottom();
                } else {
                    str = "";
                }
                Log.e("GuildRedDotTextView", str);
            }
        }
        canvas.translate(getRight() - (this.f235950e.getIntrinsicWidth() / 2), 0.0f);
        this.f235950e.draw(canvas);
    }

    public GuildRedDotTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildRedDotTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
