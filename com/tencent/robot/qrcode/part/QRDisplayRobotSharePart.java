package com.tencent.robot.qrcode.part;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.data.RobotInfo;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 J2\u00020\u0001:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J(\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00102\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010&\u001a\u00020\u00062\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001fH\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010'\u001a\u00020\u0010H\u0002R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u00109R\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/robot/qrcode/part/QRDisplayRobotSharePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "action", "", "args", "", "handleBroadcastMessage", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "T9", "U9", "", "V9", "initData", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "R9", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "avatarView", PhotoCategorySummaryInfo.AVATAR_URL, "P9", "S9", "K9", "", "L9", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "preView", "O9", "Lkotlin/Function1;", "callback", "X9", "ba", "W9", "da", "ea", "ga", "qrCodeCache", "ia", "Lw44/a;", "d", "Lw44/a;", "viewModel", "e", "Ljava/lang/String;", "localSharePath", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "sharePartView", tl.h.F, "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "avatar", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "nameText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "shareTipsView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", CommonConstant.KEY_QR_CODE, "D", "robotDescText", "Landroidx/cardview/widget/CardView;", "E", "Landroidx/cardview/widget/CardView;", "shareContentCardView", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QRDisplayRobotSharePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView qrCode;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView robotDescText;

    /* renamed from: E, reason: from kotlin metadata */
    private CardView shareContentCardView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private w44.a viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String localSharePath = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout sharePartView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RFWRoundImageView avatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView nameText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View shareTipsView;

    private final String K9() {
        String str;
        w44.a aVar = this.viewModel;
        String str2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        RobotInfo robotInfo = aVar.getRobotInfo();
        if (robotInfo != null) {
            str = robotInfo.getRobotName();
        } else {
            str = null;
        }
        w44.a aVar2 = this.viewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar2 = null;
        }
        RobotInfo robotInfo2 = aVar2.getRobotInfo();
        if (robotInfo2 != null) {
            str2 = robotInfo2.getRobotJumpUrl();
        }
        return "\u70b9\u51fb\u94fe\u63a5\u4e86\u89e3\u673a\u5668\u4eba\u8be6\u60c5\u3010" + str + "\u3011" + str2;
    }

    private final float L9(Bitmap bitmap) {
        return ViewUtils.dpToPx(6.0f) * (bitmap.getWidth() / ViewUtils.dpToPx(408.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(QRDisplayRobotSharePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.da();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QRDisplayRobotSharePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(ShareActionSheetBuilder.ActionSheetItem item, Bitmap preView) {
        String str;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        com.tencent.robot.share.f fVar = new com.tencent.robot.share.f(activity, this.localSharePath, preView);
        int i3 = item.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 26) {
                                if (i3 != 39) {
                                    if (i3 != 171 && i3 != 72 && i3 != 73) {
                                        return;
                                    }
                                } else {
                                    fVar.f();
                                    return;
                                }
                            } else {
                                item.uinType = 6000;
                                item.uin = AppConstants.DATALINE_PC_UIN;
                                com.tencent.robot.share.f.l(fVar, item, true, false, 4, null);
                                return;
                            }
                        } else {
                            fVar.n(true);
                            return;
                        }
                    } else {
                        fVar.n(false);
                        return;
                    }
                } else {
                    w44.a aVar = this.viewModel;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        aVar = null;
                    }
                    RobotInfo robotInfo = aVar.getRobotInfo();
                    if (robotInfo == null || (str = robotInfo.getRobotDesc()) == null) {
                        str = "";
                    }
                    fVar.m("", str);
                    return;
                }
            }
            com.tencent.robot.share.f.l(fVar, item, false, false, 6, null);
            return;
        }
        fVar.e(K9());
    }

    private final void P9(RFWRoundImageView avatarView, String avatarUrl) {
        boolean z16 = true;
        QLog.d("robot.qr.QRDisplaySharePart", 1, "initAvatar " + avatarUrl);
        if (avatarUrl.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(avatarUrl, avatarView, com.tencent.mobileqq.urldrawable.b.f306350a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void R9(Bitmap bitmap) {
        ImageView imageView = this.qrCode;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
            imageView = null;
        }
        imageView.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        String str;
        RelativeLayout relativeLayout = this.sharePartView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
            relativeLayout = null;
        }
        int color = relativeLayout.getResources().getColor(R.color.qui_common_text_primary);
        if (!QQTheme.isNowThemeIsNight() && QQTheme.isColorDark(color)) {
            str = "https://downv6.qq.com/innovate/guild/robot/robotQRCodeBgLight.png";
        } else {
            str = "https://downv6.qq.com/innovate/guild/robot/robotQRCodeBgDark.png";
        }
        IQQGuildUtilApi iQQGuildUtilApi = (IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class);
        RelativeLayout relativeLayout3 = this.sharePartView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        iQQGuildUtilApi.loadBackgroundImage(str, relativeLayout2);
    }

    private final void T9() {
        RelativeLayout relativeLayout = this.sharePartView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
            relativeLayout = null;
        }
        View findViewById = relativeLayout.findViewById(R.id.f648237_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "sharePartView.findViewBy\u2026id.qr_code_share_iv_head)");
        this.avatar = (RFWRoundImageView) findViewById;
        RelativeLayout relativeLayout3 = this.sharePartView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
            relativeLayout3 = null;
        }
        View findViewById2 = relativeLayout3.findViewById(R.id.f649037h);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "sharePartView.findViewBy\u2026r_code_share_tv_nickname)");
        this.nameText = (TextView) findViewById2;
        RelativeLayout relativeLayout4 = this.sharePartView;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
            relativeLayout4 = null;
        }
        View findViewById3 = relativeLayout4.findViewById(R.id.f648837f);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "sharePartView.findViewBy\u2026qr_code_share_robot_desc)");
        this.robotDescText = (TextView) findViewById3;
        RelativeLayout relativeLayout5 = this.sharePartView;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
            relativeLayout5 = null;
        }
        View findViewById4 = relativeLayout5.findViewById(R.id.f648337a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "sharePartView.findViewBy\u2026R.id.qr_code_share_iv_qr)");
        this.qrCode = (ImageView) findViewById4;
        RelativeLayout relativeLayout6 = this.sharePartView;
        if (relativeLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
        } else {
            relativeLayout2 = relativeLayout6;
        }
        View findViewById5 = relativeLayout2.findViewById(R.id.f6479377);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "sharePartView.findViewBy\u2026.qr_code_share_card_view)");
        this.shareContentCardView = (CardView) findViewById5;
        U9();
        S9();
    }

    private final void U9() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = this.sharePartView;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
            relativeLayout = null;
        }
        View findViewById = relativeLayout.findViewById(R.id.f111266kr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "sharePartView.findViewBy\u2026R.id.tv_share_tips_short)");
        this.shareTipsView = findViewById;
        if (V9()) {
            View view = this.shareTipsView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareTipsView");
                view = null;
            }
            View view2 = this.shareTipsView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareTipsView");
                view2 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams3;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.bottomMargin = ViewUtils.dpToPx(15.0f);
                layoutParams2 = layoutParams;
            }
            view.setLayoutParams(layoutParams2);
        }
    }

    private final boolean V9() {
        if (FontSettingManager.getFontLevel() > 17.0f) {
            return true;
        }
        return false;
    }

    private final void W9() {
        ga(new Function1<Bitmap, Unit>() { // from class: com.tencent.robot.qrcode.part.QRDisplayRobotSharePart$saveQRCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Bitmap shareBitmap) {
                String str;
                Intrinsics.checkNotNullParameter(shareBitmap, "shareBitmap");
                Activity activity = QRDisplayRobotSharePart.this.getActivity();
                if (activity == null) {
                    return;
                }
                str = QRDisplayRobotSharePart.this.localSharePath;
                new com.tencent.robot.share.f(activity, str, shareBitmap).f();
            }
        });
    }

    private final void X9(final Bitmap preView, final Function1<? super Boolean, Unit> callback) {
        if (!TextUtils.isEmpty(this.localSharePath)) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.robot.qrcode.part.n
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayRobotSharePart.Y9(Function1.this);
                }
            });
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.qrcode.part.o
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayRobotSharePart.Z9(QRDisplayRobotSharePart.this, preView, callback);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 function1) {
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(final QRDisplayRobotSharePart this$0, Bitmap preView, final Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preView, "$preView");
        w44.a aVar = this$0.viewModel;
        String str = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        RobotInfo robotInfo = aVar.getRobotInfo();
        if (robotInfo != null) {
            str = robotInfo.getRobotAppId();
        }
        String f16 = v44.c.f440966a.f("temp_qrcode_share_" + str + ".png", preView);
        if (f16 == null) {
            f16 = "";
        }
        if (!TextUtils.isEmpty(f16)) {
            this$0.localSharePath = f16;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.robot.qrcode.part.p
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayRobotSharePart.aa(Function1.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 function1, QRDisplayRobotSharePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(!TextUtils.isEmpty(this$0.localSharePath)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(final Bitmap preView) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        v44.g c16 = v44.h.f440969a.c(activity, v44.h.a(preView, L9(preView)));
        c16.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.robot.qrcode.part.m
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                QRDisplayRobotSharePart.ca(QRDisplayRobotSharePart.this, preView, actionSheetItem, shareActionSheet);
            }
        });
        c16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(final QRDisplayRobotSharePart this$0, final Bitmap preView, final ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(preView, "$preView");
        shareActionSheet.dismiss();
        QLog.d("robot.qr.QRDisplaySharePart", 2, " showMyQrCodeActionSheet() click item = " + actionSheetItem.action);
        this$0.X9(preView, new Function1<Boolean, Unit>() { // from class: com.tencent.robot.qrcode.part.QRDisplayRobotSharePart$showMyQrCodeActionSheet$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                String str;
                if (z16) {
                    str = QRDisplayRobotSharePart.this.localSharePath;
                    if (!TextUtils.isEmpty(str)) {
                        QRDisplayRobotSharePart qRDisplayRobotSharePart = QRDisplayRobotSharePart.this;
                        ShareActionSheetBuilder.ActionSheetItem item = actionSheetItem;
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        qRDisplayRobotSharePart.O9(item, preView);
                        return;
                    }
                }
                QLog.e("robot.qr.QRDisplaySharePart", 1, "setItemClickListenerV2 saveQRCodeToLocalCache error");
            }
        });
    }

    private final void da() {
        ga(new Function1<Bitmap, Unit>() { // from class: com.tencent.robot.qrcode.part.QRDisplayRobotSharePart$showShareActionSheet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Bitmap shareBitmap) {
                Intrinsics.checkNotNullParameter(shareBitmap, "shareBitmap");
                QRDisplayRobotSharePart.this.ba(shareBitmap);
            }
        });
    }

    private final Bitmap ea() {
        Object broadcastGetMessage = broadcastGetMessage("action_get_qr_code_shot", "");
        if (broadcastGetMessage instanceof Bitmap) {
            return (Bitmap) broadcastGetMessage;
        }
        return null;
    }

    private final void ga(final Function1<? super Bitmap, Unit> callback) {
        final Bitmap ea5 = ea();
        if (ea5 != null && !ea5.isRecycled()) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.robot.qrcode.part.l
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayRobotSharePart.ha(QRDisplayRobotSharePart.this, ea5, callback);
                }
            });
        } else {
            v44.c.f440966a.g(1, R.string.f222856en);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(QRDisplayRobotSharePart this$0, Bitmap bitmap, Function1 function1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bitmap ia5 = this$0.ia(bitmap);
        if (ia5 != null && !ia5.isRecycled()) {
            if (function1 != null) {
                function1.invoke(ia5);
                return;
            }
            return;
        }
        v44.c.f440966a.g(1, R.string.f222856en);
    }

    private final Bitmap ia(Bitmap qrCodeCache) {
        w44.a aVar = this.viewModel;
        w44.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        Bitmap value = aVar.N1().getValue();
        if (value != null && !value.isRecycled()) {
            return value;
        }
        R9(qrCodeCache);
        try {
            RelativeLayout relativeLayout = this.sharePartView;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
                relativeLayout = null;
            }
            int width = relativeLayout.getWidth();
            RelativeLayout relativeLayout2 = this.sharePartView;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
                relativeLayout2 = null;
            }
            value = Bitmap.createBitmap(width, relativeLayout2.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(value);
            RelativeLayout relativeLayout3 = this.sharePartView;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharePartView");
                relativeLayout3 = null;
            }
            relativeLayout3.draw(canvas);
        } catch (Throwable th5) {
            QLog.e("robot.qr.QRDisplaySharePart", 1, "tryGetShareSnapShot error " + th5, th5);
        }
        w44.a aVar3 = this.viewModel;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            aVar2 = aVar3;
        }
        aVar2.N1().setValue(value);
        return value;
    }

    private final void initData() {
        QBaseActivity qBaseActivity;
        String str;
        String robotAvatarUrl;
        String robotDesc;
        Activity activity = getActivity();
        RFWRoundImageView rFWRoundImageView = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            return;
        }
        w44.a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        MutableLiveData<Boolean> O1 = aVar.O1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.robot.qrcode.part.QRDisplayRobotSharePart$initData$1
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
                QRDisplayRobotSharePart.this.S9();
            }
        };
        O1.observe(qBaseActivity, new Observer() { // from class: com.tencent.robot.qrcode.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QRDisplayRobotSharePart.Q9(Function1.this, obj);
            }
        });
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
        w44.a aVar4 = this.viewModel;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar4 = null;
        }
        RobotInfo robotInfo3 = aVar4.getRobotInfo();
        if (robotInfo3 != null && (robotAvatarUrl = robotInfo3.getRobotAvatarUrl()) != null) {
            RFWRoundImageView rFWRoundImageView2 = this.avatar;
            if (rFWRoundImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatar");
            } else {
                rFWRoundImageView = rFWRoundImageView2;
            }
            P9(rFWRoundImageView, robotAvatarUrl);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "action_show_share_sheet")) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.robot.qrcode.part.j
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayRobotSharePart.M9(QRDisplayRobotSharePart.this);
                }
            });
        } else if (Intrinsics.areEqual(action, "action_save_qr_code")) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.robot.qrcode.part.k
                @Override // java.lang.Runnable
                public final void run() {
                    QRDisplayRobotSharePart.N9(QRDisplayRobotSharePart.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        w44.a aVar;
        super.onInitView(rootView);
        if (rootView == null || (aVar = (w44.a) getViewModel(w44.a.class)) == null) {
            return;
        }
        this.viewModel = aVar;
        View findViewById = rootView.findViewById(R.id.f84374m3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Re\u2026>(R.id.share_normal_part)");
        this.sharePartView = (RelativeLayout) findViewById;
        T9();
        initData();
    }
}
