package com.tencent.mobileqq.guild.media.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.l;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelPermissionHelper;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.media.core.m;
import com.tencent.mobileqq.guild.media.core.notify.ac;
import com.tencent.mobileqq.guild.media.core.notify.ae;
import com.tencent.mobileqq.guild.media.core.notify.ap;
import com.tencent.mobileqq.guild.media.core.notify.ax;
import com.tencent.mobileqq.guild.media.core.notify.be;
import com.tencent.mobileqq.guild.media.core.notify.bi;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.model.AudioQueueState;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.eh;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\n*\u0006CGKOSW\u0018\u0000 ]2\u00020\u0001:\u0002^_B\u0007\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"JA\u0010-\u001a\u00020\u00042#\u0010)\u001a\u001f\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u0004\u0018\u00010%2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*J\u0014\u0010.\u001a\u00020\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*J\u0006\u0010/\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\u0002J\u0006\u00101\u001a\u00020\u0002J\u000e\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0002J\u0006\u00104\u001a\u00020\u0002J\u000e\u00105\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0002J\u0006\u00106\u001a\u00020\u0004R0\u0010?\u001a\u0010\u0012\f\u0012\n 8*\u0004\u0018\u00010\"0\"078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R0\u0010\u0017\u001a\u0010\u0012\f\u0012\n 8*\u0004\u0018\u00010\u00020\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/guild/media/viewmodel/b;", "Landroidx/lifecycle/ViewModel;", "", "k2", "", "p2", "t2", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper;", "d2", "Lcom/tencent/mobileqq/guild/media/core/l;", "b2", ICustomDataEditor.NUMBER_PARAM_2, "", "hintString", ICustomDataEditor.STRING_PARAM_2, "micEnable", "Landroid/content/Context;", "context", "e2", "m2", "X1", "U1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "isMicEnable", "Lcom/tencent/mobileqq/guild/media/viewmodel/b$b;", "callback", "needChangeUIImmediately", "f2", "j2", "r2", "init", "q2", "enable", "u2", "Lcom/tencent/mobileqq/guild/media/viewmodel/MicState;", "state", "v2", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "enableMic", "reportClick", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "fragmentReference", "i2", "S1", "W1", "T1", "R1", "isMicOn", SemanticAttributes.DbSystemValues.H2, "Z1", "o2", "g2", "Le12/e;", "kotlin.jvm.PlatformType", "i", "Le12/e;", "c2", "()Le12/e;", "setMicState", "(Le12/e;)V", "micState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l2", "setMicEnable", "com/tencent/mobileqq/guild/media/viewmodel/b$j", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/viewmodel/b$j;", "userObtainSpeakRightObserver", "com/tencent/mobileqq/guild/media/viewmodel/b$k", "D", "Lcom/tencent/mobileqq/guild/media/viewmodel/b$k;", "userTalkPermissionUpdateEvent", "com/tencent/mobileqq/guild/media/viewmodel/b$i", "E", "Lcom/tencent/mobileqq/guild/media/viewmodel/b$i;", "userMicVolumeUpdateEvent", "com/tencent/mobileqq/guild/media/viewmodel/b$g", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/viewmodel/b$g;", "mThirdAppInfoUpdateEvent", "com/tencent/mobileqq/guild/media/viewmodel/b$h", "G", "Lcom/tencent/mobileqq/guild/media/viewmodel/b$h;", "multiRoomUpdateEvent", "com/tencent/mobileqq/guild/media/viewmodel/b$d", "H", "Lcom/tencent/mobileqq/guild/media/viewmodel/b$d;", "audioQueueStateChangeEvent", "<init>", "()V", "I", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e12.e<MicState> micState = new e12.e<>(MicState.MIC_STATE_OFF);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e12.e<Boolean> isMicEnable = new e12.e<>(Boolean.FALSE);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final j userObtainSpeakRightObserver = new j();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final k userTalkPermissionUpdateEvent = new k();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final i userMicVolumeUpdateEvent = new i();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final g mThirdAppInfoUpdateEvent = new g();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final h multiRoomUpdateEvent = new h();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final d audioQueueStateChangeEvent = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/viewmodel/b$b;", "", "Lcom/tencent/mobileqq/guild/media/viewmodel/MicState;", "state", "", "micEnable", "", "errMsg", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.viewmodel.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC7841b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.guild.media.viewmodel.b$b$a */
        /* loaded from: classes14.dex */
        public static final class a {
            public static /* synthetic */ void a(InterfaceC7841b interfaceC7841b, MicState micState, boolean z16, String str, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 4) != 0) {
                        str = "";
                    }
                    interfaceC7841b.a(micState, z16, str);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onClickMic");
            }
        }

        void a(@NotNull MicState state, boolean micEnable, @NotNull String errMsg);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229613a;

        static {
            int[] iArr = new int[MediaChannelRaiseHandHelper.RaiseHandState.values().length];
            try {
                iArr[MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_NOT_CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_CLICKED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_HAS_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f229613a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/viewmodel/b$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/c;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements o<com.tencent.mobileqq.guild.media.core.notify.c> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.c event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getAudioQueueState() == AudioQueueState.AUDIO_QUEUE_CLOSE) {
                if (b.this.k2()) {
                    b.this.u2(false);
                    b.this.v2(MicState.MIC_STATE_OFF);
                } else {
                    b.this.v2(MicState.MIC_STATE_GONE);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/media/viewmodel/b$e", "Lcom/tencent/mobileqq/guild/media/viewmodel/b$b;", "Lcom/tencent/mobileqq/guild/media/viewmodel/MicState;", "state", "", "micEnable", "", "errMsg", "", "a", "<init>", "(Lcom/tencent/mobileqq/guild/media/viewmodel/b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements InterfaceC7841b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f229615a;

        public e(@NotNull b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f229615a = this$0;
        }

        @Override // com.tencent.mobileqq.guild.media.viewmodel.b.InterfaceC7841b
        public void a(@NotNull MicState state, boolean micEnable, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f229615a.v2(state);
            this.f229615a.u2(micEnable);
            this.f229615a.s2(errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/viewmodel/b$f", "Lcom/tencent/mobileqq/guild/media/core/i;", "", "result", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.i {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f229617b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InterfaceC7841b f229618c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IGProGuildInfo f229619d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IGProChannelInfo f229620e;

        f(boolean z16, InterfaceC7841b interfaceC7841b, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
            this.f229617b = z16;
            this.f229618c = interfaceC7841b;
            this.f229619d = iGProGuildInfo;
            this.f229620e = iGProChannelInfo;
        }

        @Override // com.tencent.mobileqq.guild.media.core.i
        public void onResult(int result, @NotNull String errMsg) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Integer num;
            String str6;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            boolean Z1 = b.this.Z1();
            Logger logger = Logger.f235387a;
            boolean z16 = this.f229617b;
            IGProGuildInfo iGProGuildInfo = this.f229619d;
            IGProChannelInfo iGProChannelInfo = this.f229620e;
            Logger.a d16 = logger.d();
            Integer num2 = null;
            if (iGProGuildInfo != null) {
                str = iGProGuildInfo.getGuildID();
            } else {
                str = null;
            }
            if (iGProChannelInfo != null) {
                str2 = iGProChannelInfo.getChannelUin();
            } else {
                str2 = null;
            }
            d16.d("GuildMediaMicStateViewModel", 1, "[handleVoiceAfterCheck.onResult] result = " + result + ", mMicEnabled = " + z16 + ", isMicInActive = " + Z1 + ", guild = " + str + ", channelId = " + str2);
            if (result == 0) {
                boolean z17 = this.f229617b;
                if (!z17 || !Z1) {
                    b.this.r2(z17);
                } else {
                    InterfaceC7841b interfaceC7841b = this.f229618c;
                    MicState micState = MicState.MIC_STATE_IN_ACTIVE;
                    String string = BaseApplication.getContext().getString(R.string.f140070cz);
                    Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026uild_audio_in_active_mic)");
                    interfaceC7841b.a(micState, true, string);
                }
                b.this.u2(this.f229617b);
                return;
            }
            boolean W1 = b.this.W1();
            if (result != 10004 && W1) {
                this.f229618c.a(MicState.MIC_STATE_OFF, false, errMsg);
            } else {
                this.f229618c.a(MicState.MIC_STATE_DISABLE, false, errMsg);
            }
            boolean z18 = this.f229617b;
            IGProGuildInfo iGProGuildInfo2 = this.f229619d;
            if (iGProGuildInfo2 != null) {
                str3 = iGProGuildInfo2.getGuildID();
            } else {
                str3 = null;
            }
            IGProChannelInfo iGProChannelInfo2 = this.f229620e;
            if (iGProChannelInfo2 != null) {
                str4 = iGProChannelInfo2.getChannelUin();
            } else {
                str4 = null;
            }
            QLog.e("GuildMediaMicStateViewModel", 1, "handleVoiceAfterCheck result = " + result + ", errorMsg = " + errMsg + ", mMicEnabled = " + z18 + ", canTalkInChannel = " + W1 + ", guild = " + str3 + ", channelId = " + str4);
            HashMap hashMap = new HashMap();
            IGProGuildInfo iGProGuildInfo3 = this.f229619d;
            if (iGProGuildInfo3 != null) {
                str5 = iGProGuildInfo3.getGuildID();
            } else {
                str5 = null;
            }
            hashMap.put("sgrp_channel_id", str5);
            IGProGuildInfo iGProGuildInfo4 = this.f229619d;
            if (iGProGuildInfo4 != null) {
                num = Integer.valueOf(iGProGuildInfo4.getUserType());
            } else {
                num = null;
            }
            hashMap.put("sgrp_user_type", num);
            IGProChannelInfo iGProChannelInfo3 = this.f229620e;
            if (iGProChannelInfo3 != null) {
                str6 = iGProChannelInfo3.getChannelUin();
            } else {
                str6 = null;
            }
            hashMap.put("sgrp_sub_channel_id", str6);
            IGProChannelInfo iGProChannelInfo4 = this.f229620e;
            if (iGProChannelInfo4 != null) {
                num2 = Integer.valueOf(iGProChannelInfo4.getType());
            }
            hashMap.put("sgrp_sub_channel_type", num2);
            VideoReport.reportEvent("ev_sgrp_wzaudience_nospeak_notice", hashMap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/viewmodel/b$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ax;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements o<ax> {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ax event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.i("GuildMediaMicStateViewModel", 1, "ThirdAppInfoUpdateEvent selfIsMicOn " + m.m(b.this.b2()));
            b bVar = b.this;
            bVar.h2(m.m(bVar.b2()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/viewmodel/b$h", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ae;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements o<ae> {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ae event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.i("GuildMediaMicStateViewModel", 1, "MultiRoomUpdateTalkEvent canTalk: " + event.getCanTalk());
            b bVar = b.this;
            bVar.h2(m.m(bVar.b2()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/viewmodel/b$i", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/be;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i implements o<be> {
        i() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull be event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.i("GuildMediaMicStateViewModel", 1, "UserMicVolumeUpdateEvent: volume[" + event.getCom.tencent.mobileqq.tritonaudio.InnerAudioPlugin.AUDIO_PROPERTY_VOLUME java.lang.String() + "] sealMic[" + event.getSealMic() + "]");
            b bVar = b.this;
            bVar.h2(m.m(bVar.b2()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/viewmodel/b$j", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ap;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j implements o<ap> {
        j() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ap event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.i("GuildMediaMicStateViewModel", 1, "SelfRaiseHandStateUpdateEvent RaiseHandState " + b.this.d2().getSelfRaiseHandState());
            b bVar = b.this;
            bVar.h2(m.m(bVar.b2()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/viewmodel/b$k", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bi;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k implements o<bi> {
        k() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull bi event) {
            Intrinsics.checkNotNullParameter(event, "event");
            QLog.i("GuildMediaMicStateViewModel", 1, "UserTalkPermissionUpdateEvent selfIsMicOn " + m.m(b.this.b2()));
            b bVar = b.this;
            bVar.h2(m.m(bVar.b2()));
        }
    }

    private final boolean U1() {
        int userAVState = com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().C.getUserAVInfo().getUserAVState();
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        if (mediaChannelUtils.u(com.tencent.mobileqq.guild.media.core.j.a().E()) && mediaChannelUtils.D(userAVState)) {
            return true;
        }
        return false;
    }

    private final boolean X1() {
        if (com.tencent.mobileqq.guild.media.core.j.a().T().getSelfRaiseHandState() == MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_HAS_RIGHT) {
            return true;
        }
        return false;
    }

    private final boolean a2() {
        return com.tencent.mobileqq.guild.media.core.j.a().d0().n1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l b2() {
        return com.tencent.mobileqq.guild.media.core.j.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaChannelRaiseHandHelper d2() {
        return com.tencent.mobileqq.guild.media.core.j.a().T();
    }

    private final void e2(boolean micEnable, Context context) {
        if (com.tencent.mobileqq.guild.media.core.j.a().s() && micEnable) {
            QQToast.makeText(context, R.string.f140480e3, 0).show();
        } else {
            f2(micEnable, new e(this), m2());
        }
    }

    private final void f2(boolean isMicEnable, InterfaceC7841b callback, boolean needChangeUIImmediately) {
        if (needChangeUIImmediately) {
            if (isMicEnable) {
                InterfaceC7841b.a.a(callback, MicState.MIC_STATE_ON, true, null, 4, null);
            } else {
                InterfaceC7841b.a.a(callback, MicState.MIC_STATE_OFF, false, null, 4, null);
            }
        }
        j2(isMicEnable, callback);
    }

    private final void j2(boolean micEnable, InterfaceC7841b callback) {
        boolean z16;
        IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (MediaChannelUtils.f228046a.u(com.tencent.mobileqq.guild.media.core.j.a().E()) && !micEnable) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.guild.media.core.j.a().J().c(micEnable, z16, new f(micEnable, callback, guildInfo, channelInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k2() {
        if (!ch.m0(com.tencent.mobileqq.guild.media.core.j.a().getGuildID()) && !ch.h0(com.tencent.mobileqq.guild.media.core.j.a().E()) && !MediaChannelUtils.f228046a.t(b2().getSelfUserInfo())) {
            return false;
        }
        return true;
    }

    private final boolean m2() {
        if (!W1() && !X1()) {
            return false;
        }
        return true;
    }

    private final boolean n2() {
        if ((MediaChannelUtils.f228046a.u(com.tencent.mobileqq.guild.media.core.j.a().E()) && !k2()) || d2().X0()) {
            return true;
        }
        return false;
    }

    private final void p2() {
        com.tencent.mobileqq.guild.media.core.j.d().V(ap.class, this.userObtainSpeakRightObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(bi.class, this.userTalkPermissionUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(be.class, this.userMicVolumeUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(ax.class, this.mThirdAppInfoUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(ae.class, this.multiRoomUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.c.class, this.audioQueueStateChangeEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(boolean micEnable) {
        com.tencent.mobileqq.guild.media.core.j.d().i(new ac(micEnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s2(Object hintString) {
        boolean z16 = hintString instanceof String;
        if (z16 && StringUtil.isEmpty((String) hintString)) {
            return;
        }
        if (z16) {
            MediaChannelUtils.Q(MediaChannelUtils.f228046a, (String) hintString, null, 2, null);
        } else if (hintString instanceof Integer) {
            MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
            String string = BaseApplication.getContext().getString(((Number) hintString).intValue());
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(hintString)");
            MediaChannelUtils.Q(mediaChannelUtils, string, null, 2, null);
        }
    }

    private final void t2() {
        com.tencent.mobileqq.guild.media.core.j.d().j(ap.class, this.userObtainSpeakRightObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(bi.class, this.userTalkPermissionUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(be.class, this.userMicVolumeUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(ax.class, this.mThirdAppInfoUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(ae.class, this.multiRoomUpdateEvent);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.c.class, this.audioQueueStateChangeEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(String guildId, int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Logger.f235387a.d().i("GuildMediaMicStateViewModel", 1, "setGuildListTop end. with guildId=" + guildId + " code=" + i3 + " errMsg=" + str);
    }

    public final boolean R1() {
        String str;
        IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
        String str2 = null;
        if (guildInfo != null) {
            str = guildInfo.getGuildID();
        } else {
            str = null;
        }
        if (!com.tencent.mobileqq.guild.setting.mute.c.l(str)) {
            if (guildInfo != null) {
                str2 = guildInfo.getGuildID();
            }
            if (!ch.s(str2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean S1(@NotNull WeakReference<Fragment> fragmentReference) {
        String str;
        String str2;
        String str3;
        FragmentActivity requireActivity;
        String guildID;
        FragmentActivity fragmentActivity;
        Intrinsics.checkNotNullParameter(fragmentReference, "fragmentReference");
        if (Z1()) {
            s2(Integer.valueOf(R.string.f140070cz));
            return false;
        }
        IGProGuildInfo guildInfo = com.tencent.mobileqq.guild.media.core.j.a().getGuildInfo();
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        if (!R1()) {
            v2(MicState.MIC_STATE_DISABLE);
            String str4 = null;
            if (guildInfo != null) {
                str = guildInfo.getGuildID();
            } else {
                str = null;
            }
            if (ch.s(str)) {
                Fragment fragment = fragmentReference.get();
                if (fragment != null) {
                    fragmentActivity = fragment.requireActivity();
                } else {
                    fragmentActivity = null;
                }
                if (guildInfo != null) {
                    str4 = guildInfo.getGuildID();
                }
                ch.h1(fragmentActivity, str4);
                return false;
            }
            if (com.tencent.mobileqq.guild.media.core.j.a().S().i0()) {
                Fragment fragment2 = fragmentReference.get();
                if (fragment2 != null && (requireActivity = fragment2.requireActivity()) != null && guildInfo != null && (guildID = guildInfo.getGuildID()) != null) {
                    sz1.c.d(requireActivity, guildID);
                }
                return false;
            }
            if (guildInfo != null) {
                str2 = guildInfo.getGuildID();
            } else {
                str2 = null;
            }
            if (channelInfo != null) {
                str3 = channelInfo.getChannelUin();
            } else {
                str3 = null;
            }
            String w3 = com.tencent.mobileqq.guild.setting.mute.c.w(str2, str3);
            if (!TextUtils.isEmpty(w3)) {
                MediaChannelUtils.Q(MediaChannelUtils.f228046a, w3, null, 2, null);
            }
            return false;
        }
        return true;
    }

    public final boolean T1() {
        return m.i(com.tencent.mobileqq.guild.media.core.j.c());
    }

    public final boolean W1() {
        return com.tencent.mobileqq.guild.media.core.j.a().S().getSelfTalkPermission();
    }

    public final boolean Z1() {
        return m.l(com.tencent.mobileqq.guild.media.core.j.c());
    }

    @NotNull
    public final e12.e<MicState> c2() {
        return this.micState;
    }

    public final void g2() {
        if (m.j(b2())) {
            v2(MicState.MIC_STATE_DISABLE);
            return;
        }
        if (Z1()) {
            v2(MicState.MIC_STATE_IN_ACTIVE);
            return;
        }
        if (com.tencent.mobileqq.guild.media.core.j.a().d0().m1()) {
            v2(MicState.MIC_STATE_DISABLE);
            return;
        }
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        if (mediaChannelUtils.u(com.tencent.mobileqq.guild.media.core.j.a().E())) {
            if (mediaChannelUtils.D(b2().getSelfUserInfo().C.getUserAVInfo().getUserAVState())) {
                if (m.m(b2())) {
                    v2(MicState.MIC_STATE_ON);
                    return;
                } else {
                    v2(MicState.MIC_STATE_OFF);
                    return;
                }
            }
            v2(MicState.MIC_STATE_GONE);
            return;
        }
        int i3 = c.f229613a[d2().getSelfRaiseHandState().ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                v2(MicState.MIC_STATE_DISABLE);
                return;
            } else if (m.m(b2())) {
                v2(MicState.MIC_STATE_ON);
                return;
            } else {
                v2(MicState.MIC_STATE_OFF);
                return;
            }
        }
        v2(MicState.MIC_STATE_GONE);
    }

    public final void h2(boolean isMicOn) {
        boolean z16 = false;
        boolean U = MediaChannelPermissionHelper.U(com.tencent.mobileqq.guild.media.core.j.a().S(), false, false, 3, null);
        boolean Z1 = Z1();
        if (isMicOn && U) {
            z16 = true;
        }
        u2(z16);
        Logger.f235387a.d().d("GuildMediaMicStateViewModel", 1, "[handleMicStateChanged] canTalk[" + U + "], isMicInActive[" + Z1 + "], isMicOn[" + isMicOn + "], mMicEnabled[" + l2().getValue() + "]");
        if (U) {
            if (Z1) {
                v2(MicState.MIC_STATE_IN_ACTIVE);
                return;
            }
            Boolean value = this.isMicEnable.getValue();
            Intrinsics.checkNotNull(value);
            if (value.booleanValue()) {
                v2(MicState.MIC_STATE_ON);
                return;
            } else {
                v2(MicState.MIC_STATE_OFF);
                return;
            }
        }
        v2(MicState.MIC_STATE_DISABLE);
    }

    public final void i2(@Nullable Function1<? super Boolean, Unit> reportClick, @NotNull Context context, @NotNull WeakReference<Fragment> fragmentReference) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentReference, "fragmentReference");
        if (reportClick != null) {
            Boolean value = this.isMicEnable.getValue();
            Intrinsics.checkNotNull(value);
            reportClick.invoke(value);
        }
        if (S1(fragmentReference)) {
            Intrinsics.checkNotNull(this.isMicEnable.getValue());
            e2(!r2.booleanValue(), context);
        }
    }

    public final void init() {
        p2();
    }

    @NotNull
    public final e12.e<Boolean> l2() {
        return this.isMicEnable;
    }

    public final boolean o2(boolean isMicOn) {
        boolean z16;
        if (isMicOn && (W1() || X1() || U1() || a2())) {
            z16 = true;
        } else {
            z16 = false;
        }
        u2(z16);
        return z16;
    }

    public final void q2() {
        t2();
    }

    public final void u2(boolean enable) {
        QLog.d("GuildMediaMicStateViewModel", 1, "updateMicEnable: " + enable);
        this.isMicEnable.postValue(Boolean.valueOf(enable));
    }

    public final void v2(@NotNull MicState state) {
        MicState micState;
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == MicState.MIC_STATE_DISABLE && n2()) {
            micState = MicState.MIC_STATE_GONE;
        } else {
            micState = state;
        }
        QLog.d("GuildMediaMicStateViewModel", 1, "updateMicState: " + state);
        if (this.micState.getValue() != micState && micState == MicState.MIC_STATE_ON) {
            final String guildID = com.tencent.mobileqq.guild.media.core.j.a().getGuildID();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null) {
                iGPSService.setGuildListTop(guildID, 1, 2, new eh() { // from class: com.tencent.mobileqq.guild.media.viewmodel.a
                    @Override // wh2.eh
                    public final void a(int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
                        b.w2(guildID, i3, str, iGProGuildListSortInfo);
                    }
                });
            }
        }
        this.micState.postValue(micState);
    }
}
