package com.tencent.qqnt.chathistory.ui.sticker.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel;
import com.tencent.qqnt.expandRecyclerView.adapter.provider.c;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Lcom/tencent/qqnt/chathistory/ui/sticker/data/model/SearchStickerItemModel;", "data", "", "invoke", "(Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;Lcom/tencent/qqnt/chathistory/ui/sticker/data/model/SearchStickerItemModel;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryStickerAdapter$ContentItemProvider$convert$1 extends Lambda implements Function2<c, SearchStickerItemModel, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QUICheckBox $checkView;
    final /* synthetic */ com.tencent.qqnt.expandRecyclerView.adapter.a $helper;
    final /* synthetic */ ImageView $iv;
    final /* synthetic */ ChatHistoryStickerAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryStickerAdapter$ContentItemProvider$convert$1(ImageView imageView, ChatHistoryStickerAdapter chatHistoryStickerAdapter, com.tencent.qqnt.expandRecyclerView.adapter.a aVar, QUICheckBox qUICheckBox) {
        super(2);
        this.$iv = imageView;
        this.this$0 = chatHistoryStickerAdapter;
        this.$helper = aVar;
        this.$checkView = qUICheckBox;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, imageView, chatHistoryStickerAdapter, aVar, qUICheckBox);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ImageView iv5, SearchStickerItemModel data, c this_cast, ChatHistoryStickerAdapter this$0, View view) {
        int i3;
        int i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(iv5, "$iv");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this_cast, "$this_cast");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HistoryDtReportHelper.n(HistoryDtReportHelper.INSTANCE.a(), iv5, "em_bas_expression_entry", null, 4, null);
        if (!data.o() && !data.q()) {
            if (data.p()) {
                IAIOMarketFaceApi iAIOMarketFaceApi = (IAIOMarketFaceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOMarketFaceApi.class);
                MsgRecord m3 = data.m();
                i16 = this$0.source;
                iAIOMarketFaceApi.enterMarketFacePreviewWithSource(iv5, m3, null, i16);
            }
        } else {
            com.tencent.qqnt.chathistory.service.a aVar = com.tencent.qqnt.chathistory.service.a.f353327a;
            Context e16 = this_cast.e();
            MsgRecord m16 = data.m();
            i3 = this$0.source;
            aVar.h(e16, m16, iv5, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(c cVar, SearchStickerItemModel searchStickerItemModel) {
        invoke2(cVar, searchStickerItemModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final c cast, @NotNull final SearchStickerItemModel data) {
        ColorDrawable Y0;
        CoroutineScope coroutineScope;
        String qqStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cast, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(cast, "$this$cast");
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView = this.$iv;
        Y0 = this.this$0.Y0();
        imageView.setImageDrawable(Y0);
        ImageView imageView2 = this.$iv;
        coroutineScope = this.this$0.scope;
        data.g(imageView2, coroutineScope);
        ImageView imageView3 = this.$iv;
        if (data.p()) {
            MarketFaceElement marketFaceElement = data.i().marketFaceElement;
            if (marketFaceElement == null || (qqStr = marketFaceElement.faceName) == null) {
                qqStr = HardCodeUtil.qqStr(R.string.a1f);
            }
        } else {
            PicElement picElement = data.i().picElement;
            if (picElement == null || (qqStr = picElement.summary) == null) {
                qqStr = HardCodeUtil.qqStr(R.string.a1f);
            }
        }
        imageView3.setContentDescription(qqStr);
        HistoryDtReportHelper.INSTANCE.a().s(this.$iv, "em_bas_expression_entry", new LinkedHashMap(), false, false, String.valueOf(this.$iv.hashCode()));
        ChatHistoryStickerAdapter chatHistoryStickerAdapter = this.this$0;
        View view = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "helper.itemView");
        MsgRecord m3 = data.m();
        QUICheckBox qUICheckBox = this.$checkView;
        Function2<Boolean, Boolean, Unit> e16 = this.this$0.e1();
        final ImageView imageView4 = this.$iv;
        final ChatHistoryStickerAdapter chatHistoryStickerAdapter2 = this.this$0;
        chatHistoryStickerAdapter.h1(view, m3, data, qUICheckBox, e16, new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.sticker.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryStickerAdapter$ContentItemProvider$convert$1.b(imageView4, data, cast, chatHistoryStickerAdapter2, view2);
            }
        }, "em_bas_expression_entry");
        this.this$0.V0(this.$checkView, data.j());
    }
}
