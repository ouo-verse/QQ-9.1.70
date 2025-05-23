package com.tencent.opentelemetry.otlp.common;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.AttributeType;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.function.BiConsumer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class JsonCommonAdapter {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.opentelemetry.otlp.common.JsonCommonAdapter$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AppConstants.VALUE.UIN_TYPE_DEVICE);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AttributeType.values().length];
            $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType = iArr;
            try {
                iArr[AttributeType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType[AttributeType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType[AttributeType.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType[AttributeType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType[AttributeType.BOOLEAN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType[AttributeType.LONG_ARRAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType[AttributeType.DOUBLE_ARRAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$opentelemetry$api$common$AttributeType[AttributeType.STRING_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    JsonCommonAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toProtoResource$0(JSONArray jSONArray, AttributeKey attributeKey, Object obj) {
        try {
            jSONArray.mo162put(toJsonAttribute(attributeKey, obj));
        } catch (JSONException unused) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e("JsonCommonAdapter", "toProtoResource error");
            }
        }
    }

    static JSONArray makeBooleanArrayAnyValue(List<Boolean> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Boolean bool : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bool_value", bool);
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    private static JSONObject makeBooleanArrayKeyValue(AttributeKey<?> attributeKey, List<Boolean> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", attributeKey.getKey());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("array_value", makeBooleanArrayAnyValue(list));
        jSONObject.put("value", jSONObject2);
        return jSONObject;
    }

    private static JSONObject makeBooleanKeyValue(AttributeKey<?> attributeKey, boolean z16) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", attributeKey.getKey());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("bool_value", z16);
        jSONObject.put("value", jSONObject2);
        return jSONObject;
    }

    static JSONArray makeDoubleArrayAnyValue(List<Double> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Double d16 : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("int_value", d16);
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    private static JSONObject makeDoubleArrayKeyValue(AttributeKey<?> attributeKey, List<Double> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", attributeKey.getKey());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("array_value", makeDoubleArrayAnyValue(list));
        jSONObject.put("value", jSONObject2);
        return jSONObject;
    }

    private static JSONObject makeDoubleKeyValue(AttributeKey<?> attributeKey, Double d16) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", attributeKey.getKey());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("double_value", d16);
        jSONObject.put("value", jSONObject2);
        return jSONObject;
    }

    static JSONArray makeLongArrayAnyValue(List<Long> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Long l3 : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("int_value", l3);
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    private static JSONObject makeLongArrayKeyValue(AttributeKey<?> attributeKey, List<Long> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", attributeKey.getKey());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("array_value", makeLongArrayAnyValue(list));
        jSONObject.put("value", jSONObject2);
        return jSONObject;
    }

    private static JSONObject makeLongKeyValue(AttributeKey<?> attributeKey, Long l3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", attributeKey.getKey());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("int_value", l3);
        jSONObject.put("value", jSONObject2);
        return jSONObject;
    }

    static JSONArray makeStringArrayAnyValue(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("string_value", str);
            jSONArray.mo162put(jSONObject);
        }
        return jSONArray;
    }

    private static JSONObject makeStringArrayKeyValue(AttributeKey<?> attributeKey, List<String> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", attributeKey.getKey());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("array_value", makeStringArrayAnyValue(list));
        jSONObject.put("value", jSONObject2);
        return jSONObject;
    }

    static JSONObject makeStringKeyValue(AttributeKey<?> attributeKey, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", attributeKey.getKey());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("string_value", str);
        jSONObject.put("value", jSONObject2);
        return jSONObject;
    }

    public static JSONObject toJsonAttribute(AttributeKey<?> attributeKey, Object obj) throws JSONException {
        switch (AnonymousClass1.$SwitchMap$com$tencent$opentelemetry$api$common$AttributeType[attributeKey.getType().ordinal()]) {
            case 1:
                return makeStringKeyValue(attributeKey, (String) obj);
            case 2:
                return makeBooleanKeyValue(attributeKey, ((Boolean) obj).booleanValue());
            case 3:
                return makeLongKeyValue(attributeKey, (Long) obj);
            case 4:
                return makeDoubleKeyValue(attributeKey, (Double) obj);
            case 5:
                return makeBooleanArrayKeyValue(attributeKey, (List) obj);
            case 6:
                return makeLongArrayKeyValue(attributeKey, (List) obj);
            case 7:
                return makeDoubleArrayKeyValue(attributeKey, (List) obj);
            case 8:
                return makeStringArrayKeyValue(attributeKey, (List) obj);
            default:
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", attributeKey.getKey());
                jSONObject.put("value", new JSONObject());
                return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject toProtoInstrumentationLibrary(InstrumentationScopeInfo instrumentationScopeInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", instrumentationScopeInfo.getName());
        if (instrumentationScopeInfo.getVersion() != null) {
            jSONObject.put("version", instrumentationScopeInfo.getVersion());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject toProtoResource(Resource resource) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        final JSONArray jSONArray = new JSONArray();
        resource.getAttributes().forEach(new BiConsumer() { // from class: com.tencent.opentelemetry.otlp.common.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                JsonCommonAdapter.lambda$toProtoResource$0(JSONArray.this, (AttributeKey) obj, obj2);
            }
        });
        jSONObject.put("attributes", jSONArray);
        return jSONObject;
    }
}
