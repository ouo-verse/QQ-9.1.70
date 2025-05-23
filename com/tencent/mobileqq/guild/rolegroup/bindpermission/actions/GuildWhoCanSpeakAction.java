package com.tencent.mobileqq.guild.rolegroup.bindpermission.actions;

import com.tencent.mobileqq.guild.rolegroup.model.repositories.ChannelPermissionTarget;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.ChannelPermissionType;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.ek;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cd;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\r\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J4\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0011H\u0016J\"\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\u0015H\u0016R\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/GuildWhoCanSpeakAction;", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/z;", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/PermissionSwitchStatus;", "o", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "a", "type", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/w;", "callback", "", "c", "", "", "addRoles", "removeRoles", "b", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/x;", "d", "", "cookieCache", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/actions/y;", "e", "Ljava/lang/String;", "guildId", "channelId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildWhoCanSpeakAction implements z {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    public GuildWhoCanSpeakAction(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.guildId = guildId;
        this.channelId = channelId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(w callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        e eVar = e.f232387a;
        ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
        Intrinsics.checkNotNullExpressionValue(e16, "of(result, errMsg, security)");
        eVar.a(e16, "speak in guild", callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(w callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        e eVar = e.f232387a;
        ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
        Intrinsics.checkNotNullExpressionValue(e16, "of(result, errMsg, security)");
        eVar.a(e16, "speak in channel", callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(x callback, ri1.a error, List list) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(error, "error");
        e.f232387a.b(error, list, "speak", callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final GuildWhoCanSpeakAction this$0, final y callback, final IGPSService service, int i3, String str, int i16, boolean z16, final byte[] bArr, List memberList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        e eVar = e.f232387a;
        ri1.a e16 = ri1.a.e(i3, str, null);
        Intrinsics.checkNotNullExpressionValue(e16, "of(result, errMsg, null)");
        eVar.c(e16, f.a(memberList, this$0.guildId), i16, z16, "speak", callback, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.GuildWhoCanSpeakAction$fetchHasPermissionUsers$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                GuildWhoCanSpeakAction.this.e(service, bArr, callback);
            }
        });
    }

    private final PermissionSwitchStatus o() {
        PermissionSwitchStatus permissionSwitchStatus;
        IGProGuildInfo L = ch.L(this.guildId);
        if (L == null) {
            return PermissionSwitchStatus.TYPE_ALL;
        }
        PermissionSwitchStatus permissionSwitchStatus2 = PermissionSwitchStatus.TYPE_ALL;
        Iterator<GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry> it = L.getGuildGlobalAuthInfo().authControlSwitchInfoList.iterator();
        while (it.hasNext()) {
            GProGuildGlobalAuthInfoAuthControlSwitchInfoEntry next = it.next();
            if (next.key == 2) {
                if (next.value.getGlobalAuthScopeType() == 1) {
                    permissionSwitchStatus = PermissionSwitchStatus.TYPE_PART;
                } else {
                    permissionSwitchStatus = PermissionSwitchStatus.TYPE_ALL;
                }
                return permissionSwitchStatus;
            }
        }
        return permissionSwitchStatus2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(w callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        e eVar = e.f232387a;
        ri1.a e16 = ri1.a.e(i3, str, iGProSecurityResult);
        Intrinsics.checkNotNullExpressionValue(e16, "of(result, errMsg, security)");
        eVar.a(e16, "speak", callback);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    @NotNull
    public PermissionSwitchStatus a(@NotNull IGPSService service) {
        boolean z16;
        Intrinsics.checkNotNullParameter(service, "service");
        if (this.channelId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return o();
        }
        IGProChannelInfo channelInfo = service.getChannelInfo(this.channelId);
        if (channelInfo != null) {
            return aa.b(channelInfo.getTalkPermission());
        }
        return PermissionSwitchStatus.TYPE_ALL;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    public void b(@NotNull IGPSService service, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull final w callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(addRoles, "addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
        Intrinsics.checkNotNullParameter(callback, "callback");
        service.setChannelSpeakableRoleList(this.guildId, this.channelId, addRoles, removeRoles, new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.r
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                GuildWhoCanSpeakAction.p(w.this, i3, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    public void c(@NotNull IGPSService service, @NotNull PermissionSwitchStatus type, @NotNull final w callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i3 = 1;
        if (this.channelId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ek ekVar = new ek();
            ekVar.e(StringUtils.toLong(this.guildId));
            ekVar.d(2);
            if (type != PermissionSwitchStatus.TYPE_PART) {
                i3 = 0;
            }
            ekVar.f(i3);
            service.setGuildGlobalPermission(ekVar, new dv() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.t
                @Override // wh2.dv
                public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                    GuildWhoCanSpeakAction.k(w.this, i16, str, iGProSecurityResult);
                }
            });
            return;
        }
        service.setChannelSpeakable(this.guildId, this.channelId, aa.e(type), new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.u
            @Override // vh2.cd
            public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult) {
                GuildWhoCanSpeakAction.l(w.this, i16, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    public void d(@NotNull IGPSService service, @NotNull final x callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.guild.rolegroup.model.repositories.s.a().c(new ChannelPermissionTarget(this.guildId, this.channelId, ChannelPermissionType.SpeakPermission), new com.tencent.mobileqq.guild.base.repository.h() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.s
            @Override // com.tencent.mobileqq.guild.base.repository.h
            public final void a(ri1.a aVar, Object obj) {
                GuildWhoCanSpeakAction.m(x.this, aVar, (List) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.z
    public void e(@NotNull final IGPSService service, @Nullable byte[] cookieCache, @NotNull final y callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = this.guildId;
        String str2 = this.channelId;
        if (cookieCache == null) {
            cookieCache = new byte[0];
        }
        service.getChannelSpeakableMemberList(str, str2, 100, cookieCache, new xh2.h() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.actions.v
            @Override // xh2.h
            public final void a(int i3, String str3, int i16, boolean z16, byte[] bArr, List list) {
                GuildWhoCanSpeakAction.n(GuildWhoCanSpeakAction.this, callback, service, i3, str3, i16, z16, bArr, list);
            }
        });
    }
}
