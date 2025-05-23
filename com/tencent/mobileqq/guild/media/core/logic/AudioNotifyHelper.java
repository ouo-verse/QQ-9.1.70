package com.tencent.mobileqq.guild.media.core.logic;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 D2\u00020\u0001:\u0001KB\u0007\u00a2\u0006\u0004\bQ\u0010RJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013J\u001e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eJ&\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0004J6\u0010!\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u000eJ\u0016\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u0004J&\u0010,\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u000e2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*J\u0016\u0010/\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u0004J\u001e\u00102\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002J\u001e\u00104\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0004J\u001c\u00107\u001a\u00020\b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000e052\u0006\u0010\u001b\u001a\u00020\u0004J\u0010\u0010:\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u000108J\u0006\u0010;\u001a\u00020\bJ\u0010\u0010<\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u000108J\u0010\u0010=\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u000108J\u0010\u0010>\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u000108J\u0010\u0010?\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u000108J\u001a\u0010B\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010A\u001a\u0004\u0018\u00010@J\u0006\u0010C\u001a\u00020\bJ\u0006\u0010D\u001a\u00020\bJ\u0010\u0010F\u001a\u00020\b2\b\u0010E\u001a\u0004\u0018\u00010\u000eJ\u001e\u0010H\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010G\u001a\u00020\u000eR\u001c\u0010M\u001a\n J*\u0004\u0018\u00010I0I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\n0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010O\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/AudioNotifyHelper;", "", "", "type", "", "isSuccess", "Lcom/tencent/mobileqq/guild/media/core/data/i;", "data", "", "d", "Lcom/tencent/mobileqq/guild/media/core/notify/q;", "observer", "b", "B", "", "from", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "guildId", "channelId", "reason", "g", "tinyId", "isEnter", tl.h.F, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorTypeMsg", "errorCode", "errorCodeMsg", "f", "l", "canTalk", DomainData.DOMAIN_NAME, "connected", "j", "channelID", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "Lkotlin/collections/ArrayList;", "qualityList", "p", "userId", "available", ReportConstant.COSTREPORT_PREFIX, "width", "height", "t", "status", "r", "", "userIdList", "i", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "o", "e", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "u", "v", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "channelNumber", HippyTKDListViewAdapter.X, "w", "c", "action", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "newAuth", "k", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "a", "Landroid/os/Handler;", "handler", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "observers", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class AudioNotifyHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Handler handler = ThreadManagerV2.getUIHandlerV2();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.media.core.notify.q> observers = new CopyOnWriteArrayList<>();

    public final void A(@Nullable final IGProChannelInfo channelInfo) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).m(channelInfo);
            }
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper$notifyUserWaitingToSpeak$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = AudioNotifyHelper.this.observers.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.guild.media.core.notify.q) it5.next()).m(channelInfo);
                }
            }
        });
    }

    public final void B(@NotNull com.tencent.mobileqq.guild.media.core.notify.q observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
    }

    public final void b(@NotNull com.tencent.mobileqq.guild.media.core.notify.q observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
        this.observers.add(observer);
    }

    public final void c() {
        Iterator<com.tencent.mobileqq.guild.media.core.notify.q> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Deprecated(message = "\u540e\u7eed\u4e0d\u8d70\u8fd9\u4e2a\u51fd\u6570\u4e86\uff0c\u58f0\u660e\u63a5\u53e3\u5b9e\u73b0\uff0c\u53ef\u4ee5\u53c2\u8003notifyUIForSelfRoleTypeChange")
    public final void d(final int type, final boolean isSuccess, @NotNull final com.tencent.mobileqq.guild.media.core.data.i data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).f(type, isSuccess, data);
            }
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper$notifyUI$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = AudioNotifyHelper.this.observers.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.guild.media.core.notify.q) it5.next()).f(type, isSuccess, data);
                }
            }
        });
    }

    public final void e() {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).a();
            }
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper$notifyUIForBusinessStateUpdated$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = AudioNotifyHelper.this.observers.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.guild.media.core.notify.q) it5.next()).a();
                }
            }
        });
    }

    public final void f(@NotNull String guildId, @NotNull String channelId, int errorType, @NotNull String errorTypeMsg, int errorCode, @NotNull String errorCodeMsg) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(errorTypeMsg, "errorTypeMsg");
        Intrinsics.checkNotNullParameter(errorCodeMsg, "errorCodeMsg");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(1, guildId);
        iVar.b(2, channelId);
        iVar.b(6, Integer.valueOf(errorType));
        iVar.b(7, errorTypeMsg);
        iVar.b(8, Integer.valueOf(errorCode));
        iVar.b(9, errorCodeMsg);
        d(3, true, iVar);
    }

    public final void g(@NotNull String guildId, @NotNull String channelId, @NotNull String reason) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(1, guildId);
        iVar.b(2, channelId);
        iVar.b(5, reason);
        d(2, true, iVar);
    }

    public final void h(@NotNull String guildId, @NotNull String channelId, @NotNull String tinyId, boolean isEnter) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(1, guildId);
        iVar.b(2, channelId);
        iVar.b(23, tinyId);
        iVar.b(25, Boolean.valueOf(isEnter));
        d(16, true, iVar);
    }

    public final void i(@NotNull List<String> userIdList, boolean isEnter) {
        Intrinsics.checkNotNullParameter(userIdList, "userIdList");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(24, userIdList);
        iVar.b(25, Boolean.valueOf(isEnter));
        d(15, true, iVar);
    }

    public final void j(boolean connected) {
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(14, Boolean.valueOf(connected));
        d(8, true, iVar);
    }

    public final void k(@NotNull String guildId, @NotNull String channelId, @NotNull String newAuth) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(newAuth, "newAuth");
        Iterator<com.tencent.mobileqq.guild.media.core.notify.q> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().c(guildId, channelId, newAuth);
        }
    }

    public final void l(@NotNull com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @NotNull com.tencent.mobileqq.guild.media.core.data.r userInfoList) {
        Intrinsics.checkNotNullParameter(localUserInfo, "localUserInfo");
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(3, localUserInfo);
        d(4, true, iVar);
    }

    public final void m(@NotNull String from, @NotNull com.tencent.mobileqq.guild.media.core.data.f localUserInfo) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(localUserInfo, "localUserInfo");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(1, localUserInfo.P);
        iVar.b(2, localUserInfo.Q);
        iVar.b(3, localUserInfo.c());
        iVar.b(10, from);
        d(1, true, iVar);
    }

    public final void n(boolean canTalk, int type) {
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(13, Boolean.valueOf(canTalk));
        iVar.b(20, Integer.valueOf(type));
        d(7, true, iVar);
    }

    public final void o(@Nullable final IGProChannelInfo channelInfo) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).e(channelInfo);
            }
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper$notifyUIForSpeakModeChanged$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = AudioNotifyHelper.this.observers.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.guild.media.core.notify.q) it5.next()).e(channelInfo);
                }
            }
        });
    }

    public final void p(@NotNull String channelID, @NotNull ArrayList<TRTCQuality> qualityList) {
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(qualityList, "qualityList");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(2, channelID);
        iVar.b(15, qualityList);
        d(9, true, iVar);
    }

    public final void q(@NotNull com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @NotNull com.tencent.mobileqq.guild.media.core.data.r userInfoList) {
        Intrinsics.checkNotNullParameter(localUserInfo, "localUserInfo");
        Intrinsics.checkNotNullParameter(userInfoList, "userInfoList");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(1, localUserInfo.P);
        iVar.b(2, localUserInfo.Q);
        iVar.b(3, localUserInfo);
        iVar.b(4, userInfoList);
        d(13, true, iVar);
    }

    public final void r(@NotNull String from, @NotNull String userId, boolean status) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(userId, "userId");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(10, from);
        iVar.b(21, userId);
        iVar.b(22, Boolean.valueOf(status));
        d(12, true, iVar);
    }

    public final void s(@NotNull String userId, boolean available) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(16, userId);
        iVar.b(17, Boolean.valueOf(available));
        d(10, true, iVar);
    }

    public final void t(@NotNull String userId, int width, int height) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        com.tencent.mobileqq.guild.media.core.data.i iVar = new com.tencent.mobileqq.guild.media.core.data.i();
        iVar.b(16, userId);
        iVar.b(18, Integer.valueOf(width));
        iVar.b(19, Integer.valueOf(height));
        d(11, true, iVar);
    }

    public final void u(@Nullable final IGProChannelInfo channelInfo) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).g(channelInfo);
            }
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper$notifyUserAVStateReset$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = AudioNotifyHelper.this.observers.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.guild.media.core.notify.q) it5.next()).g(channelInfo);
                }
            }
        });
    }

    public final void v(@Nullable final IGProChannelInfo channelInfo) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).h(channelInfo);
            }
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper$notifyUserEnterAudioQueue$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = AudioNotifyHelper.this.observers.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.guild.media.core.notify.q) it5.next()).h(channelInfo);
                }
            }
        });
    }

    public final void w() {
        Iterator<com.tencent.mobileqq.guild.media.core.notify.q> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
    }

    public final void x(@Nullable final String from, @Nullable final IGProChannelUserNum channelNumber) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).j(from, channelNumber);
            }
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper$notifyUserNumberOfChannelChange$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = AudioNotifyHelper.this.observers.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.guild.media.core.notify.q) it5.next()).j(from, channelNumber);
                }
            }
        });
    }

    public final void y(@Nullable final IGProChannelInfo channelInfo) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.media.core.notify.q) it.next()).k(channelInfo);
            }
            return;
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper$notifyUserSpeaking$$inlined$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = AudioNotifyHelper.this.observers.iterator();
                while (it5.hasNext()) {
                    ((com.tencent.mobileqq.guild.media.core.notify.q) it5.next()).k(channelInfo);
                }
            }
        });
    }

    public final void z(@Nullable String action) {
        Iterator<com.tencent.mobileqq.guild.media.core.notify.q> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().l(action);
        }
    }
}
