package com.tencent.qqnt.notification.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/notification/util/b;", "", "", "", "iterator", "", "c", "seed", "value", "d", "", "e", "uin", "msgSeq", "msgRandom", "a", "groupCode", "b", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f359910a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45684);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f359910a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long c(Iterator<Character> iterator) {
        long j3 = 0;
        while (iterator.hasNext()) {
            j3 = f359910a.d(j3, iterator.next().charValue());
        }
        return j3;
    }

    private final long d(long seed, long value) {
        return seed ^ (((value + 2654435769L) + (seed << 6)) + (seed >>> 2));
    }

    private final String e(long value) {
        return String.valueOf(value & TTL.MAX_VALUE);
    }

    @NotNull
    public final String a(long uin, long msgSeq, long msgRandom) {
        CharIterator it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, Long.valueOf(uin), Long.valueOf(msgSeq), Long.valueOf(msgRandom));
        }
        it = StringsKt__StringsKt.iterator(uin + "-" + (msgSeq & WebSocketProtocol.PAYLOAD_SHORT_MAX) + "-" + (msgRandom & 4294967295L));
        return e(c(it));
    }

    @NotNull
    public final String b(long groupCode, long msgSeq) {
        CharIterator it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Long.valueOf(groupCode), Long.valueOf(msgSeq));
        }
        it = StringsKt__StringsKt.iterator(groupCode + "-" + (msgSeq & 4294967295L));
        return e(c(it));
    }
}
