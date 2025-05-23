package com.tencent.aelight.camera.ae.album.data;

import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEAlbumLogicData implements OtherCommonData, Serializable {
    public boolean canMixPhotoAndVideo;
    public boolean canPickVideo;
    public boolean canSwitchSelectionMode;
    public int initialHasPickedNum;
    public int maxSelectNumForMix;
    public int maxSelectNumForNormal;
    public int minSelectNumForMix;
    public int minSelectNumForNormal;

    public String toString() {
        return "AEAlbumLogicData{canMixPhotoAndVideo=" + this.canMixPhotoAndVideo + ", minSelectNumForNormal=" + this.minSelectNumForNormal + ", maxSelectNumForNormal=" + this.maxSelectNumForNormal + ", minSelectNumForMix=" + this.minSelectNumForMix + ", maxSelectNumForMix=" + this.maxSelectNumForMix + ", canSwitchSelectionMode=" + this.canSwitchSelectionMode + ", initialHasPickedNum=" + this.initialHasPickedNum + ", canPickVideo=" + this.canPickVideo + '}';
    }
}
