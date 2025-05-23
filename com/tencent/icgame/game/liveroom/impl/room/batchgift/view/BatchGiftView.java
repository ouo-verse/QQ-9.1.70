package com.tencent.icgame.game.liveroom.impl.room.batchgift.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xv0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b+\u0010,B\u001d\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b+\u0010/B%\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u00100\u001a\u00020\u0003\u00a2\u0006\u0004\b+\u00101J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0005J\u001a\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u001a\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010!R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00062"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "", "position", "", "f", "j", "Landroid/content/Context;", "context", "", h.F, "g", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "i", "listener", "setItemClickListener", "e", "Lxv0/a;", "batchBean", "d", "c", "a", "", "curComboSeq", "b", "Lcom/tencent/icgame/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "itemListener", "", "Ljava/util/List;", "batchGiftList", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "rootLayout", "multiGiftLayout", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "multiGiftContainer", "Landroid/widget/HorizontalScrollView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/HorizontalScrollView;", "multiGiftScrollView", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class BatchGiftView extends RelativeLayout implements BatchGiftItemView.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BatchGiftItemView.a itemListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<a> batchGiftList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout rootLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout multiGiftLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout multiGiftContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HorizontalScrollView multiGiftScrollView;

    public BatchGiftView(@Nullable Context context) {
        super(context);
        View inflate = View.inflate(getContext(), R.layout.fas, this);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.rootLayout = frameLayout;
        View findViewById = frameLayout.findViewById(R.id.zhn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootLayout.findViewById(R.id.multiGiftLayout)");
        this.multiGiftLayout = (FrameLayout) findViewById;
        View findViewById2 = frameLayout.findViewById(R.id.zho);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootLayout.findViewById(R.id.multiGiftScrollView)");
        this.multiGiftScrollView = (HorizontalScrollView) findViewById2;
        View findViewById3 = frameLayout.findViewById(R.id.zhm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootLayout.findViewById(R.id.multiGiftContainer)");
        this.multiGiftContainer = (LinearLayout) findViewById3;
    }

    private final void f(int position) {
        boolean z16;
        List<a> list;
        boolean z17;
        List<a> list2 = this.batchGiftList;
        if (list2 != null && list2.size() == this.multiGiftContainer.getChildCount()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (list = this.batchGiftList) != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                BatchGiftItemView batchGiftItemView = (BatchGiftItemView) this.multiGiftContainer.getChildAt(i3);
                if (batchGiftItemView != null) {
                    if (position != i3) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    batchGiftItemView.setHint(z17);
                }
                if (position != i3 && batchGiftItemView != null) {
                    batchGiftItemView.j();
                }
            }
        }
    }

    private final boolean h(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private final void j() {
        boolean z16;
        List<a> list;
        List<a> list2 = this.batchGiftList;
        if (list2 != null && list2.size() == this.multiGiftContainer.getChildCount()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (list = this.batchGiftList) != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                BatchGiftItemView batchGiftItemView = (BatchGiftItemView) this.multiGiftContainer.getChildAt(i3);
                if (batchGiftItemView != null) {
                    batchGiftItemView.setHint(false);
                }
            }
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void a(@Nullable a batchBean, int position) {
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            aVar.a(batchBean, position);
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void b(@Nullable a batchBean, long curComboSeq, int position) {
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            aVar.b(batchBean, curComboSeq, position);
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void c(@Nullable a batchBean, int position) {
        j();
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            aVar.c(batchBean, position);
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void d(@Nullable a batchBean, int position) {
        f(position);
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            aVar.d(batchBean, position);
        }
    }

    public final void e() {
        boolean z16;
        List<a> list;
        List<a> list2 = this.batchGiftList;
        if (list2 != null && list2.size() == this.multiGiftContainer.getChildCount()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (list = this.batchGiftList) != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                BatchGiftItemView batchGiftItemView = (BatchGiftItemView) this.multiGiftContainer.getChildAt(i3);
                if (batchGiftItemView != null) {
                    batchGiftItemView.setHint(false);
                }
                if (batchGiftItemView != null) {
                    batchGiftItemView.j();
                }
            }
        }
    }

    public final void g() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (h(context)) {
            ViewGroup.LayoutParams layoutParams = this.multiGiftLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = ViewUtils.dpToPx(102.0f);
            }
            this.multiGiftLayout.setBackgroundColor(0);
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = this.multiGiftLayout.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = ViewUtils.dpToPx(45.0f);
        }
        this.multiGiftLayout.setBackgroundColor(Color.parseColor("#181912"));
    }

    public final void i(@NotNull d data) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(data, "data");
        List<d.a> list = data.P;
        if (list != null && list.size() != 0) {
            List<d.a> list2 = data.P;
            Intrinsics.checkNotNullExpressionValue(list2, "data.batchGiftList");
            List<d.a> list3 = list2;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (d.a aVar : list3) {
                long j3 = aVar.f264885a;
                long j16 = aVar.f264886b;
                String str = aVar.f264887c;
                Intrinsics.checkNotNullExpressionValue(str, "batchOriginObject.msg");
                arrayList.add(new a(j3, j16, str));
            }
            this.batchGiftList = arrayList;
            this.multiGiftScrollView.scrollTo(0, 0);
            this.multiGiftContainer.removeAllViews();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                BatchGiftItemView batchGiftItemView = new BatchGiftItemView(context);
                batchGiftItemView.c(i3, (a) arrayList.get(i3));
                batchGiftItemView.setListener(this);
                this.multiGiftContainer.addView(batchGiftItemView);
            }
        }
    }

    public final void setItemClickListener(@NotNull BatchGiftItemView.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.itemListener = listener;
    }

    public BatchGiftView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), R.layout.fas, this);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.rootLayout = frameLayout;
        View findViewById = frameLayout.findViewById(R.id.zhn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootLayout.findViewById(R.id.multiGiftLayout)");
        this.multiGiftLayout = (FrameLayout) findViewById;
        View findViewById2 = frameLayout.findViewById(R.id.zho);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootLayout.findViewById(R.id.multiGiftScrollView)");
        this.multiGiftScrollView = (HorizontalScrollView) findViewById2;
        View findViewById3 = frameLayout.findViewById(R.id.zhm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootLayout.findViewById(R.id.multiGiftContainer)");
        this.multiGiftContainer = (LinearLayout) findViewById3;
    }

    public BatchGiftView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View inflate = View.inflate(getContext(), R.layout.fas, this);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.rootLayout = frameLayout;
        View findViewById = frameLayout.findViewById(R.id.zhn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootLayout.findViewById(R.id.multiGiftLayout)");
        this.multiGiftLayout = (FrameLayout) findViewById;
        View findViewById2 = frameLayout.findViewById(R.id.zho);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootLayout.findViewById(R.id.multiGiftScrollView)");
        this.multiGiftScrollView = (HorizontalScrollView) findViewById2;
        View findViewById3 = frameLayout.findViewById(R.id.zhm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootLayout.findViewById(R.id.multiGiftContainer)");
        this.multiGiftContainer = (LinearLayout) findViewById3;
    }
}
