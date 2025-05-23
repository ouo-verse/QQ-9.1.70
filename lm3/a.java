package lm3;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.event.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J!\u0010\n\u001a\u00020\t\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Llm3/a;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/now/linkpkanchorplay/event/b;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent;", "L1", "Lcom/tencent/now/linkpkanchorplay/event/a;", "E", "event", "", "t1", "(Lcom/tencent/now/linkpkanchorplay/event/a;)V", "i", "Landroidx/lifecycle/MutableLiveData;", "uiEventType", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a extends ViewModel implements b {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIEvent> uiEventType = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<UIEvent> L1() {
        return this.uiEventType;
    }

    @Override // com.tencent.now.linkpkanchorplay.event.b
    public <E extends com.tencent.now.linkpkanchorplay.event.a> void t1(@NotNull E event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof UIEvent)) {
            return;
        }
        this.uiEventType.setValue(event);
    }
}
