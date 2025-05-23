package com.tencent.mobileqq.troop.api.impl;

import android.util.SparseArray;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopMemberLevelService;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopmemberlevel.level.filter.AnonymousFilter;
import com.tencent.mobileqq.troop.troopmemberlevel.level.filter.RobotFilter;
import com.tencent.mobileqq.troop.troopmemberlevel.level.filter.SpecialAccountFilter;
import com.tencent.mobileqq.troop.troopmemberlevel.level.filter.SwitchFilter;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\b*\u00015\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\u001a\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J \u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00104\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopMemberLevelServiceImpl;", "Lcom/tencent/mobileqq/troop/api/ITroopMemberLevelService;", "Lcom/tencent/mobileqq/troop/troopmemberlevel/level/filter/a;", "filter", "", "putFilter", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "isAllowDisplayInAIO", "", "newConfig", "updateConfig", "", "troopUin", "onTroopAdminChanged", "isNewRealLevelGrayTroop", "Lcom/tencent/mobileqq/troop/memberlevel/api/b;", "getConfig", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "Lcom/tencent/qqnt/aio/nick/f;", "getTroopMemberLevelForAIO", "memberUin", "memberLevelInfo", "sendMemberLevelUpdateEvent", "checkNeedRefreshAIOWhenProcessMsg", "isNeedRefreshTroopAIO", "clearNeedRefreshTroopFlag", "Lcom/tencent/common/app/AppInterface;", "mApp", "Lcom/tencent/common/app/AppInterface;", "Landroid/util/SparseArray;", "mFilterList", "Landroid/util/SparseArray;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mConfigLoadedFlag", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mHasChecked", "mNeedRefreshAIO", "mConfig", "Lcom/tencent/mobileqq/troop/memberlevel/api/b;", "mDefaultConfig$delegate", "Lkotlin/Lazy;", "getMDefaultConfig", "()Lcom/tencent/mobileqq/troop/memberlevel/api/b;", "mDefaultConfig", "com/tencent/mobileqq/troop/api/impl/TroopMemberLevelServiceImpl$b", "mTroopMngObserver", "Lcom/tencent/mobileqq/troop/api/impl/TroopMemberLevelServiceImpl$b;", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopMemberLevelServiceImpl implements ITroopMemberLevelService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int INVALID_VALUE = -1;

    @NotNull
    private static final String TAG = "TroopMemberLevelServiceImpl";
    private AppInterface mApp;

    @Nullable
    private volatile com.tencent.mobileqq.troop.memberlevel.api.b mConfig;

    @NotNull
    private final AtomicBoolean mConfigLoadedFlag;

    /* renamed from: mDefaultConfig$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDefaultConfig;

    @NotNull
    private final SparseArray<com.tencent.mobileqq.troop.troopmemberlevel.level.filter.a> mFilterList;

    @NotNull
    private final AtomicBoolean mHasChecked;

    @NotNull
    private final AtomicBoolean mNeedRefreshAIO;

    @NotNull
    private final b mTroopMngObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopMemberLevelServiceImpl$a;", "", "", "INVALID_VALUE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.api.impl.TroopMemberLevelServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0014\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/api/impl/TroopMemberLevelServiceImpl$b", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "isSuccess", "", "troopuin", "", "oldOwnerUid", "newOwnerUid", "", "result", "strErrorMsg", "", "e", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberLevelServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void e(boolean isSuccess, long troopuin, @Nullable String oldOwnerUid, @Nullable String newOwnerUid, int result, @Nullable String strErrorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Long.valueOf(troopuin), oldOwnerUid, newOwnerUid, Integer.valueOf(result), strErrorMsg);
                return;
            }
            if (isSuccess && troopuin > 0) {
                AppInterface appInterface = TroopMemberLevelServiceImpl.this.mApp;
                if (appInterface == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mApp");
                    appInterface = null;
                }
                BusinessHandler businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.handler.TroopInfoHandler");
                ((TroopInfoHandler) businessHandler).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, String.valueOf(troopuin));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23867);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopMemberLevelServiceImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mFilterList = new SparseArray<>();
        this.mConfigLoadedFlag = new AtomicBoolean(false);
        this.mHasChecked = new AtomicBoolean(false);
        this.mNeedRefreshAIO = new AtomicBoolean(false);
        lazy = LazyKt__LazyJVMKt.lazy(TroopMemberLevelServiceImpl$mDefaultConfig$2.INSTANCE);
        this.mDefaultConfig = lazy;
        this.mTroopMngObserver = new b();
    }

    private final com.tencent.mobileqq.troop.memberlevel.api.b getMDefaultConfig() {
        Object value = this.mDefaultConfig.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mDefaultConfig>(...)");
        return (com.tencent.mobileqq.troop.memberlevel.api.b) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(TroopMemberLevelServiceImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.memberlevel.api.b config = this$0.getConfig();
        if (!config.j()) {
            QLog.i(TAG, 1, "config invalid, use default value");
            config = this$0.getMDefaultConfig();
        }
        this$0.updateConfig(config);
    }

    private final void putFilter(com.tencent.mobileqq.troop.troopmemberlevel.level.filter.a filter) {
        this.mFilterList.put(filter.b(), filter);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    public void checkNeedRefreshAIOWhenProcessMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.mHasChecked.compareAndSet(false, true)) {
            this.mNeedRefreshAIO.set(!this.mConfigLoadedFlag.get());
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    public void clearNeedRefreshTroopFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.mHasChecked.set(false);
            this.mNeedRefreshAIO.set(false);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    @NotNull
    public com.tencent.mobileqq.troop.memberlevel.api.b getConfig() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.troop.memberlevel.api.b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        try {
            if (this.mConfig == null) {
                this.mConfig = (com.tencent.mobileqq.troop.memberlevel.api.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102769");
            }
            if (this.mConfig == null) {
                QLog.w(TAG, 1, "[getConfig] use default config");
            }
            Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("9170_level_config_hard_check", Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(isSwitchOn, "api(IUnitedConfig::class\u2026config_hard_check\", true)");
            if (isSwitchOn.booleanValue()) {
                com.tencent.mobileqq.troop.memberlevel.api.b bVar = this.mConfig;
                if (bVar != null) {
                    i3 = bVar.F;
                } else {
                    i3 = 0;
                }
                if (i3 < 9170) {
                    return getMDefaultConfig();
                }
            }
            com.tencent.mobileqq.troop.memberlevel.api.b bVar2 = this.mConfig;
            if (bVar2 == null) {
                return getMDefaultConfig();
            }
            return bVar2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[getSwitch] exception: " + e16, e16);
            return getMDefaultConfig();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    @NotNull
    public com.tencent.qqnt.aio.nick.f getTroopMemberLevelForAIO(@NotNull TroopInfo troopInfo, @Nullable TroopMemberInfo troopMemberInfo) {
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.aio.nick.f) iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopInfo, (Object) troopMemberInfo);
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(troopInfo, troopMemberInfo);
        if (troopMemberRankItem != null) {
            int i3 = troopMemberRankItem.f300590a;
            int i16 = troopMemberRankItem.f300591b;
            String str = troopMemberRankItem.f300592c;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            int[] iArr2 = troopMemberRankItem.f300593d;
            if (iArr2 == null) {
                iArr2 = new int[0];
            }
            int[] iArr3 = iArr2;
            int[] iArr4 = troopMemberRankItem.f300594e;
            if (iArr4 == null) {
                iArr = new int[0];
            } else {
                iArr = iArr4;
            }
            return new com.tencent.qqnt.aio.nick.f(i3, i16, str2, iArr3, iArr, troopMemberRankItem.f300595f, troopMemberRankItem.f300596g, troopMemberRankItem.f300597h, troopMemberRankItem.f300598i, troopMemberRankItem.f300599j);
        }
        return new com.tencent.qqnt.aio.nick.f(-1, -1, "", new int[0], new int[0], false, false, -1, -1, null);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    public boolean isAllowDisplayInAIO(@NotNull AppRuntime appRuntime, @NotNull TroopInfo troopInfo, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, appRuntime, troopInfo, msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 2) {
            return false;
        }
        com.tencent.mobileqq.troop.troopmemberlevel.level.filter.b bVar = new com.tencent.mobileqq.troop.troopmemberlevel.level.filter.b(appRuntime, troopInfo, msgItem, String.valueOf(msgItem.getMsgRecord().senderUin));
        SparseArray<com.tencent.mobileqq.troop.troopmemberlevel.level.filter.a> sparseArray = this.mFilterList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            com.tencent.mobileqq.troop.troopmemberlevel.level.filter.a valueAt = sparseArray.valueAt(i3);
            if (!valueAt.a(bVar)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "NotAllowDisplayInAIO filter=" + valueAt.getClass().getSimpleName() + " filterArgs=" + bVar + " --> false");
                }
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    public boolean isNeedRefreshTroopAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mNeedRefreshAIO.get();
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    public boolean isNewRealLevelGrayTroop(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopUin)).booleanValue();
        }
        return getConfig().k(troopUin);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.mApp = (AppInterface) appRuntime;
        putFilter(new AnonymousFilter());
        putFilter(new SpecialAccountFilter());
        putFilter(new RobotFilter());
        putFilter(new SwitchFilter());
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appInterface = null;
        }
        appInterface.addObserver(this.mTroopMngObserver);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberLevelServiceImpl.onCreate$lambda$0(TroopMemberLevelServiceImpl.this);
            }
        }, 16, null, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApp");
            appInterface = null;
        }
        appInterface.removeObserver(this.mTroopMngObserver);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    public void onTroopAdminChanged(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopUin);
            return;
        }
        if (troopUin != null) {
            AppInterface appInterface = this.mApp;
            if (appInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                appInterface = null;
            }
            BusinessHandler businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.handler.TroopInfoHandler");
            ((TroopInfoHandler) businessHandler).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_INFO_CHANGED, true, troopUin);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    public void sendMemberLevelUpdateEvent(@NotNull String troopUin, @NotNull String memberUin, @NotNull com.tencent.qqnt.aio.nick.f memberLevelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, troopUin, memberUin, memberLevelInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        Intrinsics.checkNotNullParameter(memberLevelInfo, "memberLevelInfo");
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.n(troopUin, memberUin, memberLevelInfo.f(), memberLevelInfo.i(), memberLevelInfo.h(), memberLevelInfo.e(), memberLevelInfo.b(), memberLevelInfo.l(), memberLevelInfo.m(), memberLevelInfo.g(), memberLevelInfo.c(), memberLevelInfo.j()));
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberLevelService
    public void updateConfig(@Nullable Object newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, newConfig);
            return;
        }
        if (newConfig instanceof com.tencent.mobileqq.troop.memberlevel.api.b) {
            synchronized (this) {
                this.mConfig = (com.tencent.mobileqq.troop.memberlevel.api.b) newConfig;
                Unit unit = Unit.INSTANCE;
            }
            this.mConfigLoadedFlag.set(true);
            AppInterface appInterface = this.mApp;
            if (appInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mApp");
                appInterface = null;
            }
            BusinessHandler businessHandler = appInterface.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.handler.TroopInfoHandler");
            ((TroopInfoHandler) businessHandler).notifyUI(com.tencent.mobileqq.troop.api.observer.e.TYPE_TROOP_MEMBER_LEVEL_GLOBAL_CHANGED, true, null);
        }
    }
}
