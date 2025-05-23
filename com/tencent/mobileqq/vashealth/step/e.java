package com.tencent.mobileqq.vashealth.step;

import android.content.ContentValues;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vashealth/step/e;", "", "Lcom/tencent/mobileqq/vashealth/step/m;", "stepRecord", "", "updateTime", "", "sensorValue", "", "c", "", "e", tl.h.F, "dayOffset", "f", "step", "d", "time", "g", "", "dayKey", "b", "Lkotlin/Pair;", "a", "Lcom/tencent/mobileqq/vashealth/step/b;", "Lcom/tencent/mobileqq/vashealth/step/b;", "dbHelper", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f312337a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b dbHelper = new b();

    e() {
    }

    private final boolean c(m stepRecord, long updateTime, int sensorValue) {
        int abs = Math.abs(sensorValue - stepRecord.getSensorValue());
        long updateTime2 = (updateTime - stepRecord.getUpdateTime()) / 1000;
        if (updateTime2 == 0) {
            if (sensorValue - stepRecord.getSensorValue() > 0) {
                return true;
            }
        } else if (abs / updateTime2 < 5) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Pair<Long, Integer> a() {
        String valueOf = String.valueOf(l.f312344a.a(0));
        Pair<Long, Integer> pair = new Pair<>(-1L, -1);
        b bVar = dbHelper;
        if (!bVar.j(valueOf)) {
            return pair;
        }
        m i3 = bVar.i(valueOf);
        if (i3 == null) {
            return pair;
        }
        return new Pair<>(Long.valueOf(i3.getUpdateTime()), Integer.valueOf(i3.getSensorValue()));
    }

    public final int b(@NotNull String dayKey) {
        m i3;
        Intrinsics.checkNotNullParameter(dayKey, "dayKey");
        b bVar = dbHelper;
        if (!bVar.j(dayKey) || (i3 = bVar.i(dayKey)) == null) {
            return 0;
        }
        return i3.getStep();
    }

    public final void d(long updateTime, int step) {
        String valueOf = String.valueOf(l.f312344a.a(0));
        ContentValues contentValues = new ContentValues();
        b bVar = dbHelper;
        if (!bVar.j(valueOf)) {
            contentValues.put("day", valueOf);
            contentValues.put("step", Integer.valueOf(step));
            contentValues.put("sensorValue", (Integer) 0);
            contentValues.put("updateTime", Long.valueOf(updateTime));
            contentValues.put("shutDownTime", (Long) 0L);
            bVar.b(contentValues);
            return;
        }
        contentValues.put("updateTime", Long.valueOf(updateTime));
        contentValues.put("step", Integer.valueOf(step));
        bVar.c("day=?", new String[]{valueOf}, contentValues);
    }

    public final void e(long updateTime, int sensorValue) {
        f(updateTime, sensorValue, 0);
    }

    public final void f(long updateTime, int sensorValue, int dayOffset) {
        int step;
        if (sensorValue == 0) {
            QLog.d("SportDbHelper", 1, "step is 0, updateDataToDb cancel");
            return;
        }
        synchronized (this) {
            String valueOf = String.valueOf(l.f312344a.a(dayOffset));
            ContentValues contentValues = new ContentValues();
            b bVar = dbHelper;
            if (!bVar.j(valueOf)) {
                contentValues.put("day", valueOf);
                contentValues.put("step", (Long) 0L);
                contentValues.put("sensorValue", Long.valueOf(sensorValue));
                contentValues.put("updateTime", Long.valueOf(updateTime));
                contentValues.put("shutDownTime", (Long) 0L);
                bVar.b(contentValues);
                return;
            }
            m i3 = bVar.i(valueOf);
            if (i3 == null) {
                return;
            }
            if (sensorValue == i3.getSensorValue()) {
                QLog.d("SportDbHelper", 2, "step is invalid, updateDataToDb cancel");
                return;
            }
            contentValues.put("updateTime", Long.valueOf(updateTime));
            int step2 = i3.getStep();
            if (f312337a.c(i3, updateTime, sensorValue)) {
                if (sensorValue >= i3.getSensorValue()) {
                    step = (i3.getStep() + sensorValue) - i3.getSensorValue();
                } else {
                    step = i3.getStep() + sensorValue;
                }
                step2 = step;
            }
            contentValues.put("sensorValue", Integer.valueOf(sensorValue));
            contentValues.put("step", Integer.valueOf(step2));
            bVar.c("day=?", new String[]{valueOf}, contentValues);
        }
    }

    public final void g(long time) {
        String valueOf = String.valueOf(l.f312344a.a(0));
        ContentValues contentValues = new ContentValues();
        b bVar = dbHelper;
        if (!bVar.j(valueOf) || bVar.i(valueOf) == null) {
            return;
        }
        contentValues.put("shutDownTime", Long.valueOf(time));
        bVar.c("day=?", new String[]{valueOf}, contentValues);
    }

    public final void h(long updateTime, int sensorValue) {
        f(updateTime, sensorValue, -1);
    }
}
