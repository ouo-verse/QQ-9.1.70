package com.tencent.qqnt.avatar.util;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.g;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0001R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/avatar/util/e;", "", "", "event", "", "b", "Lcom/tencent/qqnt/avatar/util/e$a;", "a", "e", "", "success", "c", "key", "value", "d", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "getKey", "", "Ljava/util/List;", "eventList", "", "J", "getCreateTime", "()J", WadlProxyConsts.CREATE_TIME, "", "Ljava/util/Map;", "extras", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<a> eventList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long createTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> extras;

    public e(@NotNull String tag, @NotNull String key) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(key, "key");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag, (Object) key);
            return;
        }
        this.tag = tag;
        this.key = key;
        this.createTime = System.currentTimeMillis();
        this.extras = new LinkedHashMap();
    }

    public final void a(@NotNull a event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        List<a> list = this.eventList;
        if (list != null) {
            list.add(event);
        }
        b h16 = g.f352801a.h();
        if (h16 != null) {
            h16.a(this, event);
        }
    }

    public final void b(@NotNull String event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else {
            Intrinsics.checkNotNullParameter(event, "event");
            a(new a(event, false, null, 0L, null, 30, null));
        }
    }

    public final void c(boolean success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, success);
            return;
        }
        a(new a("end", success, "[" + success + " - " + (System.currentTimeMillis() - this.createTime) + "ms]", 0L, null, 24, null));
        List<a> list = this.eventList;
        if (list != null) {
            list.clear();
        }
        this.eventList = null;
    }

    public final void d(@NotNull String key, @NotNull Object value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) key, value);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.extras.put(key, value);
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.eventList = Collections.synchronizedList(new LinkedList());
            b("start");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/avatar/util/e$a;", "", "", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "", "b", "Z", "getResult", "()Z", "result", "c", "getMessage", "message", "", "d", "J", "getTime", "()J", "time", "Landroid/os/Bundle;", "e", "Landroid/os/Bundle;", "getExtra", "()Landroid/os/Bundle;", "extra", "<init>", "(Ljava/lang/String;ZLjava/lang/String;JLandroid/os/Bundle;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean result;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String message;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long time;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Bundle extra;

        public a(@NotNull String name, boolean z16, @Nullable String str, long j3, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(name, "name");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, name, Boolean.valueOf(z16), str, Long.valueOf(j3), bundle);
                return;
            }
            this.name = name;
            this.result = z16;
            this.message = str;
            this.time = j3;
            this.extra = bundle;
        }

        public /* synthetic */ a(String str, boolean z16, String str2, long j3, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? true : z16, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? System.currentTimeMillis() : j3, (i3 & 16) != 0 ? null : bundle);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), str2, Long.valueOf(j3), bundle, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }
}
