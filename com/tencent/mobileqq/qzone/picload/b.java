package com.tencent.mobileqq.qzone.picload;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.guild.api.transfile.IGuildTransFileApi;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.IpPortMappingConfig;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IpType;
import com.tencent.qqnt.kernel.nativeinterface.ServerAddress;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.java_websocket.WebSocketImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qzone/picload/b;", "", "", "e", "f", "", "g", "", "domain", "Ljava/util/concurrent/CopyOnWriteArrayList;", "domainList", "Lcom/tencent/libra/request/IpConnectConfig;", "a", "d", "b", "isHttps", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "picDomainListNeedToGetDirectIp", "videoDomainListNeedToGetDirectIp", "<init>", "()V", "qzone-picload-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f279315a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<String> picDomainListNeedToGetDirectIp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<String> videoDomainListNeedToGetDirectIp;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f279315a = new b();
        picDomainListNeedToGetDirectIp = new CopyOnWriteArrayList<>();
        videoDomainListNeedToGetDirectIp = new CopyOnWriteArrayList<>();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final IpConnectConfig a(String domain, CopyOnWriteArrayList<String> domainList) {
        boolean z16;
        boolean z17;
        if (LibraConfigUtil.INSTANCE.enableIPDirectConfigV2()) {
            boolean z18 = false;
            if (domainList != null && !domainList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && domainList.contains(domain)) {
                int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                if (activeNetIpFamily != 1) {
                    if (activeNetIpFamily != 2) {
                        if (activeNetIpFamily != 3) {
                            return null;
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList<ServerAddress> ipDirectList = ((IGuildTransFileApi) QRoute.api(IGuildTransFileApi.class)).getIpDirectList(domain, IpType.KV6);
                        ArrayList<ServerAddress> ipDirectList2 = ((IGuildTransFileApi) QRoute.api(IGuildTransFileApi.class)).getIpDirectList(domain, IpType.KV4);
                        if (ipDirectList != null && !ipDirectList.isEmpty()) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (!z17) {
                            arrayList.addAll(a.a(ipDirectList));
                        }
                        if (ipDirectList2 == null || ipDirectList2.isEmpty()) {
                            z18 = true;
                        }
                        if (!z18) {
                            arrayList.addAll(a.a(ipDirectList2));
                        }
                        return new IpConnectConfig(domain, arrayList);
                    }
                    return new IpConnectConfig(domain, a.a(((IGuildTransFileApi) QRoute.api(IGuildTransFileApi.class)).getIpDirectList(domain, IpType.KV6)));
                }
                return new IpConnectConfig(domain, a.a(((IGuildTransFileApi) QRoute.api(IGuildTransFileApi.class)).getIpDirectList(domain, IpType.KV4)));
            }
        }
        return null;
    }

    private final void e() {
        picDomainListNeedToGetDirectIp.clear();
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("domain_list_need_to_get_direct_ip", "[\"m.qpic.cn\", \"photogz.photo.store.qq.com\", \"phototj.photo.store.qq.com\", \"photonj.photo.store.qq.com\", \"photocq.photo.store.qq.com\"]");
        QLog.i("QZoneIPDirectConnectConfig", 2, "pic domainJSONString is " + loadAsString);
        if (TextUtils.isEmpty(loadAsString)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(loadAsString);
            if (jSONArray.length() <= 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                picDomainListNeedToGetDirectIp.add(jSONArray.getString(i3));
            }
        } catch (Exception e16) {
            QLog.e("QZoneIPDirectConnectConfig", 1, "exception is " + e16);
        }
    }

    private final void f() {
        videoDomainListNeedToGetDirectIp.clear();
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("video_domain_list_need_to_get_direct_ip", "[\"photovideo.photo.qq.com\"]");
        QLog.i("QZoneIPDirectConnectConfig", 2, "video domainJSONString is " + loadAsString);
        if (TextUtils.isEmpty(loadAsString)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(loadAsString);
            if (jSONArray.length() <= 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                videoDomainListNeedToGetDirectIp.add(jSONArray.getString(i3));
            }
        } catch (Exception e16) {
            QLog.e("QZoneIPDirectConnectConfig", 1, "exception is " + e16);
        }
    }

    private final boolean g() {
        if (!RFWApplication.isPublicVersion()) {
            return true;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("enable_video_ip_direct_config", false);
    }

    @Nullable
    public final IpConnectConfig b(@NotNull String domain) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IpConnectConfig) iPatchRedirector.redirect((short) 3, (Object) this, (Object) domain);
        }
        Intrinsics.checkNotNullParameter(domain, "domain");
        if (TextUtils.isEmpty(domain)) {
            return null;
        }
        return a(domain, picDomainListNeedToGetDirectIp);
    }

    @Nullable
    public final String c(@NotNull String domain, boolean isHttps) {
        IpConnectConfig a16;
        Map mapOf;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, this, domain, Boolean.valueOf(isHttps));
        }
        Intrinsics.checkNotNullParameter(domain, "domain");
        if (g() && !TextUtils.isEmpty(domain) && (a16 = a(domain, videoDomainListNeedToGetDirectIp)) != null) {
            try {
                for (IpPortMappingConfig ipPortMappingConfig : a16.getIpPortList()) {
                    if (isHttps) {
                        i3 = WebSocketImpl.DEFAULT_WSS_PORT;
                    } else {
                        i3 = 80;
                    }
                    ipPortMappingConfig.b(i3);
                }
                Gson gson = new Gson();
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(a16.getHost(), a16.getIpPortList()));
                String json = gson.toJson(mapOf);
                QLog.i("QZoneIPDirectConnectConfig", 2, "video ip string is " + json);
                return json;
            } catch (Exception e16) {
                QLog.e("QZoneIPDirectConnectConfig", 1, "exception is " + e16);
            }
        }
        return null;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("QZoneIPDirectConnectConfig", 2, "init IP direct config");
        e();
        f();
    }
}
