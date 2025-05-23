package com.tencent.mobileqq.mini.entry.expDesktop.utils;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/utils/MiniAppListDiffUtils;", "", "()V", "getDiffListInfoFromLocalToMoreList", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "originList", "", "moreDataList", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppListDiffUtils {
    public static final MiniAppListDiffUtils INSTANCE = new MiniAppListDiffUtils();

    MiniAppListDiffUtils() {
    }

    public final List<DesktopAppInfo> getDiffListInfoFromLocalToMoreList(List<? extends DesktopAppInfo> originList, List<DesktopAppInfo> moreDataList) {
        List mutableList;
        List plus;
        List<DesktopAppInfo> mutableList2;
        Intrinsics.checkNotNullParameter(originList, "originList");
        Intrinsics.checkNotNullParameter(moreDataList, "moreDataList");
        HashSet hashSet = new HashSet();
        Iterator<T> it = originList.iterator();
        while (it.hasNext()) {
            hashSet.add(((DesktopAppInfo) it.next()).mMiniAppInfo.appId);
        }
        Iterator<DesktopAppInfo> it5 = moreDataList.iterator();
        while (it5.hasNext()) {
            if (hashSet.contains(it5.next().mMiniAppInfo.appId)) {
                it5.remove();
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) originList);
        plus = CollectionsKt___CollectionsKt.plus((Collection) mutableList, (Iterable) moreDataList);
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) plus);
        return mutableList2;
    }
}
