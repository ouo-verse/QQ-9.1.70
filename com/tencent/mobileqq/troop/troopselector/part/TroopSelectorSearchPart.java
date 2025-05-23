package com.tencent.mobileqq.troop.troopselector.part;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.model.k;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorVM;
import com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart;
import com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart$onActionListener$2;
import com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart$searchBarActionCallback$2;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.ext.ChatUserListExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001(\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R!\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u00100R\u001b\u00106\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/part/TroopSelectorSearchPart;", "Lcom/tencent/mobileqq/troop/troopselector/part/a;", "", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "d", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "e", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "quiSearchBar", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "searchResultLayout", "Lcom/tencent/mobileqq/search/view/f;", h.F, "Lcom/tencent/mobileqq/search/view/f;", "searchFragment", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "M9", "()Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorVM;", "vm", "Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt$BaseChatExtAdapter;", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt$BaseChatExtAdapter;", "selectedListAdapterForSearchBar", "Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt;", BdhLogUtil.LogTag.Tag_Conn, "L9", "()Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt;", "selectedListForSearchBar", "com/tencent/mobileqq/troop/troopselector/part/TroopSelectorSearchPart$onActionListener$2$a", "D", "I9", "()Lcom/tencent/mobileqq/troop/troopselector/part/TroopSelectorSearchPart$onActionListener$2$a;", "onActionListener", "Landroid/view/View$OnFocusChangeListener;", "E", "K9", "()Landroid/view/View$OnFocusChangeListener;", "searchBarFocusChangeListener", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", UserInfo.SEX_FEMALE, "J9", "()Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "searchBarActionCallback", "<init>", "(Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopSelectorSearchPart extends com.tencent.mobileqq.troop.troopselector.part.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy selectedListForSearchBar;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy onActionListener;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy searchBarFocusChangeListener;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy searchBarActionCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TroopSelectorConfig config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISearchBar quiSearchBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout searchResultLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.search.view.f searchFragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy vm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ChatUserListExt.BaseChatExtAdapter<SharedNode> selectedListAdapterForSearchBar;

    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/troop/troopselector/part/TroopSelectorSearchPart$a", "Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt$BaseChatExtAdapter;", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "Lcom/tencent/mobileqq/widget/search/ext/ChatUserListExt$ViewHolder;", "viewHolder", "", com.tencent.luggage.wxa.c8.c.G, "data", "", "j0", "", "l0", "Landroid/content/Context;", "context", "Landroid/view/View;", "createIconView", "", "tryGrayItemOrDelete", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ChatUserListExt.BaseChatExtAdapter<SharedNode> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k0(SharedNode data, View view) {
            Intrinsics.checkNotNullParameter(data, "$data");
            com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.c(data);
        }

        @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
        protected View createIconView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new QQProAvatarView(context, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void bindViewHolder(ChatUserListExt.ViewHolder viewHolder, int pos, final SharedNode data) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(data, "data");
            viewHolder.tvName.setVisibility(8);
            View view = viewHolder.ivIcon;
            QQProAvatarView qQProAvatarView = view instanceof QQProAvatarView ? (QQProAvatarView) view : null;
            if (qQProAvatarView != null) {
                qQProAvatarView.w(4, data.getKey());
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopselector.part.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TroopSelectorSearchPart.a.k0(SharedNode.this, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public String getDesc(SharedNode data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return data.getTitle();
        }

        @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
        public boolean tryGrayItemOrDelete() {
            SharedNode item = getItemCount() > 0 ? getItem(getItemCount() - 1) : null;
            boolean z16 = this.mIsInDel;
            boolean tryGrayItemOrDelete = super.tryGrayItemOrDelete();
            if (item != null && z16 && tryGrayItemOrDelete) {
                com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.c(item);
            }
            return tryGrayItemOrDelete;
        }
    }

    public TroopSelectorSearchPart(TroopSelectorConfig troopSelectorConfig) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        this.config = troopSelectorConfig;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectorVM>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopSelectorVM invoke() {
                return (TroopSelectorVM) TroopSelectorSearchPart.this.getViewModel(TroopSelectorVM.class);
            }
        });
        this.vm = lazy;
        this.selectedListAdapterForSearchBar = new a();
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ChatUserListExt<SharedNode>>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart$selectedListForSearchBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ChatUserListExt<SharedNode> invoke() {
                QUISearchBar qUISearchBar;
                ChatUserListExt.BaseChatExtAdapter<SharedNode> baseChatExtAdapter;
                qUISearchBar = TroopSelectorSearchPart.this.quiSearchBar;
                if (qUISearchBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("quiSearchBar");
                    qUISearchBar = null;
                }
                ChatUserListExt<SharedNode> chatUserListExt = new ChatUserListExt<>(qUISearchBar);
                baseChatExtAdapter = TroopSelectorSearchPart.this.selectedListAdapterForSearchBar;
                chatUserListExt.setAdapter(baseChatExtAdapter);
                return chatUserListExt;
            }
        });
        this.selectedListForSearchBar = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectorSearchPart$onActionListener$2.a>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart$onActionListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(TroopSelectorSearchPart.this);
            }

            @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopselector/part/TroopSelectorSearchPart$onActionListener$2$a", "Lcom/tencent/mobileqq/search/view/d;", "Landroid/view/View;", "view", "", "onAction", "", "uin", "", "type", "", "isSelect", "selectedItemClick", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements com.tencent.mobileqq.search.view.d {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TroopSelectorSearchPart f301045d;

                a(TroopSelectorSearchPart troopSelectorSearchPart) {
                    this.f301045d = troopSelectorSearchPart;
                }

                @Override // com.tencent.mobileqq.search.view.d
                public void selectedItemClick(String uin, int type, boolean isSelect) {
                    TroopSelectorConfig troopSelectorConfig;
                    Intrinsics.checkNotNullParameter(uin, "uin");
                    troopSelectorConfig = this.f301045d.config;
                    boolean z16 = false;
                    if (troopSelectorConfig != null && troopSelectorConfig.e()) {
                        z16 = true;
                    }
                    if (z16) {
                        com.tencent.mobileqq.selectfriend.relationlist.e.f285562a.c(st2.b.f434715a.c(uin));
                    }
                }

                @Override // com.tencent.mobileqq.search.view.d
                public void onAction(View view) {
                    TroopSelectorConfig troopSelectorConfig;
                    TroopSelectorVM M9;
                    Object tag = view != null ? view.getTag(R.id.kxb) : null;
                    k kVar = tag instanceof k ? (k) tag : null;
                    if (kVar == null) {
                        return;
                    }
                    troopSelectorConfig = this.f301045d.config;
                    boolean z16 = false;
                    if (troopSelectorConfig != null && troopSelectorConfig.e()) {
                        z16 = true;
                    }
                    if (!z16) {
                        M9 = this.f301045d.M9();
                        st2.b bVar = st2.b.f434715a;
                        String l3 = kVar.l();
                        Intrinsics.checkNotNullExpressionValue(l3, "model.uin");
                        M9.b2(bVar.c(l3));
                        return;
                    }
                    com.tencent.mobileqq.selectfriend.relationlist.e eVar = com.tencent.mobileqq.selectfriend.relationlist.e.f285562a;
                    st2.b bVar2 = st2.b.f434715a;
                    String l16 = kVar.l();
                    Intrinsics.checkNotNullExpressionValue(l16, "model.uin");
                    eVar.c(bVar2.c(l16));
                }
            }
        });
        this.onActionListener = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new TroopSelectorSearchPart$searchBarFocusChangeListener$2(this));
        this.searchBarFocusChangeListener = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectorSearchPart$searchBarActionCallback$2.a>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart$searchBarActionCallback$2

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/troopselector/part/TroopSelectorSearchPart$searchBarActionCallback$2$a", "Lcom/tencent/mobileqq/widget/search/ActionCallbackAdapter;", "", "onSearch", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a extends ActionCallbackAdapter {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ TroopSelectorSearchPart f301046a;

                a(TroopSelectorSearchPart troopSelectorSearchPart) {
                    this.f301046a = troopSelectorSearchPart;
                }

                @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
                public void onSearch() {
                    QUISearchBar qUISearchBar;
                    com.tencent.mobileqq.search.view.f fVar;
                    FrameLayout frameLayout;
                    FrameLayout frameLayout2;
                    qUISearchBar = this.f301046a.quiSearchBar;
                    FrameLayout frameLayout3 = null;
                    if (qUISearchBar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("quiSearchBar");
                        qUISearchBar = null;
                    }
                    QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
                    String valueOf = String.valueOf(inputWidget != null ? inputWidget.getText() : null);
                    if (TextUtils.isEmpty(valueOf)) {
                        frameLayout2 = this.f301046a.searchResultLayout;
                        if (frameLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("searchResultLayout");
                        } else {
                            frameLayout3 = frameLayout2;
                        }
                        frameLayout3.setVisibility(8);
                        return;
                    }
                    fVar = this.f301046a.searchFragment;
                    if (fVar != null) {
                        fVar.startSearch(valueOf);
                    }
                    frameLayout = this.f301046a.searchResultLayout;
                    if (frameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchResultLayout");
                    } else {
                        frameLayout3 = frameLayout;
                    }
                    frameLayout3.setVisibility(0);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(TroopSelectorSearchPart.this);
            }
        });
        this.searchBarActionCallback = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectorSearchPart$onActionListener$2.a I9() {
        return (TroopSelectorSearchPart$onActionListener$2.a) this.onActionListener.getValue();
    }

    private final QUISearchBar.ActionCallback J9() {
        return (QUISearchBar.ActionCallback) this.searchBarActionCallback.getValue();
    }

    private final View.OnFocusChangeListener K9() {
        return (View.OnFocusChangeListener) this.searchBarFocusChangeListener.getValue();
    }

    private final ChatUserListExt<SharedNode> L9() {
        return (ChatUserListExt) this.selectedListForSearchBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectorVM M9() {
        return (TroopSelectorVM) this.vm.getValue();
    }

    private final void N9() {
        QUISearchBar qUISearchBar = this.quiSearchBar;
        QUISearchBar qUISearchBar2 = null;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSearchBar");
            qUISearchBar = null;
        }
        qUISearchBar.setActionCallback(J9());
        QUISearchBar qUISearchBar3 = this.quiSearchBar;
        if (qUISearchBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSearchBar");
            qUISearchBar3 = null;
        }
        qUISearchBar3.setSearchMode(1);
        QUISearchBar qUISearchBar4 = this.quiSearchBar;
        if (qUISearchBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quiSearchBar");
            qUISearchBar4 = null;
        }
        qUISearchBar4.getInputWidget().setOnFocusChangeListener(K9());
        TroopSelectorConfig troopSelectorConfig = this.config;
        if (troopSelectorConfig != null && troopSelectorConfig.e()) {
            QUISearchBar qUISearchBar5 = this.quiSearchBar;
            if (qUISearchBar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quiSearchBar");
            } else {
                qUISearchBar2 = qUISearchBar5;
            }
            qUISearchBar2.setSearchBarLayoutExt(L9());
            LifecycleOwner viewLifecycleOwner = getPartHost().getViewLifecycleOwner();
            LiveData<ArrayList<SharedNode>> S1 = M9().S1();
            final Function1<ArrayList<SharedNode>, Unit> function1 = new Function1<ArrayList<SharedNode>, Unit>() { // from class: com.tencent.mobileqq.troop.troopselector.part.TroopSelectorSearchPart$setSearchBarConfig$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<SharedNode> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ArrayList<SharedNode> it) {
                    ChatUserListExt.BaseChatExtAdapter baseChatExtAdapter;
                    com.tencent.mobileqq.search.view.f fVar;
                    List<String> emptyList;
                    baseChatExtAdapter = TroopSelectorSearchPart.this.selectedListAdapterForSearchBar;
                    baseChatExtAdapter.updateData(it);
                    ArrayList arrayList = new ArrayList();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Iterator<T> it5 = it.iterator();
                    while (it5.hasNext()) {
                        arrayList.add(((SharedNode) it5.next()).getKey());
                    }
                    fVar = TroopSelectorSearchPart.this.searchFragment;
                    if (fVar != null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        fVar.B5(arrayList, emptyList);
                    }
                }
            };
            S1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopselector.part.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopSelectorSearchPart.O9(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.imi);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026.selected_and_search_bar)");
            this.quiSearchBar = (QUISearchBar) findViewById;
            View findViewById2 = rootView.findViewById(R.id.result_layout);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.result_layout)");
            this.searchResultLayout = (FrameLayout) findViewById2;
            N9();
            QUISearchBar qUISearchBar = this.quiSearchBar;
            if (qUISearchBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quiSearchBar");
                qUISearchBar = null;
            }
            qUISearchBar.fixedKeyboardBugOnAndroid678();
        }
    }
}
