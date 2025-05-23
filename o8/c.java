package o8;

import android.os.Bundle;
import android.os.Parcelable;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.PictureManager;
import com.tencent.common.config.AppSetting;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, SoftReference<Callback>> f422208a = new ConcurrentHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Class[], java.io.Serializable] */
    private void e(Method method, Object[] objArr) {
        Bundle bundle = new Bundle();
        bundle.putString("methodName", method.getName());
        bundle.putInt("methodParamSize", method.getParameterTypes().length);
        bundle.putSerializable("methodParamTypes", method.getParameterTypes());
        int a16 = a(bundle, objArr);
        if (b(a16, objArr)) {
            bundle.putInt("callbackIndex", a16);
        }
        int sendData = PictureManager.getInstance().sendData(bundle);
        QZLog.d("RpcInvocationHandler", 1, "sendMsg reqId =  " + sendData);
        if (b(a16, objArr)) {
            if (this.f422208a == null) {
                this.f422208a = new ConcurrentHashMap();
            }
            this.f422208a.put(Integer.valueOf(sendData), new SoftReference<>((Callback) objArr[a16]));
        }
    }

    public void c() {
        Map<Integer, SoftReference<Callback>> map = this.f422208a;
        if (map != null) {
            map.clear();
            this.f422208a = null;
        }
    }

    public void d(int i3, Bundle bundle) {
        QZLog.d("RpcInvocationHandler", 1, "onRecvReply reqId =  " + i3);
        if (bundle != null) {
            SoftReference<Callback> remove = this.f422208a.remove(Integer.valueOf(i3));
            Object obj = bundle.get("data");
            if (remove == null || remove.get() == null || obj == null) {
                return;
            }
            if (obj instanceof ParcelableWrapper) {
                obj = ((ParcelableWrapper) obj).getData();
            }
            if (obj instanceof QZoneResult) {
                remove.get().onResult(obj);
            } else {
                if (obj instanceof Parcelable) {
                    remove.get().onResult(obj);
                    return;
                }
                throw new IllegalArgumentException("RpcInvocationHandler: args are not Parcelable or base type, can not be transfered! onRecvReply");
            }
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        e(method, objArr);
        return null;
    }

    private int a(Bundle bundle, Object[] objArr) {
        int i3 = -1;
        if (objArr != null && objArr.length > 0) {
            for (int i16 = 0; i16 < objArr.length; i16++) {
                if (objArr[i16] instanceof Callback) {
                    i3 = i16;
                } else {
                    String str = "paramKey" + String.valueOf(i16);
                    Object obj = objArr[i16];
                    if (obj instanceof String) {
                        bundle.putString(str, (String) obj);
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str, ((Double) obj).doubleValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Serializable) {
                        bundle.putSerializable(str, (Serializable) obj);
                    } else if (obj instanceof Parcelable) {
                        bundle.putParcelable(str, (Parcelable) obj);
                    } else if (obj instanceof SmartParcelable) {
                        ParcelableWrapper.putDataToBundle(bundle, str, (SmartParcelable) obj);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) obj;
                        if (!arrayList.isEmpty()) {
                            Object obj2 = arrayList.get(0);
                            if (obj2 instanceof Parcelable) {
                                bundle.putParcelableArrayList(str, (ArrayList) objArr[i16]);
                            } else if (obj2 instanceof String) {
                                bundle.putStringArrayList(str, (ArrayList) objArr[i16]);
                            } else if (obj2 instanceof Integer) {
                                bundle.putIntegerArrayList(str, (ArrayList) objArr[i16]);
                            }
                        }
                    } else if (!AppSetting.s()) {
                        QLog.e("RpcInvocationHandler", 1, "IllegalArgumentException : args are not Parcelable or base type, can not be transfered!", new IllegalArgumentException());
                    } else {
                        throw new IllegalArgumentException("RpcInvocationHandler: args are not Parcelable or base type, can not be transfered!");
                    }
                }
            }
        }
        return i3;
    }

    private boolean b(int i3, Object[] objArr) {
        return i3 >= 0 && objArr != null && i3 < objArr.length;
    }
}
