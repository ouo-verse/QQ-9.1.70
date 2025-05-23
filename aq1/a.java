package aq1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, AbsIpcMethod> f26723a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Class<? extends AbsIpcMethod>> f26724b;

    public a(@NonNull Map<String, Class<? extends AbsIpcMethod>> map) {
        this.f26723a = new HashMap();
        this.f26724b = new HashMap();
        for (Map.Entry<String, Class<? extends AbsIpcMethod>> entry : map.entrySet()) {
            String key = entry.getKey();
            Class<? extends AbsIpcMethod> value = entry.getValue();
            if (!d(value)) {
                this.f26724b.put(key, value);
            } else {
                try {
                    this.f26723a.put(key, value.newInstance());
                } catch (IllegalAccessException | InstantiationException e16) {
                    QLog.e("IpcMethodHandler", 1, value.getCanonicalName() + " newInstance() error!", e16);
                }
            }
        }
    }

    private AbsIpcMethod b(String str) {
        Class<? extends AbsIpcMethod> cls = this.f26724b.get(str);
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException | InstantiationException e16) {
                QLog.e("IpcMethodHandler", 1, "findIpcMethod: " + cls.getCanonicalName() + " newInstance() error!", e16);
            }
        }
        return this.f26723a.get(str);
    }

    private boolean d(Class<? extends AbsIpcMethod> cls) {
        AbsIpcMethod.IpcMethod ipcMethod = (AbsIpcMethod.IpcMethod) cls.getAnnotation(AbsIpcMethod.IpcMethod.class);
        if (ipcMethod != null && !ipcMethod.singleton()) {
            return false;
        }
        return true;
    }

    private static Map<String, Class<? extends AbsIpcMethod>> e(Class<? extends AbsIpcMethod>[] clsArr) {
        HashMap hashMap = new HashMap();
        for (Class<? extends AbsIpcMethod> cls : clsArr) {
            hashMap.put(cls.getCanonicalName(), cls);
        }
        return hashMap;
    }

    public boolean a(String str) {
        if (!this.f26724b.containsKey(str) && !this.f26723a.containsKey(str)) {
            return false;
        }
        return true;
    }

    public EIPCResult c(QIPCModule qIPCModule, String str, Bundle bundle, int i3) {
        AbsIpcMethod b16 = b(str);
        if (b16 != null) {
            return b16.b(qIPCModule, str, bundle, i3);
        }
        throw new IllegalArgumentException("can't not find method: " + str + " !");
    }

    @SafeVarargs
    public a(Class<? extends AbsIpcMethod>... clsArr) {
        this(e(clsArr));
    }
}
