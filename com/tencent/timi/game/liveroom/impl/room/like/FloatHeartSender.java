package com.tencent.timi.game.liveroom.impl.room.like;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.heart.FloatHeart;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.sso.request.QQLiveLikeRequest;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u000bJ\b\u0010\u0013\u001a\u00020\u000bH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/like/FloatHeartSender;", "", "()V", "clickedHeartList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/heart/FloatHeart;", "Lkotlin/collections/ArrayList;", "lastSendHeartTime", "", "lastTouchTime", "sendFloatHeart", "", "roomId", "isComboBegin", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "", "likeResId", "sendFloatHeartEnd", "sendRequest", "Companion", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class FloatHeartSender {
    public static final long CLICK_HEART_INTERVAL_MS = 100;
    public static final long SEND_HEART_INTERVAL_MS = 3000;

    @NotNull
    public static final String TAG = "Like_Biz|FloatHeartSender";

    @NotNull
    private final ArrayList<FloatHeart> clickedHeartList = new ArrayList<>();
    private long lastSendHeartTime;
    private long lastTouchTime;

    private final void sendRequest() {
        ArrayList arrayList = new ArrayList(this.clickedHeartList);
        AegisLogger.INSTANCE.i(TAG, "sendRequest", "likeSize:" + this.clickedHeartList.size());
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveLikeRequest(arrayList), new Function1<QQLiveResponse<yq4.c>, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.like.FloatHeartSender$sendRequest$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<yq4.c> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<yq4.c> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isFailed() && it.getRsp() != null) {
                    AegisLogger.INSTANCE.d(FloatHeartSender.TAG, "sendRequest", "success");
                    return;
                }
                AegisLogger.INSTANCE.w(FloatHeartSender.TAG, "sendRequest", "failed, retCode=" + it.getRetCode() + ", errMsg=" + it.getErrMsg());
            }
        });
        this.clickedHeartList.clear();
    }

    public final void sendFloatHeart(long roomId, boolean isComboBegin, @NotNull String materialId, @NotNull String likeResId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        Intrinsics.checkNotNullParameter(likeResId, "likeResId");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastTouchTime < 100) {
            return;
        }
        FloatHeart floatHeart = new FloatHeart();
        floatHeart.firstLike = isComboBegin;
        floatHeart.roomId = roomId;
        floatHeart.materialId = materialId;
        floatHeart.anchorId = com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomId, 0, 2, null);
        floatHeart.likeResId = likeResId;
        this.lastTouchTime = currentTimeMillis;
        this.clickedHeartList.add(floatHeart);
        SimpleEventBus.getInstance().dispatchEvent(new LocalLikeEvent(materialId, likeResId));
        if (currentTimeMillis - this.lastSendHeartTime < 3000) {
            return;
        }
        this.lastSendHeartTime = currentTimeMillis;
        sendRequest();
    }

    public final void sendFloatHeartEnd() {
        if (this.clickedHeartList.isEmpty()) {
            return;
        }
        this.lastSendHeartTime = System.currentTimeMillis();
        sendRequest();
    }
}
