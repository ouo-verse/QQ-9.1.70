package pg1;

import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lpg1/g;", "", "", "K", "", "y", "f0", "position", BdhLogUtil.LogTag.Tag_Req, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", PM.BASE, "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a {
        public static int a(@NotNull g gVar, int i3) {
            if (gVar.y()) {
                return (i3 % gVar.K()) + gVar.K();
            }
            return i3;
        }

        public static boolean b(@NotNull g gVar) {
            if (gVar.K() > 1) {
                return true;
            }
            return false;
        }

        public static int c(@NotNull g gVar) {
            if (gVar.y()) {
                return 3;
            }
            return 1;
        }

        public static int d(@NotNull g gVar, int i3) {
            if (gVar.y()) {
                return i3 % gVar.K();
            }
            return i3;
        }

        public static int e(@NotNull g gVar) {
            return gVar.m().getItemCount();
        }
    }

    int K();

    int R(int position);

    int f0();

    @NotNull
    RecyclerView.Adapter<?> m();

    int q(int position);

    boolean y();
}
