package com.tencent.mobileqq.vas.api.impl;

import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaTimestamp;
import android.media.PlaybackParams;
import android.os.Build;
import android.util.Size;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.vas.api.IVasAudioApi;
import com.tencent.mobileqq.vas.kuikly.moduleimpl.IVasAudioPlayer$PlayState;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010(\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010'\u001a\u00020#H\u0016JJ\u0010/\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t28\u0010.\u001a4\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u000b\u0018\u00010)H\u0016J5\u00102\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2#\u0010.\u001a\u001f\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000b\u0018\u000100H\u0016J\"\u00106\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u0001032\u0006\u0010,\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0016J\u0012\u00107\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u000103H\u0016J\"\u00108\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u0001032\u0006\u0010,\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0016J\u001a\u0010:\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u001aH\u0016J\u0012\u0010;\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u000103H\u0016J\"\u0010A\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010=2\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u001aH\u0016R\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasAudioApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasAudioApi;", "Landroid/media/MediaPlayer$OnErrorListener;", "Landroid/media/MediaPlayer$OnPreparedListener;", "Landroid/media/MediaPlayer$OnInfoListener;", "Landroid/media/MediaPlayer$OnBufferingUpdateListener;", "Landroid/media/MediaPlayer$OnCompletionListener;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "", "token", "", "checkStateChanged", "", "isPlaying", "bookId", "openLogic", "closeLogic", "path", OperateCustomButton.OPERATE_CREATE, "play", "next", "pause", "resume", "stop", "release", "", com.tencent.luggage.wxa.c8.c.G, "seekTo", "isLoop", "setLoop", "isLooping", "getDuration", "getAudioDuration", "getCurrentPosition", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "setVolume", "getVolume", "speed", "setSpeed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "what", "code", "callback", "setOnErrorListener", "Lkotlin/Function1;", "state", "setPlayStateListener", "Landroid/media/MediaPlayer;", "mp", "extra", "onError", "onPrepared", "onInfo", "percent", "onBufferingUpdate", "onCompletion", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "focusChange", "onAudioFocusChange", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "renderLogicView", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "Landroid/media/AudioManager;", "am", "Landroid/media/AudioManager;", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAudioApiImpl implements IVasAudioApi, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h, AudioManager.OnAudioFocusChangeListener {

    @NotNull
    public static final String AUDIO_LOGIC_EVENT = "vas_audio_logic";

    @NotNull
    public static final String AUDIO_LOGIC_PARAM_BOOK_ID = "bookid";

    @NotNull
    private static final String TAG = "VasAudioApiImpl";

    @NotNull
    public static final String VAS_QQVIP_AUDIO_LOGIC = "vas_qqvip_audio_logic";
    private static boolean isPaused;
    private static boolean isStopped;

    @Nullable
    private AudioManager am = (AudioManager) BaseApplication.context.getSystemService("audio");

    @Nullable
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g renderLogicView;

    @NotNull
    private static final HashMap<String, MediaPlayer> playerMap = new HashMap<>();

    @NotNull
    private static final HashMap<String, Function2<Integer, Integer, Unit>> errorCallbacks = new HashMap<>();

    @NotNull
    private static final HashMap<String, Function1<Integer, Unit>> stateCallbacks = new HashMap<>();
    private static int currentPlayerState = IVasAudioPlayer$PlayState.IDLE.ordinal();

    private final void checkStateChanged(String token) {
        checkStateChanged(token, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void create$lambda$1(VasAudioApiImpl this$0, MediaPlayer mp5, MediaTimestamp mediaTimestamp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mp5, "mp");
        Intrinsics.checkNotNullParameter(mediaTimestamp, "<anonymous parameter 1>");
        this$0.checkStateChanged(mp5.toString());
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void closeLogic() {
        try {
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.onDetach();
            }
            this.renderLogicView = null;
            QLog.d(TAG, 2, "detachKuiklyPage");
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    @NotNull
    public String create(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            reportMediaPlayer.setDataSource(path);
            reportMediaPlayer.setOnErrorListener(this);
            reportMediaPlayer.setOnPreparedListener(this);
            reportMediaPlayer.setOnCompletionListener(this);
            reportMediaPlayer.setOnBufferingUpdateListener(this);
            reportMediaPlayer.setOnInfoListener(this);
            if (Build.VERSION.SDK_INT >= 28) {
                reportMediaPlayer.setOnMediaTimeDiscontinuityListener(new MediaPlayer.OnMediaTimeDiscontinuityListener() { // from class: com.tencent.mobileqq.vas.api.impl.z
                    @Override // android.media.MediaPlayer.OnMediaTimeDiscontinuityListener
                    public final void onMediaTimeDiscontinuity(MediaPlayer mediaPlayer, MediaTimestamp mediaTimestamp) {
                        VasAudioApiImpl.create$lambda$1(VasAudioApiImpl.this, mediaPlayer, mediaTimestamp);
                    }
                });
            }
            reportMediaPlayer.setAudioStreamType(3);
            reportMediaPlayer.prepare();
        } catch (IllegalStateException e16) {
            QLog.e(TAG, 1, "create error:" + e16);
        }
        String obj = reportMediaPlayer.toString();
        playerMap.put(obj, reportMediaPlayer);
        QLog.d(TAG, 2, "create " + path + " " + obj);
        return obj;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public int getAudioDuration(@NotNull String token, @NotNull String path) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(path);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            Intrinsics.checkNotNull(extractMetadata);
            return Integer.parseInt(extractMetadata);
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public int getCurrentPosition(@NotNull String token) {
        int i3;
        Intrinsics.checkNotNullParameter(token, "token");
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            i3 = mediaPlayer.getCurrentPosition();
        } else {
            i3 = 0;
        }
        QLog.d(TAG, 2, "getCurrentPosition " + token + " " + i3);
        return i3;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public int getDuration(@NotNull String token) {
        int i3;
        Intrinsics.checkNotNullParameter(token, "token");
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            i3 = mediaPlayer.getDuration();
        } else {
            i3 = 0;
        }
        QLog.d(TAG, 2, "getDuration " + token + " " + i3);
        return i3;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public float getVolume(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        Object systemService = BaseApplication.context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        float streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3) / audioManager.getStreamMaxVolume(3);
        QLog.d(TAG, 2, "getVolume " + token + " " + streamVolume);
        return streamVolume;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public boolean isLooping(@NotNull String token) {
        boolean z16;
        Intrinsics.checkNotNullParameter(token, "token");
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            z16 = mediaPlayer.isLooping();
        } else {
            z16 = false;
        }
        QLog.d(TAG, 2, "isLooping " + token + " " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public boolean isPlaying(@NotNull String token) {
        boolean z16;
        Intrinsics.checkNotNullParameter(token, "token");
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            z16 = mediaPlayer.isPlaying();
        } else {
            z16 = false;
        }
        QLog.d(TAG, 2, "isPlaying " + token + " " + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void next(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.d(TAG, 2, "next " + path);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        QLog.d(TAG, 2, "onAudioFocusChange " + focusChange);
        if (focusChange == -1) {
            pause("");
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(@Nullable MediaPlayer mp5, int percent) {
        QLog.d(TAG, 2, "onBufferingUpdate " + mp5 + " " + percent);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(@Nullable MediaPlayer mp5) {
        QLog.d(TAG, 2, "onCompletion " + mp5);
        int i3 = currentPlayerState;
        IVasAudioApi.PlayState playState = IVasAudioApi.PlayState.FINISHED;
        if (i3 != playState.ordinal()) {
            currentPlayerState = playState.ordinal();
            Function1<Integer, Unit> function1 = stateCallbacks.get(String.valueOf(mp5));
            if (function1 != null) {
                function1.invoke(Integer.valueOf(currentPlayerState));
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(@Nullable MediaPlayer mp5, int what, int extra) {
        QLog.d(TAG, 2, "onError " + mp5 + " " + what + " " + extra);
        Function2<Integer, Integer, Unit> function2 = errorCallbacks.get(String.valueOf(mp5));
        if (function2 != null) {
            function2.invoke(Integer.valueOf(what), Integer.valueOf(extra));
        }
        checkStateChanged(String.valueOf(mp5));
        return false;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(@Nullable MediaPlayer mp5, int what, int extra) {
        QLog.d(TAG, 2, "onInfo " + mp5 + " " + what + " " + extra);
        checkStateChanged(String.valueOf(mp5));
        return false;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(@Nullable MediaPlayer mp5) {
        QLog.d(TAG, 2, "onPrepared " + mp5);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void openLogic(@NotNull String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (this.renderLogicView == null) {
            IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.renderLogicView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
            HashMap hashMap = new HashMap();
            hashMap.put("bundle_name", VAS_QQVIP_AUDIO_LOGIC);
            hashMap.put(AUDIO_LOGIC_PARAM_BOOK_ID, bookId);
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.renderLogicView;
            if (gVar != null) {
                gVar.b(VAS_QQVIP_AUDIO_LOGIC, hashMap, new Size(0, 0));
            }
            QLog.d(TAG, 2, "openLogic " + bookId);
            return;
        }
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_name", "setBookId");
            jSONObject.put(AUDIO_LOGIC_PARAM_BOOK_ID, bookId);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "send setBookId event! " + bookId);
            }
            Unit unit = Unit.INSTANCE;
            com.tencent.kuikly.core.render.android.expand.module.l.e(baseApplication, AUDIO_LOGIC_EVENT, jSONObject);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void pause(@NotNull String token) {
        boolean z16;
        Intrinsics.checkNotNullParameter(token, "token");
        QLog.d(TAG, 2, "pause " + token);
        boolean z17 = false;
        if (token.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            for (MediaPlayer mediaPlayer : playerMap.values()) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    isPaused = true;
                    checkStateChanged(token);
                }
            }
        } else {
            MediaPlayer mediaPlayer2 = playerMap.get(token);
            if (mediaPlayer2 != null && mediaPlayer2.isPlaying()) {
                z17 = true;
            }
            if (z17) {
                mediaPlayer2.pause();
                isPaused = true;
                checkStateChanged(token);
            }
        }
        AudioManager audioManager = this.am;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void play(@NotNull String token, @NotNull String path) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.d(TAG, 2, "play " + token + " " + path);
        AudioManager audioManager = this.am;
        if (audioManager != null) {
            audioManager.requestAudioFocus(this, 3, 1);
        }
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            mediaPlayer.setDataSource(path);
        }
        if (mediaPlayer != null) {
            mediaPlayer.prepare();
        }
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        isPaused = false;
        isStopped = false;
        checkStateChanged(token, true);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void release(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        QLog.d(TAG, 2, "release " + token);
        HashMap<String, MediaPlayer> hashMap = playerMap;
        MediaPlayer mediaPlayer = hashMap.get(token);
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        hashMap.remove(token);
        errorCallbacks.remove(token);
        stateCallbacks.remove(token);
        isPaused = false;
        isStopped = false;
        AudioManager audioManager = this.am;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void resume(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        QLog.d(TAG, 2, "resume " + token);
        AudioManager audioManager = this.am;
        boolean z16 = true;
        if (audioManager != null) {
            audioManager.requestAudioFocus(this, 3, 1);
        }
        if (token.length() != 0) {
            z16 = false;
        }
        if (z16) {
            Iterator<MediaPlayer> it = playerMap.values().iterator();
            while (it.hasNext()) {
                it.next().start();
            }
        } else {
            MediaPlayer mediaPlayer = playerMap.get(token);
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        }
        isPaused = false;
        isStopped = false;
        checkStateChanged(token);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void seekTo(@NotNull String token, int pos) {
        Intrinsics.checkNotNullParameter(token, "token");
        QLog.d(TAG, 2, "seekTo " + token + " " + pos);
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(pos);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void setLoop(@NotNull String token, boolean isLoop) {
        Intrinsics.checkNotNullParameter(token, "token");
        QLog.d(TAG, 2, "setLoop " + token + " " + isLoop);
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(isLoop);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void setOnErrorListener(@NotNull String token, @Nullable Function2<? super Integer, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(token, "token");
        if (callback != null) {
            errorCallbacks.put(token, callback);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void setPlayStateListener(@NotNull String token, @Nullable Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(token, "token");
        if (callback != null) {
            stateCallbacks.put(token, callback);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void setSpeed(@NotNull String token, float speed) {
        PlaybackParams playbackParams;
        Intrinsics.checkNotNullParameter(token, "token");
        QLog.d(TAG, 2, "setSpeed " + token + " " + speed);
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            playbackParams = mediaPlayer.getPlaybackParams();
        } else {
            playbackParams = null;
        }
        if (playbackParams != null) {
            playbackParams.setSpeed(speed);
            mediaPlayer.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void setVolume(@NotNull String token, float volume) {
        Intrinsics.checkNotNullParameter(token, "token");
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(volume, volume);
        }
        QLog.d(TAG, 2, "setVolume " + token + " " + volume);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAudioApi
    public void stop(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        QLog.d(TAG, 2, "stop " + token);
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        isStopped = true;
        checkStateChanged(token);
        AudioManager audioManager = this.am;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this);
        }
    }

    private final void checkStateChanged(String token, boolean isPlaying) {
        MediaPlayer mediaPlayer = playerMap.get(token);
        if (mediaPlayer != null) {
            int ordinal = IVasAudioPlayer$PlayState.IDLE.ordinal();
            if (!mediaPlayer.isPlaying() && !isPlaying) {
                if (isStopped) {
                    ordinal = IVasAudioPlayer$PlayState.STOPPED.ordinal();
                } else if (isPaused) {
                    ordinal = IVasAudioPlayer$PlayState.PAUSED.ordinal();
                }
            } else {
                ordinal = IVasAudioPlayer$PlayState.PLAYING.ordinal();
            }
            if (currentPlayerState != ordinal) {
                currentPlayerState = ordinal;
                Function1<Integer, Unit> function1 = stateCallbacks.get(mediaPlayer.toString());
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(currentPlayerState));
                }
            }
        }
    }
}
