package com.tencent.mobileqq.wink.preview.part.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import com.tencent.mobileqq.wink.publish.OneClickPublishingHelper;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001d\u00104\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewPublishPart;", "Lp53/a;", "", "N9", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "J9", "", "G9", "H9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", "mRootView", "onInitView", "initView", "K9", "onPartDestroy", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, QQWinkConstants.COVER_PATH, "E9", "Landroidx/cardview/widget/CardView;", "d", "Landroidx/cardview/widget/CardView;", "publish", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "publishBtn", "f", "titleHintTextView", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", tl.h.F, "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "publishTaskListener", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "i", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "F9", "()Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "setLoadingDialog", "(Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;)V", "loadingDialog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "I9", "()Ljava/lang/String;", GetAdInfoRequest.SOURCE_FROM, "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkBaseSharePreviewPublishPart extends p53.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CardView publish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView publishBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titleHintTextView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ITaskListener.Stub publishTaskListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sourceFrom;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewPublishPart$a", "Lcom/tencent/mobileqq/winkpublish/api/ITaskListener$Stub;", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "task", "", "onTaskChange", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends ITaskListener.Stub {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void Z() {
            QQToast.makeText(com.tencent.mobileqq.wink.b.c(), 2, R.string.f216285xw, 1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o0() {
            QQToast.makeText(com.tencent.mobileqq.wink.b.c(), 1, R.string.f216215xp, 1).show();
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(@NotNull TaskInfo task) {
            Object obj;
            Intrinsics.checkNotNullParameter(task, "task");
            Bundle transParams = task.getTransParams();
            if (transParams != null) {
                obj = transParams.get("publish_trans_tag");
            } else {
                obj = null;
            }
            if (obj != null && Intrinsics.areEqual(obj, QQWinkConstants.WINK_PUBLISH_TRANS_TAG_LOW_LEVEL_PUBLISH)) {
                if (task.isFinish() || task.isCancelled()) {
                    WinkBaseSharePreviewPublishPart.this.J9().f2(false);
                    if (task.isSuccess()) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.preview.part.base.k
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkBaseSharePreviewPublishPart.a.Z();
                            }
                        });
                    } else {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.preview.part.base.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkBaseSharePreviewPublishPart.a.o0();
                            }
                        });
                    }
                    QCircleCommonLoadingDialog loadingDialog = WinkBaseSharePreviewPublishPart.this.getLoadingDialog();
                    if (loadingDialog != null) {
                        loadingDialog.dismiss();
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewPublishPart$b", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkPublishHelper2.Callback {
        b() {
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            ITaskListener.Stub stub = WinkBaseSharePreviewPublishPart.this.publishTaskListener;
            if (stub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishTaskListener");
                stub = null;
            }
            service.addTaskListener2(stub);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewPublishPart$c", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements WinkPublishHelper2.Callback {
        c() {
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            ITaskListener.Stub stub = WinkBaseSharePreviewPublishPart.this.publishTaskListener;
            if (stub == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishTaskListener");
                stub = null;
            }
            service.removeTaskListener(stub);
        }
    }

    public WinkBaseSharePreviewPublishPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart$sourceFrom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                return WinkBaseSharePreviewPublishPart.this.getActivity().getIntent().getStringExtra(QQWinkConstants.AVATAR_FROM_TYPE);
            }
        });
        this.sourceFrom = lazy;
    }

    private final String I9() {
        return (String) this.sourceFrom.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N9() {
        if (this.loadingDialog == null) {
            this.loadingDialog = new QCircleCommonLoadingDialog.c(getContext()).n(false).h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.preview.part.base.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkBaseSharePreviewPublishPart.O9(WinkBaseSharePreviewPublishPart.this, view);
                }
            }).p(getContext().getResources().getString(R.string.f238887kz)).j("share_preview").a();
        }
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.loadingDialog;
        Intrinsics.checkNotNull(qCircleCommonLoadingDialog);
        qCircleCommonLoadingDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(WinkBaseSharePreviewPublishPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void E9(@NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull MetaMaterial material, @Nullable String coverPath) {
        Intent intent;
        Bundle extras;
        String string;
        Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
        Intrinsics.checkNotNullParameter(material, "material");
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQWinkConstants.WINK_PUBLISH_PARAM_IS_SAVE_MEDIA, true);
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, I9());
        Boolean value = J9().b2().getValue();
        Intrinsics.checkNotNull(value);
        if (value.booleanValue()) {
            bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, "1");
        }
        com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
        com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null && (string = extras.getString(QQWinkConstants.WINK_PUBLISH_TASK_ID, null)) != null) {
            bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, string);
        }
        bundle.putString("publish_trans_tag", QQWinkConstants.WINK_PUBLISH_TRANS_TAG_LOW_LEVEL_PUBLISH);
        OneClickPublishingHelper oneClickPublishingHelper = OneClickPublishingHelper.f325628a;
        String missionId = winkEditDataWrapper.getMissionId();
        Intrinsics.checkNotNull(missionId);
        OneClickPublishingHelper.z(oneClickPublishingHelper, 0, missionId, coverPath, H9(), bundle, false, 32, null);
        N9();
    }

    @Nullable
    /* renamed from: F9, reason: from getter */
    protected final QCircleCommonLoadingDialog getLoadingDialog() {
        return this.loadingDialog;
    }

    @NotNull
    public abstract String G9();

    @NotNull
    public abstract String H9();

    @NotNull
    public abstract WinkBasePreviewShareViewModel J9();

    public final void K9() {
        LiveData<t73.a<WinkBasePreviewShareViewModel.c>> W1 = J9().W1();
        BasePartFragment hostFragment = getHostFragment();
        final Function1<t73.a<? extends WinkBasePreviewShareViewModel.c>, Unit> function1 = new Function1<t73.a<? extends WinkBasePreviewShareViewModel.c>, Unit>() { // from class: com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(t73.a<? extends WinkBasePreviewShareViewModel.c> aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(t73.a<? extends WinkBasePreviewShareViewModel.c> aVar) {
                WinkBasePreviewShareViewModel.c b16 = aVar.b();
                if (Intrinsics.areEqual(b16, WinkBasePreviewShareViewModel.c.b.f325445a)) {
                    WinkBaseSharePreviewPublishPart.this.J9().f2(true);
                    return;
                }
                if (Intrinsics.areEqual(b16, WinkBasePreviewShareViewModel.c.C9076c.f325446a)) {
                    QQToast.makeText(WinkBaseSharePreviewPublishPart.this.getContext(), R.string.f238897l0, 1).show();
                    return;
                }
                if (b16 instanceof WinkBasePreviewShareViewModel.c.SaveShare) {
                    if (!NetworkUtil.isNetSupport(WinkBaseSharePreviewPublishPart.this.getContext())) {
                        QQToast.makeText(WinkBaseSharePreviewPublishPart.this.getContext(), R.string.f216085xc, 1).show();
                    } else {
                        WinkBasePreviewShareViewModel.c.SaveShare saveShare = (WinkBasePreviewShareViewModel.c.SaveShare) b16;
                        WinkBaseSharePreviewPublishPart.this.E9(saveShare.getWinkEditDataWrapper(), saveShare.getMaterial(), saveShare.getCoverPath());
                    }
                }
            }
        };
        W1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.preview.part.base.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkBaseSharePreviewPublishPart.L9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> b26 = J9().b2();
        BasePartFragment hostFragment2 = getHostFragment();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewPublishPart$initObserve$2
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
            public final void invoke2(Boolean bool) {
                CardView cardView;
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_operation_activity_id", WinkBaseSharePreviewPublishPart.this.G9());
                hashMap.put(WinkDaTongReportConstant.ElementParamKey.QQ_IS_SYNC_QZONE_MONENT, Intrinsics.areEqual(bool, Boolean.TRUE) ? "1" : "0");
                cardView = WinkBaseSharePreviewPublishPart.this.publish;
                if (cardView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publish");
                    cardView = null;
                }
                VideoReport.setElementParams(cardView, hashMap);
            }
        };
        b26.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.preview.part.base.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkBaseSharePreviewPublishPart.M9(Function1.this, obj);
            }
        });
    }

    public final void initView() {
        TextView textView;
        String str;
        int i3;
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView);
        View findViewById = partRootView.findViewById(R.id.f29030kj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView!!.findViewById(R.id.publish_btn)");
        this.publishBtn = (TextView) findViewById;
        View partRootView2 = getPartRootView();
        Intrinsics.checkNotNull(partRootView2);
        View findViewById2 = partRootView2.findViewById(R.id.f28990kf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView!!.findViewById(R.id.publish)");
        this.publish = (CardView) findViewById2;
        View partRootView3 = getPartRootView();
        CardView cardView = null;
        if (partRootView3 != null) {
            textView = (TextView) partRootView3.findViewById(R.id.yhs);
        } else {
            textView = null;
        }
        this.titleHintTextView = textView;
        CardView cardView2 = this.publish;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publish");
            cardView2 = null;
        }
        if (!QQTheme.isNowThemeIsNight()) {
            str = "#0099ff";
        } else {
            str = "#0066cc";
        }
        cardView2.setCardBackgroundColor(Color.parseColor(str));
        if (com.dataline.util.j.b()) {
            i3 = R.drawable.ora;
        } else {
            i3 = R.drawable.osi;
        }
        TextView textView2 = this.publishBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtn");
            textView2 = null;
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), i3);
        if (drawable != null) {
            drawable.setBounds(0, 0, ViewExKt.d(24), ViewExKt.d(24));
        } else {
            drawable = null;
        }
        textView2.setCompoundDrawables(drawable, null, null, null);
        TextView textView3 = this.publishBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishBtn");
            textView3 = null;
        }
        textView3.setText(com.dataline.util.j.d(getContext().getString(R.string.f240417p4)));
        TextView textView4 = this.titleHintTextView;
        if (textView4 != null) {
            textView4.setText(com.dataline.util.j.d(getContext().getString(R.string.f240397p2)));
        }
        CardView cardView3 = this.publish;
        if (cardView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publish");
            cardView3 = null;
        }
        cardView3.setOnClickListener(new WinkBaseSharePreviewPublishPart$initView$2(this));
        CardView cardView4 = this.publish;
        if (cardView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publish");
            cardView4 = null;
        }
        VideoReport.setElementId(cardView4, "em_xsj_publish_button");
        Map<String, Object> param = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(param, "param");
        param.put("xsj_operation_activity_id", G9());
        CardView cardView5 = this.publish;
        if (cardView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publish");
        } else {
            cardView = cardView5;
        }
        VideoReport.setElementParams(cardView, param);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View mRootView) {
        super.onInitView(mRootView);
        initView();
        K9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        this.publishTaskListener = new a();
        WinkPublishHelper2.INSTANCE.bindService(1, new b());
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        WinkPublishHelper2.INSTANCE.bindService(1, new c());
    }
}
