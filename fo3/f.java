package fo3;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.activity.richmedia.i;
import com.tencent.mobileqq.util.x;
import com.tencent.now.pkgame.linkscreen.PkAnotherAnchorView;
import com.tencent.now.pkgame.linkscreen.followbuttom.FollowLayout;
import com.tencent.now.pkgame.linkscreen.mutebutton.MuteButton;
import com.tencent.now.pkgame.pkgame.animation.AnimationView;
import com.tencent.now.pkgame.pkgame.pkresultview.PkResultView;
import com.tencent.now.pkgame.pkgame.pktimer.PkTimerView;
import com.tencent.now.pkgame.pkgame.pktoprank.PkTopRankView;
import com.tencent.now.pkgame.pkgame.scorebar.view.WholeScoreBarView;
import com.tencent.now.pkgame.pkgame.sei.Pos;
import hn3.LinkScreenAnchorInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f400199a;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout.LayoutParams f400200b;

    f(Context context, Pos pos, i iVar, int i3, int i16, boolean z16) {
        this.f400199a = context;
        this.f400200b = j(pos, iVar, i3, i16, z16);
    }

    private int i() {
        return k() - 20;
    }

    private int k() {
        return 42;
    }

    public static f m(@NonNull Context context, Pos pos, i iVar, int i3, int i16, boolean z16) {
        return new f(context, pos, iVar, i3, i16, z16);
    }

    public int a() {
        FrameLayout.LayoutParams layoutParams = this.f400200b;
        return layoutParams.topMargin + layoutParams.height;
    }

    public FollowLayout b(Context context, LinkScreenAnchorInfo linkScreenAnchorInfo) {
        FollowLayout followLayout = new FollowLayout(context, linkScreenAnchorInfo);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i3 = i() + 2;
        FrameLayout.LayoutParams layoutParams2 = this.f400200b;
        layoutParams.topMargin = ((layoutParams2.topMargin + layoutParams2.height) - x.c(context, i3)) - x.c(context, 20.0f);
        layoutParams.rightMargin = x.c(context, 4.0f);
        layoutParams.gravity = 5;
        followLayout.setLayoutParams(layoutParams);
        return followLayout;
    }

    public MuteButton c(Context context, long j3, boolean z16, b bVar) {
        MuteButton muteButton = new MuteButton(context, j3, z16, bVar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 5;
        layoutParams.topMargin = this.f400200b.topMargin + x.c(context, 12.0f);
        layoutParams.rightMargin = x.c(context, 12.0f);
        muteButton.setLayoutParams(layoutParams);
        muteButton.setVisibility(8);
        return muteButton;
    }

    public AnimationView d(Context context, ViewModelProvider viewModelProvider, LifecycleOwner lifecycleOwner) {
        AnimationView animationView = new AnimationView(context, viewModelProvider, lifecycleOwner, this.f400200b);
        animationView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return animationView;
    }

    public PkAnotherAnchorView e(Context context, long j3, LinkScreenAnchorInfo linkScreenAnchorInfo, boolean z16) {
        PkAnotherAnchorView pkAnotherAnchorView = new PkAnotherAnchorView(context, j3, linkScreenAnchorInfo, z16);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        FrameLayout.LayoutParams layoutParams2 = this.f400200b;
        layoutParams.height = layoutParams2.height;
        layoutParams.width = layoutParams2.width / 2;
        layoutParams.leftMargin = layoutParams2.width / 2;
        layoutParams.topMargin = layoutParams2.topMargin;
        pkAnotherAnchorView.setLayoutParams(layoutParams);
        return pkAnotherAnchorView;
    }

    public PkResultView f(Context context, ViewModelProvider viewModelProvider, LifecycleOwner lifecycleOwner) {
        PkResultView pkResultView = new PkResultView(context, viewModelProvider, lifecycleOwner, this.f400200b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f400200b.height);
        FrameLayout.LayoutParams layoutParams2 = this.f400200b;
        layoutParams.topMargin = layoutParams2.topMargin;
        layoutParams.height = layoutParams2.height;
        pkResultView.setLayoutParams(layoutParams);
        pkResultView.setVisibility(8);
        return pkResultView;
    }

    public PkTimerView g(ViewModelProvider viewModelProvider, LifecycleOwner lifecycleOwner) {
        PkTimerView pkTimerView = new PkTimerView(this.f400199a, viewModelProvider, lifecycleOwner);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.f400200b.topMargin;
        layoutParams.gravity = 1;
        pkTimerView.setLayoutParams(layoutParams);
        pkTimerView.setVisibility(4);
        return pkTimerView;
    }

    public PkTopRankView h(Context context, ViewModelProvider viewModelProvider, LifecycleOwner lifecycleOwner) {
        PkTopRankView pkTopRankView = new PkTopRankView(context, viewModelProvider, lifecycleOwner);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = this.f400200b.topMargin;
        pkTopRankView.setLayoutParams(layoutParams);
        return pkTopRankView;
    }

    public FrameLayout.LayoutParams j(Pos pos, i iVar, int i3, int i16, boolean z16) {
        if (z16) {
            return c.f400182a.b();
        }
        return c.f400182a.c(pos, iVar, i3, i16);
    }

    public WholeScoreBarView l(Context context, ViewModelProvider viewModelProvider, LifecycleOwner lifecycleOwner) {
        WholeScoreBarView wholeScoreBarView = new WholeScoreBarView(context, viewModelProvider, lifecycleOwner);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        FrameLayout.LayoutParams layoutParams2 = this.f400200b;
        layoutParams.topMargin = (layoutParams2.topMargin + layoutParams2.height) - x.c(context, 42);
        wholeScoreBarView.setLayoutParams(layoutParams);
        return wholeScoreBarView;
    }
}
