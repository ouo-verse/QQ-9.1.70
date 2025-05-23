package com.tencent.icgame.game.liveroom.impl.room.bottombtn;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.icgame.game.utils.g;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;

/* loaded from: classes7.dex */
public class RedPointIconView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f115169d;

    /* renamed from: e, reason: collision with root package name */
    private View f115170e;

    /* renamed from: f, reason: collision with root package name */
    private int f115171f;

    public RedPointIconView(@NonNull Context context) {
        super(context);
        A0(context, null);
    }

    private void A0(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fau, this);
        this.f115169d = (ImageView) inflate.findViewById(R.id.f165861dq1);
        this.f115170e = inflate.findViewById(R.id.xxe);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d52.a.f392846e5);
        if (obtainStyledAttributes != null) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d52.a.f392855f5, 0);
            this.f115171f = dimensionPixelSize;
            this.f115169d.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            obtainStyledAttributes.recycle();
        }
    }

    public void B0(boolean z16, int i3, boolean z17) {
        int i16 = 8;
        if (z16) {
            this.f115169d.setImageResource(i3);
            View view = this.f115170e;
            if (z17) {
                i16 = 0;
            }
            view.setVisibility(i16);
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public void C0(boolean z16, String str, boolean z17) {
        int i3 = 8;
        if (z16) {
            URLDrawable uRLDrawable = null;
            try {
                uRLDrawable = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null);
            } catch (Exception unused) {
                g.b("RedPointIconView", 1, "updateView iconDrawable is invalid, iconUrl - " + str);
            }
            if (uRLDrawable != null) {
                this.f115169d.setImageDrawable(uRLDrawable);
                View view = this.f115170e;
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

    public void z0() {
        this.f115170e.setVisibility(8);
    }

    public RedPointIconView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A0(context, attributeSet);
    }

    public RedPointIconView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        A0(context, attributeSet);
    }
}
