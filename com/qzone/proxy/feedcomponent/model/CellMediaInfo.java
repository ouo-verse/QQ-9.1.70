package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellMediaInfo implements SmartParcelable {

    @NeedParcel
    public PictureUrl albumCoverUrl;

    @NeedParcel
    public String albumId;

    @NeedParcel
    public String albumName;

    @NeedParcel
    public int albumUploadNum;

    @NeedParcel
    public ArrayList<Media> mediaItems;

    @NeedParcel
    public int uploadNum;
}
