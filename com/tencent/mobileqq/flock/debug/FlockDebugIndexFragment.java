package com.tencent.mobileqq.flock.debug;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.feeddetail.bean.FlockFeedDetailInitBean;
import com.tencent.mobileqq.flock.homepage.FlockHomePageFragment;
import com.tencent.mobileqq.flock.member.fragment.FlockMemberListFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/flock/debug/FlockDebugIndexFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getContentLayoutId", "", "getStatusBarColor", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "view", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class FlockDebugIndexFragment extends ImmersivePartFragment {
    static IPatchRedirector $redirector_;

    public FlockDebugIndexFragment() {
        super(R.layout.e7n);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(FlockDebugIndexFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CompatPublicActivity.start(this$0.getContext(), FlockHomePageFragment.class);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(FlockDebugIndexFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        com.tencent.mobileqq.flock.a.e(aVar, requireContext, 0, null, null, null, 30, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(FlockDebugIndexFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        aVar.a(requireContext, new FlockFeedDetailInitBean("", "", 0L, 0L, null, null, 0, 0, 248, null));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(FlockDebugIndexFragment this$0, View view) {
        FragmentManager supportFragmentManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FlockMemberListFragment flockMemberListFragment = new FlockMemberListFragment();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            flockMemberListFragment.show(supportFragmentManager, "flock_member");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(FlockDebugIndexFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        aVar.g(requireContext, 157555426L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(FlockDebugIndexFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        aVar.i(requireContext, null, FlockConstants$FlockListScene.ACTIVITY);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return -1;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.vqs).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.debug.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FlockDebugIndexFragment.vh(FlockDebugIndexFragment.this, view2);
            }
        });
        view.findViewById(R.id.vqn).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FlockDebugIndexFragment.wh(FlockDebugIndexFragment.this, view2);
            }
        });
        view.findViewById(R.id.vqr).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.debug.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FlockDebugIndexFragment.xh(FlockDebugIndexFragment.this, view2);
            }
        });
        view.findViewById(R.id.vqo).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.debug.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FlockDebugIndexFragment.yh(FlockDebugIndexFragment.this, view2);
            }
        });
        view.findViewById(R.id.vqt).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.debug.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FlockDebugIndexFragment.zh(FlockDebugIndexFragment.this, view2);
            }
        });
        view.findViewById(R.id.vqp).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.debug.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FlockDebugIndexFragment.Ah(FlockDebugIndexFragment.this, view2);
            }
        });
    }
}
