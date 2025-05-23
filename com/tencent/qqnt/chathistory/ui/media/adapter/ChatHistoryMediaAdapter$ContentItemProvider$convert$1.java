package com.tencent.qqnt.chathistory.ui.media.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.media.adapter.ChatHistoryMediaAdapter;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.util.f;
import com.tencent.qqnt.expandRecyclerView.adapter.provider.c;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaItemModel;", "data", "", "invoke", "(Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaItemModel;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryMediaAdapter$ContentItemProvider$convert$1 extends Lambda implements Function2<c, SearchMediaItemModel, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QUICheckBox $checkView;
    final /* synthetic */ com.tencent.qqnt.expandRecyclerView.adapter.a $helper;
    final /* synthetic */ ImageView $iv;
    final /* synthetic */ ChatHistoryMediaAdapter this$0;
    final /* synthetic */ ChatHistoryMediaAdapter.ContentItemProvider this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryMediaAdapter$ContentItemProvider$convert$1(ChatHistoryMediaAdapter chatHistoryMediaAdapter, ImageView imageView, com.tencent.qqnt.expandRecyclerView.adapter.a aVar, QUICheckBox qUICheckBox, ChatHistoryMediaAdapter.ContentItemProvider contentItemProvider) {
        super(2);
        this.this$0 = chatHistoryMediaAdapter;
        this.$iv = imageView;
        this.$helper = aVar;
        this.$checkView = qUICheckBox;
        this.this$1 = contentItemProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, chatHistoryMediaAdapter, imageView, aVar, qUICheckBox, contentItemProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002b, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        r0 = kotlin.sequences.SequencesKt___SequencesKt.map(r0, com.tencent.qqnt.chathistory.ui.media.adapter.ChatHistoryMediaAdapter$ContentItemProvider$convert$1$3$allData$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(c this_cast, ImageView iv5, SearchMediaItemModel data, ChatHistoryMediaAdapter this$0, View view) {
        List<MsgRecord> list;
        Map<String, Object> mutableMapOf;
        int i3;
        Sequence asSequence;
        Sequence filter;
        Sequence map;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_cast, "$this_cast");
        Intrinsics.checkNotNullParameter(iv5, "$iv");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b m3 = this_cast.m();
        if (m3 != null && (r0 = m3.m0()) != null && asSequence != null) {
            filter = SequencesKt___SequencesKt.filter(asSequence, ChatHistoryMediaAdapter$ContentItemProvider$convert$1$invoke$lambda$0$$inlined$filterIsInstance$1.INSTANCE);
            Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            if (filter != null && map != null) {
                list = SequencesKt___SequencesKt.toList(map);
                List<MsgRecord> list2 = list;
                HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(HistoryDtReportHelper.OperationContent.NORMAL.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(HistoryDtReportHelper.MediaType.PIC.ordinal())));
                a16.m(iv5, "em_bas_photovideo_entry", mutableMapOf);
                com.tencent.qqnt.chathistory.service.a aVar = com.tencent.qqnt.chathistory.service.a.f353327a;
                Context e16 = this_cast.e();
                MsgRecord k3 = data.k();
                i3 = this$0.source;
                aVar.i(e16, k3, list2, iv5, i3, data.g());
                EventCollector.getInstance().onViewClicked(view);
            }
        }
        list = null;
        List<MsgRecord> list22 = list;
        HistoryDtReportHelper a162 = HistoryDtReportHelper.INSTANCE.a();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(HistoryDtReportHelper.OperationContent.NORMAL.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(HistoryDtReportHelper.MediaType.PIC.ordinal())));
        a162.m(iv5, "em_bas_photovideo_entry", mutableMapOf);
        com.tencent.qqnt.chathistory.service.a aVar2 = com.tencent.qqnt.chathistory.service.a.f353327a;
        Context e162 = this_cast.e();
        MsgRecord k36 = data.k();
        i3 = this$0.source;
        aVar2.i(e162, k36, list22, iv5, i3, data.g());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(c cVar, SearchMediaItemModel searchMediaItemModel) {
        invoke2(cVar, searchMediaItemModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final c cast, @NotNull final SearchMediaItemModel data) {
        List list;
        CopyOnWriteArrayList<com.tencent.qqnt.expandRecyclerView.adapter.node.b> m06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cast, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(cast, "$this$cast");
        Intrinsics.checkNotNullParameter(data, "data");
        this.this$0.Y0(this.$iv);
        f.b(data.n(), new Function0<Unit>(this.$iv, this.this$0, this.this$1) { // from class: com.tencent.qqnt.chathistory.ui.media.adapter.ChatHistoryMediaAdapter$ContentItemProvider$convert$1.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ImageView $iv;
            final /* synthetic */ ChatHistoryMediaAdapter this$0;
            final /* synthetic */ ChatHistoryMediaAdapter.ContentItemProvider this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$iv = r6;
                this.this$0 = r7;
                this.this$1 = r8;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchMediaItemModel.this, r6, r7, r8);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Drawable c16;
                int a16;
                int a17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                d dVar = d.f354054a;
                dVar.a("ChatHistoryMediaAdapter", SearchMediaItemModel.this.j() + " thumb is Empty " + SearchMediaItemModel.this.n());
                String r16 = SearchMediaItemModel.this.r();
                if (FileUtils.fileExists(r16)) {
                    dVar.a("ChatHistoryMediaAdapter", SearchMediaItemModel.this.j() + " load oriPath " + r16);
                    ImageView imageView = this.$iv;
                    a16 = this.this$0.a1();
                    a17 = this.this$0.a1();
                    f.c(imageView, r16, a16, a17);
                    return;
                }
                if (SearchMediaItemModel.this.i()) {
                    dVar.a("ChatHistoryMediaAdapter", SearchMediaItemModel.this.j() + " expire");
                    ImageView imageView2 = this.$iv;
                    c16 = this.this$0.c1();
                    imageView2.setImageDrawable(c16);
                    return;
                }
                Pair<Integer, Integer> f16 = SearchMediaItemModel.this.f();
                this.this$1.o().invoke(new com.tencent.qqnt.chathistory.ui.base.b(SearchMediaItemModel.this.m(), SearchMediaItemModel.this.j(), SearchMediaItemModel.this.h(), new com.tencent.qqnt.chathistory.ui.base.c(f16.component1().intValue(), f16.component2().intValue())));
            }
        }, new Function1<File, Unit>(this.$iv, this.this$0) { // from class: com.tencent.qqnt.chathistory.ui.media.adapter.ChatHistoryMediaAdapter$ContentItemProvider$convert$1.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ ImageView $iv;
            final /* synthetic */ ChatHistoryMediaAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$iv = r9;
                this.this$0 = r10;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SearchMediaItemModel.this, r9, r10);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                invoke2(file);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull File it) {
                int a16;
                int a17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                d.f354054a.a("ChatHistoryMediaAdapter", SearchMediaItemModel.this.j() + " load thumb " + SearchMediaItemModel.this.n());
                ImageView imageView = this.$iv;
                String absolutePath = it.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                a16 = this.this$0.a1();
                a17 = this.this$0.a1();
                f.c(imageView, absolutePath, a16, a17);
            }
        });
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b m3 = cast.m();
        if (m3 == null || (m06 = m3.m0()) == null) {
            list = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : m06) {
                if (obj instanceof SearchMediaItemModel) {
                    arrayList.add(obj);
                }
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList);
        }
        String valueOf = list != null ? Integer.valueOf(list.indexOf(data) + 1) : "";
        this.$iv.setContentDescription(HardCodeUtil.qqStr(R.string.zjh) + valueOf + "}");
        ChatHistoryMediaAdapter chatHistoryMediaAdapter = this.this$0;
        View view = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "helper.itemView");
        MsgRecord k3 = data.k();
        QUICheckBox qUICheckBox = this.$checkView;
        Function2<Boolean, Boolean, Unit> i16 = this.this$0.i1();
        final ImageView imageView = this.$iv;
        final ChatHistoryMediaAdapter chatHistoryMediaAdapter2 = this.this$0;
        chatHistoryMediaAdapter.l1(view, k3, data, qUICheckBox, i16, new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.media.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryMediaAdapter$ContentItemProvider$convert$1.b(c.this, imageView, data, chatHistoryMediaAdapter2, view2);
            }
        }, "em_bas_photovideo_entry");
        this.this$0.W0(this.$checkView, data.j());
    }
}
