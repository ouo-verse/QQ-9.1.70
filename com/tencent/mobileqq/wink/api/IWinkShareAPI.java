package com.tencent.mobileqq.wink.api;

import android.app.Activity;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import i83.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J*\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IWinkShareAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/wink/api/IDateTransFrom;", WadlProxyConsts.KEY_MATERIAL, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "scene", "Landroid/view/View;", "clickView", "", "showMaterialSharePanel", "", "type", "", "uin", "mateData", "Li83/g;", "listener", "requestArk", "previewPic", "Lcom/tencent/mobileqq/wink/api/c;", "data", "showAIEliminationSharePanel", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkShareAPI extends QRouteApi {
    void requestArk(int type, long uin, @NotNull String mateData, @Nullable g listener);

    void showAIEliminationSharePanel(@NotNull Activity activity, @NotNull String previewPic, @NotNull c data);

    void showMaterialSharePanel(@NotNull IDateTransFrom material, @NotNull Activity activity, @NotNull String scene, @NotNull View clickView);
}
