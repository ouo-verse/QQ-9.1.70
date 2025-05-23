package com.tencent.qqnt.chathistory.ui.date;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.category.BaseSubCategoryFragment;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.date.data.a;
import com.tencent.qqnt.chathistory.ui.date.viewmodel.ChatHistoryDateActivityViewModel;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.x2k.m;
import com.tencent.qqnt.datepicker.b;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.LoadingUtil;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/ChatHistoryDateFragment;", "Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/date/viewmodel/ChatHistoryDateActivityViewModel;", "Lcom/tencent/qqnt/chathistory/ui/category/c;", "", "Gh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/app/Dialog;", UserInfo.SEX_FEMALE, "Landroid/app/Dialog;", "loadingDialog", "", "G", "Z", "firstResume", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chathistory/ui/category/c$b;", "H", "Ljava/lang/ref/WeakReference;", "Fh", "()Ljava/lang/ref/WeakReference;", "y5", "(Ljava/lang/ref/WeakReference;)V", "titleRightDelegate", "Lcom/tencent/qqnt/chathistory/ui/date/adapter/a;", "I", "Lkotlin/Lazy;", "Eh", "()Lcom/tencent/qqnt/chathistory/ui/date/adapter/a;", "adapter", "<init>", "()V", "J", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryDateFragment extends BaseSubCategoryFragment<ChatHistoryDateActivityViewModel> implements c {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a J;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean firstResume;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c.b> titleRightDelegate;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/ChatHistoryDateFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35802);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            J = new a(null);
        }
    }

    public ChatHistoryDateFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.firstResume = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.chathistory.ui.date.adapter.a>() { // from class: com.tencent.qqnt.chathistory.ui.date.ChatHistoryDateFragment$adapter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDateFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.qqnt.chathistory.ui.date.adapter.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new com.tencent.qqnt.chathistory.ui.date.adapter.a(new Function2<b, View, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.date.ChatHistoryDateFragment$adapter$2.1
                    static IPatchRedirector $redirector_;

                    {
                        super(2);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) ChatHistoryDateFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(b bVar, View view) {
                        invoke2(bVar, view);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull b it, @NotNull View view) {
                        Map<String, Object> mutableMapOf;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, (Object) it, (Object) view);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        Intrinsics.checkNotNullParameter(view, "view");
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(1, it.c());
                        calendar.set(2, it.b() - 1);
                        calendar.set(5, it.a());
                        calendar.set(11, 0);
                        calendar.set(12, 0);
                        calendar.set(13, 0);
                        long timeInMillis = calendar.getTimeInMillis() / 1000;
                        d.f354054a.a("ChatHistoryDateFragmentDebug", "choose Time " + it + "  stamp " + timeInMillis);
                        com.tencent.qqnt.chathistory.service.a aVar = com.tencent.qqnt.chathistory.service.a.f353327a;
                        Context requireContext = ChatHistoryDateFragment.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        int M1 = ((ChatHistoryDateActivityViewModel) ChatHistoryDateFragment.this.rh()).M1();
                        String N1 = ((ChatHistoryDateActivityViewModel) ChatHistoryDateFragment.this.rh()).N1();
                        String O1 = ((ChatHistoryDateActivityViewModel) ChatHistoryDateFragment.this.rh()).O1();
                        if (O1 == null) {
                            O1 = "";
                        }
                        com.tencent.qqnt.chathistory.service.a.g(aVar, requireContext, M1, N1, O1, timeInMillis, 0L, 32, null);
                        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("date", Long.valueOf(timeInMillis)));
                        a16.m(view, "em_bas_date", mutableMapOf);
                    }
                }) : (com.tencent.qqnt.chathistory.ui.date.adapter.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.adapter = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.chathistory.ui.date.adapter.a Eh() {
        return (com.tencent.qqnt.chathistory.ui.date.adapter.a) this.adapter.getValue();
    }

    private final void Gh() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatHistoryDateFragment$handleRequestUI$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Nullable
    public WeakReference<c.b> Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.titleRightDelegate;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void ff() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            c.a.a(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        c.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        if (this.firstResume) {
            Gh();
            this.firstResume = false;
        }
        WeakReference<c.b> Fh = Fh();
        if (Fh != null && (bVar = Fh.get()) != null) {
            bVar.f3(null, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.f71903pe);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(Eh());
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<Recycl\u2026apter = adapter\n        }");
        this.recyclerView = recyclerView;
        this.loadingDialog = LoadingUtil.showLoadingDialog(requireContext(), HardCodeUtil.qqStr(R.string.zjt), true);
        LiveData obtainUiState = ((ChatHistoryDateActivityViewModel) rh()).obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.qqnt.chathistory.ui.date.data.a, Unit> function1 = new Function1<com.tencent.qqnt.chathistory.ui.date.data.a, Unit>() { // from class: com.tencent.qqnt.chathistory.ui.date.ChatHistoryDateFragment$onViewCreated$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryDateFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.chathistory.ui.date.data.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.chathistory.ui.date.data.a aVar) {
                Dialog dialog;
                com.tencent.qqnt.chathistory.ui.date.adapter.a Eh;
                RecyclerView recyclerView2;
                com.tencent.qqnt.chathistory.ui.date.adapter.a Eh2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar instanceof a.C9525a) {
                    dialog = ChatHistoryDateFragment.this.loadingDialog;
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    Eh = ChatHistoryDateFragment.this.Eh();
                    Eh.m0(((a.C9525a) aVar).a());
                    recyclerView2 = ChatHistoryDateFragment.this.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView2 = null;
                    }
                    Eh2 = ChatHistoryDateFragment.this.Eh();
                    recyclerView2.scrollToPosition(Eh2.getNUM_BACKGOURND_ICON() - 1);
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.qqnt.chathistory.ui.date.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ChatHistoryDateFragment.Hh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void t6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            c.a.b(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel] */
    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment
    @Nullable
    public View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        }
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        View mRv = new m(context, null, 2, 0 == true ? 1 : 0).getMRv();
        HistoryDtReportHelper.Companion companion = HistoryDtReportHelper.INSTANCE;
        HistoryDtReportHelper a16 = companion.a();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", companion.a().d(rh())), TuplesKt.to("aio_type", Integer.valueOf(((ChatHistoryDateActivityViewModel) rh()).M1())), TuplesKt.to(TPReportKeys.LiveExKeys.LICE_FX_TUID, ((ChatHistoryDateActivityViewModel) rh()).N1()));
        a16.v(requireActivity, mRv, "pg_bas_date_tab", mutableMapOf);
        return mRv;
    }

    @Override // com.tencent.qqnt.chathistory.ui.category.c
    public void y5(@Nullable WeakReference<c.b> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) weakReference);
        } else {
            this.titleRightDelegate = weakReference;
        }
    }
}
