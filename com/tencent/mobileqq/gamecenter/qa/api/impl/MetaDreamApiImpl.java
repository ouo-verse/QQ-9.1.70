package com.tencent.mobileqq.gamecenter.qa.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.hippy.qq.fragment.BaseHippyContainer;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.metadream.fragment.GameMetaDreamMsgCenterFragment;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi;
import com.tencent.mobileqq.gamecenter.qa.fragment.MetaDreamImageCropFragment;
import com.tencent.mobileqq.gamecenter.qa.metadream.MetaDreamFrame;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import ud1.MetaDreamHippyConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J$\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001f` H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0\u0002H\u0016J \u0010.\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020$H\u0016R\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/api/impl/MetaDreamApiImpl;", "Lcom/tencent/mobileqq/gamecenter/qa/api/IMetaDreamApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/Frame;", "getMetaDreamFrameClass", "Lcom/tencent/mobileqq/app/FrameFragment;", "fragment", "newMetaDreamFrame", "", "setMainFragment", "", NodeProps.VISIBLE, "notifyTabChange", "isOn", "setTabOn", "isTabOn", "Lcom/tencent/mobileqq/app/be;", AIInput.KEY_FRAME, "isMetaDreamFrame", "Lcom/tencent/mobileqq/gamecenter/metadream/a;", "redpointInfo", "setTabRedpointInfo", "getTabRedpointInfo", "isMetaDreamFrameAlive", "isAlive", "setMetaDreamFrameAlive", "", "getMetaDreamBundleName", "Lorg/json/JSONObject;", "getHippyBusinessData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getPerformanceData", "Ljava/lang/Object;", "getSSRBundleRequester", "", "tabIndex", "openMsgList", "Lcom/tencent/mobileqq/app/parser/av;", "getJumpParserClass", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "requestCode", "openImageCropFragment", "Z", "currentRedInfo", "Lcom/tencent/mobileqq/gamecenter/metadream/a;", "isFrameAlive", "<init>", "()V", "Companion", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class MetaDreamApiImpl implements IMetaDreamApi {

    @NotNull
    private static final String ROUTER_PATH_GAME_MSG_BOX_FRAGMENT = "/metadream/msgcenter";

    @NotNull
    public static final String TAG = "MetaDreamApiImpl";

    @Nullable
    private com.tencent.mobileqq.gamecenter.metadream.a currentRedInfo;
    private boolean isFrameAlive;
    private boolean isTabOn;

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    @NotNull
    public JSONObject getHippyBusinessData() {
        JSONObject jSONObject;
        MetaDreamFrame a16 = com.tencent.mobileqq.gamecenter.qa.metadream.a.f212593a.a();
        if (a16 != null) {
            BaseHippyContainer baseHippyContainer = a16.getBaseHippyContainer();
            if (baseHippyContainer != null) {
                jSONObject = baseHippyContainer.generateBusinessData();
            } else {
                jSONObject = null;
            }
            Intrinsics.checkNotNull(jSONObject);
            return jSONObject;
        }
        return new JSONObject();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    @NotNull
    public Class<? extends av> getJumpParserClass() {
        return de1.b.class;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    @NotNull
    public String getMetaDreamBundleName() {
        String str;
        MetaDreamHippyConfig metaDreamHippyConfig = (MetaDreamHippyConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100909");
        if (metaDreamHippyConfig != null) {
            str = metaDreamHippyConfig.getBundleName();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = HippyQQConstants.ModuleName.QQ_META_DREAM;
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    @NotNull
    public Class<? extends Frame> getMetaDreamFrameClass() {
        return MetaDreamFrame.class;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    @NotNull
    public HashMap<String, Long> getPerformanceData() {
        HashMap<String, Long> hashMap;
        MetaDreamFrame a16 = com.tencent.mobileqq.gamecenter.qa.metadream.a.f212593a.a();
        if (a16 != null) {
            BaseHippyContainer baseHippyContainer = a16.getBaseHippyContainer();
            if (baseHippyContainer != null) {
                hashMap = baseHippyContainer.getPerformanceData();
            } else {
                hashMap = null;
            }
            Intrinsics.checkNotNull(hashMap);
            return hashMap;
        }
        return new HashMap<>();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    @Nullable
    public Object getSSRBundleRequester() {
        BaseHippyContainer baseHippyContainer;
        MetaDreamFrame a16 = com.tencent.mobileqq.gamecenter.qa.metadream.a.f212593a.a();
        if (a16 != null && (baseHippyContainer = a16.getBaseHippyContainer()) != null) {
            return baseHippyContainer.getSSRBundleRequester();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    @Nullable
    /* renamed from: getTabRedpointInfo, reason: from getter */
    public com.tencent.mobileqq.gamecenter.metadream.a getCurrentRedInfo() {
        return this.currentRedInfo;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    public boolean isMetaDreamFrame(@Nullable be frame) {
        return frame instanceof MetaDreamFrame;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    /* renamed from: isMetaDreamFrameAlive, reason: from getter */
    public boolean getIsFrameAlive() {
        return this.isFrameAlive;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    /* renamed from: isTabOn, reason: from getter */
    public boolean getIsTabOn() {
        return this.isTabOn;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    @NotNull
    public Frame newMetaDreamFrame(@NotNull FrameFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return new MetaDreamFrame();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    public void notifyTabChange(boolean visible) {
        MetaDreamFrame a16 = com.tencent.mobileqq.gamecenter.qa.metadream.a.f212593a.a();
        if (a16 != null) {
            a16.onTabChange(visible);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    public void openImageCropFragment(@NotNull Activity activity, @NotNull Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QLog.d(TAG, 1, "openImageCropFragment");
        QPublicFragmentActivityForPeak.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) MetaDreamImageCropFragment.class, requestCode);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    public void openMsgList(int tabIndex) {
        QLog.d(TAG, 1, "openMsgList tabIndex:" + tabIndex);
        Activity topActivity = Foreground.getTopActivity();
        Object requestWithReturn = QRoute.createNavigator(topActivity, ROUTER_PATH_GAME_MSG_BOX_FRAGMENT).requestWithReturn();
        Intrinsics.checkNotNull(requestWithReturn, "null cannot be cast to non-null type com.tencent.mobileqq.fragment.QPublicBaseFragment");
        Intent intent = new Intent();
        intent.putExtra("extra_from_meta_dream", true);
        intent.putExtra(GameMetaDreamMsgCenterFragment.EXTRA_META_DREAM_MSG_TAB_INDEX, tabIndex);
        QPublicFragmentActivity.start(topActivity, intent, ((QPublicBaseFragment) requestWithReturn).getClass());
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    public void setMainFragment(@Nullable FrameFragment fragment) {
        com.tencent.mobileqq.gamecenter.qa.metadream.a aVar = com.tencent.mobileqq.gamecenter.qa.metadream.a.f212593a;
        Intrinsics.checkNotNull(fragment);
        aVar.d(fragment);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    public void setMetaDreamFrameAlive(boolean isAlive) {
        this.isFrameAlive = isAlive;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    public void setTabOn(boolean isOn) {
        this.isTabOn = isOn;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamApi
    public void setTabRedpointInfo(@Nullable com.tencent.mobileqq.gamecenter.metadream.a redpointInfo) {
        this.currentRedInfo = redpointInfo;
    }
}
