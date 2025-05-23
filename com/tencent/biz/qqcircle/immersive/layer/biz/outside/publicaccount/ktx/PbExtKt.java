package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx;

import com.tencent.biz.qqcircle.beans.HotEventInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a \u0010\u0006\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u001a\u0018\u0010\t\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\b\u001a\u00020\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\u0000\u001a \u0010\u000e\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\f0\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\r\u001a\u0018\u0010\u000f\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\f0\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "Lfeedcloud/FeedCloudCommon$Entry;", "", "key", "value", "", "a", "Lcom/tencent/biz/qqcircle/beans/HotEventInfo;", "hotEventInfo", "b", "Lfeedcloud/FeedCloudMeta$StFeed;", "e", "Lfeedcloud/FeedCloudCommon$BytesEntry;", "", "c", "d", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class PbExtKt {
    public static final void a(@NotNull PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField, @NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(pBRepeatMessageField, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set(key);
        feedCloudCommon$Entry.value.set(value);
        pBRepeatMessageField.add(feedCloudCommon$Entry);
    }

    public static final void b(@NotNull PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField, @NotNull HotEventInfo hotEventInfo) {
        Intrinsics.checkNotNullParameter(pBRepeatMessageField, "<this>");
        Intrinsics.checkNotNullParameter(hotEventInfo, "hotEventInfo");
        a(pBRepeatMessageField, "TopicID", hotEventInfo.getId());
        a(pBRepeatMessageField, "RankNo", String.valueOf(hotEventInfo.getRank()));
    }

    public static final void c(@NotNull PBRepeatMessageField<FeedCloudCommon$BytesEntry> pBRepeatMessageField, @NotNull String key, @NotNull byte[] value) {
        Intrinsics.checkNotNullParameter(pBRepeatMessageField, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        d(pBRepeatMessageField, key);
        FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
        feedCloudCommon$BytesEntry.key.set(key);
        feedCloudCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(value));
        pBRepeatMessageField.add(feedCloudCommon$BytesEntry);
    }

    public static final void d(@NotNull PBRepeatMessageField<FeedCloudCommon$BytesEntry> pBRepeatMessageField, @NotNull final String key) {
        Intrinsics.checkNotNullParameter(pBRepeatMessageField, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        List<FeedCloudCommon$BytesEntry> list = pBRepeatMessageField.get();
        Intrinsics.checkNotNullExpressionValue(list, "this.get()");
        CollectionsKt__MutableCollectionsKt.removeAll((List) list, (Function1) new Function1<FeedCloudCommon$BytesEntry, Boolean>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt$removeKey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry) {
                return Boolean.valueOf(Intrinsics.areEqual(feedCloudCommon$BytesEntry.key.get(), key));
            }
        });
    }

    @NotNull
    public static final String e(@NotNull PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(pBRepeatMessageField, "<this>");
        List<FeedCloudMeta$StFeed> list = pBRepeatMessageField.get();
        Intrinsics.checkNotNullExpressionValue(list, "this.get()");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<FeedCloudMeta$StFeed, CharSequence>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.PbExtKt$toIds$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
                String str = feedCloudMeta$StFeed.f398449id.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.id.get()");
                return str;
            }
        }, 31, null);
        return joinToString$default;
    }
}
