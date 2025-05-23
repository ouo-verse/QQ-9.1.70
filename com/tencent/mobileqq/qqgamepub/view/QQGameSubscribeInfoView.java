package com.tencent.mobileqq.qqgamepub.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$AppSubscribeInfo;
import com.tencent.mobileqq.qqgamepub.utils.d;
import com.tencent.mobileqq.qqgamepub.utils.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameSubscribeInfoView extends FrameLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private QQGamePubSubscribe$AppSubscribeInfo C;
    private boolean D;
    private String E;
    private long F;

    /* renamed from: d, reason: collision with root package name */
    private TextView f264785d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f264786e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f264787f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f264788h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f264789i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f264790m;

    public QQGameSubscribeInfoView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private QQGamePubSubscribe$AppSubscribeInfo b(String str, IQQGameSubscribeService iQQGameSubscribeService) {
        try {
            List<QQGamePubSubscribe$AppSubscribeInfo> cachedSubscribeList = iQQGameSubscribeService.getCachedSubscribeList();
            synchronized (cachedSubscribeList) {
                for (QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo : cachedSubscribeList) {
                    if (qQGamePubSubscribe$AppSubscribeInfo != null && qQGamePubSubscribe$AppSubscribeInfo.appid.get() == Integer.parseInt(str)) {
                        return qQGamePubSubscribe$AppSubscribeInfo;
                    }
                }
                return null;
            }
        } catch (Throwable th5) {
            QLog.e("QQGamePub_QQGameSubscribeInfoView", 1, th5, new Object[0]);
            return null;
        }
    }

    private void c(Context context) {
        View.inflate(context, R.layout.ebk, this);
        this.f264785d = (TextView) findViewById(R.id.f111626lq);
        this.f264786e = (ImageView) findViewById(R.id.f111616lp);
        this.f264787f = (ImageView) findViewById(R.id.y9l);
        this.f264788h = (ImageView) findViewById(R.id.y9m);
        this.f264789i = (TextView) findViewById(R.id.f111646ls);
        this.f264790m = (TextView) findViewById(R.id.f111636lr);
        findViewById(R.id.yqt).setOnClickListener(this);
        setId(R.id.f630732j);
        setOnClickListener(this);
    }

    private boolean d(String str, QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo) {
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_QQGameSubscribeInfoView", 2, "isDataInvalid..appId:" + str + ",info:" + qQGamePubSubscribe$AppSubscribeInfo);
        }
        if (((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isInValidGameAppId(str)) {
            setVisibility(8);
            QLog.e("QQGamePub_QQGameSubscribeInfoView", 1, "isDataInvalid..appId is isInValid");
            return true;
        }
        setVisibility(0);
        this.E = str;
        if (qQGamePubSubscribe$AppSubscribeInfo != null) {
            if (!str.equals(qQGamePubSubscribe$AppSubscribeInfo.appid.get() + "")) {
                QLog.e("QQGamePub_QQGameSubscribeInfoView", 1, "isDataInvalid..appId is not match,current appid:" + str + ",rspAppId:" + qQGamePubSubscribe$AppSubscribeInfo.appid.get());
                return true;
            }
        }
        return false;
    }

    private boolean e(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    private void f() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f264787f, PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, 1.0f, 1.5f, 1.0f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, 1.0f, 1.5f, 1.0f));
        ofPropertyValuesHolder.setDuration(300L);
        ofPropertyValuesHolder.start();
    }

    private void h(String str) {
        int a16 = g.a(60.0f, getResources());
        Bitmap roundedCornerBitmap = BaseImageUtil.getRoundedCornerBitmap(d.b().c(str), g.a(12.0f, this.f264786e.getResources()), true, a16, a16);
        if (roundedCornerBitmap != null) {
            this.f264786e.setImageBitmap(roundedCornerBitmap);
        } else {
            d.b().d(str, new d.b(a16) { // from class: com.tencent.mobileqq.qqgamepub.view.QQGameSubscribeInfoView.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f264791a;

                {
                    this.f264791a = a16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameSubscribeInfoView.this, a16);
                    }
                }

                @Override // com.tencent.mobileqq.qqgamepub.utils.d.b
                public void onImageLoaded(String str2, Bitmap bitmap, String str3) {
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, str2, bitmap, str3);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onImageLoaded...url:");
                        sb5.append(str2);
                        sb5.append(",image:");
                        sb5.append(bitmap);
                        sb5.append(",isMainTread:");
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        sb5.append(z16);
                        QLog.i("QQGamePub_QQGameSubscribeInfoView", 1, sb5.toString());
                    }
                    float a17 = g.a(12.0f, QQGameSubscribeInfoView.this.f264786e.getResources());
                    int i3 = this.f264791a;
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(BaseImageUtil.getRoundedCornerBitmap(bitmap, a17, true, i3, i3)) { // from class: com.tencent.mobileqq.qqgamepub.view.QQGameSubscribeInfoView.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Bitmap f264793d;

                        {
                            this.f264793d = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else if (this.f264793d != null && QQGameSubscribeInfoView.this.f264786e != null) {
                                QQGameSubscribeInfoView.this.f264786e.setImageBitmap(this.f264793d);
                            }
                        }
                    });
                }
            }, a16, a16);
        }
    }

    private void i(boolean z16, boolean z17) {
        if (z16) {
            this.f264788h.setVisibility(8);
            this.f264787f.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mvl));
            this.f264789i.setText(getResources().getString(R.string.f1765731m));
            this.f264789i.setTextColor(Color.parseColor("#8f9194"));
            if (z17) {
                f();
            }
        } else {
            this.f264788h.setVisibility(0);
            this.f264787f.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.mvi));
            this.f264789i.setText(getResources().getString(R.string.f1765431j));
            this.f264789i.setTextColor(getResources().getColor(R.color.cgp));
        }
        this.D = z16;
    }

    private void j(long j3) {
        if (j3 <= 0) {
            this.f264790m.setVisibility(4);
            return;
        }
        this.f264790m.setVisibility(0);
        if (j3 >= 10000) {
            this.f264790m.setText(String.format(getResources().getString(R.string.f1766031p), (j3 / 10000) + ""));
            return;
        }
        this.f264790m.setText(String.format(getResources().getString(R.string.f1765931o), j3 + ""));
    }

    public void g(String str, QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo, boolean z16) {
        String str2;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, qQGamePubSubscribe$AppSubscribeInfo, Boolean.valueOf(z16));
            return;
        }
        if (d(str, qQGamePubSubscribe$AppSubscribeInfo)) {
            return;
        }
        IQQGameSubscribeService iQQGameSubscribeService = (IQQGameSubscribeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all");
        String string = getResources().getString(R.string.ivu);
        IQQGameSubscribeService.a gameInfoFromCacheMap = iQQGameSubscribeService.getGameInfoFromCacheMap(str);
        if (gameInfoFromCacheMap != null) {
            if (!TextUtils.isEmpty(gameInfoFromCacheMap.f264395b)) {
                string = gameInfoFromCacheMap.f264395b;
            }
            z17 = gameInfoFromCacheMap.f264396c;
        }
        this.C = qQGamePubSubscribe$AppSubscribeInfo;
        if (qQGamePubSubscribe$AppSubscribeInfo == null) {
            this.C = b(str, iQQGameSubscribeService);
        }
        QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo2 = this.C;
        if (qQGamePubSubscribe$AppSubscribeInfo2 != null) {
            z17 = e(qQGamePubSubscribe$AppSubscribeInfo2.subscribe.get());
            j3 = this.C.subscribeCount.get();
            str2 = this.C.appIcon.get();
        } else {
            str2 = "";
            j3 = 0;
        }
        this.f264785d.setText(string);
        i(z17, z16);
        h(str2);
        j(j3);
        if (QLog.isColorLevel()) {
            QLog.i("QQGamePub_QQGameSubscribeInfoView", 2, "refreshUi...info:" + qQGamePubSubscribe$AppSubscribeInfo + ",mSubScribeInfo:" + this.C + ",appName:" + string + ",appIcon:" + str2 + ",subscribeNum:" + j3 + ",needAnim:" + z16 + ",isSubscribed:" + z17);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("QQGamePub_QQGameSubscribeInfoView", 2, "onClick...mSubScribeInfo" + this.C + ",isNetSupport:" + AppNetConnInfo.isNetSupport() + ",mAppId:" + this.E);
            }
            int i3 = 1;
            if (!AppNetConnInfo.isNetSupport()) {
                QQToast.makeText(getContext(), 1, getResources().getString(R.string.f17640316), 0).show();
            } else if (((IQQGameHelper) QRoute.api(IQQGameHelper.class)).isInValidGameAppId(this.E)) {
                QQToast.makeText(getContext(), 1, getResources().getString(R.string.f1765631l), 0).show();
            } else if (R.id.yqt == view.getId() && Math.abs(System.currentTimeMillis() - this.F) >= 1000) {
                IQQGameSubscribeService iQQGameSubscribeService = (IQQGameSubscribeService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all");
                if (this.D) {
                    i3 = 2;
                }
                this.F = iQQGameSubscribeService.reqSetSubscribeStatus(this.E, i3, 2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public QQGameSubscribeInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QQGameSubscribeInfoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.D = false;
            c(context);
        }
    }
}
