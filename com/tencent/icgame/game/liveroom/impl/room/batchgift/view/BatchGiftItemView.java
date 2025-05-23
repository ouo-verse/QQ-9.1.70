package com.tencent.icgame.game.liveroom.impl.room.batchgift.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001BB\u0011\b\u0016\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<B\u001b\b\u0016\u0012\u0006\u0010:\u001a\u000209\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u00a2\u0006\u0004\b;\u0010?B#\b\u0016\u0012\u0006\u0010:\u001a\u000209\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\u0006\u0010@\u001a\u00020\u0003\u00a2\u0006\u0004\b;\u0010AJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\tJ\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\tJ\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010)R\u0016\u0010,\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010+R\u0016\u0010/\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00105\u00a8\u0006C"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftItemView;", "Landroid/widget/FrameLayout;", "Lorg/libpag/PAGView$PAGViewListener;", "", "width", "height", "", "layoutCenterW", "layoutCenterH", "", "f", "Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "batchGiftComboListener", "setListener", "target", "Lxv0/a;", "giftItem", "c", "", "needHint", IECSearchBar.METHOD_SET_HINT, "i", "j", h.F, "Lorg/libpag/PAGView;", "pagView", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "Lorg/libpag/PAGFile;", "d", "Lorg/libpag/PAGFile;", "pagFile", "e", "Lxv0/a;", "curBatchData", "Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "listener", "", "J", "curComboSeq", "I", "selfTarget", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "pagInited", BdhLogUtil.LogTag.Tag_Conn, "Lorg/libpag/PAGView;", "batchAnimView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "batchGiftDesc", "E", "batchGiftNum", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class BatchGiftItemView extends FrameLayout implements PAGView.PAGViewListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final PAGView batchAnimView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView batchGiftDesc;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView batchGiftNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGFile pagFile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private xv0.a curBatchData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a listener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long curComboSeq;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int selfTarget;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean pagInited;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "", "Lxv0/a;", "batchBean", "", "position", "", "d", "c", "a", "", "curComboSeq", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface a {
        void a(@Nullable xv0.a batchBean, int position);

        void b(@Nullable xv0.a batchBean, long curComboSeq, int position);

        void c(@Nullable xv0.a batchBean, int position);

        void d(@Nullable xv0.a batchBean, int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchGiftItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selfTarget = -1;
        View.inflate(getContext(), R.layout.far, this);
        View findViewById = findViewById(R.id.t5a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.batchGiftDesc)");
        this.batchGiftDesc = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.t5b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.batchGiftNum)");
        this.batchGiftNum = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.t5_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.batchAnimView)");
        this.batchAnimView = (PAGView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(BatchGiftItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        this$0.performHapticFeedback(6, 2);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void f(int width, int height, float layoutCenterW, float layoutCenterH) {
        Matrix matrix;
        ViewGroup.LayoutParams layoutParams = this.batchAnimView.getLayoutParams();
        layoutParams.width = t42.h.a(getContext(), 4.0f) + width;
        layoutParams.height = t42.h.a(getContext(), 4.0f) + height;
        this.batchAnimView.setLayoutParams(layoutParams);
        PAGFile Load = PagViewMonitor.Load(BaseApplication.getContext().getResources().getAssets(), "pag/tg_batch_anim.pag");
        PAGFile pAGFile = this.pagFile;
        if (pAGFile != null) {
            matrix = pAGFile.getTotalMatrix();
        } else {
            matrix = null;
        }
        float width2 = ((width * 1.0f) / Load.width()) * 2.0f;
        float height2 = ((height * 1.0f) / Load.height()) * 2.0f;
        if (matrix != null) {
            matrix.setScale(width2, height2, layoutCenterW, layoutCenterH);
        }
        Load.setMatrix(matrix);
        this.pagFile = Load;
        this.batchAnimView.addListener(this);
        this.batchAnimView.setScaleMode(3);
        this.pagInited = true;
    }

    public final void c(int target, @NotNull xv0.a giftItem) {
        Intrinsics.checkNotNullParameter(giftItem, "giftItem");
        this.selfTarget = target;
        this.curBatchData = giftItem;
        this.batchGiftNum.setText("\u9001" + giftItem.getGiftNum() + "\u4e2a");
        this.batchGiftDesc.setText(giftItem.getGiftDesc());
        setAlpha(1.0f);
        setOnClickListener(new View.OnClickListener() { // from class: xv0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BatchGiftItemView.d(BatchGiftItemView.this, view);
            }
        });
    }

    public final void h() {
        this.batchAnimView.setComposition(null);
        this.curComboSeq = 0L;
    }

    public final void i() {
        if (!this.pagInited) {
            f(getWidth(), getHeight(), this.batchAnimView.getWidth() / 2.0f, this.batchAnimView.getHeight() / 2.0f);
        }
        if (this.batchAnimView.isPlaying()) {
            this.batchAnimView.setProgress(0.2d);
        } else {
            this.batchAnimView.setComposition(this.pagFile);
            this.batchAnimView.setRepeatCount(1);
            this.batchAnimView.setProgress(0.1d);
            this.batchAnimView.play();
            this.curComboSeq = System.currentTimeMillis();
        }
        a aVar = this.listener;
        if (aVar != null) {
            aVar.b(this.curBatchData, this.curComboSeq, this.selfTarget);
        }
    }

    public final void j() {
        this.batchAnimView.stop();
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationCancel(@Nullable PAGView pagView) {
        if (pagView != null) {
            pagView.setVisibility(4);
        }
        a aVar = this.listener;
        if (aVar != null) {
            aVar.a(this.curBatchData, this.selfTarget);
        }
        h();
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationEnd(@Nullable PAGView pagView) {
        if (pagView != null) {
            pagView.setVisibility(4);
        }
        a aVar = this.listener;
        if (aVar != null) {
            aVar.c(this.curBatchData, this.selfTarget);
        }
        h();
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationStart(@Nullable PAGView pagView) {
        if (pagView != null) {
            pagView.setVisibility(0);
        }
        a aVar = this.listener;
        if (aVar != null) {
            aVar.d(this.curBatchData, this.selfTarget);
        }
    }

    public final void setHint(boolean needHint) {
        float f16;
        if (needHint) {
            f16 = 0.5f;
        } else {
            f16 = 1.0f;
        }
        setAlpha(f16);
    }

    public final void setListener(@Nullable a batchGiftComboListener) {
        this.listener = batchGiftComboListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchGiftItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selfTarget = -1;
        View.inflate(getContext(), R.layout.far, this);
        View findViewById = findViewById(R.id.t5a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.batchGiftDesc)");
        this.batchGiftDesc = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.t5b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.batchGiftNum)");
        this.batchGiftNum = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.t5_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.batchAnimView)");
        this.batchAnimView = (PAGView) findViewById3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchGiftItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selfTarget = -1;
        View.inflate(getContext(), R.layout.far, this);
        View findViewById = findViewById(R.id.t5a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.batchGiftDesc)");
        this.batchGiftDesc = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.t5b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.batchGiftNum)");
        this.batchGiftNum = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.t5_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.batchAnimView)");
        this.batchAnimView = (PAGView) findViewById3;
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationRepeat(@Nullable PAGView pagView) {
    }

    @Override // org.libpag.PAGView.PAGViewListener
    public void onAnimationUpdate(@Nullable PAGView pagView) {
    }
}
