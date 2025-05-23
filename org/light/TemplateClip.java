package org.light;

import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TemplateClip extends ClipAsset {
    public LightAsset asset;
    public ClipAsset[] clipAssets;

    public TemplateClip() {
    }

    protected TemplateClip(Parcel parcel) {
        super(parcel);
        this.asset = (LightAsset) parcel.readParcelable(LightAsset.class.getClassLoader());
        Object[] readParcelableArray = parcel.readParcelableArray(TemplateClip.class.getClassLoader());
        if (readParcelableArray == null) {
            return;
        }
        this.clipAssets = new ClipAsset[readParcelableArray.length];
        int i3 = 0;
        while (true) {
            ClipAsset[] clipAssetArr = this.clipAssets;
            if (i3 >= clipAssetArr.length) {
                return;
            }
            clipAssetArr[i3] = (ClipAsset) readParcelableArray[i3];
            i3++;
        }
    }
}
