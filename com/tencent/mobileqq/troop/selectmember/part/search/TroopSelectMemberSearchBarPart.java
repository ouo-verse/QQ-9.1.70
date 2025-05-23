package com.tencent.mobileqq.troop.selectmember.part.search;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.troop.selectmember.part.search.TroopSelectMemberSearchBarPart$searchBarActionCallback$2;
import com.tencent.mobileqq.troop.selectmember.part.search.h;
import com.tencent.mobileqq.troop.troopsetting.part.i;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.ext.ChatUserListExt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\u0013\u001a\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/search/TroopSelectMemberSearchBarPart;", "Lcom/tencent/mobileqq/troop/selectmember/part/a;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "searchBar", "", "N9", "Y9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "f", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "Landroid/widget/FrameLayout;", tl.h.F, "Landroid/widget/FrameLayout;", "searchResultLayout", "", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "R9", "()Ljava/lang/String;", "canNotSelectText", "Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt;", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "V9", "()Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt;", "selectedList", "Lcom/tencent/mobileqq/troop/selectmember/part/search/h;", BdhLogUtil.LogTag.Tag_Conn, "W9", "()Lcom/tencent/mobileqq/troop/selectmember/part/search/h;", "selectedListAdapter", "Lcom/tencent/mobileqq/search/view/f;", "D", "Lcom/tencent/mobileqq/search/view/f;", "searchFragment", "Landroid/view/View$OnFocusChangeListener;", "E", "U9", "()Landroid/view/View$OnFocusChangeListener;", "searchBarFocusChangeListener", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", UserInfo.SEX_FEMALE, "T9", "()Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "searchBarActionCallback", "Lcom/tencent/mobileqq/search/view/d;", "G", "S9", "()Lcom/tencent/mobileqq/search/view/d;", "contactActionListener", "<init>", "()V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberSearchBarPart extends com.tencent.mobileqq.troop.selectmember.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedListAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.search.view.f searchFragment;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchBarFocusChangeListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchBarActionCallback;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy contactActionListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUISearchBar searchBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout searchResultLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy canNotSelectText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/part/search/TroopSelectMemberSearchBarPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.part.search.TroopSelectMemberSearchBarPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54990);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberSearchBarPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopSelectMemberSearchBarPart$canNotSelectText$2.INSTANCE);
            this.canNotSelectText = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ChatUserListExt<com.tencent.mobileqq.troop.selectmember.bean.c>>() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.TroopSelectMemberSearchBarPart$selectedList$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberSearchBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ChatUserListExt<com.tencent.mobileqq.troop.selectmember.bean.c> invoke() {
                    QUISearchBar qUISearchBar;
                    h W9;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ChatUserListExt) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    qUISearchBar = TroopSelectMemberSearchBarPart.this.searchBar;
                    if (qUISearchBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                        qUISearchBar = null;
                    }
                    ChatUserListExt<com.tencent.mobileqq.troop.selectmember.bean.c> chatUserListExt = new ChatUserListExt<>(qUISearchBar);
                    W9 = TroopSelectMemberSearchBarPart.this.W9();
                    chatUserListExt.setAdapter(W9);
                    return chatUserListExt;
                }
            });
            this.selectedList = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.TroopSelectMemberSearchBarPart$selectedListAdapter$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/selectmember/part/search/TroopSelectMemberSearchBarPart$selectedListAdapter$2$a", "Lcom/tencent/mobileqq/troop/selectmember/part/search/h$a;", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "itemData", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes19.dex */
                public static final class a implements h.a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ TroopSelectMemberSearchBarPart f298404a;

                    a(TroopSelectMemberSearchBarPart troopSelectMemberSearchBarPart) {
                        this.f298404a = troopSelectMemberSearchBarPart;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSelectMemberSearchBarPart);
                        }
                    }

                    @Override // com.tencent.mobileqq.troop.selectmember.part.search.h.a
                    public void a(@NotNull com.tencent.mobileqq.troop.selectmember.bean.c itemData) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemData);
                        } else {
                            Intrinsics.checkNotNullParameter(itemData, "itemData");
                            this.f298404a.z9().C2(itemData);
                        }
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberSearchBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final h invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (h) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    h hVar = new h();
                    hVar.m0(new a(TroopSelectMemberSearchBarPart.this));
                    return hVar;
                }
            });
            this.selectedListAdapter = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new TroopSelectMemberSearchBarPart$searchBarFocusChangeListener$2(this));
            this.searchBarFocusChangeListener = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectMemberSearchBarPart$searchBarActionCallback$2.a>() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.TroopSelectMemberSearchBarPart$searchBarActionCallback$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/selectmember/part/search/TroopSelectMemberSearchBarPart$searchBarActionCallback$2$a", "Lcom/tencent/mobileqq/widget/search/ActionCallbackAdapter;", "", "onSearch", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes19.dex */
                public static final class a extends ActionCallbackAdapter {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ TroopSelectMemberSearchBarPart f298403a;

                    a(TroopSelectMemberSearchBarPart troopSelectMemberSearchBarPart) {
                        this.f298403a = troopSelectMemberSearchBarPart;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSelectMemberSearchBarPart);
                        }
                    }

                    @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
                    public void onSearch() {
                        QUISearchBar qUISearchBar;
                        Editable editable;
                        com.tencent.mobileqq.search.view.f fVar;
                        FrameLayout frameLayout;
                        FrameLayout frameLayout2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            qUISearchBar = this.f298403a.searchBar;
                            FrameLayout frameLayout3 = null;
                            if (qUISearchBar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                                qUISearchBar = null;
                            }
                            QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
                            if (inputWidget != null) {
                                editable = inputWidget.getText();
                            } else {
                                editable = null;
                            }
                            String valueOf = String.valueOf(editable);
                            if (TextUtils.isEmpty(valueOf)) {
                                frameLayout2 = this.f298403a.searchResultLayout;
                                if (frameLayout2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("searchResultLayout");
                                } else {
                                    frameLayout3 = frameLayout2;
                                }
                                frameLayout3.setVisibility(8);
                                return;
                            }
                            fVar = this.f298403a.searchFragment;
                            if (fVar != null) {
                                fVar.startSearch(valueOf);
                            }
                            frameLayout = this.f298403a.searchResultLayout;
                            if (frameLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("searchResultLayout");
                            } else {
                                frameLayout3 = frameLayout;
                            }
                            frameLayout3.setVisibility(0);
                            return;
                        }
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberSearchBarPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopSelectMemberSearchBarPart.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.searchBarActionCallback = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(new TroopSelectMemberSearchBarPart$contactActionListener$2(this));
            this.contactActionListener = lazy6;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void N9(final QUISearchBar searchBar) {
        searchBar.setActionCallback(T9());
        searchBar.setSearchMode(1);
        searchBar.getInputWidget().setOnFocusChangeListener(U9());
        searchBar.setSearchBarLayoutExt(V9());
        LifecycleOwner a16 = i.a(this);
        if (a16 != null) {
            LiveData<List<com.tencent.mobileqq.troop.selectmember.bean.c>> P = z9().P();
            final Function1<List<? extends com.tencent.mobileqq.troop.selectmember.bean.c>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.troop.selectmember.bean.c>, Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.TroopSelectMemberSearchBarPart$configSearchBar$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberSearchBarPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.troop.selectmember.bean.c> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends com.tencent.mobileqq.troop.selectmember.bean.c> list) {
                    h W9;
                    com.tencent.mobileqq.search.view.f fVar;
                    int collectionSizeOrDefault;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(list);
                    W9 = TroopSelectMemberSearchBarPart.this.W9();
                    W9.updateData(arrayList);
                    fVar = TroopSelectMemberSearchBarPart.this.searchFragment;
                    if (fVar != null) {
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(((com.tencent.mobileqq.troop.selectmember.bean.c) it.next()).e());
                        }
                        fVar.B5(arrayList2, new ArrayList());
                    }
                }
            };
            P.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberSearchBarPart.O9(Function1.this, obj);
                }
            });
            LiveData<Integer> l26 = z9().l2();
            final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.TroopSelectMemberSearchBarPart$configSearchBar$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUISearchBar.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    QuickPinyinEditText inputWidget = QUISearchBar.this.getInputWidget();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    inputWidget.setEnabled(it.intValue() >= 100);
                }
            };
            l26.observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberSearchBarPart.P9(Function1.this, obj);
                }
            });
            z9().h2().observe(a16, new Observer() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectMemberSearchBarPart.Q9(TroopSelectMemberSearchBarPart.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(TroopSelectMemberSearchBarPart this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("TroopSelectMemberFrag.SearchBarPart", 2, "[configSearchBar] deleteMemberEvent");
        }
        this$0.Y9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String R9() {
        return (String) this.canNotSelectText.getValue();
    }

    private final com.tencent.mobileqq.search.view.d S9() {
        return (com.tencent.mobileqq.search.view.d) this.contactActionListener.getValue();
    }

    private final QUISearchBar.ActionCallback T9() {
        return (QUISearchBar.ActionCallback) this.searchBarActionCallback.getValue();
    }

    private final View.OnFocusChangeListener U9() {
        return (View.OnFocusChangeListener) this.searchBarFocusChangeListener.getValue();
    }

    private final ChatUserListExt<com.tencent.mobileqq.troop.selectmember.bean.c> V9() {
        return (ChatUserListExt) this.selectedList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h W9() {
        return (h) this.selectedListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(TroopSelectMemberSearchBarPart this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i17 != i27) {
            this$0.V9().onLayoutChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        int collectionSizeOrDefault;
        com.tencent.mobileqq.search.view.f createNTContactSearchFragment = ((ISearchViewCreator) QRoute.api(ISearchViewCreator.class)).createNTContactSearchFragment(x9().g(), 8192, x9().q(), z9().p2(), false, 0, -1L, S9(), false, null);
        if (createNTContactSearchFragment != null) {
            List<com.tencent.mobileqq.troop.selectmember.bean.c> value = z9().P().getValue();
            if (value != null) {
                List<com.tencent.mobileqq.troop.selectmember.bean.c> list = value;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((com.tencent.mobileqq.troop.selectmember.bean.c) it.next()).e());
                }
                createNTContactSearchFragment.B5(arrayList, new ArrayList());
            }
            FragmentManager supportFragmentManager = A9().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            com.tencent.mobileqq.search.view.f fVar = this.searchFragment;
            if (fVar != null) {
                beginTransaction.remove(fVar.getFragment());
            }
            beginTransaction.add(R.id.f81164df, createNTContactSearchFragment.getFragment());
            beginTransaction.commitAllowingStateLoss();
            this.searchFragment = createNTContactSearchFragment;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.imi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.selected_and_search_bar)");
        this.searchBar = (QUISearchBar) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f81164df);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.search_result_layout)");
        this.searchResultLayout = (FrameLayout) findViewById2;
        QUISearchBar qUISearchBar = null;
        if (x9().m()) {
            QUISearchBar qUISearchBar2 = this.searchBar;
            if (qUISearchBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar2 = null;
            }
            N9(qUISearchBar2);
            QUISearchBar qUISearchBar3 = this.searchBar;
            if (qUISearchBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar3 = null;
            }
            qUISearchBar3.setVisibility(0);
        } else {
            QUISearchBar qUISearchBar4 = this.searchBar;
            if (qUISearchBar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                qUISearchBar4 = null;
            }
            qUISearchBar4.setVisibility(8);
        }
        QUISearchBar qUISearchBar5 = this.searchBar;
        if (qUISearchBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            qUISearchBar5 = null;
        }
        qUISearchBar5.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.troop.selectmember.part.search.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                TroopSelectMemberSearchBarPart.X9(TroopSelectMemberSearchBarPart.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        QUISearchBar qUISearchBar6 = this.searchBar;
        if (qUISearchBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        } else {
            qUISearchBar = qUISearchBar6;
        }
        qUISearchBar.fixedKeyboardBugOnAndroid678();
    }
}
