package com.tencent.mobileqq.leba.business.plugins;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginQCircle;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleSwitch$SetMultiCircleSwitchRsp;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 (2\u00020\u0001:\u0003LMNB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010 \u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\tH\u0016J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016Jb\u00105\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020-2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010/\u001a\u0004\u0018\u00010\u00102\u0018\u00102\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u0001002\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0004H\u0016J\n\u00106\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u00107\u001a\u00020\tH\u0016J\b\u00108\u001a\u00020\tH\u0016J\u0018\u00109\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020-8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010H\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQCircle;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/util/Pair;", "", "", "d0", "e0", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "", "l0", "o0", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "p0", "i0", "g0", "", "a0", "Lqqcircle/QQCircleCounter$RedPointInfo;", "redPointInfo", "Z", "Lcom/tencent/mobileqq/leba/entity/o;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mode", "style", "l", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "w", "G", "tabChange", "I", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "D", UserInfo.SEX_FEMALE, "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "", "resID", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "isTableModel", "y", "u", "e", "M", "N", "Lcom/tencent/mobileqq/leba/business/plugins/ad;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/leba/business/plugins/ad;", "redViewHolder", "Lcom/tencent/mobileqq/qcircle/api/helper/QCircleObserver;", "Lkotlin/Lazy;", "b0", "()Lcom/tencent/mobileqq/qcircle/api/helper/QCircleObserver;", "mQCircleObserver", "Lcommon/config/service/QzoneConfig$QzoneConfigChangeListener;", "E", "c0", "()Lcommon/config/service/QzoneConfig$QzoneConfigChangeListener;", "mQzoneConfigListener", "()J", "resId", "<init>", "()V", "a", "MainUpdateRedFlagTask", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginQCircle extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ad redViewHolder;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mQCircleObserver;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mQzoneConfigListener;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQCircle$MainUpdateRedFlagTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQCircle;", "d", "Ljava/lang/ref/WeakReference;", "mCirclePartWeak", "part", "<init>", "(Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQCircle;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class MainUpdateRedFlagTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<LebaPluginQCircle> mCirclePartWeak;

        public MainUpdateRedFlagTask(@NotNull LebaPluginQCircle part) {
            Intrinsics.checkNotNullParameter(part, "part");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            } else {
                this.mCirclePartWeak = new WeakReference<>(part);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("LebaPluginQCircle", 1, "MainUpdateRedFlagTask updateRedFlag");
            LebaPluginQCircle lebaPluginQCircle = this.mCirclePartWeak.get();
            if (lebaPluginQCircle != null) {
                lebaPluginQCircle.o0();
            } else {
                QLog.e("LebaPluginQCircle", 1, "MainUpdateRedFlagTask plugin is null ");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQCircle$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginQCircle$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQCircle$b;", "Lcom/tencent/mobileqq/qcircle/api/helper/QCircleObserver;", "", "redPointNum", "", "onUpdateRedPoint", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQCircle;", "d", "Ljava/lang/ref/WeakReference;", "getMPart", "()Ljava/lang/ref/WeakReference;", "mPart", "part", "<init>", "(Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginQCircle;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends QCircleObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<LebaPluginQCircle> mPart;

        public b(@NotNull LebaPluginQCircle part) {
            Intrinsics.checkNotNullParameter(part, "part");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            } else {
                this.mPart = new WeakReference<>(part);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.api.helper.QCircleObserver
        protected void onUpdateRedPoint(int redPointNum) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, redPointNum);
                return;
            }
            QLog.i("LebaPluginQCircle", 1, "QCircleObserver onUpdateRedPoint " + redPointNum);
            LebaPluginQCircle lebaPluginQCircle = this.mPart.get();
            if (lebaPluginQCircle != null) {
                lebaPluginQCircle.o0();
            } else {
                QLog.e("LebaPluginQCircle", 1, "onUpdateRedPoint plugin is null ");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginQCircle() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.leba.business.plugins.LebaPluginQCircle$mQCircleObserver$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LebaPluginQCircle.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LebaPluginQCircle.b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new LebaPluginQCircle.b(LebaPluginQCircle.this) : (LebaPluginQCircle.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mQCircleObserver = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new LebaPluginQCircle$mQzoneConfigListener$2(this));
            this.mQzoneConfigListener = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final String Z(QQCircleCounter$RedPointInfo redPointInfo) {
        if (redPointInfo == null) {
            return "none";
        }
        if (redPointInfo.redTotalNum.get() > 0) {
            return "number";
        }
        if (!QCircleHostUtil.checkOperateMaskEnabled(redPointInfo.outLayerInfo.combineRedTypes.get(), 3)) {
            return "none";
        }
        return QCircleDaTongConstant.ElementParamValue.RECOM;
    }

    private final String a0() {
        if (com.tencent.mobileqq.leba.feed.d.a()) {
            return "feeds";
        }
        return "qzone";
    }

    private final QCircleObserver b0() {
        return (QCircleObserver) this.mQCircleObserver.getValue();
    }

    private final QzoneConfig.QzoneConfigChangeListener c0() {
        return (QzoneConfig.QzoneConfigChangeListener) this.mQzoneConfigListener.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Integer, Boolean> d0() {
        boolean z16;
        int i3;
        boolean z17;
        boolean z18;
        boolean z19;
        Pair<Integer, Boolean> pair;
        boolean z26;
        boolean needShowQzoneFrame = ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.peekAppRuntime());
        QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo = null;
        if (!StudyModeManager.t() && uq3.c.L6(StudyModeManager.t())) {
            if (needShowQzoneFrame && !uq3.c.s5()) {
                return null;
            }
            boolean z27 = true;
            try {
                IQCircleRedPointService f16 = com.tencent.mobileqq.activity.qcircle.utils.c.f();
                if (f16 != null) {
                    qQCircleCounter$RedPointInfo = f16.getOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
                }
                if (qQCircleCounter$RedPointInfo != null) {
                    long j3 = qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get();
                    i3 = qQCircleCounter$RedPointInfo.redTotalNum.get();
                    try {
                        z17 = QCircleHostUtil.checkOperateMaskEnabled(j3, 1);
                        try {
                            z18 = QCircleHostUtil.checkOperateMaskEnabled(j3, 6);
                            try {
                                z16 = QCircleHostUtil.checkOperateMaskEnabled(j3, 3);
                                try {
                                    z19 = QCircleHostUtil.needHideSmallRedDotInLeba(qQCircleCounter$RedPointInfo);
                                } catch (Exception e16) {
                                    e = e16;
                                    QLog.e("MainAssistObserver.LebaTabRedTouch", 2, "getQQCircleRedTouchNums" + e);
                                    z19 = false;
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("[getQQCircleRedTouchNums]");
                                    sb5.append("  pushUnReadNum = ");
                                    sb5.append(i3);
                                    sb5.append(", showActiveRedDot = ");
                                    sb5.append(z17);
                                    sb5.append(", showRecommendRedDot = ");
                                    sb5.append(z16);
                                    sb5.append(", showPYMKRedDot = ");
                                    sb5.append(z18);
                                    QLog.d("QCircleEeveeRedPoint_MainAssistObserver.LebaTabRedTouch", 2, sb5);
                                    if (needShowQzoneFrame) {
                                    }
                                    return pair;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                z16 = false;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            z16 = false;
                            z18 = false;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z16 = false;
                        z17 = false;
                        z18 = z17;
                        QLog.e("MainAssistObserver.LebaTabRedTouch", 2, "getQQCircleRedTouchNums" + e);
                        z19 = false;
                        StringBuilder sb52 = new StringBuilder();
                        sb52.append("[getQQCircleRedTouchNums]");
                        sb52.append("  pushUnReadNum = ");
                        sb52.append(i3);
                        sb52.append(", showActiveRedDot = ");
                        sb52.append(z17);
                        sb52.append(", showRecommendRedDot = ");
                        sb52.append(z16);
                        sb52.append(", showPYMKRedDot = ");
                        sb52.append(z18);
                        QLog.d("QCircleEeveeRedPoint_MainAssistObserver.LebaTabRedTouch", 2, sb52);
                        if (needShowQzoneFrame) {
                        }
                        return pair;
                    }
                } else {
                    z19 = false;
                    z16 = false;
                    i3 = 0;
                    z17 = false;
                    z18 = false;
                }
            } catch (Exception e26) {
                e = e26;
                z16 = false;
                i3 = 0;
                z17 = false;
            }
            StringBuilder sb522 = new StringBuilder();
            sb522.append("[getQQCircleRedTouchNums]");
            sb522.append("  pushUnReadNum = ");
            sb522.append(i3);
            sb522.append(", showActiveRedDot = ");
            sb522.append(z17);
            sb522.append(", showRecommendRedDot = ");
            sb522.append(z16);
            sb522.append(", showPYMKRedDot = ");
            sb522.append(z18);
            QLog.d("QCircleEeveeRedPoint_MainAssistObserver.LebaTabRedTouch", 2, sb522);
            if (needShowQzoneFrame) {
                boolean z28 = z17 | z16 | z18;
                if (i3 > 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (!(z28 | z26) || z19) {
                    z27 = false;
                }
                pair = new Pair<>(0, Boolean.valueOf(z27));
            } else {
                Integer valueOf = Integer.valueOf(i3);
                if (!(z17 | z16 | z18) || z19) {
                    z27 = false;
                }
                pair = new Pair<>(valueOf, Boolean.valueOf(z27));
            }
            return pair;
        }
        QLog.d("MainAssistObserver.LebaTabRedTouch", 4, "needShowQzoneFrame = " + needShowQzoneFrame);
        return null;
    }

    private final boolean e0() {
        boolean z16;
        if (uq3.c.y6(StudyModeManager.t()) && uq3.c.w6(StudyModeManager.t()) && QzoneConfig.getQQCircleShowGuideOnLebaTab() && QCircleHostConfig.isNeedShowLebaTabGuideNew() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (StudyModeManager.t()) {
            return false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(View v3, String str) {
        Intrinsics.checkNotNullParameter(v3, "$v");
        com.tencent.biz.qqcircle.launcher.c.g(v3.getContext(), str);
    }

    private final void g0() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.s
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginQCircle.h0(LebaPluginQCircle.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(LebaPluginQCircle this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            QLog.d("LebaPluginQCircle", 2, "reportDtRedDotClickForFeed ");
            Map<String, Object> dtElementParams = new QCircleDTParamBuilder().buildElementParams();
            Intrinsics.checkNotNullExpressionValue(dtElementParams, "dtElementParams");
            dtElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            dtElementParams.put("xsj_action_type", "clck");
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB);
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, com.tencent.mobileqq.leba.report.d.e());
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDS_PATTERN, this$0.a0());
            QQCircleCounter$RedPointInfo outerEntranceRedPointInfoByAppid = com.tencent.mobileqq.activity.qcircle.utils.c.f().getOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, this$0.Z(outerEntranceRedPointInfoByAppid));
            String str2 = "";
            if (outerEntranceRedPointInfoByAppid == null) {
                str = "";
            } else {
                str = outerEntranceRedPointInfoByAppid.extend.get();
            }
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, str);
            if (outerEntranceRedPointInfoByAppid != null) {
                str2 = outerEntranceRedPointInfoByAppid.allPushInfo.tabTipWording.get();
            }
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TEXT, str2);
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_ENTRANCE_ACTION, null, dtElementParams);
        } catch (Exception e16) {
            QLog.e("LebaPluginQCircle", 1, "reportDtRedDotClickForFeed exception", e16);
        }
    }

    private final void i0() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.q
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginQCircle.j0(LebaPluginQCircle.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(LebaPluginQCircle this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            QLog.d("LebaPluginQCircle", 2, "reportDtRedDotExposeForFeed ");
            Map<String, Object> dtElementParams = new QCircleDTParamBuilder().buildElementParams();
            Intrinsics.checkNotNullExpressionValue(dtElementParams, "dtElementParams");
            dtElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            dtElementParams.put("xsj_action_type", "imp");
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EXTERNAL_ENTRANCE, QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB);
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, com.tencent.mobileqq.leba.report.d.e());
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEEDS_PATTERN, this$0.a0());
            QQCircleCounter$RedPointInfo outerEntranceRedPointInfoByAppid = com.tencent.mobileqq.activity.qcircle.utils.c.f().getOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_TYPE, this$0.Z(outerEntranceRedPointInfoByAppid));
            String str2 = "";
            if (outerEntranceRedPointInfoByAppid == null) {
                str = "";
            } else {
                str = outerEntranceRedPointInfoByAppid.extend.get();
            }
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TYPE, str);
            if (outerEntranceRedPointInfoByAppid != null) {
                str2 = outerEntranceRedPointInfoByAppid.allPushInfo.tabTipWording.get();
            }
            dtElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_REDDOT_RECOM_TEXT, str2);
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_EXTERNAL_ENTRANCE_ACTION, null, dtElementParams);
        } catch (Exception e16) {
            QLog.e("LebaPluginQCircle", 1, "reportDtRedDotExposeForFeed exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(boolean z16, LebaPluginQCircle this$0, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleSwitch$SetMultiCircleSwitchRsp qQCircleSwitch$SetMultiCircleSwitchRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z17 && j3 == 0) {
            QLog.i("LebaPluginQCircle", 1, "list setCircleSwitch success isChecked" + z16);
            if (!z16) {
                com.tencent.mobileqq.activity.qcircle.utils.c.f().clearPedPoint();
                QLog.i("LebaPluginQCircle", 1, "list setCircleSwitch success clearPedPoint");
                return;
            }
            return;
        }
        this$0.p0(!z16);
        QLog.i("LebaPluginQCircle", 1, "list setCircleSwitch error retcode= " + j3);
    }

    private final void l0(final RedTouch redTouch) {
        if (redTouch == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.v
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginQCircle.m0(RedTouch.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(final RedTouch redTouch) {
        final boolean z16;
        QQCircleCounter$RedPointInfo outerEntranceRedPointInfoByAppid = com.tencent.mobileqq.activity.qcircle.utils.c.f().getOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
        if (outerEntranceRedPointInfoByAppid != null && (outerEntranceRedPointInfoByAppid.redTotalNum.get() > 0 || QCircleHostUtil.checkOperateMaskEnabled(outerEntranceRedPointInfoByAppid.outLayerInfo.combineRedTypes.get(), 3))) {
            z16 = true;
        } else {
            z16 = false;
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.w
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginQCircle.n0(z16, redTouch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(boolean z16, RedTouch redTouch) {
        if (z16) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            redTypeInfo.red_content.set("");
            redTypeInfo.red_desc.set("");
            redTouch.parseRedTouch(redTypeInfo);
            return;
        }
        redTouch.clearRedTouch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        Unit unit;
        ad adVar = this.redViewHolder;
        if (adVar != null) {
            adVar.I();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("LebaPluginQCircle", 1, "updateRedFlag redViewHolder is null ");
        }
    }

    private final void p0(final boolean isOpen) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.u
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginQCircle.q0(isOpen);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        uq3.c.i7("qqcircle", "qqcircle_entrance_enable", str);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        ad adVar = this.redViewHolder;
        if (adVar != null) {
            adVar.t();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.qcircle.utils.c.d().onSend(3, null, null);
        if (QzoneConfig.getQQCircleShowGuideOnLebaTab()) {
            QCircleHostConfig.setNeedShowLebaTabGuideNew(false);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ad adVar = this.redViewHolder;
        if (adVar != null) {
            adVar.v();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull final View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        boolean z16;
        QQCircleCounter$RedPointInfo outerEntranceRedPointInfoByAppid;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        com.tencent.mobileqq.leba.widget.a q16 = q();
        if (q16 != null && q16.b() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            g0();
            HashMap<String, String> hashMap = new HashMap<>();
            HashMap<String, byte[]> hashMap2 = new HashMap<>();
            hashMap.put(UploadConstants.KEY_ENABLE_SPLASH, "1");
            hashMap.put("key_jump_from", "3");
            hashMap.put("childmode", "1");
            hashMap.put("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB_SECOND);
            com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(v3.getContext(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE, hashMap, hashMap2);
            if (uq3.c.o0() && (outerEntranceRedPointInfoByAppid = com.tencent.mobileqq.activity.qcircle.utils.c.f().getOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE)) != null) {
                final String str = outerEntranceRedPointInfoByAppid.redJumpInfo.jumpLink.get();
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        LebaPluginQCircle.f0(v3, str);
                    }
                });
                return;
            }
            return;
        }
        QCirclePluginUtil.setIsTabModeJudgeByQCircleFrame(false);
        QCirclePluginUtil.setsIsTabModeForPad(false);
        HashMap<String, String> hashMap3 = new HashMap<>();
        HashMap<String, byte[]> hashMap4 = new HashMap<>();
        hashMap3.put(UploadConstants.KEY_ENABLE_SPLASH, "1");
        hashMap3.put("key_jump_from", "3");
        hashMap3.put("childmode", "1");
        hashMap3.put("xsj_main_entrance", QCircleDaTongConstant.ElementParamValue.QQ_UPDATES_TAB);
        ad adVar = this.redViewHolder;
        if (adVar != null) {
            adVar.f(hashMap3, hashMap4);
        }
        com.tencent.mobileqq.activity.qcircle.utils.c.g().enterBySchemeAction(v3.getContext(), QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE, hashMap3, hashMap4);
        ad adVar2 = this.redViewHolder;
        if (adVar2 != null) {
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            adVar2.n(context);
        }
        if (QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) {
            QCircleHostConfig.setNeedShowLebaQCircleEntranceGuideNew(false);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void I(boolean tabChange, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
            return;
        }
        ad adVar = this.redViewHolder;
        if (adVar != null) {
            adVar.w();
        }
        com.tencent.mobileqq.leba.widget.a q16 = q();
        if (q16 == null || q16.b() != 2) {
            z16 = false;
        }
        if (z16) {
            i0();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void M() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(b0());
        }
        QzoneConfig.getInstance().removeListener(c0());
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void N(final boolean isOpen, @NotNull com.tencent.mobileqq.leba.entity.n item) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(isOpen), item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (isOpen) {
            str = "1";
        } else {
            str = "0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qqcircle_entrance_enable", str);
        p0(isOpen);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("qqcircle", hashMap);
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetMultiCircleWnsConfigRequest(hashMap2), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.leba.business.plugins.t
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                LebaPluginQCircle.k0(isOpen, this, baseRequest, z16, j3, str2, (QQCircleSwitch$SetMultiCircleSwitchRsp) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void e() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.addObserver(b0());
        }
        QzoneConfig.getInstance().addListener(c0());
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean l(int mode, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public com.tencent.mobileqq.leba.entity.o m() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.leba.entity.o) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String O3 = uq3.c.O3();
        Intrinsics.checkNotNullExpressionValue(O3, "getQQCircleProductName()");
        if (uq3.c.Y4()) {
            str = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/changename/qvideo_entrance_icon_recommend_normal_v2.png";
        } else {
            str = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8930/entrance/qvideo_entrance_icon_recommend_normal.png";
        }
        String str3 = str;
        if (uq3.c.Y4()) {
            str2 = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/changename/qvideo_skin_entrance_icon_recommend_line_v2.png";
        } else {
            str2 = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8930/entrance/qvideo_skin_entrance_icon_recommend_line.png";
        }
        return new com.tencent.mobileqq.leba.entity.o(4045L, O3, 0, str3, str2, false, (short) 0, null, false, "wezone", 480, null);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ad adVar = this.redViewHolder;
        if (adVar != null) {
            adVar.u();
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @Nullable
    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ad adVar = this.redViewHolder;
        if (adVar != null) {
            return adVar.k();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 4045L;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @Nullable
    public RedTypeInfo w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Pair<Integer, Boolean> d06 = d0();
        if (d06 != null) {
            Integer redNum = d06.first;
            Intrinsics.checkNotNullExpressionValue(redNum, "redNum");
            if (redNum.intValue() > 0) {
                RedTypeInfo redTypeInfo = new RedTypeInfo();
                redTypeInfo.setRedType(5);
                redTypeInfo.setRedContent(String.valueOf(redNum));
                return redTypeInfo;
            }
            Boolean bool = d06.second;
            Intrinsics.checkNotNullExpressionValue(bool, "pair.second");
            if (bool.booleanValue()) {
                RedTypeInfo redTypeInfo2 = new RedTypeInfo();
                redTypeInfo2.setRedType(0);
                return redTypeInfo2;
            }
        }
        if (e0()) {
            RedTypeInfo redTypeInfo3 = new RedTypeInfo();
            redTypeInfo3.setRedType(4);
            redTypeInfo3.setRedContent("NEW");
            return redTypeInfo3;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean y(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, boolean isTableModel) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        QLog.d("LebaPluginQCircle", 4, "handleSpecificRedTouch isTable? " + isTableModel);
        if (isTableModel) {
            l0(redTouch);
        } else {
            if (this.redViewHolder == null) {
                if (redTouch != null) {
                    view = redTouch.getTarget();
                } else {
                    view = null;
                }
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.RelativeLayout");
                this.redViewHolder = new ad((RelativeLayout) view);
            }
            ad adVar = this.redViewHolder;
            if (adVar != null) {
                Intrinsics.checkNotNull(redTouch);
                BaseLebaPluginItem.g(this, redTouch, adVar.g(), null, 4, null);
                adVar.I();
            }
        }
        return true;
    }
}
