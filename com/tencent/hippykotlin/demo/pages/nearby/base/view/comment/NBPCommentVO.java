package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p35.ae;
import p35.h;
import p35.i;
import s35.af;

/* loaded from: classes31.dex */
public final class NBPCommentVO {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCommentVO.class, "repliesFold", "getRepliesFold()Z", 0)};
    public final int cTime;
    public final i content;
    public final boolean defaultFoldReplies;
    public final String feedPosterUserId;

    /* renamed from: id, reason: collision with root package name */
    public final String f114212id;
    public final long key = NBPCommentVOKt.access$getNextKey();
    public final h raw;
    public final List<NBPReplyVO> replies;
    public final ReadWriteProperty repliesFold$delegate;
    public final int respNum;
    public final boolean submitted;
    public final af user;

    public NBPCommentVO(h hVar, String str, boolean z16) {
        int collectionSizeOrDefault;
        this.raw = hVar;
        this.feedPosterUserId = str;
        this.defaultFoldReplies = z16;
        this.f114212id = hVar.f425175f;
        this.user = hVar.f425173d;
        this.cTime = hVar.f425174e;
        this.content = hVar.f425176h;
        this.respNum = hVar.f425177i;
        List<ae> list = hVar.f425178m;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new NBPReplyVO((ae) it.next()));
        }
        this.replies = arrayList;
        this.submitted = this.raw.f425175f.length() > 0;
        this.repliesFold$delegate = c.a(Boolean.valueOf(this.defaultFoldReplies));
    }

    public final boolean getRepliesFold() {
        return ((Boolean) this.repliesFold$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.feedPosterUserId, this.raw.hashCode() * 31, 31);
        boolean z16 = this.defaultFoldReplies;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return m3 + i3;
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NBPCommentVO(raw=");
        m3.append(this.raw);
        m3.append(", feedPosterUserId=");
        m3.append(this.feedPosterUserId);
        m3.append(", defaultFoldReplies=");
        return BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline1.m(m3, this.defaultFoldReplies, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NBPCommentVO)) {
            return false;
        }
        NBPCommentVO nBPCommentVO = (NBPCommentVO) obj;
        return Intrinsics.areEqual(this.raw, nBPCommentVO.raw) && Intrinsics.areEqual(this.feedPosterUserId, nBPCommentVO.feedPosterUserId) && this.defaultFoldReplies == nBPCommentVO.defaultFoldReplies;
    }
}
