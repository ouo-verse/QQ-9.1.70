package bq0;

import android.os.Bundle;
import android.view.View;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J2\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lbq0/f;", "", "", "position", "highLightStyleType", "Landroid/view/View;", "itemView", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "parserId", "Landroid/os/Bundle;", "extra", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ void a(f fVar, int i3, int i16, View view, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    i16 = 0;
                }
                if ((i17 & 4) != 0) {
                    view = null;
                }
                fVar.a(i3, i16, view);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: highLightViewHolder");
        }
    }

    void a(int position, int highLightStyleType, @Nullable View itemView);

    void b(int position, @NotNull MsgRecord msgRecord, int parserId, @NotNull Bundle extra, @Nullable View itemView);
}
