package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory;

import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.g;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/RestoreByReEditTool;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/a;", "Lorg/json/JSONObject;", "jsonObject", "Lom1/a;", "restoreInfo", "Lom1/b;", "a", "", "Lpm1/b;", "Ljava/util/List;", "mRestoreList", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/d;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/d;", "backingRestorer", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RestoreByReEditTool implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<pm1.b> mRestoreList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy backingRestorer;

    public RestoreByReEditTool() {
        List<pm1.b> listOf;
        Lazy lazy;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new pm1.b[]{new g(), new rm1.c(), new qm1.a()});
        this.mRestoreList = listOf;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<d>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.RestoreByReEditTool$backingRestorer$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                return new d();
            }
        });
        this.backingRestorer = lazy;
    }

    private final d b() {
        return (d) this.backingRestorer.getValue();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a
    @NotNull
    public om1.b a(@NotNull JSONObject jsonObject, @NotNull RestoreInfo restoreInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        if (GuildFeedPublishUtils.f222315a.v()) {
            String optString = jsonObject.optString("patternInfo");
            if (optString != null && optString.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && !Intrinsics.areEqual(optString, JSONObject.NULL.toString())) {
                QLog.i("FeedEditor.RestoreTool", 1, "useRestorerV2, but patternInfo is not empty");
            } else {
                QLog.i("FeedEditor.RestoreTool", 1, "patternInfo is empty, using v2 restorer");
                return b().a(jsonObject, restoreInfo);
            }
        }
        om1.b bVar = new om1.b();
        Iterator<T> it = this.mRestoreList.iterator();
        while (it.hasNext()) {
            ((pm1.b) it.next()).a(jsonObject, bVar, restoreInfo);
        }
        return bVar;
    }
}
