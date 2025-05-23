package com.tencent.mobileqq.wink.tag;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/tag/a;", "", "Landroid/content/Intent;", "intent", "", "tagName", "tagFrom", "", "b", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f326414a = new a();

    a() {
    }

    public static /* synthetic */ void c(a aVar, Intent intent, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        aVar.b(intent, str, str2);
    }

    public final void a(@NotNull Intent intent, @NotNull String tagName, @NotNull String tagFrom) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(tagFrom, "tagFrom");
        intent.putExtra("QQWinkDataKeys-challenge_tag_name", tagName);
        intent.putExtra("QQWinkDataKeys-tag_from", tagFrom);
    }

    public final void b(@NotNull Intent intent, @NotNull String tagName, @NotNull String tagFrom) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(tagFrom, "tagFrom");
        intent.putExtra("QQWinkDataKeys-tag_name", tagName);
        intent.putExtra("QQWinkDataKeys-tag_from", tagFrom);
    }
}
