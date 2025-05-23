package com.tencent.mobileqq.statustitle.api;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.statustitle.d;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&J&\u0010\u0011\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0012\u001a\u00020\nH&J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/statustitle/api/IBaseStatusTitleBarApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/statustitle/d;", "iBaseStatusTitleBarCb", "Lcom/tencent/biz/richframework/part/Part;", "createBaseStatusTitlePart", "", "msgWhat", "", "extra", "", "notifyNetWorkState", "", "statusInfo", "Landroid/graphics/drawable/Drawable;", "statusIcon", "drawableRight", "notifyStatusInfo", "solveStatusBeforePanelShow", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "getIconColorFilterByTheme", "Lmqq/app/AppRuntime;", "app", "getIconAlphaByTheme", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IBaseStatusTitleBarApi extends QRouteApi {
    @NotNull
    Part createBaseStatusTitlePart(@NotNull d iBaseStatusTitleBarCb);

    int getIconAlphaByTheme(@NotNull AppRuntime app);

    int getIconColorFilterByTheme(@NotNull Resources resources);

    void notifyNetWorkState(int msgWhat, @Nullable Object extra);

    void notifyStatusInfo(@Nullable String statusInfo, @Nullable Drawable statusIcon, @Nullable Drawable drawableRight);

    void solveStatusBeforePanelShow();
}
