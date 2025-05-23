package com.tencent.timi.game.team.impl.floating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FloatingTestFragment extends QPublicBaseFragment {
    private WaveAvatarRoundView C;
    private TeamFloatingStateView D;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.C.setTeamCountVisible(0);
            FloatingTestFragment.this.C.setTeamCountText("3/5");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.C.setTeamCountVisible(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.D.s();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.D.w();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
            commonOuterClass$QQUserId.uid.set(281321194L);
            commonOuterClass$QQUserId.user_from.set(1);
            FloatingTestFragment.this.C.r(commonOuterClass$QQUserId);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.C.p();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.C.s();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.C.o();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.D.setTeamStateWithAnim("\u6e38\u620f\u4e2d");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.D.r();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.D.v();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.D.setRedPointVisible(0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FloatingTestFragment.this.D.setRedPointVisible(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private Button Ah() {
        Button button = new Button(getActivity());
        button.setText("\u663e\u793a\u7ea2\u70b9");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new l());
        return button;
    }

    private Button Bh() {
        Button button = new Button(getActivity());
        button.setText("\u505c\u6b62\u97f3\u6d6a\u52a8\u753b");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new g());
        return button;
    }

    private Button Ch() {
        Button button = new Button(getActivity());
        button.setText("\u505c\u6b62\u738b\u8005\u56fe\u6807\u52a8\u753b");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new k());
        return button;
    }

    private Button Dh() {
        Button button = new Button(getActivity());
        button.setText("\u64ad\u653e\u5207\u6362\u72b6\u6001\u52a8\u753b");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new i());
        return button;
    }

    private Button rh() {
        Button button = new Button(getActivity());
        button.setText("\u9690\u85cf\u4eba\u6570");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new b());
        return button;
    }

    private Button sh() {
        Button button = new Button(getActivity());
        button.setText("\u6682\u505c\u7ea2\u5305\u52a8\u753b");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new d());
        return button;
    }

    private Button th() {
        Button button = new Button(getActivity());
        button.setText("\u9690\u85cf\u7ea2\u70b9");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new m());
        return button;
    }

    private Button uh() {
        Button button = new Button(getActivity());
        button.setText("\u64ad\u653e\u738b\u8005\u56fe\u6807\u52a8\u753b");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new j());
        return button;
    }

    private Button vh() {
        Button button = new Button(getActivity());
        button.setText("\u64ad\u653e\u7ea2\u5305\u52a8\u753b");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new c());
        return button;
    }

    private Button wh() {
        Button button = new Button(getActivity());
        button.setText("\u64ad\u653e\u9707\u52a8\u52a8\u753b");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new h());
        return button;
    }

    private Button xh() {
        Button button = new Button(getActivity());
        button.setText("\u5c55\u793a\u5934\u50cf");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new e());
        return button;
    }

    private Button yh() {
        Button button = new Button(getActivity());
        button.setText("\u5c55\u793a\u4eba\u6570");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new a());
        return button;
    }

    private Button zh() {
        Button button = new Button(getActivity());
        button.setText("\u64ad\u653e\u97f3\u6d6a\u52a8\u753b");
        button.setGravity(17);
        button.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ba.dp2px(getContext(), 50.0f)));
        button.setOnClickListener(new f());
        return button;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull @NotNull LayoutInflater layoutInflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup viewGroup, @Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setPadding(0, (int) ba.dp2px(getContext(), 40.0f), 0, 0);
        relativeLayout.setBackgroundColor(-1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(xh());
        linearLayout.addView(zh());
        linearLayout.addView(Bh());
        linearLayout.addView(wh());
        linearLayout.addView(Dh());
        linearLayout.addView(uh());
        linearLayout.addView(Ch());
        linearLayout.addView(Ah());
        linearLayout.addView(th());
        linearLayout.addView(yh());
        linearLayout.addView(rh());
        linearLayout.addView(vh());
        linearLayout.addView(sh());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(12, -1);
        layoutParams.bottomMargin = (int) ba.dp2px(getContext(), 74.0f);
        layoutParams.rightMargin = (int) ba.dp2px(getContext(), 6.0f);
        TeamFloatingView teamFloatingView = new TeamFloatingView(getContext());
        teamFloatingView.setLayoutParams(layoutParams);
        relativeLayout.addView(teamFloatingView);
        this.C = teamFloatingView.y();
        this.D = teamFloatingView.B();
        relativeLayout.addView(linearLayout);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, relativeLayout);
        return relativeLayout;
    }
}
