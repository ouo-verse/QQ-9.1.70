package com.tencent.aelight.camera.ae.flashshow.ui.panel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.camera.ui.panel.bj;
import com.tencent.aelight.camera.ae.camera.ui.panel.bk;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0002\u0016\u001aB)\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\fJ\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\u0004R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder;", "", "", "position", "", "e", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "data", "j", "", "id", "", "scrollTarget", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "scrollToTarget", "c", "smoothly", "g", "i", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder$b;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder$b;", "listener", "d", "I", "rightBeautyBtnLocation", "Landroid/support/v7/widget/RecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/c;", "f", "Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/c;", "adapter", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "Landroid/support/v7/widget/RecyclerView$SmoothScroller;", "scroller", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder$b;I)V", tl.h.F, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class LSEffectListHolder {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ViewGroup container;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final b listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int rightBeautyBtnLocation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final c adapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final RecyclerView.SmoothScroller scroller;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder$a;", "", "", "Landroid/content/Context;", "context", "", "b", "LIST_HORIZONTAL_PADDING_DP", UserInfo.SEX_FEMALE, "LIST_ITEM_SPACE_DP", "LIST_TOP_MARGIN_DP", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.ui.panel.LSEffectListHolder$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(float f16, Context context) {
            return (int) TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/panel/LSEffectListHolder$b;", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface b {
        void b(bj item, int position);
    }

    public LSEffectListHolder(Context context, ViewGroup container, b listener, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.container = container;
        this.listener = listener;
        this.rightBeautyBtnLocation = i3;
        Companion companion = INSTANCE;
        int b16 = companion.b(17.0f, context);
        int b17 = companion.b(0.0f, context);
        this.scroller = new a(context);
        RecyclerView recyclerView = new RecyclerView(context);
        this.recyclerView = recyclerView;
        recyclerView.setPadding(b16, 0, b16, 0);
        recyclerView.setClipToPadding(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        c cVar = new c(context, i3, new Function3<View, bj, Integer, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.LSEffectListHolder.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(View view, bj bjVar, Integer num) {
                invoke(view, bjVar, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(View view, bj item, int i16) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(item, "item");
                LSEffectListHolder.this.listener.b(item, i16);
            }
        });
        this.adapter = cVar;
        recyclerView.setAdapter(cVar);
        recyclerView.addItemDecoration(new ae(companion.b(12.0f, context)));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = b17;
        container.addView(recyclerView, marginLayoutParams);
    }

    private final void e(final int position) {
        this.recyclerView.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.panel.aa
            @Override // java.lang.Runnable
            public final void run() {
                LSEffectListHolder.f(LSEffectListHolder.this, position);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LSEffectListHolder this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scroller.setTargetPosition(i3);
        this$0.recyclerView.getLayoutManager().startSmoothScroll(this$0.scroller);
    }

    public final void c(boolean scrollToTarget) {
        this.adapter.notifyDataSetChanged();
        if (scrollToTarget) {
            bj selectItem = this.adapter.getSelectItem();
            g(selectItem != null ? selectItem.getId() : null, false);
        }
    }

    public final void i() {
        bj selectItem = this.adapter.getSelectItem();
        h(this, selectItem != null ? selectItem.getId() : null, false, 2, null);
    }

    public final void j(List<? extends bj> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.adapter.setData(data);
        this.adapter.notifyDataSetChanged();
    }

    public final void k(String id5, boolean scrollTarget) {
        Object obj;
        bj selectItem = this.adapter.getSelectItem();
        if (Intrinsics.areEqual(id5, selectItem != null ? selectItem.getId() : null)) {
            return;
        }
        c cVar = this.adapter;
        Iterator<T> it = cVar.q().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((bj) obj).getId(), id5)) {
                    break;
                }
            }
        }
        cVar.v((bj) obj);
        this.adapter.notifyDataSetChanged();
        if (scrollTarget) {
            bj selectItem2 = this.adapter.getSelectItem();
            h(this, selectItem2 != null ? selectItem2.getId() : null, false, 2, null);
        }
    }

    public final void m() {
        if ((!this.adapter.q().isEmpty()) && bk.a(this.adapter.q().get(0))) {
            l(this, this.adapter.q().get(0).getId(), false, 2, null);
        } else {
            l(this, null, false, 2, null);
        }
    }

    public static /* synthetic */ void d(LSEffectListHolder lSEffectListHolder, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        lSEffectListHolder.c(z16);
    }

    public static /* synthetic */ void h(LSEffectListHolder lSEffectListHolder, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        lSEffectListHolder.g(str, z16);
    }

    public static /* synthetic */ void l(LSEffectListHolder lSEffectListHolder, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        lSEffectListHolder.k(str, z16);
    }

    public final void g(String id5, boolean smoothly) {
        int i3;
        if (id5 != null) {
            Iterator<bj> it = this.adapter.q().iterator();
            i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getId(), id5)) {
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            i3 = 0;
        }
        int i16 = i3 >= 0 ? i3 : 0;
        if (smoothly) {
            e(i16);
        } else {
            this.recyclerView.scrollToPosition(i16);
        }
    }
}
