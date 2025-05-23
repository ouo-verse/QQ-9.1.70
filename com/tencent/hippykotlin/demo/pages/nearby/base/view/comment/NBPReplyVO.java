package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import kotlin.jvm.internal.Intrinsics;
import p35.ae;
import p35.i;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPReplyVO {
    public final int cTime;
    public final i content;

    /* renamed from: id, reason: collision with root package name */
    public final String f114214id;
    public final long key = NBPCommentVOKt.access$getNextKey();
    public final ae raw;
    public final boolean submitted;
    public final af targetUser;
    public final af user;

    public NBPReplyVO(ae aeVar) {
        this.raw = aeVar;
        String str = aeVar.f425131f;
        this.f114214id = str;
        this.user = aeVar.f425129d;
        this.cTime = aeVar.f425130e;
        this.targetUser = aeVar.f425134m;
        this.content = aeVar.f425132h;
        this.submitted = str.length() > 0;
    }

    public final int hashCode() {
        return this.raw.hashCode();
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPReplyVO(raw=");
        m3.append(this.raw);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NBPReplyVO) && Intrinsics.areEqual(this.raw, ((NBPReplyVO) obj).raw);
    }
}
