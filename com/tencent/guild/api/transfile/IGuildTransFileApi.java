package com.tencent.guild.api.transfile;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.BigDataTicket;
import com.tencent.qqnt.kernel.nativeinterface.IpType;
import com.tencent.qqnt.kernel.nativeinterface.ServerAddress;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J0\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/api/transfile/IGuildTransFileApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getBigDataCustomEnvIpList", "Lcom/tencent/qqnt/kernel/nativeinterface/ServerAddress;", "getBigDataIpList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isHttps", "", "ipType", "Lcom/tencent/qqnt/kernel/nativeinterface/IpType;", "getBigDataTicket", "Lcom/tencent/qqnt/kernel/nativeinterface/BigDataTicket;", "getIpDirectList", "domain", "", "pullConfigIfNeed", "", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildTransFileApi extends QRouteApi {
    @Nullable
    ServerAddress getBigDataCustomEnvIpList();

    @Nullable
    ArrayList<ServerAddress> getBigDataIpList(boolean isHttps, @Nullable IpType ipType);

    @Nullable
    BigDataTicket getBigDataTicket();

    @Nullable
    ArrayList<ServerAddress> getIpDirectList(@Nullable String domain, @Nullable IpType ipType);

    void pullConfigIfNeed();
}
