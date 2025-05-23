package com.qzone.album.business.search;

import NS_MOBILE_PHOTO.PhotoSearchBoxChosenItem;
import NS_MOBILE_PHOTO.PhotoSearchBoxChosenItemElem;
import NS_MOBILE_PHOTO.PhotoSearchBoxItem;
import NS_MOBILE_PHOTO.PhotoSearchBoxItemElem;
import android.content.Intent;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SearchFilterComposition implements SmartParcelable {

    @NeedParcel
    public ArrayList<SearchFilter> flatternedFilters;

    @NeedParcel
    public ArrayList<Integer> typesSeq;

    public SearchFilter getFilterAt(int i3) {
        ArrayList<SearchFilter> arrayList;
        if (!isDataValid()) {
            return null;
        }
        ArrayList<SearchFilter> arrayList2 = this.flatternedFilters;
        if (i3 >= (arrayList2 == null ? 0 : arrayList2.size()) || (arrayList = this.flatternedFilters) == null) {
            return null;
        }
        return arrayList.get(i3);
    }

    public boolean isDataValid() {
        ArrayList<Integer> arrayList;
        ArrayList<SearchFilter> arrayList2 = this.flatternedFilters;
        return (arrayList2 == null || arrayList2.isEmpty() || (arrayList = this.typesSeq) == null || arrayList.isEmpty()) ? false : true;
    }

    public HashMap<Integer, PhotoSearchBoxChosenItem> toChosenItemMap() {
        ArrayList<PhotoSearchBoxChosenItemElem> arrayList;
        if (!isDataValid()) {
            return null;
        }
        HashMap<Integer, PhotoSearchBoxChosenItem> hashMap = new HashMap<>();
        Iterator<SearchFilter> it = this.flatternedFilters.iterator();
        while (it.hasNext()) {
            SearchFilter next = it.next();
            if (next != null) {
                if (!hashMap.containsKey(Integer.valueOf(next.filterType))) {
                    PhotoSearchBoxChosenItem photoSearchBoxChosenItem = new PhotoSearchBoxChosenItem();
                    photoSearchBoxChosenItem.elems = new ArrayList<>();
                    hashMap.put(Integer.valueOf(next.filterType), photoSearchBoxChosenItem);
                }
                if (hashMap.containsKey(Integer.valueOf(next.filterType))) {
                    PhotoSearchBoxChosenItem photoSearchBoxChosenItem2 = hashMap.get(Integer.valueOf(next.filterType));
                    PhotoSearchBoxChosenItemElem chosenItemElem = next.toChosenItemElem();
                    if (chosenItemElem != null && photoSearchBoxChosenItem2 != null && (arrayList = photoSearchBoxChosenItem2.elems) != null) {
                        arrayList.add(chosenItemElem);
                    }
                }
            }
        }
        if (hashMap.size() == this.typesSeq.size()) {
            return hashMap;
        }
        return null;
    }

    public static SearchFilterComposition createdFromPhotoSearchBox(List<Integer> list, Map<Integer, PhotoSearchBoxItem> map) {
        ArrayList<PhotoSearchBoxItemElem> arrayList;
        if (map == null || map.isEmpty() || list == null || list.isEmpty()) {
            return null;
        }
        SearchFilterComposition searchFilterComposition = new SearchFilterComposition();
        searchFilterComposition.flatternedFilters = new ArrayList<>();
        searchFilterComposition.typesSeq = new ArrayList<>();
        for (Integer num : list) {
            PhotoSearchBoxItem photoSearchBoxItem = map.get(num);
            if (photoSearchBoxItem != null && (arrayList = photoSearchBoxItem.elems) != null && !arrayList.isEmpty()) {
                searchFilterComposition.typesSeq.add(num);
                Iterator<PhotoSearchBoxItemElem> it = photoSearchBoxItem.elems.iterator();
                while (it.hasNext()) {
                    SearchFilter createdFromFilterItemElem = SearchFilter.createdFromFilterItemElem(it.next());
                    if (createdFromFilterItemElem != null) {
                        searchFilterComposition.flatternedFilters.add(createdFromFilterItemElem);
                    }
                }
            }
        }
        return searchFilterComposition;
    }

    public static void serializeMeToIntent(Intent intent, SearchFilterComposition searchFilterComposition) {
        if (intent == null) {
            return;
        }
        ParcelableWrapper.putDataToIntent(intent, QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_SEARCH_FILTER, searchFilterComposition);
    }

    public static SearchFilterComposition deSerializeMeFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (SearchFilterComposition) ParcelableWrapper.getDataFromeIntent(intent, QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_SEARCH_FILTER);
    }
}
