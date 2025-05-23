package com.tencent.mobileqq.guild.rolegroup.levelrole;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001ej\b\u0012\u0004\u0012\u00020\u0004`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "newList", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemViewType", "getItemCount", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;", "pageLayoutType", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isNewFeedSquareGuild", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a$b;", "D", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a$b;", "callback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "mList", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;ZLcom/tencent/mobileqq/guild/rolegroup/levelrole/a$b;)V", UserInfo.SEX_FEMALE, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isNewFeedSquareGuild;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b callback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<LevelRoleUIData> mList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PageLayoutType pageLayoutType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a$b;", "", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "itemData", "", "isChecked", "", "c", "d", "a", "", "roleId", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a(@Nullable View v3, @NotNull LevelRoleUIData itemData);

        boolean b(@NotNull String roleId);

        void c(@Nullable View v3, @NotNull LevelRoleUIData itemData, boolean isChecked);

        void d(@Nullable View v3, @NotNull LevelRoleUIData itemData);
    }

    public a(@NotNull PageLayoutType pageLayoutType, boolean z16, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(pageLayoutType, "pageLayoutType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pageLayoutType = pageLayoutType;
        this.isNewFeedSquareGuild = z16;
        this.callback = callback;
        this.mList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        String roleId = this.mList.get(position).getRoleId();
        if (Intrinsics.areEqual(roleId, "LEVEL_ROLE_TIP_ID")) {
            return 1;
        }
        if (Intrinsics.areEqual(roleId, "LEVEL_ROLE_SPACE_ID")) {
            return 2;
        }
        return 3;
    }

    public final void i0(@NotNull List<LevelRoleUIData> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.mList.clear();
        this.mList.addAll(newList);
        Logger.f235387a.d().d("Guild.rg.LevelRole.ListAdapter", 1, "refreshUiDataItem size:" + newList.size());
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof f) {
            LevelRoleUIData levelRoleUIData = this.mList.get(position);
            Intrinsics.checkNotNullExpressionValue(levelRoleUIData, "mList[position]");
            ((f) holder).r(levelRoleUIData);
        } else if (holder instanceof h) {
            LevelRoleUIData levelRoleUIData2 = this.mList.get(position);
            Intrinsics.checkNotNullExpressionValue(levelRoleUIData2, "mList[position]");
            ((h) holder).l(levelRoleUIData2);
        } else if (holder instanceof g) {
            LevelRoleUIData levelRoleUIData3 = this.mList.get(position);
            Intrinsics.checkNotNullExpressionValue(levelRoleUIData3, "mList[position]");
            ((g) holder).l(levelRoleUIData3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 2) {
                if (viewType == 3) {
                    return new f(parent, this.pageLayoutType, this.isNewFeedSquareGuild, this.callback);
                }
                throw new IllegalArgumentException("Unknown viewType:" + viewType);
            }
            return new g(parent);
        }
        return new h(parent);
    }
}
