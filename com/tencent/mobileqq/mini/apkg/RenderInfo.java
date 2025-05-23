package com.tencent.mobileqq.mini.apkg;

import NS_MINI_INTERFACE.INTERFACE$StRenderInfo;
import NS_MINI_INTERFACE.INTERFACE$StRenderMaterial;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RenderInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<RenderInfo> CREATOR = new Parcelable.Creator<RenderInfo>() { // from class: com.tencent.mobileqq.mini.apkg.RenderInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RenderInfo createFromParcel(Parcel parcel) {
            return new RenderInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RenderInfo[] newArray(int i3) {
            return new RenderInfo[i3];
        }
    };
    public Map<Integer, String> renderMaterialMap;
    public int renderMode;

    public RenderInfo() {
        this.renderMaterialMap = new HashMap();
    }

    public static RenderInfo from(INTERFACE$StRenderInfo iNTERFACE$StRenderInfo) {
        RenderInfo renderInfo = new RenderInfo();
        if (iNTERFACE$StRenderInfo != null) {
            renderInfo.renderMode = iNTERFACE$StRenderInfo.renderMode.get();
            List<INTERFACE$StRenderMaterial> list = iNTERFACE$StRenderInfo.renderMaterials.get();
            if (list != null) {
                for (INTERFACE$StRenderMaterial iNTERFACE$StRenderMaterial : list) {
                    int i3 = iNTERFACE$StRenderMaterial.renderMode.get();
                    String str = iNTERFACE$StRenderMaterial.downloadUrl.get();
                    if (!TextUtils.isEmpty(str)) {
                        renderInfo.renderMaterialMap.put(Integer.valueOf(i3), str);
                    }
                }
            }
        }
        return renderInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.renderMode);
        parcel.writeInt(this.renderMaterialMap.size());
        for (Map.Entry<Integer, String> entry : this.renderMaterialMap.entrySet()) {
            parcel.writeValue(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    protected RenderInfo(Parcel parcel) {
        this.renderMaterialMap = new HashMap();
        this.renderMode = parcel.readInt();
        int readInt = parcel.readInt();
        this.renderMaterialMap = new HashMap(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            this.renderMaterialMap.put((Integer) parcel.readValue(Integer.class.getClassLoader()), parcel.readString());
        }
    }
}
