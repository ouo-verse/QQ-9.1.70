package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J8\u0010\u0013\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/ExpDesktopLocalMmkvRepository;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/IExpDesktopLocalMmkvRepository;", "()V", "entity", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "index", "", "addPositionStrSetInfo", "", "desktopItemInfo", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "positionSet", "", "", "moduleType", "getMiniAppPositionInMmkv", "", "Lcom/tencent/mobileqq/mini/entry/newdesktop/bean/PositionItemInfo;", "updateMiniAppPositionInMmkv", "personalModuleMap", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "recommendModule", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "rankModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ExpDesktopLocalMmkvRepository implements IExpDesktopLocalMmkvRepository {
    public static final String DESKTOP_APP_NAME = "mini_app_exp_desktop";
    public static final String KEY_MINI_GET_APP_LIST_EXP = "mini_get_app_list_exp";
    public static final int RANK_INFO_CACHE_DEFAULT_INDEX = 0;
    private static final String TAG = "ExpDesktopLocalSpRepository";
    private MMKVOptionEntity entity;
    private int index;

    public ExpDesktopLocalMmkvRepository() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_APP)");
        this.entity = from;
    }

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalMmkvRepository
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
        Set<String> miniAppPositionSet = this.entity.decodeStringSet(peekAppRuntime.getCurrentAccountUin() + "_mini_app_exp_desktop_key_mini_app_desktop_position_info", new HashSet());
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

    @Override // com.tencent.mobileqq.mini.entry.expDesktop.repository.IExpDesktopLocalMmkvRepository
    public void updateMiniAppPositionInMmkv(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModule, List<ExpDesktopRankTabAppInfo> rankModules) {
        Intrinsics.checkNotNullParameter(personalModuleMap, "personalModuleMap");
        Intrinsics.checkNotNullParameter(recommendModule, "recommendModule");
        Intrinsics.checkNotNullParameter(rankModules, "rankModules");
        QLog.i(TAG, 1, "updateMiniAppPositionInMmkv");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (personalModuleMap.get(1) == null) {
            QLog.e(TAG, 1, "updateMiniAppPositionInMmkv error, personalModuleMap[INTERFACE.Module_RecentApp] == null!!", new Throwable("Module_RecentApp"));
            return;
        }
        if (personalModuleMap.get(3) == null) {
            QLog.e(TAG, 1, "updateMiniAppPositionInMmkv error, personalModuleMap[INTERFACE.Module_MyApp] == null!!", new Throwable("Module_MyApp"));
            return;
        }
        this.index = 0;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DesktopItemInfo desktopItemInfo = personalModuleMap.get(1);
        DesktopItemInfo desktopItemInfo2 = personalModuleMap.get(3);
        if (desktopItemInfo != null) {
            addPositionStrSetInfo(((ExpDesktopGroupAppInfo) desktopItemInfo).getGroupAppInfo(), linkedHashSet, 1);
        }
        if (desktopItemInfo2 != null) {
            addPositionStrSetInfo(((ExpDesktopGroupAppInfo) desktopItemInfo2).getGroupAppInfo(), linkedHashSet, 3);
        }
        if (!recommendModule.isEmpty()) {
            for (ExpDesktopGroupAppInfo expDesktopGroupAppInfo : recommendModule) {
                addPositionStrSetInfo(expDesktopGroupAppInfo.getGroupAppInfo(), linkedHashSet, expDesktopGroupAppInfo.mModuleType);
            }
        }
        if ((!rankModules.isEmpty()) && (!rankModules.get(0).getRankSubTabAppInfo().isEmpty())) {
            addPositionStrSetInfo(rankModules.get(0).getRankSubTabAppInfo().get(0).getRankAppInfo(), linkedHashSet, rankModules.get(0).getRankSubTabAppInfo().get(0).mModuleType);
        }
        this.entity.encodeStringSet(peekAppRuntime.getCurrentAccountUin() + "_mini_app_exp_desktop_key_mini_app_desktop_position_info", linkedHashSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addPositionStrSetInfo(List<DesktopAppInfo> desktopItemInfo, Set<String> positionSet, int moduleType) {
        List<DesktopAppInfo> filterNotNull;
        if (desktopItemInfo == null || filterNotNull == null) {
            return;
        }
        for (DesktopAppInfo desktopAppInfo : filterNotNull) {
            MiniAppInfo miniAppInfo = desktopAppInfo.mMiniAppInfo;
            if (miniAppInfo != null) {
                String str = miniAppInfo.appId;
                if (!(str == null || str.length() == 0)) {
                    positionSet.add("position:" + this.index + "_moduletype:" + moduleType + "_appid:" + desktopAppInfo.mMiniAppInfo.appId);
                    this.index = this.index + 1;
                }
            }
        }
    }
}
