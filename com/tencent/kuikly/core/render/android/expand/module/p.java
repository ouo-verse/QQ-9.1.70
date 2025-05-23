package com.tencent.kuikly.core.render.android.expand.module;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001BB\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016R/\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/p;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteDatabase;", TVKNetVideoInfo.AUDIO_TRACK_DOLBY, "", "onConfigure", "onCreate", "", "oldVersion", "newVersion", "onUpgrade", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "lastVersion", "d", "Lkotlin/jvm/functions/Function1;", "lastDbVersionGetter", "Landroid/content/Context;", "context", "", "dbName", "dbVersion", "<init>", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class p extends SQLiteOpenHelper {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function1<Integer, Unit> lastDbVersionGetter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public p(@NotNull Context context, @NotNull String dbName, int i3, @NotNull Function1<? super Integer, Unit> lastDbVersionGetter) {
        super(context, dbName, (SQLiteDatabase.CursorFactory) null, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dbName, "dbName");
        Intrinsics.checkNotNullParameter(lastDbVersionGetter, "lastDbVersionGetter");
        this.lastDbVersionGetter = lastDbVersionGetter;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(@Nullable SQLiteDatabase db5) {
        int i3;
        super.onConfigure(db5);
        Function1<Integer, Unit> function1 = this.lastDbVersionGetter;
        if (db5 != null) {
            i3 = db5.getVersion();
        } else {
            i3 = 0;
        }
        function1.invoke(Integer.valueOf(i3));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(@Nullable SQLiteDatabase db5) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(@Nullable SQLiteDatabase db5, int oldVersion, int newVersion) {
    }
}
