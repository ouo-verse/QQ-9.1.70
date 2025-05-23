package com.tencent.paysdk.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\u0016\u0010\nR\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b\u0019\u0010&\"\u0004\b'\u0010(R\"\u0010,\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b\u001f\u0010&\"\u0004\b+\u0010(R\"\u0010/\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010%\u001a\u0004\b$\u0010&\"\u0004\b.\u0010(R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010:\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010%\u001a\u0004\b8\u0010&\"\u0004\b9\u0010(R\"\u0010@\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010<\u001a\u0004\b-\u0010=\"\u0004\b>\u0010?R\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010<\u001a\u0004\b*\u0010=\"\u0004\bA\u0010?R\"\u0010D\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0006\u001a\u0004\b1\u0010\b\"\u0004\bC\u0010\nR&\u0010G\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010F\u00a8\u0006K"}, d2 = {"Lcom/tencent/paysdk/data/VideoInfo;", "", "Lorg/json/JSONObject;", "p", "", "a", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "vid", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "cid", "c", "setLid", "lid", "d", "setPid", "pid", "e", "setChid", "chid", "Lcom/tencent/paysdk/data/VideoInfo$PlayerType;", "f", "Lcom/tencent/paysdk/data/VideoInfo$PlayerType;", "()Lcom/tencent/paysdk/data/VideoInfo$PlayerType;", "r", "(Lcom/tencent/paysdk/data/VideoInfo$PlayerType;)V", "playerType", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", "title", "", h.F, "J", "()J", ReportConstant.COSTREPORT_PREFIX, "(J)V", "preTime", "i", "setPreviewCount", "previewCount", "j", "setRestPreviewCount", "restPreviewCount", "", "k", "Z", "o", "()Z", "setMainCamera", "(Z)V", "isMainCamera", "l", "setStartPreviewTime", "startPreviewTime", "", "I", "()I", "t", "(I)V", "rewardAdEnable", "setRewardAdCurrentPoint", "rewardAdCurrentPoint", "setRewardAdList", "rewardAdList", "", "Ljava/util/Map;", "bizParams", "<init>", "()V", "PlayerType", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class VideoInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String vid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String chid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PlayerType playerType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long preTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long previewCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long restPreviewCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isMainCamera;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long startPreviewTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int rewardAdEnable;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int rewardAdCurrentPoint;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String rewardAdList;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> bizParams;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/paysdk/data/VideoInfo$PlayerType;", "", "(Ljava/lang/String;I)V", "UNSPECIFIED", "VOD", "LIVE", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes22.dex */
    public static final class PlayerType {
        private static final /* synthetic */ PlayerType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PlayerType LIVE;
        public static final PlayerType UNSPECIFIED;
        public static final PlayerType VOD;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12451);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            PlayerType playerType = new PlayerType("UNSPECIFIED", 0);
            UNSPECIFIED = playerType;
            PlayerType playerType2 = new PlayerType("VOD", 1);
            VOD = playerType2;
            PlayerType playerType3 = new PlayerType("LIVE", 2);
            LIVE = playerType3;
            $VALUES = new PlayerType[]{playerType, playerType2, playerType3};
        }

        PlayerType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            }
        }

        public static PlayerType valueOf(String str) {
            return (PlayerType) Enum.valueOf(PlayerType.class, str);
        }

        public static PlayerType[] values() {
            return (PlayerType[]) $VALUES.clone();
        }
    }

    public VideoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        this.vid = "";
        this.cid = "";
        this.lid = "";
        this.pid = "";
        this.chid = "";
        this.playerType = PlayerType.UNSPECIFIED;
        this.title = "";
        this.isMainCamera = true;
        this.rewardAdList = "";
        this.bizParams = new LinkedHashMap();
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.chid;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.cid;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.lid;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.pid;
    }

    @NotNull
    public final PlayerType e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (PlayerType) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.playerType;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.preTime;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.previewCount;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.restPreviewCount;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return this.rewardAdCurrentPoint;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.rewardAdEnable;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.rewardAdList;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        return this.startPreviewTime;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.title;
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.vid;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.isMainCamera;
    }

    @NotNull
    public final JSONObject p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (JSONObject) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return new JSONObject(this.bizParams);
    }

    public final void q(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cid = str;
        }
    }

    public final void r(@NotNull PlayerType playerType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) playerType);
        } else {
            Intrinsics.checkNotNullParameter(playerType, "<set-?>");
            this.playerType = playerType;
        }
    }

    public final void s(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            this.preTime = j3;
        }
    }

    public final void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.rewardAdEnable = i3;
        }
    }

    public final void u(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }
    }

    public final void v(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.vid = str;
        }
    }
}
