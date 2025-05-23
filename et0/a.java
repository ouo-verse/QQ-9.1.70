package et0;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH&J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0005H&J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006\u001a"}, d2 = {"Let0/a;", "", "", "isPanelOrKeyBoardShow", "isAioInputBarShow", "", "b7", "be", "Landroid/widget/TextView;", "tv", "Ea", "isSelectMode", "g", "", "seq", "E2", "", ExifInterface.LATITUDE_SOUTH, "()Ljava/lang/Integer;", "Landroid/view/View;", "msgListView", "g4", "l0", "Landroid/view/MotionEvent;", "ev", "Q4", "aio-guild-media-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface a {
    void E2(long seq);

    void Ea(@NotNull TextView tv5);

    boolean Q4(@NotNull MotionEvent ev5);

    @Nullable
    Integer S();

    void b7(boolean isPanelOrKeyBoardShow, boolean isAioInputBarShow);

    void be(boolean isPanelOrKeyBoardShow);

    void g(boolean isSelectMode);

    @Nullable
    View g4(@NotNull View msgListView);

    void l0();
}
