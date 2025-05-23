package com.tencent.mobileqq.qqvideoedit.editor.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.VideoMaterialViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.ar;
import com.tencent.mobileqq.qqvideoedit.event.FilterSelectedEvent;
import com.tencent.mobileqq.qqvideoedit.event.ReceiveSchemaEvent;
import com.tencent.mobileqq.qqvideoedit.event.ResourcePreDownFinishEvent;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.AnimateUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000 72\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0004J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u0016\u001a\u00020\u0004H\u0014J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f` H\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00100\u001a\u00020%8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/menu/h;", "Lcom/tencent/mobileqq/qqvideoedit/editor/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "W9", "Lcom/tencent/mobileqq/qqvideoedit/editor/menu/MenuType;", "T9", "Y9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "args", "O9", "x9", "K9", "onDismiss", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "editMode", "J9", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoMaterialViewModel;", "S9", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "D", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoMaterialViewModel;", "materialViewModel", "Landroid/view/animation/Animation;", "E", "Landroid/view/animation/Animation;", "V9", "()Landroid/view/animation/Animation;", "aa", "(Landroid/view/animation/Animation;)V", "slideUpAnimation", UserInfo.SEX_FEMALE, "U9", "Z9", "slideDownAnimation", "", "G", "I", "bottomSpace", "<init>", "()V", "H", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class h extends com.tencent.mobileqq.qqvideoedit.editor.d implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private VideoMaterialViewModel materialViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    protected Animation slideUpAnimation;

    /* renamed from: F, reason: from kotlin metadata */
    protected Animation slideDownAnimation;

    /* renamed from: G, reason: from kotlin metadata */
    private int bottomSpace;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/menu/h$b", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends AnimateUtils.AnimationAdapter {
        b() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            h.super.K9(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/menu/h$c", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends AnimateUtils.AnimationAdapter {
        c() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            h.super.onDismiss();
        }
    }

    private final void W9() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155067i2);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(context, R.anim.slide_bottom_up)");
        aa(loadAnimation);
        V9().setDuration(200L);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f155066i1);
        Intrinsics.checkNotNullExpressionValue(loadAnimation2, "loadAnimation(context, R.anim.slide_bottom_down)");
        Z9(loadAnimation2);
        U9().setDuration(200L);
        V9().setAnimationListener(new b());
        U9().setAnimationListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(h this$0, MenuSwitchAction action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action.getMenuType() == this$0.T9()) {
            super.O9(action.getArgs());
            if (action.getMenuType() == MenuType.VIDEO_TEMPLATE && this$0.E9().getIsAutoTemplate()) {
                VideoEditorViewModel.z2(this$0.E9(), MenuType.BOTTOM_DASHBOARD, null, 2, null);
                if (!NetworkUtil.isNetworkAvailable()) {
                    QQToast.makeText(this$0.getContext(), 1, this$0.getContext().getString(R.string.ynb), 0).show();
                    this$0.E9().u2(false);
                    return;
                }
                return;
            }
            return;
        }
        super.x9();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public void J9(@NotNull VideoEditorViewModel.EditMode editMode) {
        View partRootView;
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        if (getViewStubIsInflated() && (partRootView = getPartRootView()) != null) {
            partRootView.setOnClickListener(null);
            partRootView.setFocusable(false);
            partRootView.setClickable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public void K9(@Nullable Bundle args) {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.startAnimation(V9());
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public final void O9(@Nullable Bundle args) {
        E9().y2(T9(), args);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public VideoMaterialViewModel S9() {
        boolean z16;
        if (this.materialViewModel == null) {
            Bundle arguments = getHostFragment().getArguments();
            if (arguments != null) {
                z16 = arguments.getBoolean(QQWinkConstants.IS_IMAGE_MODEL);
            } else {
                z16 = true;
            }
            this.materialViewModel = (VideoMaterialViewModel) new ViewModelProvider(getHostFragment(), new ar(4, z16)).get(VideoMaterialViewModel.class);
        }
        return this.materialViewModel;
    }

    @NotNull
    public abstract MenuType T9();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Animation U9() {
        Animation animation = this.slideDownAnimation;
        if (animation != null) {
            return animation;
        }
        Intrinsics.throwUninitializedPropertyAccessException("slideDownAnimation");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Animation V9() {
        Animation animation = this.slideUpAnimation;
        if (animation != null) {
            return animation;
        }
        Intrinsics.throwUninitializedPropertyAccessException("slideUpAnimation");
        return null;
    }

    public abstract void Y9();

    protected final void Z9(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "<set-?>");
        this.slideDownAnimation = animation;
    }

    protected final void aa(@NotNull Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "<set-?>");
        this.slideUpAnimation = animation;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ResourcePreDownFinishEvent.class);
        arrayList.add(FilterSelectedEvent.class);
        arrayList.add(ReceiveSchemaEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public void onDismiss() {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            partRootView.startAnimation(U9());
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.bottomSpace = getContext().getResources().getDimensionPixelSize(R.dimen.dio);
        E9().c2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqvideoedit.editor.menu.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.X9(h.this, (MenuSwitchAction) obj);
            }
        });
        W9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof ResourcePreDownFinishEvent) {
            Y9();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.d
    public final void x9() {
        if (!E9().getMIsDisableOther()) {
            E9().x2();
        }
    }
}
