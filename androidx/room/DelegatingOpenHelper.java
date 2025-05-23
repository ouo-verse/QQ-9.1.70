package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* compiled from: P */
/* loaded from: classes.dex */
interface DelegatingOpenHelper {
    @NonNull
    SupportSQLiteOpenHelper getDelegate();
}
