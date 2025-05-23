package com.tencent.guild.aio.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.holder.component.nick.MsgGProClientIdentityInfo;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildAudioChannelApi;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildAudioChannelData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProClientIdentityBytes;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentity;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProIdentityWithClientId;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentity;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProClientIdentityBytes;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00016B\t\b\u0002\u00a2\u0006\u0004\bJ\u0010KJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J0\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ8\u0010\"\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ!\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010&\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010*\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0006J\u0010\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-J\u0010\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u00105\u001a\u0002042\u0006\u00103\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00106\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u00108\u001a\u0004\u0018\u0001072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010;\u001a\u00020\u000f2\u0006\u0010:\u001a\u000209J\u0016\u0010<\u001a\u0002042\u0006\u0010:\u001a\u0002092\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010?\u001a\u0002042\u0006\u0010>\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010@\u001a\u0002042\u0006\u0010>\u001a\u00020=2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ2\u0010F\u001a\u0002042\b\u0010B\u001a\u0004\u0018\u00010A2\u0006\u0010C\u001a\u00020\u00062\u0018\b\u0002\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010DJ\u0010\u0010G\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010I\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010H\u00a8\u0006L"}, d2 = {"Lcom/tencent/guild/aio/util/h;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Landroid/content/Context;", "context", "", "u", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "t", "guildId", "roleId", ReportConstant.COSTREPORT_PREFIX, "", "roleType", "", "isRobot", "name", "display", "v", "p", "channelType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "c", "f", "g", "", "mask", tl.h.F, "channelId", "tinyId", "channelRoleId", "topRoleType", "i", "l", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;J)Ljava/lang/Integer;", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/guild/aio/util/h$a;", "d", "peerUin", "y", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProClientIdentityInfo;", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProClientIdentity;", "info", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProClientIdentityBytes;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/GuildLevelRoleView$b;", "e", "uiData", "", "E", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/FromRoleInfo;", "r", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "view", "id", "", "elementParams", BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, "Z", "canGetFromMsgSwitchOn", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f112401a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean canGetFromMsgSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_nick_info_from_msg_9015_119244771", false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/util/h$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "roleId", "b", "c", "name", "I", "()I", "color", "e", "type", "display", "<init>", "(Ljava/lang/String;Ljava/lang/String;III)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.util.h$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class MemberRoleInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String roleId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int color;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int display;

        public MemberRoleInfo(@NotNull String roleId, @NotNull String name, int i3, int i16, int i17) {
            Intrinsics.checkNotNullParameter(roleId, "roleId");
            Intrinsics.checkNotNullParameter(name, "name");
            this.roleId = roleId;
            this.name = name;
            this.color = i3;
            this.type = i16;
            this.display = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* renamed from: b, reason: from getter */
        public final int getDisplay() {
            return this.display;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getRoleId() {
            return this.roleId;
        }

        /* renamed from: e, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberRoleInfo)) {
                return false;
            }
            MemberRoleInfo memberRoleInfo = (MemberRoleInfo) other;
            if (Intrinsics.areEqual(this.roleId, memberRoleInfo.roleId) && Intrinsics.areEqual(this.name, memberRoleInfo.name) && this.color == memberRoleInfo.color && this.type == memberRoleInfo.type && this.display == memberRoleInfo.display) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.roleId.hashCode() * 31) + this.name.hashCode()) * 31) + this.color) * 31) + this.type) * 31) + this.display;
        }

        @NotNull
        public String toString() {
            return "MemberRoleInfo(roleId=" + this.roleId + ", name=" + this.name + ", color=" + this.color + ", type=" + this.type + ", display=" + this.display + ")";
        }
    }

    h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void D(h hVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        hVar.C(view, str, map);
    }

    public static /* synthetic */ int j(h hVar, GuildMsgItem guildMsgItem, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 4278190080L;
        }
        return hVar.h(guildMsgItem, j3);
    }

    public static /* synthetic */ int k(h hVar, String str, String str2, String str3, String str4, int i3, long j3, int i16, Object obj) {
        long j16;
        if ((i16 & 32) != 0) {
            j16 = 4278190080L;
        } else {
            j16 = j3;
        }
        return hVar.i(str, str2, str3, str4, i3, j16);
    }

    public static /* synthetic */ Integer m(h hVar, GuildMsgItem guildMsgItem, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 4278190080L;
        }
        return hVar.l(guildMsgItem, j3);
    }

    private final String p(GuildMsgItem msgItem) {
        String guildId = msgItem.getMsgRecord().guildId;
        IGuildDirectMsgUtilApi iGuildDirectMsgUtilApi = (IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class);
        String str = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.peerUid");
        long sourceGuildId = iGuildDirectMsgUtilApi.getSourceGuildId(str);
        if (sourceGuildId != 0) {
            guildId = String.valueOf(sourceGuildId);
        }
        String str2 = msgItem.getMsgRecord().senderUid.toString();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        return iq0.a.u(str2, guildId);
    }

    private final int q(int channelType) {
        if (channelType != 2) {
            if (channelType == 5) {
                return 2;
            }
            return 0;
        }
        return 1;
    }

    private final IGProGuildRoleInfo s(String guildId, String roleId) {
        IGPSService c16 = c();
        if (c16 != null) {
            return c16.getRoleInfo(guildId, roleId);
        }
        return null;
    }

    private final IGProGuildRoleInfo t(GuildMsgItem msgItem) {
        boolean z16;
        FromRoleInfo r16 = r(msgItem);
        if (r16 == null) {
            return null;
        }
        if (r16.roleId != 1 && !TextUtils.isEmpty(r16.name)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            r16 = null;
        }
        if (r16 == null) {
            return null;
        }
        h hVar = f112401a;
        String str = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
        return hVar.s(str, String.valueOf(r16.roleId));
    }

    private final String u(GuildMsgItem msgItem, Context context) {
        IGProGuildRoleInfo t16 = t(msgItem);
        if (t16 != null) {
            h hVar = f112401a;
            int roleType = t16.getRoleType();
            boolean w3 = hVar.w(msgItem.getMsgRecord());
            String displayTagName = t16.getDisplayTagName();
            Intrinsics.checkNotNullExpressionValue(displayTagName, "it.displayTagName");
            return hVar.v(roleType, w3, context, displayTagName, t16.getDisplayType());
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0012, code lost:
    
        if (r2 != 7) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String v(int roleType, boolean isRobot, Context context, String name, int display) {
        if (roleType != 0) {
            if (roleType != 2) {
                if (roleType != 4) {
                    if (roleType != 5) {
                        if (roleType == 6) {
                            String string = context.getString(R.string.f158281p7);
                            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_visitor_icon)");
                            return string;
                        }
                    }
                } else {
                    return name;
                }
            }
            if (isRobot) {
                name = context.getString(R.string.f138840_n);
            }
            Intrinsics.checkNotNullExpressionValue(name, "{\n                if (is\u2026          }\n            }");
            return name;
        }
        if (display == 1) {
            return name;
        }
        return "";
    }

    public final void A(@NotNull MsgRecord msgRecord, @NotNull Context context) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(context, "context");
        GuildProfileData ofTextTypeData = GuildProfileData.ofTextTypeData(msgRecord.guildId, msgRecord.peerUid, msgRecord.senderUid, 2);
        if (msgRecord.fromAppid == GuildMsgItem.ROBOT_MSG_FLAG) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ofTextTypeData.getGuildBaseProfileData().y(true);
            ofTextTypeData.getGuildBaseProfileData().r(msgRecord.peerUid);
        }
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog((Activity) context, ofTextTypeData);
    }

    public final void B(@NotNull Activity activity, @NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String str = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
        String str2 = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
        String str3 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
        z(activity, str, str2, str3, x(msgItem));
    }

    public final void C(@Nullable View view, @NotNull String id5, @Nullable Map<String, ? extends Object> elementParams) {
        Intrinsics.checkNotNullParameter(id5, "id");
        HashMap hashMap = new HashMap();
        if (elementParams != null) {
            hashMap.putAll(elementParams);
        }
        hashMap.put("dt_pgid", "pg_sgrp_avchannel_aio");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(view, id5, hashMap);
    }

    public final void E(@NotNull GuildLevelRoleView.UIData uiData, @NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        up0.a.f439407a.b("TAG_LEVEL_MEMBER_ROLE_CACHE", msgItem.getMsgRecord().guildId + msgItem.getMsgRecord().senderUid + msgItem.getMsgRecord().levelRoleInfo.roleId, uiData);
    }

    @NotNull
    public final GProClientIdentityBytes F(@NotNull IGProClientIdentity info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IGProClientIdentityBytes identityBytes = info.getIdentityBytes();
        GProClientIdentityBytes gProClientIdentityBytes = new GProClientIdentityBytes();
        gProClientIdentityBytes.clientId = identityBytes.getClientId();
        ArrayList<GProIdentity> arrayList = new ArrayList<>();
        identityBytes.getIdentitys();
        ArrayList<IGProIdentity> identitys = identityBytes.getIdentitys();
        Intrinsics.checkNotNullExpressionValue(identitys, "identityBytes.identitys");
        for (IGProIdentity iGProIdentity : identitys) {
            arrayList.add(new GProIdentity(iGProIdentity.getType(), iGProIdentity.getValue(), iGProIdentity.getIdentityType(), iGProIdentity.getThirdPartyData()));
        }
        gProClientIdentityBytes.identitys = arrayList;
        ArrayList<GProIdentityWithClientId> arrayList2 = new ArrayList<>();
        ArrayList<IGProIdentityWithClientId> defaultIdentitys = identityBytes.getDefaultIdentitys();
        Intrinsics.checkNotNullExpressionValue(defaultIdentitys, "identityBytes.defaultIdentitys");
        for (IGProIdentityWithClientId iGProIdentityWithClientId : defaultIdentitys) {
            GProIdentityWithClientId gProIdentityWithClientId = new GProIdentityWithClientId();
            gProIdentityWithClientId.clientId = iGProIdentityWithClientId.getClientId();
            gProIdentityWithClientId.identitys = new GProIdentity(iGProIdentityWithClientId.getIdentitys().getType(), iGProIdentityWithClientId.getIdentitys().getValue(), iGProIdentityWithClientId.getIdentitys().getIdentityType(), iGProIdentityWithClientId.getIdentitys().getThirdPartyData());
            arrayList2.add(gProIdentityWithClientId);
        }
        gProClientIdentityBytes.defaultIdentitys = arrayList2;
        return gProClientIdentityBytes;
    }

    public final boolean a(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (canGetFromMsgSwitchOn && !msgItem.isSelf() && NetConnInfoCenter.getServerTime() - msgItem.getMsgRecord().msgTime < 30) {
            return true;
        }
        return false;
    }

    @Nullable
    public final IGProClientIdentityInfo b(@NotNull GuildMsgItem msgItem) {
        IGProGuildInfo iGProGuildInfo;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String str = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
        String str2 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.senderUid");
        IGProClientIdentityInfo iGProClientIdentityInfo = null;
        if (TextUtils.isEmpty(str)) {
            QLog.w("GuildGameNickItem", 1, "guildId is null!");
            return null;
        }
        IGPSService c16 = c();
        if (c16 != null) {
            iGProGuildInfo = c16.getGuildInfo(str);
        } else {
            iGProGuildInfo = null;
        }
        if (iGProGuildInfo == null) {
            QLog.w("GuildGameNickItem", 1, "guildInfo is null! guildId=" + str);
            return null;
        }
        IGPSService c17 = c();
        if (c17 != null) {
            iGProClientIdentityInfo = c17.getGuildMemberClientIdentity(str, iGProGuildInfo.getClientId(), str2);
        }
        if (iGProClientIdentityInfo == null) {
            QLog.w("GuildGameNickItem", 1, "Fail to get clientIdentity from gpro! guildId=" + str + "\uff0c msgSeq: " + msgItem.getMsgSeq() + ", tid: " + str2 + ", get from msg.");
            GuildClientIdentity guildClientIdentity = msgItem.getMsgRecord().clientIdentityInfo;
            if (guildClientIdentity != null) {
                return new MsgGProClientIdentityInfo(com.tencent.guild.aio.msglist.holder.component.nick.p.a(guildClientIdentity));
            }
            return iGProClientIdentityInfo;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildGameNickItem", 2, "Got clientIdentity from gpro. guildId=" + str + "\uff0c msgSeq: " + msgItem.getMsgSeq() + ", tid: " + str2);
            return iGProClientIdentityInfo;
        }
        return iGProClientIdentityInfo;
    }

    @Nullable
    public final IGPSService c() {
        AppInterface appInterface;
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
        return (IGPSService) iRuntimeService;
    }

    @Nullable
    public final MemberRoleInfo d(@NotNull GuildMsgItem msgItem) {
        IGProGuildRoleInfo memberTopRole;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        up0.a aVar = up0.a.f439407a;
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        String str2 = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
        Object e16 = aVar.e("TAG_MEMBER_ROLE_CACHE", y(str, str2));
        if (e16 != null && (e16 instanceof MemberRoleInfo)) {
            return (MemberRoleInfo) e16;
        }
        IGPSService c16 = c();
        if (c16 != null && (memberTopRole = c16.getMemberTopRole(msgItem.getMsgRecord().guildId, msgItem.getMsgRecord().channelId, msgItem.getMsgRecord().senderUid, String.valueOf(msgItem.getMsgRecord().fromChannelRoleInfo.roleId), msgItem.getMsgRecord().roleType)) != null) {
            String roleId = memberTopRole.getRoleId();
            Intrinsics.checkNotNullExpressionValue(roleId, "role.roleId");
            String displayTagName = memberTopRole.getDisplayTagName();
            Intrinsics.checkNotNullExpressionValue(displayTagName, "role.displayTagName");
            MemberRoleInfo memberRoleInfo = new MemberRoleInfo(roleId, displayTagName, memberTopRole.getColor(), memberTopRole.getRoleType(), memberTopRole.getDisplayType());
            if (memberTopRole.isLevelRole()) {
                QLog.i("GuildMsgListUtils", 1, "[getMemberTopRole] from profile. msgSeq: " + msgItem.getMsgRecord().msgSeq + ", sender: " + msgItem.getMsgRecord().senderUid + ", isLevelRole = true, use default values.");
                memberRoleInfo = new MemberRoleInfo("1", "", -1, 0, 0);
            }
            h hVar = f112401a;
            String str3 = msgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
            String str4 = msgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str4, "msgItem.msgRecord.peerUid");
            aVar.b("TAG_MEMBER_ROLE_CACHE", hVar.y(str3, str4), memberRoleInfo);
            QLog.i("GuildMsgListUtils", 1, "[getMemberTopRole] from profile. msgSeq: " + msgItem.getMsgRecord().msgSeq + ", sender: " + msgItem.getMsgRecord().senderUid + ", msgRoleType: " + msgItem.getMsgRecord().roleType + ", roleId: " + memberTopRole.getRoleId() + ", color: " + memberTopRole.getColor() + ", name: " + memberTopRole.getName() + ", roleType: " + memberTopRole.getRoleType());
            return memberRoleInfo;
        }
        return null;
    }

    @Nullable
    public final GuildLevelRoleView.UIData e(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Object e16 = up0.a.f439407a.e("TAG_LEVEL_MEMBER_ROLE_CACHE", msgItem.getMsgRecord().guildId + msgItem.getMsgRecord().senderUid + msgItem.getMsgRecord().levelRoleInfo.roleId);
        if (e16 != null && (e16 instanceof GuildLevelRoleView.UIData)) {
            return (GuildLevelRoleView.UIData) e16;
        }
        return null;
    }

    @NotNull
    public final String f(@NotNull GuildMsgItem msgItem, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(context, "context");
        String u16 = u(msgItem, context);
        if (u16 == null) {
            u16 = "";
        }
        if (a(msgItem) && !TextUtils.isEmpty(u16)) {
            QLog.i("GuildRoleNickItem", 1, "getNameplateIconText: canGetFromMsg. msgSeq: " + msgItem.getMsgRecord().msgSeq + ", sender: " + msgItem.getMsgRecord().senderUid + ", roleTypeFromMsg: " + u16);
            return u16;
        }
        MemberRoleInfo d16 = d(msgItem);
        if (d16 != null) {
            h hVar = f112401a;
            return hVar.v(d16.getType(), hVar.w(msgItem.getMsgRecord()), context, d16.getName(), d16.getDisplay());
        }
        QLog.i("GuildRoleNickItem", 1, "getMemberTopRole: fail to get from profile. getRoleFromMsg. msgSeq: " + msgItem.getMsgRecord().msgSeq + ", sender: " + msgItem.getMsgRecord().senderUid + ", roleTypeFromMsg: " + u16);
        return u16;
    }

    @Nullable
    public final String g(@NotNull GuildMsgItem msgItem, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(context, "context");
        String u16 = u(msgItem, context);
        if (u16 == null) {
            u16 = "";
        }
        if (a(msgItem) && !TextUtils.isEmpty(u16)) {
            QLog.i("GuildRoleNickItem", 1, "getNameplateIconTextForPreParse: canGetFromMsg. msgSeq: " + msgItem.getMsgRecord().msgSeq + ", sender: " + msgItem.getMsgRecord().senderUid + ", roleTypeFromMsg: " + u16);
            return u16;
        }
        MemberRoleInfo d16 = d(msgItem);
        if (d16 != null) {
            h hVar = f112401a;
            return hVar.v(d16.getType(), hVar.w(msgItem.getMsgRecord()), context, d16.getName(), d16.getDisplay());
        }
        return null;
    }

    public final int h(@NotNull GuildMsgItem msgItem, long mask) {
        int i3;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IGProGuildRoleInfo t16 = t(msgItem);
        if (t16 != null) {
            i3 = (int) (t16.getColor() | mask);
            h hVar = f112401a;
            if (hVar.a(msgItem) && !TextUtils.isEmpty(t16.getName())) {
                if (QLog.isColorLevel()) {
                    QLog.i("GuildMsgListUtils", 2, "getNickColor: getRoleFromMsg. msgSeq: " + msgItem.getMsgRecord().msgSeq + ", sender: " + msgItem.getMsgRecord().senderUid + ", roleId: " + t16.getRoleId() + ", color: " + t16.getColor() + ", name: " + t16.getName());
                }
                up0.a aVar = up0.a.f439407a;
                String str = msgItem.getMsgRecord().senderUid;
                Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
                String str2 = msgItem.getMsgRecord().peerUid;
                Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
                aVar.b("TAG_MEMBER_ROLE_COLOR_CACHE", hVar.y(str, str2), Integer.valueOf(i3));
                return i3;
            }
        } else {
            i3 = -1;
        }
        MemberRoleInfo d16 = d(msgItem);
        if (d16 != null) {
            if (Intrinsics.areEqual(d16.getRoleId(), "1")) {
                return -1;
            }
            int color = (int) (mask | d16.getColor());
            up0.a aVar2 = up0.a.f439407a;
            h hVar2 = f112401a;
            String str3 = msgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
            String str4 = msgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str4, "msgItem.msgRecord.peerUid");
            aVar2.b("TAG_MEMBER_ROLE_COLOR_CACHE", hVar2.y(str3, str4), Integer.valueOf(color));
            return color;
        }
        up0.a aVar3 = up0.a.f439407a;
        String str5 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str5, "msgItem.msgRecord.senderUid");
        String str6 = msgItem.getMsgRecord().peerUid;
        Intrinsics.checkNotNullExpressionValue(str6, "msgItem.msgRecord.peerUid");
        aVar3.b("TAG_MEMBER_ROLE_COLOR_CACHE", y(str5, str6), Integer.valueOf(i3));
        return i3;
    }

    public final int i(@NotNull String guildId, @NotNull String channelId, @NotNull String tinyId, @NotNull String channelRoleId, int topRoleType, long mask) {
        IGProGuildRoleInfo memberTopRole;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(channelRoleId, "channelRoleId");
        up0.a aVar = up0.a.f439407a;
        Object e16 = aVar.e("TAG_MEMBER_ROLE_COLOR_CACHE", y(tinyId, channelId));
        if (e16 != null) {
            return ((Integer) e16).intValue();
        }
        IGPSService c16 = c();
        if (c16 == null || (memberTopRole = c16.getMemberTopRole(guildId, channelId, tinyId, channelRoleId, topRoleType)) == null) {
            return -1;
        }
        Intrinsics.checkNotNullExpressionValue(memberTopRole, "getMemberTopRole(guildId\u2026annelRoleId, topRoleType)");
        if (Intrinsics.areEqual(memberTopRole.getRoleId(), "1")) {
            return -1;
        }
        int color = (int) (memberTopRole.getColor() | mask);
        aVar.b("TAG_MEMBER_ROLE_COLOR_CACHE", y(tinyId, channelId), Integer.valueOf(color));
        return color;
    }

    @Nullable
    public final Integer l(@NotNull GuildMsgItem msgItem, long mask) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IGProGuildRoleInfo t16 = t(msgItem);
        if (t16 != null) {
            int color = (int) (t16.getColor() | mask);
            h hVar = f112401a;
            if (hVar.a(msgItem) && !TextUtils.isEmpty(t16.getName())) {
                if (QLog.isColorLevel()) {
                    QLog.i("GuildMsgListUtils", 2, "getNickColor: getRoleFromMsg. msgSeq: " + msgItem.getMsgRecord().msgSeq + ", sender: " + msgItem.getMsgRecord().senderUid + ", roleId: " + t16.getRoleId() + ", color: " + t16.getColor() + ", name: " + t16.getName());
                }
                up0.a aVar = up0.a.f439407a;
                String str = msgItem.getMsgRecord().senderUid;
                Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
                String str2 = msgItem.getMsgRecord().peerUid;
                Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.peerUid");
                aVar.b("TAG_MEMBER_ROLE_COLOR_CACHE", hVar.y(str, str2), Integer.valueOf(color));
                return Integer.valueOf(color);
            }
        }
        MemberRoleInfo d16 = d(msgItem);
        if (d16 != null) {
            if (Intrinsics.areEqual(d16.getRoleId(), "1")) {
                return -1;
            }
            int color2 = (int) (mask | d16.getColor());
            up0.a aVar2 = up0.a.f439407a;
            h hVar2 = f112401a;
            String str3 = msgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
            String str4 = msgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str4, "msgItem.msgRecord.peerUid");
            aVar2.b("TAG_MEMBER_ROLE_COLOR_CACHE", hVar2.y(str3, str4), Integer.valueOf(color2));
            return Integer.valueOf(color2);
        }
        return null;
    }

    @NotNull
    public final String n(@NotNull GuildMsgItem msgItem, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(context, "context");
        String nickFromMsg = msgItem.getMsgRecord().sendMemberName;
        if (a(msgItem) && !TextUtils.isEmpty(nickFromMsg)) {
            QLog.i("GuildNickItem", 1, "getNickName from msg, msgSeq: " + msgItem.getMsgRecord().msgSeq + ", tid: " + msgItem.getMsgRecord().senderUid);
            Intrinsics.checkNotNullExpressionValue(nickFromMsg, "nickFromMsg");
            return nickFromMsg;
        }
        String p16 = p(msgItem);
        if (!TextUtils.isEmpty(p16) && !TextUtils.equals(p16, context.getString(R.string.f143010kx))) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildNickItem", 2, "getNickName from profile, msgSeq: " + msgItem.getMsgRecord().msgSeq + ", tid: " + msgItem.getMsgRecord().senderUid);
            }
            return p16;
        }
        QLog.i("GuildNickItem", 1, "getNickName from Profile: EMPTY! Use nick from msg, msgSeq: " + msgItem.getMsgRecord().msgSeq + ", tid: " + msgItem.getMsgRecord().senderUid);
        if (!TextUtils.isEmpty(nickFromMsg)) {
            Intrinsics.checkNotNullExpressionValue(nickFromMsg, "{\n                nickFromMsg\n            }");
            return nickFromMsg;
        }
        if (!TextUtils.isEmpty(msgItem.getMsgRecord().sendNickName)) {
            String str = msgItem.getMsgRecord().sendNickName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n                msgIte\u2026endNickName\n            }");
            return str;
        }
        String string = context.getString(R.string.f143010kx);
        Intrinsics.checkNotNullExpressionValue(string, "{\n                contex\u2026fault_nick)\n            }");
        return string;
    }

    @Nullable
    public final String o(@NotNull GuildMsgItem msgItem, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(context, "context");
        String str = msgItem.getMsgRecord().sendMemberName;
        if (a(msgItem) && !TextUtils.isEmpty(str)) {
            QLog.i("GuildNickItem", 1, "getNickName from msg, msgSeq: " + msgItem.getMsgRecord().msgSeq + ", tid: " + msgItem.getMsgRecord().senderUid);
            return str;
        }
        String p16 = p(msgItem);
        if (!TextUtils.isEmpty(p16) && !TextUtils.equals(p16, context.getString(R.string.f143010kx))) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildNickItem", 2, "getNickName from profile, msgSeq: " + msgItem.getMsgRecord().msgSeq + ", tid: " + msgItem.getMsgRecord().senderUid);
            }
            return p16;
        }
        return null;
    }

    @Nullable
    public final FromRoleInfo r(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().roleType == 1) {
            return msgItem.getMsgRecord().fromChannelRoleInfo;
        }
        return msgItem.getMsgRecord().fromGuildRoleInfo;
    }

    public final boolean w(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (msgRecord.fromAppid == GuildMsgItem.ROBOT_MSG_FLAG) {
            return true;
        }
        return false;
    }

    public final boolean x(@Nullable GuildMsgItem msgItem) {
        MsgRecord msgRecord;
        if (msgItem == null || (msgRecord = msgItem.getMsgRecord()) == null || msgRecord.fromAppid != GuildMsgItem.ROBOT_MSG_FLAG) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String y(@NotNull String tinyId, @NotNull String peerUin) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        return tinyId + "_" + peerUin;
    }

    public final void z(@NotNull Activity activity, @NotNull String guildId, @NotNull String channelId, @NotNull String tinyId, boolean isRobot) {
        String str;
        String str2;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        h hVar;
        int i3;
        boolean z16;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        JumpGuildParam.JoinInfoParam joinInfoParam2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Bundle mediaChannelLoadBeanBundle = ((IGuildAudioChannelApi) QRoute.api(IGuildAudioChannelApi.class)).getMediaChannelLoadBeanBundle();
        IGProChannelInfo iGProChannelInfo = null;
        if (mediaChannelLoadBeanBundle != null && (joinInfoParam2 = (JumpGuildParam.JoinInfoParam) mediaChannelLoadBeanBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
            str = joinInfoParam2.getMainSource();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (mediaChannelLoadBeanBundle != null && (joinInfoParam = (JumpGuildParam.JoinInfoParam) mediaChannelLoadBeanBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
            str2 = joinInfoParam.getSubSource();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int sceneTypeBySource = GuildProfileData.getSceneTypeBySource(str, str2, 3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGProChannelInfo = iGPSService.getChannelInfo(channelId);
        }
        IGProChannelInfo iGProChannelInfo2 = iGProChannelInfo;
        if (iGProChannelInfo2 != null) {
            i3 = iGProChannelInfo2.getType();
            hVar = this;
        } else {
            hVar = this;
            i3 = 0;
        }
        GuildProfileData guildProfileData = new GuildProfileData(guildId, channelId, tinyId, hVar.q(i3), sceneTypeBySource);
        if (iGProChannelInfo2 != null && iGProChannelInfo2.getType() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.guild.data.u mediaChannelUserInfo = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getMediaChannelUserInfo(tinyId);
            if (mediaChannelUserInfo != null) {
                com.tencent.mobileqq.guild.data.u mediaChannelSelfUserInfo = ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getMediaChannelSelfUserInfo();
                guildProfileData.getExtras().putParcelable(GuildProfileData.KEY_CHANNEL_DATA, new GuildAudioChannelData(channelId, 2, mediaChannelSelfUserInfo.f216477a, mediaChannelSelfUserInfo.f216478b, mediaChannelUserInfo.f216477a, mediaChannelUserInfo.f216478b, mediaChannelUserInfo.f216479c, mediaChannelUserInfo.f216480d, mediaChannelUserInfo.f216481e));
            } else {
                guildProfileData.getGuildBaseProfileData().A(0);
            }
        }
        guildProfileData.getGuildBaseProfileData().r(channelId);
        guildProfileData.getGuildBaseProfileData().y(isRobot);
        ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildProfileDialog(activity, guildProfileData);
    }
}
