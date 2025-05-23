package com.tencent.qqnt.aio.forward.api;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import av3.a;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J<\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0002H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/forward/api/IForwardAIOApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/view/View;", ParseCommon.CONTAINER, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "chatType", "", "peerId", "nick", "Landroid/os/Bundle;", "extras", "", "startAIO", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lav3/a;", "listener", "", "setOnBackListener", "removeOnBackListener", "view", "dispatchOnBack", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IForwardAIOApi extends QRouteApi {
    boolean dispatchOnBack(@NotNull View view);

    void removeOnBackListener(@NotNull View rootView);

    void setOnBackListener(@NotNull View rootView, @NotNull a listener);

    boolean startAIO(@NotNull View container, @NotNull FragmentManager fragmentManager, int chatType, @NotNull String peerId, @NotNull String nick, @Nullable Bundle extras);
}
