package com.tencent.mobileqq.matchfriend.reborn.drag;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerEnableUpdateTabUnreadNumEvent;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/drag/QQStrangerDragLayoutPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "F9", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "dragArea", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "d", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "dragLayout", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout$OnDragModeChangedListener;", "e", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout$OnDragModeChangedListener;", "onDragModeChangedListener", "<init>", "()V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerDragLayoutPart extends Part {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final List<a> f245077h = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUIBadgeDragLayout dragLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy onDragModeChangedListener;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/drag/QQStrangerDragLayoutPart$a;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/drag/a;", "provider", "", "a", "b", "", "TAG", "Ljava/lang/String;", "", "priorityDragViewProviders", "Ljava/util/List;", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.drag.QQStrangerDragLayoutPart$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(a provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            if (QQStrangerDragLayoutPart.f245077h.contains(provider)) {
                return;
            }
            QQStrangerDragLayoutPart.f245077h.add(provider);
        }

        public final void b(a provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            if (QQStrangerDragLayoutPart.f245077h.contains(provider)) {
                QQStrangerDragLayoutPart.f245077h.remove(provider);
            }
        }

        Companion() {
        }
    }

    public QQStrangerDragLayoutPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new QQStrangerDragLayoutPart$onDragModeChangedListener$2(this));
        this.onDragModeChangedListener = lazy;
    }

    private final void C9(QUIBadgeDragLayout dragArea) {
        dragArea.addDragViewProviderByGroup("stranger_msg", new QUIBadgeDragLayout.IDragViewProvider() { // from class: com.tencent.mobileqq.matchfriend.reborn.drag.b
            @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.IDragViewProvider
            public final List onGetVisibleDragView() {
                List D9;
                D9 = QQStrangerDragLayoutPart.D9();
                return D9;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List D9() {
        List sortedWith;
        List<a> list = f245077h;
        final QQStrangerDragLayoutPart$addDragViewProvider$1$sortedDragViewProviders$1 qQStrangerDragLayoutPart$addDragViewProvider$1$sortedDragViewProviders$1 = new Function2<a, a, Integer>() { // from class: com.tencent.mobileqq.matchfriend.reborn.drag.QQStrangerDragLayoutPart$addDragViewProvider$1$sortedDragViewProviders$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(a aVar, a aVar2) {
                return Integer.valueOf(aVar2.getPriority().compareTo(aVar.getPriority()));
            }
        };
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: com.tencent.mobileqq.matchfriend.reborn.drag.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int E9;
                E9 = QQStrangerDragLayoutPart.E9(Function2.this, obj, obj2);
                return E9;
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((a) it.next()).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E9(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerEnableUpdateTabUnreadNumEvent(true));
    }

    private final QUIBadgeDragLayout.OnDragModeChangedListener<QUIBadgeDragLayout> G9() {
        return (QUIBadgeDragLayout.OnDragModeChangedListener) this.onDragModeChangedListener.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QUIBadgeDragLayout qUIBadgeDragLayout = (QUIBadgeDragLayout) rootView.findViewById(R.id.oni);
        this.dragLayout = qUIBadgeDragLayout;
        Intrinsics.checkNotNullExpressionValue(qUIBadgeDragLayout, "this");
        C9(qUIBadgeDragLayout);
        qUIBadgeDragLayout.addOnDragModeChangeListener(G9(), false);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QUIBadgeDragLayout qUIBadgeDragLayout = this.dragLayout;
        if (qUIBadgeDragLayout != null) {
            qUIBadgeDragLayout.removeOnDragModeChangeListener(G9());
        }
        f245077h.clear();
    }
}
