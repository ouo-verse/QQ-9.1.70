package com.tencent.mobileqq.qcircle.api.global;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommonDialog$Dialog;
import java.util.TimeZone;
import uq3.k;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QFSTeenModeConfig {
    private static final String CONTENT = "content";
    private static final String JUMP_TEXT = "jump_text";
    private static final String JUMP_URL = "jump_url";
    private static final long ONE_DAY_MILLISECOND = 86400000;
    private static final String TAG = "QFSTeenModeConfig";
    private static final String TEEN_MODE_SHOW_SWITCH = "teen_mode_show_switch";
    private static final String TEEN_MODE_WINDOW_LAST_SHOW_TIME_KEY = "TeenModeWindowLastShowTimeKey";
    private static final String TITLE = "title";
    private static FeedCloudCommonDialog$Dialog mInTeenModeDialogRsp;
    private static Boolean mIsNeedShowTeenModeWindow;
    private static FeedCloudCommonDialog$Dialog mTeenModeDialogRsp;
    private static long mTeenModeWindowLastShowTime;

    public static boolean getIsNeedShowTeenModeWindow() {
        if (mIsNeedShowTeenModeWindow == null) {
            mIsNeedShowTeenModeWindow = Boolean.valueOf(k.a().c(TEEN_MODE_SHOW_SWITCH, false));
        }
        return mIsNeedShowTeenModeWindow.booleanValue();
    }

    public static FeedCloudCommonDialog$Dialog getTeenModeDialogRsp(int i3) {
        FeedCloudCommonDialog$Dialog feedCloudCommonDialog$Dialog;
        if (i3 == 2) {
            feedCloudCommonDialog$Dialog = mInTeenModeDialogRsp;
        } else {
            feedCloudCommonDialog$Dialog = mTeenModeDialogRsp;
        }
        if (feedCloudCommonDialog$Dialog == null) {
            FeedCloudCommonDialog$Dialog feedCloudCommonDialog$Dialog2 = new FeedCloudCommonDialog$Dialog();
            feedCloudCommonDialog$Dialog2.dialog_type.set(i3);
            feedCloudCommonDialog$Dialog2.title.set(k.b().h(TAG + i3 + "title", ""));
            feedCloudCommonDialog$Dialog2.content.set(k.b().h(TAG + i3 + "content", ""));
            feedCloudCommonDialog$Dialog2.jump_text.set(k.b().h(TAG + i3 + JUMP_TEXT, ""));
            feedCloudCommonDialog$Dialog2.jump_url.set(k.b().h(TAG + i3 + "jump_url", ""));
            return feedCloudCommonDialog$Dialog2;
        }
        return feedCloudCommonDialog$Dialog;
    }

    private static String getTeenModeKVKey() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + TEEN_MODE_WINDOW_LAST_SHOW_TIME_KEY;
    }

    private static long getTeenModeWindowLastShowTime() {
        long j3 = mTeenModeWindowLastShowTime;
        if (j3 > 0) {
            return j3;
        }
        return k.a().f(getTeenModeKVKey(), 0L);
    }

    private static long getTodayZeroClockTimeStamp() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - ((TimeZone.getDefault().getRawOffset() + currentTimeMillis) % 86400000);
    }

    public static boolean isTeenModeWindowShownMoreThanOneDay() {
        if (getTodayZeroClockTimeStamp() - getTeenModeWindowLastShowTime() >= 86400000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveDialogToNative(FeedCloudCommonDialog$Dialog feedCloudCommonDialog$Dialog) {
        if (feedCloudCommonDialog$Dialog == null) {
            return;
        }
        int i3 = feedCloudCommonDialog$Dialog.dialog_type.get();
        k.b().p(TAG + i3 + "title", feedCloudCommonDialog$Dialog.title.get());
        k.b().p(TAG + i3 + "content", feedCloudCommonDialog$Dialog.content.get());
        k.b().p(TAG + i3 + JUMP_TEXT, feedCloudCommonDialog$Dialog.jump_text.get());
        k.b().p(TAG + i3 + "jump_url", feedCloudCommonDialog$Dialog.jump_url.get());
    }

    public static void saveTeenModeWindowLastShowTime() {
        mTeenModeWindowLastShowTime = getTodayZeroClockTimeStamp();
        k.a().n(getTeenModeKVKey(), mTeenModeWindowLastShowTime);
    }

    public static void setIsNeedShowTeenModeWindow(boolean z16) {
        mIsNeedShowTeenModeWindow = Boolean.valueOf(z16);
        k.a().j(TEEN_MODE_SHOW_SWITCH, z16);
    }

    public static void setTeenModeDialogRsp(final FeedCloudCommonDialog$Dialog feedCloudCommonDialog$Dialog) {
        if (feedCloudCommonDialog$Dialog == null) {
            return;
        }
        int i3 = feedCloudCommonDialog$Dialog.dialog_type.get();
        if (i3 != 1) {
            if (i3 == 2) {
                mInTeenModeDialogRsp = feedCloudCommonDialog$Dialog;
            }
        } else {
            mTeenModeDialogRsp = feedCloudCommonDialog$Dialog;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.global.QFSTeenModeConfig.1
            @Override // java.lang.Runnable
            public void run() {
                QFSTeenModeConfig.saveDialogToNative(FeedCloudCommonDialog$Dialog.this);
            }
        });
    }
}
