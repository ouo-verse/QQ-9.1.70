package com.tencent.timi.game.profile.impl.view.forbidden;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fm4.g;
import gm4.c;
import java.util.List;
import mm4.b;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomConf;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ForbiddenDurationView extends LinearLayout {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ForbiddenDurationItemView f379008d;

        a(ForbiddenDurationItemView forbiddenDurationItemView) {
            this.f379008d = forbiddenDurationItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ForbiddenDurationView.this.c();
            this.f379008d.setItemSelect(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ForbiddenDurationView(Context context) {
        super(context);
    }

    private void b(int i3, int i16) {
        ForbiddenDurationItemView forbiddenDurationItemView = new ForbiddenDurationItemView(getContext());
        forbiddenDurationItemView.setSecondData(i3);
        boolean z16 = true;
        if (i16 == 0) {
            if (getChildCount() != 0) {
                z16 = false;
            }
            forbiddenDurationItemView.setItemSelect(z16);
        } else if (i16 == i3) {
            forbiddenDurationItemView.setItemSelect(true);
        } else {
            forbiddenDurationItemView.setItemSelect(false);
        }
        forbiddenDurationItemView.setOnClickListener(new a(forbiddenDurationItemView));
        addView(forbiddenDurationItemView, new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(56.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            ((ForbiddenDurationItemView) getChildAt(i3)).setItemSelect(false);
        }
    }

    public int d() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            ForbiddenDurationItemView forbiddenDurationItemView = (ForbiddenDurationItemView) getChildAt(i3);
            if (forbiddenDurationItemView.g()) {
                return forbiddenDurationItemView.a();
            }
        }
        return 0;
    }

    public void e(long j3, int i3) {
        YoloRoomOuterClass$YoloRoomConf Y;
        setOrientation(1);
        c K0 = ((g) b.b(g.class)).K0(j3);
        if (K0 != null && (Y = K0.Y()) != null) {
            List<Integer> list = Y.yolo_room_common_conf.safe_conf.forbidden_speech_time_list.get();
            if (!list.isEmpty()) {
                if (i3 != 0) {
                    b(0, i3);
                }
                for (int i16 = 0; i16 < list.size(); i16++) {
                    b(list.get(i16).intValue(), i3);
                }
            }
        }
    }

    public ForbiddenDurationView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ForbiddenDurationView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
