package com.tencent.mobileqq.troop.troopnotification.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM;
import com.tencent.mobileqq.troop.widget.swipe.CommonSwipeMenuLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010*R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00101\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationListSubFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "type", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/d;", "Ch", "", "Ih", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "vm", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "E", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/d;", "recentListAdapter", UserInfo.SEX_FEMALE, "allListAdapter", "G", "historyListAdapter", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/a;", "H", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/a;", "dividerAdapter", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/f;", "I", "Lcom/tencent/mobileqq/troop/troopnotification/adapter/f;", "loadMoreAdapter", "J", "category", "", "K", "Z", "firstInit", "L", "isResume", "M", "needReadAllWhenResume", "<init>", "()V", "N", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationListSubFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopnotification.adapter.d recentListAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopnotification.adapter.d allListAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopnotification.adapter.d historyListAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopnotification.adapter.a dividerAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.troopnotification.adapter.f loadMoreAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    private int category;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean firstInit;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isResume;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean needReadAllWhenResume;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationListSubFragment$a;", "", "", "category", "Lcom/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationListSubFragment;", "a", "", "CATEGORY", "Ljava/lang/String;", "PRELOAD_ITEM_OFFSET_INDEX", "I", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListSubFragment$a, reason: from kotlin metadata */
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

        @NotNull
        public final TroopNotificationListSubFragment a(int category) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopNotificationListSubFragment) iPatchRedirector.redirect((short) 2, (Object) this, category);
            }
            Bundle bundle = new Bundle();
            bundle.putInt("CATEGORY", category);
            TroopNotificationListSubFragment troopNotificationListSubFragment = new TroopNotificationListSubFragment();
            troopNotificationListSubFragment.setArguments(bundle);
            return troopNotificationListSubFragment;
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/fragment/TroopNotificationListSubFragment$b", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Landroid/view/MotionEvent;", "e", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.SimpleOnItemTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f300663d;

        b(RecyclerView recyclerView) {
            this.f300663d = recyclerView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NotNull RecyclerView rv5, @NotNull MotionEvent e16) {
            CommonSwipeMenuLayout commonSwipeMenuLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rv5, (Object) e16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
            if (e16.getAction() == 0 && (commonSwipeMenuLayout = CommonSwipeMenuLayout.f().get()) != null && Intrinsics.areEqual(this.f300663d.findChildViewUnder(e16.getX(), e16.getY()), commonSwipeMenuLayout)) {
                commonSwipeMenuLayout.j();
            }
            return super.onInterceptTouchEvent(rv5, e16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58802);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationListSubFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopNotificationListVM>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListSubFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListSubFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopNotificationListVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopNotificationListVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    TroopNotificationListVM.Companion companion = TroopNotificationListVM.INSTANCE;
                    Fragment requireParentFragment = TroopNotificationListSubFragment.this.requireParentFragment();
                    Intrinsics.checkNotNullExpressionValue(requireParentFragment, "requireParentFragment()");
                    return companion.a(requireParentFragment);
                }
            });
            this.vm = lazy;
            this.firstInit = true;
            this.isResume = true;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final com.tencent.mobileqq.troop.troopnotification.adapter.d Ch(final int type) {
        com.tencent.mobileqq.troop.troopnotification.adapter.d dVar = new com.tencent.mobileqq.troop.troopnotification.adapter.d(Dh(), this.category, type);
        dVar.p0(new Function2<com.tencent.mobileqq.troop.troopnotification.render.vh.list.a, Integer, Unit>(type, this) { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListSubFragment$createNotificationAdapter$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $type;
            final /* synthetic */ TroopNotificationListSubFragment this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$type = type;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, type, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopnotification.render.vh.list.a aVar, Integer num) {
                invoke(aVar, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a vh5, int i3) {
                int i16;
                TroopNotificationListVM Dh;
                int i17;
                TroopNotificationListVM Dh2;
                int i18;
                int i19;
                com.tencent.mobileqq.troop.troopnotification.adapter.d dVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) vh5, i3);
                    return;
                }
                Intrinsics.checkNotNullParameter(vh5, "vh");
                if (this.$type == 2) {
                    dVar2 = this.this$0.recentListAdapter;
                    i16 = (dVar2 != null ? dVar2.getNUM_BACKGOURND_ICON() : 0) + i3;
                } else {
                    i16 = i3;
                }
                Dh = this.this$0.Dh();
                i17 = this.this$0.category;
                int i26 = Dh.i2(i17);
                if (QLog.isColorLevel()) {
                    i19 = this.this$0.category;
                    QLog.d("TroopNotificationListSubFragment", 2, "onBindViewListener: category=" + i19 + ", type=" + this.$type + ", notificationCount=" + i26 + ", pos=" + i3 + ", realPos=" + i16);
                }
                if (i26 - i16 < 5) {
                    Dh2 = this.this$0.Dh();
                    i18 = this.this$0.category;
                    Dh2.N2(i18);
                }
            }
        });
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopNotificationListVM Dh() {
        return (TroopNotificationListVM) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListSubFragment", 2, "readAllNotification: category=" + this.category + ", isResume=" + this.isResume);
        }
        if (this.isResume) {
            TroopNotificationListVM.J2(Dh(), this.category, 0, 2, null);
            if (this.category == 0) {
                TroopNotificationListVM.J2(Dh(), 2, 0, 2, null);
                return;
            } else {
                TroopNotificationListVM.J2(Dh(), 0, 0, 2, null);
                return;
            }
        }
        this.needReadAllWhenResume = true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("CATEGORY");
        } else {
            i3 = 0;
        }
        this.category = i3;
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListSubFragment", 2, "onCreate: category=" + this.category);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RFWConcatAdapter rFWConcatAdapter;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Context context = getContext();
            if (context != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopNotificationListSubFragment", 2, "onCreateView: category=" + this.category);
                }
                RecyclerView recyclerView = new RecyclerView(context);
                recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
                this.loadMoreAdapter = new com.tencent.mobileqq.troop.troopnotification.adapter.f();
                if (this.category == 0) {
                    this.recentListAdapter = Ch(1);
                    this.historyListAdapter = Ch(2);
                    this.dividerAdapter = new com.tencent.mobileqq.troop.troopnotification.adapter.a(Dh(), this.category);
                    RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
                    RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[4];
                    adapterArr[0] = this.recentListAdapter;
                    adapterArr[1] = this.dividerAdapter;
                    adapterArr[2] = this.historyListAdapter;
                    com.tencent.mobileqq.troop.troopnotification.adapter.f fVar = this.loadMoreAdapter;
                    if (fVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                        fVar = null;
                    }
                    adapterArr[3] = fVar;
                    rFWConcatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
                } else {
                    this.allListAdapter = Ch(0);
                    RFWConcatAdapter.Config build2 = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
                    RecyclerView.Adapter[] adapterArr2 = new RecyclerView.Adapter[2];
                    adapterArr2[0] = this.allListAdapter;
                    com.tencent.mobileqq.troop.troopnotification.adapter.f fVar2 = this.loadMoreAdapter;
                    if (fVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                        fVar2 = null;
                    }
                    adapterArr2[1] = fVar2;
                    rFWConcatAdapter = new RFWConcatAdapter(build2, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr2);
                }
                recyclerView.setAdapter(rFWConcatAdapter);
                recyclerView.addOnItemTouchListener(new b(recyclerView));
                this.recyclerView = recyclerView;
                com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<com.tencent.qqnt.notification.f>>> l26 = Dh().l2();
                LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                final Function1<Map<Integer, List<com.tencent.qqnt.notification.f>>, Unit> function1 = new Function1<Map<Integer, List<com.tencent.qqnt.notification.f>>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListSubFragment$onCreateView$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListSubFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, List<com.tencent.qqnt.notification.f>> map) {
                        invoke2(map);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<Integer, List<com.tencent.qqnt.notification.f>> map) {
                        com.tencent.mobileqq.troop.troopnotification.adapter.d dVar;
                        com.tencent.mobileqq.troop.troopnotification.adapter.a aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) map);
                            return;
                        }
                        dVar = TroopNotificationListSubFragment.this.recentListAdapter;
                        if (dVar != null) {
                            dVar.notifyDataSetChanged();
                        }
                        aVar = TroopNotificationListSubFragment.this.dividerAdapter;
                        if (aVar != null) {
                            aVar.notifyDataSetChanged();
                        }
                    }
                };
                l26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.o
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TroopNotificationListSubFragment.Eh(Function1.this, obj);
                    }
                });
                com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<com.tencent.qqnt.notification.f>>> g26 = Dh().g2();
                LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
                final Function1<Map<Integer, List<com.tencent.qqnt.notification.f>>, Unit> function12 = new Function1<Map<Integer, List<com.tencent.qqnt.notification.f>>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListSubFragment$onCreateView$3
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListSubFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, List<com.tencent.qqnt.notification.f>> map) {
                        invoke2(map);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<Integer, List<com.tencent.qqnt.notification.f>> map) {
                        com.tencent.mobileqq.troop.troopnotification.adapter.d dVar;
                        com.tencent.mobileqq.troop.troopnotification.adapter.a aVar;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) map);
                            return;
                        }
                        dVar = TroopNotificationListSubFragment.this.historyListAdapter;
                        if (dVar != null) {
                            dVar.notifyDataSetChanged();
                        }
                        aVar = TroopNotificationListSubFragment.this.dividerAdapter;
                        if (aVar != null) {
                            aVar.notifyDataSetChanged();
                        }
                    }
                };
                g26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.p
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TroopNotificationListSubFragment.Fh(Function1.this, obj);
                    }
                });
                com.tencent.mobileqq.troop.troopnotification.utils.a<Map<Integer, List<com.tencent.qqnt.notification.f>>> j26 = Dh().j2();
                LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
                final Function1<Map<Integer, ? extends List<com.tencent.qqnt.notification.f>>, Unit> function13 = new Function1<Map<Integer, ? extends List<com.tencent.qqnt.notification.f>>, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListSubFragment$onCreateView$4
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListSubFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends List<com.tencent.qqnt.notification.f>> map) {
                        invoke2(map);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Map<Integer, ? extends List<com.tencent.qqnt.notification.f>> map) {
                        com.tencent.mobileqq.troop.troopnotification.adapter.d dVar;
                        int i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) map);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            i3 = TroopNotificationListSubFragment.this.category;
                            QLog.d("TroopNotificationListSubFragment", 2, "onCreateView: notifyDataSetChanged, category=" + i3 + ", notificationMap.size=" + map.size());
                        }
                        dVar = TroopNotificationListSubFragment.this.allListAdapter;
                        if (dVar != null) {
                            dVar.notifyDataSetChanged();
                        }
                        TroopNotificationListSubFragment.this.Ih();
                        TroopNotificationListSubFragment.this.firstInit = false;
                    }
                };
                j26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.q
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TroopNotificationListSubFragment.Gh(Function1.this, obj);
                    }
                });
                com.tencent.mobileqq.troop.troopnotification.utils.a<SparseBooleanArray> f26 = Dh().f2();
                LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
                final Function1<SparseBooleanArray, Unit> function14 = new Function1<SparseBooleanArray, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.TroopNotificationListSubFragment$onCreateView$5
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationListSubFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SparseBooleanArray sparseBooleanArray) {
                        invoke2(sparseBooleanArray);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SparseBooleanArray sparseBooleanArray) {
                        TroopNotificationListVM Dh;
                        int i3;
                        com.tencent.mobileqq.troop.troopnotification.adapter.f fVar3;
                        com.tencent.mobileqq.troop.troopnotification.adapter.f fVar4;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) sparseBooleanArray);
                            return;
                        }
                        Dh = TroopNotificationListSubFragment.this.Dh();
                        i3 = TroopNotificationListSubFragment.this.category;
                        boolean x26 = Dh.x2(i3);
                        fVar3 = TroopNotificationListSubFragment.this.loadMoreAdapter;
                        com.tencent.mobileqq.troop.troopnotification.adapter.f fVar5 = null;
                        if (fVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                            fVar3 = null;
                        }
                        fVar3.setLoadState(x26, x26);
                        if (x26) {
                            return;
                        }
                        fVar4 = TroopNotificationListSubFragment.this.loadMoreAdapter;
                        if (fVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                        } else {
                            fVar5 = fVar4;
                        }
                        fVar5.onLoadMoreEnd(false);
                    }
                };
                f26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.troopnotification.fragment.r
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TroopNotificationListSubFragment.Hh(Function1.this, obj);
                    }
                });
                view = this.recyclerView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
            }
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPause();
        this.isResume = false;
        com.tencent.mobileqq.troop.troopnotification.report.d.f300921a.p(this.category);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationListSubFragment", 2, "onResume: ");
        }
        this.isResume = true;
        Dh().Q2(this.category);
        if (this.needReadAllWhenResume) {
            Ih();
            this.needReadAllWhenResume = false;
        }
        com.tencent.mobileqq.troop.troopnotification.report.d.f300921a.r(this.category);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onStart();
        }
    }
}
