package kz1;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lkz1/n;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmz1/c;", "Lkz1/i;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "viewHolder", "position", "", "i0", "getItemViewType", "Llz1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Llz1/a;", "getClickIoc", "()Llz1/a;", "clickIoc", "<init>", "(Llz1/a;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class n extends ListAdapter<mz1.c, i<mz1.c>> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final lz1.a clickIoc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull lz1.a clickIoc) {
        super(new o());
        Intrinsics.checkNotNullParameter(clickIoc, "clickIoc");
        this.clickIoc = clickIoc;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull i<mz1.c> viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        mz1.c item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        viewHolder.m(item, position, this.clickIoc);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public i<mz1.c> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        i<mz1.c> a16;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType != 1) {
                if (viewType != 2) {
                    if (viewType != 3) {
                        if (viewType != 4) {
                            a16 = m.INSTANCE.a(parent);
                            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.adapter.BaseApplicationManageViewHolder<com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.model.BaseAppItem>");
                        } else {
                            a16 = k.INSTANCE.a(parent);
                            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.adapter.BaseApplicationManageViewHolder<com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.model.BaseAppItem>");
                        }
                    } else {
                        a16 = j.INSTANCE.a(parent);
                        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.adapter.BaseApplicationManageViewHolder<com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.model.BaseAppItem>");
                    }
                } else {
                    a16 = p.INSTANCE.a(parent);
                    Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.adapter.BaseApplicationManageViewHolder<com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.model.BaseAppItem>");
                }
            } else {
                a16 = f.INSTANCE.a(parent);
                Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.adapter.BaseApplicationManageViewHolder<com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.model.BaseAppItem>");
            }
        } else {
            a16 = m.INSTANCE.a(parent);
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.adapter.BaseApplicationManageViewHolder<com.tencent.mobileqq.guild.setting.guildmanage.guildappmanage.model.BaseAppItem>");
        }
        a16.p(this.clickIoc);
        return a16;
    }
}
