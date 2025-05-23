package p44;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.profile.data.RobotQZoneInfoData;
import com.tencent.robot.profile.event.RobotProfileFetchDataEvent;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000e\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0014R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lp44/g;", "Ln44/f;", "", "t", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/robot/profile/data/g;", "data", "", "position", "", "", "payload", "r", "e", "Landroid/view/View;", "icon", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/LinearLayout;", h.F, "Landroid/widget/LinearLayout;", "tipLL", "i", "tipTv", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "imageArrow", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g extends n44.f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View icon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView titleTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout tipLL;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tipTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView imageArrow;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(com.tencent.robot.profile.data.g gVar, g this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        RobotQZoneInfoData robotQZoneInfoData = (RobotQZoneInfoData) gVar;
        userInfo.qzone_uin = robotQZoneInfoData.getRobotUin();
        userInfo.nickname = robotQZoneInfoData.getName();
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.actionType = "1";
        reportInfo.subactionType = "0";
        reportInfo.tabletype = 4;
        reportInfo.sourceType = "3";
        reportInfo.sourceFrom = QZoneClickReport.ClickReportConfig.SOURCE_FROM_USERPROFILE;
        reportInfo.sourceTo = QZoneClickReport.ClickReportConfig.SOURCE_TO_USERHOME;
        QZoneClickReport.startReportImediately(RFWApplication.getAccountId(), reportInfo);
        LinearLayout linearLayout = this$0.tipLL;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipLL");
            linearLayout = null;
        }
        if (linearLayout.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            LinearLayout linearLayout3 = this$0.tipLL;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipLL");
            } else {
                linearLayout2 = linearLayout3;
            }
            linearLayout2.setVisibility(8);
            SimpleEventBus.getInstance().dispatchEvent(new RobotProfileFetchDataEvent(500L));
        }
        QZoneHelper.forwardToUserHome(this$0.getRootView().getContext(), userInfo, robotQZoneInfoData.getRobotUin(), 0, -1, 5, null, null, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void t() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: p44.f
            @Override // java.lang.Runnable
            public final void run() {
                g.u(g.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.setElementId(this$0.getRootView(), "em_qz_space_entrance");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.icon)");
        this.icon = findViewById;
        View findViewById2 = containerView.findViewById(R.id.jj7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.text_title)");
        this.titleTv = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.zpp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026d.new_content_tip_layout)");
        this.tipLL = (LinearLayout) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.zpo);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.new_content_tip)");
        this.tipTv = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.dcv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.image_arrow)");
        this.imageArrow = (ImageView) findViewById5;
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final com.tencent.robot.profile.data.g data, int position, @Nullable List<Object> payload) {
        if (!(data instanceof RobotQZoneInfoData)) {
            QLog.e("RobotQZonePersonalInfoSection", 1, "onBindData data is not RobotQZoneInfoData");
            return;
        }
        View view = this.icon;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            view = null;
        }
        view.setBackground(ContextCompat.getDrawable(getRootView().getContext(), R.drawable.qui_qq_zone));
        TextView textView2 = this.titleTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView2 = null;
        }
        textView2.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_primary));
        TextView textView3 = this.tipTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipTv");
            textView3 = null;
        }
        textView3.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_primary));
        ImageView imageView = this.imageArrow;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageArrow");
            imageView = null;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(getRootView().getContext(), R.drawable.qui_chevron_right_icon_secondary_01));
        TextView textView4 = this.titleTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView4 = null;
        }
        textView4.setText(HardCodeUtil.qqStr(R.string.f222776ef));
        TextView textView5 = this.titleTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView5 = null;
        }
        textView5.setSingleLine(true);
        TextView textView6 = this.titleTv;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
            textView6 = null;
        }
        textView6.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        RobotQZoneInfoData robotQZoneInfoData = (RobotQZoneInfoData) data;
        if (!TextUtils.isEmpty(robotQZoneInfoData.getQZoneInfo().updateTipsString)) {
            TextView textView7 = this.tipTv;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipTv");
                textView7 = null;
            }
            textView7.setText(robotQZoneInfoData.getQZoneInfo().updateTipsString);
            LinearLayout linearLayout = this.tipLL;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipLL");
                linearLayout = null;
            }
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = this.tipLL;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tipLL");
                linearLayout2 = null;
            }
            linearLayout2.setVisibility(8);
        }
        View rootView = getRootView();
        TextView textView8 = this.titleTv;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        } else {
            textView = textView8;
        }
        rootView.setContentDescription(textView.getText());
        getRootView().setBackground(ContextCompat.getDrawable(getRootView().getContext(), R.drawable.liw));
        getRootView().setOnClickListener(new View.OnClickListener() { // from class: p44.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.s(com.tencent.robot.profile.data.g.this, this, view2);
            }
        });
    }
}
