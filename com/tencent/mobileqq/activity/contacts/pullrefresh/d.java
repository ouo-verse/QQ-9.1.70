package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static boolean a(View view) {
        if (view instanceof HeaderScrollView) {
            return !((HeaderScrollView) view).e();
        }
        if (view instanceof ViewGroup) {
            View childAt = ((ViewGroup) view).getChildAt(1);
            if (childAt != null && (childAt instanceof HeaderScrollView)) {
                return !((HeaderScrollView) childAt).e();
            }
        } else if (view instanceof AbsListView) {
            AbsListView absListView = (AbsListView) view;
            if (absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop())) {
                return true;
            }
            return false;
        }
        return ViewCompat.canScrollVertically(view, -1);
    }
}
