package com.tencent.mobileqq.wink.editor.sticker.sticker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import androidx.core.content.ContextCompat;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.wink.editor.sticker.m;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private final List<MetaMaterial> f321774d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f321775e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint.FontMetrics f321776f;

    /* renamed from: h, reason: collision with root package name */
    private int f321777h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f321778i;

    public c(Context context, List<MetaMaterial> list) {
        this.f321774d = list;
        this.f321775e = x.c(context, 45.0f);
        Paint paint = new Paint(1);
        this.f321778i = paint;
        paint.setColor(ContextCompat.getColor(context, R.color.bfo));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(x.c(context, 12.0f));
        this.f321776f = paint.getFontMetrics();
    }

    private int a(RecyclerView recyclerView, int i3) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        return -1;
    }

    private boolean b(int i3) {
        MetaMaterial metaMaterial;
        List<MetaMaterial> list = this.f321774d;
        if (list != null && i3 >= 0 && i3 < list.size() && (metaMaterial = this.f321774d.get(i3)) != null) {
            return m.P(metaMaterial);
        }
        return false;
    }

    public String c(RecyclerView recyclerView, int i3) {
        boolean z16;
        int a16 = a(recyclerView, i3);
        if (b(i3) && i3 % a16 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return com.tencent.mobileqq.wink.editor.c.p(this.f321774d.get(i3));
        }
        return null;
    }

    public void d(int i3) {
        this.f321777h = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (b(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition())) {
            rect.set(0, this.f321775e, 0, 0);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            String c16 = c(recyclerView, recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i3)));
            if (c16 != null) {
                canvas.drawText(c16, r1.getLeft() + this.f321777h, (int) (r1.getTop() - (((this.f321775e - (Math.abs(this.f321776f.ascent) + Math.abs(this.f321776f.descent))) / 2.0f) + Math.abs(this.f321776f.descent))), this.f321778i);
            }
        }
    }
}
