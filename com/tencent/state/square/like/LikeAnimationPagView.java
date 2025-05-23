package com.tencent.state.square.like;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagFileHandler;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.ISquarePagViewListener;
import com.tencent.state.square.databinding.VasSquareOperateLikeAnimationBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0019B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/like/LikeAnimationPagView;", "Landroid/widget/PopupWindow;", "Lcom/tencent/state/square/api/ISquarePagViewListener;", "Lcom/tencent/state/square/api/ISquarePagFileHandler;", "context", "Landroid/content/Context;", "type", "", "autoDismiss", "", "(Landroid/content/Context;IZ)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareOperateLikeAnimationBinding;", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "timeOutDismissRunnable", "Ljava/lang/Runnable;", "onAnimationCancel", "", "squarePagView", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onPagFileLoaded", "safelyDismiss", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class LikeAnimationPagView extends PopupWindow implements ISquarePagViewListener, ISquarePagFileHandler {
    private static final String TAG = "LikePagView";
    private final boolean autoDismiss;
    private final VasSquareOperateLikeAnimationBinding binding;
    private final Context context;
    private ISquarePagView pagView;
    private Runnable timeOutDismissRunnable;
    private final int type;

    public /* synthetic */ LikeAnimationPagView(Context context, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i3, (i16 & 4) != 0 ? true : z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void safelyDismiss() {
        try {
            View contentView = getContentView();
            if (contentView != null) {
                contentView.removeCallbacks(this.timeOutDismissRunnable);
            }
            dismiss();
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "safelyDismiss err.", th5);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationCancel(ISquarePagView squarePagView) {
        if (this.autoDismiss) {
            safelyDismiss();
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationEnd(ISquarePagView squarePagView) {
        if (this.autoDismiss) {
            safelyDismiss();
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationUpdate(ISquarePagView iSquarePagView) {
        ISquarePagViewListener.DefaultImpls.onAnimationUpdate(this, iSquarePagView);
    }

    @Override // com.tencent.state.square.api.ISquarePagFileHandler
    public void onPagFileLoaded(ISquarePagView squarePagView) {
        Integer num = LikeData.INSTANCE.getTYPE_IMG_RES().get(Integer.valueOf(this.type));
        if (num != null) {
            int intValue = num.intValue();
            ISquarePagView iSquarePagView = this.pagView;
            if (iSquarePagView != null) {
                iSquarePagView.replaceImageLayer(0, BitmapFactory.decodeResource(this.context.getResources(), intValue));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeAnimationPagView(Context context, int i3, boolean z16) {
        super(context);
        View view;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.type = i3;
        this.autoDismiss = z16;
        VasSquareOperateLikeAnimationBinding inflate = VasSquareOperateLikeAnimationBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareOperateLikeAnim\u2026utInflater.from(context))");
        this.binding = inflate;
        this.timeOutDismissRunnable = new Runnable() { // from class: com.tencent.state.square.like.LikeAnimationPagView$timeOutDismissRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                SquareBaseKt.getSquareLog().i("LikePagView", "timeout dismiss");
                LikeAnimationPagView.this.safelyDismiss();
            }
        };
        setContentView(inflate.getMRv());
        ISquarePagView pagView = Square.INSTANCE.getConfig().getCommonUtils().getPagView(context);
        this.pagView = pagView;
        if (pagView != null) {
            pagView.setPagFile(R.raw.f130982);
        }
        FrameLayout frameLayout = inflate.vasSquareLikeAnimationContainer;
        ISquarePagView iSquarePagView = this.pagView;
        frameLayout.addView(iSquarePagView != null ? iSquarePagView.getView() : null, new RelativeLayout.LayoutParams(-1, -1));
        ISquarePagView iSquarePagView2 = this.pagView;
        if (iSquarePagView2 != null) {
            iSquarePagView2.setPagViewListener(this);
        }
        ISquarePagView iSquarePagView3 = this.pagView;
        if (iSquarePagView3 != null) {
            iSquarePagView3.setPagFileHandler(this);
        }
        ISquarePagView iSquarePagView4 = this.pagView;
        if (iSquarePagView4 != null) {
            iSquarePagView4.playPag(1);
        }
        ISquarePagView iSquarePagView5 = this.pagView;
        if (iSquarePagView5 != null && (view = iSquarePagView5.getView()) != null) {
            view.setVisibility(0);
        }
        setOutsideTouchable(false);
        setFocusable(false);
        setBackgroundDrawable(new ColorDrawable(0));
        if (z16) {
            getContentView().postDelayed(this.timeOutDismissRunnable, 2500L);
        }
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationRepeat(ISquarePagView squarePagView) {
    }

    @Override // com.tencent.state.square.api.ISquarePagViewListener
    public void onAnimationStart(ISquarePagView squarePagView) {
    }
}
