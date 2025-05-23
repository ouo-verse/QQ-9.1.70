package lr0;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.util.Property;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    private f f415454a;

    /* renamed from: b, reason: collision with root package name */
    private View f415455b;

    /* renamed from: c, reason: collision with root package name */
    private a f415456c;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView.ViewHolder f415459f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f415457d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f415458e = -1;

    /* renamed from: g, reason: collision with root package name */
    private float[] f415460g = {0.8f, 1.0f, 1.2f};

    /* renamed from: h, reason: collision with root package name */
    private float f415461h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f415462i = 0.86f;

    /* renamed from: j, reason: collision with root package name */
    private float f415463j = 0.3f;

    /* renamed from: k, reason: collision with root package name */
    private float f415464k = 1.2f;

    /* renamed from: l, reason: collision with root package name */
    private b f415465l = new b("scale");

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b(boolean z16);

        void c(boolean z16, boolean z17);
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
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

    public g(@NonNull f fVar, View view) {
        this.f415454a = fVar;
        this.f415455b = view;
    }

    private void a(View view) {
        Object tag = view.getTag();
        if (tag instanceof ObjectAnimator) {
            ((ObjectAnimator) tag).cancel();
            view.setTag(null);
        }
    }

    private boolean b(View view) {
        Object tag = view.getTag();
        if ((tag instanceof ObjectAnimator) && ((ObjectAnimator) tag).isRunning()) {
            return true;
        }
        return false;
    }

    private void f(View view, long j3, float... fArr) {
        if (view.getTag() instanceof ObjectAnimator) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f415465l, fArr);
        ofFloat.setDuration(j3);
        ofFloat.start();
        view.setTag(ofFloat);
    }

    public void c(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.f415461h = f16;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i3, int i16) {
        int bottom;
        int abs;
        int top;
        int abs2;
        int abs3;
        int abs4;
        int width = i3 + viewHolder.itemView.getWidth();
        int height = i16 + viewHolder.itemView.getHeight();
        int left = i3 - viewHolder.itemView.getLeft();
        int top2 = i16 - viewHolder.itemView.getTop();
        int size = list.size();
        RecyclerView.ViewHolder viewHolder2 = null;
        int i17 = -1;
        for (int i18 = 0; i18 < size; i18++) {
            RecyclerView.ViewHolder viewHolder3 = list.get(i18);
            if (left > 0) {
                int right = viewHolder3.itemView.getRight() - width;
                if (right < viewHolder3.itemView.getWidth() * getMoveThreshold(viewHolder3) && viewHolder3.itemView.getRight() > viewHolder.itemView.getRight() && (abs4 = Math.abs(right)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs4;
                }
            }
            if (left < 0) {
                int left2 = i3 - viewHolder3.itemView.getLeft();
                if (left2 < viewHolder3.itemView.getWidth() * getMoveThreshold(viewHolder3) && viewHolder3.itemView.getLeft() < viewHolder.itemView.getLeft() && (abs3 = Math.abs(left2)) > i17) {
                    viewHolder2 = viewHolder3;
                    i17 = abs3;
                }
            }
            if (top2 < 0 && (top = viewHolder3.itemView.getTop() - i16) > 0 && viewHolder3.itemView.getTop() < viewHolder.itemView.getTop() && (abs2 = Math.abs(top)) > i17) {
                viewHolder2 = viewHolder3;
                i17 = abs2;
            }
            if (top2 > 0 && (bottom = viewHolder3.itemView.getBottom() - height) < 0 && viewHolder3.itemView.getBottom() > viewHolder.itemView.getBottom() && (abs = Math.abs(bottom)) > i17) {
                viewHolder2 = viewHolder3;
                i17 = abs;
            }
        }
        return viewHolder2;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        a(viewHolder.itemView);
        float[] fArr = this.f415460g;
        f(viewHolder.itemView, 200L, fArr[fArr.length - 1], 1.0f);
        viewHolder.itemView.setAlpha(1.0f);
        super.clearView(recyclerView, viewHolder);
    }

    public void d(a aVar) {
        this.f415456c = aVar;
    }

    public void e(float... fArr) {
        if (fArr != null && fArr.length > 0) {
            int length = fArr.length;
            this.f415460g = new float[length];
            for (int i3 = 0; i3 < length; i3++) {
                this.f415460g[i3] = fArr[i3];
                if (i3 == length - 1) {
                    this.f415464k = fArr[i3];
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(RecyclerView recyclerView, int i3, float f16, float f17) {
        if (this.f415457d) {
            return 0L;
        }
        return super.getAnimationDuration(recyclerView, i3, f16, f17);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.Callback.makeMovementFlags(12, 0);
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
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f16, float f17, int i3, boolean z16) {
        boolean z17;
        if (this.f415455b != null && !b(viewHolder.itemView)) {
            int width = this.f415455b.getWidth();
            int height = this.f415455b.getHeight();
            int[] iArr = new int[2];
            this.f415455b.getLocationInWindow(iArr);
            boolean z18 = false;
            int i16 = iArr[0];
            int i17 = iArr[1];
            int width2 = viewHolder.itemView.getWidth();
            int height2 = viewHolder.itemView.getHeight();
            int[] iArr2 = new int[2];
            viewHolder.itemView.getLocationInWindow(iArr2);
            int i18 = iArr2[0];
            int i19 = iArr2[1];
            float f18 = this.f415464k;
            int i26 = i18 + (((int) (width2 * f18)) / 2);
            int i27 = i19 + (((int) (height2 * f18)) / 2);
            if (i27 > i17 && i27 < i17 + height && i26 > i16 && i26 < i16 + width) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 != this.f415457d) {
                if (this.f415459f != null) {
                    if (z17) {
                        this.f415464k = this.f415462i;
                        a(viewHolder.itemView);
                        f(viewHolder.itemView, 600L, this.f415460g);
                        viewHolder.itemView.setAlpha(this.f415463j);
                    } else {
                        float[] fArr = this.f415460g;
                        this.f415464k = fArr[fArr.length - 1];
                        a(viewHolder.itemView);
                        f(viewHolder.itemView, 600L, this.f415460g);
                        viewHolder.itemView.setAlpha(this.f415461h);
                    }
                }
                a aVar = this.f415456c;
                if (aVar != null) {
                    if (this.f415459f == null) {
                        z18 = true;
                    }
                    aVar.c(z17, z18);
                }
            }
            this.f415457d = z17;
            super.onChildDraw(canvas, recyclerView, viewHolder, f16, f17, i3, z16);
            return;
        }
        super.onChildDraw(canvas, recyclerView, viewHolder, f16, f17, i3, z16);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
            return false;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        this.f415458e = adapterPosition2;
        this.f415454a.x0(adapterPosition, adapterPosition2);
        this.f415454a.notifyItemMoved(adapterPosition, adapterPosition2);
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i3) {
        RecyclerView.ViewHolder viewHolder2;
        if (i3 != 0) {
            a(viewHolder.itemView);
            f(viewHolder.itemView, 600L, this.f415460g);
            viewHolder.itemView.setAlpha(this.f415461h);
            a aVar = this.f415456c;
            if (aVar != null) {
                aVar.a();
            }
            this.f415458e = viewHolder.getAdapterPosition();
            this.f415459f = viewHolder;
        } else {
            a aVar2 = this.f415456c;
            if (aVar2 != null) {
                aVar2.b(this.f415457d);
            }
            if (this.f415457d && this.f415458e >= 0 && (viewHolder2 = this.f415459f) != null) {
                viewHolder2.itemView.setVisibility(4);
                this.f415454a.C0(this.f415458e);
                this.f415457d = false;
            }
            this.f415458e = -1;
            this.f415459f = null;
        }
        super.onSelectedChanged(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i3) {
    }
}
