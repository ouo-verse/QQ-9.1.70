package com.tencent.mobileqq.activity.aio.intimate.reborn.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.BackgroundChangeEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.IsNewHeaderCardItemShowEvent;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.UpdateTitlePartCurrentTypeLevelEvent;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0003J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c0\u001bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c`\u001dH\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/part/b;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/part/c;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lj61/a;", "intimateIntimateBaseModel", "", "E9", "", "intimateType", "level", "C9", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "A9", "z9", "x9", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mGameCharView", "e", "Landroid/view/View;", "mAnimRootView", "f", "mRootView", "Lj61/c;", h.F, "Lj61/c;", "viewModel", "Landroidx/lifecycle/Observer;", "i", "Landroidx/lifecycle/Observer;", "updateIntimateInfoObserver", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends c implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mGameCharView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAnimRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private j61.c viewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<IntimateBaseModel> updateIntimateInfoObserver = new Observer() { // from class: com.tencent.mobileqq.activity.aio.intimate.reborn.part.a
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            b.F9(b.this, (IntimateBaseModel) obj);
        }
    };

    private final void C9(int intimateType, int level) {
        SimpleEventBus.getInstance().dispatchEvent(new UpdateTitlePartCurrentTypeLevelEvent(intimateType, level, 0L));
        if (QQTheme.isVasTheme()) {
            View view = this.mRootView;
            if (view != null) {
                view.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
                return;
            }
            return;
        }
        D9(intimateType, level);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void D9(int intimateType, int level) {
        Drawable drawable;
        Drawable drawable2;
        if (getActivity() == null) {
            drawable = new ColorDrawable(0);
        } else {
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            drawable = activity.getDrawable(R.drawable.qui_common_bg_bottom_standard_bg);
        }
        String d16 = IntimateHeaderCardUtil.d(intimateType, level);
        View view = this.mRootView;
        if (view != null) {
            if (!IntimateHeaderCardUtil.v()) {
                IntimateHeaderCardUtil.X(view, d16, drawable);
            } else {
                view.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            }
        }
        if (IntimateHeaderCardUtil.M(intimateType)) {
            ImageView imageView = this.mGameCharView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            String g16 = IntimateHeaderCardUtil.g(intimateType);
            ImageView imageView2 = this.mGameCharView;
            Drawable drawable3 = null;
            if (imageView2 != null) {
                drawable2 = imageView2.getDrawable();
            } else {
                drawable2 = null;
            }
            if (drawable2 == null) {
                drawable3 = new ColorDrawable(0);
            } else {
                ImageView imageView3 = this.mGameCharView;
                if (imageView3 != null) {
                    drawable3 = imageView3.getDrawable();
                }
            }
            ImageView imageView4 = this.mGameCharView;
            if (imageView4 != null) {
                IntimateHeaderCardUtil.X(imageView4, g16, drawable3);
            }
        }
    }

    private final void E9(IntimateBaseModel intimateIntimateBaseModel) {
        if (IntimateHeaderCardUtil.u() && intimateIntimateBaseModel != null && com.tencent.mobileqq.activity.aio.intimate.e.d(intimateIntimateBaseModel.getIntimateInfo())) {
            View view = this.mRootView;
            if (view != null) {
                view.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
                return;
            }
            return;
        }
        IntimateInfo intimateInfo = intimateIntimateBaseModel.getIntimateInfo();
        int friendIntimateType = intimateIntimateBaseModel.getFriendIntimateType();
        if (j61.d.f409515a.b() != 0) {
            return;
        }
        if (intimateInfo.beFriendDays >= -1) {
            if (friendIntimateType != 1 && friendIntimateType != 2 && friendIntimateType != 3 && friendIntimateType != 26) {
                C9(0, intimateInfo.maskLevel);
                return;
            } else {
                C9(friendIntimateType, intimateInfo.maskLevel);
                return;
            }
        }
        C9(0, intimateInfo.maskLevel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(b this$0, IntimateBaseModel it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.E9(it);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(BackgroundChangeEvent.class, IsNewHeaderCardItemShowEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        ImageView imageView;
        this.mRootView = rootView;
        j61.c cVar = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f783746w);
        } else {
            view = null;
        }
        this.mAnimRootView = view;
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.vio);
        } else {
            imageView = null;
        }
        this.mGameCharView = imageView;
        j61.c cVar2 = this.viewModel;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar = cVar2;
        }
        cVar.M1().observe(getPartHost().getLifecycleOwner(), this.updateIntimateInfoObserver);
        SimpleEventBus.getInstance().registerReceiver(this);
        C9(0, 0);
        com.tencent.mobileqq.qui.b.f276860a.a(rootView, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(j61.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(IntimateCommonViewModel::class.java)");
        this.viewModel = (j61.c) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        View view;
        if (event instanceof BackgroundChangeEvent) {
            View view2 = this.mRootView;
            if (view2 != null && this.mAnimRootView != null) {
                BackgroundChangeEvent backgroundChangeEvent = (BackgroundChangeEvent) event;
                int type = backgroundChangeEvent.getType();
                int level = backgroundChangeEvent.getLevel();
                View view3 = this.mRootView;
                Intrinsics.checkNotNull(view3);
                View view4 = this.mAnimRootView;
                Intrinsics.checkNotNull(view4);
                IntimateHeaderCardUtil.I(type, level, view3, view4, this.mGameCharView);
                return;
            }
            QLog.i("IntimateBackgroundPart", 1, "onBgChange but mRootView=" + view2 + ", mAnimRootView=" + this.mAnimRootView);
            return;
        }
        if ((event instanceof IsNewHeaderCardItemShowEvent) && ((IsNewHeaderCardItemShowEvent) event).getIsNewHeaderShow() && (view = this.mRootView) != null) {
            view.setBackground(null);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void A9() {
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void x9() {
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.part.c
    public void z9() {
    }
}
