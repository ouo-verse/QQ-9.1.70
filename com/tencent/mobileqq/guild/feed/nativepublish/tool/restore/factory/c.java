package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory;

import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.media.MediaContentPresetRestorer;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2.TextContentRestorer2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/c;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/a;", "Lorg/json/JSONObject;", "jsonObject", "Lom1/a;", "restoreInfo", "Lom1/b;", "a", "", "Lpm1/b;", "[Lpm1/b;", "employeeLeaders", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final pm1.b[] employeeLeaders = {new TextContentRestorer2(), new MediaContentPresetRestorer(0, 1, null), new qm1.a()};

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a
    @NotNull
    public om1.b a(@NotNull JSONObject jsonObject, @NotNull RestoreInfo restoreInfo) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreInfo, "restoreInfo");
        om1.b bVar = new om1.b();
        for (pm1.b bVar2 : this.employeeLeaders) {
            bVar2.a(jsonObject, bVar, restoreInfo);
        }
        return bVar;
    }
}
