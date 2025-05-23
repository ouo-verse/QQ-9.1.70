package com.tencent.filament.zplan.view.controller;

import com.tencent.filament.zplan.animation.GYZPlanAnimation;
import com.tencent.filament.zplan.listener.IAnimationNativeCallback;
import com.tencent.filament.zplan.listener.IAnimationSetListener;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes6.dex */
final class GYFZPlanController$setAnimationWithPath$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $animationPath;
    final /* synthetic */ IAnimationSetListener $listener;
    final /* synthetic */ GYFZPlanController this$0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/filament/zplan/view/controller/GYFZPlanController$setAnimationWithPath$1$1", "Lcom/tencent/filament/zplan/listener/IAnimationNativeCallback;", "onSetAnimationResult", "", "animationJson", "", "result", "", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAnimationWithPath$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 implements IAnimationNativeCallback {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.filament.zplan.animation.GYZPlanAnimation] */
        @Override // com.tencent.filament.zplan.listener.IAnimationNativeCallback
        public void onSetAnimationResult(@NotNull String animationJson, final int result) {
            Intrinsics.checkNotNullParameter(animationJson, "animationJson");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new GYZPlanAnimation();
            if (result == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(animationJson);
                    FLog.INSTANCE.d("GYFZPlanController", "setAnimationWithPath callback , " + jSONObject.toString());
                    ((GYZPlanAnimation) objectRef.element).fromJSON(jSONObject);
                } catch (JSONException unused) {
                    FLog.INSTANCE.e("GYFZPlanController", "setAnimationWithPath json error :" + animationJson);
                }
            }
            FLog.INSTANCE.d("GYFZPlanController", ((GYZPlanAnimation) objectRef.element) + ", " + ((GYZPlanAnimation) objectRef.element).getMoodDuration() + TokenParser.SP + ((GYZPlanAnimation) objectRef.element).getMoodPath());
            GYFZPlanController$setAnimationWithPath$1.this.this$0.a0("setAnimationWithPath", new Function0<Unit>() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAnimationWithPath$1$1$onSetAnimationResult$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GYFZPlanNativeAPI nativeAPI = GYFZPlanController$setAnimationWithPath$1.this.this$0.getNativeAPI();
                    if (nativeAPI != null) {
                        nativeAPI.update(0.0d);
                    }
                    GYFZPlanController$setAnimationWithPath$1.this.this$0.L().post(new Runnable() { // from class: com.tencent.filament.zplan.view.controller.GYFZPlanController$setAnimationWithPath$1$1$onSetAnimationResult$1.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public final void run() {
                            GYFZPlanController$setAnimationWithPath$1$1$onSetAnimationResult$1 gYFZPlanController$setAnimationWithPath$1$1$onSetAnimationResult$1 = GYFZPlanController$setAnimationWithPath$1$1$onSetAnimationResult$1.this;
                            IAnimationSetListener iAnimationSetListener = GYFZPlanController$setAnimationWithPath$1.this.$listener;
                            if (iAnimationSetListener != null) {
                                iAnimationSetListener.onSetAnimationResult((GYZPlanAnimation) objectRef.element, result);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GYFZPlanController$setAnimationWithPath$1(GYFZPlanController gYFZPlanController, String str, IAnimationSetListener iAnimationSetListener) {
        super(0);
        this.this$0 = gYFZPlanController;
        this.$animationPath = str;
        this.$listener = iAnimationSetListener;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        GYFZPlanNativeAPI nativeAPI = this.this$0.getNativeAPI();
        if (nativeAPI != null) {
            nativeAPI.setAnimationWithPath(this.$animationPath, new AnonymousClass1());
        }
    }
}
