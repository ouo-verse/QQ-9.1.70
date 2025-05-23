package com.tencent.mobileqq.emoticon;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class EPRecommendTask implements IEPRecommendTask {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    WeakReference<BaseQQAppInterface> f204571a;

    /* renamed from: b, reason: collision with root package name */
    String f204572b;

    /* renamed from: c, reason: collision with root package name */
    String f204573c;

    /* renamed from: d, reason: collision with root package name */
    Runnable f204574d;

    /* renamed from: e, reason: collision with root package name */
    CallBacker f204575e;

    /* loaded from: classes12.dex */
    class a extends CallBacker {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EPRecommendTask.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
        public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            BaseQQAppInterface baseQQAppInterface = EPRecommendTask.this.f204571a.get();
            if (baseQQAppInterface != null && VasUpdateConstants.SCID_MAGIC_FACE_ENTRY_CONFIG.equals(str)) {
                ((IVasQuickUpdateService) baseQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(EPRecommendTask.this.f204575e);
                EPRecommendTask.this.b(VasUpdateUtil.getJSONFromLocal(baseQQAppInterface, VasUpdateConstants.SCID_MAGIC_FACE_ENTRY_CONFIG, false, null));
            }
        }
    }

    public EPRecommendTask(BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface);
            return;
        }
        this.f204574d = new Runnable() { // from class: com.tencent.mobileqq.emoticon.EPRecommendTask.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EPRecommendTask.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseQQAppInterface baseQQAppInterface2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("EPRecommendTask", 2, "url:" + EPRecommendTask.this.f204572b + ",type:" + EPRecommendTask.this.f204573c);
                }
                try {
                    baseQQAppInterface2 = EPRecommendTask.this.f204571a.get();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.emoji.EmoDown", 2, e16.getMessage());
                    }
                } catch (OutOfMemoryError unused) {
                }
                if (baseQQAppInterface2 == null) {
                    return;
                }
                EPRecommendTask.this.b(VasUpdateUtil.getJSONFromLocal(baseQQAppInterface2, VasUpdateConstants.SCID_MAGIC_FACE_ENTRY_CONFIG, true, EPRecommendTask.this.f204575e));
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (QLog.isColorLevel()) {
                    QLog.d("EPRecommendTask", 2, "costTime:" + currentTimeMillis2 + ",type:" + EPRecommendTask.this.f204573c);
                }
            }
        };
        this.f204575e = new a();
        this.f204571a = new WeakReference<>(baseQQAppInterface);
    }

    public static String a() {
        String lastLoginUin = MobileQQ.sMobileQQ.getLastLoginUin();
        if (lastLoginUin != null && lastLoginUin.length() > 0) {
            return lastLoginUin;
        }
        return MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
    }

    public static com.tencent.mobileqq.magicface.model.b c(JSONObject jSONObject) {
        com.tencent.mobileqq.magicface.model.b bVar = null;
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("emojiAioConfig");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                com.tencent.mobileqq.magicface.model.b bVar2 = new com.tencent.mobileqq.magicface.model.b();
                try {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                    bVar2.f243430a = jSONObject2.optInt("hide");
                    bVar2.f243431b = jSONObject2.optInt("version");
                    bVar2.f243434e = jSONObject2.optString("url");
                    JSONObject optJSONObject = jSONObject2.optJSONObject(HippyTKDGifImageViewController.PROPS_GIFURL);
                    if (optJSONObject != null) {
                        bVar2.f243432c = optJSONObject.optString("src");
                    }
                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("imgUrl");
                    if (optJSONObject2 != null) {
                        bVar2.f243433d = optJSONObject2.optString("src");
                        return bVar2;
                    }
                    return bVar2;
                } catch (Exception e16) {
                    e = e16;
                    bVar = bVar2;
                    e.printStackTrace();
                    return bVar;
                }
            }
            return null;
        } catch (Exception e17) {
            e = e17;
        }
    }

    void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.tencent.mobileqq.magicface.model.b c16 = c(jSONObject);
            if (c16 == null) {
                return;
            }
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
            sharedPreferences.edit().putInt("magic_promotion_hide", c16.f243430a).commit();
            if (QLog.isColorLevel()) {
                QLog.d("EPRecommendTask", 2, "promotionInfo:[hide]:" + c16.f243430a + ",[ver]:" + c16.f243431b);
            }
            if (1 == c16.f243430a) {
                return;
            }
            if (!TextUtils.isEmpty(c16.f243433d) && !TextUtils.isEmpty(c16.f243432c) && !TextUtils.isEmpty(c16.f243434e)) {
                sharedPreferences.edit().putString("magic_promotion_jump_url", c16.f243434e).commit();
                sharedPreferences.edit().putString("magic_promotion_imgUrl", IEPRecommendTask.PROMOTION_IMAGE_URL_PREFIX + c16.f243433d).commit();
                sharedPreferences.edit().putString("magic_promotion_gifUrl", IEPRecommendTask.PROMOTION_IMAGE_URL_PREFIX + c16.f243432c).commit();
                if (sharedPreferences.getInt("magic_promotion_old_ver_" + a(), -1) < c16.f243431b) {
                    sharedPreferences.edit().putBoolean("magic_promotion_is_new_content_" + a(), true).commit();
                    sharedPreferences.edit().putInt("magic_promotion_old_ver_" + a(), c16.f243431b).commit();
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("EPRecommendTask", 2, "promotionInfo: imgUrl = " + c16.f243433d + " gifUrl = " + c16.f243432c + " jumpUrl = " + c16.f243434e);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEPRecommendTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public EPRecommendTask setParam(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EPRecommendTask) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        this.f204573c = str2;
        this.f204572b = str;
        return this;
    }

    @Override // com.tencent.mobileqq.emoticon.IEPRecommendTask
    public void runTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ThreadManagerV2.post(this.f204574d, 5, null, true);
        }
    }
}
