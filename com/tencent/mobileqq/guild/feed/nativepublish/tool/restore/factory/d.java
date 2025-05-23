package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory;

import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2.TextContentRestorer2;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/d;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/a;", "Lorg/json/JSONObject;", "jsonObject", "Lom1/a;", "restoreInfo", "Lom1/b;", "a", "", "Lpm1/b;", "Ljava/util/List;", "employeeLeaders", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<pm1.b> employeeLeaders;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002K\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/d$a;", "Lkotlin/Function3;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "content", "Lom1/b;", "restoreResult", "Lom1/a;", "restoreInfo", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/RestorerEmployee;", "a", "Lpm1/a;", "d", "Lpm1/a;", "backing", "<init>", "(Lpm1/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements Function3<JSONObject, om1.b, RestoreInfo, Unit> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final pm1.a backing;

        public a(@NotNull pm1.a backing) {
            Intrinsics.checkNotNullParameter(backing, "backing");
            this.backing = backing;
        }

        public void a(@NotNull JSONObject content, @NotNull om1.b restoreResult, @NotNull RestoreInfo restoreInfo) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
            Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
            this.backing.a(content, nm1.a.f420455a.a(), restoreResult, restoreInfo);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject, om1.b bVar, RestoreInfo restoreInfo) {
            a(jSONObject, bVar, restoreInfo);
            return Unit.INSTANCE;
        }
    }

    public d() {
        List<pm1.b> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new pm1.b[]{new TextContentRestorer2(), new com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2.a(), new qm1.a()});
        this.employeeLeaders = listOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a
    @NotNull
    public om1.b a(@NotNull JSONObject jsonObject, @NotNull RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        om1.b bVar = new om1.b();
        Iterator<T> it = this.employeeLeaders.iterator();
        while (it.hasNext()) {
            ((pm1.b) it.next()).a(jsonObject, bVar, restoreInfo);
        }
        return bVar;
    }
}
