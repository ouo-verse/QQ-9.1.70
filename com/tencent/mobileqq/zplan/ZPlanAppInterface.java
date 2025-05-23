package com.tencent.mobileqq.zplan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseZplanAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.SharpSoLoader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.pic.ab;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.startup.task.cm;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.VasApngDownloader;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.an;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.utils.ba;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneEnvApi;
import com.tencent.zplan.common.soloader.c;
import com.tencent.zplan.common.soloader.p017default.InternalSoLoader;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.engine.service.EngineLifeCycleReporter;
import cooperation.qwallet.plugin.QWalletPicHelper;
import eipc.EIPCContentProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tl.h;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001<B\u001b\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\b\u00108\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b9\u0010:J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017H\u0016J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010 \u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u001f\u0010$\u001a\u00020\u00042\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\"\u0018\u00010!\u00a2\u0006\u0004\b$\u0010%J\u0016\u0010(\u001a\u00020\u00042\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010&R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/zplan/ZPlanAppInterface;", "Lcom/tencent/common/app/business/BaseZplanAppInterface;", "Landroid/content/Intent;", "intent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "p", "exitProcess", "r", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Lcom/tencent/mobileqq/service/MobileQQServiceBase;", "getMobileQQService", "", "getCurrentAccountUin", "Lcom/tencent/qphone/base/util/BaseApplication;", "getApp", "", "getAppid", "", "highPriorityWhenBackground", "Ljava/util/ArrayList;", "getLowerPriorityProcessList", HippyTKDListViewAdapter.X, "u", "Lhj3/a;", DomainData.DOMAIN_NAME, "Ljava/util/Observer;", "observer", "addObserver", "deleteObserver", "", "", "data", ReportConstant.COSTREPORT_PREFIX, "([Ljava/lang/Object;)V", "", "processList", "y", "d", "Lcom/tencent/mobileqq/service/MobileQQServiceBase;", "qqService", "e", "Lhj3/a;", "mZPlanNotifyCenter", "f", "Ljava/util/ArrayList;", "lowerPriorityProcessList", "Landroid/content/BroadcastReceiver;", h.F, "Landroid/content/BroadcastReceiver;", "mZPlanReceiver", "Lmqq/app/MobileQQ;", "app", "processName", "<init>", "(Lmqq/app/MobileQQ;Ljava/lang/String;)V", "i", "Companion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAppInterface extends BaseZplanAppInterface {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final AtomicBoolean f329826m = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private MobileQQServiceBase qqService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private hj3.a mZPlanNotifyCenter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> lowerPriorityProcessList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver mZPlanReceiver;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J2\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001e\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\u0005H\u0002J$\u0010\t\u001a\u00020\u00072\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0005H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/ZPlanAppInterface$Companion;", "", "", "verifyValue", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "nameList", "", "d", "c", "Landroid/content/Context;", "context", "", "e", "ACTION_PROCESS_EXIT", "Ljava/lang/String;", "KEEP_CNT", "PROC_NAME_LIST", "PROTO_FILE", "TAG", "VERIFY", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitURLDrawable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(String verifyValue, ArrayList<String> nameList) {
            if (Foreground.getActivityCount() > 0 || verifyValue == null || verifyValue.length() == 0) {
                return false;
            }
            return Intrinsics.areEqual(verifyValue, BaseApplicationImpl.getLocalVerify(nameList, false)) || Intrinsics.areEqual(verifyValue, BaseApplicationImpl.getLocalVerify(nameList, true));
        }

        public final void e(final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            c.Companion companion = com.tencent.zplan.common.soloader.c.INSTANCE;
            companion.f("QQSoLoadManagerWrapper", new Function0<com.tencent.zplan.common.soloader.b>() { // from class: com.tencent.mobileqq.zplan.ZPlanAppInterface$Companion$registerSoLoader$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.zplan.common.soloader.b invoke() {
                    return new tk3.b();
                }
            });
            companion.f("debug", new Function0<com.tencent.zplan.common.soloader.b>() { // from class: com.tencent.mobileqq.zplan.ZPlanAppInterface$Companion$registerSoLoader$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.zplan.common.soloader.b invoke() {
                    return new com.tencent.zplan.common.soloader.p017default.a(context);
                }
            });
            companion.e("internal", InternalSoLoader.INSTANCE.a());
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(ArrayList<String> nameList) {
            if (nameList == null || nameList.size() == 0) {
                return true;
            }
            String str = MobileQQ.processName;
            if (str != null) {
                int size = nameList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (Intrinsics.areEqual(str, nameList.get(i3))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0014J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/zplan/ZPlanAppInterface$a", "Lcom/tencent/image/URLDrawableParams;", "Lcom/tencent/image/ApngSoLoader;", "getApngSoLoader", "Lcom/tencent/image/SharpSoLoader;", "getSharpSoLoader", "Landroid/graphics/drawable/Drawable;", "getDefualtFailedDrawable", "getDefaultLoadingDrawable", "", AudienceReportConst.PROTOCOL, "", "businessType", "Lcom/tencent/image/ProtocolDownloader;", "doGetDownloader", "doGetLocalFilePath", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends URLDrawableParams {
        a(Context context) {
            super(context);
        }

        @Override // com.tencent.image.URLDrawableParams
        protected ProtocolDownloader doGetDownloader(String protocol2, Object businessType) {
            boolean equals;
            boolean equals2;
            boolean equals3;
            boolean equals4;
            boolean equals5;
            boolean equals6;
            boolean equals7;
            equals = StringsKt__StringsJVMKt.equals(ProtocolDownloaderConstants.PROTOCOL_FILE_ASSISTANT_IMAGE, protocol2, true);
            if (!equals) {
                equals2 = StringsKt__StringsJVMKt.equals("file", protocol2, true);
                if (!equals2) {
                    equals3 = StringsKt__StringsJVMKt.equals("vasapngdownloader", protocol2, true);
                    if (!equals3) {
                        equals4 = StringsKt__StringsJVMKt.equals("http", protocol2, true);
                        if (!equals4) {
                            equals5 = StringsKt__StringsJVMKt.equals("https", protocol2, true);
                            if (!equals5) {
                                equals6 = StringsKt__StringsJVMKt.equals(QWalletPicHelper.PROTOCOL_QWALLET_DOWNLOAD, protocol2, true);
                                if (!equals6) {
                                    equals7 = StringsKt__StringsJVMKt.equals("assets_img", protocol2, true);
                                    if (equals7) {
                                        return new com.tencent.mobileqq.downloader.a();
                                    }
                                    return null;
                                }
                                return ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQWalletPicDownloader();
                            }
                        }
                        return new HttpDownloader();
                    }
                    return new VasApngDownloader();
                }
                return new LocaleFileDownloader();
            }
            return new FileAssistantDownloader(BaseApplicationImpl.getApplication());
        }

        @Override // com.tencent.image.URLDrawableParams
        protected String doGetLocalFilePath(String protocol2) {
            return null;
        }

        @Override // com.tencent.image.URLDrawableParams
        protected ApngSoLoader getApngSoLoader() {
            an h16 = an.h();
            Intrinsics.checkNotNullExpressionValue(h16, "getInstance()");
            return h16;
        }

        @Override // com.tencent.image.URLDrawableParams
        protected Drawable getDefaultLoadingDrawable() {
            return null;
        }

        @Override // com.tencent.image.URLDrawableParams
        protected Drawable getDefualtFailedDrawable() {
            return null;
        }

        @Override // com.tencent.image.URLDrawableParams
        protected SharpSoLoader getSharpSoLoader() {
            com.tencent.mobileqq.startup.step.c b16 = com.tencent.mobileqq.startup.step.c.b();
            Intrinsics.checkNotNullExpressionValue(b16, "getInstance()");
            return b16;
        }
    }

    public ZPlanAppInterface(MobileQQ mobileQQ, String str) {
        super(mobileQQ, str);
        this.lowerPriorityProcessList = new ArrayList<>();
        this.mZPlanReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.zplan.ZPlanAppInterface$mZPlanReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null || intent.getAction() == null) {
                    return;
                }
                String action = intent.getAction();
                QLog.i("[zplan]_ZPlanAppInterface", 1, "mZPlanReceiver#onReceive - " + action);
                if (action != null) {
                    switch (action.hashCode()) {
                        case -573186114:
                            if (action.equals(NewIntent.ACTION_ACCOUNT_KICKED)) {
                                ZPlanAppInterface.this.p();
                                return;
                            }
                            return;
                        case 667652209:
                            if (action.equals(NewIntent.ACTION_LOGOUT)) {
                                ZPlanAppInterface.this.p();
                                return;
                            }
                            return;
                        case 795621267:
                            if (action.equals("com.tencent.process.exit")) {
                                ZPlanAppInterface.this.q(intent);
                                return;
                            }
                            return;
                        case 870619995:
                            if (action.equals(NewIntent.ACTION_ACCOUNT_CHANGED)) {
                                ZPlanAppInterface.this.o();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ZPlanAppInterface this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.app.unregisterReceiver(this$0.mZPlanReceiver);
        } catch (Exception e16) {
            QLog.e("[zplan]_ZPlanAppInterface", 1, "exitProcess error, " + e16);
        }
        QLog.d("[zplan]_ZPlanAppInterface", 2, "do real kill process");
        SystemMethodProxy.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        ((gk3.a) vb3.a.f441346a.a(gk3.a.class)).L0("zplanProcess#handleAccountChanged");
        ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).onAccountChange();
        exitProcess();
    }

    private final void r() {
        File cacheDir;
        if (f329826m.compareAndSet(false, true)) {
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            if (Intrinsics.areEqual("mounted", Environment.getExternalStorageState())) {
                cacheDir = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
            } else {
                cacheDir = context.getCacheDir();
            }
            URLDrawable.init(ab.c(), new a(context));
            File file = new File(cacheDir, AppConstants.PATH_URLDRAWABLE_DISKCACHE);
            cm.INSTANCE.b(new DiskCache(file));
            URLDrawableHelper.diskCachePath = file;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ZPlanAppInterface this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ba baVar = ba.f335809a;
        Context applicationContext = this$0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        baVar.a(applicationContext, "ZPlanAppInterface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final ZPlanAppInterface this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            IBinder queryBinder = EIPCContentProvider.queryBinder(MobileQQ.sMobileQQ);
            queryBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.tencent.mobileqq.zplan.d
                @Override // android.os.IBinder.DeathRecipient
                public final void binderDied() {
                    ZPlanAppInterface.w(ZPlanAppInterface.this);
                }
            }, 0);
            QLog.i("[zplan]_ZPlanAppInterface", 1, "registerMainProcessDeath link success, binder=" + queryBinder);
        } catch (Throwable th5) {
            QLog.e("[zplan]_ZPlanAppInterface", 1, "registerMainProcessDeath error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ZPlanAppInterface this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("[zplan]_ZPlanAppInterface", 1, "receive main process death, kill zplan process now");
        try {
            this$0.exitProcess();
        } catch (Throwable th5) {
            QLog.e("[zplan]_ZPlanAppInterface", 1, "exitProcess error", th5);
        }
    }

    public final void deleteObserver(Observer observer) {
        hj3.a n3 = n();
        Intrinsics.checkNotNull(n3);
        n3.deleteObserver(observer);
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public ArrayList<String> getLowerPriorityProcessList() {
        return this.lowerPriorityProcessList;
    }

    @Override // com.tencent.common.app.AppInterface
    public MobileQQServiceBase getMobileQQService() {
        MobileQQServiceBase mobileQQServiceBase = this.qqService;
        if (mobileQQServiceBase != null) {
            return mobileQQServiceBase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qqService");
        return null;
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        boolean R = ZPlanServiceHelper.I.R();
        QLog.i("[zplan]_ZPlanAppInterface", 1, "highPriorityWhenBackground isUsing\uff1b " + R);
        return R;
    }

    public final hj3.a n() {
        if (this.mZPlanNotifyCenter == null) {
            this.mZPlanNotifyCenter = new hj3.a(this);
        }
        return this.mZPlanNotifyCenter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine_zplan_process", "runtime_create_zplan", null, 4, null);
        QLog.i("[zplan]_ZPlanAppInterface", 1, "onCreate threadId:" + Thread.currentThread().getId() + ", mainThreadId:" + Looper.getMainLooper().getThread().getId() + ", isCurrentThread:" + Looper.getMainLooper().isCurrentThread());
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAppInterface.t(ZPlanAppInterface.this);
            }
        };
        if (Looper.getMainLooper().isCurrentThread()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
        x();
        try {
            r();
        } catch (Throwable th5) {
            QLog.e("[zplan]_ZPlanAppInterface", 1, "initURLDrawable exception ", th5);
        }
        this.qqService = new com.tencent.mobileqq.zootopia.sso.a(this);
        QIPCClientHelper.getInstance().register(((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).getIPCModule());
        u();
        QLog.i("[zplan]_ZPlanAppInterface", 1, "start init qzone image env");
        QLog.i("[zplan]_ZPlanAppInterface", 1, "init qzone image env result: " + ((IQZoneEnvApi) QRoute.api(IQZoneEnvApi.class)).initImageEnv(this.app));
        EngineLifeCycleReporter.k(EngineLifeCycleReporter.f385573f, "zplan_start_engine_zplan_process", "runtime_other_init_zplan", null, 4, null);
    }

    public final void u() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAppInterface.v(ZPlanAppInterface.this);
            }
        }, 16, null, true);
    }

    public final void x() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.process.exit");
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
        intentFilter.addAction(NewIntent.ACTION_LOGOUT);
        intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
        this.app.registerReceiver(this.mZPlanReceiver, intentFilter);
    }

    public final void y(List<String> processList) {
        this.lowerPriorityProcessList.clear();
        if (processList != null) {
            this.lowerPriorityProcessList.addAll(processList);
        }
    }

    private final void exitProcess() {
        QLog.e("[zplan]_ZPlanAppInterface", 1, "exit zplan process");
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAppInterface.m(ZPlanAppInterface.this);
            }
        }, 16, null, true, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        QLog.e("[zplan]_ZPlanAppInterface", 1, "handleAccountLogout in zplan process");
        ((gk3.a) vb3.a.f441346a.a(gk3.a.class)).L0("zplanProcess#handleAccountLogout");
    }

    public final void addObserver(Observer observer) {
        if (observer != null) {
            hj3.a n3 = n();
            Intrinsics.checkNotNull(n3);
            n3.addObserver(observer);
        }
    }

    public final void s(Object[] data) {
        if (data != null) {
            if (!(data.length == 0)) {
                hj3.a n3 = n();
                Intrinsics.checkNotNull(n3);
                n3.a(data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Intent intent) {
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        ArrayList<String> stringArrayList = extras != null ? extras.getStringArrayList("procNameList") : null;
        Bundle extras2 = intent.getExtras();
        String string = extras2 != null ? extras2.getString("verify") : null;
        Companion companion = INSTANCE;
        if (companion.d(string, stringArrayList) && companion.c(stringArrayList)) {
            boolean z16 = !ZPlanServiceHelper.I.Q();
            QLog.d("[zplan]_ZPlanAppInterface", 2, "canExitProcess : " + z16);
            if (z16 && QLog.isColorLevel()) {
                QLog.e("[zplan]_ZPlanAppInterface", 2, "exitProcexxreceive broacast action is " + intent.getAction());
            }
        }
    }
}
