package com.tencent.timi.game.liveroom.impl.room.dynamicbg;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.displayview.IDisplayViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001)B\u001d\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0011\u001a\u00020\u0007R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/dynamicbg/RoomDynamicBgView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "roomId", "", "displayViewWidth", "displayViewHeight", "", "C0", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "setLifeCycleOwner", "Ltq4/a;", "backgroundInfo", "D0", "E0", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "topRoomBg", "e", "bottomRoomBg", "Landroid/view/View;", "f", "Landroid/view/View;", "videoViewContainer", "Lcom/tencent/timi/game/liveroom/impl/room/dynamicbg/RoomDynamicBgViewModel;", h.F, "Lcom/tencent/timi/game/liveroom/impl/room/dynamicbg/RoomDynamicBgViewModel;", "viewModel", "i", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class RoomDynamicBgView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView topRoomBg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView bottomRoomBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View videoViewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RoomDynamicBgViewModel viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LifecycleOwner lifecycleOwner;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomDynamicBgView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void C0(long roomId, int displayViewWidth, int displayViewHeight) {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("room_info|RoomDynamicBgView", "roomId:" + roomId + ", changeDisplayViewSize, width:" + displayViewWidth + ", height:" + displayViewHeight);
        if (displayViewWidth == -1 && displayViewHeight == -1) {
            companion.i("room_info|RoomDynamicBgView", "\u8fd9\u662f\u7ad6\u5c4f\u6d41");
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.videoViewContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = displayViewHeight;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ((IDisplayViewApi) QRoute.api(IDisplayViewApi.class)).getHorizontalVideoTopMargin(true);
        this.videoViewContainer.setLayoutParams(layoutParams2);
    }

    public final void D0(long roomId, @Nullable tq4.a backgroundInfo) {
        RoomDynamicBgViewModel roomDynamicBgViewModel = this.viewModel;
        if (roomDynamicBgViewModel != null) {
            roomDynamicBgViewModel.X1(roomId, backgroundInfo);
        }
    }

    public final void E0() {
        RoomDynamicBgViewModel roomDynamicBgViewModel;
        LiveData<RoomDynamicBgData> W1;
        RoomDynamicBgViewModel roomDynamicBgViewModel2 = this.viewModel;
        if (roomDynamicBgViewModel2 != null) {
            roomDynamicBgViewModel2.Z1();
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (roomDynamicBgViewModel = this.viewModel) != null && (W1 = roomDynamicBgViewModel.W1()) != null) {
            W1.removeObservers(lifecycleOwner);
        }
        this.lifecycleOwner = null;
    }

    public final void setLifeCycleOwner(@NotNull LifecycleOwner lifecycleOwner, @NotNull ViewModelStoreOwner owner) {
        LiveData<RoomDynamicBgData> W1;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.lifecycleOwner = lifecycleOwner;
        RoomDynamicBgViewModel a16 = RoomDynamicBgViewModel.INSTANCE.a(owner);
        this.viewModel = a16;
        if (a16 != null && (W1 = a16.W1()) != null) {
            final Function1<RoomDynamicBgData, Unit> function1 = new Function1<RoomDynamicBgData, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.dynamicbg.RoomDynamicBgView$setLifeCycleOwner$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RoomDynamicBgData roomDynamicBgData) {
                    invoke2(roomDynamicBgData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RoomDynamicBgData roomDynamicBgData) {
                    ImageView imageView;
                    ImageView imageView2;
                    if (roomDynamicBgData != null) {
                        RoomDynamicBgView roomDynamicBgView = RoomDynamicBgView.this;
                        imageView = roomDynamicBgView.topRoomBg;
                        imageView.setImageBitmap(roomDynamicBgData.getTopBitmap());
                        imageView2 = roomDynamicBgView.bottomRoomBg;
                        imageView2.setImageBitmap(roomDynamicBgData.getBottomBitmap());
                        roomDynamicBgView.setVisibility(0);
                    }
                }
            };
            W1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.dynamicbg.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RoomDynamicBgView.F0(Function1.this, obj);
                }
            });
        }
    }

    public /* synthetic */ RoomDynamicBgView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RoomDynamicBgView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.e6k, this);
        View findViewById = findViewById(R.id.f99995ra);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.top_room_bg)");
        this.topRoomBg = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.ta_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.bottom_room_bg)");
        this.bottomRoomBg = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.f1182973r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.video_\u2026w_container_place_holder)");
        this.videoViewContainer = findViewById3;
        setVisibility(4);
    }
}
