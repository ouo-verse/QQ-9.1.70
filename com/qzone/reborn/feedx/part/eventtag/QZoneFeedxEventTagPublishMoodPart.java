package com.qzone.reborn.feedx.part.eventtag;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.reborn.feedx.viewmodel.QZoneFeedxEventTagViewModel;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import common.config.service.QZoneConfigHelper;
import eo.c;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StButton;
import qzone.QZoneTagFeedList$GetTagFeedListHeadRsp;
import qzone.QZoneTagFeedList$PopularityInfo;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedx/part/eventtag/QZoneFeedxEventTagPublishMoodPart;", "Lcom/qzone/reborn/base/k;", "", "initViewModel", "Lqzone/QZoneTagFeedList$GetTagFeedListHeadRsp;", "it", "J9", "", "actionUrl", "H9", "Landroid/view/View;", "v", "G9", "I9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "mPublishContainer", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "e", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mPublishAvatarView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mPublishBtnText", "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", tl.h.F, "Lcom/qzone/reborn/feedx/viewmodel/QZoneFeedxEventTagViewModel;", "mEventTagViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxEventTagPublishMoodPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mPublishContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mPublishAvatarView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mPublishBtnText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxEventTagViewModel mEventTagViewModel;

    private final void G9(View v3) {
        PBRepeatField<String> pBRepeatField;
        PBStringField pBStringField;
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = this.mEventTagViewModel;
        String str = null;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        QZoneTagFeedList$GetTagFeedListHeadRsp value = qZoneFeedxEventTagViewModel.w2().getValue();
        if (value == null || getActivity() == null) {
            return;
        }
        eo.c.f396879a.b();
        QZoneBaseMeta$StButton qZoneBaseMeta$StButton = value.publish_button;
        if (qZoneBaseMeta$StButton != null && (pBStringField = qZoneBaseMeta$StButton.actionurl) != null) {
            str = pBStringField.get();
        }
        if (!TextUtils.isEmpty(str)) {
            yo.d.b(getContext(), new yo.g(str));
            return;
        }
        PublishEventTag publishEventTag = new PublishEventTag();
        publishEventTag.title = value.tag_name.get();
        publishEventTag.desc = value.tag_intro.get();
        QZoneTagFeedList$PopularityInfo qZoneTagFeedList$PopularityInfo = value.popularity;
        publishEventTag.descTruncateNum = (qZoneTagFeedList$PopularityInfo == null || (pBRepeatField = qZoneTagFeedList$PopularityInfo.disciption) == null) ? 0 : pBRepeatField.size();
        publishEventTag.f45887protocol = I9();
        publishEventTag.picUrl = QZoneConfigHelper.Q();
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0("shuoshuoPlus");
        qZonePublishMoodInitBean.O0(21);
        qZonePublishMoodInitBean.v0(bool);
        if (!TextUtils.isEmpty(publishEventTag.title) && !TextUtils.isEmpty(publishEventTag.f45887protocol)) {
            qZonePublishMoodInitBean.J0(um.a.b(publishEventTag));
        }
        qZonePublishMoodInitBean.q0(Boolean.TRUE);
        ho.i.w().c(getActivity(), qZonePublishMoodInitBean);
        ClickReport.q("629", "2", "", true);
    }

    private final void H9(String actionUrl) {
        HashMap hashMap = new HashMap();
        TextView textView = this.mPublishBtnText;
        LinearLayout linearLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishBtnText");
            textView = null;
        }
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "mPublishBtnText.text");
        hashMap.put("relation_content", text);
        hashMap.put("function_url", actionUrl);
        fo.b h16 = new fo.b().l(hashMap).j(EndExposurePolicy.REPORT_NONE).h(new c.a());
        LinearLayout linearLayout2 = this.mPublishContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishContainer");
        } else {
            linearLayout = linearLayout2;
        }
        fo.c.o(linearLayout, "em_qz_publish_button_master_mode", h16);
    }

    private final String I9() {
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = this.mEventTagViewModel;
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel2 = null;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        QZoneTagFeedList$GetTagFeedListHeadRsp value = qZoneFeedxEventTagViewModel.w2().getValue();
        if (value == null) {
            return "";
        }
        String str = value.tag_uin.get();
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel3 = this.mEventTagViewModel;
        if (qZoneFeedxEventTagViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
        } else {
            qZoneFeedxEventTagViewModel2 = qZoneFeedxEventTagViewModel3;
        }
        return str + "_11" + qZoneFeedxEventTagViewModel2.v2().getSource2() + "_" + value.tag_name.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(QZoneTagFeedList$GetTagFeedListHeadRsp it) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        LinearLayout linearLayout = this.mPublishContainer;
        String str = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        QZoneBaseMeta$StButton qZoneBaseMeta$StButton = it.publish_button;
        if (!TextUtils.isEmpty((qZoneBaseMeta$StButton == null || (pBStringField3 = qZoneBaseMeta$StButton.text) == null) ? null : pBStringField3.get())) {
            TextView textView = this.mPublishBtnText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishBtnText");
                textView = null;
            }
            QZoneBaseMeta$StButton qZoneBaseMeta$StButton2 = it.publish_button;
            textView.setText((qZoneBaseMeta$StButton2 == null || (pBStringField2 = qZoneBaseMeta$StButton2.text) == null) ? null : pBStringField2.get());
        } else {
            TextView textView2 = this.mPublishBtnText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPublishBtnText");
                textView2 = null;
            }
            textView2.setText(com.qzone.util.l.a(R.string.mvq));
        }
        QZoneUserAvatarView qZoneUserAvatarView = this.mPublishAvatarView;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishAvatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setIsShieldJumpToMainPage(true);
        QZoneUserAvatarView qZoneUserAvatarView2 = this.mPublishAvatarView;
        if (qZoneUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishAvatarView");
            qZoneUserAvatarView2 = null;
        }
        qZoneUserAvatarView2.setUser(LoginData.getInstance().getUin());
        QZoneBaseMeta$StButton qZoneBaseMeta$StButton3 = it.publish_button;
        if (qZoneBaseMeta$StButton3 != null && (pBStringField = qZoneBaseMeta$StButton3.actionurl) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            str = "";
        }
        H9(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZoneFeedxEventTagPublishMoodPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.G9(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(QZoneFeedxEventTagPublishMoodPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.G9(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QZoneFeedxEventTagViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneFeedxE\u2026TagViewModel::class.java)");
        QZoneFeedxEventTagViewModel qZoneFeedxEventTagViewModel = (QZoneFeedxEventTagViewModel) viewModel;
        this.mEventTagViewModel = qZoneFeedxEventTagViewModel;
        if (qZoneFeedxEventTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEventTagViewModel");
            qZoneFeedxEventTagViewModel = null;
        }
        MutableLiveData<QZoneTagFeedList$GetTagFeedListHeadRsp> w26 = qZoneFeedxEventTagViewModel.w2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit> function1 = new Function1<QZoneTagFeedList$GetTagFeedListHeadRsp, Unit>() { // from class: com.qzone.reborn.feedx.part.eventtag.QZoneFeedxEventTagPublishMoodPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                invoke2(qZoneTagFeedList$GetTagFeedListHeadRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QZoneTagFeedList$GetTagFeedListHeadRsp qZoneTagFeedList$GetTagFeedListHeadRsp) {
                if (qZoneTagFeedList$GetTagFeedListHeadRsp != null) {
                    QZoneFeedxEventTagPublishMoodPart.this.J9(qZoneTagFeedList$GetTagFeedListHeadRsp);
                }
            }
        };
        w26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedx.part.eventtag.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneFeedxEventTagPublishMoodPart.K9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxEventTagPublishMoodPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f162830mv1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026g_publish_mood_container)");
        this.mPublishContainer = (LinearLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162829mv0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_tag_publish_mood_avatar)");
        this.mPublishAvatarView = (QZoneUserAvatarView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f162831mv2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026nt_tag_publish_mood_text)");
        this.mPublishBtnText = (TextView) findViewById3;
        initViewModel();
        LinearLayout linearLayout = this.mPublishContainer;
        QZoneUserAvatarView qZoneUserAvatarView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishContainer");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.eventtag.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFeedxEventTagPublishMoodPart.L9(QZoneFeedxEventTagPublishMoodPart.this, view);
            }
        });
        QZoneUserAvatarView qZoneUserAvatarView2 = this.mPublishAvatarView;
        if (qZoneUserAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPublishAvatarView");
        } else {
            qZoneUserAvatarView = qZoneUserAvatarView2;
        }
        qZoneUserAvatarView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.eventtag.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFeedxEventTagPublishMoodPart.M9(QZoneFeedxEventTagPublishMoodPart.this, view);
            }
        });
    }
}
