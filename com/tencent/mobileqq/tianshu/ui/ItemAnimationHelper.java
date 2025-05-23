package com.tencent.mobileqq.tianshu.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ItemAnimationHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String MMKV_KEY_IS_SHOW_ANIMATION_PREFIX = "is_show_item_animation_";
    private static final String TAG = "ItemAnimationHelper";
    private static boolean isLebaResume;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f293128d;

        a(String str) {
            this.f293128d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ItemAnimationHelper.setAnimationShowed(uRLDrawable, this.f293128d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34380);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            isLebaResume = false;
        }
    }

    public ItemAnimationHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getApngUrl(BusinessInfoCheckUpdate.AppInfo appInfo) {
        for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : appInfo.red_display_info.red_type_info.get()) {
            if (redTypeInfo.red_type.get() == 32) {
                return redTypeInfo.red_content.get();
            }
        }
        return null;
    }

    private static String getCurrentUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return "";
    }

    public static boolean isItemAnimationShowed(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String parseAdId = parseAdId(appInfo);
        if (TextUtils.isEmpty(parseAdId)) {
            return true;
        }
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU).decodeBool(MMKV_KEY_IS_SHOW_ANIMATION_PREFIX + getCurrentUin() + parseAdId, false);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "isItemAnimationShowed isShow:" + decodeBool);
        }
        return decodeBool;
    }

    public static boolean isValidItemAnimationRedTouch(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (redTouch != null && appInfo != null && appInfo.type.get() == 32 && appInfo.iNewFlag.get() != 0 && appInfo.exposure_max.get() >= 0 && appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
            return true;
        }
        return false;
    }

    public static void onLebaPause() {
        isLebaResume = false;
    }

    public static void onLebaResume() {
        isLebaResume = true;
    }

    private static String parseAdId(BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str = appInfo.buffer.get();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).optString("ad_id");
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parson ad_id e:", e16);
            return null;
        }
    }

    public static void removeItemAnimationView(RedTouch redTouch) {
        RelativeLayout relativeLayout;
        View findViewById;
        if ((redTouch.getTarget() instanceof RelativeLayout) && (findViewById = (relativeLayout = (RelativeLayout) redTouch.getTarget()).findViewById(R.id.xsk)) != null) {
            relativeLayout.removeView(findViewById);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setAnimationShowed(URLDrawable uRLDrawable, String str) {
        if (isLebaResume && (uRLDrawable.getCurrDrawable() instanceof ApngDrawable)) {
            QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU).encodeBool(MMKV_KEY_IS_SHOW_ANIMATION_PREFIX + getCurrentUin() + str, true);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setAnimationShowed adId:");
            sb5.append(str);
            QLog.i(TAG, 1, sb5.toString());
        }
    }

    public static boolean showItemAnimation(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo) {
        isLebaResume = true;
        if (!(redTouch.getTarget() instanceof RelativeLayout)) {
            return false;
        }
        String apngUrl = getApngUrl(appInfo);
        String parseAdId = parseAdId(appInfo);
        if (TextUtils.isEmpty(apngUrl) || TextUtils.isEmpty(parseAdId)) {
            return false;
        }
        RelativeLayout relativeLayout = (RelativeLayout) redTouch.getTarget();
        View findViewById = relativeLayout.findViewById(R.id.xsk);
        if (findViewById != null && (findViewById.getTag() instanceof String) && parseAdId.equals(findViewById.getTag())) {
            return true;
        }
        if (findViewById != null) {
            relativeLayout.removeView(findViewById);
        }
        Context context = relativeLayout.getContext();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = context.getResources().getDrawable(R.drawable.trans);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mUseApngImage = true;
        Bundle bundle = new Bundle();
        bundle.putInt("key_loop", 1);
        bundle.putBoolean("key_once_clear", true);
        obtain.mExtraInfo = bundle;
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        URLDrawable drawable2 = URLDrawable.getDrawable(apngUrl, obtain);
        drawable2.setURLDrawableListener(new a(parseAdId));
        imageView.setImageDrawable(drawable2);
        imageView.setId(R.id.xsk);
        imageView.setTag(parseAdId);
        relativeLayout.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        setAnimationShowed(drawable2, parseAdId);
        return true;
    }
}
