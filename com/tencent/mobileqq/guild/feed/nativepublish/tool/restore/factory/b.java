package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory;

import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.g;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/a;", "Lorg/json/JSONObject;", "jsonObject", "Lom1/a;", "restoreInfo", "Lom1/b;", "a", "", "Lpm1/b;", "Ljava/util/List;", "mRestoreList", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<pm1.b> mRestoreList;

    public b() {
        List<pm1.b> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new pm1.b[]{new g(), new rm1.b(), new qm1.a()});
        this.mRestoreList = listOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a
    @NotNull
    public om1.b a(@NotNull JSONObject jsonObject, @NotNull RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        om1.b bVar = new om1.b();
        Iterator<T> it = this.mRestoreList.iterator();
        while (it.hasNext()) {
            ((pm1.b) it.next()).a(jsonObject, bVar, restoreInfo);
        }
        return bVar;
    }
}
