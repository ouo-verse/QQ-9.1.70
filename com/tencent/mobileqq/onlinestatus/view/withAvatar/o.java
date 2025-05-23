package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/o;", "", "", "tag", "", "b", "a", "", "", "Ljava/util/Map;", "map", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f256726a = new o();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Long> map = new HashMap();

    o() {
    }

    @JvmStatic
    public static final void a(@NotNull String tag) {
        Long remove;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (QLog.isColorLevel() && (remove = map.remove(tag)) != null) {
            QLog.d("OnlineStatusLikeWithAvatarStatics", 2, "[" + tag + "] cost time: " + (System.currentTimeMillis() - remove.longValue()));
        }
    }

    @JvmStatic
    public static final void b(@NotNull String tag) {
        boolean z16;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (tag.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            map.put(tag, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
