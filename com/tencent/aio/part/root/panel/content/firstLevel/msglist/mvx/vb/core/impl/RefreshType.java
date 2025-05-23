package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/impl/RefreshType;", "", "(Ljava/lang/String;I)V", "RefreshInit", "PreRefresh", "LoadingRefresh", "PreLoadMore", "LoadingLoadMore", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class RefreshType {
    private static final /* synthetic */ RefreshType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final RefreshType LoadingLoadMore;
    public static final RefreshType LoadingRefresh;
    public static final RefreshType PreLoadMore;
    public static final RefreshType PreRefresh;
    public static final RefreshType RefreshInit;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51865);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        RefreshType refreshType = new RefreshType("RefreshInit", 0);
        RefreshInit = refreshType;
        RefreshType refreshType2 = new RefreshType("PreRefresh", 1);
        PreRefresh = refreshType2;
        RefreshType refreshType3 = new RefreshType("LoadingRefresh", 2);
        LoadingRefresh = refreshType3;
        RefreshType refreshType4 = new RefreshType("PreLoadMore", 3);
        PreLoadMore = refreshType4;
        RefreshType refreshType5 = new RefreshType("LoadingLoadMore", 4);
        LoadingLoadMore = refreshType5;
        $VALUES = new RefreshType[]{refreshType, refreshType2, refreshType3, refreshType4, refreshType5};
    }

    RefreshType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static RefreshType valueOf(String str) {
        return (RefreshType) Enum.valueOf(RefreshType.class, str);
    }

    public static RefreshType[] values() {
        return (RefreshType[]) $VALUES.clone();
    }
}
