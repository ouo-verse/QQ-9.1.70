package bd4;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.preload.TVKPreloadMgr;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.MethodNotSupportedException;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements ISPlayerPreDownloader {

    /* renamed from: d, reason: collision with root package name */
    private static final String f28292d = "a";

    /* renamed from: a, reason: collision with root package name */
    private TVKPreloadMgr f28293a = TVKPreloadMgr.getInstance();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Integer> f28294b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private Context f28295c;

    /* compiled from: P */
    /* renamed from: bd4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C0120a implements ITVKPreloadMgr.IPreloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28296a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISPlayerPreDownloader.Listener f28297b;

        C0120a(int i3, ISPlayerPreDownloader.Listener listener) {
            this.f28296a = i3;
            this.f28297b = listener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr.IPreloadListener
        public void onPreloadDownloadProgressUpdate(int i3, ITVKPreloadMgr.IPreloadListener.DownloadProgressInfo downloadProgressInfo) {
            if (!a.this.f28294b.containsKey(Integer.valueOf(this.f28296a))) {
                LogUtil.d(a.f28292d, "onPrepareDownloadProgressUpdate taskId is not exist, hashcode = " + this.f28296a);
                return;
            }
            int intValue = ((Integer) a.this.f28294b.get(Integer.valueOf(this.f28296a))).intValue();
            this.f28297b.onPrepareDownloadProgressUpdate(intValue, downloadProgressInfo.getPlayableDurationMs(), downloadProgressInfo.getDownloadSpeedKBs(), downloadProgressInfo.getCurrentDownloadSizeByte(), downloadProgressInfo.getTotalFileSizeByte(), downloadProgressInfo.getExtraInfo());
            LogUtil.d(a.f28292d, "onPrepareDownloadProgressUpdate, taskId = " + intValue + "hashcode = " + this.f28296a + "progress: " + downloadProgressInfo.getCurrentDownloadSizeByte() + "/" + downloadProgressInfo.getTotalFileSizeByte());
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr.IPreloadListener
        public void onPreloadError(int i3) {
            a.this.h(this.f28296a, this.f28297b);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKPreloadMgr.IPreloadListener
        public void onPreloadSuccess(int i3) {
            a.this.i(this.f28296a, this.f28297b);
        }
    }

    public a(Context context) {
        this.f28295c = context;
    }

    private int e(int i3) {
        if (i3 == -1) {
            return i3;
        }
        return i3 - 1000000;
    }

    private int f(int i3) {
        if (i3 == -1) {
            return i3;
        }
        return i3 + 1000000;
    }

    private int g(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, ITVKPreloadMgr.PreloadParam preloadParam, ISPlayerPreDownloader.Listener listener) {
        int i3 = 0;
        if (tVKUserInfo != null) {
            i3 = 0 + tVKUserInfo.hashCode();
        }
        if (tVKPlayerVideoInfo != null) {
            i3 += tVKPlayerVideoInfo.hashCode();
        }
        if (str != null) {
            i3 += str.hashCode();
        }
        if (preloadParam != null) {
            i3 += preloadParam.hashCode();
        }
        if (listener != null) {
            return i3 + listener.hashCode();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i3, ISPlayerPreDownloader.Listener listener) {
        if (listener == null) {
            return;
        }
        if (this.f28294b.containsKey(Integer.valueOf(i3))) {
            int intValue = this.f28294b.get(Integer.valueOf(i3)).intValue();
            listener.onPrepareError(intValue, 0, 0, "");
            LogUtil.d(f28292d, "onPreloadError taskId = " + intValue + ", hashcode = " + i3);
            this.f28294b.remove(Integer.valueOf(i3));
            return;
        }
        LogUtil.d(f28292d, "onPreloadError taskId is not exist, hashcode = " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3, ISPlayerPreDownloader.Listener listener) {
        if (listener == null) {
            return;
        }
        if (this.f28294b.containsKey(Integer.valueOf(i3))) {
            int intValue = this.f28294b.get(Integer.valueOf(i3)).intValue();
            listener.onPrepareSuccess(intValue);
            LogUtil.d(f28292d, "onPrepareSuccess taskId = " + intValue + ", hashcode = " + i3);
            this.f28294b.remove(Integer.valueOf(i3));
            return;
        }
        LogUtil.d(f28292d, "onPrepareSuccess taskId is not exist, hashcode = " + i3);
    }

    private int j(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, ITVKPreloadMgr.PreloadParam preloadParam, ITVKPreloadMgr.IPreloadListener iPreloadListener) {
        return f(this.f28293a.preload(tVKUserInfo, tVKPlayerVideoInfo, str, preloadParam, iPreloadListener));
    }

    private void k(int i3) {
        this.f28293a.stopPreload(e(i3));
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public void destory() {
        stopAllPreDownload();
        this.f28293a = null;
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public void setOnPreDownloadListener(ISPlayerPreDownloader.Listener listener) {
        throw new MethodNotSupportedException("setOnPreDownloadListener is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, long j16) {
        throw new MethodNotSupportedException("startPreDownload is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.tvkplayer.datatransport.ITVKPlayerPreDownloader
    public int startTVKPreDownload(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, ITVKPreloadMgr.PreloadParam preloadParam, ISPlayerPreDownloader.Listener listener) {
        int g16 = g(tVKUserInfo, tVKPlayerVideoInfo, str, preloadParam, listener);
        int j3 = j(tVKUserInfo, tVKPlayerVideoInfo, str, preloadParam, new C0120a(g16, listener));
        this.f28294b.put(Integer.valueOf(g16), Integer.valueOf(j3));
        return f(j3);
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public void stopAllPreDownload() {
        Iterator<Map.Entry<Integer, Integer>> it = this.f28294b.entrySet().iterator();
        while (it.hasNext()) {
            k(it.next().getValue().intValue());
        }
        this.f28294b.clear();
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public void stopPreDownload(int i3) {
        int i16;
        k(i3);
        Iterator<Map.Entry<Integer, Integer>> it = this.f28294b.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                if (next.getValue().intValue() == i3) {
                    i16 = next.getKey().intValue();
                    break;
                }
            } else {
                i16 = 0;
                break;
            }
        }
        if (i16 != 0 && this.f28294b.containsKey(Integer.valueOf(i16))) {
            this.f28294b.remove(Integer.valueOf(i16));
        } else {
            LogUtil.e(f28292d, "can not find target task in map!");
        }
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3) {
        throw new MethodNotSupportedException("startPreDownload is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, long j16, SuperPlayerDownOption superPlayerDownOption) {
        throw new MethodNotSupportedException("startPreDownload is not supported in TVKPlayer");
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader
    public int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerDownOption superPlayerDownOption) {
        throw new MethodNotSupportedException("startPreDownload is not supported in TVKPlayer");
    }
}
