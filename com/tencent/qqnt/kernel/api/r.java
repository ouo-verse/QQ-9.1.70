package com.tencent.qqnt.kernel.api;

import com.tencent.qqnt.kernel.nativeinterface.BatchGetGroupSchoolRoleReq;
import com.tencent.qqnt.kernel.nativeinterface.CheckInGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.ConfirmGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.DeleteGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeListReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeStatisticsReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskListReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskStatisticsReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskUnCheckInReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTemplateListReq;
import com.tencent.qqnt.kernel.nativeinterface.IBatchGetUserGroupSchoolRoleCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckInGroupSchoolTaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.IConfirmGroupSchoolNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeStatisticCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskCheckInInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskStatisticsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskUnCheckInCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTemplateListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolToolboxInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolTaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.ModGroupSchoolTaskStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupSchoolNoticeReq;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\fH&J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H&J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0015H&J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u001aH&J\u001a\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001c2\b\u0010\u0005\u001a\u0004\u0018\u00010\u001dH&J\u001a\u0010!\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001f2\b\u0010\u0005\u001a\u0004\u0018\u00010 H&J\u001a\u0010#\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\"2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010%H&J\u001a\u0010)\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020'2\b\u0010\u0005\u001a\u0004\u0018\u00010(H&J\u001a\u0010,\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020*2\b\u0010\u0005\u001a\u0004\u0018\u00010+H&J\u001a\u0010/\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020-2\b\u0010\u0005\u001a\u0004\u0018\u00010.H&J\u001a\u00102\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u0002002\b\u0010\u0005\u001a\u0004\u0018\u000101H&J\u001a\u00105\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u0002032\b\u0010\u0005\u001a\u0004\u0018\u000104H&J\u001a\u00109\u001a\u00020\u00062\u0006\u00107\u001a\u0002062\b\u0010\u0005\u001a\u0004\u0018\u000108H&\u00a8\u0006:"}, d2 = {"Lcom/tencent/qqnt/kernel/api/r;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeListReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeListCallback;", "result", "", "getGroupSchoolNoticeList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeDetailReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeDetailCallback;", "getGroupSchoolNoticeDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPublishGroupSchoolNoticeCallback;", "publishGroupSchoolNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/DeleteGroupSchoolNoticeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "deleteGroupSchoolNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/ConfirmGroupSchoolNoticeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IConfirmGroupSchoolNoticeCallback;", "confirmGroupSchoolNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeStatisticsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeStatisticCallback;", "getGroupSchoolNoticeStatistic", "Lcom/tencent/qqnt/kernel/nativeinterface/RemindGroupSchoolNoticeReq;", "remindGroupSchoolNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchGetGroupSchoolRoleReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchGetUserGroupSchoolRoleCallback;", "batchGetUserGroupSchoolRole", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTemplateListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTemplateListCallback;", "getGroupSchoolTemplateList", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPublishGroupSchoolTaskCallback;", "publishGroupSchoolTask", "Lcom/tencent/qqnt/kernel/nativeinterface/ModGroupSchoolTaskStatusReq;", "modifyGroupSchoolTaskStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskDetailReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskDetailCallback;", "getGroupSchoolTaskDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckInGroupSchoolTaskReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckInGroupSchoolTaskCallback;", "checkInGroupSchoolTask", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskListCallback;", "getGroupSchoolTaskList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskStatisticsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskStatisticsCallback;", "getGroupSchoolTaskStatistics", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskCheckInInfoCallback;", "getGroupSchoolTaskCheckInInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskUnCheckInReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskUnCheckInCallback;", "getGroupSchoolTaskUnCheckInInfo", "", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolToolboxInfoCallback;", "getGroupSchoolToolboxInfo", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface r extends j {
    void batchGetUserGroupSchoolRole(@NotNull BatchGetGroupSchoolRoleReq req, @Nullable IBatchGetUserGroupSchoolRoleCallback result);

    void checkInGroupSchoolTask(@NotNull CheckInGroupSchoolTaskReq req, @Nullable ICheckInGroupSchoolTaskCallback result);

    void confirmGroupSchoolNotice(@NotNull ConfirmGroupSchoolNoticeReq req, @Nullable IConfirmGroupSchoolNoticeCallback result);

    void deleteGroupSchoolNotice(@NotNull DeleteGroupSchoolNoticeReq req, @Nullable IOperateCallback result);

    void getGroupSchoolNoticeDetail(@NotNull GetGroupSchoolNoticeDetailReq req, @Nullable IGetGroupSchoolNoticeDetailCallback result);

    void getGroupSchoolNoticeList(@NotNull GetGroupSchoolNoticeListReq req, @Nullable IGetGroupSchoolNoticeListCallback result);

    void getGroupSchoolNoticeStatistic(@NotNull GroupSchoolNoticeStatisticsReq req, @Nullable IGetGroupSchoolNoticeStatisticCallback result);

    void getGroupSchoolTaskCheckInInfo(@NotNull GroupSchoolTaskCheckInInfoReq req, @Nullable IGetGroupSchoolTaskCheckInInfoCallback result);

    void getGroupSchoolTaskDetail(@NotNull GroupSchoolTaskDetailReq req, @Nullable IGetGroupSchoolTaskDetailCallback result);

    void getGroupSchoolTaskList(@NotNull GroupSchoolTaskListReq req, @Nullable IGetGroupSchoolTaskListCallback result);

    void getGroupSchoolTaskStatistics(@NotNull GroupSchoolTaskStatisticsReq req, @Nullable IGetGroupSchoolTaskStatisticsCallback result);

    void getGroupSchoolTaskUnCheckInInfo(@NotNull GroupSchoolTaskUnCheckInReq req, @Nullable IGetGroupSchoolTaskUnCheckInCallback result);

    void getGroupSchoolTemplateList(@NotNull GroupSchoolTemplateListReq req, @Nullable IGetGroupSchoolTemplateListCallback result);

    void getGroupSchoolToolboxInfo(long groupCode, @Nullable IGetGroupSchoolToolboxInfoCallback result);

    void modifyGroupSchoolTaskStatus(@NotNull ModGroupSchoolTaskStatusReq req, @Nullable IOperateCallback result);

    void publishGroupSchoolNotice(@NotNull PublishGroupSchoolNoticeReq req, @Nullable IPublishGroupSchoolNoticeCallback result);

    void publishGroupSchoolTask(@NotNull PublishGroupSchoolTaskReq req, @Nullable IPublishGroupSchoolTaskCallback result);

    void remindGroupSchoolNotice(@NotNull RemindGroupSchoolNoticeReq req, @Nullable IOperateCallback result);
}
