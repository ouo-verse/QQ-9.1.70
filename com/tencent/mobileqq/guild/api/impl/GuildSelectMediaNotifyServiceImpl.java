package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildSelectMediaNotifyServiceImpl implements IGuildSelectMediaNotifyService {
    private static final String KEY_PREFIX = "select_photos_from_";
    private static final String TAG = "GuildSelectMediaNotifyServiceImpl";
    private ConcurrentHashMap<Integer, com.tencent.mobileqq.guild.api.g> mListenerMap = new ConcurrentHashMap<>();

    private void onNotifyClearStatus() {
        Iterator<Map.Entry<Integer, com.tencent.mobileqq.guild.api.g>> it = this.mListenerMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
    }

    private void onNotifyRefresh() {
        Iterator<Map.Entry<Integer, com.tencent.mobileqq.guild.api.g>> it = this.mListenerMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onRefresh();
        }
    }

    private void onNotifySelectMediaItemChanged(int i3, boolean z16, LocalMediaInfo localMediaInfo) {
        Iterator<Map.Entry<Integer, com.tencent.mobileqq.guild.api.g>> it = this.mListenerMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b(i3, z16, localMediaInfo);
        }
    }

    private void onSelectChanedAddItem(int i3, LocalMediaInfo localMediaInfo, com.tencent.mobileqq.activity.aio.p pVar) {
        ArrayList<LocalMediaInfo> selectedMediaInfos = getSelectedMediaInfos(pVar);
        if (selectedMediaInfos == null) {
            selectedMediaInfos = new ArrayList<>();
        }
        selectedMediaInfos.add(localMediaInfo);
        updateSelectedMediaInfo(pVar, selectedMediaInfos);
        onNotifySelectMediaItemChanged(i3, true, localMediaInfo);
    }

    private void onSelectChangedRemoveItem(int i3, LocalMediaInfo localMediaInfo, com.tencent.mobileqq.activity.aio.p pVar) {
        ArrayList<LocalMediaInfo> selectedMediaInfos = getSelectedMediaInfos(pVar);
        if (selectedMediaInfos == null) {
            return;
        }
        Iterator<LocalMediaInfo> it = selectedMediaInfos.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (localMediaInfo.path.equals(it.next().path)) {
                it.remove();
                break;
            }
        }
        updateSelectedMediaInfo(pVar, selectedMediaInfos);
        onNotifySelectMediaItemChanged(i3, false, localMediaInfo);
    }

    private void updateSelectedMediaInfo(com.tencent.mobileqq.activity.aio.p pVar, ArrayList<LocalMediaInfo> arrayList) {
        if (!checkSessionInfo(pVar)) {
            QLog.i(TAG, 1, "updateSelectedMediaInfo session arg error !");
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Bundle b16 = pVar.b();
            b16.putParcelableArrayList(getKey(pVar.f179557e), arrayList);
            pVar.f(b16);
        } else {
            String key = getKey(pVar.f179557e);
            Bundle b17 = pVar.b();
            b17.remove(key);
            pVar.f(b17);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public void changeSelectMediaRawType(com.tencent.mobileqq.activity.aio.p pVar, int i3) {
        if (!checkSessionInfo(pVar)) {
            QLog.i(TAG, 1, "resetSelectedMediaInfo session arg error !");
            return;
        }
        ArrayList<LocalMediaInfo> selectedMediaInfos = getSelectedMediaInfos(pVar);
        if (selectedMediaInfos == null || getSelectMediaRawType(pVar) == i3) {
            return;
        }
        boolean z16 = i3 == 2;
        Iterator<LocalMediaInfo> it = selectedMediaInfos.iterator();
        while (it.hasNext()) {
            it.next().isRwa = z16;
        }
        resetSelectedMediaInfo(pVar, selectedMediaInfos);
    }

    public String getKey(String str) {
        return KEY_PREFIX + str;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public int getSelectMediaRawType(com.tencent.mobileqq.activity.aio.p pVar) {
        if (!checkSessionInfo(pVar)) {
            QLog.i(TAG, 1, "resetSelectedMediaInfo session arg error !");
            return 0;
        }
        ArrayList<LocalMediaInfo> selectedMediaInfos = getSelectedMediaInfos(pVar);
        if (selectedMediaInfos == null || selectedMediaInfos.isEmpty()) {
            return 0;
        }
        LocalMediaInfo localMediaInfo = selectedMediaInfos.get(0);
        return localMediaInfo != null && localMediaInfo.isRwa ? 2 : 0;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public List<String> getSelectedMediaInfoPaths(com.tencent.mobileqq.activity.aio.p pVar) {
        if (!checkSessionInfo(pVar)) {
            QLog.i(TAG, 1, "getSelectedMediaInfoPaths session arg error !");
            return null;
        }
        ArrayList<LocalMediaInfo> selectedMediaInfos = getSelectedMediaInfos(pVar);
        if (selectedMediaInfos == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<LocalMediaInfo> it = selectedMediaInfos.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().path);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public ArrayList<LocalMediaInfo> getSelectedMediaInfos(com.tencent.mobileqq.activity.aio.p pVar) {
        if (!checkSessionInfo(pVar)) {
            QLog.i(TAG, 1, "getSelectedMediaInfos session arg error !");
            return null;
        }
        Object obj = pVar.b().get(getKey(pVar.f179557e));
        if (obj != null) {
            return (ArrayList) obj;
        }
        return null;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mListenerMap.clear();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mListenerMap.clear();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public void onOrderChanged(com.tencent.mobileqq.activity.aio.p pVar) {
        com.tencent.mobileqq.guild.api.g gVar;
        if (checkSessionInfo(pVar) && (gVar = this.mListenerMap.get(1)) != null) {
            gVar.onRefresh();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public void onSelectedChanged(int i3, boolean z16, LocalMediaInfo localMediaInfo, com.tencent.mobileqq.activity.aio.p pVar) {
        if (!checkSessionInfo(pVar)) {
            QLog.i(TAG, 1, "onSelectedChanged oriBusiId = " + i3 + " isAdd = " + z16);
            return;
        }
        if (localMediaInfo == null || TextUtils.isEmpty(localMediaInfo.path)) {
            QLog.i(TAG, 1, "onSelectedChanged localMediaInfo error !");
        } else if (z16) {
            onSelectChanedAddItem(i3, localMediaInfo, pVar);
        } else {
            onSelectChangedRemoveItem(i3, localMediaInfo, pVar);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public void removeListener(int i3) {
        this.mListenerMap.remove(Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public void removeSelectedMediaInfos(com.tencent.mobileqq.activity.aio.p pVar) {
        if (!checkSessionInfo(pVar)) {
            QLog.i(TAG, 1, "removeSelectedMediaInfos session arg error !");
            return;
        }
        String key = getKey(pVar.f179557e);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "key = " + key);
        }
        Bundle b16 = pVar.b();
        b16.remove(key);
        pVar.f(b16);
        onNotifyClearStatus();
        onNotifyRefresh();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public void resetSelectedMediaInfo(com.tencent.mobileqq.activity.aio.p pVar, ArrayList<LocalMediaInfo> arrayList) {
        if (!checkSessionInfo(pVar)) {
            QLog.i(TAG, 1, "resetSelectedMediaInfo session arg error !");
        } else {
            updateSelectedMediaInfo(pVar, arrayList);
            onNotifyRefresh();
        }
    }

    private boolean checkSessionInfo(com.tencent.mobileqq.activity.aio.p pVar) {
        return pVar != null && pVar.f179555d == 10014;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSelectMediaNotifyService
    public void addListener(int i3, com.tencent.mobileqq.guild.api.g gVar) {
        if (gVar != null) {
            this.mListenerMap.put(Integer.valueOf(i3), gVar);
        }
    }
}
