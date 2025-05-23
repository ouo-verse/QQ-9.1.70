package com.tencent.mobileqq.guild.channel.manage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends m {
    protected Paint G;

    public c(Context context, int i3, int i16, int i17) {
        super(context, i3, i16, i17);
        Paint paint = new Paint(1);
        this.G = paint;
        paint.setColor(context.getResources().getColor(R.color.qui_common_fill_light_secondary));
        this.G.setStyle(Paint.Style.FILL);
    }

    private int a(RecyclerView recyclerView) {
        return recyclerView.getChildCount();
    }

    private int d(RecyclerView recyclerView, int i3) {
        if (i3 >= recyclerView.getAdapter().getItemCount()) {
            return -1;
        }
        return recyclerView.getAdapter().getItemViewType(i3);
    }

    @Override // com.tencent.mobileqq.guild.channel.manage.m, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft() + this.f215120i;
        int measuredWidth = (recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight()) - this.f215121m;
        int a16 = a(recyclerView);
        int i3 = 0;
        while (i3 < a16 - 1) {
            int d16 = d(recyclerView, i3);
            int i16 = i3 + 1;
            int d17 = d(recyclerView, i16);
            if (d16 == 0 && d17 == 0) {
                View childAt = recyclerView.getChildAt(i3);
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                int i17 = this.f215118f + bottom;
                Drawable drawable = this.f215117e;
                if (drawable != null) {
                    drawable.setBounds(paddingLeft, bottom, measuredWidth, i17);
                    this.f215117e.draw(canvas);
                }
                Paint paint = this.f215116d;
                if (paint != null) {
                    canvas.drawRect(paddingLeft, bottom, measuredWidth, i17, paint);
                }
                if (this.G != null) {
                    float f16 = bottom;
                    float f17 = i17;
                    canvas.drawRect(recyclerView.getPaddingLeft(), f16, paddingLeft, f17, this.G);
                    canvas.drawRect(measuredWidth, f16, this.f215121m + measuredWidth, f17, this.G);
                }
            }
            i3 = i16;
        }
    }
}
