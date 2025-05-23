package d93;

import android.animation.ObjectAnimator;
import android.support.annotation.FloatRange;
import android.util.Log;
import android.util.Property;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    private a f393240a;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView.ViewHolder f393243d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f393241b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f393242c = -1;

    /* renamed from: e, reason: collision with root package name */
    private float f393244e = 1.2f;

    /* renamed from: f, reason: collision with root package name */
    private float f393245f = 1.0f;

    /* renamed from: g, reason: collision with root package name */
    private final b f393246g = new b("scale");

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void a();

        void b(boolean z16);

        void c(int i3);

        int getSize();

        void onItemMoved(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class b extends Property<View, Float> {
        public b(String str) {
            super(Float.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getScaleX());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f16) {
            view.setScaleX(f16.floatValue());
            view.setScaleY(f16.floatValue());
        }
    }

    private void a(View view) {
        Object tag = view.getTag();
        if (tag instanceof ObjectAnimator) {
            ((ObjectAnimator) tag).cancel();
            view.setTag(null);
        }
    }

    private void e(View view, float f16, float f17, long j3) {
        if (view.getTag() instanceof ObjectAnimator) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f393246g, f16, f17);
        ofFloat.setDuration(j3);
        ofFloat.start();
        view.setTag(ofFloat);
    }

    public void b(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.f393245f = f16;
    }

    public void c(a aVar) {
        this.f393240a = aVar;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        a(viewHolder.itemView);
        e(viewHolder.itemView, this.f393244e, 1.0f, 150L);
        viewHolder.itemView.setAlpha(1.0f);
        super.clearView(recyclerView, viewHolder);
    }

    public void d(float f16) {
        this.f393244e = f16;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(RecyclerView recyclerView, int i3, float f16, float f17) {
        if (this.f393241b) {
            return 0L;
        }
        return super.getAnimationDuration(recyclerView, i3, f16, f17);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        a aVar;
        if (viewHolder.getItemViewType() != viewHolder2.getItemViewType() || (aVar = this.f393240a) == null || aVar.getSize() < 2) {
            return false;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        this.f393242c = adapterPosition2;
        this.f393240a.onItemMoved(adapterPosition, adapterPosition2);
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i3) {
        RecyclerView.ViewHolder viewHolder2;
        if (i3 != 0) {
            a(viewHolder.itemView);
            e(viewHolder.itemView, 1.0f, this.f393244e, 200L);
            viewHolder.itemView.setAlpha(this.f393245f);
            a aVar = this.f393240a;
            if (aVar != null) {
                aVar.a();
            }
            this.f393242c = viewHolder.getAdapterPosition();
            this.f393243d = viewHolder;
            Log.d("jiabin", "onSelectedChanged delPos:" + this.f393242c);
        } else {
            a aVar2 = this.f393240a;
            if (aVar2 != null) {
                aVar2.b(this.f393241b);
            }
            if (this.f393241b && this.f393242c >= 0 && (viewHolder2 = this.f393243d) != null) {
                viewHolder2.itemView.setVisibility(4);
                a aVar3 = this.f393240a;
                if (aVar3 != null) {
                    aVar3.c(this.f393242c);
                }
                this.f393241b = false;
            }
            this.f393242c = -1;
            this.f393243d = null;
        }
        super.onSelectedChanged(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i3) {
    }
}
