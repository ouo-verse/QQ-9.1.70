package com.tencent.mobileqq.zplan.api.impl;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.aio.couple.i;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.mobileqq.zplan.couple.ZPlanCoupleSwitchChgSource;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.show.ZPlanShowGuideDialogFragment;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.ZPlanMsgElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0006H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanShowGuideApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanShowGuideApi;", "", "friendUin", "", "isWhiteUser", "", "directShowAIO", "Lkotlin/Function0;", "callback", "setWhiteUser", "", "peerUin", "", "source", "showAvatarInAIO", "onGetCurrentNickname", "Lcom/tencent/aio/api/runtime/a;", "onGetAIOContext", "onShowDialogFromUpgradeBanner", "screenId", "onShowDialogFromAIOGrayTip", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchorView", "onShowBubbleTip", "onNeedShowDialog", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "onShowDialog", "onPlayAvatarAnimation", "aioContext", "onEnterAIO", "onExitAIO", "onGetCurrentPeekUin", "isShowAIOUI", "Z", "Lmqq/util/WeakReference;", "aioContextWeakReference", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/api/IZPlanAIOWhiteListApi;", "zPlanWhiteListApi$delegate", "Lkotlin/Lazy;", "getZPlanWhiteListApi", "()Lcom/tencent/mobileqq/zplan/api/IZPlanAIOWhiteListApi;", "zPlanWhiteListApi", "Lcom/tencent/mobileqq/zplan/couple/api/IZPlanCoupleSceneHelper;", "sceneHelper$delegate", "getSceneHelper", "()Lcom/tencent/mobileqq/zplan/couple/api/IZPlanCoupleSceneHelper;", "sceneHelper", "currentPeerUin", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanShowGuideApiImpl implements IZPlanShowGuideApi {
    public static final String TAG = "ZPlanShowGuideApiImpl";
    private WeakReference<com.tencent.aio.api.runtime.a> aioContextWeakReference;
    private String currentPeerUin;
    private boolean isShowAIOUI;

    /* renamed from: sceneHelper$delegate, reason: from kotlin metadata */
    private final Lazy sceneHelper;

    /* renamed from: zPlanWhiteListApi$delegate, reason: from kotlin metadata */
    private final Lazy zPlanWhiteListApi;

    public ZPlanShowGuideApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanAIOWhiteListApi>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanShowGuideApiImpl$zPlanWhiteListApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanAIOWhiteListApi invoke() {
                QRouteApi api = QRoute.api(IZPlanAIOWhiteListApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAIOWhiteListApi::class.java)");
                return (IZPlanAIOWhiteListApi) api;
            }
        });
        this.zPlanWhiteListApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanCoupleSceneHelper>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanShowGuideApiImpl$sceneHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanCoupleSceneHelper invoke() {
                QRouteApi api = QRoute.api(IZPlanCoupleSceneHelper.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanCoupleSceneHelper::class.java)");
                return (IZPlanCoupleSceneHelper) api;
            }
        });
        this.sceneHelper = lazy2;
    }

    private final void directShowAIO() {
        QLog.i(TAG, 1, "directShowAIO");
        if (this.currentPeerUin == null) {
            QLog.i(TAG, 1, "directShowAIO fail, peerUin is null");
            return;
        }
        IZPlanCoupleSceneHelper sceneHelper = getSceneHelper();
        String str = this.currentPeerUin;
        Intrinsics.checkNotNull(str);
        com.tencent.mobileqq.zplan.aio.couple.i a16 = IZPlanCoupleSceneHelper.a.a(sceneHelper, str, null, 2, null);
        if (a16 != null) {
            a16.k();
        }
    }

    private final IZPlanCoupleSceneHelper getSceneHelper() {
        return (IZPlanCoupleSceneHelper) this.sceneHelper.getValue();
    }

    private final IZPlanAIOWhiteListApi getZPlanWhiteListApi() {
        return (IZPlanAIOWhiteListApi) this.zPlanWhiteListApi.getValue();
    }

    private final boolean isWhiteUser(long friendUin) {
        boolean currentUserNeedShowDialog = getZPlanWhiteListApi().currentUserNeedShowDialog(friendUin);
        QLog.i(TAG, 1, "isWhiteUser isWhiteUser:" + currentUserNeedShowDialog);
        return currentUserNeedShowDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEnterAIO$lambda$4(final ZPlanShowGuideApiImpl this$0) {
        WeakReference<com.tencent.aio.api.runtime.a> weakReference;
        com.tencent.aio.api.runtime.a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isShowAIOUI || (weakReference = this$0.aioContextWeakReference) == null || (aVar = weakReference.get()) == null) {
            return;
        }
        final String j3 = aVar.g().r().c().j();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(j3);
        ag l3 = com.tencent.qqnt.msg.f.l();
        if (l3 != null) {
            l3.getUin(hashSet, new IKernelGetUinInfoCallback() { // from class: com.tencent.mobileqq.zplan.api.impl.w
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                public final void onResult(HashMap hashMap) {
                    ZPlanShowGuideApiImpl.onEnterAIO$lambda$4$lambda$3(j3, this$0, hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEnterAIO$lambda$4$lambda$3(String peerUid, ZPlanShowGuideApiImpl this$0, HashMap hashMap) {
        Long l3;
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hashMap == null || (l3 = (Long) hashMap.get(peerUid)) == null || !this$0.isShowAIOUI) {
            return;
        }
        this$0.currentPeerUin = String.valueOf(l3.longValue());
        if (!this$0.isWhiteUser(l3.longValue())) {
            this$0.directShowAIO();
        } else if (this$0.getSceneHelper().getCoupleAvatarSwitchState(String.valueOf(l3.longValue()))) {
            this$0.directShowAIO();
        } else {
            this$0.onShowDialog(1, String.valueOf(l3.longValue()));
        }
    }

    private final void setWhiteUser(final Function0<Unit> callback) {
        ArrayList arrayListOf;
        if (getZPlanWhiteListApi().hasAvatarFeature()) {
            callback.invoke();
            return;
        }
        com.tencent.mobileqq.zplan.model.b bVar = new com.tencent.mobileqq.zplan.model.b(21, 3, "1");
        QRouteApi api = QRoute.api(IZPlanRequest.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanRequest::class.java)");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(bVar);
        IZPlanRequest.a.a((IZPlanRequest) api, arrayListOf, 11, new nk3.a() { // from class: com.tencent.mobileqq.zplan.api.impl.x
            @Override // nk3.a
            public final void onResult(boolean z16) {
                ZPlanShowGuideApiImpl.setWhiteUser$lambda$6(ZPlanShowGuideApiImpl.this, callback, z16);
            }
        }, 0L, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setWhiteUser$lambda$6(ZPlanShowGuideApiImpl this$0, Function0 callback, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (z16) {
            this$0.getZPlanWhiteListApi().setAvatarFeature();
            callback.invoke();
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public void onEnterAIO(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.aioContextWeakReference = new WeakReference<>(aioContext);
        getZPlanWhiteListApi().reportExposure();
        if (!((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature()) {
            QLog.i(TAG, 1, "onEnterAIO, hasCoupleFeature false, return");
        } else {
            if (this.isShowAIOUI) {
                return;
            }
            this.isShowAIOUI = true;
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.api.impl.v
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanShowGuideApiImpl.onEnterAIO$lambda$4(ZPlanShowGuideApiImpl.this);
                }
            }, 2000L);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public com.tencent.aio.api.runtime.a onGetAIOContext() {
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.aioContextWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public String onGetCurrentNickname(String peerUin) {
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String g17;
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.aioContextWeakReference;
        return (weakReference == null || (aVar = weakReference.get()) == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (g17 = c16.g()) == null) ? "" : g17;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    /* renamed from: onGetCurrentPeekUin, reason: from getter */
    public String getCurrentPeerUin() {
        return this.currentPeerUin;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public boolean onNeedShowDialog(String friendUin) {
        AccessibleDetail zplanAccessibleDetailFromCacheOnly;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        AppRuntime d16 = bb.f335811a.d();
        Long valueOf = d16 != null ? Long.valueOf(d16.getLongAccountUin()) : null;
        if (valueOf != null && ((zplanAccessibleDetailFromCacheOnly = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanAccessibleDetailFromCacheOnly(1011L, valueOf.longValue())) == null || !zplanAccessibleDetailFromCacheOnly.isDevicePass())) {
            QLog.i(TAG, 1, "onNeedShowDialog accessibleDetail device pass failed. " + zplanAccessibleDetailFromCacheOnly);
            return false;
        }
        return !getSceneHelper().getCoupleAvatarSwitchState(friendUin);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public void onPlayAvatarAnimation(AIOMsgItem msgItem) {
        ZPlanMsgElement zPlanMsgElement;
        int i3;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(11);
        if (msgAttributeInfo == null || (zPlanMsgElement = msgAttributeInfo.zPlanMsgInfo) == null) {
            return;
        }
        com.tencent.mobileqq.zplan.aio.couple.i a16 = IZPlanCoupleSceneHelper.a.a(getSceneHelper(), String.valueOf(msgItem.getMsgRecord().peerUin), null, 2, null);
        boolean z16 = zPlanMsgElement.actionFlag == 2;
        int i16 = zPlanMsgElement.masterActionID;
        if (z16) {
            if (msgItem.isSelf()) {
                i3 = zPlanMsgElement.masterActionID;
            } else {
                i3 = zPlanMsgElement.guestActionID;
            }
            i16 = i3;
        }
        i.ZPlanActionInfo zPlanActionInfo = new i.ZPlanActionInfo(i16, com.tencent.mobileqq.aio.utils.d.m(msgItem), z16, msgItem.isSelf());
        if (a16 != null) {
            a16.s(zPlanActionInfo);
        }
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public void onShowBubbleTip(Context context, View anchorView) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.zplan.show.g.f335631a.j(context, anchorView);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public void onShowDialog(final AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (xh3.a.f448008a.a()) {
            return;
        }
        setWhiteUser(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanShowGuideApiImpl$onShowDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanShowGuideApiImpl.this.onShowDialog(2, String.valueOf(msgItem.getMsgRecord().peerUin));
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public void onShowDialogFromAIOGrayTip(final String peerUin, int screenId) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        setWhiteUser(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanShowGuideApiImpl$onShowDialogFromAIOGrayTip$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanShowGuideDialogFragment.Companion companion = ZPlanShowGuideDialogFragment.INSTANCE;
                final ZPlanShowGuideApiImpl zPlanShowGuideApiImpl = ZPlanShowGuideApiImpl.this;
                final String str = peerUin;
                companion.a(7, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanShowGuideApiImpl$onShowDialogFromAIOGrayTip$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ZPlanShowGuideApiImpl.this.showAvatarInAIO(str, 7);
                    }
                });
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public void onShowDialogFromUpgradeBanner(final String peerUin, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanShowGuideDialogFragment.INSTANCE.a(6, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanShowGuideApiImpl$onShowDialogFromUpgradeBanner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanShowGuideApiImpl.this.showAvatarInAIO(peerUin, 6);
                Function0<Unit> function0 = callback;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public void onExitAIO() {
        com.tencent.aio.api.runtime.a aVar;
        this.isShowAIOUI = false;
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.aioContextWeakReference;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            FragmentManager supportFragmentManager = aVar.c().requireActivity().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "aioContext.fragment.requ\u2026().supportFragmentManager");
            for (Fragment fragment : supportFragmentManager.getFragments()) {
                if (fragment instanceof ZPlanShowGuideDialogFragment) {
                    ((ZPlanShowGuideDialogFragment) fragment).dismiss();
                }
            }
        }
        WeakReference<com.tencent.aio.api.runtime.a> weakReference2 = this.aioContextWeakReference;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.aioContextWeakReference = null;
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi
    public void onShowDialog(final int source, final String peerUin) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        ZPlanShowGuideDialogFragment.INSTANCE.a(source, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.api.impl.ZPlanShowGuideApiImpl$onShowDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanShowGuideApiImpl.this.showAvatarInAIO(peerUin, source);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAvatarInAIO(String peerUin, int source) {
        ZPlanCoupleSwitchChgSource zPlanCoupleSwitchChgSource;
        if (source == 1) {
            zPlanCoupleSwitchChgSource = ZPlanCoupleSwitchChgSource.ENTER_AIO;
        } else if (source == 2) {
            zPlanCoupleSwitchChgSource = ZPlanCoupleSwitchChgSource.CLICK_MSG;
        } else if (source == 3) {
            zPlanCoupleSwitchChgSource = ZPlanCoupleSwitchChgSource.CLICK_PANEL;
        } else if (source != 6) {
            zPlanCoupleSwitchChgSource = ZPlanCoupleSwitchChgSource.UNKNOWN;
        } else {
            zPlanCoupleSwitchChgSource = ZPlanCoupleSwitchChgSource.UPGRADE_BANNER;
        }
        getSceneHelper().setCoupleAvatarSwitchState(peerUin, true, zPlanCoupleSwitchChgSource);
        com.tencent.mobileqq.zplan.aio.couple.i a16 = IZPlanCoupleSceneHelper.a.a(getSceneHelper(), peerUin, null, 2, null);
        if (a16 != null) {
            a16.j();
        }
    }
}
