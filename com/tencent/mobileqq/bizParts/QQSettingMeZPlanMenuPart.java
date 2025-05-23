package com.tencent.mobileqq.bizParts;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeZPlanMenuPart;", "Lcom/tencent/mobileqq/part/a;", "Landroid/view/View$OnClickListener;", "", "initView", "J9", "I9", "H9", "", "nickname", "N9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPostThemeChanged", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroidx/cardview/widget/CardView;", "f", "Landroidx/cardview/widget/CardView;", "cardView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "nicknameTv", "i", "Landroid/view/View;", "profileCard", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "itemAvatar", BdhLogUtil.LogTag.Tag_Conn, "itemAttire", "D", "itemSmallHome", "", "E", "Z", "isBgDrawableValid", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "<init>", "()V", "G", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QQSettingMeZPlanMenuPart extends com.tencent.mobileqq.part.a implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View itemAttire;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View itemSmallHome;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isBgDrawableValid;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String nickname;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CardView cardView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView nicknameTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View profileCard;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View itemAvatar;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/bizParts/QQSettingMeZPlanMenuPart$a;", "", "", "TAG", "Ljava/lang/String;", "ZPLAN_AVATAR_EDIT_SCHEME", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.bizParts.QQSettingMeZPlanMenuPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26353);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeZPlanMenuPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isBgDrawableValid = true;
        }
    }

    private final void H9() {
        List<View> listOf;
        Drawable e16 = DrawerUtils.f306948a.e();
        if (!this.isBgDrawableValid) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.itemAvatar, this.itemAttire, this.itemSmallHome});
            for (View view : listOf) {
                if (view != null) {
                    view.setBackground(e16);
                }
            }
        }
    }

    private final void I9() {
        List<View> listOf;
        VideoReport.setElementId(this.profileCard, "em_zplan_manage_profile");
        VideoReport.setElementId(this.itemAvatar, "em_zplan_manage_head");
        VideoReport.setElementId(this.itemAttire, ZootopiaSource.SUB_SOURCE_DRAWER_ZPLAN_MANAGE_PORTAL);
        VideoReport.setElementId(this.itemSmallHome, "em_zplan_manage_xiaowo");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.profileCard, this.itemAvatar, this.itemAttire, this.itemSmallHome});
        for (View view : listOf) {
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        }
    }

    private final void J9() {
        TextView textView;
        List<TextView> listOf;
        ColorStateList b16 = ex.b(R.color.qui_common_text_primary);
        TextView[] textViewArr = new TextView[3];
        textViewArr[0] = this.nicknameTv;
        View findViewById = getPartRootView().findViewById(R.id.f10663699);
        TextView textView2 = null;
        if (findViewById instanceof TextView) {
            textView = (TextView) findViewById;
        } else {
            textView = null;
        }
        textViewArr[1] = textView;
        View findViewById2 = getPartRootView().findViewById(R.id.f10662698);
        if (findViewById2 instanceof TextView) {
            textView2 = (TextView) findViewById2;
        }
        textViewArr[2] = textView2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) textViewArr);
        for (TextView textView3 : listOf) {
            if (textView3 != null) {
                textView3.setTextColor(b16);
            }
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(String nickname) {
        TextView textView = this.nicknameTv;
        if (textView != null) {
            textView.setText(nickname);
        }
        this.nickname = nickname;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        CardView cardView;
        List<View> listOf;
        View findViewById = getPartRootView().findViewById(R.id.arb);
        Drawable drawable = null;
        if (findViewById instanceof CardView) {
            cardView = (CardView) findViewById;
        } else {
            cardView = null;
        }
        this.cardView = cardView;
        if (cardView != null) {
            cardView.setRadius(ViewUtils.dpToPx(8.0f));
            cardView.setCardBackgroundColor(0);
            cardView.setCardElevation(0.0f);
        }
        this.nicknameTv = (TextView) getPartRootView().findViewById(R.id.f126667pd);
        this.profileCard = getPartRootView().findViewById(R.id.f126657pc);
        this.itemAvatar = getPartRootView().findViewById(R.id.f126647pb);
        this.itemAttire = getPartRootView().findViewById(R.id.f126637pa);
        J9();
        TextView textView = this.nicknameTv;
        if (textView != null) {
            textView.setText(this.nickname);
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.profileCard, this.itemAvatar, this.itemAttire, this.itemSmallHome});
        for (View view : listOf) {
            if (view != null) {
                view.setOnClickListener(this);
            }
        }
        DrawerUtils drawerUtils = DrawerUtils.f306948a;
        View view2 = this.itemAvatar;
        if (view2 != null) {
            drawable = view2.getBackground();
        }
        this.isBgDrawableValid = drawerUtils.a(drawable);
        H9();
        I9();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else if (!FastClickUtils.isFastDoubleClick("QQSettingMeZPlanMenuPart")) {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f126657pc) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                AllInOne allInOne = new AllInOne(peekAppRuntime.getCurrentAccountUin(), 0);
                allInOne.lastActivity = 1;
                allInOne.profileEntryType = 8;
                ProfileUtils.openProfileCardForResult(getActivity(), allInOne, 1009);
                IProfileCardApi iProfileCardApi = (IProfileCardApi) QRoute.api(IProfileCardApi.class);
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                iProfileCardApi.checkToCleanSettingMeRedPointGuide((AppInterface) peekAppRuntime);
            } else if (num != null && num.intValue() == R.id.f126647pb) {
                IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                iZPlanApi.launchScheme(context, "mqqapi://zplan/openPage?src_type=app&version=1.0&referer=15&pageID=13&pageData=%7B%22backupUrl%22%3A%20%22https%3A%2F%2Fmweb.superqqshow.qq.com%2Fpages%2F20fe9bc4-qqshow%2Findex.html%3F_cwv%3D1%26_wv%3D1360078691%26_wwv%3D8192%22%7D&newTask=1");
            } else if (num != null && num.intValue() == R.id.f126637pa) {
                IZootopiaApi iZootopiaApi = (IZootopiaApi) QRoute.api(IZootopiaApi.class);
                Context context2 = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "v.context");
                iZootopiaApi.startPortalActivity(context2, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.DRAWER, ZootopiaSource.SUB_SOURCE_DRAWER_ZPLAN_MANAGE_PORTAL, null, 4, null), null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<String> mutableLiveData = qQSettingMeViewModel.L;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanMenuPart$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanMenuPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeZPlanMenuPart.this.N9(str);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str);
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.bizParts.bu
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanMenuPart.K9(Function1.this, obj);
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.h> mutableLiveData2 = qQSettingMeViewModel.M;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit> function12 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.h, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanMenuPart$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanMenuPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.h hVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeZPlanMenuPart.this.N9(hVar.f184909a);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) hVar);
                }
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.bizParts.bv
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanMenuPart.L9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> mutableLiveData3 = qQSettingMeViewModel.f312694c0;
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.bizParts.QQSettingMeZPlanMenuPart$onPartCreate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeZPlanMenuPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeZPlanMenuPart.this.initView();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                }
            }
        };
        mutableLiveData3.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.bizParts.bw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanMenuPart.M9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onPostThemeChanged();
            H9();
        }
    }
}
