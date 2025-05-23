package com.tencent.mobileqq.matchfriend.aio.quote;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\t\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "avatar", "f", "title", "c", "content", "d", "e", "image", "feedId", "", "Lcom/tencent/mobileqq/matchfriend/aio/quote/a;", "Ljava/util/List;", "()Ljava/util/List;", "actions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.aio.quote.c, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerQuoteData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String avatar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String content;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String image;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String feedId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<QQStrangerQuoteAction> actions;

    public QQStrangerQuoteData(String avatar, String title, String content, String image, String feedId, List<QQStrangerQuoteAction> actions) {
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.avatar = avatar;
        this.title = title;
        this.content = content;
        this.image = image;
        this.feedId = feedId;
        this.actions = actions;
    }

    public final List<QQStrangerQuoteAction> a() {
        return this.actions;
    }

    /* renamed from: b, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: c, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: d, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: e, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((this.avatar.hashCode() * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.image.hashCode()) * 31) + this.feedId.hashCode()) * 31) + this.actions.hashCode();
    }

    public String toString() {
        return "QQStrangerQuoteData(avatar=" + this.avatar + ", title=" + this.title + ", content=" + this.content + ", image=" + this.image + ", feedId=" + this.feedId + ", actions=" + this.actions + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerQuoteData)) {
            return false;
        }
        QQStrangerQuoteData qQStrangerQuoteData = (QQStrangerQuoteData) other;
        return Intrinsics.areEqual(this.avatar, qQStrangerQuoteData.avatar) && Intrinsics.areEqual(this.title, qQStrangerQuoteData.title) && Intrinsics.areEqual(this.content, qQStrangerQuoteData.content) && Intrinsics.areEqual(this.image, qQStrangerQuoteData.image) && Intrinsics.areEqual(this.feedId, qQStrangerQuoteData.feedId) && Intrinsics.areEqual(this.actions, qQStrangerQuoteData.actions);
    }
}
