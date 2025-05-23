package com.tencent.mobileqq.vas.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.ab.ABTest;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.api.IVasRichPanelToggle;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasRichPanelToggleImpl;", "Lcom/tencent/mobileqq/vas/api/IVasRichPanelToggle;", "", "isEnable", "", "fontUrl", "bubbleUrl", "", "preloadRes", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "toggle", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "Z", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasRichPanelToggleImpl implements IVasRichPanelToggle {

    @NotNull
    private static final String BUNDLE_NAME = "vas_aio_fontbubble";

    @NotNull
    private static final String DEF_BUBBLE_SCHEMA = "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_aio_fontbubble&bundle_name=vas_aio_fontbubble&kr_turbo_display=1&panel_type=4";

    @NotNull
    private static final String DEF_FONT_SCHEMA = "mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_aio_fontbubble&bundle_name=vas_aio_fontbubble&kr_turbo_display=1&panel_type=3";

    @NotNull
    private static final String PAGE_NAME = "vas_aio_fontbubble";

    @NotNull
    private static final String TAG = "VasRichPanelToggleImpl";
    private final boolean isEnable;

    @NotNull
    private final UnitedProxy toggle;

    public VasRichPanelToggleImpl() {
        UnitedProxy b16 = com.tencent.mobileqq.vas.ar.INSTANCE.b("shouyouye", "2024-07-11", "vas_aio_fontbubble_kuikly_config");
        this.toggle = b16;
        this.isEnable = b16.isEnable(false);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasRichPanelToggle
    @NotNull
    public String bubbleUrl() {
        String optString = this.toggle.getJson().optString("bubble", DEF_BUBBLE_SCHEMA);
        if (optString == null) {
            return "";
        }
        return optString;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasRichPanelToggle
    @NotNull
    public String fontUrl() {
        String optString = this.toggle.getJson().optString("font", DEF_FONT_SCHEMA);
        if (optString == null) {
            return "";
        }
        return optString;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasRichPanelToggle
    public boolean isEnable() {
        if (!this.isEnable) {
            QLog.i(TAG, 1, "A\u5b57\u9762\u677f \u5f00\u5173\u672a\u5f00\u542f");
            return false;
        }
        if (this.toggle.getJson().optInt(FileReaderHelper.OPEN_FILE_FROM_FORCE) == 1) {
            QLog.i(TAG, 1, "A\u5b57\u9762\u677f \u5f3a\u5236\u5f00\u542f");
            return true;
        }
        String abTestName = this.toggle.getJson().optString("abtest_name");
        if (TextUtils.isEmpty(abTestName)) {
            QLog.i(TAG, 1, "A\u5b57\u9762\u677f \u672a\u914d\u7f6eab\u540d\u79f0");
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(abTestName, "abTestName");
        ABTest component1 = new com.tencent.mobileqq.vas.ab.b(abTestName).a().component1();
        if (component1 == ABTest.B) {
            QLog.i(TAG, 1, "A\u5b57\u9762\u677f \u547d\u4e2d\u5b9e\u9a8c\u7ec4");
            return true;
        }
        QLog.i(TAG, 1, "A\u5b57\u9762\u677f \u547d\u4e2d\u5bf9\u7167\u7ec4 \u6216 miss: " + component1);
        return false;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasRichPanelToggle
    public void preloadRes() {
        QRouteApi api = QRoute.api(IVasKuiklyApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasKuiklyApi::class.java)");
        IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) api;
        if (!iVasKuiklyApi.isDexPageExist("vas_aio_fontbubble", "vas_aio_fontbubble")) {
            iVasKuiklyApi.preloadKuiklyResByRule("vas_aio_fontbubble", new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasRichPanelToggleImpl$preloadRes$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.d("VasRichPanelToggleImpl", 1, "preloadRes code:" + i3 + " msg:" + msg2);
                }
            });
        }
    }
}
