package com.tencent.mobileqq.tianshu.red.request;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010\u001bJ$\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\u0005H\u0002J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\u0003R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R7\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003`\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016RB\u0010\u001c\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u0002j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0018`\u00058\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0019\u0012\u0004\b\u001a\u0010\u001bR7\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u001d\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/tianshu/red/request/RedRequestBusinessManager;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/tianshu/red/request/a;", "Lkotlin/collections/HashMap;", "i", "", "appId", "e", h.F, "reqType", "", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TranInfo;", "c", "", "b", "Lkotlin/Lazy;", "d", "()[B", "LIMIT_SIZE_BYTE", "f", "()Ljava/util/HashMap;", "limitSizeConfigMap", "Ljava/lang/Class;", "Ljava/util/HashMap;", "getProcessorsClass$annotations", "()V", "processorsClass", "g", "processors", "<init>", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RedRequestBusinessManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RedRequestBusinessManager f293121a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy LIMIT_SIZE_BYTE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy limitSizeConfigMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Tianshu/Inject_tianshu_red_request_business_processor.yml", version = 1)
    @NotNull
    private static final HashMap<String, Class<a>> processorsClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy processors;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34436);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f293121a = new RedRequestBusinessManager();
        lazy = LazyKt__LazyJVMKt.lazy(RedRequestBusinessManager$LIMIT_SIZE_BYTE$2.INSTANCE);
        LIMIT_SIZE_BYTE = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(RedRequestBusinessManager$limitSizeConfigMap$2.INSTANCE);
        limitSizeConfigMap = lazy2;
        HashMap<String, Class<a>> hashMap = new HashMap<>();
        processorsClass = hashMap;
        hashMap.put("1105", zd2.b.class);
        lazy3 = LazyKt__LazyJVMKt.lazy(RedRequestBusinessManager$processors$2.INSTANCE);
        processors = lazy3;
    }

    RedRequestBusinessManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final byte[] d() {
        return (byte[]) LIMIT_SIZE_BYTE.getValue();
    }

    private final int e(String appId) {
        Integer num = f().get(appId);
        if (num == null) {
            num = f().get("default");
        }
        if (num == null) {
            return 100;
        }
        return num.intValue();
    }

    private final HashMap<String, Integer> f() {
        return (HashMap) limitSizeConfigMap.getValue();
    }

    private final HashMap<Integer, a> g() {
        return (HashMap) processors.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Integer> h() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("tianshu_red_request_business_limit_size", "");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("default", 100);
        hashMap.put("1105", 3072);
        try {
            JSONObject jSONObject = new JSONObject(loadAsString);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str == null) {
                    str = "";
                }
                hashMap.put(str, Integer.valueOf(jSONObject.optInt(str)));
            }
        } catch (Exception unused) {
            QLog.d("RedRequestBusinessManager", 1, "initConfigMap fail, string:" + loadAsString);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<Integer, a> i() {
        HashMap<Integer, a> hashMap = new HashMap<>();
        for (Map.Entry<String, Class<a>> entry : processorsClass.entrySet()) {
            try {
                hashMap.put(Integer.valueOf(Integer.parseInt(entry.getKey())), entry.getValue().newInstance());
            } catch (Exception e16) {
                QLog.e("RedRequestBusinessManager", 1, "initProcessors fail, appId:" + entry.getKey() + " ex:" + e16);
            }
        }
        return hashMap;
    }

    @NotNull
    public final List<BusinessInfoCheckUpdate.TranInfo> c(int reqType) {
        byte[] a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, reqType);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, a> entry : g().entrySet()) {
            a value = entry.getValue();
            if (value.b(reqType) && (a16 = value.a(reqType)) != null) {
                int length = a16.length;
                RedRequestBusinessManager redRequestBusinessManager = f293121a;
                if (length > redRequestBusinessManager.e(String.valueOf(entry.getKey().intValue()))) {
                    value.onError(10001);
                    a16 = redRequestBusinessManager.d();
                    QLog.d("RedRequestBusinessManager", 1, "over len, appId:" + entry.getKey().intValue());
                }
                BusinessInfoCheckUpdate.TranInfo tranInfo = new BusinessInfoCheckUpdate.TranInfo();
                tranInfo.key.set(entry.getKey().intValue());
                tranInfo.value.set(ByteStringMicro.copyFrom(a16));
                arrayList.add(tranInfo);
            }
        }
        return arrayList;
    }
}
