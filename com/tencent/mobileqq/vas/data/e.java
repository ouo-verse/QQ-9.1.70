package com.tencent.mobileqq.vas.data;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0018\u0010\bR'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b\u0012\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/data/e;", "", "", "a", "Ljava/lang/String;", "getBubbleText", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "bubbleText", "", "b", "I", "e", "()I", "j", "(I)V", "maxVisitorNum", "c", "g", "bubbleInterval", "d", "i", "defaultBgUrl", "f", "bgUrl", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/vas/data/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "changeDatas", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int maxVisitorNum;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String bubbleText = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int bubbleInterval = 1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String defaultBgUrl = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String bgUrl = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<c> changeDatas = new ArrayList<>();

    /* renamed from: a, reason: from getter */
    public final String getBgUrl() {
        return this.bgUrl;
    }

    /* renamed from: b, reason: from getter */
    public final int getBubbleInterval() {
        return this.bubbleInterval;
    }

    public final ArrayList<c> c() {
        return this.changeDatas;
    }

    /* renamed from: d, reason: from getter */
    public final String getDefaultBgUrl() {
        return this.defaultBgUrl;
    }

    /* renamed from: e, reason: from getter */
    public final int getMaxVisitorNum() {
        return this.maxVisitorNum;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bgUrl = str;
    }

    public final void g(int i3) {
        this.bubbleInterval = i3;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bubbleText = str;
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultBgUrl = str;
    }

    public final void j(int i3) {
        this.maxVisitorNum = i3;
    }
}
