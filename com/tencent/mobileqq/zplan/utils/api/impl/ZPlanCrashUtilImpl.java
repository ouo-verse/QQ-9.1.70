package com.tencent.mobileqq.zplan.utils.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.zplan.utils.api.IZPlanCrashUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import t74.r;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/impl/ZPlanCrashUtilImpl;", "Lcom/tencent/mobileqq/zplan/utils/api/IZPlanCrashUtil;", "", "parseCrashTimeList", "", "crashTime", "handleNeedCloseZPlan", "", "isNativeCrashed", "", "crashType", "crashStack", "handleCrash", "closeZPlanSwitchWhenCrashTooMore", "clearZPlanCrashSwitch", "", "mCrashTimeList", "Ljava/util/List;", "Landroid/content/SharedPreferences;", "mZPlanSp", "Landroid/content/SharedPreferences;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanCrashUtilImpl implements IZPlanCrashUtil {
    public static final String SP_KEY_CRASH_TIME = "crash_time";
    public static final String SP_NAME = "zplan_crash";
    public static final String STR_DELIMETER = ",";
    public static final String TAG = "ZPlanCrashUtilImpl";
    private List<Long> mCrashTimeList = new ArrayList();
    private SharedPreferences mZPlanSp;
    private static final String SP_KEY_ZPLAN_SWITCH = AppSetting.f99551k + "_crash_close_switch";

    public ZPlanCrashUtilImpl() {
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(SP_NAME, 4);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sMobileQQ.getSharedPrefe\u2026ntext.MODE_MULTI_PROCESS)");
        this.mZPlanSp = sharedPreferences;
        parseCrashTimeList();
    }

    private final void handleNeedCloseZPlan(long crashTime) {
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        int d16 = zPlanFeatureSwitch.d1();
        int e16 = zPlanFeatureSwitch.e1();
        SharedPreferences sharedPreferences = null;
        if (this.mCrashTimeList.size() > d16) {
            if (crashTime - this.mCrashTimeList.get(r1.size() - 2).longValue() < e16) {
                QLog.e(TAG, 1, "close zplan!!!!");
                SharedPreferences sharedPreferences2 = this.mZPlanSp;
                if (sharedPreferences2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mZPlanSp");
                    sharedPreferences2 = null;
                }
                sharedPreferences2.edit().putString("crash_time", "").commit();
                SharedPreferences sharedPreferences3 = this.mZPlanSp;
                if (sharedPreferences3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mZPlanSp");
                } else {
                    sharedPreferences = sharedPreferences3;
                }
                SharedPreferences.Editor putBoolean = sharedPreferences.edit().putBoolean(SP_KEY_ZPLAN_SWITCH, true);
                if (putBoolean != null) {
                    putBoolean.commit();
                    return;
                }
                return;
            }
        }
        if (closeZPlanSwitchWhenCrashTooMore()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<Long> it = this.mCrashTimeList.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().longValue());
            sb5.append(",");
        }
        QLog.e(TAG, 1, "save crash time " + ((Object) sb5));
        SharedPreferences sharedPreferences4 = this.mZPlanSp;
        if (sharedPreferences4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZPlanSp");
        } else {
            sharedPreferences = sharedPreferences4;
        }
        SharedPreferences.Editor putString = sharedPreferences.edit().putString("crash_time", sb5.toString());
        if (putString != null) {
            putString.commit();
        }
    }

    private final void parseCrashTimeList() {
        List<String> split$default;
        SharedPreferences sharedPreferences = this.mZPlanSp;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZPlanSp");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("crash_time", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        Intrinsics.checkNotNull(string);
        split$default = StringsKt__StringsKt.split$default((CharSequence) string, new String[]{","}, false, 0, 6, (Object) null);
        for (String str : split$default) {
            if (!TextUtils.isEmpty(str)) {
                this.mCrashTimeList.add(Long.valueOf(Long.parseLong(str)));
            }
        }
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanCrashUtil
    public void clearZPlanCrashSwitch() {
        SharedPreferences sharedPreferences = this.mZPlanSp;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZPlanSp");
            sharedPreferences = null;
        }
        sharedPreferences.edit().putBoolean(SP_KEY_ZPLAN_SWITCH, false).commit();
        QLog.e(TAG, 1, "clearZPlanCrashSwitch success");
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanCrashUtil
    public boolean closeZPlanSwitchWhenCrashTooMore() {
        SharedPreferences sharedPreferences = this.mZPlanSp;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mZPlanSp");
            sharedPreferences = null;
        }
        boolean z16 = sharedPreferences.getBoolean(SP_KEY_ZPLAN_SWITCH, false);
        QLog.e(TAG, 1, "getZPlanCrashSwitch " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanCrashUtil
    public void handleCrash(boolean isNativeCrashed, String crashType, String crashStack) {
        Object obj;
        try {
            QLog.e(TAG, 1, "handleCrash, isNativeCrashed: " + isNativeCrashed + ", crashType: " + crashType + ", crashStack: " + crashStack);
            if (isNativeCrashed) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mCrashTimeList.add(Long.valueOf(currentTimeMillis));
                handleNeedCloseZPlan(currentTimeMillis);
            }
            PerfReportUtil.k();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str = "1";
            if (isNativeCrashed) {
                obj = "1";
            } else {
                obj = "0";
            }
            linkedHashMap.put("zplan_native_crash", obj);
            if (!ZPlanFeatureSwitch.f369852a.f3()) {
                str = "0";
            }
            linkedHashMap.put("zplan_preload", str);
            r.e(null, SP_NAME, linkedHashMap, 1, null);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "handleCrash", th5);
        }
    }
}
