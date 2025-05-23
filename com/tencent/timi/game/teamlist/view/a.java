package com.tencent.timi.game.teamlist.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a extends RecyclerView.ViewHolder {
    public CheckBox E;
    private View F;

    public a(@NonNull View view) {
        super(view);
        this.F = view;
        this.E = (CheckBox) view.findViewById(R.id.f164792ax1);
    }

    public void l(String str, String str2, String str3, String str4) {
        this.E.setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[]{-16842912}}, new int[]{Color.parseColor(str), Color.parseColor(str2)}));
        this.E.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[]{-16842912}}, new int[]{Color.parseColor(str3), Color.parseColor(str4)}));
    }
}
