package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.mobileqq.vas.webview.plugin.VasTransformUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.s;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class ChatFontJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "font";
    public static final int FONT_TYPE_FONT = 0;
    private static final String TAG = "ChatFontJsPlugin";
    private BrowserAppInterface browserApp;
    private boolean isUseFont;
    private HashMap<String, Integer> mFontSize;
    private Bundle mReqBundle;

    /* loaded from: classes20.dex */
    public static class FontPadding {
        public static final int PADDING_TYPE_HORIZANTAL = 1;
        public static final int PADDING_TYPE_VERTICAL = 2;
        public float fontSize;
        public float padding;
        public int paddingType;
    }

    private FontPadding calculateFontPadding(ETFont eTFont) {
        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        ETEngine.getInstance().native_getFontMetrics(fontMetrics, eTFont);
        float abs = Math.abs(fontMetrics.ascent) + fontMetrics.descent;
        FontPadding fontPadding = new FontPadding();
        if (abs > eTFont.getSize()) {
            fontPadding.paddingType = 1;
            fontPadding.fontSize = (eTFont.getSize() * eTFont.getSize()) / abs;
            fontPadding.padding = (eTFont.getSize() - fontPadding.fontSize) / 2.0f;
        } else {
            fontPadding.paddingType = 2;
            fontPadding.fontSize = eTFont.getSize();
            fontPadding.padding = (eTFont.getSize() - abs) / 2.0f;
        }
        return fontPadding;
    }

    private void checkDiyFontText(int i3, int i16, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkDiyFontText fail text is empty");
            }
            super.callJs(str2, "{\"ret\":-2}");
            return;
        }
        if (!ETEngine.getInstance().isEngineReady.get()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkDiyFontText fail engine not ready");
            }
            super.callJs(str2, "{\"ret\":-2}");
            return;
        }
        if (!FontManagerConstants.checkFontExist(i3, i16)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkDiyFontText fail font not exists id = " + i3);
            }
            super.callJs(str2, "{\"ret\":-2}");
            return;
        }
        ETFont eTFont = new ETFont(i3, FontManagerConstants.getTTFPath(i3, i16), 16.0f);
        if (!ETEngine.getInstance().native_diyFontIsDIYFont(eTFont)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkDiyFontText fail font is not diy font id = " + i3);
            }
            super.callJs(str2, "{\"ret\":-2}");
            return;
        }
        String str3 = "";
        for (int i17 = 0; i17 < str.length(); i17++) {
            char charAt = str.charAt(i17);
            if (charAt < '\u4e00' || charAt > '\u9fa5' || ETEngine.getInstance().native_diyFontGetCharIndex(str.charAt(i17), eTFont) == 0) {
                str3 = str3 + str.charAt(i17);
            }
        }
        if (TextUtils.isEmpty(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "checkDiyFontText all text valid");
            }
            super.callJs(str2, "{\"ret\":0}");
            return;
        }
        String str4 = "{\"ret\":-1,\"data\":{\"invalidText\":\"" + str3 + "\"}}";
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkDiyFontText result = " + str4);
        }
        super.callJs(str2, str4);
    }

    private void getDiyFontInfo(int i3, int i16, String str) {
        if (!ETEngine.getInstance().isEngineReady.get()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDiyFontInfo fail engine not ready");
            }
            super.callJs(str, "{\"ret\":-1}");
            return;
        }
        if (!FontManagerConstants.checkFontExist(i3, i16)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDiyFontInfo fail font not exists id = " + i3);
            }
            super.callJs(str, "{\"ret\":-1}");
            return;
        }
        ETFont eTFont = new ETFont(i3, FontManagerConstants.getTTFPath(i3, i16), 16.0f);
        if (!ETEngine.getInstance().native_diyFontIsDIYFont(eTFont)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDiyFontInfo fail font is not diy font id = " + i3);
            }
            super.callJs(str, "{\"ret\":-1}");
            return;
        }
        int native_diyFontGetUPEM = ETEngine.getInstance().native_diyFontGetUPEM(eTFont);
        if (native_diyFontGetUPEM <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDiyFontInfo get upem fail fontid = " + i3 + " upem = " + native_diyFontGetUPEM);
            }
            super.callJs(str, "{\"ret\":-1}");
            return;
        }
        eTFont.setSize(native_diyFontGetUPEM);
        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        ETEngine.getInstance().native_getFontMetrics(fontMetrics, eTFont);
        int abs = (int) (Math.abs(fontMetrics.ascent) + fontMetrics.descent);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("upem", native_diyFontGetUPEM);
            jSONObject2.put("height", abs);
            jSONObject.put("data", jSONObject2);
            super.callJs(str, jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDiyFontInfo result = " + jSONObject.toString());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 2, "getDiyFontInfo error: ", e16);
            super.callJs(str, "{\"ret\":-1}");
        }
    }

    private void searchFontInDir(File file, final JSONArray jSONArray) {
        if (file.exists() && file.isDirectory()) {
            file.listFiles(new FilenameFilter() { // from class: com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    File file3 = new File(file2.getAbsolutePath() + File.separatorChar + str);
                    if (file3.isDirectory()) {
                        file3.listFiles(new FilenameFilter() { // from class: com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.1.1
                            @Override // java.io.FilenameFilter
                            public boolean accept(File file4, String str2) {
                                if (str2.endsWith(".ttf")) {
                                    try {
                                        if (new File(file4.getAbsolutePath() + File.separatorChar + str2).exists()) {
                                            String[] split = file4.getAbsolutePath().split(File.separator);
                                            jSONArray.put(Integer.parseInt(split[split.length - 1]));
                                            return false;
                                        }
                                        return false;
                                    } catch (Exception e16) {
                                        QLog.e(ChatFontJsPlugin.TAG, 1, "updateFontList listFile error: " + e16.getMessage());
                                        return false;
                                    }
                                }
                                return false;
                            }
                        });
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    private void setFontSwitch(JSONObject jSONObject, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setFontSwitch:" + jSONObject);
        }
        try {
            int i3 = jSONObject.getInt("action");
            this.mReqBundle.clear();
            this.mReqBundle.putInt("action", i3);
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("setFontSwtich", str, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        } catch (JSONException e16) {
            e16.printStackTrace();
            super.callJs(str, e16.getMessage());
        }
    }

    void diyPreview(String str, int i3, int i16, String str2, String str3, int i17) {
        int i18;
        Bitmap createBitmap;
        JSONObject jSONObject;
        int i19;
        int i26;
        if (!ETEngine.getInstance().isEngineReady.get()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "diyPreview engine not ready");
            }
            tryInitHYEngine("0");
            super.callJs(str, "{\"ret\":-1}");
            return;
        }
        if (!TextUtils.isEmpty(str2) && i17 > 0) {
            if (!FontManagerConstants.checkFontExist(i3, i16)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "diyPreview font not exists");
                }
                super.callJs(str, "{\"ret\":-1}");
                startDownloadFont(i3, i16, "0", 0);
                return;
            }
            if (!ETEngine.getInstance().native_isFontLoaded(i3)) {
                ETEngine.getInstance().native_loadFont(FontManagerConstants.getTTFPath(i3, i16), i3, false);
            }
            int i27 = i17 * 2;
            ETFont eTFont = new ETFont(i3, FontManagerConstants.getTTFPath(i3, i16), i27);
            if (!ETEngine.getInstance().native_diyFontIsDIYFont(eTFont)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "checkDiyFontText fail font is not diy font id = " + i3);
                }
                super.callJs(str, "{\"ret\":-1}");
                return;
            }
            FontPadding calculateFontPadding = calculateFontPadding(eTFont);
            eTFont.setSize(calculateFontPadding.fontSize);
            eTFont.parseDIYJsonString(str3);
            int length = str2.length();
            int i28 = 1;
            try {
                createBitmap = Bitmap.createBitmap(i27 * length, i27, Bitmap.Config.ARGB_8888);
                int i29 = 0;
                while (i29 < length) {
                    int i36 = i27 * i29;
                    int i37 = calculateFontPadding.paddingType;
                    if (i37 == i28) {
                        i19 = (int) (i36 + calculateFontPadding.padding);
                    } else if (i37 == 2) {
                        try {
                            i26 = (int) (0 + calculateFontPadding.padding);
                            i19 = i36;
                            int i38 = i29 + 1;
                            ETEngine.getInstance().native_drawText(str2.substring(i29, i38), createBitmap, i19, i26, eTFont);
                            i29 = i38;
                            i28 = 1;
                        } catch (Exception unused) {
                            i18 = 1;
                            QLog.e(TAG, i18, "diyPreview createBitmap OOM");
                            super.callJs(str, "{\"ret\":-1}");
                            ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
                            return;
                        } catch (OutOfMemoryError unused2) {
                            i18 = 1;
                            QLog.e(TAG, i18, "diyPreview createBitmap OOM");
                            super.callJs(str, "{\"ret\":-1}");
                            ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
                            return;
                        }
                    } else {
                        i19 = i36;
                    }
                    i26 = 0;
                    int i382 = i29 + 1;
                    ETEngine.getInstance().native_drawText(str2.substring(i29, i382), createBitmap, i19, i26, eTFont);
                    i29 = i382;
                    i28 = 1;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("img", encodeToString);
                jSONObject2.put("width", createBitmap.getWidth());
                jSONObject2.put("height", createBitmap.getHeight());
                jSONObject.put("data", jSONObject2);
                jSONObject.put("ret", 0);
                i18 = 1;
            } catch (Exception unused3) {
                i18 = i28;
            } catch (OutOfMemoryError unused4) {
                i18 = i28;
            }
            try {
                super.callJs(str, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "diyPreview result = " + jSONObject.toString());
                }
                createBitmap.recycle();
            } catch (Exception unused5) {
                QLog.e(TAG, i18, "diyPreview createBitmap OOM");
                super.callJs(str, "{\"ret\":-1}");
                ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
                return;
            } catch (OutOfMemoryError unused6) {
                QLog.e(TAG, i18, "diyPreview createBitmap OOM");
                super.callJs(str, "{\"ret\":-1}");
                ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
                return;
            }
            ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
            return;
        }
        super.callJs(str, "{\"ret\":-1}");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "diyPreview text = " + str2 + " fontsize = " + i17);
        }
    }

    void getFontPreview(String str, int i3, int i16, String str2, String str3, int i17, String str4) {
        int parseColor;
        int i18;
        Bitmap createBitmap;
        JSONObject jSONObject;
        int i19;
        int i26;
        if (!ETEngine.getInstance().isEngineReady.get()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "diyPreview engine not ready");
            }
            tryInitHYEngine("0");
            super.callJs(str, "{\"ret\":-1,\"msg\":\"font engine not ready.\"}");
            return;
        }
        int i27 = 1;
        if (!TextUtils.isEmpty(str2) && i17 > 0) {
            int applyDimension = (int) (TypedValue.applyDimension(2, i17, this.browserApp.getApp().getResources().getDisplayMetrics()) / 2.0f);
            if (!FontManagerConstants.checkFontExist(i3, i16)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "diyPreview font not exists");
                }
                super.callJs(str, "{\"ret\":-3,\"msg\":\"this font need download.\"}");
                startDownloadFont(i3, i16, "0", 0);
                return;
            }
            if (!TextUtils.isEmpty(str4)) {
                try {
                    parseColor = Color.parseColor(str4);
                } catch (Exception unused) {
                    super.callJs(str, "{\"ret\":-4,\"msg\":\"color is illegal:" + str4 + "\"}");
                    return;
                }
            } else {
                parseColor = -16777216;
            }
            if (!ETEngine.getInstance().native_isFontLoaded(i3)) {
                ETEngine.getInstance().native_loadFont(FontManagerConstants.getTTFPath(i3, i16), i3, false);
            }
            ETFont eTFont = new ETFont(i3, FontManagerConstants.getTTFPath(i3, i16), applyDimension);
            FontPadding calculateFontPadding = calculateFontPadding(eTFont);
            eTFont.setSize(calculateFontPadding.fontSize);
            eTFont.setColor(parseColor);
            eTFont.parseDIYJsonString(str3);
            int length = str2.length();
            try {
                createBitmap = Bitmap.createBitmap(applyDimension * length, applyDimension, Bitmap.Config.ARGB_8888);
                int i28 = 0;
                while (i28 < length) {
                    int i29 = applyDimension * i28;
                    int i36 = calculateFontPadding.paddingType;
                    if (i36 == i27) {
                        i19 = (int) (i29 + calculateFontPadding.padding);
                    } else if (i36 == 2) {
                        try {
                            i26 = (int) (0 + calculateFontPadding.padding);
                            i19 = i29;
                            int i37 = i28 + 1;
                            ETEngine.getInstance().native_drawText(str2.substring(i28, i37), createBitmap, i19, i26, eTFont);
                            i28 = i37;
                            i27 = 1;
                        } catch (Exception unused2) {
                            i18 = 1;
                            QLog.e(TAG, i18, "diyPreview createBitmap OOM");
                            super.callJs(str, "{\"ret\":-1}");
                            ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
                            return;
                        } catch (OutOfMemoryError unused3) {
                            i18 = 1;
                            QLog.e(TAG, i18, "diyPreview createBitmap OOM");
                            super.callJs(str, "{\"ret\":-1}");
                            ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
                            return;
                        }
                    } else {
                        i19 = i29;
                    }
                    i26 = 0;
                    int i372 = i28 + 1;
                    ETEngine.getInstance().native_drawText(str2.substring(i28, i372), createBitmap, i19, i26, eTFont);
                    i28 = i372;
                    i27 = 1;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("img", encodeToString);
                jSONObject2.put("width", createBitmap.getWidth());
                jSONObject2.put("height", createBitmap.getHeight());
                jSONObject.put("data", jSONObject2);
                jSONObject.put("ret", 0);
                i18 = 1;
            } catch (Exception unused4) {
                i18 = i27;
            } catch (OutOfMemoryError unused5) {
                i18 = i27;
            }
            try {
                String[] strArr = new String[1];
                strArr[0] = jSONObject.toString();
                super.callJs(str, strArr);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "diyPreview result = " + jSONObject.toString());
                }
                createBitmap.recycle();
            } catch (Exception unused6) {
                QLog.e(TAG, i18, "diyPreview createBitmap OOM");
                super.callJs(str, "{\"ret\":-1}");
                ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
                return;
            } catch (OutOfMemoryError unused7) {
                QLog.e(TAG, i18, "diyPreview createBitmap OOM");
                super.callJs(str, "{\"ret\":-1}");
                ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
                return;
            }
            ETEngine.getInstance().native_diyFontDeleteNativeConfig(eTFont.mDiyHandle);
            return;
        }
        super.callJs(str, "{\"ret\":-2,\"msg\":\"illegal fontSize= " + i17 + " text=" + str2 + "\"}");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "diyPreview text = " + str2 + " fontsize = " + i17);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "font";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2147487744L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str != null && "font".equals(str2) && str3 != null) {
            JSONObject jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge == null) {
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
            }
            int optInt = jsonFromJSBridge.optInt("id");
            int optInt2 = jsonFromJSBridge.optInt("type");
            int optInt3 = jsonFromJSBridge.optInt(MessageForRichState.SIGN_MSG_FONT_TYPE);
            String optString = jsonFromJSBridge.optString("callback");
            this.mReqBundle.clear();
            VasCommonReporter.getHistoryJsbFeature(getNameSpace()).setValue2(str3).report();
            if ("queryLocal".equals(str3)) {
                queryLocal(jsonFromJSBridge, optString);
                return true;
            }
            if ("setSize".equals(str3)) {
                setSize(jsonFromJSBridge, optString);
                return true;
            }
            if (GameCenterAPIJavaScript.QUERY_INFO.equals(str3)) {
                if (optInt == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("status", 3);
                        jSONObject2.put("progress", 100);
                        jSONObject.put("result", 0);
                        jSONObject.put("message", HardCodeUtil.qqStr(R.string.f171712kd0));
                        super.callJs(optString, jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }
                if (this.proxy != null) {
                    if (optInt3 == 0) {
                        super.callJs(optString, VasTransformUtils.INSTANCE.transformFont(optInt, this.proxy.queryInfo(jsonFromJSBridge.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), optInt, QQVasUpdateBusiness.getBusiness(FontBusiness.class))));
                        return true;
                    }
                    QLog.e(TAG, 1, "hiboom is error");
                }
                str4 = "queryFontInfo";
            } else if (ColorRingJsPlugin.Method_SetUp.equals(str3)) {
                VasLogReporter.getFont().reportHighest("web set - fontId:" + optInt + "+fontType:" + optInt2);
                if (this.proxy != null) {
                    this.proxy.fontSetUp(jsonFromJSBridge.optString(VasCommonJsbProxy.JSON_KEY_SET_KEY), optInt, optInt2);
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("result", 0);
                        jSONObject3.put("message", "success");
                        i3 = 1;
                        try {
                            super.callJs(optString, jSONObject3.toString());
                            return true;
                        } catch (JSONException unused2) {
                            QLog.e(TAG, i3, "setup parse error");
                            str4 = "setupChatFont";
                            this.mReqBundle.putInt("id", optInt);
                            this.mReqBundle.putInt("type", optInt2);
                            this.mReqBundle.putInt("fontOrhiboom", optInt3);
                            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str4, optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                            return true;
                        }
                    } catch (JSONException unused3) {
                        i3 = 1;
                    }
                }
                str4 = "setupChatFont";
            } else {
                if ("startDownload".equals(str3)) {
                    VasLogReporter.getFont().reportHighest("web requestDownload - fontId:" + optInt + "+fontType:" + optInt2);
                    startDownloadFont(optInt, optInt2, optString, optInt3);
                    return true;
                }
                if ("stopDownload".equals(str3)) {
                    if (optInt3 != 0) {
                        str4 = null;
                    } else {
                        str4 = "font_StopDownLoad";
                    }
                } else {
                    if ("showBlackMsgBox".equals(str3)) {
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            String string = jsonFromJSBridge.getString("msg");
                            s g16 = this.mRuntime.g();
                            if (g16 != null && g16.getWebTitleBarInterface() != null) {
                                QQToast.makeText(this.mRuntime.a(), string, 0).show(g16.getWebTitleBarInterface().getTitleBarHeight());
                            }
                        } catch (JSONException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "showBlackMsgBox failed: " + e16.getMessage());
                            }
                        }
                        super.callJs(optString, jSONObject4.toString());
                        return true;
                    }
                    if ("isUseFont".equals(str3)) {
                        isUseFont(optString);
                        return true;
                    }
                    if ("setFontSwitch".equals(str3)) {
                        setFontSwitch(jsonFromJSBridge, optString);
                        return true;
                    }
                    if ("setMagicFont".equals(str3)) {
                        this.mReqBundle.putInt("magic_setup", jsonFromJSBridge.optInt(ColorRingJsPlugin.Method_SetUp));
                        str4 = "setupMagicFont";
                    } else if ("isSupportFounderColorFont".equals(str3)) {
                        str4 = "isSupportFounderColorFont";
                    } else {
                        if ("initEngine".equals(str3)) {
                            tryInitHYEngine(optString);
                            return true;
                        }
                        if ("getFontPreview".equals(str3)) {
                            getFontPreview(optString, optInt, jsonFromJSBridge.optInt("type"), jsonFromJSBridge.optString(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR), jsonFromJSBridge.optString(DownloadInfo.spKey_Config), jsonFromJSBridge.optInt("fontSize"), jsonFromJSBridge.optString("color"));
                            return true;
                        }
                        if ("diyPreview".equals(str3)) {
                            diyPreview(optString, optInt, 1, jsonFromJSBridge.optString(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR), jsonFromJSBridge.optString(DownloadInfo.spKey_Config), jsonFromJSBridge.optInt("fontSize"));
                            return true;
                        }
                        if ("checkText".equals(str3)) {
                            checkDiyFontText(optInt, optInt2, jsonFromJSBridge.optString("text"), optString);
                            return true;
                        }
                        if ("getFontInfo".equals(str3)) {
                            getDiyFontInfo(optInt, optInt2, optString);
                            return true;
                        }
                        if ("setMagicFontType".equals(str3)) {
                            int optInt4 = jsonFromJSBridge.optInt("id");
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "fontEffectId: " + optInt4);
                            }
                            this.mReqBundle.putInt("fontEffectId", optInt4);
                            str4 = "setupFontEffect";
                        } else if ("isSysFont".equals(str3)) {
                            str4 = "ipc_is_sys_font";
                        } else if ("setSysFont".equals(str3)) {
                            this.mReqBundle.putInt("sysfont", jsonFromJSBridge.optInt("sysfont", -1));
                            str4 = "ipc_set_sys_font";
                        } else if ("hasSysColorFont".equals(str3)) {
                            str4 = "ipc_has_sys_color_font";
                        } else {
                            if ("fontBubblePaySuccess".equals(str3)) {
                                this.mReqBundle.putInt("id", optInt);
                                this.mReqBundle.putInt("sid", jsonFromJSBridge.optInt("sid"));
                                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("fontBubblePaySuccess", optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                                return true;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.w(TAG, 2, "NOT support method " + str3 + " yet!!");
                                return false;
                            }
                            return false;
                        }
                    }
                }
            }
            this.mReqBundle.putInt("id", optInt);
            this.mReqBundle.putInt("type", optInt2);
            this.mReqBundle.putInt("fontOrhiboom", optInt3);
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a(str4, optString, this.mOnRemoteResp.key, this.mReqBundle), false, true);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
    
        if (r1 != 1) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void initHYEngine(String str) {
        boolean z16;
        int loadLibrary = VasSoUtils.loadLibrary(VasSoUtils.getSoDir(1), FontSoBusiness.HY_FONT_SO_NAME);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initHYEngine result = " + loadLibrary);
        }
        int i3 = -1;
        if (loadLibrary == 0) {
            ETEngine.isSOLoaded.set(true);
            try {
                z16 = ETEngine.getInstance().initEngine(20, 8388608);
            } catch (Exception unused) {
                QLog.e(TAG, 1, "initHYEngine fail");
                z16 = false;
            }
            if (z16) {
                ETEngine.getInstance().isEngineReady.set(true);
                i3 = 0;
            }
        }
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            super.callJs(str, "{\"ret\":" + i3 + "}");
        }
    }

    public void isUseFont(final String str) {
        boolean z16;
        boolean z17 = this.mRuntime.a().getSharedPreferences(FontManagerConstants.FONT_OPEN_SWITCH, 4).getBoolean(FontManagerConstants.ISUSEROPENFONTSWITCH + this.mRuntime.b().getAccount(), false);
        boolean isFeatureSupported = ((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.chat_font.name());
        if (!z17 && !isFeatureSupported) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isUseFont = z16;
        final JSONObject jSONObject = new JSONObject();
        if (!this.isUseFont) {
            QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this.mRuntime.a(), 230).setTitle(this.mRuntime.a().getString(R.string.i1h)).setMessage(this.mRuntime.a().getString(R.string.cxw)).setPositiveButton(this.mRuntime.a().getString(R.string.cxx), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    try {
                        jSONObject.put("selectbutton", 1);
                        jSONObject.put("isUse", 0);
                        ChatFontJsPlugin.this.callJs(str, jSONObject.toString());
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        ChatFontJsPlugin.this.callJs(str, e16.getMessage());
                    }
                }
            }).setNegativeButton(this.mRuntime.a().getString(R.string.cxs), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    try {
                        jSONObject.put("selectbutton", 0);
                        jSONObject.put("isUse", 0);
                        ChatFontJsPlugin.this.callJs(str, jSONObject.toString());
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        ChatFontJsPlugin.this.callJs(str, e16.getMessage());
                    }
                }
            });
            negativeButton.show();
            negativeButton.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin.4
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    try {
                        jSONObject.put("isUse", 0);
                        jSONObject.put("selectbutton", -1);
                        ChatFontJsPlugin.this.callJs(str, jSONObject.toString());
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                        ChatFontJsPlugin.this.callJs(str, e16.getMessage());
                    }
                }
            });
        } else {
            try {
                jSONObject.put("isUse", 1);
                callJs(str, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
                callJs(str, e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        AppInterface b16 = this.mRuntime.b();
        if (b16 instanceof BrowserAppInterface) {
            this.browserApp = (BrowserAppInterface) b16;
        } else if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "ERROR!!! ChatFont market is not running in web process!");
        }
        this.mReqBundle = new Bundle();
        HashMap<String, Integer> hashMap = new HashMap<>(4);
        this.mFontSize = hashMap;
        hashMap.put(NtFaceConstant.SMALL, 0);
        this.mFontSize.put("middle", 1);
        this.mFontSize.put("big", 2);
        this.mFontSize.put("bigger", 3);
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onPushMsg(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onPushMsg=" + bundle);
        }
        int i3 = bundle.getInt("srcType");
        if (i3 == 2) {
            int i16 = bundle.getInt("id");
            int i17 = bundle.getInt("result");
            String string = bundle.getString("callbackId");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onPushMsg DOWNLOAD_FONT_PKG id = " + i16 + " result = " + i17 + " callbackId = " + string);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", i16);
                jSONObject.put("result", i17);
            } catch (JSONException unused) {
            }
            super.callJs(string, jSONObject.toString());
            return;
        }
        if (i3 == 9) {
            int i18 = bundle.getInt("result");
            String string2 = bundle.getString("callbackId");
            initHYEngine(string2);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onPushMsg DOWN_HY_SO result = " + i18 + " callbackId = " + string2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            JSONObject jSONObject = new JSONObject();
            try {
                bundle2 = bundle.getBundle("response");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "Failed to handle cmd " + string + ", exception: " + e16.getMessage());
                }
            }
            if ("setupChatFont".equals(string)) {
                jSONObject.put("result", bundle2.getInt("result"));
                jSONObject.put("message", bundle2.getString("message"));
                super.callJs(string2, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResponse cmd = " + string + " Result = " + jSONObject.toString());
                    return;
                }
                return;
            }
            if ("queryFontInfo".equals(string)) {
                String string3 = bundle2.getString("result");
                super.callJs(string2, string3);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResponse cmd = " + string + " Result = " + string3);
                    return;
                }
                return;
            }
            if ("font_StopDownLoad".equals(string)) {
                jSONObject.put("result", 0);
                super.callJs(string2, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResponse cmd = " + string + " Result = " + jSONObject.toString());
                    return;
                }
                return;
            }
            if ("setFontSwtich".equals(string)) {
                jSONObject.put("result", 0);
                super.callJs(string2, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResponse cmd = " + string + " Result = " + jSONObject.toString());
                    return;
                }
                return;
            }
            if ("setupMagicFont".equals(string)) {
                jSONObject.put("result", 0);
                super.callJs(string2, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResponse cmd = " + string + " Result = " + jSONObject.toString());
                    return;
                }
                return;
            }
            if ("setupFontEffect".equals(string)) {
                jSONObject.put("ret", bundle.getInt("ret"));
                jSONObject.put("msg", bundle.getString("msg"));
                super.callJs(string2, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResponse cmd = " + string + " Result = " + jSONObject.toString());
                    return;
                }
                return;
            }
            if ("isSupportFounderColorFont".equals(string)) {
                int i3 = bundle2.getInt("result", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isSupport", i3);
                jSONObject.put("result", 0);
                jSONObject.put("data", jSONObject2);
                super.callJs(string2, jSONObject.toString());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResponse cmd = " + string + " result = " + jSONObject.toString());
                    return;
                }
                return;
            }
            if ("font_startDownLoad".equals(string)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onResponse download font");
                    return;
                }
                return;
            }
            if ("ipc_is_sys_font".equals(string)) {
                int i16 = bundle2.getInt("isSysFont", -1);
                if (i16 < 0) {
                    jSONObject.put("ret", -1);
                } else {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("isSysFont", i16);
                    jSONObject.put("data", jSONObject3);
                    jSONObject.put("ret", 0);
                }
            } else if ("ipc_set_sys_font".equals(string)) {
                jSONObject.put("ret", bundle2.getInt("ret", -1));
            } else if ("ipc_has_sys_color_font".equals(string)) {
                int i17 = bundle2.getInt("hasColor", -1);
                if (i17 == -1) {
                    jSONObject.put("ret", -1);
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("hasColor", i17);
                    jSONObject.put("data", jSONObject4);
                    jSONObject.put("ret", 0);
                }
            }
            super.callJs(string2, jSONObject.toString());
        }
    }

    public void queryLocal(JSONObject jSONObject, String str) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "queryLocal:" + jSONObject);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.browserApp.getAccount()), TAG);
            jSONObject2.put("result", 0);
            if (vasSimpleInfoWithUid == null) {
                jSONObject2.put("currentId", 0);
            } else {
                jSONObject2.put("currentId", vasSimpleInfoWithUid.uVipFont);
            }
            int i3 = BaseApplication.getContext().getSharedPreferences("setting_text_size", 4).getInt("chat_text_size_type", 0);
            String str2 = NtFaceConstant.SMALL;
            for (String str3 : this.mFontSize.keySet()) {
                if (this.mFontSize.get(str3).intValue() == i3) {
                    str2 = str3;
                }
            }
            jSONObject2.put("currentSize", str2);
            boolean z17 = this.mRuntime.a().getSharedPreferences(FontManagerConstants.FONT_OPEN_SWITCH, 4).getBoolean(FontManagerConstants.ISUSEROPENFONTSWITCH + this.mRuntime.b().getAccount(), false);
            boolean isFeatureSupported = ((IDPCApi) QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.chat_font.name());
            if (!z17 && !isFeatureSupported) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                jSONObject2.put(h.f248218g, 1);
            } else {
                jSONObject2.put(h.f248218g, 0);
            }
            File file = new File(FontBusiness.FONT_DOWN_LOAD_PATH_NEW);
            JSONArray jSONArray = new JSONArray();
            searchFontInDir(file, jSONArray);
            searchFontInDir(new File(FontManagerConstants.FONT_FZ_COMPATIBLE_DIR), jSONArray);
            jSONObject2.put("downloadedList", jSONArray);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, jSONObject2.toString());
            }
            super.callJs(str, jSONObject2.toString());
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getFontId failed: " + e16.getMessage());
            }
            super.callJs(str, e16.getMessage());
        }
    }

    public void setSize(JSONObject jSONObject, String str) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setSize:" + jSONObject);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            String string = jSONObject.getString("size");
            ReportController.r(null, "CliOper", "", "", "Font_Mall", "change_" + string, 0, 0, "", "", "", "");
            if (this.mFontSize.containsKey(string)) {
                i3 = this.mFontSize.get(string).intValue();
                jSONObject2.put("result", 0);
            } else {
                jSONObject2.put("result", -1);
                jSONObject2.put("message", "size illege");
                super.callJs(str, jSONObject2.toString());
                i3 = 0;
            }
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("setting_text_size", 4).edit();
            edit.putInt("chat_text_size_type", i3);
            edit.commit();
            jSONObject2.put("message", "success");
            super.callJs(str, jSONObject2.toString());
        } catch (Exception unused) {
        }
    }

    void startDownloadFont(int i3, int i16, String str, int i17) {
        if (i17 == 0) {
            this.mReqBundle.putInt("id", i3);
            this.mReqBundle.putInt("type", i16);
            super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("font_startDownLoad", str, this.mOnRemoteResp.key, this.mReqBundle), false, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        if (r0 != 2) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void tryInitHYEngine(String str) {
        boolean z16;
        if (ETEngine.getInstance().isEngineReady.get()) {
            super.callJs(str, "{\"ret\":0}");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "tryInitHYEngine engine is ready");
                return;
            }
            return;
        }
        if (ETEngine.getInstance().isEngineInited.get()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "tryInitHYEngine has inited");
                return;
            }
            return;
        }
        ETEngine.getInstance().isEngineInited.set(true);
        int loadLibrary = VasSoUtils.loadLibrary(VasSoUtils.getSoDir(1), FontSoBusiness.HY_FONT_SO_NAME);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "tryInitHYEngine loadSoResult = " + loadLibrary);
        }
        int i3 = -1;
        if (loadLibrary != 0) {
            if (loadLibrary == 1) {
                super.sendRemoteReq(com.tencent.mobileqq.emosm.a.a("ipc_font_download_hy_so", str, this.mOnRemoteResp.key, this.mReqBundle), false, true);
                return;
            }
        } else {
            ETEngine.isSOLoaded.set(true);
            try {
                z16 = ETEngine.getInstance().initEngine(20, 8388608);
            } catch (Exception unused) {
                QLog.e(TAG, 1, "tryInitHYEngine fail");
                z16 = false;
            }
            if (z16) {
                ETEngine.getInstance().isEngineReady.set(true);
                i3 = 0;
            }
        }
        String str2 = "{\"ret\":" + i3 + "}";
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            super.callJs(str, str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initEngine result = " + str2);
        }
    }
}
