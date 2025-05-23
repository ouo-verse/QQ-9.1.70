package com.tencent.qqnt.pluspanel.api.impl;

import com.tencent.aio.base.mvvm.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import com.tencent.qqnt.pluspanel.config.b;
import com.tencent.qqnt.pluspanel.config.e;
import com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo;
import com.tencent.qqnt.pluspanel.data.repository.c;
import com.tencent.qqnt.pluspanel.ui.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\bH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/pluspanel/api/impl/PlusPanelApiImpl;", "Lcom/tencent/qqnt/pluspanel/api/IPlusPanelApi;", "", "panelId", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "getPanelVB", "", "id", "type", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRedDotList", "chatType", "", "loadAppInfoConfigAsync", "", "Lcom/tencent/qqnt/pluspanel/config/b;", "getAppConfigDatas", "", "getC2CRedDotIdList", "appId", "getAppConfigDataById", "<init>", "()V", "Companion", "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PlusPanelApiImpl implements IPlusPanelApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "PlusPanelApiImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/api/impl/PlusPanelApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.api.impl.PlusPanelApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37783);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlusPanelApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.pluspanel.api.IPlusPanelApi
    @Nullable
    public b getAppConfigDataById(@NotNull String appId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) appId);
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        return e.f360364a.f(appId);
    }

    @Override // com.tencent.qqnt.pluspanel.api.IPlusPanelApi
    @NotNull
    public Map<String, b> getAppConfigDatas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return e.f360364a.h();
    }

    @Override // com.tencent.qqnt.pluspanel.api.IPlusPanelApi
    @NotNull
    public List<Integer> getC2CRedDotIdList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return e.f360364a.i();
    }

    @Override // com.tencent.qqnt.pluspanel.api.IPlusPanelApi
    @NotNull
    public a<ol3.b, MviUIState> getPanelVB(int panelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, panelId);
        }
        return new g(panelId);
    }

    @Override // com.tencent.qqnt.pluspanel.api.IPlusPanelApi
    @NotNull
    public ArrayList<String> getRedDotList(@NotNull String id5, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) id5, type);
        }
        Intrinsics.checkNotNullParameter(id5, "id");
        ArrayList<String> arrayList = new ArrayList<>();
        List<PlusPanelAppInfo> a16 = com.tencent.qqnt.pluspanel.data.repository.a.f360445a.a(id5, type);
        if (a16 != null) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((PlusPanelAppInfo) it.next()).getRedDotID()));
            }
            QLog.i(TAG, 1, "fetch red dot list from cache, size: " + arrayList.size());
            return arrayList;
        }
        c cVar = new c(id5, type);
        cVar.c();
        Iterator<T> it5 = cVar.b().iterator();
        while (it5.hasNext()) {
            arrayList.add(String.valueOf(((PlusPanelAppInfo) it5.next()).getRedDotID()));
        }
        QLog.i(TAG, 1, "fetch red dot list, size: " + arrayList.size());
        return arrayList;
    }

    @Override // com.tencent.qqnt.pluspanel.api.IPlusPanelApi
    public void loadAppInfoConfigAsync(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, chatType);
        } else if (chatType == 1) {
            e.l(e.f360364a, false, 1, null);
        }
    }
}
