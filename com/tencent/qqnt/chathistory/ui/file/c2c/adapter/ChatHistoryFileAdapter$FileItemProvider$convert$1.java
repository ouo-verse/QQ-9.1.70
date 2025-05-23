package com.tencent.qqnt.chathistory.ui.file.c2c.adapter;

import android.view.View;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.viewmodel.ChatHistoryFileModel;
import com.tencent.qqnt.chathistory.ui.file.c2c.widget.C2CFileItemView;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "data", "", "invoke", "(Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryFileAdapter$FileItemProvider$convert$1 extends Lambda implements Function2<com.tencent.qqnt.expandRecyclerView.adapter.provider.c, FileItemModel, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QUICheckBox $checkView;
    final /* synthetic */ C2CFileItemView $fileItemView;
    final /* synthetic */ com.tencent.qqnt.expandRecyclerView.adapter.a $helper;
    final /* synthetic */ ChatHistoryFileAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryFileAdapter$FileItemProvider$convert$1(com.tencent.qqnt.expandRecyclerView.adapter.a aVar, ChatHistoryFileAdapter chatHistoryFileAdapter, QUICheckBox qUICheckBox, C2CFileItemView c2CFileItemView) {
        super(2);
        this.$helper = aVar;
        this.this$0 = chatHistoryFileAdapter;
        this.$checkView = qUICheckBox;
        this.$fileItemView = c2CFileItemView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, chatHistoryFileAdapter, qUICheckBox, c2CFileItemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ChatHistoryFileAdapter this$0, FileItemModel data, C2CFileItemView fileItemView, com.tencent.qqnt.expandRecyclerView.adapter.a helper, View view) {
        List<MsgRecord> Y0;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(fileItemView, "$fileItemView");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        d c16 = this$0.c1();
        RoundRectImageView q16 = fileItemView.q();
        Y0 = this$0.Y0();
        c16.a(data, q16, Y0);
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        View view2 = helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "helper.itemView");
        HistoryDtReportHelper.n(a16, view2, "em_bas_file_entry", null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.expandRecyclerView.adapter.provider.c cVar, FileItemModel fileItemModel) {
        invoke2(cVar, fileItemModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.c cast, @NotNull final FileItemModel data) {
        ChatHistoryFileModel chatHistoryFileModel;
        CoroutineScope coroutineScope;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cast, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(cast, "$this$cast");
        Intrinsics.checkNotNullParameter(data, "data");
        HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
        View view = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "helper.itemView");
        HistoryDtReportHelper.t(a16, view, "em_bas_file_entry", null, false, false, null, 60, null);
        ChatHistoryFileAdapter chatHistoryFileAdapter = this.this$0;
        View view2 = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "helper.itemView");
        MsgRecord y16 = data.y();
        QUICheckBox qUICheckBox = this.$checkView;
        Function2<Boolean, Boolean, Unit> g16 = this.this$0.g1();
        final ChatHistoryFileAdapter chatHistoryFileAdapter2 = this.this$0;
        final C2CFileItemView c2CFileItemView = this.$fileItemView;
        final com.tencent.qqnt.expandRecyclerView.adapter.a aVar = this.$helper;
        chatHistoryFileAdapter.j1(view2, y16, data, qUICheckBox, g16, new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ChatHistoryFileAdapter$FileItemProvider$convert$1.b(ChatHistoryFileAdapter.this, data, c2CFileItemView, aVar, view3);
            }
        }, "em_bas_file_entry");
        C2CFileItemView c2CFileItemView2 = this.$fileItemView;
        chatHistoryFileModel = this.this$0.viewModel;
        int M1 = chatHistoryFileModel.M1();
        coroutineScope = this.this$0.scope;
        c2CFileItemView2.l(M1, data, coroutineScope);
        C2CFileItemView c2CFileItemView3 = this.$fileItemView;
        String r16 = data.r();
        Intrinsics.checkNotNullExpressionValue(r16, "data.fileName");
        c2CFileItemView3.setFileName(r16);
        C2CFileItemView c2CFileItemView4 = this.$fileItemView;
        i3 = this.this$0.source;
        c2CFileItemView4.setSource(i3);
        this.this$0.W0(this.$checkView, data.t());
    }
}
