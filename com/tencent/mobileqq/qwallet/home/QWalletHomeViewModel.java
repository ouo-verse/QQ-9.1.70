package com.tencent.mobileqq.qwallet.home;

import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppGroup;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Belt;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetHomepageV2Req;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetHomepageV2Rsp;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$H5;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Head;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedDot;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$VirtualAsset;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$VirtualEntity;
import com.qwallet.protocol.Wallet.pb.QWalletHomePrivilege$Privilege;
import com.qwallet.utils.QWalletUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.home.QWalletHomeViewModel;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.fh;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001gB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\bd\u0010eJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0017\u0010#\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0)0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010'R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0)0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010'R \u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0)0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010'R\u001c\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002050$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010'R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0003018\u0006\u00a2\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R)\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0<0$8\u0006\u00a2\u0006\f\n\u0004\b>\u0010'\u001a\u0004\b?\u0010@R#\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0)0$8\u0006\u00a2\u0006\f\n\u0004\bB\u0010'\u001a\u0004\bC\u0010@R \u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0)0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010'R \u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0)0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010'R\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0$8\u0006\u00a2\u0006\f\n\u0004\bK\u0010'\u001a\u0004\bL\u0010@R$\u0010U\u001a\u0004\u0018\u00010N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020%0V8F\u00a2\u0006\u0006\u001a\u0004\bW\u0010XR\u001d\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0)0V8F\u00a2\u0006\u0006\u001a\u0004\bZ\u0010XR\u001d\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0)0V8F\u00a2\u0006\u0006\u001a\u0004\b\\\u0010XR\u0019\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0V8F\u00a2\u0006\u0006\u001a\u0004\b^\u0010XR\u001d\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0)0V8F\u00a2\u0006\u0006\u001a\u0004\b`\u0010XR\u001d\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0)0V8F\u00a2\u0006\u0006\u001a\u0004\bb\u0010X\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "", "rawUrl", "g2", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$GetHomepageV2Rsp;", "rsp", "", QAdRewardDefine$VideoParams.ISCACHE, "", "j2", "i2", SemanticAttributes.DbSystemValues.H2, "S1", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onCreate", "onResume", "Landroidx/lifecycle/SavedStateHandle;", "i", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", WadlProxyConsts.CHANNEL, BdhLogUtil.LogTag.Tag_Conn, "Z", "isPreview", "D", "isExposureReported", "E", "f2", "()Z", MiniGamePAHippyBaseFragment.KEY_THEME, "Landroidx/lifecycle/MutableLiveData;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "_payCodeAppLiveData", "", "G", "_topAppsLiveData", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$Belt;", "H", "_beltsLiveData", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$VirtualEntity;", "_virtualEntities", "Landroidx/lifecycle/MediatorLiveData;", "J", "Landroidx/lifecycle/MediatorLiveData;", "_settingEntityLiveData", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$H5;", "K", "_h5LiveData", "L", "W1", "()Landroidx/lifecycle/MediatorLiveData;", "h5UrlLiveData", "Lkotlin/Pair;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", "M", "U1", "()Landroidx/lifecycle/MutableLiveData;", "gridAppsLiveData", "N", "T1", "gridAppsListLiveData", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$VirtualAsset;", "P", "_assetsLiveData", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePrivilege$Privilege;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_privilegesLiveData", BdhLogUtil.LogTag.Tag_Req, "X1", "netDataReady", "Lcom/tencent/mobileqq/qwallet/home/report/d;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qwallet/home/report/d;", "c2", "()Lcom/tencent/mobileqq/qwallet/home/report/d;", "k2", "(Lcom/tencent/mobileqq/qwallet/home/report/d;)V", "techReporter", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "payCodeLiveData", "d2", "topAppsLiveData", "R1", "beltsLiveData", "b2", "settingEntityLiveData", "Q1", "assetLiveData", ICustomDataEditor.STRING_ARRAY_PARAM_2, "privilegeLiveData", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "T", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletHomeViewModel extends ViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isPreview;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isExposureReported;

    /* renamed from: E, reason: from kotlin metadata */
    private final boolean isNightMode;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QWalletHomePage$AppInfo> _payCodeAppLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<QWalletHomePage$AppInfo>> _topAppsLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<QWalletHomePage$Belt>> _beltsLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<QWalletHomePage$VirtualEntity>> _virtualEntities;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<QWalletHomePage$VirtualEntity> _settingEntityLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QWalletHomePage$H5> _h5LiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<String> h5UrlLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<QWalletHomePage$AppGroup, QWalletHomePage$AppGroup>> gridAppsLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<QWalletHomePage$AppGroup>> gridAppsListLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<QWalletHomePage$VirtualAsset>> _assetsLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<QWalletHomePrivilege$Privilege>> _privilegesLiveData;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> netDataReady;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qwallet.home.report.d techReporter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SavedStateHandle stateHandle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int channel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ pl2.o f277975d;

        public b(pl2.o oVar) {
            this.f277975d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) QWalletHomePage$GetHomepageV2Rsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    pl2.o oVar = this.f277975d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((pl2.o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + QWalletHomePage$GetHomepageV2Rsp.class + " failed.");
                    pl2.o oVar2 = this.f277975d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, pl2.p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            pl2.o oVar3 = this.f277975d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/home/QWalletHomeViewModel$c", "Lpl2/o;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$GetHomepageV2Rsp;", "rsp", "", "b", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements pl2.o<QWalletHomePage$GetHomepageV2Rsp> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(QWalletHomePage$GetHomepageV2Rsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "$rsp");
            try {
                String str = "qwallet_home_v2_rsp_bytes_" + QWalletUtils.h();
                byte[] byteArray = rsp.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "rsp.toByteArray()");
                com.tencent.mobileqq.qwallet.utils.g.m(str, byteArray);
            } catch (Throwable th5) {
                QLog.e("QWalletHomeViewModel", 1, "cache home rsp bytes to mmkv failed", th5);
            }
        }

        @Override // pl2.k
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull final QWalletHomePage$GetHomepageV2Rsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.d("QWalletHomeViewModel", 1, "requestHomePageV2 onSuccess: rsp content size " + c4.a.g(rsp) + " ");
            com.tencent.mobileqq.qwallet.home.report.d techReporter = QWalletHomeViewModel.this.getTechReporter();
            if (techReporter != null) {
                techReporter.n(true);
            }
            QWalletHomeViewModel.this.j2(rsp, false);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.z
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletHomeViewModel.c.c(QWalletHomePage$GetHomepageV2Rsp.this);
                }
            }, 64, null, true);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("QWalletHomeViewModel", 1, "requestHomePageV2 onFail: errMsg " + errMsg);
            com.tencent.mobileqq.qwallet.home.report.d techReporter = QWalletHomeViewModel.this.getTechReporter();
            if (techReporter != null) {
                techReporter.n(false);
            }
        }
    }

    public QWalletHomeViewModel(@NotNull SavedStateHandle stateHandle) {
        int intValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.stateHandle = stateHandle;
        Integer num = (Integer) stateHandle.get(IQWalletHelper.QWALLET_HOME_CHANNEL_FROM);
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.channel = intValue;
        this.isPreview = QWalletHomePreviewController.f277969a.i(stateHandle);
        this.isNightMode = QQTheme.isNowThemeIsNight();
        this._payCodeAppLiveData = new MutableLiveData<>();
        this._topAppsLiveData = new MutableLiveData<>();
        this._beltsLiveData = new MutableLiveData<>();
        MutableLiveData<List<QWalletHomePage$VirtualEntity>> mutableLiveData = new MutableLiveData<>();
        this._virtualEntities = mutableLiveData;
        final MediatorLiveData<QWalletHomePage$VirtualEntity> mediatorLiveData = new MediatorLiveData<>();
        final Function1<List<? extends QWalletHomePage$VirtualEntity>, Unit> function1 = new Function1<List<? extends QWalletHomePage$VirtualEntity>, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeViewModel$_settingEntityLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QWalletHomePage$VirtualEntity> list) {
                invoke2((List<QWalletHomePage$VirtualEntity>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<QWalletHomePage$VirtualEntity> entities) {
                Object obj;
                MutableLiveData mutableLiveData2 = mediatorLiveData;
                Intrinsics.checkNotNullExpressionValue(entities, "entities");
                Iterator<T> it = entities.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (c4.a.l((QWalletHomePage$VirtualEntity) obj)) {
                            break;
                        }
                    }
                }
                mutableLiveData2.setValue(obj);
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.qwallet.home.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeViewModel.N1(Function1.this, obj);
            }
        });
        this._settingEntityLiveData = mediatorLiveData;
        MutableLiveData<QWalletHomePage$H5> mutableLiveData2 = new MutableLiveData<>();
        this._h5LiveData = mutableLiveData2;
        final MediatorLiveData<String> mediatorLiveData2 = new MediatorLiveData<>();
        final Function1<QWalletHomePage$H5, Unit> function12 = new Function1<QWalletHomePage$H5, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeViewModel$h5UrlLiveData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QWalletHomePage$H5 qWalletHomePage$H5) {
                invoke2(qWalletHomePage$H5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QWalletHomePage$H5 qWalletHomePage$H5) {
                String g26;
                String url = qWalletHomePage$H5.url.get();
                MediatorLiveData<String> mediatorLiveData3 = mediatorLiveData2;
                if (qWalletHomePage$H5.is_open.get()) {
                    QWalletHomeViewModel qWalletHomeViewModel = this;
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    g26 = qWalletHomeViewModel.g2(url);
                } else {
                    g26 = "";
                }
                mediatorLiveData3.setValue(g26);
            }
        };
        mediatorLiveData2.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.qwallet.home.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeViewModel.e2(Function1.this, obj);
            }
        });
        this.h5UrlLiveData = mediatorLiveData2;
        this.gridAppsLiveData = new MutableLiveData<>();
        this.gridAppsListLiveData = new MutableLiveData<>();
        this._assetsLiveData = new MutableLiveData<>();
        this._privilegesLiveData = new MutableLiveData<>();
        this.netDataReady = new MutableLiveData<>(null);
        QWalletHomePage$GetHomepageV2Rsp S1 = S1();
        if (S1 != null) {
            j2(S1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final QWalletHomePage$GetHomepageV2Rsp S1() {
        String str = "qwallet_home_v2_rsp_bytes_" + com.tencent.mobileqq.base.a.c();
        if (!com.tencent.mobileqq.qwallet.utils.g.a(str)) {
            return null;
        }
        try {
            return new QWalletHomePage$GetHomepageV2Rsp().mergeFrom(com.tencent.mobileqq.qwallet.utils.g.d(str));
        } catch (Exception e16) {
            QLog.e("QWalletHomeViewModel", 1, "getCachedHomepageRsp: illegal cache content", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g2(String rawUrl) {
        String str;
        if (this.isNightMode) {
            str = "1";
        } else {
            str = "0";
        }
        try {
            String uri = Uri.parse(rawUrl).buildUpon().appendQueryParameter(MiniGamePAHippyBaseFragment.KEY_THEME, str).appendQueryParameter("isNoAd", "1").build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "{\n            Uri.parse(\u2026ld().toString()\n        }");
            return uri;
        } catch (Throwable th5) {
            QLog.e("QWalletHomeViewModel", 1, "modifyH5Url: ", th5);
            return rawUrl;
        }
    }

    private final void h2() {
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        QWalletHomePage$GetHomepageV2Req qWalletHomePage$GetHomepageV2Req = new QWalletHomePage$GetHomepageV2Req();
        QWalletHomePage$Head qWalletHomePage$Head = new QWalletHomePage$Head();
        qWalletHomePage$Head.qyy_switch.set(true);
        qWalletHomePage$Head.is_youth_mode.set(studyModeSwitch);
        PBStringField pBStringField = qWalletHomePage$Head.phone_model;
        com.tencent.mobileqq.qwallet.utils.c cVar = com.tencent.mobileqq.qwallet.utils.c.f279254a;
        pBStringField.set(cVar.e());
        qWalletHomePage$Head.memory_size.set(cVar.d());
        qWalletHomePage$Head.cpu_type.set(cVar.a());
        qWalletHomePage$Head.cpu_max_freq.set(cVar.c());
        qWalletHomePage$Head.cpu_core_num.set(cVar.b());
        qWalletHomePage$Head.care_model.set(ol2.a.c());
        QLog.d("QWalletHomeViewModel", 1, "requestHomePageV2 phoneModel=" + qWalletHomePage$Head.phone_model.get() + ", memorySize=$" + qWalletHomePage$Head.memory_size.get() + " cpuBrand=[" + qWalletHomePage$Head.cpu_type.get() + "] cpuMaxFreq=$" + qWalletHomePage$Head.cpu_max_freq.get() + "  cpuCoreNumber=$" + qWalletHomePage$Head.cpu_core_num.get());
        qWalletHomePage$GetHomepageV2Req.head.set(qWalletHomePage$Head);
        qWalletHomePage$GetHomepageV2Req.support_app_list.set(true);
        c cVar2 = new c();
        com.tencent.mobileqq.qwallet.home.report.d dVar = this.techReporter;
        if (dVar != null) {
            dVar.o();
        }
        p.Companion companion = pl2.p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.homepage2.Homepage2.SsoGetHomepageV2 callback: " + cVar2 + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), pl2.p.class);
        newIntent.putExtra("cmd", "trpc.qpay.homepage2.Homepage2.SsoGetHomepageV2");
        newIntent.putExtra("data", fh.b(qWalletHomePage$GetHomepageV2Req.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new b(cVar2));
        waitAppRuntime.startServlet(newIntent);
    }

    private final void i2(QWalletHomePage$GetHomepageV2Rsp rsp) {
        HomeLegacyBizManager homeLegacyBizManager = HomeLegacyBizManager.f277929d;
        List<QWalletHomePage$AppGroup> list = rsp.app_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.app_list.get()");
        homeLegacyBizManager.t(list);
        this.gridAppsListLiveData.setValue(rsp.app_list.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j2(QWalletHomePage$GetHomepageV2Rsp rsp, boolean isCache) {
        HomeLegacyBizManager homeLegacyBizManager = HomeLegacyBizManager.f277929d;
        homeLegacyBizManager.v(rsp.declaim);
        List<QWalletHomePage$RedDot> list = rsp.red_dots.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.red_dots.get()");
        homeLegacyBizManager.u(list);
        this._payCodeAppLiveData.setValue(rsp.pay_code_app.get());
        this._topAppsLiveData.setValue(rsp.top_apps.get());
        this._beltsLiveData.setValue(rsp.belts.get());
        this._virtualEntities.setValue(rsp.virtual_entities.get());
        this._h5LiveData.setValue(rsp.f41693h5.get());
        this._assetsLiveData.setValue(rsp.assets.get());
        i2(rsp);
        MutableLiveData<List<QWalletHomePage$VirtualEntity>> h16 = homeLegacyBizManager.h();
        List<QWalletHomePage$VirtualEntity> list2 = rsp.virtual_entities.get();
        Intrinsics.checkNotNullExpressionValue(list2, "rsp.virtual_entities.get()");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            QWalletHomePage$VirtualEntity it = (QWalletHomePage$VirtualEntity) obj;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (c4.a.k(it)) {
                arrayList.add(obj);
            }
        }
        h16.setValue(arrayList);
        this.netDataReady.postValue(Boolean.valueOf(isCache));
    }

    @NotNull
    public final LiveData<List<QWalletHomePage$VirtualAsset>> Q1() {
        return this._assetsLiveData;
    }

    @NotNull
    public final LiveData<List<QWalletHomePage$Belt>> R1() {
        return this._beltsLiveData;
    }

    @NotNull
    public final MutableLiveData<List<QWalletHomePage$AppGroup>> T1() {
        return this.gridAppsListLiveData;
    }

    @NotNull
    public final MutableLiveData<Pair<QWalletHomePage$AppGroup, QWalletHomePage$AppGroup>> U1() {
        return this.gridAppsLiveData;
    }

    @NotNull
    public final MediatorLiveData<String> W1() {
        return this.h5UrlLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> X1() {
        return this.netDataReady;
    }

    @NotNull
    public final LiveData<QWalletHomePage$AppInfo> Z1() {
        return this._payCodeAppLiveData;
    }

    @NotNull
    public final LiveData<List<QWalletHomePrivilege$Privilege>> a2() {
        return this._privilegesLiveData;
    }

    @NotNull
    public final LiveData<QWalletHomePage$VirtualEntity> b2() {
        return this._settingEntityLiveData;
    }

    @Nullable
    /* renamed from: c2, reason: from getter */
    public final com.tencent.mobileqq.qwallet.home.report.d getTechReporter() {
        return this.techReporter;
    }

    @NotNull
    public final LiveData<List<QWalletHomePage$AppInfo>> d2() {
        return this._topAppsLiveData;
    }

    /* renamed from: f2, reason: from getter */
    public final boolean getIsNightMode() {
        return this.isNightMode;
    }

    public final void k2(@Nullable com.tencent.mobileqq.qwallet.home.report.d dVar) {
        this.techReporter = dVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("QWalletHomeViewModel", 1, "onCreate: ");
        if (this.isPreview) {
            return;
        }
        h2();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("QWalletHomeViewModel", 1, "onResume: ");
        if (!this.isPreview && !this.isExposureReported) {
            this.isExposureReported = true;
            u.m("index.show", null, "-1", String.valueOf(this.channel), null, 0, 50, null);
        }
    }
}
