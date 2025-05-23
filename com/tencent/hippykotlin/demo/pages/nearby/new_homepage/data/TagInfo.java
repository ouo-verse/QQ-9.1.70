package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data;

import kotlin.jvm.internal.DefaultConstructorMarker;
import t35.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TagInfo {
    public final a tag;
    public float viewWith;

    public TagInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final int hashCode() {
        return this.tag.f435362d;
    }

    public TagInfo(a aVar) {
        this.tag = aVar;
    }

    public /* synthetic */ TagInfo(a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new a(0, null, 63));
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof TagInfo) && ((TagInfo) obj).tag.f435362d == this.tag.f435362d;
    }
}
