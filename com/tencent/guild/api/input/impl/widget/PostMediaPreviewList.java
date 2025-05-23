package com.tencent.guild.api.input.impl.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.utils.ViewUtils;

/* loaded from: classes6.dex */
public class PostMediaPreviewList extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    public static final int f112576f = ViewUtils.dpToPx(4.0f);

    /* loaded from: classes6.dex */
    static class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private final int f112577d;

        /* renamed from: e, reason: collision with root package name */
        private final int f112578e;

        /* renamed from: f, reason: collision with root package name */
        private final int f112579f;

        public a(int i3, int i16, int i17) {
            this.f112577d = i3;
            this.f112579f = i17;
            this.f112578e = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.top = this.f112578e;
            rect.bottom = this.f112579f;
            rect.right = this.f112577d * 2;
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f112577d * 2;
            } else {
                rect.left = 0;
            }
        }
    }

    public PostMediaPreviewList(Context context) {
        super(context);
        addItemDecoration(new a(f112576f, ViewUtils.dip2px(9.0f), ViewUtils.dip2px(7.0f)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        super.dispatchTouchEvent(motionEvent);
        return true;
    }
}
