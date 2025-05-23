package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0007"}, d2 = {"", "Lfeedcloud/FeedCloudMeta$StTagInfo;", "", "name", "c", "a", "b", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "QFSTagInfosUtil")
/* loaded from: classes4.dex */
public final class QFSTagInfosUtil {
    @NotNull
    public static final String a(@NotNull List<FeedCloudMeta$StTagInfo> list) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(list, "<this>");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, "|", null, null, 0, null, new Function1<FeedCloudMeta$StTagInfo, CharSequence>() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.QFSTagInfosUtil$idReportStr$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull FeedCloudMeta$StTagInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String str = it.tagId.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.tagId.get()");
                return str;
            }
        }, 30, null);
        return joinToString$default;
    }

    @NotNull
    public static final String b(@NotNull List<FeedCloudMeta$StTagInfo> list) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(list, "<this>");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, "|", null, null, 0, null, new Function1<FeedCloudMeta$StTagInfo, CharSequence>() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage.QFSTagInfosUtil$reportStr$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull FeedCloudMeta$StTagInfo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String str = it.tagName.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.tagName.get()");
                return str;
            }
        }, 30, null);
        return joinToString$default;
    }

    @Nullable
    public static final FeedCloudMeta$StTagInfo c(@NotNull List<FeedCloudMeta$StTagInfo> list, @NotNull String name) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((FeedCloudMeta$StTagInfo) obj).tagName.get(), name)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (FeedCloudMeta$StTagInfo) obj;
    }
}
