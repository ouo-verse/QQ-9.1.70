package com.tencent.mobileqq.leba.business.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.ad.report.api.IAdAttaReporterApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.business.plugins.LebaPluginShopping;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.qqshop.qqshop_code$SRsp;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\u00b3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n*\u0001a\b\u0007\u0018\u0000 82\u00020\u0001:\u0001tB\u0007\u00a2\u0006\u0004\br\u0010sJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010!\u001a\u00020 H\u0016J \u0010(\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0016Jb\u00103\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010/\u001a\u0004\u0018\u00010\u000e2\u0018\u00102\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u0001002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016Jb\u00105\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u0001042\b\u0010/\u001a\u0004\u0018\u00010\u000e2\u0018\u00102\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010+\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u0001002\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u00106\u001a\u00020\u0004H\u0016J\"\u00108\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020-2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u00107\u001a\u00020\tH\u0016J\u0010\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\u000eR\"\u0010A\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010I\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0017\u0010T\u001a\u00020J8\u0006\u00a2\u0006\f\n\u0004\bR\u0010L\u001a\u0004\bS\u0010NR\u0016\u0010V\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010UR\u0016\u0010X\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010WR\u0016\u0010Z\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010[R\u0016\u0010^\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010YR\u0016\u0010`\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010UR\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001b\u0010j\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0017\u0010p\u001a\u00020k8\u0006\u00a2\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010>\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginShopping;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Landroid/os/Message;", "msg", "", "r0", "Ljava/lang/Runnable;", "callback", "s0", "", "position", "", "isTableModel", "hasRedDot", "", "action", "w0", "Landroid/content/Context;", "context", "index", "x0", "f0", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "h0", "q0", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "p0", "i0", "g0", "j0", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "k", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "Lmqq/app/AppRuntime;", "app", "", "resID", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "y", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", HippyTKDListViewAdapter.X, "G", "style", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "url", "y0", BdhLogUtil.LogTag.Tag_Conn, "J", "getLastRequestAuthCodeTime", "()J", "setLastRequestAuthCodeTime", "(J)V", "lastRequestAuthCodeTime", "Ltencent/im/oidb/qqshop/qqshop_code$SRsp;", "D", "Ltencent/im/oidb/qqshop/qqshop_code$SRsp;", "o0", "()Ltencent/im/oidb/qqshop/qqshop_code$SRsp;", "setTmpAuthItem", "(Ltencent/im/oidb/qqshop/qqshop_code$SRsp;)V", "tmpAuthItem", "Ljava/util/concurrent/atomic/AtomicBoolean;", "E", "Ljava/util/concurrent/atomic/AtomicBoolean;", "m0", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setMHasJdJumped", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "mHasJdJumped", UserInfo.SEX_FEMALE, "n0", "mIsWaitingAuthCode", "Z", "mHasExposed", "Ljava/lang/String;", "mRedTouchADId", "I", "mTraceId", "Lcom/tencent/gdtad/aditem/GdtAd;", "mGdtAd", "K", "mSlot", "L", "mHasAdRequested", "com/tencent/mobileqq/leba/business/plugins/LebaPluginShopping$c", "M", "Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginShopping$c;", "mAdRspCallback", "Lcom/tencent/gdtad/config/data/m;", "N", "Lkotlin/Lazy;", "l0", "()Lcom/tencent/gdtad/config/data/m;", "mDisclaimerConfig", "Lcom/tencent/util/MqqWeakReferenceHandler;", "P", "Lcom/tencent/util/MqqWeakReferenceHandler;", "k0", "()Lcom/tencent/util/MqqWeakReferenceHandler;", "handler", "resId", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginShopping extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long lastRequestAuthCodeTime;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private qqshop_code$SRsp tmpAuthItem;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean mHasJdJumped;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean mIsWaitingAuthCode;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mHasExposed;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String mRedTouchADId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String mTraceId;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private GdtAd mGdtAd;

    /* renamed from: K, reason: from kotlin metadata */
    private int mSlot;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mHasAdRequested;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private c mAdRspCallback;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDisclaimerConfig;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MqqWeakReferenceHandler handler;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginShopping$a;", "", "", "ACTION_CLICK", "Ljava/lang/String;", "ACTION_EXPOSE", "HAS_RED_DOT", "IS_TABLE_MODE", "MODULE", "OPERNAME", "POSITION", "TAG", "", "TYPE_GET_AUTHCODE", "I", "TYPE_GET_AUTHCODE_TIMEOUT", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.LebaPluginShopping$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginShopping$b", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", tl.h.F, "", "e", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "clickActionParam", "", "g", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends DefaultClickProcessor {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginShopping.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(LebaPluginShopping this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(view, "$view");
            this$0.n0().set(false);
            view.performClick();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public DefaultClickProcessor.a c(@NotNull final View view, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
            boolean z16;
            QQAppInterface qQAppInterface;
            BaseBusinessHandler baseBusinessHandler;
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (DefaultClickProcessor.a) iPatchRedirector.redirect((short) 4, this, view, item, reportInfo);
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            DefaultClickProcessor.a c16 = super.c(view, item, reportInfo);
            Bundle bundle = new Bundle();
            LebaPluginShopping lebaPluginShopping = LebaPluginShopping.this;
            if (lebaPluginShopping.l0().getLebaShoppingDisclaimerConfigJson().optBoolean("enable", true)) {
                bundle.putInt("titleBarStyle", 14);
                bundle.putString("config_json_str", bundle.toString());
            }
            bundle.putString("negative_feedback_business_id", "jd_shopping");
            Bundle bundle2 = new Bundle();
            bundle2.putString("ad_id", lebaPluginShopping.mRedTouchADId);
            Unit unit = Unit.INSTANCE;
            bundle.putBundle("negative_feedback_business_extras", bundle2);
            c16.q(bundle);
            String l3 = c16.l();
            if (c16.k() == 0) {
                EcshopReportHandler ecshopReportHandler = null;
                if (l3 != null) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) l3, (CharSequence) "fetchCode=1", false, 2, (Object) null);
                    if (contains$default) {
                        z16 = true;
                        if (z16) {
                            long serverTime = NetConnInfoCenter.getServerTime();
                            QLog.d("Leba.DefaultClickProcessor", 4, "getClickActionParams url: " + l3);
                            if (LebaPluginShopping.this.o0() != null) {
                                Intrinsics.checkNotNull(LebaPluginShopping.this.o0());
                                if (r1.expired_time.get() > serverTime) {
                                    if (QLog.isColorLevel()) {
                                        qqshop_code$SRsp o06 = LebaPluginShopping.this.o0();
                                        Intrinsics.checkNotNull(o06);
                                        QLog.i("Leba.DefaultClickProcessor", 2, "use cache:" + o06.expired_time.get());
                                    }
                                    qqshop_code$SRsp o07 = LebaPluginShopping.this.o0();
                                    Intrinsics.checkNotNull(o07);
                                    c16.z(URLUtil.addParameter(l3, "code", o07.auth_code.get()));
                                    LebaPluginShopping.this.m0().set(true);
                                    LebaPluginShopping.this.y0(item.f240505b.strGotoUrl);
                                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                    if (peekAppRuntime instanceof QQAppInterface) {
                                        qQAppInterface = (QQAppInterface) peekAppRuntime;
                                    } else {
                                        qQAppInterface = null;
                                    }
                                    if (qQAppInterface != null) {
                                        baseBusinessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
                                    } else {
                                        baseBusinessHandler = null;
                                    }
                                    if (baseBusinessHandler instanceof EcshopReportHandler) {
                                        ecshopReportHandler = (EcshopReportHandler) baseBusinessHandler;
                                    }
                                    EcshopReportHandler ecshopReportHandler2 = ecshopReportHandler;
                                    if (ecshopReportHandler2 != null) {
                                        ecshopReportHandler2.H2(134246777, null, "jump", "use_cache", "hascode", 0L, false);
                                    }
                                }
                            }
                            if (LebaPluginShopping.this.n0().compareAndSet(false, true)) {
                                LebaPluginShopping.this.m0().set(true);
                                LebaPluginShopping.this.y0(l3);
                                final LebaPluginShopping lebaPluginShopping2 = LebaPluginShopping.this;
                                LebaPluginShopping.this.k0().sendMessageDelayed(LebaPluginShopping.this.k0().obtainMessage(1134007, new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.am
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        LebaPluginShopping.b.m(LebaPluginShopping.this, view);
                                    }
                                }), 1000L);
                            }
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
            return c16;
        }

        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        @NotNull
        public String e(@NotNull com.tencent.mobileqq.leba.entity.n item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            }
            Intrinsics.checkNotNullParameter(item, "item");
            String string = BaseApplication.getContext().getString(R.string.w1b);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026imer_business_name_gouwu)");
            return string;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void g(@NotNull Activity activity, @NotNull DefaultClickProcessor.a clickActionParam) {
            boolean z16;
            boolean contains$default;
            boolean contains$default2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) clickActionParam);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(clickActionParam, "clickActionParam");
            LebaPluginShopping lebaPluginShopping = LebaPluginShopping.this;
            lebaPluginShopping.mGdtAd = lebaPluginShopping.i0();
            GdtAd gdtAd = LebaPluginShopping.this.mGdtAd;
            if (gdtAd != null) {
                LebaPluginShopping.this.q0(gdtAd);
                return;
            }
            if (clickActionParam.k() == 0) {
                String l3 = clickActionParam.l();
                boolean z17 = false;
                if (l3 != null) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) l3, (CharSequence) "fetchCode=1", false, 2, (Object) null);
                    if (contains$default2) {
                        z16 = true;
                        if (z16) {
                            String l16 = clickActionParam.l();
                            if (l16 != null) {
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) l16, (CharSequence) "code", false, 2, (Object) null);
                                if (contains$default) {
                                    z17 = true;
                                }
                            }
                            if (!z17 && LebaPluginShopping.this.n0().get()) {
                                QLog.e("Leba.DefaultClickProcessor", 1, "jumpByClickAction url: " + clickActionParam.l() + ", mIsWaitingAuthCode: " + LebaPluginShopping.this.n0().get() + " ");
                                return;
                            }
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
            super.g(activity, clickActionParam);
        }

        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        public boolean h(@NotNull com.tencent.mobileqq.leba.entity.n item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(item, "item");
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("leba_plugin_shopping_show_server_dialog_switch", true);
            QLog.i("BaseLebaPluginItem", 1, "needShowServerDialogSwitch: " + isSwitchOn);
            return isSwitchOn;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginShopping$c", "Ls71/a;", "", "retCode", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements s71.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginShopping.this);
            }
        }

        @Override // s71.a
        public void a(int retCode) {
            boolean z16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, retCode);
                return;
            }
            if (retCode != 0) {
                return;
            }
            LebaPluginShopping lebaPluginShopping = LebaPluginShopping.this;
            lebaPluginShopping.mTraceId = lebaPluginShopping.p0(lebaPluginShopping.n());
            LebaPluginShopping lebaPluginShopping2 = LebaPluginShopping.this;
            lebaPluginShopping2.mGdtAd = lebaPluginShopping2.i0();
            if (LebaPluginShopping.this.mGdtAd != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            GdtAd gdtAd = LebaPluginShopping.this.mGdtAd;
            if (gdtAd != null) {
                str = gdtAd.getTraceId();
            } else {
                str = null;
            }
            QLog.d("LebaPluginShopping", 1, "adRspCallback update ad success:" + z16 + ", " + str);
            LebaPluginShopping lebaPluginShopping3 = LebaPluginShopping.this;
            lebaPluginShopping3.f0(lebaPluginShopping3.j0(), LebaPluginShopping.this.mSlot);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginShopping() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasJdJumped = new AtomicBoolean(false);
        this.mIsWaitingAuthCode = new AtomicBoolean(false);
        this.mRedTouchADId = "";
        this.mTraceId = "";
        this.mAdRspCallback = new c();
        lazy = LazyKt__LazyJVMKt.lazy(LebaPluginShopping$mDisclaimerConfig$2.INSTANCE);
        this.mDisclaimerConfig = lazy;
        this.handler = new MqqWeakReferenceHandler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.leba.business.plugins.aj
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean v06;
                v06 = LebaPluginShopping.v0(LebaPluginShopping.this, message);
                return v06;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(Context context, int index) {
        GdtAd gdtAd;
        if (h0(this.mGdtAd) && (gdtAd = this.mGdtAd) != null) {
            GdtOriginalExposureReporter.reportOriginalExposure(gdtAd, context, index);
            GdtReporter.doCgiReport(gdtAd.getUrlForImpression());
            new GdtThirdProcessorProxy().c2sReportAsync(0, 0, gdtAd.info);
            IAdApi iAdApi = (IAdApi) QRoute.api(IAdApi.class);
            String traceId = gdtAd.getTraceId();
            if (traceId == null) {
                traceId = "";
            }
            iAdApi.updateLebaShoppingRedTouchLastExpoAd(traceId);
            QLog.d("LebaPluginShopping", 1, "ad expo success:", gdtAd.getTraceId());
        }
    }

    private final void g0() {
        ((IAdApi) QRoute.api(IAdApi.class)).clearLebaShoppingRedTouchAd();
        this.mHasAdRequested = false;
        this.mGdtAd = null;
        this.mTraceId = "";
    }

    private final boolean h0(GdtAd gdtAd) {
        if (gdtAd == null) {
            return false;
        }
        return !TextUtils.equals(gdtAd.getTraceId(), ((IAdApi) QRoute.api(IAdApi.class)).getLebaShoppingRedTouchLastExpoAd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GdtAd i0() {
        QLog.d("LebaPluginShopping", 1, "getAmsAd:" + this.mTraceId);
        if (TextUtils.isEmpty(this.mTraceId)) {
            return null;
        }
        return ((IAdApi) QRoute.api(IAdApi.class)).getLebaShoppingRedTouchAd(this.mTraceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context j0() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.gdtad.config.data.m l0() {
        return (com.tencent.gdtad.config.data.m) this.mDisclaimerConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p0(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str;
        PBStringField pBStringField;
        if (appInfo != null && (pBStringField = appInfo.extend) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String optString = new JSONObject(str).optString(QFSEdgeItem.KEY_EXTEND);
        Intrinsics.checkNotNullExpressionValue(optString, "extendJson.optString(\"extend\")");
        return optString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(GdtAd gdtAd) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = gdtAd;
        params.activity = new WeakReference<>(Foreground.getTopActivity());
        params.directPlay = true;
        params.videoCeilingSupportedIfNotInstalled = true;
        params.widthHeightRatioOfVideoCeiling = "16:9";
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_gzh_weather");
        params.extra = bundle;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        new GdtThirdProcessorProxy().c2sReportAsync(1, 0, gdtAd.info);
        g0();
    }

    private final void r0(Message msg2) {
        QQAppInterface qQAppInterface;
        qqshop_code$SRsp qqshop_code_srsp;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null && msg2 != null) {
            BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler");
            EcshopReportHandler ecshopReportHandler = (EcshopReportHandler) businessHandler;
            String valueOf = String.valueOf(System.currentTimeMillis() - this.lastRequestAuthCodeTime);
            try {
                try {
                    Object obj = msg2.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type tencent.im.oidb.qqshop.qqshop_code.SRsp");
                    qqshop_code_srsp = (qqshop_code$SRsp) obj;
                } catch (Exception e16) {
                    QLog.e("LebaPluginShopping", 1, "authcode resp exception:" + e16);
                    if (this.mHasJdJumped.get()) {
                        return;
                    }
                }
                if (qqshop_code_srsp.auth_code.get() == null) {
                    if (!this.mHasJdJumped.get()) {
                        ecshopReportHandler.H2(134246777, null, "jump", valueOf, "no_code", 0L, false);
                        this.mHasJdJumped.set(true);
                        return;
                    }
                    return;
                }
                if (!this.mHasJdJumped.get()) {
                    this.mHasJdJumped.set(true);
                    ecshopReportHandler.H2(134246777, null, "jump", valueOf, "hascode", 0L, false);
                } else {
                    ecshopReportHandler.H2(134246777, null, "not_jump", valueOf, "", 0L, false);
                    this.tmpAuthItem = qqshop_code_srsp;
                }
                if (this.mHasJdJumped.get()) {
                    return;
                }
                ecshopReportHandler.H2(134246777, null, "jump", valueOf, "no_code", 0L, false);
                this.mHasJdJumped.set(true);
            } catch (Throwable th5) {
                if (!this.mHasJdJumped.get()) {
                    ecshopReportHandler.H2(134246777, null, "jump", valueOf, "no_code", 0L, false);
                    this.mHasJdJumped.set(true);
                }
                throw th5;
            }
        }
    }

    private final void s0(Runnable callback) {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        EcshopReportHandler ecshopReportHandler = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null && !this.mHasJdJumped.get()) {
            if (QLog.isColorLevel()) {
                QLog.e("LebaPluginShopping", 2, "time out jump!");
            }
            if (callback != null) {
                callback.run();
            }
            this.mHasJdJumped.set(true);
            BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
            if (businessHandler instanceof EcshopReportHandler) {
                ecshopReportHandler = (EcshopReportHandler) businessHandler;
            }
            EcshopReportHandler ecshopReportHandler2 = ecshopReportHandler;
            if (ecshopReportHandler2 != null) {
                ecshopReportHandler2.H2(134246777, null, "jump", "time_out", "no_code", 0L, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(LebaPluginShopping this$0, int i3, boolean z16, TianshuRedTouch tianshuRedTouch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = true;
        int i16 = i3 + 1;
        if (tianshuRedTouch == null || !tianshuRedTouch.Q()) {
            z17 = false;
        }
        this$0.w0(i16, z16, z17, "expose");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(LebaPluginShopping this$0, int i3, boolean z16, RedTouch redTouch) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = true;
        int i16 = i3 + 1;
        if (redTouch == null || !redTouch.hasLebaRedTouch()) {
            z17 = false;
        }
        this$0.w0(i16, z16, z17, "expose");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v0(LebaPluginShopping this$0, Message it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && !Intrinsics.areEqual("0", peekAppRuntime.getCurrentAccountUin())) {
            switch (it.what) {
                case 1134007:
                    this$0.s0(it.getCallback());
                    return true;
                case 1134008:
                    this$0.r0(it);
                    return true;
                default:
                    return true;
            }
        }
        return false;
    }

    private final void w0(int position, boolean isTableModel, boolean hasRedDot, String action) {
        String str;
        Map<String, String> mapOf;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("ext2", String.valueOf(position));
        String str2 = "1";
        if (!isTableModel) {
            str = "1";
        } else {
            str = "2";
        }
        pairArr[1] = TuplesKt.to("ext3", str);
        if (!hasRedDot) {
            str2 = "0";
        }
        pairArr[2] = TuplesKt.to("ext4", str2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        ((IAdAttaReporterApi) QRoute.api(IAdAttaReporterApi.class)).report("dongtai", "jd", action, mapOf);
    }

    private final void x0(Context context, int index) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105775", true)) {
            return;
        }
        if (!this.mHasAdRequested) {
            ((IAdApi) QRoute.api(IAdApi.class)).requestLebaShoppingRedTouchAd(this.mAdRspCallback);
        }
        this.mHasAdRequested = true;
        this.mTraceId = p0(n());
        this.mGdtAd = i0();
        f0(context, index);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.G();
        this.mHasExposed = false;
        this.mHasAdRequested = false;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        int i3 = reportInfo.f240478b;
        boolean z17 = reportInfo.f240480d;
        if (reportInfo.f240479c != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        w0(i3, z17, z16, "click");
        super.H(v3, item, reportInfo);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean Q(@NotNull RedTouch redTouch, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo, int style) {
        String str;
        PBRepeatField<String> pBRepeatField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, redTouch, appInfo, Integer.valueOf(style))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(redTouch, "redTouch");
        if (appInfo != null && (pBRepeatField = appInfo.missions) != null) {
            str = pBRepeatField.get(0);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.mRedTouchADId = str;
        return super.Q(redTouch, appInfo, style);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public DefaultClickProcessor k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (DefaultClickProcessor) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new b();
    }

    @NotNull
    public final MqqWeakReferenceHandler k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MqqWeakReferenceHandler) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.handler;
    }

    @NotNull
    public final AtomicBoolean m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mHasJdJumped;
    }

    @NotNull
    public final AtomicBoolean n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mIsWaitingAuthCode;
    }

    @Nullable
    public final qqshop_code$SRsp o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (qqshop_code$SRsp) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.tmpAuthItem;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return 3053L;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean x(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable final TianshuRedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, final int index, final boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        if (!this.mHasExposed) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.ak
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginShopping.t0(LebaPluginShopping.this, index, isTableModel, redTouch);
                }
            });
        }
        this.mHasExposed = true;
        this.mSlot = index;
        x0(context, index);
        return super.x(app, context, resID, redTouch, resPkgName, redTouchHistory, index, isTableModel);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean y(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable final RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, final int index, final boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        if (!this.mHasExposed) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.al
                @Override // java.lang.Runnable
                public final void run() {
                    LebaPluginShopping.u0(LebaPluginShopping.this, index, isTableModel, redTouch);
                }
            });
        }
        this.mHasExposed = true;
        this.mSlot = index;
        x0(context, index);
        return super.y(app, context, resID, redTouch, resPkgName, redTouchHistory, index, isTableModel);
    }

    public final void y0(@Nullable String url) {
        QQAppInterface qQAppInterface;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) url);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.mobileqq.apollo.handler.b bVar = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface != null) {
            obj = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        } else {
            obj = null;
        }
        if (obj instanceof com.tencent.mobileqq.apollo.handler.b) {
            bVar = (com.tencent.mobileqq.apollo.handler.b) obj;
        }
        if (bVar != null) {
            bVar.c0(url);
        }
        this.lastRequestAuthCodeTime = System.currentTimeMillis();
    }
}
