package com.tencent.util;

import android.support.v4.os.TraceCompat;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/util/EventPerfTrace;", "", "tag", "", "enableSysTrace", "", "(Ljava/lang/String;Z)V", LinkReportConstant$GlobalKey.EVENTS, "Ljava/util/ArrayList;", "Lcom/tencent/util/EventPerfTrace$Event;", "Lkotlin/collections/ArrayList;", "getEvents", "()Ljava/util/ArrayList;", "addEvent", "", "name", "beginTrace", "endTrace", "finish", "print", "Companion", "Event", "QQCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class EventPerfTrace {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String EVENT_END = "end";

    @JvmField
    @NotNull
    public static final EventPerfTrace mainPageStart;
    private final boolean enableSysTrace;

    @NotNull
    private final ArrayList<Event> events;

    @NotNull
    private final String tag;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/util/EventPerfTrace$Companion;", "", "()V", "EVENT_END", "", "mainPageStart", "Lcom/tencent/util/EventPerfTrace;", "QQCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/util/EventPerfTrace$Event;", "", "name", "", "time", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "QQCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Event {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String name;
        private final long time;

        public Event(@NotNull String name, long j3) {
            Intrinsics.checkNotNullParameter(name, "name");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, name, Long.valueOf(j3));
            } else {
                this.name = name;
                this.time = j3;
            }
        }

        public static /* synthetic */ Event copy$default(Event event, String str, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = event.name;
            }
            if ((i3 & 2) != 0) {
                j3 = event.time;
            }
            return event.copy(str, j3);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.name;
        }

        public final long component2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.time;
        }

        @NotNull
        public final Event copy(@NotNull String name, long time) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Event) iPatchRedirector.redirect((short) 6, this, name, Long.valueOf(time));
            }
            Intrinsics.checkNotNullParameter(name, "name");
            return new Event(name, time);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof Event)) {
                return false;
            }
            Event event = (Event) other;
            if (Intrinsics.areEqual(this.name, event.name) && this.time == event.time) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.name;
        }

        public final long getTime() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.time;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.name.hashCode() * 31) + androidx.fragment.app.a.a(this.time);
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "Event(name=" + this.name + ", time=" + this.time + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34722);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        mainPageStart = new EventPerfTrace("MainPageStart", false, 2, defaultConstructorMarker);
    }

    public EventPerfTrace(@NotNull String tag, boolean z16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tag, Boolean.valueOf(z16));
            return;
        }
        this.tag = tag;
        this.enableSysTrace = z16;
        this.events = new ArrayList<>();
    }

    private final void beginTrace(String name) {
        if (!this.enableSysTrace) {
            return;
        }
        TraceCompat.beginSection(name);
    }

    private final void endTrace() {
        if (!this.enableSysTrace) {
            return;
        }
        TraceCompat.endSection();
    }

    public final void addEvent(@NotNull String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) name);
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        synchronized (this.events) {
            this.events.add(new Event(name, System.nanoTime()));
            if (this.events.size() > 1) {
                endTrace();
            }
            beginTrace(name);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        synchronized (this.events) {
            addEvent("end");
            Unit unit = Unit.INSTANCE;
        }
        endTrace();
        print();
    }

    @NotNull
    public final ArrayList<Event> getEvents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.events;
    }

    public final void print() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.events.isEmpty()) {
            String str = this.tag;
            QLog.i(str, 1, str + ": (no data)");
            return;
        }
        int i3 = 0;
        long time = this.events.get(0).getTime();
        int size = this.events.size() - 1;
        while (i3 < size) {
            Event event = this.events.get(i3);
            Intrinsics.checkNotNullExpressionValue(event, "events[i]");
            i3++;
            long time2 = this.events.get(i3).getTime();
            double time3 = (r7.getTime() - time) / 1000000.0d;
            String str2 = this.tag;
            String name = event.getName();
            QLog.i(str2, 1, str2 + "-" + name + MsgSummary.STR_COLON + time3 + "-" + ((time2 - time) / 1000000.0d) + " (" + ((time2 - r7.getTime()) / 1000000.0d) + ")");
        }
        ArrayList<Event> arrayList = this.events;
        double time4 = (arrayList.get(arrayList.size() - 1).getTime() - time) / 1000000.0d;
        String str3 = this.tag;
        QLog.i(str3, 1, str3 + "-total: " + time4 + " ms");
    }

    public /* synthetic */ EventPerfTrace(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
