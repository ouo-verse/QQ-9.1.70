package com.tencent.mobileqq.wink.pb;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class GetMediaMaterialRecommendationRsp extends JceStruct {
    static MediaMatRecInfo[] cache_Materials = new MediaMatRecInfo[1];
    public int Code;
    public long ExpireTime;
    public String Extra;
    public MediaMatRecInfo[] Materials;
    public String SessionID;

    static {
        cache_Materials[0] = new MediaMatRecInfo();
    }

    public GetMediaMaterialRecommendationRsp() {
        this.Code = 0;
        this.Materials = null;
        this.SessionID = "";
        this.ExpireTime = 0L;
        this.Extra = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Code = jceInputStream.read(this.Code, 0, false);
        this.Materials = (MediaMatRecInfo[]) jceInputStream.read((JceStruct[]) cache_Materials, 1, false);
        this.SessionID = jceInputStream.readString(2, false);
        this.ExpireTime = jceInputStream.read(this.ExpireTime, 3, false);
        this.Extra = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Code, 0);
        MediaMatRecInfo[] mediaMatRecInfoArr = this.Materials;
        if (mediaMatRecInfoArr != null) {
            jceOutputStream.write((Object[]) mediaMatRecInfoArr, 1);
        }
        String str = this.SessionID;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.ExpireTime, 3);
        String str2 = this.Extra;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public GetMediaMaterialRecommendationRsp(int i3, MediaMatRecInfo[] mediaMatRecInfoArr, String str, long j3, String str2) {
        this.Code = i3;
        this.Materials = mediaMatRecInfoArr;
        this.SessionID = str;
        this.ExpireTime = j3;
        this.Extra = str2;
    }
}
