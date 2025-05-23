package com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0007\rB#\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "Lorg/json/JSONObject;", "publishJson", "Lnm1/b;", "translateInfo", "", "a", "", "", "Ljava/util/Set;", "transparentKeySet", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i$b;", "b", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i$b;", "interceptPolicy", "<init>", "(Ljava/util/Set;Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i$b;)V", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i implements e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Set<String> f222284d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> transparentKeySet;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b interceptPolicy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i$a;", "", "", "", "commonTransparentKeySet", "Ljava/util/Set;", "a", "()Ljava/util/Set;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.i$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Set<String> a() {
            return i.f222284d;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/i$b;", "", "", "key", "", "a", "Lorg/json/JSONObject;", "source", "Lnm1/b;", "translateInfo", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        boolean a(@NotNull String key);

        @Nullable
        Object b(@NotNull String key, @NotNull JSONObject source, @NotNull nm1.b translateInfo);
    }

    static {
        Set<String> of5;
        c.C7754c c7754c = c.C7754c.f220907a;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"feed_source_type", "third_bar"});
        f222284d = of5;
    }

    public i(@NotNull Set<String> transparentKeySet, @Nullable b bVar) {
        Intrinsics.checkNotNullParameter(transparentKeySet, "transparentKeySet");
        this.transparentKeySet = transparentKeySet;
        this.interceptPolicy = bVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e
    public void a(@NotNull JSONObject publishJson, @NotNull nm1.b translateInfo) {
        JSONObject feedJsonObject;
        Intrinsics.checkNotNullParameter(publishJson, "publishJson");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        if (translateInfo.a() == null || (feedJsonObject = translateInfo.a().h().getFeedJsonObject()) == null) {
            return;
        }
        for (String str : this.transparentKeySet) {
            b bVar = this.interceptPolicy;
            boolean z16 = false;
            if (bVar != null && bVar.a(str)) {
                z16 = true;
            }
            if (z16) {
                Object b16 = this.interceptPolicy.b(str, feedJsonObject, translateInfo);
                if (b16 != null) {
                    publishJson.put(str, b16);
                }
            } else {
                publishJson.putOpt(str, feedJsonObject.opt(str));
            }
        }
    }

    public /* synthetic */ i(Set set, b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? f222284d : set, (i3 & 2) != 0 ? null : bVar);
    }
}
