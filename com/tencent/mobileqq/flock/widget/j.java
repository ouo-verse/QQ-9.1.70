package com.tencent.mobileqq.flock.widget;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mapsdk.internal.by;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0002\u0005!B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0011H\u0016R\u0016\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b!\u0010/R\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/j;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroid/view/View;", "view", "", "a", "", "from", "to", "", "duration", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "clearView", "", "animationType", "animateDx", "animateDy", "getAnimationDuration", "getMovementFlags", "target", "", "onMove", "actionState", "onSelectedChanged", "isItemViewSwipeEnabled", "direction", "onSwiped", "Z", "isInside", "b", "I", "delPos", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "tempHolder", "Lcom/tencent/mobileqq/flock/widget/j$b;", "d", "Lcom/tencent/mobileqq/flock/widget/j$b;", "scaleProperty", "Lcom/tencent/mobileqq/flock/widget/j$a;", "e", "Lcom/tencent/mobileqq/flock/widget/j$a;", "getDragListener", "()Lcom/tencent/mobileqq/flock/widget/j$a;", "(Lcom/tencent/mobileqq/flock/widget/j$a;)V", "dragListener", "f", UserInfo.SEX_FEMALE, "getScale", "()F", "setScale", "(F)V", "scale", "g", "getAlpha", "setAlpha", com.tencent.luggage.wxa.c8.c.f123400v, "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j extends ItemTouchHelper.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isInside;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int delPos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.ViewHolder tempHolder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b scaleProperty;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a dragListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float scale;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @FloatRange(from = 0.0d, to = by.f147964a)
    private float alpha;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/j$a;", "", "", "getSize", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "d", "fromPosition", "toPosition", "", "onItemMoved", "position", "c", "a", "isInside", "b", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        void a();

        void b(boolean isInside);

        void c(int position);

        boolean d(@NotNull RecyclerView.ViewHolder viewHolder);

        int getSize();

        void onItemMoved(int fromPosition, int toPosition);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/j$b;", "Landroid/util/Property;", "Landroid/view/View;", "", "view", "a", "(Landroid/view/View;)Ljava/lang/Float;", "value", "", "b", "", "name", "<init>", "(Ljava/lang/String;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends Property<View, Float> {
        static IPatchRedirector $redirector_;

        public b(@Nullable String str) {
            super(Float.TYPE, str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // android.util.Property
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Float) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            Intrinsics.checkNotNullParameter(view, "view");
            return Float.valueOf(view.getScaleX());
        }

        public void b(@NotNull View view, float value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, Float.valueOf(value));
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            view.setScaleX(value);
            view.setScaleY(value);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f16) {
            b(view, f16.floatValue());
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.delPos = -1;
        this.scaleProperty = new b("scale");
        this.scale = 1.2f;
        this.alpha = 0.9f;
    }

    private final void a(View view) {
        Object tag = view.getTag();
        if (tag instanceof ObjectAnimator) {
            ((ObjectAnimator) tag).cancel();
            view.setTag(null);
        }
    }

    private final void c(View view, float from, float to5, long duration) {
        if (view.getTag() instanceof ObjectAnimator) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.scaleProperty, from, to5);
        ofFloat.setDuration(duration);
        ofFloat.start();
        view.setTag(ofFloat);
    }

    public final void b(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.dragListener = aVar;
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) recyclerView, (Object) viewHolder);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        a(view);
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
        c(view2, this.scale, 1.0f, 150L);
        viewHolder.itemView.setAlpha(1.0f);
        super.clearView(recyclerView, viewHolder);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(@NotNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, this, recyclerView, Integer.valueOf(animationType), Float.valueOf(animateDx), Float.valueOf(animateDy))).longValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.isInside) {
            return 0L;
        }
        return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r4 == true) goto L14;
     */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) recyclerView, (Object) viewHolder)).intValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        a aVar = this.dragListener;
        if (aVar != null) {
            boolean d16 = aVar.d(viewHolder);
            z16 = true;
        }
        z16 = false;
        if (z16) {
            i3 = 15;
        } else {
            i3 = 0;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(i3, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, recyclerView, viewHolder, target)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        a aVar = this.dragListener;
        if (aVar != null) {
            i3 = aVar.getSize();
        } else {
            i3 = 0;
        }
        if (i3 < 2) {
            return false;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = target.getAdapterPosition();
        this.delPos = adapterPosition2;
        a aVar2 = this.dragListener;
        if (aVar2 != null) {
            aVar2.onItemMoved(adapterPosition, adapterPosition2);
            return true;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        RecyclerView.ViewHolder viewHolder2;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) viewHolder, actionState);
            return;
        }
        if (actionState != 0) {
            if (viewHolder != null) {
                View itemView = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                a(itemView);
                View itemView2 = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                c(itemView2, 1.0f, this.scale, 200L);
                viewHolder.itemView.setAlpha(this.alpha);
                this.delPos = viewHolder.getAdapterPosition();
                this.tempHolder = viewHolder;
            }
            a aVar = this.dragListener;
            if (aVar != null) {
                aVar.a();
            }
        } else {
            a aVar2 = this.dragListener;
            if (aVar2 != null) {
                aVar2.b(this.isInside);
            }
            if (this.isInside && this.delPos >= 0 && (viewHolder2 = this.tempHolder) != null) {
                if (viewHolder2 != null) {
                    view = viewHolder2.itemView;
                } else {
                    view = null;
                }
                if (view != null) {
                    view.setVisibility(4);
                }
                a aVar3 = this.dragListener;
                if (aVar3 != null) {
                    aVar3.c(this.delPos);
                }
                this.isInside = false;
            }
            this.delPos = -1;
            this.tempHolder = null;
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) viewHolder, direction);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }
}
