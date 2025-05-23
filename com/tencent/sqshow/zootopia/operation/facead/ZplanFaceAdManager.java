package com.tencent.sqshow.zootopia.operation.facead;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.data.ZootopiaFaceAdListData;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.operation.SilverGuideType;
import com.tencent.sqshow.zootopia.operation.facead.web.ZplanFaceAdWebFragment;
import com.tencent.sqshow.zootopia.utils.ah;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;
import xv4.t;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001/B\u001b\u0012\b\u0010^\u001a\u0004\u0018\u00010]\u0012\b\u0010_\u001a\u0004\u0018\u00010L\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J@\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\"\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0006H\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J$\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$J\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004J4\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0006H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J!\u00106\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u000104H\u0016\u00a2\u0006\u0004\b6\u00107R&\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u000b08j\b\u0012\u0004\u0012\u00020\u000b`98\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010:R\u0016\u0010=\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010WR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010XR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010YR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010[\u00a8\u0006b"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/ZplanFaceAdManager;", "Lcom/tencent/sqshow/zootopia/operation/facead/a;", "Lcom/tencent/sqshow/zootopia/operation/facead/ZPlanSilverGuideDialogController;", "controller", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "showIndex", "Lnw4/h;", "faceAdInfo", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroid/view/ViewGroup;", "fragmentContainer", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Landroid/os/Bundle;", "arguments", "o", "originalFaceAdInfo", "j", "isPreClicked", HippyTKDListViewAdapter.X, "", "logMsg", "isDebugOnly", ReportConstant.COSTREPORT_PREFIX, "", "th", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "p", "k", "Landroid/content/res/Configuration;", "newConfig", "t", "v", "w", "u", "Lcom/tencent/sqshow/zootopia/data/i;", "listData", DomainData.DOMAIN_NAME, "Lcom/tencent/sqshow/zootopia/operation/facead/b;", "faceAd", "a", "isClickJump", "c", "b", "faceAdId", "", "iAdId", "d", "(Ljava/lang/String;Ljava/lang/Long;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "waitingFaceAdList", "I", "curShowingFaceAdIndex", "Lcom/tencent/sqshow/zootopia/operation/facead/b;", "curShowingFaceAd", "Lja4/a;", "Lja4/a;", "operationRepository", "Lcom/tencent/sqshow/zootopia/operation/facead/p;", "e", "Lcom/tencent/sqshow/zootopia/operation/facead/p;", "realNativeHandler", "Lcom/tencent/sqshow/zootopia/operation/facead/d;", "f", "Lcom/tencent/sqshow/zootopia/operation/facead/d;", "bodyUpdateHandler", "Lmqq/util/WeakReference;", "Lcom/tencent/sqshow/zootopia/operation/facead/c;", "g", "Lmqq/util/WeakReference;", "faceAdLifeCycleDispatcher", "", "Lcom/tencent/sqshow/zootopia/operation/facead/h;", tl.h.F, "[Lcom/tencent/sqshow/zootopia/operation/facead/h;", "adHandlers", "i", "Landroidx/fragment/app/FragmentManager;", "Landroid/view/ViewGroup;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Landroid/os/Bundle;", "Ldc4/a;", "Ldc4/a;", "repository", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "lifeCycleDispatcher", "<init>", "(Landroid/app/Activity;Lcom/tencent/sqshow/zootopia/operation/facead/c;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanFaceAdManager implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ArrayList<nw4.h> waitingFaceAdList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int curShowingFaceAdIndex = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.operation.facead.b curShowingFaceAd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ja4.a operationRepository;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final p realNativeHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.operation.facead.d bodyUpdateHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<com.tencent.sqshow.zootopia.operation.facead.c> faceAdLifeCycleDispatcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final h[] adHandlers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FragmentManager fragmentManager;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ViewGroup fragmentContainer;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource sourceCurrent;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private Bundle arguments;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final dc4.a repository;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/ZplanFaceAdManager$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lxv4/t;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<t> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanSilverGuideDialogController f372142e;

        b(ZPlanSilverGuideDialogController zPlanSilverGuideDialogController) {
            this.f372142e = zPlanSilverGuideDialogController;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(t result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZplanFaceAdManager", 1, "GuidePopupsRsp success, result.isShow: " + result.f448818a);
            if (result.f448818a) {
                ZplanFaceAdManager.this.A(this.f372142e);
            } else {
                ZplanFaceAdManager.this.B();
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZplanFaceAdManager", 1, "GuidePopupsRsp failure, error: " + error + ", msg: " + message);
            ZplanFaceAdManager.this.B();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/ZplanFaceAdManager$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "onResultSuccess", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<Object> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f372144e;

        c(String str) {
            this.f372144e = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ZplanFaceAdManager.r(ZplanFaceAdManager.this, "notifyFaceAdHasShown " + this.f372144e + "  onError - " + error + ", " + message, false, null, 4, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultSuccess(Object result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZplanFaceAdManager.this.s("notifyFaceAdHasShown " + this.f372144e + "  success", false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/ZplanFaceAdManager$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "onResultSuccess", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<Object> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f372146e;

        d(String str) {
            this.f372146e = str;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            ZplanFaceAdManager.r(ZplanFaceAdManager.this, "setFaceAdNoMoreShown - " + this.f372146e + "  onError - " + error + ", " + message, false, null, 4, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultSuccess(Object result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ZplanFaceAdManager.this.s("setFaceAdNoMoreShown - " + this.f372146e + "  success", false);
        }
    }

    public ZplanFaceAdManager(Activity activity, com.tencent.sqshow.zootopia.operation.facead.c cVar) {
        p pVar = new p(activity);
        this.realNativeHandler = pVar;
        com.tencent.sqshow.zootopia.operation.facead.d dVar = new com.tencent.sqshow.zootopia.operation.facead.d();
        this.bodyUpdateHandler = dVar;
        this.faceAdLifeCycleDispatcher = new WeakReference<>(cVar);
        this.adHandlers = new h[]{pVar, dVar};
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        this.repository = new dc4.b(companion.g());
        this.operationRepository = new ja4.a(companion.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B() {
        s("tryTriggerNextFaceAd - " + this.waitingFaceAdList.size(), false);
        if (!this.waitingFaceAdList.isEmpty()) {
            nw4.h remove = this.waitingFaceAdList.remove(0);
            Intrinsics.checkNotNullExpressionValue(remove, "waitingFaceAdList.removeAt(0)");
            int i3 = this.curShowingFaceAdIndex + 1;
            this.curShowingFaceAdIndex = i3;
            boolean o16 = o(i3, remove, this.fragmentManager, this.fragmentContainer, this.sourceCurrent, this.arguments);
            if (!o16) {
                this.curShowingFaceAdIndex--;
                if (!this.waitingFaceAdList.isEmpty()) {
                    r(this, "handleSingle error, try loop next...", false, null, 4, null);
                    o16 = B();
                } else {
                    r(this, "handleSingle error, no next!", false, null, 4, null);
                    m();
                }
            }
            return o16;
        }
        m();
        return false;
    }

    private final nw4.h j(nw4.h originalFaceAdInfo, ZootopiaSource sourceCurrent, int showIndex) {
        boolean contains$default;
        String str = originalFaceAdInfo.f421485d;
        if (!TextUtils.isEmpty(str)) {
            String popupUrl = str + "&external_index=" + showIndex;
            if (sourceCurrent != null) {
                Intrinsics.checkNotNullExpressionValue(popupUrl, "popupUrl");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) popupUrl, (CharSequence) "extarnal_entrance=", false, 2, (Object) null);
                if (!contains$default) {
                    popupUrl = popupUrl + "&extarnal_entrance=" + ah.b(sourceCurrent);
                    originalFaceAdInfo.f421485d = popupUrl;
                }
            }
            r(this, "appendReportParamsToUrl error: " + sourceCurrent + " - " + popupUrl, false, null, 4, null);
            originalFaceAdInfo.f421485d = popupUrl;
        }
        return originalFaceAdInfo;
    }

    private final void m() {
        s("faceAdAllHandled", false);
        com.tencent.sqshow.zootopia.operation.facead.c cVar = this.faceAdLifeCycleDispatcher.get();
        if (cVar != null) {
            cVar.pf();
        }
        this.fragmentManager = null;
        this.fragmentContainer = null;
        this.sourceCurrent = null;
        this.arguments = null;
        this.curShowingFaceAdIndex = -1;
        for (h hVar : this.adHandlers) {
            hVar.q();
        }
    }

    private final void q(String logMsg, boolean isDebugOnly, Throwable th5) {
        if (l(isDebugOnly)) {
            QLog.e("ZplanFaceAdManager", 1, logMsg, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(String logMsg, boolean isDebugOnly) {
        if (l(isDebugOnly)) {
            QLog.i("ZplanFaceAdManager", 1, logMsg);
        }
    }

    private final void x(boolean isPreClicked) {
        s("preFaceAd handled, triggerNext - " + this.fragmentContainer, false);
        ViewGroup viewGroup = this.fragmentContainer;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.operation.facead.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanFaceAdManager.z(ZplanFaceAdManager.this);
                }
            }, isPreClicked ? 400L : 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ZplanFaceAdManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.a
    public void a(com.tencent.sqshow.zootopia.operation.facead.b faceAd) {
        Intrinsics.checkNotNullParameter(faceAd, "faceAd");
        String faceAdId = faceAd.getFaceAdId();
        s("onFaceAdShown - id=" + faceAdId + " - " + faceAd, false);
        this.curShowingFaceAd = faceAd;
        ZplanGuideManager.INSTANCE.a().i(11);
        ja4.a aVar = this.operationRepository;
        if (aVar != null) {
            aVar.j(faceAdId, new c(faceAdId));
        }
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.a
    public void b() {
        r(this, "onFaceAdLoadError ", false, null, 4, null);
        this.curShowingFaceAd = null;
        y(this, false, 1, null);
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.a
    public void c(boolean isClickJump) {
        s("onFaceAdDismiss, isClickJump= " + isClickJump, false);
        this.curShowingFaceAd = null;
        x(isClickJump);
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.a
    public void d(String faceAdId, Long iAdId) {
        Intrinsics.checkNotNullParameter(faceAdId, "faceAdId");
        s("setFaceAdNoMoreShown - " + faceAdId, false);
        if (iAdId != null) {
            long longValue = iAdId.longValue();
            ab4.b bVar = ab4.b.f25786a;
            ab4.b.k(bVar, bVar.d(), String.valueOf(longValue), null, 4, null);
        }
        ja4.a aVar = this.operationRepository;
        if (aVar != null) {
            aVar.k(new d(faceAdId));
        }
        s("setFaceAdNoMoreShown - clear waitingList - " + this.waitingFaceAdList.size(), false);
        this.waitingFaceAdList.clear();
        m();
    }

    public final boolean k() {
        if (!p()) {
            return false;
        }
        com.tencent.sqshow.zootopia.operation.facead.b bVar = this.curShowingFaceAd;
        if (bVar == null) {
            return true;
        }
        bVar.M8();
        return true;
    }

    public final boolean n(ZootopiaFaceAdListData listData, FragmentManager fragmentManager, ViewGroup fragmentContainer, ZootopiaSource sourceCurrent, Bundle arguments) {
        Intrinsics.checkNotNullParameter(listData, "listData");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        s("handleFaceAd: size = " + listData.a().size(), false);
        this.fragmentManager = fragmentManager;
        this.fragmentContainer = fragmentContainer;
        this.sourceCurrent = sourceCurrent;
        this.arguments = arguments;
        this.waitingFaceAdList.clear();
        this.waitingFaceAdList.addAll(listData.a());
        this.curShowingFaceAdIndex = -1;
        if (!ZPlanQQMC.INSTANCE.enablePortalSilverGuide()) {
            QLog.w("ZplanFaceAdManager", 1, "enablePortalSilverGuide false.");
            boolean B = B();
            s("handleFaceAd: ret = " + B, false);
            return B;
        }
        ZPlanSilverGuideDialogController zPlanSilverGuideDialogController = new ZPlanSilverGuideDialogController();
        if (zPlanSilverGuideDialogController.c()) {
            if (zPlanSilverGuideDialogController.g() == SilverGuideType.TYPE_SILVER_SUFFICIENT) {
                A(zPlanSilverGuideDialogController);
                return true;
            }
            this.repository.b(new b(zPlanSilverGuideDialogController));
            return true;
        }
        boolean B2 = B();
        s("handleFaceAd: ret = " + B2, false);
        return B2;
    }

    public final boolean p() {
        return this.curShowingFaceAd != null;
    }

    public final void t(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        for (h hVar : this.adHandlers) {
            hVar.s(newConfig);
        }
    }

    public final void u() {
        s(MosaicConstants$JsFunction.FUNC_ON_DESTROY, false);
        for (h hVar : this.adHandlers) {
            hVar.t();
        }
        m();
    }

    public final void v() {
        for (h hVar : this.adHandlers) {
            hVar.u();
        }
    }

    public final void w() {
        for (h hVar : this.adHandlers) {
            hVar.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(ZPlanSilverGuideDialogController controller) {
        QLog.i("ZplanFaceAdManager", 1, "tryShowSilverGuidePupup");
        controller.k(this.fragmentManager, new ZplanFaceAdManager$tryShowSilverGuidePupUp$1(this));
    }

    private final boolean l(boolean isDebugOnly) {
        return !isDebugOnly || QLog.isColorLevel();
    }

    private final boolean o(int showIndex, nw4.h faceAdInfo, FragmentManager fragmentManager, ViewGroup fragmentContainer, ZootopiaSource sourceCurrent, Bundle arguments) {
        s("handleSingleFaceAd: showIndex= " + showIndex + ", " + faceAdInfo.f421494m + " - " + faceAdInfo.f421483b + ", popupType = " + faceAdInfo.f421484c + " - " + faceAdInfo, false);
        int i3 = faceAdInfo.f421484c;
        if (i3 == 1 || i3 == 2) {
            nw4.h j3 = j(faceAdInfo, sourceCurrent, showIndex);
            if (fragmentManager != null && fragmentContainer != null) {
                try {
                    ZplanFaceAdWebFragment b16 = ZplanFaceAdWebFragment.INSTANCE.b(j3);
                    Bundle arguments2 = b16.getArguments();
                    if (arguments2 != null) {
                        arguments2.putAll(arguments);
                    }
                    b16.Ch(this, fragmentContainer);
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
                    beginTransaction.add(fragmentContainer.getId(), b16);
                    beginTransaction.commitAllowingStateLoss();
                    return true;
                } catch (Exception e16) {
                    q("show fragment error", false, e16);
                }
            }
        } else if (i3 != 3) {
            if (i3 != 999) {
                r(this, "unsupported popup type! - " + i3, false, null, 4, null);
                return false;
            }
            if (fragmentContainer != null) {
                this.bodyUpdateHandler.p(showIndex == 0, faceAdInfo, fragmentContainer, arguments, sourceCurrent, this);
                return true;
            }
        } else if (fragmentContainer != null) {
            this.realNativeHandler.p(showIndex == 0, faceAdInfo, fragmentContainer, arguments, sourceCurrent, this);
            return true;
        }
        return false;
    }

    static /* synthetic */ void r(ZplanFaceAdManager zplanFaceAdManager, String str, boolean z16, Throwable th5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            th5 = null;
        }
        zplanFaceAdManager.q(str, z16, th5);
    }

    static /* synthetic */ void y(ZplanFaceAdManager zplanFaceAdManager, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        zplanFaceAdManager.x(z16);
    }
}
