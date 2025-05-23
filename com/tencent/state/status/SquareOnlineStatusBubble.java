package com.tencent.state.status;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.avatar.IAvatarAnimView;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareStatusBubbleBinding;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.square.media.SquarePlayerPool;
import com.tencent.state.view.BubbleBgDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusBubble;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "resource", "Lcom/tencent/state/square/media/MediaSource;", "pool", "Lcom/tencent/state/square/media/SquarePlayerPool;", "(Landroid/content/Context;Lcom/tencent/state/square/media/MediaSource;Lcom/tencent/state/square/media/SquarePlayerPool;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareStatusBubbleBinding;", "bubblePagView", "Lcom/tencent/state/square/api/ISquarePagView;", "initAvatarView", "", "initPagView", "makeDropDownMeasureSpec", "", "measureSpec", "updateBubbleBg", "positionX", "isLeft", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusBubble extends PopupWindow {
    private static final int HEIGHT_DP = 160;
    private static final int WIDTH_DP = 150;
    private final VasSquareStatusBubbleBinding binding;
    private ISquarePagView bubblePagView;
    private final Context context;
    private final SquarePlayerPool pool;
    private final MediaSource resource;

    public SquareOnlineStatusBubble(Context context, MediaSource resource, SquarePlayerPool pool) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.context = context;
        this.resource = resource;
        this.pool = pool;
        VasSquareStatusBubbleBinding inflate = VasSquareStatusBubbleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareStatusBubbleBin\u2026utInflater.from(context))");
        this.binding = inflate;
        setHeight(ViewExtensionsKt.dip(context, 160));
        setWidth(ViewExtensionsKt.dip(context, 150));
        setOutsideTouchable(true);
        setFocusable(true);
        initPagView();
        initAvatarView();
    }

    private final void initAvatarView() {
        this.binding.avatarView.setLoopPlay(true);
        this.binding.avatarView.setConfig(new AvatarAnimConfig(true, this.pool, null, false, 12, null));
        IAvatarAnimView.DefaultImpls.setAnimSource$default(this.binding.avatarView, new MapPlayableSource(this.resource, 0, null, null, 14, null), new IAvatarAnimListener() { // from class: com.tencent.state.status.SquareOnlineStatusBubble$initAvatarView$1
            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onFirstFrame() {
                ISquarePagView iSquarePagView;
                View view;
                iSquarePagView = SquareOnlineStatusBubble.this.bubblePagView;
                if (iSquarePagView == null || (view = iSquarePagView.getView()) == null) {
                    return;
                }
                view.setVisibility(8);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayEnd() {
                IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayError(int i3) {
                IAvatarAnimListener.DefaultImpls.onPlayError(this, i3);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onPlayStart() {
                IAvatarAnimListener.DefaultImpls.onPlayStart(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onRemovedListener() {
                IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticFailed() {
                IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
            }

            @Override // com.tencent.state.square.avatar.IAvatarAnimListener
            public void onStaticSuccess() {
                IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
            }
        }, false, 4, null);
        setContentView(this.binding.getMRv());
        getContentView().measure(makeDropDownMeasureSpec(getWidth()), makeDropDownMeasureSpec(getHeight()));
    }

    private final void initPagView() {
        View view;
        ISquarePagView pagView = Square.INSTANCE.getConfig().getCommonUtils().getPagView(this.context);
        this.bubblePagView = pagView;
        if (pagView != null) {
            pagView.setPagFile(R.raw.f131015);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewExtensionsKt.dip(this.context, 27), ViewExtensionsKt.dip(this.context, 27));
        layoutParams.addRule(13);
        RelativeLayout mRv = this.binding.getMRv();
        ISquarePagView iSquarePagView = this.bubblePagView;
        mRv.addView(iSquarePagView != null ? iSquarePagView.getView() : null, layoutParams);
        ISquarePagView iSquarePagView2 = this.bubblePagView;
        if (iSquarePagView2 != null) {
            ISquarePagView.DefaultImpls.playPag$default(iSquarePagView2, 0, 1, null);
        }
        ISquarePagView iSquarePagView3 = this.bubblePagView;
        if (iSquarePagView3 == null || (view = iSquarePagView3.getView()) == null) {
            return;
        }
        view.setVisibility(0);
    }

    public final void updateBubbleBg(int positionX, boolean isLeft) {
        SquareAvatarView squareAvatarView = this.binding.avatarView;
        float dip = ViewExtensionsKt.dip(squareAvatarView.getContext(), 11.0f);
        float dip2 = ViewExtensionsKt.dip(squareAvatarView.getContext(), 9.0f);
        if (!isLeft) {
            positionX = ViewExtensionsKt.dip(squareAvatarView.getContext(), 150) - positionX;
        }
        squareAvatarView.setBackground(new BubbleBgDrawable(-1, dip, dip2, Integer.valueOf(positionX), false, 16, null));
    }

    private final int makeDropDownMeasureSpec(int measureSpec) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), measureSpec == -2 ? 0 : 1073741824);
    }
}
