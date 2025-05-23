package com.tencent.mobileqq.zootopia.api.impl;

import com.tencent.mobileqq.zootopia.api.IZootopiaEnterUEModApi;
import com.tencent.mobileqq.zootopia.k;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/ZootopiaEnterUEModApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaEnterUEModApi;", "Lcom/tencent/mobileqq/zootopia/a;", "", "mapId", "", "mapName", "", "onEnterMapCallback", "onExitMapCallback", "Lcom/tencent/mobileqq/zootopia/api/a;", "processor", "registerEnterMapProcessor", "unRegisterEnterMapProcessor", "getCurrMapName", "doEnterUEMap", "doExitUEMap", "Ljava/util/concurrent/CopyOnWriteArraySet;", "enterUEModProcessorSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "currMapName", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaEnterUEModApiImpl implements IZootopiaEnterUEModApi, com.tencent.mobileqq.zootopia.a {
    private final CopyOnWriteArraySet<com.tencent.mobileqq.zootopia.api.a> enterUEModProcessorSet = new CopyOnWriteArraySet<>();
    private String currMapName = "";

    public ZootopiaEnterUEModApiImpl() {
        k.f328365a.g(this);
    }

    private final void onEnterMapCallback(int mapId, String mapName) {
        Iterator<com.tencent.mobileqq.zootopia.api.a> it = this.enterUEModProcessorSet.iterator();
        while (it.hasNext()) {
            it.next().doEnterUEMap(mapId, mapName);
        }
    }

    private final void onExitMapCallback(int mapId, String mapName) {
        Iterator<com.tencent.mobileqq.zootopia.api.a> it = this.enterUEModProcessorSet.iterator();
        while (it.hasNext()) {
            it.next().doExitUEMap(mapId, mapName);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.a
    public void doEnterUEMap(int mapId, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        this.currMapName = mapName;
        onEnterMapCallback(mapId, mapName);
    }

    @Override // com.tencent.mobileqq.zootopia.a
    public void doExitUEMap(int mapId, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        this.currMapName = "";
        onExitMapCallback(mapId, mapName);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaEnterUEModApi
    public String getCurrMapName() {
        return this.currMapName;
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaEnterUEModApi
    public void registerEnterMapProcessor(com.tencent.mobileqq.zootopia.api.a processor) {
        if (processor != null) {
            this.enterUEModProcessorSet.add(processor);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaEnterUEModApi
    public void unRegisterEnterMapProcessor(com.tencent.mobileqq.zootopia.api.a processor) {
        if (processor != null) {
            this.enterUEModProcessorSet.remove(processor);
        }
    }
}
