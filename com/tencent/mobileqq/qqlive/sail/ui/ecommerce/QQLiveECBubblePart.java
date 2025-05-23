package com.tencent.mobileqq.qqlive.sail.ui.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.bubble.component.ECommerceBubbleBroadcastReceiver;
import com.tencent.timi.game.liveroom.impl.room.ecommerce.bubble.view.ECommerceBubbleView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/QQLiveECBubblePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/bubble/component/ECommerceBubbleBroadcastReceiver$a;", "", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "U9", "V9", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "", "isVisible", "D7", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "bubbleViewStub", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/bubble/view/ECommerceBubbleView;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/ecommerce/bubble/view/ECommerceBubbleView;", "bubbleView", "Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/c;", tl.h.F, "Lkotlin/Lazy;", "la", "()Lcom/tencent/mobileqq/qqlive/sail/ui/ecommerce/c;", "bubbleViewModel", "ma", "()Z", MiniChatConstants.MINI_APP_LANDSCAPE, "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveECBubblePart extends com.tencent.mobileqq.qqlive.sail.base.c implements ECommerceBubbleBroadcastReceiver.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup bubbleViewStub;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ECommerceBubbleView bubbleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy bubbleViewModel;

    public QQLiveECBubblePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveECBubblePart$bubbleViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) QQLiveECBubblePart.this.getViewModel(c.class);
            }
        });
        this.bubbleViewModel = lazy;
    }

    private final c la() {
        Object value = this.bubbleViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bubbleViewModel>(...)");
        return (c) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ma() {
        Resources resources;
        Configuration configuration;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.ecommerce.bubble.component.ECommerceBubbleBroadcastReceiver.a
    public void D7(boolean isVisible) {
        ViewGroup.LayoutParams layoutParams;
        AegisLogger.INSTANCE.i("Audience|QQLiveECBubblePart", "onLiveWindowVisibilityChange", "roomId=" + H9() + ", visible=" + isVisible);
        ViewGroup viewGroup = this.bubbleViewStub;
        ConstraintLayout.LayoutParams layoutParams2 = null;
        if (viewGroup != null) {
            layoutParams = viewGroup.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        }
        if (isVisible) {
            if (layoutParams2 != null) {
                layoutParams2.bottomToTop = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = wi2.c.b(170);
                layoutParams2.topToTop = 0;
                ViewGroup viewGroup2 = this.bubbleViewStub;
                if (viewGroup2 != null) {
                    viewGroup2.setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            return;
        }
        if (layoutParams2 != null) {
            layoutParams2.bottomToTop = R.id.f60432ve;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
            layoutParams2.topToTop = -1;
            ViewGroup viewGroup3 = this.bubbleViewStub;
            if (viewGroup3 != null) {
                viewGroup3.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        super.U9();
        if (N9()) {
            AegisLogger.INSTANCE.i("Audience|QQLiveECBubblePart", "onEnterRoom", "roomId=" + H9() + ", hasGoods");
            ECommerceBubbleBroadcastReceiver eCommerceBubbleBroadcastReceiver = ECommerceBubbleBroadcastReceiver.f377573a;
            eCommerceBubbleBroadcastReceiver.c();
            eCommerceBubbleBroadcastReceiver.b(this);
            la().R1(H9());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        super.V9();
        ECommerceBubbleView eCommerceBubbleView = this.bubbleView;
        if (eCommerceBubbleView != null) {
            eCommerceBubbleView.h();
        }
        la().S1();
        ECommerceBubbleBroadcastReceiver eCommerceBubbleBroadcastReceiver = ECommerceBubbleBroadcastReceiver.f377573a;
        eCommerceBubbleBroadcastReceiver.d(this);
        eCommerceBubbleBroadcastReceiver.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f60472vi;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ECommerceBubbleView eCommerceBubbleView = this.bubbleView;
        if (eCommerceBubbleView != null) {
            eCommerceBubbleView.i(ma());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        super.onInitView(rootView);
        ECommerceBubbleView eCommerceBubbleView = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f60472vi);
        } else {
            viewGroup = null;
        }
        this.bubbleViewStub = viewGroup;
        if (rootView != null) {
            eCommerceBubbleView = (ECommerceBubbleView) rootView.findViewById(R.id.f60502vl);
        }
        this.bubbleView = eCommerceBubbleView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        LiveData<String> Q1 = la().Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.QQLiveECBubblePart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0039, code lost:
            
                r0 = r5.this$0.bubbleView;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(String it) {
                boolean ma5;
                ECommerceBubbleView eCommerceBubbleView;
                AegisLogger.INSTANCE.i("Audience|QQLiveECBubblePart", "textChanged", "roomId=" + QQLiveECBubblePart.this.H9() + ", text=" + it);
                QQLiveECBubblePart.this.startInit();
                ma5 = QQLiveECBubblePart.this.ma();
                if (ma5 || eCommerceBubbleView == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                eCommerceBubbleView.e(it);
            }
        };
        Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.ecommerce.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveECBubblePart.na(Function1.this, obj);
            }
        });
    }
}
