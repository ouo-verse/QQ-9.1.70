package com.tencent.timi.game.liveroom.impl.room.batchgift.view;

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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b*\u0010+B\u001d\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b*\u0010.B%\b\u0016\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010/\u001a\u00020\u0003\u00a2\u0006\u0004\b*\u00100J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0005J\"\u0010\u0017\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\"\u0010\u001b\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010%R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010(\u00a8\u00061"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "", "position", "", "g", "k", "Landroid/content/Context;", "context", "", "i", h.F, "Lcom/tencent/mobileqq/qqgift/data/service/d;", "data", "j", "listener", "setItemClickListener", "f", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/a;", "batchBean", "", "curComboSeq", "e", "a", "b", "d", "c", "Lcom/tencent/timi/game/liveroom/impl/room/batchgift/view/BatchGiftItemView$a;", "itemListener", "", "Ljava/util/List;", "batchGiftList", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "multiGiftLayout", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "multiGiftContainer", "Landroid/widget/HorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "multiGiftScrollView", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class BatchGiftView extends RelativeLayout implements BatchGiftItemView.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BatchGiftItemView.a itemListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<a> batchGiftList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout multiGiftLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout multiGiftContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HorizontalScrollView multiGiftScrollView;

    public BatchGiftView(@Nullable Context context) {
        super(context);
        View.inflate(getContext(), R.layout.ha9, this);
        View findViewById = findViewById(R.id.zhn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.multiGiftLayout)");
        this.multiGiftLayout = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.zho);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.multiGiftScrollView)");
        this.multiGiftScrollView = (HorizontalScrollView) findViewById2;
        View findViewById3 = findViewById(R.id.zhm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.multiGiftContainer)");
        this.multiGiftContainer = (LinearLayout) findViewById3;
    }

    private final void g(int position) {
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
                    batchGiftItemView.k();
                }
            }
        }
    }

    private final boolean i(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private final void k() {
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

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void a(@Nullable a batchBean, int position) {
        g(position);
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            aVar.a(batchBean, position);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void b(@Nullable a batchBean, int position) {
        k();
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            aVar.b(batchBean, position);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void c(@Nullable a batchBean, long curComboSeq, int position) {
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            aVar.c(batchBean, curComboSeq, position);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public void d(@Nullable a batchBean, int position) {
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            aVar.d(batchBean, position);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.batchgift.view.BatchGiftItemView.a
    public boolean e(@Nullable a batchBean, long curComboSeq, int position) {
        BatchGiftItemView.a aVar = this.itemListener;
        if (aVar != null) {
            return aVar.e(batchBean, curComboSeq, position);
        }
        return false;
    }

    public final void f() {
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
                    batchGiftItemView.k();
                }
            }
        }
    }

    public final void h() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (i(context)) {
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

    public final void j(@NotNull d data) {
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
                arrayList.add(new a(j3, j16, str, aVar.f264888d));
            }
            this.batchGiftList = arrayList;
            this.multiGiftScrollView.scrollTo(0, 0);
            this.multiGiftContainer.removeAllViews();
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                BatchGiftItemView batchGiftItemView = new BatchGiftItemView(context);
                batchGiftItemView.e(i3, (a) arrayList.get(i3));
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
        View.inflate(getContext(), R.layout.ha9, this);
        View findViewById = findViewById(R.id.zhn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.multiGiftLayout)");
        this.multiGiftLayout = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.zho);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.multiGiftScrollView)");
        this.multiGiftScrollView = (HorizontalScrollView) findViewById2;
        View findViewById3 = findViewById(R.id.zhm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.multiGiftContainer)");
        this.multiGiftContainer = (LinearLayout) findViewById3;
    }

    public BatchGiftView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View.inflate(getContext(), R.layout.ha9, this);
        View findViewById = findViewById(R.id.zhn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.multiGiftLayout)");
        this.multiGiftLayout = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.zho);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.multiGiftScrollView)");
        this.multiGiftScrollView = (HorizontalScrollView) findViewById2;
        View findViewById3 = findViewById(R.id.zhm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.multiGiftContainer)");
        this.multiGiftContainer = (LinearLayout) findViewById3;
    }
}
