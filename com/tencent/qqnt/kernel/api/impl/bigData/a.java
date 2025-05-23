package com.tencent.qqnt.kernel.api.impl.bigData;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BigDataTicket;
import com.tencent.qqnt.kernel.nativeinterface.IpType;
import com.tencent.qqnt.kernel.nativeinterface.ServerAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/bigData/a;", "", "", "", "e", "", "isHttps", "Lcom/tencent/qqnt/kernel/nativeinterface/IpType;", "ipType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ServerAddress;", "Lkotlin/collections/ArrayList;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/BigDataTicket;", "d", "b", "Lmqq/app/AppRuntime;", "a", "()Lmqq/app/AppRuntime;", "app", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final C9643a f357542a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/bigData/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.bigData.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private static final class C9643a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ C9643a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        C9643a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54532);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f357542a = new C9643a(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String e(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb5.append(hexString);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @Nullable
    public final AppRuntime a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Nullable
    public ServerAddress b() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ServerAddress) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        AppRuntime a16 = a();
        if (a16 instanceof AppInterface) {
            appInterface = (AppInterface) a16;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            QLog.e("BigDataApiImpl", 1, " getBigDataCustomEnvIpList app null");
            return null;
        }
        ConfigManager configManager = ConfigManager.getInstance(appInterface.getApp().getBaseContext(), appInterface.getHwEngine());
        if (configManager == null) {
            QLog.e("BigDataApiImpl", 1, "getBigDataCustomEnvIpList configManager null");
            return null;
        }
        EndPoint customEnvAddr = configManager.getCustomEnvAddr();
        if (customEnvAddr == null) {
            return null;
        }
        return new ServerAddress(customEnvAddr.host, customEnvAddr.port);
    }

    @Nullable
    public ArrayList<ServerAddress> c(boolean isHttps, @Nullable IpType ipType) {
        AppInterface appInterface;
        boolean z16;
        List<EndPoint> ipList;
        ArrayList<ServerAddress> arrayList;
        boolean z17;
        int collectionSizeOrDefault;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isHttps), ipType);
        }
        AppRuntime a16 = a();
        Integer num = null;
        if (a16 instanceof AppInterface) {
            appInterface = (AppInterface) a16;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            QLog.e("BigDataApiImpl", 1, "getBigDataIpList app null");
            return null;
        }
        ConfigManager configManager = ConfigManager.getInstance(appInterface.getApp().getBaseContext(), appInterface.getHwEngine());
        if (configManager == null) {
            QLog.e("BigDataApiImpl", 1, "getBigDataIpList configManager null");
            return null;
        }
        if (isHttps) {
            Context baseContext = appInterface.getApp().getBaseContext();
            if (ipType == IpType.KV6) {
                z18 = true;
            } else {
                z18 = false;
            }
            ipList = configManager.getOtherTypeIp(baseContext, 21, z18);
        } else {
            Context baseContext2 = appInterface.getApp().getBaseContext();
            if (ipType == IpType.KV6) {
                z16 = true;
            } else {
                z16 = false;
            }
            ipList = configManager.getIpList(baseContext2, z16);
        }
        if (ipList != null) {
            List<EndPoint> list = ipList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList<>(collectionSizeOrDefault);
            for (EndPoint endPoint : list) {
                arrayList.add(new ServerAddress(endPoint.host, endPoint.port));
            }
        } else {
            arrayList = null;
        }
        if (!(arrayList instanceof ArrayList)) {
            arrayList = null;
        }
        if (ipType == IpType.KV6) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        }
        QLog.i("BigDataApiImpl", 1, "getBigDataIpList https:" + isHttps + " ip6:" + z17 + " size:" + num);
        if (arrayList == null || arrayList.isEmpty()) {
            z19 = true;
        }
        if (z19) {
            HwServlet.getConfig(appInterface, appInterface.getCurrentUin());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        if (r6 != false) goto L40;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDataTicket d() {
        AppInterface appInterface;
        String str;
        boolean z16;
        byte[] sessionKey;
        String e16;
        byte[] httpconn_sig_session;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BigDataTicket) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        AppRuntime a16 = a();
        if (a16 instanceof AppInterface) {
            appInterface = (AppInterface) a16;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            QLog.e("BigDataApiImpl", 1, "getBigDataTicket app null");
            return new BigDataTicket();
        }
        SessionInfo sessionInfo = SessionInfo.getInstance(appInterface.getCurrentAccountUin());
        String str2 = "";
        if (sessionInfo == null || (httpconn_sig_session = sessionInfo.getHttpconn_sig_session()) == null || (str = e(httpconn_sig_session)) == null) {
            str = "";
        }
        SessionInfo sessionInfo2 = SessionInfo.getInstance(appInterface.getCurrentAccountUin());
        if (sessionInfo2 != null && (sessionKey = sessionInfo2.getSessionKey()) != null && (e16 = e(sessionKey)) != null) {
            str2 = e16;
        }
        boolean z17 = false;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (str2.length() == 0) {
                z17 = true;
            }
        }
        HwServlet.getConfig(appInterface, appInterface.getCurrentUin());
        QLog.i("BigDataApiImpl", 1, "getBigDataTicket sig:" + str.length() + " session:" + str2.length());
        return new BigDataTicket(str, str2);
    }
}
