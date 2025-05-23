package com.tencent.mobileqq.listentogether.api.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.api.IOnlineMusicStatusApi;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.an;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.e;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class OnlineMusicStatusApiImpl implements IOnlineMusicStatusApi {
    public static final String TAG = "OnlineMusicStatusApiImpl";

    @Override // com.tencent.mobileqq.listentogether.api.IOnlineMusicStatusApi
    public an buildFromMusicInfo(boolean z16) {
        MusicInfo musicInfo = (MusicInfo) QQMusicPlayService.C();
        int D = QQMusicPlayService.D() - QQMusicPlayService.E();
        if (musicInfo == null) {
            return null;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (!(waitAppRuntime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) waitAppRuntime;
        ListenTogetherManager listenTogetherManager = (ListenTogetherManager) qQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
        e eVar = (e) ((IOnlineStatusManagerService) qQAppInterface.getRuntimeService(IOnlineStatusManagerService.class)).getManager(e.class);
        if (listenTogetherManager.O() != null) {
            int i3 = listenTogetherManager.O().f437188e == 1 ? 3 : 2;
            if (eVar != null) {
                eVar.h(i3);
            }
        }
        an anVar = new an();
        anVar.f255410a = true;
        anVar.f255411b = musicInfo.f240910d;
        anVar.f255412c = musicInfo.f240911e;
        anVar.f255413d = 1;
        List<String> list = musicInfo.f240913h;
        if (list != null && !list.isEmpty()) {
            anVar.f255414e = musicInfo.f240913h.get(0);
        }
        anVar.f255415f = D;
        anVar.f255416g = eVar != null ? eVar.getSourceType() : 0;
        anVar.f255417h = z16;
        anVar.f255418i = QQMusicPlayService.D();
        return anVar;
    }

    @Override // com.tencent.mobileqq.listentogether.api.IOnlineMusicStatusApi
    public an buildFromSongInfo(boolean z16) {
        String str;
        int e06 = QQPlayerService.e0() - QQPlayerService.a0();
        SongInfo b06 = QQPlayerService.b0();
        if (b06 == null) {
            return null;
        }
        an anVar = new an();
        anVar.f255410a = false;
        String str2 = b06.f251868e;
        anVar.f255411b = str2;
        if (TextUtils.isEmpty(str2) || b06.f251868e.equals("0")) {
            String songMid = getSongMid(b06.D);
            anVar.f255411b = songMid;
            if (TextUtils.isEmpty(songMid)) {
                QLog.d(TAG, 1, "pushMusicStatus, songMid is null");
                return null;
            }
        }
        anVar.f255412c = b06.f251871i;
        anVar.f255413d = 1;
        if (TextUtils.isEmpty(b06.F)) {
            str = b06.f251872m;
        } else {
            str = b06.F;
        }
        anVar.f255414e = str;
        if (str == null) {
            anVar.f255414e = "";
        }
        anVar.f255415f = e06;
        e eVar = (e) ((IOnlineStatusManagerService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(e.class);
        anVar.f255416g = eVar != null ? eVar.getSourceType() : 0;
        anVar.f255417h = z16;
        anVar.f255418i = QQPlayerService.e0();
        return anVar;
    }

    public String getSongMid(String str) {
        URL redirectShortUrl;
        if (TextUtils.isEmpty(str) || (redirectShortUrl = redirectShortUrl(str)) == null) {
            return null;
        }
        return Uri.parse(redirectShortUrl.toString()).getQueryParameter("songmid");
    }

    public URL redirectShortUrl(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 302) {
                return new URL(httpURLConnection.getHeaderField("Location"));
            }
            return null;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "redirectShortUrl, ", e16);
            return null;
        }
    }
}
