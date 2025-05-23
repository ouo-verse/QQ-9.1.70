package com.tencent.biz.qcircleshadow.lib.variation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.biz.qcircleshadow.lib.QCircleHostClassHelper;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qqforward.api.RecentContactListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostForwardUtils {
    private static final String HOST_FORWARD_DIALOG_RECENTLY_FLAG = "host_forward_dialog_recently_flag";
    private static final String HOST_FORWARD_RECENTLY_CHAT_FLAG = "host_forward_recently_chat_flag";
    private static final String HOST_FORWARD_TYPE_KEY = "host_forward_type_key";
    private static final String KEY_FORWARD_REPORT_BEAN = "KEY_FORWARD_REPORT_BEAN";
    private static final String KEY_QCIRCLE_FORWARD = "key_qcircle_forward";
    private static final String TAG = "RHF-HostForwardUtils";
    private IForwardOption mForwardOption = (IForwardOption) QRoute.api(IForwardOption.class);

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class ForwardInfoEntity implements Serializable {
        public static final long serialVersionUID = 1;
        private String mForwardName;
        private String mForwardUin;
        private int mForwardUinType;

        public String getForwardName() {
            return this.mForwardName;
        }

        public String getForwardUin() {
            return this.mForwardUin;
        }

        public int getForwardUinType() {
            return this.mForwardUinType;
        }

        public void setForwardName(String str) {
            this.mForwardName = str;
        }

        public void setForwardUin(String str) {
            this.mForwardUin = str;
        }

        public void setForwardUinType(int i3) {
            this.mForwardUinType = i3;
        }

        public String toString() {
            return "ForwardInfoEntity{mForwardUin='" + this.mForwardUin + "', mForwardUinType='" + this.mForwardUinType + "', mForwardName='" + this.mForwardName + "'}";
        }
    }

    public static String HOST_FORWARD_DIALOG_RECENTLY_FLAG() {
        return HOST_FORWARD_DIALOG_RECENTLY_FLAG;
    }

    public static String HOST_FORWARD_RECENTLY_CHAT_FLAG() {
        return HOST_FORWARD_RECENTLY_CHAT_FLAG;
    }

    public static String HOST_FORWARD_TYPE_KEY() {
        return HOST_FORWARD_TYPE_KEY;
    }

    public static String KEY_FORWARD_REPORT_BEAN() {
        return KEY_FORWARD_REPORT_BEAN;
    }

    public static String KEY_QCIRCLE_FORWARD() {
        return KEY_QCIRCLE_FORWARD;
    }

    public static String getNeedShowGuildEntranceKey() {
        return IGuildFeatureAdapterApi.PARAM_NEED_SHOW_GUILD_ENTRANCE;
    }

    public void addForwardType(Intent intent, String str) {
        if (intent == null) {
            QLog.w(TAG, 1, "[addForwardType] intent should not be null.");
        } else {
            intent.putExtra(HOST_FORWARD_TYPE_KEY, str);
        }
    }

    public void getQQRecentlyFriends(RecentContactListener recentContactListener) {
        this.mForwardOption.getForwardRecentList(recentContactListener);
    }

    public void registerForwardResultReceiver(Intent intent, ResultReceiver resultReceiver) {
        if (intent == null) {
            QLog.w(TAG, 1, "[registerForwardResultReceiver] intent should not be null.");
        } else {
            intent.putExtra("PARAM_ActivityResultReceiver", resultReceiver);
            intent.putExtra(KEY_QCIRCLE_FORWARD, true);
        }
    }

    public void startForwardActivityForResult(Context context, Intent intent) {
        if (context == null) {
            QLog.d(TAG, 1, "[startForwardActivityForResult] context not is null.");
        } else if (!(context instanceof Activity)) {
            QLog.d(TAG, 1, "[startForwardActivityForResult] context not is Activity");
        } else {
            this.mForwardOption.startForwardActivityForResult((Activity) context, intent, QCircleHostClassHelper.getForwardRecentTranslucentActivityClass(), 19005);
        }
    }
}
