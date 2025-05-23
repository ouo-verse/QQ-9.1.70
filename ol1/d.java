package ol1;

import android.graphics.drawable.Animatable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/libra/listener/IPicLoadStateListener;", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {
    @NotNull
    public static final IPicLoadStateListener b() {
        return new IPicLoadStateListener() { // from class: ol1.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                d.c(loadState, option);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LoadState loadState, Option option) {
        Animatable animatable;
        if (loadState == LoadState.STATE_SUCCESS && option != null && (animatable = option.getAnimatable()) != null) {
            animatable.start();
        }
    }
}
