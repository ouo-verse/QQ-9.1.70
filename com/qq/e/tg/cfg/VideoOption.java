package com.qq.e.tg.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoOption {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f40470a;

    /* renamed from: b, reason: collision with root package name */
    private final int f40471b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f40472c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f40473d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f40474e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f40475f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f40476g;

    /* renamed from: h, reason: collision with root package name */
    private final String f40477h;

    /* renamed from: i, reason: collision with root package name */
    private final int f40478i;

    /* renamed from: j, reason: collision with root package name */
    private final long f40479j;

    /* renamed from: k, reason: collision with root package name */
    private final String f40480k;

    /* renamed from: l, reason: collision with root package name */
    private final int f40481l;

    /* renamed from: m, reason: collision with root package name */
    private final int f40482m;

    /* renamed from: n, reason: collision with root package name */
    private final int f40483n;

    /* renamed from: o, reason: collision with root package name */
    private final int f40484o;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class VideoADContainerRender {
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    VideoOption(Builder builder) {
        this.f40470a = builder.f40485a;
        this.f40471b = builder.f40486b;
        this.f40472c = builder.f40487c;
        this.f40473d = builder.f40488d;
        this.f40474e = builder.f40489e;
        this.f40475f = builder.f40490f;
        this.f40476g = builder.f40495k;
        this.f40477h = builder.f40496l;
        this.f40478i = builder.f40497m;
        this.f40479j = builder.f40491g;
        this.f40480k = builder.f40492h;
        this.f40481l = builder.f40493i;
        this.f40482m = builder.f40494j;
        this.f40483n = builder.f40498n;
        this.f40484o = builder.f40499o;
    }

    public boolean getAutoPlayMuted() {
        return this.f40470a;
    }

    public int getAutoPlayPolicy() {
        return this.f40471b;
    }

    public long getCurrentPlayTime() {
        return this.f40479j;
    }

    public String getEndCardBtnColor() {
        return this.f40477h;
    }

    public int getEndCardBtnRadius() {
        return this.f40478i;
    }

    public boolean getEndCardOpening() {
        return this.f40476g;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f40470a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f40471b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f40475f));
            jSONObject.putOpt("currentPlayTime", Long.valueOf(this.f40479j));
        } catch (Exception e16) {
            GDTLogger.e("Get video options error: " + e16.getMessage());
        }
        return jSONObject;
    }

    public int getVideoHeight() {
        return this.f40482m;
    }

    public String getVideoPath() {
        return this.f40480k;
    }

    public int getVideoVoiceRestoreTime() {
        return this.f40483n;
    }

    public int getVideoVoiceRestoreTtl() {
        return this.f40484o;
    }

    public int getVideoWidth() {
        return this.f40481l;
    }

    public boolean isDetailPageMuted() {
        return this.f40475f;
    }

    public boolean isEnableUserControl() {
        return this.f40474e;
    }

    public boolean isNeedCoverImage() {
        return this.f40473d;
    }

    public boolean isNeedProgressBar() {
        return this.f40472c;
    }

    /* synthetic */ VideoOption(Builder builder, byte b16) {
        this(builder);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: h, reason: collision with root package name */
        private String f40492h;

        /* renamed from: i, reason: collision with root package name */
        private int f40493i;

        /* renamed from: j, reason: collision with root package name */
        private int f40494j;

        /* renamed from: l, reason: collision with root package name */
        private String f40496l;

        /* renamed from: m, reason: collision with root package name */
        private int f40497m;

        /* renamed from: a, reason: collision with root package name */
        private boolean f40485a = true;

        /* renamed from: b, reason: collision with root package name */
        private int f40486b = 1;

        /* renamed from: c, reason: collision with root package name */
        private boolean f40487c = true;

        /* renamed from: d, reason: collision with root package name */
        private boolean f40488d = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f40489e = false;

        /* renamed from: f, reason: collision with root package name */
        private boolean f40490f = false;

        /* renamed from: g, reason: collision with root package name */
        private long f40491g = 0;

        /* renamed from: k, reason: collision with root package name */
        private boolean f40495k = true;

        /* renamed from: n, reason: collision with root package name */
        private int f40498n = 0;

        /* renamed from: o, reason: collision with root package name */
        private int f40499o = 0;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z16) {
            this.f40485a = z16;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i3) {
            if (i3 < 0 || i3 > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i3 = 1;
            }
            this.f40486b = i3;
            return this;
        }

        public final Builder setCurrentPlayTime(long j3) {
            this.f40491g = j3;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z16) {
            this.f40490f = z16;
            return this;
        }

        public final Builder setEnableUserControl(boolean z16) {
            this.f40489e = z16;
            return this;
        }

        public final Builder setEndCardBtnColor(String str) {
            this.f40496l = str;
            return this;
        }

        public final Builder setEndCardBtnRadius(int i3) {
            this.f40497m = i3;
            return this;
        }

        public final Builder setEndCardOpening(boolean z16) {
            this.f40495k = z16;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z16) {
            this.f40488d = z16;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z16) {
            this.f40487c = z16;
            return this;
        }

        public final Builder setVideoHeight(int i3) {
            this.f40494j = i3;
            return this;
        }

        public final Builder setVideoPath(String str) {
            this.f40492h = str;
            return this;
        }

        public final Builder setVideoVoiceRestoreTime(int i3) {
            this.f40498n = i3;
            return this;
        }

        public final Builder setVideoVoiceRestoreTtl(int i3) {
            this.f40499o = i3;
            return this;
        }

        public final Builder setVideoWidth(int i3) {
            this.f40493i = i3;
            return this;
        }

        @Deprecated
        public final Builder setEnableDetailPage(boolean z16) {
            return this;
        }
    }
}
