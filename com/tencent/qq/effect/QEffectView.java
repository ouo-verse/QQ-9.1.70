package com.tencent.qq.effect;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.effect.engine.Layout;
import com.tencent.qq.effect.engine.QEffectData;
import com.tencent.qq.effect.engine.QEffectEngine;
import com.tencent.qq.effect.engine.QEffectProto;
import com.tencent.qq.effect.utils.QEffectUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QEffectView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private String TAG;
    private Context mContext;
    private String mDefImg;
    private IQEffect mIQEffect;
    private SparseArray<WeakReference<IQEffect>> mIQEffectViewMap;
    private SparseArray<Object> mOptions;
    private String mSrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class DataLoadTask extends AsyncTask<QEffectData, Void, QEffectData> {
        static IPatchRedirector $redirector_;

        DataLoadTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QEffectView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public QEffectData doInBackground(QEffectData... qEffectDataArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QEffectData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) qEffectDataArr);
            }
            QEffectData qEffectData = qEffectDataArr[0];
            if (qEffectData.resType == 1) {
                if (!new File(qEffectData.src).exists()) {
                    qEffectData.src = null;
                    return null;
                }
                int i3 = qEffectData.type;
                if (i3 == 3) {
                    BaseQEffectLoad.analyzeLottieData(qEffectData, qEffectData.src);
                } else if (i3 == 7) {
                    String str = qEffectData.src;
                    BaseQEffectLoad.analyzeGLSLData(qEffectData, str, str);
                }
            }
            return qEffectData;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(QEffectData qEffectData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qEffectData);
                return;
            }
            if (qEffectData != null) {
                QEffectEngine qEffectEngine = QEffectEngine.getInstance();
                Context context = QEffectView.this.mContext;
                QEffectView qEffectView = QEffectView.this;
                qEffectEngine.load(context, qEffectView, qEffectView.mIQEffect, qEffectData);
                QEffectEngine.getInstance().onAttachedToWindow(QEffectView.this.mIQEffect);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class QEFileAsyncTask extends AsyncTask<String, Void, List<QEffectData>> {
        static IPatchRedirector $redirector_;

        QEFileAsyncTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QEffectView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:20:0x00b3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00b4 A[Catch: IOException -> 0x0149, TryCatch #0 {IOException -> 0x0149, blocks: (B:10:0x0029, B:13:0x0030, B:16:0x003c, B:18:0x00a5, B:21:0x00b4, B:23:0x00c1, B:25:0x00c5, B:28:0x00cc, B:29:0x00d2, B:31:0x00d8, B:33:0x00e2, B:51:0x0101, B:36:0x0104, B:38:0x0109, B:48:0x0110, B:49:0x0114, B:39:0x0116, B:42:0x011a, B:57:0x012f, B:59:0x004f, B:61:0x0055, B:63:0x0062, B:64:0x006e, B:66:0x008f, B:67:0x0092), top: B:9:0x0029 }] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<QEffectData> doInBackground(String... strArr) {
            String str;
            String replace;
            QEffectEngine.JsonConvert jsonConvert;
            List<QEffectData> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
            }
            String str2 = strArr[0];
            File file = new File(str2);
            String cacheFileDir = QEffectEngine.getInstance().getCacheFileDir(QEffectView.this.mContext);
            try {
                if (!file.exists()) {
                    return null;
                }
                if (file.isDirectory()) {
                    str = str2 + "/main.json";
                } else {
                    if (file.isFile() && file.getName().equals("main.json")) {
                        replace = file.getAbsolutePath().replace("/main.json", "");
                        String readFile = QEffectUtils.readFile(str2);
                        jsonConvert = QEffectEngine.getInstance().getJsonConvert();
                        if (jsonConvert != null) {
                            return null;
                        }
                        QEffectProto qEffectProto = (QEffectProto) jsonConvert.parseObject(readFile, QEffectProto.class);
                        if (qEffectProto.minVer >= 1 && (list = qEffectProto.eles) != null && list.size() != 0) {
                            for (QEffectData qEffectData : qEffectProto.eles) {
                                if (qEffectData.resType == 1) {
                                    String str3 = replace + "/" + qEffectData.src;
                                    if (!new File(str3).exists()) {
                                        qEffectData.src = null;
                                    } else {
                                        int i3 = qEffectData.type;
                                        if (i3 == 3) {
                                            BaseQEffectLoad.analyzeLottieData(qEffectData, str3);
                                        } else if (i3 == 7) {
                                            BaseQEffectLoad.analyzeGLSLData(qEffectData, replace, str3);
                                        } else {
                                            qEffectData.src = str3;
                                        }
                                    }
                                }
                                if (qEffectData.gravity) {
                                    QEffectEngine.getInstance().getGravitySensor().init(QEffectView.this.mContext);
                                }
                            }
                            return qEffectProto.eles;
                        }
                        QEffectView.this.mDefImg = replace + "/" + qEffectProto.defImg;
                        return null;
                    }
                    str2 = cacheFileDir + "/" + file.getName();
                    File file2 = new File(str2);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    QEffectUtils.upZipFile(file, str2);
                    str = str2 + "/main.json";
                }
                String str4 = str;
                replace = str2;
                str2 = str4;
                String readFile2 = QEffectUtils.readFile(str2);
                jsonConvert = QEffectEngine.getInstance().getJsonConvert();
                if (jsonConvert != null) {
                }
            } catch (IOException e16) {
                e16.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(List<QEffectData> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
                return;
            }
            if (list == null || list.size() <= 0) {
                if (QEffectView.this.mDefImg != null) {
                    QEffectView qEffectView = QEffectView.this;
                    qEffectView.setSrc(qEffectView.mDefImg);
                    return;
                }
                return;
            }
            QEffectView.this.loadEffectViews(list);
        }
    }

    public QEffectView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.TAG = "QEffectView";
        this.mOptions = new SparseArray<>();
        init(context);
    }

    private void init(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void loadEffectViews(List<QEffectData> list) {
        if (this.mIQEffectViewMap == null) {
            this.mIQEffectViewMap = new SparseArray<>();
        }
        for (QEffectData qEffectData : list) {
            int i3 = qEffectData.support;
            if (i3 == 0 || i3 == 109) {
                IQEffect effectView = QEffectEngine.getInstance().getEffectView(this.mContext, qEffectData.type);
                if (!(effectView instanceof View)) {
                    Log.e(this.TAG, " effect is null, module mame is png, src:" + qEffectData.src);
                } else {
                    FrameLayout.LayoutParams layoutParams = Layout.getLayoutParams(getContext(), qEffectData, getWidth(), getHeight());
                    View view = (View) effectView;
                    view.setId(qEffectData.effectId);
                    addView(view, layoutParams);
                    if (this.mIQEffectViewMap.get(qEffectData.effectId) != null) {
                        Log.e(this.TAG, " ID duplicate, please check ID:" + qEffectData.effectId);
                    }
                    this.mIQEffectViewMap.put(qEffectData.effectId, new WeakReference<>(effectView));
                    QEffectEngine.getInstance().load(this.mContext, this, effectView, qEffectData);
                    QEffectEngine.getInstance().onAttachedToWindow(effectView);
                }
            }
        }
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        this.mSrc = null;
        if (this.mIQEffect != null) {
            QEffectEngine.getInstance().onDetachedFromWindow(this.mIQEffect);
            removeView((View) this.mIQEffect);
            ((View) this.mIQEffect).destroyDrawingCache();
        }
        if (this.mIQEffectViewMap != null) {
            for (int i3 = 0; i3 < this.mIQEffectViewMap.size(); i3++) {
                WeakReference<IQEffect> valueAt = this.mIQEffectViewMap.valueAt(i3);
                if (valueAt != null && valueAt.get() != null) {
                    valueAt.get().stop();
                    ((View) valueAt.get()).setBackgroundResource(0);
                    removeView((View) valueAt.get());
                    QEffectEngine.getInstance().onDetachedFromWindow(valueAt.get());
                }
            }
            this.mIQEffectViewMap.clear();
        }
        removeAllViews();
    }

    public IQEffect findById(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (IQEffect) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        WeakReference<IQEffect> weakReference = this.mIQEffectViewMap.get(i3);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Object getExtOptions(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        return this.mOptions.get(i3);
    }

    public IQEffect getQEffectImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (IQEffect) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mIQEffect;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.mOptions.clear();
        clear();
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QEffectEngine.getInstance().getGravitySensor().pause();
        IQEffect iQEffect = this.mIQEffect;
        if (iQEffect != null) {
            iQEffect.pause();
        }
        if (this.mIQEffectViewMap != null) {
            for (int i3 = 0; i3 < this.mIQEffectViewMap.size(); i3++) {
                WeakReference<IQEffect> valueAt = this.mIQEffectViewMap.valueAt(i3);
                if (valueAt != null && valueAt.get() != null) {
                    valueAt.get().pause();
                }
            }
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QEffectEngine.getInstance().getGravitySensor().resume();
        IQEffect iQEffect = this.mIQEffect;
        if (iQEffect != null) {
            iQEffect.resume();
        }
        if (this.mIQEffectViewMap != null) {
            for (int i3 = 0; i3 < this.mIQEffectViewMap.size(); i3++) {
                WeakReference<IQEffect> valueAt = this.mIQEffectViewMap.valueAt(i3);
                if (valueAt != null && valueAt.get() != null) {
                    valueAt.get().resume();
                }
            }
        }
    }

    public void setExtOptions(int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, obj);
        } else {
            this.mOptions.put(i3, obj);
        }
    }

    public void setSrc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            setSrc(str, (String) null);
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    public void setSrc(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str.equals(this.mSrc)) {
            Log.e(this.TAG, " src\u91cd\u590d\u8bbe\u7f6e\uff0c\u8fd9\u6b21\u4e0d\u4f1a\u751f\u6548:" + str);
            return;
        }
        if (str2 == null) {
            str2 = QEffectUtils.getFileType(str);
        }
        if (str2 == null) {
            Log.e(this.TAG, " setSrc fileType is null src:" + str);
            return;
        }
        setSrc(str, QEffectEngine.getInstance().getFileType(str2), QEffectUtils.getFileLoadType(str));
        this.mSrc = str;
    }

    public QEffectView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.TAG = "QEffectView";
        this.mOptions = new SparseArray<>();
        init(context);
    }

    public QEffectView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.TAG = "QEffectView";
        this.mOptions = new SparseArray<>();
        init(context);
    }

    public void setSrc(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            setSrc(i3, (String) null);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    public void setSrc(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            setSrc(Integer.valueOf(i3), QEffectEngine.getInstance().getFileType(str), 3);
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
        }
    }

    public void setSrc(QEffectData qEffectData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) qEffectData);
            return;
        }
        clear();
        IQEffect effectView = QEffectEngine.getInstance().getEffectView(this.mContext, qEffectData.type);
        this.mIQEffect = effectView;
        if (effectView instanceof View) {
            addView((View) this.mIQEffect, Layout.getLayoutParams(getContext(), qEffectData, getWidth(), getHeight()));
            new DataLoadTask().execute(qEffectData);
        }
    }

    public void setSrc(Object obj, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, obj, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        clear();
        if (i3 == 6 && (obj instanceof String)) {
            new QEFileAsyncTask().execute((String) obj);
            return;
        }
        if (QEffectEngine.getInstance() == null) {
            Log.e(this.TAG, " setSrc engine is null");
            return;
        }
        Object obj2 = this.mIQEffect;
        if (obj2 != null) {
            removeView((View) obj2);
            this.mIQEffect = null;
        }
        IQEffect effectView = QEffectEngine.getInstance().getEffectView(this.mContext, i3);
        this.mIQEffect = effectView;
        if (!(effectView instanceof View)) {
            Log.e(this.TAG, " effect is null, module mame is png, src:" + obj);
            return;
        }
        QEffectData qEffectData = new QEffectData();
        qEffectData.type = i3;
        qEffectData.resType = i16;
        qEffectData.f344465h = -1.0f;
        qEffectData.f344466w = -1.0f;
        if (i16 == 3 && (obj instanceof Integer)) {
            qEffectData.resId = ((Integer) obj).intValue();
        } else {
            qEffectData.src = (String) obj;
        }
        setSrc(qEffectData);
    }
}
