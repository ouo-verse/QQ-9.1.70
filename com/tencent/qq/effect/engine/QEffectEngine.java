package com.tencent.qq.effect.engine;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.BaseQEffectLoad;
import com.tencent.qq.effect.IQEffect;
import com.tencent.qq.effect.IQEffectLoad;
import com.tencent.qq.effect.QEffectView;
import com.tencent.qq.effect.impls.QEffectImageView;
import com.tencent.qq.effect.impls.QEffectVideoAlphaView;
import com.tencent.qq.effect.impls.QEffectVideoView;
import com.tencent.qq.effect.sensor.GravitySensor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QEffectEngine {
    static IPatchRedirector $redirector_;
    private static volatile QEffectEngine mInstance;
    private final String TAG;
    private String mCacheFileDir;
    private SparseArray<Class<? extends IQEffect>> mEffectMap;
    private SparseArray<String> mFileTypeMap;
    private GravitySensor mGravitySensor;
    private JsonConvert mJsonConvert;
    private IQEffectLoad mLoad;
    private int mSensorCount;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface JsonConvert {
        <T> T parseArray(String str, Class cls);

        <T> T parseObject(String str, Class cls);
    }

    QEffectEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "QEffectEngine";
        this.mSensorCount = 0;
        this.mEffectMap = new SparseArray<>();
        this.mFileTypeMap = new SparseArray<>();
        this.mGravitySensor = new GravitySensor();
        init();
    }

    public static QEffectEngine getInstance() {
        if (mInstance == null) {
            synchronized (QEffectEngine.class) {
                if (mInstance == null) {
                    mInstance = new QEffectEngine();
                }
            }
        }
        return mInstance;
    }

    public String getCacheFileDir(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        String str = this.mCacheFileDir;
        if (str == null) {
            return context.getExternalCacheDir().getAbsolutePath();
        }
        return str;
    }

    public IQEffect getEffectView(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IQEffect) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, i3);
        }
        Class<? extends IQEffect> cls = this.mEffectMap.get(i3);
        if (cls != null) {
            try {
                return cls.getDeclaredConstructor(Context.class).newInstance(context);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return null;
            } catch (InstantiationException e17) {
                e17.printStackTrace();
                return null;
            } catch (NoSuchMethodException e18) {
                e18.printStackTrace();
                return null;
            } catch (InvocationTargetException e19) {
                e19.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public int getFileType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).intValue();
        }
        for (int i3 = 0; i3 < this.mFileTypeMap.size(); i3++) {
            int keyAt = this.mFileTypeMap.keyAt(i3);
            String str2 = this.mFileTypeMap.get(keyAt);
            if (str2 != null && str2.equals(str)) {
                return keyAt;
            }
        }
        return 0;
    }

    public GravitySensor getGravitySensor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (GravitySensor) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mGravitySensor;
    }

    public JsonConvert getJsonConvert() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JsonConvert) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mJsonConvert;
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        registerEffect(1, QEffectType.IMAGE_TAG, QEffectImageView.class);
        registerEffect(4, "mp4", QEffectVideoView.class);
        registerEffect(5, QEffectType.VIDEO_ALPHA_TAG, QEffectVideoAlphaView.class);
        registerEffect(6, "zip", QEffectImageView.class);
        registerLoad(new BaseQEffectLoad());
    }

    public void load(Context context, QEffectView qEffectView, IQEffect iQEffect, QEffectData qEffectData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, qEffectView, iQEffect, qEffectData);
        } else {
            iQEffect.load(context, qEffectView, this.mLoad, qEffectData);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow(IQEffect iQEffect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) iQEffect);
            return;
        }
        if (!iQEffect.isGravityEnable()) {
            return;
        }
        this.mSensorCount++;
        if ((iQEffect instanceof View) && !this.mGravitySensor.isInit()) {
            this.mGravitySensor.init(((View) iQEffect).getContext());
        }
        if (iQEffect instanceof GravitySensor.GravitySensorListener) {
            this.mGravitySensor.addListener((GravitySensor.GravitySensorListener) iQEffect);
        }
    }

    public void onDetachedFromWindow(IQEffect iQEffect) {
        GravitySensor gravitySensor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) iQEffect);
            return;
        }
        iQEffect.stop();
        if (!iQEffect.isGravityEnable()) {
            return;
        }
        if (iQEffect instanceof GravitySensor.GravitySensorListener) {
            this.mGravitySensor.removeListener((GravitySensor.GravitySensorListener) iQEffect);
        }
        int i3 = this.mSensorCount - 1;
        this.mSensorCount = i3;
        if (i3 <= 0 && (gravitySensor = this.mGravitySensor) != null) {
            this.mSensorCount = 0;
            gravitySensor.destroy();
        }
    }

    public void registerEffect(int i3, String str, Class<? extends IQEffect> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, cls);
            return;
        }
        if (this.mEffectMap.get(i3) != null) {
            Log.e("QEffectEngine", i3 + " is already register," + cls.getSimpleName() + " will override");
        }
        if (str.indexOf(",") > 0) {
            for (String str2 : str.split("\\,")) {
                this.mFileTypeMap.put(i3, str2);
            }
        } else {
            this.mFileTypeMap.put(i3, str);
        }
        this.mEffectMap.put(i3, cls);
    }

    public void registerLoad(IQEffectLoad iQEffectLoad) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iQEffectLoad);
        } else {
            this.mLoad = iQEffectLoad;
        }
    }

    public void setCacheFileDir(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mCacheFileDir = str;
        }
    }

    public void setJsonConvert(JsonConvert jsonConvert) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonConvert);
        } else {
            this.mJsonConvert = jsonConvert;
        }
    }
}
