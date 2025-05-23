package com.tencent.state.square.data;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.battery.SquareBatteryStatusManager;
import com.tencent.state.view.OnlineStatusBubbleViewHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016\u00a2\u0006\u0002\u0010\u001dJ7\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u001cH\u0016\u00a2\u0006\u0002\u0010%R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000eX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/data/SingleResourceInfo;", "Lcom/tencent/state/square/data/BaseResourceInfo;", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "resource", "Lcom/tencent/state/square/data/RecordResourceInfo;", "redDotId", "", "motionUrl", "motionName", "lockInfo", "Lcom/tencent/state/square/data/StatusLockInfo;", "(Lcom/tencent/state/square/data/OnlineStatus;Lcom/tencent/state/square/data/RecordResourceInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/data/StatusLockInfo;)V", "isFilament", "", "()Z", "isMultiAction", "recordResources", "", "getRecordResources", "()Ljava/util/List;", "getResource", "()Lcom/tencent/state/square/data/RecordResourceInfo;", "singleMotionResource", "getSingleMotionResource", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/state/square/data/OnlineStatus;", "getActionId", "", "()Ljava/lang/Integer;", "getDisplayResource", "squareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "currentFriend", "withModelGender", "(Lcom/tencent/state/square/data/SquareAvatarItem;Lcom/tencent/state/square/data/SquareMultiMotionDetailData;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/state/square/data/RecordResourceInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SingleResourceInfo extends BaseResourceInfo {
    private final boolean isMultiAction;
    private final List<RecordResourceInfo> recordResources;
    private final RecordResourceInfo resource;
    private final RecordResourceInfo singleMotionResource;
    private final OnlineStatus status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x001b, code lost:
    
        r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SingleResourceInfo(OnlineStatus status, RecordResourceInfo recordResourceInfo, String str, String motionUrl, String motionName, StatusLockInfo statusLockInfo) {
        super(str, motionUrl, motionName, statusLockInfo);
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(motionUrl, "motionUrl");
        Intrinsics.checkNotNullParameter(motionName, "motionName");
        this.status = status;
        this.resource = recordResourceInfo;
        List<RecordResourceInfo> emptyList = (recordResourceInfo == null || emptyList == null) ? CollectionsKt__CollectionsKt.emptyList() : emptyList;
        this.recordResources = emptyList;
        this.singleMotionResource = recordResourceInfo;
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public Integer getActionId() {
        Resource resource;
        RecordResourceInfo recordResourceInfo = this.resource;
        if (recordResourceInfo == null || (resource = recordResourceInfo.getResource()) == null) {
            return null;
        }
        return Integer.valueOf(resource.getActionId());
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public List<RecordResourceInfo> getRecordResources() {
        return this.recordResources;
    }

    public final RecordResourceInfo getResource() {
        return this.resource;
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public RecordResourceInfo getSingleMotionResource() {
        return this.singleMotionResource;
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public OnlineStatus getStatus() {
        return this.status;
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public boolean isFilament() {
        Resource resource;
        RecordResourceInfo recordResourceInfo = this.resource;
        return (recordResourceInfo == null || (resource = recordResourceInfo.getResource()) == null || !resource.getFilamentReady()) ? false : true;
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    /* renamed from: isMultiAction, reason: from getter */
    public boolean getIsMultiAction() {
        return this.isMultiAction;
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public RecordResourceInfo getDisplayResource(SquareAvatarItem squareItem, SquareMultiMotionDetailData inviteState, String currentFriend, Integer withModelGender) {
        Resource curBatteryLevelResource;
        RecordResourceInfo recordResourceInfo;
        if (squareItem != null) {
            if (OnlineStatusBubbleViewHelperKt.isBatteryStatus(getStatus()) && (curBatteryLevelResource = SquareBatteryStatusManager.INSTANCE.getCurBatteryLevelResource(squareItem.getUin(), squareItem.getIsGenderMale(), squareItem.getDressKey())) != null && (recordResourceInfo = this.resource) != null) {
                recordResourceInfo.setResource(curBatteryLevelResource);
            }
            return this.resource;
        }
        return this.resource;
    }
}
