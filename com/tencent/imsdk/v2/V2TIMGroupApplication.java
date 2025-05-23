package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupApplication;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMGroupApplication implements Serializable {
    public static final int V2TIM_GROUP_APPLICATION_GET_TYPE_INVITE = 1;
    public static final int V2TIM_GROUP_APPLICATION_GET_TYPE_JOIN = 0;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_RESULT_AGREE = 1;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_RESULT_REFUSE = 0;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_HANDLED_BY_OTHER = 1;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_HANDLED_BY_SELF = 2;
    public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_UNHANDLED = 0;
    private GroupApplication groupApplication = new GroupApplication();

    public long getAddTime() {
        return this.groupApplication.getRequestTime();
    }

    public String getFromUser() {
        return this.groupApplication.getFromUserID();
    }

    public String getFromUserFaceUrl() {
        return this.groupApplication.getFromUserFaceUrl();
    }

    public String getFromUserNickName() {
        return this.groupApplication.getFromUserNickName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupApplication getGroupApplication() {
        return this.groupApplication;
    }

    public String getGroupID() {
        return this.groupApplication.getGroupID();
    }

    public int getHandleResult() {
        int responseType = this.groupApplication.getResponseType();
        if (responseType == GroupApplication.RESPONSE_TYPE_AGREE || responseType != GroupApplication.RESPONSE_TYPE_REFUSE) {
            return 1;
        }
        return 0;
    }

    public int getHandleStatus() {
        int responseStatus = this.groupApplication.getResponseStatus();
        if (responseStatus == GroupApplication.RESPONSE_STATUS_UNHANDLED) {
            return 0;
        }
        if (responseStatus == GroupApplication.RESPONSE_STATUS_HANDLED_BY_OTHER) {
            return 1;
        }
        if (responseStatus != GroupApplication.RESPONSE_STATUS_HANDLED_BY_SELF) {
            return 0;
        }
        return 2;
    }

    public String getHandledMsg() {
        return this.groupApplication.getResponseMessage();
    }

    public String getRequestMsg() {
        return this.groupApplication.getRequestMessage();
    }

    public String getToUser() {
        return this.groupApplication.getToUserID();
    }

    public int getType() {
        int applicationType = this.groupApplication.getApplicationType();
        if (applicationType == GroupApplication.REQUEST_TYPE_INVITE || applicationType != GroupApplication.REQUEST_TYPE_JOIN) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGroupApplication(GroupApplication groupApplication) {
        this.groupApplication = groupApplication;
    }
}
