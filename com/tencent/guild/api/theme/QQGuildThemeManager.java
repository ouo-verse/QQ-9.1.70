package com.tencent.guild.api.theme;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import or0.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0007\u001a\u00020\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/api/theme/QQGuildThemeManager;", "", "Lor0/a;", "callback", "", "c", "d", "b", "", "Ljava/util/List;", "themeCallbackList", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class QQGuildThemeManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQGuildThemeManager f112656a = new QQGuildThemeManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<a> themeCallbackList = new ArrayList();

    QQGuildThemeManager() {
    }

    @JvmStatic
    public static final void c(@NotNull final a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.theme.QQGuildThemeManager$registerThemeCallback$$inlined$onMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List list2;
                list = QQGuildThemeManager.themeCallbackList;
                list.remove(a.this);
                list2 = QQGuildThemeManager.themeCallbackList;
                list2.add(a.this);
            }
        });
    }

    @JvmStatic
    public static final void d(@NotNull final a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.theme.QQGuildThemeManager$unregisterThemeCallback$$inlined$onMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                list = QQGuildThemeManager.themeCallbackList;
                list.remove(a.this);
            }
        });
    }

    public final void b() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.theme.QQGuildThemeManager$notifyGuildThemeUpdate$$inlined$onMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                list = QQGuildThemeManager.themeCallbackList;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).onThemeChanged();
                }
            }
        });
    }
}
