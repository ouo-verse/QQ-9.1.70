package ct1;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bJ\b\u0010\u000f\u001a\u00020\u000eH\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\"\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\"\u0010-\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010/\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b.\u0010\u001bR\"\u00102\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0017\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bRD\u00108\u001a\u0012\u0012\u0004\u0012\u00020\b03j\b\u0012\u0004\u0012\u00020\b`42\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\b03j\b\u0012\u0004\u0012\u00020\b`48\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u00106\u001a\u0004\b'\u00107\u00a8\u0006;"}, d2 = {"Lct1/a;", "", "", "a", "", "j", "i", "b", "", "l", "k", "", "idList", "p", "", "toString", "Ljava/lang/String;", "c", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "checkAttachInfo", "", "I", "getFreeGiftUpperLimitAtDay", "()I", ReportConstant.COSTREPORT_PREFIX, "(I)V", "freeGiftUpperLimitAtDay", "d", DomainData.DOMAIN_NAME, "freeGiftAccountBalance", "getFreeGiftNumAtDay", "r", "freeGiftNumAtDay", "e", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "freeGiftNumAfterCheck", "f", "J", h.F, "()J", "t", "(J)V", "nextCheckTimestampMs", "o", "freeGiftCountDownSecond", "getReminderFreeGiftNumTips", "u", "reminderFreeGiftNumTips", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<set-?>", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "freeGiftIdList", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile String checkAttachInfo = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile int freeGiftUpperLimitAtDay = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int freeGiftAccountBalance = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile int freeGiftNumAtDay = -1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile int freeGiftNumAfterCheck = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile long nextCheckTimestampMs = -1;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile int freeGiftCountDownSecond = -1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile int reminderFreeGiftNumTips = -1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile ArrayList<Long> freeGiftIdList = new ArrayList<>();

    public final void a() {
        this.checkAttachInfo = "";
        this.freeGiftUpperLimitAtDay = -1;
        this.freeGiftAccountBalance = -1;
        this.freeGiftNumAtDay = -1;
        this.freeGiftNumAfterCheck = -1;
        this.nextCheckTimestampMs = -1L;
        this.freeGiftCountDownSecond = -1;
        this.reminderFreeGiftNumTips = -1;
        this.freeGiftIdList.clear();
    }

    public final boolean b() {
        if (this.freeGiftNumAfterCheck > 0 && this.freeGiftAccountBalance == this.reminderFreeGiftNumTips) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCheckAttachInfo() {
        return this.checkAttachInfo;
    }

    /* renamed from: d, reason: from getter */
    public final int getFreeGiftAccountBalance() {
        return this.freeGiftAccountBalance;
    }

    /* renamed from: e, reason: from getter */
    public final int getFreeGiftCountDownSecond() {
        return this.freeGiftCountDownSecond;
    }

    @NotNull
    public final ArrayList<Long> f() {
        return this.freeGiftIdList;
    }

    /* renamed from: g, reason: from getter */
    public final int getFreeGiftNumAfterCheck() {
        return this.freeGiftNumAfterCheck;
    }

    /* renamed from: h, reason: from getter */
    public final long getNextCheckTimestampMs() {
        return this.nextCheckTimestampMs;
    }

    public final boolean i() {
        int i3 = this.freeGiftAccountBalance;
        int i16 = this.reminderFreeGiftNumTips;
        if (1 > i16 || i16 > i3) {
            return false;
        }
        return true;
    }

    public final boolean j() {
        if (this.freeGiftNumAfterCheck > 0 && this.reminderFreeGiftNumTips > 0 && this.freeGiftAccountBalance >= this.reminderFreeGiftNumTips) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        if (this.freeGiftNumAfterCheck > 0) {
            return true;
        }
        return false;
    }

    public final long l() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (this.nextCheckTimestampMs <= 0) {
            return 0L;
        }
        return Math.max(this.nextCheckTimestampMs - serverTimeMillis, 0L) + 200;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.checkAttachInfo = str;
    }

    public final void n(int i3) {
        this.freeGiftAccountBalance = i3;
    }

    public final void o(int i3) {
        this.freeGiftCountDownSecond = i3;
    }

    public final void p(@Nullable List<Long> idList) {
        boolean z16;
        this.freeGiftIdList.clear();
        List<Long> list = idList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.freeGiftIdList.addAll(list);
    }

    public final void q(int i3) {
        this.freeGiftNumAfterCheck = i3;
    }

    public final void r(int i3) {
        this.freeGiftNumAtDay = i3;
    }

    public final void s(int i3) {
        this.freeGiftUpperLimitAtDay = i3;
    }

    public final void t(long j3) {
        this.nextCheckTimestampMs = j3;
    }

    @NotNull
    public String toString() {
        return "nextCheckTimeMs: " + this.nextCheckTimestampMs + ", freeGiftAccountBalance: " + this.freeGiftAccountBalance + ", freeGiftNumAtDay: " + this.freeGiftNumAtDay + ", freeGiftNumAfterCheck: " + this.freeGiftNumAfterCheck + ", reminderFreeGiftNumTips: " + this.reminderFreeGiftNumTips + ", freeGiftCountDownSecond: " + this.freeGiftCountDownSecond + ", freeGiftUpperLimitAtDay: " + this.freeGiftUpperLimitAtDay;
    }

    public final void u(int i3) {
        this.reminderFreeGiftNumTips = i3;
    }
}
