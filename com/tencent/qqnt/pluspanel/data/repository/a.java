package com.tencent.qqnt.pluspanel.data.repository;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R>\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\fj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR>\u0010\u0011\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\fj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/repository/a;", "", "", "peerUid", "", "chatType", "", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "appList", "", "b", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "appListMapCacheForC2C", "c", "appListMapCacheForGroup", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f360445a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, List<PlusPanelAppInfo>> appListMapCacheForC2C;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static HashMap<String, List<PlusPanelAppInfo>> appListMapCacheForGroup;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40189);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f360445a = new a();
        appListMapCacheForC2C = new HashMap<>();
        appListMapCacheForGroup = new HashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final List<PlusPanelAppInfo> a(@NotNull String peerUid, int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) peerUid, chatType);
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        QLog.i("AppListCache", 1, "getAppListFromCache peerUid: " + peerUid);
        if (chatType != 1) {
            if (chatType != 2) {
                return null;
            }
            return appListMapCacheForGroup.get(peerUid);
        }
        return appListMapCacheForC2C.get(peerUid);
    }

    public final synchronized void b(@NotNull String peerUid, int chatType, @NotNull List<? extends PlusPanelAppInfo> appList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, peerUid, Integer.valueOf(chatType), appList);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(appList, "appList");
        QLog.i("AppListCache", 1, "setAppListCache peerUid: " + peerUid);
        if (chatType != 1) {
            if (chatType == 2) {
                appListMapCacheForGroup.put(peerUid, appList);
            }
        } else {
            appListMapCacheForC2C.put(peerUid, appList);
        }
    }
}
