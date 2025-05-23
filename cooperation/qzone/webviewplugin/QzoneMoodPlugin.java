package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.qzone.reborn.event.QZoneFeedxRefreshEvent;
import com.qzone.util.r;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneMediaResultDealWithApi;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.qzonehub.api.impl.QZoneHelperProxyImpl;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.model.PublishEventTag;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes38.dex */
public class QzoneMoodPlugin extends QzoneInternalWebViewPlugin {
    private static final String PARAMS_KEY_RET_CODE = "retCode";
    private static final String PARAM_KEY_CALLBACK = "callback";
    private static final String PARAM_KEY_POP_WEB_PAGE = "popWebPageWhenPush";
    private static final int RET_CODE_JUMP_FAIL = -1;
    private static final int RET_CODE_JUMP_SUCCESS = 0;
    private static final int RET_CODE_PUBLISH_CANCEL = 1;
    private static final int RET_CODE_PUBLISH_SUCCESS = 2;
    private static final String TAG = "QzoneMoodPlugin";
    private boolean mUseWechatSyncManager = false;
    private String mWriteMoodJsonStr;
    private static final String regEmo = "\\[em\\]e\\d{1,}\\[/em\\]";
    private static final Pattern patternEmo = Pattern.compile(regEmo, 2);
    private static CopyOnWriteArrayList<FriendNickNames> listFriNickName = new CopyOnWriteArrayList<>();

    /* loaded from: classes38.dex */
    public class FriendNickNames {
        public String mainUin;
        public HashMap<String, String> nickNamesMap = new HashMap<>();

        public FriendNickNames() {
        }
    }

    private void deleteTimerShuoShuo() {
        RemoteHandleManager.getInstance().getSender().deleteTimerShuoShuo();
    }

