package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppDesktopRvPartExpoHelper;", "", "()V", "buildMiniAppExpoReportIdentity", "", "info", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "reportRecentMiniAppToDc04239", "", "appConfig", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "isClick", "", "reportRecentMiniAppToDc87", com.tencent.luggage.wxa.c8.c.G, "", "miniAppInfo", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDesktopRvPartExpoHelper {
    public static final MiniAppDesktopRvPartExpoHelper INSTANCE = new MiniAppDesktopRvPartExpoHelper();

    MiniAppDesktopRvPartExpoHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportRecentMiniAppToDc87$lambda$0(String str, String operId, String operType, int i3) {
        Intrinsics.checkNotNullParameter(operId, "$operId");
        Intrinsics.checkNotNullParameter(operType, "$operType");
        WadlReportBuilder operType2 = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(str).setBussinessId("1").setPageId("969").setOperModule("9048").setModuleType("904801").setOperId(operId).setOperType(operType);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        operType2.setExt(3, sb5.toString()).setExt(2, "1").report();
    }

    public final String buildMiniAppExpoReportIdentity(MiniAppInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return "appId=" + info.appId + " | appName=" + info.name + " | hash=" + info.hashCode();
    }

    public final void reportRecentMiniAppToDc04239(MiniAppConfig appConfig, boolean isClick) {
        boolean startsWith$default;
        String str;
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        String appId = appConfig.config.appId;
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(appId, "v", false, 2, null);
        if (startsWith$default) {
            if (isClick) {
                str = "virtual_click";
            } else {
                str = "virtual_expo";
            }
            MiniProgramLpReportDC04239.reportMiniGameVirtual(appConfig, "page_view", str, "minagame_xiala_page", null);
        }
    }

    public final void reportRecentMiniAppToDc87(final int pos, MiniAppInfo miniAppInfo, boolean isClick) {
        boolean startsWith$default;
        final String str;
        final String str2;
        boolean startsWith$default2;
        if (miniAppInfo == null) {
            return;
        }
        final String appId = miniAppInfo.appId;
        if (TextUtils.isEmpty(appId)) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(appId, "v", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(appId, "c", false, 2, null);
            if (!startsWith$default2) {
                return;
            }
        }
        if (isClick) {
            str = "209764";
        } else {
            str = "209763";
        }
        if (isClick) {
            str2 = "20";
        } else {
            str2 = "8";
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.f
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDesktopRvPartExpoHelper.reportRecentMiniAppToDc87$lambda$0(appId, str, str2, pos);
            }
        }, 64, null, false);
    }
}
