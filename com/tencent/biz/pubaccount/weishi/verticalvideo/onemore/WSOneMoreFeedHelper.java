package com.tencent.biz.pubaccount.weishi.verticalvideo.onemore;

import UserGrowth.stSimpleMetaFeed;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.weishi.player.wrapper.f;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.WSOneMoreFeedHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b1\u00102J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u000bR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010%R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR$\u00100\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010,\u001a\u0004\b)\u0010-\"\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/WSOneMoreFeedHelper;", "", "", "reqFeedId", "LUserGrowth/stSimpleMetaFeed;", "rspFeed", "", "j", "", "k", "feed", "", "i", "curFeed", "", "curProgress", "f", "feedId", "position", "l", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/d;", "a", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/d;", "fetcher", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "g", "()Landroid/os/Handler;", "handler", "c", "Z", "hasRequested", "d", "Ljava/lang/String;", "curFeedId", "e", "I", "curPosition", "watchedPosition", "curContinuousNum", h.F, "isContinuousMaxNum", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/a;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/a;", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/a;)V", "insertToNextCallback", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/d;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSOneMoreFeedHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final d fetcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean hasRequested;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String curFeedId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int curPosition;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int watchedPosition;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int curContinuousNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isContinuousMaxNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private a insertToNextCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/onemore/WSOneMoreFeedHelper$b", "Lcom/tencent/biz/pubaccount/weishi/player/wrapper/f$a;", "", "videoVid", "downloadString", "", "a", "", "errorCode", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements f.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f82216b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ stSimpleMetaFeed f82217c;

        b(String str, stSimpleMetaFeed stsimplemetafeed) {
            this.f82216b = str;
            this.f82217c = stsimplemetafeed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(WSOneMoreFeedHelper this$0, String str, stSimpleMetaFeed stsimplemetafeed) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean k3 = this$0.k(str);
            x.j("WSOneMoreFeedHelper", "preload feed success. isVideoChanged = " + k3);
            if (k3) {
                return;
            }
            this$0.curContinuousNum++;
            com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.b.d(stsimplemetafeed);
            a insertToNextCallback = this$0.getInsertToNextCallback();
            if (insertToNextCallback != null) {
                insertToNextCallback.a(stsimplemetafeed);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f.a
        public void a(String videoVid, String downloadString) {
            Handler g16 = WSOneMoreFeedHelper.this.g();
            final WSOneMoreFeedHelper wSOneMoreFeedHelper = WSOneMoreFeedHelper.this;
            final String str = this.f82216b;
            final stSimpleMetaFeed stsimplemetafeed = this.f82217c;
            g16.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.e
                @Override // java.lang.Runnable
                public final void run() {
                    WSOneMoreFeedHelper.b.d(WSOneMoreFeedHelper.this, str, stsimplemetafeed);
                }
            });
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f.a
        public void b(String videoVid, int errorCode, String downloadString) {
            x.j("WSOneMoreFeedHelper", "preload feed failed.");
        }
    }

    public WSOneMoreFeedHelper(d fetcher) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.fetcher = fetcher;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.WSOneMoreFeedHelper$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.handler = lazy;
        this.curFeedId = "";
        this.watchedPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler g() {
        return (Handler) this.handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(String reqFeedId) {
        return !Intrinsics.areEqual(reqFeedId, this.curFeedId) || this.curPosition <= this.watchedPosition;
    }

    public final void f(final stSimpleMetaFeed curFeed, long curProgress) {
        int i3 = i(curFeed);
        if (i3 == 0 || curProgress <= i3 || this.hasRequested || this.curPosition <= this.watchedPosition) {
            return;
        }
        c cVar = c.f82219a;
        if (!cVar.d() || this.curPosition < cVar.a()) {
            return;
        }
        if (this.curContinuousNum >= cVar.b()) {
            this.isContinuousMaxNum = true;
            return;
        }
        this.hasRequested = true;
        this.fetcher.a(curFeed != null ? curFeed.f25129id : null, new Function1<stSimpleMetaFeed, Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.WSOneMoreFeedHelper$checkIfNeedFetchOnMoreFeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(stSimpleMetaFeed stsimplemetafeed) {
                invoke2(stsimplemetafeed);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(stSimpleMetaFeed stsimplemetafeed) {
                WSOneMoreFeedHelper wSOneMoreFeedHelper = WSOneMoreFeedHelper.this;
                stSimpleMetaFeed stsimplemetafeed2 = curFeed;
                wSOneMoreFeedHelper.j(stsimplemetafeed2 != null ? stsimplemetafeed2.f25129id : null, stsimplemetafeed);
            }
        });
        com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.b.f(curFeed);
    }

    /* renamed from: h, reason: from getter */
    public final a getInsertToNextCallback() {
        return this.insertToNextCallback;
    }

    public final void l(String feedId, int position) {
        if (Intrinsics.areEqual(this.curFeedId, feedId)) {
            return;
        }
        int i3 = this.curPosition;
        if (position <= i3) {
            if (this.hasRequested) {
                this.watchedPosition = Math.max(i3, this.watchedPosition);
            }
        } else {
            this.watchedPosition = Math.max(i3, this.watchedPosition);
        }
        x.j("WSOneMoreFeedHelper", "onVideoSelected() feedId = " + feedId + ", position = " + position + ", watchedPosition = " + this.watchedPosition);
        this.curPosition = position;
        this.hasRequested = false;
        if (feedId == null) {
            feedId = "";
        }
        this.curFeedId = feedId;
        if (this.isContinuousMaxNum) {
            this.curContinuousNum = 0;
            this.isContinuousMaxNum = false;
        }
    }

    public final void m(a aVar) {
        this.insertToNextCallback = aVar;
    }

    private final int i(stSimpleMetaFeed feed) {
        return Math.max(feed != null ? feed.oneMoreThreshold : 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String reqFeedId, stSimpleMetaFeed rspFeed) {
        x.j("WSOneMoreFeedHelper", "preload feed. reqFeedId = " + reqFeedId + ", id = " + (rspFeed != null ? rspFeed.f25129id : null) + ", desc = " + (rspFeed != null ? rspFeed.feed_desc : null));
        if (rspFeed != null && !k(reqFeedId)) {
            com.tencent.biz.pubaccount.weishi.cache.e.c(rspFeed, new b(reqFeedId, rspFeed));
        } else {
            this.curContinuousNum = 0;
        }
    }
}
