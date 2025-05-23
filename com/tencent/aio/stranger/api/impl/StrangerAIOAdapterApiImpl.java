package com.tencent.aio.stranger.api.impl;

import com.tencent.aio.stranger.api.IStrangerAIOAdapterApi;
import com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import i72.c;
import i72.e;
import i72.g;
import i72.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/stranger/api/impl/StrangerAIOAdapterApiImpl;", "Lcom/tencent/aio/stranger/api/IStrangerAIOAdapterApi;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "getInputBarAdornApi", "", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "getExtSectionBarAdapters", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "getExtSectionBarProcessors", "getNearbyProExtProcessors", "getNearbyProExtAdapters", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class StrangerAIOAdapterApiImpl implements IStrangerAIOAdapterApi {
    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    public com.tencent.mobileqq.aio.input.adorn.a<?> getInputBarAdornApi() {
        return new l72.a();
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    public List<b> getNearbyProExtAdapters() {
        List<b> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new g());
        return listOf;
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    public List<BottomSectionBarBaseProcessor> getNearbyProExtProcessors() {
        List<BottomSectionBarBaseProcessor> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new h());
        return listOf;
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    public List<b> getExtSectionBarAdapters() {
        List<b> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new b[]{new n82.a(), new c(), new g()});
        return listOf;
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOAdapterApi
    public List<BottomSectionBarBaseProcessor> getExtSectionBarProcessors() {
        List<BottomSectionBarBaseProcessor> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new BottomSectionBarBaseProcessor[]{new n82.b(), new e(), new h()});
        return listOf;
    }
}
