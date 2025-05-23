package com.tencent.mobileqq.guild.rolegroup.view;

import android.graphics.Canvas;
import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.h;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.ItemTouchHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\f\u0006B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper;", "", "", HippyTKDListViewAdapter.X, "y", "Landroid/view/MotionEvent;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "handler", "Lcom/tencent/mobileqq/guild/widget/ItemTouchHelper;", "b", "<init>", "()V", "IMovableEventHandler", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MovableTouchHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MovableTouchHelper f232805a = new MovableTouchHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "a", "", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "source", "target", "b", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler$MoveDirection;", "e", "", "sourcePosition", "targetPosition", "d", "MoveDirection", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface IMovableEventHandler {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler$MoveDirection;", "", "(Ljava/lang/String;I)V", "NONE", "UP", "DOWN", "BOTH", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public enum MoveDirection {
            NONE,
            UP,
            DOWN,
            BOTH
        }

        void a(@NotNull RecyclerView.ViewHolder viewHolder);

        boolean b(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder source, @NotNull RecyclerView.ViewHolder target);

        boolean c(@NotNull RecyclerView.ViewHolder viewHolder);

        void d(int sourcePosition, int targetPosition, @NotNull RecyclerView.ViewHolder viewHolder);

        @NotNull
        MoveDirection e(@NotNull RecyclerView.ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020$\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J@\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J0\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$b;", "Lcom/tencent/mobileqq/guild/widget/ItemTouchHelper$c;", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$a;", "touchHelper", "", "B", "Landroidx/recyclerview/widget/RecyclerView;", "p0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "j", "actionState", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "recyclerView", "source", "target", "", HippyTKDListViewAdapter.X, "c", "Landroid/graphics/Canvas;", "", "dX", "dY", "isCurrentlyActive", "t", "viewSize", "viewSizeOutOfBounds", "totalSize", "", "msSinceStartScroll", "o", "p1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "d", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "getHandler", "()Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "handler", "e", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$a;", "f", "I", "sourcePosition", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ItemTouchHelper.c {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IMovableEventHandler handler;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private a touchHelper;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int sourcePosition;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes14.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f232812a;

            static {
                int[] iArr = new int[IMovableEventHandler.MoveDirection.values().length];
                try {
                    iArr[IMovableEventHandler.MoveDirection.NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[IMovableEventHandler.MoveDirection.UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[IMovableEventHandler.MoveDirection.DOWN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[IMovableEventHandler.MoveDirection.BOTH.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f232812a = iArr;
            }
        }

        public b(@NotNull IMovableEventHandler handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.handler = handler;
        }

        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public void A(@NotNull RecyclerView.ViewHolder p06, int p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
        }

        public final void B(@NotNull a touchHelper) {
            Intrinsics.checkNotNullParameter(touchHelper, "touchHelper");
            this.touchHelper = touchHelper;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public void c(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.c(recyclerView, viewHolder);
            int adapterPosition = viewHolder.getAdapterPosition();
            if (viewHolder instanceof h) {
                ((h) viewHolder).setSelected(false);
            }
            Logger logger = Logger.f235387a;
            this.handler.d(this.sourcePosition, adapterPosition, viewHolder);
        }

        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public int j(@NotNull RecyclerView p06, @NotNull RecyclerView.ViewHolder viewHolder) {
            int i3;
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (a.f232812a[this.handler.e(viewHolder).ordinal()] == 1) {
                i3 = 0;
            } else {
                i3 = 3;
            }
            return ItemTouchHelper.c.s(i3, 0);
        }

        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public int o(@NotNull RecyclerView recyclerView, int viewSize, int viewSizeOutOfBounds, int totalSize, long msSinceStartScroll) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            return ((int) Math.signum(viewSizeOutOfBounds)) * 3;
        }

        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public boolean p() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public boolean q() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public void t(@NotNull Canvas c16, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            float min;
            Intrinsics.checkNotNullParameter(c16, "c");
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (!isCurrentlyActive) {
                super.t(c16, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                return;
            }
            IMovableEventHandler.MoveDirection e16 = this.handler.e(viewHolder);
            int i3 = a.f232812a[e16.ordinal()];
            float f16 = 0.0f;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            f16 = dY;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        min = Math.max(dY, 0.0f);
                    }
                } else {
                    min = Math.min(dY, 0.0f);
                }
                f16 = min;
            }
            super.t(c16, recyclerView, viewHolder, dX, f16, actionState, isCurrentlyActive);
            Logger logger = Logger.f235387a;
            if ((e16 == IMovableEventHandler.MoveDirection.UP && dY > 10.0f) || (e16 == IMovableEventHandler.MoveDirection.DOWN && dY < -10.0f)) {
                a aVar = this.touchHelper;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("touchHelper");
                    aVar = null;
                }
                aVar.c();
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public boolean x(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder source, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(target, "target");
            Logger logger = Logger.f235387a;
            if (!this.handler.c(target)) {
                return false;
            }
            return this.handler.b(recyclerView, source, target);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper.c
        public void z(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            super.z(viewHolder, actionState);
            Logger logger = Logger.f235387a;
            if (viewHolder instanceof h) {
                ((h) viewHolder).setSelected(true);
                this.sourcePosition = viewHolder.getAdapterPosition();
                this.handler.a(viewHolder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0006\u0010\f\u001a\u00020\bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$c;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/MotionEvent;", "motion", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "onTouchEvent", "disallow", "onRequestDisallowInterceptTouchEvent", "a", "", "d", "[F", "b", "()[F", "point", "e", "Z", "isInDownAction", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements RecyclerView.OnItemTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final float[] point = {0.0f, 0.0f};

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isInDownAction;

        public final void a() {
            this.isInDownAction = false;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final float[] getPoint() {
            return this.point;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        
            if (r4 != 3) goto L15;
         */
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onInterceptTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motion) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(motion, "motion");
            Logger logger = Logger.f235387a;
            int actionMasked = motion.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        this.point[0] = motion.getX();
                        this.point[1] = motion.getY();
                        if (!this.isInDownAction) {
                            return true;
                        }
                    }
                }
                this.isInDownAction = false;
            } else {
                this.isInDownAction = true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallow) {
            Logger logger = Logger.f235387a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NotNull RecyclerView recyclerView, @NotNull MotionEvent motion) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(motion, "motion");
            Logger logger = Logger.f235387a;
        }
    }

    MovableTouchHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MotionEvent c(float x16, float y16) {
        MotionEvent obtain = MotionEvent.obtain(0L, 0L, 1, x16, y16, 0);
        Logger logger = Logger.f235387a;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain");
        return obtain;
    }

    @NotNull
    public final ItemTouchHelper b(@NotNull RecyclerView recyclerView, @NotNull IMovableEventHandler handler) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(handler, "handler");
        a aVar = new a(handler, null, 2, 0 == true ? 1 : 0);
        aVar.attachToRecyclerView(recyclerView);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$a;", "Lcom/tencent/mobileqq/guild/widget/ItemTouchHelper;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "attachToRecyclerView", "c", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "b0", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "getHandler", "()Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "handler", "c0", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$c;", "d0", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$c;", "touchInterceptor", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$b;", "callback", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends ItemTouchHelper {

        /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IMovableEventHandler handler;

        /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecyclerView recyclerView;

        /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private c touchInterceptor;

        public /* synthetic */ a(IMovableEventHandler iMovableEventHandler, b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(iMovableEventHandler, (i3 & 2) != 0 ? new b(iMovableEventHandler) : bVar);
        }

        @Override // com.tencent.mobileqq.guild.widget.ItemTouchHelper
        public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
            super.attachToRecyclerView(recyclerView);
            if (recyclerView == null) {
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.removeOnItemTouchListener(this.touchInterceptor);
                }
            } else {
                recyclerView.addOnItemTouchListener(this.touchInterceptor);
            }
            this.recyclerView = recyclerView;
        }

        public final void c() {
            float[] point = this.touchInterceptor.getPoint();
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.dispatchTouchEvent(MovableTouchHelper.f232805a.c(point[0], point[1]));
            }
            this.touchInterceptor.a();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull IMovableEventHandler handler, @NotNull b callback) {
            super(callback);
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.handler = handler;
            this.touchInterceptor = new c();
            callback.B(this);
        }
    }
}
