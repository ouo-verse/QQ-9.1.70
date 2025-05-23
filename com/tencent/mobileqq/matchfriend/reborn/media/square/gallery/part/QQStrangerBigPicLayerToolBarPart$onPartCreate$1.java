package com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part;

import android.os.Handler;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerBigPicCommentFeedSuccessEvent;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
final class QQStrangerBigPicLayerToolBarPart$onPartCreate$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ QQStrangerBigPicLayerToolBarPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerBigPicLayerToolBarPart$onPartCreate$1(QQStrangerBigPicLayerToolBarPart qQStrangerBigPicLayerToolBarPart) {
        super(1);
        this.this$0 = qQStrangerBigPicLayerToolBarPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQStrangerBigPicLayerToolBarPart this$0) {
        FeedPB$Feed feedPB$Feed;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        feedPB$Feed = this$0.feed;
        this$0.X9(feedPB$Feed);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke2(num);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num) {
        FeedPB$Feed feedPB$Feed;
        FeedPB$Feed feedPB$Feed2;
        FeedPB$Feed feedPB$Feed3;
        feedPB$Feed = this.this$0.feed;
        u72.a.k(feedPB$Feed, u72.a.a(feedPB$Feed) + 1);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final QQStrangerBigPicLayerToolBarPart qQStrangerBigPicLayerToolBarPart = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.media.square.gallery.part.i
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerBigPicLayerToolBarPart$onPartCreate$1.b(QQStrangerBigPicLayerToolBarPart.this);
            }
        });
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        feedPB$Feed2 = this.this$0.feed;
        String str = feedPB$Feed2.feed_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "feed.feed_id.get()");
        feedPB$Feed3 = this.this$0.feed;
        simpleEventBus.dispatchEvent(new QQStrangerBigPicCommentFeedSuccessEvent(str, u72.a.a(feedPB$Feed3)));
    }
}
