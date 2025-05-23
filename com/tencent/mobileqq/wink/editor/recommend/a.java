package com.tencent.mobileqq.wink.editor.recommend;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudTagcategorysvr$StTagCategoryRecomRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\f\u001a\u00020\tR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R4\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0012\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/recommend/a;", "", "", "traceId", "", "", "buffers", "Lfeedcloud/FeedCloudTagcategorysvr$StTagCategoryRecomRsp;", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "", "e", "f", "a", "<set-?>", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "c", "Ljava/util/List;", "()Ljava/util/List;", "Lfeedcloud/FeedCloudTagcategorysvr$StTagCategoryRecomRsp;", "()Lfeedcloud/FeedCloudTagcategorysvr$StTagCategoryRecomRsp;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f321459a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String traceId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static List<byte[]> buffers;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static FeedCloudTagcategorysvr$StTagCategoryRecomRsp tags;

    a() {
    }

    public final void a() {
        com.tencent.xaction.log.b.a("ExtractFramesStore", 1, "[clean]");
        traceId = "";
        buffers = null;
        tags = null;
    }

    @Nullable
    public final List<byte[]> b() {
        return buffers;
    }

    @Nullable
    public final FeedCloudTagcategorysvr$StTagCategoryRecomRsp c() {
        return tags;
    }

    @NotNull
    public final String d() {
        return traceId;
    }

    public final void e(@NotNull String traceId2, @Nullable List<byte[]> buffers2, @Nullable FeedCloudTagcategorysvr$StTagCategoryRecomRsp tags2) {
        Integer num;
        PBRepeatMessageField<FeedCloudMeta$StTagInfo> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(traceId2, "traceId");
        String str = traceId;
        Integer num2 = null;
        if (buffers2 != null) {
            num = Integer.valueOf(buffers2.size());
        } else {
            num = null;
        }
        if (tags2 != null && (pBRepeatMessageField = tags2.tagList) != null) {
            num2 = Integer.valueOf(pBRepeatMessageField.size());
        }
        com.tencent.xaction.log.b.a("ExtractFramesStore", 1, "[store] oldTraceId=" + str + ", traceId=" + traceId2 + ", buffer size=" + num + ", tags size=" + num2);
        traceId = traceId2;
        buffers = buffers2;
        tags = tags2;
    }

    public final void f(@NotNull String traceId2, @Nullable List<byte[]> buffers2, @Nullable FeedCloudTagcategorysvr$StTagCategoryRecomRsp tags2) {
        Integer num;
        PBRepeatMessageField<FeedCloudMeta$StTagInfo> pBRepeatMessageField;
        Intrinsics.checkNotNullParameter(traceId2, "traceId");
        String str = traceId;
        Integer num2 = null;
        if (buffers2 != null) {
            num = Integer.valueOf(buffers2.size());
        } else {
            num = null;
        }
        if (tags2 != null && (pBRepeatMessageField = tags2.tagList) != null) {
            num2 = Integer.valueOf(pBRepeatMessageField.size());
        }
        com.tencent.xaction.log.b.a("ExtractFramesStore", 1, "[update] oldTraceId=" + str + ", traceId=" + traceId2 + ", buffer size=" + num + ", tags size=" + num2);
        if (Intrinsics.areEqual(traceId, traceId2)) {
            tags = tags2;
        }
    }
}
