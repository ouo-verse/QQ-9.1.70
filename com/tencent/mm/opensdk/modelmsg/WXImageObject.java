package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.ByteArrayOutputStream;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 26214400;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    public byte[] imageData;
    public String imagePath;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e16) {
            Log.e(TAG, "WXImageObject <init>, exception:" + e16.getMessage());
        }
    }

    private int getFileSize(String str) {
        return b.a(str);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        String str2;
        byte[] bArr = this.imageData;
        if ((bArr != null && bArr.length != 0) || ((str = this.imagePath) != null && str.length() != 0)) {
            byte[] bArr2 = this.imageData;
            if (bArr2 != null && bArr2.length > 26214400) {
                str2 = "checkArgs fail, content is too large";
            } else {
                String str3 = this.imagePath;
                if (str3 != null && str3.length() > 10240) {
                    str2 = "checkArgs fail, path is invalid";
                } else {
                    String str4 = this.imagePath;
                    if (str4 != null && getFileSize(str4) > 26214400) {
                        str2 = "checkArgs fail, image content is too large";
                    } else {
                        return true;
                    }
                }
            }
        } else {
            str2 = "checkArgs fail, all arguments are null";
        }
        Log.e(TAG, str2);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }
}
