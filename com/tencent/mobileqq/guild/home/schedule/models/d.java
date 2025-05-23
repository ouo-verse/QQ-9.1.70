package com.tencent.mobileqq.guild.home.schedule.models;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.base.extension.CalendarEx;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rR\u001a\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "", "", "getType", "()I", "getType$annotations", "()V", "type", "", "getText", "()Ljava/lang/String;", "text", "", "a", "()Z", "isToday", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f225243a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/models/d$a;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ljava/util/Calendar;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.schedule.models.d$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f225243a = new Companion();

        Companion() {
        }

        @NotNull
        public final Calendar a(@NotNull d item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (item instanceof DayGroupItem) {
                return CalendarEx.f214714a.d(((DayGroupItem) item).getItem().a());
            }
            if (item instanceof ScheduleInfoItem) {
                return CalendarEx.f214714a.d(((ScheduleInfoItem) item).getInfo().getStartTimeMs());
            }
            if (item instanceof ScheduleEmptyPlaceholderItem) {
                return CalendarEx.f214714a.d(((ScheduleEmptyPlaceholderItem) item).getDate().d());
            }
            return CalendarEx.f214714a.e();
        }
    }

    boolean a();

    @NotNull
    String getText();

    int getType();
}
