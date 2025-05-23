package com.tencent.timi.game.liveroom.impl.room.batchgift.view;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00014\u0018\u00002\u00020\u0001:\u0001AB\u0011\b\u0016\u0012\u0006\u00109\u001a\u000208\u00a2\u0006\u0004\b:\u0010;B\u001b\b\u0016\u0012\u0006\u00109\u001a\u000208\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u00a2\u0006\u0004\b:\u0010>B#\b\u0016\u0012\u0006\u00109\u001a\u000208\u0012\b\u0010=\u001a\u0004\u0018\u00010<\u0012\u0006\u0010?\u001a\u00020\u0002\u00a2\u0006\u0004\b:\u0010@J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010#R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006B"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView;", "Landroid/widget/FrameLayout;", "", "width", "height", "", "layoutCenterW", "layoutCenterH", "", h.F, "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "batchGiftComboListener", "setListener", "target", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/a;", "giftItem", "e", "", "needHint", IECSearchBar.METHOD_SET_HINT, "j", "k", "i", "Lorg/libpag/PAGFile;", "d", "Lorg/libpag/PAGFile;", "pagFile", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/a;", "curBatchData", "f", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "listener", "", "J", "curComboSeq", "I", "selfTarget", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "pagInited", "Lorg/libpag/PAGView;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "g", "()Lorg/libpag/PAGView;", "batchAnimView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "batchGiftDesc", "E", "batchGiftNum", "com/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$b", UserInfo.SEX_FEMALE, "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$b;", "pagListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class BatchGiftItemView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy batchAnimView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView batchGiftDesc;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView batchGiftNum;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b pagListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGFile pagFile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.liveroom.impl.room.batchgift.view.a curBatchData;

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
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/a;", "batchBean", "", "curComboSeq", "", "position", "", "e", "", "a", "b", "d", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, int position);

        void b(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, int position);

        void c(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, long curComboSeq, int position);

        void d(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, int position);

        boolean e(@Nullable com.tencent.timi.game.liveroom.impl.room.batchgift.view.a batchBean, long curComboSeq, int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchGiftItemView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.selfTarget = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PAGView>() { // from class: com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView$batchAnimView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PAGView invoke() {
                return (PAGView) BatchGiftItemView.this.findViewById(R.id.t5_);
            }
        });
        this.batchAnimView = lazy;
        View.inflate(getContext(), R.layout.ha8, this);
        View findViewById = findViewById(R.id.t5a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.batchGiftDesc)");
        this.batchGiftDesc = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.t5b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.batchGiftNum)");
        this.batchGiftNum = (TextView) findViewById2;
        this.pagListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(BatchGiftItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
        this$0.performHapticFeedback(6, 2);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final PAGView g() {
        Object value = this.batchAnimView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-batchAnimView>(...)");
        return (PAGView) value;
    }

    private final void h(int width, int height, float layoutCenterW, float layoutCenterH) {
        Matrix matrix;
        ViewGroup.LayoutParams layoutParams = g().getLayoutParams();
        layoutParams.width = q.a(getContext(), 4.0f) + width;
        layoutParams.height = q.a(getContext(), 4.0f) + height;
        g().setLayoutParams(layoutParams);
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
        g().setScaleMode(3);
        this.pagInited = true;
    }

    public final void e(int target, @NotNull com.tencent.timi.game.liveroom.impl.room.batchgift.view.a giftItem) {
        Intrinsics.checkNotNullParameter(giftItem, "giftItem");
        this.selfTarget = target;
        this.curBatchData = giftItem;
        this.batchGiftNum.setText("\u9001" + giftItem.getGiftNum() + "\u4e2a");
        this.batchGiftDesc.setText(giftItem.getGiftDesc());
        setAlpha(1.0f);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.batchgift.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BatchGiftItemView.f(BatchGiftItemView.this, view);
            }
        });
    }

    public final void i() {
        g().setComposition(null);
        this.curComboSeq = 0L;
    }

    public final void j() {
        if (!this.pagInited) {
            h(getWidth(), getHeight(), g().getWidth() / 2.0f, g().getHeight() / 2.0f);
        }
        if (g().isPlaying()) {
            g().setProgress(0.2d);
            a aVar = this.listener;
            if (aVar != null) {
                aVar.c(this.curBatchData, this.curComboSeq, this.selfTarget);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.curComboSeq = currentTimeMillis;
        a aVar2 = this.listener;
        boolean z16 = false;
        if (aVar2 != null && aVar2.e(this.curBatchData, currentTimeMillis, this.selfTarget)) {
            z16 = true;
        }
        if (z16) {
            a aVar3 = this.listener;
            if (aVar3 != null) {
                aVar3.c(this.curBatchData, this.curComboSeq, this.selfTarget);
                return;
            }
            return;
        }
        g().setComposition(this.pagFile);
        g().setRepeatCount(1);
        g().removeListener(this.pagListener);
        g().addListener(this.pagListener);
        g().setProgress(0.1d);
        g().play();
        a aVar4 = this.listener;
        if (aVar4 != null) {
            aVar4.c(this.curBatchData, this.curComboSeq, this.selfTarget);
        }
    }

    public final void k() {
        g().stop();
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
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.selfTarget = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PAGView>() { // from class: com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView$batchAnimView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PAGView invoke() {
                return (PAGView) BatchGiftItemView.this.findViewById(R.id.t5_);
            }
        });
        this.batchAnimView = lazy;
        View.inflate(getContext(), R.layout.ha8, this);
        View findViewById = findViewById(R.id.t5a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.batchGiftDesc)");
        this.batchGiftDesc = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.t5b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.batchGiftNum)");
        this.batchGiftNum = (TextView) findViewById2;
        this.pagListener = new b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BatchGiftItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.selfTarget = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PAGView>() { // from class: com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView$batchAnimView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PAGView invoke() {
                return (PAGView) BatchGiftItemView.this.findViewById(R.id.t5_);
            }
        });
        this.batchAnimView = lazy;
        View.inflate(getContext(), R.layout.ha8, this);
        View findViewById = findViewById(R.id.t5a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.batchGiftDesc)");
        this.batchGiftDesc = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.t5b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.batchGiftNum)");
        this.batchGiftNum = (TextView) findViewById2;
        this.pagListener = new b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$b", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "pagView", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "p0", "onAnimationRepeat", "onAnimationUpdate", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements PAGView.PAGViewListener {
        b() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView pagView) {
            if (pagView != null) {
                pagView.setVisibility(4);
            }
            a aVar = BatchGiftItemView.this.listener;
            if (aVar != null) {
                aVar.d(BatchGiftItemView.this.curBatchData, BatchGiftItemView.this.selfTarget);
            }
            BatchGiftItemView.this.i();
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView pagView) {
            if (pagView != null) {
                pagView.setVisibility(4);
            }
            a aVar = BatchGiftItemView.this.listener;
            if (aVar != null) {
                aVar.b(BatchGiftItemView.this.curBatchData, BatchGiftItemView.this.selfTarget);
            }
            BatchGiftItemView.this.i();
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView pagView) {
            if (pagView != null) {
                pagView.setVisibility(0);
            }
            a aVar = BatchGiftItemView.this.listener;
            if (aVar != null) {
                aVar.a(BatchGiftItemView.this.curBatchData, BatchGiftItemView.this.selfTarget);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}
