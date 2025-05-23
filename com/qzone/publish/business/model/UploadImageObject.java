package com.qzone.publish.business.model;

import com.tencent.component.annotation.NeedParcel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UploadImageObject extends UploadObject {
    public static final int IMAGE_TYPE_LOCAL = 1;
    public static final int IMAGE_TYPE_NETWORK = 2;
    public static final int IMAGE_TYPE_PLUS_URL = 3;

    @NeedParcel
    public int is_appext_pic;

    @NeedParcel
    private String mDescription;

    @NeedParcel
    private HashMap<String, Object> mExtraData;

    @NeedParcel
    private AlbumPhotoInfo mPicInfo;

    @NeedParcel
    private int mType;

    @NeedParcel
    public String pic_url;

    @NeedParcel
    public String richval;

    public UploadImageObject(String str) {
        super(str);
        this.mType = 1;
        this.is_appext_pic = 0;
        this.richval = "";
        this.pic_url = "";
        this.mExtraData = new HashMap<>();
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Object getExtraData(String str) {
        return this.mExtraData.get(str);
    }

    public AlbumPhotoInfo getPicInfo() {
        return this.mPicInfo;
    }

    public int getType() {
        return this.mType;
    }

    public boolean needToUpload() {
        int type = getType();
        if (type != 1) {
            return type == 2 && getPicInfo() == null;
        }
        return true;
    }

    public void putExtarData(String str, Object obj) {
        this.mExtraData.put(str, obj);
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String toString() {
        return super.toString() + getFilePath();
    }

    public static UploadImageObject createFromLocalImageInfo(LocalImageInfo localImageInfo) {
        if (localImageInfo == null) {
            return null;
        }
        UploadImageObject uploadImageObject = new UploadImageObject(localImageInfo.getPath());
        HashMap<String, Object> extraData = localImageInfo.getExtraData();
        if (extraData != null) {
            uploadImageObject.mExtraData = extraData;
        }
        uploadImageObject.mDescription = localImageInfo.getDescription();
        if (localImageInfo instanceof NetworkImageInfo) {
            uploadImageObject.mType = 2;
            uploadImageObject.mPicInfo = ((NetworkImageInfo) localImageInfo).getPicInfo();
        }
        return uploadImageObject;
    }

    public static ArrayList<UploadImageObject> createListFromLocalImageInfoList(List<LocalImageInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList<UploadImageObject> arrayList = new ArrayList<>(list.size());
        Iterator<LocalImageInfo> it = list.iterator();
        while (it.hasNext()) {
            UploadImageObject createFromLocalImageInfo = createFromLocalImageInfo(it.next());
            if (createFromLocalImageInfo != null) {
                arrayList.add(createFromLocalImageInfo);
            }
        }
        return arrayList;
    }
}
