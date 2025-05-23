package com.tencent.timi.game.teamlist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.teamlist.presenter.TeamListFilterUnitAdapter;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TeamListFilterUnitView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f379845d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f379846e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f379847f;

    public TeamListFilterUnitView(Context context) {
        super(context);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f169138hy3, (ViewGroup) this, true);
        this.f379845d = inflate;
        this.f379846e = (TextView) inflate.findViewById(R.id.vjf);
        this.f379847f = (RecyclerView) this.f379845d.findViewById(R.id.vje);
        this.f379847f = (RecyclerView) findViewById(R.id.vje);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        gridLayoutManager.setOrientation(1);
        this.f379847f.setLayoutManager(gridLayoutManager);
    }

    public void setData(String str, TeamListFilterUnitAdapter teamListFilterUnitAdapter) {
        this.f379846e.setText(str);
        if (teamListFilterUnitAdapter != null) {
            this.f379847f.setAdapter(teamListFilterUnitAdapter);
        }
    }

    public void setTheme(String str) {
        this.f379846e.setTextColor(fh4.c.a(str));
    }

    public TeamListFilterUnitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public TeamListFilterUnitView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
