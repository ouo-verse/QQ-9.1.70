package l30;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {
    public static View a(RFWLayoutPreLoader rFWLayoutPreLoader, Context context, ViewStub viewStub) {
        if (viewStub == null) {
            QLog.e("QFSAsyncInflateUtils", 1, "[getPreloadViewForViewStub] error: viewStub == null, return null");
            return null;
        }
        if (rFWLayoutPreLoader == null) {
            QLog.d("QFSAsyncInflateUtils", 1, "[getPreloadViewForViewStub] preLoader == null, direct inflate");
            return viewStub.inflate();
        }
        if (context == null) {
            QLog.e("QFSAsyncInflateUtils", 1, "[getPreloadViewForViewStub] error: context == null, return null");
            return null;
        }
        View preloadView = rFWLayoutPreLoader.getPreloadView(context, viewStub.getLayoutResource(), false);
        if (preloadView == null) {
            QLog.d("QFSAsyncInflateUtils", 1, "[getPreloadViewForViewStub] has no preloadView, direct inflate");
            return viewStub.inflate();
        }
        QLog.d("QFSAsyncInflateUtils", 1, "[getPreloadViewForViewStub] success get preloadView, inflate id:" + viewStub.getLayoutResource());
        c(viewStub, preloadView);
        return preloadView;
    }

    private static void b(View view, ViewGroup viewGroup, ViewStub viewStub) {
        int indexOfChild = viewGroup.indexOfChild(viewStub);
        viewGroup.removeViewInLayout(viewStub);
        ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
    }

    private static void c(ViewStub viewStub, View view) {
        if (view != null && (viewStub.getParent() instanceof ViewGroup)) {
            if (viewStub.getInflatedId() != -1) {
                view.setId(viewStub.getInflatedId());
            }
            b(view, (ViewGroup) viewStub.getParent(), viewStub);
        }
    }
}
