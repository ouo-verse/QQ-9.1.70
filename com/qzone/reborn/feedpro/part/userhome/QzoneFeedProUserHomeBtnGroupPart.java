package com.qzone.reborn.feedpro.part.userhome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.reborn.feedpro.viewmodel.q;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.MainPageControl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.util.NetworkState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\"\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00105\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00100\u00a8\u0006:"}, d2 = {"Lcom/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeBtnGroupPart;", "Lcom/qzone/reborn/feedpro/part/b;", "", "initViewModel", "", "isSuccess", "", "errMsg", "P9", "O9", "W9", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "rsp", "Q9", "R9", "S9", "T9", "U9", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "d", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "userHomeViewModel", "Lcom/qzone/reborn/feedpro/viewmodel/q;", "e", "Lcom/qzone/reborn/feedpro/viewmodel/q;", "forbiddenViewModel", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "btnGroupRoot", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "deleteVisitBtn", "i", "Z", "isRealVip", "Landroid/view/View$OnClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnClickListener;", "applyAccessListener", BdhLogUtil.LogTag.Tag_Conn, "deleteVisitListener", "D", "addFriendListener", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProUserHomeBtnGroupPart extends com.qzone.reborn.feedpro.part.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m userHomeViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.q forbiddenViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout btnGroupRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView deleteVisitBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isRealVip;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View.OnClickListener applyAccessListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.userhome.j
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QzoneFeedProUserHomeBtnGroupPart.M9(QzoneFeedProUserHomeBtnGroupPart.this, view);
        }
    };

    /* renamed from: C, reason: from kotlin metadata */
    private final View.OnClickListener deleteVisitListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.userhome.k
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QzoneFeedProUserHomeBtnGroupPart.N9(QzoneFeedProUserHomeBtnGroupPart.this, view);
        }
    };

    /* renamed from: D, reason: from kotlin metadata */
    private final View.OnClickListener addFriendListener = new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.userhome.l
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            QzoneFeedProUserHomeBtnGroupPart.L9(QzoneFeedProUserHomeBtnGroupPart.this, view);
        }
    };

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeBtnGroupPart$b", "Lcom/qzone/reborn/feedpro/viewmodel/q$c;", "", "isSuccess", "", "errMsg", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements q.c {
        b() {
        }

        @Override // com.qzone.reborn.feedpro.viewmodel.q.c
        public void a(boolean isSuccess, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QzoneFeedProUserHomeBtnGroupPart.this.P9(isSuccess, errMsg);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeBtnGroupPart$c", "Lcom/qzone/reborn/feedpro/viewmodel/q$b;", "", "isSuccess", "", "errMsg", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements q.b {
        c() {
        }

        @Override // com.qzone.reborn.feedpro.viewmodel.q.b
        public void a(boolean isSuccess, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QzoneFeedProUserHomeBtnGroupPart.this.O9(isSuccess, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QzoneFeedProUserHomeBtnGroupPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.feedpro.viewmodel.m mVar = this$0.userHomeViewModel;
        if (mVar != null) {
            y6.b.a(this$0.getActivity(), mVar.getHostUin(), this$0.getContext().getResources().getString(R.string.f241767sr), 3081, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(QzoneFeedProUserHomeBtnGroupPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.feedpro.viewmodel.m mVar = this$0.userHomeViewModel;
        if (mVar != null) {
            Activity activity = this$0.getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            com.qzone.reborn.feedpro.utils.p.l(activity, mVar.getHostUin(), mVar.getHostNickname());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QzoneFeedProUserHomeBtnGroupPart this$0, View view) {
        String l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkState.isNetSupport()) {
            ToastUtil.s("\u65e0\u7f51\u7edc\u8fde\u63a5", 0);
            return;
        }
        String str = "";
        if (!LoginData.getInstance().isQzoneVip() && !this$0.isRealVip) {
            String stringDataSet = ar.INSTANCE.b("kenaiyu", "2024-07-12", "qzone_kuikly_pay_url").getStringDataSet("delete_record_vip_url", "");
            Intrinsics.checkNotNull(stringDataSet);
            if (stringDataSet.length() > 0) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(this$0.getActivity(), stringDataSet);
                return;
            } else {
                ak.R(this$0.getActivity(), ak.q(this$0.getActivity(), "jhan_beidangshanchu", null, null, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip() || this$0.isRealVip), -1, false);
                return;
            }
        }
        com.qzone.reborn.feedpro.viewmodel.q qVar = this$0.forbiddenViewModel;
        if (qVar != null) {
            com.qzone.reborn.feedpro.viewmodel.m mVar = this$0.userHomeViewModel;
            if (mVar != null && (l3 = Long.valueOf(mVar.getHostUin()).toString()) != null) {
                str = l3;
            }
            qVar.N1(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(GetMainPageHeadRsp rsp) {
        MainPageControl mainPageControl = rsp.mainPageControl;
        if (mainPageControl == null) {
            return;
        }
        if (!com.qzone.reborn.feedpro.utils.p.s(mainPageControl)) {
            LinearLayout linearLayout = this.btnGroupRoot;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        if (com.qzone.reborn.feedpro.utils.p.p(mainPageControl)) {
            U9();
            return;
        }
        if (com.qzone.reborn.feedpro.utils.p.r(mainPageControl)) {
            R9();
            return;
        }
        if (com.qzone.reborn.feedpro.utils.p.v(mainPageControl)) {
            S9();
            return;
        }
        if (com.qzone.reborn.feedpro.utils.p.w(mainPageControl)) {
            T9();
            return;
        }
        LinearLayout linearLayout2 = this.btnGroupRoot;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        QLog.e("QzoneFeedProUserHomeBtnGroupPart", 1, "[handleHeadInfoRsp] | isFriend: " + mainPageControl.isFriend + ", relation is " + mainPageControl.relation);
    }

    private final void R9() {
        LinearLayout linearLayout = this.btnGroupRoot;
        if (linearLayout != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FrameLayout i3 = com.qzone.reborn.feedpro.utils.p.i(context);
            TextView textView = (TextView) i3.findViewById(R.id.ncm);
            textView.setOnClickListener(this.deleteVisitListener);
            this.deleteVisitBtn = textView;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            TextView j3 = com.qzone.reborn.feedpro.utils.p.j(context2, "\u7533\u8bf7\u8bbf\u95ee");
            j3.setOnClickListener(this.applyAccessListener);
            linearLayout.removeAllViews();
            linearLayout.addView(i3, com.qzone.reborn.feedpro.utils.p.m(getContext(), 2));
            linearLayout.addView(j3, com.qzone.reborn.feedpro.utils.p.m(getContext(), 2));
            linearLayout.setVisibility(0);
            W9();
        }
    }

    private final void S9() {
        LinearLayout linearLayout = this.btnGroupRoot;
        if (linearLayout != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TextView j3 = com.qzone.reborn.feedpro.utils.p.j(context, "\u52a0\u597d\u53cb");
            j3.setOnClickListener(this.addFriendListener);
            linearLayout.removeAllViews();
            linearLayout.addView(j3, com.qzone.reborn.feedpro.utils.p.m(getContext(), 1));
            linearLayout.setVisibility(0);
        }
    }

    private final void T9() {
        LinearLayout linearLayout = this.btnGroupRoot;
        if (linearLayout != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FrameLayout i3 = com.qzone.reborn.feedpro.utils.p.i(context);
            TextView textView = (TextView) i3.findViewById(R.id.ncm);
            textView.setOnClickListener(this.deleteVisitListener);
            this.deleteVisitBtn = textView;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            TextView k3 = com.qzone.reborn.feedpro.utils.p.k(context2, "\u7533\u8bf7\u8bbf\u95ee");
            k3.setOnClickListener(this.applyAccessListener);
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            TextView j3 = com.qzone.reborn.feedpro.utils.p.j(context3, "\u52a0\u597d\u53cb");
            j3.setOnClickListener(this.addFriendListener);
            linearLayout.removeAllViews();
            linearLayout.addView(i3, com.qzone.reborn.feedpro.utils.p.m(getContext(), 3));
            linearLayout.addView(k3, com.qzone.reborn.feedpro.utils.p.m(getContext(), 3));
            linearLayout.addView(j3, com.qzone.reborn.feedpro.utils.p.m(getContext(), 3));
            linearLayout.setVisibility(0);
            W9();
        }
    }

    private final void U9() {
        LinearLayout linearLayout = this.btnGroupRoot;
        if (linearLayout != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TextView j3 = com.qzone.reborn.feedpro.utils.p.j(context, "\u52a0\u597d\u53cb");
            j3.setOnClickListener(this.addFriendListener);
            linearLayout.removeAllViews();
            linearLayout.addView(j3, com.qzone.reborn.feedpro.utils.p.m(getContext(), 1));
            linearLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void W9() {
        if (ar.INSTANCE.b("kenaiyu", "2024-12-05", "vas_bug_132247101").isEnable(true)) {
            na.e.f419543a.e(new Function0<Unit>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeBtnGroupPart$requestVipInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    QzoneFeedProUserHomeBtnGroupPart.this.isRealVip = true;
                }
            });
        }
    }

    private final void initViewModel() {
        MutableLiveData<wd.h> d26;
        com.qzone.reborn.feedpro.viewmodel.m mVar = (com.qzone.reborn.feedpro.viewmodel.m) getViewModel(com.qzone.reborn.feedpro.viewmodel.m.class);
        this.userHomeViewModel = mVar;
        if (mVar != null && (d26 = mVar.d2()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<wd.h, Unit> function1 = new Function1<wd.h, Unit>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeBtnGroupPart$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(wd.h hVar) {
                    invoke2(hVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(wd.h hVar) {
                    GetMainPageHeadRsp headRsp = hVar.getHeadRsp();
                    if (headRsp != null) {
                        QzoneFeedProUserHomeBtnGroupPart.this.Q9(headRsp);
                    }
                }
            };
            d26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.part.userhome.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QzoneFeedProUserHomeBtnGroupPart.V9(Function1.this, obj);
                }
            });
        }
        com.qzone.reborn.feedpro.viewmodel.q qVar = (com.qzone.reborn.feedpro.viewmodel.q) getViewModel(com.qzone.reborn.feedpro.viewmodel.q.class);
        this.forbiddenViewModel = qVar;
        if (qVar != null) {
            com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.userHomeViewModel;
            qVar.U1(mVar2 != null ? mVar2.getUserHomeManager() : null);
        }
        com.qzone.reborn.feedpro.viewmodel.q qVar2 = this.forbiddenViewModel;
        if (qVar2 != null) {
            qVar2.Z1(new b());
        }
        com.qzone.reborn.feedpro.viewmodel.q qVar3 = this.forbiddenViewModel;
        if (qVar3 == null) {
            return;
        }
        qVar3.X1(new c());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String str;
        String l3;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 14) {
            String str2 = "";
            if (data == null || (str = data.getStringExtra("apply_content")) == null) {
                str = "";
            }
            com.qzone.reborn.feedpro.viewmodel.q qVar = this.forbiddenViewModel;
            if (qVar != null) {
                com.qzone.reborn.feedpro.viewmodel.m mVar = this.userHomeViewModel;
                if (mVar != null && (l3 = Long.valueOf(mVar.getHostUin()).toString()) != null) {
                    str2 = l3;
                }
                qVar.M1(str2, str);
            }
        }
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        initViewModel();
        Intrinsics.checkNotNull(rootView);
        View inflate = ((ViewStub) rootView.findViewById(R.id.ncn)).inflate();
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.btnGroupRoot = linearLayout;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(boolean isSuccess, String errMsg) {
        if (isSuccess) {
            QQToastUtil.showQQToastInUiThread(0, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSendVisitApply", "\u5df2\u53d1\u9001\u8bbf\u95ee\u7533\u8bf7"));
        } else {
            QQToastUtil.showQQToastInUiThread(0, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(boolean isSuccess, String errMsg) {
        if (isSuccess) {
            QQToastUtil.showQQToastInUiThread(0, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastDeletedVisitRecord", "\u5df2\u5220\u9664\u672c\u6b21\u8bbf\u95ee\u8bb0\u5f55"));
            TextView textView = this.deleteVisitBtn;
            if (textView == null) {
                return;
            }
            textView.setText("\u5df2\u5220\u8bb0\u5f55");
            return;
        }
        QQToastUtil.showQQToastInUiThread(0, errMsg);
    }
}
