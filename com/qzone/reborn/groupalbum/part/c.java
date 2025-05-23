package com.qzone.reborn.groupalbum.part;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.qzone.reborn.groupalbum.event.GroupAlbumUnReadEvent;
import com.qzone.reborn.groupalbum.part.c;
import com.qzone.reborn.groupalbum.viewmodel.aj;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J\u001c\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aH\u0016R\u0014\u0010\u001f\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-\u00a8\u00063"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/c;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "currentIndex", "", "H9", WidgetCacheConstellationData.NUM, "K9", "G9", "", "showDuration", "I9", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "event", "onReceiveEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "J", "showAnimateTimeMs", "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", "e", "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", "mTabViewModel", "f", "I", "currentTabIndex", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "bubbleMessage", "Landroid/view/animation/Animation;", "i", "Landroid/view/animation/Animation;", "mHideAnim", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mShowAnim", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long showAnimateTimeMs = 1500;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private aj mTabViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentTabIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView bubbleMessage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Animation mHideAnim;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Animation mShowAnim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/groupalbum/part/c$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            TextView textView = c.this.bubbleMessage;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
                textView = null;
            }
            textView.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/groupalbum/part/c$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f56701e;

        b(long j3) {
            this.f56701e = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.bubbleMessage;
            Animation animation = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
                textView = null;
            }
            if (textView.getVisibility() == 0) {
                TextView textView2 = this$0.bubbleMessage;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
                    textView2 = null;
                }
                Animation animation2 = this$0.mHideAnim;
                if (animation2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHideAnim");
                } else {
                    animation = animation2;
                }
                textView2.startAnimation(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            TextView textView = c.this.bubbleMessage;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
                textView = null;
            }
            textView.setVisibility(0);
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final c cVar = c.this;
            uIHandler.postDelayed(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.b(c.this);
                }
            }, this.f56701e);
        }
    }

    private final void G9() {
        if (this.mShowAnim == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAnim");
        }
        if (this.mHideAnim == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideAnim");
        }
        TextView textView = this.bubbleMessage;
        Animation animation = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
            textView = null;
        }
        Animation animation2 = this.mShowAnim;
        if (animation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAnim");
        } else {
            animation = animation2;
        }
        textView.startAnimation(animation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(int currentIndex) {
        this.currentTabIndex = currentIndex;
        if (currentIndex == 1) {
            L9();
        }
    }

    private final void I9(long showDuration) {
        a aVar = new a();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154776cg);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(context, c\u2026nim.popupwindow_fade_out)");
        this.mHideAnim = loadAnimation;
        Animation animation = null;
        if (loadAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideAnim");
            loadAnimation = null;
        }
        loadAnimation.setAnimationListener(aVar);
        b bVar = new b(showDuration);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154775cf);
        Intrinsics.checkNotNullExpressionValue(loadAnimation2, "loadAnimation(context, c\u2026anim.popupwindow_fade_in)");
        this.mShowAnim = loadAnimation2;
        if (loadAnimation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAnim");
        } else {
            animation = loadAnimation2;
        }
        animation.setAnimationListener(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(c this$0, SimpleBaseEvent simpleBaseEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K9(((GroupAlbumUnReadEvent) simpleBaseEvent).getUnReadNum());
    }

    private final void L9() {
        TextView textView = this.bubbleMessage;
        Animation animation = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
            textView = null;
        }
        if (textView.getVisibility() != 0) {
            return;
        }
        TextView textView2 = this.bubbleMessage;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
            textView2 = null;
        }
        textView2.setVisibility(8);
        Animation animation2 = this.mShowAnim;
        if (animation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAnim");
            animation2 = null;
        }
        if (animation2.hasStarted()) {
            Animation animation3 = this.mShowAnim;
            if (animation3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShowAnim");
                animation3 = null;
            }
            animation3.cancel();
        }
        Animation animation4 = this.mHideAnim;
        if (animation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideAnim");
            animation4 = null;
        }
        if (animation4.hasStarted()) {
            Animation animation5 = this.mHideAnim;
            if (animation5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHideAnim");
            } else {
                animation = animation5;
            }
            animation.cancel();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.jwu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026lbum_bubble_message_tips)");
        TextView textView = (TextView) findViewById;
        this.bubbleMessage = textView;
        aj ajVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
            textView = null;
        }
        textView.setVisibility(8);
        I9(this.showAnimateTimeMs);
        ViewModel viewModel = getViewModel(aj.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumM\u2026TabViewModel::class.java)");
        aj ajVar2 = (aj) viewModel;
        this.mTabViewModel = ajVar2;
        if (ajVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
        } else {
            ajVar = ajVar2;
        }
        ajVar.R1().observe(getPartHost().getLifecycleOwner(), new C0477c());
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
    public void onReceiveEvent(final SimpleBaseEvent event) {
        if (event instanceof GroupAlbumUnReadEvent) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.J9(c.this, event);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/groupalbum/part/c$c", "Landroidx/lifecycle/Observer;", "", "tabIndex", "", "a", "(Ljava/lang/Integer;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.groupalbum.part.c$c, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public static final class C0477c implements Observer<Integer> {
        C0477c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer tabIndex) {
            if (tabIndex != null) {
                c.this.H9(tabIndex.intValue());
            }
        }
    }

    private final void K9(int num) {
        TextView textView = null;
        if (num > 0 && this.currentTabIndex != 1) {
            String string = BaseApplicationImpl.sApplication.getResources().getString(R.string.f1330755, Integer.valueOf(num));
            Intrinsics.checkNotNullExpressionValue(string, "sApplication.resources.getString(textId, num)");
            TextView textView2 = this.bubbleMessage;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
                textView2 = null;
            }
            textView2.setText(string);
            TextView textView3 = this.bubbleMessage;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
            } else {
                textView = textView3;
            }
            textView.setVisibility(0);
            G9();
            return;
        }
        TextView textView4 = this.bubbleMessage;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bubbleMessage");
        } else {
            textView = textView4;
        }
        textView.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumUnReadEvent.class);
        return arrayListOf;
    }
}
