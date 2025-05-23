package com.tencent.mobileqq.kandian.repo.account.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0005H&J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/kandian/repo/account/api/IUserOperationModule;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "request0x80aPushEffectEvent", "", "eventId", "", AdMetricTag.EVENT_NAME, "", "version", "attris", "", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "cmd", "command", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IUserOperationModule extends QRouteApi {
    void request0x80aPushEffectEvent(int eventId, @Nullable String eventName, int version, @Nullable List<oidb_cmd0x80a.AttributeList> attris, @Nullable String cmd, int command);

    void request0x80aPushEffectEvent(int eventId, @Nullable String eventName, @Nullable List<oidb_cmd0x80a.AttributeList> attris);
}
