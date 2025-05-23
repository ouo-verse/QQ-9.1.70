package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamLaneSelectView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private PopupWindow f379717d;

    /* renamed from: e, reason: collision with root package name */
    private b f379718e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f379719d;

        a(TextView textView) {
            this.f379719d = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TeamLaneSelectView.this.i();
            view.setSelected(true);
            if (TeamLaneSelectView.this.f379718e != null) {
                TeamLaneSelectView.this.f379718e.a(this.f379719d, ((Integer) view.getTag()).intValue());
            }
            TeamLaneSelectView.this.f379717d.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void a(View view, int i3);
    }

    public TeamLaneSelectView(Context context) {
        super(context);
        e();
    }

    @NotNull
    private TextView d(Pair<Integer, String> pair) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setTextColor(getResources().getColorStateList(R.color.cuh));
        if (getChildCount() == 0) {
            textView.setBackgroundResource(R.drawable.ltl);
        } else if (getChildCount() == ym4.a.f().size() - 1) {
            textView.setBackgroundResource(R.drawable.ltm);
        } else {
            textView.setBackgroundResource(R.drawable.ltk);
        }
        textView.setTag(pair.first);
        textView.setText(pair.second);
        textView.setTextSize(14.0f);
        textView.setSelected(false);
        textView.setOnClickListener(new a(textView));
        textView.setLayoutParams(new ViewGroup.LayoutParams((int) ba.dp2px(getContext(), 120.0f), (int) ba.dp2px(getContext(), 40.0f)));
        return textView;
    }

    private void e() {
        h();
        f();
    }

    private void f() {
        setBackgroundResource(R.drawable.ltj);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private void g() {
        ((ug4.b) mm4.b.b(ug4.b.class)).G2(this.f379717d.getContentView(), "pg_yes_smoba_team");
    }

    private void h() {
        Iterator<Pair<Integer, String>> it = ym4.a.f().iterator();
        while (it.hasNext()) {
            addView(d(it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).setSelected(false);
        }
    }

    private void k(View view) {
        int dp2px = (int) ba.dp2px(getContext(), 120.0f);
        int dp2px2 = (int) ba.dp2px(getContext(), 2.0f);
        if (ba.getScreenWidth(getContext()) - view.getX() > dp2px) {
            this.f379717d.showAsDropDown(view, 0, dp2px2);
        } else {
            this.f379717d.showAsDropDown(view, -(dp2px - view.getWidth()), dp2px2);
        }
    }

    public void j(int i3, View view) {
        PopupWindow popupWindow = new PopupWindow(this, -2, -2);
        this.f379717d = popupWindow;
        popupWindow.setOutsideTouchable(true);
        this.f379717d.setFocusable(true);
        g();
        int i16 = Build.VERSION.SDK_INT;
        this.f379717d.setElevation(ba.dp2px(getContext(), 5.0f));
        if (i16 >= 28) {
            this.f379717d.getContentView().setOutlineSpotShadowColor(-1052689);
        }
        k(view);
        TextView textView = (TextView) findViewWithTag(Integer.valueOf(i3));
        if (textView != null) {
            textView.setSelected(true);
        }
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f379717d.setOnDismissListener(onDismissListener);
    }

    public void setOnLaneSelectedListener(b bVar) {
        this.f379718e = bVar;
    }
}
