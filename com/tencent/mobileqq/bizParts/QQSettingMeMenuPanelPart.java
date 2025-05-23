package com.tencent.mobileqq.bizParts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeConstant;
import com.tencent.mobileqq.activity.qqsettingme.api.IThemeLabelTextViewApi;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0002PQB\u0007\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010\u001d\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u001c\u0010\u001e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010&\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\u0012\u0010)\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0016R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0018\u00109\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0018\u0010<\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010A\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR$\u0010L\u001a\u0012\u0012\u0004\u0012\u00020\u001f0Hj\b\u0012\u0004\u0012\u00020\u001f`I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeMenuPanelPart;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "", "W9", "T9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/j;", "bean", "la", "X9", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/q;", "pa", "", "needShowZPlanBubble", "ea", "", "bizId", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "ha", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/o;", "oa", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/b;", "ia", "Lcom/tencent/mobileqq/activity/qqsettingme/config/QQSettingMeBizBean;", "bizBean", "Y9", "U9", LocaleUtils.L_JAPANESE, "ga", "na", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPostThemeChanged", "v", NodeProps.ON_CLICK, "Landroidx/cardview/widget/CardView;", "f", "Landroidx/cardview/widget/CardView;", "midContentCardView", "Landroid/widget/RelativeLayout;", tl.h.F, "Landroid/widget/RelativeLayout;", "menuRoot", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "bubbleContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zPlanBubbleContainer", BdhLogUtil.LogTag.Tag_Conn, "menuPanel", "D", "Landroid/view/View;", "profileBubbleMsgView", "E", "zPlanBubbleView", UserInfo.SEX_FEMALE, "Z", "isBgDrawableValid", "Ljava/util/concurrent/atomic/AtomicBoolean;", "G", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isBubbleViewInit", "H", "isZPlanBubbleInit", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "I", "Ljava/util/ArrayList;", "itemViewList", "<init>", "()V", "J", "a", "b", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes11.dex */
public final class QQSettingMeMenuPanelPart extends com.tencent.mobileqq.part.a implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ViewGroup menuPanel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View profileBubbleMsgView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View zPlanBubbleView;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isBgDrawableValid;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean isBubbleViewInit;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean isZPlanBubbleInit;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<View> itemViewList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CardView midContentCardView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout menuRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup bubbleContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup zPlanBubbleContainer;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeMenuPanelPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.QQSettingMeMenuPanelPart$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeMenuPanelPart$b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "", "d", "Ljava/lang/String;", "mBizId", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/bizParts/QQSettingMeMenuPanelPart;", "e", "Ljava/lang/ref/WeakReference;", "mMenuPanelPart", "menuPanelPart", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/bizParts/QQSettingMeMenuPanelPart;)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String mBizId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QQSettingMeMenuPanelPart> mMenuPanelPart;

        public b(@NotNull String mBizId, @NotNull QQSettingMeMenuPanelPart menuPanelPart) {
            Intrinsics.checkNotNullParameter(mBizId, "mBizId");
            Intrinsics.checkNotNullParameter(menuPanelPart, "menuPanelPart");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mBizId, (Object) menuPanelPart);
            } else {
                this.mBizId = mBizId;
                this.mMenuPanelPart = new WeakReference<>(menuPanelPart);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View v3) {
            boolean z16;
            QQSettingMeBizBean c16;
            EventCollector.getInstance().onViewClickedBefore(v3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else {
                QQSettingMeMenuPanelPart qQSettingMeMenuPanelPart = this.mMenuPanelPart.get();
                if (qQSettingMeMenuPanelPart != null) {
                    com.tencent.mobileqq.part.b bVar = (com.tencent.mobileqq.part.b) qQSettingMeMenuPanelPart.getPartHost();
                    if (v3 != null && bVar != null && bVar.m() && !FastClickUtils.isFastDoubleClick("QQSettingMeMenuPanelPart")) {
                        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(this.mBizId);
                        if (g16 != null && g16.hasRedTouch()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        ((QQSettingMeViewModel) qQSettingMeMenuPanelPart.getViewModel(QQSettingMeViewModel.class)).N1(this.mBizId).onClick(v3);
                        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
                        int i3 = z16;
                        if (companion.j()) {
                            TianshuRedTouch e16 = com.tencent.mobileqq.qqsettingme.a.e(this.mBizId);
                            i3 = z16;
                            if (e16 != null) {
                                boolean c17 = companion.c(e16);
                                e16.x();
                                i3 = c17;
                            }
                        }
                        if ((QQSettingMeConstant.a(this.mBizId) || QQSettingMeConstant.b(this.mBizId)) && (c16 = com.tencent.mobileqq.qqsettingme.a.c(this.mBizId)) != null && !TextUtils.isEmpty(c16.i())) {
                            VideoReport.setElementParam(v3, "is_red_tips_em", Integer.valueOf(i3));
                            VideoReport.reportEvent("clck", v3, null);
                        }
                        if (Intrinsics.areEqual(this.mBizId, "d_zplan")) {
                            VideoReport.reportEvent("clck", v3, null);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(v3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25790);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeMenuPanelPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isBgDrawableValid = true;
        this.isBubbleViewInit = new AtomicBoolean(false);
        this.isZPlanBubbleInit = new AtomicBoolean(false);
        this.itemViewList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.qq_setting_me_item_profilebubblemsg_v9, this.bubbleContainer, false);
        this.profileBubbleMsgView = inflate;
        if (inflate != null) {
            inflate.setVisibility(8);
        }
        ViewGroup viewGroup = this.bubbleContainer;
        if (viewGroup != null) {
            viewGroup.addView(this.profileBubbleMsgView);
        }
    }

    private final void U9() {
        getPartRootView().post(new Runnable() { // from class: com.tencent.mobileqq.bizParts.u
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeMenuPanelPart.V9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9() {
        boolean z16;
        TianshuRedTouch e16;
        for (QQSettingMeBizBean qQSettingMeBizBean : com.tencent.mobileqq.qqsettingme.a.d().values()) {
            RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(qQSettingMeBizBean.n());
            View h16 = com.tencent.mobileqq.qqsettingme.a.h(qQSettingMeBizBean.n());
            if (!TextUtils.isEmpty(qQSettingMeBizBean.i()) && h16 != null) {
                VideoReport.setElementId(h16, qQSettingMeBizBean.i());
                VideoReport.setElementClickPolicy(h16, ClickPolicy.REPORT_NONE);
                VideoReport.setElementExposePolicy(h16, ExposurePolicy.REPORT_NONE);
                if (g16 != null) {
                    z16 = g16.hasRedTouch();
                } else {
                    z16 = false;
                }
                TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
                if (companion.j() && (e16 = com.tencent.mobileqq.qqsettingme.a.e(qQSettingMeBizBean.n())) != null) {
                    z16 = companion.c(e16);
                }
                VideoReport.setElementDynamicParams(h16, new com.tencent.mobileqq.activity.qqsettingme.m().b(z16, com.tencent.mobileqq.activity.qqsettingme.utils.b.c(qQSettingMeBizBean.n()), qQSettingMeBizBean.n()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v5 */
    private final void W9() {
        View view;
        CharSequence charSequence;
        int i3;
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f2();
        com.tencent.mobileqq.qqsettingme.a.d().clear();
        int i16 = 2;
        int d16 = ex.d(2);
        com.tencent.mobileqq.activity.qqsettingme.config.a aVar = new com.tencent.mobileqq.activity.qqsettingme.config.a();
        int length = aVar.a().length;
        ?? r65 = 0;
        int i17 = 0;
        boolean z16 = false;
        while (i17 < length) {
            QQSettingMeBizBean qQSettingMeBizBean = aVar.a()[i17];
            com.tencent.mobileqq.activity.qqsettingme.ac acVar = new com.tencent.mobileqq.activity.qqsettingme.ac();
            ViewGroup viewGroup = this.menuPanel;
            if (viewGroup != null) {
                view = viewGroup.getChildAt(i17);
            } else {
                view = null;
            }
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.qq_setting_me_item_v9, this.menuPanel, (boolean) r65);
                Intrinsics.checkNotNullExpressionValue(view, "from(context)\n          \u2026tem_v9, menuPanel, false)");
                ViewGroup viewGroup2 = this.menuPanel;
                if (viewGroup2 != null) {
                    viewGroup2.addView(view);
                }
                QLog.i("QQSettingMeMenuPanelPart", i16, "initMenuBiz addView");
            }
            if (!z16) {
                this.isBgDrawableValid = DrawerUtils.f306948a.a(view.getBackground());
                z16 = true;
            }
            if (!this.isBgDrawableValid) {
                view.setBackground(DrawerUtils.f306948a.e());
            }
            this.itemViewList.add(view);
            view.setFocusable(true);
            String n3 = qQSettingMeBizBean.n();
            Intrinsics.checkNotNullExpressionValue(n3, "bizBean.pluginID");
            view.setOnClickListener(new b(n3, this));
            URLImageView leftIcon = (URLImageView) view.findViewById(R.id.umf);
            int color = ContextCompat.getColor(getActivity(), R.color.qui_common_icon_primary);
            Intrinsics.checkNotNullExpressionValue(leftIcon, "leftIcon");
            DrawerUtils.m(leftIcon, qQSettingMeBizBean);
            leftIcon.setColorFilter(color);
            RedTouchTextView redTouchTextView = (RedTouchTextView) view.findViewById(R.id.umj);
            String n16 = qQSettingMeBizBean.n();
            if (qQSettingMeBizBean.r() != null) {
                charSequence = qQSettingMeBizBean.r().f184991a;
            } else {
                charSequence = "";
            }
            redTouchTextView.setText(com.tencent.mobileqq.activity.qqsettingme.utils.b.d(n16, charSequence));
            redTouchTextView.setUseRedTouchTextColorFromConfig(r65);
            redTouchTextView.setTextColor(ex.b(R.color.qui_common_text_primary));
            TextView textView = (TextView) view.findViewById(R.id.umh);
            ((IThemeLabelTextViewApi) QRoute.api(IThemeLabelTextViewApi.class)).setSupportMaskView(textView, true);
            textView.setVisibility(r65);
            AccessibilityUtil.c(view, qQSettingMeBizBean.r().f184991a, Button.class.getName());
            leftIcon.setPadding(d16, d16, d16, d16);
            ViewGroup.LayoutParams layoutParams = leftIcon.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).leftMargin -= d16;
            ViewGroup.LayoutParams layoutParams2 = redTouchTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).leftMargin -= d16;
            if (com.tencent.mobileqq.activity.qqsettingme.utils.b.h(qQSettingMeBizBean)) {
                i3 = 8;
            } else {
                i3 = r65;
            }
            view.setVisibility(i3);
            acVar.h(view);
            acVar.f(redTouchTextView);
            qQSettingMeBizBean.w(acVar);
            if (TianshuRedTouch.INSTANCE.j()) {
                redTouchTextView.R = Boolean.TRUE;
                redTouchTextView.c();
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ume);
                frameLayout.setVisibility(r65);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams3.gravity = 19;
                layoutParams3.leftMargin = (int) TypedValue.applyDimension(1, 10.0f, view.getResources().getDisplayMetrics());
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams4.gravity = 19;
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                acVar.e(new TianshuRedTouch(activity, frameLayout).s0(redTouchTextView.getWidth()).i0(redTouchTextView.getHeight()).h0(8388629).m0(layoutParams4).q().k0(layoutParams3).p0(TianshuRedTouch.RedTouchAssembleType.ALL_REDTOUCH).n0(qQSettingMeBizBean.o()));
            }
            AbstractMap d17 = com.tencent.mobileqq.qqsettingme.a.d();
            Intrinsics.checkNotNullExpressionValue(d17, "getItemBeanMap()");
            d17.put(qQSettingMeBizBean.n(), qQSettingMeBizBean);
            ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).e2(qQSettingMeBizBean.n());
            i17++;
            i16 = 2;
            r65 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X9() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.qq_setting_me_item_zplan_bubble, this.zPlanBubbleContainer, false);
        this.zPlanBubbleView = inflate;
        ViewGroup viewGroup = this.zPlanBubbleContainer;
        if (viewGroup != null) {
            viewGroup.addView(inflate);
        }
        VideoReport.setElementId(this.zPlanBubbleView, "em_drawer_bubble");
        VideoReport.setElementClickPolicy(this.zPlanBubbleView, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(this.zPlanBubbleView, ExposurePolicy.REPORT_ALL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int, boolean] */
    private final void Y9(QQSettingMeBizBean bizBean) {
        boolean z16;
        Map mapOf;
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(bizBean.n());
        if (g16 != null) {
            z16 = g16.hasRedTouch();
        } else {
            z16 = false;
        }
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        ?? r06 = z16;
        if (companion.j()) {
            TianshuRedTouch e16 = com.tencent.mobileqq.qqsettingme.a.e(bizBean.n());
            r06 = z16;
            if (e16 != null) {
                r06 = companion.c(e16);
            }
        }
        View h16 = com.tencent.mobileqq.qqsettingme.a.h(bizBean.n());
        VideoReport.setElementDynamicParams(h16, new com.tencent.mobileqq.activity.qqsettingme.m().b(r06, com.tencent.mobileqq.activity.qqsettingme.utils.b.c(bizBean.n()), bizBean.n()));
        if (bizBean.i() != null) {
            VideoReport.setElementId(h16, bizBean.i());
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_red_tips_em", Integer.valueOf((int) r06)));
        VideoReport.reportEvent("imp", h16, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ea(boolean needShowZPlanBubble) {
        QLog.i("QQSettingMeMenuPanelPart", 2, "refreshBubbles needShowZPlanBubble? " + needShowZPlanBubble);
        if (needShowZPlanBubble) {
            ViewGroup viewGroup = this.bubbleContainer;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.zPlanBubbleContainer;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(0);
                return;
            }
            return;
        }
        ViewGroup viewGroup3 = this.bubbleContainer;
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(0);
        }
        ViewGroup viewGroup4 = this.zPlanBubbleContainer;
        if (viewGroup4 != null) {
            viewGroup4.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0 A[LOOP:0: B:33:0x009c->B:38:0x00d0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2 A[EDGE_INSN: B:39:0x00d2->B:50:0x00d2 BREAK  A[LOOP:0: B:33:0x009c->B:38:0x00d0], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ga(String bizId, BusinessInfoCheckUpdate.AppInfo appInfo) {
        URLImageView uRLImageView;
        com.tencent.mobileqq.activity.qqsettingme.ac acVar;
        RedTouch g16 = com.tencent.mobileqq.qqsettingme.a.g(bizId);
        if (g16 == null) {
            View h16 = com.tencent.mobileqq.qqsettingme.a.h(bizId);
            if (h16 != null) {
                uRLImageView = (URLImageView) h16.findViewById(R.id.umf);
            } else {
                uRLImageView = null;
            }
            if (uRLImageView == null) {
                return;
            }
            g16 = new RedTouch(getActivity(), uRLImageView).setGravity(8388661).applyTo();
            QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
            if (c16 != null) {
                acVar = c16.k();
            } else {
                acVar = null;
            }
            if (acVar != null) {
                acVar.g(g16);
            }
        }
        RedTouchTextView f16 = com.tencent.mobileqq.qqsettingme.a.f(bizId);
        if (f16 == null) {
            return;
        }
        if (appInfo == null) {
            if (g16.hasRedTouch()) {
                g16.parseRedTouch((BusinessInfoCheckUpdate.AppInfo) null);
                f16.setAppInfo(null);
                return;
            }
            return;
        }
        if (appInfo.iNewFlag.get() != 0 && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
            BusinessInfoCheckUpdate.AppInfo appInfo2 = new BusinessInfoCheckUpdate.AppInfo();
            appInfo2.set(appInfo);
            BusinessInfoCheckUpdate.AppInfo appInfo3 = new BusinessInfoCheckUpdate.AppInfo();
            appInfo3.set(appInfo);
            ArrayList arrayList = new ArrayList(appInfo3.red_display_info.red_type_info.get());
            int size = arrayList.size() - 1;
            boolean z16 = false;
            if (size >= 0) {
                while (true) {
                    int i3 = size - 1;
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo) arrayList.get(size);
                    int i16 = redTypeInfo.red_type.get();
                    if (i16 == 0) {
                        arrayList.remove(size);
                    } else if (i16 == 3 && RedTouchTextView.u(redTypeInfo, appInfo3)) {
                        RedTouchTextView.setImageRedNotShowRedPoint(redTypeInfo, appInfo);
                    } else {
                        if (i16 == 15 && RedTouchTextView.t(redTypeInfo, appInfo3)) {
                            RedTouchTextView.setDiffImageRedNotShowRedPoint(redTypeInfo, appInfo);
                        }
                        if (i3 >= 0) {
                            break;
                        } else {
                            size = i3;
                        }
                    }
                    z16 = true;
                    if (i3 >= 0) {
                    }
                }
            }
            if (arrayList.size() < 2) {
                arrayList.clear();
            }
            appInfo3.red_display_info.red_type_info.set(arrayList);
            ArrayList arrayList2 = new ArrayList();
            if (z16) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo2.red_type.set(0);
                arrayList2.add(redTypeInfo2);
            }
            appInfo2.red_display_info.red_type_info.set(arrayList2);
            g16.parseRedTouch(appInfo2);
            f16.setAppInfo(appInfo3);
            return;
        }
        if (g16.hasRedTouch()) {
            g16.parseRedTouch(appInfo);
            f16.setAppInfo(appInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(String bizId, BusinessInfoCheckUpdate.AppInfo appInfo) {
        View m3;
        QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
        boolean z16 = false;
        if (c16 != null && (m3 = c16.m()) != null && m3.getVisibility() == 0) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        try {
            ja(bizId, appInfo);
        } catch (Exception e16) {
            QLog.e("QQSettingMeMenuPanelPart", 1, "updateDrawerRedTouch error: " + bizId + ", " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia(com.tencent.mobileqq.activity.qqsettingme.bean.b bean) {
        QQSettingMeBizBean c16;
        View m3;
        CharSequence charSequence;
        if (bean == null || (c16 = com.tencent.mobileqq.qqsettingme.a.c(bean.f184875a)) == null || (m3 = c16.m()) == null) {
            return;
        }
        TextView textView = (TextView) m3.findViewById(R.id.umj);
        if (c16.r() != null) {
            charSequence = c16.r().f184991a;
        } else {
            charSequence = "";
        }
        String str = bean.f184875a;
        if (!TextUtils.isEmpty(bean.f184876b)) {
            charSequence = bean.f184876b;
        }
        CharSequence d16 = com.tencent.mobileqq.activity.qqsettingme.utils.b.d(str, charSequence);
        if (!TextUtils.isEmpty(d16)) {
            textView.setText(d16);
        }
        AccessibilityUtil.c(m3, textView.getText(), Button.class.getName());
        URLImageView itemIcon = (URLImageView) m3.findViewById(R.id.umf);
        URLDrawable uRLDrawable = bean.f184877c;
        if (uRLDrawable == null) {
            Intrinsics.checkNotNullExpressionValue(itemIcon, "itemIcon");
            DrawerUtils.m(itemIcon, c16);
            return;
        }
        if (uRLDrawable != null) {
            if (QQTheme.isNowThemeIsNight()) {
                ContextCompat.getColor(getActivity(), R.color.qui_common_icon_primary);
                itemIcon.setImageDrawable(cn.f(bean.f184877c));
                itemIcon.setColorFilter(new LightingColorFilter(0, ContextCompat.getColor(getActivity(), R.color.qui_common_icon_primary)));
                return;
            }
            itemIcon.setImageDrawable(bean.f184877c);
            return;
        }
        try {
            itemIcon.setImageResource(c16.f184985f);
        } catch (NumberFormatException e16) {
            QLog.e("QQSettingMeMenuPanelPart", 1, "updateDynamicView error:" + e16 + TokenParser.SP);
        }
    }

    private final void ja(String bizId, BusinessInfoCheckUpdate.AppInfo appInfo) {
        CharSequence charSequence;
        View m3;
        PBInt32Field pBInt32Field;
        RedTouchTextView p16;
        if (na(bizId, appInfo)) {
            QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
            if (c16 != null) {
                Y9(c16);
                return;
            }
            return;
        }
        ga(bizId, appInfo);
        QQSettingMeBizBean c17 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
        if (c17 != null && (p16 = c17.p()) != null) {
            charSequence = p16.getText();
        } else {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z16 = false;
        if (appInfo != null && (pBInt32Field = appInfo.iNewFlag) != null && pBInt32Field.get() == 1) {
            z16 = true;
        }
        if (z16) {
            charSequence = ((Object) charSequence) + " \u6709\u65b0\u5185\u5bb9";
        }
        QQSettingMeBizBean c18 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
        if (c18 != null && (m3 = c18.m()) != null) {
            AccessibilityUtil.c(m3, charSequence, Button.class.getName());
        }
        QQSettingMeBizBean c19 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
        if (c19 != null) {
            Y9(c19);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la(com.tencent.mobileqq.activity.qqsettingme.bean.j bean) {
        long j3;
        View view;
        final QQProAvatarView qQProAvatarView;
        final TextView textView;
        final ImageView imageView;
        boolean equals;
        if (bean.f184915a && bean.f184917c != null) {
            QLog.d("QQSettingMeMenuPanelPart", 1, "updateProfileBubbleMsgView " + bean.f184916b);
            if (bean.f184917c.uint64_from_uin.has()) {
                j3 = bean.f184917c.uint64_from_uin.get();
            } else {
                j3 = 0;
            }
            View view2 = this.profileBubbleMsgView;
            CharSequence charSequence = null;
            if (view2 != null) {
                view = view2.findViewById(R.id.f165030un3);
            } else {
                view = null;
            }
            View view3 = this.profileBubbleMsgView;
            if (view3 != null) {
                qQProAvatarView = (QQProAvatarView) view3.findViewById(R.id.f165028un1);
            } else {
                qQProAvatarView = null;
            }
            View view4 = this.profileBubbleMsgView;
            if (view4 != null) {
                textView = (TextView) view4.findViewById(R.id.f165029un2);
            } else {
                textView = null;
            }
            View view5 = this.profileBubbleMsgView;
            if (view5 != null) {
                imageView = (ImageView) view5.findViewById(R.id.f165027un0);
            } else {
                imageView = null;
            }
            if (textView != null) {
                textView.setTextColor(ex.b(R.color.qui_common_text_primary));
            }
            if (j3 == 111) {
                if (qQProAvatarView != null) {
                    qQProAvatarView.setImageDrawable(ex.c(R.drawable.nfz));
                }
            } else if (j3 == 112) {
                if (qQProAvatarView != null) {
                    qQProAvatarView.setImageDrawable(ex.c(R.drawable.f161827ng2));
                }
            } else if (qQProAvatarView != null) {
                qQProAvatarView.w(1, String.valueOf(j3));
            }
            String string = getActivity().getResources().getString(R.string.vvh, Integer.valueOf(bean.f184916b));
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources\n     \u2026, bean.redTouchItemCount)");
            if (textView != null) {
                charSequence = textView.getText();
            }
            equals = StringsKt__StringsJVMKt.equals(string, String.valueOf(charSequence), true);
            if (!equals && textView != null) {
                textView.setText(string);
            }
            if (view != null) {
                view.setContentDescription(string);
            }
            if (view != null) {
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.bizParts.aa
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view6, MotionEvent motionEvent) {
                        boolean ma5;
                        ma5 = QQSettingMeMenuPanelPart.ma(QQProAvatarView.this, textView, imageView, view6, motionEvent);
                        return ma5;
                    }
                });
            }
            if (view != null) {
                view.setOnClickListener(this);
            }
            View view6 = this.profileBubbleMsgView;
            if (view6 != null) {
                view6.setVisibility(0);
                return;
            }
            return;
        }
        View view7 = this.profileBubbleMsgView;
        if (view7 != null) {
            view7.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ma(QQProAvatarView qQProAvatarView, TextView textView, ImageView imageView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (qQProAvatarView != null) {
                    qQProAvatarView.setAlpha(1.0f);
                }
                if (textView != null) {
                    textView.setAlpha(1.0f);
                }
                if (imageView != null) {
                    imageView.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            return false;
        }
        if (qQProAvatarView != null) {
            qQProAvatarView.setAlpha(0.5f);
        }
        if (textView != null) {
            textView.setAlpha(0.5f);
        }
        if (imageView != null) {
            imageView.setAlpha(0.5f);
            return false;
        }
        return false;
    }

    private final boolean na(String bizId, BusinessInfoCheckUpdate.AppInfo appInfo) {
        TianshuRedTouch l3;
        String str;
        PBStringField pBStringField;
        if (TianshuRedTouch.INSTANCE.j()) {
            QQSettingMeBizBean c16 = com.tencent.mobileqq.qqsettingme.a.c(bizId);
            if (c16 != null && (l3 = c16.l()) != null) {
                if (appInfo != null && (pBStringField = appInfo.path) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                l3.n0(str);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oa(com.tencent.mobileqq.activity.qqsettingme.bean.o bean) {
        try {
            if (!bean.f184935a.path.has()) {
                bean.f184935a.path.set("100400");
            }
            BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
            appInfo.set(bean.f184935a);
            if (bean.f184939e && RedTouchTextView.n(appInfo) != null) {
                ArrayList arrayList = new ArrayList();
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo.red_type.set(0);
                arrayList.add(redTypeInfo);
                appInfo.red_display_info.red_type_info.set(arrayList);
            }
            ja("d_vip_identity", appInfo);
        } catch (Exception e16) {
            QLog.e("QQSettingMeMenuPanelPart", 1, "updateSuperMemberItemView: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void pa(com.tencent.mobileqq.activity.qqsettingme.bean.q bean) {
        String str;
        String str2;
        String str3;
        String str4;
        View view;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        boolean z16;
        String str5;
        boolean startsWith$default;
        boolean z17 = true;
        if (this.zPlanBubbleView == null) {
            QLog.e("QQSettingMeMenuPanelPart", 1, "updateZplanBubbleView zplanBubbleView is null");
            return;
        }
        boolean z18 = !com.tencent.mobileqq.activity.qqsettingme.utils.b.f(bean);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateZplanBubbleView bean: [bg:");
        if (bean != null) {
            str = bean.f184952c;
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(", scheme:");
        if (bean != null) {
            str2 = bean.f184957h;
        } else {
            str2 = null;
        }
        sb5.append(str2);
        sb5.append(", title:");
        if (bean != null) {
            str3 = bean.f184954e;
        } else {
            str3 = null;
        }
        sb5.append(str3);
        sb5.append(", subtitle:");
        if (bean != null) {
            str4 = bean.f184955f;
        } else {
            str4 = null;
        }
        sb5.append(str4);
        sb5.append(']');
        QLog.i("QQSettingMeMenuPanelPart", 2, sb5.toString());
        if (z18) {
            QLog.e("QQSettingMeMenuPanelPart", 1, "updateZplanBubbleView bean is error");
            ea(false);
            return;
        }
        View view2 = this.zPlanBubbleView;
        if (view2 != null) {
            view = view2.findViewById(R.id.uof);
        } else {
            view = null;
        }
        View view3 = this.zPlanBubbleView;
        if (view3 != null) {
            imageView = (ImageView) view3.findViewById(R.id.f126167o1);
        } else {
            imageView = null;
        }
        View view4 = this.zPlanBubbleView;
        if (view4 != null) {
            textView = (TextView) view4.findViewById(R.id.f126187o3);
        } else {
            textView = null;
        }
        View view5 = this.zPlanBubbleView;
        if (view5 != null) {
            textView2 = (TextView) view5.findViewById(R.id.f126177o2);
        } else {
            textView2 = null;
        }
        if (bean != null) {
            ea(true);
            if (view != null) {
                view.setVisibility(0);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(bean.f184952c, obtain);
            if (view != null) {
                view.setBackground(drawable2);
            }
            if (view != null) {
                view.setOnClickListener(this);
            }
            if (view != null) {
                view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.bizParts.ab
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view6, MotionEvent motionEvent) {
                        boolean qa5;
                        qa5 = QQSettingMeMenuPanelPart.qa(view6, motionEvent);
                        return qa5;
                    }
                });
            }
            String str6 = bean.f184953d;
            if (str6 != null) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str6, "http", false, 2, null);
                if (startsWith$default) {
                    z16 = true;
                    if (!z16) {
                        if (imageView != null) {
                            imageView.setVisibility(0);
                        }
                        URLDrawable drawable3 = URLDrawable.getDrawable(bean.f184953d, URLDrawable.URLDrawableOptions.obtain());
                        if (imageView != null) {
                            imageView.setImageDrawable(drawable3);
                        }
                    } else if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    if (textView != null) {
                        textView.setText(bean.f184954e);
                    }
                    str5 = bean.f184955f;
                    if (str5 != null && str5.length() != 0) {
                        z17 = false;
                    }
                    if (!z17) {
                        if (textView2 != null) {
                            textView2.setVisibility(8);
                            return;
                        }
                        return;
                    } else {
                        if (textView2 != null) {
                            textView2.setText(bean.f184955f);
                        }
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                            return;
                        }
                        return;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            if (textView != null) {
            }
            str5 = bean.f184955f;
            if (str5 != null) {
                z17 = false;
            }
            if (!z17) {
            }
        } else {
            ea(false);
            if (view != null) {
                view.setBackground(null);
            }
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean qa(View view, MotionEvent motionEvent) {
        Integer num;
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            if (view != null) {
                view.setAlpha(0.5f);
            }
        } else {
            boolean z16 = true;
            if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
                z16 = false;
            }
            if (z16 && view != null) {
                view.setAlpha(1.0f);
            }
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else if (!FastClickUtils.isFastDoubleClick("QQSettingMeMenuPanelPart")) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f165030un3) {
                ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_profile_bubble").onClick(v3);
            } else if (num != null && num.intValue() == R.id.uof) {
                ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1("d_zplan_bubble").onClick(v3);
            }
            TianshuRedTouch x95 = x9();
            if (x95 != null) {
                x95.x();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        CardView cardView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        CardView cardView2 = null;
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.um8);
        } else {
            relativeLayout = null;
        }
        this.menuRoot = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setPadding(0, 0, 0, Math.max(com.tencent.mobileqq.activity.qqsettingme.utils.b.b(), ex.d(58) + ScreenUtil.getNavigationBarHeight(getActivity())));
        }
        RelativeLayout relativeLayout2 = this.menuRoot;
        if (relativeLayout2 != null) {
            viewGroup = (ViewGroup) relativeLayout2.findViewById(R.id.umr);
        } else {
            viewGroup = null;
        }
        this.menuPanel = viewGroup;
        RelativeLayout relativeLayout3 = this.menuRoot;
        if (relativeLayout3 != null) {
            viewGroup2 = (ViewGroup) relativeLayout3.findViewById(R.id.um6);
        } else {
            viewGroup2 = null;
        }
        this.bubbleContainer = viewGroup2;
        RelativeLayout relativeLayout4 = this.menuRoot;
        if (relativeLayout4 != null) {
            viewGroup3 = (ViewGroup) relativeLayout4.findViewById(R.id.uoe);
        } else {
            viewGroup3 = null;
        }
        this.zPlanBubbleContainer = viewGroup3;
        RelativeLayout relativeLayout5 = this.menuRoot;
        if (relativeLayout5 != null) {
            cardView = (CardView) relativeLayout5.findViewById(R.id.z6i);
        } else {
            cardView = null;
        }
        if (cardView instanceof CardView) {
            cardView2 = cardView;
        }
        this.midContentCardView = cardView2;
        W9();
        U9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.o> mutableLiveData = qQSettingMeViewModel.J;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.o, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.o, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeMenuPanelPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuPanelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.o oVar) {
                invoke2(oVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.o it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeMenuPanelPart qQSettingMeMenuPanelPart = QQSettingMeMenuPanelPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeMenuPanelPart.oa(it);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeMenuPanelPart.Z9(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.b> mutableLiveData2 = qQSettingMeViewModel.K;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.b, Unit> function12 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.b, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeMenuPanelPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuPanelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.b bVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeMenuPanelPart.this.ia(bVar);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                }
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.bizParts.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeMenuPanelPart.aa(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.k> mutableLiveData3 = qQSettingMeViewModel.P;
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final QQSettingMeMenuPanelPart$onPartCreate$3 qQSettingMeMenuPanelPart$onPartCreate$3 = new QQSettingMeMenuPanelPart$onPartCreate$3(this);
        mutableLiveData3.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.bizParts.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeMenuPanelPart.ba(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.j> mutableLiveData4 = qQSettingMeViewModel.Q;
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.j, Unit> function13 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.j, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeMenuPanelPart$onPartCreate$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuPanelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.j jVar) {
                invoke2(jVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.j it) {
                AtomicBoolean atomicBoolean;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                DrawerUtils drawerUtils = DrawerUtils.f306948a;
                atomicBoolean = QQSettingMeMenuPanelPart.this.isBubbleViewInit;
                drawerUtils.b(atomicBoolean, new Function0<Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeMenuPanelPart$onPartCreate$4.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuPanelPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            QQSettingMeMenuPanelPart.this.T9();
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                });
                QQSettingMeMenuPanelPart qQSettingMeMenuPanelPart = QQSettingMeMenuPanelPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeMenuPanelPart.la(it);
            }
        };
        mutableLiveData4.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.bizParts.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeMenuPanelPart.ca(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.q> mutableLiveData5 = qQSettingMeViewModel.R;
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.q, Unit> function14 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.q, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeMenuPanelPart$onPartCreate$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuPanelPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.q qVar) {
                invoke2(qVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.q qVar) {
                AtomicBoolean atomicBoolean;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) qVar);
                    return;
                }
                DrawerUtils drawerUtils = DrawerUtils.f306948a;
                atomicBoolean = QQSettingMeMenuPanelPart.this.isZPlanBubbleInit;
                drawerUtils.b(atomicBoolean, new Function0<Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeMenuPanelPart$onPartCreate$5.1
                    static IPatchRedirector $redirector_;

                    {
                        super(0);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) QQSettingMeMenuPanelPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            QQSettingMeMenuPanelPart.this.X9();
                        } else {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    }
                });
                QQSettingMeMenuPanelPart.this.pa(qVar);
            }
        };
        mutableLiveData5.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.bizParts.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeMenuPanelPart.da(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        for (QQSettingMeBizBean qQSettingMeBizBean : com.tencent.mobileqq.qqsettingme.a.d().values()) {
            if (qQSettingMeBizBean.m() != null) {
                if (!this.isBgDrawableValid) {
                    qQSettingMeBizBean.m().setBackground(DrawerUtils.f306948a.e());
                }
                View m3 = qQSettingMeBizBean.m();
                if (!com.tencent.mobileqq.activity.qqsettingme.utils.b.h(qQSettingMeBizBean) && !((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).N1(qQSettingMeBizBean.n()).f()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                m3.setVisibility(i3);
                View findViewById = qQSettingMeBizBean.m().findViewById(R.id.umf);
                Intrinsics.checkNotNullExpressionValue(findViewById, "bizBean.itemView.findVie\u2026id.drawer_item_left_icon)");
                ((URLImageView) findViewById).setColorFilter(ContextCompat.getColor(getActivity(), R.color.qui_common_icon_primary));
            }
        }
    }
}
