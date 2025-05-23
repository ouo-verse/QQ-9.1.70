package cooperation.qwallet.plugin;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qwallet.plugin.ipc.CorpReq;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes28.dex */
public interface ICorpReq extends QRouteApi {
    Bundle callForwardPage(Bundle bundle, ResultReceiver resultReceiver);

    Bundle callSendHbPage(Bundle bundle, ResultReceiver resultReceiver);

    void deleteUserNickOB();

    Bundle getAvatar(Bundle bundle, CorpReq.ICallBack iCallBack);

    Bundle getGroupNickname(Bundle bundle);

    Bundle onGetEncryption();

    Bundle onGetFaceFilePath(int i3, String str, int i16);

    Bundle onIsFriend(String str);

    void onTenWatch(Bundle bundle);

    void openAio(Bundle bundle);
}
