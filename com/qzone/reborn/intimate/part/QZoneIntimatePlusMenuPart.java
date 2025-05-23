package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateUploadAlbumInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateWriteMoodInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZoneIntimatePlusMenuPart;", "Lcom/qzone/reborn/base/k;", "", "M9", "Landroid/view/View;", "inflateView", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "H9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "d", "Ljava/lang/String;", "TAG", "Lnk/at;", "e", "Lnk/at;", "mSpaceViewModel", "f", "mSpaceId", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimatePlusMenuPart extends com.qzone.reborn.base.k {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nk.at mSpaceViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimatePublishMenuPart";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mSpaceId = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZoneIntimatePlusMenuPart this$0, View view, ActionSheet actionSheet, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (FastClickUtils.isFastDoubleClick(this$0.TAG + view)) {
            return;
        }
        nk.at atVar = this$0.mSpaceViewModel;
        nk.at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        UIStateData<QZoneIntimateSpaceBean> value = atVar.U1().getValue();
        QZoneIntimateSpaceBean data = value != null ? value.getData() : null;
        RFWLog.d(this$0.TAG, RFWLog.USR, "publish moodView click ,spaceInfo:" + data);
        if (data != null) {
            QZoneIntimateWriteMoodInitBean qZoneIntimateWriteMoodInitBean = new QZoneIntimateWriteMoodInitBean();
            nk.at atVar3 = this$0.mSpaceViewModel;
            if (atVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            } else {
                atVar2 = atVar3;
            }
            qZoneIntimateWriteMoodInitBean.setSpaceId(atVar2.getMSpaceId());
            qZoneIntimateWriteMoodInitBean.setSpaceType(data.getSpaceType());
            ck.c o16 = ho.i.o();
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            o16.u(context, qZoneIntimateWriteMoodInitBean);
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QZoneIntimatePlusMenuPart this$0, View view, ActionSheet actionSheet, View view2) {
        QZoneIntimateSpaceBean data;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (FastClickUtils.isFastDoubleClick(this$0.TAG + view)) {
            return;
        }
        RFWLog.d(this$0.TAG, RFWLog.USR, "uploadPhotoView  click");
        ck.c o16 = ho.i.o();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        nk.at atVar = this$0.mSpaceViewModel;
        nk.at atVar2 = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        String mSpaceId = atVar.getMSpaceId();
        nk.at atVar3 = this$0.mSpaceViewModel;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
        } else {
            atVar2 = atVar3;
        }
        UIStateData<QZoneIntimateSpaceBean> value = atVar2.U1().getValue();
        o16.y(context, new QZoneIntimateUploadAlbumInitBean(mSpaceId, (value == null || (data = value.getData()) == null) ? -1 : data.getSpaceType(), false, null, 12, null));
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(QZoneIntimatePlusMenuPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M9() {
        View inflateView = LayoutInflater.from(getContext()).inflate(R.layout.ckd, (ViewGroup) null);
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), inflateView);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.show();
        Intrinsics.checkNotNullExpressionValue(inflateView, "inflateView");
        H9(inflateView, actionSheet);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null && extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean");
            this.mSpaceId = ((QZoneIntimateMainPageInitBean) serializable).getSpaceId();
        }
        final View findViewById = rootView.findViewById(R.id.n9w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_publish_plus_btn)");
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.bm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneIntimatePlusMenuPart.K9(QZoneIntimatePlusMenuPart.this, view);
            }
        });
        AccessibilityUtil.p(findViewById, com.qzone.util.l.a(R.string.w9i));
        fo.c.n(findViewById, "em_qz_publish_button_master_mode");
        ViewModel viewModel = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        nk.at atVar = (nk.at) viewModel;
        this.mSpaceViewModel = atVar;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpaceViewModel");
            atVar = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimatePlusMenuPart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                String str;
                String str2;
                QZoneIntimateSpaceBean data;
                if ((uIStateData == null || (data = uIStateData.getData()) == null || !data.isMasterSpace()) ? false : true) {
                    str2 = QZoneIntimatePlusMenuPart.this.TAG;
                    RFWLog.d(str2, RFWLog.USR, "is master user,show plus btn");
                    findViewById.setVisibility(0);
                    com.qzone.reborn.util.i.b().p("MASTER_USER_ENTER_INTIMATE_SPACE_TIMES", com.qzone.reborn.util.i.b().h("MASTER_USER_ENTER_INTIMATE_SPACE_TIMES", 0L) + 1);
                    return;
                }
                str = QZoneIntimatePlusMenuPart.this.TAG;
                RFWLog.d(str, RFWLog.USR, "is not master user");
                findViewById.setVisibility(8);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.bn
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimatePlusMenuPart.L9(Function1.this, obj);
            }
        });
    }

    private final void H9(View inflateView, final ActionSheet actionSheet) {
        final View findViewById = inflateView.findViewById(R.id.n9v);
        ImageView imageView = (ImageView) inflateView.findViewById(R.id.nb_);
        ImageView imageView2 = (ImageView) inflateView.findViewById(R.id.mnd);
        if (QQTheme.isNowSimpleUI()) {
            imageView.setImageResource(R.drawable.qui_shuoshuo);
            imageView2.setImageResource(R.drawable.f16556a);
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.width = com.qzone.util.ar.e(44.0f);
            layoutParams.height = com.qzone.util.ar.e(44.0f);
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView2.setLayoutParams(layoutParams);
            imageView.setImageResource(R.drawable.g_0);
            imageView2.setImageResource(R.drawable.g9w);
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.bo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneIntimatePlusMenuPart.I9(QZoneIntimatePlusMenuPart.this, findViewById, actionSheet, view);
            }
        });
        final View findViewById2 = inflateView.findViewById(R.id.nbw);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.bp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneIntimatePlusMenuPart.J9(QZoneIntimatePlusMenuPart.this, findViewById2, actionSheet, view);
            }
        });
        fo.c.l(inflateView, getPartRootView());
        fo.c.l(findViewById, getPartRootView());
        fo.c.l(findViewById2, getPartRootView());
        fo.c.n(inflateView, "em_qz_plus_panel");
        fo.c.n(findViewById, "em_qz_plus_panel_talk_to_me");
        fo.c.n(findViewById2, "em_qz_plus_panel_album");
    }
}
