package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchFEHotwordItems {
    private final List<SmartBox_HotWordsItem> items;

    public SearchFEHotwordItems(@NonNull List<SmartBox_HotWordsItem> list) {
        this.items = list;
    }

    @NonNull
    public String getJsonArrayStr() {
        try {
            return new Gson().toJson(this.items);
        } catch (Exception unused) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }
}
