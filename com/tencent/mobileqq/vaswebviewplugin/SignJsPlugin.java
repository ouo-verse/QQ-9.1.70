package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.ActionListActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureManagerForTool;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.api.IVasWebUrl;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ao;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class SignJsPlugin extends VasWebviewJsPlugin {
    public static final String CHANGE_STATUS_CALLBACK_DATA = "change_status_callback_data";
    public static final String LOCATION_SP_KEY = "sign_location_id_";
    public static final String NAME_SPACE = "sign";
    private static final String PARAM_ACTION_ID = "k_action_id";
    private static final String PARAM_ACTION_TEXT = "k_action_text";
    public static final String PARAM_DATA_ID = "k_data_id";
    public static final String PARAM_DATA_TEXT = "k_data_text";
    private static final byte REQUEST_ACTION = 101;
    private static final byte REQUEST_LOCATION = 100;
    private static final String TAG = "SignJsPlugin";
    private final String SIGNATURE_SYNC_IMG_TEMP_FILE;
    private final String SIGNATURE_SYNC_IMG_TEMP_PATH;
    private BrowserAppInterface browserApp;
    private EIPCResultCallback getSignatureCallback;
    private boolean isSync;
    private String mActionCallback;
    private String mCachePoiId;
    private String mContentChangeCallback;
    private String mGetSigInfoCallback;
    private String mLocationCallback;
    private String mOpenFontCallback;
    private String mPublishCallback;
    private Bundle mReqBundle;
    private int mSelectTagId;
    private String mSelectTagText;

    public SignJsPlugin() {
        String str = VasConstant.SIGNATURE_TEMPLATE_DIR + "temp/";
        this.SIGNATURE_SYNC_IMG_TEMP_PATH = str;
        this.SIGNATURE_SYNC_IMG_TEMP_FILE = str + "temp.png";
        this.getSignatureCallback = new EIPCResultCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin.1
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                Bundle bundle;
                int i3;
                if (TextUtils.isEmpty(SignJsPlugin.this.mGetSigInfoCallback)) {
                    QLog.e(SignJsPlugin.TAG, 1, "getSignature callback web callback is null");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    if (eIPCResult.code == 0 && (bundle = eIPCResult.data) != null) {
                        Serializable serializable = bundle.getSerializable("my_signature");
                        if (serializable instanceof RichStatus) {
                            RichStatus richStatus = (RichStatus) serializable;
                            if (SignatureManagerForTool.j().f282249c == null) {
                                SignatureManagerForTool.j().o(richStatus);
                            }
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("bgId", richStatus.tplId);
                            jSONObject2.put(MessageForRichState.SIGN_MSG_FONT_ID, richStatus.fontId);
                            jSONObject2.put(MessageForRichState.SIGN_MSG_FONT_TYPE, richStatus.fontType);
                            jSONObject2.put("actionId", richStatus.actionId);
                            jSONObject2.put("actionText", richStatus.actionText);
                            SignatureTemplateInfo l3 = SignatureManagerForTool.j().l(richStatus.tplId);
                            if (l3.isParsing.get()) {
                                ArrayList<RichStatus.StickerInfo> arrayList = richStatus.mStickerInfos;
                                if (arrayList != null && !arrayList.isEmpty()) {
                                    i3 = 1;
                                }
                                i3 = 0;
                            } else {
                                i3 = l3.signType;
                            }
                            jSONObject2.put(PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, i3);
                            jSONObject.put("result", 0);
                            jSONObject.put("data", jSONObject2);
                            SignJsPlugin signJsPlugin = SignJsPlugin.this;
                            signJsPlugin.callJs(signJsPlugin.mGetSigInfoCallback, jSONObject.toString());
                            if (QLog.isColorLevel()) {
                                QLog.d(SignJsPlugin.TAG, 2, "getSignature result = " + jSONObject.toString());
                                return;
                            }
                            return;
                        }
                    }
                } catch (Exception e16) {
                    QLog.e(SignJsPlugin.TAG, 1, "getSignature callback error: ", e16);
                }
                SignJsPlugin signJsPlugin2 = SignJsPlugin.this;
                signJsPlugin2.callJs(signJsPlugin2.mGetSigInfoCallback, "{\"result\": -1}");
            }
        };
    }

    private void handleChangeStatusCallback(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            int i3 = bundle.getInt("result");
            if (i3 == 100) {
                jSONObject.put("result", 0);
            } else {
                jSONObject.put("result", i3);
            }
            if (bundle.getBoolean("hasTipsInfo", false)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", bundle.getInt("tips_type"));
                jSONObject2.put("titleWording", bundle.getString("tips_titleWording"));
                jSONObject2.put("wording", bundle.getString("tips_wording"));
                jSONObject2.put("rightBtnWording", bundle.getString("tips_rightBtnWording"));
                jSONObject2.put("leftBtnWording", bundle.getString("tips_leftBtnWording"));
                jSONObject2.put("vipType", bundle.getString("tips_vipType"));
                jSONObject2.put("vipMonth", bundle.getInt("tips_vipMonth"));
                jSONObject2.put("url", bundle.getString("tips_url"));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("tipsInfo", jSONObject2);
                jSONObject.put("data", jSONObject3);
            }
            if (bundle.containsKey("errorDesc")) {
                jSONObject.put("errorDesc", bundle.getString("errorDesc"));
            }
            super.callJs(str, jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleChangeStatusCallback Result = " + jSONObject.toString());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleChangeStatusCallback error: ", e16);
            super.callJs(str, "{\"result\": -1}");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934616L) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onclick open font");
            }
            if (!TextUtils.isEmpty(this.mOpenFontCallback)) {
                super.callJs(this.mOpenFontCallback, "{\"result\": 0}");
            }
            return true;
        }
        if (j3 == 8589934617L) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "change status callback");
            }
            if (!TextUtils.isEmpty(this.mPublishCallback)) {
                Object obj = map.get(CHANGE_STATUS_CALLBACK_DATA);
                if (obj instanceof Bundle) {
                    handleChangeStatusCallback((Bundle) obj, this.mPublishCallback);
                } else {
                    super.callJs(this.mPublishCallback, "{\"result\": -1}");
                }
                this.mPublishCallback = null;
            }
        } else if (j3 == 8589934618L) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "change status callback");
            }
            if (!TextUtils.isEmpty(this.mContentChangeCallback)) {
                super.callJs(this.mContentChangeCallback, "{\"result\": 0}");
            }
        } else if (j3 == 8589934598L) {
            Intent intent = new Intent();
            if (this.mSelectTagId > 0 && !TextUtils.isEmpty(this.mSelectTagText)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, String.format("setResult [%d, %s]", Integer.valueOf(this.mSelectTagId), this.mSelectTagText));
                }
                intent.putExtra("key_sign_topic_id", this.mSelectTagId);
                intent.putExtra("key_sign_topic_name", this.mSelectTagText);
                this.mRuntime.a().setResult(-1, intent);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "sign";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934619L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(23:62|63|(2:259|260)|65|66|67|(2:68|69)|(2:71|(15:73|74|75|76|77|79|80|81|82|83|84|(1:86)|88|(3:162|(1:164)|165)(6:92|(1:94)|95|96|97|98)|(1:111)(6:103|(1:105)|106|107|108|109)))|245|77|79|80|81|82|83|84|(0)|88|(1:90)|162|(0)|165|(1:112)(1:113)) */
    /* JADX WARN: Can't wrap try/catch for region: R(24:62|63|(2:259|260)|65|66|67|68|69|(2:71|(15:73|74|75|76|77|79|80|81|82|83|84|(1:86)|88|(3:162|(1:164)|165)(6:92|(1:94)|95|96|97|98)|(1:111)(6:103|(1:105)|106|107|108|109)))|245|77|79|80|81|82|83|84|(0)|88|(1:90)|162|(0)|165|(1:112)(1:113)) */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x028d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x028f, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x029a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x029b, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0294, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0295, code lost:
    
        r11 = r0;
        r5 = "share img failure, share text only.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x02a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x02a3, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x029d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x029e, code lost:
    
        r11 = r0;
        r5 = "share img failure, share text only.";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x038a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0446 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x044e A[Catch: all -> 0x0688, TryCatch #26 {all -> 0x0688, blocks: (B:101:0x038c, B:103:0x0392, B:105:0x0398, B:107:0x03a0, B:152:0x0462, B:154:0x0468, B:156:0x046e, B:157:0x0472, B:158:0x0477, B:142:0x03f7, B:144:0x03fd, B:146:0x0403, B:131:0x041f, B:133:0x0425, B:135:0x042b, B:120:0x0448, B:122:0x044e, B:124:0x0454, B:282:0x047c, B:284:0x0482, B:286:0x0488, B:287:0x049e, B:293:0x04a5, B:295:0x04b0, B:297:0x04c4, B:300:0x04cf, B:302:0x04d5, B:303:0x04d9, B:305:0x04e5, B:308:0x04f1, B:310:0x04fb, B:312:0x050c, B:314:0x053c, B:315:0x054f, B:317:0x0561, B:319:0x0565, B:323:0x0572, B:325:0x059f, B:329:0x0570, B:330:0x0545, B:331:0x05bb, B:333:0x05c4, B:335:0x05d6, B:337:0x05df, B:339:0x062d, B:341:0x0636, B:343:0x0648, B:345:0x0651, B:347:0x0665, B:348:0x067c), top: B:53:0x01d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x041d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0425 A[Catch: all -> 0x0688, TryCatch #26 {all -> 0x0688, blocks: (B:101:0x038c, B:103:0x0392, B:105:0x0398, B:107:0x03a0, B:152:0x0462, B:154:0x0468, B:156:0x046e, B:157:0x0472, B:158:0x0477, B:142:0x03f7, B:144:0x03fd, B:146:0x0403, B:131:0x041f, B:133:0x0425, B:135:0x042b, B:120:0x0448, B:122:0x044e, B:124:0x0454, B:282:0x047c, B:284:0x0482, B:286:0x0488, B:287:0x049e, B:293:0x04a5, B:295:0x04b0, B:297:0x04c4, B:300:0x04cf, B:302:0x04d5, B:303:0x04d9, B:305:0x04e5, B:308:0x04f1, B:310:0x04fb, B:312:0x050c, B:314:0x053c, B:315:0x054f, B:317:0x0561, B:319:0x0565, B:323:0x0572, B:325:0x059f, B:329:0x0570, B:330:0x0545, B:331:0x05bb, B:333:0x05c4, B:335:0x05d6, B:337:0x05df, B:339:0x062d, B:341:0x0636, B:343:0x0648, B:345:0x0651, B:347:0x0665, B:348:0x067c), top: B:53:0x01d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03fd A[Catch: all -> 0x0688, TryCatch #26 {all -> 0x0688, blocks: (B:101:0x038c, B:103:0x0392, B:105:0x0398, B:107:0x03a0, B:152:0x0462, B:154:0x0468, B:156:0x046e, B:157:0x0472, B:158:0x0477, B:142:0x03f7, B:144:0x03fd, B:146:0x0403, B:131:0x041f, B:133:0x0425, B:135:0x042b, B:120:0x0448, B:122:0x044e, B:124:0x0454, B:282:0x047c, B:284:0x0482, B:286:0x0488, B:287:0x049e, B:293:0x04a5, B:295:0x04b0, B:297:0x04c4, B:300:0x04cf, B:302:0x04d5, B:303:0x04d9, B:305:0x04e5, B:308:0x04f1, B:310:0x04fb, B:312:0x050c, B:314:0x053c, B:315:0x054f, B:317:0x0561, B:319:0x0565, B:323:0x0572, B:325:0x059f, B:329:0x0570, B:330:0x0545, B:331:0x05bb, B:333:0x05c4, B:335:0x05d6, B:337:0x05df, B:339:0x062d, B:341:0x0636, B:343:0x0648, B:345:0x0651, B:347:0x0665, B:348:0x067c), top: B:53:0x01d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[Catch: all -> 0x0688, SYNTHETIC, TryCatch #26 {all -> 0x0688, blocks: (B:101:0x038c, B:103:0x0392, B:105:0x0398, B:107:0x03a0, B:152:0x0462, B:154:0x0468, B:156:0x046e, B:157:0x0472, B:158:0x0477, B:142:0x03f7, B:144:0x03fd, B:146:0x0403, B:131:0x041f, B:133:0x0425, B:135:0x042b, B:120:0x0448, B:122:0x044e, B:124:0x0454, B:282:0x047c, B:284:0x0482, B:286:0x0488, B:287:0x049e, B:293:0x04a5, B:295:0x04b0, B:297:0x04c4, B:300:0x04cf, B:302:0x04d5, B:303:0x04d9, B:305:0x04e5, B:308:0x04f1, B:310:0x04fb, B:312:0x050c, B:314:0x053c, B:315:0x054f, B:317:0x0561, B:319:0x0565, B:323:0x0572, B:325:0x059f, B:329:0x0570, B:330:0x0545, B:331:0x05bb, B:333:0x05c4, B:335:0x05d6, B:337:0x05df, B:339:0x062d, B:341:0x0636, B:343:0x0648, B:345:0x0651, B:347:0x0665, B:348:0x067c), top: B:53:0x01d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x035c A[Catch: all -> 0x02c2, OutOfMemoryError -> 0x02c8, Exception -> 0x02ce, IllegalArgumentException -> 0x02d4, TRY_ENTER, TRY_LEAVE, TryCatch #28 {IllegalArgumentException -> 0x02d4, Exception -> 0x02ce, OutOfMemoryError -> 0x02c8, all -> 0x02c2, blocks: (B:84:0x027b, B:86:0x0287, B:90:0x02f8, B:92:0x0300, B:94:0x0310, B:164:0x035c, B:185:0x028f, B:203:0x02be, B:193:0x02df, B:194:0x02e2, B:196:0x02e8), top: B:66:0x022d }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02df A[Catch: all -> 0x02c2, OutOfMemoryError -> 0x02c8, Exception -> 0x02ce, IllegalArgumentException -> 0x02d4, IOException -> 0x02da, TryCatch #19 {IOException -> 0x02da, blocks: (B:203:0x02be, B:193:0x02df, B:194:0x02e2, B:196:0x02e8), top: B:202:0x02be }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02e8 A[Catch: all -> 0x02c2, OutOfMemoryError -> 0x02c8, Exception -> 0x02ce, IllegalArgumentException -> 0x02d4, IOException -> 0x02da, TRY_LEAVE, TryCatch #19 {IOException -> 0x02da, blocks: (B:203:0x02be, B:193:0x02df, B:194:0x02e2, B:196:0x02e8), top: B:202:0x02be }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03c7 A[Catch: all -> 0x03b9, OutOfMemoryError -> 0x03bb, Exception -> 0x03bd, IllegalArgumentException -> 0x03bf, IOException -> 0x03c2, TryCatch #14 {IOException -> 0x03c2, blocks: (B:230:0x03b5, B:209:0x03c7, B:210:0x03ca, B:212:0x03d0), top: B:229:0x03b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03d0 A[Catch: all -> 0x03b9, OutOfMemoryError -> 0x03bb, Exception -> 0x03bd, IllegalArgumentException -> 0x03bf, IOException -> 0x03c2, TRY_LEAVE, TryCatch #14 {IOException -> 0x03c2, blocks: (B:230:0x03b5, B:209:0x03c7, B:210:0x03ca, B:212:0x03d0), top: B:229:0x03b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[Catch: all -> 0x03b9, OutOfMemoryError -> 0x03bb, Exception -> 0x03bd, IllegalArgumentException -> 0x03bf, SYNTHETIC, TRY_LEAVE, TryCatch #24 {IllegalArgumentException -> 0x03bf, Exception -> 0x03bd, OutOfMemoryError -> 0x03bb, all -> 0x03b9, blocks: (B:230:0x03b5, B:209:0x03c7, B:210:0x03ca, B:212:0x03d0, B:217:0x03d8, B:216:0x03d5), top: B:229:0x03b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:358:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0287 A[Catch: IOException -> 0x028d, all -> 0x02c2, OutOfMemoryError -> 0x02c8, Exception -> 0x02ce, IllegalArgumentException -> 0x02d4, TRY_LEAVE, TryCatch #29 {IOException -> 0x028d, blocks: (B:84:0x027b, B:86:0x0287), top: B:83:0x027b }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02f8 A[Catch: all -> 0x02c2, OutOfMemoryError -> 0x02c8, Exception -> 0x02ce, IllegalArgumentException -> 0x02d4, TRY_ENTER, TryCatch #28 {IllegalArgumentException -> 0x02d4, Exception -> 0x02ce, OutOfMemoryError -> 0x02c8, all -> 0x02c2, blocks: (B:84:0x027b, B:86:0x0287, B:90:0x02f8, B:92:0x0300, B:94:0x0310, B:164:0x035c, B:185:0x028f, B:203:0x02be, B:193:0x02df, B:194:0x02e2, B:196:0x02e8), top: B:66:0x022d }] */
    /* JADX WARN: Type inference failed for: r5v111 */
    /* JADX WARN: Type inference failed for: r5v76 */
    /* JADX WARN: Type inference failed for: r5v78 */
    /* JADX WARN: Type inference failed for: r5v80 */
    /* JADX WARN: Type inference failed for: r5v82, types: [int] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v41, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v62 */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        String str5;
        Throwable th5;
        String str6;
        StringBuilder sb5;
        String optString;
        int i3;
        Throwable th6;
        String str7;
        boolean z16;
        String str8;
        OutOfMemoryError outOfMemoryError;
        String str9;
        boolean z17;
        String str10;
        Exception exc;
        String str11;
        boolean z18;
        String str12;
        IllegalArgumentException illegalArgumentException;
        String str13;
        boolean z19;
        String str14;
        String str15;
        String str16;
        boolean isEmpty;
        ?? r56;
        ?? r85;
        String str17;
        boolean isEmpty2;
        String str18;
        boolean isEmpty3;
        byte[] decode;
        Throwable th7;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        String str19;
        boolean z26;
        File file;
        if (TextUtils.isEmpty(str) || !"sign".equals(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest signjs, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        try {
            JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                try {
                    sb5 = new StringBuilder();
                    str5 = ", methodName=";
                } catch (Throwable th8) {
                    th = th8;
                    str5 = ", methodName=";
                }
                try {
                    sb5.append("handleJsRequest JSON = ");
                    sb5.append(jsonFromJSBridge.toString());
                    QLog.d(TAG, 2, sb5.toString());
                } catch (Throwable th9) {
                    th = th9;
                    th5 = th;
                    str4 = "{\"result\": -1}";
                    str6 = null;
                    QLog.e(TAG, 2, "handleJsRequest exception url=" + str + ", pkgName=" + str2 + str5 + str3 + ", msg=" + th5.getMessage());
                    if (!TextUtils.isEmpty(str6)) {
                    }
                }
            } else {
                str5 = ", methodName=";
            }
            try {
                optString = jsonFromJSBridge.optString("callback");
                try {
                } catch (Throwable th10) {
                    th = th10;
                    str4 = "{\"result\": -1}";
                }
            } catch (Throwable th11) {
                th = th11;
                str4 = "{\"result\": -1}";
                th5 = th;
                str6 = null;
                QLog.e(TAG, 2, "handleJsRequest exception url=" + str + ", pkgName=" + str2 + str5 + str3 + ", msg=" + th5.getMessage());
                if (!TextUtils.isEmpty(str6)) {
                }
            }
            try {
                if (TextUtils.isEmpty(optString)) {
                    QLog.e(TAG, 1, "callback id is null, so return");
                    return true;
                }
                VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
                if ("getLocation".equals(str3)) {
                    QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                    userInfo.qzone_uin = this.browserApp.getCurrentAccountUin();
                    userInfo.nickname = this.browserApp.getCurrentNickname();
                    this.mLocationCallback = optString;
                    String str20 = this.mCachePoiId;
                    if (TextUtils.isEmpty(str20)) {
                        str20 = this.mRuntime.b().getPreferences().getString(LOCATION_SP_KEY + this.mRuntime.b().getCurrentAccountUin(), "");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getLocation poiId = " + str20);
                    }
                    Bundle bundle = new Bundle();
                    if (!TextUtils.isEmpty(str20)) {
                        bundle.putInt("key_lbs_state", 1);
                        bundle.putString("key_current_poi_id", str20);
                    }
                    QZoneHelper.forwardToMoodSelectLocation(this.mRuntime.a(), userInfo, (ao.b("sign") << 8) + 100, bundle);
                    return true;
                }
                if ("getAction".equals(str3)) {
                    Intent intent = new Intent(this.mRuntime.a(), (Class<?>) ActionListActivity.class);
                    this.mActionCallback = optString;
                    super.startActivityForResult(intent, REQUEST_ACTION);
                    return true;
                }
                if ("setLike".equals(str3)) {
                    String optString2 = jsonFromJSBridge.optString("feedsId");
                    String optString3 = jsonFromJSBridge.optString("uin");
                    if (TextUtils.isEmpty(optString2)) {
                        super.callJs(optString, "{\"result\": -1}");
                        return true;
                    }
                    int optInt = jsonFromJSBridge.optInt("actionType");
                    this.mReqBundle.clear();
                    this.mReqBundle.putString("feedsId", optString2);
                    this.mReqBundle.putString("uin", optString3);
                    this.mReqBundle.putInt("actionType", optInt);
                    super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_signature_setlike", optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                    return true;
                }
                try {
                    if ("syncSignatureImg".equals(str3)) {
                        String optString4 = jsonFromJSBridge.optString("img4sync");
                        String optString5 = jsonFromJSBridge.optString("content");
                        boolean z27 = this.isSync;
                        if (!z27) {
                            return true;
                        }
                        if (optString4 != null && (optString4 == null || !optString4.isEmpty())) {
                            try {
                                try {
                                    if (QLog.isColorLevel()) {
                                        try {
                                            QLog.d("SigImg2Zone", 4, optString4);
                                        } catch (IllegalArgumentException e16) {
                                            str18 = "share img failure, share text only.";
                                            z19 = false;
                                            illegalArgumentException = e16;
                                            QLog.e("SigImg2Zone", 2, "base64 string error.");
                                            illegalArgumentException.printStackTrace();
                                            optString4 = str18;
                                            optString4 = str18;
                                            z27 = z19;
                                            z27 = z19;
                                            if (!z19) {
                                            }
                                            return true;
                                        } catch (Exception e17) {
                                            str17 = "share img failure, share text only.";
                                            z18 = false;
                                            exc = e17;
                                            QLog.e("SigImg2Zone", 2, "other exception.");
                                            exc.printStackTrace();
                                            optString4 = str17;
                                            optString4 = str17;
                                            z27 = z18;
                                            z27 = z18;
                                            if (!z18) {
                                            }
                                            return true;
                                        } catch (OutOfMemoryError e18) {
                                            str16 = "share img failure, share text only.";
                                            z17 = false;
                                            outOfMemoryError = e18;
                                            QLog.e("SigImg2Zone", 2, "get param or decode oom.");
                                            outOfMemoryError.printStackTrace();
                                            optString4 = str16;
                                            optString4 = str16;
                                            z27 = z17;
                                            z27 = z17;
                                            if (!z17) {
                                            }
                                            return true;
                                        } catch (Throwable th12) {
                                            th = th12;
                                            optString4 = "share img failure, share text only.";
                                            z27 = false;
                                            th6 = th;
                                            str15 = optString4;
                                            z16 = z27;
                                            if (z16) {
                                            }
                                        }
                                    }
                                } catch (IllegalArgumentException e19) {
                                    e = e19;
                                } catch (Exception e26) {
                                    e = e26;
                                } catch (OutOfMemoryError e27) {
                                    e = e27;
                                } catch (Throwable th13) {
                                    th = th13;
                                }
                                try {
                                    decode = PluginBaseInfoHelper.Base64Helper.decode(optString4, 2);
                                    try {
                                        file = new File(this.SIGNATURE_SYNC_IMG_TEMP_PATH);
                                    } catch (IOException e28) {
                                        e = e28;
                                    } catch (Throwable th14) {
                                        th = th14;
                                    }
                                } catch (IllegalArgumentException e29) {
                                    illegalArgumentException = e29;
                                    str13 = "share img failure, share text only.";
                                    z19 = false;
                                    str18 = str13;
                                    QLog.e("SigImg2Zone", 2, "base64 string error.");
                                    illegalArgumentException.printStackTrace();
                                    optString4 = str18;
                                    optString4 = str18;
                                    z27 = z19;
                                    z27 = z19;
                                    if (!z19 && optString5 != null) {
                                        isEmpty3 = optString5.isEmpty();
                                        optString4 = str18;
                                        z27 = isEmpty3;
                                        if (!isEmpty3) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SigImg2Zone", 4, str18);
                                            }
                                            r56 = 3;
                                            r85 = 0;
                                            QZoneHelper.publishPictureMoodSilently(optString5, r85, ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, r56);
                                            optString4 = r56;
                                            z27 = r85;
                                        }
                                    }
                                    return true;
                                } catch (Exception e36) {
                                    exc = e36;
                                    str11 = "share img failure, share text only.";
                                    z18 = false;
                                    str17 = str11;
                                    QLog.e("SigImg2Zone", 2, "other exception.");
                                    exc.printStackTrace();
                                    optString4 = str17;
                                    optString4 = str17;
                                    z27 = z18;
                                    z27 = z18;
                                    if (!z18 && optString5 != null) {
                                        isEmpty2 = optString5.isEmpty();
                                        optString4 = str17;
                                        z27 = isEmpty2;
                                        if (!isEmpty2) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SigImg2Zone", 4, str17);
                                            }
                                            r56 = 3;
                                            r85 = 0;
                                            QZoneHelper.publishPictureMoodSilently(optString5, r85, ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, r56);
                                            optString4 = r56;
                                            z27 = r85;
                                        }
                                    }
                                    return true;
                                } catch (OutOfMemoryError e37) {
                                    outOfMemoryError = e37;
                                    str9 = "share img failure, share text only.";
                                    z17 = false;
                                    str16 = str9;
                                    QLog.e("SigImg2Zone", 2, "get param or decode oom.");
                                    outOfMemoryError.printStackTrace();
                                    optString4 = str16;
                                    optString4 = str16;
                                    z27 = z17;
                                    z27 = z17;
                                    if (!z17 && optString5 != null) {
                                        isEmpty = optString5.isEmpty();
                                        optString4 = str16;
                                        z27 = isEmpty;
                                        if (!isEmpty) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SigImg2Zone", 4, str16);
                                            }
                                            r56 = 3;
                                            r85 = 0;
                                            QZoneHelper.publishPictureMoodSilently(optString5, r85, ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, r56);
                                            optString4 = r56;
                                            z27 = r85;
                                        }
                                    }
                                    return true;
                                } catch (Throwable th15) {
                                    th6 = th15;
                                    str7 = "share img failure, share text only.";
                                    z16 = false;
                                    str15 = str7;
                                    if (z16) {
                                        throw th6;
                                    }
                                    if (optString5 != null) {
                                        if (!optString5.isEmpty()) {
                                            if (QLog.isColorLevel()) {
                                                QLog.d("SigImg2Zone", 4, str15);
                                            }
                                            QZoneHelper.publishPictureMoodSilently(optString5, null, ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, 3);
                                            throw th6;
                                        }
                                        throw th6;
                                    }
                                    throw th6;
                                }
                                if (!file.exists()) {
                                    boolean mkdirs = file.mkdirs();
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb6 = new StringBuilder();
                                        try {
                                            sb6.append("temp path not exist, create it. result: ");
                                            sb6.append(mkdirs);
                                            sb6.append(".");
                                            QLog.i("SigImg2Zone", 2, sb6.toString());
                                            fileOutputStream = new FileOutputStream(this.SIGNATURE_SYNC_IMG_TEMP_FILE);
                                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                            bufferedOutputStream.write(decode);
                                            bufferedOutputStream.flush();
                                            bufferedOutputStream.close();
                                            fileOutputStream.close();
                                            if (QLog.isColorLevel()) {
                                                QLog.i("SigImg2Zone", 2, "close file success.");
                                            }
                                        } catch (IOException e38) {
                                            e = e38;
                                            IOException iOException = e;
                                            fileOutputStream = null;
                                            bufferedOutputStream = null;
                                            try {
                                                iOException.printStackTrace();
                                                if (bufferedOutputStream != null) {
                                                    try {
                                                        bufferedOutputStream.close();
                                                    } catch (IOException e39) {
                                                        try {
                                                            e39.printStackTrace();
                                                        } catch (IllegalArgumentException e46) {
                                                            e = e46;
                                                            str14 = "share img failure, share text only.";
                                                            illegalArgumentException = e;
                                                            str13 = str14;
                                                            z19 = false;
                                                            str18 = str13;
                                                            QLog.e("SigImg2Zone", 2, "base64 string error.");
                                                            illegalArgumentException.printStackTrace();
                                                            optString4 = str18;
                                                            optString4 = str18;
                                                            z27 = z19;
                                                            z27 = z19;
                                                            if (!z19) {
                                                            }
                                                            return true;
                                                        } catch (Exception e47) {
                                                            e = e47;
                                                            str12 = "share img failure, share text only.";
                                                            exc = e;
                                                            str11 = str12;
                                                            z18 = false;
                                                            str17 = str11;
                                                            QLog.e("SigImg2Zone", 2, "other exception.");
                                                            exc.printStackTrace();
                                                            optString4 = str17;
                                                            optString4 = str17;
                                                            z27 = z18;
                                                            z27 = z18;
                                                            if (!z18) {
                                                            }
                                                            return true;
                                                        } catch (OutOfMemoryError e48) {
                                                            e = e48;
                                                            str10 = "share img failure, share text only.";
                                                            outOfMemoryError = e;
                                                            str9 = str10;
                                                            z17 = false;
                                                            str16 = str9;
                                                            QLog.e("SigImg2Zone", 2, "get param or decode oom.");
                                                            outOfMemoryError.printStackTrace();
                                                            optString4 = str16;
                                                            optString4 = str16;
                                                            z27 = z17;
                                                            z27 = z17;
                                                            if (!z17) {
                                                            }
                                                            return true;
                                                        } catch (Throwable th16) {
                                                            th = th16;
                                                            str8 = "share img failure, share text only.";
                                                            th6 = th;
                                                            str7 = str8;
                                                            z16 = false;
                                                            str15 = str7;
                                                            if (z16) {
                                                            }
                                                        }
                                                    }
                                                }
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                if (QLog.isColorLevel()) {
                                                    QLog.i("SigImg2Zone", 2, "close file success.");
                                                }
                                                if (!FileUtils.fileExists(this.SIGNATURE_SYNC_IMG_TEMP_FILE)) {
                                                }
                                                if (QLog.isColorLevel()) {
                                                }
                                                z26 = false;
                                                if (z26) {
                                                }
                                            } catch (Throwable th17) {
                                                str19 = "share img failure, share text only.";
                                                th7 = th17;
                                                if (bufferedOutputStream != null) {
                                                    try {
                                                        try {
                                                            bufferedOutputStream.close();
                                                        } catch (IllegalArgumentException e49) {
                                                            e = e49;
                                                            str14 = str19;
                                                            illegalArgumentException = e;
                                                            str13 = str14;
                                                            z19 = false;
                                                            str18 = str13;
                                                            QLog.e("SigImg2Zone", 2, "base64 string error.");
                                                            illegalArgumentException.printStackTrace();
                                                            optString4 = str18;
                                                            optString4 = str18;
                                                            z27 = z19;
                                                            z27 = z19;
                                                            if (!z19) {
                                                            }
                                                            return true;
                                                        } catch (Exception e56) {
                                                            e = e56;
                                                            str12 = str19;
                                                            exc = e;
                                                            str11 = str12;
                                                            z18 = false;
                                                            str17 = str11;
                                                            QLog.e("SigImg2Zone", 2, "other exception.");
                                                            exc.printStackTrace();
                                                            optString4 = str17;
                                                            optString4 = str17;
                                                            z27 = z18;
                                                            z27 = z18;
                                                            if (!z18) {
                                                            }
                                                            return true;
                                                        } catch (OutOfMemoryError e57) {
                                                            e = e57;
                                                            str10 = str19;
                                                            outOfMemoryError = e;
                                                            str9 = str10;
                                                            z17 = false;
                                                            str16 = str9;
                                                            QLog.e("SigImg2Zone", 2, "get param or decode oom.");
                                                            outOfMemoryError.printStackTrace();
                                                            optString4 = str16;
                                                            optString4 = str16;
                                                            z27 = z17;
                                                            z27 = z17;
                                                            if (!z17) {
                                                            }
                                                            return true;
                                                        } catch (Throwable th18) {
                                                            th = th18;
                                                            str8 = str19;
                                                            th6 = th;
                                                            str7 = str8;
                                                            z16 = false;
                                                            str15 = str7;
                                                            if (z16) {
                                                            }
                                                        }
                                                    } catch (IOException e58) {
                                                        e58.printStackTrace();
                                                        throw th7;
                                                    }
                                                }
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                if (!QLog.isColorLevel()) {
                                                    QLog.i("SigImg2Zone", 2, "close file success.");
                                                    throw th7;
                                                }
                                                throw th7;
                                            }
                                        } catch (Throwable th19) {
                                            th = th19;
                                            th7 = th;
                                            String str21 = "share img failure, share text only.";
                                            fileOutputStream = null;
                                            bufferedOutputStream = null;
                                            str19 = str21;
                                            if (bufferedOutputStream != null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            if (!QLog.isColorLevel()) {
                                            }
                                        }
                                        if (!FileUtils.fileExists(this.SIGNATURE_SYNC_IMG_TEMP_FILE) && FileUtils.isPicFile(this.SIGNATURE_SYNC_IMG_TEMP_FILE)) {
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(this.SIGNATURE_SYNC_IMG_TEMP_FILE);
                                            if (QLog.isColorLevel()) {
                                                QLog.i("SigImg2Zone", 2, "share to zone file list: " + ((String) arrayList.get(0)));
                                            }
                                            try {
                                                QZoneHelper.publishPictureMoodSilently(HardCodeUtil.qqStr(R.string.tjj), arrayList, ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, 3);
                                                z26 = true;
                                            } catch (IllegalArgumentException e59) {
                                                illegalArgumentException = e59;
                                                str18 = "share img failure, share text only.";
                                                z19 = true;
                                                QLog.e("SigImg2Zone", 2, "base64 string error.");
                                                illegalArgumentException.printStackTrace();
                                                optString4 = str18;
                                                optString4 = str18;
                                                z27 = z19;
                                                z27 = z19;
                                                if (!z19) {
                                                    isEmpty3 = optString5.isEmpty();
                                                    optString4 = str18;
                                                    z27 = isEmpty3;
                                                    if (!isEmpty3) {
                                                    }
                                                }
                                                return true;
                                            } catch (Exception e65) {
                                                exc = e65;
                                                str17 = "share img failure, share text only.";
                                                z18 = true;
                                                QLog.e("SigImg2Zone", 2, "other exception.");
                                                exc.printStackTrace();
                                                optString4 = str17;
                                                optString4 = str17;
                                                z27 = z18;
                                                z27 = z18;
                                                if (!z18) {
                                                    isEmpty2 = optString5.isEmpty();
                                                    optString4 = str17;
                                                    z27 = isEmpty2;
                                                    if (!isEmpty2) {
                                                    }
                                                }
                                                return true;
                                            } catch (OutOfMemoryError e66) {
                                                outOfMemoryError = e66;
                                                str16 = "share img failure, share text only.";
                                                z17 = true;
                                                QLog.e("SigImg2Zone", 2, "get param or decode oom.");
                                                outOfMemoryError.printStackTrace();
                                                optString4 = str16;
                                                optString4 = str16;
                                                z27 = z17;
                                                z27 = z17;
                                                if (!z17) {
                                                    isEmpty = optString5.isEmpty();
                                                    optString4 = str16;
                                                    z27 = isEmpty;
                                                    if (!isEmpty) {
                                                    }
                                                }
                                                return true;
                                            } catch (Throwable th20) {
                                                th6 = th20;
                                                str15 = "share img failure, share text only.";
                                                z16 = true;
                                                if (z16) {
                                                }
                                            }
                                        } else {
                                            if (QLog.isColorLevel()) {
                                                QLog.i("SigImg2Zone", 2, "share to zone failure. file exist:" + FileUtils.fileExists(this.SIGNATURE_SYNC_IMG_TEMP_FILE) + " file isPic:" + FileUtils.isPicFile(this.SIGNATURE_SYNC_IMG_TEMP_FILE));
                                            }
                                            z26 = false;
                                        }
                                        if (z26 || optString5 == null || optString5.isEmpty()) {
                                            return true;
                                        }
                                        if (QLog.isColorLevel()) {
                                            QLog.d("SigImg2Zone", 4, "share img failure, share text only.");
                                        }
                                        r56 = 3;
                                        r85 = 0;
                                        QZoneHelper.publishPictureMoodSilently(optString5, r85, ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, r56);
                                        optString4 = r56;
                                        z27 = r85;
                                        return true;
                                    }
                                }
                                fileOutputStream = new FileOutputStream(this.SIGNATURE_SYNC_IMG_TEMP_FILE);
                                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                bufferedOutputStream.write(decode);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                fileOutputStream.close();
                                if (QLog.isColorLevel()) {
                                }
                                if (!FileUtils.fileExists(this.SIGNATURE_SYNC_IMG_TEMP_FILE)) {
                                }
                                if (QLog.isColorLevel()) {
                                }
                                z26 = false;
                                return z26 ? true : true;
                            } catch (Throwable th21) {
                                th = th21;
                            }
                        } else {
                            if (optString5 == null || optString5.isEmpty()) {
                                return true;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("SigImg2Zone", 4, "share only text 2 zone, content: " + optString5);
                            }
                            QZoneHelper.publishPictureMoodSilently(optString5, null, ShortVideoConstants.FORWARD_SOURCE_TO_QZONE, 3);
                            return true;
                        }
                    } else {
                        if ("getSyncTag".equals(str3)) {
                            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_signature_get_sync_tag", optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                            return true;
                        }
                        if ("clearLocationCache".equals(str3)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "clearLocationCache");
                            }
                            this.mCachePoiId = null;
                            super.callJs(optString, "{\"result\": 0}");
                            return true;
                        }
                        if ("getSignInfo".equals(str3)) {
                            this.mGetSigInfoCallback = optString;
                            if (SignatureManagerForTool.j().f282249c == null) {
                                QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.L, null, this.getSignatureCallback);
                                return true;
                            }
                            RichStatus richStatus = SignatureManagerForTool.j().f282249c;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bgId", richStatus.tplId);
                            jSONObject.put(MessageForRichState.SIGN_MSG_FONT_ID, richStatus.fontId);
                            jSONObject.put(MessageForRichState.SIGN_MSG_FONT_TYPE, richStatus.fontType);
                            jSONObject.put("actionId", richStatus.actionId);
                            if (!TextUtils.isEmpty(richStatus.actionText)) {
                                jSONObject.put("userText", richStatus.actionText);
                            } else {
                                jSONObject.put("userText", richStatus.getPlainText());
                            }
                            SignatureTemplateInfo l3 = SignatureManagerForTool.j().l(richStatus.tplId);
                            if (l3.isParsing.get()) {
                                ArrayList<RichStatus.StickerInfo> arrayList2 = richStatus.mStickerInfos;
                                if (arrayList2 != null && !arrayList2.isEmpty()) {
                                    i3 = 1;
                                }
                                i3 = 0;
                            } else {
                                i3 = l3.signType;
                            }
                            jSONObject.put(PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, i3);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("result", 0);
                            jSONObject2.put("data", jSONObject);
                            callJs(this.mGetSigInfoCallback, jSONObject2.toString());
                            if (!QLog.isColorLevel()) {
                                return true;
                            }
                            QLog.d(TAG, 2, "getSignature result exist = " + jSONObject2.toString());
                            return true;
                        }
                        if ("addOpenFontListener".equals(str3)) {
                            this.mOpenFontCallback = jsonFromJSBridge.optString("openFunctionName");
                            super.callJs(optString, "{\"result\": 0}");
                            return true;
                        }
                        if ("jumpIndex".equals(str3)) {
                            int optInt2 = jsonFromJSBridge.optInt("templateId", -1);
                            int optInt3 = jsonFromJSBridge.optInt(MessageForRichState.SIGN_MSG_FONT_ID, -1);
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("signUrl", jsonFromJSBridge.optString("url", ((IVasWebUrl) QRoute.api(IVasWebUrl.class)).getUrl(IndividuationUrlHelper.UrlId.SIGNATURE_EDIT)));
                            a33.b.f(this.mRuntime.a(), this.mRuntime.b(), 0, "signature_geqian", -1, optInt2, optInt3, bundle2);
                            super.callJs(optString, "{\"result\": 0}");
                            return true;
                        }
                        if ("contentChange".equals(str3)) {
                            this.mContentChangeCallback = jsonFromJSBridge.optString("changeFunctionName");
                            super.callJs(optString, "{\"result\": 0}");
                            return true;
                        }
                        if (!"selectTag".equals(str3)) {
                            return true;
                        }
                        int optInt4 = jsonFromJSBridge.optInt("tagID");
                        String optString6 = jsonFromJSBridge.optString("tagName");
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, String.format("jscall onTagSelected(%d,%s)", Integer.valueOf(optInt4), optString6));
                        }
                        this.mSelectTagId = optInt4;
                        this.mSelectTagText = optString6;
                        super.callJs(optString, "{\"result\": 0}");
                        return true;
                    }
                } catch (Throwable th22) {
                    th = th22;
                    th5 = th;
                    str6 = optString;
                    QLog.e(TAG, 2, "handleJsRequest exception url=" + str + ", pkgName=" + str2 + str5 + str3 + ", msg=" + th5.getMessage());
                    if (!TextUtils.isEmpty(str6)) {
                    }
                }
            } catch (Throwable th23) {
                th5 = th23;
                str4 = "{\"result\": -1}";
                str6 = optString;
                QLog.e(TAG, 2, "handleJsRequest exception url=" + str + ", pkgName=" + str2 + str5 + str3 + ", msg=" + th5.getMessage());
                if (!TextUtils.isEmpty(str6)) {
                    return true;
                }
                super.callJs(str6, str4);
                return true;
            }
        } catch (Throwable th24) {
            th = th24;
            str4 = "{\"result\": -1}";
            str5 = ", methodName=";
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (intent == null) {
            QLog.e(TAG, 1, "onActivityResult error no intent");
            return;
        }
        try {
            if (intent.getExtras() == null) {
                QLog.e(TAG, 1, "onActivityResult error no bundle");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            String str = "";
            if (b16 == 100) {
                String str2 = this.mLocationCallback;
                if (TextUtils.isEmpty(str2)) {
                    QLog.e(TAG, 1, "onActivityResult get_location error no callback");
                    return;
                }
                LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) intent.getParcelableExtra(QZoneHelper.INDEX_MOOD_SELECT_LOCATION_ITEM_SELECT_POI);
                if (poiInfo == null) {
                    QLog.e(TAG, 1, "onActivityResult request_location error no poiInfo");
                    jSONObject.put("result", 101);
                } else {
                    this.mCachePoiId = poiInfo.poiId;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getLocation poiId = " + this.mCachePoiId);
                    }
                    jSONObject.put("result", 0);
                    JSONObject jSONObject2 = new JSONObject();
                    if (!poiInfo.poiName.equals(HardCodeUtil.qqStr(R.string.tjk))) {
                        jSONObject2.put("location", poiInfo.poiName);
                    } else {
                        jSONObject2.put("location", "");
                    }
                    jSONObject.put("data", jSONObject2);
                }
                callJs(str2, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "request location result = " + jSONObject.toString());
                    return;
                }
                return;
            }
            if (b16 == 101) {
                String str3 = this.mActionCallback;
                if (TextUtils.isEmpty(str3)) {
                    QLog.e(TAG, 1, "onActivityResult get_action error no callback");
                    return;
                }
                long longExtra = intent.getLongExtra(PARAM_ACTION_ID, 0L);
                String stringExtra = intent.getStringExtra(PARAM_ACTION_TEXT);
                if (stringExtra == null) {
                    stringExtra = "";
                }
                long longExtra2 = intent.getLongExtra(PARAM_DATA_ID, 0L);
                String stringExtra2 = intent.getStringExtra(PARAM_DATA_TEXT);
                if (stringExtra2 != null) {
                    str = stringExtra2;
                }
                if (longExtra == 0) {
                    jSONObject.put("result", 101);
                    callJs(str3, jSONObject.toString());
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "request action result = " + jSONObject.toString());
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("actionId", Long.toString(longExtra));
                jSONObject4.put("actionText", stringExtra);
                jSONObject4.put("dataId", Long.toString(longExtra2));
                jSONObject4.put("dataText", str);
                jSONObject3.put("actionInfo", jSONObject4);
                jSONObject.put("result", 0);
                jSONObject.put("data", jSONObject3);
                callJs(str3, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "request action result = " + jSONObject.toString());
                }
            }
        } catch (OutOfMemoryError unused) {
            QLog.e(TAG, 1, "onActivityResult request_location fail OOM");
            if (!TextUtils.isEmpty(null)) {
                callJs(null, "{\"result\": -1}");
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "onActivityResult request_location fail: ", e16);
            if (!TextUtils.isEmpty(null)) {
                callJs(null, "{\"result\": -1}");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.mReqBundle = new Bundle();
        AppInterface b16 = this.mRuntime.b();
        if (b16 instanceof BrowserAppInterface) {
            this.browserApp = (BrowserAppInterface) b16;
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "ERROR!!! ChatFont market is not running in web process!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            try {
                Bundle bundle2 = bundle.getBundle("response");
                if (bundle2 == null) {
                    QLog.e(TAG, 1, "onResponse error no bundle");
                    super.callJs(string2, "{\"result\": -1}");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                if ("ipc_signature_setordelete".equals(string)) {
                    handleChangeStatusCallback(bundle2, string2);
                    return;
                }
                if ("ipc_signature_setlike".equals(string)) {
                    jSONObject.put("result", bundle2.getInt("result"));
                    super.callJs(string2, jSONObject.toString());
                    return;
                }
                if ("ipc_signature_get_sync_tag".equals(string)) {
                    boolean z16 = bundle2.getBoolean("isSync");
                    this.isSync = z16;
                    jSONObject.put("result", z16);
                    if (QLog.isColorLevel()) {
                        QLog.d("SigImg2Zone", 4, "isSync from onResponse: " + this.isSync);
                    }
                    super.callJs(string2, jSONObject.toString());
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onResponse error: ", e16);
                super.callJs(string2, "{\"result\": -1}");
            }
        }
    }
}
