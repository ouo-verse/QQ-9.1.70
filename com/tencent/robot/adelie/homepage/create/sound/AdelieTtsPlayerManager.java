package com.tencent.robot.adelie.homepage.create.sound;

import com.google.gson.Gson;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import com.tencent.robot.adelie.kuikly.module.KuiklyRenderCallbackData;
import com.tencent.robot.timbre.RobotTimbrePlayerManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J=\u0010\u0010\u001a\u00020\b*'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b\u0018\u00010\nj\u0004\u0018\u0001`\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J;\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122+\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b\u0018\u00010\nj\u0004\u0018\u0001`\u000eR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R;\u0010\u001c\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\b\u0018\u00010\nj\u0004\u0018\u0001`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/sound/AdelieTtsPlayerManager;", "", "", "state", "", "success", "", "i", "", "f", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "data", "e", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "ttsInfo", "o", "callback", "k", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "selectTtsInfo", "b", "Lkotlin/jvm/functions/Function1;", "kuiklyCallback", "Lcom/tencent/robot/timbre/RobotTimbrePlayerManager;", "c", "Lkotlin/Lazy;", h.F, "()Lcom/tencent/robot/timbre/RobotTimbrePlayerManager;", "mTimbrePlayerManager", "<init>", "()V", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieTtsPlayerManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TtsInfo selectTtsInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> kuiklyCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTimbrePlayerManager;

    public AdelieTtsPlayerManager() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotTimbrePlayerManager>() { // from class: com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPlayerManager$mTimbrePlayerManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotTimbrePlayerManager invoke() {
                RobotTimbrePlayerManager robotTimbrePlayerManager = new RobotTimbrePlayerManager();
                final AdelieTtsPlayerManager adelieTtsPlayerManager = AdelieTtsPlayerManager.this;
                robotTimbrePlayerManager.p(new Function1<TtsInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPlayerManager$mTimbrePlayerManager$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo) {
                        invoke2(ttsInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo ttsInfo) {
                        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
                        QLog.i("AdelieTtsPlayerManager", 1, "AdelieTtsPlayerManager onDownloadStart id=" + ttsInfo.ttsId);
                        AdelieTtsPlayerManager.g(AdelieTtsPlayerManager.this, 0, false, 2, null);
                    }
                });
                robotTimbrePlayerManager.o(new Function2<Boolean, TtsInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPlayerManager$mTimbrePlayerManager$2$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TtsInfo ttsInfo) {
                        invoke(bool.booleanValue(), ttsInfo);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull TtsInfo ttsInfo) {
                        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
                        QLog.i("AdelieTtsPlayerManager", 1, "AdelieTtsPlayerManager onDownloadCompleted success=" + z16 + " id=" + ttsInfo.ttsId);
                        AdelieTtsPlayerManager.this.f(1, z16);
                    }
                });
                robotTimbrePlayerManager.t(new Function1<TtsInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPlayerManager$mTimbrePlayerManager$2$1$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo) {
                        invoke2(ttsInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo ttsInfo) {
                        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
                        QLog.i("AdelieTtsPlayerManager", 1, "AdelieTtsPlayerManager onStartPlay id=" + ttsInfo.ttsId);
                        AdelieTtsPlayerManager.g(AdelieTtsPlayerManager.this, 2, false, 2, null);
                    }
                });
                robotTimbrePlayerManager.k(new Function1<TtsInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPlayerManager$mTimbrePlayerManager$2$1$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo) {
                        invoke2(ttsInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo ttsInfo) {
                        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
                        QLog.i("AdelieTtsPlayerManager", 1, "AdelieTtsPlayerManager onCancelPlay id=" + ttsInfo.ttsId);
                        AdelieTtsPlayerManager.g(AdelieTtsPlayerManager.this, 4, false, 2, null);
                    }
                });
                robotTimbrePlayerManager.l(new Function1<TtsInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPlayerManager$mTimbrePlayerManager$2$1$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo) {
                        invoke2(ttsInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo ttsInfo) {
                        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
                        QLog.i("AdelieTtsPlayerManager", 1, "AdelieTtsPlayerManager onCompletedPlay id=" + ttsInfo.ttsId);
                        AdelieTtsPlayerManager.g(AdelieTtsPlayerManager.this, 3, false, 2, null);
                    }
                });
                robotTimbrePlayerManager.r(new Function2<TtsInfo, String, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPlayerManager$mTimbrePlayerManager$2$1$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(TtsInfo ttsInfo, String str) {
                        invoke2(ttsInfo, str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull TtsInfo ttsInfo, @NotNull String msg2) {
                        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        QLog.i("AdelieTtsPlayerManager", 1, "AdelieTtsPlayerManager onPlayFailed id=" + ttsInfo.ttsId + " errMsg=" + msg2);
                        AdelieTtsPlayerManager.g(AdelieTtsPlayerManager.this, 5, false, 2, null);
                    }
                });
                return robotTimbrePlayerManager;
            }
        });
        this.mTimbrePlayerManager = lazy;
    }

    private final void e(Function1<Object, Unit> function1, String str) {
        if (function1 != null) {
            function1.invoke(new Gson().toJson(new KuiklyRenderCallbackData(true, str, null, 4, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int state, boolean success) {
        String i3 = i(state, success);
        Function1<Object, Unit> function1 = this.kuiklyCallback;
        if (function1 != null) {
            e(function1, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(AdelieTtsPlayerManager adelieTtsPlayerManager, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        adelieTtsPlayerManager.f(i3, z16);
    }

    private final RobotTimbrePlayerManager h() {
        return (RobotTimbrePlayerManager) this.mTimbrePlayerManager.getValue();
    }

    private final String i(int state, boolean success) {
        String str;
        JSONObject jSONObject = new JSONObject();
        TtsInfo ttsInfo = this.selectTtsInfo;
        if (ttsInfo != null) {
            str = ttsInfo.ttsId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        jSONObject.put("tts_play_state", state);
        jSONObject.put("result", success);
        jSONObject.put("tts_id", str);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AdelieTtsPlayerManager this$0, TtsInfo tts) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tts, "$tts");
        this$0.h().y(tts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final AdelieTtsPlayerManager this$0, final TtsInfo ttsInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsInfo, "$ttsInfo");
        if (this$0.h().i()) {
            this$0.h().y(ttsInfo);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.sound.c
            @Override // java.lang.Runnable
            public final void run() {
                AdelieTtsPlayerManager.n(AdelieTtsPlayerManager.this, ttsInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AdelieTtsPlayerManager this$0, TtsInfo ttsInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsInfo, "$ttsInfo");
        this$0.h().v(ttsInfo);
    }

    public final void j() {
        h().m();
        h().s();
    }

    public final void k(@NotNull final TtsInfo ttsInfo, @Nullable Function1<Object, Unit> callback) {
        boolean z16;
        final TtsInfo ttsInfo2;
        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
        this.kuiklyCallback = callback;
        if (Intrinsics.areEqual(ttsInfo.ttsId, "none_voice") && (ttsInfo2 = this.selectTtsInfo) != null && ttsInfo2 != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.sound.a
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieTtsPlayerManager.l(AdelieTtsPlayerManager.this, ttsInfo2);
                }
            });
        }
        this.selectTtsInfo = ttsInfo;
        String str = ttsInfo.ttsExample;
        Intrinsics.checkNotNullExpressionValue(str, "ttsInfo.ttsExample");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.sound.b
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieTtsPlayerManager.m(AdelieTtsPlayerManager.this, ttsInfo);
                }
            });
        }
    }

    public final void o(@NotNull TtsInfo ttsInfo) {
        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
        h().y(ttsInfo);
    }
}
