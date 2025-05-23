package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.theme.api.IThemeEffectApi;
import com.tencent.mobileqq.vas.theme.api.IThemeVideoController;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.effect.QEffectApngImageView;
import com.tencent.mobileqq.vas.theme.effect.QEffectLottieImageView;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.io.File;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class QEffectBgProvider implements u {

    /* renamed from: h, reason: collision with root package name */
    private static IThemeVideoController f178691h;

    /* renamed from: d, reason: collision with root package name */
    private QEffectView f178692d;

    /* renamed from: e, reason: collision with root package name */
    private a61.c f178693e;

    /* renamed from: f, reason: collision with root package name */
    private long f178694f = 0;

    public QEffectBgProvider(a61.c cVar) {
        this.f178693e = cVar;
    }

    public static String d(Context context, String str, String str2) {
        String chatBackgroundPath = ChatBackgroundUtil.getChatBackgroundPath(context, str, str2);
        if (chatBackgroundPath.contains("aioImage")) {
            return chatBackgroundPath.replace("aioImage", "aio_bg.mp4");
        }
        return null;
    }

    public static boolean e(Context context, String str, String str2) {
        String d16 = d(context, str, str2);
        if (!TextUtils.isEmpty(d16)) {
            return new File(d16).exists();
        }
        return false;
    }

    public void c() {
        if (this.f178692d != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("destroy qeffect, duration:");
            long j3 = this.f178694f;
            if (j3 != 0) {
                j3 = System.currentTimeMillis() - this.f178694f;
            }
            sb5.append(j3);
            QLog.i("QEffectBgProvider", 1, sb5.toString());
            IThemeVideoController iThemeVideoController = f178691h;
            if (iThemeVideoController != null) {
                iThemeVideoController.releaseAioBg();
            }
            if (this.f178692d.getQEffectImpl() != null) {
                ((View) this.f178692d.getQEffectImpl()).destroyDrawingCache();
            }
            this.f178692d.clear();
        }
    }

    public void f() {
        QEffectView qEffectView = this.f178692d;
        if (qEffectView != null) {
            qEffectView.pause();
        }
    }

    public void g() {
        QEffectView qEffectView = this.f178692d;
        if (qEffectView != null) {
            qEffectView.resume();
        }
    }

    public void h(Context context, AppRuntime appRuntime, Drawable drawable, String str, ViewGroup viewGroup) {
        if (drawable != null) {
            if (this.f178692d == null) {
                QEffectView qEffectView = new QEffectView(context);
                this.f178692d = qEffectView;
                viewGroup.addView(qEffectView, 0, new ViewGroup.LayoutParams(-1, -1));
            }
            if (drawable instanceof ChatBackgroundDrawable) {
                ThemeBackground.sAIOBusinessFlag.setUseStatic();
            } else if (drawable instanceof URLDrawable) {
                ThemeBackground.sAIOBusinessFlag.setUseApng();
            }
            this.f178692d.setExtOptions(2, QEffectApngImageView.getApngOptions(new int[]{0}, "-chatBg-"));
            String currentUin = appRuntime.getCurrentUin();
            final int l3 = ChatBackgroundManager.l(context, currentUin, str);
            if (l3 > 0) {
                VasUtil.getSignedService(appRuntime).getColorScreen().a(l3, new VasManager.CompleteListener<com.tencent.mobileqq.floatscr.a>() { // from class: com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1
                    @Override // com.tencent.mobileqq.vas.VasManager.CompleteListener
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onComplete(final com.tencent.mobileqq.floatscr.a aVar, Object obj) {
                        if (aVar != null) {
                            QEffectBgProvider.this.f178692d.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    QLog.i("QEffectBgProvider", 1, "set qeffect for 3D background effectId:" + l3);
                                    QEffectBgProvider.this.f178694f = System.currentTimeMillis();
                                    QEffectBgProvider.this.f178692d.setSrc(QEffectLottieImageView.createDefData(aVar.f209988a, -1));
                                }
                            }, 1000L);
                        }
                    }
                });
                ThemeBackground.sAIOBusinessFlag.setUseEffect();
                return;
            }
            if (ChatBackgroundManager.s(context, currentUin, str) && !DeviceInfoUtils.isLowPerfDevice()) {
                String chatBackgroundPath = ChatBackgroundUtil.getChatBackgroundPath(context, currentUin, str);
                this.f178694f = System.currentTimeMillis();
                this.f178692d.setSrc(chatBackgroundPath.replace("aioImage", ""), "zip");
                QLog.i("QEffectBgProvider", 1, "set qeffect for custom background aioImageID:" + ChatBackgroundUtil.getId(chatBackgroundPath));
                ThemeBackground.sAIOBusinessFlag.setUse3D();
                return;
            }
            if (e(context, currentUin, str)) {
                String d16 = d(context, currentUin, str);
                if (VasNormalToggle.VAS_CHANGE_GLD_2_NATIVE.isEnable(true)) {
                    if (d16 != null) {
                        IThemeVideoController iThemeVideoController = f178691h;
                        if (iThemeVideoController == null) {
                            f178691h = ((IThemeEffectApi) QRoute.api(IThemeEffectApi.class)).newLoopVideoController(d16, drawable, viewGroup);
                        } else if (iThemeVideoController.isSameFile(d16)) {
                            f178691h.init(viewGroup);
                        } else {
                            f178691h.release();
                            f178691h = ((IThemeEffectApi) QRoute.api(IThemeEffectApi.class)).newLoopVideoController(d16, drawable, viewGroup);
                        }
                        QLog.i("QEffectBgProvider", 1, "set native video player:" + d16);
                        return;
                    }
                    return;
                }
                Drawable dynamicDrawable = ThemeBackground.getDynamicDrawable(d16, R.drawable.chat_bg_texture);
                if (dynamicDrawable instanceof IGLDrawable) {
                    ((IGLDrawable) dynamicDrawable).setLockWH(true);
                }
                if (dynamicDrawable != null) {
                    viewGroup.setBackgroundDrawable(dynamicDrawable);
                    ThemeBackground.sAIOBusinessFlag.setUseVideo();
                    return;
                }
                return;
            }
            this.f178692d.clear();
            return;
        }
        QEffectView qEffectView2 = this.f178692d;
        if (qEffectView2 != null) {
            qEffectView2.clear();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.z
    public void onMoveToState(int i3) {
        if (i3 != 15) {
            if (i3 != 16) {
                if (i3 == 18) {
                    g();
                    return;
                }
                return;
            }
            f();
            return;
        }
        c();
    }
}
