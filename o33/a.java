package o33;

import cooperation.qzone.mobilereport.MobileReportManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J(\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007\u00a8\u0006\r"}, d2 = {"Lo33/a;", "", "", "moduleId", "itemId", "itemType", "actionId", "", "a", "", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f421873a = new a();

    a() {
    }

    @JvmStatic
    public static final void a(int moduleId, int itemId, int itemType, int actionId) {
        MobileReportManager.getInstance().reportAction("DressVip", "3001146", String.valueOf(moduleId), "", String.valueOf(itemId), String.valueOf(itemType), actionId, 1);
    }

    @JvmStatic
    public static final void b(int moduleId, @NotNull String itemId, int itemType, int actionId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        MobileReportManager.getInstance().reportAction("DressVip", "3001146", String.valueOf(moduleId), "", itemId, String.valueOf(itemType), actionId, 1);
    }
}
