package com.tencent.kuikly.core.module;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/module/ICalendar;", "", "Lcom/tencent/kuikly/core/module/ICalendar$Field;", "field", "", "value", "b", "d", "c", "", "a", "Field", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface ICalendar {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/kuikly/core/module/ICalendar$Field;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "YEAR", "MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR", "DAY_OF_WEEK", "HOUR_OF_DAY", "MINUS", "SECOND", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public enum Field {
        YEAR(1),
        MONTH(2),
        DAY_OF_MONTH(5),
        DAY_OF_YEAR(6),
        DAY_OF_WEEK(7),
        HOUR_OF_DAY(11),
        MINUS(12),
        SECOND(13);

        private final int id;

        Field(int i3) {
            this.id = i3;
        }

        public final int getId() {
            return this.id;
        }
    }

    long a();

    ICalendar b(Field field, int value);

    int c(Field field);

    ICalendar d(Field field, int value);
}