    private void handleEditMoodSuccess() {
        Activity a16 = this.parentPlugin.mRuntime.a();
        if (a16 != null) {
            Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE);
            Bundle bundle = new Bundle();
            bundle.putString("cmd", QZoneJsConstants.METHOD_REFRESH_FEED);
            intent.putExtras(bundle);
            QZoneHelper.forwardToQzoneTransluentActivity(this.parentPlugin.mRuntime.a(), QZoneHelper.UserInfo.getInstance(), intent);
            a16.setResult(-1);
            this.parentPlugin.mRuntime.a().finish();
        }
    }

    private void handleRefreshFriendFeed() {
        SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxRefreshEvent(), true);
    }

    private void handleWriteMoodResultCallback(String str, int i3) {
        QLog.i(TAG, 1, "handleWriteMoodResultCallback  | jsonString = " + str + " | retCode = " + i3);
        if (TextUtils.isEmpty(str) || this.parentPlugin == null) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("callback");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", i3);
            String jSONObject2 = jSONObject.toString();
            this.parentPlugin.callJs(optString, jSONObject2);
            QLog.d(TAG, 1, "handleWriteMoodResultCallback  callbackStr = " + jSONObject2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FriendNickNames loadFriendListFromQQ() {
        Cursor cursor;
        String[] strArr = {"uin", "remark", "name"};
        FriendNickNames friendNickNames = new FriendNickNames();
        friendNickNames.mainUin = this.parentPlugin.mRuntime.b().getCurrentAccountUin();
        try {
            cursor = ContactsMonitor.query(BaseApplication.getContext().getContentResolver(), Uri.parse("content://qq.friendlist/friendlist/" + friendNickNames.mainUin), strArr, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("uin");
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("remark");
                        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("name");
                        do {
                            String string = cursor.getString(columnIndexOrThrow);
                            if (!TextUtils.isEmpty(string)) {
                                String decode = SecurityUtile.decode(new String(string.getBytes(), "utf-8"), false);
                                String string2 = cursor.getString(columnIndexOrThrow2);
                                if (!TextUtils.isEmpty(string2)) {
                                    friendNickNames.nickNamesMap.put(decode, SecurityUtile.decode(new String(string2.getBytes(), "utf-8"), false));
                                } else {
                                    String string3 = cursor.getString(columnIndexOrThrow3);
                                    if (!TextUtils.isEmpty(string3)) {
                                        String decode2 = SecurityUtile.decode(new String(string3.getBytes(), "utf-8"), false);
                                        if (decode2.length() > 1 && decode2.charAt(decode2.length() - 1) == '\n') {
                                            decode2 = decode2.substring(0, decode2.length() - 1);
                                        }
                                        friendNickNames.nickNamesMap.put(decode, decode2);
                                    }
                                }
                            }
                        } while (cursor.moveToNext());
                        listFriNickName.add(friendNickNames);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        QZLog.e(TAG, "getFriendListFromQQ occuer Exception,infor=" + QZLog.getStackTraceString(th));
                        th.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            return friendNickNames;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    private static String parseAtString(String str, ArrayList<ResultRecord> arrayList) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        try {
            Matcher matcher = Pattern.compile("@\\{uin:(\\d+),nick:(.+?)\\}").matcher(str);
            while (matcher.find()) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(TAG, 4, "match:" + matcher.group() + " uin=" + matcher.group(1) + " nick=" + matcher.group(2));
                }
                ResultRecord resultRecord = new ResultRecord();
                resultRecord.uin = matcher.group(1);
                resultRecord.name = matcher.group(2);
                arrayList.add(resultRecord);
            }
            return matcher.replaceAll("");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse at string error:", e16);
            return null;
        }
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        WebViewPlugin webViewPlugin = this.parentPlugin;
        if (webViewPlugin != null && webViewPlugin.mRuntime != null) {
            if ("signInSuccess".equals(str3)) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    if (jSONObject.optBoolean("shareToWX")) {
                        String optString = jSONObject.optString("image");
                        RemoteHandleManager.getInstance().getSender().syncWithSignIn(jSONObject.optString("text"), optString, jSONObject.optString(MessageForRichState.SIGN_MSG_FONT_ID), jSONObject.optString("fontUrl"));
                        this.mUseWechatSyncManager = true;
                    }
                    handleRefreshFriendFeed();
                    if (this.parentPlugin.mRuntime.a() != null) {
                        this.parentPlugin.mRuntime.a().finish();
                        return true;
                    }
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, th5.getMessage());
                    return false;
                }
            } else {
                if ("editMoodSuccess".equals(str3)) {
                    handleEditMoodSuccess();
                    return true;
                }
                if (QZoneJsConstants.METHOD_WRITE_MOOD.equals(str3)) {
                    return writeMood(strArr[0]);
                }
                if (QZoneJsConstants.METHOD_DELETE_UNPUBLISHED_SHUOSHUO.equals(str3)) {
                    deleteTimerShuoShuo();
                    return true;
                }
                if (QZoneJsConstants.METHOD_REFRESH_FRIEND_FEED.equals(str3)) {
                    handleRefreshFriendFeed();
                    return true;
                }
                if (!QZoneJsConstants.METHOD_PUBLISH_CALLBACK.equals(str3) || strArr.length == 0) {
                    return false;
                }
                String str4 = strArr[0];
                ((IWinkAPI) QRoute.api(IWinkAPI.class)).appendMedia2QZoneMood(true, strArr[0]);
                Activity a16 = this.parentPlugin.mRuntime.a();
                if (a16 != null) {
                    a16.finish();
                }
                handleWriteMoodResultCallback(str4, 0);
                return true;
            }
        }
        return false;
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (b16 != 6) {
            return;
        }
        boolean z16 = false;
        if (intent != null) {
            int intExtra = intent.getIntExtra("PUBLISH_RESULT_CODE", 0);
            if (i3 == -1 && intExtra == 1) {
                z16 = true;
            }
        }
        handleWriteMoodResultCallback(this.mWriteMoodJsonStr, z16 ? 2 : 1);
    }

    @Override // cooperation.qzone.webviewplugin.QzoneInternalWebViewPlugin
    public void onDestroy() {
        if (this.mUseWechatSyncManager) {
            RemoteHandleManager.getInstance().destroy();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:2|3|(16:(2:5|(30:7|8|(4:10|11|12|(1:14))(1:127)|15|16|(3:20|(2:23|21)|24)|25|(3:29|(2:32|30)|33)|34|36|37|38|39|40|42|43|44|45|(1:47)|48|(1:50)|51|(1:112)(4:59|60|(3:105|106|(1:110))|62)|63|64|65|66|(2:69|(2:71|(9:73|74|75|76|77|78|79|(3:83|84|(1:86))|81)(2:96|97)))|98|(0)(0)))|44|45|(0)|48|(0)|51|(1:53)|112|63|64|65|66|(2:69|(0))|98|(0)(0))|130|16|(4:18|20|(1:21)|24)|25|(4:27|29|(1:30)|33)|34|36|37|38|39|40|42|43) */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0281, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0285, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0286, code lost:
    
        r1 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0288, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0289, code lost:
    
        r1 = r31;
        r18 = cooperation.qzone.webviewplugin.QzoneMoodPlugin.TAG;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071 A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:3:0x0013, B:5:0x0025, B:16:0x0063, B:18:0x0071, B:21:0x0078, B:23:0x007e, B:25:0x008f, B:27:0x009d, B:30:0x00a4, B:32:0x00aa, B:34:0x00bb, B:125:0x0059), top: B:2:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e A[Catch: Exception -> 0x028f, LOOP:0: B:21:0x0078->B:23:0x007e, LOOP_END, TryCatch #0 {Exception -> 0x028f, blocks: (B:3:0x0013, B:5:0x0025, B:16:0x0063, B:18:0x0071, B:21:0x0078, B:23:0x007e, B:25:0x008f, B:27:0x009d, B:30:0x00a4, B:32:0x00aa, B:34:0x00bb, B:125:0x0059), top: B:2:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[Catch: Exception -> 0x028f, TryCatch #0 {Exception -> 0x028f, blocks: (B:3:0x0013, B:5:0x0025, B:16:0x0063, B:18:0x0071, B:21:0x0078, B:23:0x007e, B:25:0x008f, B:27:0x009d, B:30:0x00a4, B:32:0x00aa, B:34:0x00bb, B:125:0x0059), top: B:2:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa A[Catch: Exception -> 0x028f, LOOP:1: B:30:0x00a4->B:32:0x00aa, LOOP_END, TryCatch #0 {Exception -> 0x028f, blocks: (B:3:0x0013, B:5:0x0025, B:16:0x0063, B:18:0x0071, B:21:0x0078, B:23:0x007e, B:25:0x008f, B:27:0x009d, B:30:0x00a4, B:32:0x00aa, B:34:0x00bb, B:125:0x0059), top: B:2:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014a A[Catch: Exception -> 0x027d, TryCatch #1 {Exception -> 0x027d, blocks: (B:45:0x0110, B:47:0x014a, B:48:0x014d, B:50:0x0153, B:51:0x0165, B:53:0x0195, B:55:0x019b, B:57:0x01a1, B:59:0x01a7), top: B:44:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0153 A[Catch: Exception -> 0x027d, TryCatch #1 {Exception -> 0x027d, blocks: (B:45:0x0110, B:47:0x014a, B:48:0x014d, B:50:0x0153, B:51:0x0165, B:53:0x0195, B:55:0x019b, B:57:0x01a1, B:59:0x01a7), top: B:44:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0195 A[Catch: Exception -> 0x027d, TryCatch #1 {Exception -> 0x027d, blocks: (B:45:0x0110, B:47:0x014a, B:48:0x014d, B:50:0x0153, B:51:0x0165, B:53:0x0195, B:55:0x019b, B:57:0x01a1, B:59:0x01a7), top: B:44:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0203 A[Catch: Exception -> 0x0274, TryCatch #9 {Exception -> 0x0274, blocks: (B:66:0x01e9, B:69:0x01f9, B:71:0x0203, B:73:0x020d), top: B:65:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020d A[Catch: Exception -> 0x0274, TRY_LEAVE, TryCatch #9 {Exception -> 0x0274, blocks: (B:66:0x01e9, B:69:0x01f9, B:71:0x0203, B:73:0x020d), top: B:65:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean writeMood(String str) {
        int i3;
        String str2;
        String str3;
        boolean z16;
        String str4;
        ArrayList arrayList;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        String optString;
        int optInt;
        String optString2;
        String optString3;
        final int i16;
        int i17;
        PublishEventTag publishEventTag;
        String optString4;
        final Activity a16;
        final ArrayList arrayList2;
        String local;
        int i18;
        int i19;
        QzoneMoodPlugin qzoneMoodPlugin = this;
        qzoneMoodPlugin.mWriteMoodJsonStr = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString5 = jSONObject.optString("text");
            try {
                try {
                    if (TextUtils.isEmpty(optString5)) {
                        String optString6 = jSONObject.optString("base64UBBText");
                        if (!TextUtils.isEmpty(optString6)) {
                            try {
                                String str5 = new String(Base64.decode(optString6, 2));
                                if (TextUtils.isEmpty(str5)) {
                                    arrayList = null;
                                } else {
                                    arrayList = new ArrayList();
                                    try {
                                        String parseAtString = parseAtString(str5, arrayList);
                                        if (!TextUtils.isEmpty(parseAtString)) {
                                            optString5 = parseAtString;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        QLog.e(TAG, 1, "writeMood: parse base64UBBText error:", th);
                                        str4 = optString5;
                                        optJSONArray = jSONObject.optJSONArray("photoList");
                                        ArrayList arrayList3 = new ArrayList();
                                        if (optJSONArray != null) {
                                        }
                                        optJSONArray2 = jSONObject.optJSONArray("videoList");
                                        final ArrayList arrayList4 = new ArrayList();
                                        if (optJSONArray2 != null) {
                                        }
                                        final Intent intent = new Intent();
                                        optString = jSONObject.optString("tagId");
                                        String optString7 = jSONObject.optString("tagTitle");
                                        String optString8 = jSONObject.optString("tagUrl");
                                        String optString9 = jSONObject.optString("tagProtocol");
                                        String optString10 = jSONObject.optString("desc");
                                        str3 = TAG;
                                        String optString11 = jSONObject.optString("materialType");
                                        String optString12 = jSONObject.optString(DKConfiguration.PreloadKeys.KEY_MATERIAL_ID);
                                        final String str6 = str4;
                                        String optString13 = jSONObject.optString("adId");
                                        final ArrayList arrayList5 = arrayList;
                                        boolean optBoolean = jSONObject.optBoolean("publishSyncToQcircle");
                                        String optString14 = jSONObject.optString("publishQCircleTemplateTopic");
                                        String optString15 = jSONObject.optString("syncCircleBubbleText");
                                        String optString16 = jSONObject.optString("placeholder");
                                        optInt = jSONObject.optInt("isfromfeedcombine");
                                        String optString17 = jSONObject.optString("descTruncateNum");
                                        String optString18 = jSONObject.optString("thirdPartyAppId");
                                        optString2 = jSONObject.optString("extendInfo");
                                        optString3 = jSONObject.optString("thirdPartyExtendMap");
                                        if (!TextUtils.isEmpty(optString2)) {
                                        }
                                        if (!TextUtils.isEmpty(optString3)) {
                                        }
                                        intent.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_TYPE, optString11);
                                        intent.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_ID, optString12);
                                        intent.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE, optBoolean);
                                        intent.putExtra(QQWinkConstants.PUBLISH_TEMPLATE_TOPIC, optString14);
                                        intent.putExtra("syncCircleBubbleText", optString15);
                                        intent.putExtra("placeholder", optString16);
                                        intent.putExtra(QQWinkConstants.PUBLISH_JS_BRIDGE_AD_ID, optString13);
                                        intent.putExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, optString18);
                                        if (TextUtils.isEmpty(optString)) {
                                        }
                                        i16 = optInt;
                                        i17 = 1;
                                        publishEventTag = null;
                                        optString4 = jSONObject.optString("singlePic");
                                        qzoneMoodPlugin = this;
                                        a16 = qzoneMoodPlugin.parentPlugin.mRuntime.a();
                                        if (!TextUtils.isEmpty(optString4)) {
                                        }
                                        arrayList2 = arrayList3;
                                        if (a16 == null) {
                                        }
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                arrayList = null;
                            }
                            str4 = optString5;
                            optJSONArray = jSONObject.optJSONArray("photoList");
                            ArrayList arrayList32 = new ArrayList();
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                for (i19 = 0; i19 < optJSONArray.length(); i19++) {
                                    arrayList32.add(optJSONArray.getJSONObject(i19).getString("url"));
                                }
                            }
                            optJSONArray2 = jSONObject.optJSONArray("videoList");
                            final ArrayList arrayList42 = new ArrayList();
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                for (i18 = 0; i18 < optJSONArray2.length(); i18++) {
                                    arrayList42.add(optJSONArray2.optJSONObject(i18).optString("localpath"));
                                }
                            }
                            final Intent intent2 = new Intent();
                            optString = jSONObject.optString("tagId");
                            String optString72 = jSONObject.optString("tagTitle");
                            String optString82 = jSONObject.optString("tagUrl");
                            String optString92 = jSONObject.optString("tagProtocol");
                            String optString102 = jSONObject.optString("desc");
                            str3 = TAG;
                            String optString112 = jSONObject.optString("materialType");
                            String optString122 = jSONObject.optString(DKConfiguration.PreloadKeys.KEY_MATERIAL_ID);
                            final String str62 = str4;
                            String optString132 = jSONObject.optString("adId");
                            final ArrayList arrayList52 = arrayList;
                            boolean optBoolean2 = jSONObject.optBoolean("publishSyncToQcircle");
                            String optString142 = jSONObject.optString("publishQCircleTemplateTopic");
                            String optString152 = jSONObject.optString("syncCircleBubbleText");
                            String optString162 = jSONObject.optString("placeholder");
                            optInt = jSONObject.optInt("isfromfeedcombine");
                            String optString172 = jSONObject.optString("descTruncateNum");
                            String optString182 = jSONObject.optString("thirdPartyAppId");
                            optString2 = jSONObject.optString("extendInfo");
                            optString3 = jSONObject.optString("thirdPartyExtendMap");
                            if (!TextUtils.isEmpty(optString2)) {
                                intent2.putExtra("extendInfo", optString2);
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                HashMap<String, String> b16 = r.b(optString3);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("third_party_extend_map", b16);
                                intent2.putExtras(bundle);
                            }
                            intent2.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_TYPE, optString112);
                            intent2.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_ID, optString122);
                            intent2.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE, optBoolean2);
                            intent2.putExtra(QQWinkConstants.PUBLISH_TEMPLATE_TOPIC, optString142);
                            intent2.putExtra("syncCircleBubbleText", optString152);
                            intent2.putExtra("placeholder", optString162);
                            intent2.putExtra(QQWinkConstants.PUBLISH_JS_BRIDGE_AD_ID, optString132);
                            intent2.putExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, optString182);
                            if (!TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString72) || TextUtils.isEmpty(optString82) || TextUtils.isEmpty(optString92)) {
                                i16 = optInt;
                                i17 = 1;
                                publishEventTag = null;
                            } else {
                                PublishEventTag publishEventTag2 = new PublishEventTag();
                                publishEventTag2.f390868id = optString;
                                publishEventTag2.title = optString72;
                                publishEventTag2.picUrl = optString82;
                                publishEventTag2.f390869protocol = optString92;
                                i16 = optInt;
                                i17 = 1;
                                if (i16 == 1) {
                                    try {
                                        if (!TextUtils.isEmpty(optString102) && !TextUtils.isEmpty(optString172)) {
                                            publishEventTag2.picUrl = QzoneConfig.DefaultValue.QZONE_EVENT_TAG_PIC_URL_DEFAULT;
                                            publishEventTag2.desc = optString102;
                                            publishEventTag2.truncateNum = optString172;
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                        qzoneMoodPlugin = this;
                                        str2 = str;
                                        i3 = i17;
                                        z16 = false;
                                        QLog.e(str3, i3, e.getMessage());
                                        qzoneMoodPlugin.handleWriteMoodResultCallback(str2, -1);
                                        return z16;
                                    }
                                }
                                publishEventTag = publishEventTag2;
                            }
                            optString4 = jSONObject.optString("singlePic");
                            qzoneMoodPlugin = this;
                            a16 = qzoneMoodPlugin.parentPlugin.mRuntime.a();
                            if (!TextUtils.isEmpty(optString4) && a16 != null) {
                                local = QzoneUploadInterface.toLocal(a16, optString4);
                                if (!TextUtils.isEmpty(local)) {
                                    arrayList2 = arrayList32;
                                    arrayList2.add(local);
                                    if (a16 == null) {
                                        final String currentAccountUin = qzoneMoodPlugin.parentPlugin.mRuntime.b().getCurrentAccountUin();
                                        WebViewPlugin webViewPlugin = qzoneMoodPlugin.parentPlugin;
                                        final int generateRequestCode = QZoneHelperProxyImpl.generateRequestCode(webViewPlugin, webViewPlugin.mRuntime, 6);
                                        final PublishEventTag publishEventTag3 = publishEventTag;
                                        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.qzone.webviewplugin.QzoneMoodPlugin.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                HashMap<String, String> hashMap;
                                                String str7;
                                                ArrayList arrayList6 = arrayList52;
                                                if (arrayList6 != null && !arrayList6.isEmpty()) {
                                                    if (QzoneMoodPlugin.listFriNickName.isEmpty()) {
                                                        QzoneMoodPlugin.this.loadFriendListFromQQ();
                                                    }
                                                    Iterator it = QzoneMoodPlugin.listFriNickName.iterator();
                                                    while (true) {
                                                        if (!it.hasNext()) {
                                                            hashMap = null;
                                                            break;
                                                        }
                                                        FriendNickNames friendNickNames = (FriendNickNames) it.next();
                                                        if (friendNickNames != null && (str7 = friendNickNames.mainUin) != null && friendNickNames.nickNamesMap != null && str7.equalsIgnoreCase(currentAccountUin)) {
                                                            hashMap = friendNickNames.nickNamesMap;
                                                            break;
                                                        }
                                                    }
                                                    if (hashMap != null) {
                                                        Iterator it5 = arrayList52.iterator();
                                                        while (it5.hasNext()) {
                                                            ResultRecord resultRecord = (ResultRecord) it5.next();
                                                            String str8 = hashMap.get(resultRecord.uin);
                                                            if (!TextUtils.isEmpty(str8)) {
                                                                resultRecord.name = str8;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (i16 == 1) {
                                                    QZoneHelper.forwardToWriteMood(a16, QzoneMoodPlugin.this.parentPlugin.mRuntime.b().getCurrentAccountUin(), str62, arrayList2, arrayList52, publishEventTag3, generateRequestCode, intent2);
                                                    return;
                                                }
                                                if (!arrayList2.isEmpty()) {
                                                    QZoneHelper.forwardToWriteMood(a16, QzoneMoodPlugin.this.parentPlugin.mRuntime.b().getCurrentAccountUin(), str62, arrayList2, arrayList52, publishEventTag3, generateRequestCode, intent2);
                                                    ((IWinkAPI) QRoute.api(IWinkAPI.class)).exitWink(true, 0, null);
                                                    return;
                                                }
                                                if (arrayList42.isEmpty()) {
                                                    return;
                                                }
                                                ArrayList arrayList7 = new ArrayList();
                                                Iterator it6 = arrayList42.iterator();
                                                while (it6.hasNext()) {
                                                    String str9 = (String) it6.next();
                                                    if (!TextUtils.isEmpty(str9)) {
                                                        LocalMediaInfo buildLocalMediaInfoByPath = ((IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class)).buildLocalMediaInfoByPath(str9);
                                                        if (buildLocalMediaInfoByPath == null) {
                                                            buildLocalMediaInfoByPath = ((IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class)).buildLocalMediaInfoForVideo(str9);
                                                        }
                                                        if (buildLocalMediaInfoByPath != null) {
                                                            buildLocalMediaInfoByPath.isVideoShareToQZone = true;
                                                            arrayList7.add(buildLocalMediaInfoByPath);
                                                        }
                                                    }
                                                }
                                                if (!TextUtils.isEmpty(str62)) {
                                                    intent2.putExtra("summary", str62);
                                                }
                                                intent2.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
                                                ((IWinkAPI) QRoute.api(IWinkAPI.class)).exitWink(true, 0, null);
                                                IQZoneMediaResultDealWithApi.CommitMediaConfig commitMediaConfig = new IQZoneMediaResultDealWithApi.CommitMediaConfig();
                                                commitMediaConfig.destPageName = ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName();
                                                commitMediaConfig.dataBundle = intent2;
                                                commitMediaConfig.selectedMediaList = arrayList7;
                                                commitMediaConfig.eventTag = publishEventTag3;
                                                commitMediaConfig.requestCode = generateRequestCode;
                                                ((IQZoneMediaResultDealWithApi) QRoute.api(IQZoneMediaResultDealWithApi.class)).commitMediaToDestPage(a16, commitMediaConfig);
                                            }
                                        });
                                        str2 = str;
                                        z16 = false;
                                        try {
                                            qzoneMoodPlugin.handleWriteMoodResultCallback(str2, 0);
                                            i3 = 1;
                                            if (jSONObject.optInt(PARAM_KEY_POP_WEB_PAGE) == 1) {
                                                try {
                                                    if (qzoneMoodPlugin.parentPlugin.mRuntime.a() != null) {
                                                        qzoneMoodPlugin.parentPlugin.mRuntime.a().finish();
                                                    }
                                                } catch (Exception e17) {
                                                    e = e17;
                                                    QLog.e(str3, i3, e.getMessage());
                                                    qzoneMoodPlugin.handleWriteMoodResultCallback(str2, -1);
                                                    return z16;
                                                }
                                            }
                                            return true;
                                        } catch (Exception e18) {
                                            e = e18;
                                            i3 = 1;
                                            QLog.e(str3, i3, e.getMessage());
                                            qzoneMoodPlugin.handleWriteMoodResultCallback(str2, -1);
                                            return z16;
                                        }
                                    }
                                    qzoneMoodPlugin.handleWriteMoodResultCallback(str, -1);
                                    return false;
                                }
                            }
                            arrayList2 = arrayList32;
                            if (a16 == null) {
                            }
                        }
                    }
                    a16 = qzoneMoodPlugin.parentPlugin.mRuntime.a();
                    if (!TextUtils.isEmpty(optString4)) {
                        local = QzoneUploadInterface.toLocal(a16, optString4);
                        if (!TextUtils.isEmpty(local)) {
                        }
                    }
                    arrayList2 = arrayList32;
                    if (a16 == null) {
                    }
                } catch (Exception e19) {
                    e = e19;
                    str2 = str;
                    i3 = i17;
                    z16 = false;
                    QLog.e(str3, i3, e.getMessage());
                    qzoneMoodPlugin.handleWriteMoodResultCallback(str2, -1);
                    return z16;
                }
                String optString1522 = jSONObject.optString("syncCircleBubbleText");
                String optString1622 = jSONObject.optString("placeholder");
                optInt = jSONObject.optInt("isfromfeedcombine");
                String optString1722 = jSONObject.optString("descTruncateNum");
                String optString1822 = jSONObject.optString("thirdPartyAppId");
                optString2 = jSONObject.optString("extendInfo");
                optString3 = jSONObject.optString("thirdPartyExtendMap");
                if (!TextUtils.isEmpty(optString2)) {
                }
                if (!TextUtils.isEmpty(optString3)) {
                }
                intent2.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_TYPE, optString112);
                intent2.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE_MATERIAL_ID, optString122);
                intent2.putExtra(QQWinkConstants.PUBLISH_SYNC_TO_QCIRCLE, optBoolean2);
                intent2.putExtra(QQWinkConstants.PUBLISH_TEMPLATE_TOPIC, optString142);
                intent2.putExtra("syncCircleBubbleText", optString1522);
                intent2.putExtra("placeholder", optString1622);
                intent2.putExtra(QQWinkConstants.PUBLISH_JS_BRIDGE_AD_ID, optString132);
                intent2.putExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, optString1822);
                if (TextUtils.isEmpty(optString)) {
                }
                i16 = optInt;
                i17 = 1;
                publishEventTag = null;
                optString4 = jSONObject.optString("singlePic");
                qzoneMoodPlugin = this;
            } catch (Exception e26) {
                e = e26;
                qzoneMoodPlugin = this;
                str2 = str;
                z16 = false;
                i3 = 1;
                QLog.e(str3, i3, e.getMessage());
                qzoneMoodPlugin.handleWriteMoodResultCallback(str2, -1);
                return z16;
            }
            str4 = optString5;
            arrayList = null;
            optJSONArray = jSONObject.optJSONArray("photoList");
            ArrayList arrayList322 = new ArrayList();
            if (optJSONArray != null) {
                while (i19 < optJSONArray.length()) {
                }
            }
            optJSONArray2 = jSONObject.optJSONArray("videoList");
            final ArrayList arrayList422 = new ArrayList();
            if (optJSONArray2 != null) {
                while (i18 < optJSONArray2.length()) {
                }
            }
            final Intent intent22 = new Intent();
            optString = jSONObject.optString("tagId");
            String optString722 = jSONObject.optString("tagTitle");
            String optString822 = jSONObject.optString("tagUrl");
            String optString922 = jSONObject.optString("tagProtocol");
            String optString1022 = jSONObject.optString("desc");
            str3 = TAG;
            String optString1122 = jSONObject.optString("materialType");
            String optString1222 = jSONObject.optString(DKConfiguration.PreloadKeys.KEY_MATERIAL_ID);
            final String str622 = str4;
            String optString1322 = jSONObject.optString("adId");
            final ArrayList arrayList522 = arrayList;
            boolean optBoolean22 = jSONObject.optBoolean("publishSyncToQcircle");
            String optString1422 = jSONObject.optString("publishQCircleTemplateTopic");
        } catch (Exception e27) {
            e = e27;
            i3 = 1;
            str2 = str;
            str3 = TAG;
        }
    }
}
