package com.tencent.aio.stranger.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.stranger.api.IStrangerBackgroundApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.matchfriend.aio.background.MutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J#\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0017J(\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/aio/stranger/api/impl/StrangerBackgroundApiImpl;", "Lcom/tencent/aio/stranger/api/IStrangerBackgroundApi;", "", "checkNearbyProChatTypeCase", "disableQQStrangerMutualBackground", "Landroid/content/Context;", "context", "Landroid/view/View;", "createMatchFriendAIOBackground", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/stranger/api/a;", "model", "immediate", "setNextMutualModel", "", "uin", "", "chatType", "useMatchFriendAIOBackground", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "uinType", "useMatchFriendAIOBackgroundOnUinType", "left", "top", "right", "bottom", "notifyInputLayoutChange", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy;", "backgroundProxy", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy;", "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class StrangerBackgroundApiImpl implements IStrangerBackgroundApi {
    private static final String TAG = "StrangerBackgroundApiImpl";
    private com.tencent.aio.api.runtime.a aioContext;
    private BaseMutualMarkAIOBackgroundProxy backgroundProxy;

    private final boolean checkNearbyProChatTypeCase() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        Integer valueOf = (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) ? null : Integer.valueOf(c16.e());
        return valueOf != null && valueOf.intValue() == 119;
    }

    private final boolean disableQQStrangerMutualBackground() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqstranger_9090_129192509_disable_mutual_background", false);
    }

    @Override // com.tencent.aio.stranger.api.IStrangerBackgroundApi
    public View createMatchFriendAIOBackground(Context context) {
        View j3;
        BaseMutualMarkAIOBackgroundProxy baseMutualMarkAIOBackgroundProxy = this.backgroundProxy;
        if (baseMutualMarkAIOBackgroundProxy != null && (j3 = baseMutualMarkAIOBackgroundProxy.j()) != null) {
            return j3;
        }
        MutualMarkAIOBackgroundProxy mutualMarkAIOBackgroundProxy = new MutualMarkAIOBackgroundProxy(context);
        this.backgroundProxy = mutualMarkAIOBackgroundProxy;
        return mutualMarkAIOBackgroundProxy.j();
    }

    @Override // com.tencent.aio.stranger.api.IStrangerBackgroundApi
    public void notifyInputLayoutChange(int left, int top, int right, int bottom) {
        BaseMutualMarkAIOBackgroundProxy baseMutualMarkAIOBackgroundProxy = this.backgroundProxy;
        if (baseMutualMarkAIOBackgroundProxy != null) {
            baseMutualMarkAIOBackgroundProxy.t(left, top, right, bottom);
        }
    }

    @Override // com.tencent.aio.stranger.api.IStrangerBackgroundApi
    public void onCreate(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.aioContext = aioContext;
        MutualMarkAIOBackgroundProxy mutualMarkAIOBackgroundProxy = new MutualMarkAIOBackgroundProxy(aioContext.c().getContext());
        this.backgroundProxy = mutualMarkAIOBackgroundProxy;
        mutualMarkAIOBackgroundProxy.l();
    }

    @Override // com.tencent.aio.stranger.api.IStrangerBackgroundApi
    public void setNextMutualModel(com.tencent.aio.stranger.api.a model, boolean immediate) {
        Intrinsics.checkNotNullParameter(model, "model");
        QLog.i(TAG, 1, "setNextMutualModel model: " + model + ", immediate: " + immediate);
        if (!disableQQStrangerMutualBackground()) {
            BaseMutualMarkAIOBackgroundProxy baseMutualMarkAIOBackgroundProxy = this.backgroundProxy;
            if (baseMutualMarkAIOBackgroundProxy != null) {
                baseMutualMarkAIOBackgroundProxy.s(new BaseMutualMarkAIOBackgroundProxy.f((int) model.a(), model.b(), model.c(), null, 8, null), immediate);
                return;
            }
            return;
        }
        if (model.a() != 5 || immediate) {
            return;
        }
        Object c16 = model.c();
        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = c16 instanceof QQStrangerInteractiveMarkModel ? (QQStrangerInteractiveMarkModel) c16 : null;
        if (qQStrangerInteractiveMarkModel != null) {
            ((IQQStrangerForegroundApi) QRoute.api(IQQStrangerForegroundApi.class)).showGainMutualMarkAnimatorView(qQStrangerInteractiveMarkModel);
        }
    }

    @Override // com.tencent.aio.stranger.api.IStrangerBackgroundApi
    public void onDestroy() {
        this.aioContext = null;
        BaseMutualMarkAIOBackgroundProxy baseMutualMarkAIOBackgroundProxy = this.backgroundProxy;
        if (baseMutualMarkAIOBackgroundProxy != null) {
            baseMutualMarkAIOBackgroundProxy.m();
        }
        this.backgroundProxy = null;
    }

    @Override // com.tencent.aio.stranger.api.IStrangerBackgroundApi
    public boolean useMatchFriendAIOBackgroundOnUinType(String uin, Integer uinType) {
        return (uinType != null && uinType.intValue() == 1046) || checkNearbyProChatTypeCase();
    }

    @Override // com.tencent.aio.stranger.api.IStrangerBackgroundApi
    public boolean useMatchFriendAIOBackground(String uin, Integer chatType) {
        if (chatType != null && chatType.intValue() == 104) {
            return true;
        }
        return chatType != null && chatType.intValue() == 119;
    }
}
