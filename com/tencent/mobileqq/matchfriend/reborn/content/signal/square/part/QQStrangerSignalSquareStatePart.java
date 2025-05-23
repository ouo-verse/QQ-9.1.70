package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareEmptyEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareErrorEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalSquareShowContentViewEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J$\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0014`\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/part/QQStrangerSignalSquareStatePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "B9", "showErrorView", "A9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "stateLayout", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "e", "Lkotlin/Lazy;", "z9", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyContentView", "f", "x9", "emptyContentError", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareStatePart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout stateLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy emptyContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy emptyContentError;

    public QQStrangerSignalSquareStatePart() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.QQStrangerSignalSquareStatePart$emptyContentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIEmptyState invoke() {
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(QQStrangerSignalSquareStatePart.this.getContext()).setImageType(16);
                String string = QQStrangerSignalSquareStatePart.this.getContext().getString(R.string.x3s);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026qq_stranger_square_empty)");
                QUIEmptyState build = imageType.setTitle(string).setBackgroundColorType(0).setHalfScreenState(true).build();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                build.setGravity(17);
                build.setLayoutParams(layoutParams);
                return build;
            }
        });
        this.emptyContentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new QQStrangerSignalSquareStatePart$emptyContentError$2(this));
        this.emptyContentError = lazy2;
    }

    private final void A9() {
        FrameLayout frameLayout = this.stateLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateLayout");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout3 = this.stateLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateLayout");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setVisibility(8);
    }

    private final void B9() {
        FrameLayout frameLayout = this.stateLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateLayout");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout3 = this.stateLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateLayout");
            frameLayout3 = null;
        }
        frameLayout3.setVisibility(0);
        FrameLayout frameLayout4 = this.stateLayout;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateLayout");
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.addView(z9());
    }

    private final void showErrorView() {
        FrameLayout frameLayout = this.stateLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateLayout");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout3 = this.stateLayout;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateLayout");
            frameLayout3 = null;
        }
        frameLayout3.setVisibility(0);
        FrameLayout frameLayout4 = this.stateLayout;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateLayout");
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.addView(x9());
    }

    private final QUIEmptyState x9() {
        return (QUIEmptyState) this.emptyContentError.getValue();
    }

    private final QUIEmptyState z9() {
        return (QUIEmptyState) this.emptyContentView.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.oq6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026nger_square_state_layout)");
        this.stateLayout = (FrameLayout) findViewById;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QQStrangerSignalSquareEmptyEvent) {
            B9();
        } else if (event instanceof QQStrangerSignalSquareErrorEvent) {
            showErrorView();
        } else if (event instanceof QQStrangerSignalSquareShowContentViewEvent) {
            A9();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerSignalSquareEmptyEvent.class, QQStrangerSignalSquareErrorEvent.class, QQStrangerSignalSquareShowContentViewEvent.class);
        return arrayListOf;
    }
}
