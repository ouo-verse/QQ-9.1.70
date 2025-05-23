package com.tencent.mobileqq.kandian.glue.report.api;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.kandian.base.image.imageloader.IRIJImageOptReport;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nJ\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoyReportUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/kandian/base/image/imageloader/IRIJImageOptReport;", "reportPushEffectEvent", "", "eventId", "", Node.ATTRS_ATTR, "", "Ltencent/im/oidb/cmd0x80a/oidb_cmd0x80a$AttributeList;", "Companion", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyReportUtils extends QRouteApi, IRIJImageOptReport {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int MOVE_CHANNEL_FRONT_SOURCE_UNKNOWN = 0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/kandian/glue/report/api/IReadInJoyReportUtils$Companion;", "", "()V", "MOVE_CHANNEL_FRONT_SOURCE_UNKNOWN", "", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int MOVE_CHANNEL_FRONT_SOURCE_UNKNOWN = 0;

        Companion() {
        }
    }

    void reportPushEffectEvent(int eventId, @NotNull List<oidb_cmd0x80a.AttributeList> attrs);
}
