package com.tencent.qqmini.sdk.action;

import android.os.Bundle;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareChatModel;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ShareAction implements Action<Boolean> {
    public static final String KEY_MINI_APP_SHARE_CHAT_NAME = "key_mini_app_share_chat_name";
    public static final String KEY_MINI_APP_SHARE_CHAT_TYPE = "key_mini_app_share_chat_type";
    public static final String KEY_MINI_APP_SHARE_CHAT_UIN = "key_mini_app_share_chat_uin";
    public static final String KEY_SHARE_ITEM_ID = "key_share_item_id";
    public static final int SHARE_GAME_RAFFLE = 6;
    public static final int SHARE_GUILD = 8;
    public static final int SHARE_OTHER = 7;
    public static final int SHARE_QQ = 1;
    public static final int SHARE_QQ_CHAT = 5;
    public static final int SHARE_QZONE = 2;
    public static final int SHARE_WX_FRIEND = 3;
    public static final int SHARE_WX_MOMENT = 4;
    private Bundle data;
    private int what;

    private String getCurrPage(IMiniAppContext iMiniAppContext) {
        String webViewUrlForShare = PageAction.obtain(iMiniAppContext).getWebViewUrlForShare();
        if (webViewUrlForShare != null) {
            QMLog.e(Action.TAG, "getCurrPage with webViewUrl:" + webViewUrlForShare);
            return webViewUrlForShare;
        }
        String pageUrl = PageAction.obtain(iMiniAppContext).getPageUrl();
        QMLog.e(Action.TAG, "getCurrPage with PageUrl:" + pageUrl);
        return pageUrl;
    }

    private int getCurrPageId(IMiniAppContext iMiniAppContext) {
        return PageAction.obtain(iMiniAppContext).getPageId();
    }

    private void handleForward(BaseRuntime baseRuntime, ShareState shareState) {
        IJsService jsService;
        String str;
        JSONObject jSONObject = new JSONObject();
        String str2 = com.tencent.luggage.wxa.c3.a.NAME;
        try {
            if (shareState.launchFrom == 1) {
                str2 = "showActionSheet";
                HashMap<String, Integer> hashMap = shareState.tapIndexMap;
                if (hashMap != null) {
                    jSONObject.put("tapIndex", hashMap.get(ShareState.KEY_TAP_INDEX_QQ));
                }
            } else {
                jSONObject.put("fromShareButton", 0);
                jSONObject.put("shareTarget", 0);
            }
            if (!baseRuntime.isMiniGame() && getCurrPage(baseRuntime) != null) {
                jSONObject.put("webViewUrl", getCurrPage(baseRuntime));
            }
        } catch (JSONException e16) {
            QMLog.e(Action.TAG, "on forward aio click exception ", e16);
        }
        shareState.fromShareMenuBtn = 0;
        RequestEvent requestEvent = shareState.requestEvent;
        if (requestEvent != null) {
            jsService = requestEvent.jsService;
        } else {
            jsService = baseRuntime.getJsService();
        }
        if (jsService != null) {
            if (shareState.launchFrom == 1) {
                JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str2, jSONObject);
                if (wrapCallbackOk != null) {
                    str = wrapCallbackOk.toString();
                } else {
                    str = "";
                }
                jsService.evaluateCallbackJs(shareState.shareCallbackId, str);
                return;
            }
            jsService.evaluateSubscribeJS(str2, jSONObject.toString(), getCurrPageId(baseRuntime));
        }
    }

    private void handleForwardQZone(BaseRuntime baseRuntime, ShareState shareState) {
        IJsService jsService;
        String str;
        JSONObject jSONObject = new JSONObject();
        String str2 = com.tencent.luggage.wxa.c3.a.NAME;
        try {
            if (shareState.launchFrom == 1) {
                str2 = "showActionSheet";
                HashMap<String, Integer> hashMap = shareState.tapIndexMap;
                if (hashMap != null) {
                    jSONObject.put("tapIndex", hashMap.get(ShareState.KEY_TAP_INDEX_QZONE));
                }
            } else {
                jSONObject.put("fromShareButton", 0);
                jSONObject.put("shareTarget", 1);
            }
            if (!baseRuntime.isMiniGame() && getCurrPage(baseRuntime) != null) {
                jSONObject.put("webViewUrl", getCurrPage(baseRuntime));
            }
        } catch (JSONException e16) {
            QMLog.e(Action.TAG, "on forward qzone click exception ", e16);
        }
        shareState.fromShareMenuBtn = 1;
        RequestEvent requestEvent = shareState.requestEvent;
        if (requestEvent != null) {
            jsService = requestEvent.jsService;
        } else {
            jsService = baseRuntime.getJsService();
        }
        if (jsService != null) {
            if (shareState.launchFrom == 1) {
                JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str2, jSONObject);
                if (wrapCallbackOk != null) {
                    str = wrapCallbackOk.toString();
                } else {
                    str = "";
                }
                jsService.evaluateCallbackJs(shareState.shareCallbackId, str);
                return;
            }
            jsService.evaluateSubscribeJS(str2, jSONObject.toString(), getCurrPageId(baseRuntime));
            return;
        }
        QMLog.e(Action.TAG, "on forward qzone click exception mGameJsPluginEngine==null");
    }

    private void handleForwardWeChatFriends(BaseRuntime baseRuntime, ShareState shareState) {
        String str;
        IJsService jsService;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            if (shareState.launchFrom == 1) {
                str = "showActionSheet";
                HashMap<String, Integer> hashMap = shareState.tapIndexMap;
                if (hashMap != null) {
                    jSONObject.put("tapIndex", hashMap.get(ShareState.KEY_TAP_INDEX_WX));
                }
            } else {
                jSONObject.put("fromShareButton", 0);
                jSONObject.put("shareTarget", 3);
                str = com.tencent.luggage.wxa.c3.a.NAME;
            }
            if (!baseRuntime.isMiniGame() && getCurrPage(baseRuntime) != null) {
                jSONObject.put("webViewUrl", getCurrPage(baseRuntime));
            }
            shareState.fromShareMenuBtn = 3;
            RequestEvent requestEvent = shareState.requestEvent;
            if (requestEvent != null) {
                jsService = requestEvent.jsService;
            } else {
                jsService = baseRuntime.getJsService();
            }
            if (jsService != null) {
                if (shareState.launchFrom == 1) {
                    JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str, jSONObject);
                    if (wrapCallbackOk != null) {
                        str2 = wrapCallbackOk.toString();
                    } else {
                        str2 = "";
                    }
                    jsService.evaluateCallbackJs(shareState.shareCallbackId, str2);
                    return;
                }
                jsService.evaluateSubscribeJS(str, jSONObject.toString(), getCurrPageId(baseRuntime));
                return;
            }
            QMLog.e(Action.TAG, "on forward wx friends click exception js service==null");
        } catch (JSONException e16) {
            QMLog.e(Action.TAG, "on forward wechat friends click exception ", e16);
        }
    }

    private void handleForwardWeChatMoment(BaseRuntime baseRuntime, ShareState shareState) {
        IJsService jsService;
        String str;
        JSONObject jSONObject = new JSONObject();
        String str2 = com.tencent.luggage.wxa.c3.a.NAME;
        try {
            if (shareState.launchFrom == 1) {
                str2 = "showActionSheet";
                HashMap<String, Integer> hashMap = shareState.tapIndexMap;
                if (hashMap != null) {
                    jSONObject.put("tapIndex", hashMap.get(ShareState.KEY_TAP_INDEX_WX_MOMENTS));
                }
            } else {
                jSONObject.put("fromShareButton", 0);
                jSONObject.put("shareTarget", 4);
            }
            if (!baseRuntime.isMiniGame() && getCurrPage(baseRuntime) != null) {
                jSONObject.put("webViewUrl", getCurrPage(baseRuntime));
            }
        } catch (JSONException e16) {
            QMLog.e(Action.TAG, "on forward wechat moment exception ", e16);
        }
        shareState.fromShareMenuBtn = 4;
        RequestEvent requestEvent = shareState.requestEvent;
        if (requestEvent != null) {
            jsService = requestEvent.jsService;
        } else {
            jsService = baseRuntime.getJsService();
        }
        if (jsService != null) {
            if (shareState.launchFrom == 1) {
                JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str2, jSONObject);
                if (wrapCallbackOk != null) {
                    str = wrapCallbackOk.toString();
                } else {
                    str = "";
                }
                jsService.evaluateCallbackJs(shareState.shareCallbackId, str);
                return;
            }
            jsService.evaluateSubscribeJS(str2, jSONObject.toString(), getCurrPageId(baseRuntime));
            return;
        }
        QMLog.e(Action.TAG, "on forward wechat moments click exception js service==null");
    }

    private void handleRaffleShare(BaseRuntime baseRuntime, ShareState shareState) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fromShareButton", 0);
            jSONObject.put("shareTarget", 0);
            jSONObject.put("shareActionName", RaffleJsPlugin.RAFFLE_SHARE_ACTION);
        } catch (JSONException e16) {
            QMLog.e(Action.TAG, "handleRaffleShare", e16);
        }
        QMLog.d(Action.TAG, "handleRaffleShare param: " + jSONObject.toString());
        shareState.fromShareMenuBtn = 0;
        IJsService jsService = baseRuntime.getJsService();
        if (jsService != null) {
            jsService.evaluateSubscribeJS(com.tencent.luggage.wxa.c3.a.NAME, jSONObject.toString(), 0);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:5|(12:42|43|8|9|10|(2:12|(1:14))(1:39)|15|(1:19)|20|21|(1:23)(1:37)|(2:25|(4:27|(1:29)(1:32)|30|31)(2:33|34))(2:35|36))|7|8|9|10|(0)(0)|15|(2:17|19)|20|21|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0085, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
    
        com.tencent.qqmini.sdk.launcher.log.QMLog.e(com.tencent.qqmini.sdk.launcher.core.action.Action.TAG, "on forward directly click exception ", r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0048 A[Catch: JSONException -> 0x0085, TryCatch #0 {JSONException -> 0x0085, blocks: (B:10:0x0044, B:12:0x0048, B:14:0x004f, B:15:0x0064, B:17:0x006a, B:19:0x0070, B:20:0x007a, B:39:0x0057), top: B:9:0x0044 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0057 A[Catch: JSONException -> 0x0085, TryCatch #0 {JSONException -> 0x0085, blocks: (B:10:0x0044, B:12:0x0048, B:14:0x004f, B:15:0x0064, B:17:0x006a, B:19:0x0070, B:20:0x007a, B:39:0x0057), top: B:9:0x0044 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleShareChatDirectly(BaseRuntime baseRuntime, ShareState shareState) {
        long longValue;
        JSONObject jSONObject;
        RequestEvent requestEvent;
        IJsService jsService;
        String str;
        Bundle bundle = this.data;
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("key_mini_app_share_chat_uin");
        int i3 = this.data.getInt("key_mini_app_share_chat_type");
        String string2 = this.data.getString("key_mini_app_share_chat_name");
        if (string != null) {
            try {
                longValue = Long.valueOf(string).longValue();
            } catch (Throwable th5) {
                QMLog.e(Action.TAG, "handleShareChatDirectly get an exception ", th5);
            }
            ShareChatModel shareChatModel = new ShareChatModel(i3, longValue, string2);
            jSONObject = new JSONObject();
            String str2 = com.tencent.luggage.wxa.c3.a.NAME;
            if (shareState.launchFrom != 1) {
                str2 = "showActionSheet";
                if (shareState.tapIndexMap != null) {
                    jSONObject.put("tapIndex", -1);
                }
            } else {
                jSONObject.put("fromShareButton", 0);
                jSONObject.put("shareTarget", 5);
            }
            if (!baseRuntime.isMiniGame() && getCurrPage(baseRuntime) != null) {
                jSONObject.put("webViewUrl", getCurrPage(baseRuntime));
            }
            jSONObject.put("chatDataHash", shareChatModel.getEntryHash());
            shareState.fromShareMenuBtn = 0;
            shareState.shareChatModel = shareChatModel;
            requestEvent = shareState.requestEvent;
            if (requestEvent == null) {
                jsService = requestEvent.jsService;
            } else {
                jsService = baseRuntime.getJsService();
            }
            if (jsService == null) {
                if (shareState.launchFrom == 1) {
                    JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str2, jSONObject);
                    if (wrapCallbackOk != null) {
                        str = wrapCallbackOk.toString();
                    } else {
                        str = "";
                    }
                    jsService.evaluateCallbackJs(shareState.shareCallbackId, str);
                    return;
                }
                jsService.evaluateSubscribeJS(str2, jSONObject.toString(), getCurrPageId(baseRuntime));
                return;
            }
            QMLog.e(Action.TAG, "on forward directly click exception js service==null");
            return;
        }
        longValue = -1;
        ShareChatModel shareChatModel2 = new ShareChatModel(i3, longValue, string2);
        jSONObject = new JSONObject();
        String str22 = com.tencent.luggage.wxa.c3.a.NAME;
        if (shareState.launchFrom != 1) {
        }
        if (!baseRuntime.isMiniGame()) {
            jSONObject.put("webViewUrl", getCurrPage(baseRuntime));
        }
        jSONObject.put("chatDataHash", shareChatModel2.getEntryHash());
        shareState.fromShareMenuBtn = 0;
        shareState.shareChatModel = shareChatModel2;
        requestEvent = shareState.requestEvent;
        if (requestEvent == null) {
        }
        if (jsService == null) {
        }
    }

    private void handleShareOther(BaseRuntime baseRuntime, ShareState shareState, int i3) {
        IJsService jsService;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fromShareButton", 0);
            jSONObject.put("shareTarget", i3);
            if (!baseRuntime.isMiniGame() && getCurrPage(baseRuntime) != null) {
                jSONObject.put("webViewUrl", getCurrPage(baseRuntime));
            }
        } catch (JSONException e16) {
            QMLog.e(Action.TAG, "on forward wechat moment exception ", e16);
        }
        shareState.fromShareMenuBtn = i3;
        RequestEvent requestEvent = shareState.requestEvent;
        if (requestEvent != null) {
            jsService = requestEvent.jsService;
        } else {
            jsService = baseRuntime.getJsService();
        }
        if (jsService != null) {
            jsService.evaluateSubscribeJS(com.tencent.luggage.wxa.c3.a.NAME, jSONObject.toString(), getCurrPageId(baseRuntime));
        } else {
            QMLog.e(Action.TAG, "on forward wechat moments click exception js service==null");
        }
    }

    public static ShareAction obtain(int i3) {
        return obtain(i3, null);
    }

    public Bundle getBundle() {
        return this.data;
    }

    public int getWhat() {
        return this.what;
    }

    public static ShareAction obtain(int i3, Bundle bundle) {
        ShareAction shareAction = new ShareAction();
        shareAction.what = i3;
        shareAction.data = bundle;
        return shareAction;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        ShareState shareState = baseRuntime.getShareState();
        if (shareState == null) {
            QMLog.e(Action.TAG, "Failed to perform " + this + ". shareState is null");
            return Boolean.FALSE;
        }
        if (baseRuntime.getPage() == null) {
            QMLog.e(Action.TAG, "Failed to perform " + this + ". page is null");
            return Boolean.FALSE;
        }
        switch (this.what) {
            case 1:
                handleForward(baseRuntime, shareState);
                break;
            case 2:
                handleForwardQZone(baseRuntime, shareState);
                break;
            case 3:
                handleForwardWeChatFriends(baseRuntime, shareState);
                break;
            case 4:
                handleForwardWeChatMoment(baseRuntime, shareState);
                break;
            case 5:
                handleShareChatDirectly(baseRuntime, shareState);
                break;
            case 6:
                handleRaffleShare(baseRuntime, shareState);
                break;
            case 7:
                Bundle bundle = this.data;
                if (bundle == null) {
                    QMLog.e(Action.TAG, "Failed to share to other, data is null");
                    return Boolean.FALSE;
                }
                handleShareOther(baseRuntime, shareState, bundle.getInt(KEY_SHARE_ITEM_ID, 0));
                break;
            case 8:
                handleShareOther(baseRuntime, shareState, 8);
                break;
        }
        return Boolean.TRUE;
    }
}
