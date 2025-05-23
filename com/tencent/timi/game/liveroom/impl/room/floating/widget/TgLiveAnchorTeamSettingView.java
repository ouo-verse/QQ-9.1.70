package com.tencent.timi.game.liveroom.impl.room.floating.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TgLiveAnchorTeamSettingView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private AnchorPlayTogetherPresenter f377678d;

    /* renamed from: e, reason: collision with root package name */
    private List<TextView> f377679e;

    /* renamed from: f, reason: collision with root package name */
    private List<ImageView> f377680f;

    /* renamed from: h, reason: collision with root package name */
    private List<View> f377681h;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f377682d;

        a(int i3) {
            this.f377682d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TgLiveAnchorTeamSettingView.this.d(this.f377682d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TgLiveAnchorTeamSettingView(Context context) {
        super(context);
        this.f377679e = new ArrayList();
        this.f377680f = new ArrayList();
        this.f377681h = new ArrayList();
    }

    private int b(int i3) {
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                return 3;
            }
            return 0;
        }
        return 1;
    }

    private int c(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 != 3) {
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i3) {
        f(i3);
    }

    private void e(int i3) {
        int b16 = b(i3);
        for (int i16 = 0; i16 < this.f377680f.size(); i16++) {
            if (i16 == b16) {
                this.f377679e.get(i16).setTextColor(-1);
                this.f377679e.get(i16).setTypeface(Typeface.DEFAULT_BOLD);
                this.f377680f.get(i16).setVisibility(0);
            } else {
                this.f377679e.get(i16).setTextColor(Color.parseColor("#999999"));
                this.f377679e.get(i16).setTypeface(Typeface.DEFAULT);
                this.f377680f.get(i16).setVisibility(8);
            }
        }
    }

    private void f(int i3) {
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = this.f377678d;
        if (anchorPlayTogetherPresenter != null) {
            anchorPlayTogetherPresenter.N(i3);
        }
        e(i3);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f377679e.add((TextView) findViewById(R.id.u3e));
        this.f377679e.add((TextView) findViewById(R.id.u3h));
        this.f377679e.add((TextView) findViewById(R.id.u3k));
        this.f377679e.add((TextView) findViewById(R.id.u3n));
        this.f377680f.add((ImageView) findViewById(R.id.u3c));
        this.f377680f.add((ImageView) findViewById(R.id.u3f));
        this.f377680f.add((ImageView) findViewById(R.id.u3i));
        this.f377680f.add((ImageView) findViewById(R.id.u3l));
        this.f377681h.add(findViewById(R.id.u3d));
        this.f377681h.add(findViewById(R.id.u3g));
        this.f377681h.add(findViewById(R.id.u3j));
        this.f377681h.add(findViewById(R.id.u3m));
        for (int i3 = 0; i3 < this.f377681h.size(); i3++) {
            this.f377681h.get(i3).setOnClickListener(new a(c(i3)));
        }
    }

    public TgLiveAnchorTeamSettingView(Context context, @Nullable @android.support.annotation.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f377679e = new ArrayList();
        this.f377680f = new ArrayList();
        this.f377681h = new ArrayList();
    }

    public TgLiveAnchorTeamSettingView(Context context, @Nullable @android.support.annotation.Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f377679e = new ArrayList();
        this.f377680f = new ArrayList();
        this.f377681h = new ArrayList();
    }
}
