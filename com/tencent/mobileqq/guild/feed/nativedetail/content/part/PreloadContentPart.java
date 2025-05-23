package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001c\u0010\u0014\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0017\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R'\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/PreloadContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "action", "", "args", "", "A9", "B9", "Ltl1/g$q;", "message", "C9", "Ltl1/g$u;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "feedDetailMain", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartPause", "onPartStop", "handleBroadcastMessage", "", "Lsl1/b;", "Lhl1/g;", "d", "Lkotlin/Lazy;", "z9", "()Ljava/util/List;", "processors", "", "e", "Z", "hasPaused", "<init>", "()V", "f", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PreloadContentPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy processors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasPaused;

    public PreloadContentPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends sl1.b<? super hl1.g>>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.PreloadContentPart$processors$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends sl1.b<? super hl1.g>> invoke() {
                List<? extends sl1.b<? super hl1.g>> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new sl1.b[]{new sl1.c(), new sl1.d()});
                return listOf;
            }
        });
        this.processors = lazy;
    }

    private final void A9(String action, Object args) {
        g.OnLoadMainCompletedMessage onLoadMainCompletedMessage;
        if (args instanceof g.OnLoadMainCompletedMessage) {
            onLoadMainCompletedMessage = (g.OnLoadMainCompletedMessage) args;
        } else {
            onLoadMainCompletedMessage = null;
        }
        if (onLoadMainCompletedMessage == null) {
            return;
        }
        C9(onLoadMainCompletedMessage);
        List<hl1.g> a16 = onLoadMainCompletedMessage.a();
        if (a16 != null) {
            for (hl1.g gVar : a16) {
                Iterator<T> it = z9().iterator();
                while (it.hasNext()) {
                    sl1.b bVar = (sl1.b) it.next();
                    if (bVar.b(action, gVar)) {
                        bVar.a(gVar);
                    }
                }
            }
        }
    }

    private final void B9(String action, Object args) {
        g.OnPreloadMainCompletedMessage onPreloadMainCompletedMessage;
        FeedDetailMainData feedDetailMainData;
        g.OnGetFeedDetailMainDataMessage onGetFeedDetailMainDataMessage = null;
        if (args instanceof g.OnPreloadMainCompletedMessage) {
            onPreloadMainCompletedMessage = (g.OnPreloadMainCompletedMessage) args;
        } else {
            onPreloadMainCompletedMessage = null;
        }
        if (onPreloadMainCompletedMessage == null || !onPreloadMainCompletedMessage.getIsSuccess()) {
            return;
        }
        Object broadcastGetMessage = broadcastGetMessage("action_get_detail_main_data", null);
        if (broadcastGetMessage instanceof g.OnGetFeedDetailMainDataMessage) {
            onGetFeedDetailMainDataMessage = (g.OnGetFeedDetailMainDataMessage) broadcastGetMessage;
        }
        if (onGetFeedDetailMainDataMessage != null && (feedDetailMainData = onGetFeedDetailMainDataMessage.getFeedDetailMainData()) != null) {
            D9(onPreloadMainCompletedMessage, feedDetailMainData);
            Iterator<T> it = z9().iterator();
            while (it.hasNext()) {
                sl1.b bVar = (sl1.b) it.next();
                if (bVar.b(action, feedDetailMainData)) {
                    bVar.a(feedDetailMainData);
                }
            }
        }
    }

    private final void C9(g.OnLoadMainCompletedMessage message) {
        g.OnGetFeedDetailMainDataMessage onGetFeedDetailMainDataMessage;
        try {
            FeedDetailMainData feedDetailMainData = null;
            Object broadcastGetMessage = broadcastGetMessage("action_get_detail_main_data", null);
            if (broadcastGetMessage instanceof g.OnGetFeedDetailMainDataMessage) {
                onGetFeedDetailMainDataMessage = (g.OnGetFeedDetailMainDataMessage) broadcastGetMessage;
            } else {
                onGetFeedDetailMainDataMessage = null;
            }
            if (onGetFeedDetailMainDataMessage != null) {
                feedDetailMainData = onGetFeedDetailMainDataMessage.getFeedDetailMainData();
            }
            FeedDetailMainData feedDetailMainData2 = feedDetailMainData;
            com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
            cVar.q(partHost, "stage_finish", message.getIsSuccess(), feedDetailMainData2, true, getPartRootView(), new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.PreloadContentPart$reportMainDataComplete$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    boolean z16;
                    z16 = PreloadContentPart.this.hasPaused;
                    return Boolean.valueOf(!z16);
                }
            });
        } catch (Exception e16) {
            QLog.e("PreloadContentPart", 1, "reportPreloadComplete exception: " + e16.getMessage());
        }
    }

    private final void D9(g.OnPreloadMainCompletedMessage message, FeedDetailMainData feedDetailMain) {
        try {
            if (message.getUseCacheToRender()) {
                com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
                IPartHost partHost = getPartHost();
                Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
                cVar.q(partHost, "stage_cache_first_frame_finish", message.getIsSuccess(), feedDetailMain, false, getPartRootView(), new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.PreloadContentPart$reportPreloadComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Boolean invoke() {
                        boolean z16;
                        z16 = PreloadContentPart.this.hasPaused;
                        return Boolean.valueOf(!z16);
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("PreloadContentPart", 1, "reportPreloadComplete exception: " + e16.getMessage());
        }
    }

    private final List<sl1.b<hl1.g>> z9() {
        return (List) this.processors.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_on_load_main_completed")) {
            A9(action, args);
        } else if (Intrinsics.areEqual(action, "message_on_preload_main_completed")) {
            B9(action, args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.hasPaused = true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        this.hasPaused = true;
    }
}
