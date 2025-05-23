package com.tencent.mobileqq.qcircle.api.constant;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/constant/QCirclePublicAccountDc5504ActionType;", "", "()V", "ENTRY", "", "PROFILE_PAGE_CANCEL_FOLLOW", "PROFILE_PAGE_FOLLOW", "PROFILE_PAGE_RECEIVE_MESSAGE", "PROFILE_PAGE_SECOND_CONFIRM", "PROFILE_PAGE_SET_UP", "PROFILE_PAGE_SHARE", "PROFILE_PAGE_TIP_OFF", "isPublicAccountActionType", "", "actionType", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountDc5504ActionType {
    public static final int ENTRY = 116;

    @NotNull
    public static final QCirclePublicAccountDc5504ActionType INSTANCE = new QCirclePublicAccountDc5504ActionType();
    public static final int PROFILE_PAGE_CANCEL_FOLLOW = 131;
    public static final int PROFILE_PAGE_FOLLOW = 137;
    public static final int PROFILE_PAGE_RECEIVE_MESSAGE = 134;
    public static final int PROFILE_PAGE_SECOND_CONFIRM = 136;
    public static final int PROFILE_PAGE_SET_UP = 135;
    public static final int PROFILE_PAGE_SHARE = 132;
    public static final int PROFILE_PAGE_TIP_OFF = 133;

    QCirclePublicAccountDc5504ActionType() {
    }

    @JvmStatic
    public static final boolean isPublicAccountActionType(int actionType) {
        if (actionType != 116 && actionType != 131 && actionType != 132 && actionType != 133 && actionType != 134 && actionType != 135 && actionType != 136 && actionType != 137) {
            return false;
        }
        return true;
    }
}
