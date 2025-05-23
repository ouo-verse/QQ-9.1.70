package i23;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Li23/a;", "", "", "toString", "", "a", "I", "()I", "day", "b", WidgetCacheWeatherData.HOUR, "c", "minute", "d", "sec", "<init>", "(IIII)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: i23.a, reason: from toString */
/* loaded from: classes20.dex */
public final class ExperienceExpiredCountDown {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int day;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int hour;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int minute;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int sec;

    public ExperienceExpiredCountDown(int i3, int i16, int i17, int i18) {
        this.day = i3;
        this.hour = i16;
        this.minute = i17;
        this.sec = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getDay() {
        return this.day;
    }

    /* renamed from: b, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* renamed from: c, reason: from getter */
    public final int getMinute() {
        return this.minute;
    }

    /* renamed from: d, reason: from getter */
    public final int getSec() {
        return this.sec;
    }

    @NotNull
    public String toString() {
        return "ExperienceExpiredCountDown(day=" + this.day + ", hour=" + this.hour + ", minute=" + this.minute + ", sec=" + this.sec + ")";
    }
}
