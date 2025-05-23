package cooperation.ilive.util;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface ILiveEntranceUtilApi extends QRouteApi {
    boolean checkIsAnchorRoomNow();

    void enterRoom(n05.a aVar);

    String getCurrentRoomId();

    String getQQLiveSecretKey();

    boolean isAnchorShowEntrance();

    boolean isClickEnable(int i3);

    @Deprecated
    boolean isServiceExisted(Context context, String str);

    boolean isShowIlveShopEntrance();

    void jumpToQQLivePrepareFragment(Context context, boolean z16, Intent intent);

    void liveWatchEntranceJump(n05.a aVar);

    void openWebView(Context context, String str, int i3, @NonNull String str2);
}
