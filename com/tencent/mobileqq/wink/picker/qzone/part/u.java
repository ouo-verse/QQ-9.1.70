package com.tencent.mobileqq.wink.picker.qzone.part;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import cooperation.qzone.util.DateUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/part/u;", "Lcom/tencent/biz/richframework/part/Part;", "", "z9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "d", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "qZoneInitBean", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titlePublishMoodIcon", "", "f", "Ljava/lang/String;", "guidePublishMoodText", "<init>", "(Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;)V", tl.h.F, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class u extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QZoneInitBean qZoneInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView titlePublishMoodIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guidePublishMoodText;

    public u(@NotNull QZoneInitBean qZoneInitBean) {
        Intrinsics.checkNotNullParameter(qZoneInitBean, "qZoneInitBean");
        this.qZoneInitBean = qZoneInitBean;
        this.guidePublishMoodText = "";
        this.guidePublishMoodText = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_guide_publish_mood_bubble_text", "\u70b9\u8fd9\u91cc\u53d1\u6587\u5b57\u6d88\u606f");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchPublishMoodPage(this$0.getContext());
        this$0.getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void z9() {
        if (!this.qZoneInitBean.getShowTitlePublishMoodBtn()) {
            TextView textView = this.titlePublishMoodIcon;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.titlePublishMoodIcon;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.titlePublishMoodIcon;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.A9(u.this, view);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.titlePublishMoodIcon = (TextView) rootView.findViewById(R.id.f29020ki);
        z9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        if (uq3.k.a().e("guide_publish_bubble_last_show_times", 0) >= 3) {
            QLog.i("QZoneMediaTitlePublishTextMoodPart", 1, "has reached show limitation, no need to show");
            return;
        }
        if (DateUtils.isSameDay(uq3.k.a().f("guide_publish_bubble_last_show_time", 0L), System.currentTimeMillis())) {
            QLog.i("QZoneMediaTitlePublishTextMoodPart", 1, "same day, no need to show");
            return;
        }
        QUIDefaultBubbleTip.r(activity).S(this.titlePublishMoodIcon).m0(5).o0(this.guidePublishMoodText).R(0).k0(1).f0(false).s0();
        uq3.k.a().m("guide_publish_bubble_last_show_times", uq3.k.a().e("guide_publish_bubble_last_show_times", 0) + 1);
        uq3.k.a().n("guide_publish_bubble_last_show_time", System.currentTimeMillis());
    }
}
