package androidx.compose.runtime;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\n\u00c0\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/RememberManager;", "", "forgetting", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Landroidx/compose/runtime/RememberObserver;", "remembering", "sideEffect", QQWinkConstants.TAB_EFFECT, "Lkotlin/Function0;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public interface RememberManager {
    void forgetting(RememberObserver instance);

    void remembering(RememberObserver instance);

    void sideEffect(Function0<Unit> effect);
}
