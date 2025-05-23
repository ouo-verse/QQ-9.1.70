package com.tencent.mobileqq.guild.media.core.notify;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/notify/z;", "Lcom/tencent/mobileqq/guild/media/core/notify/x;", "", "d", "I", "b", "()I", "oldSpeakModel", "e", "a", "newSpeakModel", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class z implements x {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int oldSpeakModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int newSpeakModel;

    public z(int i3, int i16) {
        this.oldSpeakModel = i3;
        this.newSpeakModel = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getNewSpeakModel() {
        return this.newSpeakModel;
    }

    /* renamed from: b, reason: from getter */
    public final int getOldSpeakModel() {
        return this.oldSpeakModel;
    }
}
