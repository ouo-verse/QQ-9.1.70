package h32;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.icgame.framework.eventbroadcaster.annotation.ComponentEvent;
import g32.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lh32/a;", "", "a", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ/\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0002\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lh32/a$a;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", HippyQQConstants.URL_COMPONENT_NAME, "", "Lg32/b;", "a", "(Ljava/lang/Class;)Ljava/util/List;", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: h32.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final List<Class<? extends b>> a(@NotNull Class<? extends e> component) {
            Intrinsics.checkNotNullParameter(component, "component");
            ComponentEvent componentEvent = (ComponentEvent) component.getAnnotation(ComponentEvent.class);
            if (componentEvent != null) {
                ArrayList arrayList = new ArrayList();
                for (KClass kClass : Reflection.getOrCreateKotlinClasses(componentEvent.eventList())) {
                    arrayList.add(JvmClassMappingKt.getJavaClass(kClass));
                }
                return arrayList;
            }
            return null;
        }

        Companion() {
        }
    }
}
