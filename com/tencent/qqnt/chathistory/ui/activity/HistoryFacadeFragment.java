package com.tencent.qqnt.chathistory.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqnt.chathistory.business.a;
import com.tencent.qqnt.chathistory.business.b;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.h;
import com.tencent.qqnt.chathistory.ui.menu.ChatHistoryMenuFragment;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "\u89c6\u56fe\u5bb9\u5668", path = "/base/chathistory/main/fragment")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001b\u0010\u0014\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/activity/HistoryFacadeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/qqnt/chathistory/ui/base/h;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "clearRestore", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "Lcom/tencent/qqnt/chathistory/business/a;", "viewModel", "chatHistoryMainViewModel$delegate", "Lkotlin/Lazy;", "getChatHistoryMainViewModel", "()Lcom/tencent/qqnt/chathistory/business/a;", "chatHistoryMainViewModel", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class HistoryFacadeFragment extends ReportAndroidXFragment implements h {
    static IPatchRedirector $redirector_;

    /* renamed from: chatHistoryMainViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy chatHistoryMainViewModel;

    public HistoryFacadeFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.qqnt.chathistory.ui.activity.HistoryFacadeFragment$chatHistoryMainViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HistoryFacadeFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HistoryFacadeFragment historyFacadeFragment = HistoryFacadeFragment.this;
                    Bundle requireArguments = HistoryFacadeFragment.this.requireArguments();
                    Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
                    ViewModel viewModel = new ViewModelProvider(historyFacadeFragment, new b(requireArguments)).get(a.class);
                    Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026essViewModel::class.java)");
                    return (a) viewModel;
                }
            });
            this.chatHistoryMainViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void clearRestore(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        savedInstanceState.remove("android:fragments");
        savedInstanceState.remove("android:support:fragments");
    }

    private final a getChatHistoryMainViewModel() {
        return (a) this.chatHistoryMainViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
        } else {
            clearRestore(savedInstanceState);
            super.onCreate(savedInstanceState);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Class cls;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            HistoryDtReportHelper.INSTANCE.a().y(this);
            FrameLayout frameLayout = new FrameLayout(inflater.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setId(View.generateViewId());
            String string = requireArguments().getString("frameKey");
            if (string == null) {
                cls = ChatHistoryMenuFragment.class;
            } else {
                cls = Class.forName(string);
                Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.Fragment>");
            }
            if (getChildFragmentManager().findFragmentByTag(string) == null) {
                getChildFragmentManager().beginTransaction().add(frameLayout.getId(), cls, requireArguments(), string).commitAllowingStateLoss();
            }
            view = frameLayout;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.h
    @NotNull
    public a viewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return getChatHistoryMainViewModel();
    }
}
