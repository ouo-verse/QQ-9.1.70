package com.tencent.qqnt.chathistory.ui.media.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.chathistory.api.IChatHistoryMultiActionApi;
import com.tencent.qqnt.chathistory.exception.HistoryException;
import com.tencent.qqnt.chathistory.ui.base.TailDefaultItemModel;
import com.tencent.qqnt.chathistory.ui.base.g;
import com.tencent.qqnt.chathistory.ui.base.item.e;
import com.tencent.qqnt.chathistory.ui.base.l;
import com.tencent.qqnt.chathistory.ui.base.n;
import com.tencent.qqnt.chathistory.ui.base.o;
import com.tencent.qqnt.chathistory.ui.base.p;
import com.tencent.qqnt.chathistory.ui.base.r;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaModel;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.util.f;
import com.tencent.qqnt.chathistory.util.i;
import com.tencent.qqnt.chathistory.util.k;
import com.tencent.qqnt.chathistory.x2k.u;
import com.tencent.qqnt.chathistory.x2k.v;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0003TUVBl\u0012\b\b\u0002\u00109\u001a\u00020\u0003\u0012!\u0010P\u001a\u001d\u0012\u0013\u0012\u00110N\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00060\u000e\u00126\u0010#\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00060 \u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002J\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J2\u0010\u0013\u001a\u00020\f2'\b\u0002\u0010\u0012\u001a!\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000eH\u0096\u0001J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0014H\u0096\u0001J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0014H\u0096\u0001J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0096\u0001J2\u0010\u001a\u001a\u00020\u00062'\b\u0002\u0010\u0012\u001a!\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000eH\u0096\u0001Jq\u0010(\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\b26\u0010#\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00060 2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0096\u0001J\u001e\u0010,\u001a\u00020\u00032\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u00142\u0006\u0010+\u001a\u00020\u0003H\u0014J\b\u0010.\u001a\u0004\u0018\u00010-J\b\u00100\u001a\u0004\u0018\u00010/J$\u00106\u001a\u00020\u00062\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\f\u00105\u001a\b\u0012\u0004\u0012\u00020/0\u0014R\u0014\u00109\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108RG\u0010#\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00060 8\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001d\u0010H\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010GR\u001c\u0010M\u001a\u00020\f8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L\u00a8\u0006W"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/adapter/ChatHistoryMediaAdapter;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "", "", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Landroid/widget/ImageView;", "", "Y0", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cb", "", "msgId", "", "W0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "choose", "callBack", "X0", "", "f1", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "g1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "h1", "k1", "Landroid/view/View;", "itemView", "msgRecord", "msgItemModel", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Lkotlin/Function2;", "isEnabled", "isFavEnabled", "setBottomBarState", "Landroid/view/View$OnClickListener;", "listener", "", "elementId", "l1", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", "data", "position", "o0", "Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaModel;", "e1", "Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaItemModel;", "d1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "itemModelList", "j1", "G", "I", "source", "H", "Lkotlin/jvm/functions/Function2;", "i1", "()Lkotlin/jvm/functions/Function2;", "Landroid/graphics/drawable/ColorDrawable;", "J", "Lkotlin/Lazy;", "b1", "()Landroid/graphics/drawable/ColorDrawable;", "defaultDrawable", "Landroid/graphics/drawable/Drawable;", "K", "c1", "()Landroid/graphics/drawable/Drawable;", "failedDrawable", "Z0", "()Z", "setChooseModel", "(Z)V", "chooseModel", "Lcom/tencent/qqnt/chathistory/ui/base/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "sendIntent", "<init>", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "L", "a", "ContentItemProvider", "ContentVideoItemProvider", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryMediaAdapter extends com.tencent.qqnt.expandRecyclerView.adapter.provider.b {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: G, reason: from kotlin metadata */
    private final int source;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Function2<Boolean, Boolean, Unit> setBottomBarState;
    private final /* synthetic */ l I;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultDrawable;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy failedDrawable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B*\u0012!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R2\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/adapter/ChatHistoryMediaAdapter$ContentItemProvider;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "helper", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "Lcom/tencent/qqnt/chathistory/ui/base/b;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "o", "()Lkotlin/jvm/functions/Function1;", "sendIntent", "", "f", "()I", "itemViewType", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/media/adapter/ChatHistoryMediaAdapter;Lkotlin/jvm/functions/Function1;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class ContentItemProvider extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.qqnt.chathistory.ui.base.b, Unit> sendIntent;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatHistoryMediaAdapter f353751d;

        /* JADX WARN: Multi-variable type inference failed */
        public ContentItemProvider(@NotNull ChatHistoryMediaAdapter chatHistoryMediaAdapter, Function1<? super com.tencent.qqnt.chathistory.ui.base.b, Unit> sendIntent) {
            Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
            this.f353751d = chatHistoryMediaAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryMediaAdapter, (Object) sendIntent);
            } else {
                this.sendIntent = sendIntent;
            }
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        @NotNull
        public View c(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new u(context, null, 2, null).getRoot();
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        public int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void b(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a helper, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b item, @NotNull List<? extends Object> payloads) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, helper, item, payloads);
                return;
            }
            Intrinsics.checkNotNullParameter(helper, "helper");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            final ImageView imageView = (ImageView) helper.getView(R.id.y9u);
            final QUICheckBox qUICheckBox = (QUICheckBox) helper.getView(R.id.fqa);
            qUICheckBox.setClickable(false);
            qUICheckBox.setImportantForAccessibility(2);
            ChatHistoryMediaAdapter$ContentItemProvider$convert$1 chatHistoryMediaAdapter$ContentItemProvider$convert$1 = new ChatHistoryMediaAdapter$ContentItemProvider$convert$1(this.f353751d, imageView, helper, qUICheckBox, this);
            final ChatHistoryMediaAdapter chatHistoryMediaAdapter = this.f353751d;
            ExtensionsKt.b(this, item, payloads, chatHistoryMediaAdapter$ContentItemProvider$convert$1, new Function3<c, SearchMediaItemModel, i, Unit>(imageView, chatHistoryMediaAdapter, qUICheckBox) { // from class: com.tencent.qqnt.chathistory.ui.media.adapter.ChatHistoryMediaAdapter$ContentItemProvider$convert$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUICheckBox $checkView;
                final /* synthetic */ ImageView $iv;
                final /* synthetic */ ChatHistoryMediaAdapter this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$iv = imageView;
                    this.this$0 = chatHistoryMediaAdapter;
                    this.$checkView = qUICheckBox;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, imageView, chatHistoryMediaAdapter, qUICheckBox);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(c cVar, SearchMediaItemModel searchMediaItemModel, i iVar) {
                    invoke2(cVar, searchMediaItemModel, iVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull c cast, @NotNull SearchMediaItemModel data, @NotNull i map) {
                    Drawable c16;
                    int a16;
                    int a17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, cast, data, map);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(cast, "$this$cast");
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(map, "map");
                    p pVar = (p) map.a(p.class);
                    if (pVar != null) {
                        ImageView imageView2 = this.$iv;
                        ChatHistoryMediaAdapter chatHistoryMediaAdapter2 = this.this$0;
                        d.f354054a.a("ChatHistoryMediaAdapter", data.j() + " download " + pVar);
                        long j3 = pVar.a().fileErrCode;
                        if (j3 == 0) {
                            String str = pVar.a().filePath;
                            Intrinsics.checkNotNullExpressionValue(str, "picPayLoad.notifyInfo.filePath");
                            a16 = chatHistoryMediaAdapter2.a1();
                            a17 = chatHistoryMediaAdapter2.a1();
                            f.c(imageView2, str, a16, a17);
                        } else {
                            boolean z16 = true;
                            if (j3 != 2006014 && j3 != 2006016) {
                                z16 = false;
                            }
                            if (!z16) {
                                c16 = chatHistoryMediaAdapter2.c1();
                                imageView2.setImageDrawable(c16);
                            }
                        }
                    }
                    if (((o) map.a(o.class)) != null) {
                        this.this$0.W0(this.$checkView, data.j());
                    }
                }
            });
        }

        @NotNull
        public final Function1<com.tencent.qqnt.chathistory.ui.base.b, Unit> o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Function1) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.sendIntent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B*\u0012!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R2\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\r0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/adapter/ChatHistoryMediaAdapter$ContentVideoItemProvider;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "c", "Lcom/tencent/qqnt/expandRecyclerView/adapter/a;", "helper", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "Lcom/tencent/qqnt/chathistory/ui/base/b;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "o", "()Lkotlin/jvm/functions/Function1;", "sendIntent", "", "f", "()I", "itemViewType", "<init>", "(Lcom/tencent/qqnt/chathistory/ui/media/adapter/ChatHistoryMediaAdapter;Lkotlin/jvm/functions/Function1;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class ContentVideoItemProvider extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.qqnt.chathistory.ui.base.b, Unit> sendIntent;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChatHistoryMediaAdapter f353753d;

        /* JADX WARN: Multi-variable type inference failed */
        public ContentVideoItemProvider(@NotNull ChatHistoryMediaAdapter chatHistoryMediaAdapter, Function1<? super com.tencent.qqnt.chathistory.ui.base.b, Unit> sendIntent) {
            Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
            this.f353753d = chatHistoryMediaAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) chatHistoryMediaAdapter, (Object) sendIntent);
            } else {
                this.sendIntent = sendIntent;
            }
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        @NotNull
        public View c(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new v(context, null, null, false, 14, null).getRoot();
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        public int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 2;
        }

        @Override // com.tencent.qqnt.expandRecyclerView.adapter.provider.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void b(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.a helper, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b item, @NotNull List<? extends Object> payloads) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, helper, item, payloads);
                return;
            }
            Intrinsics.checkNotNullParameter(helper, "helper");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            final ImageView imageView = (ImageView) helper.getView(R.id.y9u);
            final QUICheckBox qUICheckBox = (QUICheckBox) helper.getView(R.id.fqa);
            qUICheckBox.setClickable(false);
            qUICheckBox.setImportantForAccessibility(2);
            ChatHistoryMediaAdapter$ContentVideoItemProvider$convert$1 chatHistoryMediaAdapter$ContentVideoItemProvider$convert$1 = new ChatHistoryMediaAdapter$ContentVideoItemProvider$convert$1(this.f353753d, imageView, helper, qUICheckBox, this, (TextView) helper.getView(R.id.f167093ks0));
            final ChatHistoryMediaAdapter chatHistoryMediaAdapter = this.f353753d;
            ExtensionsKt.b(this, item, payloads, chatHistoryMediaAdapter$ContentVideoItemProvider$convert$1, new Function3<c, SearchMediaItemModel, i, Unit>(imageView, chatHistoryMediaAdapter, qUICheckBox) { // from class: com.tencent.qqnt.chathistory.ui.media.adapter.ChatHistoryMediaAdapter$ContentVideoItemProvider$convert$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QUICheckBox $checkView;
                final /* synthetic */ ImageView $iv;
                final /* synthetic */ ChatHistoryMediaAdapter this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$iv = imageView;
                    this.this$0 = chatHistoryMediaAdapter;
                    this.$checkView = qUICheckBox;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, imageView, chatHistoryMediaAdapter, qUICheckBox);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(c cVar, SearchMediaItemModel searchMediaItemModel, i iVar) {
                    invoke2(cVar, searchMediaItemModel, iVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull c cast, @NotNull SearchMediaItemModel data, @NotNull i map) {
                    int a16;
                    int a17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, cast, data, map);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(cast, "$this$cast");
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(map, "map");
                    p pVar = (p) map.a(p.class);
                    if (pVar != null) {
                        ImageView imageView2 = this.$iv;
                        ChatHistoryMediaAdapter chatHistoryMediaAdapter2 = this.this$0;
                        d.f354054a.a("ChatHistoryMediaAdapter", data.j() + " video download  " + pVar);
                        long j3 = pVar.a().fileErrCode;
                        if (j3 == 0) {
                            String str = pVar.a().filePath;
                            Intrinsics.checkNotNullExpressionValue(str, "picPayLoad.notifyInfo.filePath");
                            a16 = chatHistoryMediaAdapter2.a1();
                            a17 = chatHistoryMediaAdapter2.a1();
                            f.c(imageView2, str, a16, a17);
                        } else {
                            boolean z16 = true;
                            if (j3 != 2006014 && j3 != 2006016) {
                                z16 = false;
                            }
                            if (!z16) {
                                imageView2.setImageResource(R.drawable.aio_image_fail);
                            }
                        }
                    }
                    if (((o) map.a(o.class)) != null) {
                        this.this$0.W0(this.$checkView, data.j());
                    }
                }
            });
        }

        @NotNull
        public final Function1<com.tencent.qqnt.chathistory.ui.base.b, Unit> o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Function1) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.sendIntent;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/adapter/ChatHistoryMediaAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.media.adapter.ChatHistoryMediaAdapter$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47864);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryMediaAdapter(int i3, @NotNull Function1<? super com.tencent.qqnt.chathistory.ui.base.b, Unit> sendIntent, @NotNull Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState) {
        super(null, 1, 0 == true ? 1 : 0);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(sendIntent, "sendIntent");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), sendIntent, setBottomBarState);
            return;
        }
        this.source = i3;
        this.setBottomBarState = setBottomBarState;
        this.I = new l();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatHistoryMediaAdapter$defaultDrawable$2.INSTANCE);
        this.defaultDrawable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ChatHistoryMediaAdapter$failedDrawable$2.INSTANCE);
        this.failedDrawable = lazy2;
        F0(new g());
        F0(new n());
        F0(new r());
        k0(new ContentItemProvider(this, sendIntent));
        k0(new ContentVideoItemProvider(this, sendIntent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(ImageView imageView) {
        imageView.setImageDrawable(b1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a1() {
        return k.f354062a.a() / 4;
    }

    private final ColorDrawable b1() {
        return (ColorDrawable) this.defaultDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable c1() {
        return (Drawable) this.failedDrawable.getValue();
    }

    public boolean W0(@NotNull QUICheckBox cb5, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, cb5, Long.valueOf(msgId))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        return this.I.c(cb5, msgId);
    }

    public boolean X0(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) callBack)).booleanValue();
        }
        return this.I.d(callBack);
    }

    public boolean Z0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.I.f();
    }

    @Nullable
    public final SearchMediaItemModel d1() {
        boolean z16;
        Object last;
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (SearchMediaItemModel) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> m06 = m0();
        if (m06 != null && !m06.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) m0());
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) last;
            if (!(bVar instanceof SearchMediaItemModel)) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) bVar.b());
                if (!(lastOrNull instanceof SearchMediaItemModel)) {
                    return null;
                }
                return (SearchMediaItemModel) lastOrNull;
            }
            return (SearchMediaItemModel) bVar;
        }
        return null;
    }

    @Nullable
    public final SearchMediaModel e1() {
        boolean z16;
        Object last;
        SearchMediaItemModel searchMediaItemModel;
        com.tencent.qqnt.chathistory.ui.base.i iVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SearchMediaModel) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> m06 = m0();
        if (m06 != null && !m06.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        SearchMediaModel searchMediaModel = null;
        if (!z16) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) m0());
            com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = (com.tencent.qqnt.expandRecyclerView.adapter.node.b) last;
            if (bVar instanceof SearchMediaModel) {
                return (SearchMediaModel) bVar;
            }
            if (bVar instanceof SearchMediaItemModel) {
                searchMediaItemModel = (SearchMediaItemModel) bVar;
            } else {
                searchMediaItemModel = null;
            }
            if (searchMediaItemModel != null) {
                iVar = searchMediaItemModel.d();
            } else {
                iVar = null;
            }
            if (iVar instanceof SearchMediaModel) {
                searchMediaModel = (SearchMediaModel) iVar;
            }
            if (searchMediaModel == null) {
                d.f354054a.a("ChatHistoryMediaAdapter", "getLastParentNode return model = " + bVar);
            }
            return searchMediaModel;
        }
        return null;
    }

    @NotNull
    public List<Long> f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.I.g();
    }

    @NotNull
    public List<com.tencent.qqnt.chathistory.ui.base.item.b> g1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.I.h();
    }

    @NotNull
    public List<MsgRecord> h1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.I.i();
    }

    @NotNull
    public final Function2<Boolean, Boolean, Unit> i1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function2) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.setBottomBarState;
    }

    public final void j1(@NotNull Activity activity, @NotNull Context context, @NotNull List<SearchMediaItemModel> itemModelList) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, activity, context, itemModelList);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemModelList, "itemModelList");
        IChatHistoryMultiActionApi iChatHistoryMultiActionApi = (IChatHistoryMultiActionApi) QRoute.api(IChatHistoryMultiActionApi.class);
        List<SearchMediaItemModel> list = itemModelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((SearchMediaItemModel) it.next()).k());
        }
        iChatHistoryMultiActionApi.saveMedia(activity, arrayList);
    }

    public void k1(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) callBack);
        } else {
            this.I.k(callBack);
        }
    }

    public void l1(@NotNull View itemView, @NotNull MsgRecord msgRecord, @NotNull com.tencent.qqnt.chathistory.ui.base.item.b msgItemModel, @NotNull QUICheckBox checkbox, @NotNull Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState, @NotNull View.OnClickListener listener, @NotNull String elementId) {
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
        this.I.m(itemView, msgRecord, msgItemModel, checkbox, setBottomBarState, listener, elementId);
    }

    @Override // com.tencent.qqnt.expandRecyclerView.adapter.BaseProviderMultiAdapter
    protected int o0(@NotNull List<? extends com.tencent.qqnt.expandRecyclerView.adapter.node.b> data, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) data, position)).intValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar = data.get(position);
        if (bVar instanceof SearchMediaModel) {
            return 0;
        }
        if (bVar instanceof e) {
            return 10;
        }
        if (bVar instanceof SearchMediaItemModel) {
            SearchMediaItemModel searchMediaItemModel = (SearchMediaItemModel) bVar;
            if (searchMediaItemModel.p()) {
                return 1;
            }
            if (searchMediaItemModel.q()) {
                return 2;
            }
            throw new HistoryException("illegal data " + bVar);
        }
        if (bVar instanceof TailDefaultItemModel) {
            return 100;
        }
        throw new HistoryException("illegal data " + bVar);
    }
}
