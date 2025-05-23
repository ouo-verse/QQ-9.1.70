package com.tencent.qqnt.chathistory.ui.link.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chathistory.ui.base.g;
import com.tencent.qqnt.chathistory.ui.base.l;
import com.tencent.qqnt.chathistory.ui.base.n;
import com.tencent.qqnt.chathistory.ui.base.o;
import com.tencent.qqnt.chathistory.ui.link.viewmodel.ChatHistoryLinkViewModel;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.chathistory.x2k.e;
import com.tencent.qqnt.expandRecyclerView.adapter.provider.c;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002CDBW\u0012\u0006\u0010/\u001a\u00020*\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010!\u001a\u000204\u00126\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r0\u001c\u00a2\u0006\u0004\b@\u0010AJ\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J2\u0010\u000f\u001a\u00020\u00072'\b\u0002\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\tH\u0096\u0001J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0096\u0001J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010H\u0096\u0001J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010H\u0096\u0001J2\u0010\u0016\u001a\u00020\r2'\b\u0002\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\tH\u0096\u0001Jq\u0010$\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u000326\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r0\u001c2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0096\u0001J\u001e\u0010)\u001a\u00020'2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00102\u0006\u0010(\u001a\u00020'H\u0014R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u0010!\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106RG\u0010\u001f\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r0\u001c8\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001c\u0010?\u001a\u00020\u00078\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/adapter/ChatHistoryLinkAdapter;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cb", "", "msgId", "", "U0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "choose", "", "callBack", "V0", "", "X0", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "Y0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Z0", "c1", "Landroid/view/View;", "itemView", "msgRecord", "msgItemModel", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Lkotlin/Function2;", "isEnabled", "isFavEnabled", "setBottomBarState", "Landroid/view/View$OnClickListener;", "listener", "", "elementId", "d1", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "data", "", "position", "o0", "Lkotlinx/coroutines/CoroutineScope;", "G", "Lkotlinx/coroutines/CoroutineScope;", ICustomDataEditor.STRING_ARRAY_PARAM_1, "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/tencent/qqnt/chathistory/ui/link/viewmodel/ChatHistoryLinkViewModel;", "H", "Lcom/tencent/qqnt/chathistory/ui/link/viewmodel/ChatHistoryLinkViewModel;", "viewModel", "Lcom/tencent/qqnt/chathistory/ui/link/adapter/b;", "I", "Lcom/tencent/qqnt/chathistory/ui/link/adapter/b;", "J", "Lkotlin/jvm/functions/Function2;", "b1", "()Lkotlin/jvm/functions/Function2;", "W0", "()Z", "setChooseModel", "(Z)V", "chooseModel", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/tencent/qqnt/chathistory/ui/link/viewmodel/ChatHistoryLinkViewModel;Lcom/tencent/qqnt/chathistory/ui/link/adapter/b;Lkotlin/jvm/functions/Function2;)V", "L", "ChatLinkProvider", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryLinkAdapter extends com.tencent.qqnt.expandRecyclerView.adapter.provider.b {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ChatHistoryLinkViewModel viewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final b listener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Function2<Boolean, Boolean, Unit> setBottomBarState;
    private final /* synthetic */ l K;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/adapter/ChatHistoryLinkAdapter$ChatLinkProvider;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "helper", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", DomainData.DOMAIN_NAME, "", "f", "()I", "itemViewType", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/link/adapter/ChatHistoryLinkAdapter;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private final class ChatLinkProvider extends c {
        static IPatchRedirector $redirector_;

        public ChatLinkProvider() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkAdapter.this);
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
            return new e(context, null, 2, null).getRoot();
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
            super.b(helper, item, payloads);
            final QUICheckBox qUICheckBox = (QUICheckBox) helper.getView(R.id.j4f);
            qUICheckBox.setClickable(false);
            ChatHistoryLinkAdapter$ChatLinkProvider$convert$1 chatHistoryLinkAdapter$ChatLinkProvider$convert$1 = new ChatHistoryLinkAdapter$ChatLinkProvider$convert$1(helper, ChatHistoryLinkAdapter.this, qUICheckBox);
            final ChatHistoryLinkAdapter chatHistoryLinkAdapter = ChatHistoryLinkAdapter.this;
            ExtensionsKt.b(this, item, payloads, chatHistoryLinkAdapter$ChatLinkProvider$convert$1, new Function3<c, com.tencent.qqnt.chathistory.ui.link.data.model.a, i, Unit>(qUICheckBox) { // from class: com.tencent.qqnt.chathistory.ui.link.adapter.ChatHistoryLinkAdapter$ChatLinkProvider$convert$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUICheckBox $checkView;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$checkView = qUICheckBox;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatHistoryLinkAdapter.this, (Object) qUICheckBox);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(c cVar, com.tencent.qqnt.chathistory.ui.link.data.model.a aVar, i iVar) {
                    invoke2(cVar, aVar, iVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull c cast, @NotNull com.tencent.qqnt.chathistory.ui.link.data.model.a data, @NotNull i map) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, cast, data, map);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(cast, "$this$cast");
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(map, "map");
                    if (((o) map.a(o.class)) != null) {
                        ChatHistoryLinkAdapter.this.U0(this.$checkView, data.j());
                    }
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/adapter/ChatHistoryLinkAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.link.adapter.ChatHistoryLinkAdapter$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryLinkAdapter(@NotNull CoroutineScope scope, @NotNull ChatHistoryLinkViewModel viewModel, @NotNull b listener, @NotNull Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scope, viewModel, listener, setBottomBarState);
            return;
        }
        this.scope = scope;
        this.viewModel = viewModel;
        this.listener = listener;
        this.setBottomBarState = setBottomBarState;
        this.K = new l();
        F0(new n());
        F0(new g());
        k0(new ChatLinkProvider());
    }

    public boolean U0(@NotNull QUICheckBox cb5, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, cb5, Long.valueOf(msgId))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        return this.K.c(cb5, msgId);
    }

    public boolean V0(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) callBack)).booleanValue();
        }
        return this.K.d(callBack);
    }

    public boolean W0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.K.f();
    }

    @NotNull
    public List<Long> X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.K.g();
    }

    @NotNull
    public List<com.tencent.qqnt.chathistory.ui.base.item.b> Y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.K.h();
    }

    @NotNull
    public List<MsgRecord> Z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.K.i();
    }

    @NotNull
    public final CoroutineScope a1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.scope;
    }

    @NotNull
    public final Function2<Boolean, Boolean, Unit> b1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.setBottomBarState;
    }

    public void c1(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) callBack);
        } else {
            this.K.k(callBack);
        }
    }

    public void d1(@NotNull View itemView, @NotNull MsgRecord msgRecord, @NotNull com.tencent.qqnt.chathistory.ui.base.item.b msgItemModel, @NotNull QUICheckBox checkbox, @NotNull Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState, @NotNull View.OnClickListener listener, @NotNull String elementId) {
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
        this.K.m(itemView, msgRecord, msgItemModel, checkbox, setBottomBarState, listener, elementId);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    protected int o0(@NotNull List<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> data, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) data, position)).intValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.get(position) instanceof com.tencent.qqnt.chathistory.ui.base.item.a) {
            return 0;
        }
        return 1;
    }
}
