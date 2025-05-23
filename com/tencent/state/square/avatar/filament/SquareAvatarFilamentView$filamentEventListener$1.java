package com.tencent.state.square.avatar.filament;

import android.widget.FrameLayout;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.filament.zplan.scene.square.SquareInteractionEventData;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.view.SquareImageView;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import sk0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/state/square/avatar/filament/SquareAvatarFilamentView$filamentEventListener$1", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAvatarFilamentView$filamentEventListener$1 implements b {
    final /* synthetic */ SquareAvatarFilamentView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareAvatarFilamentView$filamentEventListener$1(SquareAvatarFilamentView squareAvatarFilamentView) {
        this.this$0 = squareAvatarFilamentView;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00c5, code lost:
    
        r8 = r5.this$0.currentPlayData;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    @Override // sk0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleEvent(c spanContext, String type, String data) {
        long timeAfterCreate;
        long timeAfterCreate2;
        MoodConfig moodConfig;
        SquareAvatarData squareAvatarData;
        Function0 function0;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305;
        long timeAfterCreate3;
        Function0 function02;
        long timeAfterCreate4;
        Intrinsics.checkNotNullParameter(type, "type");
        switch (type.hashCode()) {
            case -1565730423:
                if (type.equals("onFilamentRenderFail")) {
                    this.this$0.renderFailTips(data, RenderFailReason.INIT_FAIL);
                    return;
                }
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onEvent, type:");
                sb5.append(type);
                sb5.append(", cost:");
                timeAfterCreate = this.this$0.getTimeAfterCreate();
                sb5.append(timeAfterCreate);
                squareLog.d("SquareAvatarFilamentView", sb5.toString());
                return;
            case -12447438:
                if (type.equals("SquareAvatarScene.DOUBLE_CLICK")) {
                    SquareLogger squareLog2 = SquareBaseKt.getSquareLog();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("onEvent, type:");
                    sb6.append(type);
                    sb6.append(", cost:");
                    timeAfterCreate2 = this.this$0.getTimeAfterCreate();
                    sb6.append(timeAfterCreate2);
                    squareLog2.d("SquareAvatarFilamentView", sb6.toString());
                    moodConfig = this.this$0.currentMoodConfig;
                    if (moodConfig == null || squareAvatarData == null) {
                        return;
                    }
                    EnumUserGender gender = squareAvatarData.getHost().getGender();
                    AvatarType avatarType = AvatarType.HOST;
                    AnimType animType = AnimType.CLICK;
                    SquareAvatarData.AvatarAnim avatarAnim = moodConfig.getAvatarAnim(gender, avatarType, animType);
                    SquareAvatarData.AvatarData guest = squareAvatarData.getGuest();
                    SquareAvatarData.AvatarAnim avatarAnim2 = guest != null ? moodConfig.getAvatarAnim(guest.getGender(), AvatarType.GUEST, animType) : null;
                    SquareAvatarData.ExtraActorData extraActorData = moodConfig.getExtraActorData(animType, squareAvatarData.getHost().getGender());
                    String animGltf = extraActorData != null ? extraActorData.getAnimGltf() : null;
                    if (avatarAnim != null) {
                        SquareInteractionEventData squareInteractionEventData = new SquareInteractionEventData(avatarAnim, avatarAnim2, animGltf);
                        iFilamentNativeAppV2305 = this.this$0.filamentApp;
                        if (iFilamentNativeAppV2305 != null) {
                            iFilamentNativeAppV2305.dispatchEvent(spanContext, "SquareAvatarScene.EVENT_INTERACTION", squareInteractionEventData.toJson());
                        }
                    }
                    function0 = this.this$0.doubleClickListener;
                    if (function0 != null) {
                        return;
                    }
                    return;
                }
                SquareLogger squareLog3 = SquareBaseKt.getSquareLog();
                StringBuilder sb52 = new StringBuilder();
                sb52.append("onEvent, type:");
                sb52.append(type);
                sb52.append(", cost:");
                timeAfterCreate = this.this$0.getTimeAfterCreate();
                sb52.append(timeAfterCreate);
                squareLog3.d("SquareAvatarFilamentView", sb52.toString());
                return;
            case 520310516:
                if (type.equals("SquareAvatarScene.TAP_CLICK")) {
                    SquareLogger squareLog4 = SquareBaseKt.getSquareLog();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("onEvent, type:");
                    sb7.append(type);
                    sb7.append(", cost:");
                    timeAfterCreate3 = this.this$0.getTimeAfterCreate();
                    sb7.append(timeAfterCreate3);
                    squareLog4.d("SquareAvatarFilamentView", sb7.toString());
                    function02 = this.this$0.tapClickListener;
                    if (function02 != null) {
                        return;
                    }
                    return;
                }
                SquareLogger squareLog32 = SquareBaseKt.getSquareLog();
                StringBuilder sb522 = new StringBuilder();
                sb522.append("onEvent, type:");
                sb522.append(type);
                sb522.append(", cost:");
                timeAfterCreate = this.this$0.getTimeAfterCreate();
                sb522.append(timeAfterCreate);
                squareLog32.d("SquareAvatarFilamentView", sb522.toString());
                return;
            case 1543387125:
                if (type.equals("SquareAvatarScene.EVENT_FIRST_FRAME_RENDERED_AFTER_LOAD")) {
                    SquareLogger squareLog5 = SquareBaseKt.getSquareLog();
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("firstRender, cost:");
                    timeAfterCreate4 = this.this$0.getTimeAfterCreate();
                    sb8.append(timeAfterCreate4);
                    squareLog5.i("SquareAvatarFilamentView", sb8.toString());
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.filament.SquareAvatarFilamentView$filamentEventListener$1$handleEvent$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            SquareImageView squareImageView;
                            FrameLayout frameLayout;
                            IAvatarAnimListener iAvatarAnimListener;
                            SquareImageView squareImageView2;
                            SquareAvatarFilamentView$filamentEventListener$1.this.this$0.isFirstFrameRendered = true;
                            squareImageView = SquareAvatarFilamentView$filamentEventListener$1.this.this$0.imageView;
                            if (ViewExtensionsKt.isVisible(squareImageView)) {
                                SquareAvatarFilamentView squareAvatarFilamentView = SquareAvatarFilamentView$filamentEventListener$1.this.this$0;
                                squareImageView2 = squareAvatarFilamentView.imageView;
                                SquareAvatarFilamentView.startAlphaAnimation$default(squareAvatarFilamentView, squareImageView2, false, null, 4, null);
                            }
                            SquareAvatarFilamentView$filamentEventListener$1.this.this$0.setVideoViewVisibility(true);
                            frameLayout = SquareAvatarFilamentView$filamentEventListener$1.this.this$0.loadingView;
                            ViewExtensionsKt.setVisibility(frameLayout, false);
                            iAvatarAnimListener = SquareAvatarFilamentView$filamentEventListener$1.this.this$0.playListener;
                            if (iAvatarAnimListener != null) {
                                iAvatarAnimListener.onFirstFrame();
                            }
                        }
                    });
                    this.this$0.reportFirstRender(RenderResult.SUCCESS, RenderFailReason.DEFAULT);
                    return;
                }
                SquareLogger squareLog322 = SquareBaseKt.getSquareLog();
                StringBuilder sb5222 = new StringBuilder();
                sb5222.append("onEvent, type:");
                sb5222.append(type);
                sb5222.append(", cost:");
                timeAfterCreate = this.this$0.getTimeAfterCreate();
                sb5222.append(timeAfterCreate);
                squareLog322.d("SquareAvatarFilamentView", sb5222.toString());
                return;
            default:
                SquareLogger squareLog3222 = SquareBaseKt.getSquareLog();
                StringBuilder sb52222 = new StringBuilder();
                sb52222.append("onEvent, type:");
                sb52222.append(type);
                sb52222.append(", cost:");
                timeAfterCreate = this.this$0.getTimeAfterCreate();
                sb52222.append(timeAfterCreate);
                squareLog3222.d("SquareAvatarFilamentView", sb52222.toString());
                return;
        }
    }
}
