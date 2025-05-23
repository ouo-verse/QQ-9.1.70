package com.tencent.mobileqq.qwallet.pet.h5event;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00102\u00020\u0001:\u0003\u0003\u0011\u0012B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "method", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "c", "()Lorg/json/JSONObject;", "rawJSON", "callback", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V", "d", "PetBroadcastEvent", "ToH5DispatchEvent", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PetH5Method {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String method;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject rawJSON;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String callback;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method$PetBroadcastEvent;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "PlayActionStart", "PlayActionFinish", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public enum PetBroadcastEvent {
        PlayActionStart,
        PlayActionFinish;


        @NotNull
        public static final String EXTRA_KEY_ACTION_TYPE = "actionType";
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method$ToH5DispatchEvent;", "", "(Ljava/lang/String;I)V", "NativeSceneLoadComplete", "OnPetTouch", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum ToH5DispatchEvent {
        NativeSceneLoadComplete,
        OnPetTouch
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method$a;", "", "", "jsonData", "Lcom/tencent/mobileqq/qwallet/pet/h5event/PetH5Method;", "a", "DATA_EXTRA_CALLBACK", "Ljava/lang/String;", "DATA_EXTRA_METHOD", "DISPATCH_DATA_KEY", "DISPATCH_EVENT_NAME", "TAG", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.h5event.PetH5Method$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final PetH5Method a(@Nullable String jsonData) {
            if (jsonData == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonData);
                String optString = jSONObject.optString("method", "");
                Intrinsics.checkNotNullExpressionValue(optString, "dataJSON.optString(DATA_EXTRA_METHOD, \"\")");
                return new PetH5Method(optString, jSONObject, jSONObject.optString("callback"));
            } catch (JSONException unused) {
                QLog.w("QWallet.Pet.PetH5Method", 1, "parse");
                return null;
            }
        }

        Companion() {
        }
    }

    public PetH5Method(@NotNull String method, @NotNull JSONObject rawJSON, @Nullable String str) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(rawJSON, "rawJSON");
        this.method = method;
        this.rawJSON = rawJSON;
        this.callback = str;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCallback() {
        return this.callback;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final JSONObject getRawJSON() {
        return this.rawJSON;
    }
}
