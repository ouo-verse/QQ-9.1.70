package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.AddContactItemDeleteEvent;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.AddContactReportHelper;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactViewModelV2;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.gridpage.QQGridContainerView;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.RoundRelativeLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.RandomKt;
import mqq.app.Constants;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 b2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J$\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016J\u0012\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'`(H\u0016R\u0016\u0010,\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010G\u001a\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010G\u001a\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactFragmentV2;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/f;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initData", "initView", "Fh", "initTitleBar", "Hh", "Eh", "Ch", "Dh", "Landroid/view/View;", "view", "Bh", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/b;", "uiState", "Kh", "xh", "Jh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "qOnBackPressed", "qOnNewIntent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/widget/RoundRelativeLayout;", "D", "Lcom/tencent/widget/RoundRelativeLayout;", "searchBoxContainer", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "searchBox", "Lcom/tencent/mobileqq/widget/gridpage/QQGridContainerView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/gridpage/QQGridContainerView;", "gridContainer", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "emptyContainer", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/i;", "I", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/i;", "stateDelegate", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactViewModelV2;", "J", "Lkotlin/Lazy;", "Ah", "()Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactViewModelV2;", "viewModel", "Lcom/tencent/mobileqq/app/QQAppInterface;", "K", "yh", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "L", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "service", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/b;", "M", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/b;", "adapter", "Lcom/tencent/mobileqq/activity/contact/addcontact/e;", "N", "Lcom/tencent/mobileqq/activity/contact/addcontact/e;", "locationDelegate", "P", "Z", "hasTechReported", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactFragmentV2 extends QPublicBaseFragment implements com.tencent.mobileqq.pad.f, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private RoundRelativeLayout searchBoxContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView searchBox;

    /* renamed from: F, reason: from kotlin metadata */
    private QQGridContainerView gridContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout emptyContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private i stateDelegate;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy app;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy service;

    /* renamed from: M, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.b adapter;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.activity.contact.addcontact.e locationDelegate;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean hasTechReported;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactFragmentV2$a;", "", "", "LAUNCHER_TIME", "Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactFragmentV2$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactFragmentV2$b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/DislikeRecommendItemListener;", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements Function2<String, AddContactDataType, Unit> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactFragmentV2.this);
            }
        }

        public void a(@NotNull String id5, @NotNull AddContactDataType type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5, (Object) type);
                return;
            }
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            if (AppNetConnInfo.isNetSupport()) {
                AddContactViewModelV2.P1(AddContactFragmentV2.this.Ah(), id5, type, false, 4, null);
            } else {
                QQToast.makeText(AddContactFragmentV2.this.requireContext(), 1, AddContactFragmentV2.this.getString(R.string.f171140iv0), 0).show();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String str, AddContactDataType addContactDataType) {
            a(str, addContactDataType);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002!\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactFragmentV2$c", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "Lkotlin/ParameterName;", "name", "type", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/MoreViewItemListener;", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements Function1<AddContactDataType, Unit> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactFragmentV2.this);
            }
        }

        public void a(@NotNull AddContactDataType type) {
            List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.g> c16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
                return;
            }
            Intrinsics.checkNotNullParameter(type, "type");
            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.b value = AddContactFragmentV2.this.Ah().X1().getValue();
            if (value != null && (c16 = value.c()) != null) {
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.a.f180891a.a(c16);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AddContactDataType addContactDataType) {
            a(addContactDataType);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactFragmentV2$d", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactFragmentV2.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(@Nullable View v3, int item) {
            FragmentActivity activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3, item);
            } else if (item == 1 && (activity = AddContactFragmentV2.this.getActivity()) != null) {
                activity.onBackPressed();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49870);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddContactFragmentV2() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactFragmentV2$special$$inlined$viewModels$default$1
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Fragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? Fragment.this : (Fragment) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AddContactViewModelV2.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactFragmentV2$special$$inlined$viewModels$default$2
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Function0.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ViewModelStore) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        lazy = LazyKt__LazyJVMKt.lazy(AddContactFragmentV2$app$2.INSTANCE);
        this.app = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGProGlobalService>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactFragmentV2$service$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactFragmentV2.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGProGlobalService invoke() {
                QQAppInterface yh5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (IGProGlobalService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                yh5 = AddContactFragmentV2.this.yh();
                return (IGProGlobalService) yh5.getRuntimeService(IGProGlobalService.class, "");
            }
        });
        this.service = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddContactViewModelV2 Ah() {
        return (AddContactViewModelV2) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(View view) {
        int id5 = view.getId();
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.e("AddContactFragmentV2", 1, "invalid params while click. activity is null. viewId: " + id5);
            return;
        }
        boolean z16 = false;
        switch (id5) {
            case 1001:
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.b(qBaseActivity, yh());
                return;
            case 1002:
                QQAppInterface yh5 = yh();
                com.tencent.mobileqq.activity.contact.addcontact.e eVar = this.locationDelegate;
                if (eVar != null) {
                    z16 = eVar.l();
                }
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.d(qBaseActivity, yh5, z16);
                return;
            case 1003:
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.h(qBaseActivity, yh());
                return;
            case 1004:
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.e(qBaseActivity, yh(), 0);
                return;
            case 1005:
            case 1009:
            default:
                QLog.e("AddContactFragmentV2", 1, "click not match. invalid view id: " + id5);
                return;
            case 1006:
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.i(qBaseActivity, yh());
                return;
            case 1007:
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.g(qBaseActivity, yh(), view);
                return;
            case 1008:
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.f(qBaseActivity, yh());
                return;
            case 1010:
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.k(qBaseActivity);
                return;
            case 1011:
                com.tencent.mobileqq.activity.contact.addcontact.gridentrance.b.j(qBaseActivity);
                return;
        }
    }

    private final void Ch() {
        View view = this.rootView;
        RecyclerView recyclerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content)");
        this.recyclerView = (RecyclerView) findViewById;
        QQAppInterface yh5 = yh();
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar = new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a(yh5, recyclerView2);
        Manager manager = yh().getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.MayknowRecommendManager");
        this.adapter = new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.b(aVar, (MayknowRecommendManager) manager, yh().getCurrentUin() + "-" + System.currentTimeMillis() + "-" + RandomKt.Random(10000).nextInt(), new b(), new c());
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.b bVar = this.adapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            bVar = null;
        }
        recyclerView3.setAdapter(bVar);
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView5;
        }
        recyclerView4.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    private final void Dh() {
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.bwi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.empty_layout)");
        this.emptyContainer = (LinearLayout) findViewById;
    }

    private final void Eh() {
        View view = this.rootView;
        QQGridContainerView qQGridContainerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f165103uw3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.entrance_root_grid)");
        QQGridContainerView qQGridContainerView2 = (QQGridContainerView) findViewById;
        this.gridContainer = qQGridContainerView2;
        if (qQGridContainerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridContainer");
        } else {
            qQGridContainerView = qQGridContainerView2;
        }
        com.tencent.mobileqq.activity.contact.addcontact.gridentrance.c.a(qQGridContainerView, Ah().R1(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactFragmentV2$initGridEntry$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactFragmentV2.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2);
                } else {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    AddContactFragmentV2.this.Bh(view2);
                }
            }
        });
    }

    private final void Fh() {
        LiveData<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.b> X1 = Ah().X1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.b, Unit> function1 = new Function1<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.b, Unit>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactFragmentV2$initObservableData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactFragmentV2.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.b it) {
                i iVar;
                i iVar2;
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.b bVar;
                i iVar3;
                i iVar4;
                i iVar5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                iVar = AddContactFragmentV2.this.stateDelegate;
                i iVar6 = null;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
                    iVar = null;
                }
                iVar.c();
                if (!it.g()) {
                    iVar5 = AddContactFragmentV2.this.stateDelegate;
                    if (iVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
                    } else {
                        iVar6 = iVar5;
                    }
                    iVar6.h();
                } else if (!it.c().isEmpty() || !it.f()) {
                    iVar2 = AddContactFragmentV2.this.stateDelegate;
                    if (iVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
                        iVar2 = null;
                    }
                    iVar2.d();
                    ArrayList arrayList = new ArrayList();
                    for (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.g gVar : it.c()) {
                        if (!gVar.c().isEmpty()) {
                            arrayList.add(new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.b(gVar.d(), gVar.c()));
                        }
                    }
                    bVar = AddContactFragmentV2.this.adapter;
                    if (bVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        bVar = null;
                    }
                    bVar.k0(arrayList);
                    if (arrayList.isEmpty() && it.f()) {
                        iVar3 = AddContactFragmentV2.this.stateDelegate;
                        if (iVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
                        } else {
                            iVar6 = iVar3;
                        }
                        iVar6.f();
                    }
                } else {
                    iVar4 = AddContactFragmentV2.this.stateDelegate;
                    if (iVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
                    } else {
                        iVar6 = iVar4;
                    }
                    iVar6.f();
                }
                AddContactFragmentV2 addContactFragmentV2 = AddContactFragmentV2.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                addContactFragmentV2.Kh(it);
            }
        };
        X1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddContactFragmentV2.Gh(Function1.this, obj);
            }
        });
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new AddContactFragmentV2$initObservableData$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new AddContactFragmentV2$initObservableData$3(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Hh() {
        RoundRelativeLayout roundRelativeLayout;
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f80784ce);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.search_box_container)");
        this.searchBoxContainer = (RoundRelativeLayout) findViewById;
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.search_box);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.search_box)");
        TextView textView = (TextView) findViewById2;
        this.searchBox = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            textView = null;
        }
        textView.setFocusableInTouchMode(false);
        TextView textView2 = this.searchBox;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            textView2 = null;
        }
        textView2.setText(getString(R.string.yk_));
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        Drawable drawable = ResourcesCompat.getDrawable(view3.getContext().getResources(), R.drawable.qui_search, null);
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        int c16 = x.c(view4.getContext(), 16.0f);
        if (drawable != null) {
            drawable.setBounds(0, 0, c16, c16);
        }
        TextView textView3 = this.searchBox;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            textView3 = null;
        }
        textView3.setCompoundDrawables(drawable, null, null, null);
        TextView textView4 = this.searchBox;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBox");
            textView4 = null;
        }
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        textView4.setCompoundDrawablePadding(x.c(view5.getContext(), 4.0f));
        RoundRelativeLayout roundRelativeLayout2 = this.searchBoxContainer;
        if (roundRelativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBoxContainer");
            roundRelativeLayout2 = null;
        }
        roundRelativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                AddContactFragmentV2.Ih(AddContactFragmentV2.this, view6);
            }
        });
        AddContactReportHelper addContactReportHelper = AddContactReportHelper.f180887a;
        RoundRelativeLayout roundRelativeLayout3 = this.searchBoxContainer;
        if (roundRelativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBoxContainer");
            roundRelativeLayout = null;
        } else {
            roundRelativeLayout = roundRelativeLayout3;
        }
        AddContactReportHelper.b(addContactReportHelper, roundRelativeLayout, "em_bas_top_search_bar", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(AddContactFragmentV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Jh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Jh() {
        FragmentActivity activity = getActivity();
        Intent intent = new Intent(activity, (Class<?>) SearchContactsActivity.class);
        intent.putExtra("from_key", 1);
        intent.putExtra(IProfileCardConst.KEY_FROM_TYPE, 13);
        if (activity != null) {
            activity.startActivity(intent);
        }
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        SearchUtils.V0("add_page", "search", "active_frame", 2, 0, "");
        ReportController.o(yh(), "CliOper", "", "", "0X8004BEC", "0X8004BEC", 2, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.b uiState) {
        String str;
        if (this.hasTechReported) {
            return;
        }
        this.hasTechReported = true;
        Bundle arguments = getArguments();
        if (arguments != null) {
            long currentTimeMillis = System.currentTimeMillis() - arguments.getLong("launcher_time");
            if (!uiState.g()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", uiState.d());
                jSONObject.put("errorMsg", uiState.e());
                str = jSONObject.toString();
            } else {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (!uiState.isSuccess) \u2026tring()\n        } else \"\"");
            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.a.f180889a.a(currentTimeMillis, str, uiState.c().size());
        }
    }

    private final void initData() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            QLog.e("AddContactFragmentV2", 1, "initData failed. activity is null");
            return;
        }
        Ah().Z1(qBaseActivity, yh());
        com.tencent.mobileqq.activity.contact.addcontact.e eVar = new com.tencent.mobileqq.activity.contact.addcontact.e(yh(), qBaseActivity);
        eVar.m();
        this.locationDelegate = eVar;
    }

    private final void initTitleBar() {
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        NavBarCommon navBarCommon = (NavBarCommon) view.findViewById(R.id.jo9);
        String string = getString(R.string.yka);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.add_contacts_title_v2)");
        navBarCommon.setTitle(string);
        navBarCommon.setContentDescription(string);
        navBarCommon.setOnItemSelectListener(new d());
    }

    private final void initView() {
        initTitleBar();
        Hh();
        Eh();
        Ch();
        Dh();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        LinearLayout linearLayout = this.emptyContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
            linearLayout = null;
        }
        i iVar = new i(requireContext, linearLayout);
        iVar.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactFragmentV2$initView$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactFragmentV2.this);
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
                    AddContactFragmentV2.this.Ah().Q1();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        this.stateDelegate = iVar;
    }

    private final void xh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setPageId(view, "pg_bas_find_crowd_page");
        VideoReport.setElementExposePolicy(getView(), ExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface yh() {
        return (QQAppInterface) this.app.getValue();
    }

    private final IGProGlobalService zh() {
        return (IGProGlobalService) this.service.getValue();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(AddContactItemDeleteEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.gvc, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026ity_v2, container, false)");
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        i iVar = this.stateDelegate;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
            iVar = null;
        }
        iVar.c();
        yh().removeObserver(Ah().W1());
        zh().deleteObserver(Ah().T1());
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.a.f180891a.b();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPause();
        com.tencent.mobileqq.activity.contact.addcontact.e eVar = this.locationDelegate;
        if (eVar != null) {
            eVar.k();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
        } else if (event instanceof AddContactItemDeleteEvent) {
            AddContactItemDeleteEvent addContactItemDeleteEvent = (AddContactItemDeleteEvent) event;
            Ah().O1(addContactItemDeleteEvent.getId(), addContactItemDeleteEvent.getType(), false);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.mobileqq.activity.contact.addcontact.e eVar = this.locationDelegate;
        if (eVar != null) {
            eVar.o();
        }
        com.tencent.mobileqq.activity.contact.addcontact.e eVar2 = this.locationDelegate;
        if (eVar2 != null) {
            eVar2.i();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
        Fh();
        i iVar = this.stateDelegate;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
            iVar = null;
        }
        iVar.g();
        yh().addObserver(Ah().W1());
        zh().addObserver(Ah().T1());
        SimpleEventBus.getInstance().registerReceiver(this);
        Ah().Q1();
        xh();
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }
}
