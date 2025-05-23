package eq0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b:\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016R$\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010-\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R$\u00100\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R$\u00103\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R$\u00106\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R$\u00109\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R$\u0010<\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010%\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R$\u0010?\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010%\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R$\u0010B\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010%\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)\u00a8\u0006E"}, d2 = {"Leq0/c;", "Leq0/g;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "isSelf", "Landroid/view/View;", "d", "view", "", "f", "a", "g", "b", "c", "e", DomainData.DOMAIN_NAME, "k", ReportConstant.COSTREPORT_PREFIX, "r", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "p", "t", "l", h.F, "Landroid/view/ViewGroup;", "u", "()Landroid/view/ViewGroup;", HippyTKDListViewAdapter.X, "(Landroid/view/ViewGroup;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "getAvatarView", "()Landroid/view/View;", "v", "(Landroid/view/View;)V", "avatarView", "getNickView", "setNickView", "nickView", "getContentView", "w", "contentView", "getStatusView", "setStatusView", "statusView", "getHeadView", "setHeadView", "headView", "getTailView", "setTailView", "tailView", "getEmojiView", "setEmojiView", "emojiView", "getSelectView", "setSelectView", "selectView", "getReplyView", "setReplyView", "replyView", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class c implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View avatarView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View nickView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View statusView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View headView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View tailView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View emojiView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View selectView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View replyView;

    @Override // eq0.g
    @Nullable
    public View a() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (FrameLayout) viewGroup.findViewById(R.id.zfr);
        }
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View b() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (LinearLayout) viewGroup.findViewById(R.id.zfv);
        }
        return null;
    }

    @Override // eq0.g
    public void c(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.nickView = view;
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.zg8)) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    @NotNull
    public View d(@NotNull Context context, @NotNull ViewGroup parent, boolean isSelf) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = new b().i(context, parent, false);
        ViewGroup viewGroup = (ViewGroup) view;
        this.rootView = viewGroup;
        if (viewGroup != null) {
            linearLayout = (LinearLayout) viewGroup.findViewById(R.id.f164907u83);
        } else {
            linearLayout = null;
        }
        if (isSelf) {
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.guild_aio_self_bubble_bg);
            }
        } else if (linearLayout != null) {
            linearLayout.setBackgroundResource(R.drawable.guild_aio_friend_bubble_bg);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // eq0.g
    @Nullable
    public View e() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (LinearLayout) viewGroup.findViewById(R.id.zg8);
        }
        return null;
    }

    @Override // eq0.g
    public void f(@Nullable View view) {
        FrameLayout frameLayout;
        if (view != null) {
            this.avatarView = view;
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (frameLayout = (FrameLayout) viewGroup.findViewById(R.id.zfr)) != null) {
                frameLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    public void g(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.contentView = view;
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.zfv)) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    @Nullable
    public View h() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (LinearLayout) viewGroup.findViewById(R.id.f164907u83);
        }
        return null;
    }

    @Override // eq0.g
    public void i(@Nullable View view) {
        FrameLayout frameLayout;
        if (view != null) {
            this.emojiView = view;
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (frameLayout = (FrameLayout) viewGroup.findViewById(R.id.zfx)) != null) {
                frameLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    public void j(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.headView = view;
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.f166331zg3)) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    @Nullable
    public View k() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (LinearLayout) viewGroup.findViewById(R.id.zgm);
        }
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View l() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (LinearLayout) viewGroup.findViewById(R.id.zg7);
        }
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View m() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (LinearLayout) viewGroup.findViewById(R.id.f166331zg3);
        }
        return null;
    }

    @Override // eq0.g
    public void n(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.statusView = view;
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.zgm)) != null) {
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
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null && (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.zgk)) != null) {
            linearLayout.addView(view);
        }
    }

    @Override // eq0.g
    @Nullable
    public View p() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (LinearLayout) viewGroup.findViewById(R.id.zgk);
        }
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View q() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (FrameLayout) viewGroup.findViewById(R.id.zfx);
        }
        return null;
    }

    @Override // eq0.g
    @Nullable
    public View r() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            return (LinearLayout) viewGroup.findViewById(R.id.zgs);
        }
        return null;
    }

    @Override // eq0.g
    public void s(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.tailView = view;
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.zgs)) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Override // eq0.g
    public void t(@Nullable View view) {
        LinearLayout linearLayout;
        if (view != null) {
            this.selectView = view;
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.zg7)) != null) {
                linearLayout.addView(view);
            }
        }
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final void v(@Nullable View view) {
        this.avatarView = view;
    }

    public final void w(@Nullable View view) {
        this.contentView = view;
    }

    public final void x(@Nullable ViewGroup viewGroup) {
        this.rootView = viewGroup;
    }
}
