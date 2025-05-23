package com.tencent.mobileqq.tvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tvideo/event/QFSTVideoRewardAdClickEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "cid", "", "vid", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCid", "()Ljava/lang/String;", "setCid", "(Ljava/lang/String;)V", "getFlowId", "setFlowId", "getVid", "setVid", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class QFSTVideoRewardAdClickEvent extends SimpleBaseEvent {

    @NotNull
    private String cid;

    @Nullable
    private String flowId;

    @NotNull
    private String vid;

    public QFSTVideoRewardAdClickEvent(@NotNull String cid, @NotNull String vid, @Nullable String str) {
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(vid, "vid");
        this.cid = cid;
        this.vid = vid;
        this.flowId = str;
    }

    @NotNull
    public final String getCid() {
        return this.cid;
    }

    @Nullable
    public final String getFlowId() {
        return this.flowId;
    }

    @NotNull
    public final String getVid() {
        return this.vid;
    }

    public final void setCid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cid = str;
    }

    public final void setFlowId(@Nullable String str) {
        this.flowId = str;
    }

    public final void setVid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vid = str;
    }
}
