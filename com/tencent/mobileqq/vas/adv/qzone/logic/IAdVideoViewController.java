package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0004H&J\b\u0010\u0012\u001a\u00020\u0004H&J\b\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010\u0018\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/qzone/logic/IAdVideoViewController;", "", "Landroid/view/ViewGroup;", "parentView", "", "initStubView", "Landroid/view/View;", "getView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "setOutActivity", "Lcom/tencent/mobileqq/vas/adv/common/data/AlumBasicData;", "alumBasicData", "", WadlProxyConsts.SCENE_ID, "setVideoDataChanged", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isAdClosed", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/vas/adv/qzone/logic/a;", "adReportEventListenerRef", "setAdReportEventListener", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface IAdVideoViewController {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void setVideoDataChanged$default(IAdVideoViewController iAdVideoViewController, AlumBasicData alumBasicData, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = -1;
                }
                iAdVideoViewController.setVideoDataChanged(alumBasicData, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setVideoDataChanged");
        }
    }

    @NotNull
    View getView();

    void initStubView(@NotNull ViewGroup parentView);

    boolean isAdClosed();

    void onDestroy();

    void onPause();

    void onResume();

    void setAdReportEventListener(@Nullable WeakReference<a> adReportEventListenerRef);

    void setOutActivity(@NotNull Activity activity);

    void setVideoDataChanged(@Nullable AlumBasicData alumBasicData, int sceneId);
}
