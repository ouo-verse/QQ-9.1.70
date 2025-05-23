package com.tencent.mobileqq.qqecommerce.biz.kuikly.utils;

import android.util.DisplayMetrics;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.QQKuiklyRouterImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/a;", "", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/utils/a$a;", "", "", "b", "", "bundleName", "pageName", "a", "PAD_MAXWIDTH_KEY", "Ljava/lang/String;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(String bundleName, String pageName) {
            Intrinsics.checkNotNullParameter(bundleName, "bundleName");
            Intrinsics.checkNotNullParameter(pageName, "pageName");
            if (!(bundleName.length() == 0)) {
                if (!(pageName.length() == 0)) {
                    if (!HippyUtils.isPadOrFoldDevice()) {
                        QLog.d(QQKuiklyRouterImpl.TAG, 1, "getMaxWidthForPad is not pad fold");
                        return 0;
                    }
                    if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102284", false)) {
                        QLog.d(QQKuiklyRouterImpl.TAG, 1, "getMaxWidthForPad config switch is off");
                        return 0;
                    }
                    try {
                        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102284", "");
                        if (loadAsString.length() == 0) {
                            if (QLog.isColorLevel()) {
                                QLog.i(QQKuiklyRouterImpl.TAG, 1, "getMaxWidthForPad abort,config not found");
                            }
                            return 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(QQKuiklyRouterImpl.TAG, 1, "getMaxWidthForPad " + bundleName + "|" + pageName + ",jsonStr=" + loadAsString);
                        }
                        JSONObject optJSONObject = new JSONObject(loadAsString).optJSONObject(bundleName);
                        if (optJSONObject == null) {
                            return 0;
                        }
                        Integer valueOf = Integer.valueOf(optJSONObject.optInt(pageName, 0));
                        QLog.i(QQKuiklyRouterImpl.TAG, 1, "getMaxWidthForPad " + bundleName + "|" + pageName + ",maxWidth=" + valueOf);
                        return valueOf.intValue();
                    } catch (Throwable th5) {
                        QLog.e(QQKuiklyRouterImpl.TAG, 1, "getMaxWidthForPad " + bundleName + "|" + pageName + " fail.", th5);
                        return 0;
                    }
                }
            }
            QLog.d(QQKuiklyRouterImpl.TAG, 1, "getMaxWidthForPad params error, " + bundleName + "|" + pageName);
            return 0;
        }

        public final int b() {
            DisplayMetrics displayMetrics = HippyUtils.getDisplayMetrics();
            if (displayMetrics == null) {
                return 0;
            }
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            return i3 < i16 ? i3 : i16;
        }

        Companion() {
        }
    }
}
