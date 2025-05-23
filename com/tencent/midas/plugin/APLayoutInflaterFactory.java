package com.tencent.midas.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.reflect.Constructor;
import java.util.HashMap;

@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class APLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private final HashMap<String, Constructor<? extends View>> constructorMap = new HashMap<>();
    private final Class<?>[] constructorSign = {Context.class, AttributeSet.class};
    private final Object[] constructorArgs = new Object[2];

    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085 A[Catch: all -> 0x0069, TryCatch #5 {all -> 0x0069, blocks: (B:35:0x0032, B:37:0x0040, B:13:0x0055, B:28:0x006e, B:31:0x0089, B:32:0x0096, B:33:0x0085, B:21:0x0098, B:22:0x00b9, B:18:0x00bb, B:19:0x00dc, B:24:0x00de, B:25:0x00fc), top: B:9:0x0030, inners: #6 }] */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Class cls;
        Class cls2;
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, Constants.Service.CLASS);
        }
        if (-1 == str.indexOf(46)) {
            return null;
        }
        Object[] objArr = this.constructorArgs;
        Context context2 = (Context) objArr[0];
        objArr[0] = context;
        Constructor<? extends View> constructor = this.constructorMap.get(str);
        try {
            if (constructor == null) {
                try {
                    try {
                        cls = context.getClassLoader().loadClass(str).asSubclass(View.class);
                    } catch (ClassCastException e16) {
                        InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Class is not a View " + str);
                        inflateException.initCause(e16);
                        throw inflateException;
                    } catch (ClassNotFoundException e17) {
                        InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Class not found " + str);
                        inflateException2.initCause(e17);
                        throw inflateException2;
                    } catch (NoSuchMethodException e18) {
                        InflateException inflateException3 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        inflateException3.initCause(e18);
                        throw inflateException3;
                    }
                } catch (Exception e19) {
                    e = e19;
                    cls = null;
                }
                try {
                    Constructor<? extends View> constructor2 = cls.getConstructor(this.constructorSign);
                    this.constructorMap.put(str, constructor2);
                    cls2 = cls;
                    constructor = constructor2;
                } catch (Exception e26) {
                    e = e26;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(attributeSet.getPositionDescription());
                    sb5.append(": Error inflating class ");
                    sb5.append(cls != null ? "<unknown>" : cls.getName());
                    InflateException inflateException4 = new InflateException(sb5.toString());
                    inflateException4.initCause(e);
                    throw inflateException4;
                }
            } else {
                cls2 = null;
            }
            try {
                Object[] objArr2 = this.constructorArgs;
                objArr2[1] = attributeSet;
                constructor.setAccessible(true);
                return constructor.newInstance(objArr2);
            } catch (Exception e27) {
                e = e27;
                cls = cls2;
                StringBuilder sb52 = new StringBuilder();
                sb52.append(attributeSet.getPositionDescription());
                sb52.append(": Error inflating class ");
                sb52.append(cls != null ? "<unknown>" : cls.getName());
                InflateException inflateException42 = new InflateException(sb52.toString());
                inflateException42.initCause(e);
                throw inflateException42;
            }
        } finally {
            Object[] objArr3 = this.constructorArgs;
            objArr3[0] = context2;
            objArr3[1] = null;
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
