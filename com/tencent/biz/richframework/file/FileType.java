package com.tencent.biz.richframework.file;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.file.info.AVIFInfo;
import com.tencent.biz.richframework.file.info.AVIInfo;
import com.tencent.biz.richframework.file.info.BMPInfo;
import com.tencent.biz.richframework.file.info.DNGInfo;
import com.tencent.biz.richframework.file.info.GIFInfo;
import com.tencent.biz.richframework.file.info.HEICInfo;
import com.tencent.biz.richframework.file.info.HEIFInfo;
import com.tencent.biz.richframework.file.info.IFileTypeInfo;
import com.tencent.biz.richframework.file.info.JPEGInfo;
import com.tencent.biz.richframework.file.info.MKVInfo;
import com.tencent.biz.richframework.file.info.MOVInfo;
import com.tencent.biz.richframework.file.info.MP3Info;
import com.tencent.biz.richframework.file.info.MP4Info;
import com.tencent.biz.richframework.file.info.MPEGInfo;
import com.tencent.biz.richframework.file.info.PNGInfo;
import com.tencent.biz.richframework.file.info.ThreeGPInfo;
import com.tencent.biz.richframework.file.info.WEBPInfo;
import com.tencent.biz.richframework.file.info.WMVInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public enum FileType {
    JPEG(JPEGInfo.class),
    PNG(PNGInfo.class),
    GIF(GIFInfo.class),
    BMP(BMPInfo.class),
    HEIF(HEIFInfo.class),
    HEIC(HEICInfo.class),
    AVIF(AVIFInfo.class),
    WEBP(WEBPInfo.class),
    DNG(DNGInfo.class),
    MPEG(MPEGInfo.class),
    WMV(WMVInfo.class),
    MP4(MP4Info.class),
    MOV(MOVInfo.class),
    AVI(AVIInfo.class),
    MKV(MKVInfo.class),
    ThreeGP(ThreeGPInfo.class),
    MP3(MP3Info.class);

    private IFileTypeInfo mTypeInfo;

    FileType(Class cls) {
        try {
            this.mTypeInfo = (IFileTypeInfo) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e16) {
            RFWLog.e("FileType", RFWLog.USR, e16);
        }
    }

    public IFileTypeInfo getTypeInfo() {
        return this.mTypeInfo;
    }

    public boolean matches(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : getTypeInfo().getHeaders()) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
