package cooperation.qqcircle.helpers;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.dataline.util.j;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.az;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.factory.OnHookCreateViewCallback;
import cooperation.qqcircle.factory.QCircleSkinFactory2;
import cooperation.qqcircle.helpers.QCircleIniFile;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSDynamicResourceManager {
    private static volatile QFSDynamicResourceManager INSTANCE = null;
    private static final List<Integer> QQ_BASE_WHITE_LIST;
    private static final String RES_DEF_TYPE = "string";
    private static final String SECTION_URL_KEY = "URL";
    private static final String TAG = "DTR-QFSDynamicResourceManager";
    private static final List<Integer> mDynamicStrForIdList = new CopyOnWriteArrayList();
    private static final Map<String, String> mDynamicUrlMap = new ConcurrentHashMap();
    private QCircleIniFile mDefaultIniFile;
    private RFWMultiDownloadHelper mMultiDownloadHelper;
    private QFSDynamicDownloadResultImpl mQFSDynamicDownloadResultImpl;
    private AtomicInteger mResStrMinVal = new AtomicInteger();
    private AtomicInteger mResStrMaxVal = new AtomicInteger();
    private boolean mDynamicInitRes = false;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class QFSDynamicDownloadResultImpl implements RFWMultiDownloadHelper.MultiDownloadResultListener {
        private String mDownloadUrl;
        private WeakReference<QFSDynamicResourceManager> mDynamicResourceManagerWeak;

        public QFSDynamicDownloadResultImpl(QFSDynamicResourceManager qFSDynamicResourceManager, String str) {
            this.mDynamicResourceManagerWeak = new WeakReference<>(qFSDynamicResourceManager);
            this.mDownloadUrl = str;
        }

        @Override // com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener
        public void onDownloadResult(boolean z16, Map<String, RFWMultiDownloadHelper.DownloadResult> map) {
            QFSDynamicResourceManager qFSDynamicResourceManager;
            WeakReference<QFSDynamicResourceManager> weakReference = this.mDynamicResourceManagerWeak;
            if (weakReference == null) {
                qFSDynamicResourceManager = null;
            } else {
                qFSDynamicResourceManager = weakReference.get();
            }
            if (qFSDynamicResourceManager != null) {
                qFSDynamicResourceManager.handlerIniFileDownloadChange(z16, map, this.mDownloadUrl);
                return;
            }
            QLog.e(QFSDynamicResourceManager.TAG, 1, "[onDownloadResult] helper should not be null, mDownloadUrl: " + this.mDownloadUrl);
        }
    }

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        QQ_BASE_WHITE_LIST = copyOnWriteArrayList;
        Integer valueOf = Integer.valueOf(R.string.f228946v4);
        copyOnWriteArrayList.add(valueOf);
        Integer valueOf2 = Integer.valueOf(R.string.f1632522m);
        copyOnWriteArrayList.add(valueOf2);
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f228886uy));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f228876ux));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f1632222j));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f1632122i));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.znq));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f228896uz));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f229156vo));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f201814vt));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f202044wf));
        Integer valueOf3 = Integer.valueOf(R.string.f202914ys);
        copyOnWriteArrayList.add(valueOf3);
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f202404xe));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f202334x8));
        copyOnWriteArrayList.add(valueOf3);
        copyOnWriteArrayList.add(valueOf);
        copyOnWriteArrayList.add(valueOf2);
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f1632422l));
        copyOnWriteArrayList.add(Integer.valueOf(R.string.f195594f1));
    }

    public QFSDynamicResourceManager() {
        az.f316690d = new az.a() { // from class: cooperation.qqcircle.helpers.c
            @Override // com.tencent.mobileqq.widget.az.a
            public final String a(int i3) {
                String lambda$new$0;
                lambda$new$0 = QFSDynamicResourceManager.lambda$new$0(i3);
                return lambda$new$0;
            }
        };
        QzoneConfig.getInstance().addListener(new QzoneConfig.QzoneConfigChangeListener() { // from class: cooperation.qqcircle.helpers.d
            @Override // common.config.service.QzoneConfig.QzoneConfigChangeListener
            public final void onConfigChange() {
                QFSDynamicResourceManager.lambda$new$1();
            }
        });
    }

    public static QFSDynamicResourceManager g() {
        if (INSTANCE == null) {
            synchronized (QFSDynamicResourceManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new QFSDynamicResourceManager();
                }
            }
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlerIniFileDownloadChange(boolean z16, Map<String, RFWMultiDownloadHelper.DownloadResult> map, String str) {
        int size;
        RFWMultiDownloadHelper.DownloadResult downloadResult;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handlerIniFileDownloadChange] is all success: ");
        sb5.append(z16);
        sb5.append(" | download result size: ");
        if (map == null) {
            size = 0;
        } else {
            size = map.size();
        }
        sb5.append(size);
        sb5.append(" | dynamic ini url: ");
        sb5.append(str);
        QLog.d(TAG, 1, sb5.toString());
        if (!z16) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "[handlerIniFileDownloadChange] dynamic ini url empty, end flow.");
            return;
        }
        if (map == null) {
            downloadResult = null;
        } else {
            downloadResult = map.get(str);
        }
        if (downloadResult == null) {
            QLog.e(TAG, 1, "[handlerIniFileDownloadChange] result == null.");
        } else {
            loadIniFileResource(downloadResult.mFilePath);
        }
    }

    private void initResTextToIds(List<Integer> list) {
        int intValue;
        if (RFWApplication.getApplication().getResources() == null) {
            QLog.e(TAG, 1, "[initResTextToIds] resources == null.");
            return;
        }
        try {
            List<Integer> list2 = mDynamicStrForIdList;
            list2.addAll(list);
            Integer[] numArr = new Integer[list2.size()];
            list2.toArray(numArr);
            Arrays.sort(numArr);
            ArrayList arrayList = new ArrayList(Arrays.asList(numArr));
            int i3 = 0;
            Integer num = (Integer) RFSafeListUtils.get(arrayList, 0);
            Integer num2 = (Integer) RFSafeListUtils.get(arrayList, arrayList.size() - 1);
            AtomicInteger atomicInteger = this.mResStrMinVal;
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue();
            }
            atomicInteger.set(intValue);
            AtomicInteger atomicInteger2 = this.mResStrMaxVal;
            if (num2 != null) {
                i3 = num2.intValue();
            }
            atomicInteger2.set(i3);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[initResTextToIds] ex: ", th5);
        }
    }

    private void initResUrlToMap(QCircleIniFile.Section section) {
        if (section == null) {
            QLog.e(TAG, 1, "[initResourceUrlForValue] section should not be null.");
            return;
        }
        Map<String, Object> values = section.getValues();
        Set<String> keySet = values.keySet();
        mDynamicUrlMap.clear();
        for (String str : keySet) {
            String valueOf = String.valueOf(values.get(str));
            QLog.d(TAG, 1, "[initResourceUrlForValue] resourceKey: " + str + " | value: " + valueOf);
            mDynamicUrlMap.put(str, valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIniFileResource$2(String str) {
        if (this.mDefaultIniFile == null) {
            QLog.e(TAG, 1, "[loadIniFileResource] ini file obj should not be null.");
            return;
        }
        try {
            this.mDefaultIniFile.load(new FileInputStream(str));
            initResUrlToMap(this.mDefaultIniFile.get("URL"));
            QLog.d(TAG, 1, "[loadIniFileResource] step2 local file path: " + str);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[loadIniFileResource] error: ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$0(int i3) {
        Resources resources;
        if (!QQ_BASE_WHITE_LIST.contains(Integer.valueOf(i3))) {
            return null;
        }
        Application application = RFWApplication.getApplication();
        if (application == null) {
            resources = null;
        } else {
            resources = application.getResources();
        }
        if (resources == null) {
            return null;
        }
        return j.d(resources.getString(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$1() {
        uq3.c.f439799c = "";
        uq3.c.f7();
    }

    private void loadIniFileResource(final String str) {
        QLog.d(TAG, 1, "[loadIniFileResource] step1 local file path: " + str);
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: cooperation.qqcircle.helpers.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSDynamicResourceManager.this.lambda$loadIniFileResource$2(str);
            }
        });
    }

    public void init(QCircleSkinFactory2 qCircleSkinFactory2, OnHookCreateViewCallback onHookCreateViewCallback, List<Integer> list) {
        if (qCircleSkinFactory2 == null) {
            QLog.e(TAG, 1, "[init] factory should not be null.");
            return;
        }
        if (!j.b()) {
            QLog.e(TAG, 1, "[init] current dynamic new name exp is close.");
            return;
        }
        if (this.mDynamicInitRes) {
            QLog.e(TAG, 1, "[init] current is load finish state.");
            return;
        }
        qCircleSkinFactory2.setOnHookLayoutInflaterViewAttr(onHookCreateViewCallback);
        this.mDefaultIniFile = new QCircleIniFile();
        String c16 = j.c();
        QLog.d(TAG, 1, "[init] dynamic ini url: " + c16);
        this.mMultiDownloadHelper = new RFWMultiDownloadHelper();
        RFWMultiDownloadHelper.DownloadTask downloadTask = new RFWMultiDownloadHelper.DownloadTask(c16, vq3.a.a());
        QFSDynamicDownloadResultImpl qFSDynamicDownloadResultImpl = new QFSDynamicDownloadResultImpl(this, c16);
        this.mQFSDynamicDownloadResultImpl = qFSDynamicDownloadResultImpl;
        this.mMultiDownloadHelper.setListener(qFSDynamicDownloadResultImpl);
        this.mMultiDownloadHelper.addTask(downloadTask);
        this.mMultiDownloadHelper.start();
        initResTextToIds(list);
        this.mDynamicInitRes = true;
    }

    public boolean isDynamicNewNameExp() {
        return j.b();
    }

    public boolean isNeedDynamicRes(int i3) {
        if (this.mResStrMinVal.get() == 0 && this.mResStrMaxVal.get() == 0) {
            return mDynamicStrForIdList.contains(Integer.valueOf(i3));
        }
        if (i3 >= this.mResStrMinVal.get() && i3 <= this.mResStrMaxVal.get() && mDynamicStrForIdList.contains(Integer.valueOf(i3))) {
            return true;
        }
        return false;
    }

    public boolean isUpdateViewToWhiteList(int i3) {
        try {
            return mDynamicStrForIdList.contains(Integer.valueOf(i3));
        } catch (Throwable unused) {
            return false;
        }
    }

    public String obtainKeyToStrVal(int i3, String str) {
        try {
            String string = RFWApplication.getApplication().getResources().getString(i3);
            QLog.d(TAG, 1, "[getNewNameText] identifier: " + i3 + " | value: " + string);
            return j.d(string);
        } catch (Throwable unused) {
            return str;
        }
    }

    public String obtainTokenToDynamicUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (j.a()) {
            String str3 = mDynamicUrlMap.get(str);
            if (!TextUtils.isEmpty(str3)) {
                str2 = QCircleSkinHelper.getInstance().getUrl(RFWApplication.getApplication(), str3);
            }
        } else {
            str2 = QCircleSkinHelper.getInstance().getUrl(str);
        }
        QLog.d(TAG, 1, "[obtainTokenToDynamicUrl] key: " + str + " | resultUrl: " + str2);
        return str2;
    }

    public void updateNetworkResource(ImageView imageView, String str, int i3) {
        if (imageView == null) {
            return;
        }
        String obtainTokenToDynamicUrl = g().obtainTokenToDynamicUrl(str, "");
        if (TextUtils.isEmpty(obtainTokenToDynamicUrl)) {
            imageView.setImageDrawable(RFWApplication.getApplication().getResources().getDrawable(i3));
            return;
        }
        Option targetView = Option.obtain().setUrl(obtainTokenToDynamicUrl).setTargetView(imageView);
        targetView.setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        QCircleFeedPicLoader.g().loadImage(targetView);
    }
}
