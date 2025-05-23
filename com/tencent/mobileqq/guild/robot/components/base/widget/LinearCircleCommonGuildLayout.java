package com.tencent.mobileqq.guild.robot.components.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GProRobotCommonGuildInfo;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class LinearCircleCommonGuildLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private List<GProRobotCommonGuildInfo> f232135d;

    /* renamed from: e, reason: collision with root package name */
    private int f232136e;

    /* renamed from: f, reason: collision with root package name */
    private AppRuntime f232137f;

    public LinearCircleCommonGuildLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        removeAllViews();
        for (int i3 = 0; i3 < this.f232135d.size(); i3++) {
            if (i3 >= 5) {
                getChildAt(4).setAlpha(0.5f);
                d(i3 - 1);
                return;
            }
            GProRobotCommonGuildInfo gProRobotCommonGuildInfo = this.f232135d.get(i3);
            CircleBorderRoundImageView circleBorderRoundImageView = new CircleBorderRoundImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(26.0f), ViewUtils.dpToPx(26.0f));
            if (i3 != 0) {
                layoutParams.leftMargin = -ViewUtils.dpToPx(6.0f);
            }
            circleBorderRoundImageView.setLayoutParams(layoutParams);
            circleBorderRoundImageView.setImageDrawable(b(gProRobotCommonGuildInfo.getGuildFace(), ViewUtils.dpToPx(26.0f), ViewUtils.dpToPx(26.0f), null, true, true));
            addView(circleBorderRoundImageView);
        }
    }

    private URLDrawable b(String str, int i3, int i16, Drawable drawable, boolean z16, boolean z17) {
        Drawable drawable2;
        URLDrawable uRLDrawable;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (drawable != null) {
            drawable2 = drawable;
        } else {
            drawable2 = b.f306350a;
        }
        obtain.mLoadingDrawable = drawable2;
        if (drawable == null) {
            drawable = b.f306350a;
        }
        obtain.mFailedDrawable = drawable;
        obtain.mRequestHeight = i16;
        obtain.mRequestWidth = i3;
        obtain.mUseMemoryCache = z17;
        try {
            uRLDrawable = URLDrawable.getDrawable(str, obtain);
            if (z16) {
                try {
                    uRLDrawable.setTag(new int[]{i3, i16});
                    uRLDrawable.setDecodeHandler(ch.f235510c);
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("LinearCircleRobotLayout", 1, e, new Object[0]);
                    return uRLDrawable;
                }
            }
        } catch (Exception e17) {
            e = e17;
            uRLDrawable = null;
        }
        return uRLDrawable;
    }

    private void d(int i3) {
        RoundImageView roundImageView = new RoundImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(26.0f), ViewUtils.dpToPx(26.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = ViewUtils.dpToPx(-26.0f);
        roundImageView.setLayoutParams(layoutParams);
        roundImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.guild_robot_common_guild_more));
        addView(roundImageView);
    }

    public void c(AppRuntime appRuntime, List<GProRobotCommonGuildInfo> list, int i3) {
        this.f232135d = list;
        this.f232137f = appRuntime;
        this.f232136e = i3;
        a();
    }
}
