package com.tencent.guild.api.transfile.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.transfile.IGuildTransFileApi;
import com.tencent.guild.api.transfile.impl.GuildTransFileApiImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qqnt.kernel.nativeinterface.BigDataTicket;
import com.tencent.qqnt.kernel.nativeinterface.IpType;
import com.tencent.qqnt.kernel.nativeinterface.ServerAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J0\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/api/transfile/impl/GuildTransFileApiImpl;", "Lcom/tencent/guild/api/transfile/IGuildTransFileApi;", "", "", "toHexStr", "", "isHttps", "Lcom/tencent/qqnt/kernel/nativeinterface/IpType;", "ipType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ServerAddress;", "Lkotlin/collections/ArrayList;", "getBigDataIpList", "Lcom/tencent/qqnt/kernel/nativeinterface/BigDataTicket;", "getBigDataTicket", "domain", "getIpDirectList", "getBigDataCustomEnvIpList", "", "pullConfigIfNeed", "Lmqq/app/AppRuntime;", "getApp", "()Lmqq/app/AppRuntime;", "app", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildTransFileApiImpl implements IGuildTransFileApi {

    @NotNull
    private static final String TAG = "GuildTransFileApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pullConfigIfNeed$lambda$14(GuildTransFileApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBigDataTicket();
    }

    private final String toHexStr(byte[] bArr) {
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
    public final AppRuntime getApp() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.guild.api.transfile.IGuildTransFileApi
    @Nullable
    public ServerAddress getBigDataCustomEnvIpList() {
        AppInterface appInterface;
        AppRuntime app = getApp();
        if (app instanceof AppInterface) {
            appInterface = (AppInterface) app;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            Logger.f235387a.d().i(TAG, 1, "getBigDataCustomEnvIpList app null");
            return null;
        }
        ConfigManager configManager = ConfigManager.getInstance(appInterface.getApp().getBaseContext(), appInterface.getHwEngine());
        if (configManager == null) {
            Logger.f235387a.d().i(TAG, 1, "getBigDataCustomEnvIpList configManager null");
            return null;
        }
        EndPoint customEnvAddr = configManager.getCustomEnvAddr();
        if (customEnvAddr == null) {
            return null;
        }
        return new ServerAddress(customEnvAddr.host, customEnvAddr.port);
    }

    @Override // com.tencent.guild.api.transfile.IGuildTransFileApi
    @Nullable
    public ArrayList<ServerAddress> getBigDataIpList(boolean isHttps, @Nullable IpType ipType) {
        AppInterface appInterface;
        boolean z16;
        List<EndPoint> ipList;
        ArrayList<ServerAddress> arrayList;
        boolean z17;
        int collectionSizeOrDefault;
        boolean z18;
        AppRuntime app = getApp();
        Integer num = null;
        if (app instanceof AppInterface) {
            appInterface = (AppInterface) app;
        } else {
            appInterface = null;
        }
        boolean z19 = true;
        if (appInterface == null) {
            Logger.f235387a.d().i(TAG, 1, "getBigDataIpList app null");
            return null;
        }
        ConfigManager configManager = ConfigManager.getInstance(appInterface.getApp().getBaseContext(), appInterface.getHwEngine());
        if (configManager == null) {
            Logger.f235387a.d().i(TAG, 1, "getBigDataIpList configManager null");
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
        Logger.a d16 = Logger.f235387a.d();
        if (ipType == IpType.KV6) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        }
        d16.i(TAG, 1, "getBigDataIpList https:" + isHttps + " ip6:" + z17 + " size:" + num);
        if (arrayList != null && !arrayList.isEmpty()) {
            z19 = false;
        }
        if (z19) {
            HwServlet.getConfig(appInterface, appInterface.getCurrentUin());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        if (r6 != false) goto L34;
     */
    @Override // com.tencent.guild.api.transfile.IGuildTransFileApi
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDataTicket getBigDataTicket() {
        AppInterface appInterface;
        String str;
        boolean z16;
        byte[] sessionKey;
        String hexStr;
        byte[] httpconn_sig_session;
        AppRuntime app = getApp();
        if (app instanceof AppInterface) {
            appInterface = (AppInterface) app;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            Logger.f235387a.d().i(TAG, 1, "getBigDataTicket app null");
            return new BigDataTicket();
        }
        SessionInfo sessionInfo = SessionInfo.getInstance(appInterface.getCurrentAccountUin());
        String str2 = "";
        if (sessionInfo == null || (httpconn_sig_session = sessionInfo.getHttpconn_sig_session()) == null || (str = toHexStr(httpconn_sig_session)) == null) {
            str = "";
        }
        SessionInfo sessionInfo2 = SessionInfo.getInstance(appInterface.getCurrentAccountUin());
        if (sessionInfo2 != null && (sessionKey = sessionInfo2.getSessionKey()) != null && (hexStr = toHexStr(sessionKey)) != null) {
            str2 = hexStr;
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
        Logger.f235387a.d().i(TAG, 1, "getBigDataTicket sig:" + str.length() + " session:" + str2.length());
        return new BigDataTicket(str, str2);
    }

    @Override // com.tencent.guild.api.transfile.IGuildTransFileApi
    @Nullable
    public ArrayList<ServerAddress> getIpDirectList(@Nullable String domain, @Nullable IpType ipType) {
        int i3;
        ArrayList<ServerAddr> arrayList;
        ArrayList<ServerAddress> arrayList2;
        int collectionSizeOrDefault;
        if (ipType == IpType.KV4) {
            i3 = 1;
        } else {
            i3 = 28;
        }
        InnerDns innerDns = InnerDns.getInstance();
        if (innerDns != null) {
            arrayList = innerDns.reqSerAddrList(domain, 1021, i3);
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            arrayList2 = new ArrayList<>(collectionSizeOrDefault);
            for (ServerAddr serverAddr : arrayList) {
                arrayList2.add(new ServerAddress(serverAddr.mIp, serverAddr.port));
            }
        } else {
            arrayList2 = null;
        }
        if (!(arrayList2 instanceof ArrayList)) {
            return null;
        }
        return arrayList2;
    }

    @Override // com.tencent.guild.api.transfile.IGuildTransFileApi
    public void pullConfigIfNeed() {
        ThreadManagerV2.excute(new Runnable() { // from class: pr0.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildTransFileApiImpl.pullConfigIfNeed$lambda$14(GuildTransFileApiImpl.this);
            }
        }, 64, null, false);
    }
}
