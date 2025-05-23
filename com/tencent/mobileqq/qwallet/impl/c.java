package com.tencent.mobileqq.qwallet.impl;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/impl/c;", "", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "a", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f278227a = new c();

    c() {
    }

    @JvmStatic
    public static final boolean a(@Nullable BaseQQAppInterface app) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean startsWith$default;
        boolean z16;
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return false;
        }
        boolean gestureLocking = BaseGesturePWDUtil.getGestureLocking(context);
        QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "isQQForeground isQQLock=" + gestureLocking);
        if (app != null && !gestureLocking) {
            if (!app.isBackgroundPause) {
                return true;
            }
            try {
                ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                if (activityManager == null) {
                    return false;
                }
                String packageName = context.getApplicationContext().getPackageName();
                if (TextUtils.isEmpty(packageName) || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) == null) {
                    return false;
                }
                ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
                for (Object obj : runningAppProcesses) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : arrayList) {
                    if (Intrinsics.areEqual(runningAppProcessInfo2.processName, packageName + MsfConstants.PROCESS_VIDEO)) {
                        return false;
                    }
                    if (!Intrinsics.areEqual(runningAppProcessInfo2.processName, packageName)) {
                        String str = runningAppProcessInfo2.processName;
                        Intrinsics.checkNotNullExpressionValue(str, "it.processName");
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, packageName + ":", false, 2, null);
                        if (startsWith$default) {
                        }
                    }
                    return true;
                }
                return false;
            } catch (Exception e16) {
                QLog.w(IQWalletHelper.TAG_WALLET_PUSH, 2, "isQQForeground: ", e16);
            }
        }
        return false;
    }
}
