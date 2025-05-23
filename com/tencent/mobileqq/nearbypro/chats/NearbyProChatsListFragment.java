package com.tencent.mobileqq.nearbypro.chats;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.nearbypro.chats.part.ChatsListPart;
import com.tencent.mobileqq.nearbypro.chats.part.ChatsListPublicAccountNoticePart;
import com.tencent.mobileqq.nearbypro.chats.part.ChatsListTitlePart;
import com.tencent.mobileqq.nearbypro.chats.part.a;
import com.tencent.mobileqq.nearbypro.chats.part.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.chats.core.ui.n;
import com.tencent.qqnt.chats.view.SkinnableRecycleView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xa2.d;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001=\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DB\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\"\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u001405j\b\u0012\u0004\u0012\u00020\u0014`68\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/NearbyProChatsListFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/qqnt/chats/biz/main/part/b;", "", "setStatusBarImmersive", "", "Lcom/tencent/mobileqq/nearbypro/chats/part/a;", "assembleParts", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "onCreate", "view", "ph", "Lcom/tencent/qqnt/chats/core/ui/n;", "handler", com.tencent.bugly.common.constants.Constants.DEBUG_INFO, "", "index", "Cg", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "Landroidx/lifecycle/LifecycleCoroutineScope;", "M9", "Landroidx/lifecycle/ViewModelStoreOwner;", "y", "", "onBackEvent", "Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListPart;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListPart;", "chatListPart", "Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListPublicAccountNoticePart;", "D", "Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListPublicAccountNoticePart;", "publicAccountNoticePart", "E", "Lcom/tencent/mobileqq/nearbypro/chats/part/a;", "titlePart", "Lcom/tencent/mobileqq/nearbypro/chats/part/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/nearbypro/chats/part/g;", "topBannerPart", "Lxa2/d;", "G", "Lxa2/d;", "_binding", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "backPressList", "I", "Ljava/util/List;", "partList", "com/tencent/mobileqq/nearbypro/chats/NearbyProChatsListFragment$b", "J", "Lcom/tencent/mobileqq/nearbypro/chats/NearbyProChatsListFragment$b;", "mJumpToMapBackPressHandler", "<init>", "(Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListPart;)V", "K", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProChatsListFragment extends QPublicBaseFragment implements com.tencent.qqnt.chats.biz.main.part.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ChatsListPart chatListPart;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ChatsListPublicAccountNoticePart publicAccountNoticePart;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final a titlePart;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final g topBannerPart;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private d _binding;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<n> backPressList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final List<a> partList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b mJumpToMapBackPressHandler;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/nearbypro/chats/NearbyProChatsListFragment$b", "Lcom/tencent/qqnt/chats/core/ui/n;", "", "handleBackPress", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements n {
        b() {
        }

        @Override // com.tencent.qqnt.chats.core.ui.n
        public boolean handleBackPress() {
            Intent intent;
            Context context = NearbyProChatsListFragment.this.getContext();
            if (context == null) {
                return false;
            }
            FragmentActivity activity = NearbyProChatsListFragment.this.getActivity();
            if (activity != null) {
                intent = activity.getIntent();
            } else {
                intent = null;
            }
            if (intent != null && intent.getBooleanExtra("exit_chats_list_action_open_main", false)) {
                ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchNearbyMainFragment(context, new Intent());
            }
            return false;
        }
    }

    public NearbyProChatsListFragment() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void setStatusBarImmersive() {
        if (getQBaseActivity() != null && ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
            ImmersiveUtils.setStatusTextColor(true, getQBaseActivity().getWindow());
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    public void Cg(int index, @NotNull n handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.backPressList.add(index, handler);
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    public void G4(@NotNull n handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.backPressList.add(handler);
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    @NotNull
    public LifecycleCoroutineScope M9() {
        return LifecycleOwnerKt.getLifecycleScope(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<a> assembleParts() {
        return this.partList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Iterator<T> it = this.backPressList.iterator();
        while (it.hasNext()) {
            if (((n) it.next()).handleBackPress()) {
                return true;
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        G4(this.mJumpToMapBackPressHandler);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setStatusBarImmersive();
        d g16 = d.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this._binding = g16;
        DragFrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        SkinnableRecycleView skinnableRecycleView = g16.f447577b;
        Intrinsics.checkNotNullExpressionValue(skinnableRecycleView, "binding.chatsList");
        DragFrameLayout dragFrameLayout = g16.f447578c;
        Intrinsics.checkNotNullExpressionValue(dragFrameLayout, "binding.dragArea");
        SmartRefreshLayout smartRefreshLayout = g16.f447583h;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "binding.recyclerScroll");
        FrameLayout frameLayout = g16.f447585j;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.topbarContainer");
        SmartRefreshLayout smartRefreshLayout2 = g16.f447583h;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout2, "binding.recyclerScroll");
        FrameLayout frameLayout2 = g16.f447584i;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.topBanner");
        RelativeLayout relativeLayout = g16.f447582g;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.publicAccountNoticeBar");
        com.tencent.mobileqq.nearbypro.chats.part.b bVar = new com.tencent.mobileqq.nearbypro.chats.part.b(root, skinnableRecycleView, dragFrameLayout, smartRefreshLayout, frameLayout, smartRefreshLayout2, frameLayout2, relativeLayout);
        Iterator<a> it = this.partList.iterator();
        while (it.hasNext()) {
            it.next().D9(bVar);
        }
        DragFrameLayout root2 = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        ph(root2);
        DragFrameLayout root3 = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root3);
        return root3;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setStatusBarImmersive();
    }

    public final void ph(@NotNull View view) {
        Integer num;
        Map<String, ? extends Object> mapOf;
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            num = Integer.valueOf(intent.getIntExtra("open_chats_list_source", 0));
        } else {
            num = null;
        }
        com.tencent.mobileqq.nearbypro.aio.utils.a aVar = com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("nearby_msg_list_source", num));
        aVar.c(view, requireActivity, "pg_nearby_msg_list", mapOf);
    }

    public /* synthetic */ NearbyProChatsListFragment(ChatsListPart chatsListPart, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ChatsListPart() : chatsListPart);
    }

    public NearbyProChatsListFragment(@NotNull ChatsListPart chatListPart) {
        List<a> mutableListOf;
        Intrinsics.checkNotNullParameter(chatListPart, "chatListPart");
        this.chatListPart = chatListPart;
        ChatsListPublicAccountNoticePart chatsListPublicAccountNoticePart = new ChatsListPublicAccountNoticePart();
        this.publicAccountNoticePart = chatsListPublicAccountNoticePart;
        ChatsListTitlePart chatsListTitlePart = new ChatsListTitlePart();
        this.titlePart = chatsListTitlePart;
        g gVar = new g();
        this.topBannerPart = gVar;
        this.backPressList = new ArrayList<>();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(chatsListPublicAccountNoticePart, chatsListTitlePart, gVar, chatListPart);
        Iterator<a> it = mutableListOf.iterator();
        while (it.hasNext()) {
            it.next().C9(this);
        }
        this.partList = mutableListOf;
        this.mJumpToMapBackPressHandler = new b();
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    @NotNull
    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.b
    @NotNull
    public ViewModelStoreOwner y() {
        return this;
    }
}
