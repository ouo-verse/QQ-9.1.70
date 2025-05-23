package com.tencent.mobileqq.zootopia.portal.aigc.preview;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.r;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import fi3.al;
import id3.d;
import java.util.Collection;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import uk0.e;
import wc3.AigcPreviewParams;
import wc3.ExtraReportParams;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR#\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "", "show", "", "Ph", "Nh", "", "getSubSource", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, DKHippyEvent.EVENT_STOP, "onBackPressedEvent", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lfi3/al;", "N", "Lfi3/al;", "binding", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", "P", "Lkotlin/Lazy;", "Mh", "()Landroid/app/Dialog;", "showLoadingDialog", "Lcom/tencent/image/URLImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/image/URLImageView;", "textureBg", "Lwk0/a;", BdhLogUtil.LogTag.Tag_Req, "Lwk0/a;", "nativeApp", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "scene", "T", "Landroid/view/View;", "textureView", "Lwc3/b;", "U", "Lwc3/b;", "extraReportParams", "Lid3/d;", "V", "Lid3/d;", "dtReporter", "<init>", "()V", "W", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AigcPreviewFragment extends ZootopiaBaseFragment {

    /* renamed from: N, reason: from kotlin metadata */
    private al binding;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy showLoadingDialog;

    /* renamed from: Q, reason: from kotlin metadata */
    private URLImageView textureBg;

    /* renamed from: R, reason: from kotlin metadata */
    private wk0.a nativeApp;

    /* renamed from: S, reason: from kotlin metadata */
    private AigcPreviewBusinessScene scene;

    /* renamed from: T, reason: from kotlin metadata */
    private View textureView;

    /* renamed from: U, reason: from kotlin metadata */
    private ExtraReportParams extraReportParams;

    /* renamed from: V, reason: from kotlin metadata */
    private final d dtReporter;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewFragment$b", "Luk0/e;", "", "type", "eventData", "", "onEvent", "", "d", "Z", "a", "()Z", "setDone", "(Z)V", "done", "Lkotlinx/coroutines/CancellableContinuation;", "e", "Lkotlinx/coroutines/CancellableContinuation;", "getContRef", "()Lkotlinx/coroutines/CancellableContinuation;", "b", "(Lkotlinx/coroutines/CancellableContinuation;)V", "contRef", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean done;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private CancellableContinuation<? super Unit> contRef;

        b() {
        }

        /* renamed from: a, reason: from getter */
        public final boolean getDone() {
            return this.done;
        }

        public final void b(CancellableContinuation<? super Unit> cancellableContinuation) {
            this.contRef = cancellableContinuation;
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            synchronized (this) {
                this.done = true;
                CancellableContinuation<? super Unit> cancellableContinuation = this.contRef;
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
                this.contRef = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewFragment$c", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements e {
        c() {
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            QLog.d("AigcPreviewFragment", 4, "onEvent, type: " + type + ", eventData: " + eventData);
        }
    }

    public AigcPreviewFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewFragment$showLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Dialog invoke() {
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(AigcPreviewFragment.this.getContext(), "\u52a0\u8f7d\u4e2d", true);
                showLoadingDialog.setCanceledOnTouchOutside(false);
                return showLoadingDialog;
            }
        });
        this.showLoadingDialog = lazy;
        this.dtReporter = new d(null, 1, null);
    }

    private final Dialog Mh() {
        return (Dialog) this.showLoadingDialog.getValue();
    }

    private final void Nh() {
        b bVar = new b();
        wk0.a aVar = this.nativeApp;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        aVar.c("onFirstFrameRenderEnd", bVar);
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new AigcPreviewFragment$initLoading$1(this, bVar, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(AigcPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
        d dVar = this$0.dtReporter;
        al alVar = this$0.binding;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar = null;
        }
        RelativeLayout relativeLayout = alVar.f398840d;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.zplanAigcPreviewClose");
        dVar.c("clck", relativeLayout, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(boolean show) {
        QLog.d("AigcPreviewFragment", 1, "showOrHideLoading " + show + " ");
        if (show) {
            Mh().show();
        } else {
            Mh().dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_AIGC_PREVIEW;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        wk0.a aVar = this.nativeApp;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        aVar.onDestroy();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        wk0.a aVar = this.nativeApp;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        aVar.onPause();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        wk0.a aVar = this.nativeApp;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        aVar.onResume();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Ph(false);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(requireContext());
        al alVar = this.binding;
        al alVar2 = null;
        if (alVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar = null;
        }
        ViewGroup.LayoutParams layoutParams = alVar.f398838b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = statusBarHeight;
        al alVar3 = this.binding;
        if (alVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            alVar2 = alVar3;
        }
        alVar2.f398840d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.aigc.preview.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AigcPreviewFragment.Oh(AigcPreviewFragment.this, view2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle savedInstanceState) {
        AigcPreviewParams aigcPreviewParams;
        Collection emptyList;
        wk0.a b16;
        Intent intent;
        String stringExtra;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        wk0.a aVar = null;
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("aigc_preview_params")) != null) {
            try {
                aigcPreviewParams = (AigcPreviewParams) new Gson().fromJson(stringExtra, AigcPreviewParams.class);
            } catch (JsonSyntaxException e16) {
                QLog.e("AigcPreviewFragment", 1, "onCreate aigcPreviewParams \u8bed\u6cd5\u9519\u8bef " + stringExtra + " ", e16);
            }
            this.extraReportParams = aigcPreviewParams == null ? aigcPreviewParams.getExtraReportParams() : null;
            if (aigcPreviewParams == null) {
                emptyList = aigcPreviewParams.b();
            } else {
                QLog.w("AigcPreviewFragment", 1, "onCreate agic\u9884\u89c8\u9875\u7f3a\u5c11\u9884\u89c8\u53c2\u6570");
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            this.scene = new AigcPreviewBusinessScene(emptyList, 1, null, null, null, 28, null);
            b16 = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, FilamentApiImpl.f369933a.e(), null, null, 12, null);
            this.nativeApp = b16;
            if (b16 != null) {
                Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            } else {
                aVar = b16;
            }
            aVar.c("onFirstFrameRenderEnd", new c());
        }
        aigcPreviewParams = null;
        this.extraReportParams = aigcPreviewParams == null ? aigcPreviewParams.getExtraReportParams() : null;
        if (aigcPreviewParams == null) {
        }
        this.scene = new AigcPreviewBusinessScene(emptyList, 1, null, null, null, 28, null);
        b16 = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, FilamentApiImpl.f369933a.e(), null, null, 12, null);
        this.nativeApp = b16;
        if (b16 != null) {
        }
        aVar.c("onFirstFrameRenderEnd", new c());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        al g16 = al.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        FragmentActivity activity = getActivity();
        al alVar = null;
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            com.tencent.sqshow.zootopia.utils.a.a(qBaseActivity);
            r.c(qBaseActivity.getWindow());
        }
        Nh();
        Ph(true);
        URLImageView uRLImageView = new URLImageView(getContext());
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        CommonExKt.v(uRLImageView, c84.b.f30450a.a(), R.drawable.ie8, null, 4, null);
        uRLImageView.setZ(-2.0f);
        this.textureBg = uRLImageView;
        al alVar2 = this.binding;
        if (alVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar2 = null;
        }
        ConstraintLayout root = alVar2.getRoot();
        URLImageView uRLImageView2 = this.textureBg;
        if (uRLImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureBg");
            uRLImageView2 = null;
        }
        root.addView(uRLImageView2, new ConstraintLayout.LayoutParams(-1, -1));
        al alVar3 = this.binding;
        if (alVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar3 = null;
        }
        alVar3.f398838b.setZ(1.0f);
        al alVar4 = this.binding;
        if (alVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar4 = null;
        }
        alVar4.f398842f.setZ(-1.0f);
        al alVar5 = this.binding;
        if (alVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar5 = null;
        }
        alVar5.f398842f.setText(MobileQQ.sMobileQQ.getLastLoginUin() + "\u5236\u4f5c\u4e2d");
        wk0.a aVar = this.nativeApp;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        View z16 = aVar.z(requireContext, Boolean.TRUE);
        z16.setZ(0.0f);
        this.textureView = z16;
        al alVar6 = this.binding;
        if (alVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar6 = null;
        }
        FrameLayout frameLayout = alVar6.f398841e;
        View view2 = this.textureView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view2 = null;
        }
        frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, -1));
        wk0.a aVar2 = this.nativeApp;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar2 = null;
        }
        AigcPreviewBusinessScene aigcPreviewBusinessScene = this.scene;
        if (aigcPreviewBusinessScene == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scene");
            aigcPreviewBusinessScene = null;
        }
        int y16 = aVar2.y("", aigcPreviewBusinessScene);
        if (y16 != 1) {
            QLog.e("AigcPreviewFragment", 1, "startWithEntry fail, ret: " + y16);
        }
        d dVar = this.dtReporter;
        al alVar7 = this.binding;
        if (alVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar7 = null;
        }
        ConstraintLayout root2 = alVar7.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        dVar.j(this, root2, "pg_zplan_preview", new LinkedHashMap());
        d dVar2 = this.dtReporter;
        al alVar8 = this.binding;
        if (alVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            alVar8 = null;
        }
        RelativeLayout relativeLayout = alVar8.f398840d;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.zplanAigcPreviewClose");
        d.i(dVar2, relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, new LinkedHashMap(), false, false, null, false, false, 224, null);
        d dVar3 = this.dtReporter;
        View view3 = this.textureView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view = null;
        } else {
            view = view3;
        }
        d.h(dVar3, view, "em_zplan_avatar", null, false, false, null, 60, null);
        al alVar9 = this.binding;
        if (alVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            alVar = alVar9;
        }
        ConstraintLayout root3 = alVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
        return root3;
    }
}
