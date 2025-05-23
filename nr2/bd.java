package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.component.chat.GroupChatView;
import com.tencent.timi.game.component.gamecore.api.view.GameAuthAndBindHintView;
import com.tencent.timi.game.expand.hall.impl.mic.view.MicCardView;
import com.tencent.timi.game.expand.hall.impl.operation.HallOperationContainer;
import com.tencent.timi.game.expand.hall.impl.teamtoast.TeamToastView;
import com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout;
import com.tencent.timi.game.teamlist.view.TeamListView;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.ui.widget.TopCropImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class bd implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final WorldScaleLayout f420980a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final WorldScaleLayout f420981b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final GameAuthAndBindHintView f420982c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f420983d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final URLImageView f420984e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f420985f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final URLImageView f420986g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f420987h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f420988i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final GroupChatView f420989j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f420990k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final HallOperationContainer f420991l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f420992m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f420993n;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420994o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    public final MicCardView f420995p;

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    public final ViewStub f420996q;

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f420997r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final URLImageView f420998s;

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    public final TeamListView f420999t;

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    public final TeamToastView f421000u;

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421001v;

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    public final TopCropImageView f421002w;

    bd(@NonNull WorldScaleLayout worldScaleLayout, @NonNull WorldScaleLayout worldScaleLayout2, @NonNull GameAuthAndBindHintView gameAuthAndBindHintView, @NonNull FrameLayout frameLayout, @NonNull URLImageView uRLImageView, @NonNull RelativeLayout relativeLayout, @NonNull URLImageView uRLImageView2, @NonNull View view, @NonNull TextView textView, @NonNull GroupChatView groupChatView, @NonNull TextView textView2, @NonNull HallOperationContainer hallOperationContainer, @NonNull RelativeLayout relativeLayout2, @NonNull RoundCornerImageView roundCornerImageView, @NonNull LinearLayout linearLayout, @NonNull MicCardView micCardView, @NonNull ViewStub viewStub, @NonNull RelativeLayout relativeLayout3, @NonNull URLImageView uRLImageView3, @NonNull TeamListView teamListView, @NonNull TeamToastView teamToastView, @NonNull LinearLayout linearLayout2, @NonNull TopCropImageView topCropImageView) {
        this.f420980a = worldScaleLayout;
        this.f420981b = worldScaleLayout2;
        this.f420982c = gameAuthAndBindHintView;
        this.f420983d = frameLayout;
        this.f420984e = uRLImageView;
        this.f420985f = relativeLayout;
        this.f420986g = uRLImageView2;
        this.f420987h = view;
        this.f420988i = textView;
        this.f420989j = groupChatView;
        this.f420990k = textView2;
        this.f420991l = hallOperationContainer;
        this.f420992m = relativeLayout2;
        this.f420993n = roundCornerImageView;
        this.f420994o = linearLayout;
        this.f420995p = micCardView;
        this.f420996q = viewStub;
        this.f420997r = relativeLayout3;
        this.f420998s = uRLImageView3;
        this.f420999t = teamListView;
        this.f421000u = teamToastView;
        this.f421001v = linearLayout2;
        this.f421002w = topCropImageView;
    }

    @NonNull
    public static bd e(@NonNull View view) {
        WorldScaleLayout worldScaleLayout = (WorldScaleLayout) view;
        int i3 = R.id.sxc;
        GameAuthAndBindHintView gameAuthAndBindHintView = (GameAuthAndBindHintView) ViewBindings.findChildViewById(view, R.id.sxc);
        if (gameAuthAndBindHintView != null) {
            i3 = R.id.t2b;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.t2b);
            if (frameLayout != null) {
                i3 = R.id.t2f;
                URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.t2f);
                if (uRLImageView != null) {
                    i3 = R.id.tsv;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.tsv);
                    if (relativeLayout != null) {
                        i3 = R.id.f165116uy2;
                        URLImageView uRLImageView2 = (URLImageView) ViewBindings.findChildViewById(view, R.id.f165116uy2);
                        if (uRLImageView2 != null) {
                            i3 = R.id.f165362vo3;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f165362vo3);
                            if (findChildViewById != null) {
                                i3 = R.id.vqk;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vqk);
                                if (textView != null) {
                                    i3 = R.id.f165396vt3;
                                    GroupChatView groupChatView = (GroupChatView) ViewBindings.findChildViewById(view, R.id.f165396vt3);
                                    if (groupChatView != null) {
                                        i3 = R.id.x5u;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.x5u);
                                        if (textView2 != null) {
                                            i3 = R.id.x5v;
                                            HallOperationContainer hallOperationContainer = (HallOperationContainer) ViewBindings.findChildViewById(view, R.id.x5v);
                                            if (hallOperationContainer != null) {
                                                i3 = R.id.x7p;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.x7p);
                                                if (relativeLayout2 != null) {
                                                    i3 = R.id.x7s;
                                                    RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.x7s);
                                                    if (roundCornerImageView != null) {
                                                        i3 = R.id.x7t;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.x7t);
                                                        if (linearLayout != null) {
                                                            i3 = R.id.f166250z61;
                                                            MicCardView micCardView = (MicCardView) ViewBindings.findChildViewById(view, R.id.f166250z61);
                                                            if (micCardView != null) {
                                                                i3 = R.id.zwx;
                                                                ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.zwx);
                                                                if (viewStub != null) {
                                                                    i3 = R.id.iet;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.iet);
                                                                    if (relativeLayout3 != null) {
                                                                        i3 = R.id.f926958k;
                                                                        URLImageView uRLImageView3 = (URLImageView) ViewBindings.findChildViewById(view, R.id.f926958k);
                                                                        if (uRLImageView3 != null) {
                                                                            i3 = R.id.f927058l;
                                                                            TeamListView teamListView = (TeamListView) ViewBindings.findChildViewById(view, R.id.f927058l);
                                                                            if (teamListView != null) {
                                                                                i3 = R.id.f927558q;
                                                                                TeamToastView teamToastView = (TeamToastView) ViewBindings.findChildViewById(view, R.id.f927558q);
                                                                                if (teamToastView != null) {
                                                                                    i3 = R.id.f99495py;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f99495py);
                                                                                    if (linearLayout2 != null) {
                                                                                        i3 = R.id.f99505pz;
                                                                                        TopCropImageView topCropImageView = (TopCropImageView) ViewBindings.findChildViewById(view, R.id.f99505pz);
                                                                                        if (topCropImageView != null) {
                                                                                            return new bd(worldScaleLayout, worldScaleLayout, gameAuthAndBindHintView, frameLayout, uRLImageView, relativeLayout, uRLImageView2, findChildViewById, textView, groupChatView, textView2, hallOperationContainer, relativeLayout2, roundCornerImageView, linearLayout, micCardView, viewStub, relativeLayout3, uRLImageView3, teamListView, teamToastView, linearLayout2, topCropImageView);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static bd g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hxr, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public WorldScaleLayout getMRv() {
        return this.f420980a;
    }
}
