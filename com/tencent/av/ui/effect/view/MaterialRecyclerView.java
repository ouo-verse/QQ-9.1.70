package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MaterialRecyclerView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    protected int f75587f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        private int f75588d;

        public a(int i3, int i16) {
            this.f75588d = i16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            rect.top = this.f75588d;
        }
    }

    public MaterialRecyclerView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public void C(Context context) {
        init(context);
    }

    protected void init(Context context) {
        int f16 = BaseAIOUtils.f(60.0f, context.getResources());
        int f17 = BaseAIOUtils.f(9.0f, context.getResources());
        this.f75587f = (context.getResources().getDisplayMetrics().widthPixels - f17) / (f16 + f17);
        setPadding(0, 0, 0, (int) context.getResources().getDimension(R.dimen.a47));
        setClipToPadding(false);
        setLayoutManager(new GridLayoutManager(getContext(), this.f75587f));
        if (getItemDecorationCount() > 0) {
            removeItemDecorationAt(0);
        }
        addItemDecoration(new a(this.f75587f, f17));
    }

    public MaterialRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MaterialRecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
