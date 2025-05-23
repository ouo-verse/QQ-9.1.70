package com.tencent.mobileqq.mini.entry.expDesktop.bean;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopBannerModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u001e\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/bean/ExpDesktopGroupBannerInfo;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "moduleType", "", "groupBannerInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopBannerModuleInfo;", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "mGroupBannerInfo", "getGroupBannerInfo", "getViewType", "setGroupBannerInfo", "", "groupAppInfo", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ExpDesktopGroupBannerInfo extends DesktopItemInfo {
    private ArrayList<DesktopBannerModuleInfo> mGroupBannerInfo;

    public ExpDesktopGroupBannerInfo(int i3, ArrayList<DesktopBannerModuleInfo> groupBannerInfo) {
        Intrinsics.checkNotNullParameter(groupBannerInfo, "groupBannerInfo");
        new ArrayList();
        this.mModuleType = i3;
        this.mGroupBannerInfo = groupBannerInfo;
    }

    public final ArrayList<DesktopBannerModuleInfo> getGroupBannerInfo() {
        return this.mGroupBannerInfo;
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo
    public int getViewType() {
        return 14;
    }

    public final void setGroupBannerInfo(ArrayList<DesktopBannerModuleInfo> groupAppInfo) {
        Intrinsics.checkNotNullParameter(groupAppInfo, "groupAppInfo");
        this.mGroupBannerInfo = this.mGroupBannerInfo;
    }
}
