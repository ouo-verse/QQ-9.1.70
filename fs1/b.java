package fs1;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.libra.LoadState;
import com.tencent.libra.help.RFWPicHelper;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.config.r;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.mainframe.view.GuildDragTextView;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.performance.report.t;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.h;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TypefaceProvider;
import com.tencent.mobileqq.guild.widget.LeftBarAvatarFrameLayout;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import er1.DrawableType;
import er1.UnreadDotType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import r01.d;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b extends RecyclerView.ViewHolder implements h {
    public static final int S = 2131371263;
    private static int T;
    private static int U;
    private static int V;
    private static int W;
    private static int X;
    private static int Y;
    private View E;
    private View F;
    private View G;
    private View H;
    private LeftBarAvatarFrameLayout I;
    private ImageView J;
    private GuildDragTextView K;
    private ViewStub L;
    private View M;
    private ImageView N;
    private cs1.b P;
    private boolean Q;
    private ValueAnimator R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, QQGuildUIUtil.f(16.0f), QQGuildUIUtil.f(16.0f)), QQGuildUIUtil.f(8.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        WeakReference<b> f400478e;

        /* renamed from: f, reason: collision with root package name */
        int f400479f;

        public c(b bVar, int i3) {
            super(true);
            this.f400478e = new WeakReference<>(bVar);
            this.f400479f = i3;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            b bVar = this.f400478e.get();
            if (bVar == null) {
                return;
            }
            int i3 = this.f400479f;
            if (i3 == 1) {
                bVar.H(loadState, option);
            } else if (i3 == 2) {
                bVar.I(loadState, option);
            }
        }
    }

    public b(@NonNull View view) {
        super(view);
        this.Q = false;
        C();
        B();
    }

    private void A() {
        this.K.setVisibility(8);
        this.K.setText("0");
        this.I.setTopRightHole(0, 0, true);
    }

    private void B() {
        T = QQGuildUIUtil.f(4.0f);
        U = QQGuildUIUtil.f(11.0f);
        V = QQGuildUIUtil.f(30.0f);
        W = QQGuildUIUtil.f(48.0f);
        X = QQGuildUIUtil.f(140.0f);
        this.R = com.tencent.mobileqq.guild.mainframe.startpanel.leftbar.animation.c.c(this.I, 200L, 0, 255, R.drawable.guild_leftbar_selected_bg);
        QLog.d("Guild.MF.Lt.GuildLeftBarItemViewHolder", 2, "initData");
    }

    private void C() {
        this.E = this.itemView.findViewById(R.id.f166067yk1);
        View findViewById = this.itemView.findViewById(R.id.f26980f0);
        this.F = findViewById;
        com.tencent.mobileqq.guild.component.token.c.d(findViewById, null);
        this.G = this.itemView.findViewById(R.id.t1t);
        this.I = (LeftBarAvatarFrameLayout) this.itemView.findViewById(R.id.t18);
        this.H = this.itemView.findViewById(R.id.t1r);
        this.J = (ImageView) this.itemView.findViewById(R.id.t1g);
        this.K = (GuildDragTextView) this.itemView.findViewById(R.id.kio);
        ImageView imageView = (ImageView) this.itemView.findViewById(R.id.f88084w4);
        this.N = imageView;
        imageView.setOutlineProvider(new a());
        com.tencent.mobileqq.guild.component.token.c.d(this.F, null);
        this.N.setClipToOutline(true);
        this.L = (ViewStub) this.itemView.findViewById(R.id.w0i);
        GuildDragTextView guildDragTextView = this.K;
        guildDragTextView.setTypeface(TypefaceProvider.c(guildDragTextView.getContext(), "fonts/DIN-NextLT-Pro-QQ.ttf"));
        this.K.setDragViewType(2, this.itemView);
        Y = this.itemView.getResources().getColor(R.color.f157154bs0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(int i3) {
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(LoadState loadState, Option option) {
        String str;
        K(loadState, option);
        if (loadState == LoadState.STATE_SUCCESS && option.getResultBitMap() != null) {
            h12.c.c(option.getUrl(), new BitmapDrawable(option.getResultBitMap()));
            return;
        }
        if (option.getTargetView() == null) {
            QLog.w("Guild.MF.Lt.GuildLeftBarItemViewHolder", 1, "bindGuildAvatarView finish state:" + loadState + " |url:" + option.getUrl() + " targetview is null");
            return;
        }
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.w("Guild.MF.Lt.GuildLeftBarItemViewHolder", 1, "bindGuildAvatarView: failed state:" + loadState + " |url:" + option.getUrl() + " |view hashcode:" + option.getTargetView().hashCode());
            if (!(option.getTargetView().getTag(R.id.t1g) instanceof String)) {
                str = "";
            } else {
                str = (String) option.getTargetView().getTag(R.id.t1g);
            }
            if (TextUtils.equals(str, option.getUrl())) {
                option.getTargetView().setTag(R.id.t1g, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(LoadState loadState, Option option) {
        if (loadState.isFinishSuccess() && option.getAnimatable() != null) {
            r01.c cVar = (r01.c) option.getAnimatable();
            cVar.setLoopCount(1);
            cVar.start();
            cVar.r(new d() { // from class: fs1.a
                @Override // r01.d
                public final void a(int i3) {
                    b.this.D(i3);
                }
            });
        }
    }

    private void K(LoadState loadState, Option option) {
        t.b(loadState, option, "2");
    }

    private void L() {
        this.K.setText("");
        new DrawableType(R.drawable.guild_page_strong_unread_bg, Integer.valueOf(R.color.qui_common_feedback_normal)).a(this.K);
        this.K.setVisibility(0);
        this.K.getLayoutParams().height = U;
        ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
        int i3 = U;
        layoutParams.width = i3;
        this.I.setTopRightHole(i3, i3, false);
    }

    private void M(int i3) {
        QQGuildUIUtil.P(this.K, i3, new UnreadDotType(new DrawableType(R.drawable.guild_page_strong_unread_bg, null), R.color.qui_common_text_allwhite_primary));
        ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -2;
        this.K.setLayoutParams(layoutParams);
        this.K.setVisibility(0);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.K.measure(makeMeasureSpec, makeMeasureSpec);
        this.I.setTopRightHole(this.K.getMeasuredWidth(), this.K.getMeasuredHeight(), true);
    }

    private void o() {
        int i3 = 8;
        if (this.P.f391797f) {
            if (this.M == null) {
                this.M = this.L.inflate();
            }
            this.M.setVisibility(0);
            View findViewById = this.M.findViewById(R.id.w0g);
            if (this.P.f391798h) {
                i3 = 0;
            }
            findViewById.setVisibility(i3);
            return;
        }
        View view = this.M;
        if (view != null) {
            view.setVisibility(8);
            this.M.findViewById(R.id.w0g).setVisibility(8);
        }
    }

    private void p(Option option) {
        String str;
        if (this.J.getTag(R.id.t1g) instanceof String) {
            str = (String) this.J.getTag(R.id.t1g);
        } else {
            str = "";
        }
        if (TextUtils.equals(str, this.P.C)) {
            return;
        }
        if (QLog.isColorLevel()) {
            cs1.b bVar = this.P;
            QLog.d("Guild.MF.Lt.GuildLeftBarItemViewHolder", 2, "start bindGuildAvatarView guildId:", bVar.f391796e, " url:", bVar.C, " |view hashcode:", Integer.valueOf(this.J.hashCode()));
        }
        this.J.setTag(R.id.t1g, this.P.C);
        e.a().f(option, new c(this, 2));
    }

    private void q() {
        cs1.b bVar = this.P;
        int i3 = bVar.f391800m;
        if (i3 != 0) {
            this.J.setImageResource(i3);
            u();
            return;
        }
        if (TextUtils.isEmpty(bVar.C)) {
            QLog.d("Guild.MF.Lt.GuildLeftBarItemViewHolder", 1, this.P.f391796e, " bindGuildAvatarView avatar url is empty |view hashcode:", Integer.valueOf(this.J.hashCode()));
            this.J.setImageDrawable(QQGuildUIUtil.k(false));
            u();
            return;
        }
        Drawable y16 = y();
        Option requestWidth = new Option().setUrl(this.P.C).setTargetView(this.J).setNeedFilterUrl(false).setLoadingDrawable(QQGuildUIUtil.k(false)).setRequestHeight(X).setRequestWidth(X);
        if (y16 == null && QzoneConfig.guildUseQCirclePicLoader()) {
            p(requestWidth);
        } else if (this.J.getDrawable() != y16) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Lt.GuildLeftBarItemViewHolder", 2, "setImageDrawable: ", this.P.C, " |view hashcode:", Integer.valueOf(this.J.hashCode()));
            }
            this.J.setTag(R.id.t1g, this.P.C);
            this.J.setImageDrawable(y16);
        }
    }

    private void r(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue != 1) {
                if (intValue == 3) {
                    o();
                }
            } else {
                q();
            }
        }
    }

    private void u() {
        RFWPicHelper.clearViewPicTag(this.J);
        this.J.setTag(R.id.t1g, "");
    }

    private int w() {
        return this.E.getResources().getColor(R.color.qui_common_fill_standard_primary);
    }

    public static String x(int i3, String str) {
        return "guild_leftbar_" + i3 + str;
    }

    private Drawable y() {
        if (QzoneConfig.guildUseQCirclePicLoader() && !TextUtils.isEmpty(this.P.C)) {
            return h12.c.g(this.P.C);
        }
        Drawable h16 = h12.c.h(this.P.C, X, "", null);
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Lt.GuildLeftBarItemViewHolder", 2, "getDrawable guildId:" + this.P.f391796e + " url: " + this.P.C + ", headDrawable: " + h16);
        }
        return h16;
    }

    public static List<Integer> z(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof Boolean) {
                    return new ArrayList();
                }
                if (obj instanceof List) {
                    List list2 = (List) obj;
                    if (!list2.isEmpty()) {
                        arrayList.addAll(list2);
                    }
                }
            }
        }
        return arrayList;
    }

    public void E(cs1.b bVar, List<Object> list) {
        this.P = bVar;
        List<Integer> arrayList = new ArrayList<>();
        if (!list.isEmpty()) {
            Iterator<Object> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (next instanceof Boolean) {
                    this.Q = ((Boolean) next).booleanValue();
                    arrayList.clear();
                    break;
                } else if (next instanceof List) {
                    List list2 = (List) next;
                    if (!list2.isEmpty()) {
                        arrayList.addAll(list2);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Lt.GuildLeftBarItemViewHolder", 2, "onBindViewHolder payloads:", list, " item=", bVar.i());
            }
        }
        if (!arrayList.isEmpty()) {
            r(arrayList);
        } else {
            J();
        }
        this.F.setTag(S, bVar);
    }

    @SuppressLint({"NewApi"})
    public void J() {
        boolean z16;
        if (this.P == null) {
            return;
        }
        ViewCompat.setBackground(this.H, ResourcesCompat.getDrawable(this.H.getContext().getResources(), R.drawable.qui_common_bg_middle_light_bg, this.H.getContext().getTheme()));
        if (!this.Q && this.P.j()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.I.setBackgroundResource(R.drawable.guild_leftbar_selected_bg);
            this.K.setOnModeChangeListener(GuildMainFrameManager.e());
            this.K.setTag(this.P);
            GuildDragTextView guildDragTextView = this.K;
            cs1.b bVar = this.P;
            guildDragTextView.setDragGroup(x(bVar.f391795d, bVar.f391796e));
            this.G.setElevation(0.0f);
        } else {
            this.I.setBackgroundColor(0);
            this.K.setOnModeChangeListener(null);
            if (Build.VERSION.SDK_INT >= 28) {
                this.G.setOutlineAmbientShadowColor(Y);
                this.G.setOutlineSpotShadowColor(Y);
            }
            this.G.setElevation(T);
        }
        q();
        o();
        this.Q = false;
    }

    public void N(Animator.AnimatorListener animatorListener) {
        if (this.R.isRunning()) {
            this.R.cancel();
        }
        this.R.removeAllListeners();
        this.R.addListener(animatorListener);
        this.R.addListener(new C10336b());
        this.R.start();
    }

    public void O(@NonNull r rVar, boolean z16) {
        if (rVar.d() > 0 && !z16) {
            this.N.setVisibility(0);
            this.N.setImageResource(rVar.b());
            this.I.setBottomRightHole();
            this.G.getLayoutParams().width = V;
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Lt.GuildLeftBarItemViewHolder", 2, "updateAvatarStateIcon: guildStateIconInfo:", rVar, " mUIData=", this.P.f391796e);
                return;
            }
            return;
        }
        this.N.setVisibility(8);
        this.I.a();
        this.G.getLayoutParams().width = W;
    }

    public void P(boolean z16) {
        if (z16) {
            this.E.setBackgroundColor(w());
            return;
        }
        View view = this.E;
        view.setBackgroundColor(view.getResources().getColor(R.color.ajr));
        this.E.setBackground(null);
    }

    public void Q(@Nullable IGuildUnreadCntService.b bVar, boolean z16) {
        if (bVar != null) {
            long j3 = bVar.f230840d;
            if (j3 > 0 && !z16) {
                int i3 = bVar.f230841e;
                if (i3 == 1) {
                    M((int) j3);
                    return;
                } else {
                    if (i3 == 2) {
                        L();
                        return;
                    }
                    return;
                }
            }
        }
        A();
    }

    public void s() {
        this.R.cancel();
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.h
    public void setSelected(boolean z16) {
        this.itemView.setSelected(z16);
    }

    public void t() {
        this.I.setBackgroundColor(0);
    }

    public View v() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: fs1.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C10336b implements Animator.AnimatorListener {
        C10336b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.J();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.t();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
