package com.tencent.mobileqq.troop.homework.homework.submit.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWAudioRecordPart;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWMediaSelectPart;
import com.tencent.mobileqq.troop.homework.homework.submit.parts.MediaPart;
import com.tencent.mobileqq.troop.homework.homework.submit.parts.SubmitHomeworkAnimPart;
import com.tencent.mobileqq.troop.homework.homework.submit.parts.SubmitPart;
import com.tencent.mobileqq.troop.homework.homework.submit.parts.TitlePart;
import com.tencent.mobileqq.troop.homework.homework.submit.vm.SubmitHomeWorkVM;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ts2.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/fragment/SubmitHomeworkFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initUI", "", "getContentLayoutId", "onStart", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onDestroyView", "Landroid/content/Intent;", "intent", "onNewIntent", "Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "sh", "()Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", "viewModel", "Lts2/i;", "D", "rh", "()Lts2/i;", "binding", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class SubmitHomeworkFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/fragment/SubmitHomeworkFragment$a;", "", "", "homeWorkId", "troopId", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lkotlin/collections/ArrayList;", "items", "", "requestCode", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.homework.submit.fragment.SubmitHomeworkFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

        public final void a(@NotNull String homeWorkId, @NotNull String troopId, @NotNull Context context, @NotNull ArrayList<BaseItem> items, int requestCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, homeWorkId, troopId, context, items, Integer.valueOf(requestCode));
                return;
            }
            Intrinsics.checkNotNullParameter(homeWorkId, "homeWorkId");
            Intrinsics.checkNotNullParameter(troopId, "troopId");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(items, "items");
            Intent intent = new Intent();
            intent.putExtra("hw_id", homeWorkId);
            intent.putExtra("troop_id", troopId);
            intent.putExtra("hw_data", items);
            QPublicFragmentActivity.b.f(context, intent, QPublicTransFragmentActivity.class, SubmitHomeworkFragment.class, requestCode);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SubmitHomeworkFragment() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SubmitHomeWorkVM>() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.fragment.SubmitHomeworkFragment$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubmitHomeworkFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SubmitHomeWorkVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (SubmitHomeWorkVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ViewModel viewModel = new ViewModelProvider(SubmitHomeworkFragment.this).get(SubmitHomeWorkVM.class);
                    SubmitHomeworkFragment submitHomeworkFragment = SubmitHomeworkFragment.this;
                    SubmitHomeWorkVM submitHomeWorkVM = (SubmitHomeWorkVM) viewModel;
                    submitHomeWorkVM.a2(submitHomeworkFragment, submitHomeworkFragment.getArguments());
                    return submitHomeWorkVM;
                }
            });
            this.viewModel = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<i>() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.fragment.SubmitHomeworkFragment$binding$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubmitHomeworkFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final i invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? i.e(SubmitHomeworkFragment.this.requireView()) : (i) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.binding = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void initUI() {
        rh().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubmitHomeworkFragment.th(SubmitHomeworkFragment.this, view);
            }
        });
        rh().f437410j.setText(sh().Z1());
        ViewCompat.setOnApplyWindowInsetsListener(rh().getRoot(), new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.fragment.b
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat uh5;
                uh5 = SubmitHomeworkFragment.uh(view, windowInsetsCompat);
                return uh5;
            }
        });
    }

    private final i rh() {
        return (i) this.binding.getValue();
    }

    private final SubmitHomeWorkVM sh() {
        return (SubmitHomeWorkVM) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(SubmitHomeworkFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            InputMethodUtil.hide(activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat uh(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "insets.getInsets(WindowI\u2026Compat.Type.systemBars())");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TitlePart(), new SubmitPart(), new MediaPart(), new SubmitHomeworkAnimPart(), new HWAudioRecordPart(), new HWMediaSelectPart(HWMediaSelectPart.SourceType.SUBMIT_HW));
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.i1_;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            if (!(activity instanceof QBaseActivity)) {
                return;
            }
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            qBaseActivity.overridePendingTransition(R.anim.f154431s, R.anim.f154430r);
            com.tencent.mobileqq.theme.a.d(qBaseActivity.getWindow());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroyView();
        InputMethodUtil.hide(getActivity());
        sh().T1().G();
        com.tencent.mobileqq.troop.homework.utils.b.a();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        aVar.a("SubmitHWSubmitFragment", "onNewIntent,action is " + str);
        getPartManager().onNewIntent(intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI();
    }
}
