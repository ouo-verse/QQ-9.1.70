package com.tencent.sqshow.zootopia.samestyle.mix;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.lua.ZPlanSameStyleProgress;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.fragment.ZPlanPublicBaseFragment;
import com.tencent.sqshow.zootopia.samestyle.TemplatePreviewViewModel;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import com.tencent.sqshow.zootopia.samestyle.mix.ZPlanTemplateMixPreviewPage;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.PreviewVideoPlayHelper;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.c;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.i;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.j;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.k;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.l;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.t;
import com.tencent.sqshow.zootopia.samestyle.mix.helper.u;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.world.model.FirstFrameResult;
import id3.d;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import n74.dh;
import sb4.a;
import tb4.StageProgress;
import tb4.StageProgressConfig;
import tb4.e;

@Metadata(d1 = {"\u0000\u00ea\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001}B\u0007\u00a2\u0006\u0004\bz\u0010{J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J$\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J&\u00102\u001a\u00020\u00052\u0006\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020.2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u0010(\u001a\u000203H\u0016J\u0010\u00105\u001a\u00020\u00052\u0006\u0010(\u001a\u000203H\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u0010(\u001a\u000203H\u0016J\u0010\u00107\u001a\u00020\u00052\u0006\u0010(\u001a\u000203H\u0016J\u0010\u0010:\u001a\u00020\u00052\u0006\u00109\u001a\u000208H\u0016J\b\u0010<\u001a\u00020;H\u0014R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010m\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020s0r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010y\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010x\u00a8\u0006~"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/mix/ZPlanTemplateMixPreviewPage;", "Lcom/tencent/sqshow/fragment/ZPlanPublicBaseFragment;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/u;", "Ltb4/e;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/t;", "", "initData", "initView", "Mh", "", "getPageId", "Ih", "Oh", "Nh", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Fh", "Kh", "Yh", "Gh", "Xh", "Hh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "progress", "Fg", "path", "sf", "I5", "fakeProgress", "Ltb4/c;", "", "Ltb4/d;", "totalStageConfig", "e8", "Lcom/tencent/mobileqq/zootopia/lua/x;", "X1", "fg", "ef", "o9", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "", "rh", "Ln74/dh;", UserInfo.SEX_FEMALE, "Ln74/dh;", "mBinding", "Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", "G", "Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", "mViewModel", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "H", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "mTemplate", "", "I", "J", "mTemplateTabId", "Z", "mIsAutoPublish", "K", "Ljava/lang/String;", "mPublishBackScheme", "Lid3/d;", "L", "Lid3/d;", "mReporter", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "M", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "mSource", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/PreviewVideoPlayHelper;", "N", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/PreviewVideoPlayHelper;", "mVideoPreviewHelper", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/k;", "P", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/k;", "mImagePreviewHelper", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/c;", "mARTemplateHelper", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/i;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/i;", "mEngineHelper", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/e;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/e;", "mNormalDownloadHelper", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/l;", "T", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/l;", "mProgressMakeHelper", "Ljava/util/LinkedList;", "Lcom/tencent/sqshow/zootopia/samestyle/mix/helper/d;", "U", "Ljava/util/LinkedList;", "mHelperPool", "V", "Lcom/tencent/mobileqq/zootopia/lua/x;", "mMixResult", "<init>", "()V", "W", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTemplateMixPreviewPage extends ZPlanPublicBaseFragment implements u, e, t {

    /* renamed from: F, reason: from kotlin metadata */
    private dh mBinding;

    /* renamed from: G, reason: from kotlin metadata */
    private TemplatePreviewViewModel mViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private long mTemplateTabId;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsAutoPublish;

    /* renamed from: N, reason: from kotlin metadata */
    private PreviewVideoPlayHelper mVideoPreviewHelper;

    /* renamed from: P, reason: from kotlin metadata */
    private k mImagePreviewHelper;

    /* renamed from: Q, reason: from kotlin metadata */
    private c mARTemplateHelper;

    /* renamed from: R, reason: from kotlin metadata */
    private i mEngineHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.samestyle.mix.helper.e mNormalDownloadHelper;

    /* renamed from: T, reason: from kotlin metadata */
    private l mProgressMakeHelper;

    /* renamed from: V, reason: from kotlin metadata */
    private ZPlanSameStyleProgress mMixResult;

    /* renamed from: H, reason: from kotlin metadata */
    private ZPlanTemplate mTemplate = new ZPlanTemplate(0, null, null, null, null, 0, false, 0, null, null, null, 0, null, false, null, null, false, 131071, null);

    /* renamed from: K, reason: from kotlin metadata */
    private String mPublishBackScheme = "";

    /* renamed from: L, reason: from kotlin metadata */
    private final d mReporter = new d(null, 1, null);

    /* renamed from: M, reason: from kotlin metadata */
    private ZootopiaSource mSource = ZootopiaSource.INSTANCE.a(Source.UnSet);

    /* renamed from: U, reason: from kotlin metadata */
    private final LinkedList<com.tencent.sqshow.zootopia.samestyle.mix.helper.d> mHelperPool = new LinkedList<>();

    @Metadata(d1 = {"\u0000G\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/sqshow/zootopia/samestyle/mix/ZPlanTemplateMixPreviewPage$b", "Lsb4/a;", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "getTemplate", "Ln74/dh;", "c", "Lcom/tencent/sqshow/zootopia/samestyle/TemplatePreviewViewModel;", "J", "Landroid/content/Context;", "getContext", "Lid3/d;", "b", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "Landroid/app/Activity;", "getActivity", "Landroid/os/Bundle;", "getArguments", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZPlanTemplate f372926a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ dh f372927b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TemplatePreviewViewModel f372928c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f372929d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanTemplateMixPreviewPage f372930e;

        b(ZPlanTemplate zPlanTemplate, dh dhVar, TemplatePreviewViewModel templatePreviewViewModel, Context context, ZPlanTemplateMixPreviewPage zPlanTemplateMixPreviewPage) {
            this.f372926a = zPlanTemplate;
            this.f372927b = dhVar;
            this.f372928c = templatePreviewViewModel;
            this.f372929d = context;
            this.f372930e = zPlanTemplateMixPreviewPage;
        }

        @Override // sb4.a
        /* renamed from: J, reason: from getter */
        public TemplatePreviewViewModel getF372928c() {
            return this.f372928c;
        }

        @Override // sb4.a
        public long a() {
            return this.f372930e.mTemplateTabId;
        }

        @Override // sb4.a
        public d b() {
            return this.f372930e.mReporter;
        }

        @Override // sb4.a
        /* renamed from: c, reason: from getter */
        public dh getF372927b() {
            return this.f372927b;
        }

        @Override // sb4.a
        public Activity getActivity() {
            return this.f372930e.getActivity();
        }

        @Override // sb4.a
        public Bundle getArguments() {
            return this.f372930e.getArguments();
        }

        @Override // sb4.a
        /* renamed from: getContext, reason: from getter */
        public Context getF372929d() {
            return this.f372929d;
        }

        @Override // sb4.a
        public LifecycleOwner getLifecycleOwner() {
            LifecycleOwner viewLifecycleOwner = this.f372930e.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            return viewLifecycleOwner;
        }

        @Override // sb4.a
        public ZootopiaSource getSource() {
            return this.f372930e.mSource;
        }

        @Override // sb4.a
        /* renamed from: getTemplate, reason: from getter */
        public ZPlanTemplate getF372926a() {
            return this.f372926a;
        }
    }

    private final HashMap<String, Object> Fh() {
        return com.tencent.sqshow.zootopia.samestyle.b.f372897a.c(null, Integer.valueOf(this.mIsAutoPublish ? 7 : 3), this.mIsAutoPublish, this.mTemplate.getId(), this.mTemplate.getContentType(), this.mPublishBackScheme);
    }

    private final void Gh() {
        dh dhVar = this.mBinding;
        LinearLayout linearLayout = dhVar != null ? dhVar.f419253h : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        dh dhVar2 = this.mBinding;
        TextView textView = dhVar2 != null ? dhVar2.f419249d : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    private final void Hh() {
        dh dhVar = this.mBinding;
        FrameLayout frameLayout = dhVar != null ? dhVar.f419259n : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        PreviewVideoPlayHelper previewVideoPlayHelper = this.mVideoPreviewHelper;
        if (previewVideoPlayHelper != null) {
            previewVideoPlayHelper.v();
        }
    }

    private final void Ih() {
        final dh dhVar = this.mBinding;
        if (dhVar == null) {
            return;
        }
        dhVar.f419247b.setOnClickListener(new View.OnClickListener() { // from class: sb4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanTemplateMixPreviewPage.Jh(ZPlanTemplateMixPreviewPage.this, dhVar, view);
            }
        });
        d dVar = this.mReporter;
        ImageView imageView = dhVar.f419247b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backIgv");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(this.mTemplate.getId()));
        linkedHashMap.put("zplan_samestyle_type", Integer.valueOf(this.mTemplate.getContentType()));
        Unit unit = Unit.INSTANCE;
        d.h(dVar, imageView, "em_zplan_back_btn", linkedHashMap, false, true, null, 40, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(ZPlanTemplateMixPreviewPage this$0, dh binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        QLog.i("ZPlanTemplateMixPreviewPage_", 1, "click back Button");
        PreviewVideoPlayHelper previewVideoPlayHelper = this$0.mVideoPreviewHelper;
        if (previewVideoPlayHelper != null) {
            previewVideoPlayHelper.F();
        }
        this$0.requireActivity().onBackPressed();
        d dVar = this$0.mReporter;
        ImageView imageView = binding.f419247b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backIgv");
        dVar.c("dt_clck", imageView, new LinkedHashMap());
    }

    private final void Kh() {
        final dh dhVar = this.mBinding;
        if (dhVar == null) {
            return;
        }
        dhVar.f419249d.setOnClickListener(new View.OnClickListener() { // from class: sb4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanTemplateMixPreviewPage.Lh(ZPlanTemplateMixPreviewPage.this, dhVar, view);
            }
        });
        d dVar = this.mReporter;
        TextView textView = dhVar.f419249d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.beginCreateTxv");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(QCircleScheme.AttrQQPublish.ZPLAN_SAMESTYLE_ID, Integer.valueOf(this.mTemplate.getId()));
        linkedHashMap.put("zplan_samestyle_type", Integer.valueOf(this.mTemplate.getContentType()));
        Unit unit = Unit.INSTANCE;
        d.h(dVar, textView, "em_zplan_samestyle_create", linkedHashMap, false, true, null, 40, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(ZPlanTemplateMixPreviewPage this$0, dh binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        QLog.i("ZPlanTemplateMixPreviewPage_", 1, "beginCreateTxv clicked!");
        this$0.Gh();
        if (this$0.mTemplate.isAR()) {
            c cVar = this$0.mARTemplateHelper;
            if (cVar != null) {
                cVar.s(this$0.mIsAutoPublish ? 5 : 1);
            }
        } else {
            ZPlanSameStyleProgress zPlanSameStyleProgress = this$0.mMixResult;
            if (zPlanSameStyleProgress != null) {
                ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).doShare(null, zPlanSameStyleProgress.d(), this$0.Fh());
                return;
            }
            i iVar = this$0.mEngineHelper;
            if (iVar != null) {
                iVar.r();
            }
            com.tencent.sqshow.zootopia.samestyle.mix.helper.e eVar = this$0.mNormalDownloadHelper;
            if (eVar != null) {
                eVar.p();
            }
            com.tencent.sqshow.zootopia.samestyle.mix.helper.e eVar2 = this$0.mNormalDownloadHelper;
            if (eVar2 != null) {
                eVar2.r();
            }
            com.tencent.sqshow.zootopia.samestyle.mix.helper.e eVar3 = this$0.mNormalDownloadHelper;
            if (eVar3 != null) {
                eVar3.o();
            }
            ZPlanTemplate.INSTANCE.b(this$0.mTemplate);
            this$0.Yh();
        }
        d dVar = this$0.mReporter;
        TextView textView = binding.f419249d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.beginCreateTxv");
        dVar.c("dt_clck", textView, new LinkedHashMap());
    }

    private final void Mh() {
        TemplatePreviewViewModel templatePreviewViewModel;
        Context context;
        Map<String, Object> mutableMapOf;
        ZPlanTemplate zPlanTemplate = this.mTemplate;
        dh dhVar = this.mBinding;
        if (dhVar == null || (templatePreviewViewModel = this.mViewModel) == null || (context = getContext()) == null) {
            return;
        }
        b bVar = new b(zPlanTemplate, dhVar, templatePreviewViewModel, context, this);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(this.mSource)), new Pair(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, Integer.valueOf(zPlanTemplate.getId())));
        d dVar = this.mReporter;
        ConstraintLayout root = dhVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        dVar.j(this, root, getPageId(), mutableMapOf);
        j jVar = new j(bVar);
        PreviewVideoPlayHelper f16 = jVar.f();
        this.mHelperPool.add(f16);
        this.mVideoPreviewHelper = f16;
        k e16 = jVar.e();
        this.mHelperPool.add(e16);
        this.mImagePreviewHelper = e16;
        c a16 = jVar.a();
        this.mHelperPool.add(a16);
        this.mARTemplateHelper = a16;
        i d16 = jVar.d();
        this.mHelperPool.add(d16);
        this.mEngineHelper = d16;
        l b16 = jVar.b();
        this.mHelperPool.add(b16);
        this.mProgressMakeHelper = b16;
        if (b16 != null) {
            b16.n(this);
        }
        com.tencent.sqshow.zootopia.samestyle.mix.helper.e c16 = jVar.c();
        this.mHelperPool.add(c16);
        this.mNormalDownloadHelper = c16;
        if (c16 != null) {
            c16.x(this);
        }
        i iVar = this.mEngineHelper;
        if (iVar == null) {
            return;
        }
        iVar.F(this);
    }

    private final void Nh() {
        dh dhVar = this.mBinding;
        if (dhVar == null) {
            return;
        }
        QLog.i("ZPlanTemplateMixPreviewPage_", 1, "template length = " + this.mTemplate.getLength());
        if (this.mTemplate.isAR()) {
            dhVar.f419263r.setVisibility(8);
        } else {
            dhVar.f419263r.setVisibility(0);
            dhVar.f419263r.setText(this.mTemplate.getDesc());
        }
        dhVar.f419264s.setText(this.mTemplate.getDisplayName());
    }

    private final void Oh() {
        dh dhVar = this.mBinding;
        if (dhVar == null) {
            return;
        }
        dhVar.f419260o.setOnClickListener(new View.OnClickListener() { // from class: sb4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanTemplateMixPreviewPage.Ph(view);
            }
        });
        if (this.mTemplate.getShowVideo()) {
            PreviewVideoPlayHelper previewVideoPlayHelper = this.mVideoPreviewHelper;
            if (previewVideoPlayHelper != null) {
                previewVideoPlayHelper.w();
                return;
            }
            return;
        }
        k kVar = this.mImagePreviewHelper;
        if (kVar != null) {
            kVar.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(ZPlanTemplateMixPreviewPage this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i iVar = this$0.mEngineHelper;
        if (iVar != null) {
            iVar.G();
        }
        this$0.Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(ZPlanTemplateMixPreviewPage this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Xh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(ZPlanTemplateMixPreviewPage this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Xh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(ZPlanSameStyleProgress progress, ZPlanTemplateMixPreviewPage this$0) {
        Intrinsics.checkNotNullParameter(progress, "$progress");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).doShare(null, progress.d(), this$0.Fh());
        dh dhVar = this$0.mBinding;
        TextView textView = dhVar != null ? dhVar.f419249d : null;
        if (textView != null) {
            textView.setText("\u4e0b\u4e00\u6b65");
        }
        this$0.mMixResult = progress;
        this$0.Gh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(ZPlanTemplateMixPreviewPage this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Xh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(ZPlanTemplateMixPreviewPage this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l lVar = this$0.mProgressMakeHelper;
        if (lVar != null) {
            lVar.p(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(ZPlanTemplateMixPreviewPage this$0, String path) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        l lVar = this$0.mProgressMakeHelper;
        if (lVar != null) {
            lVar.p(100);
        }
        i iVar = this$0.mEngineHelper;
        if (iVar != null) {
            iVar.y(path);
        }
    }

    private final void Xh() {
        l lVar = this.mProgressMakeHelper;
        if (lVar != null) {
            lVar.o();
        }
        Gh();
        i iVar = this.mEngineHelper;
        if (iVar != null) {
            iVar.v();
        }
        c cVar = this.mARTemplateHelper;
        if (cVar != null) {
            cVar.r();
        }
    }

    private final void Yh() {
        dh dhVar = this.mBinding;
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = dhVar != null ? dhVar.f419251f : null;
        if (zplanExcludeFontPaddingTextView != null) {
            zplanExcludeFontPaddingTextView.setText("\u5408\u6210\u4e2d...");
        }
        dh dhVar2 = this.mBinding;
        LinearLayout linearLayout = dhVar2 != null ? dhVar2.f419253h : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        dh dhVar3 = this.mBinding;
        TextView textView = dhVar3 != null ? dhVar3.f419249d : null;
        if (textView != null) {
            textView.setVisibility(4);
        }
        c cVar = this.mARTemplateHelper;
        if (cVar != null) {
            cVar.q();
        }
    }

    private final String getPageId() {
        return "pg_zplan_outfit_samestyle_preview";
    }

    private final void initData() {
        Intent intent = requireActivity().getIntent();
        Serializable serializableExtra = intent.getSerializableExtra("template");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate");
        this.mTemplate = (ZPlanTemplate) serializableExtra;
        this.mTemplateTabId = intent.getLongExtra("templateTab", 0L);
        this.mIsAutoPublish = intent.getBooleanExtra("zplan_auto_publish", false);
        this.mPublishBackScheme = intent.getStringExtra("zplan_publish_back_scheme");
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).setReportExtraInfo(ZPlanShareLaunchParam.KEY_BIZ_SAMESTYLE_ID, String.valueOf(this.mTemplate.getId()));
        this.mViewModel = (TemplatePreviewViewModel) new ViewModelProvider(requireActivity()).get(TemplatePreviewViewModel.class);
        QLog.i("ZPlanTemplateMixPreviewPage_", 1, "isAutoPublish = " + this.mIsAutoPublish + ", template info is : [" + this.mTemplate + "], mPublishBackScheme: " + this.mPublishBackScheme);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE) : null;
        ZootopiaSource zootopiaSource = serializable instanceof ZootopiaSource ? (ZootopiaSource) serializable : null;
        if (zootopiaSource != null) {
            this.mSource = zootopiaSource;
        }
    }

    private final void initView() {
        Mh();
        Ih();
        Oh();
        Nh();
        c cVar = this.mARTemplateHelper;
        if (cVar != null) {
            cVar.t();
        }
        Kh();
        i iVar = this.mEngineHelper;
        if (iVar != null) {
            iVar.w();
        }
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.u
    public void Fg(final int progress) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: sb4.k
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTemplateMixPreviewPage.Vh(ZPlanTemplateMixPreviewPage.this, progress);
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.u
    public void I5() {
        QQToast.makeText(getContext(), 1, VSNetLightQUICBaseRequest.NETWORK_ERROR_HINT, 0).show();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: sb4.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTemplateMixPreviewPage.Uh(ZPlanTemplateMixPreviewPage.this);
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.t
    public void X1(ZPlanSameStyleProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        QQToast.makeText(getContext(), 1, "\u5408\u6210\u5931\u8d25\uff01", 0).show();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: sb4.g
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTemplateMixPreviewPage.Sh(ZPlanTemplateMixPreviewPage.this);
            }
        });
    }

    @Override // tb4.e
    public void e8(int fakeProgress, StageProgress progress, List<StageProgressConfig> totalStageConfig) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(totalStageConfig, "totalStageConfig");
        QLog.d("ZPlanTemplateMixPreviewPage_", 4, "update fakeProgress:" + fakeProgress + ", progress:" + progress);
        int i3 = (progress.getStage() == 1 && progress.getProgress() == 100) ? 100 : (int) ((fakeProgress * 95.0f) / 100);
        dh dhVar = this.mBinding;
        ProgressBar progressBar = dhVar != null ? dhVar.f419252g : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress(i3);
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.t
    public void ef(ZPlanSameStyleProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        l lVar = this.mProgressMakeHelper;
        if (lVar != null) {
            lVar.q((int) progress.getMMixProgress());
        }
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.t
    public void fg(final ZPlanSameStyleProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        l lVar = this.mProgressMakeHelper;
        if (lVar != null) {
            lVar.q(100);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: sb4.i
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTemplateMixPreviewPage.Th(ZPlanSameStyleProgress.this, this);
            }
        }, 1000L);
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.t
    public void o9(ZPlanSameStyleProgress progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: sb4.h
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTemplateMixPreviewPage.Rh(ZPlanTemplateMixPreviewPage.this);
            }
        });
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        dh g16 = dh.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.mBinding = g16;
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Iterator<T> it = this.mHelperPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.samestyle.mix.helper.d) it.next()).i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Iterator<T> it = this.mHelperPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.samestyle.mix.helper.d) it.next()).j();
        }
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.t
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: sb4.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTemplateMixPreviewPage.Qh(ZPlanTemplateMixPreviewPage.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Iterator<T> it = this.mHelperPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.samestyle.mix.helper.d) it.next()).k();
        }
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Iterator<T> it = this.mHelperPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.samestyle.mix.helper.d) it.next()).l();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Iterator<T> it = this.mHelperPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.samestyle.mix.helper.d) it.next()).m();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override // com.tencent.sqshow.fragment.ZPlanPublicBaseFragment
    protected boolean rh() {
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.samestyle.mix.helper.u
    public void sf(final String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: sb4.j
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanTemplateMixPreviewPage.Wh(ZPlanTemplateMixPreviewPage.this, path);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(View view) {
        QLog.i("ZPlanTemplateMixPreviewPage_", 1, "empty click, mask engine page event");
    }
}
