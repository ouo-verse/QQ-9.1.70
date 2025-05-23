package ok;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.layer.adapter.ViewPager2Container;
import com.tencent.mobileqq.auto.engine.main.IASFragment;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name */
    private IASFragment f423032m;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f423032m != null ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        ViewPager2Container viewPager2Container = new ViewPager2Container(viewGroup.getContext());
        IASFragment iASFragment = this.f423032m;
        if (iASFragment != null && iASFragment.getTargetDecorView() != null) {
            View targetDecorView = this.f423032m.getTargetDecorView();
            targetDecorView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (targetDecorView.getParent() instanceof ViewGroup) {
                ((ViewGroup) targetDecorView.getParent()).removeView(targetDecorView);
            }
            viewPager2Container.addView(targetDecorView);
        }
        viewPager2Container.a(false);
        viewPager2Container.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new a(viewPager2Container);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(a aVar) {
        super.onViewAttachedToWindow(aVar);
        this.f423032m.setIsSelected(true);
        this.f423032m.onResume();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(a aVar) {
        super.onViewDetachedFromWindow(aVar);
        this.f423032m.onPause();
    }

    public void m0(IASFragment iASFragment) {
        this.f423032m = iASFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
    }
}
