package com.tencent.mobileqq.vashealth.step;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vashealth/step/b;", "Lcom/tencent/mobileqq/vashealth/step/a;", "", "e", "g", "dayKey", "", "j", "Lcom/tencent/mobileqq/vashealth/step/m;", "i", "f", "Ljava/lang/String;", "TAG", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    public b() {
        super("STEP");
        this.TAG = "QQSportDbHelper";
    }

    @Override // com.tencent.mobileqq.vashealth.step.a
    @NotNull
    public String e() {
        return "day TEXT NOT NULL, step LONG NOT NULL, sensorValue LONG, updateTime LONG, shutDownTime LONG, ";
    }

    @Override // com.tencent.mobileqq.vashealth.step.a
    @NotNull
    public String g() {
        return "day";
    }

    @Nullable
    public final m i(@NotNull String dayKey) {
        m mVar;
        Intrinsics.checkNotNullParameter(dayKey, "dayKey");
        synchronized (this) {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursor = null;
            r9 = null;
            m mVar2 = null;
            if (readableDatabase == null) {
                return null;
            }
            try {
                Cursor query = readableDatabase.query(getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String(), new String[]{"day", "step", "sensorValue", "shutDownTime", "updateTime"}, "day=?", new String[]{dayKey}, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        try {
                            mVar = new m();
                        } catch (Throwable th5) {
                            th = th5;
                            mVar = mVar2;
                        }
                        try {
                            int columnIndex = query.getColumnIndex("day");
                            int columnIndex2 = query.getColumnIndex("step");
                            int columnIndex3 = query.getColumnIndex("updateTime");
                            int columnIndex4 = query.getColumnIndex("sensorValue");
                            int columnIndex5 = query.getColumnIndex("shutDownTime");
                            if (columnIndex >= 0) {
                                mVar.d(query.getString(columnIndex));
                            }
                            if (columnIndex2 >= 0) {
                                mVar.g(query.getInt(columnIndex2));
                            }
                            if (columnIndex3 >= 0) {
                                mVar.h(query.getLong(columnIndex3));
                            }
                            if (columnIndex4 >= 0) {
                                mVar.e(query.getInt(columnIndex4));
                            }
                            if (columnIndex5 >= 0) {
                                mVar.f(query.getLong(columnIndex5));
                            }
                            mVar2 = mVar;
                        } catch (Throwable th6) {
                            th = th6;
                            cursor = query;
                            try {
                                QLog.e(this.TAG, 1, "execQueryByDay " + getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String() + " dayKey=" + dayKey + " exception:" + th.getMessage());
                                mVar2 = mVar;
                                return mVar2;
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                                GameCenterUtil.closeIO(readableDatabase);
                            }
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                GameCenterUtil.closeIO(readableDatabase);
            } catch (Throwable th7) {
                th = th7;
                mVar = null;
            }
            return mVar2;
        }
    }

    public final boolean j(@NotNull String dayKey) {
        boolean d16;
        Intrinsics.checkNotNullParameter(dayKey, "dayKey");
        synchronized (this) {
            d16 = d("day=?", new String[]{dayKey}, "day");
        }
        return d16;
    }
}
