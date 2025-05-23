package com.tencent.biz.qqcircle.events;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.comment.recpic.CmtClusterBean;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.rmonitor.base.config.data.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSKMeansResultEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "threshold", UserInfo.SEX_FEMALE, "getThreshold", "()F", "", k.FEATURES_KEY, "[F", "getFeatures", "()[F", "Lcom/tencent/biz/qqcircle/comment/recpic/b;", "reportBean", "Lcom/tencent/biz/qqcircle/comment/recpic/b;", "getReportBean", "()Lcom/tencent/biz/qqcircle/comment/recpic/b;", "", "feedId", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "<init>", "(F[FLcom/tencent/biz/qqcircle/comment/recpic/b;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSKMeansResultEvent extends SimpleBaseEvent {

    @NotNull
    private final float[] features;

    @NotNull
    private final String feedId;

    @NotNull
    private final CmtClusterBean reportBean;
    private final float threshold;

    public QFSKMeansResultEvent(float f16, @NotNull float[] features, @NotNull CmtClusterBean reportBean, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(reportBean, "reportBean");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.threshold = f16;
        this.features = features;
        this.reportBean = reportBean;
        this.feedId = feedId;
    }

    @NotNull
    public final float[] getFeatures() {
        return this.features;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final CmtClusterBean getReportBean() {
        return this.reportBean;
    }

    public final float getThreshold() {
        return this.threshold;
    }
}
