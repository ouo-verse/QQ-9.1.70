package com.tencent.mobileqq.sharepanel.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.sharepanel.api.ISharePanelDebugApi;
import com.tencent.mobileqq.sharepanel.config.biz.a;
import com.tencent.mobileqq.sharepanel.config.biz.b;
import com.tencent.mobileqq.sharepanel.config.biz.c;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/impl/SharePanelDebugApiImpl;", "Lcom/tencent/mobileqq/sharepanel/api/ISharePanelDebugApi;", "()V", "getAllSceneIds", "", "", "", "isMainSwitchOn", "", "isSceneSwitchOn", WadlProxyConsts.SCENE_ID, "resetDebugSwitch", "", "setDebugMainSwitch", "switchOn", "setDebugSceneSwitch", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SharePanelDebugApiImpl implements ISharePanelDebugApi {
    static IPatchRedirector $redirector_;

    public SharePanelDebugApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelDebugApi
    @NotNull
    public Map<String, List<String>> getAllSceneIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        List<a> a16 = b.f287223a.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a aVar : a16) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = aVar.a().iterator();
            while (it.hasNext()) {
                arrayList.add(((c) it.next()).e());
            }
            String simpleName = aVar.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "bizConfig.javaClass.simpleName");
            linkedHashMap.put(simpleName, arrayList);
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelDebugApi
    public boolean isMainSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return SharePanelApiImpl.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelDebugApi
    public boolean isSceneSwitchOn(@NotNull String sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sceneId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        return SharePanelApiImpl.INSTANCE.b(sceneId);
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelDebugApi
    public void resetDebugSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.context, QMMKVFile.FILE_COMMON)");
        fromV2.remove(SharePanelApiImpl.SHARE_PANEL_DEBUG_SWITCH);
        Iterator<List<String>> it = getAllSceneIds().values().iterator();
        while (it.hasNext()) {
            Iterator<String> it5 = it.next().iterator();
            while (it5.hasNext()) {
                String str = SharePanelApiImpl.SHARE_PANEL_SCENE_DEBUG_SWITCH + it5.next();
                if (fromV2.contains(str)) {
                    fromV2.remove(str);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelDebugApi
    public void setDebugMainSwitch(boolean switchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, switchOn);
        } else {
            QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations").putBoolean(SharePanelApiImpl.SHARE_PANEL_DEBUG_SWITCH, switchOn);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.api.ISharePanelDebugApi
    public void setDebugSceneSwitch(@NotNull String sceneId, boolean switchOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, sceneId, Boolean.valueOf(switchOn));
            return;
        }
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations").putBoolean(SharePanelApiImpl.SHARE_PANEL_SCENE_DEBUG_SWITCH + sceneId, switchOn);
    }
}
