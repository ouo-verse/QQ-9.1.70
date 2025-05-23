package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: P */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Function {
    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).yieldIfContendedSafely());
    }
}
