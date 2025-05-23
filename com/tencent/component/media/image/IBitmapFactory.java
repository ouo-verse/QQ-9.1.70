package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import cooperation.qzone.QZoneHelper;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class IBitmapFactory {
    static final byte[] EMPTY_JPEG_PREFIX;
    static final byte[] EMPTY_JPEG_SUFFIX;
    private static final String TAG = "BitmapFactory";
    static int sEmptyByteSize;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ArtBitmapFactory extends IBitmapFactory {
        ByteArrayPool mByteArrayPool;
        IDecoder mDecoder;

        public ArtBitmapFactory(ByteArrayPool byteArrayPool, IDecoder iDecoder) {
            this.mByteArrayPool = byteArrayPool;
            this.mDecoder = iDecoder;
        }

        @Override // com.tencent.component.media.image.IBitmapFactory
        @TargetApi(12)
        public BitmapReference createBitmap(int i3, int i16, Bitmap.Config config) {
            if (i3 > 0 && i16 > 0) {
                byte[] generate = IBitmapFactory.generate((short) i3, (short) i16, this.mByteArrayPool);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = config;
                BitmapReference decodeImage = this.mDecoder.decodeImage(generate, 0, IBitmapFactory.sEmptyByteSize, options, i3, i16);
                if (decodeImage == null) {
                    return BitmapReference.getBitmapReference(Bitmap.createBitmap(i3, i16, config));
                }
                if (config != Bitmap.Config.RGB_565) {
                    decodeImage.getBitmap().eraseColor(0);
                    decodeImage.getBitmap().setHasAlpha(true);
                }
                if (decodeImage.getWidth() == i3 && decodeImage.getHeight() == i16) {
                    this.mByteArrayPool.release(generate);
                    return decodeImage;
                }
                return BitmapReference.getBitmapReference(Bitmap.createBitmap(i3, i16, config));
            }
            ImageManagerLog.w(IBitmapFactory.TAG, "width height error " + i3 + ", " + i16);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DalvikBitmapFactory extends IBitmapFactory {
        ByteArrayPool mByteArrayPool;
        IDecoder mDecoder;

        DalvikBitmapFactory(ByteArrayPool byteArrayPool, IDecoder iDecoder) {
            this.mByteArrayPool = byteArrayPool;
            this.mDecoder = iDecoder;
        }

        @Override // com.tencent.component.media.image.IBitmapFactory
        @TargetApi(12)
        public synchronized BitmapReference createBitmap(int i3, int i16, Bitmap.Config config) {
            if (i3 > 0 && i16 > 0) {
                byte[] generate = IBitmapFactory.generate((short) i3, (short) i16, this.mByteArrayPool);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                BitmapReference decodeImage = this.mDecoder.decodeImage(generate, 0, IBitmapFactory.sEmptyByteSize, options, -1, -1);
                if (decodeImage == null) {
                    return BitmapReference.getBitmapReference(Bitmap.createBitmap(i3, i16, config));
                }
                decodeImage.getBitmap().eraseColor(0);
                decodeImage.getBitmap().setHasAlpha(true);
                if (decodeImage.getWidth() == i3 && decodeImage.getHeight() == i16) {
                    this.mByteArrayPool.release(generate);
                    return decodeImage;
                }
                return BitmapReference.getBitmapReference(Bitmap.createBitmap(i3, i16, config));
            }
            ImageManagerLog.w(IBitmapFactory.TAG, "width height error " + i3 + ", " + i16);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class DefaultBitmapFactory extends IBitmapFactory {
        IDecoder mDecoder;

        public DefaultBitmapFactory(IDecoder iDecoder) {
            this.mDecoder = iDecoder;
        }

        @Override // com.tencent.component.media.image.IBitmapFactory
        public BitmapReference createBitmap(int i3, int i16, Bitmap.Config config) {
            return BitmapReference.getBitmapReference(Bitmap.createBitmap(i3, i16, config));
        }
    }

    static {
        byte[] bArr = {-1, -40, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -64, 0, 17, 8};
        EMPTY_JPEG_PREFIX = bArr;
        byte[] bArr2 = {3, 1, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, RegisterType.UNINIT_REF, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, Constants.PACKET_LOSS_EFFECT_STATIS, 1, 2, 3, 0, 4, 17, 5, RegisterType.REFERENCE, 33, 49, 65, 6, RegisterType.CONFLICTED, 81, 97, 7, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 50, -127, -111, -95, 8, 35, 66, -79, -63, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 82, -47, -16, 36, 51, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, -126, 9, 10, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, RegisterType.REFERENCE, 65, 81, 7, 97, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, RegisterType.CONFLICTED, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 50, -127, 8, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, -47, 10, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 36, 52, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, 40, -96, RegisterType.DOUBLE_HI, -1, -39};
        EMPTY_JPEG_SUFFIX = bArr2;
        sEmptyByteSize = bArr.length + bArr2.length + 4;
    }

    public static void arraycopy(byte[] bArr, int i3, byte[] bArr2, int i16, int i17) {
        if (bArr != null) {
            if (bArr2 != null) {
                if (i3 >= 0 && i16 >= 0 && i17 >= 0 && i3 <= bArr.length - i17 && i16 <= bArr2.length - i17) {
                    if (bArr == bArr2 && i3 < i16 && i16 < i3 + i17) {
                        for (int i18 = i17 - 1; i18 >= 0; i18--) {
                            bArr2[i16 + i18] = bArr[i3 + i18];
                        }
                        return;
                    }
                    for (int i19 = 0; i19 < i17; i19++) {
                        bArr2[i16 + i19] = bArr[i3 + i19];
                    }
                    return;
                }
                throw new ArrayIndexOutOfBoundsException("src.length=" + bArr.length + " srcPos=" + i3 + " dst.length=" + bArr2.length + " dstPos=" + i16 + " length=" + i17);
            }
            throw new NullPointerException("dst == null");
        }
        throw new NullPointerException("src == null");
    }

    static byte[] generate(short s16, short s17, ByteArrayPool byteArrayPool) {
        byte[] bArr = byteArrayPool.get(sEmptyByteSize);
        byte[] bArr2 = EMPTY_JPEG_PREFIX;
        arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        bArr[bArr2.length] = (byte) (s17 >> 8);
        bArr[bArr2.length + 1] = (byte) (s17 & 255);
        bArr[bArr2.length + 2] = (byte) (s16 >> 8);
        bArr[bArr2.length + 3] = (byte) (s16 & 255);
        byte[] bArr3 = EMPTY_JPEG_SUFFIX;
        arraycopy(bArr3, 0, bArr, bArr2.length + 4, bArr3.length);
        return bArr;
    }

    public abstract BitmapReference createBitmap(int i3, int i16, Bitmap.Config config);
}
