package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpDragHelper;", "", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDragHelper {
    private static final float DRAGGING_ICON_SCALE_SIZE = 1.385f;
    private static final String TAG = "MiniAppExpDragHelper";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static AtomicBoolean isNeedStartDragViewVisible = new AtomicBoolean(true);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J6\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004J\u001e\u0010 \u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpDragHelper$Companion;", "", "()V", "DRAGGING_ICON_SCALE_SIZE", "", "TAG", "", "isNeedStartDragViewVisible", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setNeedStartDragViewVisible", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "doVibrator", "", "context", "Landroid/content/Context;", "getDragActionString", "action", "", "resetDraggingViewState", "dragData", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpDragData;", "startDrag", "startRv", "Landroidx/recyclerview/widget/RecyclerView;", "startViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fromPosition", "fromDesktopAppInfo", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "viewHolderRawX", "viewHolderRawY", "updateDragShadow", "shadowResId", "dragViewMarkVisibility", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void doVibrator(Context context) {
            VibrationEffect createOneShot;
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Object systemService = context.getSystemService("vibrator");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                Vibrator vibrator = (Vibrator) systemService;
                if (vibrator.hasVibrator()) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        createOneShot = VibrationEffect.createOneShot(50L, -1);
                        vibrator.vibrate(createOneShot);
                    } else {
                        vibrator.vibrate(50L);
                    }
                }
            } catch (Exception unused) {
                QLog.e(MiniAppExpDragHelper.TAG, 2, "Vibrator exception.");
            }
        }

        public final AtomicBoolean isNeedStartDragViewVisible() {
            return MiniAppExpDragHelper.isNeedStartDragViewVisible;
        }

        public final void resetDraggingViewState(MiniAppExpDragData dragData) {
            Intrinsics.checkNotNullParameter(dragData, "dragData");
            View view = dragData.getStartViewHolder().itemView;
            Intrinsics.checkNotNullExpressionValue(view, "dragData.startViewHolder.itemView");
            view.setVisibility(0);
            if (dragData.getFromDesktopAppInfo().mMiniAppInfo.isWxMiniApp()) {
                view.findViewById(R.id.f163693ri0).setVisibility(0);
            } else {
                view.findViewById(R.id.f163693ri0).setVisibility(8);
            }
        }

        public final void setNeedStartDragViewVisible(AtomicBoolean atomicBoolean) {
            Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
            MiniAppExpDragHelper.isNeedStartDragViewVisible = atomicBoolean;
        }

        public final void startDrag(RecyclerView startRv, RecyclerView.ViewHolder startViewHolder, int fromPosition, DesktopAppInfo fromDesktopAppInfo, final float viewHolderRawX, final float viewHolderRawY) {
            Intrinsics.checkNotNullParameter(startRv, "startRv");
            Intrinsics.checkNotNullParameter(startViewHolder, "startViewHolder");
            Intrinsics.checkNotNullParameter(fromDesktopAppInfo, "fromDesktopAppInfo");
            final View findViewById = startViewHolder.itemView.findViewById(R.id.rgn);
            startViewHolder.itemView.findViewById(R.id.f163693ri0).setVisibility(4);
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(findViewById) { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragHelper$Companion$startDrag$shadowBuilder$1
                @Override // android.view.View.DragShadowBuilder
                public void onDrawShadow(Canvas canvas) {
                    Intrinsics.checkNotNullParameter(canvas, "canvas");
                    canvas.scale(1.385f, 1.385f);
                    getView().draw(canvas);
                }

                @Override // android.view.View.DragShadowBuilder
                public void onProvideShadowMetrics(Point outShadowSize, Point outShadowTouchPoint) {
                    Intrinsics.checkNotNullParameter(outShadowSize, "outShadowSize");
                    Intrinsics.checkNotNullParameter(outShadowTouchPoint, "outShadowTouchPoint");
                    int[] iArr = new int[2];
                    getView().getLocationOnScreen(iArr);
                    int i3 = iArr[0];
                    int i16 = iArr[1];
                    int width = getView().getWidth();
                    int height = getView().getHeight();
                    int i17 = (width / 2) + i3;
                    int i18 = (height / 2) + i16;
                    float f16 = 2;
                    outShadowSize.set((int) (width * 1.385f), (int) (height * 1.385f));
                    outShadowTouchPoint.set(Math.abs((int) ((viewHolderRawX - i3) + (((int) ((r3 / f16) + r2)) - i17))), Math.abs((int) ((viewHolderRawY - i16) + (((int) ((r4 / f16) + r1)) - i18))));
                }
            };
            startViewHolder.itemView.setVisibility(4);
            Context context = startViewHolder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "startViewHolder.itemView.context");
            doVibrator(context);
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    findViewById.startDragAndDrop(null, dragShadowBuilder, new MiniAppExpDragData(startRv, startViewHolder, fromPosition, fromDesktopAppInfo), 0);
                } else {
                    findViewById.startDrag(null, dragShadowBuilder, new MiniAppExpDragData(startRv, startViewHolder, fromPosition, fromDesktopAppInfo), 0);
                }
            } catch (Throwable th5) {
                QLog.e(MiniAppExpDragHelper.TAG, 1, "startDrag(), error", th5);
            }
        }

        public final void updateDragShadow(MiniAppExpDragData dragData, int shadowResId, int dragViewMarkVisibility) {
            Intrinsics.checkNotNullParameter(dragData, "dragData");
            if (Build.VERSION.SDK_INT >= 24) {
                final View findViewById = dragData.getStartViewHolder().itemView.findViewById(R.id.rgn);
                FrameLayout frameLayout = (FrameLayout) dragData.getStartViewHolder().itemView.findViewById(R.id.rg_);
                ImageView imageView = (ImageView) dragData.getStartViewHolder().itemView.findViewById(R.id.rg9);
                frameLayout.setVisibility(dragViewMarkVisibility);
                if (shadowResId != -1) {
                    imageView.setImageResource(shadowResId);
                }
                findViewById.updateDragShadow(new View.DragShadowBuilder(findViewById) { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.MiniAppExpDragHelper$Companion$updateDragShadow$updateShadow$1
                    @Override // android.view.View.DragShadowBuilder
                    public void onDrawShadow(Canvas canvas) {
                        Intrinsics.checkNotNullParameter(canvas, "canvas");
                        canvas.scale(1.385f, 1.385f);
                        getView().draw(canvas);
                    }
                });
            }
        }

        Companion() {
        }

        public final String getDragActionString(int action) {
            switch (action) {
                case 1:
                    return "DRAG_STARTED";
                case 2:
                    return "DRAG_LOCATION";
                case 3:
                    return "DROP";
                case 4:
                    return "DRAG_ENDED";
                case 5:
                    return "DRAG_ENTERED";
                case 6:
                    return "DRAG_EXITED";
                default:
                    return "";
            }
        }
    }
}
