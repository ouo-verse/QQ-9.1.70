package com.tencent.robot.adelie.kuikly.module;

import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPlayerManager;
import com.tencent.robot.adelie.kuikly.module.p;
import com.tencent.robot.adelie.kuikly.view.record.AdelieUploadFile;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import x14.c;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JM\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/module/AdelieKuiklyTTSPageModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "g", "j", "audioUrl", "", "success", "msg", "i", "method", "call", "Lcom/tencent/robot/adelie/homepage/create/sound/AdelieTtsPlayerManager;", "Lkotlin/Lazy;", "c", "()Lcom/tencent/robot/adelie/homepage/create/sound/AdelieTtsPlayerManager;", "ttsPlayerManger", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieKuiklyTTSPageModule extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy ttsPlayerManger;

    public AdelieKuiklyTTSPageModule() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieTtsPlayerManager>() { // from class: com.tencent.robot.adelie.kuikly.module.AdelieKuiklyTTSPageModule$ttsPlayerManger$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AdelieTtsPlayerManager invoke() {
                AdelieTtsPlayerManager adelieTtsPlayerManager = new AdelieTtsPlayerManager();
                adelieTtsPlayerManager.j();
                return adelieTtsPlayerManager;
            }
        });
        this.ttsPlayerManger = lazy;
    }

    private final AdelieTtsPlayerManager c() {
        return (AdelieTtsPlayerManager) this.ttsPlayerManger.getValue();
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        boolean z16;
        Object obj;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyTTSPageModule", 1, "call playTts params is null, return");
            return;
        }
        p.Companion companion = p.INSTANCE;
        try {
            obj = new Gson().fromJson(params, (Class<Object>) AdelieTtsInfo.class);
        } catch (Exception e16) {
            QLog.e("AdelieModuleData", 1, "AdelieModuleData fromJson exception = " + e16);
            obj = null;
        }
        AdelieTtsInfo adelieTtsInfo = (AdelieTtsInfo) obj;
        if (adelieTtsInfo == null) {
            return;
        }
        TtsInfo ttsInfo = new TtsInfo();
        ttsInfo.ttsIcon = "";
        ttsInfo.ttsId = adelieTtsInfo.getTtsId();
        ttsInfo.ttsName = adelieTtsInfo.getTtsName();
        ttsInfo.ttsExample = adelieTtsInfo.getTtsExample();
        c().k(ttsInfo, callback);
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        boolean z16;
        Object obj;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("AdelieKuiklyTTSPageModule", 1, "call playTts params is null, return");
            return;
        }
        p.Companion companion = p.INSTANCE;
        try {
            obj = new Gson().fromJson(params, (Class<Object>) AdelieTtsInfo.class);
        } catch (Exception e16) {
            QLog.e("AdelieModuleData", 1, "AdelieModuleData fromJson exception = " + e16);
            obj = null;
        }
        AdelieTtsInfo adelieTtsInfo = (AdelieTtsInfo) obj;
        if (adelieTtsInfo == null) {
            return;
        }
        TtsInfo ttsInfo = new TtsInfo();
        ttsInfo.ttsIcon = "";
        ttsInfo.ttsId = adelieTtsInfo.getTtsId();
        ttsInfo.ttsName = adelieTtsInfo.getTtsName();
        ttsInfo.ttsExample = adelieTtsInfo.getTtsExample();
        c().o(ttsInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String audioUrl, boolean success, String msg2, Function1<Object, Unit> callback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("audioUrl", audioUrl);
        jSONObject.put("success", success);
        jSONObject.put("msg", msg2);
        if (callback != null) {
            r.d(callback, jSONObject.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0018 A[Catch: Exception -> 0x0013, TryCatch #0 {Exception -> 0x0013, blocks: (B:18:0x000a, B:5:0x0018, B:8:0x001f, B:12:0x0035, B:14:0x003c), top: B:17:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f A[Catch: Exception -> 0x0013, TryCatch #0 {Exception -> 0x0013, blocks: (B:18:0x000a, B:5:0x0018, B:8:0x001f, B:12:0x0035, B:14:0x003c), top: B:17:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17 = true;
        if (params != null) {
            try {
                if (params.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        i("", false, "\u53c2\u6570\u4e3a\u7a7a", callback);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(params);
                    String filePath = jSONObject.optString("filePath");
                    Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
                    if (filePath.length() != 0) {
                        z17 = false;
                    }
                    if (z17) {
                        i("", false, "\u8def\u5f84\u4e3a\u7a7a", callback);
                        return;
                    }
                    int optInt = jSONObject.optInt("commandId");
                    String optString = jSONObject.optString("remoteDir");
                    Intrinsics.checkNotNullExpressionValue(optString, "paramJson.optString(\"remoteDir\")");
                    new AdelieUploadFile().d(new c.TaskParam(filePath, optInt, optString, null, 8, null), new Function1<String, Unit>() { // from class: com.tencent.robot.adelie.kuikly.module.AdelieKuiklyTTSPageModule$uploadFile$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String url) {
                            Intrinsics.checkNotNullParameter(url, "url");
                            AdelieKuiklyTTSPageModule.this.i(url, true, "", callback);
                        }
                    });
                    return;
                }
            } catch (Exception e16) {
                i("", false, e16.toString(), callback);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1919305439) {
            if (hashCode != -1446843821) {
                if (hashCode == -243495139 && method.equals("uploadFile")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("playTtsVoice")) {
                d(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("stopTtsVoice")) {
            g(params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
