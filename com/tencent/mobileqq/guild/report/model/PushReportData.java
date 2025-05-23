package com.tencent.mobileqq.guild.report.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.report.i;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.group_pro_proto.reportsvr.ReportSvr$Record;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0018UB\u0007\u00a2\u0006\u0004\bO\u0010PB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\bO\u0010QB\u0011\b\u0016\u0012\u0006\u0010R\u001a\u00020\u000f\u00a2\u0006\u0004\bO\u0010SJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0011\u001a\u00020\u0010*\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\rH\u0002R$\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR$\u0010*\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR$\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\"\u0010/\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b7\u00104R$\u00108\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001eR\"\u0010;\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u00100\u001a\u0004\b<\u00102\"\u0004\b=\u00104R$\u0010>\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u001a\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010\u001eR$\u0010A\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001a\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR$\u0010D\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u001a\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010\u001eR\u0013\u0010J\u001a\u0004\u0018\u00010G8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010IR\u0013\u0010N\u001a\u0004\u0018\u00010K8F\u00a2\u0006\u0006\u001a\u0004\bL\u0010M\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/guild/report/model/PushReportData;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/guild/report/i;", "Landroid/os/Parcelable;", "Ltencent/im/group_pro_proto/reportsvr/ReportSvr$Record;", "toRecord", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "isDirectMsg", "msgRecord", "c", "e", "channelId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "a", "b", "d", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "action", "", "time", "J", "getTime", "()J", "setTime", "(J)V", "uin", "getUin", "setUin", "guildId", "getGuildId", "setGuildId", "getChannelId", "setChannelId", "appStatus", "I", "getAppStatus", "()I", "setAppStatus", "(I)V", "pushType", "getPushType", "setPushType", "senderTinyId", "getSenderTinyId", "setSenderTinyId", "channelType", "getChannelType", "setChannelType", "sgrpPushUrl", "getSgrpPushUrl", "setSgrpPushUrl", "feedId", "getFeedId", "setFeedId", "scheduleId", "getScheduleId", "setScheduleId", "Lmqq/app/AppRuntime;", "getApp", "()Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "<init>", "()V", "(Landroid/os/Parcel;)V", "msg", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "Companion", "PushType", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class PushReportData implements Serializable, i, Parcelable {

    @NotNull
    public static final String ACTION_CLICK = "click";

    @NotNull
    public static final String ACTION_PUSH = "push";

    @NotNull
    public static final String ACTION_RECEIVE = "receive";

    @NotNull
    public static final String GUILD_NOTIFY_REPORT = "guild_notify_report";

    @NotNull
    public static final String PLATFORM_ANDROID = "Android";
    public static final int STATUS_BACKGROUND = 2;
    public static final int STATUS_FOREGROUND = 1;

    @NotNull
    public static final String TABLE_NAME = "05900061849";

    @NotNull
    public static final String TAG = "PushReportData";
    private int appStatus;

    @Nullable
    private String channelId;
    private int channelType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private transient String action;

    @Nullable
    private String feedId;

    @Nullable
    private String guildId;
    private int pushType;

    @Nullable
    private String scheduleId;

    @Nullable
    private String senderTinyId;

    @Nullable
    private String sgrpPushUrl;
    private long time;

    @Nullable
    private String uin;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<PushReportData> CREATOR = new a();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/report/model/PushReportData$PushType;", "", "(Ljava/lang/String;I)V", "PUSH_TYPE_UNKNOWN", "PUSH_TYPE_AT_ALL", "PUSH_TYPE_AT_ME", "PUSH_TYPE_NORMAL", "PUSH_TYPE_RED_PACK", "PUSH_TYPE_NO_SUMMARY", "PUSH_TYPE_SUMMON_ALL", "PUSH_TYPE_DIRECT", "PUSH_TYPE_FEED", "PUSH_TYPE_AT_ONLINE", "PUSH_TYPE_AT_ROLE", "PUSH_TYPE_SUMMON_ONLINE", "PUSH_TYPE_SUMMON_ROLE", "PUSH_TYPE_FEATURED_GUILD", "PUSH_TYPE_OPERATOR_ANNOUNCEMENT", "PUSH_TYPE_SCHEDULE", "PUSH_TYPE_CHECK_IN", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum PushType {
        PUSH_TYPE_UNKNOWN,
        PUSH_TYPE_AT_ALL,
        PUSH_TYPE_AT_ME,
        PUSH_TYPE_NORMAL,
        PUSH_TYPE_RED_PACK,
        PUSH_TYPE_NO_SUMMARY,
        PUSH_TYPE_SUMMON_ALL,
        PUSH_TYPE_DIRECT,
        PUSH_TYPE_FEED,
        PUSH_TYPE_AT_ONLINE,
        PUSH_TYPE_AT_ROLE,
        PUSH_TYPE_SUMMON_ONLINE,
        PUSH_TYPE_SUMMON_ROLE,
        PUSH_TYPE_FEATURED_GUILD,
        PUSH_TYPE_OPERATOR_ANNOUNCEMENT,
        PUSH_TYPE_SCHEDULE,
        PUSH_TYPE_CHECK_IN
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/report/model/PushReportData$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/report/model/PushReportData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/report/model/PushReportData;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements Parcelable.Creator<PushReportData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PushReportData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PushReportData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PushReportData[] newArray(int size) {
            return new PushReportData[size];
        }
    }

    public PushReportData() {
        this.guildId = "";
        this.channelId = "";
        this.senderTinyId = "";
        this.sgrpPushUrl = "";
        this.feedId = "";
        this.scheduleId = "";
    }

    private final IGProChannelInfo a(String channelId) {
        IGPSService service = getService();
        if (service != null) {
            return service.getChannelInfo(channelId);
        }
        return null;
    }

    private final int b(String channelId) {
        IGProChannelInfo a16 = a(channelId);
        if (a16 != null) {
            return a16.getType();
        }
        return 0;
    }

    private final int c(MsgRecord msgRecord) {
        String str;
        PushType pushType;
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isShowContent(getApp())) {
            pushType = PushType.PUSH_TYPE_NO_SUMMARY;
        } else if (isDirectMsg(msgRecord)) {
            pushType = PushType.PUSH_TYPE_DIRECT;
        } else if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isRedPacketMsgApi(msgRecord)) {
            pushType = PushType.PUSH_TYPE_RED_PACK;
        } else if (MsgExtKt.J(msgRecord)) {
            pushType = PushType.PUSH_TYPE_SUMMON_ROLE;
        } else if (MsgExtKt.I(msgRecord)) {
            pushType = PushType.PUSH_TYPE_SUMMON_ONLINE;
        } else if (MsgExtKt.H(msgRecord)) {
            pushType = PushType.PUSH_TYPE_SUMMON_ALL;
        } else if (MsgExtKt.c(msgRecord)) {
            pushType = PushType.PUSH_TYPE_AT_ROLE;
        } else if (MsgExtKt.b(msgRecord, e())) {
            pushType = PushType.PUSH_TYPE_AT_ONLINE;
        } else if (MsgExtKt.D(msgRecord)) {
            pushType = PushType.PUSH_TYPE_AT_ALL;
        } else {
            IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
            IGPSService service = getService();
            if (service != null) {
                str = service.getSelfTinyId();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (iGuildTempApi.isAtMeMsgApi(msgRecord, str)) {
                pushType = PushType.PUSH_TYPE_AT_ME;
            } else {
                pushType = PushType.PUSH_TYPE_NORMAL;
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d(TAG, "pushType " + pushType);
        }
        return pushType.ordinal();
    }

    private final boolean e() {
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isUserOnLine();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final AppRuntime getApp() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    public final int getAppStatus() {
        return this.appStatus;
    }

    @Nullable
    public final String getChannelId() {
        return this.channelId;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @Nullable
    public final String getFeedId() {
        return this.feedId;
    }

    @Nullable
    public final String getGuildId() {
        return this.guildId;
    }

    public final int getPushType() {
        return this.pushType;
    }

    @Nullable
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @Nullable
    public final String getSenderTinyId() {
        return this.senderTinyId;
    }

    @Nullable
    public final IGPSService getService() {
        return at.d();
    }

    @Nullable
    public final String getSgrpPushUrl() {
        return this.sgrpPushUrl;
    }

    public final long getTime() {
        return this.time;
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    public final boolean isDirectMsg(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.directMsgFlag == 1) {
            return true;
        }
        return false;
    }

    public final void setAction(@Nullable String str) {
        this.action = str;
    }

    public final void setAppStatus(int i3) {
        this.appStatus = i3;
    }

    public final void setChannelId(@Nullable String str) {
        this.channelId = str;
    }

    public final void setChannelType(int i3) {
        this.channelType = i3;
    }

    public final void setFeedId(@Nullable String str) {
        this.feedId = str;
    }

    public final void setGuildId(@Nullable String str) {
        this.guildId = str;
    }

    public final void setPushType(int i3) {
        this.pushType = i3;
    }

    public final void setScheduleId(@Nullable String str) {
        this.scheduleId = str;
    }

    public final void setSenderTinyId(@Nullable String str) {
        this.senderTinyId = str;
    }

    public final void setSgrpPushUrl(@Nullable String str) {
        this.sgrpPushUrl = str;
    }

    public final void setTime(long j3) {
        this.time = j3;
    }

    public final void setUin(@Nullable String str) {
        this.uin = str;
    }

    @Override // com.tencent.mobileqq.guild.report.i
    @Nullable
    public ReportSvr$Record toRecord() {
        int i3;
        if (TextUtils.isEmpty(this.action) || TextUtils.isEmpty(this.uin) || this.time == 0 || this.appStatus == 0 || (i3 = this.pushType) == 0) {
            return null;
        }
        if (i3 != PushType.PUSH_TYPE_FEATURED_GUILD.ordinal() && this.pushType != PushType.PUSH_TYPE_SCHEDULE.ordinal() && (TextUtils.isEmpty(this.guildId) || TextUtils.isEmpty(this.channelId))) {
            return null;
        }
        ReportSvr$Record reportSvr$Record = new ReportSvr$Record();
        reportSvr$Record.table_name.set(ByteStringMicro.copyFromUtf8(TABLE_NAME));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(this.action));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(String.valueOf(this.time)));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(this.uin));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(this.guildId));
        String str = "";
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(""));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(this.channelId));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(""));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8("Android"));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(String.valueOf(this.appStatus)));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(String.valueOf(NetConnInfoCenter.getServerTime())));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(String.valueOf(this.pushType)));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(this.senderTinyId));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(String.valueOf(this.channelType)));
        reportSvr$Record.fields.add(ByteStringMicro.copyFromUtf8(""));
        PBRepeatField<ByteStringMicro> pBRepeatField = reportSvr$Record.fields;
        String str2 = this.sgrpPushUrl;
        if (str2 == null) {
            str2 = "";
        }
        pBRepeatField.add(ByteStringMicro.copyFromUtf8(str2));
        PBRepeatField<ByteStringMicro> pBRepeatField2 = reportSvr$Record.fields;
        String str3 = this.feedId;
        if (str3 == null) {
            str3 = "";
        }
        pBRepeatField2.add(ByteStringMicro.copyFromUtf8(str3));
        PBRepeatField<ByteStringMicro> pBRepeatField3 = reportSvr$Record.fields;
        String str4 = AppSetting.f99554n;
        if (str4 == null) {
            str4 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str4, "AppSetting.reportVersionName ?: \"\"");
        }
        pBRepeatField3.add(ByteStringMicro.copyFromUtf8(str4));
        PBRepeatField<ByteStringMicro> pBRepeatField4 = reportSvr$Record.fields;
        String str5 = this.scheduleId;
        if (str5 != null) {
            str = str5;
        }
        pBRepeatField4.add(ByteStringMicro.copyFromUtf8(str));
        return reportSvr$Record;
    }

    @NotNull
    public String toString() {
        return "PushReportData(action=" + this.action + ", time=" + this.time + ", uin=" + this.uin + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", appStatus=" + this.appStatus + ", pushType=" + this.pushType + ", senderTinyId=" + this.senderTinyId + ", channelType=" + this.channelType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.time);
        parcel.writeString(this.uin);
        parcel.writeString(this.guildId);
        parcel.writeString(this.channelId);
        parcel.writeInt(this.appStatus);
        parcel.writeInt(this.pushType);
        parcel.writeString(this.senderTinyId);
        parcel.writeInt(this.channelType);
        parcel.writeString(this.sgrpPushUrl);
        parcel.writeString(this.feedId);
        parcel.writeString(this.scheduleId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushReportData(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.time = parcel.readLong();
        this.uin = parcel.readString();
        this.guildId = parcel.readString();
        this.channelId = parcel.readString();
        this.appStatus = parcel.readInt();
        this.pushType = parcel.readInt();
        this.senderTinyId = parcel.readString();
        this.channelType = parcel.readInt();
        this.sgrpPushUrl = parcel.readString();
        this.feedId = parcel.readString();
        this.scheduleId = parcel.readString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushReportData(@NotNull MsgRecord msg2) {
        this();
        String currentUin;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.time = msg2.msgTime;
        AppRuntime app = getApp();
        this.uin = (app == null || (currentUin = app.getCurrentUin()) == null) ? "" : currentUin;
        this.guildId = msg2.guildId;
        this.channelId = msg2.channelId;
        this.pushType = c(msg2);
        String str = msg2.channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msg.channelId");
        this.channelType = b(str);
        this.senderTinyId = msg2.senderUid;
    }
}
