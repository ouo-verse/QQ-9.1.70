package com.tencent.qqmini.minigame.screenrecord;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.ui.GuideBubbleView;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GuideBubbleViewCtrl {
    private void a(final View view) {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.screenrecord.GuideBubbleViewCtrl.1
            @Override // java.lang.Runnable
            public void run() {
                View view2 = view;
                if (view2 != null) {
                    view2.setVisibility(4);
                }
            }
        }, 5000L);
    }

    private void c(View view) {
        if (view == null) {
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.shake));
    }

    public GuideBubbleView b(int i3, Context context) {
        String str = "screen_record_guild_type_" + i3;
        GuideBubbleView guideBubbleView = null;
        if (StorageUtil.getPreference().getBoolean(str, false)) {
            return null;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    guideBubbleView = new GuideBubbleView(context);
                    guideBubbleView.setBubbleType(3, 15);
                    guideBubbleView.setContent(context.getString(R.string.mini_sdk_record_guide_show_record_result));
                }
            } else {
                guideBubbleView = new GuideBubbleView(context);
                guideBubbleView.setBubbleType(1, 30);
                guideBubbleView.setContent(context.getString(R.string.mini_sdk_record_guide_click_2_stop_record));
            }
        } else {
            guideBubbleView = new GuideBubbleView(context);
            guideBubbleView.setBubbleType(2, 50);
            guideBubbleView.setContent(context.getString(R.string.mini_sdk_record_guide_show_entry));
        }
        if (guideBubbleView != null) {
            a(guideBubbleView);
            c(guideBubbleView);
            StorageUtil.getPreference().edit().putBoolean(str, true).commit();
        }
        return guideBubbleView;
    }
}
