package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }

    private int getFileSize(String str) {
        return b.a(str);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        byte[] bArr;
        String str2;
        String str3 = this.extInfo;
        if ((str3 != null && str3.length() != 0) || (((str = this.filePath) != null && str.length() != 0) || ((bArr = this.fileData) != null && bArr.length != 0))) {
            String str4 = this.extInfo;
            if (str4 != null && str4.length() > 2048) {
                str2 = "checkArgs fail, extInfo is invalid";
            } else {
                String str5 = this.filePath;
                if (str5 != null && str5.length() > 10240) {
                    str2 = "checkArgs fail, filePath is invalid";
                } else {
                    String str6 = this.filePath;
                    if (str6 != null && getFileSize(str6) > 10485760) {
                        str2 = "checkArgs fail, fileSize is too large";
                    } else {
                        byte[] bArr2 = this.fileData;
                        if (bArr2 != null && bArr2.length > 10485760) {
                            str2 = "checkArgs fail, fileData is too large";
                        } else {
                            return true;
                        }
                    }
                }
            }
        } else {
            str2 = "checkArgs fail, all arguments is null";
        }
        Log.e(TAG, str2);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 7;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
    }
}
