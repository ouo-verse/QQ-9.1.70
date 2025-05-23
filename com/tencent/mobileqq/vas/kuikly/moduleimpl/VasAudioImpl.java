package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.ark.ark;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.vas.api.IVasAudioApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0016J=\u0010$\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052+\u0010#\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001ej\u0004\u0018\u0001`\"H\u0016J=\u0010%\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052+\u0010#\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001ej\u0004\u0018\u0001`\"H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/VasAudioImpl;", "", "value", "", "v", "", "bookId", "", "j", "a", "path", "b", ark.ARKMETADATA_JSON, "l", "i", "token", "k", DomainData.DOMAIN_NAME, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "p", "g", tl.h.F, "e", "c", "d", "t", "f", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAudioImpl {
    private final float v(Object value) {
        if (value instanceof Integer) {
            return ((Number) value).intValue();
        }
        if (value instanceof Double) {
            return (float) ((Number) value).doubleValue();
        }
        if (value instanceof String) {
            return Float.parseFloat((String) value);
        }
        if (value instanceof Float) {
            return ((Number) value).floatValue();
        }
        return 0.0f;
    }

    public void a() {
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).closeLogic();
    }

    @NotNull
    public String b(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).create(path);
    }

    @NotNull
    public String c(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        IVasAudioApi iVasAudioApi = (IVasAudioApi) QRoute.api(IVasAudioApi.class);
        String optString = jSONObject.optString("token");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"token\")");
        String optString2 = jSONObject.optString("path");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"path\")");
        return String.valueOf(iVasAudioApi.getAudioDuration(optString, optString2));
    }

    @NotNull
    public String d(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return String.valueOf(((IVasAudioApi) QRoute.api(IVasAudioApi.class)).getCurrentPosition(token));
    }

    @NotNull
    public String e(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return String.valueOf(((IVasAudioApi) QRoute.api(IVasAudioApi.class)).getDuration(token));
    }

    public float f(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        return ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).getVolume(token);
    }

    @NotNull
    public String g(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        if (((IVasAudioApi) QRoute.api(IVasAudioApi.class)).isLooping(token)) {
            return "1";
        }
        return "0";
    }

    @NotNull
    public String h(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        if (((IVasAudioApi) QRoute.api(IVasAudioApi.class)).isPlaying(token)) {
            return "1";
        }
        return "0";
    }

    public void i(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).next(path);
    }

    public void j(@NotNull String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).openLogic(bookId);
    }

    public void k(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).pause(token);
    }

    public void l(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        IVasAudioApi iVasAudioApi = (IVasAudioApi) QRoute.api(IVasAudioApi.class);
        String optString = jSONObject.optString("token");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"token\")");
        String optString2 = jSONObject.optString("path");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"path\")");
        iVasAudioApi.play(optString, optString2);
    }

    public void m(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).release(token);
    }

    public void n(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).resume(token);
    }

    public void o(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        IVasAudioApi iVasAudioApi = (IVasAudioApi) QRoute.api(IVasAudioApi.class);
        String optString = jSONObject.optString("token");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"token\")");
        iVasAudioApi.seekTo(optString, jSONObject.optInt(com.tencent.luggage.wxa.c8.c.G));
    }

    public void p(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        IVasAudioApi iVasAudioApi = (IVasAudioApi) QRoute.api(IVasAudioApi.class);
        String optString = jSONObject.optString("token");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"token\")");
        iVasAudioApi.setLoop(optString, jSONObject.optBoolean("isLoop"));
    }

    public void q(@NotNull String token, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(token, "token");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).setOnErrorListener(token, new Function2<Integer, Integer, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.VasAudioImpl$setOnErrorListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, int i16) {
                Map mapOf;
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("what", Integer.valueOf(i3)), TuplesKt.to("code", Integer.valueOf(i16)));
                    function1.invoke(mapOf);
                }
            }
        });
    }

    public void r(@NotNull String token, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(token, "token");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).setPlayStateListener(token, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.VasAudioImpl$setPlayStateListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Map mapOf;
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("state", Integer.valueOf(i3)));
                    function1.invoke(mapOf);
                }
            }
        });
    }

    public void s(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        IVasAudioApi iVasAudioApi = (IVasAudioApi) QRoute.api(IVasAudioApi.class);
        String optString = jSONObject.optString("token");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"token\")");
        iVasAudioApi.setSpeed(optString, v(jSONObject.opt("speed")));
    }

    public void t(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        IVasAudioApi iVasAudioApi = (IVasAudioApi) QRoute.api(IVasAudioApi.class);
        String optString = jSONObject.optString("token");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"token\")");
        iVasAudioApi.setVolume(optString, v(jSONObject.opt(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME)));
    }

    public void u(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).stop(token);
    }
}
