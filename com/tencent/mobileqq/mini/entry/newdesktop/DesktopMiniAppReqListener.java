package com.tencent.mobileqq.mini.entry.newdesktop;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\u00032.\u0010\n\u001a*\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000bj\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r`\u000fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/DesktopMiniAppReqListener;", "", "getMiniAppInfoFailed", "", "errorMsg", "", "errorCode", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getMiniAppInfoSuccess", "miniAppInfoMap", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "Lkotlin/collections/HashMap;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public interface DesktopMiniAppReqListener {
    void getMiniAppInfoFailed(String errorMsg, Long errorCode);

    void getMiniAppInfoSuccess(HashMap<Integer, List<DesktopItemInfo>> miniAppInfoMap);
}
