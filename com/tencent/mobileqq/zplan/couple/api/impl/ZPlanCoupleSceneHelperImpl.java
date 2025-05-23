package com.tencent.mobileqq.zplan.couple.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.IThemeEffectApi;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarViewController;
import com.tencent.mobileqq.zplan.aio.couple.i;
import com.tencent.mobileqq.zplan.api.IZPlanAIOWhiteListApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.couple.ZPlanCoupleSwitchChgSource;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.mobileqq.zplan.couple.api.impl.ZPlanCoupleSceneHelperImpl;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleBubbleConfig;
import com.tencent.mobileqq.zplan.couple.manager.ZPlanCoupleBubbleDataManager;
import com.tencent.mobileqq.zplan.couple.manager.ZPlanCoupleGuideBubblePlayManager;
import com.tencent.mobileqq.zplan.couple.manager.f;
import com.tencent.mobileqq.zplan.couple.processor.ZPlanCoupleProfileDataProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.AvatarBgChangeEvent;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import vg3.d;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J5\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0002H\u0096\u0001J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0018H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J#\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\fH\u0096\u0001J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0096\u0001J\t\u0010!\u001a\u00020\u0006H\u0096\u0001J%\u0010%\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0001J!\u0010(\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010)\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J)\u0010*\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\fH\u0096\u0001\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/api/impl/ZPlanCoupleSceneHelperImpl;", "Lcom/tencent/mobileqq/zplan/couple/api/IZPlanCoupleSceneHelper;", "", "peerUin", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "clearCurrentCoupleAvatarViewController", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "subScene", "Lcom/tencent/mobileqq/zplan/couple/manager/a;", "createBubblePlayManager", "", "targetDrawableWidth", "targetDrawableHeight", "bgPicUrl", "Landroid/graphics/drawable/Drawable;", "lastBgDrawable", "getBackgroundDrawable", "friendUin", "", "getCoupleAvatarSwitchState", "Lcom/tencent/mobileqq/zplan/aio/couple/i;", "getCoupleAvatarViewController", "", "getCoupleSceneId", "selfUin", "getSettingBubbleShownMark", "uinType", "getZPlanChatBackgroundPicPath", "", "Lcom/tencent/mobileqq/zplan/couple/config/a;", "getZPlanSettingBubbles", "requestZPlanSettingBubbles", "open", "Lcom/tencent/mobileqq/zplan/couple/ZPlanCoupleSwitchChgSource;", "source", "setCoupleAvatarSwitchState", "sceneID", "needPush", "setCoupleSceneId", "setSettingBubbleShownMark", "setZPlanChatBackgroundPicPath", "<init>", "()V", ZPlanCoupleSceneHelperImpl.TAG, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanCoupleSceneHelperImpl implements IZPlanCoupleSceneHelper {
    private static final String COUPLE_SETTING_BUBBLE_SHOWN_MMKV_KEY = "COUPLE_SETTING_BUBBLE_SHOWN";
    private static final String TAG = "ZPlanCoupleSceneHelper";

    /* renamed from: ZPlanCoupleSceneHelper, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ConcurrentHashMap<String, CoupleAvatarViewController> coupleAvatarViewControllerMap = new ConcurrentHashMap<>();
    private final /* synthetic */ Companion $$delegate_0 = INSTANCE;

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0012H\u0016J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J4\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J(\u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0013H\u0016J\"\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\bH\u0016R\u0014\u0010,\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010-R\"\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002000/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/api/impl/ZPlanCoupleSceneHelperImpl$ZPlanCoupleSceneHelper;", "Lcom/tencent/mobileqq/zplan/couple/api/IZPlanCoupleSceneHelper;", "Lcom/tencent/mobileqq/zplan/couple/ZPlanCoupleSwitchChgSource;", "source", "", "open", "", "reportSwitchStateChange", "", "friendUin", "getCoupleAvatarSwitchState", "setCoupleAvatarSwitchState", "peerUin", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/zplan/aio/couple/i;", "getCoupleAvatarViewController", "clearCurrentCoupleAvatarViewController", "", "", "getCoupleSceneId", "sceneID", "needPush", "setCoupleSceneId", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "subScene", "Lcom/tencent/mobileqq/zplan/couple/manager/a;", "createBubblePlayManager", "targetDrawableWidth", "targetDrawableHeight", "bgPicUrl", "Landroid/graphics/drawable/Drawable;", "lastBgDrawable", "getBackgroundDrawable", "selfUin", "uinType", "setZPlanChatBackgroundPicPath", "getZPlanChatBackgroundPicPath", "requestZPlanSettingBubbles", "", "Lcom/tencent/mobileqq/zplan/couple/config/a;", "getZPlanSettingBubbles", "getSettingBubbleShownMark", "setSettingBubbleShownMark", "COUPLE_SETTING_BUBBLE_SHOWN_MMKV_KEY", "Ljava/lang/String;", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarViewController;", "coupleAvatarViewControllerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.couple.api.impl.ZPlanCoupleSceneHelperImpl$ZPlanCoupleSceneHelper, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion implements IZPlanCoupleSceneHelper {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void reportSwitchStateChange(final ZPlanCoupleSwitchChgSource source, final boolean open) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.couple.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanCoupleSceneHelperImpl.Companion.reportSwitchStateChange$lambda$0(ZPlanCoupleSwitchChgSource.this, open);
                }
            }, 16, null, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setSettingBubbleShownMark$lambda$1(String selfUin) {
            Intrinsics.checkNotNullParameter(selfUin, "$selfUin");
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("COUPLE_SETTING_BUBBLE_SHOWN_" + selfUin, true);
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public void clearCurrentCoupleAvatarViewController(String peerUin, com.tencent.aio.api.runtime.a aioContext) {
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            CoupleAvatarViewController coupleAvatarViewController = (CoupleAvatarViewController) ZPlanCoupleSceneHelperImpl.coupleAvatarViewControllerMap.get(peerUin);
            if (coupleAvatarViewController == null || coupleAvatarViewController.getMAIOContext() == aioContext) {
                QLog.i(ZPlanCoupleSceneHelperImpl.TAG, 1, "clearCurrentCoupleAvatarViewController: " + coupleAvatarViewController);
                if (coupleAvatarViewController != null) {
                    coupleAvatarViewController.onMoveToState(15);
                }
                ZPlanCoupleSceneHelperImpl.coupleAvatarViewControllerMap.remove(peerUin);
            }
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public com.tencent.mobileqq.zplan.couple.manager.a createBubblePlayManager(CoupleAvatarSubScene subScene) {
            Intrinsics.checkNotNullParameter(subScene, "subScene");
            if (subScene == CoupleAvatarSubScene.AIO) {
                return new ZPlanCoupleGuideBubblePlayManager();
            }
            return new f();
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public Drawable getBackgroundDrawable(CoupleAvatarSubScene subScene, int targetDrawableWidth, int targetDrawableHeight, String bgPicUrl, Drawable lastBgDrawable) {
            Intrinsics.checkNotNullParameter(subScene, "subScene");
            Intrinsics.checkNotNullParameter(bgPicUrl, "bgPicUrl");
            return d.f441627a.e(subScene, targetDrawableWidth, targetDrawableHeight, bgPicUrl, lastBgDrawable);
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public boolean getCoupleAvatarSwitchState(String friendUin) {
            Long longOrNull;
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(friendUin);
            if (longOrNull == null) {
                return false;
            }
            long longValue = longOrNull.longValue();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e(ZPlanCoupleSceneHelperImpl.TAG, 1, "app is null");
                return false;
            }
            if (!peekAppRuntime.getCurrentUin().equals(friendUin) && ((IZPlanAIOWhiteListApi) QRoute.api(IZPlanAIOWhiteListApi.class)).hasAvatarFeature()) {
                return ZPlanCoupleProfileDataProcessor.f332677a.g(longValue);
            }
            return false;
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public i getCoupleAvatarViewController(String peerUin, com.tencent.aio.api.runtime.a aioContext) {
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            CoupleAvatarViewController coupleAvatarViewController = (CoupleAvatarViewController) ZPlanCoupleSceneHelperImpl.coupleAvatarViewControllerMap.get(peerUin);
            if (coupleAvatarViewController != null) {
                if (aioContext == null || aioContext == coupleAvatarViewController.getMAIOContext()) {
                    return coupleAvatarViewController;
                }
                return null;
            }
            if (aioContext == null) {
                return null;
            }
            CoupleAvatarViewController coupleAvatarViewController2 = new CoupleAvatarViewController(peerUin, aioContext);
            ZPlanCoupleSceneHelperImpl.coupleAvatarViewControllerMap.put(peerUin, coupleAvatarViewController2);
            return coupleAvatarViewController2;
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public int getCoupleSceneId(long friendUin) {
            int f16 = ZPlanCoupleProfileDataProcessor.f332677a.f(friendUin);
            QLog.i(ZPlanCoupleSceneHelperImpl.TAG, 1, "getCoupleSceneID, uin: " + friendUin + ", sceneId: " + f16);
            return f16;
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public boolean getSettingBubbleShownMark(String selfUin) {
            Intrinsics.checkNotNullParameter(selfUin, "selfUin");
            return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("COUPLE_SETTING_BUBBLE_SHOWN_" + selfUin, false);
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public String getZPlanChatBackgroundPicPath(String selfUin, String friendUin, int uinType) {
            Intrinsics.checkNotNullParameter(selfUin, "selfUin");
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
            return d.f441627a.i(selfUin, friendUin, uinType);
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public List<ZPlanCoupleBubbleConfig> getZPlanSettingBubbles() {
            return ZPlanCoupleBubbleDataManager.f332649a.i();
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public void requestZPlanSettingBubbles() {
            ZPlanCoupleBubbleDataManager.f332649a.l();
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public void setCoupleAvatarSwitchState(String friendUin, boolean open, ZPlanCoupleSwitchChgSource source) {
            Long longOrNull;
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
            QLog.i(ZPlanCoupleSceneHelperImpl.TAG, 1, "setFriendTimesState, friendUin: " + friendUin + ", open: " + open);
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(friendUin);
            if (longOrNull != null) {
                ZPlanCoupleProfileDataProcessor.f332677a.m(longOrNull.longValue(), open);
                ((IThemeEffectApi) QRoute.api(IThemeEffectApi.class)).switchAIOBackground(open, friendUin, 0);
                if (!open) {
                    String peerUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(friendUin);
                    SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                    Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
                    simpleEventBus.dispatchEvent(new AvatarBgChangeEvent(peerUid, true));
                }
                reportSwitchStateChange(source, open);
            }
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public void setCoupleSceneId(long friendUin, int sceneID, boolean needPush) {
            QLog.i(ZPlanCoupleSceneHelperImpl.TAG, 1, "setCoupleSceneId, uin: " + friendUin + ", sceneId: " + sceneID + " needPush:" + needPush);
            ZPlanCoupleProfileDataProcessor.f332677a.l(friendUin, sceneID, needPush);
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public void setSettingBubbleShownMark(final String selfUin) {
            Intrinsics.checkNotNullParameter(selfUin, "selfUin");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.couple.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanCoupleSceneHelperImpl.Companion.setSettingBubbleShownMark$lambda$1(selfUin);
                }
            }, 16, null, true);
        }

        @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
        public void setZPlanChatBackgroundPicPath(String selfUin, String friendUin, String bgPicUrl, int uinType) {
            Intrinsics.checkNotNullParameter(selfUin, "selfUin");
            Intrinsics.checkNotNullParameter(friendUin, "friendUin");
            Intrinsics.checkNotNullParameter(bgPicUrl, "bgPicUrl");
            d.f441627a.m(selfUin, friendUin, bgPicUrl, uinType);
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void reportSwitchStateChange$lambda$0(ZPlanCoupleSwitchChgSource zPlanCoupleSwitchChgSource, boolean z16) {
            int ordinal;
            String str;
            if (zPlanCoupleSwitchChgSource != null) {
                try {
                    ordinal = zPlanCoupleSwitchChgSource.ordinal();
                } catch (Throwable th5) {
                    QLog.e(ZPlanCoupleSceneHelperImpl.TAG, 1, "reportSwitchStateChange failed.", th5);
                    return;
                }
            } else {
                ordinal = 0;
            }
            if (z16) {
                str = "open";
            } else {
                str = "close";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
            hashMap.put("zplan_avatar_open_source", String.valueOf(ordinal));
            hashMap.put("zplan_switch_action_type", str);
            VideoReport.reportEvent("ev_zplan_avatar_switch", hashMap);
        }
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public void clearCurrentCoupleAvatarViewController(String peerUin, com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.$$delegate_0.clearCurrentCoupleAvatarViewController(peerUin, aioContext);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public com.tencent.mobileqq.zplan.couple.manager.a createBubblePlayManager(CoupleAvatarSubScene subScene) {
        Intrinsics.checkNotNullParameter(subScene, "subScene");
        return this.$$delegate_0.createBubblePlayManager(subScene);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public Drawable getBackgroundDrawable(CoupleAvatarSubScene subScene, int targetDrawableWidth, int targetDrawableHeight, String bgPicUrl, Drawable lastBgDrawable) {
        Intrinsics.checkNotNullParameter(subScene, "subScene");
        Intrinsics.checkNotNullParameter(bgPicUrl, "bgPicUrl");
        return this.$$delegate_0.getBackgroundDrawable(subScene, targetDrawableWidth, targetDrawableHeight, bgPicUrl, lastBgDrawable);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public boolean getCoupleAvatarSwitchState(String friendUin) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        return this.$$delegate_0.getCoupleAvatarSwitchState(friendUin);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public i getCoupleAvatarViewController(String peerUin, com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        return this.$$delegate_0.getCoupleAvatarViewController(peerUin, aioContext);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public int getCoupleSceneId(long friendUin) {
        return this.$$delegate_0.getCoupleSceneId(friendUin);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public boolean getSettingBubbleShownMark(String selfUin) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        return this.$$delegate_0.getSettingBubbleShownMark(selfUin);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public String getZPlanChatBackgroundPicPath(String selfUin, String friendUin, int uinType) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        return this.$$delegate_0.getZPlanChatBackgroundPicPath(selfUin, friendUin, uinType);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public List<ZPlanCoupleBubbleConfig> getZPlanSettingBubbles() {
        return this.$$delegate_0.getZPlanSettingBubbles();
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public void requestZPlanSettingBubbles() {
        this.$$delegate_0.requestZPlanSettingBubbles();
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public void setCoupleAvatarSwitchState(String friendUin, boolean open, ZPlanCoupleSwitchChgSource source) {
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        this.$$delegate_0.setCoupleAvatarSwitchState(friendUin, open, source);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public void setCoupleSceneId(long friendUin, int sceneID, boolean needPush) {
        this.$$delegate_0.setCoupleSceneId(friendUin, sceneID, needPush);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public void setSettingBubbleShownMark(String selfUin) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        this.$$delegate_0.setSettingBubbleShownMark(selfUin);
    }

    @Override // com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper
    public void setZPlanChatBackgroundPicPath(String selfUin, String friendUin, String bgPicUrl, int uinType) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(bgPicUrl, "bgPicUrl");
        this.$$delegate_0.setZPlanChatBackgroundPicPath(selfUin, friendUin, bgPicUrl, uinType);
    }
}
