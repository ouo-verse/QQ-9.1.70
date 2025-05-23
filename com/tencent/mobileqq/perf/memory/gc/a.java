package com.tencent.mobileqq.perf.memory.gc;

import android.os.Debug;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002JJ\u0010\u000b\u001a\u00020\n2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002J(\u0010\u000f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002J(\u0010\u0012\u001a\u00020\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0007J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0013J\u0019\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/gc/a;", "", "", "before", "after", "f", "", "", "", "data", "", "g", "", "strHistogram", "dataMap", h.F, "map", "key", "d", "Lcom/tencent/mobileqq/perf/memory/gc/a$a;", "c", "e", "strValue", "i", "(Ljava/lang/String;)J", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257735a;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b4\u00105J%\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010)\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR>\u00101\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t`,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010-\u001a\u0004\b \u0010.\"\u0004\b/\u00100R>\u00103\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t0*j\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\t`,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010-\u001a\u0004\b\u0011\u0010.\"\u0004\b2\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/gc/a$a;", "", "", "", "map", "", "l", "(Ljava/util/Map;)V", "toString", "", "a", "J", "f", "()J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(J)V", "gcCount", "b", h.F, "r", "gcTime", "c", "d", "o", "bytesAllocated", "e", "p", "bytesFreed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "blockCount", DomainData.DOMAIN_NAME, "blockTime", "g", "i", ReportConstant.COSTREPORT_PREFIX, "gcWaitTime", "k", "u", "oomGcCount", "j", "t", "objAllocated", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setGcHistogram", "(Ljava/util/HashMap;)V", "gcHistogram", "setBlockHistogram", "blockHistogram", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.memory.gc.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8202a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long gcCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long gcTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long bytesAllocated;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long bytesFreed;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long blockCount;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long blockTime;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long gcWaitTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long oomGcCount;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long objAllocated;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashMap<Integer, Long> gcHistogram;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashMap<Integer, Long> blockHistogram;

        public C8202a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.gcCount = -1L;
            this.gcTime = -1L;
            this.bytesAllocated = -1L;
            this.bytesFreed = -1L;
            this.blockCount = -1L;
            this.blockTime = -1L;
            this.gcWaitTime = -1L;
            this.oomGcCount = -1L;
            this.objAllocated = -1L;
            this.gcHistogram = new HashMap<>();
            this.blockHistogram = new HashMap<>();
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
            }
            return this.blockCount;
        }

        @NotNull
        public final HashMap<Integer, Long> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (HashMap) iPatchRedirector.redirect((short) 22, (Object) this);
            }
            return this.blockHistogram;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
            }
            return this.blockTime;
        }

        public final long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.bytesAllocated;
        }

        public final long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
            }
            return this.bytesFreed;
        }

        public final long f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.gcCount;
        }

        @NotNull
        public final HashMap<Integer, Long> g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (HashMap) iPatchRedirector.redirect((short) 20, (Object) this);
            }
            return this.gcHistogram;
        }

        public final long h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.gcTime;
        }

        public final long i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Long) iPatchRedirector.redirect((short) 14, (Object) this)).longValue();
            }
            return this.gcWaitTime;
        }

        public final long j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
            }
            return this.objAllocated;
        }

        public final long k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
            }
            return this.oomGcCount;
        }

        public final void l(@Nullable Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, (Object) map);
                return;
            }
            if (map == null) {
                return;
            }
            a aVar = a.f257735a;
            this.gcCount = aVar.i(aVar.d(map, "art.gc.gc-count"));
            this.gcTime = aVar.i(aVar.d(map, "art.gc.gc-time"));
            this.bytesAllocated = aVar.i(aVar.d(map, "art.gc.bytes-allocated"));
            this.bytesFreed = aVar.i(aVar.d(map, "art.gc.bytes-freed"));
            this.blockCount = aVar.i(aVar.d(map, "art.gc.blocking-gc-count"));
            this.blockTime = aVar.i(aVar.d(map, "art.gc.blocking-gc-time"));
            this.gcWaitTime = aVar.i(aVar.d(map, "art.gc.total-time-waiting-for-gc"));
            this.oomGcCount = aVar.i(aVar.d(map, "art.gc.pre-oome-gc-count"));
            this.objAllocated = aVar.i(aVar.d(map, "art.gc.objects-allocated"));
            String d16 = aVar.d(map, "art.gc.gc-count-rate-histogram");
            String d17 = aVar.d(map, "art.gc.blocking-gc-count-rate-histogram");
            aVar.h(d16, this.gcHistogram);
            aVar.h(d17, this.blockHistogram);
        }

        public final void m(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, j3);
            } else {
                this.blockCount = j3;
            }
        }

        public final void n(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, j3);
            } else {
                this.blockTime = j3;
            }
        }

        public final void o(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            } else {
                this.bytesAllocated = j3;
            }
        }

        public final void p(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, j3);
            } else {
                this.bytesFreed = j3;
            }
        }

        public final void q(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.gcCount = j3;
            }
        }

        public final void r(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            } else {
                this.gcTime = j3;
            }
        }

        public final void s(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, j3);
            } else {
                this.gcWaitTime = j3;
            }
        }

        public final void t(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, j3);
            } else {
                this.objAllocated = j3;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (String) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(super.toString());
            sb5.append(" gcCount=" + this.gcCount);
            sb5.append(" gcTime=" + this.gcTime);
            sb5.append(" bytesAllocated=" + this.bytesAllocated);
            sb5.append(" bytesFreed=" + this.bytesFreed);
            sb5.append(" blockCount=" + this.blockCount);
            sb5.append(" blockTime=" + this.blockTime);
            sb5.append(" gcWaitTime=" + this.gcWaitTime);
            sb5.append(" oomGcCount=" + this.oomGcCount);
            sb5.append(" objAllocated=" + this.objAllocated);
            sb5.append(" gcHistogram=" + this.gcHistogram);
            sb5.append(" blockHistogram=" + this.blockHistogram);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            return sb6;
        }

        public final void u(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, j3);
            } else {
                this.oomGcCount = j3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30339);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f257735a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(Map<String, String> map, String key) {
        String str;
        if (map == null || key == null || (str = map.get(key)) == null) {
            return "";
        }
        return str;
    }

    private final long f(long before, long after) {
        if (after < 0) {
            return -1L;
        }
        if (before >= 0) {
            return after - before;
        }
        return after;
    }

    private final void g(Map<Integer, Long> before, Map<Integer, Long> after, Map<Integer, Long> data) {
        long j3;
        if (before != null && after != null && data != null) {
            Iterator<Integer> it = after.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                Long l3 = after.get(Integer.valueOf(intValue));
                Intrinsics.checkNotNull(l3);
                long longValue = l3.longValue();
                if (before.containsKey(Integer.valueOf(intValue))) {
                    Long l16 = before.get(Integer.valueOf(intValue));
                    Intrinsics.checkNotNull(l16);
                    j3 = l16.longValue();
                } else {
                    j3 = 0;
                }
                long j16 = longValue - j3;
                if (j16 > 0) {
                    data.put(Integer.valueOf(intValue), Long.valueOf(j16));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String strHistogram, Map<Integer, Long> dataMap) {
        List emptyList;
        List emptyList2;
        boolean z16;
        boolean z17;
        if (strHistogram != null && strHistogram.length() != 0 && dataMap != null) {
            List<String> split = new Regex(",").split(strHistogram, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            Object[] array = emptyList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            for (String str : (String[]) array) {
                try {
                    List<String> split2 = new Regex(":").split(str, 0);
                    if (!split2.isEmpty()) {
                        ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (!z16) {
                                emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    Object[] array2 = emptyList2.toArray(new String[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    String[] strArr = (String[]) array2;
                    int parseInt = Integer.parseInt(strArr[0]);
                    Long nValue = Long.valueOf(strArr[1]);
                    Integer valueOf = Integer.valueOf(parseInt);
                    Intrinsics.checkNotNullExpressionValue(nValue, "nValue");
                    dataMap.put(valueOf, nValue);
                } catch (NumberFormatException e16) {
                    QLog.e("GcInfoHelper", 1, "parseHistogram has NumberFormatException", e16);
                }
            }
        }
    }

    @RequiresApi(api = 23)
    @NotNull
    public final C8202a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (C8202a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Map<String, String> runtimeStats = Debug.getRuntimeStats();
        C8202a c8202a = new C8202a();
        c8202a.l(runtimeStats);
        return c8202a;
    }

    @Nullable
    public final C8202a e(@Nullable C8202a before, @Nullable C8202a after) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (C8202a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) before, (Object) after);
        }
        if (before != null && after != null) {
            C8202a c8202a = new C8202a();
            c8202a.q(f(before.f(), after.f()));
            c8202a.r(f(before.h(), after.h()));
            c8202a.o(f(before.d(), after.d()));
            c8202a.p(f(before.e(), after.e()));
            c8202a.n(f(before.c(), after.c()));
            c8202a.m(f(before.a(), after.a()));
            c8202a.s(f(before.i(), after.i()));
            c8202a.u(f(before.k(), after.k()));
            c8202a.t(f(before.j(), after.j()));
            g(before.g(), after.g(), c8202a.g());
            g(before.b(), after.b(), c8202a.b());
            return c8202a;
        }
        return null;
    }

    public final long i(@Nullable String strValue) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) strValue)).longValue();
        }
        if (strValue == null || strValue.length() == 0) {
            return -1L;
        }
        try {
            l3 = Long.valueOf(strValue, 10);
        } catch (NumberFormatException e16) {
            QLog.e("GcInfoHelper", 1, "parseLongValue has NumberFormatException", e16);
            l3 = -1L;
        }
        Intrinsics.checkNotNullExpressionValue(l3, "try {\n            java.l\u2026            -1L\n        }");
        return l3.longValue();
    }
}
