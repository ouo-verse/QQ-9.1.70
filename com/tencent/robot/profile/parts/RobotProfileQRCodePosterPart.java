package com.tencent.robot.profile.parts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.am;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.a;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.profile.RobotProfileViewModel;
import com.tencent.robot.profile.parts.RobotProfileQRCodePosterPart$backgroundURLDrawableListener$2;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\b\u000b*\u0001i\u0018\u0000 q2\u00020\u0001:\u0001rB%\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000600\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0014\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001e\u0010!\u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0018\u0010@\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00105R\u0018\u0010B\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00105R\u0018\u0010D\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00105R\u0018\u0010F\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00105R\u0018\u0010H\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00109R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010KR\u0018\u0010R\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u00105R\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010KR\u0016\u0010[\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010ZR&\u0010a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00180^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00060e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u001b\u0010n\u001a\u00020i8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\u00a8\u0006s"}, d2 = {"Lcom/tencent/robot/profile/parts/RobotProfileQRCodePosterPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "Q9", "", "refreshView", "", "backgroundUrl", "S9", "", "dayRes", "nightRes", "K9", "P9", "J9", "M9", "T9", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/component/qrcode/d;", "L9", "initData", "Lcom/tencent/robot/data/RobotInfo;", "robotInfo", "V9", "Landroid/graphics/Bitmap;", "W9", "R9", "Landroid/view/View;", "parentView", "onInitView", "action", "", "args", "getMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "getLogTag", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "d", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "bgUrlApplier", tl.h.F, "Landroid/view/View;", "root", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "robotAvatarView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "backgroundView", BdhLogUtil.LogTag.Tag_Conn, "robotInfoView", "D", "topGradientView", "E", "bottomGradientView", UserInfo.SEX_FEMALE, "bottomMaskViewUp", "G", "bottomMaskViewDown", "H", "logoView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "logoNameTextView", "J", "robotNameTextView", "K", "robotDescTextView", "L", "qrCodeContainerView", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "M", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "qrCodeView", "N", "identifyQRCodeGuildTextView", "P", "Z", "isBackgroundReady", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isQRCodeReady", "Lkotlin/Pair;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Pair;", "cacheBitmap", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "currentRobotJumpUrl", "", "T", "Ljava/util/Set;", "baby_q_set", "com/tencent/robot/profile/parts/RobotProfileQRCodePosterPart$backgroundURLDrawableListener$2$a", "U", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/robot/profile/parts/RobotProfileQRCodePosterPart$backgroundURLDrawableListener$2$a;", "backgroundURLDrawableListener", "<init>", "(Lcom/tencent/robot/profile/RobotProfileViewModel;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;)V", "V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileQRCodePosterPart extends Part {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View robotInfoView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View topGradientView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View bottomGradientView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View bottomMaskViewUp;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View bottomMaskViewDown;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ImageView logoView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView logoNameTextView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView robotNameTextView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private TextView robotDescTextView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View qrCodeContainerView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private QUIColorfulQRCodeView qrCodeView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView identifyQRCodeGuildTextView;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isBackgroundReady;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isQRCodeReady;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private Pair<String, Bitmap> cacheBitmap;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String currentRobotJumpUrl;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Set<String> baby_q_set;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy backgroundURLDrawableListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<String> bgUrlApplier;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View root;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView robotAvatarView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView backgroundView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/profile/parts/RobotProfileQRCodePosterPart$a;", "", "", "d", "c", "ACTION_GET_QR_CODE_POSTER_BITMAP", "Ljava/lang/String;", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.parts.RobotProfileQRCodePosterPart$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String c(String str) {
            return new Regex("\n+").replace(str, "\n");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String d(String str) {
            if (str.length() > 5) {
                String substring = str.substring(0, 5);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            return str;
        }

        Companion() {
        }
    }

    public RobotProfileQRCodePosterPart(@NotNull RobotProfileViewModel viewModel, @NotNull LifecycleOwner viewLifecycleOwner, @NotNull Function0<String> bgUrlApplier) {
        Set<String> of5;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(bgUrlApplier, "bgUrlApplier");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
        this.bgUrlApplier = bgUrlApplier;
        this.cacheBitmap = new Pair<>("", null);
        this.currentRobotJumpUrl = "";
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"66600000", "2854206139", "3889161009"});
        this.baby_q_set = of5;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<RobotProfileQRCodePosterPart$backgroundURLDrawableListener$2.a>() { // from class: com.tencent.robot.profile.parts.RobotProfileQRCodePosterPart$backgroundURLDrawableListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotProfileQRCodePosterPart.this);
            }

            @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/robot/profile/parts/RobotProfileQRCodePosterPart$backgroundURLDrawableListener$2$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements URLDrawable.URLDrawableListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RobotProfileQRCodePosterPart f368029d;

                a(RobotProfileQRCodePosterPart robotProfileQRCodePosterPart) {
                    this.f368029d = robotProfileQRCodePosterPart;
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(@Nullable URLDrawable drawable) {
                    URL url;
                    if (drawable != null) {
                        url = drawable.getURL();
                    } else {
                        url = null;
                    }
                    QLog.i("robot.profile.RobotProfileQRCodePosterPart", 1, "load canceled " + url);
                    if (drawable != null) {
                        drawable.setURLDrawableListener(null);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
                    URL url;
                    if (drawable != null) {
                        url = drawable.getURL();
                    } else {
                        url = null;
                    }
                    QLog.e("robot.profile.RobotProfileQRCodePosterPart", 1, "load failed " + url);
                    if (drawable != null) {
                        drawable.setURLDrawableListener(null);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(@Nullable URLDrawable drawable) {
                    URL url;
                    if (drawable != null) {
                        url = drawable.getURL();
                    } else {
                        url = null;
                    }
                    QLog.i("robot.profile.RobotProfileQRCodePosterPart", 1, "load success " + url);
                    this.f368029d.isBackgroundReady = true;
                    if (drawable != null) {
                        drawable.setURLDrawableListener(null);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
                }
            }
        });
        this.backgroundURLDrawableListener = lazy;
    }

    private final RobotProfileQRCodePosterPart$backgroundURLDrawableListener$2.a I9() {
        return (RobotProfileQRCodePosterPart$backgroundURLDrawableListener$2.a) this.backgroundURLDrawableListener.getValue();
    }

    private final int J9() {
        if (Q9()) {
            return K9(R.color.b6w, R.color.b6x);
        }
        return R.color.qui_common_bubble_guest;
    }

    private final int K9(int dayRes, int nightRes) {
        if (QQTheme.isNowThemeIsNight()) {
            return nightRes;
        }
        return dayRes;
    }

    private final HashMap<Integer, com.tencent.mobileqq.component.qrcode.d> L9() {
        HashMap<Integer, com.tencent.mobileqq.component.qrcode.d> hashMap = new HashMap<>();
        hashMap.put(3, new com.tencent.mobileqq.component.qrcode.d(7, 6, am.a(2.5f), 0.0f));
        hashMap.put(4, new com.tencent.mobileqq.component.qrcode.d(9, 7, am.a(2.5f), 0.0f));
        hashMap.put(5, new com.tencent.mobileqq.component.qrcode.d(10, 8, am.a(2.5f), 0.0f));
        hashMap.put(6, new com.tencent.mobileqq.component.qrcode.d(11, 9, am.a(2.5f), 0.0f));
        hashMap.put(7, new com.tencent.mobileqq.component.qrcode.d(12, 10, am.a(2.5f), 0.0f));
        hashMap.put(8, new com.tencent.mobileqq.component.qrcode.d(13, 11, am.a(2.5f), 0.0f));
        hashMap.put(9, new com.tencent.mobileqq.component.qrcode.d(14, 12, am.a(2.5f), 0.0f));
        com.tencent.mobileqq.component.qrcode.d dVar = new com.tencent.mobileqq.component.qrcode.d(14, 12, am.a(2.5f), 0.0f);
        hashMap.put(10, dVar);
        hashMap.put(11, dVar);
        hashMap.put(12, dVar);
        hashMap.put(13, dVar);
        hashMap.put(14, dVar);
        hashMap.put(15, dVar);
        hashMap.put(16, dVar);
        hashMap.put(17, dVar);
        hashMap.put(18, dVar);
        hashMap.put(19, dVar);
        hashMap.put(20, dVar);
        hashMap.put(21, dVar);
        hashMap.put(22, dVar);
        hashMap.put(23, dVar);
        hashMap.put(24, dVar);
        hashMap.put(25, dVar);
        hashMap.put(26, dVar);
        hashMap.put(27, dVar);
        hashMap.put(28, dVar);
        hashMap.put(29, dVar);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        int l3 = CommonExKt.l(getContext().getColor(J9()), 1.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{0, l3});
        View view = this.bottomMaskViewUp;
        if (view != null) {
            view.setBackground(gradientDrawable);
        }
        View view2 = this.bottomMaskViewDown;
        if (view2 != null) {
            view2.setBackgroundColor(l3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        View view = this.topGradientView;
        if (view != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setColors(new int[]{ContextCompat.getColor(getContext(), K9(R.color.coq, R.color.cor)), ContextCompat.getColor(getContext(), K9(R.color.coo, R.color.cop))});
            view.setBackground(gradientDrawable);
        }
        View view2 = this.bottomGradientView;
        if (view2 != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setGradientType(0);
            gradientDrawable2.setColors(new int[]{ContextCompat.getColor(getContext(), K9(R.color.col, R.color.f157931com)), ContextCompat.getColor(getContext(), K9(R.color.coi, R.color.coj))});
            view2.setBackground(gradientDrawable2);
        }
    }

    private final boolean Q9() {
        return this.baby_q_set.contains(this.viewModel.getRobotUin());
    }

    private final String R9() {
        RobotInfo value = this.viewModel.q2().getValue();
        if (value == null) {
            return "";
        }
        String robotName = value.getRobotName();
        String robotDesc = value.getRobotDesc();
        String invoke = this.bgUrlApplier.invoke();
        return robotName + robotDesc + ((Object) invoke) + value.getRobotJumpUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(String backgroundUrl) {
        boolean z16;
        ColorDrawable colorDrawable = new ColorDrawable(ContextCompat.getColor(getContext(), R.color.qui_common_bg_aio_01));
        QLog.i("robot.profile.RobotProfileQRCodePosterPart", 1, "refreshBackgroundView url=" + backgroundUrl);
        if (backgroundUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ImageView imageView = this.backgroundView;
            if (imageView != null) {
                imageView.setImageDrawable(colorDrawable);
                return;
            }
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mRetryCount = 3;
        URLDrawable drawable = URLDrawable.getDrawable(backgroundUrl, obtain);
        if (drawable != null) {
            drawable.startDownload();
            if (drawable.getStatus() != 1) {
                drawable.setURLDrawableListener(I9());
            } else {
                this.isBackgroundReady = true;
            }
            ImageView imageView2 = this.backgroundView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        final String str;
        boolean z16;
        List<Integer> listOf;
        List<Float> listOf2;
        String robotJumpUrl;
        CharSequence trim;
        RobotInfo value = this.viewModel.q2().getValue();
        if (value != null && (robotJumpUrl = value.getRobotJumpUrl()) != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) robotJumpUrl);
            str = trim.toString();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("robot.profile.RobotProfileQRCodePosterPart", 1, "robotJumpUrl is empty");
            return;
        }
        if (Intrinsics.areEqual(this.currentRobotJumpUrl, str)) {
            QLog.w("robot.profile.RobotProfileQRCodePosterPart", 1, "repeat robotJumpUrl");
            return;
        }
        this.currentRobotJumpUrl = str;
        QUIColorfulQRCodeView qUIColorfulQRCodeView = this.qrCodeView;
        if (qUIColorfulQRCodeView != null) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#D7B2F8")), Integer.valueOf(Color.parseColor("#59B2F6")), Integer.valueOf(Color.parseColor("#55E4ED"))});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.0f), Float.valueOf(0.5f), Float.valueOf(1.0f)});
            qUIColorfulQRCodeView.n(listOf, listOf2);
        }
        QUIColorfulQRCodeView qUIColorfulQRCodeView2 = this.qrCodeView;
        if (qUIColorfulQRCodeView2 != null) {
            qUIColorfulQRCodeView2.e(false);
        }
        QUIColorfulQRCodeView qUIColorfulQRCodeView3 = this.qrCodeView;
        if (qUIColorfulQRCodeView3 != null) {
            qUIColorfulQRCodeView3.g(new com.tencent.mobileqq.component.qrcode.i(R.drawable.qui_robot, null, null, 0, 12, null));
        }
        QUIColorfulQRCodeView qUIColorfulQRCodeView4 = this.qrCodeView;
        if (qUIColorfulQRCodeView4 != null) {
            qUIColorfulQRCodeView4.setTargetGenerateQRCodeParams(new com.tencent.mobileqq.component.qrcode.e(3, 29, L9(), ErrorCorrectionLevel.Q));
        }
        this.isQRCodeReady = false;
        QUIColorfulQRCodeView qUIColorfulQRCodeView5 = this.qrCodeView;
        if (qUIColorfulQRCodeView5 != null) {
            qUIColorfulQRCodeView5.f(str, new com.tencent.mobileqq.component.qrcode.g() { // from class: com.tencent.robot.profile.parts.q
                @Override // com.tencent.mobileqq.component.qrcode.g
                public final void onResult(int i3) {
                    RobotProfileQRCodePosterPart.U9(str, this, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(String str, RobotProfileQRCodePosterPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.i("robot.profile.RobotProfileQRCodePosterPart", 1, "qrcode refreshContent, errCode=" + i3 + ", robotJumpUrl=" + str);
        if (i3 != 0) {
            z16 = false;
        }
        this$0.isQRCodeReady = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b8, code lost:
    
        r10 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V9(RobotInfo robotInfo) {
        long j3;
        Long longOrNull;
        boolean z16;
        String str;
        CharSequence trim;
        TextView textView = this.robotNameTextView;
        if (textView != null) {
            textView.setText(robotInfo.getRobotName());
        }
        TextView textView2 = this.robotDescTextView;
        if (textView2 != null) {
            String robotDesc = robotInfo.getRobotDesc();
            if (robotDesc != null && robotDesc.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                str = "\u65e0\u66f4\u591a\u8d44\u6599";
            } else {
                String robotDesc2 = robotInfo.getRobotDesc();
                if (robotDesc2 != null) {
                    trim = StringsKt__StringsKt.trim((CharSequence) robotDesc2);
                    String obj = trim.toString();
                    if (obj != null) {
                        str = INSTANCE.c(obj);
                    }
                }
                str = null;
            }
            textView2.setText(str);
        }
        TextView textView3 = this.identifyQRCodeGuildTextView;
        if (textView3 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("\u957f\u6309\u8bc6\u522b\n\u8ddf\u300c%s\u300d\u804a\u4e00\u804a", Arrays.copyOf(new Object[]{INSTANCE.d(robotInfo.getRobotName())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView3.setText(format);
        }
        ImageView imageView = this.robotAvatarView;
        if (imageView != null) {
            b.Companion companion = com.tencent.qqnt.avatar.b.INSTANCE;
            b.a aVar = new b.a();
            aVar.f(0);
            aVar.g(AvatarSizeType.SMALL);
            aVar.b(Integer.valueOf(R.drawable.f160830com));
            com.tencent.qqnt.avatar.b a16 = aVar.a();
            a.Companion companion2 = com.tencent.qqnt.avatar.a.INSTANCE;
            Context context = imageView.getRootView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            com.tencent.qqnt.avatar.e e16 = companion2.b(context).b(imageView).e(a16);
            String valueOf = String.valueOf(robotInfo.getRobotUid());
            String robotUin = robotInfo.getRobotUin();
            if (robotUin != null && longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            e.a.b(e16, valueOf, j3, null, 4, null);
        }
    }

    private final Bitmap W9() {
        Bitmap bitmap;
        if (Intrinsics.areEqual(this.cacheBitmap.getFirst(), R9())) {
            bitmap = this.cacheBitmap.getSecond();
        } else {
            bitmap = null;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        View view = this.root;
        if (view == null) {
            return null;
        }
        try {
            bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(bitmap));
        } catch (Throwable th5) {
            QLog.e("robot.profile.RobotProfileQRCodePosterPart", 1, "tryGetPosterBitmap error", th5);
        }
        this.cacheBitmap = new Pair<>(R9(), bitmap);
        return bitmap;
    }

    private final void initData() {
        MutableLiveData<RobotInfo> q26 = this.viewModel.q2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<RobotInfo, Unit> function1 = new Function1<RobotInfo, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileQRCodePosterPart$initData$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RobotInfo robotInfo) {
                invoke2(robotInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RobotInfo robotInfo) {
                QLog.d("robot.profile.RobotProfileQRCodePosterPart", 1, "initData");
                if (robotInfo != null) {
                    RobotProfileQRCodePosterPart robotProfileQRCodePosterPart = RobotProfileQRCodePosterPart.this;
                    robotProfileQRCodePosterPart.V9(robotInfo);
                    robotProfileQRCodePosterPart.T9();
                    robotProfileQRCodePosterPart.refreshView();
                    robotProfileQRCodePosterPart.P9();
                    robotProfileQRCodePosterPart.M9();
                }
            }
        };
        q26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.profile.parts.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileQRCodePosterPart.O9(Function1.this, obj);
            }
        });
        RobotInfo robotInfo = q26.getValue();
        if (robotInfo != null) {
            Intrinsics.checkNotNullExpressionValue(robotInfo, "robotInfo");
            V9(robotInfo);
            T9();
        }
        LiveData<GroupRobotProfile> r26 = this.viewModel.r2();
        LifecycleOwner lifecycleOwner2 = this.viewLifecycleOwner;
        final Function1<GroupRobotProfile, Unit> function12 = new Function1<GroupRobotProfile, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileQRCodePosterPart$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupRobotProfile groupRobotProfile) {
                invoke2(groupRobotProfile);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupRobotProfile robotProfile) {
                String i3;
                if (QQTheme.isNowThemeIsNight()) {
                    Intrinsics.checkNotNullExpressionValue(robotProfile, "robotProfile");
                    i3 = com.tencent.robot.profile.utils.a.p(robotProfile, true);
                } else {
                    Intrinsics.checkNotNullExpressionValue(robotProfile, "robotProfile");
                    i3 = com.tencent.robot.profile.utils.a.i(robotProfile, true);
                }
                RobotProfileQRCodePosterPart.this.S9(i3);
            }
        };
        r26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.robot.profile.parts.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileQRCodePosterPart.N9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshView() {
        int color;
        View view = this.robotInfoView;
        if (view != null) {
            view.setBackgroundColor(CommonExKt.l(getContext().getColor(R.color.qui_common_bubble_guest_secondary), 0.4f));
        }
        TextView textView = this.robotNameTextView;
        if (textView != null) {
            if (Q9()) {
                color = getContext().getColor(R.color.qui_common_bubble_guest_text_primary);
            } else {
                color = getContext().getColor(R.color.qui_common_text_primary);
            }
            textView.setTextColor(color);
        }
        TextView textView2 = this.robotDescTextView;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getColor(R.color.qui_common_bubble_guest_text_primary));
        }
        TextView textView3 = this.logoNameTextView;
        if (textView3 != null) {
            textView3.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        TextView textView4 = this.identifyQRCodeGuildTextView;
        if (textView4 != null) {
            textView4.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
        }
        ImageView imageView = this.logoView;
        if (imageView != null) {
            imageView.setImageDrawable(ie0.a.f().o(imageView.getContext(), R.drawable.qui_robot, R.color.qui_common_icon_primary, 1000));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "robot.profile.RobotProfileQRCodePosterPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "action_get_qr_code_poster_bitmap")) {
            boolean z16 = this.isBackgroundReady;
            if (z16 && this.isQRCodeReady) {
                return W9();
            }
            if (!z16) {
                S9(this.bgUrlApplier.invoke());
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View parentView) {
        ViewStub viewStub;
        View view;
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        if (Q9()) {
            viewStub = (ViewStub) parentView.findViewById(R.id.f26680e7);
        } else {
            viewStub = (ViewStub) parentView.findViewById(R.id.f26670e6);
        }
        if (viewStub != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        this.root = view;
        this.robotAvatarView = (ImageView) parentView.findViewById(R.id.f7627418);
        this.backgroundView = (ImageView) parentView.findViewById(R.id.a4j);
        this.topGradientView = parentView.findViewById(R.id.f99855qx);
        this.bottomGradientView = parentView.findViewById(R.id.t_o);
        this.robotInfoView = parentView.findViewById(R.id.f768142o);
        this.bottomMaskViewUp = parentView.findViewById(R.id.f164630ta0);
        this.bottomMaskViewDown = parentView.findViewById(R.id.t_z);
        this.logoView = (ImageView) parentView.findViewById(R.id.f7695432);
        this.logoNameTextView = (TextView) parentView.findViewById(R.id.f7694431);
        this.robotNameTextView = (TextView) parentView.findViewById(R.id.f770943f);
        this.robotDescTextView = (TextView) parentView.findViewById(R.id.f765241w);
        this.qrCodeContainerView = parentView.findViewById(R.id.f7736446);
        this.qrCodeView = (QUIColorfulQRCodeView) parentView.findViewById(R.id.f7737447);
        this.identifyQRCodeGuildTextView = (TextView) parentView.findViewById(R.id.f767842l);
        refreshView();
        S9(this.bgUrlApplier.invoke());
        P9();
        M9();
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        this.cacheBitmap = new Pair<>("", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
    }
}
