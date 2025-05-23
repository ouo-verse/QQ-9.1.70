package e54;

import com.tencent.robot.scheme.api.impl.robotaio.RobotOpenStoryAIOProcessor;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R@\u0010\u000b\u001a.\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00070\u0006j\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0007`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Le54/c;", "", "", "actionName", "Le54/a;", "a", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "processClassMap", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f395725a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Class<? extends a>> processClassMap;

    static {
        HashMap<String, Class<? extends a>> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("timbre", f.class), TuplesKt.to("invite_to_group", e.class), TuplesKt.to("open_story_list", com.tencent.robot.scheme.api.impl.robotaio.f.class), TuplesKt.to("open_story_aio", RobotOpenStoryAIOProcessor.class));
        processClassMap = hashMapOf;
    }

    c() {
    }

    @Nullable
    public final a a(@Nullable String actionName) {
        boolean z16;
        Class<? extends a> cls;
        if (actionName != null && actionName.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || (cls = processClassMap.get(actionName)) == null) {
            return null;
        }
        return cls.newInstance();
    }
}
