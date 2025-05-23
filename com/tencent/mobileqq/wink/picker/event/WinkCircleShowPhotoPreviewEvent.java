package com.tencent.mobileqq.wink.picker.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;

/* loaded from: classes21.dex */
public class WinkCircleShowPhotoPreviewEvent extends SimpleBaseEvent {
    public boolean mIsFromCustomSticker;
    public boolean mIsFromPicMove;
    public boolean mIsFromQZoneAlbum;
    public boolean mNeedFace;
    public List<LocalMediaInfo> mPhotoInfoList;
    public int mPosition;

    public WinkCircleShowPhotoPreviewEvent(List<LocalMediaInfo> list, int i3, boolean z16, boolean z17) {
        this(list, i3, z16, z17, false, false);
    }

    public WinkCircleShowPhotoPreviewEvent(List<LocalMediaInfo> list, int i3, boolean z16, boolean z17, boolean z18, boolean z19) {
        this.mPhotoInfoList = list;
        this.mPosition = i3;
        this.mIsFromPicMove = z16;
        this.mNeedFace = z17;
        this.mIsFromCustomSticker = z18;
        this.mIsFromQZoneAlbum = z19;
    }
}
