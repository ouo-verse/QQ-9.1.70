package com.tencent.timi.game.teamlist.view;

import ag4.h;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.ui.widget.rc.RCImageView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends RecyclerView.ViewHolder {
    private RCImageView E;
    private View F;

    public b(@NonNull View view) {
        super(view);
        this.F = view;
        RCImageView rCImageView = (RCImageView) view.findViewById(R.id.f930259g);
        this.E = rCImageView;
        rCImageView.setRadius(ViewUtils.dip2px(6.0f));
    }

    public void l(int i3) {
        this.E.setImageDrawable(gn4.c.b(((h) mm4.b.b(h.class)).l1(i3).team_info.create_small_icon.get(), null, 135.0f, 99.0f));
    }
}
