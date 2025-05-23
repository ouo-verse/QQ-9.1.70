package com.tencent.qqnt.chathistory.ui.troopMember;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.troopMember.viewmodel.ChatHistoryTroopMemberViewModel;
import com.tencent.qqnt.chathistory.x2k.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/TroopMemberFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/troopMember/viewmodel/ChatHistoryTroopMemberViewModel;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "<init>", "()V", "E", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TroopMemberFragment extends BaseSubCategoryFragment<ChatHistoryTroopMemberViewModel> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a E;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/troopMember/TroopMemberFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51467);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            E = new a(null);
        }
    }

    public TroopMemberFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Fragment fragment;
        IHistoryBridgeInterface newInstance;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("TroopMemberFragment");
        if (findFragmentByTag != null) {
            getChildFragmentManager().beginTransaction().attach(findFragmentByTag);
            return;
        }
        Class<IHistoryBridgeInterface> cls = com.tencent.qqnt.chathistory.inject.a.f353321a.get("groupMember");
        Fragment fragment2 = null;
        if (cls != null && (newInstance = cls.newInstance()) != 0) {
            newInstance.q8(new IHistoryBridgeInterface.b() { // from class: com.tencent.qqnt.chathistory.ui.troopMember.TroopMemberFragment$onViewCreated$groupMemberFragment$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberFragment.this);
                    }
                }

                @Override // com.tencent.qqnt.chathistory.bridge.IHistoryBridgeInterface.b
                @Nullable
                public Object invoke(int action, @NotNull Object... args) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return iPatchRedirector2.redirect((short) 2, (Object) this, action, (Object) args);
                    }
                    Intrinsics.checkNotNullParameter(args, "args");
                    if (action == 0) {
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(TroopMemberFragment.this), null, null, new TroopMemberFragment$onViewCreated$groupMemberFragment$1$1$invoke$1(args, TroopMemberFragment.this, null), 3, null);
                    }
                    return null;
                }
            });
            fragment = newInstance;
        } else {
            fragment = null;
        }
        if (fragment instanceof Fragment) {
            fragment2 = fragment;
        }
        if (fragment2 == null) {
            fragment2 = new TestFragment();
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(IGroupTeamWorkHandler.KEY_GROUP_CODE, ((ChatHistoryTroopMemberViewModel) rh()).N1());
        fragment2.setArguments(bundle);
        Unit unit = Unit.INSTANCE;
        beginTransaction.add(R.id.z1d, fragment2, "TroopMemberFragment").commitAllowingStateLoss();
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        return new o(context, null, 2, null).getMContainer();
    }
}
