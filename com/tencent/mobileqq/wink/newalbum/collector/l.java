package com.tencent.mobileqq.wink.newalbum.collector;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0003\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/l;", "", "", "a", "I", "e", "()I", "sameDayCount", "b", "eachCount", "", "c", "D", "()D", "maxTextSimilarityThreshould", "d", "minTextSimilarityThreshould", "g", "storyIntervalNums", "", "f", "Z", "()Z", "shouldClearStoryDBTableAfterCollector", "dropoutDisplayedPhotoRate", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int sameDayCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int eachCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final double maxTextSimilarityThreshould;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int minTextSimilarityThreshould;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int storyIntervalNums;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean shouldClearStoryDBTableAfterCollector;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final double dropoutDisplayedPhotoRate;

    public l() {
        w83.b bVar = w83.b.f445025a;
        this.sameDayCount = bVar.h();
        this.eachCount = bVar.j();
        this.maxTextSimilarityThreshould = bVar.o();
        this.storyIntervalNums = bVar.k();
        this.shouldClearStoryDBTableAfterCollector = bVar.A();
        this.dropoutDisplayedPhotoRate = bVar.i();
    }

    /* renamed from: a, reason: from getter */
    public final double getDropoutDisplayedPhotoRate() {
        return this.dropoutDisplayedPhotoRate;
    }

    /* renamed from: b, reason: from getter */
    public final int getEachCount() {
        return this.eachCount;
    }

    /* renamed from: c, reason: from getter */
    public final double getMaxTextSimilarityThreshould() {
        return this.maxTextSimilarityThreshould;
    }

    /* renamed from: d, reason: from getter */
    public final int getMinTextSimilarityThreshould() {
        return this.minTextSimilarityThreshould;
    }

    /* renamed from: e, reason: from getter */
    public final int getSameDayCount() {
        return this.sameDayCount;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getShouldClearStoryDBTableAfterCollector() {
        return this.shouldClearStoryDBTableAfterCollector;
    }

    /* renamed from: g, reason: from getter */
    public final int getStoryIntervalNums() {
        return this.storyIntervalNums;
    }
}
