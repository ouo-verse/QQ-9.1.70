package com.tencent.mobileqq.mini.entry.expDesktop.repository;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopGroupAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankTabAppInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.bean.PositionItemInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J<\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/repository/IExpDesktopLocalMmkvRepository;", "", "getMiniAppPositionInMmkv", "", "Lcom/tencent/mobileqq/mini/entry/newdesktop/bean/PositionItemInfo;", "updateMiniAppPositionInMmkv", "", "personalModuleMap", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "recommendModule", "", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupAppInfo;", "rankModules", "Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopRankTabAppInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface IExpDesktopLocalMmkvRepository {
    List<PositionItemInfo> getMiniAppPositionInMmkv();

    void updateMiniAppPositionInMmkv(Map<Integer, DesktopItemInfo> personalModuleMap, List<ExpDesktopGroupAppInfo> recommendModule, List<ExpDesktopRankTabAppInfo> rankModules);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateMiniAppPositionInMmkv$default(IExpDesktopLocalMmkvRepository iExpDesktopLocalMmkvRepository, Map map, List list, List list2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    list = new ArrayList();
                }
                if ((i3 & 4) != 0) {
                    list2 = new ArrayList();
                }
                iExpDesktopLocalMmkvRepository.updateMiniAppPositionInMmkv(map, list, list2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMiniAppPositionInMmkv");
        }
    }
}
