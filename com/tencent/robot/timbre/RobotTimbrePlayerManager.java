package com.tencent.robot.timbre;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.TtsInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 L2\u00020\u0001:\u0002MNB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u001a\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000eJ \u0010\u0013\u001a\u00020\u00062\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0011J\u001a\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000eJ\u001a\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000eJ\u001a\u0010\u0019\u001a\u00020\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000eJ \u0010\u001c\u001a\u00020\u00062\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u0011J\u001c\u0010 \u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010#\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\"\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010%\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010$\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010'\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010&\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010)\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010(\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010*\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010+\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JH\u0010-\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u0011H\u0002JH\u0010.\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u001c\b\u0002\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J\u0010\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u00102\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001aH\u0002R\u0016\u00105\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R$\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010<R$\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010<R$\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010<R*\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR$\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010<R*\u0010F\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010AR\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006O"}, d2 = {"Lcom/tencent/robot/timbre/RobotTimbrePlayerManager;", "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioPlayerBase$b;", "", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "ttsInfo", "", "y", "v", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function1;", "downloadStart", "p", "Lkotlin/Function2;", "downloadCompleted", "o", "onStart", "t", "onCancel", "k", "onCompleted", "l", "", "onFailed", "r", "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioPlayerBase;", "player", "sourcePath", "W8", "", "errorCode", "k9", "streamType", "j5", "volumeType", "Tg", "currentPosition", "V3", "f9", "j", "onSuccess", "e", h.F, HippyTKDListViewAdapter.X, "u", "path", "w", "d", "Lcom/tencent/mobileqq/qqaudio/audioplayer/AudioPlayerBase;", "audioPlayer", "Lcom/tencent/robot/timbre/RobotTimbrePlayerManager$b;", "Lcom/tencent/robot/timbre/RobotTimbrePlayerManager$b;", "currentPlayerTtsInfo", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "pendingPlayTtsInfo", "Lkotlin/jvm/functions/Function1;", "onStartPlay", "onCancelPlay", "onCompletedPlay", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "onPlayFailed", "D", "onDownloadStart", "E", "onDownloadCompleted", UserInfo.SEX_FEMALE, "Z", "isResume", "<init>", "()V", "G", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotTimbrePlayerManager implements AudioPlayerBase.b {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function2<? super TtsInfo, ? super String, Unit> onPlayFailed;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<? super TtsInfo, Unit> onDownloadStart;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function2<? super Boolean, ? super TtsInfo, Unit> onDownloadCompleted;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isResume;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AudioPlayerBase audioPlayer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PlayTtsInfo currentPlayerTtsInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TtsInfo pendingPlayTtsInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super TtsInfo, Unit> onStartPlay;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super TtsInfo, Unit> onCancelPlay;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super TtsInfo, Unit> onCompletedPlay;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/timbre/RobotTimbrePlayerManager$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;", "ttsInfo", "Ljava/lang/String;", "()Ljava/lang/String;", "path", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/TtsInfo;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.timbre.RobotTimbrePlayerManager$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class PlayTtsInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final TtsInfo ttsInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String path;

        public PlayTtsInfo(@NotNull TtsInfo ttsInfo, @NotNull String path) {
            Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
            Intrinsics.checkNotNullParameter(path, "path");
            this.ttsInfo = ttsInfo;
            this.path = path;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final TtsInfo getTtsInfo() {
            return this.ttsInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlayTtsInfo)) {
                return false;
            }
            PlayTtsInfo playTtsInfo = (PlayTtsInfo) other;
            if (Intrinsics.areEqual(this.ttsInfo, playTtsInfo.ttsInfo) && Intrinsics.areEqual(this.path, playTtsInfo.path)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.ttsInfo.hashCode() * 31) + this.path.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlayTtsInfo(ttsInfo=" + this.ttsInfo + ", path=" + this.path + ")";
        }
    }

    private final void e(final TtsInfo ttsInfo, final Function2<? super TtsInfo, ? super String, Unit> onFailed, final Function2<? super TtsInfo, ? super String, Unit> onSuccess) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.timbre.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotTimbrePlayerManager.f(RobotTimbrePlayerManager.this, ttsInfo, onFailed, onSuccess);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(RobotTimbrePlayerManager this$0, TtsInfo ttsInfo, Function2 function2, Function2 onSuccess) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsInfo, "$ttsInfo");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        this$0.h(ttsInfo, function2, onSuccess);
    }

    private final void h(final TtsInfo ttsInfo, final Function2<? super TtsInfo, ? super String, Unit> onFailed, final Function2<? super TtsInfo, ? super String, Unit> onSuccess) {
        String str = ttsInfo.ttsExample;
        Intrinsics.checkNotNullExpressionValue(str, "ttsInfo.ttsExample");
        d dVar = d.f368605a;
        String c16 = dVar.c();
        String str2 = ttsInfo.ttsExample;
        Intrinsics.checkNotNullExpressionValue(str2, "ttsInfo.ttsExample");
        String str3 = ttsInfo.ttsId;
        Intrinsics.checkNotNullExpressionValue(str3, "ttsInfo.ttsId");
        t64.a.c(str, c16, dVar.a(str2, str3), new Function1<String, Unit>() { // from class: com.tencent.robot.timbre.RobotTimbrePlayerManager$downloadTimbreFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str4) {
                invoke2(str4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                onSuccess.invoke(ttsInfo, it);
            }
        }, new Function1<String, Unit>() { // from class: com.tencent.robot.timbre.RobotTimbrePlayerManager$downloadTimbreFile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str4) {
                invoke2(str4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function2<TtsInfo, String, Unit> function2 = onFailed;
                if (function2 != null) {
                    function2.invoke(ttsInfo, it);
                }
            }
        });
    }

    private final boolean j(TtsInfo ttsInfo) {
        TtsInfo ttsInfo2;
        PlayTtsInfo playTtsInfo = this.currentPlayerTtsInfo;
        if (playTtsInfo != null) {
            ttsInfo2 = playTtsInfo.getTtsInfo();
        } else {
            ttsInfo2 = null;
        }
        return Intrinsics.areEqual(ttsInfo2, ttsInfo);
    }

    private final void u(TtsInfo ttsInfo) {
        Unit unit;
        this.pendingPlayTtsInfo = ttsInfo;
        d dVar = d.f368605a;
        String str = ttsInfo.ttsExample;
        Intrinsics.checkNotNullExpressionValue(str, "ttsInfo.ttsExample");
        String str2 = ttsInfo.ttsId;
        Intrinsics.checkNotNullExpressionValue(str2, "ttsInfo.ttsId");
        String d16 = dVar.d(str, str2);
        if (d16 != null) {
            w(ttsInfo, d16);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Function1<? super TtsInfo, Unit> function1 = this.onDownloadStart;
            if (function1 != null) {
                function1.invoke(ttsInfo);
            }
            e(ttsInfo, new RobotTimbrePlayerManager$playTimbreAudio$2$1(this), new RobotTimbrePlayerManager$playTimbreAudio$2$2(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(TtsInfo ttsInfo, String path) {
        if (!Intrinsics.areEqual(ttsInfo, this.pendingPlayTtsInfo)) {
            if (QLog.isColorLevel()) {
                QLog.i("RobotTimbrePlayerManager", 2, "startPlayInner ttsInfo: " + ttsInfo + ", pendingPlayTtsInfo: " + this.pendingPlayTtsInfo + ", is not equal");
                return;
            }
            return;
        }
        AudioPlayerBase audioPlayerBase = null;
        this.pendingPlayTtsInfo = null;
        if (QLog.isColorLevel()) {
            QLog.i("RobotTimbrePlayerManager", 2, "startPlayInner ttsInfo: " + ttsInfo + ", path: " + path);
        }
        if (!this.isResume) {
            if (QLog.isColorLevel()) {
                QLog.i("RobotTimbrePlayerManager", 2, "startPlayInner not isResume return,  ttsInfo: " + ttsInfo);
                return;
            }
            return;
        }
        x();
        Function1<? super TtsInfo, Unit> function1 = this.onStartPlay;
        if (function1 != null) {
            function1.invoke(ttsInfo);
        }
        this.currentPlayerTtsInfo = new PlayTtsInfo(ttsInfo, path);
        AudioPlayerBase audioPlayerBase2 = this.audioPlayer;
        if (audioPlayerBase2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
        } else {
            audioPlayerBase = audioPlayerBase2;
        }
        audioPlayerBase.u(path);
    }

    private final void x() {
        AudioPlayerBase audioPlayerBase = this.audioPlayer;
        AudioPlayerBase audioPlayerBase2 = null;
        if (audioPlayerBase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
            audioPlayerBase = null;
        }
        if (audioPlayerBase.r()) {
            AudioPlayerBase audioPlayerBase3 = this.audioPlayer;
            if (audioPlayerBase3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
            } else {
                audioPlayerBase2 = audioPlayerBase3;
            }
            audioPlayerBase2.stop();
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void W8(@Nullable AudioPlayerBase player, @Nullable String sourcePath) {
        Function1<? super TtsInfo, Unit> function1;
        PlayTtsInfo playTtsInfo = this.currentPlayerTtsInfo;
        if (playTtsInfo != null && Intrinsics.areEqual(playTtsInfo.getPath(), sourcePath) && (function1 = this.onCompletedPlay) != null) {
            function1.invoke(playTtsInfo.getTtsInfo());
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void f9(@Nullable AudioPlayerBase player, @Nullable String sourcePath) {
        Function1<? super TtsInfo, Unit> function1;
        PlayTtsInfo playTtsInfo = this.currentPlayerTtsInfo;
        if (playTtsInfo != null && Intrinsics.areEqual(playTtsInfo.getPath(), sourcePath) && (function1 = this.onCancelPlay) != null) {
            function1.invoke(playTtsInfo.getTtsInfo());
        }
    }

    public final void g(@NotNull TtsInfo ttsInfo) {
        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
        if (Intrinsics.areEqual(ttsInfo, this.pendingPlayTtsInfo)) {
            this.pendingPlayTtsInfo = null;
        }
    }

    public final boolean i() {
        AudioPlayerBase audioPlayerBase = this.audioPlayer;
        if (audioPlayerBase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
            audioPlayerBase = null;
        }
        return audioPlayerBase.r();
    }

    public final void k(@NotNull Function1<? super TtsInfo, Unit> onCancel) {
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        this.onCancelPlay = onCancel;
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void k9(@Nullable AudioPlayerBase player, int errorCode, @Nullable String sourcePath) {
        Function2<? super TtsInfo, ? super String, Unit> function2;
        if (QLog.isColorLevel()) {
            QLog.e("RobotTimbrePlayerManager", 2, "onError errorCode: " + errorCode + ", sourcePath: " + sourcePath);
        }
        PlayTtsInfo playTtsInfo = this.currentPlayerTtsInfo;
        if (playTtsInfo != null && Intrinsics.areEqual(playTtsInfo.getPath(), sourcePath) && (function2 = this.onPlayFailed) != null) {
            function2.invoke(playTtsInfo.getTtsInfo(), "play error");
        }
    }

    public final void l(@NotNull Function1<? super TtsInfo, Unit> onCompleted) {
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
        this.onCompletedPlay = onCompleted;
    }

    public final void m() {
        if (QLog.isColorLevel()) {
            QLog.i("RobotTimbrePlayerManager", 2, "onCreate");
        }
        AudioPlayer audioPlayer = new AudioPlayer(MobileQQ.sMobileQQ, this);
        audioPlayer.C(10);
        this.audioPlayer = audioPlayer;
    }

    public final void n() {
        if (QLog.isColorLevel()) {
            QLog.i("RobotTimbrePlayerManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.isResume = false;
        AudioPlayerBase audioPlayerBase = this.audioPlayer;
        if (audioPlayerBase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
            audioPlayerBase = null;
        }
        audioPlayerBase.stop();
        AudioPlayerBase audioPlayerBase2 = this.audioPlayer;
        if (audioPlayerBase2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
            audioPlayerBase2 = null;
        }
        audioPlayerBase2.j();
        this.onStartPlay = null;
        this.onCancelPlay = null;
        this.onCompletedPlay = null;
        this.onPlayFailed = null;
        this.onDownloadStart = null;
        this.onDownloadCompleted = null;
    }

    public final void o(@NotNull Function2<? super Boolean, ? super TtsInfo, Unit> downloadCompleted) {
        Intrinsics.checkNotNullParameter(downloadCompleted, "downloadCompleted");
        this.onDownloadCompleted = downloadCompleted;
    }

    public final void p(@NotNull Function1<? super TtsInfo, Unit> downloadStart) {
        Intrinsics.checkNotNullParameter(downloadStart, "downloadStart");
        this.onDownloadStart = downloadStart;
    }

    public final void q() {
        if (QLog.isColorLevel()) {
            QLog.i("RobotTimbrePlayerManager", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.isResume = false;
        AudioPlayerBase audioPlayerBase = this.audioPlayer;
        if (audioPlayerBase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
            audioPlayerBase = null;
        }
        audioPlayerBase.stop();
    }

    public final void r(@NotNull Function2<? super TtsInfo, ? super String, Unit> onFailed) {
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        this.onPlayFailed = onFailed;
    }

    public final void s() {
        this.isResume = true;
    }

    public final void t(@NotNull Function1<? super TtsInfo, Unit> onStart) {
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        this.onStartPlay = onStart;
    }

    public final void v(@NotNull TtsInfo ttsInfo) {
        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
        if (!this.isResume) {
            return;
        }
        AudioPlayerBase audioPlayerBase = this.audioPlayer;
        if (audioPlayerBase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
            audioPlayerBase = null;
        }
        if (!audioPlayerBase.r()) {
            u(ttsInfo);
        } else {
            if (j(ttsInfo)) {
                return;
            }
            x();
            u(ttsInfo);
        }
    }

    public final void y(@NotNull TtsInfo ttsInfo) {
        Intrinsics.checkNotNullParameter(ttsInfo, "ttsInfo");
        AudioPlayerBase audioPlayerBase = this.audioPlayer;
        if (audioPlayerBase == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
            audioPlayerBase = null;
        }
        audioPlayerBase.stop();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void Tg(@Nullable AudioPlayerBase player, int volumeType, @Nullable String sourcePath) {
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void V3(@Nullable AudioPlayerBase player, int currentPosition, @Nullable String sourcePath) {
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.b
    public void j5(@Nullable AudioPlayerBase player, int streamType, @Nullable String sourcePath) {
    }
}
