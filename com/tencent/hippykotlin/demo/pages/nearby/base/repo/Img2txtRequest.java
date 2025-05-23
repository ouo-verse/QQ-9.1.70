package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import i25.a;
import i25.b;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import n35.w;
import p35.ah;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Img2txtRequest extends NearbyBasePbRequest<a, b> {
    public final Map<String, String> extContent;
    public final List<w> images;
    public final ah location;

    public Img2txtRequest(List<w> list, ah ahVar, Map<String, String> map) {
        this.images = list;
        this.location = ahVar;
        this.extContent = map;
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e decodeResponse(byte[] bArr) {
        return (b) i.b(new b(null, null, 3, null), bArr);
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final String getCmd() {
        return "trpc.kuolie.assisted_chat.MultiModalChatService.SsoPicGenText";
    }

    @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
    public final e getRequest() {
        Map mutableMap;
        List mutableList;
        ah ahVar = this.location;
        mutableMap = MapsKt__MapsKt.toMutableMap(this.extContent);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.images);
        return new a(ahVar, mutableMap, mutableList, 1);
    }
}
