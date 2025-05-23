package com.tencent.youtu.sdkkitframework.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTImageData {
    public static final /* synthetic */ boolean $assertionsDisabled;
    static IPatchRedirector $redirector_;
    private static final String TAG;
    public String checksum;
    public int height;
    public byte[] imgData;
    public String imgDataBase64;
    public long timeStamp;
    public int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18554);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            $assertionsDisabled = true;
            TAG = YTImageData.class.getSimpleName();
        }
    }

    public YTImageData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private int[] convertBGRByteToColor(byte[] bArr) {
        int i3;
        int i16;
        int length = bArr.length;
        if (length == 0) {
            return null;
        }
        int i17 = 0;
        if (length % 3 != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i18 = (length / 3) + i3;
        int[] iArr = new int[i18];
        if (i3 == 0) {
            while (i17 < i18) {
                int i19 = i17 * 3;
                iArr[i17] = ((bArr[i19 + 2] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | (bArr[i19] & 255) | ((bArr[i19 + 1] << 8) & 65280) | (-16777216);
                i17++;
            }
        } else {
            while (true) {
                i16 = i18 - 1;
                if (i17 >= i16) {
                    break;
                }
                int i26 = i17 * 3;
                iArr[i17] = ((bArr[i26 + 2] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | (bArr[i26] & 255) | ((bArr[i26 + 1] << 8) & 65280) | (-16777216);
                i17++;
            }
            iArr[i16] = -16777216;
        }
        return iArr;
    }

    private int[] convertRGBByteToColor(byte[] bArr) {
        int i3;
        int i16;
        int length = bArr.length;
        if (length == 0) {
            return null;
        }
        int i17 = 0;
        if (length % 3 != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i18 = (length / 3) + i3;
        int[] iArr = new int[i18];
        if (i3 == 0) {
            while (i17 < i18) {
                int i19 = i17 * 3;
                iArr[i17] = (bArr[i19 + 2] & 255) | ((bArr[i19] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[i19 + 1] << 8) & 65280) | (-16777216);
                i17++;
            }
        } else {
            while (true) {
                i16 = i18 - 1;
                if (i17 >= i16) {
                    break;
                }
                int i26 = i17 * 3;
                iArr[i17] = (bArr[i26 + 2] & 255) | ((bArr[i26] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT) | ((bArr[i26 + 1] << 8) & 65280) | (-16777216);
                i17++;
            }
            iArr[i16] = -16777216;
        }
        return iArr;
    }

    public Bitmap bgr2Bitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Bitmap) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        int[] convertBGRByteToColor = convertBGRByteToColor(this.imgData);
        if (!$assertionsDisabled && convertBGRByteToColor == null) {
            throw new AssertionError();
        }
        int i3 = this.width;
        return Bitmap.createBitmap(convertBGRByteToColor, 0, i3, i3, this.height, Bitmap.Config.ARGB_8888);
    }

    public byte[] bgr2JPEG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? bgr2JPEG(100) : (byte[]) iPatchRedirector.redirect((short) 17, (Object) this);
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this);
        }
        YTImageData yTImageData = new YTImageData();
        yTImageData.imgData = (byte[]) this.imgData.clone();
        yTImageData.width = this.width;
        yTImageData.height = this.height;
        return yTImageData;
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.height;
    }

    public byte[] getImgData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.imgData;
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.width;
    }

    public void setHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.height = i3;
        }
    }

    public void setImgData(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
        } else {
            this.imgData = bArr;
        }
    }

    public void setWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.width = i3;
        }
    }

    public JSONObject toJSON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (JSONObject) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("img", this.imgData);
            jSONObject.put("checksum", this.checksum);
            return jSONObject;
        } catch (JSONException e16) {
            YtLogger.e(TAG, "video data tojson error", e16);
            return new JSONObject();
        }
    }

    public JSONObject toJSON64Img() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (JSONObject) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("img", this.imgDataBase64);
            jSONObject.put("checksum", this.checksum);
            return jSONObject;
        } catch (JSONException e16) {
            YtLogger.e(TAG, "video data tojson error", e16);
            return new JSONObject();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "ImageData{imgDataSize=" + this.imgData.length + ", width=" + this.width + ", height=" + this.height + '}';
    }

    public void writeImg2LocalDisk(Bitmap bitmap, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, bitmap, str, str2);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FileUtils.createFile(str, str2));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        } catch (IOException e17) {
            e17.printStackTrace();
        }
    }

    public Bitmap yuv2Bitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Bitmap) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        YuvImage yuvImage = new YuvImage(this.imgData, 17, this.width, this.height, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 95, byteArrayOutputStream);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e16) {
            YtLogger.e(TAG, "close error", e16);
        }
        return decodeByteArray;
    }

    public YTImageData(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.imgData = bArr;
        this.width = i3;
        this.height = i16;
    }

    public byte[] bgr2JPEG(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (byte[]) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        int[] convertBGRByteToColor = convertBGRByteToColor((byte[]) this.imgData.clone());
        if (!$assertionsDisabled && convertBGRByteToColor == null) {
            throw new AssertionError();
        }
        int i16 = this.width;
        Bitmap createBitmap = Bitmap.createBitmap(convertBGRByteToColor, 0, i16, i16, this.height, Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e16) {
            YtLogger.e(TAG, "close error", e16);
        }
        return byteArray;
    }

    public YTImageData(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        this.width = i3;
        this.height = i16;
        this.imgDataBase64 = str;
    }
}
