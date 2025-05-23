package com.tencent.mobileqq.matchfriend.reborn.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.publish.SquareFeedPublishHideKeyboardEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import s82.SquarePublishPicInfo;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R#\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\u0016\u001a\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/part/SquareFeedPublishTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "M9", "O9", "", "currentText", "Ls82/b;", "picInfo", "J9", "N9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Ls82/a;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "L9", "()Ls82/a;", "viewModel", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPublishing", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", tl.h.F, "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "editText", "Landroid/graphics/Bitmap;", "i", "Landroid/graphics/Bitmap;", "bitMap", "Lcom/tencent/biz/qui/quibutton/QUIButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "publishBtn", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "cancelBtn", "", "D", "I", "source", "", "E", "K9", "()Z", "openPublishAnimSwitch", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SquareFeedPublishTitlePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private View cancelBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private int source;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy openPublishAnimSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isPublishing;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView imageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QUIMultiLineInputView editText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Bitmap bitMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QUIButton publishBtn;

    public SquareFeedPublishTitlePart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<s82.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final s82.a invoke() {
                return (s82.a) SquareFeedPublishTitlePart.this.getViewModel(s82.a.class);
            }
        });
        this.viewModel = lazy;
        this.isPublishing = new AtomicBoolean(false);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$openPublishAnimSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102969", false));
            }
        });
        this.openPublishAnimSwitch = lazy2;
    }

    private final void J9(CharSequence currentText, SquarePublishPicInfo picInfo) {
        if (this.isPublishing.getAndSet(true)) {
            QLog.i("SquareFeedPublishTitlePart", 1, "[doPublishFeed] is publishing.");
            return;
        }
        QUIButton qUIButton = this.publishBtn;
        if (qUIButton != null) {
            qUIButton.r();
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), "SquareFeedPublishTitlePart", null, null, null, new SquareFeedPublishTitlePart$doPublishFeed$1(currentText, picInfo, this, null), 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K9() {
        return ((Boolean) this.openPublishAnimSwitch.getValue()).booleanValue();
    }

    private final s82.a L9() {
        return (s82.a) this.viewModel.getValue();
    }

    private final void M9() {
        VideoReport.setElementId(this.cancelBtn, "em_kl_cancel_btn");
        View view = this.cancelBtn;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(view, clickPolicy);
        View view2 = this.cancelBtn;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(view2, exposurePolicy);
        VideoReport.setElementId(this.publishBtn, "em_kl_publish_btn");
        VideoReport.setElementClickPolicy(this.publishBtn, clickPolicy);
        VideoReport.setElementExposePolicy(this.publishBtn, exposurePolicy);
    }

    private final void N9() {
        if (hf0.a.a("SquareFeedPublishTitlePart")) {
            return;
        }
        QLog.i("SquareFeedPublishTitlePart", 2, "onClickCancelBtn.");
        VideoReport.reportEvent("dt_clck", this.cancelBtn, null);
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private final void O9() {
        CharSequence trim;
        String localPath;
        if (hf0.a.a("SquareFeedPublishTitlePart")) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(SquareFeedPublishHideKeyboardEvent.INSTANCE);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), 1, R.string.x0e, 0).show();
            QUIButton qUIButton = this.publishBtn;
            if (qUIButton != null) {
                qUIButton.s();
                return;
            }
            return;
        }
        VideoReport.reportEvent("dt_clck", this.publishBtn, null);
        CharSequence value = L9().O1().getValue();
        String str = "";
        if (value == null) {
            value = "";
        }
        trim = StringsKt__StringsKt.trim(value);
        SquarePublishPicInfo value2 = L9().N1().getValue();
        if (value2 != null && (localPath = value2.getLocalPath()) != null) {
            str = localPath;
        }
        if (str.length() == 0) {
            if (trim.length() == 0) {
                QQToast.makeText(getContext(), "\u8bf7\u8f93\u5165\u5185\u5bb9", 0).show();
                return;
            }
        }
        QLog.i("SquareFeedPublishTitlePart", 1, "onClickPublishBtn");
        J9(value, L9().N1().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(SquareFeedPublishTitlePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.N9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(SquareFeedPublishTitlePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intent intent;
        super.onPartCreate(activity, savedInstanceState);
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.source = intent.getIntExtra("key_source", 0);
        }
        MutableLiveData<Boolean> L1 = L9().L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$onPartCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QUIButton qUIButton;
                qUIButton = SquareFeedPublishTitlePart.this.publishBtn;
                if (qUIButton == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qUIButton.setEnabled(it.booleanValue());
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SquareFeedPublishTitlePart.R9(Function1.this, obj);
            }
        });
        MutableLiveData<Bitmap> M1 = L9().M1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Bitmap, Unit> function12 = new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTitlePart$onPartCreate$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap bitmap) {
                SquareFeedPublishTitlePart.this.bitMap = bitmap;
            }
        };
        M1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SquareFeedPublishTitlePart.S9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.olc);
        QUIButton qUIButton = null;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SquareFeedPublishTitlePart.P9(SquareFeedPublishTitlePart.this, view);
                }
            });
        } else {
            findViewById = null;
        }
        this.cancelBtn = findViewById;
        QUIButton qUIButton2 = (QUIButton) rootView.findViewById(R.id.f163163on2);
        if (qUIButton2 != null) {
            qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SquareFeedPublishTitlePart.Q9(SquareFeedPublishTitlePart.this, view);
                }
            });
            qUIButton = qUIButton2;
        }
        this.publishBtn = qUIButton;
        View findViewById2 = rootView.findViewById(R.id.f163161on0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.pic_view)");
        this.imageView = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.okg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.input_view)");
        this.editText = (QUIMultiLineInputView) findViewById3;
        M9();
    }
}
