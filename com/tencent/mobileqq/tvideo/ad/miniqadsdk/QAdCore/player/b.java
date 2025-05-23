package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.qqlive.playerinterface.IQAdPlayerView;
import kt3.c;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static c f303864a;

    public static void a(ViewGroup viewGroup, View view) {
        if (viewGroup instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            viewGroup.addView(view, layoutParams);
            return;
        }
        if (viewGroup instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(13);
            viewGroup.addView(view, layoutParams2);
        } else if (viewGroup instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams3.gravity = 17;
            viewGroup.addView(view, layoutParams3);
        } else {
            if (viewGroup instanceof ConstraintLayout) {
                ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-1, -1);
                layoutParams4.topToTop = 0;
                layoutParams4.bottomToBottom = 0;
                layoutParams4.leftToLeft = 0;
                layoutParams4.rightToRight = 0;
                viewGroup.addView(view, layoutParams4);
                return;
            }
            throw new RuntimeException("invalid parent view");
        }
    }

    @Nullable
    public static kt3.b b(Context context, IQAdPlayerView iQAdPlayerView) {
        n.e("QAdPlayerUtils", "createMediaPlayer");
        c cVar = f303864a;
        if (cVar != null) {
            return cVar.a(context, iQAdPlayerView);
        }
        return null;
    }

    @NonNull
    public static IQAdPlayerView c(Context context, int i3) {
        return new QAdTextureView(context, i3);
    }

    public static String d(String str) {
        return "[QAd]" + str;
    }

    public static void e(@NonNull c cVar) {
        f303864a = cVar;
    }
}
