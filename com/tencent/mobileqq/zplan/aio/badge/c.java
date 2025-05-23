package com.tencent.mobileqq.zplan.aio.badge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/c;", "", "", "a", "I", "getType", "()I", "type", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "c", "lifeTime", "<init>", "(ILjava/lang/String;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int lifeTime;

    public c(int i3, String text, int i16) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.type = i3;
        this.text = text;
        this.lifeTime = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getLifeTime() {
        return this.lifeTime;
    }

    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }
}
