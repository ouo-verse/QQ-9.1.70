package com.tencent.mobileqq.troop.troopcreate.classify;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.troopcreate.classify.TroopCreateClassifyDetailFragment$createEventReceiver$2;
import com.tencent.mobileqq.troop.troopcreate.classify.detail.TroopClassifyContainerView;
import com.tencent.mobileqq.troop.troopcreate.classify.detail.TroopClassifyNewContainerView;
import com.tencent.mobileqq.troop.troopcreate.classify.detail.g;
import com.tencent.mobileqq.troop.troopcreate.event.TroopChangeClassEvent;
import com.tencent.mobileqq.troop.utils.ay;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\n*\u00019\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00103\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/TroopCreateClassifyDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/f;", "", "initViews", "initTitleBar", "uh", "th", "vh", "", "showContentTitle", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "qOnBackPressed", "qOnNewIntent", "needImmersive", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "D", "Z", "showNavTitle", "E", "showNewPage", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navTitleBar", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyContainerView;", "G", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyContainerView;", "troopContainerView", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyNewContainerView;", "H", "Lcom/tencent/mobileqq/troop/troopcreate/classify/detail/TroopClassifyNewContainerView;", "troopNewContainerView", "I", "Lkotlin/Lazy;", "xh", "()Z", "isFromSettingPage", "", "J", "rh", "()Ljava/lang/String;", "categoryId", "com/tencent/mobileqq/troop/troopcreate/classify/TroopCreateClassifyDetailFragment$createEventReceiver$2$a", "K", "sh", "()Lcom/tencent/mobileqq/troop/troopcreate/classify/TroopCreateClassifyDetailFragment$createEventReceiver$2$a;", "createEventReceiver", "<init>", "()V", "L", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopCreateClassifyDetailFragment extends QPublicBaseFragment implements com.tencent.mobileqq.pad.f {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean showNavTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean showNewPage;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QUISecNavBar navTitleBar;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TroopClassifyContainerView troopContainerView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TroopClassifyNewContainerView troopNewContainerView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy isFromSettingPage;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy categoryId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy createEventReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/TroopCreateClassifyDetailFragment$a;", "", "", "DIS_SHOW_NAV_TITLE_BETWEEN_NAV_AND_CONTAINER", UserInfo.SEX_FEMALE, "", "HEADER_BG_URL", "Ljava/lang/String;", "TAG", "TITLE_TEXT", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.classify.TroopCreateClassifyDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57475);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopCreateClassifyDetailFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.showNewPage = ((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).getExperimentResultAndReport();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.TroopCreateClassifyDetailFragment$isFromSettingPage$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopCreateClassifyDetailFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Bundle arguments = TroopCreateClassifyDetailFragment.this.getArguments();
                return Boolean.valueOf(arguments != null ? arguments.getBoolean("fromSetting") : false);
            }
        });
        this.isFromSettingPage = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.TroopCreateClassifyDetailFragment$categoryId$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopCreateClassifyDetailFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String string;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Bundle arguments = TroopCreateClassifyDetailFragment.this.getArguments();
                return (arguments == null || (string = arguments.getString("categoryId")) == null) ? "" : string;
            }
        });
        this.categoryId = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TroopCreateClassifyDetailFragment$createEventReceiver$2.a>() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.TroopCreateClassifyDetailFragment$createEventReceiver$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopcreate/classify/TroopCreateClassifyDetailFragment$createEventReceiver$2$a", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopcreate/event/TroopChangeClassEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes19.dex */
            public static final class a implements SimpleEventReceiver<TroopChangeClassEvent> {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TroopCreateClassifyDetailFragment f300031d;

                a(TroopCreateClassifyDetailFragment troopCreateClassifyDetailFragment) {
                    this.f300031d = troopCreateClassifyDetailFragment;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopCreateClassifyDetailFragment);
                    }
                }

                @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                @NotNull
                public ArrayList<Class<TroopChangeClassEvent>> getEventClass() {
                    ArrayList<Class<TroopChangeClassEvent>> arrayListOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopChangeClassEvent.class);
                        return arrayListOf;
                    }
                    return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
                }

                @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
                public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
                    FragmentActivity activity;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                        return;
                    }
                    if ((event instanceof TroopChangeClassEvent) && (activity = this.f300031d.getActivity()) != null) {
                        Intent intent = new Intent();
                        intent.putExtra("id", ((TroopChangeClassEvent) event).getTroopGroupClassExt());
                        activity.setResult(-1, intent);
                        activity.finish();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopCreateClassifyDetailFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopCreateClassifyDetailFragment.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.createEventReceiver = lazy3;
    }

    private final void initTitleBar() {
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.zmb);
        if (qUISecNavBar != null) {
            qUISecNavBar.S(this);
            qUISecNavBar.setAutoAdaptTransparent(true);
            qUISecNavBar.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
            qUISecNavBar.setTitleAlpha(0.0f);
            qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.TroopCreateClassifyDetailFragment$initTitleBar$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopCreateClassifyDetailFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view3, BaseAction baseAction) {
                    invoke2(view3, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View view3, @NotNull BaseAction action) {
                    FragmentActivity activity;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view3, (Object) action);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(view3, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (action != BaseAction.ACTION_LEFT_BUTTON || (activity = TroopCreateClassifyDetailFragment.this.getActivity()) == null) {
                        return;
                    }
                    activity.onBackPressed();
                }
            });
        } else {
            qUISecNavBar = null;
        }
        this.navTitleBar = qUISecNavBar;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        QUISecNavBar qUISecNavBar2 = (QUISecNavBar) view2.findViewById(R.id.zmc);
        qUISecNavBar2.S(this);
        qUISecNavBar2.setLeftImageResInTransParent(R.drawable.qui_chevron_left);
        qUISecNavBar2.setTitleAlpha(0.0f);
        qUISecNavBar2.setVisibility(4);
    }

    private final void initViews() {
        initTitleBar();
        uh();
        th();
        vh();
    }

    private final void qh(boolean showContentTitle) {
        if (this.showNavTitle == showContentTitle) {
            return;
        }
        if (showContentTitle) {
            QUISecNavBar qUISecNavBar = this.navTitleBar;
            if (qUISecNavBar != null) {
                qUISecNavBar.setTitleAlpha(1.0f);
            }
            QUISecNavBar qUISecNavBar2 = this.navTitleBar;
            if (qUISecNavBar2 != null) {
                qUISecNavBar2.setCenterText("\u9009\u62e9\u5206\u7c7b");
            }
        } else {
            QUISecNavBar qUISecNavBar3 = this.navTitleBar;
            if (qUISecNavBar3 != null) {
                qUISecNavBar3.setTitleAlpha(0.0f);
            }
            QUISecNavBar qUISecNavBar4 = this.navTitleBar;
            if (qUISecNavBar4 != null) {
                qUISecNavBar4.setCenterText("");
            }
        }
        this.showNavTitle = showContentTitle;
    }

    private final String rh() {
        return (String) this.categoryId.getValue();
    }

    private final TroopCreateClassifyDetailFragment$createEventReceiver$2.a sh() {
        return (TroopCreateClassifyDetailFragment$createEventReceiver$2.a) this.createEventReceiver.getValue();
    }

    private final void th() {
        String c16 = g.d("TroopCreateClassifyDetailFragment").c();
        View view = this.rootView;
        TroopClassifyContainerView troopClassifyContainerView = null;
        TroopClassifyNewContainerView troopClassifyNewContainerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        TextView textView = (TextView) view.findViewById(R.id.txc);
        if (textView != null) {
            textView.setText(c16);
        }
        if (this.showNewPage) {
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            TroopClassifyNewContainerView troopClassifyNewContainerView2 = (TroopClassifyNewContainerView) view2.findViewById(R.id.zpn);
            if (troopClassifyNewContainerView2 != null) {
                troopClassifyNewContainerView2.setVisibility(0);
                boolean xh5 = xh();
                String categoryId = rh();
                Intrinsics.checkNotNullExpressionValue(categoryId, "categoryId");
                troopClassifyNewContainerView2.a(xh5, categoryId);
                troopClassifyNewContainerView = troopClassifyNewContainerView2;
            }
            this.troopNewContainerView = troopClassifyNewContainerView;
            return;
        }
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        TroopClassifyContainerView troopClassifyContainerView2 = (TroopClassifyContainerView) view3.findViewById(R.id.tx_);
        if (troopClassifyContainerView2 != null) {
            troopClassifyContainerView2.setVisibility(0);
            troopClassifyContainerView2.d();
            troopClassifyContainerView = troopClassifyContainerView2;
        }
        this.troopContainerView = troopClassifyContainerView;
    }

    private final void uh() {
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.txa);
        if (imageView != null) {
            ay.f302095a.a("https://vfiles.gtimg.cn/wupload/xy/componenthub/go2NH614.png", imageView);
        }
    }

    private final void vh() {
        final int dip2px = ViewUtils.dip2px(16.0f);
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ((ScrollView) view.findViewById(R.id.txb)).setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.c
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view2, int i3, int i16, int i17, int i18) {
                TroopCreateClassifyDetailFragment.wh(TroopCreateClassifyDetailFragment.this, dip2px, view2, i3, i16, i17, i18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(TroopCreateClassifyDetailFragment this$0, int i3, View view, int i16, int i17, int i18, int i19) {
        int i26;
        int i27;
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isDebugVersion()) {
            QUISecNavBar qUISecNavBar = this$0.navTitleBar;
            Integer num2 = null;
            if (qUISecNavBar != null) {
                num = Integer.valueOf(qUISecNavBar.getBottom());
            } else {
                num = null;
            }
            TroopClassifyContainerView troopClassifyContainerView = this$0.troopContainerView;
            if (troopClassifyContainerView != null) {
                num2 = Integer.valueOf(troopClassifyContainerView.getTop());
            }
            QLog.d("TroopCreateClassifyDetailFragment", 4, "[onLayoutChange] scrollY:" + i17 + ", navTitleBar.bottom:" + num + ", container.top:" + num2);
        }
        QUISecNavBar qUISecNavBar2 = this$0.navTitleBar;
        if (qUISecNavBar2 != null) {
            boolean z16 = false;
            if (qUISecNavBar2 != null) {
                i26 = qUISecNavBar2.getBottom();
            } else {
                i26 = 0;
            }
            TroopClassifyContainerView troopClassifyContainerView2 = this$0.troopContainerView;
            if (troopClassifyContainerView2 != null) {
                Intrinsics.checkNotNull(troopClassifyContainerView2);
                i27 = troopClassifyContainerView2.getTop();
            } else {
                TroopClassifyNewContainerView troopClassifyNewContainerView = this$0.troopNewContainerView;
                if (troopClassifyNewContainerView != null) {
                    Intrinsics.checkNotNull(troopClassifyNewContainerView);
                    i27 = troopClassifyNewContainerView.getTop();
                } else {
                    i27 = 0;
                }
            }
            if ((i27 - i17) - i26 <= i3) {
                z16 = true;
            }
            this$0.qh(z16);
        }
    }

    private final boolean xh() {
        return ((Boolean) this.isFromSettingPage.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(sh());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.hyy, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026layout, container, false)");
            this.rootView = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                inflate = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDestroy();
            SimpleEventBus.getInstance().unRegisterReceiver(sh());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViews();
        VideoReport.addToDetectionWhitelist(getActivity());
        View view2 = this.rootView;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        VideoReport.setPageId(view2, "pg_group_classify_create");
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view3 = view4;
        }
        if (this.showNewPage) {
            str = QCircleDaTongConstant.ElementParamValue.NEW;
        } else {
            str = QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD;
        }
        VideoReport.setPageParams(view3, MiniAppPlugin.ATTR_PAGE_TYPE, str);
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }
}
