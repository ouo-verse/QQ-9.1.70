package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopBannerModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J8\u0010\u0013\u001a\u00020\b2.\u0010\u0014\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0015j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n`\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/DesktopLocalMmkvRepository;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopLocalMmkvRepository;", "()V", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "index", "", "addPositionStrSetInfo", "", "desktopItemInfo", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "positionSet", "", "", "moduleType", "getMiniAppPositionInMmkv", "", "Lcom/tencent/mobileqq/mini/entry/newdesktop/bean/PositionItemInfo;", "updateMiniAppPositionInMmkv", "miniAppUIDataMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class DesktopLocalMmkvRepository implements IDesktopLocalMmkvRepository {
    public static final String DESKTOP_APP_NAME = "mini_app_desktop";
    public static final String KEY_MINI_GET_APP_LIST_NEW = "mini_get_app_list_new";
    private static final String TAG = "DesktopLocalSpRepository";
    private MMKVOptionEntity entity;
    private int index;

    public DesktopLocalMmkvRepository() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP)");
        this.entity = from;
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalMmkvRepository
    public List<PositionItemInfo> getMiniAppPositionInMmkv() {
        List split$default;
        boolean contains$default;
        List split$default2;
        List split$default3;
        List split$default4;
        boolean contains$default2;
        List split$default5;
        List split$default6;
        List split$default7;
        List<PositionItemInfo> emptyList;
        List<PositionItemInfo> emptyList2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        Set<String> miniAppPositionSet = this.entity.decodeStringSet(peekAppRuntime.getCurrentAccountUin() + "_mini_app_desktop_key_mini_app_desktop_position_info", new HashSet());
        if (miniAppPositionSet == null || miniAppPositionSet.isEmpty()) {
            QLog.i(TAG, 2, "getMiniAppPositionInSp is null or empty!");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        QLog.i(TAG, 2, "getMiniAppPositionInSp miniAppPositionSet:" + miniAppPositionSet);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(miniAppPositionSet, "miniAppPositionSet");
        for (String positionItem : miniAppPositionSet) {
            if (!(positionItem == null || positionItem.length() == 0)) {
                Intrinsics.checkNotNullExpressionValue(positionItem, "positionItem");
                split$default = StringsKt__StringsKt.split$default((CharSequence) positionItem, new String[]{"_"}, false, 0, 6, (Object) null);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) split$default.get(2), (CharSequence) "appid", false, 2, (Object) null);
                if (!contains$default) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) split$default.get(2), (CharSequence) "title", false, 2, (Object) null);
                    if (contains$default2) {
                        PositionItemInfo positionItemInfo = new PositionItemInfo();
                        split$default5 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(0), new String[]{":"}, false, 0, 6, (Object) null);
                        positionItemInfo.setPosition(Integer.parseInt((String) split$default5.get(1)));
                        split$default6 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{":"}, false, 0, 6, (Object) null);
                        positionItemInfo.setModuleType(Integer.parseInt((String) split$default6.get(1)));
                        split$default7 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(2), new String[]{":"}, false, 0, 6, (Object) null);
                        positionItemInfo.setModuleTitle((String) split$default7.get(1));
                        arrayList.add(positionItemInfo);
                    }
                } else {
                    PositionItemInfo positionItemInfo2 = new PositionItemInfo();
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(0), new String[]{":"}, false, 0, 6, (Object) null);
                    positionItemInfo2.setPosition(Integer.parseInt((String) split$default2.get(1)));
                    split$default3 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(1), new String[]{":"}, false, 0, 6, (Object) null);
                    positionItemInfo2.setModuleType(Integer.parseInt((String) split$default3.get(1)));
                    split$default4 = StringsKt__StringsKt.split$default((CharSequence) split$default.get(2), new String[]{":"}, false, 0, 6, (Object) null);
                    positionItemInfo2.setAppId((String) split$default4.get(1));
                    arrayList.add(positionItemInfo2);
                }
            }
        }
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.mini.entry.newdesktop.repository.IDesktopLocalMmkvRepository
    public void updateMiniAppPositionInMmkv(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap) {
        Intrinsics.checkNotNullParameter(miniAppUIDataMap, "miniAppUIDataMap");
        QLog.i(TAG, 1, "setMiniAppPositionChangeInSp");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.index = 0;
        List<DesktopItemInfo> list = miniAppUIDataMap.get(16);
        addPositionStrSetInfo(list != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list) : null, linkedHashSet, 16);
        List<DesktopItemInfo> list2 = miniAppUIDataMap.get(15);
        addPositionStrSetInfo(list2 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list2) : null, linkedHashSet, 15);
        List<DesktopItemInfo> list3 = miniAppUIDataMap.get(14);
        addPositionStrSetInfo(list3 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list3) : null, linkedHashSet, 14);
        List<DesktopItemInfo> list4 = miniAppUIDataMap.get(1);
        addPositionStrSetInfo(list4 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list4) : null, linkedHashSet, 1);
        List<DesktopItemInfo> list5 = miniAppUIDataMap.get(3);
        addPositionStrSetInfo(list5 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list5) : null, linkedHashSet, 3);
        List<DesktopItemInfo> list6 = miniAppUIDataMap.get(2);
        addPositionStrSetInfo(list6 != null ? CollectionsKt___CollectionsKt.toMutableList((Collection) list6) : null, linkedHashSet, 2);
        this.entity.encodeStringSet(peekAppRuntime.getCurrentAccountUin() + "_mini_app_desktop_key_mini_app_desktop_position_info", linkedHashSet);
        QLog.d(TAG, 1, "setDesktopAppPositionInfoToSp, position info: " + linkedHashSet);
    }

    private final void addPositionStrSetInfo(List<DesktopItemInfo> desktopItemInfo, Set<String> positionSet, int moduleType) {
        if (desktopItemInfo != null) {
            for (DesktopItemInfo desktopItemInfo2 : desktopItemInfo) {
                if (desktopItemInfo2 instanceof DesktopAppInfo) {
                    DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo2;
                    MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
                    if (!miniAppInfo.isGdtMiniAppAd) {
                        String str = miniAppInfo.appId;
                        if (!(str == null || str.length() == 0)) {
                            positionSet.add("position:" + this.index + "_moduletype:" + moduleType + "_appid:" + desktopAppInfo.mMiniAppInfo.appId);
                            this.index = this.index + 1;
                        }
                    }
                }
                if ((desktopItemInfo2 instanceof DesktopAppModuleInfo) && (desktopItemInfo2 instanceof DesktopBannerModuleInfo)) {
                    DesktopAppModuleInfo desktopAppModuleInfo = (DesktopAppModuleInfo) desktopItemInfo2;
                    String str2 = desktopAppModuleInfo.moduleTitle;
                    if (!(str2 == null || str2.length() == 0)) {
                        positionSet.add("position:" + this.index + "_moduletype:" + moduleType + "_title:" + desktopAppModuleInfo.moduleTitle);
                        this.index = this.index + 1;
                    }
                }
                if (desktopItemInfo2 instanceof DesktopSearchInfo) {
                    DesktopSearchInfo desktopSearchInfo = (DesktopSearchInfo) desktopItemInfo2;
                    String str3 = desktopSearchInfo.mAppInfo.appId;
                    if (!(str3 == null || str3.length() == 0)) {
                        positionSet.add("position:" + this.index + "_moduletype:" + moduleType + "_appid:" + desktopSearchInfo.mAppInfo.appId);
                        this.index = this.index + 1;
                    }
                }
            }
        }
    }
}
