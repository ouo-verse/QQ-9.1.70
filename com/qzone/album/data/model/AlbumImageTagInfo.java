package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.stPhotoTag;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumImageTagInfo implements SmartParcelable {

    @NeedParcel
    public String content;

    @NeedParcel
    public String poiTagStreet;

    @NeedParcel
    public int xScale;

    @NeedParcel
    public int yScale;

    @NeedParcel
    public int type = 0;

    @NeedParcel
    public String tagId = "";

    @NeedParcel
    public int direction = 2;

    public static ArrayList<AlbumImageTagInfo> createListFrom(ArrayList<stPhotoTag> arrayList) {
        ArrayList<AlbumImageTagInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<stPhotoTag> it = arrayList.iterator();
            while (it.hasNext()) {
                AlbumImageTagInfo createFrom = createFrom(it.next());
                if (createFrom != null) {
                    arrayList2.add(createFrom);
                }
            }
        }
        return arrayList2;
    }

    public String toString() {
        return "AlbumImageTagInfo{type=" + this.type + ", content='" + this.content + "', tagId='" + this.tagId + "', xScale=" + this.xScale + ", yScale=" + this.yScale + ", direction=" + this.direction + ", poiTagStreet='" + this.poiTagStreet + "'}";
    }

    public static AlbumImageTagInfo createFrom(stPhotoTag stphototag) {
        if (stphototag == null) {
            return null;
        }
        AlbumImageTagInfo albumImageTagInfo = new AlbumImageTagInfo();
        albumImageTagInfo.type = stphototag.type;
        albumImageTagInfo.content = stphototag.content;
        albumImageTagInfo.tagId = stphototag.tag_id;
        albumImageTagInfo.xScale = (int) stphototag.x_scale;
        albumImageTagInfo.yScale = (int) stphototag.y_scale;
        albumImageTagInfo.direction = stphototag.direction;
        albumImageTagInfo.poiTagStreet = stphototag.poiTagStreet;
        return albumImageTagInfo;
    }
}
