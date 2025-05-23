package com.tencent.qqnt.chathistory.ui.document.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.document.viewmodel.ChatHistoryDocumentViewModel;
import com.tencent.qqnt.chathistory.util.MsgRecordExKt;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.chathistory.util.j;
import com.tencent.qqnt.chathistory.util.l;
import com.tencent.qqnt.expandRecyclerView.adapter.provider.c;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Lcom/tencent/qqnt/chathistory/ui/document/data/model/b;", "data", "", "invoke", "(Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;Lcom/tencent/qqnt/chathistory/ui/document/data/model/b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryDocumentAdapter$ChatHistoryDocumentProvider$convert$1 extends Lambda implements Function2<c, com.tencent.qqnt.chathistory.ui.document.data.model.b, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ ImageView $docIcon;
    final /* synthetic */ TextView $docMsgName;
    final /* synthetic */ TextView $docMsgTime;
    final /* synthetic */ QUICheckBox $docSelector;
    final /* synthetic */ TextView $docSenderLabel;
    final /* synthetic */ TextView $docTitle;
    final /* synthetic */ com.tencent.qqnt.expandRecyclerView.adapter.a $helper;
    final /* synthetic */ ChatHistoryDocumentAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryDocumentAdapter$ChatHistoryDocumentProvider$convert$1(TextView textView, TextView textView2, TextView textView3, ChatHistoryDocumentAdapter chatHistoryDocumentAdapter, com.tencent.qqnt.expandRecyclerView.adapter.a aVar, QUICheckBox qUICheckBox, ImageView imageView, TextView textView4) {
        super(2);
        this.$docMsgTime = textView;
        this.$docSenderLabel = textView2;
        this.$docMsgName = textView3;
        this.this$0 = chatHistoryDocumentAdapter;
        this.$helper = aVar;
        this.$docSelector = qUICheckBox;
        this.$docIcon = imageView;
        this.$docTitle = textView4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, textView, textView2, textView3, chatHistoryDocumentAdapter, aVar, qUICheckBox, imageView, textView4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.qqnt.chathistory.ui.document.data.model.b data, com.tencent.qqnt.expandRecyclerView.adapter.a helper, ChatHistoryDocumentAdapter this$0, View view) {
        b bVar;
        String e16;
        b bVar2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (data.l().msgType != 2 && data.l().msgType != 31) {
            String f16 = data.f();
            if (f16 != null && (e16 = l.f354063a.e(f16, data.l().subMsgType)) != null) {
                bVar2 = this$0.listener;
                bVar2.a(e16);
            }
        } else {
            String f17 = data.f();
            if (f17 != null) {
                bVar = this$0.listener;
                bVar.a(f17);
            }
        }
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        View view2 = helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "helper.itemView");
        HistoryDtReportHelper.n(a16, view2, "em_bas_online_document_entry", null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(c cVar, com.tencent.qqnt.chathistory.ui.document.data.model.b bVar) {
        invoke2(cVar, bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull c cast, @NotNull final com.tencent.qqnt.chathistory.ui.document.data.model.b data) {
        ChatHistoryDocumentViewModel chatHistoryDocumentViewModel;
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cast, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(cast, "$this$cast");
        Intrinsics.checkNotNullParameter(data, "data");
        String g16 = data.g();
        if (g16 != null) {
            this.$docIcon.setImageDrawable(URLDrawable.getDrawable(g16, (URLDrawable.URLDrawableOptions) null));
        }
        String i3 = data.i();
        if (i3 != null) {
            this.$docTitle.setText(i3);
        }
        if (data.h() == null && (f16 = data.f()) != null) {
            TextView textView = this.$docTitle;
            ImageView imageView = this.$docIcon;
            l lVar = l.f354063a;
            textView.setText(lVar.d(f16, data.l().subMsgType));
            String c16 = lVar.c(f16, data.l().subMsgType);
            if (c16 != null) {
                try {
                    new URL(c16);
                    imageView.setImageDrawable(URLDrawable.getDrawable(c16, (URLDrawable.URLDrawableOptions) null));
                } catch (MalformedURLException e16) {
                    d.f354054a.a("ChatHistoryDocumentAdapter", "document icon parse error: [" + c16 + "] e: " + e16);
                }
            }
        }
        this.$docMsgTime.setText(j.a(data.l().msgTime * 1000));
        this.$docSenderLabel.setText(cast.e().getString(data.m() ? R.string.f170738zl4 : R.string.zk5));
        TextView textView2 = this.$docMsgName;
        chatHistoryDocumentViewModel = this.this$0.viewModel;
        MsgRecordExKt.e(textView2, chatHistoryDocumentViewModel.M1(), data.l(), this.this$0.a1(), 0, 8, null);
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        View view = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "helper.itemView");
        a16.s(view, "em_bas_online_document_entry", new LinkedHashMap(), false, false, String.valueOf(this.$helper.itemView.hashCode()));
        ChatHistoryDocumentAdapter chatHistoryDocumentAdapter = this.this$0;
        View view2 = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "helper.itemView");
        MsgRecord l3 = data.l();
        QUICheckBox qUICheckBox = this.$docSelector;
        Function2<Boolean, Boolean, Unit> b16 = this.this$0.b1();
        final com.tencent.qqnt.expandRecyclerView.adapter.a aVar = this.$helper;
        final ChatHistoryDocumentAdapter chatHistoryDocumentAdapter2 = this.this$0;
        chatHistoryDocumentAdapter.d1(view2, l3, data, qUICheckBox, b16, new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.document.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ChatHistoryDocumentAdapter$ChatHistoryDocumentProvider$convert$1.b(com.tencent.qqnt.chathistory.ui.document.data.model.b.this, aVar, chatHistoryDocumentAdapter2, view3);
            }
        }, "em_bas_online_document_entry");
        this.this$0.U0(this.$docSelector, data.j());
    }
}
