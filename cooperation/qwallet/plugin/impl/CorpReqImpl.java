package cooperation.qwallet.plugin.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.temp.ITenpayFriendListObserver;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qwallet.plugin.ICorpReq;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.ipc.CorpReq;
import cooperation.qwallet.plugin.ipc.CorpResp;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CorpReqImpl implements ICorpReq {
    private static final String TAG = "CorpReqImpl";

    @Override // cooperation.qwallet.plugin.ICorpReq
    public Bundle callForwardPage(Bundle bundle, ResultReceiver resultReceiver) {
        if (bundle == null) {
            return null;
        }
        CorpResp corpResp = new CorpResp();
        corpResp.corpReqType = CorpReq.corpReqType;
        corpResp.encryptionData = CorpReq.encryptionData;
        if (resultReceiver == null) {
            corpResp.callForwardRet = -1;
        } else {
            int i3 = bundle.getInt("forward_type", 0);
            String string = bundle.getString("forward_title");
            Context context = QBaseActivity.sTopActivity;
            if (context == null) {
                context = MobileQQ.sMobileQQ;
            }
            if (context != null) {
                try {
                    Intent intent = new Intent();
                    intent.putExtra(AppConstants.Key.FORWARD_TEXT, string);
                    intent.putExtra("forward_type", i3);
                    intent.putExtra("choose_friend_callback", resultReceiver);
                    intent.addFlags(268435456);
                    RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT);
                    corpResp.callForwardRet = 0;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                }
            }
        }
        Bundle bundle2 = new Bundle();
        corpResp.toBundle(bundle2);
        return bundle2;
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    public Bundle callSendHbPage(Bundle bundle, ResultReceiver resultReceiver) {
        if (bundle == null) {
            return null;
        }
        CorpResp corpResp = new CorpResp();
        corpResp.corpReqType = CorpReq.corpReqType;
        corpResp.encryptionData = CorpReq.encryptionData;
        if (resultReceiver == null) {
            corpResp.callForwardRet = -1;
        } else {
            Context context = QBaseActivity.sTopActivity;
            if (context == null) {
                context = MobileQQ.sMobileQQ;
            }
            if (context != null) {
                try {
                    String string = bundle.getString(WadlProxyConsts.CHANNEL);
                    String string2 = bundle.getString("recv_uin");
                    Intent intent = new Intent();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(WadlProxyConsts.CHANNEL, string);
                        jSONObject.put("recv_uin", string2);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                    }
                    intent.putExtra("extra_data", jSONObject.toString());
                    intent.putExtra("come_from", 2);
                    intent.putExtra(j.T0, "appid#1344242394|bargainor_id#1000030201|channel#multi");
                    intent.addFlags(536870912);
                    RouteUtils.startActivity(context, intent, "/qwallet/redpacket/sendhb");
                    corpResp.callForwardRet = 0;
                } catch (Exception e17) {
                    QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e17);
                }
            }
        }
        Bundle bundle2 = new Bundle();
        corpResp.toBundle(bundle2);
        return bundle2;
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    public void deleteUserNickOB() {
        BaseQQAppInterface appInterface = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getAppInterface();
        ITenpayFriendListObserver iTenpayFriendListObserver = (ITenpayFriendListObserver) QRoute.api(ITenpayFriendListObserver.class);
        if (appInterface != null) {
            appInterface.removeObserver((BusinessObserver) iTenpayFriendListObserver);
            iTenpayFriendListObserver.destroy();
        }
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    public Bundle getAvatar(Bundle bundle, final CorpReq.ICallBack iCallBack) {
        final CorpResp corpResp = new CorpResp();
        corpResp.corpReqType = CorpReq.corpReqType;
        if (bundle != null) {
            BaseQQAppInterface appInterface = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getAppInterface();
            String string = bundle.getString("req_uin");
            int i3 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
            if (!TextUtils.isEmpty(string)) {
                Context context = QBaseActivity.sTopActivity;
                if (context == null) {
                    context = MobileQQ.sMobileQQ;
                }
                if (context != null && !TextUtils.isEmpty(string) && appInterface != null) {
                    IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
                    iQQAvatarService.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener() { // from class: cooperation.qwallet.plugin.impl.CorpReqImpl.1
                        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
                        public void onDecodeTaskCompleted(int i16, int i17, String str, Bitmap bitmap) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putParcelable("avatar_bitmap", bitmap);
                            corpResp.toBundle(bundle2);
                            CorpReq.ICallBack iCallBack2 = iCallBack;
                            if (iCallBack2 != null) {
                                iCallBack2.callBack(bundle2);
                            }
                        }
                    });
                    iQQAvatarService.requestDecodeFace(string, i3, false);
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    public Bundle getGroupNickname(Bundle bundle) {
        CorpResp corpResp = new CorpResp();
        corpResp.corpReqType = CorpReq.corpReqType;
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            String string = bundle.getString("req_uin");
            int i3 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
            if (TextUtils.isEmpty(string)) {
                corpResp.userNick = "";
                corpResp.toBundle(bundle2);
                return bundle2;
            }
            corpResp.memNick = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getGroupNicknameByType(((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getAppInterface(), i3, string);
        }
        corpResp.toBundle(bundle2);
        return bundle2;
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    public Bundle onGetEncryption() {
        CorpResp corpResp = new CorpResp();
        corpResp.corpReqType = CorpReq.corpReqType;
        corpResp.encryptionData = CorpReq.encryptionData;
        Bundle bundle = new Bundle();
        corpResp.toBundle(bundle);
        return bundle;
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    public Bundle onGetFaceFilePath(int i3, String str, int i16) {
        CorpResp corpResp = new CorpResp();
        corpResp.corpReqType = CorpReq.corpReqType;
        AppRuntime appRuntime = QWalletHelperImpl.getAppRuntime();
        if (appRuntime instanceof BaseQQAppInterface) {
            corpResp.faceFilePath = ((IQQAvatarDataService) appRuntime.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(null, i3, str, i16, 0);
            corpResp.memUin = str;
        }
        Bundle bundle = new Bundle();
        corpResp.toBundle(bundle);
        return bundle;
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    public Bundle onIsFriend(String str) {
        CorpResp corpResp = new CorpResp();
        corpResp.corpReqType = CorpReq.corpReqType;
        AppRuntime appRuntime = QWalletHelperImpl.getAppRuntime();
        if (appRuntime != null) {
            if (appRuntime.getCurrentAccountUin().equals(str)) {
                corpResp.isFriend = false;
            } else {
                corpResp.isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), TAG);
            }
        }
        Bundle bundle = new Bundle();
        corpResp.toBundle(bundle);
        return bundle;
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    public void openAio(Bundle bundle) {
        String str;
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("send_uin");
        int i3 = bundle.getInt("send_type", 0);
        if (i3 == 1) {
            str = "discuss";
        } else if (i3 == 2) {
            str = VipFunCallConstants.KEY_GROUP;
        } else {
            str = "c2c";
        }
        Context context = QBaseActivity.sTopActivity;
        if (context == null) {
            context = MobileQQ.sMobileQQ;
        }
        if (context != null && !TextUtils.isEmpty(string)) {
            try {
                Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
                intent.setData(Uri.parse("mqqapi://im/chat?src_type=web&uin=" + string + "&attach_content=&version=1&chat_type=" + str));
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
        }
    }

    @Override // cooperation.qwallet.plugin.ICorpReq
    @Deprecated
    public void onTenWatch(Bundle bundle) {
    }
}
