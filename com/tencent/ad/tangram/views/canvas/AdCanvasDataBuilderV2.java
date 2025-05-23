package com.tencent.ad.tangram.views.canvas;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.json.AdJSONArrayUtil;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.canvas.AdAnalysisHelperForCanvas;
import com.tencent.ad.tangram.statistics.canvas.AdReport;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.ad.tangram.views.ImageLoadParams;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;
import com.tencent.ad.tangram.views.canvas.components.appicon.AdCanvasAppIconComponentData;
import com.tencent.ad.tangram.views.canvas.components.appinfobutton.AdCanvasAppInfoButtonComponentData;
import com.tencent.ad.tangram.views.canvas.components.fixedbutton.AdCanvasFixedButtonComponentData;
import com.tencent.ad.tangram.views.canvas.components.imagescarousel.AdCanvasImagesCarouselComponentData;
import com.tencent.ad.tangram.views.canvas.components.layercard.AdCanvasLayerCardData;
import com.tencent.ad.tangram.views.canvas.components.picture.AdCanvasPictureComponentData;
import com.tencent.ad.tangram.views.canvas.components.pictures.AdCanvasMultiPictureComponentData;
import com.tencent.ad.tangram.views.canvas.components.pictures.HotArea;
import com.tencent.ad.tangram.views.canvas.components.text.AdCanvasTextComponentData;
import com.tencent.ad.tangram.views.canvas.components.title.AdCanvasTitleComponentData;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasPageData;
import com.tencent.ad.tangram.views.xijing.AdButtonData;
import com.tencent.ad.tangram.views.xijing.AdTextData;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.vivo.push.PushClientConstants;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdCanvasDataBuilderV2 {
    private static final String TAG = "AdCanvasDataBuilderV2";

    @Nullable
    private static ImageLoadParams imageLoadParams;

    @Nullable
    public static AdCanvasData build(@NonNull Context context, @Nullable Ad ad5, String str, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = true;
        if (ad5 == null) {
            AdLog.e(TAG, "build error");
            AdReport.getInstance().reportForCanvasDataBuildError(context, 1, null, null);
            AdAnalysisHelperForCanvas.reportForCanvasDataBuildError(context, null, String.valueOf(1));
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            AdLog.e(TAG, "build error");
            AdReport.getInstance().reportForCanvasDataBuildError(context, 2, ad5, null);
            AdAnalysisHelperForCanvas.reportForCanvasDataBuildError(context, ad5, String.valueOf(2));
            return null;
        }
        AdLog.i(TAG, "build " + str);
        try {
            AdCanvasData canvasData = getCanvasData(context, ad5, new JSONObject(str), z16);
            setActiveAppBtnView(canvasData);
            AdReport.getInstance().reportForCanvasDataBuildEnd(context, ad5, System.currentTimeMillis() - currentTimeMillis);
            if (canvasData == null || !canvasData.isValid()) {
                z17 = false;
            }
            AdAnalysisHelperForCanvas.reportForCanvasDataBuildEnd(context, ad5, z17, System.currentTimeMillis() - currentTimeMillis);
            return canvasData;
        } catch (Throwable th5) {
            AdLog.e(TAG, "build error", th5);
            return null;
        }
    }

    @Nullable
    private static AdCanvasAppBtnComponentData getAppButtonComponent(Context context, @NonNull JSONObject jSONObject, int i3) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getAppButtonComponent error");
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
        AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = new AdCanvasAppBtnComponentData();
        initComponent(jSONObject, i3, adCanvasAppBtnComponentData);
        adCanvasAppBtnComponentData.button.text.text = unescapeHtml(jSONObject2.getJSONObject("content").getString("text"));
        if (!adCanvasAppBtnComponentData.button.text.text.contains("\u4e0b\u8f7d")) {
            adCanvasAppBtnComponentData.button.text.text = "\u4e0b\u8f7dAPP";
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject("style");
        adCanvasAppBtnComponentData.button.text.color = getColor(jSONObject3.getString("color"));
        adCanvasAppBtnComponentData.button.backgroundColor = getColor(jSONObject3.getString("backgroundColor"));
        adCanvasAppBtnComponentData.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject3.getInt(NodeProps.BORDER_RADIUS));
        adCanvasAppBtnComponentData.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject3.getInt("fontSize"));
        int i16 = jSONObject3.getInt("width");
        adCanvasAppBtnComponentData.height = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject3.getInt(NodeProps.LINE_HEIGHT));
        JSONObject jSONObject4 = jSONObject2.getJSONObject("wrapper");
        String string = jSONObject4.getString("textAlign");
        if (TextUtils.equals(string, "center")) {
            adCanvasAppBtnComponentData.gravity = 17;
        } else if (TextUtils.equals(string, "left")) {
            adCanvasAppBtnComponentData.gravity = 3;
        } else if (TextUtils.equals(string, "right")) {
            adCanvasAppBtnComponentData.gravity = 5;
        } else {
            throw new Exception("unknow button align");
        }
        adCanvasAppBtnComponentData.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_LEFT));
        adCanvasAppBtnComponentData.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_RIGHT));
        adCanvasAppBtnComponentData.width = (((AdUIUtils.getPhysicalScreenWidth(context) - adCanvasAppBtnComponentData.paddingLeft) - adCanvasAppBtnComponentData.paddingRight) * i16) / 100;
        adCanvasAppBtnComponentData.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_TOP));
        adCanvasAppBtnComponentData.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_BOTTOM));
        boolean z16 = jSONObject2.getBoolean("isFixed");
        adCanvasAppBtnComponentData.isFixed = z16;
        if (z16) {
            JSONObject jSONObject5 = jSONObject2.getJSONObject("position");
            adCanvasAppBtnComponentData.toBottom = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject5.getInt("toBottom"));
            adCanvasAppBtnComponentData.whiteSpace = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject5.getInt("whiteSpace"));
        }
        ImageLoadParams imageLoadParams2 = imageLoadParams;
        if (imageLoadParams2 != null) {
            imageLoadParams2.currentLength += adCanvasAppBtnComponentData.paddingBottom + adCanvasAppBtnComponentData.paddingTop + adCanvasAppBtnComponentData.height;
        }
        return adCanvasAppBtnComponentData;
    }

    @Nullable
    private static AdCanvasComponentData getAppIconComponent(Context context, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getAppIconComponent error");
            return null;
        }
        AdCanvasAppIconComponentData adCanvasAppIconComponentData = new AdCanvasAppIconComponentData();
        initComponent(jSONObject, adCanvasData.basicWidth, adCanvasAppIconComponentData);
        JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("appInfo");
        JSONObject jSONObject4 = jSONObject2.getJSONObject("wrapper");
        int i3 = adCanvasData.basicWidth;
        adCanvasAppIconComponentData.logoWidth = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 64);
        adCanvasAppIconComponentData.logoHeight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 64);
        adCanvasAppIconComponentData.logoUrl = jSONObject3.getString("logoUrl");
        adCanvasAppIconComponentData.name = jSONObject3.getString("name");
        adCanvasAppIconComponentData.downloadCount = jSONObject3.optLong("downloadCount");
        adCanvasAppIconComponentData.fileSize = jSONObject3.getLong("fileSize");
        if (jSONObject3.isNull("starCount")) {
            adCanvasAppIconComponentData.starCount = 4;
        } else {
            adCanvasAppIconComponentData.starCount = jSONObject3.getInt("starCount");
        }
        adCanvasAppIconComponentData.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_LEFT));
        adCanvasAppIconComponentData.marginTop = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_TOP));
        adCanvasAppIconComponentData.marginRight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_RIGHT));
        adCanvasAppIconComponentData.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_BOTTOM));
        AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = new AdCanvasAppBtnComponentData();
        adCanvasAppBtnComponentData.f61339id = "XJAppIcon_AppBtn_" + adCanvasAppIconComponentData.logoUrl.hashCode();
        adCanvasAppBtnComponentData.width = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 71);
        adCanvasAppBtnComponentData.height = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 36);
        adCanvasAppBtnComponentData.fontColor = -1;
        adCanvasAppBtnComponentData.gravity = 17;
        adCanvasAppBtnComponentData.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 17);
        AdTextData adTextData = adCanvasAppBtnComponentData.button.text;
        adTextData.text = "\u4e0b\u8f7d";
        adTextData.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 16);
        AdButtonData adButtonData = adCanvasAppBtnComponentData.button;
        adButtonData.text.color = -1;
        adButtonData.backgroundColor = getColor("#20A0FF");
        adCanvasAppIconComponentData.adCanvasAppBtnComponentData = adCanvasAppBtnComponentData;
        ImageLoadParams imageLoadParams2 = imageLoadParams;
        if (imageLoadParams2 != null) {
            imageLoadParams2.currentLength += adCanvasAppIconComponentData.logoHeight + adCanvasAppIconComponentData.marginBottom + adCanvasAppIconComponentData.marginTop;
        }
        return adCanvasAppIconComponentData;
    }

    @Nullable
    private static AdCanvasAppInfoButtonComponentData getAppInfoButtonComponent(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getAppInfoButtonComponent error");
            return null;
        }
        AdCanvasAppInfoButtonComponentData adCanvasAppInfoButtonComponentData = new AdCanvasAppInfoButtonComponentData();
        initComponent(jSONObject, adCanvasData.basicWidth, adCanvasAppInfoButtonComponentData);
        JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("appInfo");
        JSONObject jSONObject4 = jSONObject2.getJSONObject("style");
        JSONObject jSONObject5 = jSONObject2.getJSONObject("content");
        int i3 = adCanvasData.basicWidth;
        adCanvasAppInfoButtonComponentData.downloadCount = jSONObject3.optLong("downloadCount");
        adCanvasAppInfoButtonComponentData.logoUrl = jSONObject3.getString("logoUrl");
        adCanvasAppInfoButtonComponentData.appName = jSONObject3.getString("name");
        adCanvasAppInfoButtonComponentData.fileSize = jSONObject3.getLong("fileSize");
        adCanvasAppInfoButtonComponentData.desc = unescapeHtml(jSONObject5.getString("text"));
        adCanvasAppInfoButtonComponentData.backgroundColor = getColor(jSONObject2.getString("backgroundColor"));
        adCanvasAppInfoButtonComponentData.button.backgroundColor = getColor(jSONObject4.getString("backgroundColor"));
        AdTextData adTextData = adCanvasAppInfoButtonComponentData.button.text;
        adTextData.text = "\u7acb\u5373\u4e0b\u8f7d";
        adTextData.color = getColor(jSONObject4.getString("color"));
        adCanvasAppInfoButtonComponentData.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, AdUIUtils.getPxFromString(jSONObject4.getString("fontSize"), "appInfo button fontSize"));
        adCanvasAppInfoButtonComponentData.button.borderCornerRadius = AdUIUtils.getPxFromString(jSONObject4.getString(NodeProps.BORDER_RADIUS), "appInfo button borderRadius");
        adCanvasAppInfoButtonComponentData.width = (AdUIUtils.getPhysicalScreenWidth(context) * AdUIUtils.getPercentageFromString(jSONObject4.getString("width"), "appInfo button width")) / 100;
        adCanvasAppInfoButtonComponentData.height = AdUIUtils.dp2px(AdUIUtils.getPxFromString(jSONObject4.getString("height"), "appInfo button height"), context.getResources());
        return adCanvasAppInfoButtonComponentData;
    }

    @NonNull
    private static List<AdCanvasComponentData> getCanvasComponents(@NonNull Context context, @NonNull Ad ad5, @NonNull JSONArray jSONArray, @NonNull AdCanvasData adCanvasData) throws Throwable {
        ArrayList arrayList = new ArrayList();
        if (AdJSONArrayUtil.isEmpty(jSONArray)) {
            AdLog.e(TAG, "getCanvasComponents error");
            AdReport.getInstance().reportForCanvasDataBuildError(context, 5, ad5, null);
            AdAnalysisHelperForCanvas.reportForCanvasDataBuildError(context, ad5, String.valueOf(5));
            return arrayList;
        }
        imageLoadParams = new ImageLoadParams(0, false, new AtomicInteger(0));
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            AdCanvasComponentData component = getComponent(context, ad5, jSONArray.getJSONObject(i3), adCanvasData);
            if (component != null) {
                if (component instanceof AdCanvasFixedButtonComponentData) {
                    adCanvasData.fixedButtonComponentDataList.add((AdCanvasFixedButtonComponentData) component);
                } else if (component instanceof AdCanvasAppBtnComponentData) {
                    AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = (AdCanvasAppBtnComponentData) component;
                    if (adCanvasAppBtnComponentData.isFixed) {
                        adCanvasData.appFixedButtonComponentDataList.add(adCanvasAppBtnComponentData);
                    } else {
                        arrayList.add(component);
                    }
                } else {
                    arrayList.add(component);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    private static AdCanvasData getCanvasData(@NonNull Context context, @Nullable Ad ad5, @NonNull JSONObject jSONObject, boolean z16) throws Throwable {
        if (ad5 != null && !AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdCanvasData adCanvasData = new AdCanvasData();
            adCanvasData.f61337ad = ad5;
            adCanvasData.setAutoDownload(z16);
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (AdJSONUtil.isJSONObjectNull(optJSONObject)) {
                String cachedCanvasJson = AdCanvasJsonManager.getInstance().getCachedCanvasJson(ad5, jSONObject.getString("canvas_json_key"), true);
                if (TextUtils.isEmpty(cachedCanvasJson)) {
                    AdReport.getInstance().reportForCanvasDataBuildError(context, 3, ad5, null);
                    AdAnalysisHelperForCanvas.reportForCanvasDataBuildError(context, ad5, String.valueOf(3));
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(cachedCanvasJson);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                adCanvasData.appInfoRightUrl = jSONObject2.getJSONObject("appRights").getString("appInfoRightUrl");
                if (!isKeyElementsValid(adCanvasData, jSONObject2)) {
                    return null;
                }
                getPageList(context, ad5, adCanvasData, jSONObject3);
            } else {
                adCanvasData.appInfoRightUrl = jSONObject.getJSONObject("appRights").getString("appInfoRightUrl");
                if (!isKeyElementsValid(adCanvasData, jSONObject)) {
                    return null;
                }
                getPageList(context, ad5, adCanvasData, optJSONObject);
            }
            return adCanvasData;
        }
        AdLog.e(TAG, "getCanvasData error");
        return null;
    }

    public static int getColor(@NonNull String str) throws Throwable {
        if (str.indexOf("rgb") >= 0) {
            return getRgbColor(str);
        }
        if (str.length() == 4) {
            str = str + str.substring(1, 4);
        }
        return Color.parseColor(str);
    }

    @Nullable
    private static AdCanvasComponentData getComponent(@NonNull Context context, @NonNull Ad ad5, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getComponent error");
            AdReport.getInstance().reportForCanvasDataBuildError(context, 6, ad5, null);
            AdAnalysisHelperForCanvas.reportForCanvasDataBuildError(context, ad5, String.valueOf(6));
            return null;
        }
        String string = jSONObject.getString("type");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if (string.equals("XJAPPH5Images")) {
            AdCanvasMultiPictureComponentData mulitiPictureComponent = getMulitiPictureComponent(context, jSONObject, adCanvasData);
            if (mulitiPictureComponent != null) {
                adCanvasData.hasMultiPictureData = true;
                return mulitiPictureComponent;
            }
            return mulitiPictureComponent;
        }
        if (string.equals("XJAppH5Button")) {
            return getAppButtonComponent(context, jSONObject, adCanvasData.basicWidth);
        }
        if (string.equals("XJFixedButton")) {
            AdCanvasFixedButtonComponentData fixedButtonComponent = getFixedButtonComponent(context, ad5, jSONObject, adCanvasData.basicWidth);
            if (fixedButtonComponent != null) {
                adCanvasData.hasFixedButtonData = true;
                return fixedButtonComponent;
            }
            return fixedButtonComponent;
        }
        if (string.equals("XJText")) {
            return getTextComponent(context, ad5, jSONObject, adCanvasData.basicWidth);
        }
        if (string.equals("XJImages")) {
            return getWebMulitiPictureComponent(context, jSONObject, adCanvasData);
        }
        if (string.equals("XJDEFAULTImagesCarousel")) {
            return getImagesCarouselComponent(context, jSONObject, adCanvasData);
        }
        if (string.equals("XJAPPIcon")) {
            return getAppIconComponent(context, jSONObject, adCanvasData);
        }
        if (string.equals("XJAPPTitle")) {
            return getTitleComponent(context, jSONObject, adCanvasData);
        }
        if (string.equals("XJLayerCard")) {
            return getLayerCardComponent(context, ad5, jSONObject, adCanvasData);
        }
        if (string.equals("XJAPPInfoButton")) {
            return getAppInfoButtonComponent(context, jSONObject, adCanvasData);
        }
        AdReport.getInstance().reportForCanvasDataBuildError(context, 0, ad5, string);
        AdAnalysisHelperForCanvas.reportForCanvasDataBuildError(context, ad5, string);
        throw new Exception("unknow type exception");
    }

    @Nullable
    private static AdCanvasFixedButtonComponentData getFixedButtonComponent(@NonNull Context context, Ad ad5, @NonNull JSONObject jSONObject, int i3) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getFixedButtonComponent error");
            return null;
        }
        AdCanvasFixedButtonComponentData adCanvasFixedButtonComponentData = new AdCanvasFixedButtonComponentData();
        initComponent(jSONObject, i3, adCanvasFixedButtonComponentData);
        JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
        adCanvasFixedButtonComponentData.buttonStyle = jSONObject3.getString("buttonStyle");
        adCanvasFixedButtonComponentData.position = jSONObject3.getString("position");
        adCanvasFixedButtonComponentData.desc = unescapeHtml(jSONObject3.getString("desc"));
        adCanvasFixedButtonComponentData.button.text.text = unescapeHtml(jSONObject3.getString("text"));
        if (!adCanvasFixedButtonComponentData.button.text.text.contains("\u4e0b\u8f7d")) {
            adCanvasFixedButtonComponentData.button.text.text = "\u4e0b\u8f7dAPP";
        }
        String string = jSONObject3.getString("logoUrl");
        adCanvasFixedButtonComponentData.imageUrl = string;
        validateUrl(string);
        adCanvasFixedButtonComponentData.name = unescapeHtml(jSONObject3.getString("name"));
        adCanvasFixedButtonComponentData.fileSize = jSONObject3.getInt("fileSize");
        JSONObject jSONObject4 = jSONObject2.getJSONObject("style");
        adCanvasFixedButtonComponentData.button.text.color = getColor(jSONObject4.getString("color"));
        adCanvasFixedButtonComponentData.button.backgroundColor = getColor(jSONObject4.getString("backgroundColor"));
        if (!TextUtils.isEmpty(adCanvasFixedButtonComponentData.buttonStyle)) {
            if (adCanvasFixedButtonComponentData.buttonStyle.equals(AdCanvasFixedButtonComponentData.BUTTON_STYLE_1)) {
                adCanvasFixedButtonComponentData.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 13);
                adCanvasFixedButtonComponentData.button.text.text = "\u4e0b\u8f7d";
                adCanvasFixedButtonComponentData.width = AdUIUtils.dp2px(81.0f, context.getResources());
                adCanvasFixedButtonComponentData.height = AdUIUtils.dp2px(40.0f, context.getResources());
            } else if (adCanvasFixedButtonComponentData.buttonStyle.equals(AdCanvasFixedButtonComponentData.BUTTON_STYLE_2)) {
                adCanvasFixedButtonComponentData.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 19);
                adCanvasFixedButtonComponentData.gravity = 17;
                int dp2px = AdUIUtils.dp2px(5.0f, context.getResources());
                adCanvasFixedButtonComponentData.paddingTop = dp2px;
                adCanvasFixedButtonComponentData.paddingBottom = dp2px;
                int dp2px2 = AdUIUtils.dp2px(7.5f, context.getResources());
                adCanvasFixedButtonComponentData.paddingRight = dp2px2;
                adCanvasFixedButtonComponentData.paddingLeft = dp2px2;
                adCanvasFixedButtonComponentData.width = AdUIUtils.getPhysicalScreenWidth(context) - (adCanvasFixedButtonComponentData.paddingLeft * 2);
                adCanvasFixedButtonComponentData.height = AdUIUtils.dp2px(40.0f, context.getResources());
            } else {
                throw new Exception("unKnow button style");
            }
            if (!TextUtils.isEmpty(adCanvasFixedButtonComponentData.position) && (adCanvasFixedButtonComponentData.position.toLowerCase().equals("top") || adCanvasFixedButtonComponentData.position.toLowerCase().equals("bottom"))) {
                int optInt = jSONObject3.optInt("bottomWhiteSpace");
                int optInt2 = jSONObject3.optInt("topWhiteSpace");
                if (adCanvasFixedButtonComponentData.position.toLowerCase().equals("top")) {
                    adCanvasFixedButtonComponentData.topWhiteSpace += AdUIUtils.getValueDependsOnScreenWidth(context, i3, optInt2);
                } else if (adCanvasFixedButtonComponentData.position.toLowerCase().equals("bottom")) {
                    adCanvasFixedButtonComponentData.bottomWhiteSpace += AdUIUtils.getValueDependsOnScreenWidth(context, i3, optInt);
                }
                return adCanvasFixedButtonComponentData;
            }
            throw new Exception("unKnow button position");
        }
        throw new Exception("unKnow button style");
    }

    @Nullable
    private static HotArea getHotArea(Context context, int i3, String str, @NonNull JSONObject jSONObject, @Nullable AdCanvasPictureComponentData adCanvasPictureComponentData) throws Throwable {
        if (adCanvasPictureComponentData == null) {
            return null;
        }
        int physicalScreenWidth = AdUIUtils.getPhysicalScreenWidth(context);
        HotArea hotArea = new HotArea();
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        if (jSONObject2 == null) {
            return null;
        }
        int i16 = adCanvasPictureComponentData.height + adCanvasPictureComponentData.paddingBottom + adCanvasPictureComponentData.paddingTop;
        float f16 = physicalScreenWidth;
        hotArea.f61342x = (int) ((jSONObject2.getJSONObject("position").getInt("left") / 100.0f) * f16);
        float f17 = i16;
        hotArea.f61343y = (int) ((jSONObject2.getJSONObject("position").getInt("top") / 100.0f) * f17);
        hotArea.width = (int) ((jSONObject2.getJSONObject("style").getInt("width") / 100.0f) * f16);
        hotArea.height = (int) ((jSONObject2.getJSONObject("style").getInt("height") / 100.0f) * f17);
        hotArea.linkType = jSONObject2.getJSONObject(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK).getString("linkType");
        hotArea.url = jSONObject2.getJSONObject(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK).optString("url");
        return hotArea;
    }

    @Nullable
    private static AdCanvasComponentData getImagesCarouselComponent(Context context, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getImagesCarouselComponent error");
            return null;
        }
        AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData = new AdCanvasImagesCarouselComponentData();
        int i3 = adCanvasData.basicWidth;
        initComponent(jSONObject, i3, adCanvasImagesCarouselComponentData);
        ArrayList<AdCanvasPictureComponentData> arrayList = new ArrayList<>();
        JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
        JSONArray jSONArray = jSONObject2.getJSONArray("images");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("wrapper");
        adCanvasImagesCarouselComponentData.displaySpeed = ((Integer) jSONObject2.get("displaySpeed")).intValue();
        adCanvasImagesCarouselComponentData.pageLimit = 2;
        adCanvasImagesCarouselComponentData.pageMargin = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 10);
        adCanvasImagesCarouselComponentData.enableImageRoundRectBackground = true;
        adCanvasImagesCarouselComponentData.imageRadius = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 8);
        adCanvasImagesCarouselComponentData.imageBorderWidth = AdUIUtils.getValueDependsOnScreenWidth(context, i3, 1);
        adCanvasImagesCarouselComponentData.imageBorderColor = "#E3E3E3";
        adCanvasImagesCarouselComponentData.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject3.getInt(NodeProps.MARGIN_LEFT));
        adCanvasImagesCarouselComponentData.marginTop = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject3.getInt(NodeProps.MARGIN_TOP));
        adCanvasImagesCarouselComponentData.marginRight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject3.getInt(NodeProps.MARGIN_RIGHT));
        adCanvasImagesCarouselComponentData.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject3.getInt(NodeProps.MARGIN_BOTTOM));
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < jSONArray.length()) {
            AdCanvasPictureComponentData adCanvasPictureComponentData = new AdCanvasPictureComponentData();
            JSONObject jSONObject4 = ((JSONObject) jSONArray.get(i16)).getJSONObject("image");
            int valueDependsOnScreenWidth = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt("width"));
            int valueDependsOnScreenWidth2 = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt("height"));
            adCanvasPictureComponentData.width = valueDependsOnScreenWidth;
            adCanvasPictureComponentData.height = valueDependsOnScreenWidth2;
            String string = jSONObject4.getString("url");
            adCanvasPictureComponentData.url = string;
            validateUrl(string);
            adCanvasPictureComponentData.f61339id = "" + adCanvasPictureComponentData.url.hashCode();
            arrayList.add(adCanvasPictureComponentData);
            if (imageLoadParams != null) {
                setImageInfo(adCanvasPictureComponentData, context);
            }
            i16++;
            i17 = valueDependsOnScreenWidth;
            i18 = valueDependsOnScreenWidth2;
        }
        adCanvasImagesCarouselComponentData.imageWidth = i17;
        adCanvasImagesCarouselComponentData.imageHeight = i18;
        adCanvasImagesCarouselComponentData.imageList = arrayList;
        adCanvasImagesCarouselComponentData.width = i17 * 2;
        adCanvasImagesCarouselComponentData.height = i18;
        ImageLoadParams imageLoadParams2 = imageLoadParams;
        if (imageLoadParams2 != null) {
            imageLoadParams2.currentLength += i18 + adCanvasImagesCarouselComponentData.marginBottom + adCanvasImagesCarouselComponentData.marginTop;
        }
        return adCanvasImagesCarouselComponentData;
    }

    @Nullable
    private static AdCanvasComponentData getLayerCardComponent(Context context, Ad ad5, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getLayerCardComponent error");
            return null;
        }
        AdCanvasLayerCardData adCanvasLayerCardData = new AdCanvasLayerCardData();
        int i3 = adCanvasData.basicWidth;
        initComponent(jSONObject, i3, adCanvasLayerCardData);
        int screenWidth = AdUIUtils.getScreenWidth(context);
        int screenHeight = AdUIUtils.getScreenHeight(context);
        adCanvasLayerCardData.width = screenWidth;
        adCanvasLayerCardData.height = screenHeight;
        JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
        ArrayList<AdCanvasPictureComponentData> arrayList = new ArrayList<>();
        AdCanvasImagesCarouselComponentData adCanvasImagesCarouselComponentData = new AdCanvasImagesCarouselComponentData();
        adCanvasImagesCarouselComponentData.f61339id = "XJLayerCard_ImageCarousel_" + adCanvasLayerCardData.f61339id.hashCode();
        JSONArray jSONArray = jSONObject2.getJSONArray("images");
        int i16 = 0;
        while (i16 < jSONArray.length()) {
            AdCanvasPictureComponentData adCanvasPictureComponentData = new AdCanvasPictureComponentData();
            JSONObject jSONObject3 = ((JSONObject) jSONArray.get(i16)).getJSONObject("image");
            adCanvasPictureComponentData.width = screenWidth;
            int i17 = i3;
            int i18 = screenWidth;
            int intValue = Double.valueOf(screenWidth * ((jSONObject3.getInt("height") * 1.0d) / jSONObject3.getInt("width"))).intValue();
            adCanvasPictureComponentData.height = intValue;
            int i19 = adCanvasPictureComponentData.width;
            adCanvasImagesCarouselComponentData.width = i19;
            adCanvasImagesCarouselComponentData.height = intValue;
            adCanvasImagesCarouselComponentData.imageWidth = i19;
            adCanvasImagesCarouselComponentData.imageHeight = intValue;
            adCanvasPictureComponentData.gaussianUrl = jSONObject3.getString("guassianUrl");
            adCanvasPictureComponentData.url = jSONObject3.getString("url");
            adCanvasPictureComponentData.f61339id = "" + adCanvasPictureComponentData.url.hashCode();
            arrayList.add(adCanvasPictureComponentData);
            if (imageLoadParams != null) {
                setImageInfo(adCanvasPictureComponentData, context);
            }
            i16++;
            screenWidth = i18;
            i3 = i17;
        }
        int i26 = i3;
        adCanvasImagesCarouselComponentData.imageList = arrayList;
        adCanvasImagesCarouselComponentData.displaySpeed = 3;
        adCanvasImagesCarouselComponentData.pageLimit = 1;
        adCanvasLayerCardData.adCanvasImagesCarouselComponentData = adCanvasImagesCarouselComponentData;
        JSONObject jSONObject4 = jSONObject2.getJSONObject("appInfo");
        adCanvasLayerCardData.logoUrl = jSONObject4.getString("logoUrl");
        int valueDependsOnScreenWidth = AdUIUtils.getValueDependsOnScreenWidth(context, i26, 70);
        adCanvasLayerCardData.logoHeight = valueDependsOnScreenWidth;
        adCanvasLayerCardData.logoWidth = valueDependsOnScreenWidth;
        adCanvasLayerCardData.appName = unescapeHtml(jSONObject4.getString("name"));
        adCanvasLayerCardData.appDesc = unescapeHtml(jSONObject4.getString("description"));
        adCanvasLayerCardData.downloadCount = jSONObject4.optLong("downloadCount");
        if (jSONObject4.isNull("starCount")) {
            adCanvasLayerCardData.starCount = 4;
        } else {
            adCanvasLayerCardData.starCount = jSONObject4.getInt("starCount");
        }
        JSONObject jSONObject5 = jSONObject2.getJSONObject("button");
        JSONObject jSONObject6 = jSONObject5.getJSONObject("style");
        AdCanvasAppBtnComponentData adCanvasAppBtnComponentData = new AdCanvasAppBtnComponentData();
        adCanvasAppBtnComponentData.f61339id = "XJLayerCard_AppBtn_" + adCanvasLayerCardData.logoUrl.hashCode();
        adCanvasAppBtnComponentData.width = AdUIUtils.getValueDependsOnScreenWidth(context, i26, 287);
        adCanvasAppBtnComponentData.height = AdUIUtils.getValueDependsOnScreenWidth(context, i26, 40);
        adCanvasAppBtnComponentData.gravity = 17;
        adCanvasAppBtnComponentData.button.borderCornerRadius = AdUIUtils.getValueDependsOnScreenWidth(context, i26, 3);
        adCanvasAppBtnComponentData.button.text.size = AdUIUtils.getValueDependsOnScreenWidth(context, i26, 14);
        adCanvasAppBtnComponentData.button.text.text = unescapeHtml(jSONObject5.getString("text"));
        adCanvasAppBtnComponentData.button.text.color = getColor(jSONObject6.getString("color"));
        adCanvasAppBtnComponentData.button.backgroundColor = getColor(jSONObject6.getString("backgroundColor"));
        adCanvasLayerCardData.adCanvasAppBtnComponentData = adCanvasAppBtnComponentData;
        ImageLoadParams imageLoadParams2 = imageLoadParams;
        if (imageLoadParams2 != null) {
            imageLoadParams2.currentLength += adCanvasLayerCardData.height;
        }
        return adCanvasLayerCardData;
    }

    @Nullable
    private static AdCanvasMultiPictureComponentData getMulitiPictureComponent(Context context, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getMulitiPictureComponent error");
            return null;
        }
        AdCanvasMultiPictureComponentData adCanvasMultiPictureComponentData = new AdCanvasMultiPictureComponentData();
        initComponent(jSONObject, adCanvasData.basicWidth, adCanvasMultiPictureComponentData);
        ArrayList<AdCanvasPictureComponentData> arrayList = new ArrayList<>();
        JSONArray jSONArray = jSONObject.getJSONObject(DownloadInfo.spKey_Config).getJSONArray("images");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            AdCanvasPictureComponentData adCanvasPictureComponentData = new AdCanvasPictureComponentData();
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("padding");
            adCanvasPictureComponentData.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(context, adCanvasData.basicWidth, jSONObject3.getInt("left"));
            adCanvasPictureComponentData.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(context, adCanvasData.basicWidth, jSONObject3.getInt("top"));
            adCanvasPictureComponentData.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(context, adCanvasData.basicWidth, jSONObject3.getInt("right"));
            adCanvasPictureComponentData.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(context, adCanvasData.basicWidth, jSONObject3.getInt("bottom"));
            adCanvasPictureComponentData.floatingBarTextColor = -1;
            adCanvasPictureComponentData.floatingBarBackgroundColor = Color.parseColor("#1890ff");
            JSONObject jSONObject4 = jSONObject2.getJSONObject("progressBar");
            adCanvasPictureComponentData.floatingBarTextColor = getColor(jSONObject4.getString("color"));
            adCanvasPictureComponentData.floatingBarBackgroundColor = getColor(jSONObject4.getString("backgroundColor"));
            JSONObject jSONObject5 = jSONObject2.getJSONObject("image");
            int i16 = jSONObject5.getInt("width");
            int i17 = jSONObject5.getInt("height");
            int physicalScreenWidth = (AdUIUtils.getPhysicalScreenWidth(context) - adCanvasPictureComponentData.paddingLeft) - adCanvasPictureComponentData.paddingRight;
            adCanvasPictureComponentData.width = physicalScreenWidth;
            adCanvasPictureComponentData.height = (int) ((physicalScreenWidth * i17) / i16);
            String string = jSONObject5.getString("url");
            adCanvasPictureComponentData.url = string;
            validateUrl(string);
            adCanvasPictureComponentData.gaussianUrl = jSONObject5.optString("guassianUrl");
            adCanvasPictureComponentData.f61339id = "" + adCanvasPictureComponentData.url.hashCode();
            JSONObject jSONObject6 = jSONObject2.getJSONObject("hotArea");
            if (jSONObject6.getBoolean("isSet")) {
                HotArea[] hotAreaArr = {getHotArea(context, adCanvasData.basicWidth, "hotArea1", jSONObject2, adCanvasPictureComponentData), getHotArea(context, adCanvasData.basicWidth, "hotArea2", jSONObject2, adCanvasPictureComponentData), getHotArea(context, adCanvasData.basicWidth, "hotArea3", jSONObject2, adCanvasPictureComponentData)};
                ArrayList<HotArea> arrayList2 = new ArrayList<>();
                int parseInt = Integer.parseInt(jSONObject6.getString(WidgetCacheConstellationData.NUM));
                for (int i18 = 0; i18 < parseInt; i18++) {
                    HotArea hotArea = hotAreaArr[i18];
                    if (hotArea != null) {
                        arrayList2.add(hotArea);
                    } else {
                        throw new Exception("hot area is null");
                    }
                }
                adCanvasPictureComponentData.hotAreaList = arrayList2;
            } else {
                adCanvasPictureComponentData.hotAreaList = null;
            }
            arrayList.add(adCanvasPictureComponentData);
            if (TextUtils.isEmpty(adCanvasData.firstPictureComponentIdWithHotArea) && adCanvasPictureComponentData.isHotAreaValild()) {
                adCanvasData.firstPictureComponentIdWithHotArea = adCanvasPictureComponentData.f61339id;
            }
            if (imageLoadParams != null) {
                setImageInfo(adCanvasPictureComponentData, context);
                imageLoadParams.currentLength += adCanvasPictureComponentData.height;
            }
        }
        adCanvasMultiPictureComponentData.imageList = arrayList;
        return adCanvasMultiPictureComponentData;
    }

    @Nullable
    private static AdCanvasPageData getPage(@NonNull Context context, @NonNull Ad ad5, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getPage error");
            return null;
        }
        AdCanvasPageData adCanvasPageData = new AdCanvasPageData();
        adCanvasPageData.floatingBarTextColor = -1;
        adCanvasPageData.floatingBarBackgroundColor = Color.parseColor("#1890ff");
        JSONObject jSONObject2 = jSONObject.getJSONObject("pageConfig");
        JSONObject jSONObject3 = jSONObject2.getJSONObject(DownloadInfo.spKey_Config);
        String optString = jSONObject2.optString("arkFormApp");
        String optString2 = jSONObject2.optString("arkFormView");
        adCanvasPageData.arkApp = optString;
        adCanvasPageData.arkView = optString2;
        adCanvasPageData.backgroundColor = getColor(jSONObject3.getString("bgColor"));
        adCanvasPageData.components = getCanvasComponents(context, ad5, jSONObject.getJSONArray("modules"), adCanvasData);
        return adCanvasPageData;
    }

    private static void getPageList(@NonNull Context context, @NonNull Ad ad5, @NonNull AdCanvasData adCanvasData, @NonNull JSONObject jSONObject) throws Throwable {
        imageLoadParams = null;
        JSONObject jSONObject2 = jSONObject.getJSONObject("pageConfig");
        adCanvasData.pageTitle = jSONObject2.getJSONObject(DownloadInfo.spKey_Config).getString(VasWebviewConstants.KEY_PAGE_TITLE);
        adCanvasData.pageType = jSONObject2.getString("type");
        adCanvasData.commonPageId = jSONObject2.getString("commonPageId");
        adCanvasData.basicWidth = QidPagView.DESIGN_PAG_WIDTH;
        adCanvasData.pages = getPageList(context, ad5, jSONObject, adCanvasData);
    }

    public static int getRgbColor(String str) throws Throwable {
        String[] split;
        int i3;
        if (!TextUtils.isEmpty(str) && (split = str.toLowerCase().replace(" ", "").replace("rgba", "").replace("rgb", "").replace("(", "").replace(")", "").split(",")) != null && split.length >= 3) {
            if (split.length >= 4) {
                i3 = (int) (Float.parseFloat(split[3]) * 255.0f);
            } else {
                i3 = 255;
            }
            return Color.argb(i3, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
        throw new Exception("color is null");
    }

    @Nullable
    private static AdCanvasComponentData getTextComponent(Context context, @NonNull Ad ad5, @NonNull JSONObject jSONObject, int i3) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getTextComponent error");
            return null;
        }
        if (ad5.isAppXiJingDefault()) {
            AdCanvasTextComponentData adCanvasTextComponentData = new AdCanvasTextComponentData();
            initComponent(jSONObject, i3, adCanvasTextComponentData);
            JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
            JSONObject jSONObject4 = jSONObject2.getJSONObject("style");
            adCanvasTextComponentData.content = jSONObject3.getString("text").replace(RedTouch.NEWLINE_CHAR, "\n");
            adCanvasTextComponentData.fontSize = jSONObject4.getInt("fontSize");
            adCanvasTextComponentData.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_LEFT));
            adCanvasTextComponentData.marginTop = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_TOP));
            adCanvasTextComponentData.marginRight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_RIGHT));
            adCanvasTextComponentData.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject4.getInt(NodeProps.MARGIN_BOTTOM));
            return adCanvasTextComponentData;
        }
        AdCanvasMultiPictureComponentData adCanvasMultiPictureComponentData = new AdCanvasMultiPictureComponentData();
        ArrayList<AdCanvasPictureComponentData> arrayList = new ArrayList<>();
        initComponent(jSONObject, i3, adCanvasMultiPictureComponentData);
        JSONObject jSONObject5 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
        JSONObject jSONObject6 = jSONObject5.getJSONObject("style");
        adCanvasMultiPictureComponentData.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject6.getInt(NodeProps.MARGIN_TOP));
        adCanvasMultiPictureComponentData.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject6.getInt(NodeProps.MARGIN_BOTTOM));
        JSONArray jSONArray = jSONObject5.getJSONArray("images");
        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
            AdCanvasPictureComponentData adCanvasPictureComponentData = new AdCanvasPictureComponentData();
            JSONObject jSONObject7 = (JSONObject) jSONArray.get(i16);
            int i17 = jSONObject7.getInt("width");
            int i18 = jSONObject7.getInt("height");
            int physicalScreenWidth = (AdUIUtils.getPhysicalScreenWidth(context) - adCanvasPictureComponentData.paddingLeft) - adCanvasPictureComponentData.paddingRight;
            adCanvasPictureComponentData.width = physicalScreenWidth;
            adCanvasPictureComponentData.height = (int) ((physicalScreenWidth * i18) / i17);
            String string = jSONObject7.getString("url");
            adCanvasPictureComponentData.url = string;
            validateUrl(string);
            adCanvasPictureComponentData.f61339id = "" + adCanvasPictureComponentData.url.hashCode();
            arrayList.add(adCanvasPictureComponentData);
            if (imageLoadParams != null) {
                setImageInfo(adCanvasPictureComponentData, context);
                imageLoadParams.currentLength += adCanvasPictureComponentData.height;
            }
        }
        adCanvasMultiPictureComponentData.imageList = arrayList;
        return adCanvasMultiPictureComponentData;
    }

    @Nullable
    private static AdCanvasTitleComponentData getTitleComponent(Context context, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getTitleComponent error");
            return null;
        }
        AdCanvasTitleComponentData adCanvasTitleComponentData = new AdCanvasTitleComponentData();
        initComponent(jSONObject, adCanvasData.basicWidth, adCanvasTitleComponentData);
        JSONObject jSONObject2 = jSONObject.getJSONObject(DownloadInfo.spKey_Config);
        int i3 = adCanvasData.basicWidth;
        adCanvasTitleComponentData.adTextData.text = unescapeHtml(jSONObject2.getJSONObject("content").getString("text"));
        adCanvasTitleComponentData.adTextData.color = getColor(jSONObject2.getJSONObject("style").getString("color"));
        adCanvasTitleComponentData.adTextData.size = jSONObject2.getJSONObject("style").getInt("fontSize");
        adCanvasTitleComponentData.adTextData.weight = jSONObject2.getJSONObject("style").getString("fontWeight");
        adCanvasTitleComponentData.decoration = getColor(jSONObject2.getString("decoration"));
        adCanvasTitleComponentData.textAlignGravity = AdUIUtils.formatStringToGravity(jSONObject2.getJSONObject("wrapper").getString("textAlign"), "title text align");
        adCanvasTitleComponentData.marginBottom = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject2.getJSONObject("wrapper").getInt(NodeProps.MARGIN_BOTTOM));
        adCanvasTitleComponentData.marginTop = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject2.getJSONObject("wrapper").getInt(NodeProps.MARGIN_TOP));
        adCanvasTitleComponentData.marginLeft = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject2.getJSONObject("wrapper").getInt(NodeProps.MARGIN_LEFT));
        adCanvasTitleComponentData.marginRight = AdUIUtils.getValueDependsOnScreenWidth(context, i3, jSONObject2.getJSONObject("wrapper").getInt(NodeProps.MARGIN_RIGHT));
        adCanvasTitleComponentData.titleDecorationType = jSONObject2.getString(PushClientConstants.TAG_CLASS_NAME);
        adCanvasTitleComponentData.backgroundColor = getColor(jSONObject2.getJSONObject("wrapper").getString("backgroundColor"));
        adCanvasTitleComponentData.justifyContent = AdUIUtils.formatStringToRelativeLayoutRule(jSONObject2.getJSONObject("wrapper").getString(NodeProps.JUSTIFY_CONTENT), "title justifyContent");
        return adCanvasTitleComponentData;
    }

    @Nullable
    @Deprecated
    private static AdCanvasComponentData getWebMulitiPictureComponent(Context context, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getMulitiPictureComponent error");
            return null;
        }
        AdCanvasMultiPictureComponentData adCanvasMultiPictureComponentData = new AdCanvasMultiPictureComponentData();
        initComponent(jSONObject, adCanvasData.basicWidth, adCanvasMultiPictureComponentData);
        ArrayList<AdCanvasPictureComponentData> arrayList = new ArrayList<>();
        JSONArray jSONArray = jSONObject.getJSONObject(DownloadInfo.spKey_Config).getJSONArray("images");
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            AdCanvasPictureComponentData adCanvasPictureComponentData = new AdCanvasPictureComponentData();
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("padding");
            adCanvasPictureComponentData.paddingLeft = AdUIUtils.getValueDependsOnScreenWidth(context, adCanvasData.basicWidth, jSONObject3.getInt("left"));
            adCanvasPictureComponentData.paddingTop = AdUIUtils.getValueDependsOnScreenWidth(context, adCanvasData.basicWidth, jSONObject3.getInt("top"));
            adCanvasPictureComponentData.paddingRight = AdUIUtils.getValueDependsOnScreenWidth(context, adCanvasData.basicWidth, jSONObject3.getInt("right"));
            adCanvasPictureComponentData.paddingBottom = AdUIUtils.getValueDependsOnScreenWidth(context, adCanvasData.basicWidth, jSONObject3.getInt("bottom"));
            adCanvasPictureComponentData.floatingBarTextColor = -1;
            adCanvasPictureComponentData.floatingBarBackgroundColor = Color.parseColor("#1890ff");
            JSONObject jSONObject4 = jSONObject2.getJSONObject("image");
            int i16 = jSONObject4.getInt("width");
            int i17 = jSONObject4.getInt("height");
            int physicalScreenWidth = (AdUIUtils.getPhysicalScreenWidth(context) - adCanvasPictureComponentData.paddingLeft) - adCanvasPictureComponentData.paddingRight;
            adCanvasPictureComponentData.width = physicalScreenWidth;
            adCanvasPictureComponentData.height = (int) ((physicalScreenWidth * i17) / i16);
            String string = jSONObject4.getString("url");
            adCanvasPictureComponentData.url = string;
            validateUrl(string);
            adCanvasPictureComponentData.gaussianUrl = jSONObject4.optString("guassianUrl");
            adCanvasPictureComponentData.f61339id = "" + adCanvasPictureComponentData.url.hashCode();
            JSONObject jSONObject5 = jSONObject2.getJSONObject("hotArea");
            if (jSONObject5.getBoolean("isSet")) {
                HotArea[] hotAreaArr = {getHotArea(context, adCanvasData.basicWidth, "hotArea1", jSONObject2, adCanvasPictureComponentData), getHotArea(context, adCanvasData.basicWidth, "hotArea2", jSONObject2, adCanvasPictureComponentData), getHotArea(context, adCanvasData.basicWidth, "hotArea3", jSONObject2, adCanvasPictureComponentData)};
                ArrayList<HotArea> arrayList2 = new ArrayList<>();
                int parseInt = Integer.parseInt(jSONObject5.getString(WidgetCacheConstellationData.NUM));
                for (int i18 = 0; i18 < parseInt; i18++) {
                    HotArea hotArea = hotAreaArr[i18];
                    if (hotArea != null) {
                        arrayList2.add(hotArea);
                    } else {
                        throw new Exception("hot area is null");
                    }
                }
                adCanvasPictureComponentData.hotAreaList = arrayList2;
            } else {
                adCanvasPictureComponentData.hotAreaList = null;
            }
            arrayList.add(adCanvasPictureComponentData);
            if (TextUtils.isEmpty(adCanvasData.firstPictureComponentIdWithHotArea) && adCanvasPictureComponentData.isHotAreaValild()) {
                adCanvasData.firstPictureComponentIdWithHotArea = adCanvasPictureComponentData.f61339id;
            }
        }
        adCanvasMultiPictureComponentData.imageList = arrayList;
        return adCanvasMultiPictureComponentData;
    }

    private static void initComponent(@NonNull JSONObject jSONObject, int i3, @Nullable AdCanvasComponentData adCanvasComponentData) throws Throwable {
        if (!AdJSONUtil.isJSONObjectNull(jSONObject) && adCanvasComponentData != null) {
            adCanvasComponentData.f61339id = jSONObject.getString("id");
        } else {
            AdLog.e(TAG, "initComponent error");
            throw new Exception("initComponent error");
        }
    }

    private static boolean isKeyElementsValid(@Nullable AdCanvasData adCanvasData, @NonNull JSONObject jSONObject) throws Throwable {
        if (adCanvasData == null || AdJSONUtil.isJSONObjectNull(jSONObject)) {
            return false;
        }
        String string = jSONObject.getString("lastModTime");
        JSONObject jSONObject2 = jSONObject.getJSONObject("appRights");
        if (AdJSONUtil.isJSONObjectNull(jSONObject2)) {
            return false;
        }
        String string2 = jSONObject2.getString("appCriteriaTime");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string2, new ParsePosition(0));
            Date parse2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(string, new ParsePosition(0));
            if (parse != null && parse2 != null) {
                if (parse2.getTime() < parse.getTime()) {
                    AdLog.e(TAG, "getCanvasData return null cause lastModTimeMillis < inValidTimeMillis");
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private static void setActiveAppBtnView(@Nullable AdCanvasData adCanvasData) {
        if (adCanvasData != null) {
            List<AdCanvasComponentData> list = adCanvasData.pages.get(0).components;
            ArrayList<AdCanvasFixedButtonComponentData> arrayList = adCanvasData.fixedButtonComponentDataList;
            ArrayList<AdCanvasAppBtnComponentData> arrayList2 = adCanvasData.appFixedButtonComponentDataList;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<AdCanvasFixedButtonComponentData> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().canShowProgress = true;
                }
                return;
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                if (arrayList2.get(0) != null) {
                    arrayList2.get(0).canShowProgress = true;
                }
            } else if (list != null && list.size() > 0) {
                for (AdCanvasComponentData adCanvasComponentData : list) {
                    if (adCanvasComponentData instanceof AdCanvasAppInfoButtonComponentData) {
                        ((AdCanvasAppInfoButtonComponentData) adCanvasComponentData).canShowProgress = true;
                    } else if (adCanvasComponentData instanceof AdCanvasLayerCardData) {
                        ((AdCanvasLayerCardData) adCanvasComponentData).adCanvasAppBtnComponentData.canShowProgress = true;
                    } else if (adCanvasComponentData instanceof AdCanvasAppBtnComponentData) {
                        ((AdCanvasAppBtnComponentData) adCanvasComponentData).canShowProgress = true;
                    }
                }
            }
        }
    }

    private static void setImageInfo(@Nullable AdCanvasPictureComponentData adCanvasPictureComponentData, @Nullable Context context) {
        ImageLoadParams imageLoadParams2;
        if (context != null && context.getResources() != null && context.getResources().getDisplayMetrics() != null && adCanvasPictureComponentData != null && (imageLoadParams2 = imageLoadParams) != null) {
            if (imageLoadParams2.currentLength > context.getResources().getDisplayMetrics().heightPixels && imageLoadParams.hasLoadedImage && !TextUtils.isEmpty(adCanvasPictureComponentData.gaussianUrl)) {
                adCanvasPictureComponentData.isLoadFirst = false;
                return;
            }
            adCanvasPictureComponentData.isLoadFirst = true;
            imageLoadParams.hasLoadedFirstImages.incrementAndGet();
            imageLoadParams.hasLoadedImage = true;
            if (imageLoadParams.firstImage.get() == 0) {
                imageLoadParams.firstImage.incrementAndGet();
                adCanvasPictureComponentData.needFirstImageReport = true;
            }
        }
    }

    private static String unescapeHtml(String str) {
        Spanned fromHtml;
        if (TextUtils.isEmpty(str) || (fromHtml = Html.fromHtml(str)) == null) {
            return str;
        }
        return fromHtml.toString();
    }

    private static void validateUrl(String str) throws Exception {
        Uri parse = AdUriUtil.parse(str);
        if (parse != null && (parse.getScheme().equals("http") || parse.getScheme().equals("https"))) {
        } else {
            throw new Exception("url type error");
        }
    }

    @NonNull
    private static List<AdCanvasPageData> getPageList(@NonNull Context context, @NonNull Ad ad5, @NonNull JSONObject jSONObject, @NonNull AdCanvasData adCanvasData) throws Throwable {
        ArrayList arrayList = new ArrayList();
        if (AdJSONUtil.isJSONObjectNull(jSONObject)) {
            AdLog.e(TAG, "getPageList error");
            AdReport.getInstance().reportForCanvasDataBuildError(context, 4, ad5, null);
            AdAnalysisHelperForCanvas.reportForCanvasDataBuildError(context, ad5, String.valueOf(4));
            return arrayList;
        }
        AdCanvasPageData page = getPage(context, ad5, jSONObject, adCanvasData);
        if (page != null) {
            page.hasFixedButtonData = adCanvasData.hasFixedButtonData;
            page.hasMultiPictureData = adCanvasData.hasMultiPictureData;
            page.imageLoadParams = imageLoadParams;
            arrayList.add(page);
            return arrayList;
        }
        throw new Exception("getPageList error");
    }
}
