package com.tencent.mobileqq.wink.api;

import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.sharepanel.j;
import com.tencent.mobileqq.wink.share.WinkShareCommonModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JB\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J8\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IWinkNewSharePanelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", WadlProxyConsts.SCENE_ID, "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/api/d;", "shareConfig", "Lcom/tencent/mobileqq/wink/share/WinkShareCommonModel;", "shareModel", "Lcom/tencent/mobileqq/sharepanel/j;", "onPanelClickListener", "", "hideRecentContent", "", "showSharePanel", "Lcom/tencent/mobileqq/sharepanel/f;", "createPanel", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkNewSharePanelApi extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(IWinkNewSharePanelApi iWinkNewSharePanelApi, String str, FragmentActivity fragmentActivity, d dVar, WinkShareCommonModel winkShareCommonModel, j jVar, boolean z16, int i3, Object obj) {
            WinkShareCommonModel winkShareCommonModel2;
            j jVar2;
            boolean z17;
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    winkShareCommonModel2 = null;
                } else {
                    winkShareCommonModel2 = winkShareCommonModel;
                }
                if ((i3 & 16) != 0) {
                    jVar2 = null;
                } else {
                    jVar2 = jVar;
                }
                if ((i3 & 32) != 0) {
                    z17 = false;
                } else {
                    z17 = z16;
                }
                iWinkNewSharePanelApi.showSharePanel(str, fragmentActivity, dVar, winkShareCommonModel2, jVar2, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSharePanel");
        }
    }

    @NotNull
    com.tencent.mobileqq.sharepanel.f createPanel(@NotNull String sceneId, @NotNull FragmentActivity activity, @NotNull d shareConfig, @Nullable WinkShareCommonModel shareModel, @Nullable j onPanelClickListener);

    void showSharePanel(@NotNull String sceneId, @NotNull FragmentActivity activity, @NotNull d shareConfig, @Nullable WinkShareCommonModel shareModel, @Nullable j onPanelClickListener, boolean hideRecentContent);
}
