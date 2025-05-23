package com.tencent.mobileqq.zplan.debug.recordpreview;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.filament.zplan.record.FilamentNativeAppRecorder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import com.tencent.zplan.record.model.Source;
import com.tencent.zplan.utils.ZPlanConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import t74.l;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004JB\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J&\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0002H\u0014J\b\u0010\u001c\u001a\u00020\u000fH\u0016R\u0014\u0010\u001f\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010\n\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020K0J8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/recordpreview/ZPlanRecordPreviewFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "Mh", "()Ljava/lang/Integer;", "resourceId", "width", "height", "", "useFilament", "bodyType", "", "cameraParams", "Landroid/app/Dialog;", "progressDialog", "", "Nh", "message", "iconType", "toast", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "getContentLayoutId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "recordSetting", "Landroid/widget/EditText;", "E", "Landroid/widget/EditText;", "inputResourceIdEditText", UserInfo.SEX_FEMALE, "previewImageView", "Landroid/widget/Button;", "G", "Landroid/widget/Button;", "startRecordButton", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "H", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "settingFloatingScreen", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "recordEngineView", "Lcom/tencent/mobileqq/zplan/debug/recordpreview/a;", "J", "Lkotlin/Lazy;", "Jh", "()Lcom/tencent/mobileqq/zplan/debug/recordpreview/a;", "floatingViewController", "K", "Z", "destroyed", "Landroid/util/Size;", "Kh", "()Landroid/util/Size;", "recordSize", "Ih", "()Z", "enableUseFilament", "Gh", "()I", "Hh", "()Ljava/lang/String;", "", "Lcom/tencent/zplan/record/model/Source;", "Lh", "()Ljava/util/List;", "recordSources", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanRecordPreviewFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final String TAG = "[zplan]ZPlanRecordPreviewFragment";

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView recordSetting;

    /* renamed from: E, reason: from kotlin metadata */
    private EditText inputResourceIdEditText;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView previewImageView;

    /* renamed from: G, reason: from kotlin metadata */
    private Button startRecordButton;

    /* renamed from: H, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView settingFloatingScreen;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView recordEngineView;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy floatingViewController;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile boolean destroyed;

    public ZPlanRecordPreviewFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.ZPlanRecordPreviewFragment$floatingViewController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                Context requireContext = ZPlanRecordPreviewFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return new a(requireContext);
            }
        });
        this.floatingViewController = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(ZPlanRecordPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this$0.settingFloatingScreen;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setVisibility(0);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this$0.settingFloatingScreen;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.P(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(ZPlanRecordPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer Mh = this$0.Mh();
        if (Mh == null) {
            this$0.toast("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u8d44\u6e90ID!", 1);
            return;
        }
        Button button = this$0.startRecordButton;
        if (button != null) {
            button.setClickable(false);
        }
        Size Kh = this$0.Kh();
        int intValue = Mh.intValue();
        int width = Kh.getWidth();
        int height = Kh.getHeight();
        boolean Ih = this$0.Ih();
        int Gh = this$0.Gh();
        String Hh = this$0.Hh();
        Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(this$0.getContext(), 1, false);
        showOnlyLoadingImageDialog.show();
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(showOnlyLoadingImageDialog, "showOnlyLoadingImageDial\u2026.show()\n                }");
        this$0.Nh(intValue, width, height, Ih, Gh, Hh, showOnlyLoadingImageDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(final ZPlanRecordPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Size Kh = this$0.Kh();
        QLog.i(this$0.TAG, 1, "Floating Setting View Dismiss, set new preview size: " + Kh);
        l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.ZPlanRecordPreviewFragment$doOnCreateView$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageView imageView;
                ImageView imageView2;
                ImageView imageView3;
                imageView = ZPlanRecordPreviewFragment.this.previewImageView;
                ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
                if (layoutParams != null) {
                    layoutParams.width = Kh.getWidth();
                }
                imageView2 = ZPlanRecordPreviewFragment.this.previewImageView;
                ViewGroup.LayoutParams layoutParams2 = imageView2 != null ? imageView2.getLayoutParams() : null;
                if (layoutParams2 != null) {
                    layoutParams2.height = Kh.getHeight();
                }
                imageView3 = ZPlanRecordPreviewFragment.this.previewImageView;
                if (imageView3 != null) {
                    imageView3.requestLayout();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(final ZPlanRecordPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRecordPreviewFragment.Fh(ZPlanRecordPreviewFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(ZPlanRecordPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).clearRecordCache();
        FileUtils.deleteDirectory(ZPlanConstant.f386195f.a());
        this$0.toast("\u6e05\u9664\u7f13\u5b58\u6210\u529f!", 2);
    }

    private final int Gh() {
        return Jh().b();
    }

    private final String Hh() {
        return Jh().c();
    }

    private final boolean Ih() {
        return Jh().a();
    }

    private final a Jh() {
        return (a) this.floatingViewController.getValue();
    }

    private final Size Kh() {
        return Jh().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Source> Lh() {
        return Jh().d();
    }

    private final Integer Mh() {
        EditText editText = this.inputResourceIdEditText;
        String valueOf = String.valueOf(editText != null ? editText.getText() : null);
        if (valueOf.length() == 0) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(valueOf));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toast(final String message, final int iconType) {
        l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.ZPlanRecordPreviewFragment$toast$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(ZPlanRecordPreviewFragment.this.getContext(), iconType, message, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        QLog.i(this.TAG, 1, "doOnCreateView");
        ImageView imageView = (ImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qg9);
        this.recordSetting = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanRecordPreviewFragment.Bh(ZPlanRecordPreviewFragment.this, view);
                }
            });
        }
        this.inputResourceIdEditText = (EditText) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qg7);
        this.previewImageView = (ImageView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qg8);
        this.recordEngineView = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163499qg2);
        Button button = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qnb);
        this.startRecordButton = button;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanRecordPreviewFragment.Ch(ZPlanRecordPreviewFragment.this, view);
                }
            });
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.qge);
        this.settingFloatingScreen = qUSHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.setVisibility(8);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.settingFloatingScreen;
        if (qUSHalfScreenFloatingView2 != null) {
            qUSHalfScreenFloatingView2.setQUSDragFloatController(Jh());
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.settingFloatingScreen;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.d
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    ZPlanRecordPreviewFragment.Dh(ZPlanRecordPreviewFragment.this);
                }
            });
        }
        setRightButtonText("\u6e05\u9664\u7f13\u5b58", new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.recordpreview.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanRecordPreviewFragment.Eh(ZPlanRecordPreviewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dbc;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.destroyed = true;
    }

    private final void Nh(int resourceId, int width, int height, boolean useFilament, int bodyType, String cameraParams, Dialog progressDialog) {
        QLog.i(this.TAG, 1, "recordAndPreview, resourceId:" + resourceId + ", width:" + width + ", height:" + height + ", useFilament:" + useFilament + ", bodyType:" + bodyType + ", cameraParams:\n " + cameraParams + ", recordSources: " + Lh());
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        String str = e16;
        MODE mode = MODE.FRAME;
        BusinessConfig businessConfig = new BusinessConfig(0, false, false, false, BusinessConfig.FrameType.PNG, 0, null, null, null, null, null, null, null, false, null, 0, null, 131055, null);
        if (useFilament) {
            businessConfig.G(new EngineType.Filament(FilamentNativeAppRecorder.class));
            businessConfig.A(Boolean.TRUE);
        }
        businessConfig.x(bodyType);
        businessConfig.getCamera().c(cameraParams);
        Unit unit = Unit.INSTANCE;
        SingleRecordRequestParams singleRecordRequestParams = new SingleRecordRequestParams(resourceId, str, null, width, height, mode, businessConfig, 0, null, null, null, null, 0, false, null, null, 65412, null);
        ImageView imageView = this.previewImageView;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanRecordPreviewFragment$recordAndPreview$1(singleRecordRequestParams, this, resourceId, progressDialog, useFilament, null), 3, null);
    }
}
