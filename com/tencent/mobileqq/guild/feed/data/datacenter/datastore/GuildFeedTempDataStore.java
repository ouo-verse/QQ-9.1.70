package com.tencent.mobileqq.guild.feed.data.datacenter.datastore;

import androidx.collection.ArrayMap;
import com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.richframework.data.base.BaseDataStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u000b2\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001:\u0002\u0006\u000bB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016R{\u0010\u0013\u001ab\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0012\u001c\u0012\u001a\u0012\u0006\b\u0001\u0012\u00020\u0003 \u000e*\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u000e*0\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\b0\b\u0012\u001c\u0012\u001a\u0012\u0006\b\u0001\u0012\u00020\u0003 \u000e*\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u000f0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/data/datacenter/datastore/GuildFeedTempDataStore;", "Lcom/tencent/richframework/data/base/BaseDataStore;", "Lcom/tencent/mobileqq/guild/feed/data/datacenter/datastore/GuildFeedTempDataStore$b;", "", "data", "", "a", "", "", "getAllData", "key", "b", "c", "removeDataByKey", "kotlin.jvm.PlatformType", "", "Lkotlin/Lazy;", "d", "()Ljava/util/Map;", "map", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedTempDataStore extends BaseDataStore<b<? extends Object>> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy map;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/data/datacenter/datastore/GuildFeedTempDataStore$b;", "T", "", "", "getKey", "()Ljava/lang/String;", "key", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/Object;", "value", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b<T> {
        @NotNull
        String getKey();

        T getValue();
    }

    public GuildFeedTempDataStore() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, b<? extends Object>>>() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore$map$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, GuildFeedTempDataStore.b<? extends Object>> invoke() {
                return Collections.synchronizedMap(new ArrayMap());
            }
        });
        this.map = lazy;
    }

    private final Map<String, b<? extends Object>> d() {
        return (Map) this.map.getValue();
    }

    @Override // com.tencent.richframework.data.base.BaseDataStore, com.tencent.richframework.data.idata.IDataStore
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void addData(@Nullable b<? extends Object> data) {
        if (getKeyFromData(data) != null) {
            d().put(getKeyFromData(data), data);
        }
    }

    @Override // com.tencent.richframework.data.base.BaseDataStore, com.tencent.richframework.data.idata.IDataStore
    @Nullable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b<? extends Object> getData(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return d().get(key);
    }

    @Override // com.tencent.richframework.data.idata.IDataStore
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getKeyFromData(@Nullable b<? extends Object> data) {
        if (data != null) {
            return data.getKey();
        }
        return null;
    }

    @Override // com.tencent.richframework.data.idata.IDataStore
    @NotNull
    public Map<String, b<? extends Object>> getAllData() {
        return new HashMap(d());
    }

    @Override // com.tencent.richframework.data.base.BaseDataStore, com.tencent.richframework.data.idata.IDataStore
    public void removeDataByKey(@Nullable String key) {
        if (key != null) {
            d().remove(key);
        }
    }
}
