package com.tencent.mobileqq.qcircle.api.qqvideo.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/qqvideo/event/QCircleFeedJSPermissionChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "rightFlag", "", "feedId", "", AppConstants.Key.KEY_QZONE_UGCKEY, "downLoadOper", "qzoneType", "(ILjava/lang/String;Ljava/lang/String;II)V", "getDownLoadOper", "()I", "setDownLoadOper", "(I)V", "getFeedId", "()Ljava/lang/String;", "setFeedId", "(Ljava/lang/String;)V", "getQzoneType", "setQzoneType", "getRightFlag", "setRightFlag", "getUgcKey", "setUgcKey", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCircleFeedJSPermissionChangeEvent extends SimpleBaseEvent {
    private int downLoadOper;

    @NotNull
    private String feedId;
    private int qzoneType;
    private int rightFlag;

    @NotNull
    private String ugcKey;

    public QCircleFeedJSPermissionChangeEvent(int i3, @NotNull String feedId, @NotNull String ugcKey, int i16, int i17) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(ugcKey, "ugcKey");
        this.rightFlag = i3;
        this.feedId = feedId;
        this.ugcKey = ugcKey;
        this.downLoadOper = i16;
        this.qzoneType = i17;
    }

    public final int getDownLoadOper() {
        return this.downLoadOper;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public final int getQzoneType() {
        return this.qzoneType;
    }

    public final int getRightFlag() {
        return this.rightFlag;
    }

    @NotNull
    public final String getUgcKey() {
        return this.ugcKey;
    }

    public final void setDownLoadOper(int i3) {
        this.downLoadOper = i3;
    }

    public final void setFeedId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    public final void setQzoneType(int i3) {
        this.qzoneType = i3;
    }

    public final void setRightFlag(int i3) {
        this.rightFlag = i3;
    }

    public final void setUgcKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ugcKey = str;
    }
}
