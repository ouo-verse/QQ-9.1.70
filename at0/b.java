package at0;

import a22.d;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.guild.aio.msglist.holder.template.BubbleLayoutCompatPress;
import com.tencent.guildmedia.widget.GuildMediaMsgItemRelativeLayout;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import eq0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b(\u0010)J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0018\u0010 \u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR$\u0010'\u001a\u0004\u0018\u00010!8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lat0/b;", "Leq0/g;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "Landroid/view/View;", "d", "view", "", "f", "a", "c", "e", "g", "b", DomainData.DOMAIN_NAME, "k", ReportConstant.COSTREPORT_PREFIX, "r", "o", "p", "t", "l", "Landroid/view/View;", "avatarView", "contentView", "statusView", "tailView", "selectView", "replyView", "La22/d;", "La22/d;", "getBinding", "()La22/d;", "setBinding", "(La22/d;)V", "binding", "<init>", "()V", h.F, "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class b implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View avatarView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View statusView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View tailView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View selectView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View replyView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d binding;

    @Override // eq0.g
    @Nullable
    public View a() {
        d dVar = this.binding;
        if (dVar != null) {
            return dVar.f25387d;
        }
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View b() {
        d dVar = this.binding;
        if (dVar != null) {
            return dVar.f25388e;
        }
        return null;
    }

    @Override // eq0.g
    @NotNull
    public View d(@NotNull Context context, @NotNull ViewGroup parent, boolean isSelf) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        d g16 = d.g(LayoutInflater.from(context), parent, false);
        this.binding = g16;
        Intrinsics.checkNotNull(g16);
        GuildMediaMsgItemRelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding!!.root");
        return root;
    }

    @Override // eq0.g
    @Nullable
    public View e() {
        d dVar = this.binding;
        if (dVar != null) {
            return dVar.f25390g;
        }
        return null;
    }

    @Override // eq0.g
    public void f(@Nullable View view) {
        FrameLayout frameLayout;
        if (view != null) {
            this.avatarView = view;
            d dVar = this.binding;
            if (dVar != null && (frameLayout = dVar.f25387d) != null) {
                frameLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    public void g(@Nullable View view) {
        BubbleLayoutCompatPress bubbleLayoutCompatPress;
        if (view != null) {
            this.contentView = view;
            d dVar = this.binding;
            if (dVar != null && (bubbleLayoutCompatPress = dVar.f25388e) != null) {
                bubbleLayoutCompatPress.addView(view);
            }
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
        d dVar = this.binding;
        if (dVar != null) {
            return dVar.f25392i;
        }
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View l() {
        d dVar = this.binding;
        if (dVar != null) {
            return dVar.f25389f;
        }
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View m() {
        return g.a.b(this);
    }

    @Override // eq0.g
    public void n(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.statusView = view;
            d dVar = this.binding;
            if (dVar != null && (linearLayout = dVar.f25392i) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    public void o(@Nullable View view) {
        LinearLayout linearLayout;
        if (view == null) {
            return;
        }
        this.replyView = view;
        d dVar = this.binding;
        if (dVar != null && (linearLayout = dVar.f25391h) != null) {
            linearLayout.addView(view);
        }
    }

    @Override // eq0.g
    @Nullable
    public View p() {
        d dVar = this.binding;
        if (dVar != null) {
            return dVar.f25391h;
        }
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
        d dVar = this.binding;
        if (dVar != null) {
            return dVar.f25393j;
        }
        return null;
    }

    @Override // eq0.g
    public void s(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.tailView = view;
            d dVar = this.binding;
            if (dVar != null && (linearLayout = dVar.f25393j) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    public void t(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.selectView = view;
            d dVar = this.binding;
            if (dVar != null && (linearLayout = dVar.f25389f) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    public void c(@Nullable View view) {
    }
}
