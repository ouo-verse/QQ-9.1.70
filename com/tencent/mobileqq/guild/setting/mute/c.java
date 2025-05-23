package com.tencent.mobileqq.guild.setting.mute;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.ServiceCache$LazyHolder;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001c\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\"\u0010\u0012\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0007J,\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0007J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0007J\u001c\u0010\u001b\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u001c\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u001e\u001a\u00020\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u001f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u000fH\u0007J!\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u000fH\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0007J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020'H\u0007J \u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0-0,H\u0007J\u0018\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0'2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u0019\u00100\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007\u00a2\u0006\u0004\b0\u00101J\u0019\u00102\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007\u00a2\u0006\u0004\b2\u00101J\u0010\u00103\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0012\u00104\u001a\u00020\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u00105\u001a\u00020\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u0019\u00107\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u00010\u000fH\u0007\u00a2\u0006\u0004\b7\u00108J\u0012\u00109\u001a\u00020\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010:\u001a\u00020\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010;\u001a\u00020\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0007J \u0010=\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u001dH\u0007J\n\u0010?\u001a\u0004\u0018\u00010>H\u0002J\"\u0010@\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0012\u0010A\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010B\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010C\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010D\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010F\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010E\u001a\u00020\u0015H\u0002J\b\u0010G\u001a\u00020\u000fH\u0002J\u0010\u0010I\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u000fH\u0002R\u0014\u0010L\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010.R&\u0010R\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0'0O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR,\u0010Z\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d0-0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010XR\u0016\u0010]\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010\\R\u0014\u0010_\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010^R\u0014\u0010b\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010aR\u0014\u0010e\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010d\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/c;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "account", "", "onAccountChanged", "", "guildIdList", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "k", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", DomainData.DOMAIN_NAME, "j", ExifInterface.LATITUDE_SOUTH, "guildId", "", "muteLastTimeSecond", "from", "X", "tinyId", "Z", "", "day", WidgetCacheWeatherData.HOUR, "minute", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "channelId", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "N", "w", "v", "lastMuteSecond", "y", "userMute", HippyTKDListViewAdapter.X, "(ZLjava/lang/Long;)Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Req, "Le12/a;", ReportConstant.COSTREPORT_PREFIX, "J", "H", "K", "Landroidx/lifecycle/LiveData;", "Lkotlin/Triple;", "I", BdhLogUtil.LogTag.Tag_Conn, "G", "(Ljava/lang/Long;)Ljava/lang/String;", "B", "r", "T", "l", "lastMuteTime", "O", "(Ljava/lang/Long;)Z", "M", "U", "V", "isAdmin", "W", "Lmqq/app/AppRuntime;", "o", "Y", "t", "D", "L", "E", "formatId", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "time", UserInfo.SEX_FEMALE, "e", "Ljava/lang/String;", "TAG", "f", "nextCountDownTime", "Ljava/util/concurrent/ConcurrentHashMap;", tl.h.F, "Ljava/util/concurrent/ConcurrentHashMap;", "muteMap", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "countDownHandler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Le12/a;", "userMuteChangeLiveData", "userAdminChangeLiveData", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "muteObserver", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "countDownRunnable", "com/tencent/mobileqq/guild/setting/mute/c$b", "Lcom/tencent/mobileqq/guild/setting/mute/c$b;", "guildUnreadCallback", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static final e12.a<Triple<String, String, Boolean>> userAdminChangeLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private static ServiceCache$LazyHolder serviceHolder;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private static final GPServiceObserver muteObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static final Runnable countDownRunnable;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static final b guildUnreadCallback;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f234815d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int nextCountDownTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, e12.a<Long>> muteMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler countDownHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final e12.a<String> userMuteChangeLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J8\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/c$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "", "expireTime", "onShutUpStateChanged", "", "result", "errMsg", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "onUserProfileInfoUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            IGProGuildInfo iGProGuildInfo;
            long j3;
            boolean z16;
            AppRuntime o16;
            IGuildUnreadService iGuildUnreadService;
            IGPSService iGPSService;
            boolean T = c.T(guildId);
            c cVar = c.f234815d;
            AppRuntime o17 = cVar.o();
            String str = null;
            if (o17 != null && (iGPSService = (IGPSService) o17.getRuntimeService(IGPSService.class, "")) != null) {
                iGProGuildInfo = iGPSService.getGuildInfo(guildId);
            } else {
                iGProGuildInfo = null;
            }
            if (iGProGuildInfo != null) {
                j3 = iGProGuildInfo.getShutUpExpireTime();
            } else {
                j3 = 0;
            }
            if (iGProGuildInfo != null) {
                str = iGProGuildInfo.getGuildID();
            }
            c.X(str, j3, "onGuildInfoUpdated");
            if (guildId != null && guildId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && T && !c.T(guildId) && (o16 = cVar.o()) != null && (iGuildUnreadService = (IGuildUnreadService) o16.getRuntimeService(IGuildUnreadService.class, "")) != null) {
                iGuildUnreadService.refreshGuildUnread(guildId);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            boolean z16;
            AppRuntime o16;
            IGuildUnreadService iGuildUnreadService;
            boolean T = c.T(guildId);
            c cVar = c.f234815d;
            cVar.Y(guildId, expireTime, "onShutUpStateChanged");
            if (guildId != null && guildId.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && T && !c.T(guildId) && (o16 = cVar.o()) != null && (iGuildUnreadService = (IGuildUnreadService) o16.getRuntimeService(IGuildUnreadService.class, "")) != null) {
                iGuildUnreadService.refreshGuildUnread(guildId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @Nullable String errMsg, @Nullable String guildId, @Nullable String tinyId, @Nullable ev info) {
            if (result == 0 && info != null) {
                c.Z(guildId, tinyId, info.getShutUpExpireTime(), c.TAG);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/mute/c$b", "Lcom/tencent/mobileqq/guild/message/unread/api/e;", "", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "unreadCounts", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.message.unread.api.e {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.message.unread.api.e
        public void a(@NotNull List<Pair<String, UnreadInfo.a>> unreadCounts) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(unreadCounts, "unreadCounts");
            List<Pair<String, UnreadInfo.a>> list = unreadCounts;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Pair) it.next()).getFirst());
            }
            c.f234815d.Q(arrayList);
        }
    }

    static {
        Object m476constructorimpl;
        String stackTraceToString;
        c cVar = new c();
        f234815d = cVar;
        TAG = "Q_G_MUTE.GuildChannelMuteManager";
        nextCountDownTime = 2;
        muteMap = new ConcurrentHashMap<>();
        countDownHandler = new Handler(Looper.getMainLooper());
        userMuteChangeLiveData = new e12.a<>();
        userAdminChangeLiveData = new e12.a<>();
        muteObserver = cVar.n();
        countDownRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.setting.mute.a
            @Override // java.lang.Runnable
            public final void run() {
                c.m();
            }
        };
        guildUnreadCallback = new b();
        AccountChangedNotifier.f214789d.a(cVar);
        try {
            Result.Companion companion = Result.INSTANCE;
            cVar.j();
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        final Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            String str = TAG;
            Logger.a d16 = logger.d();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
            d16.w(str, 1, "init warn:" + m479exceptionOrNullimpl + "\n" + stackTraceToString);
            Function0.b(60000, new Runnable() { // from class: com.tencent.mobileqq.guild.setting.mute.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.P(m479exceptionOrNullimpl);
                }
            });
        }
    }

    c() {
    }

    @JvmStatic
    public static final long A(int day, int hour, int minute) {
        if (day == 0 && hour == 0 && minute == 0) {
            return 0L;
        }
        return f234815d.q() + (day * 86400) + (hour * 3600) + (minute * 60);
    }

    @JvmStatic
    @NotNull
    public static final String B(@Nullable Long muteLastTimeSecond) {
        c cVar = f234815d;
        long q16 = cVar.q();
        if (muteLastTimeSecond != null && muteLastTimeSecond.longValue() > q16) {
            long longValue = muteLastTimeSecond.longValue() - q16;
            if (longValue < 3600) {
                return cVar.F(longValue);
            }
            if (longValue < 86400) {
                long j3 = 3600;
                long j16 = (longValue % j3) / 60;
                if (j16 == 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%s\u5c0f\u65f6", Arrays.copyOf(new Object[]{Long.valueOf(longValue / j3)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    return format;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%s\u5c0f\u65f6%s\u5206\u949f", Arrays.copyOf(new Object[]{Long.valueOf(longValue / j3), Long.valueOf(j16)}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                return format2;
            }
            long j17 = 86400;
            long j18 = (longValue % j17) / 3600;
            if (j18 == 0) {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String format3 = String.format("%s\u5929", Arrays.copyOf(new Object[]{Long.valueOf(longValue / j17)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                return format3;
            }
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format4 = String.format("%s\u5929%s\u5c0f\u65f6", Arrays.copyOf(new Object[]{Long.valueOf(longValue / j17), Long.valueOf(j18)}, 2));
            Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
            return format4;
        }
        return "";
    }

    @JvmStatic
    @NotNull
    public static final e12.a<Long> C(@Nullable String guildId) {
        String D = f234815d.D(guildId);
        ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
        if (!concurrentHashMap.containsKey(D)) {
            concurrentHashMap.put(D, new e12.a<>(0L));
        }
        e12.a<Long> aVar = concurrentHashMap.get(D);
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    private final String D(String guildId) {
        String str = "-1";
        if (guildId == null) {
            guildId = "-1";
        }
        String E = E();
        if (E != null) {
            str = E;
        }
        return guildId + str;
    }

    private final String E() {
        IGPSService iGPSService;
        AppRuntime o16 = o();
        if (o16 != null && (iGPSService = (IGPSService) o16.getRuntimeService(IGPSService.class, "")) != null) {
            return iGPSService.getSelfTinyId();
        }
        return null;
    }

    private final String F(long time) {
        int i3;
        long j3 = 60;
        if (time % j3 >= 30) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        long j16 = (time / j3) + i3;
        if (j16 > 59) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s\u5c0f\u65f6", Arrays.copyOf(new Object[]{1}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (j16 < 1) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%s\u5206\u949f", Arrays.copyOf(new Object[]{1}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("%s\u5206\u949f", Arrays.copyOf(new Object[]{Long.valueOf(j16)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        return format3;
    }

    @JvmStatic
    @NotNull
    public static final String G(@Nullable Long muteLastTimeSecond) {
        long q16 = f234815d.q();
        if (muteLastTimeSecond != null && muteLastTimeSecond.longValue() > q16) {
            long longValue = muteLastTimeSecond.longValue() - q16;
            long j3 = 60;
            long j16 = longValue / j3;
            if (longValue - (j16 * j3) > 30) {
                j16++;
            }
            long j17 = j16 / j3;
            long j18 = 24;
            long j19 = j17 / j18;
            long j26 = j17 % j18;
            long j27 = j16 % j3;
            if (j19 >= 1) {
                if (j26 >= 1) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%s\u5929%s\u5c0f\u65f6", Arrays.copyOf(new Object[]{Long.valueOf(j19), Long.valueOf(j26)}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    return format;
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%s\u5929", Arrays.copyOf(new Object[]{Long.valueOf(j19)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                return format2;
            }
            if (j26 >= 1) {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String format3 = String.format("%s\u5c0f\u65f6", Arrays.copyOf(new Object[]{Long.valueOf(j26)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                return format3;
            }
            if (j27 >= 1) {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String format4 = String.format("%s\u5206\u949f", Arrays.copyOf(new Object[]{Long.valueOf(j27)}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(format, *args)");
                return format4;
            }
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            String format5 = String.format("%s\u5206\u949f", Arrays.copyOf(new Object[]{1}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "format(format, *args)");
            return format5;
        }
        return "";
    }

    @JvmStatic
    public static final long H(@NotNull String guildId, @NotNull String tinyId) {
        Long l3;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        String L = f234815d.L(guildId, tinyId);
        ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
        if (!concurrentHashMap.containsKey(L)) {
            return 0L;
        }
        e12.a<Long> aVar = concurrentHashMap.get(L);
        if (aVar != null) {
            l3 = aVar.getValue();
        } else {
            l3 = null;
        }
        if (l3 == null) {
            return 0L;
        }
        return l3.longValue();
    }

    @JvmStatic
    @NotNull
    public static final LiveData<Triple<String, String, Boolean>> I() {
        return userAdminChangeLiveData;
    }

    @JvmStatic
    @NotNull
    public static final e12.a<Long> J(@Nullable String guildId, @Nullable String tinyId) {
        String L = f234815d.L(guildId, tinyId);
        ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
        if (!concurrentHashMap.containsKey(L)) {
            concurrentHashMap.put(L, new e12.a<>(0L));
        }
        e12.a<Long> aVar = concurrentHashMap.get(L);
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    @JvmStatic
    @NotNull
    public static final e12.a<String> K() {
        return userMuteChangeLiveData;
    }

    private final String L(String guildId, String tinyId) {
        if (guildId == null) {
            guildId = "-1";
        }
        if (tinyId == null) {
            tinyId = "-1";
        }
        return guildId + tinyId;
    }

    @JvmStatic
    public static final boolean M(@Nullable String guildId) {
        boolean z16;
        String stackTraceToString;
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger.f235387a.d().w(TAG, 1, "hasGuildMuteManagePermission guildId is nullOrEmpty, please check guildId");
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            return com.tencent.mobileqq.guild.rolegroup.model.repositories.r.p().getGuildPermission(guildId).a(90001);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)));
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                String str = TAG;
                Logger.a d16 = logger.d();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                d16.w(str, 1, "hasGuildMuteManagePermission warn:" + m479exceptionOrNullimpl + "\n" + stackTraceToString);
            }
            return false;
        }
    }

    private final boolean N(String guildId) {
        Long value = s(guildId).getValue();
        Long l3 = 0L;
        if (value == null) {
            value = l3;
        }
        long longValue = value.longValue();
        Long value2 = C(guildId).getValue();
        if (value2 != null) {
            l3 = value2;
        }
        if (longValue > l3.longValue()) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean O(@Nullable Long lastMuteTime) {
        if (lastMuteTime != null && f234815d.q() < lastMuteTime.longValue()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Throwable it) {
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(it, "$it");
        Logger logger = Logger.f235387a;
        String str = TAG;
        Logger.a d16 = logger.d();
        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(it);
        d16.w(str, 1, "init postDelay warn:" + it + "\n" + stackTraceToString);
        try {
            Result.Companion companion = Result.INSTANCE;
            f234815d.j();
            Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(List<String> guildIdList) {
        Iterator<String> it = guildIdList.iterator();
        while (it.hasNext()) {
            String D = D(it.next());
            ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
            if (concurrentHashMap.containsKey(D)) {
                e12.a<Long> aVar = concurrentHashMap.get(D);
                Intrinsics.checkNotNull(aVar);
                e12.a<Long> aVar2 = concurrentHashMap.get(D);
                Intrinsics.checkNotNull(aVar2);
                aVar.setValue(aVar2.getValue());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R(String guildId) {
        Long l3;
        IGProGuildInfo L = ch.L(guildId);
        if (L == null) {
            return;
        }
        String D = D(guildId);
        Logger logger = Logger.f235387a;
        String str = TAG;
        Logger.a d16 = logger.d();
        long shutUpExpireTime = L.getShutUpExpireTime();
        e12.a aVar = (e12.a) muteMap.get(guildId);
        Long l16 = null;
        if (aVar != null) {
            l3 = (Long) aVar.getValue();
        } else {
            l3 = null;
        }
        long myShutUpExpireTime = L.getMyShutUpExpireTime();
        e12.a aVar2 = (e12.a) muteMap.get(D);
        if (aVar2 != null) {
            l16 = (Long) aVar2.getValue();
        }
        d16.d(str, 1, "prepareMuteInfoIfNeeded global:" + shutUpExpireTime + "  curGlobal:" + l3 + "  self:" + myShutUpExpireTime + " curSelf:" + l16 + " curTime:" + f234815d.q());
        ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
        if (concurrentHashMap.get(guildId) == null) {
            concurrentHashMap.put(guildId, new e12.a<>(Long.valueOf(L.getShutUpExpireTime())));
        } else {
            e12.a<Long> aVar3 = concurrentHashMap.get(guildId);
            Intrinsics.checkNotNull(aVar3);
            Long value = aVar3.getValue();
            long shutUpExpireTime2 = L.getShutUpExpireTime();
            if (value == null || value.longValue() != shutUpExpireTime2) {
                e12.a<Long> aVar4 = concurrentHashMap.get(guildId);
                Intrinsics.checkNotNull(aVar4);
                aVar4.setValue(Long.valueOf(L.getShutUpExpireTime()));
            }
        }
        if (concurrentHashMap.get(D) == null) {
            concurrentHashMap.put(D, new e12.a<>(Long.valueOf(L.getMyShutUpExpireTime())));
            return;
        }
        e12.a<Long> aVar5 = concurrentHashMap.get(D);
        Intrinsics.checkNotNull(aVar5);
        Long value2 = aVar5.getValue();
        long myShutUpExpireTime2 = L.getMyShutUpExpireTime();
        if (value2 == null || value2.longValue() != myShutUpExpireTime2) {
            e12.a<Long> aVar6 = concurrentHashMap.get(D);
            Intrinsics.checkNotNull(aVar6);
            aVar6.setValue(Long.valueOf(L.getMyShutUpExpireTime()));
        }
    }

    private final void S() {
        String str = TAG;
        GPServiceObserver gPServiceObserver = muteObserver;
        QLog.i(str, 1, "[removeGPService] observerId: " + System.identityHashCode(gPServiceObserver));
        ServiceCache$LazyHolder serviceCache$LazyHolder = serviceHolder;
        ServiceCache$LazyHolder serviceCache$LazyHolder2 = null;
        if (serviceCache$LazyHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            serviceCache$LazyHolder = null;
        }
        serviceCache$LazyHolder.b().deleteObserver(gPServiceObserver);
        ServiceCache$LazyHolder serviceCache$LazyHolder3 = serviceHolder;
        if (serviceCache$LazyHolder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
        } else {
            serviceCache$LazyHolder2 = serviceCache$LazyHolder3;
        }
        serviceCache$LazyHolder2.f().unRegisterGuildUnreadCallback(guildUnreadCallback);
        countDownHandler.removeCallbacks(countDownRunnable);
    }

    @JvmStatic
    public static final boolean T(@Nullable String guildId) {
        Long value = C(guildId).getValue();
        Long l3 = 0L;
        if (value == null) {
            value = l3;
        }
        long longValue = value.longValue();
        Long value2 = s(guildId).getValue();
        if (value2 != null) {
            l3 = value2;
        }
        long longValue2 = l3.longValue();
        Logger logger = Logger.f235387a;
        String str = TAG;
        if (QLog.isDevelopLevel()) {
            Log.d(str, "selfIsMute guildId:" + guildId + " selfMute[" + longValue + "}] allMute[" + longValue2 + "]");
        }
        if (f234815d.q() < Math.max(longValue, longValue2)) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean U(@Nullable String guildId) {
        String stackTraceToString;
        IGPSService iGPSService;
        if (guildId == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            AppRuntime o16 = f234815d.o();
            if (o16 != null) {
                iGPSService = (IGPSService) o16.getRuntimeService(IGPSService.class, "");
            } else {
                iGPSService = null;
            }
            if (iGPSService == null) {
                return false;
            }
            return ch.t0(iGPSService.getGuildInfo(guildId));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)));
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                String str = TAG;
                Logger.a d16 = logger.d();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                d16.w(str, 1, "selfIsQQGuildManager warn:" + m479exceptionOrNullimpl + "\n" + stackTraceToString);
            }
            return false;
        }
    }

    @JvmStatic
    public static final boolean V(@Nullable String guildId, @Nullable String channelId) {
        String stackTraceToString;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (!U(guildId)) {
                if (!ch.h0(channelId)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)));
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                String str = TAG;
                Logger.a d16 = logger.d();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                d16.w(str, 1, "selfIsQQGuildOrChannelManager warn:" + m479exceptionOrNullimpl + "\n" + stackTraceToString);
            }
            return false;
        }
    }

    @JvmStatic
    public static final void W(@NotNull String guildId, @NotNull String tinyId, boolean isAdmin) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        userAdminChangeLiveData.setValue(new Triple<>(guildId, tinyId, Boolean.valueOf(isAdmin)));
    }

    @JvmStatic
    public static final void X(@Nullable String guildId, long muteLastTimeSecond, @NotNull String from) {
        String str;
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        String str2 = TAG;
        logger.d().i(str2, 1, "[updateMuteAll] guild:" + guildId + " time:" + muteLastTimeSecond + " from:" + from);
        if (guildId == null) {
            str = "-1";
        } else {
            str = guildId;
        }
        ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
        if (!concurrentHashMap.containsKey(str)) {
            concurrentHashMap.put(str, new e12.a<>(0L));
        }
        e12.a<Long> aVar = concurrentHashMap.get(str);
        Intrinsics.checkNotNull(aVar);
        aVar.postValue(Long.valueOf(muteLastTimeSecond));
        e12.a<Long> C = C(guildId);
        C.postValue(C.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(String guildId, long muteLastTimeSecond, String from) {
        Logger logger = Logger.f235387a;
        String str = TAG;
        logger.d().i(str, 1, "updateSelfMute guildId:" + guildId + " time:" + muteLastTimeSecond + " from:" + from);
        String D = D(guildId);
        ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
        if (!concurrentHashMap.containsKey(D)) {
            concurrentHashMap.put(D, new e12.a<>(0L));
        }
        e12.a<Long> aVar = concurrentHashMap.get(D);
        Intrinsics.checkNotNull(aVar);
        aVar.postValue(Long.valueOf(muteLastTimeSecond));
    }

    @JvmStatic
    public static final void Z(@Nullable String guildId, @Nullable String tinyId, long muteLastTimeSecond, @NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Logger logger = Logger.f235387a;
        String str = TAG;
        logger.d().i(str, 1, "[updateMuteUser] guild:" + guildId + " tinyId:" + tinyId + " time:" + muteLastTimeSecond + " from:" + from);
        String L = f234815d.L(guildId, tinyId);
        ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
        if (!concurrentHashMap.containsKey(L)) {
            concurrentHashMap.put(L, new e12.a<>(0L));
        }
        e12.a<Long> aVar = concurrentHashMap.get(L);
        Intrinsics.checkNotNull(aVar);
        aVar.postValue(Long.valueOf(muteLastTimeSecond));
    }

    private final void j() {
        String str = TAG;
        GPServiceObserver gPServiceObserver = muteObserver;
        QLog.i(str, 1, "[addGPService] observerId: " + System.identityHashCode(gPServiceObserver));
        ServiceCache$LazyHolder serviceCache$LazyHolder = new ServiceCache$LazyHolder(str);
        serviceHolder = serviceCache$LazyHolder;
        serviceCache$LazyHolder.b().addObserver(gPServiceObserver);
        ServiceCache$LazyHolder serviceCache$LazyHolder2 = serviceHolder;
        if (serviceCache$LazyHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            serviceCache$LazyHolder2 = null;
        }
        serviceCache$LazyHolder2.f().registerGuildUnreadCallback(guildUnreadCallback);
        countDownHandler.removeCallbacks(countDownRunnable);
        k();
    }

    private final void k() {
        countDownHandler.postDelayed(countDownRunnable, nextCountDownTime * 1000);
    }

    @JvmStatic
    public static final boolean l(@Nullable String guildId) {
        if (M(guildId)) {
            Logger logger = Logger.f235387a;
            String str = TAG;
            if (QLog.isDebugVersion()) {
                logger.d().d(str, 1, "selfIsMute guildId:" + guildId + " hasGuildMuteManagePermission");
                return false;
            }
            return false;
        }
        return T(guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m() {
        int i3;
        boolean z16;
        boolean z17;
        long q16 = f234815d.q();
        boolean z18 = false;
        boolean z19 = false;
        for (String str : muteMap.keySet()) {
            ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
            e12.a<Long> aVar = concurrentHashMap.get(str);
            Intrinsics.checkNotNull(aVar);
            Long value = aVar.getValue();
            if (value == null) {
                value = 0L;
            }
            long longValue = value.longValue();
            e12.a<Long> aVar2 = concurrentHashMap.get(str);
            Intrinsics.checkNotNull(aVar2);
            aVar2.setValue(Long.valueOf(longValue));
            if (!z19) {
                long j3 = longValue - q16;
                if (1 <= j3 && j3 < 70) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z19 = false;
                    if (z18) {
                        long j16 = longValue - q16;
                        if (1 <= j16 && j16 < 20) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            z18 = false;
                        }
                    }
                    z18 = true;
                }
            }
            z19 = true;
            if (z18) {
            }
            z18 = true;
        }
        if (z18) {
            i3 = 2;
        } else if (z19) {
            i3 = 15;
        } else {
            i3 = 60;
        }
        nextCountDownTime = i3;
        Logger logger = Logger.f235387a;
        String str2 = TAG;
        if (QLog.isColorLevel()) {
            logger.d().d(str2, 2, "countDownRunnable run next:" + nextCountDownTime + " s");
        }
        f234815d.k();
    }

    private final GPServiceObserver n() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppRuntime o() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final String p(String guildId, int formatId) {
        Long value = C(guildId).getValue();
        Long l3 = 0L;
        if (value == null) {
            value = l3;
        }
        long longValue = value.longValue();
        Long value2 = s(guildId).getValue();
        if (value2 != null) {
            l3 = value2;
        }
        String G = G(Long.valueOf(Math.max(longValue, l3.longValue())));
        if (TextUtils.isEmpty(G)) {
            return "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(formatId);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(formatId)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{G}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long q() {
        return NetConnInfoCenter.getServerTime();
    }

    @JvmStatic
    @NotNull
    public static final String r(long muteLastTimeSecond) {
        String G = G(Long.valueOf(muteLastTimeSecond));
        if (TextUtils.isEmpty(G)) {
            return G;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f1505915e);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_mute_hint_in_member_list)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{G}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @JvmStatic
    @NotNull
    public static final e12.a<Long> s(@Nullable String guildId) {
        String t16 = f234815d.t(guildId);
        ConcurrentHashMap<String, e12.a<Long>> concurrentHashMap = muteMap;
        if (!concurrentHashMap.containsKey(t16)) {
            concurrentHashMap.put(t16, new e12.a<>(0L));
        }
        e12.a<Long> aVar = concurrentHashMap.get(t16);
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    private final String t(String guildId) {
        if (guildId == null) {
            return "-1";
        }
        return guildId;
    }

    @JvmStatic
    @NotNull
    public static final String u(@Nullable String guildId, @Nullable String channelId) {
        boolean z16;
        int i3;
        if (guildId != null) {
            f234815d.R(guildId);
        }
        boolean z17 = false;
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && M(guildId)) {
            z17 = true;
        }
        if (z17) {
            i3 = R.string.f1505815d;
        } else if (f234815d.N(guildId)) {
            i3 = R.string.f1506215h;
        } else {
            i3 = R.string.f158151ou;
        }
        return f234815d.p(guildId, i3);
    }

    @JvmStatic
    @NotNull
    public static final String v(@Nullable String guildId) {
        if (guildId != null) {
            f234815d.R(guildId);
        }
        return f234815d.p(guildId, R.string.f1506315i);
    }

    @JvmStatic
    @NotNull
    public static final String w(@Nullable String guildId, @Nullable String channelId) {
        if (guildId != null) {
            f234815d.R(guildId);
        }
        return f234815d.p(guildId, R.string.f1506415j);
    }

    @JvmStatic
    @NotNull
    public static final String x(boolean userMute, @Nullable Long lastMuteSecond) {
        int i3;
        if (userMute) {
            i3 = R.string.f158151ou;
        } else {
            i3 = R.string.f1506215h;
        }
        String G = G(lastMuteSecond);
        if (TextUtils.isEmpty(G)) {
            return G;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(i3);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(formatId)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{G}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @JvmStatic
    @NotNull
    public static final String y(long lastMuteSecond) {
        String G = G(Long.valueOf(lastMuteSecond));
        if (TextUtils.isEmpty(G)) {
            return G;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f1506515k);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(formatId)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{G}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @JvmStatic
    @NotNull
    public static final String z(@Nullable String guildId) {
        String str;
        if (guildId != null) {
            f234815d.R(guildId);
        }
        if (U(guildId)) {
            String r16 = QQGuildUIUtil.r(R.string.f1505815d);
            Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.guild_mute_all_switch_on)");
            return r16;
        }
        if (f234815d.N(guildId)) {
            str = "\u5168\u5458";
        } else {
            str = "";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr = HardCodeUtil.qqStr(R.string.f1506615l);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_mute_user_simple_hint_format)");
        String format = String.format(qqStr, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(account, "account");
        QLog.i(TAG, 1, "[onAccountChanged] account:" + account);
        try {
            Result.Companion companion = Result.INSTANCE;
            c cVar = f234815d;
            cVar.S();
            muteMap.clear();
            cVar.j();
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            Logger logger = Logger.f235387a;
            String str = TAG;
            Logger.a d16 = logger.d();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
            d16.w(str, 1, "onAccountChanged warn:" + m479exceptionOrNullimpl + "\n" + stackTraceToString);
        }
    }
}
