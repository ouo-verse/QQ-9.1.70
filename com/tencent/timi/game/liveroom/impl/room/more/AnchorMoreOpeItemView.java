package com.tencent.timi.game.liveroom.impl.room.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AnchorMoreOpeItemView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f378131d;

    public AnchorMoreOpeItemView(@NonNull Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i3) {
        View.inflate(context, R.layout.f169113ht3, this);
        this.f378131d = (ImageView) findViewById(R.id.soh);
        TextView textView = (TextView) findViewById(R.id.som);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mr2.a.f417323l);
            Drawable drawable = obtainStyledAttributes.getDrawable(mr2.a.f417331m);
            String string = obtainStyledAttributes.getString(mr2.a.f417339n);
            if (drawable != null) {
                this.f378131d.setImageDrawable(drawable);
                textView.setText(string);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setIconDrawable(@DrawableRes int i3) {
        this.f378131d.setImageDrawable(yn4.c.b(i3));
    }

    public AnchorMoreOpeItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public AnchorMoreOpeItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet, i3);
    }
}
