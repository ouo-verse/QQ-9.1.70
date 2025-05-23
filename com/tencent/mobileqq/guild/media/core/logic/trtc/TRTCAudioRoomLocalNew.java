package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.data.MediaRoomStatus;
import com.tencent.mobileqq.guild.media.core.logic.EnterTrtcRoomReq;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ai;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.cv;
import com.tencent.mobileqq.qqguildsdk.data.genc.fd;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.aw;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bq\u0010rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0007H\u0016J \u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\u0018\u0010-\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\u0012\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u0012\u00106\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0012\u00109\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u0004H\u0016J(\u0010A\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\t2\u0006\u0010@\u001a\u00020?H\u0016J\b\u0010B\u001a\u00020\u0004H\u0016J\u0018\u0010F\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\t2\u0006\u0010E\u001a\u00020DH\u0016J\b\u0010G\u001a\u00020\u0004H\u0016J\u0010\u0010H\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0007H\u0016J\b\u0010I\u001a\u00020\u0004H\u0016J\u0010\u0010J\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\tH\u0016J\b\u0010K\u001a\u00020\u0004H\u0016J\b\u0010L\u001a\u00020\u0004H\u0016J\u0012\u0010N\u001a\u00020\u00042\b\u0010M\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010R\u001a\u00020\u00042\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0OH\u0016J2\u0010X\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\t2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020?2\b\u0010W\u001a\u0004\u0018\u00010VH\u0016J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0016J\u0010\u0010Z\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0016J\u0010\u0010[\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0007H\u0016J\u0018\u0010]\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\u0007H\u0016J\u0018\u0010^\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0010\u0010_\u001a\u00020?2\u0006\u0010S\u001a\u00020\u0007H\u0016J\u0010\u0010`\u001a\u00020?2\u0006\u0010>\u001a\u00020\tH\u0016J\u0018\u0010c\u001a\u0012\u0012\u0004\u0012\u00020P0aj\b\u0012\u0004\u0012\u00020P`bH\u0016J\b\u0010d\u001a\u00020\u0004H\u0016R\u0014\u0010g\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010lR\u0016\u0010 \u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010LR\u0014\u0010p\u001a\u00020n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010o\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/TRTCAudioRoomLocalNew;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom;", "Landroid/content/Context;", "context", "", "U", "a0", "", "resCode", "", "msg", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$a;", "callback", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/r;", "V", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/l;", "W", "", "audioIsOpen", "i", "Lcom/tencent/mobileqq/guild/media/core/logic/l;", "req", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "subRoomId", "f", "targetRoomId", "l", "isInited", "userId", "mute", "muteRemoteAudio", "playId", "H", "soPath", "r", "y", "B", "d", "roomId", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "mode", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Intent;", "intent", "X", "Lcom/tencent/mobileqq/guild/media/core/logic/i;", "bgMusicObserver", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "listener", UserInfo.SEX_FEMALE, "setMusicPlayoutVolume", "setRemoteAudioVolume", "K", "publish", "path", "", "startTimeMs", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tinyId", "Landroid/view/Surface;", "surface", "w", "a", "p", "o", "e", "Y", "Z", "privateMapKey", "E", "", "Lcom/tencent/mobileqq/guild/media/core/data/g;", "trtcRoomIdList", "c", "id", "loopCount", "startTime", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/u;", "observer", "v", "J", "t", "g", "targetTime", "G", "D", "u", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", tl.h.F, "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ag;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ag;", "roomRouteHelper", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/z;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/z;", "bgMusicHelper", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ac;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ac;", "openMusicHelper", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class TRTCAudioRoomLocalNew implements ITRTCAudioRoom {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final HashSet<Integer> f228508g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<TRTCAudioRoomLocalNew> f228509h;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile z bgMusicHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile ac openMusicHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isInited;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ag roomRouteHelper = new ag();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u001b\u0010\f\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0012j\b\u0012\u0004\u0012\u00020\r`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/TRTCAudioRoomLocalNew$a;", "", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/TRTCAudioRoomLocalNew;", "a", "Landroid/content/Intent;", "data", "", "c", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/media/core/logic/trtc/TRTCAudioRoomLocalNew;", "sInstance", "", "AUDIO_VOLUME_EVALUATION", "I", "ERROR_CODE_ID_NOT_EXIST", "ERROR_CODE_PARAM_INVALID", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "OPEN_MUSIC_ID_SET", "Ljava/util/HashSet;", "ROOM_TYPE_MAIN", "ROOM_TYPE_SUB", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCAudioRoomLocalNew$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final TRTCAudioRoomLocalNew b() {
            return (TRTCAudioRoomLocalNew) TRTCAudioRoomLocalNew.f228509h.getValue();
        }

        @JvmStatic
        @NotNull
        public final TRTCAudioRoomLocalNew a() {
            return b();
        }

        @JvmStatic
        public final void c(@Nullable Intent data) {
            b().V().p0(data);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/trtc/TRTCAudioRoomLocalNew$b", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ai$a;", "", "code", "", "errMsg", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ai.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f228516b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ITRTCAudioRoom.a f228517c;

        b(Context context, ITRTCAudioRoom.a aVar) {
            this.f228516b = context;
            this.f228517c = aVar;
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ai.a
        public void a(int code, @Nullable String errMsg) {
            QLog.i("QGMC.TRTCAudioRoomLocal", 1, "onLoadResult code:" + code);
            if (code == 0) {
                TRTCAudioRoomLocalNew.this.U(this.f228516b);
                TRTCAudioRoomLocalNew tRTCAudioRoomLocalNew = TRTCAudioRoomLocalNew.this;
                if (errMsg == null) {
                    errMsg = "";
                }
                tRTCAudioRoomLocalNew.R(code, errMsg, this.f228517c);
                return;
            }
            QLog.e("QGMC.TRTCAudioRoomLocal", 1, "onLoadResult " + ("so_LoadFail: " + errMsg));
            TRTCAudioRoomLocalNew.this.R(-1, "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", this.f228517c);
        }
    }

    static {
        Lazy<TRTCAudioRoomLocalNew> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<TRTCAudioRoomLocalNew>() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.TRTCAudioRoomLocalNew$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TRTCAudioRoomLocalNew invoke() {
                return new TRTCAudioRoomLocalNew();
            }
        });
        f228509h = lazy;
    }

    private final f Q() {
        z zVar;
        if (this.bgMusicHelper == null) {
            this.bgMusicHelper = new z();
        }
        if (V().W() && (zVar = this.bgMusicHelper) != null) {
            zVar.h(V().T());
        }
        z zVar2 = this.bgMusicHelper;
        Intrinsics.checkNotNull(zVar2);
        return zVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(final int resCode, final String msg2, final ITRTCAudioRoom.a callback) {
        if (callback == null) {
            return;
        }
        boolean areEqual = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        QLog.d("QGMC.TRTCAudioRoomLocal", 4, "callPrepareResult, isMainThread:" + areEqual);
        if (areEqual) {
            callback.onCallback(resCode, msg2);
        } else {
            this.mainHandler.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.x
                @Override // java.lang.Runnable
                public final void run() {
                    TRTCAudioRoomLocalNew.S(ITRTCAudioRoom.a.this, resCode, msg2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ITRTCAudioRoom.a aVar, int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        aVar.onCallback(i3, msg2);
    }

    @JvmStatic
    @NotNull
    public static final TRTCAudioRoomLocalNew T() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(Context context) {
        if (this.isInited) {
            QLog.i("QGMC.TRTCAudioRoomLocal", 1, "isInited, ignore.");
        } else {
            y(context);
            this.isInited = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r V() {
        return this.roomRouteHelper.getMainTRTCRoom();
    }

    private final l W() {
        ac acVar;
        if (this.openMusicHelper == null) {
            this.openMusicHelper = new ac();
        }
        if (V().W() && (acVar = this.openMusicHelper) != null) {
            acVar.x(V().T());
        }
        ac acVar2 = this.openMusicHelper;
        Intrinsics.checkNotNull(acVar2);
        return acVar2;
    }

    private final void a0() {
        IRuntimeService runtimeService = ch.l().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface().getRuntim\u2026ssConstant.MAIN\n        )");
        ((IGPSService) runtimeService).getChannelHeartbeat(com.tencent.mobileqq.guild.media.core.j.a().getGuildID(), com.tencent.mobileqq.guild.media.core.j.a().E(), new aw() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.y
            @Override // vh2.aw
            public final void a(int i3, cv cvVar) {
                TRTCAudioRoomLocalNew.b0(TRTCAudioRoomLocalNew.this, i3, cvVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(TRTCAudioRoomLocalNew this$0, int i3, cv cvVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            return;
        }
        String G = this$0.roomRouteHelper.G();
        fd i16 = cvVar.i();
        if (i16 != null) {
            i16.h(G);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void A() {
        V().A();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void B() {
        this.roomRouteHelper.B();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public long C(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return W().C(path);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int D(int id5, int volume) {
        if (volume >= 0 && volume <= 100) {
            return W().D(id5, volume);
        }
        return -10002;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void E(@Nullable String privateMapKey) {
        if (privateMapKey == null) {
            privateMapKey = "";
        }
        if (TextUtils.isEmpty(privateMapKey)) {
            QLog.e("QGMC.TRTCAudioRoomLocal", 1, "updatePrivateMapKey empty\uff0cplease check!");
        } else {
            this.roomRouteHelper.E(privateMapKey);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void F(@Nullable ITRTCAudioRoom.b listener) {
        this.roomRouteHelper.F(listener);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int G(int id5, int targetTime) {
        return W().G(id5, targetTime);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void H(int playId) {
        Q().H(playId);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void I(@Nullable ITRTCAudioRoom.a callback) {
        QLog.i("QGMC.TRTCAudioRoomLocal", 1, "exit room.");
        this.mainHandler.removeCallbacksAndMessages(null);
        this.roomRouteHelper.I(callback);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int J(int id5) {
        return W().J(id5);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void K() {
        QLog.i("QGMC.TRTCAudioRoomLocal", 1, "startMicrophone.");
        this.roomRouteHelper.K();
    }

    public void X(@Nullable Intent intent) {
        QLog.d("QGMC.TRTCAudioRoomLocal", 1, "setCaptureIntent ");
        V().p0(intent);
    }

    public void Y() {
        this.roomRouteHelper.L();
    }

    public void Z() {
        this.roomRouteHelper.M();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom, com.tencent.mobileqq.guild.media.core.logic.trtc.d
    public void a() {
        QLog.i("QGMC.TRTCAudioRoomLocal", 1, "stopMicrophone.");
        this.roomRouteHelper.a();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void b(int mode) {
        QLog.i("QGMC.TRTCAudioRoomLocal", 1, "setAudioMode " + mode);
        this.roomRouteHelper.b(mode);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void c(@NotNull List<MediaRoomStatus> trtcRoomIdList) {
        Intrinsics.checkNotNullParameter(trtcRoomIdList, "trtcRoomIdList");
        this.roomRouteHelper.c(trtcRoomIdList);
        a0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void d() {
        this.roomRouteHelper.d();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void e(@NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        V().e(tinyId);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void f(@NotNull String subRoomId, @Nullable ITRTCAudioRoom.a callback) {
        Intrinsics.checkNotNullParameter(subRoomId, "subRoomId");
        this.roomRouteHelper.f(subRoomId, callback);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int g(int id5) {
        return W().g(id5);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public void h() {
        W().h();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void i(boolean audioIsOpen) {
        QLog.d("QGMC.TRTCAudioRoomLocal", 1, "enableAudioRecord " + audioIsOpen);
        this.roomRouteHelper.i(audioIsOpen);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    /* renamed from: isInited, reason: from getter */
    public boolean getIsInited() {
        return this.isInited;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    @NotNull
    public ArrayList<MediaRoomStatus> j() {
        return this.roomRouteHelper.j();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void k(@NotNull EnterTrtcRoomReq req, @Nullable ITRTCAudioRoom.a callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        this.roomRouteHelper.k(req, callback);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void l(@Nullable String targetRoomId) {
        this.roomRouteHelper.l(targetRoomId);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void m(@NotNull EnterTrtcRoomReq req, @Nullable ITRTCAudioRoom.a callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        this.roomRouteHelper.m(req, callback);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void muteRemoteAudio(@NotNull String userId, boolean mute) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        QLog.i("QGMC.TRTCAudioRoomLocal", 1, "mute remote audio, user id:" + userId + " mute:" + mute);
        this.roomRouteHelper.muteRemoteAudio(userId, mute);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void n(@Nullable com.tencent.mobileqq.guild.media.core.logic.i bgMusicObserver) {
        Q().n(bgMusicObserver);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void o() {
        V().o();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void p(int playId) {
        Q().p(playId);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public int q() {
        return this.roomRouteHelper.q();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void r(@NotNull Context context, @NotNull String soPath, @NotNull ITRTCAudioRoom.a callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(soPath, "soPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("QGMC.TRTCAudioRoomLocal", 1, "prepare context:" + context + ", mIsInited:" + this.isInited);
        if (this.isInited) {
            y(context);
            R(0, "", callback);
        } else {
            ai.d(soPath, new b(context, callback));
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void setMusicPlayoutVolume(int playId, int volume) {
        Q().setMusicPlayoutVolume(playId, volume);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void setRemoteAudioVolume(@NotNull String userId, int volume) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        QLog.d("QGMC.TRTCAudioRoomLocal", 4, "setRemoteAudioVolume userId:" + userId + ", volume:" + volume);
        this.roomRouteHelper.setRemoteAudioVolume(userId, volume);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int t(int id5) {
        return W().t(id5);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public long u(int id5) {
        return W().u(id5);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.l
    public int v(int id5, @NotNull String path, int loopCount, long startTime, @Nullable u observer) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (id5 >= 0 && !TextUtils.isEmpty(path)) {
            return W().v(id5, path, loopCount, startTime, observer);
        }
        return -10002;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void w(@NotNull String tinyId, @NotNull Surface surface) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(surface, "surface");
        V().w(tinyId, surface);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.f
    public void x(int playId, boolean publish, @NotNull String path, long startTimeMs) {
        Intrinsics.checkNotNullParameter(path, "path");
        Q().x(playId, publish, path, startTimeMs);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public void y(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.guild.media.core.w.b("QGMC.TRTCAudioRoomLocal", "requireTrtcInstance");
        V().y(context);
        z zVar = this.bgMusicHelper;
        if (zVar != null) {
            zVar.h(V().T());
        }
        ac acVar = this.openMusicHelper;
        if (acVar != null) {
            acVar.x(V().T());
        }
        com.tencent.mobileqq.guild.media.core.w.a("QGMC.TRTCAudioRoomLocal", "requireTrtcInstance");
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom
    public boolean z(@NotNull String roomId, int volume) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        return this.roomRouteHelper.z(roomId, volume);
    }
}
