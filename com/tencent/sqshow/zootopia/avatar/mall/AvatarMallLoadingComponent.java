package com.tencent.sqshow.zootopia.avatar.mall;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.avatar.loading.ISceneLoadingView;
import com.tencent.sqshow.zootopia.avatar.loading.view.ZPlanAvatarMallLoading;
import com.tencent.sqshow.zootopia.scene.component.ComponentLoading;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001'B#\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\tH\u0014J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/mall/AvatarMallLoadingComponent;", "Lcom/tencent/sqshow/zootopia/scene/component/ComponentLoading;", "", ExifInterface.LATITUDE_SOUTH, "", "W", "", "show", "y", "", "outDuration", "Lkotlin/Function0;", "callback", "X", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/avatar/loading/ISceneLoadingView;", "P", "o", "Landroid/view/View;", "view", "Landroid/animation/ObjectAnimator;", BdhLogUtil.LogTag.Tag_Req, "I", "styleMode", "Y", "Lkotlin/jvm/functions/Function0;", "callbackCache", "Ljava/lang/Runnable;", "Z", "Ljava/lang/Runnable;", "runCallbackTask", "", "loadingScene", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", TagName.ENGINE_TYPE, "<init>", "(ILjava/lang/String;Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;)V", "a0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarMallLoadingComponent extends ComponentLoading {

    /* renamed from: X, reason: from kotlin metadata */
    private int styleMode;

    /* renamed from: Y, reason: from kotlin metadata */
    private Function0<Unit> callbackCache;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Runnable runCallbackTask;

    public /* synthetic */ AvatarMallLoadingComponent(int i3, String str, AvatarEngineType avatarEngineType, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 4 : i3, str, (i16 & 4) != 0 ? AvatarEngineType.UE : avatarEngineType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(AvatarMallLoadingComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callbackCache.invoke();
        this$0.callbackCache = new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.mall.AvatarMallLoadingComponent$runCallbackTask$1$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.ComponentLoading
    protected ISceneLoadingView P(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ZPlanAvatarMallLoading(context, null, 0, this.styleMode, getEngineType(), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.scene.component.ComponentLoading
    public ObjectAnimator R(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ISceneLoadingView loadingView = getLoadingView();
        ObjectAnimator p16 = loadingView != null ? loadingView.p() : null;
        if (p16 != null) {
            return p16;
        }
        float alpha = view.getAlpha();
        QLog.i("AvatarMallLoadingComponent", 1, "currentAlpha :" + alpha);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, alpha, 1.0f);
        ofFloat.setDuration(o());
        ofFloat.setInterpolator(new com.tencent.sqshow.zootopia.utils.ui.a());
        return ofFloat;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.ComponentLoading
    /* renamed from: S, reason: from getter */
    protected int getStyleMode() {
        return this.styleMode;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.ComponentLoading
    protected boolean W() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.ComponentLoading
    public void X(long outDuration, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean isResumed = getIsResumed();
        QLog.i("AvatarMallLoadingComponent", 1, "onProgressEnd isResumed:" + isResumed);
        if (isResumed) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.runCallbackTask);
            super.X(outDuration, callback);
        } else {
            this.callbackCache = callback;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.scene.component.ComponentLoading
    public long o() {
        ISceneLoadingView loadingView = getLoadingView();
        if (loadingView != null) {
            return loadingView.o();
        }
        return 100L;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.ComponentLoading, wb4.a, od3.c
    public void show() {
        this.callbackCache = new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.mall.AvatarMallLoadingComponent$show$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        super.show();
    }

    @Override // wb4.a, od3.d
    public void y() {
        super.y();
        ThreadManagerV2.getUIHandlerV2().post(this.runCallbackTask);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarMallLoadingComponent(int i3, String loadingScene, AvatarEngineType engineType) {
        super(engineType);
        Intrinsics.checkNotNullParameter(loadingScene, "loadingScene");
        Intrinsics.checkNotNullParameter(engineType, "engineType");
        this.styleMode = i3;
        this.callbackCache = new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.avatar.mall.AvatarMallLoadingComponent$callbackCache$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.runCallbackTask = new Runnable() { // from class: com.tencent.sqshow.zootopia.avatar.mall.a
            @Override // java.lang.Runnable
            public final void run() {
                AvatarMallLoadingComponent.f0(AvatarMallLoadingComponent.this);
            }
        };
    }
}
