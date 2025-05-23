package com.tencent.state.square.data;

import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\"\u001a\u0004\u0018\u00010#H&\u00a2\u0006\u0002\u0010$J=\u0010%\u001a\u0004\u0018\u00010\u00172\b\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010#H&\u00a2\u0006\u0002\u0010,J\b\u0010-\u001a\u00020#H\u0016J\u0006\u0010.\u001a\u00020\nJ\u0006\u0010/\u001a\u00020\nJ\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\nJ\b\u00105\u001a\u00020\u0003H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0012\u0010\u000f\u001a\u00020\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u00066"}, d2 = {"Lcom/tencent/state/square/data/BaseResourceInfo;", "", "redDotId", "", "motionUrl", "motionName", "lockInfo", "Lcom/tencent/state/square/data/StatusLockInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/data/StatusLockInfo;)V", "hasPick", "", "hasSelected", "isFilament", "()Z", "isLock", "isMultiAction", "getLockInfo", "()Lcom/tencent/state/square/data/StatusLockInfo;", "getMotionName", "()Ljava/lang/String;", "getMotionUrl", "recordResources", "", "Lcom/tencent/state/square/data/RecordResourceInfo;", "getRecordResources", "()Ljava/util/List;", "getRedDotId", "singleMotionResource", "getSingleMotionResource", "()Lcom/tencent/state/square/data/RecordResourceInfo;", "status", "Lcom/tencent/state/square/data/OnlineStatus;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lcom/tencent/state/square/data/OnlineStatus;", "getActionId", "", "()Ljava/lang/Integer;", "getDisplayResource", "squareItem", "Lcom/tencent/state/square/data/SquareAvatarItem;", "inviteState", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "currentFriend", "withModelGender", "(Lcom/tencent/state/square/data/SquareAvatarItem;Lcom/tencent/state/square/data/SquareMultiMotionDetailData;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/state/square/data/RecordResourceInfo;", "getMotionIdForPublish", "isPick", "isSelected", "setPick", "", "pick", "setSelected", "selected", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class BaseResourceInfo {
    private boolean hasPick;
    private boolean hasSelected;
    private final boolean isLock;
    private final StatusLockInfo lockInfo;
    private final String motionName;
    private final String motionUrl;
    private final String redDotId;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (r5.getLockStatus() == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseResourceInfo(String str, String motionUrl, String motionName, StatusLockInfo statusLockInfo) {
        Intrinsics.checkNotNullParameter(motionUrl, "motionUrl");
        Intrinsics.checkNotNullParameter(motionName, "motionName");
        this.redDotId = str;
        this.motionUrl = motionUrl;
        this.motionName = motionName;
        this.lockInfo = statusLockInfo;
        boolean z16 = statusLockInfo != null;
        this.isLock = z16;
    }

    public abstract Integer getActionId();

    public abstract RecordResourceInfo getDisplayResource(SquareAvatarItem squareItem, SquareMultiMotionDetailData inviteState, String currentFriend, Integer withModelGender);

    public final StatusLockInfo getLockInfo() {
        return this.lockInfo;
    }

    public int getMotionIdForPublish() {
        Object firstOrNull;
        Resource resource;
        List<RecordResourceInfo> recordResources = getRecordResources();
        if (recordResources != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) recordResources);
            RecordResourceInfo recordResourceInfo = (RecordResourceInfo) firstOrNull;
            if (recordResourceInfo != null && (resource = recordResourceInfo.getResource()) != null) {
                return resource.getActionId();
            }
        }
        return 0;
    }

    public final String getMotionName() {
        return this.motionName;
    }

    public final String getMotionUrl() {
        return this.motionUrl;
    }

    public abstract List<RecordResourceInfo> getRecordResources();

    public final String getRedDotId() {
        return this.redDotId;
    }

    public abstract RecordResourceInfo getSingleMotionResource();

    public abstract OnlineStatus getStatus();

    public abstract boolean isFilament();

    /* renamed from: isLock, reason: from getter */
    public final boolean getIsLock() {
        return this.isLock;
    }

    public abstract boolean isMultiAction();

    /* renamed from: isPick, reason: from getter */
    public final boolean getHasPick() {
        return this.hasPick;
    }

    /* renamed from: isSelected, reason: from getter */
    public final boolean getHasSelected() {
        return this.hasSelected;
    }

    public final void setPick(boolean pick) {
        this.hasPick = pick;
        this.hasSelected = pick;
    }

    public final void setSelected(boolean selected) {
        this.hasSelected = selected;
    }

    public String toString() {
        return "BaseResourceInfo(status=" + getStatus().getId() + util.base64_pad_url + getStatus().getTitle() + ", isMultiAction=" + isMultiAction() + ')';
    }

    public static /* synthetic */ RecordResourceInfo getDisplayResource$default(BaseResourceInfo baseResourceInfo, SquareAvatarItem squareAvatarItem, SquareMultiMotionDetailData squareMultiMotionDetailData, String str, Integer num, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                squareMultiMotionDetailData = null;
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            if ((i3 & 8) != 0) {
                num = null;
            }
            return baseResourceInfo.getDisplayResource(squareAvatarItem, squareMultiMotionDetailData, str, num);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDisplayResource");
    }
}
