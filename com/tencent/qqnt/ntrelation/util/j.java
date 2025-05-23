package com.tencent.qqnt.ntrelation.util;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CustomStatus;
import com.tencent.qqnt.kernel.nativeinterface.CustomStatusDescInfo;
import com.tencent.qqnt.kernel.nativeinterface.StatusBusinessInfo;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.StatusMusicInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.protocol.onLineStatus.OnlineStatusExtInfo$WeatherBizInfo;
import com.tencent.qqnt.ntrelation.protocol.onLineStatus.OnlineStatusExtInfo$ZodiacBizInfo;
import com.tencent.qqnt.ntrelation.protocol.onLineStatus.StatSvcStatSong$SongInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007J\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ2\u0010\u0016\u001a\u00020\u0015\"\u0010\b\u0000\u0010\u0011*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/j;", "", "", "trace", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "statusInfo", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "b", "result", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/UserDetailInfo;", "userDetailInfo", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "a", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "vecInfo", "targetObject", "", "c", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f360277a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37589);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f360277a = new j();
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a a(@NotNull String trace, @NotNull String uid, @Nullable UserDetailInfo userDetailInfo) {
        UserSimpleInfo userSimpleInfo;
        StatusInfo statusInfo;
        int i3;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a) iPatchRedirector.redirect((short) 4, this, trace, uid, userDetailInfo);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a(null, null, 0L, 0, 0, 0L, (byte) 0, 0, 0, null, null, null, 0L, 0, 0, 0, null, null, null, null, null, 0L, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, 0, 0L, null, null, null, null, 0L, 0L, 0L, null, null, 0, 0L, -1, 131071, null);
        aVar.b1(uid);
        aVar.c1(c.f360229a.m(uid));
        if (userDetailInfo != null && (userSimpleInfo = userDetailInfo.simpleInfo) != null && (statusInfo = userSimpleInfo.status) != null) {
            aVar.r0(statusInfo.abiFlag);
            aVar.K0(statusInfo.batteryStatus);
            aVar.O0(statusInfo.iconType);
            aVar.a1(statusInfo.extStatus);
            aVar.G0((byte) statusInfo.status);
            aVar.L0(statusInfo.termType);
            aVar.P0(statusInfo.eNetworkType);
            aVar.Q0(statusInfo.setTime);
            StatusMusicInfo musicInfo = statusInfo.musicInfo;
            if (musicInfo != null) {
                Intrinsics.checkNotNullExpressionValue(musicInfo, "musicInfo");
                StatSvcStatSong$SongInfo statSvcStatSong$SongInfo = new StatSvcStatSong$SongInfo();
                if (f360277a.c(musicInfo.buf, statSvcStatSong$SongInfo)) {
                    aVar.U0(statSvcStatSong$SongInfo.bytes_song_id.get().toStringUtf8());
                    aVar.V0(statSvcStatSong$SongInfo.bytes_song_name.get().toStringUtf8());
                    aVar.R0(statSvcStatSong$SongInfo.bytes_singer_name.get().toStringUtf8());
                    aVar.T0(statSvcStatSong$SongInfo.uint64_end_time.get());
                    aVar.X0(statSvcStatSong$SongInfo.uint32_source_type.get());
                    aVar.W0(statSvcStatSong$SongInfo.uint32_pause_remaining_time.get());
                    aVar.S0(statSvcStatSong$SongInfo.uint32_song_play_time.get());
                }
            }
            StatusBusinessInfo extOnlineBusinessInfo = statusInfo.extOnlineBusinessInfo;
            if (extOnlineBusinessInfo != null) {
                Intrinsics.checkNotNullExpressionValue(extOnlineBusinessInfo, "extOnlineBusinessInfo");
                if (aVar.e0() == 1040) {
                    OnlineStatusExtInfo$ZodiacBizInfo onlineStatusExtInfo$ZodiacBizInfo = new OnlineStatusExtInfo$ZodiacBizInfo();
                    if (f360277a.c(extOnlineBusinessInfo.buf, onlineStatusExtInfo$ZodiacBizInfo)) {
                        aVar.B0(onlineStatusExtInfo$ZodiacBizInfo.string_today_trend.get());
                        aVar.C0(onlineStatusExtInfo$ZodiacBizInfo.string_tomorrow_trend.get());
                        aVar.w0(onlineStatusExtInfo$ZodiacBizInfo.string_today_date.get());
                        aVar.y0(onlineStatusExtInfo$ZodiacBizInfo.string_miniapp.get());
                        if (onlineStatusExtInfo$ZodiacBizInfo.string_lucky_color.has()) {
                            aVar.A0(onlineStatusExtInfo$ZodiacBizInfo.string_lucky_number.get().toString());
                        }
                        if (onlineStatusExtInfo$ZodiacBizInfo.string_lucky_number.has()) {
                            aVar.z0(onlineStatusExtInfo$ZodiacBizInfo.string_lucky_color.get().toString());
                        }
                    }
                } else if (aVar.e0() == 1030) {
                    OnlineStatusExtInfo$WeatherBizInfo onlineStatusExtInfo$WeatherBizInfo = new OnlineStatusExtInfo$WeatherBizInfo();
                    if (f360277a.c(extOnlineBusinessInfo.buf, onlineStatusExtInfo$WeatherBizInfo)) {
                        aVar.m1(onlineStatusExtInfo$WeatherBizInfo.string_weather_type_id.get());
                        aVar.l1(onlineStatusExtInfo$WeatherBizInfo.string_weather_type.get());
                        aVar.Z0(onlineStatusExtInfo$WeatherBizInfo.string_temper.get());
                        aVar.u0(onlineStatusExtInfo$WeatherBizInfo.string_city.get());
                        aVar.t0(onlineStatusExtInfo$WeatherBizInfo.string_area.get());
                        aVar.s0(String.valueOf(onlineStatusExtInfo$WeatherBizInfo.uint32_adcode.get()));
                        aVar.h1(onlineStatusExtInfo$WeatherBizInfo.uint32_flag.get());
                        aVar.n1(onlineStatusExtInfo$WeatherBizInfo.uint64_update_time.get());
                        if (onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.has()) {
                            aVar.g1(onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.get());
                        }
                        aVar.i1(onlineStatusExtInfo$WeatherBizInfo.icon_key.get());
                        aVar.j1(onlineStatusExtInfo$WeatherBizInfo.prompt.get());
                    }
                }
            }
            aVar.d1(statusInfo.extOnlineBusinessInfo.videoBizInfo.cid);
            aVar.f1(statusInfo.extOnlineBusinessInfo.videoBizInfo.tvUrl);
            aVar.e1(statusInfo.extOnlineBusinessInfo.videoInfo.name);
            CustomStatus customStatus = statusInfo.customStatus;
            if (customStatus != null) {
                i3 = (int) customStatus.faceType;
            } else {
                i3 = -1;
            }
            aVar.J0(i3);
            CustomStatus customStatus2 = statusInfo.customStatus;
            if (customStatus2 != null) {
                j3 = customStatus2.faceId;
            } else {
                j3 = -1;
            }
            aVar.I0(j3);
            CustomStatus customStatus3 = statusInfo.customStatus;
            String str2 = "";
            if (customStatus3 == null || (str = customStatus3.wording) == null) {
                str = "";
            }
            aVar.H0(str);
            String str3 = statusInfo.termDesc;
            if (str3 == null) {
                str3 = "";
            }
            aVar.Y0(str3);
            CustomStatusDescInfo customStatusDescInfo = statusInfo.customStatusDescInfo;
            if (customStatusDescInfo != null) {
                Intrinsics.checkNotNullExpressionValue(customStatusDescInfo, "customStatusDescInfo");
                aVar.F0(customStatusDescInfo.hasCustomInfo);
                String str4 = customStatusDescInfo.customDesc;
                if (str4 == null) {
                    str4 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str4, "customStatusDescInfo.customDesc ?: \"\"");
                }
                String str5 = customStatusDescInfo.customModel;
                if (str5 != null) {
                    Intrinsics.checkNotNullExpressionValue(str5, "customStatusDescInfo.customModel ?: \"\"");
                    str2 = str5;
                }
                aVar.E0(str4 + str2);
            }
        }
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.i("OnLineStatusDataConvertUtil", 1, "trace " + trace + " KernelDataToNTOnlineStatusDetailInfo " + aVar);
        }
        return aVar;
    }

    @Nullable
    public final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c b(@NotNull String trace, @NotNull String uid, @Nullable StatusInfo statusInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) iPatchRedirector.redirect((short) 2, this, trace, uid, statusInfo);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(uid, "uid");
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c(null, null, 3, null);
        cVar.b1(uid);
        cVar.c1(c.f360229a.m(uid));
        d(trace, statusInfo, cVar);
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.i("OnLineStatusDataConvertUtil", 1, "trace " + trace + " KernelDataToNTOnlineStatusSimpleInfo " + cVar);
        }
        return cVar;
    }

    public final <T extends MessageMicro<T>> boolean c(@Nullable byte[] vecInfo, @Nullable MessageMicro<T> targetObject) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) vecInfo, (Object) targetObject)).booleanValue();
        }
        if (vecInfo == null || targetObject == null) {
            return false;
        }
        try {
            if (vecInfo.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return false;
            }
            targetObject.mergeFrom(vecInfo);
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.d("OnLineStatusDataConvertUtil", 1, "parseFriendMusicInfo fail", e16);
            return false;
        }
    }

    public final void d(@NotNull String trace, @Nullable StatusInfo statusInfo, @NotNull com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c result) {
        int i3;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, trace, statusInfo, result);
            return;
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(result, "result");
        if (statusInfo != null) {
            result.r0(statusInfo.abiFlag);
            result.K0(statusInfo.batteryStatus);
            result.O0(statusInfo.iconType);
            result.a1(statusInfo.extStatus);
            result.G0((byte) statusInfo.status);
            result.L0(statusInfo.termType);
            result.P0(statusInfo.eNetworkType);
            result.Q0(statusInfo.setTime);
            StatusMusicInfo musicInfo = statusInfo.musicInfo;
            if (musicInfo != null) {
                Intrinsics.checkNotNullExpressionValue(musicInfo, "musicInfo");
                StatSvcStatSong$SongInfo statSvcStatSong$SongInfo = new StatSvcStatSong$SongInfo();
                if (f360277a.c(musicInfo.buf, statSvcStatSong$SongInfo)) {
                    result.U0(statSvcStatSong$SongInfo.bytes_song_id.get().toStringUtf8());
                    result.V0(statSvcStatSong$SongInfo.bytes_song_name.get().toStringUtf8());
                    result.R0(statSvcStatSong$SongInfo.bytes_singer_name.get().toStringUtf8());
                    result.T0(statSvcStatSong$SongInfo.uint64_end_time.get());
                    result.X0(statSvcStatSong$SongInfo.uint32_source_type.get());
                    result.W0(statSvcStatSong$SongInfo.uint32_pause_remaining_time.get());
                    result.S0(statSvcStatSong$SongInfo.uint32_song_play_time.get());
                }
            }
            StatusBusinessInfo extOnlineBusinessInfo = statusInfo.extOnlineBusinessInfo;
            if (extOnlineBusinessInfo != null) {
                Intrinsics.checkNotNullExpressionValue(extOnlineBusinessInfo, "extOnlineBusinessInfo");
                if (result.e0() == 1040) {
                    OnlineStatusExtInfo$ZodiacBizInfo onlineStatusExtInfo$ZodiacBizInfo = new OnlineStatusExtInfo$ZodiacBizInfo();
                    if (f360277a.c(extOnlineBusinessInfo.buf, onlineStatusExtInfo$ZodiacBizInfo)) {
                        result.B0(onlineStatusExtInfo$ZodiacBizInfo.string_today_trend.get());
                        result.C0(onlineStatusExtInfo$ZodiacBizInfo.string_tomorrow_trend.get());
                        result.w0(onlineStatusExtInfo$ZodiacBizInfo.string_today_date.get());
                        result.y0(onlineStatusExtInfo$ZodiacBizInfo.string_miniapp.get());
                        if (onlineStatusExtInfo$ZodiacBizInfo.string_lucky_color.has()) {
                            result.A0(onlineStatusExtInfo$ZodiacBizInfo.string_lucky_number.get().toString());
                        }
                        if (onlineStatusExtInfo$ZodiacBizInfo.string_lucky_number.has()) {
                            result.z0(onlineStatusExtInfo$ZodiacBizInfo.string_lucky_color.get().toString());
                        }
                    }
                } else if (result.e0() == 1030) {
                    OnlineStatusExtInfo$WeatherBizInfo onlineStatusExtInfo$WeatherBizInfo = new OnlineStatusExtInfo$WeatherBizInfo();
                    if (f360277a.c(extOnlineBusinessInfo.buf, onlineStatusExtInfo$WeatherBizInfo)) {
                        result.m1(onlineStatusExtInfo$WeatherBizInfo.string_weather_type_id.get());
                        result.l1(onlineStatusExtInfo$WeatherBizInfo.string_weather_type.get());
                        result.Z0(onlineStatusExtInfo$WeatherBizInfo.string_temper.get());
                        result.u0(onlineStatusExtInfo$WeatherBizInfo.string_city.get());
                        result.t0(onlineStatusExtInfo$WeatherBizInfo.string_area.get());
                        result.s0(String.valueOf(onlineStatusExtInfo$WeatherBizInfo.uint32_adcode.get()));
                        result.h1(onlineStatusExtInfo$WeatherBizInfo.uint32_flag.get());
                        result.n1(onlineStatusExtInfo$WeatherBizInfo.uint64_update_time.get());
                        if (onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.has()) {
                            result.g1(onlineStatusExtInfo$WeatherBizInfo.string_weather_desc.get());
                        }
                        result.i1(onlineStatusExtInfo$WeatherBizInfo.icon_key.get());
                        result.j1(onlineStatusExtInfo$WeatherBizInfo.prompt.get());
                    }
                }
            }
            result.d1(statusInfo.extOnlineBusinessInfo.videoBizInfo.cid);
            result.f1(statusInfo.extOnlineBusinessInfo.videoBizInfo.tvUrl);
            result.e1(statusInfo.extOnlineBusinessInfo.videoInfo.name);
            CustomStatus customStatus = statusInfo.customStatus;
            if (customStatus != null) {
                i3 = (int) customStatus.faceType;
            } else {
                i3 = -1;
            }
            result.J0(i3);
            CustomStatus customStatus2 = statusInfo.customStatus;
            if (customStatus2 != null) {
                j3 = customStatus2.faceId;
            } else {
                j3 = -1;
            }
            result.I0(j3);
            CustomStatus customStatus3 = statusInfo.customStatus;
            String str2 = "";
            if (customStatus3 == null || (str = customStatus3.wording) == null) {
                str = "";
            }
            result.H0(str);
            String str3 = statusInfo.termDesc;
            if (str3 == null) {
                str3 = "";
            }
            result.Y0(str3);
            CustomStatusDescInfo customStatusDescInfo = statusInfo.customStatusDescInfo;
            if (customStatusDescInfo != null) {
                Intrinsics.checkNotNullExpressionValue(customStatusDescInfo, "customStatusDescInfo");
                result.F0(customStatusDescInfo.hasCustomInfo);
                String str4 = customStatusDescInfo.customDesc;
                if (str4 == null) {
                    str4 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str4, "customStatusDescInfo.customDesc ?: \"\"");
                }
                String str5 = customStatusDescInfo.customModel;
                if (str5 != null) {
                    Intrinsics.checkNotNullExpressionValue(str5, "customStatusDescInfo.customModel ?: \"\"");
                    str2 = str5;
                }
                result.E0(str4 + str2);
            }
        }
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.i("OnLineStatusDataConvertUtil", 1, "trace " + trace + " statusInfoUpdateNTOnlineStatusInfo " + result);
        }
    }
}
