package com.tencent.mobileqq.mini.entry.newdesktop.repository;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J8\u0010\u0005\u001a\u00020\u00062.\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bj\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n`\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/repository/IDesktopLocalMmkvRepository;", "", "getMiniAppPositionInMmkv", "", "Lcom/tencent/mobileqq/mini/entry/newdesktop/bean/PositionItemInfo;", "updateMiniAppPositionInMmkv", "", "miniAppUIDataMap", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface IDesktopLocalMmkvRepository {
    List<PositionItemInfo> getMiniAppPositionInMmkv();

    void updateMiniAppPositionInMmkv(HashMap<Integer, List<DesktopItemInfo>> miniAppUIDataMap);
}
