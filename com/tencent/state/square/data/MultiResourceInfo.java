package com.tencent.state.square.data;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.state.data.Gender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016\u00a2\u0006\u0002\u0010\u001cJ7\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010#\u001a\u0004\u0018\u00010\u001bH\u0016\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u001bH\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020!H\u0002R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/state/square/data/MultiResourceInfo;", "Lcom/tencent/state/square/data/BaseResourceInfo;", "status", "Lcom/tencent/state/square/data/OnlineStatus;", DKConfiguration.Directory.RESOURCES, "", "Lcom/tencent/state/square/data/RecordResourceInfo;", "redDotId", "", "motionUrl", "motionName", "lockInfo", "Lcom/tencent/state/square/data/StatusLockInfo;", "(Lcom/tencent/state/square/data/OnlineStatus;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/data/StatusLockInfo;)V", "isFilament", "", "()Z", "isMultiAction", "recordResources", "getRecordResources", "()Ljava/util/List;", "singleMotionResource", "getSingleMotionResource", "()Lcom/tencent/state/square/data/RecordResourceInfo;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/state/square/data/OnlineStatus;", "getActionId", "", "()Ljava/lang/Integer;", "getDisplayResource", "squareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "currentFriend", "withModelGender", "(Lcom/tencent/state/square/data/SquareAvatarItem;Lcom/tencent/state/square/data/SquareMultiMotionDetailData;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/state/square/data/RecordResourceInfo;", "getMotionIdForPublish", "getMultiActionResource", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MultiResourceInfo extends BaseResourceInfo {
    private final boolean isMultiAction;
    private final List<RecordResourceInfo> recordResources;
    private final List<RecordResourceInfo> resources;
    private final RecordResourceInfo singleMotionResource;
    private final OnlineStatus status;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiResourceInfo(OnlineStatus status, List<RecordResourceInfo> resources, String str, String motionUrl, String motionName, StatusLockInfo statusLockInfo) {
        super(str, motionUrl, motionName, statusLockInfo);
        Object obj;
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(motionUrl, "motionUrl");
        Intrinsics.checkNotNullParameter(motionName, "motionName");
        this.status = status;
        this.resources = resources;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : resources) {
            if (((RecordResourceInfo) obj2).getResource().isSingleAction()) {
                arrayList.add(obj2);
            }
        }
        this.recordResources = arrayList;
        Iterator<T> it = this.resources.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((RecordResourceInfo) obj).getResource().isSingleAction()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        this.singleMotionResource = (RecordResourceInfo) obj;
        this.isMultiAction = true;
    }

    private final RecordResourceInfo getMultiActionResource(SquareMultiMotionDetailData inviteState) {
        Object obj;
        Iterator<T> it = this.resources.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((RecordResourceInfo) obj).getResource().isMultiAction()) {
                break;
            }
        }
        RecordResourceInfo recordResourceInfo = (RecordResourceInfo) obj;
        if (recordResourceInfo == null) {
            return null;
        }
        if (recordResourceInfo.getResource().getActionId() == inviteState.getResource().getActionId()) {
            recordResourceInfo.setResource(inviteState.getResource());
        }
        return recordResourceInfo;
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public Integer getActionId() {
        Object firstOrNull;
        Resource resource;
        List<RecordResourceInfo> list = this.resources;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((RecordResourceInfo) obj).getResource().getActionType() == 1) {
                arrayList.add(obj);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        RecordResourceInfo recordResourceInfo = (RecordResourceInfo) firstOrNull;
        if (recordResourceInfo == null || (resource = recordResourceInfo.getResource()) == null) {
            return null;
        }
        return Integer.valueOf(resource.getActionId());
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public int getMotionIdForPublish() {
        Object obj;
        Resource resource;
        List<RecordResourceInfo> list = this.resources;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((RecordResourceInfo) obj).getResource().isMultiAction()) {
                    break;
                }
            }
            RecordResourceInfo recordResourceInfo = (RecordResourceInfo) obj;
            if (recordResourceInfo != null && (resource = recordResourceInfo.getResource()) != null) {
                return resource.getActionId();
            }
        }
        return super.getMotionIdForPublish();
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    public List<RecordResourceInfo> getRecordResources() {
        return this.recordResources;
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
        Object firstOrNull;
        Resource resource;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.resources);
        RecordResourceInfo recordResourceInfo = (RecordResourceInfo) firstOrNull;
        return (recordResourceInfo == null || (resource = recordResourceInfo.getResource()) == null || !resource.getFilamentReady()) ? false : true;
    }

    @Override // com.tencent.state.square.data.BaseResourceInfo
    /* renamed from: isMultiAction, reason: from getter */
    public boolean getIsMultiAction() {
        return this.isMultiAction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    @Override // com.tencent.state.square.data.BaseResourceInfo
    public RecordResourceInfo getDisplayResource(SquareAvatarItem squareItem, SquareMultiMotionDetailData inviteState, String currentFriend, Integer withModelGender) {
        RecordResourceInfo recordResourceInfo;
        RecordResourceInfo recordResourceInfo2;
        Resource resource;
        Boolean bool = null;
        if ((inviteState != null && inviteState.isInviteSuccess() && getStatus().getId() == inviteState.getStatusInfo().getId() && (currentFriend == null || inviteState.isInInvite(currentFriend))) && inviteState != null) {
            recordResourceInfo2 = getMultiActionResource(inviteState);
        } else {
            Iterator it = this.resources.iterator();
            while (true) {
                if (!it.hasNext()) {
                    recordResourceInfo = 0;
                    break;
                }
                recordResourceInfo = it.next();
                if (((RecordResourceInfo) recordResourceInfo).getResource().isMultiAction()) {
                    break;
                }
            }
            recordResourceInfo2 = recordResourceInfo;
        }
        if (recordResourceInfo2 != null && (resource = recordResourceInfo2.getResource()) != null && resource.getIsDefault()) {
            if (withModelGender != null) {
                bool = Boolean.valueOf(withModelGender.intValue() == Gender.MALE.ordinal());
            }
            recordResourceInfo2.getResource().getDynamic().resetDefaultWithGender(bool);
            recordResourceInfo2.getResource().getStatic().resetDefaultWithGender(bool);
        }
        return recordResourceInfo2;
    }
}
