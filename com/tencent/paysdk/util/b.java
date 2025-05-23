package com.tencent.paysdk.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.paysdk.api.IUserInfoProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/paysdk/util/b;", "", "", "", "b", "", "a", "Ljava/util/List;", "finalCookies", "()Ljava/util/List;", "cookies", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static List<String> finalCookies;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f342085b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13108);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f342085b = new b();
            finalCookies = new ArrayList();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @NotNull
    public final List<String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (List) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        IUserInfoProvider d16 = com.tencent.paysdk.a.l().d();
        com.tencent.paysdk.data.b deviceInfo = com.tencent.paysdk.a.l().getDeviceInfo();
        com.tencent.paysdk.data.a appInfo = com.tencent.paysdk.a.l().getAppInfo();
        if (IUserInfoProvider.UserType.QQ == d16.type()) {
            arrayList.add("main_login=qq");
            arrayList.add("vqq_appid=" + d16.getUserInfo().b());
            arrayList.add("vqq_vuserid=" + d16.getUserInfo().i());
            arrayList.add("vqq_vusession=" + d16.getUserInfo().f());
            arrayList.add("vqq_openid=" + d16.getUserInfo().h());
            arrayList.add("vqq_access_token=" + d16.getUserInfo().e());
            arrayList.add("vdevice_qimei36=" + deviceInfo.getQimei36());
            arrayList.add("video_appid=" + appInfo.b());
            arrayList.add("video_platform=" + deviceInfo.getPlatform());
        } else if (IUserInfoProvider.UserType.WX == d16.type()) {
            arrayList.add("main_login=wx");
            arrayList.add("appid=" + d16.getUserInfo().b());
            arrayList.add("vuserid=" + d16.getUserInfo().i());
            arrayList.add("vusession=" + d16.getUserInfo().f());
            arrayList.add("openid=" + d16.getUserInfo().h());
            arrayList.add("access_token=" + d16.getUserInfo().e());
            arrayList.add("refresh_token=" + d16.getUserInfo().d());
            arrayList.add("vdevice_qimei36=" + deviceInfo.getQimei36());
            arrayList.add("video_appid=" + appInfo.b());
            arrayList.add("video_platform=" + deviceInfo.getPlatform());
        } else if (IUserInfoProvider.UserType.QQ_SKEY == d16.type()) {
            arrayList.add("main_login=qq");
            arrayList.add("vuserid=" + d16.getUserInfo().i());
            arrayList.add("vusession=" + d16.getUserInfo().f());
            arrayList.add("uin=" + d16.getUserInfo().a());
            arrayList.add("skey=" + d16.getUserInfo().j());
            arrayList.add("vdevice_qimei36=" + deviceInfo.getQimei36());
            arrayList.add("video_platform=" + deviceInfo.getPlatform());
            arrayList.add("video_appid=" + appInfo.b());
        } else {
            arrayList.add("main_login=none");
            arrayList.add("vdevice_qimei36=" + deviceInfo.getQimei36());
            arrayList.add("video_platform=" + deviceInfo.getPlatform());
            arrayList.add("video_appid=" + appInfo.b());
        }
        return arrayList;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        finalCookies.clear();
        finalCookies.addAll(a());
        return finalCookies;
    }
}
