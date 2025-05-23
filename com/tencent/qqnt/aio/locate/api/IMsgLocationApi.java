package com.tencent.qqnt.aio.locate.api;

import android.app.Activity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&JJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/locate/api/IMsgLocationApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "jumpToTargetNTAIOPosition", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "uinType", "", "uin", "", "troopUin", AppConstants.Key.COLUMN_SHMSG_SEQ, "", "msgId", "chatType", "peerUid", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IMsgLocationApi extends QRouteApi {
    void jumpToTargetNTAIOPosition(@NotNull Activity activity, int uinType, @NotNull String uin, @Nullable String troopUin, long shmsgseq, long msgId);

    void jumpToTargetNTAIOPosition(@NotNull Activity activity, int uinType, @NotNull String uin, @Nullable String troopUin, long shmsgseq, long msgId, int chatType, @NotNull String peerUid);
}
