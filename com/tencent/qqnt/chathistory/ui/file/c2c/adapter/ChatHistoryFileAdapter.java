package com.tencent.qqnt.chathistory.ui.file.c2c.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.base.e;
import com.tencent.qqnt.chathistory.ui.base.g;
import com.tencent.qqnt.chathistory.ui.base.l;
import com.tencent.qqnt.chathistory.ui.base.n;
import com.tencent.qqnt.chathistory.ui.base.o;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.m;
import com.tencent.qqnt.chathistory.ui.file.c2c.viewmodel.ChatHistoryFileModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.widget.C2CFileItemView;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.h;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002QRBa\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010#\u001a\u00020:\u0012\u0006\u0010B\u001a\u00020?\u0012\b\b\u0002\u0010D\u001a\u00020)\u00126\u0010!\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110\u001e\u00a2\u0006\u0004\bN\u0010OJ\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0019\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0096\u0001J2\u0010\u0013\u001a\u00020\u000b2'\b\u0002\u0010\u0012\u001a!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\rH\u0096\u0001J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0096\u0001J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004H\u0096\u0001J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0096\u0001J2\u0010\u0018\u001a\u00020\u00112'\b\u0002\u0010\u0012\u001a!\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\rH\u0096\u0001Jq\u0010&\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000726\u0010!\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110\u001e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0096\u0001J\u001e\u0010+\u001a\u00020)2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00042\u0006\u0010*\u001a\u00020)H\u0014J\u0006\u0010-\u001a\u00020,J\u000e\u0010.\u001a\u00020$2\u0006\u0010*\u001a\u00020)J\u001c\u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u0002010\u0004J\f\u00105\u001a\u0006\u0012\u0002\b\u000304H\u0016R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0017\u0010#\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010@RG\u0010!\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110\u001e8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001c\u0010M\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L\u00a8\u0006S"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/ChatHistoryFileAdapter;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/m;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Y0", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cb", "", "msgId", "", "W0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "choose", "", "callBack", "X0", "d1", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "e1", "f1", "i1", "Landroid/view/View;", "itemView", "msgRecord", "msgItemModel", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Lkotlin/Function2;", "isEnabled", "isFavEnabled", "setBottomBarState", "Landroid/view/View$OnClickListener;", "listener", "", "elementId", "j1", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "data", "", "position", "o0", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/a;", "b1", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "itemModelList", "h1", "", "f", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", "G", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;", "viewModel", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;", "H", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;", "c1", "()Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;", "Lkotlinx/coroutines/CoroutineScope;", "I", "Lkotlinx/coroutines/CoroutineScope;", "scope", "J", "source", "K", "Lkotlin/jvm/functions/Function2;", "g1", "()Lkotlin/jvm/functions/Function2;", "Z0", "()Z", "setChooseModel", "(Z)V", "chooseModel", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/file/c2c/viewmodel/ChatHistoryFileModel;Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/d;Lkotlinx/coroutines/CoroutineScope;ILkotlin/jvm/functions/Function2;)V", "M", "a", "FileItemProvider", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryFileAdapter extends com.tencent.qqnt.expandRecyclerView.adapter.provider.b implements m {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a M;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ChatHistoryFileModel viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final d listener;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: J, reason: from kotlin metadata */
    private final int source;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Function2<Boolean, Boolean, Unit> setBottomBarState;
    private final /* synthetic */ l L;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/ChatHistoryFileAdapter$FileItemProvider;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "helper", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", DomainData.DOMAIN_NAME, "", "f", "()I", "itemViewType", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/ChatHistoryFileAdapter;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    private final class FileItemProvider extends com.tencent.qqnt.expandRecyclerView.adapter.provider.c {
        static IPatchRedirector $redirector_;

        public FileItemProvider() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryFileAdapter.this);
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
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.drc, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026arch_file, parent, false)");
            return inflate;
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
            final QUICheckBox qUICheckBox = (QUICheckBox) helper.getView(R.id.c_i);
            qUICheckBox.setClickable(false);
            qUICheckBox.setImportantForAccessibility(2);
            final C2CFileItemView c2CFileItemView = (C2CFileItemView) helper.getView(R.id.v4y);
            ChatHistoryFileAdapter$FileItemProvider$convert$1 chatHistoryFileAdapter$FileItemProvider$convert$1 = new ChatHistoryFileAdapter$FileItemProvider$convert$1(helper, ChatHistoryFileAdapter.this, qUICheckBox, c2CFileItemView);
            final ChatHistoryFileAdapter chatHistoryFileAdapter = ChatHistoryFileAdapter.this;
            ExtensionsKt.b(this, item, payloads, chatHistoryFileAdapter$FileItemProvider$convert$1, new Function3<com.tencent.qqnt.expandRecyclerView.adapter.provider.c, FileItemModel, i, Unit>(chatHistoryFileAdapter, qUICheckBox) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.adapter.ChatHistoryFileAdapter$FileItemProvider$convert$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUICheckBox $checkView;
                final /* synthetic */ ChatHistoryFileAdapter this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.this$0 = chatHistoryFileAdapter;
                    this.$checkView = qUICheckBox;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, C2CFileItemView.this, chatHistoryFileAdapter, qUICheckBox);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.expandRecyclerView.adapter.provider.c cVar, FileItemModel fileItemModel, i iVar) {
                    invoke2(cVar, fileItemModel, iVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.c cast, @NotNull FileItemModel data, @NotNull i map) {
                    ChatHistoryFileModel chatHistoryFileModel;
                    CoroutineScope coroutineScope;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, cast, data, map);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(cast, "$this$cast");
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(map, "map");
                    if (((o) map.a(o.class)) != null) {
                        this.this$0.W0(this.$checkView, data.t());
                    }
                    C2CFileItemView c2CFileItemView2 = C2CFileItemView.this;
                    chatHistoryFileModel = this.this$0.viewModel;
                    int M1 = chatHistoryFileModel.M1();
                    coroutineScope = this.this$0.scope;
                    c2CFileItemView2.l(M1, data, coroutineScope);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/adapter/ChatHistoryFileAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            M = new a(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryFileAdapter(@NotNull ChatHistoryFileModel viewModel, @NotNull d listener, @NotNull CoroutineScope scope, int i3, @NotNull Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, viewModel, listener, scope, Integer.valueOf(i3), setBottomBarState);
            return;
        }
        this.viewModel = viewModel;
        this.listener = listener;
        this.scope = scope;
        this.source = i3;
        this.setBottomBarState = setBottomBarState;
        this.L = new l();
        F0(new n());
        F0(new g());
        k0(new FileItemProvider());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<MsgRecord> Y0() {
        Sequence asSequence;
        Sequence filter;
        Sequence map;
        List<MsgRecord> list;
        asSequence = CollectionsKt___CollectionsKt.asSequence(m0());
        filter = SequencesKt___SequencesKt.filter(asSequence, ChatHistoryFileAdapter$getAllMsgRecords$1.INSTANCE);
        map = SequencesKt___SequencesKt.map(filter, ChatHistoryFileAdapter$getAllMsgRecords$2.INSTANCE);
        list = SequencesKt___SequencesKt.toList(map);
        return list;
    }

    public boolean W0(@NotNull QUICheckBox cb5, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, cb5, Long.valueOf(msgId))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        return this.L.c(cb5, msgId);
    }

    public boolean X0(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) callBack)).booleanValue();
        }
        return this.L.d(callBack);
    }

    public boolean Z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.L.f();
    }

    @NotNull
    public final String a1(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, position);
        }
        com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = m0().get(position);
        if (!(bVar instanceof FileItemModel)) {
            return "null";
        }
        FileItemModel fileItemModel = (FileItemModel) bVar;
        if (fileItemModel.F()) {
            return String.valueOf(HistoryDtReportHelper.FileThumbContent.OTHER.ordinal());
        }
        if (!fileItemModel.z() && !Intrinsics.areEqual(fileItemModel.I(), e.d.f353349a)) {
            if (Intrinsics.areEqual(fileItemModel.I(), e.f.f353351a)) {
                return String.valueOf(HistoryDtReportHelper.FileThumbContent.PAUSE.ordinal());
            }
            if (Intrinsics.areEqual(fileItemModel.I(), e.a.f353346a)) {
                return String.valueOf(HistoryDtReportHelper.FileThumbContent.PAUSE.ordinal());
            }
            if (fileItemModel.B()) {
                return String.valueOf(HistoryDtReportHelper.FileThumbContent.UPLOAD.ordinal());
            }
            return String.valueOf(HistoryDtReportHelper.FileThumbContent.DOWNLOAD.ordinal());
        }
        return String.valueOf(HistoryDtReportHelper.FileThumbContent.OTHER.ordinal());
    }

    @NotNull
    public final com.tencent.qqnt.chathistory.ui.file.c2c.data.model.a b1() {
        Object last;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) m0());
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) last;
            if (bVar instanceof com.tencent.qqnt.chathistory.ui.file.c2c.data.model.a) {
                return (com.tencent.qqnt.chathistory.ui.file.c2c.data.model.a) bVar;
            }
            Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel");
            com.tencent.qqnt.chathistory.ui.base.item.a d16 = ((FileItemModel) bVar).d();
            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileGroupModel");
            return (com.tencent.qqnt.chathistory.ui.file.c2c.data.model.a) d16;
        }
        return (com.tencent.qqnt.chathistory.ui.file.c2c.data.model.a) iPatchRedirector.redirect((short) 15, (Object) this);
    }

    @NotNull
    public final d c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.listener;
    }

    @NotNull
    public List<Long> d1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.L.g();
    }

    @NotNull
    public List<com.tencent.qqnt.chathistory.ui.base.item.b> e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.L.h();
    }

    @Override // com.tencent.qqnt.chathistory.ui.file.c2c.m
    @NotNull
    public List<?> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return m0();
    }

    @NotNull
    public List<MsgRecord> f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.L.i();
    }

    @NotNull
    public final Function2<Boolean, Boolean, Unit> g1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function2) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.setBottomBarState;
    }

    public final boolean h1(@NotNull Activity activity, @NotNull List<FileItemModel> itemModelList) {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) activity, (Object) itemModelList)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(itemModelList, "itemModelList");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        h hVar = h.f354057a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE});
        if (hVar.a(activity, listOf)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new ChatHistoryFileAdapter$handleMultiDownload$1(itemModelList, activity, booleanRef, null), 3, null);
        }
        return booleanRef.element;
    }

    public void i1(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) callBack);
        } else {
            this.L.k(callBack);
        }
    }

    public void j1(@NotNull View itemView, @NotNull MsgRecord msgRecord, @NotNull com.tencent.qqnt.chathistory.ui.base.item.b msgItemModel, @NotNull QUICheckBox checkbox, @NotNull Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState, @NotNull View.OnClickListener listener, @NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, itemView, msgRecord, msgItemModel, checkbox, setBottomBarState, listener, elementId);
            return;
        }
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgItemModel, "msgItemModel");
        Intrinsics.checkNotNullParameter(checkbox, "checkbox");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        this.L.m(itemView, msgRecord, msgItemModel, checkbox, setBottomBarState, listener, elementId);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    protected int o0(@NotNull List<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> data, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) data, position)).intValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.get(position) instanceof com.tencent.qqnt.chathistory.ui.base.item.a) {
            return 0;
        }
        return 1;
    }
}
