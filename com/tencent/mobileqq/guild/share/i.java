package com.tencent.mobileqq.guild.share;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GuildContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\t\u001a\u00020\bH\u0002J.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/share/i;", "", "Lmqq/app/AppRuntime;", "appRunTime", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", "Lkotlin/collections/ArrayList;", tl.h.F, "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "g", "recentUsers", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "recentUser", "a", "c", "recentContactInfo", "b", "", "e", "", "ntChatType", "d", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f235000a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((GuildRecentUser) t17).getTime()), Long.valueOf(((GuildRecentUser) t16).getTime()));
            return compareValues;
        }
    }

    i() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GuildRecentUser a(RecentContactInfo recentUser) {
        boolean z16;
        boolean isBlank;
        String e16 = e(recentUser);
        if (e16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(e16);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    e16 = String.valueOf(recentUser.peerUin);
                }
                return new GuildRecentUser(String.valueOf(recentUser.peerUin), e16, 0, null, 1, recentUser.msgTime, 8, null);
            }
        }
        z16 = true;
        if (z16) {
        }
        return new GuildRecentUser(String.valueOf(recentUser.peerUin), e16, 0, null, 1, recentUser.msgTime, 8, null);
    }

    private final GuildRecentUser b(RecentContactInfo recentContactInfo, QQAppInterface app) {
        GuildContactInfo guildContactInfo = recentContactInfo.guildContactInfo;
        if (guildContactInfo.channelType != 1) {
            return null;
        }
        String str = guildContactInfo.channelName;
        IRuntimeService runtimeService = app.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGProGuildInfo guildInfo = ((IGPSService) runtimeService).getGuildInfo(recentContactInfo.guildContactInfo.guildId);
        if (guildInfo != null) {
            str = guildInfo.getGuildName() + APLogFileUtil.SEPARATOR_LOG + recentContactInfo.guildContactInfo.channelName;
        }
        String displayName = str;
        String str2 = recentContactInfo.guildContactInfo.channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "recentContactInfo.guildContactInfo.channelId");
        Intrinsics.checkNotNullExpressionValue(displayName, "displayName");
        String str3 = recentContactInfo.guildContactInfo.guildId;
        Intrinsics.checkNotNullExpressionValue(str3, "recentContactInfo.guildContactInfo.guildId");
        return new GuildRecentUser(str2, displayName, 10014, str3, 0, recentContactInfo.msgTime, 16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final GuildRecentUser c(RecentContactInfo recentUser) {
        boolean z16;
        boolean isBlank;
        int i3 = !TroopUtils.n(String.valueOf(recentUser.peerUin)) ? 113 : 4;
        String e16 = e(recentUser);
        if (e16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(e16);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    e16 = String.valueOf(recentUser.peerUin);
                }
                return new GuildRecentUser(String.valueOf(recentUser.peerUin), e16, 1, null, i3, recentUser.msgTime, 8, null);
            }
        }
        z16 = true;
        if (z16) {
        }
        return new GuildRecentUser(String.valueOf(recentUser.peerUin), e16, 1, null, i3, recentUser.msgTime, 8, null);
    }

    private final String e(RecentContactInfo recentContactInfo) {
        if (!TextUtils.isEmpty(recentContactInfo.remark)) {
            String str = recentContactInfo.remark;
            Intrinsics.checkNotNullExpressionValue(str, "recentContactInfo.remark");
            return str;
        }
        if (!TextUtils.isEmpty(recentContactInfo.peerName)) {
            String str2 = recentContactInfo.peerName;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n            recentContactInfo.peerName\n        }");
            return str2;
        }
        String str3 = recentContactInfo.sendNickName;
        Intrinsics.checkNotNullExpressionValue(str3, "recentContactInfo.sendNickName");
        return str3;
    }

    private final List<GuildRecentUser> f(ArrayList<GuildRecentUser> recentUsers, QQAppInterface app) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        List<t02.e> recentTalkedChannelsInfo = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getRecentTalkedChannelsInfo(app);
        if (recentTalkedChannelsInfo == null) {
            return arrayList;
        }
        for (t02.e eVar : recentTalkedChannelsInfo) {
            Iterator<T> it = recentUsers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                GuildRecentUser guildRecentUser = (GuildRecentUser) obj;
                if (guildRecentUser.getType() == 10014 && Intrinsics.areEqual(guildRecentUser.getUin(), eVar.a())) {
                    break;
                }
            }
            if (obj == null) {
                String str = eVar.d() + APLogFileUtil.SEPARATOR_LOG + eVar.b();
                String a16 = eVar.a();
                Intrinsics.checkNotNullExpressionValue(a16, "recentTalkedChannelInfo.channelId");
                String c16 = eVar.c();
                Intrinsics.checkNotNullExpressionValue(c16, "recentTalkedChannelInfo.guildId");
                arrayList.add(new GuildRecentUser(a16, str, 10014, c16, 0, eVar.e().longValue() / 1000, 16, null));
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildShare.GuildRecentUserLoadTaskV2", 1, "getGuildRecentChannel size:" + arrayList.size());
        }
        return arrayList;
    }

    private final List<GuildRecentUser> g(QQAppInterface app) {
        if (!app.isAccLoginSuccess()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.qqnt.kernel.api.aa recentContactService = ((IKernelService) app.getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService == null) {
            return new ArrayList();
        }
        List<RecentContactInfo> a16 = recentContactService.a();
        if (a16 == null) {
            return new ArrayList();
        }
        for (RecentContactInfo recentContactInfo : a16) {
            if (d(recentContactInfo.chatType) != -1) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildShare.GuildRecentUserLoadTaskV2", "getQQLiteRecentUser " + recentContactInfo);
                }
                int i3 = recentContactInfo.chatType;
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        arrayList.add(c(recentContactInfo));
                    } else if (i3 == 4) {
                        GuildRecentUser b16 = b(recentContactInfo, app);
                        if (b16 != null) {
                            arrayList.add(b16);
                        }
                    } else if (i3 != 99 && i3 != 100) {
                    }
                }
                arrayList.add(a(recentContactInfo));
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final ArrayList<GuildRecentUser> h(AppRuntime appRunTime) {
        Intrinsics.checkNotNullParameter(appRunTime, "appRunTime");
        if (!(appRunTime instanceof QQAppInterface)) {
            return new ArrayList<>();
        }
        ArrayList<GuildRecentUser> arrayList = new ArrayList<>();
        i iVar = f235000a;
        QQAppInterface qQAppInterface = (QQAppInterface) appRunTime;
        arrayList.addAll(iVar.g(qQAppInterface));
        arrayList.addAll(iVar.f(arrayList, qQAppInterface));
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildShare.GuildRecentUserLoadTaskV2", 1, "getRecentUsers size:" + arrayList.size());
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new a());
        }
        return arrayList;
    }

    public final int d(int ntChatType) {
        if (ntChatType != 1) {
            if (ntChatType == 2) {
                return 1;
            }
            if (ntChatType != 3) {
                if (ntChatType != 4) {
                    if (ntChatType != 99 && ntChatType != 100) {
                        return -1;
                    }
                    return 1000;
                }
                return 10014;
            }
            return 3000;
        }
        return 0;
    }
}
