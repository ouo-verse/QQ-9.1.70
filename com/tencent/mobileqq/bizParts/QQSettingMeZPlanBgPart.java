package com.tencent.mobileqq.bizParts;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.de;
import com.tencent.mobileqq.utils.dg;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeZPlanBgPart;", "Lcom/tencent/mobileqq/part/a;", "", "M9", "O9", "U9", "", "K9", "x6", "L9", "S9", "", "needShowBg", "needShowZPlan", "V9", "T9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPostThemeChanged", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "zPlanContainer", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "zPlanContainerBgView", "i", "zPlanDefaultAvatarContainer", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "defaultAvatar", "Lcom/tencent/biz/qui/quibutton/QUIButton;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "button", "D", "Ljava/lang/String;", "bgUrl", "E", "Ljava/lang/Boolean;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "G", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDefaultAvatarInit", "H", "isZPlanContainerInit", "<init>", "()V", "I", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQSettingMeZPlanBgPart extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUIButton button;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String bgUrl;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Boolean needShowBg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Boolean needShowZPlan;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean isDefaultAvatarInit;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean isZPlanContainerInit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout zPlanContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout zPlanContainerBgView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout zPlanDefaultAvatarContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView defaultAvatar;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeZPlanBgPart$a;", "", "", "FILAMENT_DEFAULT_AVATAR", "Ljava/lang/String;", "TAG", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.QQSettingMeZPlanBgPart$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26143);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeZPlanBgPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isDefaultAvatarInit = new AtomicBoolean(false);
            this.isZPlanContainerInit = new AtomicBoolean(false);
        }
    }

    private final String K9() {
        dg dgVar = dg.f307630a;
        if (dgVar.c() == null) {
            return null;
        }
        com.tencent.mobileqq.activity.qqsettingme.bean.r c16 = dgVar.c();
        Intrinsics.checkNotNull(c16);
        if (c16.c() != null) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            com.tencent.mobileqq.activity.qqsettingme.bean.r c17 = dgVar.c();
            Intrinsics.checkNotNull(c17);
            long b16 = c17.b();
            com.tencent.mobileqq.activity.qqsettingme.bean.r c18 = dgVar.c();
            Intrinsics.checkNotNull(c18);
            boolean z16 = false;
            if (serverTimeMillis <= c18.a() && b16 <= serverTimeMillis) {
                z16 = true;
            }
            if (z16) {
                com.tencent.mobileqq.activity.qqsettingme.bean.r c19 = dgVar.c();
                Intrinsics.checkNotNull(c19);
                return c19.c();
            }
        }
        return null;
    }

    private final void L9() {
        VideoReport.setElementId(this.zPlanContainer, "em_drawer_avatar");
        VideoReport.setElementClickPolicy(this.zPlanContainer, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.zPlanContainer, ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        FrameLayout frameLayout;
        View partRootView = getPartRootView();
        LinearLayout linearLayout = null;
        if (partRootView != null) {
            frameLayout = (FrameLayout) partRootView.findViewById(R.id.yg7);
        } else {
            frameLayout = null;
        }
        this.zPlanContainer = frameLayout;
        View partRootView2 = getPartRootView();
        if (partRootView2 != null) {
            linearLayout = (LinearLayout) partRootView2.findViewById(R.id.yg8);
        }
        this.zPlanContainerBgView = linearLayout;
        com.tencent.mobileqq.qui.b.f276860a.a(this.zPlanContainer, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
        FrameLayout frameLayout2 = this.zPlanContainer;
        if (frameLayout2 != null) {
            frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.bizParts.bn
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQSettingMeZPlanBgPart.N9(QQSettingMeZPlanBgPart.this, view);
                }
            });
        }
        U9();
        L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QQSettingMeZPlanBgPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("QQSettingMeZPlanBgPart")) {
            QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class);
            Integer value = qQSettingMeViewModel.V.getValue();
            if (value != null && value.intValue() == 0) {
                qQSettingMeViewModel.f312693b0.postValue(3);
            } else {
                qQSettingMeViewModel.f312693b0.postValue(2);
            }
            DrawerUtils.f306948a.o(this$0.zPlanContainer, true);
            if (de.f307628a.c()) {
                VideoReport.reportEvent("clck", view, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        LinearLayout linearLayout;
        ImageView imageView;
        QUIButton qUIButton;
        TextView textView;
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.qq_setting_me_default_avatar_layout, (ViewGroup) this.zPlanContainer, false);
        TextView textView2 = null;
        if (inflate instanceof LinearLayout) {
            linearLayout = (LinearLayout) inflate;
        } else {
            linearLayout = null;
        }
        this.zPlanDefaultAvatarContainer = linearLayout;
        if (linearLayout != null) {
            imageView = (ImageView) linearLayout.findViewById(R.id.ufm);
        } else {
            imageView = null;
        }
        this.defaultAvatar = imageView;
        LinearLayout linearLayout2 = this.zPlanDefaultAvatarContainer;
        if (linearLayout2 != null) {
            qUIButton = (QUIButton) linearLayout2.findViewById(R.id.zz_);
        } else {
            qUIButton = null;
        }
        this.button = qUIButton;
        LinearLayout linearLayout3 = this.zPlanDefaultAvatarContainer;
        if (linearLayout3 != null) {
            textView = (TextView) linearLayout3.findViewById(R.id.f111306kv);
        } else {
            textView = null;
        }
        if (textView instanceof TextView) {
            textView2 = textView;
        }
        if (textView2 != null) {
            textView2.setTextColor(ex.b(R.color.qui_common_text_primary));
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable("https://static-res.qq.com/static-res/drawer/drawer_default_avatar_01.png", obtain);
        ImageView imageView2 = this.defaultAvatar;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable2);
        }
        S9();
        QUIButton qUIButton2 = this.button;
        if (qUIButton2 != null) {
            qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.bizParts.bo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QQSettingMeZPlanBgPart.P9(QQSettingMeZPlanBgPart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QQSettingMeZPlanBgPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        iZPlanApi.startAvatarSettingActivity(activity, "setting_me");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S9() {
        ImageView imageView = this.defaultAvatar;
        if (imageView != null) {
            imageView.setColorFilter(ContextCompat.getColor(getActivity(), R.color.qui_common_fill_standard_secondary), PorterDuff.Mode.DST_IN);
        }
    }

    private final void T9() {
        ViewParent viewParent;
        DrawerUtils.f306948a.b(this.isDefaultAvatarInit, new Function0<Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanBgPart$showDefaultAvatar$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanBgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    QQSettingMeZPlanBgPart.this.O9();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        LinearLayout linearLayout = this.zPlanDefaultAvatarContainer;
        if (linearLayout != null) {
            viewParent = linearLayout.getParent();
        } else {
            viewParent = null;
        }
        if (Intrinsics.areEqual(viewParent, this.zPlanContainer)) {
            return;
        }
        FrameLayout frameLayout = this.zPlanContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.zPlanContainer;
        if (frameLayout2 != null) {
            LinearLayout linearLayout2 = this.zPlanDefaultAvatarContainer;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.tencent.mobileqq.activity.qqsettingme.utils.b.b();
            Unit unit = Unit.INSTANCE;
            frameLayout2.addView(linearLayout2, layoutParams);
        }
    }

    private final void U9() {
        if (this.zPlanContainer != null) {
            String K9 = K9();
            if (TextUtils.isEmpty(K9)) {
                if (je0.a.a(getActivity())) {
                    K9 = "https://static-res.qq.com/static-res/zplan/background/zplan_bg_dark.png";
                } else {
                    K9 = "https://static-res.qq.com/static-res/zplan/background/zplan_bg_light.png";
                }
            }
            if (!TextUtils.equals(this.bgUrl, K9)) {
                this.bgUrl = K9;
                x6();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(boolean needShowBg, boolean needShowZPlan) {
        MutableLiveData<Integer> mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2;
        FrameLayout frameLayout;
        if (Intrinsics.areEqual(Boolean.valueOf(needShowBg), this.needShowBg) && Intrinsics.areEqual(Boolean.valueOf(needShowZPlan), this.needShowZPlan)) {
            return;
        }
        this.needShowBg = Boolean.valueOf(needShowBg);
        this.needShowZPlan = Boolean.valueOf(needShowZPlan);
        QLog.i("QQSettingMeZPlanBgPart", 2, "updateZPlanContainer needShowBg:" + needShowBg + " ,needShowZPlan:" + needShowZPlan);
        if (needShowBg) {
            DrawerUtils.f306948a.b(this.isZPlanContainerInit, new Function0<Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanBgPart$updateZPlanContainer$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanBgPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        QQSettingMeZPlanBgPart.this.M9();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
            LinearLayout linearLayout = this.zPlanContainerBgView;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout2 = this.zPlanContainerBgView;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        if (needShowZPlan) {
            LinearLayout linearLayout3 = this.zPlanDefaultAvatarContainer;
            if (linearLayout3 != null && (frameLayout = this.zPlanContainer) != null) {
                frameLayout.removeView(linearLayout3);
            }
            QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
            if (qQSettingMeViewModel != null && (mutableLiveData2 = qQSettingMeViewModel.f312697f0) != null) {
                mutableLiveData2.postValue(1);
                return;
            }
            return;
        }
        QQSettingMeViewModel qQSettingMeViewModel2 = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        if (qQSettingMeViewModel2 != null && (mutableLiveData = qQSettingMeViewModel2.f312697f0) != null) {
            mutableLiveData.postValue(0);
        }
        if (needShowBg) {
            T9();
        }
    }

    private final void x6() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = ex.c(R.drawable.qui_common_bg_bottom_standard_bg);
        obtain.mFailedDrawable = ex.c(R.drawable.qui_common_bg_bottom_standard_bg);
        URLDrawable drawable = URLDrawable.getDrawable(this.bgUrl, obtain);
        LinearLayout linearLayout = this.zPlanContainerBgView;
        if (linearLayout != null) {
            linearLayout.setBackground(drawable);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<Integer> mutableLiveData = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).V;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanBgPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanBgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                FrameLayout frameLayout;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                DrawerUtils drawerUtils = DrawerUtils.f306948a;
                frameLayout = QQSettingMeZPlanBgPart.this.zPlanContainer;
                drawerUtils.o(frameLayout, num != null && num.intValue() == 0);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.bl
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanBgPart.Q9(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData2 = ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f312698g0;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanBgPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanBgPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() == 0) {
                    QQSettingMeZPlanBgPart.this.V9(true, true);
                    return;
                }
                if (num != null && num.intValue() == 1) {
                    QQSettingMeZPlanBgPart.this.V9(true, false);
                } else if (num != null && num.intValue() == 2) {
                    QQSettingMeZPlanBgPart.this.V9(false, false);
                }
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.bizParts.bm
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanBgPart.R9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            U9();
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        U9();
        S9();
    }
}
