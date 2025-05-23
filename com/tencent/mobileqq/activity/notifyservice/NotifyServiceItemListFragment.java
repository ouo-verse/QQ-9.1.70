package com.tencent.mobileqq.activity.notifyservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.TempChatServiceAssistantSession;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002CDB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0007J&\u0010\u0011\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00105\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010/R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "ph", "", "initView", "rh", "initViewModel", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "sh", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getContentLayoutId", "v", NodeProps.ON_CLICK, "qh", "Lqw3/a;", BdhLogUtil.LogTag.Tag_Conn, "Lqw3/a;", "mBinding", "Lcom/tencent/qqnt/chats/biz/notifyservice/d;", "D", "Lcom/tencent/qqnt/chats/biz/notifyservice/d;", "mChatsVB", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "E", "Lcom/tencent/qqnt/chats/core/mvi/a;", "mChatsVM", "", UserInfo.SEX_FEMALE, "Ljava/lang/Long;", "mUin", "", "G", "Ljava/lang/String;", "mUid", "H", "mUinName", "I", "Ljava/lang/Integer;", "mUinType", "J", "mAddFriendSourceId", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "K", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "mNavBarCommon", "Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListFragment$b;", "L", "Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListFragment$b;", "mItemAttachChangeListenerImpl", "<init>", "()V", "M", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class NotifyServiceItemListFragment extends QIphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private qw3.a mBinding;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.qqnt.chats.biz.notifyservice.d mChatsVB;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Long mUin;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mUid;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String mUinName;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Integer mUinType;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String mAddFriendSourceId;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private NavBarCommon mNavBarCommon;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private b mItemAttachChangeListenerImpl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListFragment$a;", "", "", "DIFFER", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.notifyservice.NotifyServiceItemListFragment$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onChildViewAttachedToWindow", "onChildViewDetachedFromWindow", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListFragment;", "d", "Lmqq/util/WeakReference;", "mFragmentWeak", "fragment", "<init>", "(Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListFragment;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    private static final class b implements RecyclerView.OnChildAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WeakReference<NotifyServiceItemListFragment> mFragmentWeak;

        public b(@NotNull NotifyServiceItemListFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragment);
            } else {
                this.mFragmentWeak = new WeakReference<>(fragment);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NotNull View view) {
            NotifyServiceItemListFragment notifyServiceItemListFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            WeakReference<NotifyServiceItemListFragment> weakReference = this.mFragmentWeak;
            if (weakReference != null && (notifyServiceItemListFragment = weakReference.get()) != null) {
                notifyServiceItemListFragment.sh(view);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NotifyServiceItemListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void initView() {
        NavBarCommon navBarCommon;
        String str;
        View view;
        Intent intent;
        View view2 = ((QIphoneTitleBarFragment) this).mContentView;
        String str2 = null;
        if (view2 != null) {
            navBarCommon = (NavBarCommon) view2.findViewById(R.id.rlCommenTitle);
        } else {
            navBarCommon = null;
        }
        this.mNavBarCommon = navBarCommon;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("uinname");
        } else {
            str = null;
        }
        setTitle(str);
        NavBarCommon navBarCommon2 = this.mNavBarCommon;
        if (navBarCommon2 == null) {
            this.rightViewImg.setVisibility(0);
            this.rightViewImg.setImageResource(R.drawable.qui_setting_icon_nav_secondary_selector);
            this.rightViewImg.setOnClickListener(this);
            ImageView imageView = this.rightViewImg;
            if (imageView != null) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    str2 = activity2.getString(R.string.f171622o9);
                }
                imageView.setContentDescription(str2);
                return;
            }
            return;
        }
        if (navBarCommon2 != null) {
            navBarCommon2.setRightImage(getResources().getDrawable(R.drawable.qui_setting_icon_nav_secondary_selector));
        }
        NavBarCommon navBarCommon3 = this.mNavBarCommon;
        if (navBarCommon3 != null) {
            view = navBarCommon3.findViewById(R.id.dsr);
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(0);
        }
        if (view != null) {
            view.setOnClickListener(this);
        }
        if (view != null) {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                str2 = activity3.getString(R.string.f171622o9);
            }
            view.setContentDescription(str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b A[Catch: all -> 0x006e, TRY_LEAVE, TryCatch #0 {all -> 0x006e, blocks: (B:20:0x003d, B:24:0x0054, B:26:0x0060, B:27:0x0066, B:30:0x006b), top: B:19:0x003d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final com.tencent.qqnt.chats.core.adapter.itemdata.g ph(View view) {
        Integer num;
        Object obj;
        qw3.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        RecyclerView.LayoutManager layoutManager = aVar.f430254b.getLayoutManager();
        if (layoutManager != null) {
            num = Integer.valueOf(layoutManager.getPosition(view));
        } else {
            num = null;
        }
        if (num != null && num.intValue() == -1) {
            return null;
        }
        qw3.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar2 = null;
        }
        RecyclerView.Adapter adapter = aVar2.f430254b.getAdapter();
        if (!(adapter instanceof ListAdapter)) {
            return null;
        }
        try {
            Field declaredField = ListAdapter.class.getDeclaredField("mDiffer");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(adapter);
            if (!(obj2 instanceof AsyncListDiffer)) {
                return null;
            }
            if (num != null) {
                int intValue = num.intValue();
                List currentList = ((AsyncListDiffer) obj2).getCurrentList();
                if (currentList != null) {
                    obj = currentList.get(intValue);
                    if (obj instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
                        return null;
                    }
                    return (com.tencent.qqnt.chats.core.adapter.itemdata.g) obj;
                }
            }
            obj = null;
            if (obj instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            }
        } catch (Throwable th5) {
            QLog.e("IphoneTitleBarFragment", 1, "[getViewForData] ex: ", th5);
            return null;
        }
    }

    private final void rh() {
        Long l3;
        String str;
        String str2;
        Integer num;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        FragmentActivity activity = getActivity();
        String str3 = null;
        if (activity != null && (intent5 = activity.getIntent()) != null) {
            l3 = Long.valueOf(intent5.getLongExtra("uin", 0L));
        } else {
            l3 = null;
        }
        this.mUin = l3;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent4 = activity2.getIntent()) != null) {
            str = intent4.getStringExtra(AppConstants.Key.UID);
        } else {
            str = null;
        }
        this.mUid = str;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent3 = activity3.getIntent()) != null) {
            str2 = intent3.getStringExtra("uinname");
        } else {
            str2 = null;
        }
        this.mUinName = str2;
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (intent2 = activity4.getIntent()) != null) {
            num = Integer.valueOf(intent2.getIntExtra("uintype", 0));
        } else {
            num = null;
        }
        this.mUinType = num;
        FragmentActivity activity5 = getActivity();
        if (activity5 != null && (intent = activity5.getIntent()) != null) {
            str3 = intent.getStringExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID);
        }
        this.mAddFriendSourceId = str3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout frameLayout;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        String str = null;
        if (view != null) {
            frameLayout = (FrameLayout) view.findViewById(R.id.f166437zv0);
        } else {
            frameLayout = null;
        }
        qw3.a g16 = qw3.a.g(getLayoutInflater(), frameLayout, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, contentView, true)");
        this.mBinding = g16;
        rh();
        initView();
        initViewModel();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        } else {
            aVar = aVar2;
        }
        this.mChatsVB = new com.tencent.qqnt.chats.biz.notifyservice.d(aVar, new com.tencent.qqnt.chats.biz.notifyservice.e(), null, 4, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            qw3.a aVar3 = this.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar3 = null;
            }
            SkinnableRecycleView skinnableRecycleView = aVar3.f430254b;
            Intrinsics.checkNotNullExpressionValue(skinnableRecycleView, "mBinding.chatsList");
            qw3.a aVar4 = this.mBinding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar4 = null;
            }
            QUIBadgeDragLayout qUIBadgeDragLayout = aVar4.f430255c;
            Intrinsics.checkNotNullExpressionValue(qUIBadgeDragLayout, "mBinding.dragArea");
            ChatsListVB.b bVar = new ChatsListVB.b(skinnableRecycleView, qUIBadgeDragLayout, null, activity, null, null, null, null, 240, null);
            com.tencent.qqnt.chats.biz.notifyservice.d dVar = this.mChatsVB;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
                dVar = null;
            }
            dVar.d0(bVar);
        }
        this.mItemAttachChangeListenerImpl = new b(this);
        qw3.a aVar5 = this.mBinding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar5 = null;
        }
        SkinnableRecycleView skinnableRecycleView2 = aVar5.f430254b;
        b bVar2 = this.mItemAttachChangeListenerImpl;
        Intrinsics.checkNotNull(bVar2);
        skinnableRecycleView2.addOnChildAttachStateChangeListener(bVar2);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar6 = this.mChatsVM;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar6 = null;
        }
        com.tencent.qqnt.chats.biz.notifyservice.d dVar2 = this.mChatsVB;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            dVar2 = null;
        }
        aVar6.d(dVar2);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar7 = this.mChatsVM;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar7 = null;
        }
        aVar7.o(b.c.f355083a);
        TextView textView = this.leftView;
        if (textView != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                str = activity2.getString(R.string.f170549u3);
            }
            textView.setContentDescription(str);
        }
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, c.b());
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_node_list");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return R.layout.fpc;
    }

    public final void initViewModel() {
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            QRouteApi api = QRoute.api(IChatsViewModelCreator.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IChatsViewModelCreator::class.java)");
            aVar = (com.tencent.qqnt.chats.core.mvi.a) IChatsViewModelCreator.a.a((IChatsViewModelCreator) api, LifecycleOwnerKt.getLifecycleScope(this), activity, null, null, 8, null);
        } else {
            aVar = null;
        }
        Intrinsics.checkNotNull(aVar);
        this.mChatsVM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        View view;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            NavBarCommon navBarCommon = this.mNavBarCommon;
            if (navBarCommon != null) {
                view = navBarCommon.findViewById(R.id.dsr);
            } else {
                view = null;
            }
            if (Intrinsics.areEqual(v3, this.rightViewImg) || Intrinsics.areEqual(v3, view)) {
                qh();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.biz.notifyservice.d dVar = this.mChatsVB;
        qw3.a aVar = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            dVar = null;
        }
        dVar.e0();
        super.onDestroy();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar2 = null;
        }
        aVar2.o(b.d.f355084a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar3 = null;
        }
        com.tencent.qqnt.chats.biz.notifyservice.d dVar2 = this.mChatsVB;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            dVar2 = null;
        }
        aVar3.m(dVar2);
        if (this.mItemAttachChangeListenerImpl != null) {
            qw3.a aVar4 = this.mBinding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar = aVar4;
            }
            SkinnableRecycleView skinnableRecycleView = aVar.f430254b;
            b bVar = this.mItemAttachChangeListenerImpl;
            Intrinsics.checkNotNull(bVar);
            skinnableRecycleView.removeOnChildAttachStateChangeListener(bVar);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPause();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.h.f355088a);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.i.f355089a);
    }

    public void qh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.d("IphoneTitleBarFragment", 1, "[handlerRightIconClick] mUin:" + this.mUin + " | mUid:" + this.mUid + " | mUinName:" + this.mUinName + " | mUinType:" + this.mUinType + " | mAddFriendSourceId:" + this.mAddFriendSourceId);
        Intent intent = new Intent();
        intent.putExtra("uin", this.mUin);
        intent.putExtra("KEY_UID", this.mUid);
        intent.putExtra("uinname", this.mUinName);
        intent.putExtra("uintype", this.mUinType);
        intent.putExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID, this.mUinName);
        QPublicFragmentActivity.start(getActivity(), intent, NotifyServiceItemListSettingFragment.class);
    }

    public final void sh(@NotNull View view) {
        Object obj;
        RecentContactExtAttr recentContactExtAttr;
        TempChatServiceAssistantSession tempChatServiceAssistantSession;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.qqnt.chats.core.adapter.itemdata.g ph5 = ph(view);
        if (ph5 != null && ph5.p() != null) {
            ArrayList<RecentContactExtAttr> p16 = ph5.p();
            Intrinsics.checkNotNull(p16);
            if (!p16.isEmpty()) {
                ArrayList<RecentContactExtAttr> p17 = ph5.p();
                if (p17 != null && (recentContactExtAttr = p17.get(0)) != null && (tempChatServiceAssistantSession = recentContactExtAttr.serviceAssistantSession) != null) {
                    obj = Integer.valueOf(tempChatServiceAssistantSession.appType);
                } else {
                    obj = "";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("business_type", String.valueOf(obj));
                VideoReport.setElementParams(view, hashMap);
                VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
                VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
                VideoReport.setElementId(view, "em_bas_node_message_entry");
            }
        }
    }
}
