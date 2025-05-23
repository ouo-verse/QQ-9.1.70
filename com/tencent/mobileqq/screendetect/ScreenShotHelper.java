package com.tencent.mobileqq.screendetect;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.Pair;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.app.d;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import com.tencent.util.UiThreadUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScreenShotHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<Integer> f282486a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements RecentContactListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f282490a;

        a(c cVar) {
            this.f282490a = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScreenShotHelper.this, (Object) cVar);
            }
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NonNull final List<RecentUser> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            final c cVar = this.f282490a;
            if (cVar != null) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.screendetect.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ScreenShotHelper.c.this.a(list);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ScreenShotHelper.f(view.getContext(), (String) view.getTag(), false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void a(List<RecentUser> list);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74862);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f282486a = arrayList;
        arrayList.clear();
        f282486a.add(0);
        f282486a.add(1);
        f282486a.add(3000);
        f282486a.add(1004);
        f282486a.add(1000);
        f282486a.add(1022);
        f282486a.add(1001);
        f282486a.add(10002);
        f282486a.add(1006);
        f282486a.add(1005);
        f282486a.add(10008);
        f282486a.add(10010);
    }

    public ScreenShotHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, Uri uri, View view, View view2, boolean z16) {
        boolean z17;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Object obj;
        String jSONObject3;
        if (context == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        int decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(uri, context, 3, sparseArray);
        String str = "";
        JSONObject jSONObject4 = null;
        if (com.tencent.mobileqq.qrscan.utils.b.f(decodeQQCodeFromFile)) {
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotHelper", 2, "ScreenShot page detect app code success");
            }
            Object obj2 = sparseArray.get(2);
            if (obj2 instanceof String) {
                String str2 = (String) obj2;
                try {
                    jSONObject2 = new JSONObject();
                } catch (JSONException e16) {
                    e = e16;
                    jSONObject2 = null;
                }
                try {
                    jSONObject2.put("strMini", str2);
                } catch (JSONException e17) {
                    e = e17;
                    e.printStackTrace();
                    obj = sparseArray.get(1001);
                    if (obj instanceof String) {
                    }
                    if (jSONObject2 != null) {
                    }
                    view2.setVisibility(0);
                    view2.setTag(jSONObject3);
                    z17 = true;
                    if (!com.tencent.mobileqq.qrscan.utils.b.g(decodeQQCodeFromFile)) {
                    }
                }
            } else {
                jSONObject2 = null;
            }
            obj = sparseArray.get(1001);
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (jSONObject2 != null) {
                    try {
                        jSONObject2.put("type", str3);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
            if (jSONObject2 != null) {
                jSONObject3 = "";
            } else {
                jSONObject3 = jSONObject2.toString();
            }
            view2.setVisibility(0);
            view2.setTag(jSONObject3);
            z17 = true;
        } else {
            z17 = false;
        }
        if (!com.tencent.mobileqq.qrscan.utils.b.g(decodeQQCodeFromFile)) {
            if (QLog.isColorLevel()) {
                QLog.d("ScreenShotHelper", 2, "ScreenShot page detect qr code success");
            }
            Object obj3 = sparseArray.get(1);
            if (obj3 instanceof Pair) {
                Pair pair = (Pair) obj3;
                String trim = String.valueOf(pair.second).trim();
                String trim2 = String.valueOf(pair.first).trim();
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e18) {
                    e = e18;
                }
                try {
                    jSONObject.put("scannerType", trim);
                    jSONObject.put("scannerResult", trim2);
                    jSONObject4 = jSONObject;
                } catch (JSONException e19) {
                    e = e19;
                    jSONObject4 = jSONObject;
                    e.printStackTrace();
                    if (jSONObject4 != null) {
                    }
                    if (z17) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    view.setVisibility(0);
                    view.setTag(str);
                }
            }
            if (jSONObject4 != null) {
                str = jSONObject4.toString();
            }
            if (z17 || z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ScreenShotHelper", 2, "ScreenShot page qr code entrance show success");
                }
                view.setVisibility(0);
                view.setTag(str);
            }
        }
    }

    public static void b(Activity activity, MotionEvent motionEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotHelper", 2, "disaptchTouchEventCallback() called with: activity = [" + activity + "], ev = [" + motionEvent + "]");
        }
        try {
            View findViewById = ((ViewGroup) activity.getWindow().getDecorView().getRootView()).findViewById(R.id.m7m);
            if (findViewById != null) {
                int[] iArr = new int[2];
                findViewById.getLocationOnScreen(iArr);
                if (!new RectF(iArr[0], iArr[1], r4 + findViewById.getWidth(), iArr[1] + findViewById.getHeight()).contains(motionEvent.getRawX(), motionEvent.getRawY())) {
                    ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                }
            }
        } catch (Exception e16) {
            QLog.e("ScreenShotHelper", 1, "remove float view exception ", e16);
        }
    }

    public static void c(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public static Point d(Context context) {
        Point point = null;
        try {
            Point point2 = new Point();
            try {
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point2);
                return point2;
            } catch (Exception e16) {
                e = e16;
                point = point2;
                QLog.e("ScreenShotHelper", 1, "getRealScreenSize error.", e);
                return point;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void f(Context context, String str, boolean z16) {
        g(context, str, z16, null);
    }

    public static void g(Context context, String str, boolean z16, Intent intent) {
        boolean z17;
        BaseActivity baseActivity;
        QQAppInterface qQAppInterface;
        View findViewById;
        if ((context instanceof Activity) && (findViewById = ((ViewGroup) ((Activity) context).getWindow().getDecorView().getRootView()).findViewById(R.id.m7m)) != null) {
            ((ViewGroup) findViewById.getParent()).removeView(findViewById);
        }
        Intent intent2 = new Intent();
        intent2.putExtra("public_fragment_window_feature", 1);
        intent2.putExtra("screen_path", str);
        intent2.putExtra("screen_has_alpha", true);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        if ((context instanceof BaseActivity) && (qQAppInterface = (baseActivity = (BaseActivity) context).app) != null && qQAppInterface.getMessageFacade() != null && qQAppInterface.getMessageFacade().K1() && qQAppInterface.getMessageFacade().q1() != null && qQAppInterface.getMessageFacade().q1().size() > 0) {
            intent2.putExtra("is_aio_page_with_msg", true);
            PublicFragmentActivity.b.d(baseActivity, intent2, PublicTransFragmentActivity.class, ScreenShotFragment.class, 9011);
            z17 = true;
        } else {
            z17 = false;
        }
        if (context instanceof QQBrowserActivity) {
            QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) context;
            if (i(qQBrowserActivity)) {
                intent2.putExtra("is_screen_shot_from_web", true);
                PublicFragmentActivity.b.d(qQBrowserActivity, intent2, PublicTransFragmentActivity.class, ScreenShotFragment.class, 11);
                return;
            }
        }
        intent2.putExtra("switch_bottom_layout", z16);
        if (!z17) {
            PublicFragmentActivity.b.a(context, intent2, PublicTransFragmentActivity.class, ScreenShotFragment.class);
        }
    }

    public static void h(Activity activity) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotHelper", 2, "hideFloatView() called with: activity = [" + activity + "]");
        }
        View findViewById = ((ViewGroup) activity.getWindow().getDecorView().getRootView()).findViewById(R.id.m7m);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    private static boolean i(QQBrowserActivity qQBrowserActivity) {
        if (qQBrowserActivity == null) {
            QLog.e("ScreenShotHelper", 1, "isCurrentPageIsWebFragment activity is null");
            return false;
        }
        return qQBrowserActivity.getSupportFragmentManager().findFragmentById(R.id.b9v) instanceof WebViewFragment;
    }

    public static void j(Activity activity, Handler handler) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotHelper", 2, "onActivityResumeHideFloatView");
        }
        View findViewById = ((ViewGroup) activity.getWindow().getDecorView().getRootView()).findViewById(R.id.m7m);
        if (findViewById != null) {
            findViewById.setVisibility(0);
            handler.postDelayed(new Runnable(new WeakReference(activity), findViewById, handler) { // from class: com.tencent.mobileqq.screendetect.ScreenShotHelper.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ WeakReference f282487d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f282488e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ Handler f282489f;

                {
                    this.f282487d = r7;
                    this.f282488e = findViewById;
                    this.f282489f = handler;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, r7, findViewById, handler);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Activity activity2 = (Activity) this.f282487d.get();
                    if (activity2 != null) {
                        if (activity2.hasWindowFocus()) {
                            View findViewById2 = ((ViewGroup) activity2.getWindow().getDecorView().getRootView()).findViewById(R.id.m7m);
                            if (findViewById2 != null) {
                                ((ViewGroup) this.f282488e.getParent()).removeView(findViewById2);
                                return;
                            }
                            return;
                        }
                        if (!activity2.isDestroyed()) {
                            this.f282489f.postDelayed(this, 5000L);
                        } else {
                            this.f282489f.removeCallbacksAndMessages(null);
                        }
                    }
                }
            }, 5000L);
        }
    }

    public static void k(Context context, String str, int i3, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra("detectType", i3);
        intent.putExtra("fromPicQRDecode", true);
        RouteUtils.startActivity(context, intent, "/qrscan/scanner");
    }

    public static void l(Activity activity) {
        if (QLog.isColorLevel()) {
            QLog.d("ScreenShotHelper", 2, "removeFloatView() called with: activity = [" + activity + "]");
        }
        View findViewById = ((ViewGroup) activity.getWindow().getDecorView().getRootView()).findViewById(R.id.m7m);
        if (findViewById != null) {
            ((ViewGroup) findViewById.getParent()).removeView(findViewById);
        }
    }

    public static void m(String str, int i3) {
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
    }

    public static void n(String str, String str2, String str3) {
        ReportController.o(null, "dc00898", "", "", str, str, 0, 0, str2, str3, "", "");
    }

    public static void o(Activity activity, String str, Handler handler) {
        int i3;
        int i16;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().getRootView();
        View findViewById = viewGroup.findViewById(R.id.m7m);
        int dpToPx = ViewUtils.dpToPx(79.0f);
        Point d16 = d(activity);
        int i17 = (int) ((d16.y / d16.x) * dpToPx);
        double d17 = dpToPx * 2.5d;
        if (i17 > d17) {
            i17 = (int) d17;
        }
        if (findViewById == null && (viewGroup instanceof FrameLayout)) {
            Drawable drawable = null;
            findViewById = View.inflate(activity, R.layout.cee, null);
            ImageView imageView = (ImageView) findViewById.findViewById(R.id.f166826ii0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.height = i17;
            layoutParams.width = dpToPx;
            imageView.setLayoutParams(layoutParams);
            try {
                activity.getResources().getDrawable(R.drawable.icon);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = dpToPx;
                obtain.mRequestHeight = i17;
                obtain.mLoadingDrawable = URLDrawableHelper.getLoadingDrawable();
                obtain.mFailedDrawable = BaseURLDrawableHelper.getFailedDrawable();
                obtain.mPlayGifImage = false;
                obtain.mGifRoundCorner = 0.0f;
                obtain.mNeedCheckNetType = false;
                obtain.mRetryCount = 3;
                drawable = URLDrawable.getFileDrawable(str, obtain);
            } catch (IllegalStateException e16) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                if (i17 > 0) {
                    i3 = options.outHeight / i17;
                } else {
                    i3 = 1;
                }
                if (dpToPx > 0) {
                    i16 = options.outWidth / dpToPx;
                } else {
                    i16 = 1;
                }
                options.inJustDecodeBounds = false;
                if (i3 <= i16) {
                    i3 = i16;
                }
                options.inSampleSize = i3;
                options.inTargetDensity = 320;
                if (BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi > options.inDensity) {
                    options.inDensity = 320;
                } else {
                    options.inDensity = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
                }
                try {
                    drawable = new BitmapDrawable(BitmapFactory.decodeFile(str, options));
                } catch (Throwable unused) {
                    QLog.e("ScreenShotHelper", 1, "decode screenshot failed ", e16);
                }
            }
            imageView.setImageDrawable(drawable);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(ViewUtils.dpToPx(96.0f), -2);
            layoutParams2.gravity = 21;
            layoutParams2.rightMargin = ViewUtils.dpToPx(16.0f);
            findViewById.setLayoutParams(layoutParams2);
            viewGroup.addView(findViewById);
            findViewById.setId(R.id.m7m);
        }
        if (findViewById != null) {
            c(findViewById);
            findViewById.setTag(str);
            findViewById.setOnClickListener(new b());
            j(activity, handler);
            return;
        }
        QLog.e("ScreenShotHelper", 1, "screenshot float view failed ");
    }

    public static void p(Context context, String str, Handler handler) {
        boolean isInMultiWindowMode;
        try {
            if (context instanceof Activity) {
                if (Build.VERSION.SDK_INT >= 24) {
                    isInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
                    if (isInMultiWindowMode) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ScreenShotHelper", 2, "start float view is error and errMsg : isInMultiWindowMode");
                            return;
                        }
                        return;
                    }
                }
                o((Activity) context, str, handler);
                d dVar = d.f99535a;
                if (dVar != null) {
                    if (context instanceof AppActivity) {
                        AppActivity.setActivityDispatchCallback(dVar);
                    } else {
                        PluginProxyActivity.setActivityDispatchCallback(dVar);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("ScreenShotHelper", 2, e16, new Object[0]);
        }
    }

    public void e(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof BaseQQAppInterface)) {
            ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(peekAppRuntime, new a(cVar), false);
        }
    }
}
