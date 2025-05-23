package com.tencent.biz.qqcircle.helpers;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/g;", "", "Lorg/json/JSONObject;", "b", "", "hashcode", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "", "g", "d", "c", "e", "value", "f", "a", "", "Ljava/util/Map;", "mCommentCanShowFeedbackMap", "Lorg/json/JSONObject;", "mConfigObj", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f84619a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Boolean> mCommentCanShowFeedbackMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static JSONObject mConfigObj;

    g() {
    }

    private final JSONObject b() {
        try {
            return new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_comment_feedback_card_intervals_config", "{\"default_intervals\":10,\"clk_intervals\":7,\"show_position\":6,\"show_cnt\":0}"));
        } catch (Exception e16) {
            QLog.e("QFSCommentFeedbackHelper", 1, "[getConfigJsonObject] exception: " + e16);
            return new JSONObject("{\"default_intervals\":10,\"clk_intervals\":7,\"show_position\":6,\"show_cnt\":0}");
        }
    }

    public final boolean a(int hashcode) {
        long f16 = uq3.k.a().f("key_feedback_show_timestamp", 0L);
        boolean c16 = uq3.k.a().c("key_feedback_clk_flag", false);
        JSONObject b16 = b();
        int optInt = b16.optInt("default_intervals");
        int optInt2 = b16.optInt("clk_intervals");
        if (c16) {
            optInt = optInt2;
        }
        if (System.currentTimeMillis() - f16 <= optInt * 86400000 || !Intrinsics.areEqual(mCommentCanShowFeedbackMap.get(Integer.valueOf(hashcode)), Boolean.TRUE)) {
            return false;
        }
        return true;
    }

    public final int c() {
        try {
            if (mConfigObj == null) {
                mConfigObj = b();
            }
            JSONObject jSONObject = mConfigObj;
            if (jSONObject == null) {
                return 0;
            }
            return jSONObject.optInt("show_cnt");
        } catch (Exception e16) {
            QLog.d("QFSCommentFeedbackHelper", 1, "[getShowCount] error:" + e16);
            return 0;
        }
    }

    public final int d() {
        int i3;
        try {
            if (mConfigObj == null) {
                mConfigObj = b();
            }
            JSONObject jSONObject = mConfigObj;
            if (jSONObject != null) {
                i3 = jSONObject.optInt("show_position");
            } else {
                i3 = 6;
            }
            return i3 - 1;
        } catch (Exception e16) {
            QLog.d("QFSCommentFeedbackHelper", 1, "[getShowPos] error:" + e16);
            return 5;
        }
    }

    public final void e() {
        QLog.d("QFSCommentFeedbackHelper", 1, "[saveFeedShowTimestamp]");
        uq3.k.a().n("key_feedback_show_timestamp", System.currentTimeMillis());
        f(false);
    }

    public final void f(boolean value) {
        QLog.d("QFSCommentFeedbackHelper", 1, "[saveRealFeedBackClickFlag] value:" + value);
        uq3.k.a().j("key_feedback_clk_flag", value);
    }

    public final void g(int hashcode, boolean canShow) {
        mCommentCanShowFeedbackMap.put(Integer.valueOf(hashcode), Boolean.valueOf(canShow));
    }
}
