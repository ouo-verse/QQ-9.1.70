package com.qzone.widget;

import android.app.Activity;
import android.view.View;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes37.dex */
public class r {
    public static void b(ListView listView, int i3) {
        if (listView == null || i3 == 0) {
            return;
        }
        int a16 = i3 + com.qzone.proxy.feedcomponent.util.g.a(55.0f);
        View childAt = listView.getChildAt(0);
        if (childAt != null) {
            listView.setSelectionFromTop(listView.getPositionForView(childAt), childAt.getTop() + a16);
        }
    }

    public static void a(Activity activity, ListView listView, View view, int i3, BusinessFeedData businessFeedData, ClickedPoint clickedPoint, q qVar) {
        int a16;
        if (activity == null || view == null || businessFeedData == null || clickedPoint == null || qVar == null || qVar.isShowing()) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int left = iArr[0] + clickedPoint.getLeft() + (clickedPoint.getWidth() / 2);
        int top = iArr[1] + clickedPoint.getTop() + (clickedPoint.getHeight() / 2);
        int screenHeight = FeedGlobalEnv.g().getScreenHeight();
        int l16 = qVar.l1();
        int width = (screenHeight - top) - (clickedPoint.getWidth() / 4);
        int width2 = (top - (clickedPoint.getWidth() / 4)) - qVar.q1();
        if (width >= l16) {
            if (qVar.Y0(left, top + (clickedPoint.getWidth() / 4))) {
                qVar.Z1();
                return;
            }
            return;
        }
        if (width2 >= l16) {
            if (qVar.Y0(left, (top - l16) - (clickedPoint.getWidth() / 4))) {
                qVar.a2();
                return;
            }
            return;
        }
        if (width < width2 && i3 > 1) {
            a16 = (com.qzone.proxy.feedcomponent.util.g.a(6.0f) + l16) - width2;
        } else {
            a16 = width - (com.qzone.proxy.feedcomponent.util.g.a(6.0f) + l16);
        }
        int i16 = top + a16;
        b(listView, a16);
        if (a16 <= 0) {
            if (qVar.Y0(left, i16 + (clickedPoint.getWidth() / 4))) {
                qVar.Z1();
            }
        } else if (qVar.Y0(left, (i16 - l16) - (clickedPoint.getWidth() / 4))) {
            qVar.a2();
        }
    }
}
