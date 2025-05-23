package com.tencent.mobileqq.troop.homework.clockin.detail.widget.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002)*BN\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R4\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/HWDateRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "dateInfo", "", UserInfo.SEX_FEMALE, "", "list", "G", "H", "Landroid/graphics/Canvas;", PM.CANVAS, "onDrawForeground", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "info", "f", "Lkotlin/jvm/functions/Function1;", "getClickEventCallback", "()Lkotlin/jvm/functions/Function1;", "clickEventCallback", "Landroid/graphics/Paint;", h.F, "Lkotlin/Lazy;", "E", "()Landroid/graphics/Paint;", "dividerPaint", "", "i", "Z", "isNeedScrollToCenter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILkotlin/jvm/functions/Function1;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWDateRecyclerView extends RecyclerView {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, Unit> clickEventCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dividerPaint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedScrollToCenter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/HWDateRecyclerView$a;", "", "", "RECYCLER_ITEM_WIDTH_DP", "I", "RECYCLER_VIEW_HEIGHT_DP", "RECYCLER_VIEW_LEFT_RIGHT_SPACE_DP", "RECYCLER_VIEW_TOP_MARGIN_DP", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.HWDateRecyclerView$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/HWDateRecyclerView$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spaceWidth", "<init>", "(I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int spaceWidth;

        public b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.spaceWidth = i3;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = this.spaceWidth;
            }
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null && childAdapterPosition == adapter.getItemCount() - 1) {
                outRect.right = this.spaceWidth;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWDateRecyclerView(@NotNull Context context) {
        this(context, null, 0, null, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
    }

    private final Paint E() {
        return (Paint) this.dividerPaint.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a dateInfo) {
        com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b bVar;
        boolean z16;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b) {
            bVar = (com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b) adapter;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        List<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a> currentList = bVar.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        int i3 = 0;
        for (Object obj : currentList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar = (com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a) obj;
            if (aVar.f() == dateInfo.f()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (!aVar.g()) {
                    aVar.j(true);
                    bVar.notifyItemChanged(i3);
                }
            } else if (!z16 && aVar.g()) {
                aVar.j(false);
                bVar.notifyItemChanged(i3);
            }
            i3 = i16;
        }
        Function1<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, Unit> function1 = this.clickEventCallback;
        if (function1 != null) {
            function1.invoke(dateInfo);
        }
    }

    private final void G(List<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a> list) {
        Iterable<IndexedValue> withIndex;
        int b16 = l.b(56);
        int screenWidth = (ImmersiveUtils.getScreenWidth() - b16) / 2;
        withIndex = CollectionsKt___CollectionsKt.withIndex(list);
        int i3 = 0;
        for (IndexedValue indexedValue : withIndex) {
            if (((com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a) indexedValue.getValue()).g()) {
                i3 = indexedValue.getIndex();
            }
        }
        int b17 = ((i3 * b16) - screenWidth) + l.b(6);
        if (b17 > 0) {
            scrollBy(b17, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(HWDateRecyclerView this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        if (this$0.isNeedScrollToCenter) {
            this$0.isNeedScrollToCenter = false;
            this$0.G(list);
        }
    }

    public final void H(@NotNull final List<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a> list) {
        com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(list, "list");
        setVisibility(0);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b) {
            bVar = (com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b) adapter;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.submitList(list);
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.a
            @Override // java.lang.Runnable
            public final void run() {
                HWDateRecyclerView.I(HWDateRecyclerView.this, list);
            }
        });
    }

    @Override // android.view.View
    public void onDrawForeground(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDrawForeground(canvas);
        float height = getHeight() - (E().getStrokeWidth() / 2);
        float width = getWidth();
        if (canvas != null) {
            canvas.drawLine(0.0f, height, width, height, E());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWDateRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWDateRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, context, attributeSet, Integer.valueOf(i3));
    }

    public /* synthetic */ HWDateRecyclerView(Context context, AttributeSet attributeSet, int i3, Function1 function1, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) == 0 ? function1 : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), function1, Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWDateRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @Nullable Function1<? super com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, Unit> function1) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), function1);
            return;
        }
        this.clickEventCallback = function1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.HWDateRecyclerView$dividerPaint$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDateRecyclerView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Paint invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Paint) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Paint paint = new Paint();
                HWDateRecyclerView hWDateRecyclerView = HWDateRecyclerView.this;
                paint.setStrokeWidth(ViewUtils.dip2px(0.5f));
                paint.setColor(hWDateRecyclerView.getResources().getColor(R.color.qui_common_border_standard));
                return paint;
            }
        });
        this.dividerPaint = lazy;
        this.isNeedScrollToCenter = true;
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, l.b(72));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = l.b(12);
        setLayoutParams(layoutParams);
        setBackground(ContextCompat.getDrawable(context, R.drawable.qui_common_bg_bottom_light_bg));
        setItemAnimator(null);
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        setAdapter(new com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.adapter.b(new Function1<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.HWDateRecyclerView.2
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDateRecyclerView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    HWDateRecyclerView.this.F(it);
                }
            }
        }));
        setOverScrollMode(2);
        addItemDecoration(new b(l.b(6)));
        setVisibility(8);
    }
}
