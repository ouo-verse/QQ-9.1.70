package com.tencent.aelight.camera.aioeditor.capture.music;

import NS_QQ_STORY_CLIENT.CLIENT$StBatchGetMusicInfoRsp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.aioeditor.capture.control.GetSingleFullMusicInfoTask;
import com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager;
import com.tencent.aelight.camera.aioeditor.capture.data.i;
import com.tencent.aelight.camera.aioeditor.capture.util.QIMFileUtils;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMMusicConfigManager extends QIMAsyncManager {
    public static final File U = new File(QIMFileUtils.a(), "dov_doodle_music");
    public String E;
    private String F;
    private ArrayList<i> I;
    public EntityManager K;
    private i L;
    public i M;
    public MusicItemInfo N;
    public IHttpEngineService R;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<i> f66761i;

    /* renamed from: e, reason: collision with root package name */
    private boolean f66758e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f66759f = 3;

    /* renamed from: h, reason: collision with root package name */
    public String f66760h = null;

    /* renamed from: m, reason: collision with root package name */
    private int f66762m = 0;
    private int C = 0;
    private int D = 0;
    private int G = 2;
    private String H = "\u6211\u7684";
    private List<FlowMusic> J = new ArrayList();
    private Object P = new Object();
    public AtomicBoolean Q = new AtomicBoolean(false);
    private List<c> S = new ArrayList();
    protected BroadcastReceiver T = new b();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private final class GetQQMusicSongListTask extends LoadMusicStepTask {
        GetQQMusicSongListTask(QIMMusicConfigManager qIMMusicConfigManager) {
            super(qIMMusicConfigManager);
        }

        GetSongListStepTask f() {
            return new GetSongListStepTask(this.f66767d);
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.LoadMusicStepTask, com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (netResp.mHttpCode != 200) {
                QIMMusicConfigManager.this.s(false);
                this.f66767d.F(0, false, "Http Request fail, code=" + netResp.mHttpCode);
                return;
            }
            if (netResp.mRespData == null) {
                QIMMusicConfigManager.this.s(false);
                this.f66767d.F(0, false, "Have no data.");
            } else {
                GetSongListStepTask f16 = f();
                f16.f66766m = new String(netResp.mRespData);
                f16.e();
                this.f66767d.F(0, true, f16.f66766m);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mPrioty = 1;
            httpNetReq.mCallback = this;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", "2000000228");
            hashMap.put("app_key", "TCOHANTCNlddnsTY");
            hashMap.put("device_id", ah.z());
            hashMap.put("timestamp", String.valueOf(currentTimeMillis));
            hashMap.put("sign", c(currentTimeMillis));
            hashMap.putAll(a(this.f66770h, "_FAKESKEY_"));
            httpNetReq.mReqUrl = b("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_self.fcg", hashMap);
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "QQMusicReq SongList api request, req url=" + httpNetReq.mReqUrl);
            }
            IHttpEngineService iHttpEngineService = this.f66771i;
            if (iHttpEngineService != null) {
                iHttpEngineService.sendReq(httpNetReq);
            } else {
                QLog.e("QIMMusicConfigManager", 1, "QQMusicReq SongList api request failed, mHttpEngine is null!");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("data");
                String stringExtra2 = intent.getStringExtra("event");
                if (TextUtils.isEmpty(stringExtra2) || !stringExtra2.equals(QQWinkConstants.JS_PLUGIN_EVENT_SELECT_MUSIC)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QIMMusicConfigManager", 2, "onReceive:" + stringExtra);
                }
                MusicItemInfo musicItemInfo = null;
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    musicItemInfo = QIMMusicConfigManager.this.u(jSONObject.optInt("id"));
                    boolean optBoolean = jSONObject.optBoolean(IAELaunchMusicConfigManager.JSON_KEY_H5_MUSIC_FROM, false);
                    if (musicItemInfo == null) {
                        musicItemInfo = QIMMusicConfigManager.this.B(jSONObject, optBoolean);
                    }
                    musicItemInfo.mSongMid = jSONObject.optString("mid");
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QIMMusicConfigManager", 2, QLog.getStackTraceString(e16));
                    }
                }
                if (QIMMusicConfigManager.this.S != null) {
                    Iterator it = QIMMusicConfigManager.this.S.iterator();
                    while (it.hasNext()) {
                        ((c) it.next()).b(musicItemInfo);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(int i3, boolean z16, Object obj);

        void b(MusicItemInfo musicItemInfo);
    }

    public QIMMusicConfigManager() {
        AppInterface c16 = c();
        this.K = c16.getEntityManagerFactory().createEntityManager();
        if (TextUtils.isEmpty(c16.getAccount())) {
            QLog.e("QIMMusicConfigManager", 1, "QIMMusicConfigManager init http engine error, account uin is empty!");
        } else {
            this.R = (IHttpEngineService) c16.getRuntimeService(IHttpEngineService.class, "all");
        }
    }

    public static boolean E() {
        boolean exists = new File(U + File.separator + "doodle_music_config.cfg").exists();
        if (QLog.isColorLevel()) {
            QLog.i("QIMMusicConfigManager", 2, "QIMMusicConfigManager isStickerConfigFileExist=" + exists);
        }
        return exists;
    }

    public static void H(String str) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("fecth_qq_music", 4).edit();
        edit.putLong("fecth_from_qq_music_time_" + str, System.currentTimeMillis());
        edit.commit();
    }

    private void n(i iVar, MusicItemInfo musicItemInfo) {
        if (iVar.f66740d == 999 || musicItemInfo.mType != 5) {
            return;
        }
        for (MusicItemInfo musicItemInfo2 : iVar.f66743h) {
            int i3 = musicItemInfo2.mType;
            if (i3 == 5) {
                int indexOf = iVar.f66743h.indexOf(musicItemInfo2);
                iVar.f66743h.remove(indexOf);
                iVar.f66743h.add(indexOf, musicItemInfo);
                return;
            } else if (i3 == 1) {
                iVar.f66743h.add(iVar.f66743h.indexOf(musicItemInfo2), musicItemInfo);
                return;
            }
        }
    }

    private void p(FlowMusic flowMusic, long j3) {
        FlowMusic flowMusic2;
        try {
            flowMusic.storeTimeStamp = j3;
            Iterator<FlowMusic> it = this.J.iterator();
            while (true) {
                if (!it.hasNext()) {
                    flowMusic2 = null;
                    break;
                }
                flowMusic2 = it.next();
                if (flowMusic2.songId == flowMusic.songId) {
                    if (flowMusic2 != flowMusic) {
                        flowMusic2.copyFrom(flowMusic);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            if (flowMusic2 != null) {
                arrayList.add(new UpdateTransaction(flowMusic));
            } else {
                if (this.J.size() < 40) {
                    this.J.add(0, flowMusic);
                } else {
                    FlowMusic remove = this.J.remove(this.J.size() - 1);
                    arrayList.add(new DeleteTransaction(FlowMusic.class.getSimpleName(), "songName=? and tryBegin=? and tryEnd=?", new String[]{remove.songName, String.valueOf(remove.tryBegin), String.valueOf(remove.tryEnd)}));
                    this.J.add(0, flowMusic);
                }
                arrayList.add(new PersistOrReplaceTransaction(flowMusic));
                if (QLog.isColorLevel()) {
                    QLog.d("QIMMusicConfigManager", 2, "insert music=" + flowMusic);
                }
            }
            if (arrayList.size() > 0) {
                this.K.doMultiDBOperateByTransaction(arrayList);
            }
        } finally {
            Collections.sort(this.J);
        }
    }

    private i q(MusicItemInfo musicItemInfo, MusicItemInfo musicItemInfo2, MusicItemInfo musicItemInfo3) {
        i iVar = new i();
        this.L = iVar;
        iVar.f66740d = 999;
        iVar.f66742f = this.H;
        MusicItemInfo musicItemInfo4 = new MusicItemInfo();
        musicItemInfo4.mType = 4;
        musicItemInfo4.mItemId = -3;
        this.L.f66743h = new ArrayList();
        this.L.f66743h.add(musicItemInfo);
        this.L.f66743h.add(musicItemInfo2);
        this.L.f66743h.add(musicItemInfo4);
        if (this.D == 1) {
            this.L.f66743h.add(musicItemInfo3);
            musicItemInfo3.jumpWs = this.F;
        }
        for (int i3 = 0; i3 < this.J.size(); i3++) {
            FlowMusic flowMusic = this.J.get(i3);
            MusicItemInfo musicItemInfo5 = new MusicItemInfo();
            musicItemInfo5.mType = 5;
            musicItemInfo5.mMusicName = flowMusic.songName;
            musicItemInfo5.setPath(flowMusic.path);
            musicItemInfo5.mUrl = flowMusic.url;
            musicItemInfo5.mSingername = flowMusic.singerName;
            musicItemInfo5.mItemId = flowMusic.songId;
            musicItemInfo5.mSongMid = flowMusic.songMid;
            musicItemInfo5.musicStart = flowMusic.tryBegin;
            musicItemInfo5.musicEnd = flowMusic.tryEnd;
            musicItemInfo5.musicDuration = flowMusic.duration;
            musicItemInfo5.mAlbumUrl = flowMusic.albumUrl;
            this.L.f66743h.add(musicItemInfo5);
        }
        return this.L;
    }

    private FlowMusic t(int i3) {
        if (this.J == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "findFlowMusicFromUserList mUserMusicList is null");
            }
            return null;
        }
        for (int i16 = 0; i16 < this.J.size(); i16++) {
            FlowMusic flowMusic = this.J.get(i16);
            if (flowMusic.songId == i3) {
                return flowMusic;
            }
        }
        return null;
    }

    private int v(MusicItemInfo musicItemInfo) {
        i iVar = this.L;
        if (iVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
            }
            return -1;
        }
        if (iVar.f66743h == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
            }
            return -1;
        }
        for (int i3 = 0; i3 < this.L.f66743h.size(); i3++) {
            MusicItemInfo musicItemInfo2 = this.L.f66743h.get(i3);
            if (musicItemInfo2.mItemId == musicItemInfo.mItemId) {
                return i3;
            }
            if (musicItemInfo.mRecognitionOffset != -1.0f && !TextUtils.isEmpty(musicItemInfo.mMusicName) && !TextUtils.isEmpty(musicItemInfo2.mMusicName) && musicItemInfo.mMusicName.equals(musicItemInfo2.mMusicName)) {
                return i3;
            }
        }
        return -1;
    }

    public synchronized MusicItemInfo A(int i3, int i16) {
        ArrayList<i> w3 = w();
        if (w3 != null) {
            Iterator<i> it = w3.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (i3 == -1) {
                    return next.b(i16);
                }
                if (next.f66740d == i3) {
                    return next.b(i16);
                }
            }
        }
        return null;
    }

    public void D(String str) {
        this.f66761i = y(str);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleDoodleMusicConfig");
            sb5.append(str);
            sb5.append(" result:");
            sb5.append(this.f66761i != null);
            QLog.i("QIMMusicConfigManager", 2, sb5.toString());
        }
        QIMFileUtils.d(U, "doodle_music_config.cfg", str);
        PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication).edit().putInt("show_wstab", this.C).commit();
    }

    public void F(final int i3, final boolean z16, final Object obj) {
        if (z16) {
            if (i3 == 4) {
                this.J.addAll((Collection) obj);
                Collections.sort(this.J);
            }
            if ((obj instanceof String) && QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "onStepCall successed, step=" + i3 + ", msg=" + obj);
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigManager", 2, "onStepCall failed, step=" + i3 + ", msg=" + obj);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = QIMMusicConfigManager.this.S.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(i3, z16, obj);
                }
            }
        });
    }

    public void G(c cVar) {
        if (this.S.contains(cVar)) {
            this.S.remove(cVar);
        }
    }

    @Override // fr.e
    public void d() {
        AppInterface c16 = c();
        if (c16 != null) {
            c16.getApp().unregisterReceiver(this.T);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.control.QIMAsyncManager
    public void i() {
        AppInterface c16 = c();
        if (c16 != null) {
            c16.getApp().registerReceiver(this.T, new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT"));
            w();
            c().notifyObservers(com.tencent.aelight.camera.aioeditor.capture.music.b.class, 1, true, null);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QIMMusicConfigManager", 4, "initMusicConfig");
        }
    }

    public void o(MusicItemInfo musicItemInfo, boolean z16) {
        List<MusicItemInfo> list;
        FlowMusic t16;
        synchronized (this.P) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, lock updateTimeStamp=" + z16);
            }
            i iVar = this.L;
            if (iVar != null && (list = iVar.f66743h) != null) {
                int v3 = v(musicItemInfo);
                long currentTimeMillis = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, index=" + v3);
                }
                if (v3 == -1) {
                    int size = list.size();
                    int i3 = this.f66759f;
                    if (size < i3 + 40) {
                        list.add(i3, musicItemInfo);
                    } else {
                        MusicItemInfo remove = list.remove(list.size() - 1);
                        if (!TextUtils.isEmpty(remove.getLocalPath())) {
                            com.tencent.biz.qqstory.utils.d.h(new File(remove.getLocalPath()));
                            if (QLog.isColorLevel()) {
                                QLog.d("QIMMusicConfigManager", 2, "delete file=" + remove.mMusicName);
                            }
                        }
                        list.add(this.f66759f, musicItemInfo);
                    }
                    t16 = new FlowMusic(musicItemInfo);
                } else if (v3 != this.f66759f && z16) {
                    list.remove(v3);
                    list.add(this.f66759f, musicItemInfo);
                    t16 = t(musicItemInfo.mItemId);
                    if (t16 != null) {
                        t16.sourceType = 0;
                    }
                } else {
                    list.remove(v3);
                    list.add(v3, musicItemInfo);
                    t16 = t(musicItemInfo.mItemId);
                    if (t16 != null) {
                        t16.sourceType = 0;
                        currentTimeMillis = t16.storeTimeStamp;
                    }
                }
                if (t16 != null) {
                    t16.tryBegin = musicItemInfo.musicStart;
                    t16.tryEnd = musicItemInfo.musicEnd;
                    t16.url = musicItemInfo.mUrl;
                    t16.path = musicItemInfo.getLocalPath();
                    t16.duration = musicItemInfo.musicDuration;
                    p(t16, currentTimeMillis);
                }
                List<c> list2 = this.S;
                if (list2 != null) {
                    Iterator<c> it = list2.iterator();
                    while (it.hasNext()) {
                        it.next().a(5, true, musicItemInfo);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, unlock");
                }
            }
        }
    }

    public void r() {
        String currentAccountUin;
        this.J.clear();
        ((IAsyncControl) QRoute.api(IAsyncControl.class)).startAsyncStep(1009);
        String currentAccountUin2 = c().getCurrentAccountUin();
        long j3 = BaseApplication.getContext().getSharedPreferences("fecth_qq_music", 4).getLong("fecth_from_qq_music_time_" + currentAccountUin2, 0L);
        boolean z16 = System.currentTimeMillis() - j3 > 86400000 && NetworkUtil.isWifiEnabled(BaseApplicationImpl.sApplication);
        if ((j3 == 0 || z16) && (currentAccountUin = c().getCurrentAccountUin()) != null) {
            this.f66760h = currentAccountUin;
            new GetQQMusicSongListTask(this).e();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigManager", 2, "checkMyFavoriteUpgradeInQQMusic, lastFetchTime = " + j3);
        }
    }

    public MusicItemInfo u(int i3) {
        i iVar = this.L;
        if (iVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
            }
            return null;
        }
        if (iVar.f66743h == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
            }
            return null;
        }
        for (int i16 = 0; i16 < this.L.f66743h.size(); i16++) {
            MusicItemInfo musicItemInfo = this.L.f66743h.get(i16);
            if (musicItemInfo.mItemId == i3) {
                return musicItemInfo;
            }
        }
        return null;
    }

    public synchronized ArrayList<i> w() {
        if (this.Q.compareAndSet(true, true)) {
            return null;
        }
        return x(false);
    }

    public synchronized ArrayList<i> x(boolean z16) {
        int i3;
        MusicItemInfo musicItemInfo;
        ArrayList<i> arrayList;
        synchronized (this.P) {
            this.Q.set(true);
            if (this.f66761i == null) {
                String b16 = QIMFileUtils.b(U, "doodle_music_config.cfg");
                if (b16 != null) {
                    this.f66761i = y(b16);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("initStickerConfigFromCache, result:");
                        sb5.append(this.f66761i != null);
                        QLog.i("QIMMusicConfigManager", 2, sb5.toString());
                    }
                }
                ArrayList<i> arrayList2 = this.f66761i;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    this.f66761i = y(QIMFileUtils.c("doodle_music.cfg"));
                    if (QLog.isColorLevel()) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("initStickerConfigFromAssets, result:");
                        sb6.append(this.f66761i != null);
                        QLog.i("QIMMusicConfigManager", 2, sb6.toString());
                    }
                }
            }
            i iVar = this.L;
            boolean z17 = (iVar == null || iVar.f66743h.size() == this.J.size() + this.f66759f) ? false : true;
            if (this.I == null || z16 || z17) {
                ArrayList<i> arrayList3 = this.f66761i;
                this.I = new ArrayList<>(arrayList3 == null ? 0 : arrayList3.size());
                MusicItemInfo musicItemInfo2 = new MusicItemInfo();
                musicItemInfo2.mType = 2;
                musicItemInfo2.mItemId = -1;
                MusicItemInfo musicItemInfo3 = new MusicItemInfo();
                musicItemInfo3.mType = 3;
                musicItemInfo3.mItemId = -2;
                MusicItemInfo musicItemInfo4 = new MusicItemInfo();
                musicItemInfo4.mType = 10;
                musicItemInfo4.mItemId = -7;
                ArrayList<i> arrayList4 = this.f66761i;
                if (arrayList4 != null) {
                    Iterator<i> it = arrayList4.iterator();
                    while (it.hasNext()) {
                        i next = it.next();
                        List<MusicItemInfo> list = next.f66743h;
                        if (list != null && list.size() > 0) {
                            i clone = next.clone();
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.add(musicItemInfo2);
                            arrayList5.add(musicItemInfo3);
                            this.f66759f = 3;
                            i iVar2 = this.M;
                            if (iVar2 != null && iVar2.f66743h != null && iVar2.f66740d == next.f66740d && (musicItemInfo = this.N) != null) {
                                n(next, musicItemInfo);
                            }
                            if (z16 && next.f66741e) {
                                Collections.shuffle(next.f66743h);
                            }
                            arrayList5.addAll(next.f66743h);
                            clone.f66743h = arrayList5;
                            this.I.add(clone);
                        }
                    }
                }
                if (this.f66762m == 1 && (i3 = this.G) >= 1 && i3 <= this.I.size()) {
                    this.I.add(this.G - 1, q(musicItemInfo2, musicItemInfo3, musicItemInfo4));
                }
            }
            this.Q.set(false);
            arrayList = this.I;
        }
        return arrayList;
    }

    public ArrayList<i> y(String str) {
        ArrayList<i> arrayList = new ArrayList<>(4);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("showMine")) {
                this.f66762m = jSONObject.getInt("showMine");
            }
            if (jSONObject.has("showWsTab")) {
                this.C = jSONObject.getInt("showWsTab");
            }
            if (jSONObject.has("showMusicWs")) {
                this.D = jSONObject.getInt("showMusicWs");
            }
            if (jSONObject.has("jumpWsTab")) {
                this.E = jSONObject.getString("jumpWsTab");
            }
            if (jSONObject.has("jumpWsMusic")) {
                this.F = jSONObject.getString("jumpWsMusic");
            }
            if (jSONObject.has("mineIndex")) {
                this.G = jSONObject.getInt("mineIndex");
            }
            if (jSONObject.has("mineCategoryName")) {
                this.H = jSONObject.getString("mineCategoryName");
            }
            JSONArray jSONArray = jSONObject.getJSONArray("category");
            arrayList.ensureCapacity(jSONArray.length());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(new i(jSONArray.getJSONObject(i3)));
            }
            return arrayList;
        } catch (JSONException e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e("QIMMusicConfigManager", 2, QLog.getStackTraceString(e16));
            return null;
        }
    }

    public synchronized MusicItemInfo z(int i3) {
        MusicItemInfo musicItemInfo;
        ArrayList<i> w3 = w();
        musicItemInfo = null;
        if (w3 != null) {
            Iterator<i> it = w3.iterator();
            while (it.hasNext() && (musicItemInfo = it.next().b(i3)) == null) {
            }
        }
        return musicItemInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public final class GetSongListStepTask extends LoadMusicStepTask {

        /* renamed from: m, reason: collision with root package name */
        String f66766m;

        GetSongListStepTask(QIMMusicConfigManager qIMMusicConfigManager) {
            super(qIMMusicConfigManager);
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.LoadMusicStepTask, com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            if (netResp.mHttpCode != 200) {
                QIMMusicConfigManager.this.s(false);
                this.f66767d.F(1, false, "Http Request fail, code=" + netResp.mHttpCode);
                return;
            }
            byte[] bArr = netResp.mRespData;
            if (bArr == null) {
                QIMMusicConfigManager.this.s(false);
                this.f66767d.F(1, false, "have no data.");
            } else {
                ((IAsyncControl) QRoute.api(IAsyncControl.class)).startAsyncStep(String.valueOf(1008), new Object[]{new String(bArr)});
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray optJSONArray;
            long j3;
            try {
                JSONObject jSONObject = new JSONObject(this.f66766m);
                if (jSONObject.optInt("ret", -1) != 0 || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= optJSONArray.length()) {
                        j3 = -1;
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null && "\u6211\u559c\u6b22".equals(optJSONObject.optString("diss_name"))) {
                        j3 = optJSONObject.optLong("diss_id", -1L);
                        break;
                    }
                    i3++;
                }
                if (j3 == -1) {
                    QIMMusicConfigManager.this.s(true);
                    this.f66767d.F(1, false, "can not find myFav diss.");
                    return;
                }
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mPrioty = 1;
                httpNetReq.mCallback = this;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                HashMap hashMap = new HashMap();
                hashMap.put("app_id", "2000000228");
                hashMap.put("app_key", "TCOHANTCNlddnsTY");
                hashMap.put("device_id", ah.z());
                hashMap.put("timestamp", String.valueOf(currentTimeMillis));
                hashMap.put("sign", c(currentTimeMillis));
                hashMap.put("dissid", String.valueOf(j3));
                hashMap.putAll(a(this.f66770h, "_FAKESKEY_"));
                httpNetReq.mReqUrl = b("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_detail.fcg", hashMap);
                IHttpEngineService iHttpEngineService = this.f66771i;
                if (iHttpEngineService != null) {
                    iHttpEngineService.sendReq(httpNetReq);
                } else {
                    QLog.e("QIMMusicConfigManager", 1, "QQMusicReq SongList api request failed, mHttpEngine is null!");
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QIMMusicConfigManager", 2, "QQMusicReq GetSongListStepTask req url=" + httpNetReq.mReqUrl);
                }
            } catch (JSONException unused) {
                QIMMusicConfigManager.this.s(false);
                this.f66767d.F(1, false, "parsed json error, json=" + this.f66766m);
            }
        }
    }

    public void m(c cVar) {
        List<c> list;
        if (cVar != null && (list = this.S) != null) {
            if (list.contains(cVar)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener mListeners has listener");
                    return;
                }
                return;
            }
            this.S.add(cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener listener = null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements VSDispatchObserver.OnVSRspCallBack<CLIENT$StBatchGetMusicInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ns.a f66772a;

        a(ns.a aVar) {
            this.f66772a = aVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, CLIENT$StBatchGetMusicInfoRsp cLIENT$StBatchGetMusicInfoRsp) {
            if (z16 && cLIENT$StBatchGetMusicInfoRsp.vecMusic.size() != 0) {
                if (this.f66772a != null) {
                    FlowMusic flowMusic = new FlowMusic(cLIENT$StBatchGetMusicInfoRsp.vecMusic.get(0));
                    QLog.i("QIMMusicConfigManager", 1, "getSingleFullMusicInfo from story success flow info:" + flowMusic.toString());
                    this.f66772a.a(true, flowMusic);
                    return;
                }
                return;
            }
            this.f66772a.a(false, new FlowMusic());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MusicItemInfo B(JSONObject jSONObject, boolean z16) {
        if (z16) {
            return new VsMusicItemInfo(jSONObject);
        }
        MusicItemInfo musicItemInfo = new MusicItemInfo();
        musicItemInfo.mType = 5;
        musicItemInfo.mMusicName = jSONObject.optString("title");
        musicItemInfo.mSingername = jSONObject.optString("desc");
        musicItemInfo.mItemId = jSONObject.optInt("id");
        musicItemInfo.mSongMid = jSONObject.optString("mid");
        return musicItemInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z16) {
        if (z16) {
            H(c().getCurrentAccountUin());
        }
    }

    public void C(String str, boolean z16, ns.a aVar) {
        if (z16) {
            QLog.i("QIMMusicConfigManager", 1, "getSingleFullMusicInfo instance is VsMusicItemInfo though videoStory cmd");
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            VSNetworkHelper.getInstance().sendRequest(new BatchGetMusicInfoRequest(arrayList), new a(aVar));
            return;
        }
        ThreadManagerV2.executeOnSubThread(new GetSingleFullMusicInfoTask(str, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static abstract class LoadMusicStepTask implements Runnable, INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final QIMMusicConfigManager f66767d;

        /* renamed from: e, reason: collision with root package name */
        final AppInterface f66768e;

        /* renamed from: f, reason: collision with root package name */
        final String f66769f;

        /* renamed from: h, reason: collision with root package name */
        final String f66770h;

        /* renamed from: i, reason: collision with root package name */
        final IHttpEngineService f66771i;

        LoadMusicStepTask(QIMMusicConfigManager qIMMusicConfigManager) {
            this.f66767d = qIMMusicConfigManager;
            AppInterface c16 = qIMMusicConfigManager.c();
            this.f66768e = c16;
            this.f66769f = c16.getCurrentAccountUin();
            this.f66770h = qIMMusicConfigManager.f66760h;
            this.f66771i = qIMMusicConfigManager.R;
        }

        Map<String, String> a(String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.put(MsfConstants.ATTRIBUTE_LOGIN_TYPE, String.valueOf(1));
            hashMap.put("uin", str);
            hashMap.put("ticket_type", "skey");
            hashMap.put(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, str2);
            return hashMap;
        }

        String b(String str, Map<String, String> map) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            if (!map.isEmpty()) {
                boolean z16 = true;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (z16) {
                        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        z16 = false;
                    } else {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb5.append(entry.getKey());
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(entry.getValue());
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "genQQMusicReqUrl url" + sb5.toString());
            }
            return sb5.toString();
        }

        String c(long j3) {
            String str = "OpitrtqeGzopIlwxs_2000000228_TCOHANTCNlddnsTY_uZliVvhTJzkDPlHX_" + j3;
            String lowerCase = com.tencent.securitysdk.utils.c.b(str).toLowerCase();
            if (QLog.isColorLevel()) {
                QLog.d("QIMMusicConfigManager", 2, "generate the sign string, pre=" + str + ", md5=" + lowerCase);
            }
            return lowerCase;
        }

        void e() {
            ThreadManagerV2.executeOnSubThread(this);
        }

        public void onResp(NetResp netResp) {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
