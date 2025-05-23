package com.tencent.localedit.fakenative.localserver;

import android.content.Context;
import com.tencent.localedit.fakenative.core.BaseManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u0011\u001a\u00020\u0004R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/localedit/fakenative/localserver/b;", "Lcom/tencent/localedit/fakenative/core/BaseManager;", "Lcom/tencent/localedit/fakenative/localserver/b$a;", "serverListener", "", "j", "Landroid/content/Context;", "context", "", "host", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "d", "hostAddress", tl.h.F, "error", "g", "i", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "localhost", "", "c", "I", "f", "()I", "l", "(I)V", "port", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class b extends BaseManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<a> listeners = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String localhost = "127.0.0.1";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int port = 8080;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/localedit/fakenative/localserver/b$a;", "", "", "hostAddress", "", "c", "error", "a", "b", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public interface a {
        void a(@Nullable String error);

        void b();

        void c(@Nullable String hostAddress);
    }

    public boolean d() {
        return true;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getLocalhost() {
        return this.localhost;
    }

    /* renamed from: f, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final void g(@Nullable String error) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(error);
        }
    }

    public final void h(@Nullable String hostAddress) {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c(hostAddress);
        }
    }

    public final void i() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
    }

    public final void j(@Nullable a serverListener) {
        if (serverListener != null) {
            this.listeners.add(serverListener);
        }
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.localhost = str;
    }

    public final void l(int i3) {
        this.port = i3;
    }

    public abstract void m(@NotNull Context context, @NotNull String host, @Nullable a serverListener);
}
