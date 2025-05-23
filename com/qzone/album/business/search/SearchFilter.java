package com.qzone.album.business.search;

import NS_MOBILE_PHOTO.PhotoSearchBoxChosenItemElem;
import NS_MOBILE_PHOTO.PhotoSearchBoxItemElem;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SearchFilter implements SmartParcelable {
    public static final int VIEW_TYPE_IMAGE = 1;
    public static final int VIEW_TYPE_TEXT = 0;

    @NeedParcel
    public int filterType = 0;

    @NeedParcel
    public String filterID = "";

    @NeedParcel
    public String filterContent = "";

    @NeedParcel
    public String filterPortaitUrl = "";

    public int getViewType() {
        return this.filterType == 1 ? 1 : 0;
    }

    public PhotoSearchBoxChosenItemElem toChosenItemElem() {
        PhotoSearchBoxChosenItemElem photoSearchBoxChosenItemElem = new PhotoSearchBoxChosenItemElem();
        photoSearchBoxChosenItemElem.categoryid = this.filterID;
        photoSearchBoxChosenItemElem.type = this.filterType;
        return photoSearchBoxChosenItemElem;
    }

    public static SearchFilter createdFromFilterItemElem(PhotoSearchBoxItemElem photoSearchBoxItemElem) {
        if (photoSearchBoxItemElem == null) {
            return null;
        }
        SearchFilter searchFilter = new SearchFilter();
        searchFilter.filterType = photoSearchBoxItemElem.type;
        searchFilter.filterID = photoSearchBoxItemElem.categoryid;
        searchFilter.filterContent = photoSearchBoxItemElem.desc;
        searchFilter.filterPortaitUrl = photoSearchBoxItemElem.url;
        return searchFilter;
    }
}
