package com.tencent.mobileqq.guild.media;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.EnterChannelState;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.core.notify.ThirdAppBarClickEvent;
import com.tencent.mobileqq.guild.media.core.notify.bb;
import com.tencent.mobileqq.guild.media.thirdapp.ContentSize;
import com.tencent.mobileqq.guild.media.thirdapp.ScreenMode;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.media.widget.MediaChannelDialogFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\nkosw{\u007f\u0082\u0001\u0086\u0001\u0018\u0000 \u008c\u00012\u00020\u0001:\u0002\u008d\u0001B\t\u00a2\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\bJ\b\u0010\u000f\u001a\u00020\bH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0002R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0006\u00a2\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0006\u00a2\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010,R%\u00107\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00040\u00040(8\u0006\u00a2\u0006\f\n\u0004\b5\u0010*\u001a\u0004\b6\u0010,R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u0002080(8\u0006\u00a2\u0006\f\n\u0004\b9\u0010*\u001a\u0004\b:\u0010,R%\u0010>\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00040\u00040(8\u0006\u00a2\u0006\f\n\u0004\b<\u0010*\u001a\u0004\b=\u0010,R\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020F0(8\u0006\u00a2\u0006\f\n\u0004\bG\u0010*\u001a\u0004\bH\u0010,R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020J0(8\u0006\u00a2\u0006\f\n\u0004\bK\u0010*\u001a\u0004\bL\u0010,R\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020N0(8\u0006\u00a2\u0006\f\n\u0004\bO\u0010*\u001a\u0004\bP\u0010,R\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020R0(8\u0006\u00a2\u0006\f\n\u0004\bS\u0010*\u001a\u0004\bT\u0010,R\u001d\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0(8\u0006\u00a2\u0006\f\n\u0004\bW\u0010*\u001a\u0004\bX\u0010,R\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020Z0(8\u0006\u00a2\u0006\f\n\u0004\b[\u0010*\u001a\u0004\b\\\u0010,R\u001d\u0010d\u001a\b\u0012\u0004\u0012\u00020_0^8\u0006\u00a2\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010v\u001a\u00020s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010~\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0016\u0010\u0081\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b@\u0010\u0080\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel;", "Landroidx/lifecycle/ViewModel;", "", "S1", "", "e2", "Lcom/tencent/mobileqq/guild/media/thirdapp/a;", "contentSize", "", "l2", "X1", "Landroid/os/Bundle;", "bundle", "init", "g2", "onCleared", "d2", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "i", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "i2", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getChannelInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", SemanticAttributes.DbSystemValues.H2, "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "channelInfo", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "T1", "()Landroid/os/Bundle;", "k2", "(Landroid/os/Bundle;)V", "startMediaChannelFragmentArguments", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/MutableLiveData;", "toLandView", "E", "c2", "underNeedImmersiveView", UserInfo.SEX_FEMALE, "b2", "toPortraitFullScreen", "kotlin.jvm.PlatformType", "G", "P1", "needExitPage", "Lcom/tencent/mobileqq/guild/media/core/notify/n;", "H", "f2", "isShowGuestView", "I", "Q1", "needOrientationSensor", "J", "Z", "R1", "()Z", "j2", "(Z)V", "noNeedDetectionImmersive", "Lcom/tencent/mobileqq/guild/media/core/notify/b;", "K", "L1", "audioQueueSpeakStartEvent", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "L", "U1", "switchThemeEvent", "Lcom/tencent/mobileqq/guild/media/core/notify/u;", "M", "N1", "listenStateEvent", "Lcom/tencent/mobileqq/guild/media/core/notify/v;", "N", "O1", "listenTipsEvent", "Lcom/tencent/mobileqq/guild/media/core/notify/bb;", "P", "Z1", "thirdAppShowInputEvent", "Lcom/tencent/mobileqq/guild/media/core/notify/ThirdAppBarClickEvent;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "W1", "thirdAppBarClickEvent", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/guild/media/core/EnterChannelState;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "enterChannelState", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "startFrom", "T", "Lcom/tencent/mobileqq/guild/media/thirdapp/a;", "thirdAppPlaceHolderSize", "com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$b", "U", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$b;", "audioQueueSpeakStartObserver", "com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$f", "V", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$f;", "switchThemeEventObserver", "com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$d", "W", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$d;", "listenStateObserver", "com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$e", "X", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$e;", "listenTipsObserver", "com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$g", "Y", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$g;", "thirdAppInputObserver", "com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$h", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$h;", "thirdAppPortraitStatusObserver", "com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$c", "a0", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$c;", "guestStateChangedEventObserver", "com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$mAudioRoomObserver$1", "b0", "Lcom/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$mAudioRoomObserver$1;", "mAudioRoomObserver", "<init>", "()V", "c0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaChannelViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    public Bundle startMediaChannelFragmentArguments;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> toLandView = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> underNeedImmersiveView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> toPortraitFullScreen;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> needExitPage;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.n> isShowGuestView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> needOrientationSensor;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean noNeedDetectionImmersive;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.b> audioQueueSpeakStartEvent;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<SwitchThemeEvent> switchThemeEvent;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.u> listenStateEvent;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.v> listenTipsEvent;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<bb> thirdAppShowInputEvent;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ThirdAppBarClickEvent> thirdAppBarClickEvent;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LiveData<EnterChannelState> enterChannelState;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String startFrom;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private ContentSize thirdAppPlaceHolderSize;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final b audioQueueSpeakStartObserver;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final f switchThemeEventObserver;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final d listenStateObserver;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final e listenTipsObserver;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final g thirdAppInputObserver;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final h thirdAppPortraitStatusObserver;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c guestStateChangedEventObserver;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMediaChannelViewModel$mAudioRoomObserver$1 mAudioRoomObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public IGProGuildInfo guildInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public IGProChannelInfo channelInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/b;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.b> {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.b event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMediaChannelViewModel.this.L1().setValue(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/n;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.n> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.n event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMediaChannelViewModel.this.f2().setValue(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$d", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/u;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.u> {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.u event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMediaChannelViewModel.this.N1().setValue(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/v;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<com.tencent.mobileqq.guild.media.core.notify.v> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull com.tencent.mobileqq.guild.media.core.notify.v event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMediaChannelViewModel.this.O1().setValue(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$f", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        f() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMediaChannelViewModel.this.U1().setValue(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$g", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/bb;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.media.core.notify.o<bb> {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull bb event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMediaChannelViewModel.this.Z1().setValue(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/GuildMediaChannelViewModel$h", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ThirdAppBarClickEvent;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements com.tencent.mobileqq.guild.media.core.notify.o<ThirdAppBarClickEvent> {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull ThirdAppBarClickEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GuildMediaChannelViewModel.this.W1().setValue(event);
        }
    }

    /* JADX WARN: Type inference failed for: r0v27, types: [com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel$mAudioRoomObserver$1] */
    public GuildMediaChannelViewModel() {
        Boolean bool = Boolean.FALSE;
        this.underNeedImmersiveView = new MutableLiveData<>(bool);
        this.toPortraitFullScreen = new MutableLiveData<>(bool);
        this.needExitPage = new MutableLiveData<>(bool);
        this.isShowGuestView = new MutableLiveData<>();
        this.needOrientationSensor = new MutableLiveData<>(bool);
        this.audioQueueSpeakStartEvent = new MutableLiveData<>();
        this.switchThemeEvent = new MutableLiveData<>();
        this.listenStateEvent = new MutableLiveData<>();
        this.listenTipsEvent = new MutableLiveData<>();
        this.thirdAppShowInputEvent = new MutableLiveData<>();
        this.thirdAppBarClickEvent = new MutableLiveData<>();
        this.enterChannelState = com.tencent.mobileqq.guild.media.core.j.c().l();
        this.startFrom = MediaChannelCore.INSTANCE.a().o0().getStartParams().getSourceType();
        this.thirdAppPlaceHolderSize = new ContentSize(0, 0, 0, 0, ScreenMode.UNKNOWN);
        this.audioQueueSpeakStartObserver = new b();
        this.switchThemeEventObserver = new f();
        this.listenStateObserver = new d();
        this.listenTipsObserver = new e();
        this.thirdAppInputObserver = new g();
        this.thirdAppPortraitStatusObserver = new h();
        this.guestStateChangedEventObserver = new c();
        this.mAudioRoomObserver = new com.tencent.mobileqq.guild.media.core.notify.y() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel$mAudioRoomObserver$1
            private final boolean B(String reason) {
                boolean z16;
                boolean isBlank;
                if (reason != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(reason);
                    if (!isBlank) {
                        z16 = true;
                        if (!z16 && !Intrinsics.areEqual(reason, "\u5f53\u524d\u7528\u6237\u4e0d\u5728\u6b64\u623f\u95f4\u7528\u6237\u5217\u8868\u5185")) {
                            return true;
                        }
                    }
                }
                z16 = false;
                return !z16 ? false : false;
            }

            @Override // com.tencent.mobileqq.guild.media.core.notify.y
            public void t(@Nullable String guildId, @Nullable String channelId, @Nullable String reason) {
                QLog.i("QGMC.GuildMediaChannelViewModel", 1, "[onExit] guildId: " + guildId + ", channelId: " + channelId + ", reason: " + reason);
                if (reason != null && B(reason)) {
                    MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
                    if (mediaChannelUtils.z()) {
                        final GuildMediaChannelViewModel guildMediaChannelViewModel = GuildMediaChannelViewModel.this;
                        mediaChannelUtils.P(reason, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel$mAudioRoomObserver$1$onExit$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                GuildMediaChannelViewModel.this.P1().setValue(Boolean.TRUE);
                            }
                        });
                        return;
                    }
                    String btnContent = QQGuildUIUtil.r(R.string.f146610un);
                    MediaChannelDialogFragment.a aVar = MediaChannelDialogFragment.C;
                    Intrinsics.checkNotNullExpressionValue(btnContent, "btnContent");
                    aVar.a(reason, btnContent);
                    GuildMediaChannelViewModel.this.P1().setValue(Boolean.TRUE);
                    return;
                }
                GuildMediaChannelViewModel.this.P1().setValue(Boolean.TRUE);
            }

            @Override // com.tencent.mobileqq.guild.media.core.notify.y
            public void z(@Nullable String userId, boolean available) {
                QLog.i("QGMC.GuildMediaChannelViewModel", 1, "[onUserVideoAvailable] userId: " + userId + ", " + available);
                if (!available) {
                    GuildMediaChannelViewModel.this.c2().postValue(Boolean.FALSE);
                }
            }
        };
    }

    private final void d2() {
        com.tencent.mobileqq.guild.media.core.j.d().V(SwitchThemeEvent.class, this.switchThemeEventObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.b.class, this.audioQueueSpeakStartObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.u.class, this.listenStateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.v.class, this.listenTipsObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(bb.class, this.thirdAppInputObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(ThirdAppBarClickEvent.class, this.thirdAppPortraitStatusObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(com.tencent.mobileqq.guild.media.core.notify.n.class, this.guestStateChangedEventObserver);
    }

    @NotNull
    public final MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.b> L1() {
        return this.audioQueueSpeakStartEvent;
    }

    @NotNull
    public final LiveData<EnterChannelState> M1() {
        return this.enterChannelState;
    }

    @NotNull
    public final MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.u> N1() {
        return this.listenStateEvent;
    }

    @NotNull
    public final MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.v> O1() {
        return this.listenTipsEvent;
    }

    @NotNull
    public final MutableLiveData<Boolean> P1() {
        return this.needExitPage;
    }

    @NotNull
    public final MutableLiveData<Boolean> Q1() {
        return this.needOrientationSensor;
    }

    /* renamed from: R1, reason: from getter */
    public final boolean getNoNeedDetectionImmersive() {
        return this.noNeedDetectionImmersive;
    }

    @NotNull
    /* renamed from: S1, reason: from getter */
    public final String getStartFrom() {
        return this.startFrom;
    }

    @NotNull
    public final Bundle T1() {
        Bundle bundle = this.startMediaChannelFragmentArguments;
        if (bundle != null) {
            return bundle;
        }
        Intrinsics.throwUninitializedPropertyAccessException("startMediaChannelFragmentArguments");
        return null;
    }

    @NotNull
    public final MutableLiveData<SwitchThemeEvent> U1() {
        return this.switchThemeEvent;
    }

    @NotNull
    public final MutableLiveData<ThirdAppBarClickEvent> W1() {
        return this.thirdAppBarClickEvent;
    }

    @NotNull
    /* renamed from: X1, reason: from getter */
    public final ContentSize getThirdAppPlaceHolderSize() {
        return this.thirdAppPlaceHolderSize;
    }

    @NotNull
    public final MutableLiveData<bb> Z1() {
        return this.thirdAppShowInputEvent;
    }

    @NotNull
    public final MutableLiveData<Boolean> a2() {
        return this.toLandView;
    }

    @NotNull
    public final MutableLiveData<Boolean> b2() {
        return this.toPortraitFullScreen;
    }

    @NotNull
    public final MutableLiveData<Boolean> c2() {
        return this.underNeedImmersiveView;
    }

    public final boolean e2() {
        return com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().R;
    }

    @NotNull
    public final MutableLiveData<com.tencent.mobileqq.guild.media.core.notify.n> f2() {
        return this.isShowGuestView;
    }

    public final void g2() {
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mAudioRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(SwitchThemeEvent.class, this.switchThemeEventObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.b.class, this.audioQueueSpeakStartObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.u.class, this.listenStateObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.v.class, this.listenTipsObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(bb.class, this.thirdAppInputObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(ThirdAppBarClickEvent.class, this.thirdAppPortraitStatusObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(com.tencent.mobileqq.guild.media.core.notify.n.class, this.guestStateChangedEventObserver);
    }

    @NotNull
    public final IGProChannelInfo getChannelInfo() {
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        if (iGProChannelInfo != null) {
            return iGProChannelInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channelInfo");
        return null;
    }

    @NotNull
    public final IGProGuildInfo getGuildInfo() {
        IGProGuildInfo iGProGuildInfo = this.guildInfo;
        if (iGProGuildInfo != null) {
            return iGProGuildInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
        return null;
    }

    public final void h2(@NotNull IGProChannelInfo iGProChannelInfo) {
        Intrinsics.checkNotNullParameter(iGProChannelInfo, "<set-?>");
        this.channelInfo = iGProChannelInfo;
    }

    public final void i2(@NotNull IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(iGProGuildInfo, "<set-?>");
        this.guildInfo = iGProGuildInfo;
    }

    public final void init(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Object obj = bundle.get("extra_guild_guild_info");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo");
        i2((IGProGuildInfo) obj);
        Object obj2 = bundle.get("extra_guild_channel_info");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo");
        h2((IGProChannelInfo) obj2);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mAudioRoomObserver);
        d2();
        this.startFrom = MediaChannelCore.INSTANCE.a().o0().getStartParams().getSourceType();
    }

    public final void j2(boolean z16) {
        this.noNeedDetectionImmersive = z16;
    }

    public final void k2(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.startMediaChannelFragmentArguments = bundle;
    }

    public final void l2(@NotNull final ContentSize contentSize) {
        Intrinsics.checkNotNullParameter(contentSize, "contentSize");
        if (Intrinsics.areEqual(this.thirdAppPlaceHolderSize, contentSize)) {
            return;
        }
        Logger.f235387a.d().d("QGMC.GuildMediaChannelViewModel", 1, "[setThirdAppPlaceHolderSize] contentSize " + contentSize);
        this.thirdAppPlaceHolderSize = contentSize;
        String E1 = com.tencent.mobileqq.guild.media.core.j.a().d0().E1();
        final GuildMediaWebIPCServer a16 = GuildMediaWebIPCServer.INSTANCE.a();
        a16.i(E1, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.GuildMediaChannelViewModel$setThirdAppPlaceHolderSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Logger.f235387a.d().d("QGMC.GuildMediaChannelViewModel", 1, "[setThirdAppPlaceHolderSize] checkIfAttach " + z16);
                if (z16) {
                    GuildMediaWebIPCServer.this.s(new ToolProcessIntent.NotifyWebScreenChangedIntent(contentSize.getTopPlaceHolder(), contentSize.getLeftPlaceHolder(), contentSize.getRightPlaceHolder(), contentSize.getBottomPlaceHolder(), contentSize.getScreenMode()));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QLog.i("QGMC.GuildMediaChannelViewModel", 1, "onCleared");
    }
}
