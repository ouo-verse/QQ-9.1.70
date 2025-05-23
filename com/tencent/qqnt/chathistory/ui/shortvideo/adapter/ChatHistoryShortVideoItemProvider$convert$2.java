package com.tencent.qqnt.chathistory.ui.shortvideo.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryShortVideoApi;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.chathistory.ui.shortvideo.data.model.ChatHistoryShortVideoItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a;", "data", "", "invoke", "(Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;Lcom/tencent/qqnt/chathistory/ui/shortvideo/data/model/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ChatHistoryShortVideoItemProvider$convert$2 extends Lambda implements Function2<com.tencent.qqnt.expandRecyclerView.adapter.provider.c, ChatHistoryShortVideoItemModel, Unit> {
    final /* synthetic */ RoundRectImageView $authorAvatar;
    final /* synthetic */ TextView $authorName;
    final /* synthetic */ com.tencent.qqnt.expandRecyclerView.adapter.a $helper;
    final /* synthetic */ ImageView $itemCover;
    final /* synthetic */ TextView $titleView;
    final /* synthetic */ ChatHistoryShortVideoItemProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryShortVideoItemProvider$convert$2(TextView textView, ImageView imageView, RoundRectImageView roundRectImageView, com.tencent.qqnt.expandRecyclerView.adapter.a aVar, TextView textView2, ChatHistoryShortVideoItemProvider chatHistoryShortVideoItemProvider) {
        super(2);
        this.$titleView = textView;
        this.$itemCover = imageView;
        this.$authorAvatar = roundRectImageView;
        this.$helper = aVar;
        this.$authorName = textView2;
        this.this$0 = chatHistoryShortVideoItemProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ChatHistoryShortVideoItemModel data, com.tencent.qqnt.expandRecyclerView.adapter.provider.c this_cast, ChatHistoryShortVideoItemProvider this$0, com.tencent.qqnt.expandRecyclerView.adapter.a helper, View view) {
        String str;
        com.tencent.qqnt.expandRecyclerView.adapter.provider.b m3;
        Pair r16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this_cast, "$this_cast");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        QLog.d("QCHV-ChatHistoryShortVideoAdapter", 1, "[onClick] item: " + data.getMsgRecord().msgId + " | data name: " + data.o());
        if (data.f() == 2) {
            str = "qq_aio_\u7fa4\u804a";
        } else {
            str = "qq_aio_C2C";
        }
        String str2 = str;
        String m16 = data.m();
        if (m16 != null && (m3 = this_cast.m()) != null) {
            r16 = this$0.r(m3.m0(), m3.m0().indexOf(data));
            IChatHistoryShortVideoApi iChatHistoryShortVideoApi = (IChatHistoryShortVideoApi) QRoute.api(IChatHistoryShortVideoApi.class);
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            iChatHistoryShortVideoApi.forwardToShortVideoLayer(sMobileQQ, m16, str2, (List) r16.getFirst(), (List) r16.getSecond());
            this$0.s(helper, m16);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.expandRecyclerView.adapter.provider.c cVar, ChatHistoryShortVideoItemModel chatHistoryShortVideoItemModel) {
        invoke2(cVar, chatHistoryShortVideoItemModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final com.tencent.qqnt.expandRecyclerView.adapter.provider.c cast, @NotNull final ChatHistoryShortVideoItemModel data) {
        Intrinsics.checkNotNullParameter(cast, "$this$cast");
        Intrinsics.checkNotNullParameter(data, "data");
        String o16 = data.o();
        if (o16 != null) {
            this.$titleView.setText(o16);
        }
        String n3 = data.n();
        if (n3 != null) {
            this.$authorName.setText(n3);
        }
        if (TextUtils.isEmpty(this.$titleView.getText())) {
            this.$titleView.setVisibility(8);
        } else {
            this.$titleView.setVisibility(0);
        }
        this.$itemCover.setImageBitmap(null);
        String l3 = data.l();
        if (l3 != null) {
            ImageView imageView = this.$itemCover;
            Option option = Option.obtain();
            option.setUrl(l3);
            option.setTargetView(imageView);
            option.setNeedShowLoadingDrawable(false);
            option.setNeedShowFailedDrawable(true);
            option.setFailedDrawableId(R.drawable.f160441jg1);
            IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
            Intrinsics.checkNotNullExpressionValue(option, "option");
            iPicAIOApi.loadPic(option, null);
        }
        this.$authorAvatar.setImageBitmap(null);
        String k3 = data.k();
        if (k3 != null) {
            RoundRectImageView roundRectImageView = this.$authorAvatar;
            Option option2 = Option.obtain();
            option2.setUrl(k3);
            option2.setTargetView(roundRectImageView);
            option2.setNeedShowLoadingDrawable(false);
            IPicAIOApi iPicAIOApi2 = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
            Intrinsics.checkNotNullExpressionValue(option2, "option");
            iPicAIOApi2.loadPic(option2, null);
        }
        final com.tencent.qqnt.expandRecyclerView.adapter.a aVar = this.$helper;
        View view = aVar.itemView;
        final ChatHistoryShortVideoItemProvider chatHistoryShortVideoItemProvider = this.this$0;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.shortvideo.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistoryShortVideoItemProvider$convert$2.b(ChatHistoryShortVideoItemModel.this, cast, chatHistoryShortVideoItemProvider, aVar, view2);
            }
        });
    }
}
