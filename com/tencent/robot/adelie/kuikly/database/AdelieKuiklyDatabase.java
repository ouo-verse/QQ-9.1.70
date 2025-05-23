package com.tencent.robot.adelie.kuikly.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import e24.KuiklyData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Database(entities = {KuiklyData.class}, exportSchema = false, version = 2)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/database/AdelieKuiklyDatabase;", "Landroidx/room/RoomDatabase;", "Le24/a;", "c", "<init>", "()V", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class AdelieKuiklyDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/database/AdelieKuiklyDatabase$a;", "", "Lcom/tencent/robot/adelie/kuikly/database/AdelieKuiklyDatabase;", "b", "Lcom/tencent/robot/adelie/kuikly/database/AdelieKuiklyDatabase;", "a", "()Lcom/tencent/robot/adelie/kuikly/database/AdelieKuiklyDatabase;", "INSTANCE", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f366718a = new a();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final AdelieKuiklyDatabase INSTANCE;

        static {
            RoomDatabase build = Room.databaseBuilder(MobileQQ.sMobileQQ, AdelieKuiklyDatabase.class, "adelie_kuikly").fallbackToDestructiveMigration().build();
            Intrinsics.checkNotNullExpressionValue(build, "databaseBuilder(\n       \u2026uctiveMigration().build()");
            INSTANCE = (AdelieKuiklyDatabase) build;
        }

        a() {
        }

        @NotNull
        public final AdelieKuiklyDatabase a() {
            return INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/database/AdelieKuiklyDatabase$b;", "", "Lcom/tencent/robot/adelie/kuikly/database/AdelieKuiklyDatabase;", "a", "", "DATABASE_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.kuikly.database.AdelieKuiklyDatabase$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AdelieKuiklyDatabase a() {
            return a.f366718a.a();
        }

        Companion() {
        }
    }

    @NotNull
    public abstract e24.a c();
}
