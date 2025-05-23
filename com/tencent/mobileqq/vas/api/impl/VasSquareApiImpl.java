package com.tencent.mobileqq.vas.api.impl;

import ac3.ZPlanDownloadHttpDnsKey;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.data.SquareRecordReason;
import com.tencent.mobileqq.vas.social.SocialActionRecordHelper;
import com.tencent.mobileqq.vas.social.config.VasSquareAvatarUtils;
import com.tencent.mobileqq.vas.social.config.VasSquareRecorder;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.SquareRuntime;
import com.tencent.state.config.NetworkConfig;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasSquarePatchAddService;
import com.tencent.state.service.VasSquareTempChatService;
import com.tencent.state.service.VasStatusSquareService;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareConfig;
import com.tencent.state.square.SquareGroupFragment;
import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.avatar.filament.FilamentReportHelper;
import com.tencent.state.square.avatar.filament.SquareActionHelperKt;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.SquareRecordManager;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 _2\u00020\u0001:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J<\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016JD\u0010!\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0011H\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\"H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\n\u0010+\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0002H\u0016J\\\u00107\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00022:\u00106\u001a6\u0012\u0015\u0012\u0013\u0018\u00010$\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u000601H\u0016J$\u00109\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00022\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000608H\u0016J\"\u0010?\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00022\u0006\u0010<\u001a\u00020;2\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010A\u001a\u00020\r2\u0006\u0010@\u001a\u00020\u0002H\u0016J\u0012\u0010E\u001a\u00020D2\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J$\u0010J\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00022\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020H0GH\u0016J\b\u0010K\u001a\u00020\rH\u0016J\b\u0010L\u001a\u00020\rH\u0016R\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010Q\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasSquareApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasSquareApi;", "", com.heytap.mcssdk.a.a.f36102l, "Lcom/tencent/state/square/SquareConfig;", "getSquareConfig", "", "checkSquareConfig", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "handleSquareEnterTheme", "", "isSquareRuntimeReady", "lunchLibrary", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "startSquareDetailPage", "startSquareActivity", "startLibraryActivity", "startChatLandActivity", "Lcom/tencent/mobileqq/vas/data/SquareRecordReason;", "reason", "recordFilamentAvatarCover", "Lcom/tencent/state/square/api/RecordSuccessListener;", "listener", "addRecordDoneListener", "removeRecordDoneListener", "initializeSquare", "url", "actionName", "handleSquareScheme", "", "type", "", "data", "handleOIDBPush", "appearanceKey", "gender", "refreshAppearance", "doDns", "getDnsIp", "uin", "onMusicInfoChange", "scene", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "receiverUin", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "token", "receiverUid", "callback", "getSquareAioToken", "Lkotlin/Function1;", "checkTargetInSquare", "method", "Lcom/tencent/mtt/hippy/common/HippyMap;", "readableMap", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "onHippyMethodCall", "moduleName", "isSquareHippyModule", "Lc33/a;", "embedParams", "Landroidx/fragment/app/Fragment;", "getSquareFragment", "eventId", "", "", "businessParams", "reportCustomEvent", "isUsedFilament", "isDeviceSupported", "Lcom/tencent/mobileqq/vas/social/config/n;", "squareNetworkDelegate", "Lcom/tencent/mobileqq/vas/social/config/n;", "Lcom/tencent/mobileqq/vas/social/config/q;", "rapierDelegate", "Lcom/tencent/mobileqq/vas/social/config/q;", "Lcom/tencent/mobileqq/vas/social/config/i;", "hippyEngine", "Lcom/tencent/mobileqq/vas/social/config/i;", "ip", "Ljava/lang/String;", "Lcom/tencent/mobileqq/vas/social/config/s;", "reporter", "Lcom/tencent/mobileqq/vas/social/config/s;", "isHttpDNSEnabled", "Z", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasSquareApiImpl implements IVasSquareApi {
    private static final String MSDKDNS_INIT_OpenID = "zplan_vas_square";
    private static final String MSDKDNS_INIT_SERVICE = "119.29.29.98";
    private static final int MSDKDNS_INIT_TIMEOUT = 1000;
    private static final String RECORD_CDN_HOST = "https://record.superqqshow.qq.com";
    private static final String SQUARE_DNS_ENABLED = "square_dns_enabled";
    private static final String SQUARE_MAIN_SOURCE = "em_zplan_entrance_qq_main_square";
    private static final String SQUARE_SOURCE_KEY = "subReferer";
    private static final String SQUARE_SPACE_TYPE_KEY = "space_type";
    private static final String SQUARE_SPACE_TYPE_LIBRARY = "library";
    private static final String TAG = "VasSquareApiImpl";
    private String ip;
    private boolean isHttpDNSEnabled;
    private final com.tencent.mobileqq.vas.social.config.n squareNetworkDelegate = new com.tencent.mobileqq.vas.social.config.n();
    private final com.tencent.mobileqq.vas.social.config.q rapierDelegate = new com.tencent.mobileqq.vas.social.config.q();
    private final com.tencent.mobileqq.vas.social.config.i hippyEngine = new com.tencent.mobileqq.vas.social.config.i();
    private final com.tencent.mobileqq.vas.social.config.s reporter = new com.tencent.mobileqq.vas.social.config.s(null, 1, 0 == true ? 1 : 0);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f308545a;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.TABLET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.FOLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f308545a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasSquareApiImpl$c", "Lcom/tencent/state/service/ResultCallback;", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements ResultCallback<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f308546a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Boolean, Unit> function1) {
            this.f308546a = function1;
        }

        public void a(boolean result) {
            this.f308546a.invoke(Boolean.valueOf(result));
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int i3, String str) {
            ResultCallback.DefaultImpls.onResultFailure(this, i3, str);
        }

        @Override // com.tencent.state.service.ResultCallback
        public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
            a(bool.booleanValue());
        }

        @Override // com.tencent.state.service.ResultCallback
        public void onResultFailure(int i3, String str, String str2) {
            ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
        }
    }

    public VasSquareApiImpl() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(SQUARE_DNS_ENABLED, false);
        this.isHttpDNSEnabled = isSwitchOn;
        if (isSwitchOn) {
            try {
                ZPlanDownloadHttpDnsKey d16 = ac3.b.INSTANCE.d();
                com.tencent.msdk.dns.c.h().i(BaseApplication.getContext(), d16.getAppKey(), d16.getDnsId(), d16.getDnsKey(), MSDKDNS_INIT_SERVICE, false, 1000);
                com.tencent.msdk.dns.c.h().a(MSDKDNS_INIT_OpenID);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "MSDKDnsResolver init throw:", e16);
            }
        }
        initializeSquare();
    }

    private final void checkSquareConfig(String appKey) {
        Square square = Square.INSTANCE;
        boolean isSquareConfigInvalid = square.isSquareConfigInvalid();
        String commonUtilsClassName = square.getCommonUtilsClassName();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        QLog.i(TAG, 1, "checkSquareConfig: isSquareConfigInvalid=" + isSquareConfigInvalid + ", myUin=" + currentAccountUin + ", isCurrentUin=" + square.getConfig().getCommonUtils().isCurrentAccount(currentAccountUin) + ", utilClassName=" + commonUtilsClassName);
        SquareBase.INSTANCE.initialize(getSquareConfig(appKey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doDns$lambda$1(VasSquareApiImpl this$0) {
        List split$default;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String hostFromUrl = InnerDns.getHostFromUrl(RECORD_CDN_HOST);
        if (hostFromUrl != null) {
            String c16 = com.tencent.msdk.dns.c.h().c(hostFromUrl);
            Intrinsics.checkNotNullExpressionValue(c16, "getInstance().getAddrByName(domain)");
            QLog.d(TAG, 1, "reqSerAddrList domain:" + hostFromUrl + " result:" + c16);
            split$default = StringsKt__StringsKt.split$default((CharSequence) c16, new char[]{';'}, false, 0, 6, (Object) null);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) split$default);
            String str = (String) firstOrNull;
            if (str == null || Intrinsics.areEqual(str, "0")) {
                return;
            }
            this$0.ip = str;
            QLog.d(TAG, 1, "set ip:" + str);
        }
    }

    private final SquareConfig getSquareConfig(String appKey) {
        File file = new File(BaseApplication.getContext().getExternalCacheDir(), "square");
        com.tencent.mobileqq.vas.social.b bVar = new com.tencent.mobileqq.vas.social.b();
        return new SquareConfig(false, file, false, new com.tencent.mobileqq.vas.social.m(), new com.tencent.mobileqq.vas.social.u(), bVar, new com.tencent.mobileqq.vas.social.config.t(), new VasSquareRecorder(), new com.tencent.mobileqq.vas.social.config.f(), new com.tencent.mobileqq.vas.social.config.o(), new com.tencent.mobileqq.vas.message.d(), new com.tencent.mobileqq.vas.social.service.d(), new com.tencent.mobileqq.vas.social.config.p(), new com.tencent.mobileqq.vas.social.config.s(appKey), null, new com.tencent.mobileqq.vas.social.config.u(), this.hippyEngine, true, null, new com.tencent.mobileqq.vas.social.config.w(), new VasSquareAvatarUtils(), 278532, null);
    }

    private final void handleSquareEnterTheme(Context context, Bundle bundle) {
        String string = bundle.getString(SQUARE_SPACE_TYPE_KEY);
        if (string == null) {
            return;
        }
        if (Intrinsics.areEqual(string, "library")) {
            lunchLibrary(context, bundle);
        } else {
            startSquareActivity(context, bundle);
        }
    }

    private final boolean isSquareRuntimeReady(Context context) {
        return SquareRuntime.INSTANCE.hasMark();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMusicInfoChange$lambda$2(String uin) {
        IFriendHandlerTempService iFriendHandlerTempService;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || (iFriendHandlerTempService = (IFriendHandlerTempService) appInterface.getRuntimeService(IFriendHandlerTempService.class, "")) == null) {
            return;
        }
        iFriendHandlerTempService.getOnlineInfo(uin, false);
    }

    private final void startSquareDetailPage(Context context, HashMap<String, String> params, Bundle bundle) {
        String str = params.get("uin");
        if (Intrinsics.areEqual(str, "0") || str == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            str = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        }
        bundle.putString(LauncherConst.KEY_OPEN_DETAIL_UIN, str);
        bundle.putInt("launch_type", 3);
        startSquareActivity(context, bundle);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void addRecordDoneListener(RecordSuccessListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialActionRecordHelper.f310651d.d(listener);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void checkTargetInSquare(String uin, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new VasSquarePatchAddService().checkUserInSquare(uin, new c(callback));
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void doDns() {
        if (this.isHttpDNSEnabled) {
            QLog.d(TAG, 2, "doDns needIpConnect:" + ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d().e());
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.aq
                @Override // java.lang.Runnable
                public final void run() {
                    VasSquareApiImpl.doDns$lambda$1(VasSquareApiImpl.this);
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    /* renamed from: getDnsIp, reason: from getter */
    public String getIp() {
        return this.ip;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void getSquareAioToken(int scene, String senderUin, String receiverUin, final Function2<? super byte[], ? super String, Unit> callback) {
        Long longOrNull;
        Long longOrNull2;
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(receiverUin, "receiverUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        VasSquareTempChatService vasSquareTempChatService = VasSquareTempChatService.INSTANCE;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(senderUin);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(receiverUin);
        vasSquareTempChatService.getToken(scene, longValue, longOrNull2 != null ? longOrNull2.longValue() : 0L, new Function3<Boolean, byte[], String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasSquareApiImpl$getSquareAioToken$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, byte[] bArr, String str) {
                invoke(bool.booleanValue(), bArr, str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, byte[] bArr, String str) {
                if (z16) {
                    callback.invoke(bArr, str);
                } else {
                    QLog.d("VasSquareApiImpl", 1, "getSquareAioToken fail");
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public Fragment getSquareFragment(c33.a embedParams) {
        SquareGroupFragment newInstance$default = SquareGroupFragment.Companion.newInstance$default(SquareGroupFragment.INSTANCE, null, 1, null);
        Intrinsics.checkNotNull(newInstance$default, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return newInstance$default;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void handleOIDBPush(int type, byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        f33.a.f397786a.b(type, data);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public boolean handleSquareScheme(Context context, String url, String actionName, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(params, "params");
        return false;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void initializeSquare() {
        QLog.i(TAG, 1, "initialize square.");
        QLog.i(TAG, 1, "initialize square: isRealInitialized=" + Square.initialize$default(Square.INSTANCE, getSquareConfig$default(this, null, 1, null), null, 2, null));
        checkSquareConfig$default(this, null, 1, null);
        NetworkConfig.INSTANCE.setupNetworkDelegate(this.squareNetworkDelegate);
        com.tencent.rapier.l.f364071b.b(this.rapierDelegate);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public boolean isDeviceSupported() {
        DeviceType a16 = PadUtil.a(BaseApplication.context);
        int i3 = a16 == null ? -1 : b.f308545a[a16.ordinal()];
        return (i3 == 1 || i3 == 2) ? false : true;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public boolean isSquareHippyModule(String moduleName) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(moduleName, HippyQQConstants.ModuleName.QQ_VAS_SQUARE, false, 2, null);
        return startsWith$default;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public boolean isUsedFilament() {
        return FilamentReportHelper.INSTANCE.isUsedFilament();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void onHippyMethodCall(String method, HippyMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        this.hippyEngine.b(method, readableMap, promise);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void onMusicInfoChange(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d(TAG, 4, "onMusicInfoChange uin:" + uin);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.ar
            @Override // java.lang.Runnable
            public final void run() {
                VasSquareApiImpl.onMusicInfoChange$lambda$2(uin);
            }
        }, 128, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void recordFilamentAvatarCover(final SquareRecordReason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (!com.tencent.mobileqq.vas.qqmc.b.f310591a.a().getEnableDressKeyTrigger()) {
            QLog.d(TAG, 1, "recordFilamentAvatarCover: enableDressKeyTrigger is false");
            return;
        }
        final Function2<CoroutineContext, Throwable, Unit> function2 = new Function2<CoroutineContext, Throwable, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasSquareApiImpl$recordFilamentAvatarCover$handleException$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(CoroutineContext coroutineContext, Throwable th5) {
                invoke2(coroutineContext, th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CoroutineContext coroutineContext, Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                QLog.e("VasSquareApiImpl", 1, "recordFilamentAvatarCover: handleException, reason:" + SquareRecordReason.this.name() + ", throwable:" + throwable.getMessage());
            }
        };
        QLog.d(TAG, 1, "recordFilamentAvatarCover " + reason);
        VasStatusSquareService.INSTANCE.getMyCurrentResources(new ResultCallback<List<? extends Resource>>() { // from class: com.tencent.mobileqq.vas.api.impl.VasSquareApiImpl$recordFilamentAvatarCover$1
            @Override // com.tencent.state.service.ResultCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(List<Resource> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.d("VasSquareApiImpl", 1, "recordFilamentAvatarCover: getMyCurrentResources success, result:" + result.size());
                Function2<CoroutineContext, Throwable, Unit> function22 = function2;
                for (Resource resource : result) {
                    QLog.d("VasSquareApiImpl", 1, "recordFilamentAvatarCover: actionId=" + resource.getActionId() + ", dressKeys=" + resource.getFilament().getUserDressKey());
                    SquareActionHelperKt.launchCoroutine(Dispatchers.getIO(), function22, new VasSquareApiImpl$recordFilamentAvatarCover$1$onResultSuccess$1$1(resource, null));
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                QLog.e("VasSquareApiImpl", 1, "recordFilamentAvatarCover: getMyCurrentResources error:" + error + ", message:" + message);
            }
        });
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void refreshAppearance(String appearanceKey, int gender) {
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        QLog.d(TAG, 1, "onAppearanceChange appearanceKey:" + appearanceKey + ", gender:" + gender);
        SquareRecordManager.INSTANCE.updateDressKey(appearanceKey, "refreshAppearance", true, gender != 2);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void removeRecordDoneListener(RecordSuccessListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SocialActionRecordHelper.f310651d.I(listener);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void reportCustomEvent(String eventId, Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        this.reporter.reportEvent(eventId, businessParams);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void startChatLandActivity(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void startLibraryActivity(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasSquareApi
    public void startSquareActivity(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    static /* synthetic */ void checkSquareConfig$default(VasSquareApiImpl vasSquareApiImpl, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = SquareReportConst.APP_KEY;
        }
        vasSquareApiImpl.checkSquareConfig(str);
    }

    static /* synthetic */ SquareConfig getSquareConfig$default(VasSquareApiImpl vasSquareApiImpl, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = SquareReportConst.APP_KEY;
        }
        return vasSquareApiImpl.getSquareConfig(str);
    }

    private final void lunchLibrary(Context context, Bundle bundle) {
    }
}
