package com.tencent.richmediabrowser.model;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import f04.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MainBrowserModel implements a {
    public List<RichMediaBrowserInfo> browserDataList = new ArrayList();
    private MainBrowserPresenter browserPresenter;
    public RichMediaBrowserInfo currentBrowserInfo;
    public int currentIndex;

    public MainBrowserModel(MainBrowserPresenter mainBrowserPresenter) {
        this.browserPresenter = mainBrowserPresenter;
    }

    public int getCount() {
        if (!this.browserDataList.isEmpty()) {
            return this.browserDataList.size();
        }
        return 0;
    }

    public RichMediaBrowserInfo getItem(int i3) {
        if (this.browserDataList.isEmpty() || i3 < 0 || i3 >= this.browserDataList.size()) {
            return null;
        }
        return this.browserDataList.get(i3);
    }

    public int getPosition(String str) {
        RichMediaBaseData richMediaBaseData;
        if (this.browserDataList.isEmpty() || TextUtils.isEmpty(str)) {
            return 0;
        }
        int size = this.browserDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            RichMediaBrowserInfo richMediaBrowserInfo = this.browserDataList.get(i3);
            if (richMediaBrowserInfo != null && (richMediaBaseData = richMediaBrowserInfo.baseData) != null && str.equals(richMediaBaseData.f365136id)) {
                return i3;
            }
        }
        return 0;
    }

    public int getSelectedIndex() {
        return this.currentIndex;
    }

    public RichMediaBrowserInfo getSelectedItem() {
        return this.currentBrowserInfo;
    }

    public void setSelectedIndex(int i3) {
        this.currentIndex = i3;
        this.currentBrowserInfo = getItem(i3);
    }

    public void updateItem(RichMediaBrowserInfo richMediaBrowserInfo) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBaseData richMediaBaseData2;
        if (richMediaBrowserInfo == null || (richMediaBaseData = richMediaBrowserInfo.baseData) == null || TextUtils.isEmpty(richMediaBaseData.f365136id) || this.browserDataList.isEmpty()) {
            return;
        }
        int size = this.browserDataList.size();
        for (int i3 = 0; i3 < size; i3++) {
            RichMediaBrowserInfo richMediaBrowserInfo2 = this.browserDataList.get(i3);
            if (richMediaBrowserInfo2 != null && (richMediaBaseData2 = richMediaBrowserInfo2.baseData) != null && richMediaBrowserInfo.baseData.f365136id.equals(richMediaBaseData2.f365136id)) {
                this.browserDataList.set(i3, richMediaBrowserInfo);
            }
        }
    }

    public void updateItemProgress(String str, int i3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo item = getItem(str);
        if (item != null && (richMediaBaseData = item.baseData) != null) {
            richMediaBaseData.progress = i3;
            updateItem(item);
        }
    }

    public void updateItemStatus(String str, int i3) {
        RichMediaBaseData richMediaBaseData;
        RichMediaBrowserInfo item = getItem(str);
        if (item != null && (richMediaBaseData = item.baseData) != null) {
            richMediaBaseData.status = i3;
            updateItem(item);
        }
    }

    public void updateList(List<RichMediaBrowserInfo> list) {
        this.browserDataList = list;
    }

    public RichMediaBrowserInfo getItem(String str) {
        if (this.browserDataList.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (RichMediaBrowserInfo richMediaBrowserInfo : this.browserDataList) {
            RichMediaBaseData richMediaBaseData = richMediaBrowserInfo.baseData;
            if (richMediaBaseData != null && !TextUtils.isEmpty(richMediaBaseData.f365136id) && str.equals(richMediaBrowserInfo.baseData.f365136id)) {
                return richMediaBrowserInfo;
            }
        }
        return null;
    }

    public void updateItem(RichMediaBrowserInfo richMediaBrowserInfo, int i3) {
        if (richMediaBrowserInfo == null || richMediaBrowserInfo.baseData == null || this.browserDataList.isEmpty() || i3 < 0 || i3 >= this.browserDataList.size()) {
            return;
        }
        this.browserDataList.set(i3, richMediaBrowserInfo);
    }

    @Override // f04.a
    public void buildComplete() {
    }

    @Override // f04.a
    public void buildModel() {
    }

    @Override // f04.a
    public void buildParams(Intent intent) {
    }
}
