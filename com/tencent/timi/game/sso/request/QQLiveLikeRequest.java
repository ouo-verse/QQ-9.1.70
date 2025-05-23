package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.heart.FloatHeart;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yq4.b;
import yq4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveLikeRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "floatHearts", "", "Lcom/tencent/mobileqq/qqlive/data/heart/FloatHeart;", "(Ljava/util/List;)V", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getMainCmd", "", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getSubCmd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class QQLiveLikeRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    private final List<FloatHeart> floatHearts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QQLiveLikeRequest(@NotNull List<? extends FloatHeart> floatHearts) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        Intrinsics.checkNotNullParameter(floatHearts, "floatHearts");
        this.floatHearts = floatHearts;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) c.c(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveLikeRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getMainCmd */
    public String getService() {
        return "trpc.qlive.live_room_like_svr.LiveRoomLikeSvr";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        Object orNull;
        long j3;
        Object orNull2;
        boolean z16;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        b bVar = new b();
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.floatHearts, 0);
        FloatHeart floatHeart = (FloatHeart) orNull;
        long j16 = 0;
        if (floatHeart != null) {
            j3 = floatHeart.roomId;
        } else {
            j3 = 0;
        }
        bVar.f451027b = j3;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.floatHearts, 0);
        FloatHeart floatHeart2 = (FloatHeart) orNull2;
        if (floatHeart2 != null) {
            j16 = floatHeart2.anchorId;
        }
        bVar.f451031f = j16;
        List<FloatHeart> list = this.floatHearts;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((FloatHeart) it.next()).firstLike) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        bVar.f451026a = z16;
        List<FloatHeart> list2 = this.floatHearts;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList.add(((FloatHeart) it5.next()).materialId);
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bVar.f451029d = (String[]) array;
        bVar.f451028c = this.floatHearts.size();
        List<FloatHeart> list3 = this.floatHearts;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it6 = list3.iterator();
        while (it6.hasNext()) {
            arrayList2.add(((FloatHeart) it6.next()).likeResId);
        }
        Object[] array2 = arrayList2.toArray(new String[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bVar.f451032g = (String[]) array2;
        return bVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getSubCmd */
    public String getMethod() {
        return "UserLikeAction";
    }
}
