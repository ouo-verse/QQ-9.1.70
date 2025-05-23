package com.tencent.qqnt.qbasealbum.select.view;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.util.Property;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000b&B\u0007\u00a2\u0006\u0004\b7\u00108J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J(\u0010\u001a\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u001a\u0010\u001c\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 J\u000e\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0004J\u0010\u0010&\u001a\u00020\t2\b\b\u0001\u0010%\u001a\u00020\u0004R\u0018\u0010(\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010'R\u0016\u0010*\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010)R\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010-R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010/R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/view/a;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "Landroid/view/View;", "view", "", "from", "to", "", "duration", "", "e", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "getMovementFlags", "target", "", "onMove", "direction", "onSwiped", "animationType", "animateDx", "animateDy", "getAnimationDuration", "actionState", "onSelectedChanged", "clearView", "isLongPressDragEnabled", "isItemViewSwipeEnabled", "Lcom/tencent/qqnt/qbasealbum/select/view/a$a;", "listener", "c", "scale", "d", com.tencent.luggage.wxa.c8.c.f123400v, "b", "Lcom/tencent/qqnt/qbasealbum/select/view/a$a;", "mDragListener", "Z", "mIsInside", "I", "mDelPos", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mTempHolder", UserInfo.SEX_FEMALE, "mScale", "f", "mAlpha", "Lcom/tencent/qqnt/qbasealbum/select/view/a$b;", "g", "Lcom/tencent/qqnt/qbasealbum/select/view/a$b;", "mScaleProperty", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends ItemTouchHelper.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InterfaceC9685a mDragListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInside;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mDelPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView.ViewHolder mTempHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mScale;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mAlpha;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mScaleProperty;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/view/a$a;", "", "", "getSize", "fromPosition", "toPosition", "", "onItemMoved", "position", "c", "a", "", "isInside", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.select.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC9685a {
        void a();

        void b(boolean isInside);

        void c(int position);

        int getSize();

        void onItemMoved(int fromPosition, int toPosition);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/select/view/a$b;", "Landroid/util/Property;", "Landroid/view/View;", "", "object", "a", "(Landroid/view/View;)Ljava/lang/Float;", "value", "", "b", "", "name", "<init>", "(Ljava/lang/String;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
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
        public Float get(@NotNull View object) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Float) iPatchRedirector.redirect((short) 2, (Object) this, (Object) object);
            }
            Intrinsics.checkNotNullParameter(object, "object");
            return Float.valueOf(object.getScaleX());
        }

        public void b(@NotNull View object, float value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, object, Float.valueOf(value));
                return;
            }
            Intrinsics.checkNotNullParameter(object, "object");
            object.setScaleX(value);
            object.setScaleY(value);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f16) {
            b(view, f16.floatValue());
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mDelPos = -1;
        this.mScale = 1.2f;
        this.mAlpha = 1.0f;
        this.mScaleProperty = new b("scale");
    }

    private final void a(View view) {
        Object tag = view.getTag();
        if (tag instanceof ObjectAnimator) {
            ((ObjectAnimator) tag).cancel();
            view.setTag(null);
        }
    }

    private final void e(View view, float from, float to5, long duration) {
        if (view.getTag() instanceof ObjectAnimator) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.mScaleProperty, from, to5);
        ofFloat.setDuration(duration);
        ofFloat.start();
        view.setTag(ofFloat);
    }

    public final void b(@FloatRange(from = 0.0d, to = 1.0d) float alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(alpha));
        } else {
            this.mAlpha = alpha;
        }
    }

    public final void c(@Nullable InterfaceC9685a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) listener);
        } else {
            this.mDragListener = listener;
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recyclerView, (Object) viewHolder);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        a(view);
        View view2 = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
        e(view2, this.mScale, 1.0f, 150L);
        viewHolder.itemView.setAlpha(1.0f);
        super.clearView(recyclerView, viewHolder);
    }

    public final void d(float scale) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(scale));
        } else {
            this.mScale = scale;
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(@NotNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, this, recyclerView, Integer.valueOf(animationType), Float.valueOf(animateDx), Float.valueOf(animateDy))).longValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.mIsInside) {
            return 0L;
        }
        return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, (Object) viewHolder)).intValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        InterfaceC9685a interfaceC9685a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, recyclerView, viewHolder, target)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        if (viewHolder.getItemViewType() != target.getItemViewType() || (interfaceC9685a = this.mDragListener) == null) {
            return false;
        }
        Intrinsics.checkNotNull(interfaceC9685a);
        if (interfaceC9685a.getSize() < 2) {
            return false;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = target.getAdapterPosition();
        this.mDelPos = adapterPosition2;
        InterfaceC9685a interfaceC9685a2 = this.mDragListener;
        Intrinsics.checkNotNull(interfaceC9685a2);
        interfaceC9685a2.onItemMoved(adapterPosition, adapterPosition2);
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        RecyclerView.ViewHolder viewHolder2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewHolder, actionState);
            return;
        }
        if (actionState != 0 && viewHolder != null) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            a(view);
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "viewHolder.itemView");
            e(view2, 1.0f, this.mScale, 200L);
            viewHolder.itemView.setAlpha(this.mAlpha);
            InterfaceC9685a interfaceC9685a = this.mDragListener;
            if (interfaceC9685a != null) {
                Intrinsics.checkNotNull(interfaceC9685a);
                interfaceC9685a.a();
            }
            int adapterPosition = viewHolder.getAdapterPosition();
            this.mDelPos = adapterPosition;
            this.mTempHolder = viewHolder;
            Log.d("jiabin", "onSelectedChanged delPos:" + adapterPosition);
        } else {
            InterfaceC9685a interfaceC9685a2 = this.mDragListener;
            if (interfaceC9685a2 != null) {
                Intrinsics.checkNotNull(interfaceC9685a2);
                interfaceC9685a2.b(this.mIsInside);
            }
            if (this.mIsInside && this.mDelPos >= 0 && (viewHolder2 = this.mTempHolder) != null) {
                Intrinsics.checkNotNull(viewHolder2);
                viewHolder2.itemView.setVisibility(4);
                InterfaceC9685a interfaceC9685a3 = this.mDragListener;
                if (interfaceC9685a3 != null) {
                    Intrinsics.checkNotNull(interfaceC9685a3);
                    interfaceC9685a3.c(this.mDelPos);
                }
                this.mIsInside = false;
            }
            this.mDelPos = -1;
            this.mTempHolder = null;
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int direction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, direction);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }
    }
}
