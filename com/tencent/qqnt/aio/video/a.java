package com.tencent.qqnt.aio.video;

import android.text.TextUtils;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import com.tencent.qqnt.kernel.api.ab;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RMBeaconReportInfo;
import com.tencent.qqnt.kernel.nativeinterface.RMBizTypeEnum;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0002\u0018 B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002Jd\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0017J2\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0017R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R>\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-`\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102RD\u0010:\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\r048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/aio/video/a;", "", "", "uin", "c", "eventId", "eventTime", "storeId", "videoFormat", TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, "playScene", "local", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "g", "", h.F, "f", "isTroop", "isFile", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;", "d", "", "a", "i", "k", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "localPath", "Lcom/tencent/qqnt/aio/video/a$b;", "j", "b", "Ljava/lang/String;", "getVideoPlayId", "()Ljava/lang/String;", "setVideoPlayId", "(Ljava/lang/String;)V", "videoPlayId", "Lcom/tencent/qqnt/aio/video/a$b;", "getVideoReportInfo", "()Lcom/tencent/qqnt/aio/video/a$b;", "setVideoReportInfo", "(Lcom/tencent/qqnt/aio/video/a$b;)V", "videoReportInfo", "", "Ljava/util/HashMap;", "getEventMap", "()Ljava/util/HashMap;", "setEventMap", "(Ljava/util/HashMap;)V", "eventMap", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "getReportInfos", "()Ljava/util/ArrayList;", "setReportInfos", "(Ljava/util/ArrayList;)V", "reportInfos", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoPlayId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b videoReportInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, Long> eventMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<HashMap<String, String>> reportInfos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/video/a$a;", "", "", "BUFFERING_END", "Ljava/lang/String;", "BUFFERING_START", "CREATE_PLAYER", "FIRST_FRAME_RENDERED", "TAG", "VIDEO_ERROR", "VIDEO_PREPARE", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.video.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0019\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\"\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u0018\u0010\u001f\"\u0004\b \u0010!R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/video/a$b;", "", "", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "uin", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;", "i", "(Lcom/tencent/qqnt/kernel/nativeinterface/RMBizTypeEnum;)V", "bizType", "c", "g", "o", "videoFromat", "d", "l", TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, "e", "k", "playScene", "j", "local", "", "I", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "storeID", h.F, "p", "videoMd5", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private RMBizTypeEnum bizType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String videoFromat;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String playType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String playScene;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String local;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int storeID;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String videoMd5;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.uin = "";
            this.bizType = RMBizTypeEnum.KC2CVIDEO;
            this.videoFromat = "";
            this.playType = "";
            this.playScene = "";
            this.local = "";
            this.videoMd5 = "";
        }

        @NotNull
        public final RMBizTypeEnum a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (RMBizTypeEnum) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.bizType;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.local;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.playScene;
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.playType;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return this.storeID;
        }

        @NotNull
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.uin;
        }

        @NotNull
        public final String g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.videoFromat;
        }

        @Nullable
        public final String h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.videoMd5;
        }

        public final void i(@NotNull RMBizTypeEnum rMBizTypeEnum) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) rMBizTypeEnum);
            } else {
                Intrinsics.checkNotNullParameter(rMBizTypeEnum, "<set-?>");
                this.bizType = rMBizTypeEnum;
            }
        }

        public final void j(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.local = str;
            }
        }

        public final void k(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.playScene = str;
            }
        }

        public final void l(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.playType = str;
            }
        }

        public final void m(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, i3);
            } else {
                this.storeID = i3;
            }
        }

        public final void n(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.uin = str;
            }
        }

        public final void o(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.videoFromat = str;
            }
        }

        public final void p(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            } else {
                this.videoMd5 = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.videoPlayId = "";
        this.videoReportInfo = new b();
        this.eventMap = new HashMap<>();
        this.reportInfos = new ArrayList<>();
    }

    private final void a() {
        Set<Map.Entry<String, Long>> entrySet = this.eventMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "eventMap.entries");
        for (Map.Entry<String, Long> entries : entrySet) {
            Intrinsics.checkNotNullExpressionValue(entries, "entries");
            String eventId = entries.getKey();
            Long value = entries.getValue();
            String f16 = this.videoReportInfo.f();
            Intrinsics.checkNotNullExpressionValue(eventId, "eventId");
            this.reportInfos.add(e(f16, eventId, String.valueOf(value.longValue()), String.valueOf(this.videoReportInfo.e()), this.videoReportInfo.g(), this.videoReportInfo.d(), this.videoReportInfo.c(), this.videoReportInfo.b()));
        }
    }

    private final String c(String uin) {
        if (TextUtils.isEmpty(this.videoPlayId)) {
            StringBuffer stringBuffer = new StringBuffer(uin);
            stringBuffer.append("_");
            stringBuffer.append(System.currentTimeMillis());
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "StringBuffer(uin).append\u2026tTimeMillis()).toString()");
            this.videoPlayId = stringBuffer2;
        }
        return this.videoPlayId;
    }

    private final RMBizTypeEnum d(boolean isTroop, boolean isFile) {
        if (isTroop) {
            if (isFile) {
                return RMBizTypeEnum.KGROUPFILE;
            }
            return RMBizTypeEnum.KGROUPVIDEO;
        }
        if (isFile) {
            return RMBizTypeEnum.KC2CFILE;
        }
        return RMBizTypeEnum.KC2CVIDEO;
    }

    private final HashMap<String, String> e(String uin, String eventId, String eventTime, String storeId, String videoFormat, String playType, String playScene, String local) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("video_play_id", c(uin));
        hashMap.put("event_id", eventId);
        hashMap.put("time_cost", g(eventId));
        hashMap.put("time_stamp", eventTime);
        hashMap.put("video_codec_format", videoFormat);
        hashMap.put("video_play_type", playType);
        hashMap.put("video_play_scene", playScene);
        hashMap.put("is_local", local);
        return hashMap;
    }

    private final String f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            String currentUin = peekAppRuntime.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "appRuntime.currentUin");
            return currentUin;
        }
        return "";
    }

    private final String g(String eventId) {
        long j3;
        try {
            if (Intrinsics.areEqual(eventId, "first_frame_rendered") && this.eventMap.get("first_frame_rendered") != null && this.eventMap.get(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH) != null) {
                Long l3 = this.eventMap.get("first_frame_rendered");
                Intrinsics.checkNotNull(l3);
                long longValue = l3.longValue();
                Long l16 = this.eventMap.get(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH);
                Intrinsics.checkNotNull(l16);
                j3 = longValue - l16.longValue();
            } else if (Intrinsics.areEqual(eventId, "buffering_end") && this.eventMap.get("buffering_end") != null && this.eventMap.get("buffering_start") != null) {
                Long l17 = this.eventMap.get("buffering_end");
                Intrinsics.checkNotNull(l17);
                long longValue2 = l17.longValue();
                Long l18 = this.eventMap.get("buffering_start");
                Intrinsics.checkNotNull(l18);
                j3 = longValue2 - l18.longValue();
            } else {
                j3 = 0;
            }
            return String.valueOf(j3);
        } catch (Exception e16) {
            QLog.i("VideoPlayReport", 1, "getTimeCost exception: " + e16.getMessage());
            return "";
        }
    }

    private final boolean h() {
        if (this.eventMap.isEmpty()) {
            return true;
        }
        if (this.eventMap.containsKey(QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_SET_VIDEO_PATH) && !this.eventMap.containsKey("first_frame_rendered")) {
            return true;
        }
        return false;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.videoPlayId = "";
        this.eventMap.clear();
        this.reportInfos.clear();
    }

    public final void i(@NotNull String eventId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) eventId);
        } else {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            this.eventMap.put(eventId, Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Nullable
    public final b j(@NotNull AIOMsgItem aioMsgItem, @NotNull String localPath, @Nullable String videoFormat, @NotNull String playType, @NotNull String playScene) {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (b) iPatchRedirector.redirect((short) 12, this, aioMsgItem, localPath, videoFormat, playType, playScene);
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(playType, "playType");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        this.videoReportInfo.n(f());
        MsgRecord msgRecord = aioMsgItem.getMsgRecord();
        if (msgRecord.chatType == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (msgRecord.msgType != 3) {
            z17 = false;
        }
        this.videoReportInfo.i(d(z16, z17));
        VideoElement videoElement = null;
        FileElement fileElement = null;
        if (z17) {
            MsgElement firstTypeElement = aioMsgItem.getFirstTypeElement(3);
            if (firstTypeElement != null) {
                fileElement = firstTypeElement.getFileElement();
            }
            if (fileElement != null) {
                this.videoReportInfo.p(fileElement.fileMd5);
                this.videoReportInfo.m(fileElement.storeID);
            }
        } else {
            MsgElement firstTypeElement2 = aioMsgItem.getFirstTypeElement(5);
            if (firstTypeElement2 != null) {
                videoElement = firstTypeElement2.getVideoElement();
            }
            if (videoElement != null) {
                b bVar = this.videoReportInfo;
                if (!TextUtils.isEmpty(videoElement.originVideoMd5)) {
                    str = videoElement.originVideoMd5;
                } else {
                    str = videoElement.videoMd5;
                }
                bVar.p(str);
                this.videoReportInfo.m(videoElement.storeID);
            }
        }
        b bVar2 = this.videoReportInfo;
        if (videoFormat == null) {
            videoFormat = "";
        }
        bVar2.o(videoFormat);
        this.videoReportInfo.l(playType);
        this.videoReportInfo.k(playScene);
        b bVar3 = this.videoReportInfo;
        if (RFWFileUtils.isLocalPath(localPath) && RFWFileUtils.fileExists(localPath)) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        bVar3.j(str2);
        return this.videoReportInfo;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (h()) {
            return;
        }
        a();
        RMBeaconReportInfo rMBeaconReportInfo = new RMBeaconReportInfo("nt_transfer", this.videoReportInfo.a(), true, false, this.reportInfos, this.videoReportInfo.e(), 10, this.videoReportInfo.h());
        ab g16 = f.g();
        if (g16 != null) {
            g16.beaconReportRMData(rMBeaconReportInfo);
        }
    }
}
