package com.tencent.qq.effect;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BaseQEffectLoad implements IQEffectLoad {
    static IPatchRedirector $redirector_;

    public BaseQEffectLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static QEffectData analyzeGLSLData(QEffectData qEffectData, String str, String str2) {
        qEffectData.src = str2;
        qEffectData.vertex = QEffectUtils.loadShaderFile(str + "/" + qEffectData.vertex);
        qEffectData.fragment = QEffectUtils.loadShaderFile(str + "/" + qEffectData.fragment);
        return qEffectData;
    }

    public static QEffectData analyzeLottieData(QEffectData qEffectData, String str) {
        qEffectData.src = str;
        File file = new File(new File(str).getParentFile().getAbsolutePath() + File.separator + LottieLoader.FILE_IMAGES);
        if (file.exists()) {
            qEffectData.images = file.getAbsolutePath() + "/";
        }
        return qEffectData;
    }

    @Override // com.tencent.qq.effect.IQEffectLoad
    public void load(Context context, IQEffect iQEffect, QEffectData qEffectData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, iQEffect, qEffectData);
            return;
        }
        int i3 = qEffectData.resType;
        if (i3 != 1) {
            if (i3 == 3) {
                loadFromResource(context, iQEffect, qEffectData.resId);
                return;
            }
            return;
        }
        loadFromFile(context, iQEffect, qEffectData.src);
    }

    @Override // com.tencent.qq.effect.IQEffectLoad
    public void loadFromAsset(Context context, IQEffect iQEffect, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, iQEffect, str);
        }
    }

    @Override // com.tencent.qq.effect.IQEffectLoad
    public void loadFromFile(Context context, IQEffect iQEffect, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, iQEffect, str);
            return;
        }
        try {
            iQEffect.complete(new BitmapDrawable(BitmapFactory.decodeStream(new FileInputStream(str))));
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qq.effect.IQEffectLoad
    public void loadFromResource(Context context, IQEffect iQEffect, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, iQEffect, Integer.valueOf(i3));
        } else if (context != null) {
            iQEffect.complete(context.getResources().getDrawable(i3));
        }
    }
}
