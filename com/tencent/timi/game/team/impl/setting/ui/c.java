package com.tencent.timi.game.team.impl.setting.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.e;
import com.tencent.timi.game.utils.l;
import com.tencent.util.AnimateUtils;
import java.util.ArrayList;
import java.util.List;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigKV;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigLinkageOption;
import trpc.yes.common.YoloRoomOuterClass$ListParam;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends com.tencent.timi.game.team.impl.setting.ui.a implements View.OnClickListener {
    private TextView D;
    private TextView E;
    private EditText F;
    private ImageView G;
    private ImageView H;
    private RelativeLayout I;
    private List<String> J;
    private int K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends e {
        a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            c cVar = c.this;
            cVar.y(cVar.F.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements InputFilter {
        b() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            if (charSequence.equals(" ")) {
                return "";
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.team.impl.setting.ui.c$c, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C9979c extends AnimateUtils.AnimationAdapter {
        C9979c() {
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            c.this.x();
        }
    }

    public c(@NonNull View view) {
        super(view);
        this.D = (TextView) view.findViewById(R.id.f928458z);
        this.E = (TextView) view.findViewById(R.id.f928358y);
        this.F = (EditText) view.findViewById(R.id.f928258x);
        this.G = (ImageView) view.findViewById(R.id.f9285590);
        this.H = (ImageView) view.findViewById(R.id.f928158w);
        this.I = (RelativeLayout) view.findViewById(R.id.f927958u);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
    }

    private void s() {
        String str = this.f379675e.f379564i.team_info.text_sub_hue.get();
        if (yn4.a.a(str)) {
            this.E.setTextColor(Color.parseColor(str));
        }
        String str2 = this.f379675e.f379564i.team_info.text_hue.get();
        if (yn4.a.a(str2)) {
            this.F.setTextColor(Color.parseColor(str2));
            this.G.setColorFilter(new PorterDuffColorFilter(Color.parseColor(str2), PorterDuff.Mode.SRC_ATOP));
        }
        String str3 = this.f379675e.f379564i.team_info.unselected_bg_hue.get();
        if (yn4.a.a(str3)) {
            this.I.getBackground().setColorFilter(new PorterDuffColorFilter(Color.parseColor(str3), PorterDuff.Mode.SRC));
        }
    }

    private void t() {
        List<YesGameInfoOuterClass$GameConfigKV> list = this.f379676f.f437255kv.get();
        if (list.isEmpty()) {
            return;
        }
        this.J = list.get(0).value.get();
        if (l()) {
            List<String> list2 = this.J;
            if (list2 != null && !list2.isEmpty()) {
                this.K = (int) (Math.random() * (this.J.size() - 1));
                l.i("Team_Config", "team name random index == " + this.K);
                if (l()) {
                    x();
                    return;
                }
                return;
            }
            this.G.setVisibility(4);
            return;
        }
        List<String> k3 = k();
        if (!k3.isEmpty() && !TextUtils.isEmpty(k3.get(0))) {
            this.F.setText(k3.get(0));
        }
    }

    private void u(com.tencent.timi.game.team.impl.main.d dVar) {
        this.E.setText(this.F.getText().length() + "/15");
        this.F.addTextChangedListener(new a());
        z(this.F);
    }

    @NonNull
    private YoloRoomOuterClass$ListParam v() {
        YoloRoomOuterClass$ListParam yoloRoomOuterClass$ListParam = new YoloRoomOuterClass$ListParam();
        yoloRoomOuterClass$ListParam.index.set(this.f379676f.index.get());
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.F.getText().toString());
        yoloRoomOuterClass$ListParam.value.set(arrayList);
        return yoloRoomOuterClass$ListParam;
    }

    private void w() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 179.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(400L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setAnimationListener(new C9979c());
        this.G.startAnimation(rotateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        l.i("Team_Config", "now teamName index is == " + this.K);
        List<String> list = this.J;
        if (list != null && !list.isEmpty()) {
            List<String> list2 = this.J;
            String str = list2.get(this.K % list2.size());
            this.F.setText(str);
            if (this.F.isFocused()) {
                this.F.setSelection(str.length());
            }
            this.K++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3) {
        this.E.setText(i3 + "/15");
    }

    public static void z(EditText editText) {
        editText.setFilters(new InputFilter[]{new b(), new InputFilter.LengthFilter(15)});
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void c(YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem, com.tencent.timi.game.team.impl.main.d dVar, List<YesGameInfoOuterClass$GameConfigLinkageOption> list, int i3) {
        super.c(yesGameInfoOuterClass$GameConfigItem, dVar, list, i3);
        d(yesGameInfoOuterClass$GameConfigItem, this.D);
        s();
        t();
        u(dVar);
    }

    @Override // com.tencent.timi.game.team.impl.setting.ui.a
    public void g(YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams) {
        if (l()) {
            yoloRoomOuterClass$YoloGameRoomParams.list_param_list.add(v());
            return;
        }
        String obj = this.F.getText().toString();
        if (!TextUtils.equals(obj, this.f379675e.f379562g)) {
            l.i("Team_Config", "update the name of team, before : " + this.f379675e.f379562g + ",now : " + obj);
            yoloRoomOuterClass$YoloGameRoomParams.list_param_list.add(v());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f9285590) {
            w();
        } else if (view.getId() == R.id.f928158w) {
            this.F.setText("");
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
