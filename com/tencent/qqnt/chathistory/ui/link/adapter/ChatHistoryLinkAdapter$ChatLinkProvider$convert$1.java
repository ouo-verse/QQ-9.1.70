package com.tencent.qqnt.chathistory.ui.link.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.link.viewmodel.ChatHistoryLinkViewModel;
import com.tencent.qqnt.chathistory.util.MsgRecordExKt;
import com.tencent.qqnt.chathistory.util.d;
import com.tencent.qqnt.expandRecyclerView.adapter.provider.c;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Lcom/tencent/qqnt/chathistory/ui/link/data/model/a;", "data", "", "invoke", "(Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;Lcom/tencent/qqnt/chathistory/ui/link/data/model/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryLinkAdapter$ChatLinkProvider$convert$1 extends Lambda implements Function2<c, com.tencent.qqnt.chathistory.ui.link.data.model.a, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QUICheckBox $checkView;
    final /* synthetic */ com.tencent.qqnt.expandRecyclerView.adapter.a $helper;
    final /* synthetic */ ChatHistoryLinkAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryLinkAdapter$ChatLinkProvider$convert$1(com.tencent.qqnt.expandRecyclerView.adapter.a aVar, ChatHistoryLinkAdapter chatHistoryLinkAdapter, QUICheckBox qUICheckBox) {
        super(2);
        this.$helper = aVar;
        this.this$0 = chatHistoryLinkAdapter;
        this.$checkView = qUICheckBox;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, chatHistoryLinkAdapter, qUICheckBox);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.qqnt.chathistory.ui.link.data.model.a data, com.tencent.qqnt.expandRecyclerView.adapter.a helper, ChatHistoryLinkAdapter this$0, View view) {
        b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String i3 = data.i();
        if (i3 != null) {
            bVar = this$0.listener;
            bVar.j0(i3);
        }
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        View view2 = helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "helper.itemView");
        HistoryDtReportHelper.n(a16, view2, "em_bas_link_entry", null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(c cVar, com.tencent.qqnt.chathistory.ui.link.data.model.a aVar) {
        invoke2(cVar, aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull c cast, @NotNull final com.tencent.qqnt.chathistory.ui.link.data.model.a data) {
        ChatHistoryLinkViewModel chatHistoryLinkViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cast, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(cast, "$this$cast");
        Intrinsics.checkNotNullParameter(data, "data");
        ((TextView) this.$helper.getView(R.id.f164642ae0)).setText(data.f());
        ((TextView) this.$helper.getView(R.id.bdn)).setText(data.g());
        View view = this.$helper.getView(R.id.f2a);
        ChatHistoryLinkAdapter chatHistoryLinkAdapter = this.this$0;
        TextView textView = (TextView) view;
        chatHistoryLinkViewModel = chatHistoryLinkAdapter.viewModel;
        MsgRecordExKt.e(textView, chatHistoryLinkViewModel.M1(), data.l(), chatHistoryLinkAdapter.a1(), 0, 8, null);
        ImageView imageView = (ImageView) this.$helper.getView(R.id.j4d);
        if (TextUtils.isEmpty(data.h())) {
            imageView.setImageResource(R.drawable.mpn);
        } else {
            d.f354054a.a("ChatHistoryLinkAdapter", "msgId " + data.j() + " loadIcon " + data.h());
            URLDrawable drawable = URLDrawable.getDrawable(data.h(), URLDrawable.URLDrawableOptions.obtain());
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(data.iconUrl, options)");
            imageView.setImageDrawable(drawable);
        }
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        View view2 = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "helper.itemView");
        a16.s(view2, "em_bas_link_entry", new LinkedHashMap(), false, false, String.valueOf(this.$helper.itemView.hashCode()));
        ChatHistoryLinkAdapter chatHistoryLinkAdapter2 = this.this$0;
        View view3 = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view3, "helper.itemView");
        MsgRecord l3 = data.l();
        QUICheckBox qUICheckBox = this.$checkView;
        Function2<Boolean, Boolean, Unit> b16 = this.this$0.b1();
        final com.tencent.qqnt.expandRecyclerView.adapter.a aVar = this.$helper;
        final ChatHistoryLinkAdapter chatHistoryLinkAdapter3 = this.this$0;
        chatHistoryLinkAdapter2.d1(view3, l3, data, qUICheckBox, b16, new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.link.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                ChatHistoryLinkAdapter$ChatLinkProvider$convert$1.b(com.tencent.qqnt.chathistory.ui.link.data.model.a.this, aVar, chatHistoryLinkAdapter3, view4);
            }
        }, "em_bas_link_entry");
        this.this$0.U0(this.$checkView, data.j());
    }
}
