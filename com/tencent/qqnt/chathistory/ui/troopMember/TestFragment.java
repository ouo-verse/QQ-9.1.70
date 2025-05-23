package com.tencent.qqnt.chathistory.ui.troopMember;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.chathistory.ui.troopMember.TestFragment;
import com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$adapter$2;
import com.tencent.qqnt.chathistory.ui.troopMember.history.TroopMemberHistoryFragment;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.util.m;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.BulletinFeedsDownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataSource;
import com.tencent.qqnt.kernel.nativeinterface.FirstGroupBulletinInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAllInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupArkInviteStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletin;
import com.tencent.qqnt.kernel.nativeinterface.GroupBulletinListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupListUpdateType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberLevelInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListChangeInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupStatisticInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener;
import com.tencent.qqnt.kernel.nativeinterface.JoinGroupNotifyMsg;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupBulletinMsg;
import com.tencent.qqnt.kernel.nativeinterface.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\f*\u0001!\b\u0000\u0018\u0000 (2\u00020\u0001:\u0003)*+B\u0007\u00a2\u0006\u0004\b&\u0010'J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/TestFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/qqnt/kernel/api/s;", "uh", "", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "", "Lcom/tencent/qqnt/chathistory/ui/troopMember/TestFragment$b;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "datas", "", "D", "Ljava/lang/String;", "groupCode", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Lkotlin/Lazy;", "vh", "()Landroidx/recyclerview/widget/RecyclerView;", "ry", "com/tencent/qqnt/chathistory/ui/troopMember/TestFragment$adapter$2$a", UserInfo.SEX_FEMALE, "th", "()Lcom/tencent/qqnt/chathistory/ui/troopMember/TestFragment$adapter$2$a;", "adapter", "<init>", "()V", "G", "a", "b", "c", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TestFragment extends ReportAndroidXFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<b> datas;

    /* renamed from: D, reason: from kotlin metadata */
    private String groupCode;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy ry;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/TestFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/TestFragment$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uin", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String name;

        public b(@NotNull String uin, @NotNull String name) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(name, "name");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uin, (Object) name);
            } else {
                this.uin = uin;
                this.name = name;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.uin, bVar.uin) && Intrinsics.areEqual(this.name, bVar.name)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.uin.hashCode() * 31) + this.name.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "Member(uin=" + this.uin + ", name=" + this.name + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/TestFragment$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "itemView", "<init>", "(Landroid/widget/TextView;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull TextView itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51447);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TestFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.datas = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$ry$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TestFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RecyclerView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RecyclerView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                RecyclerView recyclerView = new RecyclerView(TestFragment.this.requireContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(TestFragment.this.requireContext()));
                return recyclerView;
            }
        });
        this.ry = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TestFragment$adapter$2.a>() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$adapter$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/chathistory/ui/troopMember/TestFragment$adapter$2$a", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/TestFragment$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "j0", "getItemCount", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes23.dex */
            public static final class a extends RecyclerView.Adapter<TestFragment.c> {
                static IPatchRedirector $redirector_;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ TestFragment f353932m;

                a(TestFragment testFragment) {
                    this.f353932m = testFragment;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) testFragment);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void k0(TestFragment this$0, TestFragment.b member, View view) {
                    String str;
                    ArrayList<String> arrayListOf;
                    EventCollector.getInstance().onViewClickedBefore(view);
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    Intrinsics.checkNotNullParameter(member, "$member");
                    FragmentActivity requireActivity = this$0.requireActivity();
                    Intent intent = new Intent(this$0.getActivity(), this$0.requireActivity().getClass());
                    intent.putExtra("frameKey", TroopMemberHistoryFragment.class.getName());
                    intent.putExtra("nt_chat_history_chatType", 2);
                    str = this$0.groupCode;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupCode");
                        str = null;
                    }
                    intent.putExtra("nt_chat_history_peerId", str);
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(member.b());
                    intent.putStringArrayListExtra("key_troop_member_uids", arrayListOf);
                    intent.putExtra("key_troop_member_nick", member.a());
                    requireActivity.startActivity(intent);
                    EventCollector.getInstance().onViewClicked(view);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                public int getItemCount() {
                    List list;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                        list = this.f353932m.datas;
                        return list.size();
                    }
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                /* renamed from: j0, reason: merged with bridge method [inline-methods] */
                public void onBindViewHolder(@NotNull TestFragment.c holder, int position) {
                    List list;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(holder, "holder");
                    list = this.f353932m.datas;
                    final TestFragment.b bVar = (TestFragment.b) list.get(position);
                    View view = holder.itemView;
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
                    ((TextView) view).setText(bVar.a());
                    View view2 = holder.itemView;
                    final TestFragment testFragment = this.f353932m;
                    view2.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003b: INVOKE 
                          (r4v1 'view2' android.view.View)
                          (wrap:android.view.View$OnClickListener:0x0038: CONSTRUCTOR 
                          (r0v6 'testFragment' com.tencent.qqnt.chathistory.ui.troopMember.TestFragment A[DONT_INLINE])
                          (r5v2 'bVar' com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$b A[DONT_INLINE])
                         A[MD:(com.tencent.qqnt.chathistory.ui.troopMember.TestFragment, com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$b):void (m), WRAPPED] (LINE:57) call: com.tencent.qqnt.chathistory.ui.troopMember.b.<init>(com.tencent.qqnt.chathistory.ui.troopMember.TestFragment, com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$b):void type: CONSTRUCTOR)
                         VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void A[MD:(android.view.View$OnClickListener):void (c)] (LINE:60) in method: com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$adapter$2.a.j0(com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$c, int):void, file: classes23.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.qqnt.chathistory.ui.troopMember.b, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 19 more
                        */
                    /*
                        this = this;
                        com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$adapter$2.a.$redirector_
                        if (r0 == 0) goto Lf
                        r1 = 3
                        boolean r2 = r0.hasPatch(r1)
                        if (r2 == 0) goto Lf
                        r0.redirect(r1, r3, r4, r5)
                        return
                    Lf:
                        java.lang.String r0 = "holder"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                        com.tencent.qqnt.chathistory.ui.troopMember.TestFragment r0 = r3.f353932m
                        java.util.List r0 = com.tencent.qqnt.chathistory.ui.troopMember.TestFragment.rh(r0)
                        java.lang.Object r5 = r0.get(r5)
                        com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$b r5 = (com.tencent.qqnt.chathistory.ui.troopMember.TestFragment.b) r5
                        android.view.View r0 = r4.itemView
                        java.lang.String r1 = "null cannot be cast to non-null type android.widget.TextView"
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
                        android.widget.TextView r0 = (android.widget.TextView) r0
                        java.lang.String r1 = r5.a()
                        r0.setText(r1)
                        android.view.View r4 = r4.itemView
                        com.tencent.qqnt.chathistory.ui.troopMember.TestFragment r0 = r3.f353932m
                        com.tencent.qqnt.chathistory.ui.troopMember.b r1 = new com.tencent.qqnt.chathistory.ui.troopMember.b
                        r1.<init>(r0, r5)
                        r4.setOnClickListener(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$adapter$2.a.onBindViewHolder(com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$c, int):void");
                }

                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                @NotNull
                /* renamed from: l0, reason: merged with bridge method [inline-methods] */
                public TestFragment.c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (TestFragment.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
                    }
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Button button = new Button(parent.getContext());
                    button.setLayoutParams(new ViewGroup.LayoutParams(-1, m.a(50)));
                    return new TestFragment.c(button);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TestFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TestFragment.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.adapter = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TestFragment$adapter$2.a th() {
        return (TestFragment$adapter$2.a) this.adapter.getValue();
    }

    private final s uh() {
        return ((IKernelService) MobileQQ.sMobileQQ.waitAppRuntime().getRuntimeService(IKernelService.class, "")).getGroupService();
    }

    private final RecyclerView vh() {
        return (RecyclerView) this.ry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(TestFragment this$0, int i3, String str, GroupMemberListResult groupMemberListResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), Dispatchers.getMain(), null, new TestFragment$onStart$1$2$1$1(groupMemberListResult, this$0, null), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vh5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            vh5 = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            vh5 = vh();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, vh5);
        return vh5;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onPause();
        d.f354054a.a("TestFragment_Member", "onPause " + this);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onResume();
        d.f354054a.a("TestFragment_Member", "onResume " + this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onStart();
        this.groupCode = String.valueOf(requireArguments().getString(IGroupTeamWorkHandler.KEY_GROUP_CODE));
        s uh5 = uh();
        if (uh5 != null) {
            uh5.D(new IKernelGroupListener() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.TestFragment$onStart$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TestFragment.this);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGetGroupBulletinListResult(long j3, String str, GroupBulletinListResult groupBulletinListResult) {
                    am.a(this, j3, str, groupBulletinListResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupAdd(long j3) {
                    am.b(this, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupAllInfoChange(GroupAllInfo groupAllInfo) {
                    am.c(this, groupAllInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupArkInviteStateResult(long j3, GroupArkInviteStateInfo groupArkInviteStateInfo) {
                    am.d(this, j3, groupArkInviteStateInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupBulletinChange(long j3, GroupBulletin groupBulletin) {
                    am.e(this, j3, groupBulletin);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupBulletinRemindNotify(long j3, RemindGroupBulletinMsg remindGroupBulletinMsg) {
                    am.f(this, j3, remindGroupBulletinMsg);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupBulletinRichMediaDownloadComplete(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
                    am.g(this, bulletinFeedsDownloadInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupBulletinRichMediaProgressUpdate(BulletinFeedsDownloadInfo bulletinFeedsDownloadInfo) {
                    am.h(this, bulletinFeedsDownloadInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupConfMemberChange(long j3, ArrayList arrayList) {
                    am.i(this, j3, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupDetailInfoChange(GroupDetailInfo groupDetailInfo) {
                    am.j(this, groupDetailInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupEssenceListChange(long j3) {
                    am.k(this, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupExtListUpdate(GroupExtListUpdateType groupExtListUpdateType, ArrayList arrayList) {
                    am.l(this, groupExtListUpdateType, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupFirstBulletinNotify(FirstGroupBulletinInfo firstGroupBulletinInfo) {
                    am.m(this, firstGroupBulletinInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupListInited(boolean z16) {
                    am.n(this, z16);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupListUpdate(GroupListUpdateType groupListUpdateType, ArrayList arrayList) {
                    am.o(this, groupListUpdateType, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupMemberLevelInfoChange(long j3, GroupMemberLevelInfo groupMemberLevelInfo) {
                    am.p(this, j3, groupMemberLevelInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupNotifiesUnreadCountUpdated(boolean z16, long j3, int i3) {
                    am.q(this, z16, j3, i3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupNotifiesUnreadCountUpdatedV2(boolean z16, long j3, int i3, int i16, int i17, int i18) {
                    am.r(this, z16, j3, i3, i16, i17, i18);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupNotifiesUpdated(boolean z16, ArrayList arrayList) {
                    am.s(this, z16, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupNotifiesUpdatedV2(boolean z16, long j3, ArrayList arrayList, ArrayList arrayList2) {
                    am.t(this, z16, j3, arrayList, arrayList2);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupSingleScreenNotifies(boolean z16, long j3, ArrayList arrayList) {
                    am.u(this, z16, j3, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupSingleScreenNotifiesV2(boolean z16, long j3, long j16, boolean z17, int i3, ArrayList arrayList, ArrayList arrayList2) {
                    am.v(this, z16, j3, j16, z17, i3, arrayList, arrayList2);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupStatisticInfoChange(long j3, GroupStatisticInfo groupStatisticInfo) {
                    am.w(this, j3, groupStatisticInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onGroupsMsgMaskResult(ArrayList arrayList) {
                    am.x(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onJoinGroupNoVerifyFlag(long j3, boolean z16, boolean z17) {
                    am.y(this, j3, z16, z17);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onJoinGroupNotify(JoinGroupNotifyMsg joinGroupNotifyMsg) {
                    am.z(this, joinGroupNotifyMsg);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onMemberInfoChange(long j3, DataSource dataSource, HashMap hashMap) {
                    am.A(this, j3, dataSource, hashMap);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public void onMemberListChange(@Nullable GroupMemberListChangeInfo info) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(TestFragment.this), Dispatchers.getMain(), null, new TestFragment$onStart$1$1$onMemberListChange$1(info, TestFragment.this, null), 2, null);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) info);
                    }
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onSearchMemberChange(String str, String str2, ArrayList arrayList, HashMap hashMap) {
                    am.C(this, str, str2, arrayList, hashMap);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupListener
                public /* synthetic */ void onShutUpMemberListChanged(long j3, ArrayList arrayList) {
                    am.D(this, j3, arrayList);
                }
            });
            String str = this.groupCode;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("groupCode");
                str = null;
            }
            Intrinsics.checkNotNull(str);
            String createMemberListScene = uh5.createMemberListScene(Long.parseLong(str), "aio");
            if (createMemberListScene != null) {
                uh5.getNextMemberList(createMemberListScene, null, 15, new IGroupMemberListCallback() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
                    public final void onResult(int i3, String str2, GroupMemberListResult groupMemberListResult) {
                        TestFragment.wh(TestFragment.this, i3, str2, groupMemberListResult);
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        vh().setAdapter(th());
    }
}
