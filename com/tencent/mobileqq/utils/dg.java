package com.tencent.mobileqq.utils;

import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0002R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/utils/dg;", "", "", "d", "", "key", "Lorg/json/JSONObject;", "springFestivalConfig", "b", "e", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/r;", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/r;", "c", "()Lcom/tencent/mobileqq/activity/qqsettingme/bean/r;", "setSpringFestivalDataBean", "(Lcom/tencent/mobileqq/activity/qqsettingme/bean/r;)V", "springFestivalDataBean", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class dg {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final dg f307630a = new dg();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.activity.qqsettingme.bean.r springFestivalDataBean;

    dg() {
    }

    private final String b(String key, JSONObject springFestivalConfig) {
        if (springFestivalConfig == null) {
            return null;
        }
        try {
            return springFestivalConfig.getString(key);
        } catch (JSONException e16) {
            QLog.e("QQSettingMeToggleManager", 1, "getConfigData error:" + e16);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(2:3|(14:7|8|9|10|11|(8:13|15|16|(4:18|(1:24)|25|26)|29|(3:20|22|24)|25|26)|32|15|16|(0)|29|(0)|25|26))|38|9|10|11|(0)|32|15|16|(0)|29|(0)|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        com.tencent.qphone.base.util.QLog.e("QQSettingMeToggleManager", 1, "festivalEndTime error:" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
    
        com.tencent.qphone.base.util.QLog.e("QQSettingMeToggleManager", 1, "festivalStartTime error:" + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[Catch: NumberFormatException -> 0x0064, TRY_LEAVE, TryCatch #1 {NumberFormatException -> 0x0064, blocks: (B:11:0x0054, B:13:0x005d), top: B:10:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0084 A[Catch: NumberFormatException -> 0x0089, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x0089, blocks: (B:16:0x007b, B:18:0x0084), top: B:15:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d() {
        JSONObject jSONObject;
        String b16;
        long j3;
        long j16;
        String b17;
        String b18;
        Pair<Boolean, String> switchAndValue = ((IFeatureServiceProxy) QRoute.api(IFeatureServiceProxy.class)).getSwitchAndValue("qq_setting_me_spring_festival_bg");
        com.tencent.mobileqq.activity.qqsettingme.bean.r rVar = null;
        if (switchAndValue != null) {
            Object obj = switchAndValue.first;
            Intrinsics.checkNotNullExpressionValue(obj, "pair.first");
            if (((Boolean) obj).booleanValue() && switchAndValue.second != null) {
                try {
                    jSONObject = new JSONObject((String) switchAndValue.second);
                } catch (JSONException e16) {
                    QLog.e("QQSettingMeToggleManager", 1, "updateToggle mConfig error:" + e16);
                }
                b16 = b("spring_festival_bg", jSONObject);
                b18 = b("start_time", jSONObject);
                if (b18 != null) {
                    j3 = Long.parseLong(b18);
                    b17 = b("end_time", jSONObject);
                    if (b17 != null) {
                        j16 = Long.parseLong(b17);
                        if (b16 != null && j3 != 0 && j16 != 0) {
                            rVar = new com.tencent.mobileqq.activity.qqsettingme.bean.r(b16, j3, j16);
                        }
                        springFestivalDataBean = rVar;
                    }
                    j16 = 0;
                    if (b16 != null) {
                        rVar = new com.tencent.mobileqq.activity.qqsettingme.bean.r(b16, j3, j16);
                    }
                    springFestivalDataBean = rVar;
                }
                j3 = 0;
                b17 = b("end_time", jSONObject);
                if (b17 != null) {
                }
                j16 = 0;
                if (b16 != null) {
                }
                springFestivalDataBean = rVar;
            }
        }
        jSONObject = null;
        b16 = b("spring_festival_bg", jSONObject);
        b18 = b("start_time", jSONObject);
        if (b18 != null) {
        }
        j3 = 0;
        b17 = b("end_time", jSONObject);
        if (b17 != null) {
        }
        j16 = 0;
        if (b16 != null) {
        }
        springFestivalDataBean = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        f307630a.d();
        QLog.i("QQSettingMeToggleManager", 1, "updateToggle, mSpringFestivalDataBean:" + springFestivalDataBean);
    }

    @Nullable
    public final com.tencent.mobileqq.activity.qqsettingme.bean.r c() {
        return springFestivalDataBean;
    }

    public final void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.utils.df
            @Override // java.lang.Runnable
            public final void run() {
                dg.f();
            }
        }, 16, null, false);
    }
}
