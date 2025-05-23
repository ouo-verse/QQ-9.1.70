package com.tencent.mobileqq.zplan.share.action;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.share.MultiFileUploadHelper;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.mobileqq.zplan.share.ZPlanShareParam;
import com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction;
import com.tencent.mobileqq.zplan.share.action.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import ov4.l;
import ov4.n;
import ov4.o;
import ov4.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 P2\u00020\u0001:\u0004/0'+B\u0007\u00a2\u0006\u0004\bN\u0010OJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J2\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J?\u0010\u001e\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00040\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J*\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0016J*\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020.H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00103R0\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f05j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f`68\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010=R\u0016\u0010E\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001b\u0010K\u001a\u00020F8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction;", "Lcom/tencent/mobileqq/zplan/share/action/b;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "v", "Lcom/tencent/mobileqq/zplan/share/e;", "shareParams", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "listener", "", IProfileProtocolConst.PARAM_IS_FRIEND, "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$c;", "shareConfig", "B", "", "path", "Landroid/graphics/Bitmap;", "y", "", "uinType", "uin", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "midImage", "bigImage", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "callback", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", HippyTKDListViewAdapter.X, "Lov4/f;", "result", "u", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "c", "onFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "d", "f", "e", "Lcom/tencent/mobileqq/zplan/share/report/c;", "a", "b", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$c;", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$b;", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$b;", "getShareConfigListener", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "uploadImageRsp", "Lcom/tencent/mobileqq/zootopia/view/z;", "Lcom/tencent/mobileqq/zootopia/view/z;", "loadingDialog", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "showLoadingRunnable", "g", "disMissLoadingRunnable", tl.h.F, "shareToWxRspRunnable", "i", "Z", "isRequestShareConfigFail", "Lcom/tencent/mobileqq/zplan/share/MultiFileUploadHelper;", "j", "Lkotlin/Lazy;", "w", "()Lcom/tencent/mobileqq/zplan/share/MultiFileUploadHelper;", "uploadFileHelper", "k", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", "<init>", "()V", "l", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class SmallHomeShotShareAction implements com.tencent.mobileqq.zplan.share.action.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ShareConfig shareConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private b getShareConfigListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, String> uploadImageRsp = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private z loadingDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Runnable showLoadingRunnable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Runnable disMissLoadingRunnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Runnable shareToWxRspRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isRequestShareConfigFail;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Lazy uploadFileHelper;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ZPlanShareLaunchParam launchParam;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$b;", "", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$c;", "resp", "", "a", "", "error", "", "message", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(ShareConfig resp);

        void b(int error, String message);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lov4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<ov4.f> {
        e() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ov4.f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ShareConfig u16 = SmallHomeShotShareAction.this.u(result);
            SmallHomeShotShareAction.this.shareConfig = u16;
            SmallHomeShotShareAction.this.isRequestShareConfigFail = false;
            b bVar = SmallHomeShotShareAction.this.getShareConfigListener;
            if (bVar != null) {
                bVar.a(u16);
            }
            QLog.i("ModShareAction", 1, "request share config success -> " + u16);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ModShareAction", 1, "request failed " + error + ", " + message);
            SmallHomeShotShareAction.this.isRequestShareConfigFail = true;
            SmallHomeShotShareAction.this.x();
            b bVar = SmallHomeShotShareAction.this.getShareConfigListener;
            if (bVar != null) {
                bVar.b(error, message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$f", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$b;", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$c;", "resp", "", "a", "", "error", "", "message", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f335492b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f335493c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f335494d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanShareParam f335495e;

        f(Activity activity, int i3, String str, ZPlanShareParam zPlanShareParam) {
            this.f335492b = activity;
            this.f335493c = i3;
            this.f335494d = str;
            this.f335495e = zPlanShareParam;
        }

        @Override // com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction.b
        public void a(ShareConfig resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            SmallHomeShotShareAction.this.A(this.f335492b, this.f335493c, this.f335494d, this.f335495e, resp);
        }

        @Override // com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction.b
        public void b(int error, String message) {
            SmallHomeShotShareAction.this.v(this.f335492b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$g", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$b;", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$c;", "resp", "", "a", "", "error", "", "message", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanShareParam f335497b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WXShareHelper.a f335498c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f335499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f335500e;

        g(ZPlanShareParam zPlanShareParam, WXShareHelper.a aVar, boolean z16, Activity activity) {
            this.f335497b = zPlanShareParam;
            this.f335498c = aVar;
            this.f335499d = z16;
            this.f335500e = activity;
        }

        @Override // com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction.b
        public void a(ShareConfig resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            SmallHomeShotShareAction.this.B(this.f335497b, this.f335498c, this.f335499d, resp);
        }

        @Override // com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction.b
        public void b(int error, String message) {
            SmallHomeShotShareAction.this.v(this.f335500e);
        }
    }

    public SmallHomeShotShareAction() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MultiFileUploadHelper>() { // from class: com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction$uploadFileHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MultiFileUploadHelper invoke() {
                return new MultiFileUploadHelper();
            }
        });
        this.uploadFileHelper = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(Activity activity, int uinType, String uin, ZPlanShareParam shareParams, ShareConfig shareConfig) {
        ov4.c cVar;
        o invite;
        String view;
        String app;
        String prompt;
        String ver;
        x();
        Map<String, Object> j3 = shareParams.j();
        HashMap hashMap = j3 instanceof HashMap ? (HashMap) j3 : null;
        if (hashMap != null) {
            l shareArkInfo = shareConfig.getShareArkInfo();
            hashMap.put("id", shareConfig.getShareId());
            if (shareArkInfo != null && (ver = shareArkInfo.f424173e) != null) {
                Intrinsics.checkNotNullExpressionValue(ver, "ver");
                hashMap.put("ark_version", ver);
            }
            if (shareArkInfo != null && (prompt = shareArkInfo.f424172d) != null) {
                Intrinsics.checkNotNullExpressionValue(prompt, "prompt");
                hashMap.put("prompt", prompt);
            }
            if (shareArkInfo != null && (app = shareArkInfo.f424170b) != null) {
                Intrinsics.checkNotNullExpressionValue(app, "app");
                hashMap.put("name_app_ark", app);
            }
            if (shareArkInfo != null && (view = shareArkInfo.f424171c) != null) {
                Intrinsics.checkNotNullExpressionValue(view, "view");
                hashMap.put("view_app_ark", view);
            }
            if (shareArkInfo != null && (cVar = shareArkInfo.f424174f) != null && (invite = cVar.f424142a) != null) {
                Intrinsics.checkNotNullExpressionValue(invite, "invite");
                String str = invite.f424185a;
                Intrinsics.checkNotNullExpressionValue(str, "meta.roomId");
                hashMap.put("roomId", str);
                hashMap.put("roomCreateTime", Long.valueOf(invite.f424190f));
                String str2 = invite.f424191g;
                Intrinsics.checkNotNullExpressionValue(str2, "meta.background");
                hashMap.put("background", str2);
                String str3 = invite.f424187c;
                Intrinsics.checkNotNullExpressionValue(str3, "meta.title");
                hashMap.put("title", str3);
                String str4 = invite.f424189e;
                Intrinsics.checkNotNullExpressionValue(str4, "meta.tag");
                hashMap.put("tag", str4);
                String str5 = invite.f424188d;
                Intrinsics.checkNotNullExpressionValue(str5, "meta.tagIcon");
                hashMap.put("tagIcon", str5);
                hashMap.put("showRoomState", Boolean.valueOf(invite.f424192h));
            }
        }
        QLog.d("ModShareAction", 1, "shareToQQInternal => " + shareParams);
        com.tencent.mobileqq.zplan.share.d.f335534a.w(activity, uinType, uin, shareParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(ZPlanShareParam shareParams, final WXShareHelper.a listener, boolean isFriend, ShareConfig shareConfig) {
        String path;
        Map<String, Object> shareExtraParams;
        Object obj;
        x();
        int i3 = !isFriend ? 1 : 0;
        if (listener != null) {
            WXShareHelper.b0().A(listener);
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        WXShareInfo wxInfo = shareConfig.getWxInfo();
        ZPlanShareLaunchParam zPlanShareLaunchParam = this.launchParam;
        if (zPlanShareLaunchParam == null || (shareExtraParams = zPlanShareLaunchParam.getShareExtraParams()) == null || (obj = shareExtraParams.get(ReportConstant.COSTREPORT_PREFIX)) == null || (path = obj.toString()) == null) {
            path = shareParams.getPath();
        }
        QLog.i("ModShareAction", 1, "share H5 to wx " + wxInfo + ", path: " + path);
        WXShareHelper.b0().L0(valueOf, wxInfo.getTitle(), y(path), wxInfo.getDesc(), wxInfo.getWebPageUrl(), i3);
        if (this.shareToWxRspRunnable == null) {
            this.shareToWxRspRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.share.action.g
                @Override // java.lang.Runnable
                public final void run() {
                    SmallHomeShotShareAction.C(WXShareHelper.a.this);
                }
            };
        }
    }

    private final void D(final Activity activity) {
        QLog.i("ModShareAction", 1, "show loading =>");
        if (this.loadingDialog == null) {
            this.loadingDialog = new z(activity, false, false, 6, null);
        }
        try {
            if (this.showLoadingRunnable == null) {
                this.showLoadingRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.share.action.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmallHomeShotShareAction.E(activity, this);
                    }
                };
            }
            if (this.disMissLoadingRunnable == null) {
                this.disMissLoadingRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.share.action.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmallHomeShotShareAction.F(SmallHomeShotShareAction.this, activity);
                    }
                };
            }
            ThreadManager.getUIHandler().postDelayed(this.showLoadingRunnable, 500L);
            ThreadManager.getUIHandler().postDelayed(this.disMissLoadingRunnable, 5000L);
        } catch (Exception e16) {
            QLog.e("ModShareAction", 1, "show loading dialog fail => ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Activity activity, SmallHomeShotShareAction this$0) {
        z zVar;
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activity.isFinishing() || activity.isDestroyed() || (zVar = this$0.loadingDialog) == null) {
            return;
        }
        zVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(SmallHomeShotShareAction this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QLog.i("ModShareAction", 1, "show loading timeout, dismiss dialog!");
        this$0.x();
        QQToast.makeText(BaseApplication.getContext(), 1, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25", 0).show();
        activity.finish();
    }

    private final void G(String midImage, String bigImage, final Function1<? super Boolean, Unit> callback) {
        String contentPath;
        String contentPath2;
        if (!com.tencent.biz.common.util.g.b(BaseApplication.getContext())) {
            QQToast.makeText(BaseApplication.getContext(), 1, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25", 0).show();
            return;
        }
        QLog.i("ModShareAction", 1, "uploadImage to cdn " + midImage + ", " + bigImage);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (midImage != null) {
            linkedHashMap.put(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, midImage);
        }
        if (bigImage != null) {
            linkedHashMap.put("l", bigImage);
        }
        if (linkedHashMap.isEmpty()) {
            ZPlanShareLaunchParam zPlanShareLaunchParam = this.launchParam;
            if (zPlanShareLaunchParam != null && (contentPath2 = zPlanShareLaunchParam.getContentPath()) != null) {
                linkedHashMap.put(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, contentPath2);
            }
            ZPlanShareLaunchParam zPlanShareLaunchParam2 = this.launchParam;
            if (zPlanShareLaunchParam2 != null && (contentPath = zPlanShareLaunchParam2.getContentPath()) != null) {
                linkedHashMap.put("l", contentPath);
            }
        }
        w().c(linkedHashMap, new Function3<String, String, String, Unit>() { // from class: com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction$uploadImageToCDN$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, String str3) {
                invoke2(str, str2, str3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, String str, String remoteUrl) {
                HashMap hashMap;
                HashMap hashMap2;
                HashMap hashMap3;
                HashMap hashMap4;
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
                hashMap = SmallHomeShotShareAction.this.uploadImageRsp;
                hashMap.put(key, remoteUrl);
                hashMap2 = SmallHomeShotShareAction.this.uploadImageRsp;
                if (hashMap2.size() >= linkedHashMap.size()) {
                    Map<String, String> map = linkedHashMap;
                    SmallHomeShotShareAction smallHomeShotShareAction = SmallHomeShotShareAction.this;
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        hashMap4 = smallHomeShotShareAction.uploadImageRsp;
                        if (TextUtils.isEmpty((CharSequence) hashMap4.get(entry.getKey()))) {
                            linkedHashMap2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    callback.invoke(Boolean.valueOf(linkedHashMap2.isEmpty()));
                    hashMap3 = SmallHomeShotShareAction.this.uploadImageRsp;
                    QLog.i("ModShareAction", 1, "file upload success " + hashMap3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShareConfig u(ov4.f result) {
        q qVar = result.f424158c;
        String str = qVar != null ? qVar.f424196a : null;
        if (str == null) {
            str = "";
        }
        String str2 = qVar != null ? qVar.f424198c : null;
        if (str2 == null) {
            str2 = "QQ\u5c0f\u7a9d";
        }
        String str3 = qVar != null ? qVar.f424200e : null;
        WXShareInfo wXShareInfo = new WXShareInfo(str, str2, str3 != null ? str3 : "");
        String str4 = result.f424156a;
        Intrinsics.checkNotNullExpressionValue(str4, "result.shareId");
        return new ShareConfig(str4, wXShareInfo, result.f424157b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(Activity activity) {
        QQToast.makeText(BaseApplication.getContext(), 1, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0).show();
        activity.finish();
    }

    private final MultiFileUploadHelper w() {
        return (MultiFileUploadHelper) this.uploadFileHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        z zVar;
        z zVar2 = this.loadingDialog;
        QLog.i("ModShareAction", 1, "hide dialog => " + (zVar2 != null ? Boolean.valueOf(zVar2.isShowing()) : null));
        ThreadManager.getUIHandler().removeCallbacks(this.showLoadingRunnable);
        ThreadManager.getUIHandler().removeCallbacks(this.disMissLoadingRunnable);
        z zVar3 = this.loadingDialog;
        if (!(zVar3 != null && zVar3.isShowing()) || (zVar = this.loadingDialog) == null) {
            return;
        }
        zVar.dismiss();
    }

    private final Bitmap y(String path) {
        if (path == null) {
            return null;
        }
        if ((path.length() == 0) || !new File(path).exists()) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeFile = BitmapFactory.decodeFile(path, options);
            int width = decodeFile != null ? decodeFile.getWidth() : 0;
            int height = decodeFile != null ? decodeFile.getHeight() : 0;
            int i3 = width * height;
            if (i3 > 8000) {
                double sqrt = Math.sqrt(8000 / i3);
                int i16 = (int) (width * sqrt);
                int i17 = (int) (sqrt * height);
                decodeFile = Bitmap.createScaledBitmap(decodeFile, i16, i17, true);
                QLog.d("ModShareAction", 1, "scaledBitamp ==>" + i16 + ", " + i17 + " ");
            }
            QLog.d("ModShareAction", 1, "decode bitmap : cost " + (System.currentTimeMillis() - currentTimeMillis) + ", bitmap =" + (decodeFile == null));
            return decodeFile;
        } catch (Error e16) {
            QLog.e("ModShareAction", 1, "error ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        Map<String, Object> shareExtraParams;
        Map<String, Object> shareExtraParams2;
        Map<String, Object> shareExtraParams3;
        Object obj;
        String obj2;
        Map<String, Object> shareExtraParams4;
        Object obj3;
        String obj4;
        Map<String, Object> shareExtraParams5;
        Object obj5;
        String obj6;
        Map<String, Object> shareExtraParams6;
        Object obj7;
        String obj8;
        Map<String, Object> shareExtraParams7;
        Object obj9;
        String obj10;
        ov4.e eVar = new ov4.e();
        n[] nVarArr = new n[2];
        n nVar = new n();
        nVar.f424183a = 1;
        String str = this.uploadImageRsp.get(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
        if (str == null) {
            str = "";
        }
        nVar.f424184b = str;
        Unit unit = Unit.INSTANCE;
        boolean z16 = false;
        nVarArr[0] = nVar;
        n nVar2 = new n();
        nVar2.f424183a = 2;
        String str2 = this.uploadImageRsp.get("l");
        nVar2.f424184b = str2 != null ? str2 : "";
        nVarArr[1] = nVar2;
        eVar.f424148d = nVarArr;
        ZPlanShareLaunchParam zPlanShareLaunchParam = this.launchParam;
        if (zPlanShareLaunchParam != null && (shareExtraParams7 = zPlanShareLaunchParam.getShareExtraParams()) != null && (obj9 = shareExtraParams7.get("OpenId")) != null && (obj10 = obj9.toString()) != null) {
            eVar.f424145a = obj10;
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam2 = this.launchParam;
        if (zPlanShareLaunchParam2 != null && (shareExtraParams6 = zPlanShareLaunchParam2.getShareExtraParams()) != null && (obj7 = shareExtraParams6.get("SceneId")) != null && (obj8 = obj7.toString()) != null) {
            eVar.f424146b = obj8;
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam3 = this.launchParam;
        if (zPlanShareLaunchParam3 != null && (shareExtraParams5 = zPlanShareLaunchParam3.getShareExtraParams()) != null && (obj5 = shareExtraParams5.get("RoomId")) != null && (obj6 = obj5.toString()) != null) {
            eVar.f424147c = obj6;
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam4 = this.launchParam;
        if (zPlanShareLaunchParam4 != null && (shareExtraParams4 = zPlanShareLaunchParam4.getShareExtraParams()) != null && (obj3 = shareExtraParams4.get("RoomName")) != null && (obj4 = obj3.toString()) != null) {
            eVar.f424154j = obj4;
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam5 = this.launchParam;
        if (zPlanShareLaunchParam5 != null && (shareExtraParams3 = zPlanShareLaunchParam5.getShareExtraParams()) != null && (obj = shareExtraParams3.get("ExtContent")) != null && (obj2 = obj.toString()) != null) {
            eVar.f424152h = obj2;
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam6 = this.launchParam;
        Object obj11 = (zPlanShareLaunchParam6 == null || (shareExtraParams2 = zPlanShareLaunchParam6.getShareExtraParams()) == null) ? null : shareExtraParams2.get("LikesNums");
        Integer num = obj11 instanceof Integer ? (Integer) obj11 : null;
        if (num != null) {
            eVar.f424150f = num.intValue();
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam7 = this.launchParam;
        Object obj12 = (zPlanShareLaunchParam7 == null || (shareExtraParams = zPlanShareLaunchParam7.getShareExtraParams()) == null) ? null : shareExtraParams.get("SceneType");
        Integer num2 = obj12 instanceof Integer ? (Integer) obj12 : null;
        if (num2 != null) {
            eVar.f424153i = num2.intValue();
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam8 = this.launchParam;
        if (zPlanShareLaunchParam8 != null && zPlanShareLaunchParam8.getShareType() == 6) {
            z16 = true;
        }
        if (z16) {
            eVar.f424155k = "1";
        } else {
            eVar.f424155k = "0";
        }
        QLog.i("ModShareAction", 1, "request share config -> " + eVar);
        mj3.a.b(mj3.a.f416866a, eVar, new e(), 0, 4, null);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public com.tencent.mobileqq.zplan.share.report.c a() {
        return new com.tencent.mobileqq.zplan.share.report.e();
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void b(Activity activity, ZPlanShareParam zPlanShareParam) {
        b.C9201b.e(this, activity, zPlanShareParam);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void c(ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.launchParam = launchParam;
        Map<String, Object> shareExtraParams = launchParam.getShareExtraParams();
        if (shareExtraParams != null) {
            Object obj = shareExtraParams.get(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
            String obj2 = obj != null ? obj.toString() : null;
            Object obj3 = shareExtraParams.get("l");
            G(obj2, obj3 != null ? obj3.toString() : null, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction$prepareToShare$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    SmallHomeShotShareAction.ShareConfig shareConfig;
                    if (z16) {
                        shareConfig = SmallHomeShotShareAction.this.shareConfig;
                        if (shareConfig == null) {
                            SmallHomeShotShareAction.this.z();
                        }
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void d(final Activity activity, ZPlanShareParam shareParams, int uinType, String uin) {
        Map<String, Object> shareExtraParams;
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        ShareConfig shareConfig = this.shareConfig;
        if (shareConfig != null) {
            if (shareConfig != null) {
                A(activity, uinType, uin, shareParams, shareConfig);
                return;
            }
            return;
        }
        D(activity);
        this.getShareConfigListener = new f(activity, uinType, uin, shareParams);
        String str = this.uploadImageRsp.get(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO);
        QLog.i("ModShareAction", 1, "share to QQ with remoteUrl " + str + ",  and isRequestShareConfigFail => " + this.isRequestShareConfigFail + " ");
        if (str != null) {
            if (!(str.length() == 0)) {
                if (this.isRequestShareConfigFail) {
                    z();
                    return;
                }
                return;
            }
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam = this.launchParam;
        G(null, (zPlanShareLaunchParam == null || (shareExtraParams = zPlanShareLaunchParam.getShareExtraParams()) == null || (obj = shareExtraParams.get(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO)) == null) ? null : obj.toString(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction$shareToQQ$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    SmallHomeShotShareAction.this.z();
                } else {
                    SmallHomeShotShareAction.this.v(activity);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void e(final Activity activity, ZPlanShareParam shareParams, WXShareHelper.a listener, boolean isFriend) {
        String str;
        Map<String, Object> shareExtraParams;
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        if (!com.tencent.mobileqq.zplan.share.action.b.INSTANCE.a()) {
            activity.finish();
            return;
        }
        ShareConfig shareConfig = this.shareConfig;
        if (shareConfig != null) {
            if (shareConfig != null) {
                B(shareParams, listener, isFriend, shareConfig);
                return;
            }
            return;
        }
        D(activity);
        this.getShareConfigListener = new g(shareParams, listener, isFriend, activity);
        String str2 = this.uploadImageRsp.get("l");
        QLog.i("ModShareAction", 1, "click share to WX, remoteUrl: " + str2 + ",  isRequestShareConfigFail: " + this.isRequestShareConfigFail);
        if (str2 != null) {
            if (!(str2.length() == 0)) {
                if (this.isRequestShareConfigFail) {
                    z();
                    return;
                }
                return;
            }
        }
        ZPlanShareLaunchParam zPlanShareLaunchParam = this.launchParam;
        if (zPlanShareLaunchParam == null || (shareExtraParams = zPlanShareLaunchParam.getShareExtraParams()) == null || (obj = shareExtraParams.get("l")) == null || (str = obj.toString()) == null) {
            str = "";
        }
        G(null, str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction$shareToWX$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    SmallHomeShotShareAction.this.z();
                } else {
                    SmallHomeShotShareAction.this.v(activity);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void f(Activity activity, ZPlanShareParam shareParams, ZPlanShareLaunchParam launchParam) {
        String path;
        ArrayList<String> arrayListOf;
        Object obj;
        l shareArkInfo;
        ov4.c cVar;
        o oVar;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        QLog.i("ModShareAction", 1, "send video to qzone");
        Map<String, Object> j3 = shareParams.j();
        HashMap hashMap = j3 instanceof HashMap ? (HashMap) j3 : null;
        if (hashMap != null) {
            Object obj2 = hashMap.get("ExtContent");
            String str = obj2 instanceof String ? (String) obj2 : null;
            if (str == null) {
                str = "";
            }
            ShareConfig shareConfig = this.shareConfig;
            String str2 = (shareConfig == null || (shareArkInfo = shareConfig.getShareArkInfo()) == null || (cVar = shareArkInfo.f424174f) == null || (oVar = cVar.f424142a) == null) ? null : oVar.f424186b;
            if (str2 == null) {
                ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                ZootopiaSource a16 = ZootopiaSource.INSTANCE.a(Source.UserCenter);
                Bundle bundle = new Bundle();
                bundle.putBoolean("openDetailNotReady", true);
                bundle.putBoolean(FavEmoConstant.ROAMING_TYPE_PANEL, true);
                Bundle bundle2 = new Bundle();
                bundle2.putString("ExtContent", str);
                bundle2.putString("SceneType", "5");
                Unit unit = Unit.INSTANCE;
                bundle.putBundle("ueParams", bundle2);
                str2 = iSchemeApi.buildMapScheme(a16, AdMetricID.Click.SUCCESS, bundle);
            }
            QLog.d("ModShareAction", 1, "appendParamsForQZone, url:" + str2);
            hashMap.put(QZoneShareManager.QZONE_SHARE_HULIAN_APPID, "1000001");
            hashMap.put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, str2);
        }
        Map<String, Object> shareExtraParams = launchParam.getShareExtraParams();
        if (shareExtraParams == null || (obj = shareExtraParams.get(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO)) == null || (path = obj.toString()) == null) {
            path = shareParams.getPath();
        }
        Bundle bundle3 = new Bundle();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(path);
        bundle3.putStringArrayList("images", arrayListOf);
        for (Map.Entry<String, Object> entry : shareParams.j().entrySet()) {
            bundle3.putString(entry.getKey(), entry.getValue().toString());
        }
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        AppRuntime appRuntime = qBaseActivity != null ? qBaseActivity.getAppRuntime() : null;
        AppInterface appInterface = appRuntime instanceof AppInterface ? (AppInterface) appRuntime : null;
        if (appInterface == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            appInterface = (AppInterface) peekAppRuntime;
        }
        QZoneShareManager.publishToQzone(appInterface, activity, bundle3, null, shareParams.getRequestCode());
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onFinish() {
        w().b();
        this.shareToWxRspRunnable = null;
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onResume() {
        QLog.i("ModShareAction", 1, "shareToWxRsp : " + (this.shareToWxRspRunnable == null));
        Runnable runnable = this.shareToWxRspRunnable;
        if (runnable != null) {
            runnable.run();
        }
        this.shareToWxRspRunnable = null;
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onDestroy() {
        QLog.i("ModShareAction", 1, "onDestroy ");
        Runnable runnable = this.shareToWxRspRunnable;
        if (runnable != null) {
            ThreadManager.getUIHandler().removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(WXShareHelper.a aVar) {
        if (aVar != null) {
            aVar.onWXShareResp(new ShowMessageFromWX.Resp());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "shareId", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$d;", "Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$d;", "c", "()Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$d;", "wxInfo", "Lov4/l;", "Lov4/l;", "()Lov4/l;", AppConstants.Key.SHARE_REQ_ARK_INFO, "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$d;Lov4/l;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class ShareConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String shareId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final WXShareInfo wxInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final l shareArkInfo;

        public ShareConfig(String shareId, WXShareInfo wxInfo, l lVar) {
            Intrinsics.checkNotNullParameter(shareId, "shareId");
            Intrinsics.checkNotNullParameter(wxInfo, "wxInfo");
            this.shareId = shareId;
            this.wxInfo = wxInfo;
            this.shareArkInfo = lVar;
        }

        /* renamed from: a, reason: from getter */
        public final l getShareArkInfo() {
            return this.shareArkInfo;
        }

        /* renamed from: b, reason: from getter */
        public final String getShareId() {
            return this.shareId;
        }

        /* renamed from: c, reason: from getter */
        public final WXShareInfo getWxInfo() {
            return this.wxInfo;
        }

        public int hashCode() {
            int hashCode = ((this.shareId.hashCode() * 31) + this.wxInfo.hashCode()) * 31;
            l lVar = this.shareArkInfo;
            return hashCode + (lVar == null ? 0 : lVar.hashCode());
        }

        public String toString() {
            return "ShareConfig(shareId=" + this.shareId + ", wxInfo=" + this.wxInfo + ", shareArkInfo=" + this.shareArkInfo + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShareConfig)) {
                return false;
            }
            ShareConfig shareConfig = (ShareConfig) other;
            return Intrinsics.areEqual(this.shareId, shareConfig.shareId) && Intrinsics.areEqual(this.wxInfo, shareConfig.wxInfo) && Intrinsics.areEqual(this.shareArkInfo, shareConfig.shareArkInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/SmallHomeShotShareAction$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "title", "desc", "c", "webPageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.share.action.SmallHomeShotShareAction$d, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class WXShareInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String desc;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String webPageUrl;

        public WXShareInfo(String title, String desc, String webPageUrl) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(webPageUrl, "webPageUrl");
            this.title = title;
            this.desc = desc;
            this.webPageUrl = webPageUrl;
        }

        /* renamed from: a, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        /* renamed from: b, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: c, reason: from getter */
        public final String getWebPageUrl() {
            return this.webPageUrl;
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.desc.hashCode()) * 31) + this.webPageUrl.hashCode();
        }

        public String toString() {
            return "WXShareInfo(title=" + this.title + ", desc=" + this.desc + ", webPageUrl=" + this.webPageUrl + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WXShareInfo)) {
                return false;
            }
            WXShareInfo wXShareInfo = (WXShareInfo) other;
            return Intrinsics.areEqual(this.title, wXShareInfo.title) && Intrinsics.areEqual(this.desc, wXShareInfo.desc) && Intrinsics.areEqual(this.webPageUrl, wXShareInfo.webPageUrl);
        }
    }
}
