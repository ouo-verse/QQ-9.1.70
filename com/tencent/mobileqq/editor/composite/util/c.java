package com.tencent.mobileqq.editor.composite.util;

import com.tencent.aelight.camera.aioeditor.capture.paster.AnimationDecodeWrapper;
import com.tencent.aelight.camera.aioeditor.capture.paster.ApngDecodeWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/VideoCodec/Inject_InjectGifDecoderConfig.yml", version = 1)
    public static ArrayList<Class<? extends b>> f204040a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        f204040a = arrayList;
        arrayList.add(ApngDecodeWrapper.class);
        f204040a.add(AnimationDecodeWrapper.class);
    }

    public static b a(DynamicStickerData dynamicStickerData) {
        try {
            Iterator<Class<? extends b>> it = f204040a.iterator();
            b bVar = null;
            while (it.hasNext()) {
                Constructor<? extends b> declaredConstructor = it.next().getDeclaredConstructor(String.class, String.class);
                declaredConstructor.setAccessible(true);
                b newInstance = declaredConstructor.newInstance(dynamicStickerData.path, dynamicStickerData.data);
                if (bVar == null) {
                    bVar = newInstance;
                } else if (newInstance.getType() == dynamicStickerData.type) {
                    return newInstance;
                }
            }
            return bVar;
        } catch (Exception e16) {
            QLog.e("InjectGifDecoder", 1, e16, new Object[0]);
            return null;
        }
    }
}
