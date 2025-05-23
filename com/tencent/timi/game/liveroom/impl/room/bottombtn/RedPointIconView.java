package com.tencent.timi.game.liveroom.impl.room.bottombtn;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.utils.l;
import mr2.a;

/* loaded from: classes26.dex */
public class RedPointIconView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f377534d;

    /* renamed from: e, reason: collision with root package name */
    private View f377535e;

    /* renamed from: f, reason: collision with root package name */
    private int f377536f;

    public RedPointIconView(@NonNull Context context) {
        super(context);
        z0(context, null);
    }

    private void z0(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hmw, this);
        this.f377534d = (ImageView) inflate.findViewById(R.id.f165861dq1);
        this.f377535e = inflate.findViewById(R.id.xxe);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f417260d5);
        if (obtainStyledAttributes != null) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(a.f417269e5, 0);
            this.f377536f = dimensionPixelSize;
            this.f377534d.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            obtainStyledAttributes.recycle();
        }
    }

    public void A0(boolean z16, int i3, boolean z17) {
        int i16 = 8;
        if (z16) {
            this.f377534d.setImageResource(i3);
            View view = this.f377535e;
            if (z17) {
                i16 = 0;
            }
            view.setVisibility(i16);
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public void B0(boolean z16, String str, boolean z17) {
        int i3 = 8;
        if (z16) {
            URLDrawable uRLDrawable = null;
            try {
                uRLDrawable = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null);
            } catch (Exception unused) {
                l.c("RedPointIconView", 1, "updateView iconDrawable is invalid, iconUrl - " + str);
            }
            if (uRLDrawable != null) {
                this.f377534d.setImageDrawable(uRLDrawable);
                View view = this.f377535e;
                if (z17) {
                    i3 = 0;
                }
                view.setVisibility(i3);
                setVisibility(0);
                return;
            }
            setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public RedPointIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        z0(context, attributeSet);
    }

    public RedPointIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        z0(context, attributeSet);
    }
}
