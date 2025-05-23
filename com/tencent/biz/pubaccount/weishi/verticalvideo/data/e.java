package com.tencent.biz.pubaccount.weishi.verticalvideo.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\r\u0012\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/e;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "feedId", "", "b", "I", "c", "()I", "scene", "", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "videoFeedTypeMap", "Lkz/a;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "Lkz/a;", "()Lkz/a;", "listener", "<init>", "(Ljava/lang/String;ILjava/util/Map;Lkz/a;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String feedId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int scene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Integer> videoFeedTypeMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final kz.a<j> listener;

    public e(String feedId, int i3, Map<String, Integer> videoFeedTypeMap, kz.a<j> listener) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(videoFeedTypeMap, "videoFeedTypeMap");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.feedId = feedId;
        this.scene = i3;
        this.videoFeedTypeMap = videoFeedTypeMap;
        this.listener = listener;
    }

    /* renamed from: a, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    public final kz.a<j> b() {
        return this.listener;
    }

    /* renamed from: c, reason: from getter */
    public final int getScene() {
        return this.scene;
    }

    public final Map<String, Integer> d() {
        return this.videoFeedTypeMap;
    }
}
