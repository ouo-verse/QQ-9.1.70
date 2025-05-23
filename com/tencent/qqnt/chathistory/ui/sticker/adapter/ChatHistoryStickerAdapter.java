package com.tencent.qqnt.chathistory.ui.sticker.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi;
import com.tencent.qqnt.chathistory.ui.base.TailDefaultItemModel;
import com.tencent.qqnt.chathistory.ui.base.g;
import com.tencent.qqnt.chathistory.ui.base.l;
import com.tencent.qqnt.chathistory.ui.base.n;
import com.tencent.qqnt.chathistory.ui.base.o;
import com.tencent.qqnt.chathistory.ui.base.r;
import com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.chathistory.x2k.u;
import com.tencent.qqnt.expandRecyclerView.adapter.provider.b;
import com.tencent.qqnt.expandRecyclerView.adapter.provider.c;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0002LMBQ\u0012\u0006\u00107\u001a\u000204\u0012\b\b\u0002\u0010:\u001a\u00020'\u00126\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r0\u001c\u00a2\u0006\u0004\bI\u0010JJ\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J2\u0010\u000f\u001a\u00020\u00072'\b\u0002\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\tH\u0096\u0001J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0096\u0001J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010H\u0096\u0001J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H\u0096\u0001J2\u0010\u0016\u001a\u00020\r2'\b\u0002\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\tH\u0096\u0001Jq\u0010$\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000326\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r0\u001c2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0096\u0001J\u001e\u0010)\u001a\u00020'2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00102\u0006\u0010(\u001a\u00020'H\u0014J\b\u0010+\u001a\u0004\u0018\u00010*J\b\u0010-\u001a\u0004\u0018\u00010,J$\u00103\u001a\u00020\r2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\f\u00102\u001a\b\u0012\u0004\u0012\u00020,0\u0010R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109RG\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b9\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010H\u001a\u00020\u00078\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u00a8\u0006N"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/adapter/ChatHistoryStickerAdapter;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cb", "", "msgId", "", "V0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "choose", "", "callBack", "W0", "", "b1", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "c1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d1", "g1", "Landroid/view/View;", "itemView", "msgRecord", "msgItemModel", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Lkotlin/Function2;", "isEnabled", "isFavEnabled", "setBottomBarState", "Landroid/view/View$OnClickListener;", "listener", "", "elementId", "h1", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "data", "", "position", "o0", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/model/a;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/qqnt/chathistory/ui/sticker/data/model/SearchStickerItemModel;", "Z0", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "itemModelList", "f1", "Lkotlinx/coroutines/CoroutineScope;", "G", "Lkotlinx/coroutines/CoroutineScope;", "scope", "H", "I", "source", "Lkotlin/jvm/functions/Function2;", "e1", "()Lkotlin/jvm/functions/Function2;", "Landroid/graphics/drawable/ColorDrawable;", "K", "Lkotlin/Lazy;", "Y0", "()Landroid/graphics/drawable/ColorDrawable;", "defaultDrawable", "X0", "()Z", "setChooseModel", "(Z)V", "chooseModel", "<init>", "(Lkotlinx/coroutines/CoroutineScope;ILkotlin/jvm/functions/Function2;)V", "L", "a", "ContentItemProvider", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryStickerAdapter extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: H, reason: from kotlin metadata */
    private final int source;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Function2<Boolean, Boolean, Unit> setBottomBarState;
    private final /* synthetic */ l J;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/adapter/ChatHistoryStickerAdapter$ContentItemProvider;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "helper", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", DomainData.DOMAIN_NAME, "", "f", "()I", "itemViewType", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/sticker/adapter/ChatHistoryStickerAdapter;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class ContentItemProvider extends c {
        static IPatchRedirector $redirector_;

        public ContentItemProvider() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerAdapter.this);
            }
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        @NotNull
        public View c(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new u(context, null, 2, null).getRoot();
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        public int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return 1;
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void b(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a helper, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b item, @NotNull List<? extends Object> payloads) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, helper, item, payloads);
                return;
            }
            Intrinsics.checkNotNullParameter(helper, "helper");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            ImageView imageView = (ImageView) helper.getView(R.id.y9u);
            final QUICheckBox qUICheckBox = (QUICheckBox) helper.getView(R.id.fqa);
            qUICheckBox.setClickable(false);
            ChatHistoryStickerAdapter$ContentItemProvider$convert$1 chatHistoryStickerAdapter$ContentItemProvider$convert$1 = new ChatHistoryStickerAdapter$ContentItemProvider$convert$1(imageView, ChatHistoryStickerAdapter.this, helper, qUICheckBox);
            final ChatHistoryStickerAdapter chatHistoryStickerAdapter = ChatHistoryStickerAdapter.this;
            ExtensionsKt.b(this, item, payloads, chatHistoryStickerAdapter$ContentItemProvider$convert$1, new Function3<c, SearchStickerItemModel, i, Unit>(qUICheckBox) { // from class: com.tencent.qqnt.chathistory.ui.sticker.adapter.ChatHistoryStickerAdapter$ContentItemProvider$convert$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUICheckBox $checkView;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$checkView = qUICheckBox;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryStickerAdapter.this, (Object) qUICheckBox);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(c cVar, SearchStickerItemModel searchStickerItemModel, i iVar) {
                    invoke2(cVar, searchStickerItemModel, iVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull c cast, @NotNull SearchStickerItemModel data, @NotNull i map) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, cast, data, map);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(cast, "$this$cast");
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(map, "map");
                    if (((o) map.a(o.class)) != null) {
                        ChatHistoryStickerAdapter.this.V0(this.$checkView, data.j());
                    }
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/sticker/adapter/ChatHistoryStickerAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.sticker.adapter.ChatHistoryStickerAdapter$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50197);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryStickerAdapter(@NotNull CoroutineScope scope, int i3, @NotNull Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState) {
        super(null, 1, 0 == true ? 1 : 0);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scope, Integer.valueOf(i3), setBottomBarState);
            return;
        }
        this.scope = scope;
        this.source = i3;
        this.setBottomBarState = setBottomBarState;
        this.J = new l();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) ChatHistoryStickerAdapter$defaultDrawable$2.INSTANCE);
        this.defaultDrawable = lazy;
        F0(new n());
        F0(new g());
        F0(new r());
        k0(new ContentItemProvider());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ColorDrawable Y0() {
        return (ColorDrawable) this.defaultDrawable.getValue();
    }

    public boolean V0(@NotNull QUICheckBox cb5, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, cb5, Long.valueOf(msgId))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        return this.J.c(cb5, msgId);
    }

    public boolean W0(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) callBack)).booleanValue();
        }
        return this.J.d(callBack);
    }

    public boolean X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.J.f();
    }

    @Nullable
    public final SearchStickerItemModel Z0() {
        boolean z16;
        Object lastOrNull;
        com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar;
        List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b16;
        Object lastOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (SearchStickerItemModel) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> m06 = m0();
        if (m06 != null && !m06.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) m0());
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar2 = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) lastOrNull;
            if (bVar2 instanceof SearchStickerItemModel) {
                return (SearchStickerItemModel) bVar2;
            }
            if (bVar2 != null && (b16 = bVar2.b()) != null) {
                lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) b16);
                bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) lastOrNull2;
            } else {
                bVar = null;
            }
            if (!(bVar instanceof SearchStickerItemModel)) {
                return null;
            }
            return (SearchStickerItemModel) bVar;
        }
        return null;
    }

    @Nullable
    public final com.tencent.qqnt.chathistory.ui.sticker.data.model.a a1() {
        boolean z16;
        Object last;
        SearchStickerItemModel searchStickerItemModel;
        com.tencent.qqnt.chathistory.ui.base.i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.qqnt.chathistory.ui.sticker.data.model.a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> m06 = m0();
        if (m06 != null && !m06.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        com.tencent.qqnt.chathistory.ui.sticker.data.model.a aVar = null;
        if (!z16) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) m0());
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) last;
            if (bVar instanceof com.tencent.qqnt.chathistory.ui.sticker.data.model.a) {
                return (com.tencent.qqnt.chathistory.ui.sticker.data.model.a) bVar;
            }
            if (bVar instanceof SearchStickerItemModel) {
                searchStickerItemModel = (SearchStickerItemModel) bVar;
            } else {
                searchStickerItemModel = null;
            }
            if (searchStickerItemModel != null) {
                iVar = searchStickerItemModel.d();
            } else {
                iVar = null;
            }
            if (iVar instanceof com.tencent.qqnt.chathistory.ui.sticker.data.model.a) {
                aVar = (com.tencent.qqnt.chathistory.ui.sticker.data.model.a) iVar;
            }
            if (aVar == null) {
                d.f354054a.a("ChatHistoryStickerAdapter", "getLastParentNode return model = " + bVar);
            }
            return aVar;
        }
        return null;
    }

    @NotNull
    public List<Long> b1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.J.g();
    }

    @NotNull
    public List<com.tencent.qqnt.chathistory.ui.base.item.b> c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.J.h();
    }

    @NotNull
    public List<MsgRecord> d1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.J.i();
    }

    @NotNull
    public final Function2<Boolean, Boolean, Unit> e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.setBottomBarState;
    }

    public final void f1(@NotNull Activity activity, @NotNull Context context, @NotNull List<SearchStickerItemModel> itemModelList) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, activity, context, itemModelList);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemModelList, "itemModelList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : itemModelList) {
            if (!((SearchStickerItemModel) obj).p()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            QQToast.makeText(context, context.getString(R.string.zkt), 0).show();
        }
        IChatHistoryMultiActionApi iChatHistoryMultiActionApi = (IChatHistoryMultiActionApi) QRoute.api(IChatHistoryMultiActionApi.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((SearchStickerItemModel) it.next()).m());
        }
        iChatHistoryMultiActionApi.saveMedia(activity, arrayList2);
    }

    public void g1(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) callBack);
        } else {
            this.J.k(callBack);
        }
    }

    public void h1(@NotNull View itemView, @NotNull MsgRecord msgRecord, @NotNull com.tencent.qqnt.chathistory.ui.base.item.b msgItemModel, @NotNull QUICheckBox checkbox, @NotNull Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState, @NotNull View.OnClickListener listener, @NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, itemView, msgRecord, msgItemModel, checkbox, setBottomBarState, listener, elementId);
            return;
        }
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgItemModel, "msgItemModel");
        Intrinsics.checkNotNullParameter(checkbox, "checkbox");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        this.J.m(itemView, msgRecord, msgItemModel, checkbox, setBottomBarState, listener, elementId);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    protected int o0(@NotNull List<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> data, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) data, position)).intValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = data.get(position);
        if (bVar instanceof com.tencent.qqnt.chathistory.ui.sticker.data.model.a) {
            return 0;
        }
        if (bVar instanceof SearchStickerItemModel) {
            return 1;
        }
        if (bVar instanceof TailDefaultItemModel) {
            return 100;
        }
        throw new IllegalArgumentException("illegal data " + data.get(position) + "]");
    }
}
