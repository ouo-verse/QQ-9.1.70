package com.tencent.tdf.module;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.utils.TDFParamsUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
class TDFMethodInfo {
    static IPatchRedirector $redirector_;
    private final boolean mIsSync;

    @NonNull
    private final Method mMethod;

    @Nullable
    private final Type[] mParamTypes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TDFMethodInfo(@NonNull Method method, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, method, Boolean.valueOf(z16));
            return;
        }
        this.mMethod = method;
        this.mParamTypes = method.getGenericParameterTypes();
        this.mIsSync = z16;
    }

    private Object[] prepareArguments(@NonNull List<Object> list, TDFModulePromise tDFModulePromise) {
        Type[] typeArr = this.mParamTypes;
        if (typeArr != null && typeArr.length != 0) {
            int length = typeArr.length;
            Object[] objArr = new Object[length];
            int i3 = 0;
            int i16 = 0;
            while (true) {
                Type[] typeArr2 = this.mParamTypes;
                if (i3 < typeArr2.length) {
                    Type type = typeArr2[i3];
                    if (type == TDFModulePromise.class) {
                        objArr[i3] = tDFModulePromise;
                    } else if (length > i16) {
                        objArr[i3] = TDFParamsUtils.parseParams(list, type, i16);
                        i16++;
                    } else {
                        throw new IllegalArgumentException("The number of parameters does not match");
                    }
                    i3++;
                } else {
                    return objArr;
                }
            }
        } else {
            return null;
        }
    }

    public Object invoke(@NonNull Object obj, List<Object> list, TDFModulePromise tDFModulePromise) throws Exception {
        Object[] objArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, obj, list, tDFModulePromise);
        }
        if (list != null) {
            objArr = prepareArguments(list, tDFModulePromise);
        } else {
            objArr = null;
        }
        return this.mMethod.invoke(obj, objArr);
    }

    public boolean isSync() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mIsSync;
    }
}
