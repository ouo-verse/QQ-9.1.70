package com.tencent.mobileqq.login.relogin.anim;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000bR$\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000fR$\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/anim/b;", "", "", "d", "", "b", "c", "Lcom/tencent/mobileqq/login/relogin/anim/b$a;", "node", "a", "", "Ljava/util/List;", "nodeList", "", "<set-?>", "J", "getBeginTime", "()J", "beginTime", "endTime", "", "Z", "isBegin", "()Z", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> nodeList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long beginTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isBegin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004R0\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/anim/b$a;", "", "", "eventId", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "b", "a", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "eventList", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LinkedHashMap<Integer, Long> eventList;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/anim/b$a$a;", "", "", "EVENT_ID_BEGIN", "I", "EVENT_ID_DRAW", "EVENT_ID_END", "EVENT_ID_LOCK_CANVAS", "EVENT_ID_SLEEP", "EVENT_ID_UNLOCK_CANVAS", "EVENT_ID_UPDATE_ANIM", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.login.relogin.anim.b$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes15.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23132);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.eventList = new LinkedHashMap<>();
            }
        }

        public static /* synthetic */ void c(a aVar, int i3, long j3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                j3 = System.nanoTime();
            }
            aVar.b(i3, j3);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            Long l3 = this.eventList.get(6);
            if (l3 != null) {
                return l3.longValue();
            }
            return 0L;
        }

        public final void b(int eventId, long currentTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(eventId), Long.valueOf(currentTime));
                return;
            }
            if (eventId < 0 || eventId >= 7) {
                z16 = false;
            }
            if (z16) {
                this.eventList.put(Integer.valueOf(eventId), Long.valueOf(currentTime));
            }
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.nodeList = new ArrayList();
        }
    }

    private final String d() {
        List list;
        if (!this.nodeList.isEmpty()) {
            list = CollectionsKt___CollectionsKt.toList(this.nodeList);
            StringBuilder sb5 = new StringBuilder();
            long j3 = this.endTime - this.beginTime;
            sb5.append("totalTime :");
            sb5.append(j3);
            sb5.append('\n');
            sb5.append("frameSize: ");
            sb5.append(list.size());
            sb5.append('\n');
            sb5.append("fps: ");
            long j16 = 1000;
            sb5.append((int) (list.size() / (((float) ((j3 / j16) / j16)) / 1000.0f)));
            sb5.append('\n');
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
            return sb6;
        }
        return "";
    }

    public final void a(@NotNull a node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        if (this.isBegin) {
            this.nodeList.add(node);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.beginTime = System.nanoTime();
            this.isBegin = true;
        }
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        this.isBegin = false;
        this.endTime = System.nanoTime();
        String d16 = d();
        this.nodeList.clear();
        return d16;
    }
}
