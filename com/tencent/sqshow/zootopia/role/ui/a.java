package com.tencent.sqshow.zootopia.role.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.sqshow.zootopia.role.logic.CreateRoleController;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qv4.bb;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0015\b&\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002@AB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b>\u0010?J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\bH\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010'\u001a\u00020\b8\u0000X\u0080D\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010,\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010$\u001a\u0004\b6\u0010&\"\u0004\b7\u0010+R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lqv4/bb;", "materialInfoList", "", "setData", "", "gender", "r0", "getData", "selectedPosition", "t0", "Lcom/tencent/sqshow/zootopia/role/ui/a$b;", "onItemClickListener", "s0", "holder", "position", "onBindViewHolder", "localPosition", "p0", "getItemCount", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "k0", "()Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "mController", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "l0", "()Ljava/util/List;", "setMaterialInfoList$superqqshow_portal_impl_release", "(Ljava/util/List;)V", "D", "I", "n0", "()I", "pageItemNum", "E", "j0", "setCurGender$superqqshow_portal_impl_release", "(I)V", "curGender", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "i0", "()Ljava/lang/String;", "q0", "(Ljava/lang/String;)V", "avatarId", "G", "o0", "setSelectedPosition", "H", "Lcom/tencent/sqshow/zootopia/role/ui/a$b;", "m0", "()Lcom/tencent/sqshow/zootopia/role/ui/a$b;", "setOnItemClickListener$superqqshow_portal_impl_release", "(Lcom/tencent/sqshow/zootopia/role/ui/a$b;)V", "<init>", "(Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;)V", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private List<bb> materialInfoList;

    /* renamed from: D, reason: from kotlin metadata */
    private final int pageItemNum;

    /* renamed from: E, reason: from kotlin metadata */
    private int curGender;

    /* renamed from: F, reason: from kotlin metadata */
    private String avatarId;

    /* renamed from: G, reason: from kotlin metadata */
    private int selectedPosition;

    /* renamed from: H, reason: from kotlin metadata */
    private b onItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final CreateRoleController mController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/ui/a$b;", "", "", "position", "Lqv4/bb;", "materialInfo", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(int position, bb materialInfo);
    }

    public a(CreateRoleController mController) {
        Intrinsics.checkNotNullParameter(mController, "mController");
        this.mController = mController;
        this.materialInfoList = new ArrayList();
        this.pageItemNum = 5;
        this.curGender = UEAvatarGender.FEMALE.getIndex();
        this.avatarId = "";
    }

    public final List<bb> getData() {
        return this.materialInfoList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.materialInfoList.size();
    }

    /* renamed from: i0, reason: from getter */
    public final String getAvatarId() {
        return this.avatarId;
    }

    /* renamed from: j0, reason: from getter */
    public final int getCurGender() {
        return this.curGender;
    }

    /* renamed from: k0, reason: from getter */
    public final CreateRoleController getMController() {
        return this.mController;
    }

    public final List<bb> l0() {
        return this.materialInfoList;
    }

    /* renamed from: m0, reason: from getter */
    public final b getOnItemClickListener() {
        return this.onItemClickListener;
    }

    /* renamed from: n0, reason: from getter */
    public final int getPageItemNum() {
        return this.pageItemNum;
    }

    /* renamed from: o0, reason: from getter */
    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public final void p0(int localPosition) {
        int i3 = this.selectedPosition;
        this.selectedPosition = localPosition;
        notifyItemChanged(i3, "selectOnly");
        notifyItemChanged(this.selectedPosition, "selectOnly");
    }

    public final void q0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarId = str;
    }

    public final void r0(int gender) {
        this.curGender = gender;
    }

    public final void s0(b onItemClickListener) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.onItemClickListener = onItemClickListener;
    }

    public final void setData(List<bb> materialInfoList) {
        Intrinsics.checkNotNullParameter(materialInfoList, "materialInfoList");
        this.materialInfoList = materialInfoList;
        notifyItemRangeChanged(0, materialInfoList.size());
    }

    public final void t0(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        p0(selectedPosition);
    }
}
