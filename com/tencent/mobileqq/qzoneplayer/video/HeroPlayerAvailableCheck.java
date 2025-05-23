package com.tencent.mobileqq.qzoneplayer.video;

import android.os.Build;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.VideoDecoderType;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes35.dex */
public class HeroPlayerAvailableCheck {

    /* renamed from: e, reason: collision with root package name */
    private static final String f279797e = "HeroPlayerAvailableCheck";

    /* renamed from: f, reason: collision with root package name */
    private static volatile HeroPlayerAvailableCheck f279798f;

    /* renamed from: a, reason: collision with root package name */
    private String f279799a;

    /* renamed from: b, reason: collision with root package name */
    private String f279800b;

    /* renamed from: c, reason: collision with root package name */
    private List<VideoDecoderType.DecoderType> f279801c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, VideoDecoderType.DecoderType> f279802d;

    HeroPlayerAvailableCheck() {
        this.f279799a = null;
        this.f279800b = null;
        this.f279802d = null;
        List<String> heroPlayerSetInfo = PlayerConfig.g().getHeroPlayerSetInfo();
        if (heroPlayerSetInfo != null && heroPlayerSetInfo.size() >= 2) {
            this.f279799a = heroPlayerSetInfo.get(0);
            this.f279800b = heroPlayerSetInfo.get(1);
        }
        PlayerUtils.log(4, f279797e, "hero set config = " + this.f279799a + ", process name = " + this.f279800b);
        this.f279802d = new HashMap<String, VideoDecoderType.DecoderType>() { // from class: com.tencent.mobileqq.qzoneplayer.video.HeroPlayerAvailableCheck.1
            {
                put("0", VideoDecoderType.DecoderType.UNKNOWN);
                put("1", VideoDecoderType.DecoderType.H264);
                put("2", VideoDecoderType.DecoderType.H265_SW);
                put("3", VideoDecoderType.DecoderType.H265_HW);
            }
        };
    }

    private boolean a(String str) {
        PlayerUtils.log(4, f279797e, "current process = " + this.f279800b + ", allow process = " + str);
        String[] split = str.split(",");
        if (split == null || split.length == 0 || (split.length > 0 && split[0].equals("default"))) {
            return true;
        }
        List asList = Arrays.asList(split);
        return (asList == null || asList.isEmpty() || !asList.contains(this.f279800b)) ? false : true;
    }

    private boolean b(String str) {
        PlayerUtils.log(4, f279797e, "current remainder = " + (FeedVideoEnv.externalFunc.getLoginUin() % 100) + ", allow remainder = " + str);
        String[] split = str.split(",");
        if (split == null || split.length == 0 || (split.length > 0 && split[0].equals("default"))) {
            return true;
        }
        List asList = Arrays.asList(split);
        Long valueOf = Long.valueOf(FeedVideoEnv.externalFunc.getLoginUin() % 100);
        if (asList != null && !asList.isEmpty()) {
            if (asList.size() == 1 && asList.contains(valueOf.toString())) {
                return true;
            }
            if (asList.size() == 2) {
                try {
                    long parseLong = Long.parseLong((String) asList.get(0));
                    long parseLong2 = Long.parseLong((String) asList.get(1));
                    long j3 = parseLong2 > parseLong ? parseLong : parseLong2;
                    if (parseLong2 > parseLong) {
                        parseLong = parseLong2;
                    }
                    if (j3 <= valueOf.longValue()) {
                        if (parseLong >= valueOf.longValue()) {
                            return true;
                        }
                    }
                } catch (Exception e16) {
                    PlayerUtils.log(6, f279797e, "check uin error = " + e16);
                }
            }
        }
        return false;
    }

    private boolean c(String str) {
        PlayerUtils.log(4, f279797e, "current mobile model = " + DeviceInfoMonitor.getModel() + ", allow model = " + str);
        String[] split = str.split(",");
        if (split == null || split.length == 0 || (split.length > 0 && split[0].equals("default"))) {
            return true;
        }
        List asList = Arrays.asList(split);
        DeviceInfoMonitor.getModel();
        return (asList == null || asList.isEmpty() || !asList.contains(DeviceInfoMonitor.getModel())) ? false : true;
    }

    private boolean d(String str) {
        String str2 = f279797e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("current mobile version = ");
        int i3 = Build.VERSION.SDK_INT;
        sb5.append(i3);
        sb5.append(", allow version = ");
        sb5.append(str);
        PlayerUtils.log(4, str2, sb5.toString());
        String[] split = str.split(",");
        if (split == null || split.length == 0 || (split.length > 0 && split[0].equals("default"))) {
            return true;
        }
        List asList = Arrays.asList(split);
        return (asList == null || asList.isEmpty() || !asList.contains(Integer.valueOf(i3).toString())) ? false : true;
    }

    private boolean f(String str) {
        PlayerUtils.log(4, f279797e, "current mobile model = " + DeviceInfoMonitor.getModel() + ", forbidden model = " + str);
        String[] split = str.split(",");
        if (split != null && split.length != 0 && (split.length <= 0 || !split[0].equals("default"))) {
            List asList = Arrays.asList(split);
            DeviceInfoMonitor.getModel();
            if (asList != null && !asList.isEmpty() && asList.contains(DeviceInfoMonitor.getModel())) {
                return false;
            }
        }
        return true;
    }

    public static HeroPlayerAvailableCheck h() {
        if (f279798f == null) {
            synchronized (HeroPlayerAvailableCheck.class) {
                if (f279798f == null) {
                    f279798f = new HeroPlayerAvailableCheck();
                }
            }
        }
        return f279798f;
    }

    public List<VideoDecoderType.DecoderType> e(String str) {
        PlayerUtils.log(4, f279797e, "forbidden type = " + str);
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(",");
        if (split != null) {
            List asList = Arrays.asList(split);
            for (Map.Entry<String, VideoDecoderType.DecoderType> entry : this.f279802d.entrySet()) {
                if (!asList.contains(entry.getKey())) {
                    arrayList.add(entry.getValue());
                }
            }
        }
        return arrayList;
    }

    public List<VideoDecoderType.DecoderType> g() {
        String[] split;
        List<VideoDecoderType.DecoderType> list = this.f279801c;
        if (list != null && !list.isEmpty()) {
            return this.f279801c;
        }
        String str = this.f279799a;
        if (str != null && (split = str.split("\\|")) != null && split.length >= 6) {
            if (c(split[1]) && f(split[2]) && d(split[3]) && a(split[4]) && b(split[5])) {
                this.f279801c = e(split[0]);
            }
        }
        return this.f279801c;
    }

    public boolean i(VideoDecoderType.DecoderType decoderType) {
        List<VideoDecoderType.DecoderType> g16 = g();
        return (g16 == null || g16.isEmpty() || !g16.contains(decoderType)) ? false : true;
    }
}
