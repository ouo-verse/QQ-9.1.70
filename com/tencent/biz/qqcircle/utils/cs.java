package com.tencent.biz.qqcircle.utils;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Lfeedcloud/FeedCloudCommon$StCommonExt;", "", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class cs {
    @NotNull
    public static final String a(@NotNull FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, @NotNull String key, @NotNull String defaultValue) {
        Object obj;
        Intrinsics.checkNotNullParameter(feedCloudCommon$StCommonExt, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        List<FeedCloudCommon$Entry> list = feedCloudCommon$StCommonExt.mapInfo.get();
        Intrinsics.checkNotNullExpressionValue(list, "mapInfo.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((FeedCloudCommon$Entry) obj).key.get(), key)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        FeedCloudCommon$Entry feedCloudCommon$Entry = (FeedCloudCommon$Entry) obj;
        if (feedCloudCommon$Entry != null) {
            String str = feedCloudCommon$Entry.value.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.value.get()");
            return str;
        }
        return defaultValue;
    }
}
