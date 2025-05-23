package com.qzone.reborn.groupalbum.selectmedia.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import com.qzone.reborn.groupalbum.selectmedia.util.e;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import yi.DownLoadParam;
import yi.DownlandReq;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lxi/c;", "Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaItemModel;", "data", "", "invoke", "(Lxi/c;Lcom/qzone/reborn/groupalbum/selectmedia/data/model/SearchMediaItemModel;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1 extends Lambda implements Function2<xi.c, SearchMediaItemModel, Unit> {
    final /* synthetic */ QUICheckBox $checkView;
    final /* synthetic */ a $helper;
    final /* synthetic */ ImageView $iv;
    final /* synthetic */ ChatHistorySelectMediaAdapter this$0;
    final /* synthetic */ ChatHistorySelectMediaAdapter.ContentItemProvider this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1(ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter, ImageView imageView, a aVar, QUICheckBox qUICheckBox, ChatHistorySelectMediaAdapter.ContentItemProvider contentItemProvider) {
        super(2);
        this.this$0 = chatHistorySelectMediaAdapter;
        this.$iv = imageView;
        this.$helper = aVar;
        this.$checkView = qUICheckBox;
        this.this$1 = contentItemProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002b, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        r0 = kotlin.sequences.SequencesKt___SequencesKt.map(r0, com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1$3$allData$1.INSTANCE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(xi.c this_cast, SearchMediaItemModel data, ImageView iv5, ChatHistorySelectMediaAdapter this$0, View view) {
        List<MsgRecord> list;
        int i3;
        Sequence asSequence;
        Sequence filter;
        Sequence map;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_cast, "$this_cast");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(iv5, "$iv");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xi.b m3 = this_cast.m();
        if (m3 != null && (r0 = m3.m0()) != null && asSequence != null) {
            filter = SequencesKt___SequencesKt.filter(asSequence, new Function1<Object, Boolean>() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1$invoke$lambda$0$$inlined$filterIsInstance$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof SearchMediaItemModel);
                }
            });
            Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            if (filter != null && map != null) {
                list = SequencesKt___SequencesKt.toList(map);
                cj.a aVar = cj.a.f30979a;
                Context e16 = this_cast.e();
                MsgRecord msgRecord = data.getMsgRecord();
                i3 = this$0.source;
                aVar.b(e16, msgRecord, list, iv5, i3, data.getElement());
                EventCollector.getInstance().onViewClicked(view);
            }
        }
        list = null;
        cj.a aVar2 = cj.a.f30979a;
        Context e162 = this_cast.e();
        MsgRecord msgRecord2 = data.getMsgRecord();
        i3 = this$0.source;
        aVar2.b(e162, msgRecord2, list, iv5, i3, data.getElement());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(xi.c cVar, SearchMediaItemModel searchMediaItemModel) {
        invoke2(cVar, searchMediaItemModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final xi.c cast, final SearchMediaItemModel data) {
        Intrinsics.checkNotNullParameter(cast, "$this$cast");
        Intrinsics.checkNotNullParameter(data, "data");
        this.this$0.T0(this.$iv);
        String thumbPath = data.getThumbPath();
        final ImageView imageView = this.$iv;
        final ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter = this.this$0;
        final ChatHistorySelectMediaAdapter.ContentItemProvider contentItemProvider = this.this$1;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Drawable W0;
                int U0;
                int U02;
                com.qzone.reborn.groupalbum.selectmedia.util.c cVar = com.qzone.reborn.groupalbum.selectmedia.util.c.f56957a;
                cVar.a("ChatHistorySelectMediaAdapter", SearchMediaItemModel.this.j() + " thumb is Empty " + SearchMediaItemModel.this.getThumbPath());
                String s16 = SearchMediaItemModel.this.s();
                if (FileUtils.fileExists(s16)) {
                    cVar.a("ChatHistorySelectMediaAdapter", SearchMediaItemModel.this.j() + " load oriPath " + s16);
                    ImageView imageView2 = imageView;
                    U0 = chatHistorySelectMediaAdapter.U0();
                    U02 = chatHistorySelectMediaAdapter.U0();
                    e.c(imageView2, s16, U0, U02);
                    return;
                }
                if (SearchMediaItemModel.this.getExpire()) {
                    cVar.a("ChatHistorySelectMediaAdapter", SearchMediaItemModel.this.j() + " expire");
                    ImageView imageView3 = imageView;
                    W0 = chatHistorySelectMediaAdapter.W0();
                    imageView3.setImageDrawable(W0);
                    return;
                }
                Pair<Integer, Integer> f16 = SearchMediaItemModel.this.f();
                contentItemProvider.o().invoke(new DownLoadParam(SearchMediaItemModel.this.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String(), SearchMediaItemModel.this.j(), SearchMediaItemModel.this.getElementId(), new DownlandReq(f16.component1().intValue(), f16.component2().intValue())));
            }
        };
        final ImageView imageView2 = this.$iv;
        final ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter2 = this.this$0;
        e.b(thumbPath, function0, new Function1<File, Unit>() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                invoke2(file);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(File it) {
                int U0;
                int U02;
                Intrinsics.checkNotNullParameter(it, "it");
                com.qzone.reborn.groupalbum.selectmedia.util.c.f56957a.a("ChatHistorySelectMediaAdapter", SearchMediaItemModel.this.j() + " load thumb " + SearchMediaItemModel.this.getThumbPath());
                ImageView imageView3 = imageView2;
                String absolutePath = it.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                U0 = chatHistorySelectMediaAdapter2.U0();
                U02 = chatHistorySelectMediaAdapter2.U0();
                e.c(imageView3, absolutePath, U0, U02);
            }
        });
        this.$iv.setContentDescription(HardCodeUtil.qqStr(R.string.zjh));
        ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter3 = this.this$0;
        View view = this.$helper.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "helper.itemView");
        MsgRecord msgRecord = data.getMsgRecord();
        QUICheckBox qUICheckBox = this.$checkView;
        Function2<Boolean, Boolean, Unit> a16 = this.this$0.a1();
        final ImageView imageView3 = this.$iv;
        final ChatHistorySelectMediaAdapter chatHistorySelectMediaAdapter4 = this.this$0;
        chatHistorySelectMediaAdapter3.b1(view, msgRecord, data, qUICheckBox, a16, new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.selectmedia.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChatHistorySelectMediaAdapter$ContentItemProvider$convert$1.b(xi.c.this, data, imageView3, chatHistorySelectMediaAdapter4, view2);
            }
        });
        this.this$0.R0(this.$checkView, data.j());
    }
}
