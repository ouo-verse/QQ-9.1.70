package com.tencent.mobileqq.search.api.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.tencent.mobileqq.search.api.IGroupSearchHistoryManager;
import com.tencent.mobileqq.search.util.MmkvKeys;
import com.tencent.mobileqq.search.util.ah;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GroupSearchHistoryManagerImpl implements IGroupSearchHistoryManager {
    private static final int MAX_COUNT = 15;
    private static final String REGEX = ",";
    private final List<String> historyItemList = new ArrayList();
    private String stringCache = "";
    private final Collection<kn2.d> listeners = new ArraySet();

    private void initHistoryItemList() {
        if (!this.historyItemList.isEmpty()) {
            return;
        }
        String h16 = ah.f284994a.h(MmkvKeys.MMKV_KEY_GROUP_SEARCH_HISTORY_KEY, "");
        this.stringCache = h16;
        if (TextUtils.isEmpty(h16)) {
            return;
        }
        this.historyItemList.clear();
        for (String str : this.stringCache.split(",")) {
            if (!TextUtils.isEmpty(str)) {
                this.historyItemList.add(str);
            }
        }
    }

    private void notifyListeners() {
        List<String> groupSearchHistory = getGroupSearchHistory();
        Iterator<kn2.d> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().a(groupSearchHistory);
        }
    }

    private void updateStringCache() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.historyItemList.size(); i3++) {
            if (i3 != 0) {
                sb5.append(",");
            }
            sb5.append(this.historyItemList.get(i3));
        }
        String sb6 = sb5.toString();
        this.stringCache = sb6;
        ah.f284994a.r(MmkvKeys.MMKV_KEY_GROUP_SEARCH_HISTORY_KEY, sb6);
    }

    @Override // com.tencent.mobileqq.search.api.IGroupSearchHistoryManager
    public void add(@NonNull String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            initHistoryItemList();
            this.historyItemList.remove(str);
            this.historyItemList.add(0, str);
            if (this.historyItemList.size() > 15) {
                this.historyItemList.remove(r3.size() - 1);
            }
            updateStringCache();
            notifyListeners();
        }
    }

    @Override // com.tencent.mobileqq.search.api.IGroupSearchHistoryManager
    public void clear() {
        initHistoryItemList();
        if (TextUtils.isEmpty(this.stringCache)) {
            return;
        }
        this.historyItemList.clear();
        updateStringCache();
        notifyListeners();
    }

    @Override // com.tencent.mobileqq.search.api.IGroupSearchHistoryManager
    public void delete(@NonNull String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            initHistoryItemList();
            this.historyItemList.remove(str);
            updateStringCache();
            notifyListeners();
        }
    }

    @Override // com.tencent.mobileqq.search.api.IGroupSearchHistoryManager
    @NonNull
    public List<String> getGroupSearchHistory() {
        initHistoryItemList();
        return this.historyItemList;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.historyItemList.clear();
        this.listeners.clear();
    }

    @Override // com.tencent.mobileqq.search.api.IGroupSearchHistoryManager
    public void register(@NonNull kn2.d dVar) {
        this.listeners.add(dVar);
    }

    @Override // com.tencent.mobileqq.search.api.IGroupSearchHistoryManager
    public void unregister(@NonNull kn2.d dVar) {
        this.listeners.remove(dVar);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
