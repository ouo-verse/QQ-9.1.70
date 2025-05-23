package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.tencent.ams.hippo.quickjs.android.TypeAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes3.dex */
class StandardTypeAdapters {
    static IPatchRedirector $redirector_;
    private static final TypeAdapter<Boolean> BOOLEAN_TYPE_ADAPTER;
    private static final TypeAdapter<Byte> BYTE_TYPE_ADAPTER;
    private static final TypeAdapter<Character> CHARACTER_TYPE_ADAPTER;
    private static final TypeAdapter<Double> DOUBLE_TYPE_ADAPTER;
    static final TypeAdapter.Factory FACTORY;
    private static final TypeAdapter<Float> FLOAT_TYPE_ADAPTER;
    private static final TypeAdapter<Integer> INTEGER_TYPE_ADAPTER;
    private static final TypeAdapter<Long> LONG_TYPE_ADAPTER;
    private static final TypeAdapter<Short> SHORT_TYPE_ADAPTER;
    private static final TypeAdapter<String> STRING_TYPE_ADAPTER;
    private static final TypeAdapter<Void> VOID_TYPE_ADAPTER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14890);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        FACTORY = new TypeAdapter.Factory() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter.Factory
            @Nullable
            public TypeAdapter<?> create(QuickJS quickJS, Type type) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (TypeAdapter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) quickJS, (Object) type);
                }
                if (type == Void.TYPE) {
                    return StandardTypeAdapters.VOID_TYPE_ADAPTER;
                }
                if (type == Boolean.TYPE) {
                    return StandardTypeAdapters.BOOLEAN_TYPE_ADAPTER;
                }
                if (type == Byte.TYPE) {
                    return StandardTypeAdapters.BYTE_TYPE_ADAPTER;
                }
                if (type == Character.TYPE) {
                    return StandardTypeAdapters.CHARACTER_TYPE_ADAPTER;
                }
                if (type == Short.TYPE) {
                    return StandardTypeAdapters.SHORT_TYPE_ADAPTER;
                }
                if (type == Integer.TYPE) {
                    return StandardTypeAdapters.INTEGER_TYPE_ADAPTER;
                }
                if (type == Long.TYPE) {
                    return StandardTypeAdapters.LONG_TYPE_ADAPTER;
                }
                if (type == Float.TYPE) {
                    return StandardTypeAdapters.FLOAT_TYPE_ADAPTER;
                }
                if (type == Double.TYPE) {
                    return StandardTypeAdapters.DOUBLE_TYPE_ADAPTER;
                }
                if (type == Void.class) {
                    return StandardTypeAdapters.VOID_TYPE_ADAPTER;
                }
                if (type == Boolean.class) {
                    return StandardTypeAdapters.BOOLEAN_TYPE_ADAPTER.nullable();
                }
                if (type == Byte.class) {
                    return StandardTypeAdapters.BYTE_TYPE_ADAPTER.nullable();
                }
                if (type == Character.class) {
                    return StandardTypeAdapters.CHARACTER_TYPE_ADAPTER.nullable();
                }
                if (type == Short.class) {
                    return StandardTypeAdapters.SHORT_TYPE_ADAPTER.nullable();
                }
                if (type == Integer.class) {
                    return StandardTypeAdapters.INTEGER_TYPE_ADAPTER.nullable();
                }
                if (type == Long.class) {
                    return StandardTypeAdapters.LONG_TYPE_ADAPTER.nullable();
                }
                if (type == Float.class) {
                    return StandardTypeAdapters.FLOAT_TYPE_ADAPTER.nullable();
                }
                if (type == Double.class) {
                    return StandardTypeAdapters.DOUBLE_TYPE_ADAPTER.nullable();
                }
                if (type == String.class) {
                    return StandardTypeAdapters.STRING_TYPE_ADAPTER.nullable();
                }
                return null;
            }
        };
        VOID_TYPE_ADAPTER = new TypeAdapter<Void>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Void fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Void) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
                }
                if ((jSValue instanceof JSNull) || (jSValue instanceof JSUndefined)) {
                    return null;
                }
                throw new JSDataException("excepted: JSNull or JSUndefined, actual: " + jSValue.getClass().getSimpleName());
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Void r56) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSNull() : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) r56);
            }
        };
        BOOLEAN_TYPE_ADAPTER = new TypeAdapter<Boolean>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Boolean fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? Boolean.valueOf(((JSBoolean) jSValue.cast(JSBoolean.class)).getBoolean()) : (Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Boolean bool) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSBoolean(bool.booleanValue()) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) bool);
            }
        };
        BYTE_TYPE_ADAPTER = new TypeAdapter<Byte>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Byte fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? Byte.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getByte()) : (Byte) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Byte b16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSNumber((int) b16.byteValue()) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) b16);
            }
        };
        CHARACTER_TYPE_ADAPTER = new TypeAdapter<Character>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Character fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Character) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
                }
                String string = ((JSString) jSValue.cast(JSString.class)).getString();
                if (string.length() == 1) {
                    return Character.valueOf(string.charAt(0));
                }
                throw new JSDataException("Can't treat \"" + string + "\" as char");
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Character ch5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSString(ch5.toString()) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) ch5);
            }
        };
        SHORT_TYPE_ADAPTER = new TypeAdapter<Short>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Short fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? Short.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getShort()) : (Short) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Short sh5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSNumber((int) sh5.shortValue()) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) sh5);
            }
        };
        INTEGER_TYPE_ADAPTER = new TypeAdapter<Integer>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Integer fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? Integer.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getInt()) : (Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSNumber(num.intValue()) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) num);
            }
        };
        LONG_TYPE_ADAPTER = new TypeAdapter<Long>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Long fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? Long.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getLong()) : (Long) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Long l3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSNumber(l3.longValue()) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) l3);
            }
        };
        FLOAT_TYPE_ADAPTER = new TypeAdapter<Float>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Float fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? Float.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getFloat()) : (Float) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Float f16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSNumber(f16.floatValue()) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) f16);
            }
        };
        DOUBLE_TYPE_ADAPTER = new TypeAdapter<Double>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public Double fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? Double.valueOf(((JSNumber) jSValue.cast(JSNumber.class)).getDouble()) : (Double) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, Double d16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSNumber(d16.doubleValue()) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) d16);
            }
        };
        STRING_TYPE_ADAPTER = new TypeAdapter<String>() { // from class: com.tencent.ams.hippo.quickjs.android.StandardTypeAdapters.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public String fromJSValue(JSContext jSContext, JSValue jSValue) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? ((JSString) jSValue.cast(JSString.class)).getString() : (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }

            @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
            public JSValue toJSValue(JSContext jSContext, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSContext.createJSString(str) : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) str);
            }
        };
    }

    StandardTypeAdapters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
