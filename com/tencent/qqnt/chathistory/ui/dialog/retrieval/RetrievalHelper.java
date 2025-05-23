package com.tencent.qqnt.chathistory.ui.dialog.retrieval;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001b\u0010\u001b\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/RetrievalHelper;", "", "", "searchWord", "", tl.h.F, "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/b;", "a", "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/b;", "retrievalListener", "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/i;", "b", "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/i;", "f", "()Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/i;", "retrievalRepo", "", "c", "I", "mFirstPosition", "d", "mLastPosition", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Lkotlin/Lazy;", "g", "()Landroidx/recyclerview/widget/RecyclerView;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/b;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class RetrievalHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f353428f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b retrievalListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i retrievalRepo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mFirstPosition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mLastPosition;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/RetrievalHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39764);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f353428f = new a(null);
        }
    }

    public RetrievalHelper(@NotNull final Context context, @NotNull b retrievalListener) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(retrievalListener, "retrievalListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) retrievalListener);
            return;
        }
        this.retrievalListener = retrievalListener;
        this.retrievalRepo = new i();
        this.mFirstPosition = -1;
        this.mLastPosition = -1;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>(context, this) { // from class: com.tencent.qqnt.chathistory.ui.dialog.retrieval.RetrievalHelper$rootView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ RetrievalHelper this$0;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/chathistory/ui/dialog/retrieval/RetrievalHelper$rootView$2$a", "Lcom/tencent/qqnt/chathistory/ui/dialog/retrieval/a;", "", "keyword", "", "a", "b", "", "position", "clearHistory", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes23.dex */
            public static final class a implements com.tencent.qqnt.chathistory.ui.dialog.retrieval.a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ RetrievalHelper f353434a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ RecyclerView f353435b;

                a(RetrievalHelper retrievalHelper, RecyclerView recyclerView) {
                    this.f353434a = retrievalHelper;
                    this.f353435b = recyclerView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) retrievalHelper, (Object) recyclerView);
                    }
                }

                @Override // com.tencent.qqnt.chathistory.ui.dialog.retrieval.a
                public void a(@NotNull String keyword) {
                    com.tencent.qqnt.chathistory.ui.dialog.retrieval.b bVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) keyword);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(keyword, "keyword");
                    bVar = this.f353434a.retrievalListener;
                    bVar.a(keyword);
                }

                @Override // com.tencent.qqnt.chathistory.ui.dialog.retrieval.a
                public void b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    this.f353434a.f().a();
                    RecyclerView.Adapter adapter = this.f353435b.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override // com.tencent.qqnt.chathistory.ui.dialog.retrieval.a
                public void clearHistory(@NotNull String keyword, int position) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) keyword, position);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(keyword, "keyword");
                    this.f353434a.f().d(keyword);
                    RecyclerView.Adapter adapter = this.f353435b.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/dialog/retrieval/RetrievalHelper$rootView$2$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes23.dex */
            public static final class b extends RecyclerView.OnScrollListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RetrievalHelper f353436d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ RecyclerView f353437e;

                b(RetrievalHelper retrievalHelper, RecyclerView recyclerView) {
                    this.f353436d = retrievalHelper;
                    this.f353437e = recyclerView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) retrievalHelper, (Object) recyclerView);
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
                    boolean z16;
                    int i3;
                    View view;
                    Map<String, Object> mutableMapOf;
                    int i16;
                    int i17;
                    int i18;
                    View view2;
                    Map<String, Object> mutableMapOf2;
                    View view3;
                    Map<String, Object> mutableMapOf3;
                    int i19;
                    int i26;
                    View view4;
                    Map<String, Object> mutableMapOf4;
                    View view5;
                    Map<String, Object> mutableMapOf5;
                    com.tencent.qqnt.chathistory.ui.dialog.retrieval.b bVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                        return;
                    }
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    super.onScrolled(recyclerView, dx5, dy5);
                    if (dy5 != 0) {
                        bVar = this.f353436d.retrievalListener;
                        bVar.b();
                    }
                    if (this.f353437e.getAdapter() == null) {
                        return;
                    }
                    if (dy5 > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    RecyclerView.LayoutManager layoutManager = this.f353437e.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                    RecyclerView.LayoutManager layoutManager2 = this.f353437e.getLayoutManager();
                    Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    int findFirstVisibleItemPosition2 = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() + this.f353437e.getChildCount();
                    if (findFirstVisibleItemPosition != -1 && findFirstVisibleItemPosition2 != -1) {
                        i3 = this.f353436d.mFirstPosition;
                        if (i3 != -1) {
                            i16 = this.f353436d.mLastPosition;
                            if (i16 != -1) {
                                if (z16) {
                                    i19 = this.f353436d.mFirstPosition;
                                    int i27 = findFirstVisibleItemPosition - i19;
                                    for (int i28 = 0; i28 < i27 && i28 < this.f353437e.getChildCount(); i28++) {
                                        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                                        RecyclerView.LayoutManager layoutManager3 = this.f353437e.getLayoutManager();
                                        if (layoutManager3 != null) {
                                            view5 = layoutManager3.findViewByPosition(i28);
                                        } else {
                                            view5 = null;
                                        }
                                        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("number_search_history_displays", Integer.valueOf(this.f353436d.f().c())));
                                        a16.q(view5, "em_bas_search_history", mutableMapOf5, String.valueOf(i28));
                                    }
                                    i26 = this.f353436d.mLastPosition;
                                    int i29 = findFirstVisibleItemPosition2 - i26;
                                    for (int i36 = 0; i36 < i29 && i36 < this.f353437e.getChildCount(); i36++) {
                                        HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                                        RecyclerView.LayoutManager layoutManager4 = this.f353437e.getLayoutManager();
                                        if (layoutManager4 != null) {
                                            view4 = layoutManager4.findViewByPosition(i36);
                                        } else {
                                            view4 = null;
                                        }
                                        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("number_search_history_displays", Integer.valueOf(this.f353436d.f().c())));
                                        a17.o(view4, "em_bas_search_history", mutableMapOf4, String.valueOf(i36));
                                    }
                                } else {
                                    i17 = this.f353436d.mFirstPosition;
                                    int i37 = i17 - findFirstVisibleItemPosition;
                                    for (int i38 = 0; i38 < i37 && i38 < this.f353437e.getChildCount(); i38++) {
                                        HistoryDtReportHelper a18 = HistoryDtReportHelper.INSTANCE.a();
                                        RecyclerView.LayoutManager layoutManager5 = this.f353437e.getLayoutManager();
                                        if (layoutManager5 != null) {
                                            view3 = layoutManager5.findViewByPosition(i38);
                                        } else {
                                            view3 = null;
                                        }
                                        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("number_search_history_displays", Integer.valueOf(this.f353436d.f().c())));
                                        a18.o(view3, "em_bas_search_history", mutableMapOf3, String.valueOf(i38));
                                    }
                                    i18 = this.f353436d.mLastPosition;
                                    int i39 = i18 - findFirstVisibleItemPosition2;
                                    for (int i46 = 0; i46 < i39 && i46 < this.f353437e.getChildCount(); i46++) {
                                        HistoryDtReportHelper a19 = HistoryDtReportHelper.INSTANCE.a();
                                        RecyclerView.LayoutManager layoutManager6 = this.f353437e.getLayoutManager();
                                        if (layoutManager6 != null) {
                                            view2 = layoutManager6.findViewByPosition(i46);
                                        } else {
                                            view2 = null;
                                        }
                                        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("number_search_history_displays", Integer.valueOf(this.f353436d.f().c())));
                                        a19.q(view2, "em_bas_search_history", mutableMapOf2, String.valueOf(i46));
                                    }
                                }
                                this.f353436d.mFirstPosition = findFirstVisibleItemPosition;
                                this.f353436d.mLastPosition = findFirstVisibleItemPosition2;
                                return;
                            }
                        }
                        this.f353436d.mFirstPosition = findFirstVisibleItemPosition;
                        this.f353436d.mLastPosition = findFirstVisibleItemPosition2;
                        int i47 = findFirstVisibleItemPosition2 - findFirstVisibleItemPosition;
                        for (int i48 = 0; i48 < i47 && i48 < this.f353437e.getChildCount(); i48++) {
                            HistoryDtReportHelper a26 = HistoryDtReportHelper.INSTANCE.a();
                            RecyclerView.LayoutManager layoutManager7 = this.f353437e.getLayoutManager();
                            if (layoutManager7 != null) {
                                view = layoutManager7.findViewByPosition(i48);
                            } else {
                                view = null;
                            }
                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("number_search_history_displays", Integer.valueOf(this.f353436d.f().c())));
                            a26.o(view, "em_bas_search_history", mutableMapOf, String.valueOf(i48));
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) this);
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
                RecyclerView recyclerView = new RecyclerView(this.$context);
                Context context2 = this.$context;
                RetrievalHelper retrievalHelper = this.this$0;
                recyclerView.setLayoutManager(new LinearLayoutManager(context2));
                recyclerView.setAdapter(new f(retrievalHelper.f(), new a(retrievalHelper, recyclerView)));
                recyclerView.setOverScrollMode(2);
                recyclerView.addOnScrollListener(new b(retrievalHelper, recyclerView));
                return recyclerView;
            }
        });
        this.rootView = lazy;
    }

    @NotNull
    public final i f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (i) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.retrievalRepo;
    }

    @NotNull
    public final RecyclerView g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (RecyclerView) this.rootView.getValue();
    }

    public final void h(@NotNull String searchWord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) searchWord);
            return;
        }
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        this.retrievalRepo.e(searchWord);
        RecyclerView.Adapter adapter = g().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
