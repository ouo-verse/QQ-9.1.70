package com.tencent.mobileqq.qzoneplayer.player;

import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.player.FFSegmentMediaPlayer;
import com.tencent.oskplayer.player.GLTextureMediaPlayer;
import com.tencent.oskplayer.player.HLSMediaPlayer;
import com.tencent.oskplayer.player.IExo2MediaPlayer;
import com.tencent.oskplayer.player.SegmentMediaPlayer;
import com.tencent.oskplayer.player.StateMediaPlayer;
import com.tencent.oskplayer.player.StateSegmentMediaPlayer;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.xweb.FileReaderHelper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes35.dex */
public class CachedMediaPlayer {

    /* renamed from: b, reason: collision with root package name */
    int f279444b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f279445c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f279446d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f279447e = false;

    /* renamed from: f, reason: collision with root package name */
    private PrepareState f279448f = PrepareState.IDLE;

    /* renamed from: g, reason: collision with root package name */
    private IOException f279449g = null;

    /* renamed from: h, reason: collision with root package name */
    private Exception f279450h = null;

    /* renamed from: a, reason: collision with root package name */
    private StateSegmentMediaPlayer f279443a = null;

    /* renamed from: i, reason: collision with root package name */
    private String f279451i = null;

    /* renamed from: j, reason: collision with root package name */
    private Pair<Integer, Integer> f279452j = null;

    /* loaded from: classes35.dex */
    public enum PrepareState {
        IDLE,
        PREPARING,
        PREPARED,
        ERROR
    }

    CachedMediaPlayer() {
    }

