package com.tencent.mobileqq.qqlive.sail.ui.netstatus;

import android.util.Pair;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.trtc.TRTCStatistics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000f0\u000eJ\u0006\u0010\u0011\u001a\u00020\bR\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R&\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/netstatus/h;", "", "", "totalBytesSend", "", "b", "", "upLoss", "", "f", "Lcom/tencent/trtc/TRTCStatistics;", "statistic", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/AnchorLiveSystemInfo;", "e", "", "Landroid/util/Pair;", "c", "a", "I", "getNetQuality", "()I", "d", "(I)V", "netQuality", "J", "lastTimeStamp", "lastTimeTotalBytes", "upLossIndex", "Ljava/util/List;", "upLossRecord", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f272963a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int netQuality;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastTimeStamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long lastTimeTotalBytes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int upLossIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Pair<Long, Integer>> upLossRecord;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f272963a = new h();
            upLossRecord = new ArrayList();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final float b(long totalBytesSend) {
        long currentTimeMillis;
        if (System.currentTimeMillis() - lastTimeStamp == 0) {
            currentTimeMillis = 1000;
        } else {
            currentTimeMillis = System.currentTimeMillis() - lastTimeStamp;
        }
        long j3 = totalBytesSend - lastTimeTotalBytes;
        lastTimeStamp = System.currentTimeMillis();
        lastTimeTotalBytes = totalBytesSend;
        return (((float) j3) / 1024.0f) / (((float) currentTimeMillis) / 1000.0f);
    }

    private final void f(int upLoss) {
        int i3 = upLossIndex;
        if (i3 % 30 == 0) {
            upLossIndex = 0;
            upLossRecord.add(new Pair<>(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(upLoss)));
            upLossIndex++;
            return;
        }
        upLossIndex = i3 + 1;
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        netQuality = 0;
        lastTimeStamp = 0L;
        lastTimeTotalBytes = 0L;
        upLossIndex = 0;
        upLossRecord.clear();
    }

    @NotNull
    public final List<Pair<Long, Integer>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return upLossRecord;
    }

    public final void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            netQuality = i3;
        }
    }

    @NotNull
    public final AnchorLiveSystemInfo e(@NotNull TRTCStatistics statistic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AnchorLiveSystemInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) statistic);
        }
        Intrinsics.checkNotNullParameter(statistic, "statistic");
        f(statistic.upLoss);
        float b16 = b(statistic.sendBytes);
        float f16 = statistic.rtt;
        int i3 = statistic.upLoss;
        int i16 = statistic.appCpu;
        int i17 = netQuality;
        MemoryUtil memoryUtil = MemoryUtil.f258173a;
        return new AnchorLiveSystemInfo(b16, f16, i3, i16, i17, (memoryUtil.f() * 100) / memoryUtil.h());
    }
}
