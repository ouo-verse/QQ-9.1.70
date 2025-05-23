package com.qzone.reborn.intimate.part;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceMedal$MainPageMedalDetail;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0017\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZIntimateTitleMedalPart;", "Lcom/qzone/reborn/base/k;", "", "H9", "", "url", "Landroid/content/Context;", "context", "G9", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "uiStateData", "J9", "Lqzone/QZIntimateSpaceMedal$MainPageMedalDetail;", "medalInfo", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "", "args", "handleBroadcastMessage", "Lnk/at;", "d", "Lnk/at;", "mainTabViewModel", "e", "Landroid/view/View;", "medalContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "medalText", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "newMedalIcon", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateTitleMedalPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nk.at mainTabViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View medalContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView medalText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView newMedalIcon;

    private final void G9(String url, Context context) {
        if (com.qzone.reborn.util.e.b("QZIntimateTitleMedalPartHalfScreen", 500L)) {
            return;
        }
        yo.d.d(url, context, null);
    }

    private final void H9() {
        nk.at atVar = this.mainTabViewModel;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        UIStateData<QZoneIntimateSpaceBean> value = atVar.U1().getValue();
        QZoneIntimateSpaceBean data = value != null ? value.getData() : null;
        QZIntimateSpaceMedal$MainPageMedalDetail medalInfo = data != null ? data.getMedalInfo() : null;
        if (medalInfo == null) {
            QLog.e(getTAG(), 1, "[handlePoolBallViewClick] medalDetail is null");
            return;
        }
        if (!data.isMasterSpace() && medalInfo.got_num.get() <= 0) {
            QLog.d(getTAG(), 1, "[handlePoolBallViewClick] not master space and medal's got_num <= 0");
            return;
        }
        if (TextUtils.isEmpty(medalInfo.detail_page_url.get())) {
            QLog.e(getTAG(), 1, "[handlePoolBallViewClick] jump url is empty");
            return;
        }
        String str = medalInfo.detail_page_url.get();
        Intrinsics.checkNotNullExpressionValue(str, "medalDetail.detail_page_url.get()");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        G9(str, context);
        getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.intimate.part.bf
            @Override // java.lang.Runnable
            public final void run() {
                QZIntimateTitleMedalPart.I9(QZIntimateTitleMedalPart.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZIntimateTitleMedalPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nk.at atVar = this$0.mainTabViewModel;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        atVar.i2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(UIStateData<QZoneIntimateSpaceBean> uiStateData) {
        String str;
        if (uiStateData.getState() == 2 || uiStateData.getState() == 3) {
            QZoneIntimateSpaceBean data = uiStateData.getData();
            com.qzone.reborn.util.k kVar = com.qzone.reborn.util.k.f59549a;
            if ((kVar.g() && data.isLoveSpace()) || kVar.a()) {
                return;
            }
            M9(data.getMedalInfo());
            TextView textView = this.medalText;
            CharSequence text = textView != null ? textView.getText() : null;
            if (!(text == null || text.length() == 0)) {
                TextView textView2 = this.medalText;
                str = " " + ((Object) (textView2 != null ? textView2.getText() : null));
            } else {
                str = "";
            }
            AccessibilityUtil.p(this.medalContainer, com.qzone.util.l.a(R.string.f169556w90) + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZIntimateTitleMedalPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        nk.at atVar = (nk.at) viewModel;
        this.mainTabViewModel = atVar;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTabViewModel");
            atVar = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZIntimateTitleMedalPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> it) {
                QZIntimateTitleMedalPart qZIntimateTitleMedalPart = QZIntimateTitleMedalPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZIntimateTitleMedalPart.J9(it);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.bg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZIntimateTitleMedalPart.K9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "QZONE_INTIMATE_UPDATE_BADGE") && (args instanceof QZIntimateSpaceMedal$MainPageMedalDetail)) {
            QLog.d("QZIntimateTitleMedalPart", 1, "receive broadcast QZONE_INTIMATE_UPDATE_BADGE: " + args);
            M9((QZIntimateSpaceMedal$MainPageMedalDetail) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.medalContainer = rootView != null ? rootView.findViewById(R.id.nhe) : null;
        this.medalText = rootView != null ? (TextView) rootView.findViewById(R.id.nhf) : null;
        this.newMedalIcon = rootView != null ? (ImageView) rootView.findViewById(R.id.mhc) : null;
        initViewModel();
        View view = this.medalContainer;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.be
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZIntimateTitleMedalPart.L9(QZIntimateTitleMedalPart.this, view2);
                }
            });
        }
    }

    private final void M9(QZIntimateSpaceMedal$MainPageMedalDetail medalInfo) {
        PBBoolField pBBoolField;
        PBUInt32Field pBUInt32Field;
        int i3 = (medalInfo == null || (pBUInt32Field = medalInfo.got_num) == null) ? 0 : pBUInt32Field.get();
        boolean z16 = (medalInfo == null || (pBBoolField = medalInfo.has_new_medal) == null) ? false : pBBoolField.get();
        QLog.i("QZIntimateTitleMedalPart", 1, "medal count is " + i3 + ", has new medal is " + z16);
        if (i3 > 0) {
            TextView textView = this.medalText;
            if (textView != null) {
                textView.setText(getActivity().getString(R.string.f169557w91, Integer.valueOf(i3)));
            }
        } else {
            TextView textView2 = this.medalText;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        if (z16) {
            ImageView imageView = this.newMedalIcon;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            int dip2px = ViewUtils.dip2px(16.0f);
            com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl("https://qzonestyle.gtimg.cn/qzone/client/intimate_space/reddot-new.png").setTargetView(this.newMedalIcon).setRequestWidth(dip2px).setRequestHeight(dip2px).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
            return;
        }
        ImageView imageView2 = this.newMedalIcon;
        if (imageView2 == null) {
            return;
        }
        imageView2.setVisibility(8);
    }
}
