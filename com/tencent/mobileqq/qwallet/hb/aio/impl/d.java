package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    public static String a(AppRuntime appRuntime, @Nullable String str, @Nullable String str2) {
        if (appRuntime == null) {
            return HardCodeUtil.qqStr(R.string.f143020ky);
        }
        if (TextUtils.equals(appRuntime.getCurrentAccountUin(), str2)) {
            str2 = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        }
        return ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getGuildUserDisplayName(str, str2);
    }

    public static JSONObject b(String str, String str2, String str3, int i3, String str4, String str5, String str6, int i16, int i17, int i18, String str7, int i19, String str8, int i26, Bundle bundle, String str9) {
        Set<String> keySet;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("listid", str);
            jSONObject.put("senderuin", str2);
            jSONObject.put("name", str3);
            jSONObject.put("grouptype", i3 + "");
            jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str5);
            jSONObject.put(WadlProxyConsts.CHANNEL, i16);
            jSONObject.put("resource_type", i17);
            jSONObject.put("skin_id", i18);
            jSONObject.put("outer_skin_id", str7);
            jSONObject.put("skin_from", i19);
            jSONObject.put("fromHBList", i26);
            if (str6 != null) {
                jSONObject.put("groupuin", str6);
            }
            if (str4 != null) {
                jSONObject.put("authkey", str4);
            }
            if (!TextUtils.isEmpty(str8)) {
                jSONObject.put("voice_rate_id", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObject.put("curFriendUin", str9);
            }
            if (bundle != null && (keySet = bundle.keySet()) != null) {
                for (String str10 : keySet) {
                    jSONObject.put(str10, bundle.get(str10));
                }
            }
        } catch (Exception e16) {
            QLog.e("QWalletRedPkgUtils", 1, "error msg in qqpay-impl module: ", e16);
        }
        return jSONObject;
    }

    public static JSONObject c(AppRuntime appRuntime, @NonNull QWalletMsgModel qWalletMsgModel, QWalletSessionInfo qWalletSessionInfo, int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        vk2.b elem = qWalletMsgModel.getHbModel().getElem();
        int i16 = elem.f441783u;
        int i17 = elem.f441784v;
        String str7 = elem.f441785w;
        int i18 = elem.f441786x;
        int i19 = elem.C;
        String senderUin = qWalletMsgModel.getSenderUin();
        JSONObject b16 = b(str2, senderUin, str, i3, str3, str4, qWalletMsgModel.getSenderUin(), qWalletMsgModel.getHbModel().getRedChannel(), i16, i17, str7, i18, "", qWalletMsgModel.getFromHbList(), null, qWalletSessionInfo.getCurFriendUin());
        try {
            QQWalletAioBodyReserve body = qWalletMsgModel.getHbModel().getBody();
            b16.put("hb_from", i19);
            b16.put("pay_flag", body.payFlag);
            b16.put("hb_flag", body.hbFlag);
            if (qWalletMsgModel.getHbModel().getBody().hbFlag == 1) {
                b16.put("coverId", body.coverId);
                b16.put("avatarId", body.avatarId);
                b16.put("zplanSenderUin", body.zplanSenderUin);
                String str8 = body.makeHbExtend;
                if (!TextUtils.isEmpty(str8)) {
                    b16.put("zplan_res_type", new JSONObject(str8).optInt("zplan_res_type"));
                }
            }
            if (qWalletSessionInfo.getCurType() == 1008) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WadlProxyConsts.CHANNEL, 2);
                b16.put("detailinfo", jSONObject);
            } else if (qWalletSessionInfo.getCurType() == 10014) {
                String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
                b16.put("tinyId", selfTinyId);
                b16.put("guildId", qWalletSessionInfo.getTroopUin());
                b16.put("subGuildId", qWalletSessionInfo.getCurFriendUin());
                String a16 = a(appRuntime, str4, selfTinyId);
                if (!TextUtils.isEmpty(a16)) {
                    b16.put("name", a16);
                }
            }
        } catch (Exception e16) {
            QLog.e("QWalletRedPkgUtils", 1, "error msg in qqpay-impl module: ", e16);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("userId", appRuntime.getCurrentAccountUin());
            jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, str6);
            jSONObject2.put(j.T0, str5);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
            jSONObject2.put("extra_data", b16);
            jSONObject2.put("senderuin", senderUin);
        } catch (Exception e17) {
            QLog.e("QWalletRedPkgUtils", 1, "error msg in qqpay-impl module: ", e17);
        }
        return jSONObject2;
    }

    public static Bundle d(int i3) {
        int i16;
        String h16 = com.tencent.mobileqq.qwallet.impl.d.h();
        String nickNameSync = ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickNameSync(null, h16);
        if (i3 != 0) {
            i16 = 1;
            if (i3 != 1) {
                if (i3 != 1000) {
                    if (i3 != 1001) {
                        if (i3 != 1004) {
                            if (i3 != 1008) {
                                if (i3 != 3000) {
                                    if (i3 != 10002 && i3 != 10004) {
                                        i16 = i3 != 10014 ? (i3 == 1024 || i3 == 1025) ? 58 : -1 : 11;
                                    }
                                } else {
                                    i16 = 2;
                                }
                            }
                        } else {
                            i16 = 4;
                        }
                    }
                    nickNameSync = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getDateNickName(h16);
                    i16 = 6;
                    if (TextUtils.isEmpty(nickNameSync)) {
                        nickNameSync = ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickNameSync(null, h16);
                    }
                } else {
                    i16 = 3;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt(NotifyMsgApiImpl.KEY_GROUP_TYPE, i16);
            bundle.putString("name", nickNameSync);
            return bundle;
        }
        i16 = 0;
        Bundle bundle2 = new Bundle();
        bundle2.putInt(NotifyMsgApiImpl.KEY_GROUP_TYPE, i16);
        bundle2.putString("name", nickNameSync);
        return bundle2;
    }

    public static boolean e(String str) {
        return TextUtils.equals(str, "1");
    }

    public static boolean f(String str) {
        return TextUtils.equals(str, "2");
    }

    public static boolean g(String str) {
        return TextUtils.equals(str, "11");
    }

    public static boolean h(String str) {
        return TextUtils.equals(str, "3");
    }
}
