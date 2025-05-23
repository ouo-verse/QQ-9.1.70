package cooperation.vip.ad;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;

/* loaded from: classes28.dex */
public class TianshuBigInsertPage {

    /* renamed from: a, reason: collision with root package name */
    private View f391044a;

    /* renamed from: b, reason: collision with root package name */
    private View f391045b;

    /* renamed from: c, reason: collision with root package name */
    private DragFrameLayout f391046c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f391047d;

    /* renamed from: e, reason: collision with root package name */
    private TianShuAccess.AdItem f391048e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                TianshuBigInsertPage.this.j();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes28.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TianshuBigInsertPage.this.j();
            if (TianshuBigInsertPage.this.f391048e != null) {
                w.b(String.valueOf(TianshuBigInsertPage.this.f391048e.iAdId.get()), 122, TianshuBigInsertPage.this.f391048e.traceinfo.get());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes28.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f391054d;

        c(String str) {
            this.f391054d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TianshuBigInsertPage.this.j();
            if (TianshuBigInsertPage.this.i() != null) {
                i.h(TianshuBigInsertPage.this.i(), TianshuBigInsertPage.this.f391047d.getContext(), this.f391054d, 4005);
            }
            if (TianshuBigInsertPage.this.f391048e != null) {
                w.b(String.valueOf(TianshuBigInsertPage.this.f391048e.iAdId.get()), 102, TianshuBigInsertPage.this.f391048e.traceinfo.get());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TianshuBigInsertPage(Activity activity) {
        k(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface i() {
        if (BaseApplicationImpl.getApplication() != null && (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
            return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ViewUtils.removeViewFromParent(this.f391044a);
        TianShuManager.getInstance().clearAdShowStatus(340);
    }

    private void k(Activity activity) {
        if (activity == null) {
            QLog.e("TianshuBigInsertPage", 1, "initView  activity == null");
            return;
        }
        this.f391046c = (DragFrameLayout) activity.findViewById(R.id.b9o);
        View inflate = activity.getLayoutInflater().inflate(R.layout.dwj, (ViewGroup) this.f391046c, false);
        this.f391044a = inflate;
        this.f391045b = inflate.findViewById(R.id.f97185jp);
        this.f391044a.findViewById(R.id.f97105jh).setBackgroundColor(activity.getResources().getColor(R.color.f156940fu));
        this.f391047d = (ImageView) this.f391044a.findViewById(R.id.f97115ji);
        this.f391044a.setOnTouchListener(new a());
        ((ImageView) this.f391044a.findViewById(R.id.f97125jj)).setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(300L);
        view.startAnimation(translateAnimation);
    }

    public void l(TianShuAccess.AdItem adItem) {
        if (adItem == null) {
            QLog.e("TianshuBigInsertPage", 1, "showLayer with null ");
            return;
        }
        this.f391048e = adItem;
        String str = null;
        String str2 = null;
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            if (mapEntry.key.get().equals("image")) {
                str = mapEntry.value.get();
            } else if (mapEntry.key.get().equals("url")) {
                str2 = mapEntry.value.get();
            }
        }
        QLog.d("TianshuBigInsertPage", 1, "showHongbaoLayer | imgUrl is: " + str + " actionUrl: " + str2);
        this.f391047d.setOnClickListener(new c(str2));
        com.tencent.mobileqq.qwallet.preload.a.h().getResPath(str, new IPreloadService.c() { // from class: cooperation.vip.ad.TianshuBigInsertPage.4
            @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.c
            public void onResult(int i3, final IPreloadService.PathResult pathResult) {
                QLog.d("TianshuBigInsertPage", 1, "onResult: " + i3 + ", path: " + pathResult.filePath);
                if (i3 == 0 && !TextUtils.isEmpty(pathResult.filePath)) {
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.vip.ad.TianshuBigInsertPage.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QLog.d("TianshuBigInsertPage", 1, "show insert page...");
                            ViewUtils.removeViewFromParent(TianshuBigInsertPage.this.f391044a);
                            TianshuBigInsertPage.this.f391046c.addView(TianshuBigInsertPage.this.f391044a);
                            URLDrawable fileDrawable = URLDrawable.getFileDrawable(pathResult.filePath, URLDrawable.URLDrawableOptions.obtain());
                            try {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(pathResult.filePath, options);
                                QLog.d("TianshuBigInsertPage", 1, "bitmap w: " + options.outWidth + ", h: " + options.outHeight);
                                int screenWidth = (int) (((((float) options.outHeight) * 1.0f) / ((float) options.outWidth)) * ((float) ViewUtils.getScreenWidth()));
                                if (screenWidth > 0) {
                                    QLog.d("TianshuBigInsertPage", 1, "calc height: " + screenWidth);
                                    ViewGroup.LayoutParams layoutParams = TianshuBigInsertPage.this.f391047d.getLayoutParams();
                                    layoutParams.height = screenWidth;
                                    TianshuBigInsertPage.this.f391047d.setLayoutParams(layoutParams);
                                }
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                            TianshuBigInsertPage.this.f391047d.setBackgroundDrawable(fileDrawable);
                            TianshuBigInsertPage.m(TianshuBigInsertPage.this.f391045b);
                            if (TianshuBigInsertPage.this.f391048e != null) {
                                w.b(String.valueOf(TianshuBigInsertPage.this.f391048e.iAdId.get()), 101, TianshuBigInsertPage.this.f391048e.traceinfo.get());
                            }
                        }
                    });
                }
            }
        });
    }
}
