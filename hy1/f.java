package hy1;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010$\u001a\u00020\u001e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0010\u00a8\u0006'"}, d2 = {"Lhy1/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "p", "r", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "data", "t", "v", "o", "Lhy1/g;", "E", "Lhy1/g;", "onLabelClickListener", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "colorView", "H", "colorTv", "I", "operationView", "J", "lvIconView", "Landroid/view/View;", "K", "Landroid/view/View;", "lvNameDivide", "L", "lvName", "itemView", "<init>", "(Landroid/view/View;Lhy1/g;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final g onLabelClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView textView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView colorView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TextView colorTv;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ImageView operationView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final ImageView lvIconView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final View lvNameDivide;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private final TextView lvName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull View itemView, @Nullable g gVar) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.onLabelClickListener = gVar;
        View findViewById = itemView.findViewById(R.id.vu7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.group_name_tv)");
        this.textView = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.vth);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.group_color_iv)");
        this.colorView = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.vtj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.group_color_tv)");
        this.colorTv = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.vtt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.group_image_iv)");
        this.operationView = (ImageView) findViewById4;
        this.lvIconView = (ImageView) itemView.findViewById(R.id.f165401vu0);
        this.lvNameDivide = itemView.findViewById(R.id.wlt);
        this.lvName = (TextView) itemView.findViewById(R.id.wls);
    }

    private final void p() {
        v();
        this.colorView.setVisibility(8);
        this.operationView.setVisibility(0);
        this.textView.setText(this.itemView.getContext().getString(R.string.f138600_0));
        this.operationView.setImageResource(R.drawable.guild_role_preview_add_tiny);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: hy1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.q(f.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(f this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = this$0.onLabelClickListener;
        if (gVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            gVar.c(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void r() {
        v();
        this.colorView.setVisibility(8);
        this.operationView.setVisibility(0);
        this.textView.setVisibility(8);
        this.operationView.setImageResource(R.drawable.guild_role_group_label_more);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: hy1.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.s(f.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(f this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = this$0.onLabelClickListener;
        if (gVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            gVar.b(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void t(final RoleLabelData data) {
        boolean z16;
        String roleName;
        this.operationView.setVisibility(8);
        boolean z17 = true;
        if (data.isLevelRole() && this.lvIconView != null) {
            this.textView.setText(data.getLvName());
            if (data.getRoleName().length() != 0) {
                z17 = false;
            }
            if (z17) {
                View view = this.lvNameDivide;
                if (view != null) {
                    view.setVisibility(8);
                }
                TextView textView = this.lvName;
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else {
                View view2 = this.lvNameDivide;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                TextView textView2 = this.lvName;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.lvName;
                if (textView3 != null) {
                    textView3.setText(data.getRoleName());
                }
            }
            this.colorView.setVisibility(8);
            this.lvIconView.setVisibility(0);
            v.i(data.getLvIcon(), this.lvIconView);
        } else {
            v();
            if (data.getDisplayType() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                roleName = this.itemView.getContext().getResources().getString(R.string.f154371em) + APLogFileUtil.SEPARATOR_LOG + data.getRoleName();
            } else {
                roleName = data.getRoleName();
            }
            this.textView.setText(roleName);
            dy1.a aVar = dy1.a.f395200a;
            int roleColor = data.getRoleColor();
            int roleType = data.getRoleType();
            ImageView imageView = this.colorView;
            TextView textView4 = this.colorTv;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            aVar.d(roleColor, roleType, z16, imageView, textView4, context);
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: hy1.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                f.u(f.this, data, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(f this$0, RoleLabelData data, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        g gVar = this$0.onLabelClickListener;
        if (gVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            gVar.a(it, data);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void v() {
        ImageView imageView = this.lvIconView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.lvNameDivide;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView = this.lvName;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void o(@NotNull RoleLabelData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String roleId = data.getRoleId();
        if (Intrinsics.areEqual(roleId, "add_label_group_id")) {
            p();
        } else if (Intrinsics.areEqual(roleId, "more_label_group_id")) {
            r();
        } else {
            t(data);
        }
    }
}
