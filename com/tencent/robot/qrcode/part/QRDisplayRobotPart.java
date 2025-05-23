package com.tencent.robot.qrcode.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.az;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.data.RobotShareState;
import com.tencent.robot.qrcode.widget.RobotQRCodeLoadingComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0003J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u0018\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0017J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010&R\u0016\u00103\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010.R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010.R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/robot/qrcode/part/QRDisplayRobotPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "Q9", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "avatarView", "", PhotoCategorySummaryInfo.AVATAR_URL, "H9", "I9", "initData", "M9", "Landroid/content/Context;", "context", "N9", "Landroid/view/View;", "view", "O9", "P9", "Landroid/graphics/Bitmap;", "S9", "action", "", "args", "getMessage", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "d", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "avatar", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "bannedLayout", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mCardPart", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "nameText", "i", "normCardLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "normProfileContainer", "Landroidx/cardview/widget/CardView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/cardview/widget/CardView;", "normalCardView", "D", "normalTips", "Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent;", "E", "Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent;", CommonConstant.KEY_QR_CODE, UserInfo.SEX_FEMALE, "robotDescText", "Lw44/a;", "G", "Lw44/a;", "viewModel", "<init>", "()V", "H", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QRDisplayRobotPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private CardView normalCardView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView normalTips;

    /* renamed from: E, reason: from kotlin metadata */
    private RobotQRCodeLoadingComponent qrCode;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView robotDescText;

    /* renamed from: G, reason: from kotlin metadata */
    private w44.a viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RFWRoundImageView avatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout bannedLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mCardPart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView nameText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout normCardLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout normProfileContainer;

    private final void H9(RFWRoundImageView avatarView, String avatarUrl) {
        boolean z16 = true;
        QLog.d("robot.qr.QRDisplayRobotPart", 1, "initAvatar " + avatarUrl);
        if (avatarUrl.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(avatarUrl, avatarView, com.tencent.mobileqq.urldrawable.b.f306350a);
    }

    private final void I9() {
        RobotShareState robotShareState;
        w44.a aVar = this.viewModel;
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        RobotInfo robotInfo = aVar.getRobotInfo();
        if (robotInfo == null || (robotShareState = robotInfo.getShareState()) == null) {
            robotShareState = RobotShareState.NORMAL;
        }
        if (robotShareState != RobotShareState.BANNED) {
            return;
        }
        RelativeLayout relativeLayout = this.bannedLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannedLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
        TextView textView = this.normalTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalTips");
            textView = null;
        }
        textView.setVisibility(8);
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent2 = this.qrCode;
        if (robotQRCodeLoadingComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            robotQRCodeLoadingComponent2 = null;
        }
        RobotQRCodeLoadingComponent.setChain$default(robotQRCodeLoadingComponent2, "\u65e0\u6548\u4e8c\u7ef4\u7801", false, 2, null);
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent3 = this.qrCode;
        if (robotQRCodeLoadingComponent3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            robotQRCodeLoadingComponent3 = null;
        }
        robotQRCodeLoadingComponent3.u();
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent4 = this.qrCode;
        if (robotQRCodeLoadingComponent4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
        } else {
            robotQRCodeLoadingComponent = robotQRCodeLoadingComponent4;
        }
        robotQRCodeLoadingComponent.setAlpha(0.05f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M9() {
        LinearLayout linearLayout = this.mCardPart;
        if (linearLayout == null) {
            return;
        }
        RelativeLayout relativeLayout = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout = null;
        }
        View findViewById = linearLayout.findViewById(R.id.y67);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mCardPart.findViewById(R.id.iv_my_head_short)");
        this.avatar = (RFWRoundImageView) findViewById;
        LinearLayout linearLayout2 = this.mCardPart;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout2 = null;
        }
        View findViewById2 = linearLayout2.findViewById(R.id.f109556g5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mCardPart.findViewById(R.id.tv_nickName_short)");
        this.nameText = (TextView) findViewById2;
        LinearLayout linearLayout3 = this.mCardPart;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout3 = null;
        }
        View findViewById3 = linearLayout3.findViewById(R.id.f110826jk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mCardPart.findViewById(R.id.tv_robot_desc)");
        this.robotDescText = (TextView) findViewById3;
        LinearLayout linearLayout4 = this.mCardPart;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout4 = null;
        }
        View findViewById4 = linearLayout4.findViewById(R.id.y7k);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mCardPart.findViewById(R.id.iv_qr_code_short)");
        this.qrCode = (RobotQRCodeLoadingComponent) findViewById4;
        LinearLayout linearLayout5 = this.mCardPart;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout5 = null;
        }
        View findViewById5 = linearLayout5.findViewById(R.id.f6474372);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mCardPart.findViewById(R\u2026qr_code_normal_card_view)");
        this.normalCardView = (CardView) findViewById5;
        LinearLayout linearLayout6 = this.mCardPart;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout6 = null;
        }
        View findViewById6 = linearLayout6.findViewById(R.id.f6476374);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mCardPart.findViewById(R\u2026normal_profile_container)");
        this.normProfileContainer = (LinearLayout) findViewById6;
        LinearLayout linearLayout7 = this.mCardPart;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout7 = null;
        }
        View findViewById7 = linearLayout7.findViewById(R.id.f6473371);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mCardPart.findViewById(R\u2026_code_normal_card_layout)");
        this.normCardLayout = (RelativeLayout) findViewById7;
        LinearLayout linearLayout8 = this.mCardPart;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout8 = null;
        }
        View findViewById8 = linearLayout8.findViewById(R.id.f109486fy);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mCardPart.findViewById(R.id.tv_my_card_tips_short)");
        this.normalTips = (TextView) findViewById8;
        LinearLayout linearLayout9 = this.mCardPart;
        if (linearLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout9 = null;
        }
        View findViewById9 = linearLayout9.findViewById(R.id.f647136z);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mCardPart.findViewById(R\u2026code_forbidden_container)");
        this.bannedLayout = (RelativeLayout) findViewById9;
        RelativeLayout relativeLayout2 = this.normCardLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normCardLayout");
        } else {
            relativeLayout = relativeLayout2;
        }
        O9(relativeLayout);
    }

    @SuppressLint({"InflateParams"})
    private final void N9(Context context) {
        M9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(View view) {
        Resources resources;
        if (QQTheme.isVasTheme()) {
            if (QQTheme.isColorDark(view.getResources().getColor(R.color.qui_common_text_primary))) {
                view.setBackgroundColor(-1);
            } else {
                view.setBackgroundColor(-16777216);
            }
            view.getBackground().setAlpha(216);
            return;
        }
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null) {
            view.setBackgroundColor(resources.getColor(R.color.qui_common_fill_light_secondary));
            view.getBackground().setAlpha(255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        RobotShareState robotShareState;
        String str;
        w44.a aVar = this.viewModel;
        RelativeLayout relativeLayout = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        RobotInfo robotInfo = aVar.getRobotInfo();
        if (robotInfo == null || (robotShareState = robotInfo.getShareState()) == null) {
            robotShareState = RobotShareState.NORMAL;
        }
        if (robotShareState == RobotShareState.NORMAL) {
            w44.a aVar2 = this.viewModel;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar2 = null;
            }
            RobotInfo robotInfo2 = aVar2.getRobotInfo();
            if (robotInfo2 == null || (str = robotInfo2.getRobotJumpUrl()) == null) {
                str = "";
            }
        } else {
            str = "invalid qrcode";
        }
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent = this.qrCode;
        if (robotQRCodeLoadingComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            robotQRCodeLoadingComponent = null;
        }
        robotQRCodeLoadingComponent.setChain(str, true);
        RelativeLayout relativeLayout2 = this.normCardLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normCardLayout");
        } else {
            relativeLayout = relativeLayout2;
        }
        O9(relativeLayout);
    }

    private final void Q9() {
        LinearLayout linearLayout = this.mCardPart;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
            linearLayout = null;
        }
        linearLayout.post(new Runnable() { // from class: com.tencent.robot.qrcode.part.h
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayRobotPart.R9(QRDisplayRobotPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QRDisplayRobotPart this$0) {
        int c16;
        int i3;
        int dip2px;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getPartRootView().getContext();
        if (context == null) {
            return;
        }
        if (bi.e()) {
            c16 = bi.d();
        } else {
            c16 = bi.c();
        }
        float f16 = c16;
        int statusBarHeight = ViewUtils.getStatusBarHeight(context);
        if (az.e(context)) {
            i3 = az.c(context);
        } else {
            i3 = 0;
        }
        float pxToDp = ViewUtils.pxToDp((f16 - i3) - statusBarHeight) - 89.0f;
        if (pxToDp < 695.0f) {
            float f17 = 275.0f - (695.0f - pxToDp);
            if (f17 < 120.0f) {
                f17 = 120.0f;
            }
            dip2px = ViewUtils.dpToPx(f17);
        } else {
            dip2px = ViewUtils.dip2px(275.0f);
        }
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent = this$0.qrCode;
        ViewGroup.LayoutParams layoutParams = null;
        if (robotQRCodeLoadingComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            robotQRCodeLoadingComponent = null;
        }
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent2 = this$0.qrCode;
        if (robotQRCodeLoadingComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            robotQRCodeLoadingComponent2 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = robotQRCodeLoadingComponent2.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = dip2px;
            layoutParams2.height = dip2px;
        } else {
            layoutParams2 = null;
        }
        robotQRCodeLoadingComponent.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout = this$0.bannedLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannedLayout");
            relativeLayout = null;
        }
        RelativeLayout relativeLayout2 = this$0.bannedLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bannedLayout");
            relativeLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = relativeLayout2.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = dip2px;
            layoutParams3.height = dip2px;
            layoutParams = layoutParams3;
        }
        relativeLayout.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Bitmap S9() {
        QLog.i("robot.qr.QRDisplayRobotPart", 1, "shotNormalCard");
        w44.a aVar = null;
        try {
            RobotQRCodeLoadingComponent robotQRCodeLoadingComponent = this.qrCode;
            if (robotQRCodeLoadingComponent == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                robotQRCodeLoadingComponent = null;
            }
            robotQRCodeLoadingComponent.u();
            RobotQRCodeLoadingComponent robotQRCodeLoadingComponent2 = this.qrCode;
            if (robotQRCodeLoadingComponent2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                robotQRCodeLoadingComponent2 = null;
            }
            int width = robotQRCodeLoadingComponent2.getWidth();
            RobotQRCodeLoadingComponent robotQRCodeLoadingComponent3 = this.qrCode;
            if (robotQRCodeLoadingComponent3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                robotQRCodeLoadingComponent3 = null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, robotQRCodeLoadingComponent3.getHeight(), Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                RobotQRCodeLoadingComponent robotQRCodeLoadingComponent4 = this.qrCode;
                if (robotQRCodeLoadingComponent4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                    robotQRCodeLoadingComponent4 = null;
                }
                robotQRCodeLoadingComponent4.draw(canvas);
                w44.a aVar2 = this.viewModel;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    aVar = aVar2;
                }
                aVar.L1().setValue(createBitmap);
                return createBitmap;
            } catch (Throwable th5) {
                th = th5;
                aVar = createBitmap;
                QLog.e("robot.qr.QRDisplayRobotPart", 1, "startShot error " + th, th);
                return aVar;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private final void initData() {
        QBaseActivity qBaseActivity;
        String str;
        String robotAvatarUrl;
        String robotDesc;
        Activity activity = getActivity();
        w44.a aVar = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            return;
        }
        TextView textView = this.nameText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameText");
            textView = null;
        }
        w44.a aVar2 = this.viewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar2 = null;
        }
        RobotInfo robotInfo = aVar2.getRobotInfo();
        String str2 = "";
        if (robotInfo == null || (str = robotInfo.getRobotName()) == null) {
            str = "";
        }
        textView.setText(str);
        TextView textView2 = this.robotDescText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotDescText");
            textView2 = null;
        }
        w44.a aVar3 = this.viewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar3 = null;
        }
        RobotInfo robotInfo2 = aVar3.getRobotInfo();
        if (robotInfo2 != null && (robotDesc = robotInfo2.getRobotDesc()) != null) {
            str2 = robotDesc;
        }
        textView2.setText(str2);
        P9();
        w44.a aVar4 = this.viewModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar4 = null;
        }
        RobotInfo robotInfo3 = aVar4.getRobotInfo();
        if (robotInfo3 != null && (robotAvatarUrl = robotInfo3.getRobotAvatarUrl()) != null) {
            RFWRoundImageView rFWRoundImageView = this.avatar;
            if (rFWRoundImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatar");
                rFWRoundImageView = null;
            }
            H9(rFWRoundImageView, robotAvatarUrl);
        }
        RobotQRCodeLoadingComponent robotQRCodeLoadingComponent = this.qrCode;
        if (robotQRCodeLoadingComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            robotQRCodeLoadingComponent = null;
        }
        MutableLiveData<Boolean> q16 = robotQRCodeLoadingComponent.q();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.qrcode.part.QRDisplayRobotPart$initData$2
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
                RobotQRCodeLoadingComponent robotQRCodeLoadingComponent2;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    robotQRCodeLoadingComponent2 = QRDisplayRobotPart.this.qrCode;
                    if (robotQRCodeLoadingComponent2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                        robotQRCodeLoadingComponent2 = null;
                    }
                    robotQRCodeLoadingComponent2.v();
                }
            }
        };
        q16.observe(qBaseActivity, new Observer() { // from class: com.tencent.robot.qrcode.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayRobotPart.J9(Function1.this, obj);
            }
        });
        w44.a aVar5 = this.viewModel;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar5 = null;
        }
        MutableLiveData<Boolean> O1 = aVar5.O1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.qrcode.part.QRDisplayRobotPart$initData$3
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
                RelativeLayout relativeLayout;
                RobotQRCodeLoadingComponent robotQRCodeLoadingComponent2;
                w44.a aVar6;
                w44.a aVar7;
                QRDisplayRobotPart qRDisplayRobotPart = QRDisplayRobotPart.this;
                relativeLayout = qRDisplayRobotPart.normCardLayout;
                if (relativeLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("normCardLayout");
                    relativeLayout = null;
                }
                qRDisplayRobotPart.O9(relativeLayout);
                robotQRCodeLoadingComponent2 = QRDisplayRobotPart.this.qrCode;
                if (robotQRCodeLoadingComponent2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
                    robotQRCodeLoadingComponent2 = null;
                }
                robotQRCodeLoadingComponent2.x();
                aVar6 = QRDisplayRobotPart.this.viewModel;
                if (aVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    aVar6 = null;
                }
                aVar6.L1().setValue(null);
                aVar7 = QRDisplayRobotPart.this.viewModel;
                if (aVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    aVar7 = null;
                }
                aVar7.N1().setValue(null);
            }
        };
        O1.observe(qBaseActivity, new Observer() { // from class: com.tencent.robot.qrcode.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayRobotPart.K9(Function1.this, obj);
            }
        });
        w44.a aVar6 = this.viewModel;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            aVar = aVar6;
        }
        MutableLiveData<Boolean> P1 = aVar.P1();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.qrcode.part.QRDisplayRobotPart$initData$4
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
                w44.a aVar7;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    aVar7 = QRDisplayRobotPart.this.viewModel;
                    if (aVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        aVar7 = null;
                    }
                    aVar7.P1().postValue(Boolean.FALSE);
                    QRDisplayRobotPart.this.P9();
                }
            }
        };
        P1.observe(qBaseActivity, new Observer() { // from class: com.tencent.robot.qrcode.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayRobotPart.L9(Function1.this, obj);
            }
        });
        I9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "action_get_qr_code_shot")) {
            w44.a aVar = this.viewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                aVar = null;
            }
            Bitmap value = aVar.L1().getValue();
            if (value == null || value.isRecycled()) {
                Bitmap S9 = S9();
                if (S9 == null) {
                    return Unit.INSTANCE;
                }
                return S9;
            }
            return value;
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Q9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @SuppressLint({"ClickableViewAccessibility"})
    public void onInitView(@Nullable View rootView) {
        LinearLayout linearLayout;
        super.onInitView(rootView);
        LinearLayout linearLayout2 = null;
        if (rootView != null) {
            linearLayout = (LinearLayout) rootView.findViewById(R.id.toc);
        } else {
            linearLayout = null;
        }
        if (linearLayout instanceof LinearLayout) {
            linearLayout2 = linearLayout;
        }
        if (linearLayout2 == null) {
            QLog.i("robot.qr.QRDisplayRobotPart", 1, "card part is null");
            return;
        }
        this.mCardPart = linearLayout2;
        w44.a aVar = (w44.a) getViewModel(w44.a.class);
        if (aVar == null) {
            return;
        }
        this.viewModel = aVar;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        N9(activity);
        initData();
        Q9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        I9();
    }
}
