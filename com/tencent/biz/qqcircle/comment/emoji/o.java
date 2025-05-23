package com.tencent.biz.qqcircle.comment.emoji;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.popupwindow.priority.RFWPriorityPopupWindow;

/* compiled from: P */
/* loaded from: classes4.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final View f83638a;

    /* renamed from: b, reason: collision with root package name */
    private final View f83639b;

    /* renamed from: c, reason: collision with root package name */
    private RFWPriorityPopupWindow f83640c;

    public o(@NonNull FrameLayout frameLayout) {
        this.f83638a = frameLayout.findViewById(R.id.tcm);
        this.f83639b = frameLayout.findViewById(R.id.tg8);
    }

    private boolean b() {
        int e16 = uq3.k.a().e("sp_key_comment_ai_comment_guide_show_count", 0);
        if (e16 >= 1) {
            return false;
        }
        uq3.k.a().m("sp_key_comment_ai_comment_guide_show_count", e16 + 1);
        if (this.f83638a.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public static boolean c() {
        return false;
    }

    public static void e() {
        i(-1);
    }

    private void f() {
        QLog.d("QFSCommentGuideBubbleManager", 1, "showAiCommentGuide");
        this.f83640c = mc0.a.c(this.f83638a.getContext(), R.string.yob).setAnchor(this.f83638a).setAlignment(0).setPosition(0);
    }

    public static void i(int i3) {
        if (i3 <= 0) {
            i3 = uq3.k.a().e("sp_key_comment_publish_pic_red_point_show_count", 0);
        }
        uq3.k.a().m("sp_key_comment_publish_pic_red_point_show_count", i3 + 1);
    }

    public void a() {
        View view = this.f83639b;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void d() {
        RFWPriorityPopupWindow rFWPriorityPopupWindow = this.f83640c;
        if (rFWPriorityPopupWindow != null && rFWPriorityPopupWindow.isShowing()) {
            this.f83640c.dismiss();
        } else {
            this.f83640c = null;
        }
    }

    public void g(boolean z16) {
        int i3;
        if (b()) {
            f();
        }
        View view = this.f83639b;
        if (c() && z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (h()) {
            e();
        }
    }

    public boolean h() {
        View view = this.f83639b;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }
}
