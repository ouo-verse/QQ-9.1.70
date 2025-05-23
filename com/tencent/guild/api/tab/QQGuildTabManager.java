package com.tencent.guild.api.tab;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import nr0.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/api/tab/QQGuildTabManager;", "", "Lmqq/util/WeakReference;", "Lnr0/a;", "callback", "", "c", "", "guildTab", "b", "", "Ljava/util/List;", "tabCallbackList", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class QQGuildTabManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQGuildTabManager f112651a = new QQGuildTabManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<a>> tabCallbackList = new ArrayList();

    QQGuildTabManager() {
    }

    @JvmStatic
    public static final void c(@NotNull final WeakReference<a> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.tab.QQGuildTabManager$registerCallback$$inlined$onMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List list2;
                list = QQGuildTabManager.tabCallbackList;
                list.remove(WeakReference.this);
                list2 = QQGuildTabManager.tabCallbackList;
                list2.add(WeakReference.this);
            }
        });
    }

    public final void b(final boolean guildTab) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.guild.api.tab.QQGuildTabManager$notifyGuildTabUpdate$$inlined$onMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                list = QQGuildTabManager.tabCallbackList;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    a aVar = (a) ((WeakReference) it.next()).get();
                    if (aVar != null) {
                        aVar.onTabChanged(guildTab);
                    }
                }
            }
        });
    }
}
