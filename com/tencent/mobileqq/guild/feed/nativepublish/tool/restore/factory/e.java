package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/e;", "", "", "toolType", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/factory/a;", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f222261a = new e();

    e() {
    }

    @NotNull
    public final a a(int toolType) {
        if (toolType != 1) {
            if (toolType != 2) {
                if (toolType != 3) {
                    return new RestoreByReEditTool();
                }
                return new c();
            }
            return new b();
        }
        return new RestoreByReEditTool();
    }
}
