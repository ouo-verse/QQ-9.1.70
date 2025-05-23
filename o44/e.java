package o44;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.qqnt.kernel.nativeinterface.RobotMetricsInfo;
import com.tencent.robot.profile.data.RobotProfileAvatarHeaderData;
import com.tencent.robot.profile.data.g;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import n44.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0017\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002J\f\u0010\r\u001a\u00020\u000b*\u00020\nH\u0002J\f\u0010\u000e\u001a\u00020\u000b*\u00020\nH\u0002J\f\u0010\u000f\u001a\u00020\u000b*\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J*\u0010#\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00112\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0014R\u0016\u0010&\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0016\u00101\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u0016\u00103\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010(\u00a8\u00068"}, d2 = {"Lo44/e;", "Ln44/f;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotMetricsInfo;", "robotMetricsInfo", "", "y", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "r", "", "", "v", "t", "u", "w", "Landroid/content/Context;", "", "drawableResId", "Landroid/graphics/drawable/Drawable;", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/widget/TextView;", "valueTextView", "titleTextView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/robot/profile/data/g;", "data", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "e", "Landroid/view/View;", "metricsLayout", "f", "Landroid/widget/TextView;", "hotValueView", h.F, "hotTitleView", "i", "friendOrGroupValueView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "friendOrGroupTitleView", BdhLogUtil.LogTag.Tag_Conn, "sessionValueView", "D", "sessionTitleView", "<init>", "()V", "E", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends f {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView sessionValueView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView sessionTitleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View metricsLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView hotValueView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView hotTitleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView friendOrGroupValueView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView friendOrGroupTitleView;

    private final void A(TextView valueTextView, TextView titleTextView) {
        valueTextView.setTextColor(valueTextView.getContext().getColorStateList(R.color.qui_common_text_primary));
        titleTextView.setTextColor(titleTextView.getContext().getColorStateList(R.color.qui_common_text_secondary));
    }

    private final void p(RobotMetricsInfo robotMetricsInfo) {
        TextView textView = null;
        if (x(robotMetricsInfo)) {
            TextView textView2 = this.friendOrGroupValueView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupValueView");
                textView2 = null;
            }
            textView2.setText(t(robotMetricsInfo.friendCount));
            TextView textView3 = this.friendOrGroupTitleView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupTitleView");
                textView3 = null;
            }
            Context context = textView3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "friendOrGroupTitleView.context");
            Drawable s16 = s(context, R.drawable.qui_user_icon_secondary);
            TextView textView4 = this.friendOrGroupTitleView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupTitleView");
                textView4 = null;
            }
            textView4.setCompoundDrawables(s16, null, null, null);
            TextView textView5 = this.friendOrGroupTitleView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupTitleView");
                textView5 = null;
            }
            textView5.setText(R.string.f222686e7);
            TextView textView6 = this.friendOrGroupValueView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupValueView");
                textView6 = null;
            }
            TextView textView7 = this.friendOrGroupTitleView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupTitleView");
            } else {
                textView = textView7;
            }
            A(textView6, textView);
            return;
        }
        TextView textView8 = this.friendOrGroupValueView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupValueView");
            textView8 = null;
        }
        textView8.setText(u(robotMetricsInfo.joinedGroupCount));
        TextView textView9 = this.friendOrGroupTitleView;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupTitleView");
            textView9 = null;
        }
        Context context2 = textView9.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "friendOrGroupTitleView.context");
        Drawable s17 = s(context2, R.drawable.qui_group_icon_secondary);
        TextView textView10 = this.friendOrGroupTitleView;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupTitleView");
            textView10 = null;
        }
        textView10.setCompoundDrawables(s17, null, null, null);
        TextView textView11 = this.friendOrGroupTitleView;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupTitleView");
            textView11 = null;
        }
        textView11.setText(R.string.f222696e8);
        TextView textView12 = this.friendOrGroupValueView;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupValueView");
            textView12 = null;
        }
        TextView textView13 = this.friendOrGroupTitleView;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("friendOrGroupTitleView");
        } else {
            textView = textView13;
        }
        A(textView12, textView);
    }

    private final void q(RobotMetricsInfo robotMetricsInfo) {
        TextView textView = this.hotValueView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotValueView");
            textView = null;
        }
        textView.setText(v(robotMetricsInfo.hot));
        TextView textView3 = this.hotTitleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotTitleView");
            textView3 = null;
        }
        Context context = textView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "hotTitleView.context");
        Drawable s16 = s(context, R.drawable.qui_operation_icon_secondary);
        TextView textView4 = this.hotTitleView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotTitleView");
            textView4 = null;
        }
        textView4.setCompoundDrawables(s16, null, null, null);
        TextView textView5 = this.hotValueView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotValueView");
            textView5 = null;
        }
        TextView textView6 = this.hotTitleView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hotTitleView");
        } else {
            textView2 = textView6;
        }
        A(textView5, textView2);
    }

    private final void r(RobotMetricsInfo robotMetricsInfo) {
        TextView textView = this.sessionValueView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionValueView");
            textView = null;
        }
        textView.setText(w(robotMetricsInfo.chatCount));
        TextView textView3 = this.sessionTitleView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionTitleView");
            textView3 = null;
        }
        Context context = textView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "sessionTitleView.context");
        Drawable s16 = s(context, R.drawable.qui_message_icon_secondary);
        TextView textView4 = this.sessionTitleView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionTitleView");
            textView4 = null;
        }
        textView4.setCompoundDrawables(s16, null, null, null);
        TextView textView5 = this.sessionValueView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionValueView");
            textView5 = null;
        }
        TextView textView6 = this.sessionTitleView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionTitleView");
        } else {
            textView2 = textView6;
        }
        A(textView5, textView2);
    }

    private final Drawable s(Context context, @DrawableRes int i3) {
        Drawable drawable = ContextCompat.getDrawable(context, i3);
        if (drawable != null) {
            drawable.setBounds(0, 0, ViewUtils.dip2px(14.0f), ViewUtils.dip2px(14.0f));
            return drawable;
        }
        return null;
    }

    private final String t(long j3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (Long.MIN_VALUE <= j3 && j3 < 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        if (1 <= j3 && j3 < 1000) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return String.valueOf(j3);
        }
        if (1000 <= j3 && j3 < 10000) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d\u5343+", Arrays.copyOf(new Object[]{Long.valueOf(j3 / 1000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (10000 <= j3 && j3 < JsonGrayBusiId.UI_RESERVE_100000_110000) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%d\u4e07+", Arrays.copyOf(new Object[]{Long.valueOf(j3 / 10000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        return "10\u4e07+";
    }

    private final String u(long j3) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (Long.MIN_VALUE <= j3 && j3 < 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        if (1 <= j3 && j3 < 1000) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return String.valueOf(j3);
        }
        if (1000 <= j3 && j3 < 10000) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d\u5343+", Arrays.copyOf(new Object[]{Long.valueOf(j3 / 1000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return "1\u4e07+";
    }

    private final String v(long j3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (Long.MIN_VALUE <= j3 && j3 < 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        if (1 <= j3 && j3 < 1000) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return String.valueOf(j3);
        }
        if (1000 <= j3 && j3 < 10000) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d\u5343+", Arrays.copyOf(new Object[]{Long.valueOf(j3 / 1000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (10000 <= j3 && j3 < 1000000) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%d\u4e07+", Arrays.copyOf(new Object[]{Long.valueOf(j3 / 10000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        return "100\u4e07+";
    }

    private final String w(long j3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (Long.MIN_VALUE <= j3 && j3 < 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        if (1 <= j3 && j3 < 1000) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return String.valueOf(j3);
        }
        if (1000 <= j3 && j3 < 10000) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d\u5343+", Arrays.copyOf(new Object[]{Long.valueOf(j3 / 1000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (10000 <= j3 && j3 < 1000000) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%d\u4e07+", Arrays.copyOf(new Object[]{Long.valueOf(j3 / 10000)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        return "100\u4e07+";
    }

    private final boolean x(RobotMetricsInfo robotMetricsInfo) {
        if (robotMetricsInfo.friendCount > 0) {
            return true;
        }
        return false;
    }

    private final boolean y(RobotMetricsInfo robotMetricsInfo) {
        if (QLog.isColorLevel()) {
            QLog.i("RobotMetricsInfoSection", 2, "[isValid] robotMetricsInfo: " + robotMetricsInfo);
        }
        if (robotMetricsInfo.hot > 0 && ((robotMetricsInfo.friendCount > 0 || robotMetricsInfo.joinedGroupCount > 0) && robotMetricsInfo.chatCount > 0)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f770343_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026obot_metrics_info_layout)");
        this.metricsLayout = findViewById;
        View findViewById2 = containerView.findViewById(R.id.f7702439);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026.robot_metrics_hot_value)");
        this.hotValueView = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f7701438);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026.robot_metrics_hot_title)");
        this.hotTitleView = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.f7700437);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026cs_friend_or_group_value)");
        this.friendOrGroupValueView = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f7699436);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026cs_friend_or_group_title)");
        this.friendOrGroupTitleView = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.f770543b);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026ot_metrics_session_value)");
        this.sessionValueView = (TextView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.f770443a);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026ot_metrics_session_title)");
        this.sessionTitleView = (TextView) findViewById7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable g data, int position, @Nullable List<Object> payload) {
        RobotProfileAvatarHeaderData robotProfileAvatarHeaderData;
        View view = null;
        if (data instanceof RobotProfileAvatarHeaderData) {
            robotProfileAvatarHeaderData = (RobotProfileAvatarHeaderData) data;
        } else {
            robotProfileAvatarHeaderData = null;
        }
        if (robotProfileAvatarHeaderData != null) {
            boolean y16 = y(robotProfileAvatarHeaderData.getRobotMetricsInfo());
            View view2 = this.metricsLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("metricsLayout");
            } else {
                view = view2;
            }
            Boolean valueOf = Boolean.valueOf(y16);
            view.setVisibility(0);
            if (((View) au.a(valueOf, view)) == null) {
                view.setVisibility(8);
            }
            if (y16) {
                q(robotProfileAvatarHeaderData.getRobotMetricsInfo());
                p(robotProfileAvatarHeaderData.getRobotMetricsInfo());
                r(robotProfileAvatarHeaderData.getRobotMetricsInfo());
                new com.tencent.videocut.utils.dsl.b();
                return;
            }
            new com.tencent.videocut.utils.dsl.a(y16);
        }
    }
}
