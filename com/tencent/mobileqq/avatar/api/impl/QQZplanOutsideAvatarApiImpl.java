package com.tencent.mobileqq.avatar.api.impl;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/QQZplanOutsideAvatarApiImpl;", "Lcom/tencent/mobileqq/avatar/api/IQQZplanOutsideAvatarApi;", "", "updateOutboundHeadFeatureOn", "", "isOutboundHeadFeatureOn", "", WadlProxyConsts.SCENE_ID, "checkOutboundHeadSceneEnable", "isManualCancelDecodeRequest", "isToggleBugfix106568443Enable", "enableSetBgDrawableDimens", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isZplanAvatarV2ToggleInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isZplanOutboundsAvatarToggleEnable", "Z", "", "zplanOutboundAvatarSceneSet", "Ljava/util/Set;", "isZplanAvatarManualCancelEnable", "bugfix106568443ToggleSwitch", "isEnableZplanBgDrawableSetDimens", "<init>", "()V", "Companion", "a", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQZplanOutsideAvatarApiImpl implements IQQZplanOutsideAvatarApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "QQZplanOutsideAvatarApiImpl";

    @NotNull
    public static final String TOGGLE_ZPLAN_AVATAR_V2_SWITCH = "zplan_avatar_v2_switch";
    public static final boolean ZPLAN_AVATAR_V2_SWITCH_DEFAULT = true;
    private boolean bugfix106568443ToggleSwitch;
    private boolean isEnableZplanBgDrawableSetDimens;
    private boolean isZplanAvatarManualCancelEnable;

    @NotNull
    private final AtomicBoolean isZplanAvatarV2ToggleInit;
    private boolean isZplanOutboundsAvatarToggleEnable;

    @NotNull
    private final Set<Integer> zplanOutboundAvatarSceneSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/impl/QQZplanOutsideAvatarApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "TOGGLE_ZPLAN_AVATAR_V2_SWITCH", "", "ZPLAN_AVATAR_V2_SWITCH_DEFAULT", "Z", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.api.impl.QQZplanOutsideAvatarApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17310);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQZplanOutsideAvatarApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isZplanAvatarV2ToggleInit = new AtomicBoolean(false);
        this.isZplanOutboundsAvatarToggleEnable = true;
        this.zplanOutboundAvatarSceneSet = new LinkedHashSet();
        this.bugfix106568443ToggleSwitch = true;
        this.isEnableZplanBgDrawableSetDimens = true;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi
    public boolean checkOutboundHeadSceneEnable(int sceneId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, sceneId)).booleanValue();
        }
        if (this.isZplanAvatarV2ToggleInit.compareAndSet(false, true)) {
            updateOutboundHeadFeatureOn();
        }
        if (!this.isZplanOutboundsAvatarToggleEnable) {
            return false;
        }
        if (sceneId == 1) {
            return true;
        }
        return this.zplanOutboundAvatarSceneSet.contains(Integer.valueOf(sceneId));
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi
    public boolean enableSetBgDrawableDimens() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.isZplanAvatarV2ToggleInit.compareAndSet(false, true)) {
            updateOutboundHeadFeatureOn();
        }
        return this.isEnableZplanBgDrawableSetDimens;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi
    public boolean isManualCancelDecodeRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.isZplanAvatarV2ToggleInit.compareAndSet(false, true)) {
            updateOutboundHeadFeatureOn();
        }
        return this.isZplanAvatarManualCancelEnable;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi
    public boolean isOutboundHeadFeatureOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.isZplanAvatarV2ToggleInit.compareAndSet(false, true)) {
            updateOutboundHeadFeatureOn();
        }
        return this.isZplanOutboundsAvatarToggleEnable;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi
    public boolean isToggleBugfix106568443Enable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.isZplanAvatarV2ToggleInit.compareAndSet(false, true)) {
            updateOutboundHeadFeatureOn();
        }
        return this.bugfix106568443ToggleSwitch;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQZplanOutsideAvatarApi
    public void updateOutboundHeadFeatureOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ant.ALL\n                )");
            IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
            this.isZplanOutboundsAvatarToggleEnable = iFeatureRuntimeService.isFeatureSwitchEnable(TOGGLE_ZPLAN_AVATAR_V2_SWITCH, true);
            String string = iFeatureRuntimeService.getString(TOGGLE_ZPLAN_AVATAR_V2_SWITCH, null);
            Intrinsics.checkNotNullExpressionValue(string, "runtimeService.getString\u2026WITCH, null\n            )");
            JSONArray jSONArray = new JSONObject(string).getJSONArray("whiteSceneList");
            if (jSONArray != null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                int length = jSONArray.length();
                if (length >= 0) {
                    int i3 = 0;
                    while (true) {
                        int optInt = jSONArray.optInt(i3, 0);
                        if (optInt > 0) {
                            linkedHashSet.add(Integer.valueOf(optInt));
                        }
                        if (i3 == length) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                this.zplanOutboundAvatarSceneSet.clear();
                this.zplanOutboundAvatarSceneSet.addAll(linkedHashSet);
            }
            QLog.i(TAG, 1, "initZplanOutboundAvatarToggle " + this.isZplanOutboundsAvatarToggleEnable + " sceneSet:" + this.zplanOutboundAvatarSceneSet);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "isZplanOutboundsAvatarToggleEnable: default", e16);
        }
        try {
            IRuntimeService runtimeService2 = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService2, "appRuntime.getRuntimeSer\u2026ant.ALL\n                )");
            IFeatureRuntimeService iFeatureRuntimeService2 = (IFeatureRuntimeService) runtimeService2;
            this.isZplanAvatarManualCancelEnable = iFeatureRuntimeService2.isFeatureSwitchEnable(FaceConstant.TOGGLE_QQ_AVATAR_ZPLAN_MANUAL_CANCEL_SWITCH, false);
            this.bugfix106568443ToggleSwitch = iFeatureRuntimeService2.isFeatureSwitchEnable(FaceConstant.TOGGLE_QQ_AVATAR_BUGFIX_106568443, true);
            boolean isFeatureSwitchEnable = iFeatureRuntimeService2.isFeatureSwitchEnable(FaceConstant.TOGGLE_QQ_AVATAR_ENABLE_BG_SET_DIMENS, true);
            this.isEnableZplanBgDrawableSetDimens = isFeatureSwitchEnable;
            QLog.i(TAG, 1, "initZplanAvatarManualCancelEnable: " + this.isZplanAvatarManualCancelEnable + ", bugfix106568443ToggleSwitch: " + this.bugfix106568443ToggleSwitch + ", isEnableZplanBgDrawableSetDimens: " + isFeatureSwitchEnable);
        } catch (Exception unused) {
            QLog.d(TAG, 1, "initZplanAvatarManualCancelEnable: default");
        }
    }
}
