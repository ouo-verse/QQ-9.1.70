package com.tencent.qqnt.aio.msg.api;

import android.net.Uri;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.data.g;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JF\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/msg/api/IAIOMsgRecordApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "originPath", "Landroid/net/Uri;", "originUri", "", CustomImageProps.QUALITY, "", QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getPicMsgRecord", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "markFaceMessage", "getMarkFaceMsgRecord", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOMsgRecordApi extends QRouteApi {
    @Nullable
    MsgRecord getMarkFaceMsgRecord(@NotNull MarkFaceMessage markFaceMessage);

    @Nullable
    MsgRecord getPicMsgRecord(@NotNull String originPath, @Nullable Uri originUri, boolean quality, int subType, @Nullable String textSummary, @Nullable g picExtBizInfo);
}
