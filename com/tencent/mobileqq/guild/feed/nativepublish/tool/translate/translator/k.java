package com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator;

import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.i;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/k;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i$b;", "", "key", "", "a", "Lorg/json/JSONObject;", "source", "Lnm1/b;", "translateInfo", "", "b", "", "Ljava/util/Set;", "translatorKeys", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k implements i.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> translatorKeys = i.INSTANCE.a();

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.i.b
    public boolean a(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.translatorKeys.contains(key);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.i.b
    @Nullable
    public Object b(@NotNull String key, @NotNull JSONObject source, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        return null;
    }
}
