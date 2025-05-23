package com.tencent.mobileqq.wink.newalbum.database;

import android.database.Cursor;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u0019\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/database/a;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", h.F, "(Ljava/lang/String;)V", "photoID", "", "b", UserInfo.SEX_FEMALE, "e", "()F", "i", "(F)V", "similarity", "", "c", "I", "()I", "g", "(I)V", "hasExposure", "f", "aestheticScore", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String photoID = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float similarity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int hasExposure;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float aestheticScore;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/database/a$a;", "", "Landroid/database/Cursor;", "cursor", "Lcom/tencent/mobileqq/wink/newalbum/database/a;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.database.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final a a(@NotNull Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            a aVar = new a();
            try {
                int columnIndex = cursor.getColumnIndex("id");
                if (columnIndex >= 0 && columnIndex < cursor.getColumnCount()) {
                    String string = cursor.getString(columnIndex);
                    Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(columnPhotoIDIndex)");
                    aVar.h(string);
                }
                int columnIndex2 = cursor.getColumnIndex("similarity");
                if (columnIndex2 >= 0 && columnIndex2 < cursor.getColumnCount()) {
                    aVar.i(cursor.getFloat(columnIndex2));
                }
                int columnIndex3 = cursor.getColumnIndex("hasexposure");
                if (columnIndex3 >= 0 && columnIndex3 < cursor.getColumnCount()) {
                    aVar.g(cursor.getInt(columnIndex3));
                }
                int columnIndex4 = cursor.getColumnIndex("aestheticscore");
                if (columnIndex4 >= 0 && columnIndex4 < cursor.getColumnCount()) {
                    aVar.f(cursor.getFloat(columnIndex4));
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }

        Companion() {
        }
    }

    @JvmStatic
    @Nullable
    public static final a a(@NotNull Cursor cursor) {
        return INSTANCE.a(cursor);
    }

    /* renamed from: b, reason: from getter */
    public final float getAestheticScore() {
        return this.aestheticScore;
    }

    /* renamed from: c, reason: from getter */
    public final int getHasExposure() {
        return this.hasExposure;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getPhotoID() {
        return this.photoID;
    }

    /* renamed from: e, reason: from getter */
    public final float getSimilarity() {
        return this.similarity;
    }

    public final void f(float f16) {
        this.aestheticScore = f16;
    }

    public final void g(int i3) {
        this.hasExposure = i3;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.photoID = str;
    }

    public final void i(float f16) {
        this.similarity = f16;
    }
}
