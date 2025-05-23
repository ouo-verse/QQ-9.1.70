package com.tencent.mobileqq.guild.feed.feedsquare.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.feed.event.GuildFeedListFirstLoadingEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J(\u0010\u0019\u001a\"\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0017\u0018\u00010\u0016j\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0017\u0018\u0001`\u0018H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareLoadingAnimPart;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "state", "", "F9", "C9", "Landroid/view/View;", "mRootView", "D9", "H9", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedListFirstLoadingEvent;", "event", "B9", "hideLoadingView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mContainer", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "e", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "mScanningLightView", "", "f", "Z", "firstIn", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareLoadingAnimPart extends com.tencent.mobileqq.guild.feed.part.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ScanningLightView mScanningLightView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean firstIn = true;

    private final void B9(GuildFeedListFirstLoadingEvent event) {
        Logger.f235387a.d().d("GuildFeedSquareLoadingAnimPart", 1, "handleFeedListFirstLoading: isFinish[" + event.isLoadingFinish() + "]");
        if (!event.isLoadingFinish()) {
            return;
        }
        hideLoadingView();
    }

    private final void C9() {
        if (this.firstIn) {
            hideLoadingView();
            this.firstIn = false;
        }
    }

    private final void D9(View mRootView) {
        FrameLayout frameLayout;
        View findViewById = mRootView.findViewById(R.id.wej);
        ScanningLightView scanningLightView = null;
        if (findViewById instanceof FrameLayout) {
            frameLayout = (FrameLayout) findViewById;
        } else {
            frameLayout = null;
        }
        if (frameLayout == null) {
            return;
        }
        this.mContainer = frameLayout;
        View findViewById2 = frameLayout.findViewById(R.id.efs);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContainer.findViewById(R.id.loading_view)");
        ScanningLightView scanningLightView2 = (ScanningLightView) findViewById2;
        this.mScanningLightView = scanningLightView2;
        if (scanningLightView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScanningLightView");
            scanningLightView2 = null;
        }
        scanningLightView2.setSkeletonColorRes(R.color.qui_common_fill_standard_primary);
        ScanningLightView scanningLightView3 = this.mScanningLightView;
        if (scanningLightView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScanningLightView");
        } else {
            scanningLightView = scanningLightView3;
        }
        scanningLightView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedSquareLoadingAnimPart.E9(GuildFeedSquareLoadingAnimPart.this);
            }
        });
        H9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(GuildFeedSquareLoadingAnimPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScanningLightView scanningLightView = this$0.mScanningLightView;
        ScanningLightView scanningLightView2 = null;
        if (scanningLightView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScanningLightView");
            scanningLightView = null;
        }
        ViewGroup.LayoutParams layoutParams = scanningLightView.getLayoutParams();
        if (layoutParams != null) {
            ScanningLightView scanningLightView3 = this$0.mScanningLightView;
            if (scanningLightView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScanningLightView");
            } else {
                scanningLightView2 = scanningLightView3;
            }
            layoutParams.height = scanningLightView2.getHeight();
            scanningLightView.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(UIStateData<List<ij1.g>> state) {
        int state2 = state.getState();
        if (state2 == 0 || state2 == 2 || state2 == 3 || state2 == 4) {
            C9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H9() {
        Logger.f235387a.d().d("GuildFeedSquareLoadingAnimPart", 1, "showLoadingAnim");
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        frameLayout.setVisibility(0);
    }

    private final void hideLoadingView() {
        FrameLayout frameLayout = this.mContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            frameLayout = null;
        }
        frameLayout.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedListFirstLoadingEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
        com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k vmApi;
        MutableLiveData<UIStateData<List<ij1.g>>> j3;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        D9(rootView);
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) PartIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
        if (gVar != null && (context = gVar.getContext()) != null && (vmApi = context.getVmApi()) != null && (j3 = vmApi.j()) != null) {
            LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
            final Function1<UIStateData<List<ij1.g>>, Unit> function1 = new Function1<UIStateData<List<ij1.g>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareLoadingAnimPart$onInitView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<ij1.g>> uIStateData) {
                    invoke2(uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<List<ij1.g>> it) {
                    GuildFeedSquareLoadingAnimPart guildFeedSquareLoadingAnimPart = GuildFeedSquareLoadingAnimPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    guildFeedSquareLoadingAnimPart.F9(it);
                }
            };
            j3.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedSquareLoadingAnimPart.G9(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedListFirstLoadingEvent) {
            B9((GuildFeedListFirstLoadingEvent) simpleBaseEvent);
        }
    }
}
