package kotlin.properties;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\"\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u00a6\u0002\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lkotlin/properties/ReadOnlyProperty;", "T", "V", "", HippyTextInputController.COMMAND_getValue, "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public interface ReadOnlyProperty<T, V> {
    V getValue(T thisRef, @NotNull KProperty<?> property);
}
