package com.tencent.mobileqq.guild.rolegroup.view.singlerevokerole;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelPanel;
import com.tencent.mobileqq.utils.ViewUtils;
import hy1.a;
import hy1.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\u0012B+\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/view/singlerevokerole/DialogRoleLabelPanel;", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelPanel;", "", "c", "Lhy1/a;", "b", "Lhy1/b;", "d", "", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DialogRoleLabelPanel extends RoleLabelPanel {

    /* renamed from: m, reason: collision with root package name */
    private static final int f232850m = ViewUtils.dpToPx(3.0f);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialogRoleLabelPanel(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelPanel
    public boolean a() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelPanel
    @NotNull
    public a b() {
        return new iy1.a();
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelPanel
    public int c() {
        return R.layout.ekd;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelPanel
    @NotNull
    public b d() {
        return new b(f232850m, 2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialogRoleLabelPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialogRoleLabelPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogRoleLabelPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
