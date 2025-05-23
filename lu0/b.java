package lu0;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.icgame.game.liveroom.impl.room.definition.d;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.icgame.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.icgame.api.room.IcgRoomPlayerConfig;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.PreloadSuperPlayerParams;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayUrlHandler;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fu0.EnterRoomConfig;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mu0.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J$\u0010\u0012\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J,\u0010\u0017\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J*\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001c\u0010$\u001a\u00020#2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010\u001eH\u0016\u00a8\u0006("}, d2 = {"Llu0/b;", "", "Lcom/tencent/mobileqq/icgame/api/room/ILiveAudienceTPPlayerRoom;", "", "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/icgame/api/room/IcgRoomPlayerConfig;", "icgRoomPlayerConfig", "", "o", "audienceRoom", "playerConfig", "roomId", "c", "e", "f", "Lcom/tencent/mobileqq/icgame/data/room/LiveInfo;", "liveInfo", "costTime", h.F, "", "errCode", "errMsg", "i", "j", "b", "Lfu0/a;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/icgame/data/room/EnterRoomInfo;", "g", "enterRoomConfig", "Lcom/tencent/mobileqq/icgame/api/room/AudienceRoomConfig;", "k", "<init>", "()V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(b this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.m(str);
    }

    private final long l() {
        IQQLiveModuleLogin loginModule;
        LiveUserInfo userInfo;
        IQQLiveSDK l3 = mu0.a.k().l();
        if (l3 != null && (loginModule = l3.getLoginModule()) != null && (userInfo = loginModule.getUserInfo()) != null) {
            return userInfo.uid;
        }
        return 0L;
    }

    private final String m(String url) {
        long l3 = l();
        if (n(url) && l3 > 0) {
            Uri parse = Uri.parse(url);
            Uri.Builder buildUpon = parse.buildUpon();
            if (!parse.getQueryParameterNames().contains("lvuid")) {
                buildUpon.appendQueryParameter("lvuid", String.valueOf(l3)).build();
            }
            if (!parse.getQueryParameterNames().contains("lvrand")) {
                buildUpon.appendQueryParameter("lvrand", String.valueOf(new Random().nextLong()));
            }
            String uri = buildUpon.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "builder.build().toString()");
            QLog.i("ICGameVideoRoomManager", 1, "[handleFlvUrl] handled url, " + uri);
            return uri;
        }
        QLog.w("ICGameVideoRoomManager", 1, "[handleFlvUrl] not handled url, url=" + url + ", uid=" + l3);
        return url;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r2 != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean n(String url) {
        boolean startsWith$default;
        boolean contains$default;
        boolean startsWith$default2;
        if (url != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) ".flv", false, 2, (Object) null);
            if (contains$default) {
                return true;
            }
        }
        QLog.i("ICGameVideoRoomManager", 1, "[isFlvUrl] not valid flv url, url=" + url);
        return false;
    }

    public void b(@Nullable ILiveAudienceTPPlayerRoom audienceRoom, long roomId) {
        if (audienceRoom == null) {
            QLog.w("ICGameVideoRoomManager", 1, "[afterRemoveAudienceRoom] room=null, roomId=" + roomId);
        }
        px0.a.f427869a.h(audienceRoom, roomId);
    }

    public void c(@NotNull ILiveAudienceTPPlayerRoom audienceRoom, @Nullable IcgRoomPlayerConfig playerConfig, long roomId) {
        int roomType;
        Intrinsics.checkNotNullParameter(audienceRoom, "audienceRoom");
        if (playerConfig == null || roomId == 0) {
            QLog.w("ICGameVideoRoomManager", 1, "[afterRoomCreate] room=" + audienceRoom + ", config=" + playerConfig + ", roomId=" + roomId);
        }
        if (playerConfig != null) {
            roomType = playerConfig.roomType;
        } else {
            roomType = audienceRoom.getRoomType();
        }
        audienceRoom.setUrlHandler(new AudienceRoomPlayUrlHandler() { // from class: lu0.a
            @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayUrlHandler
            public final String handle(String str) {
                String d16;
                d16 = b.d(b.this, str);
                return d16;
            }
        });
        if (playerConfig != null) {
            QLog.i("ICGameVideoRoomManager", 1, "[afterRoomCreate] xy axis=" + playerConfig.superPlayerParams.playerXYAxis);
            audienceRoom.setXYAxis(playerConfig.superPlayerParams.playerXYAxis);
        }
        px0.a.f427869a.g(audienceRoom, roomId, roomType);
    }

    public void e(@Nullable ILiveAudienceTPPlayerRoom audienceRoom, @Nullable IcgRoomPlayerConfig icgRoomPlayerConfig, long roomId) {
        if (audienceRoom == null || icgRoomPlayerConfig == null || roomId == 0) {
            QLog.w("ICGameVideoRoomManager", 1, "[audiencePreload] room=" + audienceRoom + ", config=" + icgRoomPlayerConfig + ", roomId=" + roomId);
        }
        px0.a.f427869a.i(audienceRoom, roomId);
        if (icgRoomPlayerConfig != null && audienceRoom != null) {
            audienceRoom.preloadUrl(icgRoomPlayerConfig.superPlayerParams.url);
        }
    }

    public void f(@Nullable ILiveAudienceTPPlayerRoom audienceRoom, @Nullable IcgRoomPlayerConfig icgRoomPlayerConfig) {
        long j3;
        ITPPlayerVideoView displayView;
        View currentDisplayView;
        if (audienceRoom == null || icgRoomPlayerConfig == null) {
            QLog.w("ICGameVideoRoomManager", 1, "[beforeEnterRoom] room=" + audienceRoom + ", config=" + icgRoomPlayerConfig);
        }
        if (icgRoomPlayerConfig != null) {
            QLog.i("ICGameVideoRoomManager", 1, "[beforeEnterRoom] xy axis=" + icgRoomPlayerConfig.superPlayerParams.playerXYAxis);
            if (audienceRoom != null) {
                audienceRoom.setXYAxis(icgRoomPlayerConfig.superPlayerParams.playerXYAxis);
            }
        }
        if (audienceRoom != null && (displayView = audienceRoom.getDisplayView()) != null && (currentDisplayView = displayView.getCurrentDisplayView()) != null) {
            c.b().g(currentDisplayView);
        }
        px0.a aVar = px0.a.f427869a;
        if (icgRoomPlayerConfig != null) {
            j3 = icgRoomPlayerConfig.roomId;
        } else {
            j3 = 0;
        }
        aVar.a(j3);
    }

    @NotNull
    public EnterRoomInfo g(@Nullable EnterRoomConfig config) {
        long j3;
        String str;
        EnterRoomInfo.VideoDefinition f16;
        String str2;
        Bundle extraInfo;
        if (config == null) {
            QLog.w("ICGameVideoRoomManager", 1, "[createEnterRoomInfo] invalid params, config=null");
        }
        if (config != null) {
            j3 = config.getRoomId();
        } else {
            j3 = 0;
        }
        EnterRoomInfo enterRoomInfo = new EnterRoomInfo();
        enterRoomInfo.setRoomId(j3);
        if (config == null || (extraInfo = config.getExtraInfo()) == null || (str = extraInfo.getString("extdata")) == null) {
            str = "";
        }
        enterRoomInfo.setExtraData(str);
        if (d.a().d(j3)) {
            f16 = d.a().b(BaseApplication.context, j3);
        } else {
            f16 = com.tencent.icgame.game.liveroom.impl.room.definition.b.f();
        }
        enterRoomInfo.setTargetDefinition(f16);
        String str3 = null;
        if (config != null) {
            str2 = config.getSource();
        } else {
            str2 = null;
        }
        enterRoomInfo.setSource(str2);
        if (config != null) {
            str3 = config.getShareToken();
        }
        enterRoomInfo.setShareToken(str3);
        QLog.i("ICGameVideoRoomManager", 1, "[createEnterRoomInfo] enterRoomInfo=" + enterRoomInfo);
        return enterRoomInfo;
    }

    public void h(@Nullable ILiveAudienceTPPlayerRoom audienceRoom, long roomId, @Nullable LiveInfo liveInfo, long costTime) {
        if (audienceRoom == null || liveInfo == null) {
            QLog.w("ICGameVideoRoomManager", 1, "[enterRoom] room=" + audienceRoom + ", liveInfo=" + liveInfo);
        }
        px0.a.f427869a.d(liveInfo, costTime);
    }

    public void i(long roomId, int errCode, @Nullable String errMsg, long costTime) {
        px0.a.f427869a.e(roomId, errCode, errMsg, costTime);
    }

    public void j(@Nullable ILiveAudienceTPPlayerRoom audienceRoom, long roomId) {
        if (audienceRoom == null) {
            QLog.w("ICGameVideoRoomManager", 1, "[exitRoom] room=null, roomId=" + roomId);
        }
        px0.a aVar = px0.a.f427869a;
        aVar.f(roomId);
        aVar.h(audienceRoom, roomId);
    }

    @NotNull
    public AudienceRoomConfig k(@Nullable IcgRoomPlayerConfig icgRoomPlayerConfig, @Nullable EnterRoomConfig enterRoomConfig) {
        boolean z16;
        int i3;
        boolean z17;
        AudienceRoomConfig.VideoFormat videoFormat;
        PreloadSuperPlayerParams preloadSuperPlayerParams;
        String str;
        boolean startsWith$default;
        PreloadSuperPlayerParams preloadSuperPlayerParams2;
        if (icgRoomPlayerConfig == null || enterRoomConfig == null) {
            QLog.w("ICGameVideoRoomManager", 1, "[beforeEnterRoom] preloadConfig=" + icgRoomPlayerConfig + ", enterRoomConfig=" + enterRoomConfig);
        }
        boolean z18 = false;
        if (icgRoomPlayerConfig == null && enterRoomConfig == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            AudienceRoomConfig audienceRoomConfig = new AudienceRoomConfig();
            if (icgRoomPlayerConfig != null) {
                i3 = icgRoomPlayerConfig.roomType;
            } else if (enterRoomConfig != null) {
                i3 = enterRoomConfig.getRoomType();
            } else {
                i3 = -1;
            }
            audienceRoomConfig.roomType = i3;
            PlayerConfig playerConfig = audienceRoomConfig.playerConfig;
            if (icgRoomPlayerConfig != null && (preloadSuperPlayerParams2 = icgRoomPlayerConfig.superPlayerParams) != null) {
                z17 = preloadSuperPlayerParams2.useTextureView;
            } else {
                z17 = false;
            }
            playerConfig.isUseTextureView = z17;
            if (icgRoomPlayerConfig != null && (preloadSuperPlayerParams = icgRoomPlayerConfig.superPlayerParams) != null && (str = preloadSuperPlayerParams.url) != null) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "rtmp", false, 2, null);
                if (startsWith$default) {
                    z18 = true;
                }
            }
            if (z18) {
                videoFormat = AudienceRoomConfig.VideoFormat.RTMP;
            } else {
                videoFormat = AudienceRoomConfig.VideoFormat.FLV;
            }
            playerConfig.format = videoFormat;
            audienceRoomConfig.preloadPlayParams.copyFrom(icgRoomPlayerConfig);
            hu0.c.b().a(audienceRoomConfig);
            QLog.i("ICGameVideoRoomManager", 1, "[getAudienceRoomConfig] config=" + audienceRoomConfig);
            return audienceRoomConfig;
        }
        throw new IllegalArgumentException("Preload config and enterRoom Config cannot be null both".toString());
    }

    public void o(@Nullable IcgRoomPlayerConfig icgRoomPlayerConfig) {
        if (icgRoomPlayerConfig != null) {
            PreloadSuperPlayerParams preloadSuperPlayerParams = icgRoomPlayerConfig.superPlayerParams;
            preloadSuperPlayerParams.url = m(preloadSuperPlayerParams.url);
        }
    }
}
