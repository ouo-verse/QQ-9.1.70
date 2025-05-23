package com.tencent.qqnt.chats.biz.guildhelper;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.chats.data.converter.g;
import cooperation.qzone.util.QZoneImageUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guildhelper/c;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QZoneImageUtils.KEY_MATCH, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "update", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "a", "Ljava/util/List;", "mPartProcessorList", "b", "mExtraProcessorList", "<init>", "()V", "c", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c extends com.tencent.qqnt.chats.data.converter.e {

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_GuildHelperConvertProcessor.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<g>> f354299d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> mPartProcessorList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> mExtraProcessorList;

    static {
        ArrayList<Class<g>> arrayList = new ArrayList<>();
        f354299d = arrayList;
        arrayList.add(com.tencent.mobileqq.guildhelper.c.class);
    }

    public c() {
        List<g> listOf;
        int collectionSizeOrDefault;
        Object first;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new g[]{new com.tencent.qqnt.chats.biz.guild.f(), new iw3.a(), new iw3.b(), new iw3.c(), new com.tencent.qqnt.chats.data.processor.part.c()});
        this.mPartProcessorList = listOf;
        ArrayList<Class<g>> arrayList = f354299d;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.data.converter.IPartConvertProcessor");
            arrayList2.add((g) newInstance);
        }
        this.mExtraProcessorList = arrayList2;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 60) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        Iterator<g> it = this.mPartProcessorList.iterator();
        while (it.hasNext()) {
            it.next().update(item, params);
        }
        Iterator<g> it5 = this.mExtraProcessorList.iterator();
        while (it5.hasNext()) {
            it5.next().update(item, params);
        }
    }
}
