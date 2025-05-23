package com.tencent.mobileqq.kandian.biz.video.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import j62.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0002H&J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002H&J\b\u0010\u0010\u001a\u00020\bH&J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeControl;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "mute", "", "reason", "", "what", "", "setMute", "shouldMuteInReadInJoy", "Landroid/content/Context;", "context", "isInPhoneCall", "shouldMute", "saveConfig", "startAudioPlay", "Lj62/b;", "manager", "setMuteForce", "Companion", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoVolumeControl extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f239556a;
    public static final int GLOBAL = 0;
    public static final int IN_READINJOY = 1;
    public static final int IN_VIDEO_FEED = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoVolumeControl$a;", "", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeControl$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f239556a = new Companion();

        Companion() {
        }
    }

    boolean isInPhoneCall(@Nullable Context context);

    void saveConfig(boolean shouldMute);

    void setMute(boolean mute, @Nullable String reason, int what);

    void setMuteForce(@Nullable b manager, boolean mute);

    boolean shouldMuteInReadInJoy();

    void startAudioPlay();
}
