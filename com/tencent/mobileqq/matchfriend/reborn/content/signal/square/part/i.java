package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import java.util.HashMap;
import k82.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 A2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0003H\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010&R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010>\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/part/i;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBasePart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/viewmodel/QQStrangerSignalSquareSelfSignalViewModel;", "Lk82/a;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "M9", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "signalInfo", "", "justNowPublish", "I9", "U9", "R9", "Z9", "X9", "Y9", "aa", "", "state", "V9", "T9", "S9", "L9", "publishView", "Q9", "P9", "K9", "onInitView", "event", "J9", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "d", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "e", "Landroid/view/View;", "signalPublishView", "f", "signalBgAssistView", tl.h.F, "signalTitleBgView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "signalTitleNameView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "signalTitleIconBgView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "signalTitleIconView", "D", "I", "lastState", "E", "Z", "hasShowExpireAtSoonBubbleTips", "H9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/viewmodel/QQStrangerSignalSquareSelfSignalViewModel;", "viewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class i extends QQStrangerSignalBasePart<QQStrangerSignalSquareSelfSignalViewModel, k82.a, Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView signalTitleIconView;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastState = -1;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasShowExpireAtSoonBubbleTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar quiSecNavBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View signalPublishView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View signalBgAssistView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View signalTitleBgView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView signalTitleNameView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View signalTitleIconBgView;

    private final void K9(View publishView) {
        VideoReport.setElementId(publishView, "em_kl_publish_btn_no_sign");
        VideoReport.setElementExposePolicy(publishView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(publishView, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(publishView, EndExposurePolicy.REPORT_NONE);
    }

    private final void L9(int state) {
        View view = this.signalTitleBgView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view = null;
        }
        VideoReport.setElementId(view, "em_kl_publish_btn");
        View view3 = this.signalTitleBgView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view3 = null;
        }
        VideoReport.setElementParam(view3, "kl_state", Integer.valueOf(state));
        View view4 = this.signalTitleBgView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view4 = null;
        }
        VideoReport.setElementExposePolicy(view4, ExposurePolicy.REPORT_NONE);
        View view5 = this.signalTitleBgView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view5 = null;
        }
        VideoReport.setElementEndExposePolicy(view5, EndExposurePolicy.REPORT_NONE);
        View view6 = this.signalTitleBgView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
        } else {
            view2 = view6;
        }
        VideoReport.setElementClickPolicy(view2, ClickPolicy.REPORT_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(i this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(i this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).openSignalPublisher(it.getContext(), false);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.P9(it);
    }

    private final void P9(View publishView) {
        K9(publishView);
        VideoReport.reportEvent("clck", publishView, null);
    }

    private final void Q9(View publishView) {
        if (this.lastState == 0) {
            return;
        }
        K9(publishView);
        VideoReport.reportEvent("imp", publishView, null);
    }

    private final void R9() {
        if (this.hasShowExpireAtSoonBubbleTips) {
            return;
        }
        this.hasShowExpireAtSoonBubbleTips = true;
        View view = this.signalTitleBgView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view = null;
        }
        VideoReport.setElementId(view, "em_kl_expansion_list_hint");
        View view3 = this.signalTitleBgView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view3 = null;
        }
        VideoReport.setElementExposePolicy(view3, ExposurePolicy.REPORT_NONE);
        View view4 = this.signalTitleBgView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view4 = null;
        }
        VideoReport.setElementEndExposePolicy(view4, EndExposurePolicy.REPORT_NONE);
        View view5 = this.signalTitleBgView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view5 = null;
        }
        VideoReport.setElementClickPolicy(view5, ClickPolicy.REPORT_NONE);
        View view6 = this.signalTitleBgView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
        } else {
            view2 = view6;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_pgid", "pg_kl_expansion_list");
        hashMap.put("qq_eid", "em_kl_expansion_list_hint");
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("qq_imp", view2, hashMap);
    }

    private final void S9(int state) {
        L9(state);
        View view = this.signalTitleBgView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view = null;
        }
        VideoReport.reportEvent("clck", view, null);
    }

    private final void T9(int state) {
        if (this.lastState != state || state == 1) {
            L9(state);
            View view = this.signalTitleBgView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
                view = null;
            }
            VideoReport.reportEvent("imp", view, null);
        }
    }

    private final void U9() {
        View view = this.signalTitleBgView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view = null;
        }
        QUIDefaultBubbleTip.r(view.getContext()).S(view).o0(view.getContext().getString(R.string.f169682x10)).k0(1).R(0).m0(3).s0();
        A9().U1();
        R9();
    }

    private final void V9(final SignalPlazaSvrPB$SignalInfo signalInfo, final int state) {
        View view = this.signalPublishView;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalPublishView");
            view = null;
        }
        view.setVisibility(8);
        View view2 = this.signalBgAssistView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalBgAssistView");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.signalTitleBgView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view3 = null;
        }
        view3.setVisibility(0);
        TextView textView = this.signalTitleNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleNameView");
            textView = null;
        }
        textView.setVisibility(0);
        View view4 = this.signalTitleIconBgView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconBgView");
            view4 = null;
        }
        view4.setVisibility(0);
        ImageView imageView2 = this.signalTitleIconView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconView");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        View view5 = this.signalTitleBgView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view5 = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        SignalPB$SignalConfig signalPB$SignalConfig = signalInfo.signal_meta.config;
        Intrinsics.checkNotNullExpressionValue(signalPB$SignalConfig, "signalInfo.signal_meta.config");
        gradientDrawable.setColor(ModelExtKt.d(signalPB$SignalConfig));
        gradientDrawable.setCornerRadius(l.a(4.0f));
        view5.setBackground(gradientDrawable);
        View view6 = this.signalTitleBgView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view6 = null;
        }
        view6.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view7) {
                i.W9(SignalPlazaSvrPB$SignalInfo.this, this, state, view7);
            }
        }, 1, null));
        TextView textView2 = this.signalTitleNameView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleNameView");
            textView2 = null;
        }
        textView2.setText(signalInfo.signal_meta.partner_name.get());
        ImageView imageView3 = this.signalTitleIconView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconView");
        } else {
            imageView = imageView3;
        }
        String str = signalInfo.signal_meta.config.icon.get();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = l.b(24);
        obtain.mRequestHeight = l.b(24);
        Unit unit = Unit.INSTANCE;
        imageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        T9(state);
        this.lastState = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(SignalPlazaSvrPB$SignalInfo signalInfo, i this$0, int i3, View view) {
        Intrinsics.checkNotNullParameter(signalInfo, "$signalInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).openSignalPublisher(view.getContext(), true, signalInfo.signal_meta.partner_id.get(), signalInfo.signal_meta.partner_adj.partner_adj_id.get());
        this$0.S9(i3);
    }

    private final void aa() {
        View view = this.signalPublishView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalPublishView");
            view = null;
        }
        view.setVisibility(0);
        View view3 = this.signalBgAssistView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalBgAssistView");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.signalTitleBgView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleBgView");
            view4 = null;
        }
        view4.setVisibility(8);
        TextView textView = this.signalTitleNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleNameView");
            textView = null;
        }
        textView.setVisibility(8);
        View view5 = this.signalTitleIconBgView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconBgView");
            view5 = null;
        }
        view5.setVisibility(8);
        ImageView imageView = this.signalTitleIconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconView");
            imageView = null;
        }
        imageView.setVisibility(8);
        View view6 = this.signalPublishView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalPublishView");
        } else {
            view2 = view6;
        }
        Q9(view2);
        this.lastState = 0;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart
    /* renamed from: H9, reason: merged with bridge method [inline-methods] */
    public QQStrangerSignalSquareSelfSignalViewModel A9() {
        ViewModel viewModel = getViewModel(QQStrangerSignalSquareSelfSignalViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QQStrangerS\u2026nalViewModel::class.java)");
        return (QQStrangerSignalSquareSelfSignalViewModel) viewModel;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBasePart
    /* renamed from: J9, reason: merged with bridge method [inline-methods] */
    public void B9(k82.a event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof a.QQStrangerUpdateSelfSignalInfoState) {
            a.QQStrangerUpdateSelfSignalInfoState qQStrangerUpdateSelfSignalInfoState = (a.QQStrangerUpdateSelfSignalInfoState) event;
            I9(qQStrangerUpdateSelfSignalInfoState.getSignalInfo(), qQStrangerUpdateSelfSignalInfoState.getJustNowPublish());
        } else if (event instanceof a.C10641a) {
            U9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        M9(rootView);
        View findViewById = rootView.findViewById(R.id.oq7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026nger_square_title_layout)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        this.quiSecNavBar = qUISecNavBar;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar = null;
        }
        qUISecNavBar.setAutoAdaptTransparent(false);
        QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
        if (qUISecNavBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar2 = null;
        }
        qUISecNavBar2.setTitleAlpha(0.0f);
        QUISecNavBar qUISecNavBar3 = this.quiSecNavBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar3 = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        qUISecNavBar3.R(activity);
        QUISecNavBar qUISecNavBar4 = this.quiSecNavBar;
        if (qUISecNavBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSecNavBar");
            qUISecNavBar4 = null;
        }
        qUISecNavBar4.setBaseClickListener(BaseAction.ACTION_LEFT_BUTTON, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.N9(i.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.oq8);
        findViewById2.setOnClickListener(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.O9(i.this, view);
            }
        }, 1, null));
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Vi\u2026         })\n            }");
        this.signalPublishView = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.oqa);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026uare_title_signal_assist)");
        this.signalBgAssistView = findViewById3;
        View findViewById4 = rootView.findViewById(R.id.oqb);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026r_square_title_signal_bg)");
        this.signalTitleBgView = findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f163179oq4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026er_square_signal_icon_bg)");
        this.signalTitleIconBgView = findViewById5;
        View findViewById6 = rootView.findViewById(R.id.oq3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026anger_square_signal_icon)");
        this.signalTitleIconView = (ImageView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.oq5);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026anger_square_signal_name)");
        this.signalTitleNameView = (TextView) findViewById7;
        A9().T1();
    }

    private final void X9(SignalPlazaSvrPB$SignalInfo signalInfo) {
        V9(signalInfo, 2);
        View view = this.signalTitleIconBgView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconBgView");
            view = null;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(l.b(32), l.b(32));
        layoutParams.bottomToBottom = R.id.oq5;
        layoutParams.endToStart = R.id.oq5;
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.drawable.g4t);
        ImageView imageView = this.signalTitleIconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconView");
        } else {
            view2 = imageView;
        }
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(l.b(20), l.b(20));
        layoutParams2.topToTop = R.id.f163179oq4;
        layoutParams2.startToStart = R.id.f163179oq4;
        layoutParams2.endToEnd = R.id.f163179oq4;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = l.b(5);
        view2.setLayoutParams(layoutParams2);
    }

    private final void Y9(SignalPlazaSvrPB$SignalInfo signalInfo) {
        V9(signalInfo, 3);
        View view = this.signalTitleIconBgView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconBgView");
            view = null;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(l.b(20), l.b(20));
        layoutParams.bottomToBottom = R.id.oq5;
        layoutParams.topToTop = R.id.oq5;
        layoutParams.endToStart = R.id.oq5;
        layoutParams.setMarginEnd(l.b(2));
        view.setLayoutParams(layoutParams);
        view.setBackground(null);
        ImageView imageView = this.signalTitleIconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconView");
        } else {
            view2 = imageView;
        }
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(l.b(20), l.b(20));
        layoutParams2.topToTop = R.id.f163179oq4;
        layoutParams2.bottomToBottom = R.id.f163179oq4;
        layoutParams2.startToStart = R.id.f163179oq4;
        layoutParams2.endToEnd = R.id.f163179oq4;
        view2.setLayoutParams(layoutParams2);
    }

    private final void Z9(SignalPlazaSvrPB$SignalInfo signalInfo) {
        V9(signalInfo, 1);
        View view = this.signalTitleIconBgView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconBgView");
            view = null;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(l.b(40), l.b(40));
        layoutParams.bottomToBottom = R.id.oq5;
        layoutParams.endToStart = R.id.oq5;
        view.setLayoutParams(layoutParams);
        view.setBackgroundResource(R.drawable.g4s);
        ImageView imageView = this.signalTitleIconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleIconView");
        } else {
            view2 = imageView;
        }
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(l.b(24), l.b(24));
        layoutParams2.topToTop = R.id.f163179oq4;
        layoutParams2.startToStart = R.id.f163179oq4;
        layoutParams2.setMarginStart(l.b(7));
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = l.b(5);
        view2.setLayoutParams(layoutParams2);
    }

    private final void I9(SignalPlazaSvrPB$SignalInfo signalInfo, boolean justNowPublish) {
        if (signalInfo == null) {
            aa();
            return;
        }
        if (justNowPublish) {
            Z9(signalInfo);
            return;
        }
        if (ModelExtKt.p(signalInfo)) {
            X9(signalInfo);
        } else if (ModelExtKt.q(signalInfo)) {
            Y9(signalInfo);
        } else {
            aa();
        }
    }

    private final void M9(View rootView) {
        View findViewById = rootView.findViewById(R.id.or6);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = RFWImmersiveUtils.getStatusBarHeight();
            findViewById.setLayoutParams(marginLayoutParams);
        }
    }
}
