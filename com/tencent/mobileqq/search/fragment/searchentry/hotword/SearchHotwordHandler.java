package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.dj;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nn2.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchHotwordHandler extends dj {
    private QQAppInterface app;
    private final HotWordSearchEntryDataModel dataModel;
    private SearchHippyEventEmitter eventEmitter;
    private final UniteSearchHandler uniteSearchHandler;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface OnGetHotwordItemResultListener {
        void onResult(@NonNull SearchFEHotwordItems searchFEHotwordItems);
    }

    public SearchHotwordHandler() {
        if (BaseApplicationImpl.getApplication() != null && (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            this.app = qQAppInterface;
            qQAppInterface.addObserver(this);
        }
        this.dataModel = new HotWordSearchEntryDataModel(7, 10, false);
        this.uniteSearchHandler = new UniteSearchHandler(this.app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public SmartBox_HotWordsItem convertHotSearchItemToSmartBoxHotWordItem(@NonNull HotWordSearchEntryDataModel.HotSearchItem hotSearchItem) {
        SmartBox_HotWordsItem smartBox_HotWordsItem = new SmartBox_HotWordsItem();
        smartBox_HotWordsItem.iId = 1;
        String str = hotSearchItem.title;
        smartBox_HotWordsItem.sTitle = str;
        smartBox_HotWordsItem.sShowTitle = str;
        smartBox_HotWordsItem.sSubShowTitle = str;
        smartBox_HotWordsItem.iExposureCount = hotSearchItem.showCount;
        String str2 = hotSearchItem.jumpUrl;
        if (TextUtils.isEmpty(str2)) {
            str2 = w.g(hotSearchItem.recallWord, 5, "kandian_recomword");
        }
        smartBox_HotWordsItem.sUrl = str2;
        smartBox_HotWordsItem.sAppend = hotSearchItem.sAppend;
        smartBox_HotWordsItem.sItemExtInfo = hotSearchItem.sExtInfo;
        smartBox_HotWordsItem.sTextColor = hotSearchItem.titleTextColor;
        smartBox_HotWordsItem.symbolUrl = hotSearchItem.rightIconUrl;
        return smartBox_HotWordsItem;
    }

    public static Map<String, Object> getHotwordDataMap(@NonNull SearchHotwordHandler searchHotwordHandler, @Nullable String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("hotwords", str);
        }
        hashMap.put("hotwordExtInfo", searchHotwordHandler.getHotwordExtInfo());
        hashMap.put("showHotword", Boolean.valueOf(searchHotwordHandler.isHotwordVisible()));
        hashMap.put("tabHideSettingShow", Boolean.FALSE);
        return hashMap;
    }

    public void destroy() {
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this);
        }
    }

    public String getHotwordExtInfo() {
        String str;
        HotWordSearchEntryDataModel hotWordSearchEntryDataModel = this.dataModel;
        if (hotWordSearchEntryDataModel != null && (str = hotWordSearchEntryDataModel.H) != null) {
            return str;
        }
        return "";
    }

    public void getSearchFEHotwordItems(@NonNull final OnGetHotwordItemResultListener onGetHotwordItemResultListener) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler.1
            @Override // java.lang.Runnable
            public void run() {
                SearchHotwordHandler.this.dataModel.l();
                List<HotWordSearchEntryDataModel.HotSearchItem> q16 = SearchHotwordHandler.this.dataModel.q();
                ArrayList arrayList = new ArrayList();
                if (q16 != null) {
                    Iterator<HotWordSearchEntryDataModel.HotSearchItem> it = q16.iterator();
                    while (it.hasNext()) {
                        arrayList.add(SearchHotwordHandler.this.convertHotSearchItemToSmartBoxHotWordItem(it.next()));
                    }
                }
                onGetHotwordItemResultListener.onResult(new SearchFEHotwordItems(arrayList));
            }
        }, 5, null, true);
    }

    public boolean isHotwordVisible() {
        return a.i(this.app);
    }

    public void notifyFEHotwordChanged() {
        getSearchFEHotwordItems(new OnGetHotwordItemResultListener() { // from class: com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler.2
            @Override // com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler.OnGetHotwordItemResultListener
            public void onResult(@NonNull SearchFEHotwordItems searchFEHotwordItems) {
                if (SearchHotwordHandler.this.eventEmitter == null) {
                    return;
                }
                SearchHotwordHandler.this.eventEmitter.sendCommonEvent(SearchHippyEventEmitter.CommonEvent.HotwordChanged, SearchHotwordHandler.getHotwordDataMap(SearchHotwordHandler.this, searchFEHotwordItems.getJsonArrayStr()));
            }
        });
    }

    public void setEventEmitter(SearchHippyEventEmitter searchHippyEventEmitter) {
        this.eventEmitter = searchHippyEventEmitter;
    }

    public void setHotwordVisibility(boolean z16) {
        a.j(this.app, z16);
    }

    public void onHotwordClick(int i3) {
    }
}
