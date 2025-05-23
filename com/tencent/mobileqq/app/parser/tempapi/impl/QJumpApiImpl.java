package com.tencent.mobileqq.app.parser.tempapi.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ck;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashWidget;
import com.tencent.mobileqq.splashad.config.ThemeSplashHelper;
import com.tencent.mobileqq.splashad.processor.h;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.theme.ThemeVipBehavior;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QJumpApiImpl implements IQJumpApi {
    static IPatchRedirector $redirector_ = null;
    public static final String REPORT_INVALID = "-1";
    public static ck mQQMapActivityProxy;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements ChatActivityUtils.u {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f196488a;

        a(QBaseActivity qBaseActivity) {
            this.f196488a = qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QJumpApiImpl.this, (Object) qBaseActivity);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.f196488a.finish();
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.activity.ChatActivityUtils.u
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f196488a.finish();
            }
        }
    }

    public QJumpApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void overWriteLayoutParamsWhenVas(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public boolean backToFileScheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return ForwardUtils.f();
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public void buildMapActivityProxy(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (mQQMapActivityProxy == null) {
            mQQMapActivityProxy = new ck(str);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public String forwardGetFilePath(Context context, Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, (Object) uri);
        }
        return ForwardFileBaseOption.r(context, uri);
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public boolean gestureGetJumpLock(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) str)).booleanValue();
        }
        return BaseGesturePWDUtil.getJumpLock(context, str);
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public String getSecurityVerifyPluginDataKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "extra_data";
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public View getSplashWidget(Activity activity, Drawable drawable, Drawable drawable2) {
        Drawable drawable3;
        BitmapDrawable bitmapDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, this, activity, drawable, drawable2);
        }
        SplashWidget splashWidget = new SplashWidget(activity);
        Drawable drawable4 = null;
        if (ThemeVipBehavior.enableVipSplash()) {
            drawable3 = h.d();
            if (drawable3 != null) {
                splashWidget.setSplashDrawable(drawable3, false);
                try {
                    overWriteLayoutParamsWhenVas(splashWidget.b());
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } else {
            drawable3 = null;
        }
        if (drawable3 == null) {
            ThemeSplashHelper.b m3 = ThemeSplashHelper.m(activity.getResources());
            if (m3 != null && (bitmapDrawable = m3.f288760a) != null) {
                drawable2 = m3.f288761b;
                drawable = bitmapDrawable;
            }
            if (drawable != null) {
                splashWidget.setSplashDrawable(drawable, true);
            }
            drawable4 = drawable2;
        }
        if (drawable4 != null) {
            splashWidget.setLogoDrawable(drawable4);
        }
        return splashWidget;
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public void handleByColorNote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ((IColorNoteController) QRoute.api(IColorNoteController.class)).setSmallScreenShouldShow(false, 0);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public void handleStartGroupAudio(QBaseActivity qBaseActivity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) str);
            return;
        }
        if (ChatActivityUtils.d0((QQAppInterface) qBaseActivity.getAppRuntime(), qBaseActivity, 3000, str, true, true, new a(qBaseActivity), null)) {
            qBaseActivity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public void nearByEnterNewGame(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public String parseJumpActionName(AppRuntime appRuntime, Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, this, appRuntime, context, str);
        }
        ax c16 = bi.c((QQAppInterface) appRuntime, context, str);
        if (c16 == null) {
            return "-1";
        }
        return c16.f307440e;
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public String parseJumpServerName(AppRuntime appRuntime, Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, appRuntime, context, str);
        }
        ax c16 = bi.c((QQAppInterface) appRuntime, context, str);
        if (c16 == null) {
            return "-1";
        }
        return c16.f307439d;
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public void qzoneLaunchForPreview(Context context, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) bundle);
        } else {
            StoryPublishLauncher.d().j(context, bundle);
        }
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public void releaseMapActivityProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (mQQMapActivityProxy != null) {
            mQQMapActivityProxy = null;
        }
    }

    @Override // com.tencent.mobileqq.app.parser.tempapi.IQJumpApi
    public void startForwardActivity(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) intent);
        } else {
            ForwardBaseOption.startForwardActivity(context, intent);
        }
    }
}
