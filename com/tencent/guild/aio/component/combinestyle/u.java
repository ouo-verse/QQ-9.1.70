package com.tencent.guild.aio.component.combinestyle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import eq0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/u;", "Leq0/g;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "Landroid/view/View;", "d", "view", "", "f", "a", "g", "b", "c", "e", DomainData.DOMAIN_NAME, "k", ReportConstant.COSTREPORT_PREFIX, "r", "o", "p", "Lvn0/u;", "Lvn0/u;", "binding", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class u implements eq0.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private vn0.u binding;

    @Override // eq0.g
    @Nullable
    public View a() {
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View b() {
        vn0.u uVar = this.binding;
        if (uVar != null) {
            return uVar.f442038c;
        }
        return null;
    }

    @Override // eq0.g
    @NotNull
    public View d(@NotNull Context context, @NotNull ViewGroup parent, boolean isSelf) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        vn0.u g16 = vn0.u.g(LayoutInflater.from(context), parent, false);
        this.binding = g16;
        Intrinsics.checkNotNull(g16);
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding!!.root");
        return root;
    }

    @Override // eq0.g
    @Nullable
    public View e() {
        return null;
    }

    @Override // eq0.g
    public void g(@Nullable View view) {
        vn0.u uVar;
        LinearLayout linearLayout;
        if (view != null && (uVar = this.binding) != null && (linearLayout = uVar.f442038c) != null) {
            linearLayout.addView(view);
        }
    }

    @Override // eq0.g
    @Nullable
    public View h() {
        return g.a.c(this);
    }

    @Override // eq0.g
    public void i(@Nullable View view) {
        g.a.e(this, view);
    }

    @Override // eq0.g
    public void j(@Nullable View view) {
        g.a.f(this, view);
    }

    @Override // eq0.g
    @Nullable
    public View k() {
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View l() {
        return g.a.d(this);
    }

    @Override // eq0.g
    @Nullable
    public View m() {
        return g.a.b(this);
    }

    @Override // eq0.g
    @Nullable
    public View p() {
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View q() {
        return g.a.a(this);
    }

    @Override // eq0.g
    @Nullable
    public View r() {
        return null;
    }

    @Override // eq0.g
    public void t(@Nullable View view) {
        g.a.g(this, view);
    }

    @Override // eq0.g
    public void c(@Nullable View view) {
    }

    @Override // eq0.g
    public void f(@Nullable View view) {
    }

    @Override // eq0.g
    public void n(@Nullable View view) {
    }

    @Override // eq0.g
    public void o(@Nullable View view) {
    }

    @Override // eq0.g
    public void s(@Nullable View view) {
    }
}
