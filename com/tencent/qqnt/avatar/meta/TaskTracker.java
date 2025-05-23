package com.tencent.qqnt.avatar.meta;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.avatar.util.d;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0011\u0010\u000fR$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/TaskTracker;", "", "", "e", "event", "", "b", "", "success", "preStr", "c", "f", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "getKey", "key", "", "", "Ljava/util/Map;", "eventMap", "d", "J", "startTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TaskTracker {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Map<String, Long> eventMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    public TaskTracker(@NotNull String tag, @NotNull String key) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(key, "key");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag, (Object) key);
            return;
        }
        this.tag = tag;
        this.key = key;
        this.eventMap = Collections.synchronizedMap(new LinkedHashMap());
        long currentTimeMillis = System.currentTimeMillis();
        this.startTime = currentTimeMillis;
        b("create: " + currentTimeMillis);
    }

    public static /* synthetic */ void d(TaskTracker taskTracker, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "taskLoadTrack";
        }
        taskTracker.c(z16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        Map<String, Long> map = this.eventMap;
        if (map != null) {
            StringBuilder sb5 = new StringBuilder(this.key);
            sb5.append('[');
            long j3 = this.startTime;
            synchronized (map) {
                for (Map.Entry<String, Long> entry : map.entrySet()) {
                    sb5.append('\n');
                    sb5.append(entry.getKey());
                    sb5.append(" cost(");
                    sb5.append(entry.getValue().longValue() - j3);
                    sb5.append(')');
                    j3 = entry.getValue().longValue();
                }
                Unit unit = Unit.INSTANCE;
            }
            sb5.append(']');
            return sb5.toString();
        }
        return null;
    }

    public final void b(@NotNull String event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Map<String, Long> map = this.eventMap;
        if (map != null) {
            map.put(event, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void c(boolean success, @Nullable String preStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(success), preStr);
            return;
        }
        b("end:[" + success + " - " + (System.currentTimeMillis() - this.startTime) + "ms]");
        f(preStr);
        Map<String, Long> map = this.eventMap;
        if (map != null) {
            map.clear();
        }
        this.eventMap = null;
    }

    public final void f(@Nullable final String preStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) preStr);
        } else {
            d.f352991a.a(this.tag, new Function0<String>(preStr, this) { // from class: com.tencent.qqnt.avatar.meta.TaskTracker$printLog$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $preStr;
                final /* synthetic */ TaskTracker this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$preStr = preStr;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) preStr, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    String e16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    String str = this.$preStr;
                    e16 = this.this$0.e();
                    return str + MsgSummary.STR_COLON + e16;
                }
            });
        }
    }
}
