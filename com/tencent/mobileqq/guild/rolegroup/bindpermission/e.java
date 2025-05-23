package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.e;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0015j\b\u0012\u0004\u0012\u00020\u0004`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "newList", "", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$b;", "mCallback", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mList", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$b;)V", "D", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class e extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<RoleLabelData> mList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$b;", "", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        @Nullable
        String a();

        @NotNull
        String b();

        void c(@Nullable View v3, @NotNull RoleLabelData item);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$b;", "E", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$b;", "mCallback", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "groupName", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "groupIcon", "H", "groupAdminIcon", "I", "deleteIcon", "J", "channelName", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$b;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends RecyclerView.ViewHolder {

        @NotNull
        private static final a K = new a(null);

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final b mCallback;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView groupName;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView groupIcon;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView groupAdminIcon;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final ImageView deleteIcon;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView channelName;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$c$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes14.dex */
        private static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final View a(@NotNull ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f1j, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026roup_item, parent, false)");
                return inflate;
            }

            a() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull ViewGroup parent, @NotNull b mCallback) {
            super(K.a(parent));
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(mCallback, "mCallback");
            this.mCallback = mCallback;
            View findViewById = this.itemView.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.title)");
            this.groupName = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.xdq);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.icon_dot_role_color)");
            this.groupIcon = (ImageView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.xda);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.icon_admin_role_color)");
            this.groupAdminIcon = (TextView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.bft);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.delete_icon)");
            this.deleteIcon = (ImageView) findViewById4;
            View findViewById5 = this.itemView.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.channel_name)");
            this.channelName = (TextView) findViewById5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(c this$0, RoleLabelData item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            this$0.mCallback.c(view, item);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final RoleLabelData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.groupName.setText(item.getRoleName());
            dy1.a aVar = dy1.a.f395200a;
            int roleColor = item.getRoleColor();
            int roleType = item.getRoleType();
            boolean z16 = true;
            if (item.getDisplayType() != 1) {
                z16 = false;
            }
            ImageView imageView = this.groupIcon;
            TextView textView = this.groupAdminIcon;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            aVar.d(roleColor, roleType, z16, imageView, textView, context);
            if (item.getEnableModify()) {
                this.deleteIcon.setVisibility(0);
                this.deleteIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        e.c.n(e.c.this, item, view);
                    }
                });
            } else {
                this.deleteIcon.setVisibility(8);
                this.deleteIcon.setOnClickListener(null);
            }
            if (item.isChannelAdmin()) {
                this.channelName.setVisibility(0);
                this.channelName.setText(this.mCallback.b());
            } else if (item.isCategoryAdmin()) {
                this.channelName.setVisibility(0);
                this.channelName.setText(this.mCallback.a());
            } else {
                this.channelName.setVisibility(8);
            }
        }
    }

    public e(@NotNull b mCallback) {
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        this.mCallback = mCallback;
        this.mList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mList.size();
    }

    public final void i0(@NotNull List<RoleLabelData> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.mList.clear();
        this.mList.addAll(newList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof c) {
            RoleLabelData roleLabelData = this.mList.get(position);
            Intrinsics.checkNotNullExpressionValue(roleLabelData, "mList[position]");
            ((c) holder).m(roleLabelData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new c(parent, this.mCallback);
    }
}