    public static CachedMediaPlayer c(int i3, String str, boolean z16) throws UnsupportedOperationException {
        IExo2MediaPlayer b16;
        IExo2MediaPlayer b17;
        CachedMediaPlayer cachedMediaPlayer = new CachedMediaPlayer();
        if (i3 == 1) {
            cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(new SegmentMediaPlayer(), z16);
            cachedMediaPlayer.f279444b = 1;
        } else if (i3 == 2) {
            if (!FFSegmentMediaPlayer.isSupported()) {
                cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(new HLSMediaPlayer(), z16);
            } else {
                cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(new GLTextureMediaPlayer(new FFSegmentMediaPlayer()), z16);
            }
            cachedMediaPlayer.f279444b = 2;
        } else if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 6) {
                    FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
                    if (feedVideoExternalFunc == null && !feedVideoExternalFunc.isSuperPlayerEnabled()) {
                        throw new RuntimeException("SuperPlayer not ready");
                    }
                    cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(new c(), z16);
                    cachedMediaPlayer.f279444b = 6;
                } else {
                    throw new UnsupportedOperationException("unrecognized playertype " + i3);
                }
            } else if (a.c().d() == PlayerSupportStatus.SUPPORTED && (b17 = a.c().b(PlayerConfig.g().getAppContext())) != null) {
                cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(b17, z16);
                cachedMediaPlayer.f279444b = 4;
            } else {
                PlayerUtils.log(5, "mpCache CachedMediaPlayer", "request PLAYER_TYPE_EXO2 which is not supported, using fallback players instead");
                cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(new SegmentMediaPlayer(), z16);
                cachedMediaPlayer.f279444b = 1;
            }
        } else if (a.c().d() == PlayerSupportStatus.SUPPORTED && (b16 = a.c().b(PlayerConfig.g().getAppContext())) != null) {
            cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(b16, z16);
            cachedMediaPlayer.f279444b = 3;
        } else {
            if (!FFSegmentMediaPlayer.isSupported()) {
                cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(new HLSMediaPlayer(), z16);
            } else {
                cachedMediaPlayer.f279443a = new StateSegmentMediaPlayer(new FFSegmentMediaPlayer(), z16);
            }
            cachedMediaPlayer.f279444b = 3;
        }
        cachedMediaPlayer.f279451i = str;
        return cachedMediaPlayer;
    }

    public Exception a() {
        return this.f279450h;
    }

    public IOException b() {
        return this.f279449g;
    }

    public Pair<Integer, Integer> e() {
        return this.f279452j;
    }

    public PrepareState f() {
        return this.f279448f;
    }

    public int g() {
        return this.f279444b;
    }

    public boolean h() {
        return this.f279447e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        PlayerUtils.log(4, "mpCache CachedMediaPlayer", this + " is released");
        this.f279446d = true;
        if (this.f279443a.checkState(StateMediaPlayer.StateMediaPlayerOperation.OP_RELEASE)) {
            this.f279443a.release();
        }
    }

    public String toString() {
        return "[" + super.toString() + ", videoUniqueKey=" + this.f279451i + ", mPrepareState=" + this.f279448f + ", mIsInUse=" + this.f279445c + ", mIsRecycled=" + this.f279447e + ", mIsReleased=" + this.f279446d + "]";
    }

    public StateSegmentMediaPlayer d() {
        this.f279445c = true;
        this.f279447e = false;
        return this.f279443a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<Integer, String[]> k(SegmentVideoInfo.StreamInfo streamInfo, int i3) {
        URL url;
        Uri uri;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int networkType;
        String str7;
        int iPStackType;
        HashMap hashMap = new HashMap();
        String currentSegmentUrl = d().getCurrentSegmentUrl();
        if (!TextUtils.isEmpty(currentSegmentUrl)) {
            PlayerUtils.parseVideoKey(currentSegmentUrl);
        }
        String str8 = null;
        try {
            url = new URL(currentSegmentUrl);
            try {
                uri = Uri.parse(currentSegmentUrl);
            } catch (MalformedURLException e16) {
                e = e16;
                PlayerUtils.log(6, "mpCache CachedMediaPlayer", PlayerUtils.getPrintableStackTrace(e));
                uri = null;
                if (url == null) {
                }
                if (uri != null) {
                }
                str3 = null;
                str4 = null;
                str5 = null;
                hashMap.put(Integer.valueOf(i3), new String[]{"vid", str3});
                Integer valueOf = Integer.valueOf(i3 + 1);
                String[] strArr = new String[2];
                strArr[0] = "\u6d41\u7c7b\u578b";
                if (streamInfo != null) {
                }
                strArr[1] = str6;
                hashMap.put(valueOf, strArr);
                hashMap.put(Integer.valueOf(i3 + 2), new String[]{"\u7f16\u7801\u89c4\u683c", str5});
                Integer valueOf2 = Integer.valueOf(i3 + 3);
                String[] strArr2 = new String[2];
                strArr2[0] = "\u534f\u8bae\u5c01\u88c5";
                if (str2 != null) {
                }
                strArr2[1] = str8;
                hashMap.put(valueOf2, strArr2);
                networkType = FeedVideoEnv.externalFunc.getNetworkType(PlayerConfig.g().getAppContext());
                if (networkType == 0) {
                }
                iPStackType = PlayerConfig.g().getIPStackType();
                if (iPStackType == -1) {
                }
                return hashMap;
            }
        } catch (MalformedURLException e17) {
            e = e17;
            url = null;
        }
        if (url == null) {
            str2 = url.getHost();
            str = url.getProtocol();
        } else {
            str = null;
            str2 = null;
        }
        if (uri != null) {
            String lastPathSegment = uri.getLastPathSegment();
            Matcher matcher = Pattern.compile("^([^.]+)\\.(f\\d+)\\.(\\w+)$").matcher(lastPathSegment);
            if (matcher.matches()) {
                str3 = matcher.group(1);
                str5 = matcher.group(2);
                str4 = matcher.group(3);
            } else {
                Matcher matcher2 = Pattern.compile("^([^.]+)\\.(\\w+)$").matcher(lastPathSegment);
                if (matcher2.matches()) {
                    String group = matcher2.group(1);
                    str5 = null;
                    str4 = matcher2.group(2);
                    str3 = group;
                }
            }
            hashMap.put(Integer.valueOf(i3), new String[]{"vid", str3});
            Integer valueOf3 = Integer.valueOf(i3 + 1);
            String[] strArr3 = new String[2];
            strArr3[0] = "\u6d41\u7c7b\u578b";
            if (streamInfo != null) {
                str6 = streamInfo.streamType + "";
            } else {
                str6 = "\u672a\u77e5";
            }
            strArr3[1] = str6;
            hashMap.put(valueOf3, strArr3);
            hashMap.put(Integer.valueOf(i3 + 2), new String[]{"\u7f16\u7801\u89c4\u683c", str5});
            Integer valueOf22 = Integer.valueOf(i3 + 3);
            String[] strArr22 = new String[2];
            strArr22[0] = "\u534f\u8bae\u5c01\u88c5";
            if (str2 != null && str != null) {
                str8 = str + "," + str2 + "," + str4;
            }
            strArr22[1] = str8;
            hashMap.put(valueOf22, strArr22);
            networkType = FeedVideoEnv.externalFunc.getNetworkType(PlayerConfig.g().getAppContext());
            if (networkType == 0) {
                str7 = "UNKNOWN";
            } else if (networkType == 1) {
                str7 = Global.TRACKING_WIFI;
            } else if (networkType == 2) {
                str7 = "3G";
            } else if (networkType == 3) {
                str7 = "2G";
            } else if (networkType != 4) {
                str7 = "\u5176\u4ed6";
            } else {
                str7 = "4G";
            }
            iPStackType = PlayerConfig.g().getIPStackType();
            if (iPStackType == -1) {
                hashMap.put(Integer.valueOf(i3 + 4), new String[]{"\u7f51\u7edc\u73af\u5883", "\u672a\u77e5," + str7});
            } else if (iPStackType == 0) {
                hashMap.put(Integer.valueOf(i3 + 4), new String[]{"\u7f51\u7edc\u73af\u5883", "\u65e0\u7f51\u7edc," + str7});
            } else if (iPStackType == 1) {
                hashMap.put(Integer.valueOf(i3 + 4), new String[]{"\u7f51\u7edc\u73af\u5883", "IPv4," + str7});
            } else if (iPStackType == 2) {
                hashMap.put(Integer.valueOf(i3 + 4), new String[]{"\u7f51\u7edc\u73af\u5883", "IPv6," + str7});
            } else if (iPStackType != 3) {
                hashMap.put(Integer.valueOf(i3 + 4), new String[]{"\u7f51\u7edc\u73af\u5883", "\u9ed8\u8ba4," + str7});
            } else {
                hashMap.put(Integer.valueOf(i3 + 4), new String[]{"\u7f51\u7edc\u73af\u5883", "IPv6\u53cc\u6808," + str7});
            }
            return hashMap;
        }
        str3 = null;
        str4 = null;
        str5 = null;
        hashMap.put(Integer.valueOf(i3), new String[]{"vid", str3});
        Integer valueOf32 = Integer.valueOf(i3 + 1);
        String[] strArr32 = new String[2];
        strArr32[0] = "\u6d41\u7c7b\u578b";
        if (streamInfo != null) {
        }
        strArr32[1] = str6;
        hashMap.put(valueOf32, strArr32);
        hashMap.put(Integer.valueOf(i3 + 2), new String[]{"\u7f16\u7801\u89c4\u683c", str5});
        Integer valueOf222 = Integer.valueOf(i3 + 3);
        String[] strArr222 = new String[2];
        strArr222[0] = "\u534f\u8bae\u5c01\u88c5";
        if (str2 != null) {
            str8 = str + "," + str2 + "," + str4;
        }
        strArr222[1] = str8;
        hashMap.put(valueOf222, strArr222);
        networkType = FeedVideoEnv.externalFunc.getNetworkType(PlayerConfig.g().getAppContext());
        if (networkType == 0) {
        }
        iPStackType = PlayerConfig.g().getIPStackType();
        if (iPStackType == -1) {
        }
        return hashMap;
    }

    public Map<Integer, String[]> j(String str, SegmentVideoInfo.StreamInfo streamInfo) {
        Map<Integer, String[]> k3 = k(streamInfo, 100);
        String currentSegmentUrl = this.f279443a.getCurrentSegmentUrl();
        int i3 = this.f279444b;
        if (i3 == 4) {
            IExo2MediaPlayer iExo2MediaPlayer = (IExo2MediaPlayer) this.f279443a.getInternalMediaPlayer();
            k3.put(110, new String[]{"\u89e3\u7801\u65b9\u5f0f", "\u786c\u89e3"});
            k3.put(111, new String[]{"\u89e3\u7801\u5668", iExo2MediaPlayer.getVideoDecoderName()});
            String videoMIMEType = iExo2MediaPlayer.getVideoMIMEType();
            if (TextUtils.isEmpty(videoMIMEType)) {
                videoMIMEType = null;
            } else if (videoMIMEType.trim().equalsIgnoreCase("video/avc")) {
                PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyEncH264StreamInfo", currentSegmentUrl);
                videoMIMEType = "H264";
            } else if (videoMIMEType.trim().equalsIgnoreCase("video/hevc")) {
                PlayerConfig.g().getVideoReporter().setExtraData(str, "ExtraDataKeyEncH265StreamInfo", currentSegmentUrl);
                videoMIMEType = "H265";
            }
            String audioMIMEType = iExo2MediaPlayer.getAudioMIMEType();
            if (TextUtils.isEmpty(audioMIMEType)) {
                audioMIMEType = null;
            } else if (audioMIMEType.equals("audio/mp4a-latm")) {
                audioMIMEType = FileReaderHelper.AAC_EXT;
            }
            k3.put(112, new String[]{"\u89c6\u9891\u683c\u5f0f", videoMIMEType});
            k3.put(113, new String[]{"\u97f3\u9891\u683c\u5f0f", audioMIMEType});
            if (iExo2MediaPlayer.getVideoDimension() != null) {
                Rect videoDimension = iExo2MediaPlayer.getVideoDimension();
                k3.put(114, new String[]{"\u5c3a\u5bf8", videoDimension.width() + HippyTKDListViewAdapter.X + videoDimension.height()});
            } else {
                k3.put(114, new String[]{"\u5c3a\u5bf8", null});
            }
            k3.put(115, new String[]{"\u5e26\u5bbd\u4f30\u8ba1", VideoManager.getInstance().getDownloadBitrate() + ""});
        } else if (i3 == 6) {
            c cVar = (c) this.f279443a.getInternalMediaPlayer();
            k3.put(110, new String[]{"\u89e3\u7801\u65b9\u5f0f", cVar.A()});
            k3.put(111, new String[]{"\u89e3\u7801\u5668", cVar.w() + "-" + cVar.x() + ""});
            k3.put(112, new String[]{"\u89c6\u9891\u683c\u5f0f", cVar.z()});
            k3.put(113, new String[]{"\u97f3\u9891\u683c\u5f0f", cVar.u()});
            k3.put(114, new String[]{"\u5c3a\u5bf8", cVar.getVideoWidth() + HippyTKDListViewAdapter.X + cVar.getVideoHeight()});
            StringBuilder sb5 = new StringBuilder();
            sb5.append((cVar.y() / 8) / 1024);
            sb5.append("KBps");
            k3.put(115, new String[]{"\u771f\u5b9e\u7801\u7387", sb5.toString()});
            k3.put(116, new String[]{"\u4e0b\u8f7d\u901f\u5ea6", cVar.v() + "KBps"});
            k3.put(117, new String[]{"\u4e0b\u8f7dID", str + ">" + UuidPlayIdMap.getPlayIdListByUuid(str)});
        }
        return k3;
    }
}
