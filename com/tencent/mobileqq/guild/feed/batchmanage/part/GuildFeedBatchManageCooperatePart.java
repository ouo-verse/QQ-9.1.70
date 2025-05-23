package com.tencent.mobileqq.guild.feed.batchmanage.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageCooperatePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "selectedFeedPosition", "", "channelId", "", "A9", "D9", "E9", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "batchOperationType", "F9", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedBatchManageCooperatePart extends Part {
    private final void A9(final int selectedFeedPosition, final long channelId) {
        final String str;
        boolean z16;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("default_select_feed_id");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && selectedFeedPosition != -1) {
            RFWIocAbilityProvider.g().getIoc(vi1.f.class).originView(getPartRootView()).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.l
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    GuildFeedBatchManageCooperatePart.B9(selectedFeedPosition, str, channelId, (vi1.f) obj);
                }
            }).run();
            RFWIocAbilityProvider.g().getIoc(vi1.e.class).originView(getPartRootView()).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.m
                @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
                public final void onDone(Object obj) {
                    GuildFeedBatchManageCooperatePart.C9(selectedFeedPosition, (vi1.e) obj);
                }
            }).run();
            return;
        }
        QLog.w(getLogTag(), 1, "feedId=" + str + ", feedPos=" + selectedFeedPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(int i3, String str, long j3, vi1.f fVar) {
        if (fVar != null) {
            fVar.c(i3, str, j3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(int i3, vi1.e eVar) {
        if (eVar != null) {
            eVar.B1(i3);
        }
    }

    private final void D9() {
        G9();
    }

    private final void E9() {
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        boolean z16 = false;
        if (bVar != null && 15 == vi1.c.e(bVar)) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        G9();
    }

    private final void G9() {
        Bundle arguments;
        Serializable serializable;
        SimpleBaseEvent simpleBaseEvent;
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar != null && (arguments = bVar.getArguments()) != null && (serializable = arguments.getSerializable("old_page_refresh_event")) != null) {
            if (serializable instanceof SimpleBaseEvent) {
                simpleBaseEvent = (SimpleBaseEvent) serializable;
            } else {
                simpleBaseEvent = null;
            }
            if (simpleBaseEvent != null) {
                SimpleEventBus.getInstance().dispatchEvent(simpleBaseEvent);
            }
        }
    }

    public final void F9(int batchOperationType) {
        Serializable serializable;
        Bundle arguments;
        if (batchOperationType != 1) {
            if (batchOperationType == 2) {
                D9();
            }
        } else {
            E9();
        }
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar != null && (arguments = bVar.getArguments()) != null) {
            serializable = arguments.getSerializable("source");
        } else {
            serializable = null;
        }
        if (Intrinsics.areEqual(serializable, "source_from_feed_square")) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        broadcastMessage("BROADCAST_REFRESH", null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        Pair pair;
        if (Intrinsics.areEqual(action, "broadcast_first_screen_dataset")) {
            if (args instanceof Pair) {
                pair = (Pair) args;
            } else {
                pair = null;
            }
            if (pair == null) {
                pair = TuplesKt.to(-1, 0L);
            }
            Object component1 = pair.component1();
            Object component2 = pair.component2();
            if ((component1 instanceof Integer) && (component2 instanceof Long)) {
                A9(((Number) component1).intValue(), ((Number) component2).longValue());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new GuildFeedBatchManageCooperatePart$onInitView$$inlined$eventFlow$1(simpleEventBus, null)), new GuildFeedBatchManageCooperatePart$onInitView$1(this, null)), com.tencent.mobileqq.guild.feed.part.a.d(this));
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus2, "getInstance()");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new GuildFeedBatchManageCooperatePart$onInitView$$inlined$eventFlow$2(simpleEventBus2, null)), new GuildFeedBatchManageCooperatePart$onInitView$2(this, null)), com.tencent.mobileqq.guild.feed.part.a.d(this));
    }
}
