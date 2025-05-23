package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import android.util.Base64;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VsAppKeyVerify {
    private static final int BLOCK_SIZE = 373;
    private static final int KEY_SIZE = 384;
    private static final String PUB_KEY_BASE = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAvrKogXQuH0o0JcHsLKnEqr74NTWwI4Z65kTg0/z/O5dYTWbU5VgZUMWm110wCIdzozx/x4jiCPX0Ya/casUF6wpWXGoMV93qWB2p4EPBmxjSNLxjxPgTWfOyMt4v1ELHy9OTsFfFqbPQ1wSkSLQEn7J+0ZSGxZZXsUmkvuUJwd/PwVu79CjrCVSZsgnmqcplKvbVqYT8B8zBqnz3lIcBeMINWYu4id6MggiREGc07jw/VRYcu/Y8E8UKkRfa+bxPSzBaMLWRzGxXHLhrgHFDhBdINOXJit0A4AhJ0AckMsEcFUSE2WFW5F8a8gam/ZD7nj5tnyVM034qggV+W9PyhS3B6BRgIkFHkNr0y4zbw+RQDCSkGGqVBCHOWFhNR+olWimhhwaxWK4DMRVHlOyI/PE9/Kp0Xud7UM65r/jLgMG39Oz7ipfeqa4SrTYaBemYWv9YQ09a7Tn5unIb0nxmLHobTQBngbKoqcXGm56toYWhG+LQfcSjOaTbQ3fPSDFBAgMBAAE=";
    private Context mContext;
    private static final byte[] PUBLIC_KEY = {48, -126, 1, -94, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, -113, 0, 48, -126, 1, -118, 2, -126, 1, -127, 0, -66, -78, -88, -127, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 46, 31, 74, 52, 37, -63, -20, 44, -87, -60, -86, -66, -8, 53, 53, -80, 35, -122, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, -26, 68, -32, -45, -4, -1, 59, -105, 88, 77, 102, -44, -27, 88, 25, 80, -59, -90, -41, 93, 48, 8, -121, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, -93, 60, Byte.MAX_VALUE, -57, -120, -30, 8, -11, -12, 97, -81, -36, 106, -59, 5, -21, 10, 86, 92, 106, 12, 87, -35, -22, 88, 29, -87, -32, 67, -63, -101, 24, -46, 52, -68, 99, -60, -8, RegisterType.CONFLICTED, 89, -13, -78, 50, -34, 47, -44, 66, -57, -53, -45, -109, -80, 87, -59, -87, -77, -48, -41, 4, -92, 72, -76, 4, -97, -78, 126, -47, -108, -122, -59, -106, 87, -79, 73, -92, -66, -27, 9, -63, -33, -49, -63, Constants.SEND_CHANNEL_LATENCY, -69, -12, 40, -21, 9, 84, -103, -78, 9, -26, -87, -54, 101, 42, -10, -43, -87, -124, -4, 7, -52, -63, -86, 124, -9, -108, -121, 1, 120, -62, 13, 89, -117, -72, -119, -34, -116, -126, 8, -111, RegisterType.UNINIT_REF, 103, 52, -18, 60, 63, 85, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 28, -69, -10, 60, RegisterType.CONFLICTED, -59, 10, -111, 23, -38, -7, -68, 79, 75, 48, 90, 48, -75, -111, -52, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 87, 28, -72, 107, Byte.MIN_VALUE, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, 67, -124, 23, 72, 52, -27, -55, -118, -35, 0, -32, 8, 73, -48, 7, 36, 50, -63, 28, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 68, -124, -39, 97, 86, -28, 95, 26, -14, 6, -90, -3, -112, -5, -98, 62, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, -97, 37, 76, -45, 126, 42, -126, 5, 126, Constants.SEND_CHANNEL_LATENCY, -45, -14, -123, MultipartStream.DASH, -63, -24, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, Constants.VIRTUAL_GAMEPAD_SDK_DATA, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 65, 71, -112, -38, -12, -53, -116, -37, -61, -28, 80, 12, 36, -92, 24, 106, -107, 4, 33, -50, 88, 88, 77, 71, -22, 37, 90, 41, -95, -121, 6, -79, 88, -82, 3, 49, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 71, -108, -20, -120, -4, -15, 61, -4, -86, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 94, -25, 123, 80, -50, -71, -81, -8, -53, Byte.MIN_VALUE, -63, -73, -12, -20, -5, -118, -105, -34, -87, -82, RegisterType.REFERENCE, -83, 54, 26, 5, -23, -104, 90, -1, 88, 67, 79, 90, -19, 57, -7, -70, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, 27, -46, 124, 102, 44, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 27, 77, 0, 103, -127, -78, -88, -87, -59, -58, -101, -98, -83, -95, -123, -95, 27, -30, -48, Constants.PACKET_LOSS_EFFECT_STATIS, -60, -93, 57, -92, -37, 67, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, -49, 72, 49, 65, 2, 3, 1, 0, 1};
    private static VsAppKeyVerify instance = null;

    VsAppKeyVerify() {
    }

    private static byte[] decrypt(Key key, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, key);
        int length = bArr.length / 384;
        if (bArr.length % 384 == 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length * 373);
            for (int i3 = 0; i3 < length; i3++) {
                byteArrayOutputStream.write(cipher.doFinal(bArr, i3 * 384, 384));
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalBlockSizeException("The size of data is not a multiple of cipher block size. Data size=" + bArr.length);
    }

    public static synchronized VsAppKeyVerify getInstance() {
        VsAppKeyVerify vsAppKeyVerify;
        synchronized (VsAppKeyVerify.class) {
            if (instance == null) {
                instance = new VsAppKeyVerify();
            }
            vsAppKeyVerify = instance;
        }
        return vsAppKeyVerify;
    }

    public VsAppKeyBean verifyVsAppKey(Context context, String str) {
        if (str != null && !str.isEmpty()) {
            try {
                this.mContext = context;
                byte[] decrypt = decrypt(KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(PUB_KEY_BASE, 0))), Base64.decode(str, 0));
                VsLog.info(new String(decrypt), new Object[0]);
                Properties properties = new Properties();
                properties.load(new ByteArrayInputStream(decrypt));
                String property = properties.getProperty("vskey");
                VsLog.info(property, new Object[0]);
                if (property == null) {
                    VsLog.error("verify appkey fail vskey", new Object[0]);
                }
                String property2 = properties.getProperty("platform");
                if (property2 == null) {
                    VsLog.error("verify appkey fail platform", new Object[0]);
                }
                String property3 = properties.getProperty("sdtfrom");
                if (property3 == null) {
                    VsLog.error("verify appkey fail sdtfrom", new Object[0]);
                }
                String property4 = properties.getProperty("pkg");
                if (property4 == null) {
                    VsLog.error("verify appkey fail pkg", new Object[0]);
                }
                String packageName = this.mContext.getPackageName();
                if (!packageName.equals(property4)) {
                    VsLog.error("verify appkey fail pkg %s %s", packageName, property4);
                }
                VsAppKeyBean vsAppKeyBean = new VsAppKeyBean(property2, property3, property, property4);
                VsAppKeyUtil.getInstance().add(vsAppKeyBean);
                return vsAppKeyBean;
            } catch (Throwable th5) {
                if (th5 instanceof GeneralSecurityException) {
                    VsLog.error(th5.toString(), new Object[0]);
                } else {
                    VsLog.error(th5.toString(), new Object[0]);
                }
            }
        }
        return null;
    }
}
