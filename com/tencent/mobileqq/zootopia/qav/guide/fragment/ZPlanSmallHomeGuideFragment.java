package com.tencent.mobileqq.zootopia.qav.guide.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.utils.ZplanVasSmallHomeUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.portal.detail.ah;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.utils.v;
import fi3.bc;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import pv4.j;
import pv4.k;
import tj3.a;

@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 g2\u00020\u0001:\u0001hB\u0007\u00a2\u0006\u0004\be\u0010fJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J \u0010\"\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020#H\u0002J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020\u000bH\u0002J\u0012\u0010,\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J?\u00106\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00192\u0006\u00100\u001a\u00020/2%\b\u0002\u00105\u001a\u001f\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u000b\u0018\u000101H\u0002J\b\u00108\u001a\u000207H\u0002R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010G\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010BR\u001b\u0010M\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010J\u001a\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010J\u001a\u0004\b\\\u0010]R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00140_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020c0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010a\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/ZPlanSmallHomeGuideFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "needStatusTrans", "needImmersive", "", "getSubSource", "onBackPressedEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", "qi", "hi", "ni", "", "uin", "ci", "ai", "bi", "Landroid/widget/ImageView;", "url", "", "defaultRes", SensorJsPlugin.SENSOR_INTERVAL_UI, "Lcom/tencent/image/URLDrawable;", "ii", "urlDrawable", "mi", "Yh", "ri", "pi", "si", "status", "ti", "finishActivity", IProfileProtocolConst.PARAM_TARGET_UIN, "Lcom/tencent/sqshow/zootopia/data/m;", "detail", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "code", "callback", "gi", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "fi", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "N", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "transitPageInfo", "Lfi3/bc;", "P", "Lfi3/bc;", "binding", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "enterSmallHomeSuccess", BdhLogUtil.LogTag.Tag_Req, "hasExposureReport", ExifInterface.LATITUDE_SOUTH, "hasStartDownload", "Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "T", "Lkotlin/Lazy;", "ki", "()Lcom/tencent/mobileqq/zootopia/portal/detail/ah;", "reportHelper", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "U", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "mDecoder", "V", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Ldd3/a;", "W", "li", "()Ldd3/a;", "vm", "Loa4/a;", "X", WidgetCacheLunarData.JI, "()Loa4/a;", "mapResVm", "Landroidx/lifecycle/Observer;", "Y", "Landroidx/lifecycle/Observer;", "statusObserver", "", "progressObserver", "<init>", "()V", "a0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanSmallHomeGuideFragment extends ZootopiaBaseFragment {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: N, reason: from kotlin metadata */
    private TransitPageInfo transitPageInfo;

    /* renamed from: P, reason: from kotlin metadata */
    private bc binding;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean enterSmallHomeSuccess;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean hasExposureReport;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean hasStartDownload;

    /* renamed from: T, reason: from kotlin metadata */
    private final Lazy reportHelper;

    /* renamed from: U, reason: from kotlin metadata */
    private IFaceDecoder mDecoder;

    /* renamed from: V, reason: from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: X, reason: from kotlin metadata */
    private final Lazy mapResVm;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Observer<ButtonStatus> statusObserver;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Observer<Float> progressObserver;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/ZPlanSmallHomeGuideFragment$a;", "", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zootopia/qav/guide/fragment/ZPlanSmallHomeGuideFragment;", "a", "", "BG_URL", "Ljava/lang/String;", "", "ENTER_FAILED", "I", "ENTER_SUCCESS", "IMG_URL", "MAP_ID", "SMALL_HOME_NAME", "SOURCE", "TAG", "TRANSIT_PAGE_INFO", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ZPlanSmallHomeGuideFragment a(TransitPageInfo info, ZootopiaSource source) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(source, "source");
            ZPlanSmallHomeGuideFragment zPlanSmallHomeGuideFragment = new ZPlanSmallHomeGuideFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tansit_page_info", info);
            bundle.putSerializable("source", source);
            zPlanSmallHomeGuideFragment.setArguments(bundle);
            return zPlanSmallHomeGuideFragment;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/qav/guide/fragment/ZPlanSmallHomeGuideFragment$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable urlDrawable, Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            ZPlanSmallHomeGuideFragment.this.mi(urlDrawable);
        }
    }

    public ZPlanSmallHomeGuideFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ah>() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideFragment$reportHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ah invoke() {
                Context requireContext = ZPlanSmallHomeGuideFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new ah(requireContext);
            }
        });
        this.reportHelper = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<dd3.a>() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideFragment$vm$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/qav/guide/fragment/ZPlanSmallHomeGuideFragment$vm$2$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements ViewModelProvider.Factory {
                a() {
                }

                @Override // androidx.lifecycle.ViewModelProvider.Factory
                public <T extends ViewModel> T create(Class<T> modelClass) {
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    return new dd3.a(new cd3.a());
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final dd3.a invoke() {
                ViewModel viewModel = h.b(ZPlanSmallHomeGuideFragment.this, new a()).get(dd3.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026ideViewModel::class.java)");
                return (dd3.a) viewModel;
            }
        });
        this.vm = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<oa4.a>() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideFragment$mapResVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oa4.a invoke() {
                ViewModel viewModel = h.a(ZPlanSmallHomeGuideFragment.this.requireActivity()).get(oa4.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(requ\u2026ResViewModel::class.java)");
                return (oa4.a) viewModel;
            }
        });
        this.mapResVm = lazy3;
        this.statusObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanSmallHomeGuideFragment.vi(ZPlanSmallHomeGuideFragment.this, (ButtonStatus) obj);
            }
        };
        this.progressObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanSmallHomeGuideFragment.oi(ZPlanSmallHomeGuideFragment.this, (Float) obj);
            }
        };
    }

    private final void Yh(final long uin) {
        final bc bcVar = this.binding;
        if (bcVar == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (appInterface != null) {
            booleanRef.element = uin == appInterface.getLongAccountUin();
        }
        bcVar.f399056b.setButtonType(ZootopiaDownloadBarType.SMALL_HOME_TRANSIT_PAGE_BAR);
        li().L1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZPlanSmallHomeGuideFragment.Zh(bc.this, this, uin, booleanRef, (ZootopiaMapDetail) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(bc binding, final ZPlanSmallHomeGuideFragment this$0, final long j3, Ref.BooleanRef isEnterSelfSmallHome, final ZootopiaMapDetail zootopiaMapDetail) {
        ExtInfo extInfo;
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(isEnterSelfSmallHome, "$isEnterSelfSmallHome");
        if (zootopiaMapDetail != null) {
            final ZootopiaDownloadButton zootopiaDownloadButton = binding.f399056b;
            zootopiaDownloadButton.setNormalBackgroundDrwable(new ColorDrawable(Color.parseColor("#0099ff")));
            zootopiaDownloadButton.setProgressDrawable(ContextCompat.getDrawable(zootopiaDownloadButton.getContext(), R.drawable.i3b));
            final int id5 = zootopiaMapDetail.getId();
            final ZootopiaSource fi5 = this$0.fi();
            k33.a aVar = k33.a.f411513a;
            TransitPageInfo transitPageInfo = this$0.transitPageInfo;
            final Map<String, Object> a16 = aVar.a((transitPageInfo == null || (extInfo = transitPageInfo.getExtInfo()) == null) ? null : extInfo.getUeExtras(), String.valueOf(j3));
            zootopiaDownloadButton.setButtonStatusListener(new CloudModClickListener(id5, fi5, a16) { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideFragment$bindDownloadButton$2$1$1

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes35.dex */
                public /* synthetic */ class a {

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f329011a;

                    static {
                        int[] iArr = new int[ButtonStatus.values().length];
                        try {
                            iArr[ButtonStatus.LOADED.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[ButtonStatus.INIT.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[ButtonStatus.PAUSE.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[ButtonStatus.UPDATE.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        try {
                            iArr[ButtonStatus.LOADING.ordinal()] = 5;
                        } catch (NoSuchFieldError unused5) {
                        }
                        try {
                            iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 6;
                        } catch (NoSuchFieldError unused6) {
                        }
                        try {
                            iArr[ButtonStatus.CAN_APPOINTMENT.ordinal()] = 7;
                        } catch (NoSuchFieldError unused7) {
                        }
                        try {
                            iArr[ButtonStatus.APPOINTED.ordinal()] = 8;
                        } catch (NoSuchFieldError unused8) {
                        }
                        try {
                            iArr[ButtonStatus.ONLY_DOWNLOAD.ordinal()] = 9;
                        } catch (NoSuchFieldError unused9) {
                        }
                        f329011a = iArr;
                    }
                }

                @Override // com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener
                public void b(View view, ButtonStatus buttonStatus) {
                    oa4.a ji5;
                    oa4.a ji6;
                    k[] kVarArr;
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(buttonStatus, "buttonStatus");
                    int i3 = 0;
                    k kVar = null;
                    switch (a.f329011a[buttonStatus.ordinal()]) {
                        case 1:
                            ZPlanSmallHomeGuideFragment.this.ri();
                            ZPlanSmallHomeGuideFragment zPlanSmallHomeGuideFragment = ZPlanSmallHomeGuideFragment.this;
                            long j16 = j3;
                            ZootopiaMapDetail info = zootopiaMapDetail;
                            Intrinsics.checkNotNullExpressionValue(info, "info");
                            final ZPlanSmallHomeGuideFragment zPlanSmallHomeGuideFragment2 = ZPlanSmallHomeGuideFragment.this;
                            zPlanSmallHomeGuideFragment.gi(j16, info, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideFragment$bindDownloadButton$2$1$1$onModButtonClick$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                                    invoke(num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i16) {
                                    boolean z16;
                                    ZPlanSmallHomeGuideFragment.this.enterSmallHomeSuccess = i16 == 0;
                                    z16 = ZPlanSmallHomeGuideFragment.this.enterSmallHomeSuccess;
                                    if (z16) {
                                        ZPlanSmallHomeGuideFragment.this.si();
                                    }
                                    ZPlanSmallHomeGuideFragment.this.hi();
                                }
                            });
                            return;
                        case 2:
                        case 3:
                        case 4:
                            ji5 = ZPlanSmallHomeGuideFragment.this.ji();
                            ZootopiaMapDetail info2 = zootopiaMapDetail;
                            Intrinsics.checkNotNullExpressionValue(info2, "info");
                            oa4.a.W1(ji5, info2, false, 2, null);
                            ZPlanSmallHomeGuideFragment.this.hasStartDownload = true;
                            ZPlanSmallHomeGuideFragment.this.pi();
                            return;
                        case 5:
                            ji6 = ZPlanSmallHomeGuideFragment.this.ji();
                            ji6.R1(String.valueOf(zootopiaMapDetail.getId()));
                            return;
                        case 6:
                            com.tencent.mobileqq.zootopia.utils.k kVar2 = new com.tencent.mobileqq.zootopia.utils.k();
                            Context requireContext = ZPlanSmallHomeGuideFragment.this.requireContext();
                            Activity activity = requireContext instanceof Activity ? (Activity) requireContext : null;
                            if (activity != null) {
                                com.tencent.mobileqq.zootopia.utils.k.e(kVar2, activity, null, 2, null);
                                return;
                            }
                            return;
                        case 7:
                            j reserveItem = zootopiaMapDetail.getReserveItem();
                            if (reserveItem != null) {
                                a.C11293a.b((tj3.a) vb3.a.f441346a.a(tj3.a.class), reserveItem, false, null, 6, null);
                                return;
                            }
                            return;
                        case 8:
                            j reserveItem2 = zootopiaMapDetail.getReserveItem();
                            if (reserveItem2 != null) {
                                tj3.a aVar2 = (tj3.a) vb3.a.f441346a.a(tj3.a.class);
                                String str = reserveItem2.f427619b;
                                Intrinsics.checkNotNullExpressionValue(str, "it.id");
                                j o16 = aVar2.o(str, reserveItem2.f427618a);
                                if (o16 == null || (kVarArr = o16.f427623f) == null) {
                                    return;
                                }
                                int length = kVarArr.length;
                                while (true) {
                                    if (i3 < length) {
                                        k findConfig = kVarArr[i3];
                                        Intrinsics.checkNotNullExpressionValue(findConfig, "findConfig");
                                        if (com.tencent.mobileqq.zootopia.utils.g.j(findConfig)) {
                                            kVar = findConfig;
                                        } else {
                                            i3++;
                                        }
                                    }
                                }
                                if (kVar == null || kVar.f427628d) {
                                    return;
                                }
                                ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).E0(reserveItem2);
                                return;
                            }
                            return;
                        case 9:
                            String beforeOnlineToast = zootopiaMapDetail.getBeforeOnlineToast();
                            if (beforeOnlineToast != null) {
                                QQToast.makeText(zootopiaDownloadButton.getContext(), beforeOnlineToast, 0).show();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
            zootopiaDownloadButton.setDownloadSize(zootopiaMapDetail);
            ButtonStatus buttonStatus = ButtonStatus.LOADED;
            zootopiaDownloadButton.setStatusText(buttonStatus, zootopiaMapDetail.getButtonText());
            if (isEnterSelfSmallHome.element) {
                zootopiaDownloadButton.setStatusText(ButtonStatus.INIT, zootopiaDownloadButton.getContext().getString(R.string.xvg));
            } else {
                zootopiaDownloadButton.setStatusText(buttonStatus, zootopiaDownloadButton.getContext().getString(R.string.xvf));
            }
            this$0.ji().M1("200001");
            LiveData<ButtonStatus> P1 = this$0.ji().P1("200001");
            if (P1 != null) {
                P1.removeObserver(this$0.statusObserver);
                P1.observe(this$0.getViewLifecycleOwner(), this$0.statusObserver);
            }
            LiveData<Float> O1 = this$0.ji().O1("200001");
            if (O1 != null) {
                O1.removeObserver(this$0.progressObserver);
                O1.observe(this$0.getViewLifecycleOwner(), this$0.progressObserver);
            }
        }
    }

    private final void ai() {
        bc bcVar = this.binding;
        if (bcVar == null) {
            return;
        }
        ImageView imageView = bcVar.f399057c;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.zplanGuideBackground");
        ui(imageView, "https://static-res.qq.com/static-res/yinshipin/xiaowo/av_smallhome_bg@2x.png", R.drawable.iik);
    }

    private final void bi() {
        bc bcVar = this.binding;
        if (bcVar == null) {
            return;
        }
        bcVar.f399059e.setImageDrawable(ii(" https://static-res.qq.com/static-res/yinshipin/xiaowo/av_smallhome_avatar.png"));
    }

    private final void ci(final long uin) {
        final bc bcVar = this.binding;
        if (bcVar == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        if (String.valueOf(uin).equals(appInterface.getCurrentUin())) {
            bcVar.f399060f.setText(getString(R.string.xvh));
            return;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IFriendNameService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        final IFriendNameService iFriendNameService = (IFriendNameService) runtimeService;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSmallHomeGuideFragment.di(IFriendNameService.this, uin, bcVar, this);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(IFriendNameService friendService, long j3, final bc binding, final ZPlanSmallHomeGuideFragment this$0) {
        Intrinsics.checkNotNullParameter(friendService, "$friendService");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final String friendName = friendService.getFriendName(String.valueOf(j3));
        if (QLog.isColorLevel()) {
            QLog.i("ZPlanSmallHomeGuideFragment", 2, "uin: " + j3 + " name is " + friendName);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSmallHomeGuideFragment.ei(bc.this, this$0, friendName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(bc binding, ZPlanSmallHomeGuideFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = binding.f399060f;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this$0.getString(R.string.xvi);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.zplan_small_home_friend_invite)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZootopiaSource fi() {
        String subSource = Ch().getSubSource();
        if (Intrinsics.areEqual(subSource, ZootopiaSource.SUB_SOURCE_QAV_GROUP_AUTO)) {
            return ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.QavEntrance, ZootopiaSource.SUB_SOURCE_QAV_GROUP_MID, null, 4, null);
        }
        if (Intrinsics.areEqual(subSource, ZootopiaSource.SUB_SOURCE_QAV_C2C_AUTO)) {
            return ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.QavEntrance, ZootopiaSource.SUB_SOURCE_QAV_C2C_MID, null, 4, null);
        }
        return Ch();
    }

    private final void finishActivity() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi(final long targetUin, final ZootopiaMapDetail detail, final Function1<? super Integer, Unit> callback) {
        QLog.i("ZPlanSmallHomeGuideFragment", 1, "enterResidence: targetUin " + targetUin);
        ZplanVasSmallHomeUtils zplanVasSmallHomeUtils = ZplanVasSmallHomeUtils.f311238a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        zplanVasSmallHomeUtils.d(requireContext, String.valueOf(targetUin), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideFragment$enterResidence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                ZootopiaSource fi5;
                TransitPageInfo transitPageInfo;
                ExtInfo extInfo;
                if (!z16) {
                    si3.c cVar = (si3.c) vb3.a.f441346a.a(si3.c.class);
                    int id5 = ZootopiaMapDetail.this.getId();
                    fi5 = this.fi();
                    k33.a aVar = k33.a.f411513a;
                    transitPageInfo = this.transitPageInfo;
                    Map<String, Object> a16 = aVar.a((transitPageInfo == null || (extInfo = transitPageInfo.getExtInfo()) == null) ? null : extInfo.getUeExtras(), String.valueOf(targetUin));
                    final Function1<Integer, Unit> function1 = callback;
                    cVar.u(id5, fi5, a16, new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.qav.guide.fragment.ZPlanSmallHomeGuideFragment$enterResidence$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                            invoke2(enterModCheckResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(EnterModCheckResult result) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            Function1<Integer, Unit> function12 = function1;
                            if (function12 != null) {
                                function12.invoke(Integer.valueOf(result.getResultCode()));
                            }
                        }
                    });
                    return;
                }
                Function1<Integer, Unit> function12 = callback;
                if (function12 != null) {
                    function12.invoke(-1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi() {
        try {
            Fragment parentFragment = getParentFragment();
            DialogFragment dialogFragment = parentFragment instanceof DialogFragment ? (DialogFragment) parentFragment : null;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            } else {
                getParentFragmentManager().beginTransaction().remove(this).commit();
            }
        } catch (Throwable th5) {
            QLog.e("ZPlanSmallHomeGuideFragment", 1, "finishSelf err.", th5);
        }
    }

    private final URLDrawable ii(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int dpToPx = ViewUtils.dpToPx(240.0f);
        int dpToPx2 = ViewUtils.dpToPx(200.0f);
        obtain.mRequestWidth = dpToPx;
        obtain.mRequestHeight = dpToPx2;
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mUseApngImage = true;
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", 0);
        obtain.mExtraInfo = bundle;
        obtain.mPlayGifImage = true;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        drawable.setURLDrawableListener(new b());
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final oa4.a ji() {
        return (oa4.a) this.mapResVm.getValue();
    }

    private final ah ki() {
        return (ah) this.reportHelper.getValue();
    }

    private final dd3.a li() {
        return (dd3.a) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi(URLDrawable urlDrawable) {
        Drawable currDrawable = urlDrawable.getCurrDrawable();
        if (currDrawable instanceof ApngDrawable) {
            QLog.d("ZPlanSmallHomeGuideFragment", 1, "initApngDrawable success");
            ((ApngDrawable) currDrawable).getImage().setSupportGlobalPasued(false);
        }
    }

    private final String ni(View view) {
        String uin;
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("tansit_page_info") : null;
        TransitPageInfo transitPageInfo = serializable instanceof TransitPageInfo ? (TransitPageInfo) serializable : null;
        if (transitPageInfo == null) {
            return "transitPageInfo";
        }
        this.transitPageInfo = transitPageInfo;
        MasterInfo masterInfo = transitPageInfo.getMasterInfo();
        long parseLong = (masterInfo == null || (uin = masterInfo.getUin()) == null) ? 0L : Long.parseLong(uin);
        if (parseLong <= 0) {
            return "uin";
        }
        Bundle arguments2 = getArguments();
        Serializable serializable2 = arguments2 != null ? arguments2.getSerializable("source") : null;
        Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.ZootopiaSource");
        this.source = (ZootopiaSource) serializable2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return "app";
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        Intrinsics.checkNotNullExpressionValue(iQQAvatarService, "app.getRuntimeService(IQ\u2026        .getInstance(app)");
        this.mDecoder = iQQAvatarService;
        li().N1(parseLong);
        li().O1();
        ci(parseLong);
        ai();
        bi();
        Yh(parseLong);
        ah ki5 = ki();
        ah.f(ki5, view, AdMetricID.Click.SUCCESS, "QQ\u5c0f\u7a9d", this.source, null, 16, null);
        bc bcVar = this.binding;
        ah.c(ki5, bcVar != null ? bcVar.f399056b : null, false, false, 6, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(ZPlanSmallHomeGuideFragment this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bc bcVar = this$0.binding;
        if (bcVar == null) {
            return;
        }
        ZootopiaDownloadButton zootopiaDownloadButton = bcVar.f399056b;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zootopiaDownloadButton.setProcess(it.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi() {
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource == null || zootopiaSource.getMainSource() != Source.QavEntrance) {
            return;
        }
        if (Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) || Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_GROUP_RIGHT)) {
            ReportController.o(null, "dc00898", "", "", "0X800C257", "0X800C257", Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) ? 1 : 2, 0, "", "", "", "");
        }
    }

    private final void qi(ButtonStatus buttonStatus) {
        ZootopiaSource zootopiaSource;
        if (this.hasStartDownload && buttonStatus == ButtonStatus.LOADED && (zootopiaSource = this.source) != null && zootopiaSource.getMainSource() == Source.QavEntrance) {
            if (Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) || Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_GROUP_RIGHT)) {
                ReportController.o(null, "dc00898", "", "", "0X800C25A", "0X800C25A", Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) ? 1 : 2, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ri() {
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource == null || zootopiaSource.getMainSource() != Source.QavEntrance) {
            return;
        }
        if (Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) || Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_GROUP_RIGHT)) {
            ReportController.o(null, "dc00898", "", "", "0X800C25C", "0X800C25C", Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) ? 1 : 2, 0, "", "", "", "");
        }
    }

    private final void ui(ImageView view, String url, int defaultRes) {
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = view.getWidth();
            obtain.mRequestHeight = view.getHeight();
            obtain.mFailedDrawable = q.b(defaultRes);
            obtain.mLoadingDrawable = q.b(defaultRes);
            view.setImageDrawable(URLDrawable.getDrawable(url, obtain));
        } catch (Throwable th5) {
            QLog.e("ZPlanSmallHomeGuideFragment", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(ZPlanSmallHomeGuideFragment this$0, ButtonStatus it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bc bcVar = this$0.binding;
        if (bcVar == null) {
            return;
        }
        ZootopiaDownloadButton zootopiaDownloadButton = bcVar.f399056b;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zootopiaDownloadButton.setStatus(it);
        this$0.ti(it);
        this$0.qi(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_GROUP_TRANSIT;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        bc g16 = bc.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (!this.enterSmallHomeSuccess) {
            bb.f335811a.t(false, getActivity());
        }
        finishActivity();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String ni5 = ni(view);
        if (ni5 != null) {
            v.f373305a.c(R.string.xhl, ni5);
            hi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si() {
        String str;
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource == null || zootopiaSource.getMainSource() != Source.QavEntrance) {
            return;
        }
        if (!Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) && !Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_GROUP_RIGHT)) {
            int i3 = (Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_MID) || Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_AUTO)) ? 1 : 2;
            if (this.hasStartDownload) {
                str = "2";
            } else {
                str = "1";
            }
            ReportController.o(null, "dc00898", "", "", "0X800C268", "0X800C268", i3, 0, str, "", "", "");
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C25E", "0X800C25E", Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) ? 1 : 2, 0, "", "", "", "");
    }

    private final void ti(ButtonStatus status) {
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource == null || zootopiaSource.getMainSource() != Source.QavEntrance || this.hasExposureReport) {
            return;
        }
        if ((Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) || Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_GROUP_RIGHT)) && (status == ButtonStatus.INIT || status == ButtonStatus.PAUSE || status == ButtonStatus.UPDATE)) {
            ReportController.o(null, "dc00898", "", "", "0X800C255", "0X800C255", Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_RIGHT) ? 1 : 2, 0, "", "", "", "");
            this.hasExposureReport = true;
        }
        if (Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_AUTO) || Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_GROUP_AUTO)) {
            if (status != ButtonStatus.INIT && status != ButtonStatus.PAUSE && status != ButtonStatus.UPDATE) {
                ReportController.o(null, "dc00898", "", "", "0X800C262", "0X800C262", Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_AUTO) ? 1 : 2, 0, "", "", "1", "");
                this.hasExposureReport = true;
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800C262", "0X800C262", Intrinsics.areEqual(zootopiaSource.getSubSource(), ZootopiaSource.SUB_SOURCE_QAV_C2C_AUTO) ? 1 : 2, 0, "", "", "2", "");
                this.hasExposureReport = true;
            }
        }
    }
}
