package com.tencent.mapsdk.internal;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetFileResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetHead;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJceResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetJsonResolver;
import com.tencent.mapsdk.core.components.protocol.service.net.annotation.NetRequest;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.cp;
import com.tencent.mapsdk.internal.cp.a;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class dn<R extends cp.a> implements cp<R> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f148117a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f148118b = true;

    /* renamed from: c, reason: collision with root package name */
    public boolean f148119c = true;

    /* renamed from: d, reason: collision with root package name */
    private volatile R f148120d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f148121e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.dn$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f148122a;

        static {
            int[] iArr = new int[NetMethod.values().length];
            f148122a = iArr;
            try {
                iArr[NetMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f148122a[NetMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f148123a;

        /* renamed from: b, reason: collision with root package name */
        String f148124b;

        /* renamed from: c, reason: collision with root package name */
        String f148125c;

        /* renamed from: d, reason: collision with root package name */
        String f148126d;

        /* renamed from: e, reason: collision with root package name */
        String[] f148127e;

        /* renamed from: f, reason: collision with root package name */
        HashMap<String, String> f148128f;

        /* renamed from: g, reason: collision with root package name */
        String f148129g;

        /* renamed from: h, reason: collision with root package name */
        String f148130h;

        /* renamed from: i, reason: collision with root package name */
        int f148131i;

        /* renamed from: j, reason: collision with root package name */
        boolean f148132j;

        /* renamed from: k, reason: collision with root package name */
        NetMethod f148133k;

        /* renamed from: l, reason: collision with root package name */
        ef f148134l;

        /* renamed from: m, reason: collision with root package name */
        int[] f148135m;

        a() {
        }

        public final String toString() {
            return "RequestEntity{service='" + this.f148123a + "', request='" + this.f148124b + "', method=" + this.f148133k + ", heads=" + this.f148128f + ", authority=" + this.f148126d + ", queryKeys=" + Arrays.toString(this.f148127e) + ", constQuery='" + this.f148129g + "', useAgent='" + this.f148130h + "', resolver='" + this.f148134l + "', retry=" + this.f148131i + ", useExtraQuery=" + this.f148132j + "\nurl='" + this.f148125c + "'}";
        }

        /* synthetic */ a(byte b16) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements InvocationHandler {

        /* renamed from: b, reason: collision with root package name */
        private Class<? extends dn> f148137b;

        b(Class<? extends dn> cls) {
            this.f148137b = cls;
        }

        private a a(Method method) {
            String str;
            a aVar = new a(0 == true ? 1 : 0);
            NetJceResolver netJceResolver = (NetJceResolver) method.getAnnotation(NetJceResolver.class);
            NetFileResolver netFileResolver = (NetFileResolver) method.getAnnotation(NetFileResolver.class);
            NetJsonResolver netJsonResolver = (NetJsonResolver) method.getAnnotation(NetJsonResolver.class);
            NetRequest netRequest = (NetRequest) method.getAnnotation(NetRequest.class);
            if (netJceResolver != null) {
                aVar.f148134l = new ed(netJceResolver.inJce(), netJceResolver.outJce());
                aVar.f148135m = netJceResolver.queryRange();
            } else if (netFileResolver != null) {
                aVar.f148134l = new ec(netFileResolver.outFile());
                aVar.f148135m = netFileResolver.queryRange();
            } else if (netJsonResolver != null) {
                aVar.f148134l = new ee(netJsonResolver.outModel());
                aVar.f148135m = netJsonResolver.queryRange();
            }
            if (netRequest != null) {
                aVar.f148123a = this.f148137b.getSimpleName();
                aVar.f148133k = netRequest.method();
                aVar.f148124b = method.getName();
                aVar.f148126d = netRequest.authority();
                aVar.f148130h = netRequest.userAgent();
                aVar.f148127e = netRequest.queryKeys();
                aVar.f148131i = netRequest.retry();
                aVar.f148132j = netRequest.useExtraQuery();
                NetHead head = netRequest.head();
                String[] keys = head.keys();
                String[] values = head.values();
                if (keys.length > 0 && keys.length == values.length) {
                    aVar.f148128f = new HashMap<>();
                    for (int i3 = 0; i3 < keys.length; i3++) {
                        aVar.f148128f.put(keys[i3], values[i3]);
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                dn dnVar = dn.this;
                String str2 = aVar.f148126d;
                StringBuilder sb6 = new StringBuilder();
                if (hs.a(str2)) {
                    str2 = dnVar.j();
                }
                if (!TextUtils.isEmpty(str2)) {
                    String k3 = dnVar.k();
                    if (!TextUtils.isEmpty(k3)) {
                        sb6.append(k3);
                        sb6.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
                    }
                    sb6.append(str2);
                    str = sb6.toString();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                }
                String path = netRequest.path();
                if (path.length() != 0) {
                    sb5.append("/");
                    sb5.append(path);
                }
                aVar.f148129g = netRequest.constQuery();
                aVar.f148125c = sb5.toString();
            }
            return aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String str;
            a aVar = new a(0 == true ? 1 : 0);
            NetJceResolver netJceResolver = (NetJceResolver) method.getAnnotation(NetJceResolver.class);
            NetFileResolver netFileResolver = (NetFileResolver) method.getAnnotation(NetFileResolver.class);
            NetJsonResolver netJsonResolver = (NetJsonResolver) method.getAnnotation(NetJsonResolver.class);
            NetRequest netRequest = (NetRequest) method.getAnnotation(NetRequest.class);
            if (netJceResolver != null) {
                aVar.f148134l = new ed(netJceResolver.inJce(), netJceResolver.outJce());
                aVar.f148135m = netJceResolver.queryRange();
            } else if (netFileResolver != null) {
                aVar.f148134l = new ec(netFileResolver.outFile());
                aVar.f148135m = netFileResolver.queryRange();
            } else if (netJsonResolver != null) {
                aVar.f148134l = new ee(netJsonResolver.outModel());
                aVar.f148135m = netJsonResolver.queryRange();
            }
            if (netRequest != null) {
                aVar.f148123a = this.f148137b.getSimpleName();
                aVar.f148133k = netRequest.method();
                aVar.f148124b = method.getName();
                aVar.f148126d = netRequest.authority();
                aVar.f148130h = netRequest.userAgent();
                aVar.f148127e = netRequest.queryKeys();
                aVar.f148131i = netRequest.retry();
                aVar.f148132j = netRequest.useExtraQuery();
                NetHead head = netRequest.head();
                String[] keys = head.keys();
                String[] values = head.values();
                if (keys.length > 0 && keys.length == values.length) {
                    aVar.f148128f = new HashMap<>();
                    for (int i3 = 0; i3 < keys.length; i3++) {
                        aVar.f148128f.put(keys[i3], values[i3]);
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                dn dnVar = dn.this;
                String str2 = aVar.f148126d;
                StringBuilder sb6 = new StringBuilder();
                if (hs.a(str2)) {
                    str2 = dnVar.j();
                }
                if (!TextUtils.isEmpty(str2)) {
                    String k3 = dnVar.k();
                    if (!TextUtils.isEmpty(k3)) {
                        sb6.append(k3);
                        sb6.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
                    }
                    sb6.append(str2);
                    str = sb6.toString();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                }
                String path = netRequest.path();
                if (path.length() != 0) {
                    sb5.append("/");
                    sb5.append(path);
                }
                aVar.f148129g = netRequest.constQuery();
                aVar.f148125c = sb5.toString();
            }
            dn dnVar2 = dn.this;
            if (!dnVar2.f148119c) {
                LogUtil.d("TS", "The Service[" + this.f148137b.getSimpleName() + "] is block!!  Please check the ServiceProtocol for corrected, or contact the Tencent MapSdk Office to enable it. ");
                if (aVar.f148133k != NetMethod.URL) {
                    return null;
                }
                return "";
            }
            if (aVar.f148133k == NetMethod.URL) {
                String str3 = aVar.f148125c;
                String b16 = dnVar2.b(aVar, objArr);
                if (b16.length() != 0) {
                    str3 = str3 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + b16;
                }
                aVar.f148125c = str3;
                LogUtil.c("TS", aVar.toString());
                return str3;
            }
            ef efVar = aVar.f148134l;
            if (efVar != null) {
                return aVar.f148134l.a(dn.this.a(aVar, efVar.a(aVar.f148135m, objArr)));
            }
            return dnVar2.a(aVar, objArr);
        }
    }

    private R l() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            if (actualTypeArguments.length > 0) {
                Type type = actualTypeArguments[0];
                if (type instanceof Class) {
                    Class<?> cls = (Class) type;
                    ClassLoader classLoader = cls.getClassLoader();
                    Class<?>[] clsArr = new Class[1];
                    if (cls.isInterface()) {
                        clsArr[0] = cls;
                    } else {
                        clsArr = cls.getInterfaces();
                    }
                    return (R) Proxy.newProxyInstance(classLoader, clsArr, new b(getClass()));
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.cp
    public final boolean c() {
        return this.f148118b;
    }

    @Override // com.tencent.mapsdk.internal.cp
    public final boolean d() {
        return this.f148117a;
    }

    @Override // com.tencent.mapsdk.internal.cp
    public final boolean e() {
        return this.f148119c;
    }

    @Override // com.tencent.mapsdk.internal.cp
    public String g() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.cp
    public final String h() {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.cp
    public final R i() {
        if (this.f148120d != null) {
            return this.f148120d;
        }
        this.f148120d = l();
        return this.f148120d;
    }

    public final String j() {
        String f16 = f();
        if (this.f148117a) {
            return g();
        }
        return f16;
    }

    public final String k() {
        if (this.f148118b) {
            return "https";
        }
        return "http";
    }

    @Override // com.tencent.mapsdk.internal.cp
    public final void a(Map<String, String> map) {
        Map<String, String> map2 = this.f148121e;
        if (map2 != null) {
            map2.putAll(map);
        } else {
            this.f148121e = map;
        }
    }

    @Override // com.tencent.mapsdk.internal.co.a
    public final void b(boolean z16) {
        this.f148117a = z16;
    }

    @Override // com.tencent.mapsdk.internal.co.a
    public final void c(boolean z16) {
        this.f148118b = z16;
    }

    private String b() {
        StringBuilder sb5 = new StringBuilder();
        String j3 = j();
        if (TextUtils.isEmpty(j3)) {
            return null;
        }
        String k3 = k();
        if (!TextUtils.isEmpty(k3)) {
            sb5.append(k3);
            sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        }
        sb5.append(j3);
        return sb5.toString();
    }

    @Override // com.tencent.mapsdk.internal.co.a
    public final void a(boolean z16) {
        this.f148119c = z16;
    }

    private String a(String str) {
        StringBuilder sb5 = new StringBuilder();
        if (hs.a(str)) {
            str = j();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String k3 = k();
        if (!TextUtils.isEmpty(k3)) {
            sb5.append(k3);
            sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        }
        sb5.append(str);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(@NonNull a aVar, Object... objArr) {
        Map<String, String> map;
        String[] strArr = aVar.f148127e;
        StringBuilder sb5 = new StringBuilder();
        if (strArr != null && objArr != null && strArr.length <= objArr.length) {
            for (String str : strArr) {
                sb5.append(str);
                sb5.append("=%s&");
            }
        }
        String str2 = aVar.f148129g;
        if (!TextUtils.isEmpty(str2)) {
            for (String str3 : str2.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str3.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    sb5.append(split[0]);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(split[1]);
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
            }
        }
        if (aVar.f148132j && (map = this.f148121e) != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : this.f148121e.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(entry.getValue());
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        int lastIndexOf = sb5.lastIndexOf(ContainerUtils.FIELD_DELIMITER);
        if (lastIndexOf >= 0 && lastIndexOf == sb5.length() - 1) {
            sb5.deleteCharAt(lastIndexOf);
        }
        return String.format(sb5.toString(), objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final NetResponse a(a aVar, Object... objArr) {
        if (aVar == null) {
            return null;
        }
        String str = aVar.f148125c;
        try {
            String b16 = b(aVar, objArr);
            if (!TextUtils.isEmpty(b16)) {
                str = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + b16;
            }
            aVar.f148125c = str;
            LogUtil.c("TS", aVar.toString());
            int i3 = AnonymousClass1.f148122a[aVar.f148133k.ordinal()];
            if (i3 == 1) {
                return NetManager.getInstance().builder().forceHttps(false).userAgent(aVar.f148130h).url(str).retryNum(aVar.f148131i).header(aVar.f148128f).doGet();
            }
            if (i3 != 2) {
                return null;
            }
            byte[] bArr = new byte[0];
            if (objArr.length > 0) {
                int length = objArr.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        break;
                    }
                    Object obj = objArr[i16];
                    if (obj instanceof byte[]) {
                        bArr = (byte[]) obj;
                        break;
                    }
                    i16++;
                }
            }
            return NetManager.getInstance().builder().userAgent(aVar.f148130h).forceHttps(false).url(str).retryNum(aVar.f148131i).header(aVar.f148128f).postData(bArr).doPost();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static /* synthetic */ String a(dn dnVar, String str) {
        StringBuilder sb5 = new StringBuilder();
        if (hs.a(str)) {
            str = dnVar.j();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String k3 = dnVar.k();
        if (!TextUtils.isEmpty(k3)) {
            sb5.append(k3);
            sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        }
        sb5.append(str);
        return sb5.toString();
    }
}
