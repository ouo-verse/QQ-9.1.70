package com.tencent.tdf.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public class TDFParamsUtils {
    static IPatchRedirector $redirector_;

    public TDFParamsUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean isListType(Type type) {
        if (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != List.class) {
            return false;
        }
        return true;
    }

    private static boolean isMapType(Type type) {
        if (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != Map.class) {
            return false;
        }
        return true;
    }

    public static Object parseParams(List<Object> list, Type type, int i3) {
        if (type == String.class) {
            return TDFListUtils.getString(list, i3);
        }
        if (type != Integer.TYPE && type != Integer.class) {
            if (type != Long.TYPE && type != Long.class) {
                if (type != Double.TYPE && type != Double.class) {
                    if (type != Boolean.TYPE && type != Boolean.class) {
                        if (type != Float.TYPE && type != Float.class) {
                            if (isListType(type)) {
                                return TDFListUtils.getArray(list, i3);
                            }
                            if (isMapType(type)) {
                                return TDFListUtils.getMap(list, i3);
                            }
                            throw new IllegalArgumentException("parseArgument exception, index: " + i3 + " paramType: " + type);
                        }
                        return Float.valueOf(TDFListUtils.getFloat(list, i3));
                    }
                    return Boolean.valueOf(TDFListUtils.getBoolean(list, i3));
                }
                return Double.valueOf(TDFListUtils.getDouble(list, i3));
            }
            return Long.valueOf(TDFListUtils.getLong(list, i3));
        }
        return Integer.valueOf(TDFListUtils.getInt(list, i3));
    }
}
