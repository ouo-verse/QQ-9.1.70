package com.tencent.qqlive.tvkplayer.tools.auth;

import android.content.Context;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAppKeyManager {
    private static final int APPKEY_MAIN_VERSION = 2;
    private static final int APPKEY_MAIN_VERSION_TV = 1;
    public static final int APPKEY_STATE_ERROR_CIPHER = 306;
    public static final int APPKEY_STATE_ERROR_UNCAUGHT_EXCEPTION = 304;
    public static final int APPKEY_STATE_INVALID = 200;
    public static final int APPKEY_STATE_INVALID_CERT_MISMATCH = 204;
    public static final int APPKEY_STATE_INVALID_CHANNELID_EMPTY = 208;
    public static final int APPKEY_STATE_INVALID_MISSING_VER = 201;
    public static final int APPKEY_STATE_INVALID_PKG_MISMATCH = 203;
    public static final int APPKEY_STATE_INVALID_PLATFORM_PARSE_EXCEPTION = 206;
    public static final int APPKEY_STATE_INVALID_SDTFROM_EMPTY = 207;
    public static final int APPKEY_STATE_INVALID_VER_MISMATCH = 202;
    public static final int APPKEY_STATE_SDK_NOT_INITIALIZED = 1;
    public static final int APPKEY_STATE_VALID = 100;
    private static final int APPKEY_VERSION_MOD = 1000;
    private static final int BLOCK_SIZE = 245;
    private static final int KEY_SIZE = 256;
    private static final byte[] PUBLIC_KEY = {48, -126, 1, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, RegisterType.DOUBLE_HI, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -78, -104, -69, -90, -63, -12, -111, -65, 10, -68, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 7, 43, -89, -73, -74, -59, 46, MultipartStream.DASH, 94, -35, -105, 46, 58, -95, RegisterType.DOUBLE_HI, -2, -110, -114, 33, RegisterType.CONFLICTED, -83, -81, 78, -53, -117, 48, -68, 107, Byte.MIN_VALUE, -101, -18, -80, -80, -14, 101, 63, -90, -101, RegisterType.REFERENCE, -54, -57, 67, 90, 56, 82, 46, -105, -60, 79, 53, 23, -95, -54, -124, 65, 97, 107, 29, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, -70, RegisterType.CONFLICTED, 0, 33, 62, -37, 23, -81, -13, -40, -34, -15, -101, 101, -13, -8, -113, -65, -110, -20, -107, 25, 67, -72, -25, -99, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, -106, -26, -51, -7, -42, -117, 85, -24, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, -17, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, -34, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -28, -4, -43, -99, -126, -122, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 57, 105, -98, 94, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, -68, 80, -31, -28, 102, -59, -85, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 86, -75, -9, 105, 83, -47, -37, Constants.PACKET_LOSS_EFFECT_STATIS, -116, -65, -116, -56, 84, -112, 90, -27, 55, Constants.PACKET_LOSS_EFFECT_STATIS, -33, -116, 7, 47, -85, -76, 25, 63, 10, -33, 89, -35, -84, 38, 27, 106, -10, -78, -65, RegisterType.REFERENCE, 58, 106, 66, MultipartStream.DASH, 47, -111, 59, 26, 52, RegisterType.CONFLICTED, -35, -26, 54, -69, -90, -8, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, 3, 52, 44, -70, -114, 54, 78, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, -71, 73, -120, -115, 28, 107, -81, -92, -6, 47, -27, 79, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 89, 88, 52, -107, 23, 78, -71, -55, -88, 36, 41, -112, 72, 47, -103, -56, 9, -63, -25, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 65, 32, -83, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, 53, -81, 123, 53, 120, -17, -94, 75, -38, -68, 0, 52, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, -82, -119, RegisterType.REFERENCE, -88, 29, -117, 67, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, -113, 5, 2, 3, 1, 0, 1};
    private static final byte[] PUBLIC_KEY_V2 = {48, -126, 1, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, RegisterType.DOUBLE_HI, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -60, 95, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -75, 126, -76, -87, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, Byte.MAX_VALUE, -45, 56, 77, 123, 33, -49, 9, 82, 44, -17, -22, 58, -22, 68, 37, -29, -56, -3, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 32, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, PublicAccountH5AbilityPluginImpl.OPENIMG, -64, -71, -121, 57, 4, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, -93, -41, 56, 3, -59, 65, 94, 33, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 48, 33, -7, 92, 12, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, 106, 72, MultipartStream.DASH, 0, 41, 7, -124, -109, -78, -76, 7, -45, 70, -45, -18, 59, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 6, -51, -20, 62, PublicAccountH5AbilityPluginImpl.OPENCAMERA, -18, 7, -69, 4, -38, MultipartStream.DASH, -64, -58, -30, 61, 68, -79, -26, 24, -9, -113, 28, -123, -55, 5, -99, -20, 72, -10, 25, 57, -75, -118, -75, -98, 65, -101, 9, 126, 5, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, -6, 48, -98, 99, -46, 30, -90, -38, -71, 3, -25, -84, -21, -62, 2, Byte.MIN_VALUE, -119, 28, 90, 94, 47, -78, 33, -92, -68, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, 90, -61, -117, -66, -26, -47, -86, -49, -63, 77, RegisterType.CONFLICTED, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 63, 49, 27, Constants.VIRTUAL_GAMEPAD_SDK_DATA, 88, -51, -4, 82, -17, -117, Byte.MAX_VALUE, -25, -5, 0, 62, 79, -81, -79, 83, -82, 26, -103, -117, 12, 85, -86, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 81, 55, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, 2, 49, -10, -58, 73, -46, 13, 46, -87, 33, -77, -124, -83, -61, 58, 103, 8, 124, -62, 44, -27, Constants.SEND_CHANNEL_LATENCY, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, -83, 46, -113, 102, -124, -101, -8, -19, -99, -103, 92, 37, 52, -70, -73, -19, -81, -21, 59, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, -89, -11, RegisterType.UNINIT_REF, 35, -29, 63, -93, -106, -1, -96, -62, -121, -35, -41, 74, -120, 26, -65, 124, -32, -79, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 66, -79, 89, 44, -5, -23, 0, 9, -22, -92, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, -23, 2, 3, 1, 0, 1};
    private static final String TAG = "TVKPlayer[TVKAppKeyManager]";
    private static String sAdChid = "";
    private static String sChannelId = "";
    private static String sConfigId = "";
    private static Context sContext = null;
    private static boolean sIsInited = false;
    private static int sKeyState = 200;
    private static String sKeyStateDescription = "";
    private static String sLicence = "";
    private static String sPlatform = "";
    private static String sSdtfrom = "";

    private static byte[] decrypt(Key key, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, key);
        int length = bArr.length / 256;
        if (bArr.length % 256 == 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length * 245);
            for (int i3 = 0; i3 < length; i3++) {
                byteArrayOutputStream.write(cipher.doFinal(bArr, i3 * 256, 256));
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalBlockSizeException("The size of data is not a multiple of cipher block size. Data size=" + bArr.length);
    }

    public static String getAdChid() {
        return sAdChid;
    }

    private static String getAppCert() {
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(sContext.getPackageManager(), sContext.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            byte[] digest = messageDigest.digest();
            StringBuilder sb5 = new StringBuilder(digest.length * 2);
            for (byte b16 : digest) {
                sb5.append(String.format("%02x", Byte.valueOf(b16)));
            }
            return sb5.toString();
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, th5);
            return null;
        }
    }

    public static String getChannelId() {
        return sChannelId;
    }

    public static String getConfigId() {
        return sConfigId;
    }

    public static int getKeyState() {
        return sKeyState;
    }

    public static String getKeyStateDescription() {
        return sKeyStateDescription;
    }

    public static String getLicence() {
        return sLicence;
    }

    public static String getPlatform() {
        return sPlatform;
    }

    public static String getSdtfrom() {
        return sSdtfrom;
    }

    public static synchronized void init(Context context, String str) {
        synchronized (TVKAppKeyManager.class) {
            if (sIsInited) {
                return;
            }
            if (context != null && str != null) {
                sContext = context.getApplicationContext();
                verifyAppKey(str);
                if (isAuthorized()) {
                    sIsInited = true;
                }
                return;
            }
            setAppKeyState(1);
        }
    }

    public static boolean isAuthorized() {
        if (sKeyState == 100) {
            return true;
        }
        return false;
    }

    private static void setAppKeyState(int i3) {
        setAppKeyState(i3, null);
    }

    private static void verifyAppKey(String str) {
        try {
            byte[] decrypt = decrypt(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(PUBLIC_KEY_V2)), Base64.decode(str, 0));
            Properties properties = new Properties();
            properties.load(new ByteArrayInputStream(decrypt));
            String property = properties.getProperty("ver");
            if (property == null) {
                setAppKeyState(201);
                return;
            }
            if (TVKUtils.optInt(property, 0) / 1000 != 2) {
                setAppKeyState(202, "AppKey version mismatch");
                return;
            }
            String property2 = properties.getProperty("pkg");
            String packageName = sContext.getPackageName();
            if (!packageName.equals(property2) && !TVKCommParams.isDebug()) {
                setAppKeyState(203, "AppKey pkg mismatch:pkg:" + property2 + ";package:" + packageName);
                return;
            }
            String property3 = properties.getProperty("cert");
            if (property3 != null && !property3.equalsIgnoreCase(getAppCert()) && !"ANY".equals(property3)) {
                setAppKeyState(204, "AppKey cert mismatch");
                return;
            }
            String property4 = properties.getProperty("platform");
            if (!TextUtils.isEmpty(property4)) {
                sPlatform = property4;
                String property5 = properties.getProperty("sdtfrom");
                if (!TextUtils.isEmpty(property5)) {
                    sSdtfrom = property5;
                    String property6 = properties.getProperty("channelId");
                    if (!TextUtils.isEmpty(property6)) {
                        sChannelId = property6;
                        String property7 = properties.getProperty("configid");
                        if (!TextUtils.isEmpty(property7)) {
                            sConfigId = property7;
                        }
                        String property8 = properties.getProperty("chid");
                        if (!TextUtils.isEmpty(property8)) {
                            sAdChid = property8;
                        }
                        String property9 = properties.getProperty("licence");
                        if (!TextUtils.isEmpty(property9)) {
                            sLicence = property9;
                        }
                        TVKLogUtil.i("MediaPlayerMgr", "platform=" + property4 + ";sdtfrom=" + property5 + ";channelId=" + property6 + ";ConfigId=" + sConfigId + ";adChid=" + sAdChid + ";licence=" + sLicence + ";package=" + packageName);
                        setAppKeyState(100);
                        return;
                    }
                    setAppKeyState(208, "AppKey channelId is empty");
                    return;
                }
                setAppKeyState(207, "AppKey sdtfrom is empty");
                return;
            }
            setAppKeyState(206, "AppKey platform is empty");
        } catch (Throwable th5) {
            if (th5 instanceof GeneralSecurityException) {
                setAppKeyState(306, th5.toString());
            } else {
                setAppKeyState(304, th5.toString());
            }
        }
    }

    private static void setAppKeyState(int i3, String str) {
        TVKLogUtil.e("MediaPlayerMgr", "verify state result: " + i3 + ", msg: " + str);
        if (sKeyState != i3) {
            sKeyState = i3;
        }
        sKeyStateDescription = str;
    }
}
