package p14;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.robot.adelie.homepage.cards.role.AdelieHomeRoleCardItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lp14/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lp14/h;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "coreInfo", "", "subjectName", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "i0", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "robotCoreInfo", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends RecyclerView.Adapter<h> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String subjectName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<RobotCoreInfo> robotCoreInfo;

    public e() {
        List<RobotCoreInfo> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.robotCoreInfo = emptyList;
        this.subjectName = "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.robotCoreInfo.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull h holder, int position) {
        AdelieHomeRoleCardItem adelieHomeRoleCardItem;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= 0 && position < this.robotCoreInfo.size()) {
            RobotCoreInfo robotCoreInfo = this.robotCoreInfo.get(position);
            View view = holder.itemView;
            if (view instanceof AdelieHomeRoleCardItem) {
                adelieHomeRoleCardItem = (AdelieHomeRoleCardItem) view;
            } else {
                adelieHomeRoleCardItem = null;
            }
            if (adelieHomeRoleCardItem != null) {
                adelieHomeRoleCardItem.setData(robotCoreInfo, this.subjectName);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public h onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AdelieHomeRoleCardItem adelieHomeRoleCardItem = new AdelieHomeRoleCardItem(context, null, 0, 6, null);
        FontSettingManager.resetViewSize2Normal(parent.getContext(), adelieHomeRoleCardItem);
        return new h(adelieHomeRoleCardItem);
    }

    public final void k0(@NotNull List<RobotCoreInfo> coreInfo, @NotNull String subjectName) {
        Intrinsics.checkNotNullParameter(coreInfo, "coreInfo");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        this.robotCoreInfo = coreInfo;
        this.subjectName = subjectName;
        notifyDataSetChanged();
    }
}
