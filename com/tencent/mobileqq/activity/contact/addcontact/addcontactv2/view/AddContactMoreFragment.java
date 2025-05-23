package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.AddContactListAdapterV2;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactMoreViewModel;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.AddContactViewModelV2;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.recent.gamemsgbox.NTChatRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
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
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 b2\u00020\u0001:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010I\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010I\u001a\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010I\u001a\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactMoreFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", "view", "", "initView", "initData", "Ph", "Landroid/widget/TextView;", "Jh", "Xh", "", "icon", "msgId", "Vh", "Oh", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel$b$a;", "state", "Wh", "Hh", "Uh", "", "Ih", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "D", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "titleBar", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/CommonRefreshLayout;", "E", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/CommonRefreshLayout;", "refreshLayout", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/NTChatRecyclerViewWithHeaderFooter;", "recycleView", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/ContactRefreshHeader;", "G", "Lcom/tencent/mobileqq/activity/contacts/pullrefresh/ContactRefreshHeader;", "headerView", "H", "Landroid/widget/TextView;", "footView", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/AddContactListAdapterV2;", "I", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/AddContactListAdapterV2;", "adapter", "Landroid/widget/RelativeLayout;", "J", "Landroid/widget/RelativeLayout;", "emptyContainer", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/i;", "K", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/i;", "stateDelegate", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "L", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel;", "M", "Lkotlin/Lazy;", "Nh", "()Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactMoreViewModel;", "viewModel", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactViewModelV2;", "N", "Lh", "()Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/AddContactViewModelV2;", "observerViewModel", "Lcom/tencent/mobileqq/app/QQAppInterface;", "P", "Kh", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Mh", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "service", "", BdhLogUtil.LogTag.Tag_Req, "Z", "hasTechReported", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactMoreFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private NavBarCommon titleBar;

    /* renamed from: E, reason: from kotlin metadata */
    private CommonRefreshLayout refreshLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private NTChatRecyclerViewWithHeaderFooter recycleView;

    /* renamed from: G, reason: from kotlin metadata */
    private ContactRefreshHeader headerView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView footView;

    /* renamed from: I, reason: from kotlin metadata */
    private AddContactListAdapterV2 adapter;

    /* renamed from: J, reason: from kotlin metadata */
    private RelativeLayout emptyContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private i stateDelegate;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private AddContactDataType type;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy observerViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy app;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy service;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean hasTechReported;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactMoreFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "", "title", "", "a", "ADD_CONTACT_MORE_TITLE", "Ljava/lang/String;", "ADD_CONTACT_MORE_TYPE", "", "DELAY_HIDE_HEADER_WHEN_SUCCESS", "J", "LAUNCHER_TIME", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull Context context, @NotNull AddContactDataType type, @NotNull String title) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, type, title);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("add_contact_more_type", Integer.valueOf(type.ordinal())), TuplesKt.to("add_contact_more_title", title), TuplesKt.to("launcher_time", Long.valueOf(System.currentTimeMillis())));
            Intent intent = new Intent();
            intent.putExtras(bundleOf);
            QPublicFragmentActivity.start(context, intent, AddContactMoreFragment.class);
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180903a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.SRERR_VOICE_ENCODE_TYPE);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddContactDataType.GUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddContactDataType.FLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f180903a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactMoreFragment$c", "Lcom/tencent/mobileqq/widget/navbar/a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactMoreFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(@Nullable View v3, int item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, item);
            } else if (item == 1) {
                AddContactMoreFragment.this.requireActivity().finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/AddContactMoreFragment$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactMoreFragment.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, newState);
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0 && AddContactMoreFragment.this.Nh().a2()) {
                View childAt = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                TextView textView = AddContactMoreFragment.this.footView;
                TextView textView2 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("footView");
                    textView = null;
                }
                if (Intrinsics.areEqual(childAt, textView)) {
                    AddContactMoreFragment.this.Nh().g2();
                    TextView textView3 = AddContactMoreFragment.this.footView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("footView");
                    } else {
                        textView2 = textView3;
                    }
                    textView2.setVisibility(0);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            CommonRefreshLayout commonRefreshLayout = AddContactMoreFragment.this.refreshLayout;
            if (commonRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                commonRefreshLayout = null;
            }
            commonRefreshLayout.setRefreshEnabled(!recyclerView.canScrollVertically(-1));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50134);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddContactMoreFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.type = AddContactDataType.f293812GROUP;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactMoreFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                AddContactDataType addContactDataType;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ViewModelProvider.Factory) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                AddContactMoreViewModel.Companion companion = AddContactMoreViewModel.INSTANCE;
                addContactDataType = AddContactMoreFragment.this.type;
                return companion.a(addContactDataType);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$special$$inlined$viewModels$default$1
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AddContactMoreViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$special$$inlined$viewModels$default$2
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
                ViewModelStore mViewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getMViewModelStore();
                Intrinsics.checkNotNullExpressionValue(mViewModelStore, "ownerProducer().viewModelStore");
                return mViewModelStore;
            }
        }, function0);
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$special$$inlined$viewModels$default$3
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
        this.observerViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AddContactViewModelV2.class), new Function0<ViewModelStore>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$special$$inlined$viewModels$default$4
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
                ViewModelStore mViewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getMViewModelStore();
                Intrinsics.checkNotNullExpressionValue(mViewModelStore, "ownerProducer().viewModelStore");
                return mViewModelStore;
            }
        }, null);
        lazy = LazyKt__LazyJVMKt.lazy(AddContactMoreFragment$app$2.INSTANCE);
        this.app = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IGProGlobalService>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$service$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddContactMoreFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IGProGlobalService invoke() {
                QQAppInterface Kh;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (IGProGlobalService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Kh = AddContactMoreFragment.this.Kh();
                return (IGProGlobalService) Kh.getRuntimeService(IGProGlobalService.class, "");
            }
        });
        this.service = lazy2;
    }

    private final void Hh(View view) {
        String str;
        int i3 = b.f180903a[this.type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                } else {
                    str = "pg__bas_search_might_interest_channel_second";
                }
            } else {
                str = "pg__bas_search_might_interest_person_second";
            }
        } else {
            str = "pg__bas_search_might_interest_group_second";
        }
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(view, str);
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        VideoReport.setPageParams(view2, "trace_id", Ih());
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
    }

    private final String Ih() {
        return Kh().getCurrentUin() + "-" + System.currentTimeMillis() + "-" + RandomKt.Random(10000).nextInt();
    }

    private final TextView Jh() {
        TextView textView = new TextView(requireContext());
        textView.setText(HardCodeUtil.qqStr(R.string.swr));
        textView.setGravity(17);
        textView.setTextSize(1, 14.0f);
        int n3 = Utils.n(10.0f, textView.getResources());
        textView.setPadding(n3, n3, n3, n3);
        textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_secondary));
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface Kh() {
        return (QQAppInterface) this.app.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddContactViewModelV2 Lh() {
        return (AddContactViewModelV2) this.observerViewModel.getValue();
    }

    private final IGProGlobalService Mh() {
        return (IGProGlobalService) this.service.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AddContactMoreViewModel Nh() {
        return (AddContactMoreViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh() {
        ContactRefreshHeader contactRefreshHeader = this.headerView;
        CommonRefreshLayout commonRefreshLayout = null;
        if (contactRefreshHeader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            contactRefreshHeader = null;
        }
        contactRefreshHeader.setRefresh(false);
        CommonRefreshLayout commonRefreshLayout2 = this.refreshLayout;
        if (commonRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            commonRefreshLayout = commonRefreshLayout2;
        }
        commonRefreshLayout.setRefreshing(false);
    }

    private final void Ph() {
        LiveData<List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f>> Z1 = Nh().Z1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f>, Unit>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactMoreFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f> it) {
                AddContactListAdapterV2 addContactListAdapterV2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                addContactListAdapterV2 = AddContactMoreFragment.this.adapter;
                if (addContactListAdapterV2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    addContactListAdapterV2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                addContactListAdapterV2.j0(it);
                AddContactMoreFragment.this.Uh();
            }
        };
        Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddContactMoreFragment.Qh(Function1.this, obj);
            }
        });
        LiveData<AddContactMoreViewModel.b> c26 = Nh().c2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final AddContactMoreFragment$initObserver$2 addContactMoreFragment$initObserver$2 = new AddContactMoreFragment$initObserver$2(this);
        c26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddContactMoreFragment.Rh(Function1.this, obj);
            }
        });
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new AddContactMoreFragment$initObserver$3(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new AddContactMoreFragment$initObserver$4(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(AddContactMoreFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (StudyModeManager.t()) {
            this$0.Oh();
        } else if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            AddContactMoreViewModel.f2(this$0.Nh(), false, 1, null);
        } else {
            this$0.Oh();
            this$0.Vh(1, R.string.f171139ci4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Th(AddContactMoreFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.Nh().b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh() {
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setPageParams(view, "trace_id", Ih());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(int icon, int msgId) {
        QQToast.makeText(requireContext(), icon, getResources().getString(msgId), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(AddContactMoreViewModel.b.a state) {
        String str;
        if (this.hasTechReported) {
            return;
        }
        this.hasTechReported = true;
        Bundle arguments = getArguments();
        if (arguments != null) {
            long j3 = arguments.getLong("launcher_time");
            if (!state.d()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errorCode", state.a());
                jSONObject.put("errorMsg", state.b());
                str = jSONObject.toString();
            } else {
                str = "";
            }
            String str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "if (!state.success) {\n  \u2026tring()\n        } else \"\"");
            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.a.f180889a.b(this.type, System.currentTimeMillis() - j3, str2, state.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0016, code lost:
    
        if (r0.isEmpty() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Xh() {
        boolean z16;
        List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f> value = Nh().Z1().getValue();
        if (value != null) {
            z16 = true;
        }
        z16 = false;
        CommonRefreshLayout commonRefreshLayout = null;
        if (z16) {
            i iVar = this.stateDelegate;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
                iVar = null;
            }
            iVar.f();
            CommonRefreshLayout commonRefreshLayout2 = this.refreshLayout;
            if (commonRefreshLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                commonRefreshLayout = commonRefreshLayout2;
            }
            commonRefreshLayout.setVisibility(8);
            return;
        }
        i iVar2 = this.stateDelegate;
        if (iVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
            iVar2 = null;
        }
        iVar2.d();
        CommonRefreshLayout commonRefreshLayout3 = this.refreshLayout;
        if (commonRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            commonRefreshLayout = commonRefreshLayout3;
        }
        commonRefreshLayout.setVisibility(0);
    }

    private final void initData() {
        Integer num;
        String qqStr;
        Bundle arguments = getArguments();
        NavBarCommon navBarCommon = null;
        if (arguments != null) {
            num = Integer.valueOf(arguments.getInt("add_contact_more_type"));
        } else {
            num = null;
        }
        if (num == null) {
            QLog.e("AddContactMoreFragment", 1, "add contact more type is null");
            requireActivity().finish();
            return;
        }
        this.type = AddContactDataType.values()[num.intValue()];
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (qqStr = arguments2.getString("add_contact_more_title")) == null) {
            int i3 = b.f180903a[this.type.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            qqStr = HardCodeUtil.qqStr(R.string.yk8);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.yk7);
                    }
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.yk9);
                }
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.yk6);
            }
        }
        NavBarCommon navBarCommon2 = this.titleBar;
        if (navBarCommon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            navBarCommon = navBarCommon2;
        }
        navBarCommon.setTitle(qqStr);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title_bar)");
        this.titleBar = (NavBarCommon) findViewById;
        View findViewById2 = view.findViewById(R.id.f72333qk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.refresh_layout)");
        this.refreshLayout = (CommonRefreshLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.recycler_view)");
        this.recycleView = (NTChatRecyclerViewWithHeaderFooter) findViewById3;
        View findViewById4 = view.findViewById(R.id.j8x);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.swipe_refresh_header)");
        this.headerView = (ContactRefreshHeader) findViewById4;
        this.footView = Jh();
        View findViewById5 = view.findViewById(R.id.bwb);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.empty_container)");
        this.emptyContainer = (RelativeLayout) findViewById5;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        RelativeLayout relativeLayout = this.emptyContainer;
        TextView textView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyContainer");
            relativeLayout = null;
        }
        i iVar = new i(requireContext, relativeLayout);
        iVar.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$initView$2$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactMoreFragment.this);
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
                    AddContactMoreFragment.this.Nh().e2(false);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        this.stateDelegate = iVar;
        NavBarCommon navBarCommon = this.titleBar;
        if (navBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            navBarCommon = null;
        }
        navBarCommon.setOnItemSelectListener(new c());
        CommonRefreshLayout commonRefreshLayout = this.refreshLayout;
        if (commonRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            commonRefreshLayout = null;
        }
        commonRefreshLayout.setRefreshCompleteDelayDuration(0);
        CommonRefreshLayout commonRefreshLayout2 = this.refreshLayout;
        if (commonRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            commonRefreshLayout2 = null;
        }
        commonRefreshLayout2.setOnRefreshListener(new com.tencent.mobileqq.activity.contacts.pullrefresh.a() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.c
            @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.a
            public final void onRefresh() {
                AddContactMoreFragment.Sh(AddContactMoreFragment.this);
            }
        });
        ContactRefreshHeader contactRefreshHeader = this.headerView;
        if (contactRefreshHeader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headerView");
            contactRefreshHeader = null;
        }
        contactRefreshHeader.setRefreshHeaderUpdateListener(new ContactRefreshHeader.b() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.d
            @Override // com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader.b
            public final long a() {
                long Th;
                Th = AddContactMoreFragment.Th(AddContactMoreFragment.this);
                return Th;
            }
        });
        NTChatRecyclerViewWithHeaderFooter nTChatRecyclerViewWithHeaderFooter = this.recycleView;
        if (nTChatRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            nTChatRecyclerViewWithHeaderFooter = null;
        }
        TextView textView2 = this.footView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footView");
            textView2 = null;
        }
        nTChatRecyclerViewWithHeaderFooter.C(textView2);
        QQAppInterface Kh = Kh();
        NTChatRecyclerViewWithHeaderFooter nTChatRecyclerViewWithHeaderFooter2 = this.recycleView;
        if (nTChatRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            nTChatRecyclerViewWithHeaderFooter2 = null;
        }
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar = new com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a(Kh, nTChatRecyclerViewWithHeaderFooter2);
        Manager manager = Kh().getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.MayknowRecommendManager");
        this.adapter = new AddContactListAdapterV2(aVar, (MayknowRecommendManager) manager, new Function2<String, AddContactDataType, Unit>() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment$initView$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddContactMoreFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, AddContactDataType addContactDataType) {
                invoke2(str, addContactDataType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String id5, @NotNull AddContactDataType type) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5, (Object) type);
                    return;
                }
                Intrinsics.checkNotNullParameter(id5, "id");
                Intrinsics.checkNotNullParameter(type, "type");
                if (AppNetConnInfo.isNetSupport()) {
                    AddContactMoreFragment.this.Nh().U1(id5, type);
                } else {
                    QQToast.makeText(AddContactMoreFragment.this.requireContext(), 1, AddContactMoreFragment.this.getString(R.string.f171140iv0), 0).show();
                }
            }
        });
        NTChatRecyclerViewWithHeaderFooter nTChatRecyclerViewWithHeaderFooter3 = this.recycleView;
        if (nTChatRecyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            nTChatRecyclerViewWithHeaderFooter3 = null;
        }
        AddContactListAdapterV2 addContactListAdapterV2 = this.adapter;
        if (addContactListAdapterV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            addContactListAdapterV2 = null;
        }
        nTChatRecyclerViewWithHeaderFooter3.setAdapter(addContactListAdapterV2);
        NTChatRecyclerViewWithHeaderFooter nTChatRecyclerViewWithHeaderFooter4 = this.recycleView;
        if (nTChatRecyclerViewWithHeaderFooter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            nTChatRecyclerViewWithHeaderFooter4 = null;
        }
        nTChatRecyclerViewWithHeaderFooter4.setLayoutManager(new LinearLayoutManager(requireContext()));
        NTChatRecyclerViewWithHeaderFooter nTChatRecyclerViewWithHeaderFooter5 = this.recycleView;
        if (nTChatRecyclerViewWithHeaderFooter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            nTChatRecyclerViewWithHeaderFooter5 = null;
        }
        nTChatRecyclerViewWithHeaderFooter5.addOnScrollListener(new d());
        TextView textView3 = this.footView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("footView");
        } else {
            textView = textView3;
        }
        textView.setVisibility(4);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Kh().addObserver(Lh().W1());
        Mh().addObserver(Lh().T1());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            view = inflater.inflate(R.layout.gvg, container, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            this.rootView = view;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        Kh().removeObserver(Lh().W1());
        Mh().deleteObserver(Lh().T1());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        initView(view);
        initData();
        Ph();
        i iVar = this.stateDelegate;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateDelegate");
            iVar = null;
        }
        iVar.g();
        Nh().e2(false);
        Hh(view);
    }
}
