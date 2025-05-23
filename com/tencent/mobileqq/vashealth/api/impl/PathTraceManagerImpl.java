package com.tencent.mobileqq.vashealth.api.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.pluginsdk.PluginInterface;
import com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vashealth.PathTraceService;
import com.tencent.mobileqq.vashealth.TracePathData;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.mobileqq.vashealth.api.IPathTraceManager;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit$OrbitHeader;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit$OrbitPacePoint;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit$OrbitPoint;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit$OrbitReq;
import com.tencent.mobileqq.vashealth.pb.QQSportsOrbit$OrbitRsp;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class PathTraceManagerImpl implements IPathTraceManager {
    public static final String BASE_URL = "https://imgcache.qq.com/ac/vasapp/webviewlib/2513/run_sd/audio715.zip";
    public static int LAST_DISTANCE = -2;
    public static int LAST_TIME = -1;
    public static final int MSG_TYPE_CALL_JS = 1;
    public static final int SUCCESS = 1;
    public static final String TAG = "PathTraceManager";
    public static final int TIME_TOO_LONG = -6;
    private static int mVoiceIndex = 0;
    public static MediaPlayer mediaPalyer = null;
    private static int sAccuracy = 50;
    private static int sIntervalDistance = 30;
    private static int sIntervalDistanceMax = 100;
    AppRuntime mApp;
    h mDownloaderInterface;
    EntityManager mEntityManager;
    public long mIntervalTime;
    private TracePointsData mLastPoint;
    private int mLastSteps;
    private TracePathData mPathTrace;
    private f mPathTraceLocation;
    WeakReference<WebViewPlugin> mPathTracePlug;
    private PluginInterfaceHelper.OnPluginInterfaceLoadedListener mPluginInterfaceLoadedListener;
    private int mStepGoal;
    SensorManager mStepManager;
    Sensor mStepSensor;
    SensorEventListener mSteplistener;
    private int mSteps;
    private int mType;
    public long mUploadTime;
    private int mWorkingMode;
    public boolean mSpeedRule = false;
    public boolean mIgnoreSpeed = false;
    boolean mVoiceAllFiles = true;
    public boolean mIsMute = false;
    private String internalSavePath = null;
    private PluginInterface mPluginInterface = null;
    private boolean mToolong = true;
    private List<TracePointsData> tempPointList = new ArrayList(4);
    boolean debug = false;
    public ArrayList<TracePointsData> mOriginnalPoints = new ArrayList<>();
    Handler mUIHandler = new e(Looper.getMainLooper());

    /* loaded from: classes20.dex */
    private class DataUploadTask implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private long f312212e;

        /* renamed from: f, reason: collision with root package name */
        private String f312213f;

        /* renamed from: d, reason: collision with root package name */
        private final int f312211d = 3000;

        /* renamed from: h, reason: collision with root package name */
        private String f312214h = "yundong_orbit.datauploadV3";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes20.dex */
        public class a implements BusinessObserver {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ JSONObject f312215d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ List f312216e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ TracePathData f312217f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ SharedPreferences f312218h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ QQSportsOrbit$OrbitReq f312219i;

            a(JSONObject jSONObject, List list, TracePathData tracePathData, SharedPreferences sharedPreferences, QQSportsOrbit$OrbitReq qQSportsOrbit$OrbitReq) {
                this.f312215d = jSONObject;
                this.f312216e = list;
                this.f312217f = tracePathData;
                this.f312218h = sharedPreferences;
                this.f312219i = qQSportsOrbit$OrbitReq;
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                int i16;
                DataUploadTask.this.g(z16, i3);
                if (z16) {
                    try {
                        byte[] byteArray = bundle.getByteArray("extra_data");
                        QQSportsOrbit$OrbitRsp qQSportsOrbit$OrbitRsp = new QQSportsOrbit$OrbitRsp();
                        try {
                            qQSportsOrbit$OrbitRsp.mergeFrom(byteArray);
                            i16 = qQSportsOrbit$OrbitRsp.lastNum.get();
                        } catch (Exception e16) {
                            QLog.e(PathTraceManagerImpl.TAG, 1, "[run] json fail" + e16.getMessage());
                            i16 = -1;
                        }
                        if (i16 != -1 && qQSportsOrbit$OrbitRsp.retCode.get() == 0) {
                            if (i16 >= this.f312216e.size()) {
                                this.f312215d.put("retCode", 1);
                                if (PathTraceManagerImpl.this.mUIHandler != null) {
                                    Message obtain = Message.obtain();
                                    obtain.what = 1;
                                    obtain.obj = this.f312215d;
                                    PathTraceManagerImpl.this.mUIHandler.sendMessage(obtain);
                                }
                                PathTraceManagerImpl.this.pathTraceDelete(Long.valueOf(this.f312217f.startTime));
                                QLog.d(PathTraceManagerImpl.TAG, 1, "upload success");
                                PathTraceManagerImpl.this.mPathTrace = null;
                                this.f312218h.edit().clear().commit();
                                return;
                            }
                            if (this.f312216e.size() > 0) {
                                if (this.f312216e.size() > 0) {
                                    for (int i17 = i16; i17 < i16 + 3000; i17++) {
                                        QQSportsOrbit$OrbitPoint qQSportsOrbit$OrbitPoint = new QQSportsOrbit$OrbitPoint();
                                        qQSportsOrbit$OrbitPoint.latitude.set(((TracePointsData) this.f312216e.get(i17)).latitude);
                                        qQSportsOrbit$OrbitPoint.longitude.set(((TracePointsData) this.f312216e.get(i17)).longitude);
                                        qQSportsOrbit$OrbitPoint.timef.set((int) ((TracePointsData) this.f312216e.get(i17)).time);
                                        qQSportsOrbit$OrbitPoint.speedf.set(((TracePointsData) this.f312216e.get(i17)).speed);
                                        qQSportsOrbit$OrbitPoint.accuracy.set(((TracePointsData) this.f312216e.get(i17)).accuracy);
                                        qQSportsOrbit$OrbitPoint.step.set(((TracePointsData) this.f312216e.get(i17)).steps);
                                        qQSportsOrbit$OrbitPoint.altitude.set((float) ((TracePointsData) this.f312216e.get(i17)).altitude);
                                        this.f312219i.tracePath.add(qQSportsOrbit$OrbitPoint);
                                        if (i17 == this.f312216e.size() - 1) {
                                            break;
                                        }
                                    }
                                }
                                if (i16 + 3000 >= this.f312216e.size()) {
                                    this.f312219i.isOver.set(1);
                                } else {
                                    this.f312219i.isOver.set(0);
                                }
                                this.f312219i.num.set(i16 + 1);
                            }
                            NewIntent newIntent = new NewIntent(PathTraceManagerImpl.this.mApp.getApplicationContext(), com.tencent.mobileqq.vashealth.websso.a.class);
                            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, DataUploadTask.this.f312214h);
                            newIntent.putExtra("extra_data", PathTraceManagerImpl.gzip(this.f312219i.toByteArray()));
                            this.f312219i.tracePath.clear();
                            newIntent.putExtra("extra_timeout", 15000);
                            newIntent.setObserver(this);
                            PathTraceManagerImpl.this.mApp.startServlet(newIntent);
                            return;
                        }
                        this.f312215d.put("retCode", -10);
                        if (PathTraceManagerImpl.this.mUIHandler != null) {
                            Message obtain2 = Message.obtain();
                            obtain2.what = 1;
                            obtain2.obj = this.f312215d;
                            PathTraceManagerImpl.this.mUIHandler.sendMessage(obtain2);
                            return;
                        }
                        return;
                    } catch (Exception e17) {
                        QLog.e(PathTraceManagerImpl.TAG, 1, "[run] json fail" + e17.getMessage());
                        return;
                    }
                }
                QLog.e(PathTraceManagerImpl.TAG, 1, "upload fail");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("retCode", -10);
                    if (PathTraceManagerImpl.this.mUIHandler != null) {
                        Message obtain3 = Message.obtain();
                        obtain3.what = 1;
                        obtain3.obj = jSONObject;
                        PathTraceManagerImpl.this.mUIHandler.sendMessage(obtain3);
                    }
                } catch (Exception e18) {
                    QLog.d(PathTraceManagerImpl.TAG, 1, "uploadfail:" + e18.toString());
                }
            }
        }

        public DataUploadTask(long j3, String str) {
            this.f312212e = j3;
            this.f312213f = str;
        }

        @NotNull
        private BusinessObserver c(QQSportsOrbit$OrbitReq qQSportsOrbit$OrbitReq, JSONObject jSONObject, TracePathData tracePathData, List<TracePointsData> list, SharedPreferences sharedPreferences) {
            return new a(jSONObject, list, tracePathData, sharedPreferences, qQSportsOrbit$OrbitReq);
        }

        private TracePathData e() {
            if (PathTraceManagerImpl.this.mPathTrace != null) {
                TracePathData tracePathData = PathTraceManagerImpl.this.mPathTrace;
                ArrayList arrayList = new ArrayList();
                arrayList.add(PathTraceManagerImpl.this.mPathTrace);
                PathTraceManagerImpl.this.bulkUpdateEntitys(arrayList);
                return tracePathData;
            }
            return PathTraceManagerImpl.this.getPathTraceByTime(this.f312212e);
        }

        private boolean f(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(boolean z16, int i3) {
            if (PathTraceManagerImpl.this.mApp != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("type", i3 + "");
                StatisticCollector.getInstance(PathTraceManagerImpl.this.mApp.getApp()).collectPerformance(PathTraceManagerImpl.this.mApp.getCurrentAccountUin(), "QQSportUpload", z16, System.currentTimeMillis(), 0L, hashMap, "", false);
            }
        }

        private void h(TracePathData tracePathData) {
            long j3 = PathTraceManagerImpl.this.mUploadTime;
            if (j3 != 0 && tracePathData != null) {
                tracePathData.totalTime = j3;
            }
        }

        private void i(QQSportsOrbit$OrbitHeader qQSportsOrbit$OrbitHeader) {
            if (PathTraceManagerImpl.this.mStepSensor != null) {
                qQSportsOrbit$OrbitHeader.stepType.set(1);
            } else {
                qQSportsOrbit$OrbitHeader.stepType.set(0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List<TracePointsData> list;
            SharedPreferences sharedPreferences;
            QQSportsOrbit$OrbitReq qQSportsOrbit$OrbitReq = new QQSportsOrbit$OrbitReq();
            char c16 = 1;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callback", this.f312213f);
                TracePathData e16 = e();
                h(e16);
                List<TracePointsData> allTracePointByStartTime = PathTraceManagerImpl.this.getAllTracePointByStartTime(this.f312212e);
                if (e16 != null && allTracePointByStartTime != null) {
                    QLog.d(PathTraceManagerImpl.TAG, 1, "upload startTime: " + e16.toString() + ",point size: " + allTracePointByStartTime.size());
                    QQSportsOrbit$OrbitHeader qQSportsOrbit$OrbitHeader = new QQSportsOrbit$OrbitHeader();
                    qQSportsOrbit$OrbitHeader.startTime.set((int) e16.startTime);
                    qQSportsOrbit$OrbitHeader.endTime.set((int) e16.endTime);
                    qQSportsOrbit$OrbitHeader.totalTime.set((int) e16.totalTime);
                    qQSportsOrbit$OrbitHeader.totalSteps.set(e16.totalSteps);
                    qQSportsOrbit$OrbitHeader.type.set(e16.type);
                    qQSportsOrbit$OrbitHeader.distance.set((float) e16.distance);
                    qQSportsOrbit$OrbitHeader.platform.set(2);
                    i(qQSportsOrbit$OrbitHeader);
                    char c17 = 0;
                    SharedPreferences sharedPreferences2 = PathTraceManagerImpl.this.mApp.getApplication().getSharedPreferences(String.valueOf(e16.startTime), 0);
                    int i3 = 1;
                    while (sharedPreferences2.getString(String.valueOf(i3), null) != null) {
                        String string = sharedPreferences2.getString(String.valueOf(i3), null);
                        if (string != null) {
                            String[] split = string.split(",");
                            QQSportsOrbit$OrbitPacePoint qQSportsOrbit$OrbitPacePoint = new QQSportsOrbit$OrbitPacePoint();
                            qQSportsOrbit$OrbitPacePoint.f312321km.set(i3);
                            qQSportsOrbit$OrbitPacePoint.time.set(Integer.parseInt(split[c17]));
                            sharedPreferences = sharedPreferences2;
                            qQSportsOrbit$OrbitPacePoint.latitude.set(Double.valueOf(split[c16]).doubleValue());
                            qQSportsOrbit$OrbitPacePoint.longitude.set(Double.valueOf(split[2]).doubleValue());
                            qQSportsOrbit$OrbitHeader.kmRecords.add(qQSportsOrbit$OrbitPacePoint);
                        } else {
                            sharedPreferences = sharedPreferences2;
                        }
                        i3++;
                        sharedPreferences2 = sharedPreferences;
                        c16 = 1;
                        c17 = 0;
                    }
                    SharedPreferences sharedPreferences3 = sharedPreferences2;
                    qQSportsOrbit$OrbitReq.reqHeader.set(qQSportsOrbit$OrbitHeader);
                    qQSportsOrbit$OrbitReq.isOver.set(0);
                    if (allTracePointByStartTime.size() > 0) {
                        int i16 = 0;
                        while (true) {
                            if (i16 >= 3000) {
                                break;
                            }
                            QQSportsOrbit$OrbitPoint qQSportsOrbit$OrbitPoint = new QQSportsOrbit$OrbitPoint();
                            qQSportsOrbit$OrbitPoint.latitude.set(allTracePointByStartTime.get(i16).latitude);
                            qQSportsOrbit$OrbitPoint.longitude.set(allTracePointByStartTime.get(i16).longitude);
                            qQSportsOrbit$OrbitPoint.timef.set((int) allTracePointByStartTime.get(i16).time);
                            qQSportsOrbit$OrbitPoint.speedf.set(allTracePointByStartTime.get(i16).speed);
                            qQSportsOrbit$OrbitPoint.accuracy.set(allTracePointByStartTime.get(i16).accuracy + 1);
                            qQSportsOrbit$OrbitPoint.step.set(allTracePointByStartTime.get(i16).steps);
                            qQSportsOrbit$OrbitPoint.altitude.set((float) allTracePointByStartTime.get(i16).altitude);
                            qQSportsOrbit$OrbitReq.tracePath.add(qQSportsOrbit$OrbitPoint);
                            if (i16 == allTracePointByStartTime.size() - 1) {
                                qQSportsOrbit$OrbitReq.isOver.set(1);
                                break;
                            }
                            i16++;
                        }
                    }
                    byte[] byteArray = qQSportsOrbit$OrbitReq.toByteArray();
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] gzip = PathTraceManagerImpl.gzip(byteArray);
                    if (QLog.isColorLevel() && gzip != null) {
                        list = allTracePointByStartTime;
                        QLog.d(PathTraceManagerImpl.TAG, 2, String.format("first:%s second:%s rate:%.3f time:%s", Integer.valueOf(byteArray.length), Integer.valueOf(gzip.length), Double.valueOf((gzip.length + 0.0d) / (byteArray.length + 0.0d)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
                    } else {
                        list = allTracePointByStartTime;
                    }
                    if (f(gzip)) {
                        jSONObject.put("retCode", -11);
                        jSONObject.put("message", "gzip failed");
                        return;
                    }
                    NewIntent newIntent = new NewIntent(PathTraceManagerImpl.this.mApp.getApplicationContext(), com.tencent.mobileqq.vashealth.websso.a.class);
                    newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, this.f312214h);
                    qQSportsOrbit$OrbitReq.num.set(0);
                    newIntent.putExtra("extra_data", gzip);
                    qQSportsOrbit$OrbitReq.tracePath.clear();
                    newIntent.putExtra("extra_timeout", 15000);
                    newIntent.setObserver(c(qQSportsOrbit$OrbitReq, jSONObject, e16, list, sharedPreferences3));
                    PathTraceManagerImpl.this.mApp.startServlet(newIntent);
                    return;
                }
                jSONObject.put("retCode", -9);
                jSONObject.put("message", "no path trace recode");
            } catch (Throwable th5) {
                QLog.e(PathTraceManagerImpl.TAG, 1, "[run] json fail" + th5.getMessage());
            }
        }
    }

    /* loaded from: classes20.dex */
    class a implements PluginInterfaceHelper.OnPluginInterfaceLoadedListener {
        a() {
        }

        @Override // com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.OnPluginInterfaceLoadedListener
        public void onPluginInterfaceLoaded(PluginInterface pluginInterface) {
            PathTraceManagerImpl.this.mPluginInterface = pluginInterface;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c extends com.tencent.mobileqq.vip.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f312223a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f312224b;

        c(String str, String str2) {
            this.f312223a = str;
            this.f312224b = str2;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            boolean z16;
            super.onDone(gVar);
            if (QLog.isColorLevel()) {
                QLog.d(PathTraceManagerImpl.TAG, 1, "voice down");
            }
            try {
                ZipUtils.unZipFile(new File(this.f312223a), PathTraceManagerImpl.this.internalSavePath);
                z16 = true;
            } catch (IOException unused) {
                QLog.i(PathTraceManagerImpl.TAG, 1, "unzip fail");
                z16 = false;
            }
            if (z16) {
                QLog.d(PathTraceManagerImpl.TAG, 1, "unzip success");
                if (this.f312224b != null) {
                    AudioUtil.p(Uri.fromFile(new File(PathTraceManagerImpl.this.internalSavePath, this.f312224b + DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)), false, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class d implements MediaPlayer.OnCompletionListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f312226d;

        d(ArrayList arrayList) {
            this.f312226d = arrayList;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            FileInputStream fileInputStream;
            Throwable th5;
            Exception e16;
            if (PathTraceManagerImpl.mVoiceIndex < this.f312226d.size() - 1) {
                PathTraceManagerImpl.mVoiceIndex++;
                PathTraceManagerImpl.mediaPalyer.reset();
                try {
                    try {
                        fileInputStream = new FileInputStream(new File(((Uri) this.f312226d.get(PathTraceManagerImpl.mVoiceIndex)).getPath()));
                    } catch (Exception e17) {
                        fileInputStream = null;
                        e16 = e17;
                    } catch (Throwable th6) {
                        fileInputStream = null;
                        th5 = th6;
                        PathTraceManagerImpl.closeFileInputStream(fileInputStream);
                        throw th5;
                    }
                    try {
                        PathTraceManagerImpl.mediaPalyer.setDataSource(fileInputStream.getFD());
                        PathTraceManagerImpl.mediaPalyer.prepare();
                        PathTraceManagerImpl.mediaPalyer.start();
                    } catch (Exception e18) {
                        e16 = e18;
                        QLog.e(PathTraceManagerImpl.TAG, 1, "Exception", e16);
                        PathTraceManagerImpl.closeFileInputStream(fileInputStream);
                        return;
                    }
                    PathTraceManagerImpl.closeFileInputStream(fileInputStream);
                    return;
                } catch (Throwable th7) {
                    th5 = th7;
                    PathTraceManagerImpl.closeFileInputStream(fileInputStream);
                    throw th5;
                }
            }
            this.f312226d.clear();
            PathTraceManagerImpl.mVoiceIndex = 0;
        }
    }

    /* loaded from: classes20.dex */
    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WebViewPlugin webViewPlugin;
            if (message.what == 1) {
                try {
                    JSONObject jSONObject = (JSONObject) message.obj;
                    String string = jSONObject.getString("callback");
                    WeakReference<WebViewPlugin> weakReference = PathTraceManagerImpl.this.mPathTracePlug;
                    if (weakReference != null && (webViewPlugin = weakReference.get()) != null) {
                        webViewPlugin.callJs(string, jSONObject.toString());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes20.dex */
    public class f extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private AppRuntime f312228a;

        public f(AppInterface appInterface) {
            super("pathtrace", true);
            this.f312228a = appInterface;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            if (i3 == 0) {
                SosoLocation sosoLocation = sosoLbsInfo.mLocation;
                TracePointsData tracePointsData = new TracePointsData();
                tracePointsData.time = NetConnInfoCenter.getServerTime();
                tracePointsData.latitude = (float) sosoLocation.mLat02;
                tracePointsData.longitude = (float) sosoLocation.mLon02;
                tracePointsData.altitude = sosoLocation.altitude;
                tracePointsData.accuracy = (int) sosoLocation.accuracy;
                tracePointsData.speed = sosoLocation.speed;
                if (this.f312228a != null) {
                    PathTraceManagerImpl.this.handleLocation(tracePointsData);
                    return;
                }
                return;
            }
            PathTraceManagerImpl pathTraceManagerImpl = PathTraceManagerImpl.this;
            pathTraceManagerImpl.mLastSteps = pathTraceManagerImpl.mSteps;
            if (PathTraceManagerImpl.this.mPathTrace != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(PathTraceManagerImpl.this.mPathTrace);
                PathTraceManagerImpl.this.bulkUpdateEntitys(arrayList);
            }
            QLog.e(PathTraceManagerImpl.TAG, 1, "Location Err: " + i3);
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onStatusUpdate(String str, int i3, String str2) {
            if (str.equals("gps") && i3 == 0) {
                QLog.d(PathTraceManagerImpl.TAG, 1, "GPS shutdown");
            }
        }
    }

    private boolean addDecadesStepToVoice(ArrayList<String> arrayList, long j3, boolean z16) {
        double d16 = j3;
        if (isDigitValid(getDecades(d16))) {
            arrayList.add(getDecades(d16));
            arrayList.add("100");
            return false;
        }
        if (getDecades(d16) != null && Integer.parseInt(getDecades(d16)) == 0 && !z16) {
            if (isDigitValid(getTens(d16)) || isDigitValid(getOnes(d16))) {
                arrayList.add("0");
                return true;
            }
            return z16;
        }
        return z16;
    }

    private void addDecadesTimeToVoice(ArrayList<String> arrayList, long j3) {
        double d16 = j3;
        if (getDecades(d16) != null) {
            arrayList.add(getDecades(d16));
            arrayList.add("100");
        }
    }

    private boolean addErrDataToLogStr(TracePointsData tracePointsData, StringBuilder sb5, float[] fArr) {
        if (tracePointsData.accuracy > sAccuracy) {
            sb5.append(",accuracy too low: ");
            sb5.append(tracePointsData.accuracy);
            return true;
        }
        if (!this.mIgnoreSpeed && (tracePointsData.speed >= 0.005d || !this.mSpeedRule)) {
            float f16 = fArr[0];
            if (f16 > sIntervalDistanceMax && this.mToolong) {
                sb5.append(",distance too long: ");
                sb5.append(fArr[0]);
                this.mToolong = false;
                return true;
            }
            if (f16 >= 0.5d || this.mLastPoint == null) {
                return false;
            }
            sb5.append(",distance too low: ");
            sb5.append(fArr[0]);
            return true;
        }
        sb5.append(",speed too low: ");
        sb5.append(tracePointsData.speed);
        return true;
    }

    private boolean addKilosStepToVoice(ArrayList<String> arrayList, long j3, boolean z16) {
        double d16 = j3;
        if (isDigitValid(getKilos(d16))) {
            if (j3 < 10000 && ((int) ((j3 % 10000) / 1000)) == 2) {
                arrayList.add("2_liang");
            } else {
                arrayList.add(getKilos(d16));
            }
            arrayList.add("1000");
            return z16;
        }
        if (getKilos(d16) != null && Integer.parseInt(getKilos(d16)) == 0) {
            if (isDigitValid(getDecades(d16)) || isDigitValid(getTens(d16)) || isDigitValid(getOnes(d16))) {
                arrayList.add("0");
                return true;
            }
            return z16;
        }
        return z16;
    }

    private void addKmToVoice(boolean z16, ArrayList<String> arrayList, double d16) {
        if (!z16) {
            double floor = (long) Math.floor(d16 / 1000.0d);
            arrayList.add("yyd");
            if (getDecades(floor) != null) {
                arrayList.add(getDecades(floor));
                arrayList.add("100");
            }
            if (getTens(floor) != null && Integer.parseInt(getTens(floor)) != 0) {
                arrayList.add(getTens(floor));
                arrayList.add("10");
            }
            if (getOnes(floor) != null) {
                arrayList.add(getOnes(floor));
            }
            arrayList.add("km");
            return;
        }
        arrayList.add("yyd");
        kmToVoice(arrayList, d16);
    }

    private void addOnesTimeToVoice(ArrayList<String> arrayList, long j3) {
        double d16 = j3;
        if (getOnes(d16) != null) {
            arrayList.add(getOnes(d16));
        }
    }

    private void addPoint(TracePointsData tracePointsData, boolean z16, List<Entity> list) {
        ArrayList<TracePointsData> arrayList;
        if (z16) {
            list.add(tracePointsData);
            return;
        }
        TracePathData tracePathData = this.mPathTrace;
        if (tracePathData != null && tracePathData.distance < 10.0d && (arrayList = this.mOriginnalPoints) != null) {
            arrayList.add(tracePointsData);
        }
        try {
            new JSONObject().put("retCode", 1);
            if (this.mPathTrace != null) {
                drawPathTrace(null);
            }
        } catch (Exception unused) {
            QLog.i(TAG, 1, "no singnal step");
        }
    }

    private void addTensStepToVoice(ArrayList<String> arrayList, long j3, boolean z16) {
        double d16 = j3;
        if (isDigitValid(getTens(d16))) {
            arrayList.add(getTens(d16));
            arrayList.add("10");
        } else if (getTens(d16) != null && Integer.parseInt(getTens(d16)) == 0 && !z16 && isDigitValid(getOnes(d16))) {
            arrayList.add("0");
        }
    }

    private void addTensTimeToVoice(ArrayList<String> arrayList, long j3) {
        double d16 = j3;
        if (getTens(d16) != null) {
            arrayList.add(getTens(d16));
            arrayList.add("10");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeFileInputStream(FileInputStream fileInputStream) {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    private void dispatchPathTraceJsEvent(JSONObject jSONObject, WebViewPlugin webViewPlugin) {
        if (webViewPlugin != null) {
            webViewPlugin.dispatchJsEvent("PathTraceEnd", jSONObject, new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawPathTrace(List<TracePointsData> list) {
        WebViewPlugin webViewPlugin;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Element.ELEMENT_NAME_DISTANCE, this.mPathTrace.distance);
            jSONObject2.put("totalTime", this.mPathTrace.totalTime);
            jSONObject2.put("totalSteps", this.mPathTrace.totalSteps);
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    jSONArray.mo162put(list.get(i3).toJson());
                }
            }
            jSONObject2.put("tracePath", jSONArray);
            jSONObject.put("data", jSONObject2.toString());
            WeakReference<WebViewPlugin> weakReference = this.mPathTracePlug;
            if (weakReference != null && (webViewPlugin = weakReference.get()) != null) {
                webViewPlugin.dispatchJsEvent("PathTraceSend", jSONObject, new JSONObject());
            }
        } catch (Exception unused) {
            QLog.d(TAG, 1, "draw Err");
        }
    }

    private JSONObject drawPoint(TracePointsData tracePointsData) {
        String str;
        WebViewPlugin webViewPlugin;
        JSONObject jSONObject = new JSONObject();
        if (tracePointsData == null) {
            return jSONObject;
        }
        try {
            JSONObject json = tracePointsData.toJson();
            jSONObject.put("retCode", 1);
            if (json != null) {
                str = json.toString();
            } else {
                str = "";
            }
            jSONObject.put("data", str);
            jSONObject.put("isBeforeRunning", "true");
            WeakReference<WebViewPlugin> weakReference = this.mPathTracePlug;
            if (weakReference != null && (webViewPlugin = weakReference.get()) != null) {
                webViewPlugin.dispatchJsEvent("PathTraceSend", jSONObject, new JSONObject());
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private float getCoefficient(TracePointsData tracePointsData) {
        int i3 = tracePointsData.accuracy;
        if (i3 >= sIntervalDistanceMax) {
            return 0.2f;
        }
        if (i3 <= sIntervalDistance) {
            return 1.0f;
        }
        return Float.valueOf(r0 - i3).floatValue() / (sIntervalDistanceMax - sIntervalDistance);
    }

    private double getMeantime(TracePathData tracePathData, boolean z16, long j3) {
        Float valueOf = Float.valueOf(1000.0f);
        if (!z16 && ((int) (tracePathData.distance / valueOf.floatValue())) == 1) {
            return j3;
        }
        return j3 / (tracePathData.distance / valueOf.floatValue());
    }

    public static byte[] gzip(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th6) {
            th = th6;
            try {
                QLog.e(TAG, 1, th, new Object[0]);
                if (byteArrayOutputStream == null) {
                    return null;
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable unused) {
                if (byteArrayOutputStream == null) {
                    return null;
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLocation(TracePointsData tracePointsData) {
        int i3 = this.mWorkingMode;
        if (i3 <= 0) {
            drawPoint(tracePointsData);
            QLog.i(TAG, 1, "drawPoint: " + tracePointsData.toString());
            return;
        }
        if (i3 == 1) {
            handleRunningLocation(tracePointsData);
            return;
        }
        stopLocation(-1, "");
        stopPathTraceService();
        QLog.e(TAG, 1, "WorkMode Err :" + this.mWorkingMode);
    }

    private void handleRunningLocation(TracePointsData tracePointsData) {
        setPointDebug(tracePointsData);
        if (this.mPathTrace == null) {
            QLog.e(TAG, 1, "dowhile Err");
        } else {
            setPointSteps(tracePointsData);
        }
        StringBuilder sb5 = new StringBuilder("drawPathTrace: ");
        sb5.append(tracePointsData.toString());
        TracePathData tracePathData = this.mPathTrace;
        boolean z16 = false;
        if (tracePathData == null) {
            QLog.e(TAG, 1, "DoWhile Err");
        } else {
            tracePointsData.startTime = tracePathData.startTime;
            tracePathData.endTime = NetConnInfoCenter.getServerTime();
            setTotalTime(tracePointsData);
            this.mIntervalTime = NetConnInfoCenter.getServerTime();
            this.mPathTrace.isStop = 2;
            float[] fArr = new float[1];
            setPointByLast(tracePointsData, sb5, fArr);
            TracePointsData tracePointsData2 = this.mLastPoint;
            if (tracePointsData2 != null) {
                tracePointsData2.time = tracePointsData.time;
            }
            if (!setPointByOriginal(tracePointsData, sb5, fArr)) {
                Double valueOf = Double.valueOf(this.mPathTrace.distance);
                TracePathData tracePathData2 = this.mPathTrace;
                double d16 = tracePathData2.distance + fArr[0];
                tracePathData2.distance = d16;
                if (tracePathData2.type == 0 && Math.floor(d16 / 1000.0d) - Math.floor(valueOf.doubleValue() / 1000.0d) > 0.0d) {
                    runVoiceBroadCast(this.mPathTrace, false, tracePointsData);
                }
                this.mLastPoint = tracePointsData;
                this.mToolong = true;
                this.mSpeedRule = true;
                this.mPathTrace.totalSteps = tracePointsData.steps;
                this.tempPointList.clear();
                this.tempPointList.add(tracePointsData);
                drawPathTrace(this.tempPointList);
                z16 = true;
            }
        }
        final List<Entity> arrayList = new ArrayList<>(2);
        if (this.mPathTrace != null) {
            TracePathData tracePathData3 = new TracePathData();
            TracePathData tracePathData4 = this.mPathTrace;
            tracePathData3.startTime = tracePathData4.startTime;
            tracePathData3.type = tracePathData4.type;
            tracePathData3.distance = tracePathData4.distance;
            tracePathData3.endTime = tracePathData4.endTime;
            tracePathData3.totalTime = tracePathData4.totalTime;
            tracePathData3.isStop = tracePathData4.isStop;
            tracePathData3.totalSteps = tracePathData4.totalSteps;
            tracePathData3.stepsGoal = tracePathData4.stepsGoal;
            arrayList.add(tracePathData3);
            sb5.append(",totalTime: ");
            sb5.append(this.mPathTrace.totalTime);
            sb5.append(",total distance: ");
            sb5.append(this.mPathTrace.distance);
        }
        addPoint(tracePointsData, z16, arrayList);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                PathTraceManagerImpl.this.bulkUpdateEntitys(arrayList);
            }
        }, 32, null, true);
        if (this.mPathTrace != null && Build.VERSION.SDK_INT >= 25) {
            Intent intent = new Intent();
            intent.setAction(PathTraceService.C);
            intent.putExtra(PathTraceService.D, this.mWorkingMode);
            intent.putExtra(PathTraceService.E, this.mPathTrace.totalTime);
            intent.putExtra(PathTraceService.F, this.mPathTrace.distance);
            this.mApp.getApp().getApplicationContext().sendBroadcast(intent);
        }
        overTime();
        QLog.i(TAG, 1, sb5.toString());
    }

    private boolean isDigitValid(String str) {
        if (str != null && Integer.parseInt(str) != 0) {
            return true;
        }
        return false;
    }

    private void kmToVoice(ArrayList<String> arrayList, double d16) {
        double floatValue = d16 / Float.valueOf(1000.0f).floatValue();
        if (getDecades(floatValue) != null) {
            arrayList.add(getDecades(floatValue));
            arrayList.add("100");
        }
        if (getTens(floatValue) != null) {
            arrayList.add(getTens(floatValue));
            arrayList.add("10");
        }
        if (getOnes(floatValue) != null) {
            arrayList.add(getOnes(floatValue));
        }
        arrayList.add("d");
        if (getZeroOnes(floatValue) != null) {
            arrayList.add(getZeroOnes(floatValue));
        }
        if (getZeroTwos(floatValue) != null) {
            arrayList.add(getZeroTwos(floatValue));
        }
        arrayList.add("km");
    }

    private void overTime() {
        WebViewPlugin webViewPlugin;
        TracePathData tracePathData = this.mPathTrace;
        if (tracePathData != null && tracePathData.totalTime > JoinTimeType.SIX_HOUR) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retCode", -6);
                WeakReference<WebViewPlugin> weakReference = this.mPathTracePlug;
                if (weakReference != null && (webViewPlugin = weakReference.get()) != null) {
                    webViewPlugin.dispatchJsEvent("PathTraceEnd", jSONObject, new JSONObject());
                    QLog.i(TAG, 1, "LONG END");
                }
            } catch (Exception unused) {
                QLog.i(TAG, 1, "TooLong Err");
            }
            pathTraceEnd(JoinTimeType.SIX_HOUR, "");
        }
    }

    public static void pathTraceConsectivePlay(ArrayList<Uri> arrayList) {
        MediaPlayer mediaPlayer;
        FileInputStream fileInputStream = null;
        try {
            try {
                MediaPlayer mediaPlayer2 = mediaPalyer;
                if (mediaPlayer2 != null) {
                    if (mediaPlayer2.isPlaying()) {
                        closeFileInputStream(null);
                        return;
                    } else {
                        MediaPlayer mediaPlayer3 = mediaPalyer;
                        if (mediaPlayer3 != null) {
                            mediaPlayer3.release();
                        }
                    }
                }
                mVoiceIndex = 0;
                Uri uri = arrayList.get(0);
                if (uri.getScheme().equals("file")) {
                    mediaPalyer = new ReportMediaPlayer();
                    FileInputStream fileInputStream2 = new FileInputStream(new File(uri.getPath()));
                    try {
                        mediaPalyer.setDataSource(fileInputStream2.getFD());
                        mediaPalyer.prepare();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        closeFileInputStream(fileInputStream);
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        closeFileInputStream(fileInputStream);
                        throw th;
                    }
                }
                mediaPlayer = mediaPalyer;
            } catch (Exception e17) {
                e = e17;
            }
            if (mediaPlayer == null) {
                closeFileInputStream(fileInputStream);
                return;
            }
            mediaPlayer.setOnCompletionListener(new d(arrayList));
            mediaPalyer.start();
            mediaPalyer.setLooping(false);
            closeFileInputStream(fileInputStream);
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private boolean pathTraceTooShort() {
        TracePathData tracePathData = this.mPathTrace;
        if (tracePathData.totalTime >= 60 && tracePathData.distance >= 100.0d) {
            return false;
        }
        return true;
    }

    private void setPointByLast(TracePointsData tracePointsData, StringBuilder sb5, float[] fArr) {
        if (this.mLastPoint != null) {
            Location.distanceBetween(tracePointsData.latitude, tracePointsData.longitude, r3.latitude, r3.longitude, fArr);
            sb5.append(",interval: ");
            sb5.append(fArr[0]);
            float f16 = fArr[0];
            if (f16 > sIntervalDistance && f16 < sIntervalDistanceMax) {
                float coefficient = getCoefficient(tracePointsData);
                float f17 = tracePointsData.latitude * coefficient;
                TracePointsData tracePointsData2 = this.mLastPoint;
                float f18 = 1.0f - coefficient;
                float f19 = f17 + (tracePointsData2.latitude * f18);
                tracePointsData.latitude = f19;
                float f26 = (tracePointsData.longitude * coefficient) + (tracePointsData2.longitude * f18);
                tracePointsData.longitude = f26;
                Location.distanceBetween(f19, f26, tracePointsData2.latitude, tracePointsData2.longitude, fArr);
                sb5.append(",Mis distance:" + fArr[0] + ",coefficient:" + coefficient);
                this.mSpeedRule = false;
                return;
            }
            this.mSpeedRule = true;
        }
    }

    private boolean setPointByOriginal(TracePointsData tracePointsData, StringBuilder sb5, float[] fArr) {
        ArrayList<TracePointsData> arrayList;
        if (this.mPathTrace.distance < 10.0d && (arrayList = this.mOriginnalPoints) != null && arrayList.size() >= 5) {
            float f16 = 0.0f;
            float f17 = 0.0f;
            for (int i3 = 0; i3 < this.mOriginnalPoints.size(); i3++) {
                f16 += this.mOriginnalPoints.get(i3).latitude;
                f17 += this.mOriginnalPoints.get(i3).longitude;
            }
            tracePointsData.latitude = f16 / this.mOriginnalPoints.size();
            tracePointsData.longitude = f17 / this.mOriginnalPoints.size();
            QLog.d(TAG, 1, "mOriginnalPoints HAPPEND:" + this.mOriginnalPoints.toString());
            this.mOriginnalPoints.clear();
        } else if (addErrDataToLogStr(tracePointsData, sb5, fArr)) {
            return true;
        }
        return false;
    }

    private void setPointDebug(TracePointsData tracePointsData) {
        if (this.debug) {
            TracePointsData tracePointsData2 = this.mLastPoint;
            if (tracePointsData2 != null) {
                tracePointsData.latitude = tracePointsData2.latitude + ((float) (Math.random() * 3.0E-4d));
                tracePointsData.longitude = this.mLastPoint.longitude + ((float) (Math.random() * 3.0E-4d));
            }
            tracePointsData.speed = 3.0f;
            tracePointsData.altitude = 8.8d;
            tracePointsData.accuracy = 41;
        }
    }

    private void setPointSteps(TracePointsData tracePointsData) {
        if (this.mStepSensor == null) {
            int i3 = (int) (this.mPathTrace.distance / 0.65d);
            float[] fArr = new float[1];
            if (this.mLastPoint != null) {
                Location.distanceBetween(tracePointsData.latitude, tracePointsData.longitude, r4.latitude, r4.longitude, fArr);
            }
            int i16 = (int) ((this.mPathTrace.distance + fArr[0]) / 0.65d);
            if (this.debug) {
                tracePointsData.steps += (int) (Math.random() * 20.0d);
            } else {
                tracePointsData.steps = i16;
            }
            TracePathData tracePathData = this.mPathTrace;
            if (tracePathData.type == 1) {
                int i17 = tracePathData.stepsGoal;
                if (i3 < i17 && tracePathData.totalSteps >= i17) {
                    stepVoiceBroadCast(tracePathData, false, true);
                    return;
                } else {
                    if (Math.floor(tracePathData.totalSteps / 1000) - Math.floor(i3 / 1000) > 0.0d) {
                        stepVoiceBroadCast(this.mPathTrace, false, false);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        tracePointsData.steps = this.mPathTrace.totalSteps;
    }

    private void setStepListener() {
        this.mSteplistener = new b();
    }

    private void setStepVoice(ArrayList<String> arrayList, int i3) {
        double d16 = i3;
        if (isDigitValid(getTenThousands(d16))) {
            if ((i3 % 100000) / 10000 == 2) {
                arrayList.add("2_liang");
            } else {
                arrayList.add(getTenThousands(d16));
            }
            arrayList.add(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
        }
        if (isDigitValid(getKilos(d16))) {
            if (i3 < 10000 && (i3 % 10000) / 1000 == 2) {
                arrayList.add("2_liang");
            } else {
                arrayList.add(getKilos(d16));
            }
            arrayList.add("1000");
        }
        arrayList.add("step");
    }

    private void setTotalTime(TracePointsData tracePointsData) {
        long j3;
        TracePointsData tracePointsData2 = this.mLastPoint;
        if (tracePointsData2 == null && this.mIntervalTime != 0) {
            TracePathData tracePathData = this.mPathTrace;
            tracePathData.totalTime = (tracePathData.totalTime + NetConnInfoCenter.getServerTime()) - this.mIntervalTime;
            return;
        }
        TracePathData tracePathData2 = this.mPathTrace;
        long j16 = tracePathData2.totalTime;
        if (tracePointsData2 == null) {
            j3 = 2;
        } else {
            j3 = tracePointsData.time - tracePointsData2.time;
        }
        tracePathData2.totalTime = j16 + j3;
    }

    private void setVoiceBroadCast() {
        TracePathData tracePathData = this.mPathTrace;
        int i3 = tracePathData.type;
        if (i3 == 0) {
            runVoiceBroadCast(tracePathData, true, null);
        } else if (i3 == 1) {
            stepVoiceBroadCast(tracePathData, true, false);
        }
    }

    public void bulkUpdateEntitys(List<Entity> list) {
        if (list != null && list.size() != 0) {
            EntityManager entityManager = this.mEntityManager;
            if (entityManager != null && entityManager.isOpen()) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Entity entity : list) {
                        if (entity.getStatus() == 1000) {
                            arrayList.add(new PersistOrReplaceTransaction(entity));
                        } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                            arrayList.add(new UpdateTransaction(entity));
                        }
                    }
                    this.mEntityManager.doMultiDBOperateByTransaction(arrayList);
                    return;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "bulkUpdate Err: " + e16.getMessage());
                    return;
                }
            }
            QLog.e(TAG, 1, "mEntityManager is null, cancel operate");
        }
    }

    public void downloadVoice(String str) {
        File file;
        String str2 = this.internalSavePath + "audio715.zip";
        if (!FileUtils.fileExists(str2)) {
            file = new File(this.internalSavePath, "audio715.zip");
            this.mVoiceAllFiles = false;
        } else {
            file = null;
        }
        if (this.mVoiceAllFiles) {
            return;
        }
        g gVar = new g(BASE_URL, file);
        gVar.X = false;
        gVar.W = true;
        if (this.mDownloaderInterface == null) {
            this.mDownloaderInterface = ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1);
        }
        h hVar = this.mDownloaderInterface;
        if (hVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "loaderInterface Null");
                return;
            }
            return;
        }
        hVar.startDownload(gVar, new c(str2, str), null);
    }

    public List<TracePointsData> getAllTracePointByStartTime(long j3) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        List rawQuery = DBMethodProxy.rawQuery(this.mEntityManager, TracePointsData.class, "SELECT * FROM TracePointsData WHERE startTime = " + j3, null);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getAllTracePointByStartTime  size: ");
        if (rawQuery != null) {
            i3 = rawQuery.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append(", cost: ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        QLog.i(TAG, 1, sb5.toString());
        return rawQuery;
    }

    String getDecades(double d16) {
        if (d16 >= 100.0d) {
            return String.valueOf((int) ((d16 % 1000.0d) / 100.0d));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public int getEngineWorkingMode() {
        return this.mWorkingMode;
    }

    String getHours(long j3) {
        if (j3 >= 3600) {
            return String.valueOf((int) (j3 / 3600));
        }
        return null;
    }

    String getKilos(double d16) {
        if (d16 >= 1000.0d) {
            return String.valueOf((int) ((d16 % 10000.0d) / 1000.0d));
        }
        return null;
    }

    String getMinutes(long j3) {
        if (j3 >= 60) {
            return String.valueOf((int) ((j3 % 3600) / 60));
        }
        return null;
    }

    String getOnes(double d16) {
        if (getTens(d16) != null && ((int) (d16 % 10.0d)) == 0) {
            return null;
        }
        return String.valueOf((int) (d16 % 10.0d));
    }

    public TracePathData getPathTraceByTime(long j3) {
        List<Entity> rawQuery = DBMethodProxy.rawQuery(this.mEntityManager, TracePathData.class, "SELECT * FROM TracePathData WHERE startTime = " + j3, null);
        if (rawQuery == null) {
            return null;
        }
        return (TracePathData) rawQuery.get(0);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public int getRunningStatus() {
        int i3 = this.mWorkingMode;
        if (i3 <= 0) {
            TracePathData lastUnCompletedTrace = getLastUnCompletedTrace();
            this.mPathTrace = lastUnCompletedTrace;
            if (lastUnCompletedTrace != null) {
                return 2;
            }
            return 0;
        }
        return i3;
    }

    String getSeconds(long j3) {
        if (j3 >= 0) {
            return String.valueOf((int) (j3 % 60));
        }
        return null;
    }

    String getTenThousands(double d16) {
        if (d16 >= 10000.0d) {
            return String.valueOf((int) ((d16 % 100000.0d) / 10000.0d));
        }
        return null;
    }

    String getTens(double d16) {
        if (d16 >= 10.0d) {
            return String.valueOf((int) ((d16 % 100.0d) / 10.0d));
        }
        return null;
    }

    String getZeroOnes(double d16) {
        return String.valueOf((int) ((d16 * 10.0d) % 10.0d));
    }

    String getZeroTwos(double d16) {
        int i3 = (int) ((d16 * 100.0d) % 10.0d);
        if (i3 != 0) {
            return String.valueOf(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public boolean isRunning() {
        if (this.mWorkingMode == 1) {
            return true;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        this.mEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        this.mWorkingMode = -1;
        this.mPluginInterfaceLoadedListener = new a();
        PluginInterfaceHelper.getPluginInterface(this.mApp.getApp(), this.mPluginInterfaceLoadedListener);
        this.mPathTrace = getLastUnCompletedTrace();
        this.internalSavePath = this.mApp.getApp().getFilesDir().getPath() + "/QQSportVoice/";
        downloadVoice(null);
        SensorManager sensorManager = (SensorManager) this.mApp.getApp().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.mStepManager = sensorManager;
        this.mStepSensor = SensorMonitor.getDefaultSensor(sensorManager, 19);
        setStepListener();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("path:");
            Object obj = this.mPathTrace;
            if (obj == null) {
                obj = "null";
            }
            sb5.append(obj);
            QLog.i(TAG, 2, sb5.toString());
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        stopLocation(-1, "");
        stopPathTraceService();
        removeSportBar();
        AudioUtil.s();
        stepDetectEnd();
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public boolean pathTraceDelete(Long l3) {
        WebViewPlugin webViewPlugin;
        DBMethodProxy.execSQL(this.mEntityManager, "DELETE FROM TracePathData WHERE startTime = " + l3);
        boolean execSQL = DBMethodProxy.execSQL(this.mEntityManager, "DELETE FROM TracePointsData WHERE time IN (SELECT time FROM TracePointsData WHERE startTime =" + l3 + ")");
        try {
            JSONObject jSONObject = new JSONObject();
            if (execSQL) {
                jSONObject.put("retCode", 1);
            } else {
                jSONObject.put("retCode", -8);
            }
            WeakReference<WebViewPlugin> weakReference = this.mPathTracePlug;
            if (weakReference != null) {
                webViewPlugin = weakReference.get();
            } else {
                webViewPlugin = null;
            }
            if (webViewPlugin != null) {
                webViewPlugin.dispatchJsEvent("PathTraceDelete", jSONObject, new JSONObject());
            }
        } catch (JSONException unused) {
            QLog.d(TAG, 1, "PathTraceDelete Err");
        }
        return execSQL;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public boolean pathTraceEnd(long j3, String str) {
        WebViewPlugin webViewPlugin;
        stopLocation(-1, str);
        stopPathTraceService();
        removeSportBar();
        if (this.mPathTrace == null) {
            this.mPathTrace = getLastUnCompletedTrace();
        }
        if (this.mPathTrace != null) {
            this.mApp.getApplication().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().remove(String.valueOf(this.mPathTrace.startTime)).commit();
        }
        if (this.mPathTrace == null) {
            QLog.e(TAG, 1, "pathTraceEnd Err");
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        WeakReference<WebViewPlugin> weakReference = this.mPathTracePlug;
        if (weakReference != null) {
            webViewPlugin = weakReference.get();
        } else {
            webViewPlugin = null;
        }
        if (pathTraceTooShort()) {
            try {
                jSONObject.put("retCode", -5);
                dispatchPathTraceJsEvent(jSONObject, webViewPlugin);
                pathTraceDelete(Long.valueOf(this.mPathTrace.startTime));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return false;
        }
        this.mPathTrace.totalTime = j3;
        this.mUploadTime = j3;
        setVoiceBroadCast();
        TracePathData tracePathData = this.mPathTrace;
        tracePathData.isStop = 1;
        tracePathData.endTime = NetConnInfoCenter.getServerTime();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mPathTrace);
        bulkUpdateEntitys(arrayList);
        try {
            jSONObject.put("retCode", 1);
            dispatchPathTraceJsEvent(jSONObject, webViewPlugin);
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        stepDetectEnd();
        return true;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void pathTracePause(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("pause");
        pathTraceVoicePlay(arrayList);
        boolean z16 = false;
        if (this.mLastPoint != null) {
            this.mApp.getApplication().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().putFloat("search_lbs_logitude", this.mLastPoint.longitude).putFloat("search_lbs_latitude", this.mLastPoint.latitude).putLong("search_lbs_timestamp", System.currentTimeMillis()).apply();
        }
        this.mLastPoint = null;
        stopLocation(2, str);
        stopPathTraceService();
        TracePathData tracePathData = this.mPathTrace;
        if (tracePathData != null) {
            if (this.mIntervalTime != 0) {
                tracePathData.totalTime = (tracePathData.totalTime + NetConnInfoCenter.getServerTime()) - this.mIntervalTime;
            }
            this.mPathTrace.isStop = 3;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.mPathTrace);
            bulkUpdateEntitys(arrayList2);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pathTracePause:");
        if (this.mPathTrace == null) {
            z16 = true;
        }
        sb5.append(z16);
        QLog.i(TAG, 1, sb5.toString());
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public JSONObject pathTraceQuery() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        List<? extends Entity> query = this.mEntityManager.query(TracePathData.class);
        try {
            jSONObject.put("retCode", 1);
            if (query != null && query.size() > 0) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    TracePathData tracePathData = (TracePathData) it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("startTime", tracePathData.startTime);
                    jSONObject2.put("endTime", tracePathData.endTime);
                    jSONObject2.put("totalTime", tracePathData.totalTime);
                    jSONObject2.put("totalSteps", tracePathData.totalSteps);
                    jSONObject2.put(Element.ELEMENT_NAME_DISTANCE, tracePathData.distance);
                    jSONObject2.put("type", tracePathData.type);
                    jSONArray.mo162put(jSONObject2);
                }
                jSONObject.put("data", jSONArray);
            } else {
                jSONObject.put("retCode", 1);
                jSONObject.put("data", jSONArray);
            }
        } catch (JSONException unused) {
            QLog.d(TAG, 1, "PathTraceQuery Err");
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void pathTraceResume(String str) {
        if (this.mPathTrace == null) {
            this.mPathTrace = getLastUnCompletedTrace();
        }
        this.mIntervalTime = NetConnInfoCenter.getServerTime();
        stepDetectStart();
        if (this.mPathTrace != null) {
            startLocation(1, str);
            startPathTraceService();
        } else {
            QLog.e(TAG, 1, "pathTraceResume Err");
        }
        this.mLastSteps = 0;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void pathTraceUpload(long j3, String str) {
        ThreadManagerV2.executeOnNetWorkThread(new DataUploadTask(j3, str));
    }

    public void pathTraceVoicePlay(ArrayList<String> arrayList) {
        QLog.d(TAG, 1, "internalSavePath:" + this.internalSavePath);
        if (!this.mIsMute) {
            boolean z16 = true;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (!FileUtils.fileExists(this.internalSavePath + arrayList.get(i3) + DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)) {
                    if (arrayList.size() == 1) {
                        downloadVoice(arrayList.get(0));
                    } else {
                        downloadVoice(null);
                    }
                    z16 = false;
                }
            }
            if (z16) {
                if (arrayList.size() == 1) {
                    AudioUtil.p(Uri.fromFile(new File(this.internalSavePath + arrayList.get(0) + DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)), false, true);
                    return;
                }
                final ArrayList arrayList2 = new ArrayList();
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    arrayList2.add(Uri.fromFile(new File(this.internalSavePath + arrayList.get(i16) + DefaultHlsExtractorFactory.MP3_FILE_EXTENSION)));
                }
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        PathTraceManagerImpl.pathTraceConsectivePlay(arrayList2);
                    }
                }, 5, null, false);
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "play mute");
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public JSONObject queryPathData(String str) {
        TracePathData lastUnCompletedTrace;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (str != null) {
                lastUnCompletedTrace = getPathTraceByTime(Long.parseLong(new JSONObject(str).getString("startTime")));
            } else {
                lastUnCompletedTrace = getLastUnCompletedTrace();
            }
            if (lastUnCompletedTrace != null) {
                String valueOf = String.valueOf(lastUnCompletedTrace.startTime);
                jSONObject.put("startTime", lastUnCompletedTrace.startTime);
                jSONObject.put("endTime", lastUnCompletedTrace.endTime);
                jSONObject.put("totalTime", lastUnCompletedTrace.totalTime);
                jSONObject.put(Element.ELEMENT_NAME_DISTANCE, lastUnCompletedTrace.distance);
                jSONObject.put("type", lastUnCompletedTrace.type);
                jSONObject.put("totalSteps", lastUnCompletedTrace.totalSteps);
                jSONObject.put("stepsGoal", lastUnCompletedTrace.stepsGoal);
                List<TracePointsData> allTracePointByStartTime = getAllTracePointByStartTime(Long.parseLong(valueOf));
                if (allTracePointByStartTime != null && allTracePointByStartTime.size() > 0) {
                    for (TracePointsData tracePointsData : allTracePointByStartTime) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("time", tracePointsData.time);
                        jSONObject2.put("longitude", tracePointsData.longitude);
                        jSONObject2.put("latitude", tracePointsData.latitude);
                        jSONObject2.put("altitude", tracePointsData.altitude);
                        jSONObject2.put("speed", tracePointsData.speed);
                        jSONObject2.put("accuracy", tracePointsData.accuracy);
                        jSONObject2.put("steps", tracePointsData.steps);
                        jSONArray.mo162put(jSONObject2);
                    }
                }
                jSONObject.put("data", jSONArray);
            }
        } catch (Exception unused) {
            QLog.d(TAG, 1, "queryPathData Err");
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void registerWebViewPlug(WebViewPlugin webViewPlugin) {
        this.mPathTracePlug = new WeakReference<>(webViewPlugin);
    }

    public void removeSportBar() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((IQQHealthApi) QRoute.apiIPCSync(IQQHealthApi.class)).hideBanner();
                } catch (Exception e16) {
                    QLog.e(PathTraceManagerImpl.TAG, 1, e16, "fail to hide banner");
                }
            }
        });
        QLog.i(TAG, 1, "removeSportBar");
    }

    protected void runVoiceBroadCast(TracePathData tracePathData, boolean z16, TracePointsData tracePointsData) {
        ArrayList<String> arrayList = new ArrayList<>();
        double d16 = tracePathData.distance;
        if (z16) {
            arrayList.add("end");
        }
        addKmToVoice(z16, arrayList, d16);
        long j3 = tracePathData.totalTime;
        arrayList.add("ys");
        timeToVoice(arrayList, j3);
        if (!z16) {
            SharedPreferences sharedPreferences = this.mApp.getApplication().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0);
            SharedPreferences sharedPreferences2 = this.mApp.getApplication().getSharedPreferences(String.valueOf(tracePathData.startTime), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
            if (((int) (tracePathData.distance / 1000.0d)) == 1) {
                arrayList.add("zjps");
                timeToVoice(arrayList, j3);
                edit.putLong(String.valueOf(tracePathData.startTime), tracePathData.totalTime);
                if (tracePointsData != null) {
                    edit2.putString("1", String.valueOf(j3) + "," + String.valueOf(tracePointsData.latitude) + "," + String.valueOf(tracePointsData.longitude));
                } else {
                    edit2.putString("1", String.valueOf(j3) + ",0,0");
                }
                edit2.putLong(String.valueOf(LAST_TIME), tracePathData.totalTime).putFloat(String.valueOf(LAST_DISTANCE), (float) tracePathData.distance);
            } else {
                long j16 = sharedPreferences.getLong(String.valueOf(tracePathData.startTime), 0L);
                if (j16 != 0) {
                    arrayList.add("zjps");
                    timeToVoice(arrayList, tracePathData.totalTime - j16);
                    if (tracePointsData != null) {
                        edit2.putString(String.valueOf((int) (tracePathData.distance / 1000.0d)), String.valueOf(tracePathData.totalTime - j16) + "," + String.valueOf(tracePointsData.latitude) + "," + String.valueOf(tracePointsData.longitude));
                    }
                    edit2.putLong(String.valueOf(LAST_TIME), tracePathData.totalTime).putFloat(String.valueOf(LAST_DISTANCE), Float.valueOf(String.valueOf(tracePathData.distance)).floatValue());
                    edit.putLong(String.valueOf(tracePathData.startTime), tracePathData.totalTime);
                }
            }
            edit.commit();
            edit2.commit();
        }
        arrayList.add("pjps");
        timeToVoice(arrayList, (long) getMeantime(tracePathData, z16, j3));
        if (!z16) {
            arrayList.add("jxjy");
            pathTraceVoicePlay(arrayList);
        }
        if (z16) {
            arrayList.add("jsy");
            pathTraceVoicePlay(arrayList);
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            QLog.d(TAG, 1, "psvoice:" + arrayList.get(i3));
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void setIgnoreSpeed(boolean z16) {
        this.mIgnoreSpeed = z16;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void setIsMute(boolean z16) {
        this.mIsMute = z16;
    }

    public void showSportBar(final int i3, String str) {
        final String replace;
        if (!TextUtils.isEmpty(str)) {
            if (Uri.parse(str).getQuery() != null) {
                if (Uri.parse(str).getQueryParameter("ADTAG") == null) {
                    str = str + "&ADTAG=aio.run.click&from=bar";
                }
            } else if (Uri.parse(str).getQueryParameter("ADTAG") == null) {
                str = str + "?ADTAG=aio.run.click&from=bar";
            }
            if (!str.contains("runningState")) {
                if (Uri.parse(str).getQuery() != null) {
                    replace = str + "&runningState=" + i3;
                } else {
                    replace = str + "?runningState=" + i3;
                }
            } else {
                replace = str.replace("runningState=" + Uri.parse(str).getQueryParameter("runningState"), "runningState=" + i3);
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ((IQQHealthApi) QRoute.apiIPCSync(IQQHealthApi.class)).showBanner(i3, replace);
                    } catch (Exception e16) {
                        QLog.e(PathTraceManagerImpl.TAG, 1, e16, "fail to show banner");
                    }
                }
            });
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "showSportBar url\uff1a" + replace);
            }
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void startLocation(int i3, String str) {
        boolean z16;
        WebViewPlugin.b bVar;
        String str2;
        if (this.mPathTraceLocation == null) {
            this.mPathTraceLocation = new f((AppInterface) this.mApp);
        }
        this.mWorkingMode = i3;
        ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.mPathTraceLocation);
        if (this.mWorkingMode == 1) {
            WeakReference<WebViewPlugin> weakReference = this.mPathTracePlug;
            if (weakReference != null && weakReference.get() != null) {
                WebViewPlugin webViewPlugin = this.mPathTracePlug.get();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("1: startLocation ");
                if (webViewPlugin.mRuntime != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.i(TAG, 1, sb5.toString());
                if (TextUtils.isEmpty(str) && (bVar = webViewPlugin.mRuntime) != null) {
                    if (bVar.f() != null) {
                        str2 = webViewPlugin.mRuntime.f().getCurrentUrl();
                    } else {
                        str2 = null;
                    }
                    str = str2;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                showSportBar(this.mWorkingMode, str);
            }
        }
        QLog.i(TAG, 1, "startMode: " + this.mWorkingMode);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void startPathTrace(JSONObject jSONObject, String str) {
        QLog.i(TAG, 1, "startPathTrace");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("start");
        pathTraceVoicePlay(arrayList);
        this.mType = jSONObject.optInt("type");
        sAccuracy = jSONObject.optInt("accuracy");
        this.mStepGoal = jSONObject.optInt("stepGoal");
        if (sAccuracy == 0) {
            sAccuracy = 50;
        }
        try {
            TracePathData tracePathData = new TracePathData();
            tracePathData.startTime = NetConnInfoCenter.getServerTime();
            tracePathData.endTime = NetConnInfoCenter.getServerTime();
            tracePathData.type = this.mType;
            tracePathData.stepsGoal = this.mStepGoal;
            this.mIntervalTime = tracePathData.startTime;
            this.mPathTrace = tracePathData;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.mPathTrace);
            bulkUpdateEntitys(arrayList2);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
        startLocation(1, str);
        startPathTraceService();
        this.mLastSteps = 0;
        stepDetectStart();
    }

    public void startPathTraceService() {
        Context applicationContext = this.mApp.getApplicationContext();
        try {
            applicationContext.startService(new Intent(applicationContext, (Class<?>) PathTraceService.class));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "", th5);
            }
        }
    }

    public void stepDetectEnd() {
        SensorEventListener sensorEventListener;
        SensorManager sensorManager = this.mStepManager;
        if (sensorManager != null && (sensorEventListener = this.mSteplistener) != null) {
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    @TargetApi(19)
    public void stepDetectStart() {
        Sensor sensor = this.mStepSensor;
        if (sensor != null) {
            try {
                SensorMonitor.registerListener(this.mStepManager, this.mSteplistener, sensor, 3, 0);
                this.mStepManager.flush(this.mSteplistener);
                return;
            } catch (Exception unused) {
                QLog.d(TAG, 1, "detector API err");
                return;
            }
        }
        QLog.d(TAG, 1, "Step Unsupported");
    }

    void stepToVoice(ArrayList<String> arrayList, long j3) {
        double d16 = j3;
        if (getTenThousands(d16) != null) {
            if (((int) ((j3 % JsonGrayBusiId.UI_RESERVE_100000_110000) / 10000)) == 2) {
                arrayList.add("2_liang");
            } else {
                arrayList.add(getTenThousands(d16));
            }
            arrayList.add(MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
        }
        addTensStepToVoice(arrayList, j3, addDecadesStepToVoice(arrayList, j3, addKilosStepToVoice(arrayList, j3, false)));
        if (isDigitValid(getOnes(d16))) {
            arrayList.add(getOnes(d16));
        }
        arrayList.add("step");
    }

    protected void stepVoiceBroadCast(TracePathData tracePathData, boolean z16, boolean z17) {
        ArrayList<String> arrayList = new ArrayList<>();
        int i3 = tracePathData.totalSteps;
        if (!z16) {
            arrayList.add("yyd");
            if (z17) {
                stepToVoice(arrayList, tracePathData.stepsGoal);
            } else {
                setStepVoice(arrayList, i3);
            }
            arrayList.add("ys");
            timeToVoice(arrayList, tracePathData.totalTime);
            int i16 = tracePathData.stepsGoal;
            if (i16 == 0) {
                arrayList.add("jxjy");
                pathTraceVoicePlay(arrayList);
                return;
            }
            if (tracePathData.totalSteps < i16) {
                arrayList.add("hy");
                stepToVoice(arrayList, tracePathData.stepsGoal - ((tracePathData.totalSteps / 1000) * 1000));
                arrayList.add("goal_0");
                arrayList.add("jxjy");
                pathTraceVoicePlay(arrayList);
                return;
            }
            if (z17) {
                arrayList.add("goal_1");
                pathTraceVoicePlay(arrayList);
                return;
            } else {
                arrayList.add("jxjy");
                pathTraceVoicePlay(arrayList);
                return;
            }
        }
        arrayList.add("end");
        arrayList.add("bcyd");
        stepToVoice(arrayList, tracePathData.totalSteps);
        arrayList.add("empty_0_5s");
        kmToVoice(arrayList, tracePathData.distance);
        arrayList.add("ys");
        timeToVoice(arrayList, tracePathData.totalTime);
        if (tracePathData.totalSteps < 10000) {
            arrayList.add("jsy");
        } else {
            arrayList.add("guli_1");
        }
        pathTraceVoicePlay(arrayList);
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public void stopLocation(int i3, String str) {
        WeakReference<WebViewPlugin> weakReference;
        String str2;
        if (this.mPathTraceLocation != null) {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.mPathTraceLocation);
            this.mWorkingMode = i3;
            if (i3 == 2 && (weakReference = this.mPathTracePlug) != null && weakReference.get() != null) {
                WebViewPlugin webViewPlugin = this.mPathTracePlug.get();
                if (webViewPlugin != null && webViewPlugin.mRuntime != null && TextUtils.isEmpty(str)) {
                    if (webViewPlugin.mRuntime.f() != null) {
                        str2 = webViewPlugin.mRuntime.f().getCurrentUrl();
                    } else {
                        str2 = null;
                    }
                    str = str2;
                }
                if (!TextUtils.isEmpty(str)) {
                    showSportBar(this.mWorkingMode, str);
                }
            }
            QLog.i(TAG, 1, "stopMode:" + this.mWorkingMode);
        }
    }

    public void stopPathTraceService() {
        try {
            this.mApp.getApplicationContext().stopService(new Intent(this.mApp.getApplicationContext(), (Class<?>) PathTraceService.class));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "", th5);
            }
        }
        QLog.i(TAG, 1, "stopPathTraceService");
    }

    void timeToVoice(ArrayList<String> arrayList, long j3) {
        if (getHours(j3) != null) {
            long j16 = j3 / 3600;
            addDecadesTimeToVoice(arrayList, j16);
            addTensTimeToVoice(arrayList, j16);
            addOnesTimeToVoice(arrayList, j16);
            arrayList.add(WidgetCacheWeatherData.HOUR);
        }
        if (getMinutes(j3) != null) {
            long j17 = (j3 % 3600) / 60;
            addDecadesTimeToVoice(arrayList, j17);
            addTensTimeToVoice(arrayList, j17);
            addOnesTimeToVoice(arrayList, j17);
            arrayList.add(Element.ELEMENT_NAME_MIN);
        }
        if (getSeconds(j3) != null) {
            long j18 = j3 % 60;
            addDecadesTimeToVoice(arrayList, j18);
            if (j18 >= 10) {
                addTensTimeToVoice(arrayList, j18);
                addOnesTimeToVoice(arrayList, j18);
                arrayList.add("sec");
            } else if (j18 > 0) {
                arrayList.add("0");
                addOnesTimeToVoice(arrayList, j18);
                arrayList.add("sec");
            } else if (j18 == 0) {
                arrayList.add("0");
                arrayList.add("sec");
            }
        }
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public TracePathData getLastUnCompletedTrace() {
        List<Entity> rawQuery = DBMethodProxy.rawQuery(this.mEntityManager, TracePathData.class, "SELECT * FROM TracePathData WHERE isStop <> 1 order by startTime desc limit 1 ", null);
        if (rawQuery != null) {
            return (TracePathData) rawQuery.get(0);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vashealth.api.IPathTraceManager
    public TracePathData getPathTrace() {
        return this.mPathTrace;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements SensorEventListener {
        b() {
        }

        private void a() {
            PathTraceManagerImpl pathTraceManagerImpl = PathTraceManagerImpl.this;
            if (pathTraceManagerImpl.debug) {
                pathTraceManagerImpl.mPathTrace.totalSteps += (PathTraceManagerImpl.this.mSteps - PathTraceManagerImpl.this.mLastSteps) * ((int) (Math.random() * 20.0d));
            } else {
                pathTraceManagerImpl.mPathTrace.totalSteps += PathTraceManagerImpl.this.mSteps - PathTraceManagerImpl.this.mLastSteps;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            QLog.d(PathTraceManagerImpl.TAG, 1, "step Changed:" + sensorEvent.values[0]);
            if (PathTraceManagerImpl.this.mWorkingMode == 1) {
                PathTraceManagerImpl.this.mSteps = (int) sensorEvent.values[0];
                if (PathTraceManagerImpl.this.mPathTrace != null && PathTraceManagerImpl.this.mSteps > PathTraceManagerImpl.this.mLastSteps && PathTraceManagerImpl.this.mLastSteps != 0) {
                    int i3 = PathTraceManagerImpl.this.mPathTrace.totalSteps;
                    a();
                    PathTraceManagerImpl pathTraceManagerImpl = PathTraceManagerImpl.this;
                    pathTraceManagerImpl.mLastSteps = pathTraceManagerImpl.mSteps;
                    PathTraceManagerImpl.this.drawPathTrace(null);
                    if (PathTraceManagerImpl.this.mPathTrace.type == 1) {
                        if (i3 < PathTraceManagerImpl.this.mPathTrace.stepsGoal && PathTraceManagerImpl.this.mPathTrace.totalSteps >= PathTraceManagerImpl.this.mPathTrace.stepsGoal) {
                            PathTraceManagerImpl pathTraceManagerImpl2 = PathTraceManagerImpl.this;
                            pathTraceManagerImpl2.stepVoiceBroadCast(pathTraceManagerImpl2.mPathTrace, false, true);
                            return;
                        } else {
                            if (Math.floor(PathTraceManagerImpl.this.mPathTrace.totalSteps / 1000) - Math.floor(i3 / 1000) > 0.0d) {
                                PathTraceManagerImpl pathTraceManagerImpl3 = PathTraceManagerImpl.this;
                                pathTraceManagerImpl3.stepVoiceBroadCast(pathTraceManagerImpl3.mPathTrace, false, false);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (PathTraceManagerImpl.this.mLastSteps == 0) {
                    PathTraceManagerImpl pathTraceManagerImpl4 = PathTraceManagerImpl.this;
                    pathTraceManagerImpl4.mLastSteps = pathTraceManagerImpl4.mSteps;
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
