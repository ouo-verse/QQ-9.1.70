package com.tencent.mobileqq.guild.rolegroup.model.repositories;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.base.repository.ResultDispatcher;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildTarget;
import com.tencent.mobileqq.guild.rolegroup.model.data.Permissions;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupListModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GProRolePermission;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.fn;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.ak;
import vh2.bx;
import vh2.cc;
import vh2.cd;
import wh2.ah;
import wh2.aj;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007\u00a2\u0006\u0004\bI\u0010JJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J&\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J.\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J,\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016JB\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J,\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\r2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u0005H\u0016J,\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u0005H\u0016J$\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u0005H\u0016JJ\u0010+\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010&\u001a\u00020#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00152\u0006\u0010!\u001a\u00020 2\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150)J:\u0010,\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J:\u00100\u001a\u00020\b2\u0006\u0010!\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J\u0010\u00102\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u00104\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00103\u001a\u00020\rH\u0016J\u0018\u00106\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00105\u001a\u00020\rH\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020\rH\u0016J&\u0010:\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00109\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J:\u0010;\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016J\b\u0010<\u001a\u00020\bH\u0002R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010AR\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/q;", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/IRoleGroupListRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/c;", "fetchParam", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/g;", "callback", "", tl.h.F, "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "g", "e", "", "guildId", "roleGroup", "", "i", "roleGroupId", "o", "a", "", "roleGroupIds", "j", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/d;", "guildTarget", "tinyId", "addRoles", "removeRoles", "l", DomainData.DOMAIN_NAME, "f", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/a;", "target", "c", "", "code", "errMsg", "totalRoleNum", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleList", "Lcom/tencent/mobileqq/guild/base/repository/ResultDispatcher;", "dispatcher", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "b", "Lcom/tencent/mobileqq/guild/rolegroup/model/repositories/b;", "addChannels", "removeChannels", "d", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/c;", "getGuildPermission", "channelId", "getChannelPermission", "categoryId", "getCategoryPermission", "account", "onAccountChanged", "whiteList", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "K", "Luh2/f;", "Luh2/f;", "roleService", "Luh2/d;", "Luh2/d;", "permissionService", "Luh2/b;", "Luh2/b;", "genService", "Lcom/tencent/mobileqq/guild/base/repository/g;", "Lcom/tencent/mobileqq/guild/base/repository/g;", "inlineDispatcher", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q implements IRoleGroupListRepository, com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private uh2.f roleService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private uh2.d permissionService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private uh2.b genService;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.base.repository.g inlineDispatcher;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232784a;

        static {
            int[] iArr = new int[ChannelPermissionType.values().length];
            try {
                iArr[ChannelPermissionType.ViewPermission.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChannelPermissionType.SpeakPermission.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChannelPermissionType.LivePermission.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChannelPermissionType.ActivityPermission.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ChannelPermissionType.ModifyMapPermission.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f232784a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J0\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0016J0\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/model/repositories/q$c", "Lwh2/aj;", "Lxh2/i;", "Lxh2/g;", "Lwh2/ah;", "", "code", "", "errMsg", "total", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildRoleInfo;", "roleList", "", "a", "totalRoleNum", "Ljava/util/ArrayList;", "onFetchChannelAbleRoleList", "result", "onFetchChannelVisibleRoleList", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements aj, xh2.i, xh2.g, ah {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChannelPermissionTarget f232786b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ResultDispatcher<List<RoleGroupModel>> f232787c;

        c(ChannelPermissionTarget channelPermissionTarget, ResultDispatcher<List<RoleGroupModel>> resultDispatcher) {
            this.f232786b = channelPermissionTarget;
            this.f232787c = resultDispatcher;
        }

        @Override // xh2.i, xh2.g
        public void a(int code, @Nullable String errMsg, int total, @NotNull List<IGProGuildRoleInfo> roleList) {
            Intrinsics.checkNotNullParameter(roleList, "roleList");
            q.this.A(code, errMsg, total, roleList, this.f232786b, this.f232787c);
        }

        @Override // wh2.ah
        public void onFetchChannelAbleRoleList(int code, @Nullable String errMsg, int totalRoleNum, @NotNull ArrayList<IGProGuildRoleInfo> roleList) {
            Intrinsics.checkNotNullParameter(roleList, "roleList");
            q.this.A(code, errMsg, totalRoleNum, roleList, this.f232786b, this.f232787c);
        }

        @Override // wh2.aj
        public void onFetchChannelVisibleRoleList(int result, @Nullable String errMsg, int totalRoleNum, @NotNull ArrayList<IGProGuildRoleInfo> roleList) {
            Intrinsics.checkNotNullParameter(roleList, "roleList");
            q.this.A(result, errMsg, totalRoleNum, roleList, this.f232786b, this.f232787c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/model/repositories/q$d", "Lvh2/cc;", "", "code", "", "errMsg", "", "onResult", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements cc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultDispatcher<Boolean> f232788a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChannelPermissionTargetForRole f232789b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f232790c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f232791d;

        d(ResultDispatcher<Boolean> resultDispatcher, ChannelPermissionTargetForRole channelPermissionTargetForRole, List<String> list, List<String> list2) {
            this.f232788a = resultDispatcher;
            this.f232789b = channelPermissionTargetForRole;
            this.f232790c = list;
            this.f232791d = list2;
        }

        @Override // vh2.cc
        public void onResult(int code, @Nullable String errMsg) {
            ri1.a result = ri1.a.e(code, errMsg, null);
            if (!result.d()) {
                Logger logger = Logger.f235387a;
                ChannelPermissionTargetForRole channelPermissionTargetForRole = this.f232789b;
                List<String> list = this.f232790c;
                List<String> list2 = this.f232791d;
                Logger.b bVar = new Logger.b();
                String str = "modifyChannelPermissionForRoleGroup result:" + code + " errMsg:" + errMsg + " " + channelPermissionTargetForRole + " addChannels:" + list + " removeChannels:" + list2;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
                }
                ResultDispatcher<Boolean> resultDispatcher = this.f232788a;
                Intrinsics.checkNotNullExpressionValue(result, "result");
                resultDispatcher.b(result);
                return;
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.rg.RealRoleGroupListRepository", 2, "modifyChannelPermissionForRoleGroup result:" + code + " errMsg:" + errMsg);
            }
            this.f232788a.c(Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/model/repositories/q$e", "Lvh2/cd;", "Lwh2/dv;", "", "code", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements cd, dv {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultDispatcher<Boolean> f232792a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChannelPermissionTarget f232793b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<String> f232794c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f232795d;

        e(ResultDispatcher<Boolean> resultDispatcher, ChannelPermissionTarget channelPermissionTarget, List<String> list, List<String> list2) {
            this.f232792a = resultDispatcher;
            this.f232793b = channelPermissionTarget;
            this.f232794c = list;
            this.f232795d = list2;
        }

        @Override // vh2.cd
        public void a(int code, @NotNull String errMsg, @Nullable IGProSecurityResult security) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ri1.a result = ri1.a.e(code, errMsg, security);
            if (!result.d()) {
                Logger logger = Logger.f235387a;
                ChannelPermissionTarget channelPermissionTarget = this.f232793b;
                List<String> list = this.f232794c;
                List<String> list2 = this.f232795d;
                Logger.b bVar = new Logger.b();
                String str = "modifyRoleGroupForChannelPermission result:" + code + " errMsg:" + errMsg + " " + channelPermissionTarget + " addRoles:" + list + " removeRoles:" + list2;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
                }
                ResultDispatcher<Boolean> resultDispatcher = this.f232792a;
                Intrinsics.checkNotNullExpressionValue(result, "result");
                resultDispatcher.b(result);
                return;
            }
            Logger logger2 = Logger.f235387a;
            ChannelPermissionTarget channelPermissionTarget2 = this.f232793b;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.rg.RealRoleGroupListRepository", 2, "modifyRoleGroupForChannelPermission result:" + code + " errMsg:" + errMsg + " " + channelPermissionTarget2);
            }
            this.f232792a.c(Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/model/repositories/q$f", "Lvh2/cd;", "", "code", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements cd {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultDispatcher<Boolean> f232796a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f232797b;

        f(ResultDispatcher<Boolean> resultDispatcher, String str) {
            this.f232796a = resultDispatcher;
            this.f232797b = str;
        }

        @Override // vh2.cd
        public void a(int code, @Nullable String errMsg, @Nullable IGProSecurityResult security) {
            ri1.a result = ri1.a.e(code, errMsg, security);
            if (!result.d()) {
                Logger logger = Logger.f235387a;
                String str = this.f232797b;
                Logger.b bVar = new Logger.b();
                String str2 = "updateRoleGroup fail code=" + code + " msg=" + errMsg + " sec=" + security + " guildId=" + str;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
                }
                ResultDispatcher<Boolean> resultDispatcher = this.f232796a;
                Intrinsics.checkNotNullExpressionValue(result, "result");
                resultDispatcher.b(result);
                return;
            }
            this.f232796a.c(Boolean.TRUE);
        }
    }

    public q() {
        AccountChangedNotifier.f214789d.a(this);
        K();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.RealRoleGroupListRepository", 2, "register observer");
        }
        this.inlineDispatcher = new com.tencent.mobileqq.guild.base.repository.g("Guild.rg.RealRoleGroupListRepository", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ResultDispatcher this_networkGuard, String guildId, String roleGroupId, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this_networkGuard, "$this_networkGuard");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(roleGroupId, "$roleGroupId");
        ri1.a result = ri1.a.e(i3, str, iGProSecurityResult);
        if (!result.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "deleteRole fail code=" + i3 + " msg=" + str + " sec=" + iGProSecurityResult + " guildId=" + guildId + " roleId=" + roleGroupId;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            this_networkGuard.b(result);
            return;
        }
        this_networkGuard.c(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(com.tencent.mobileqq.guild.base.repository.h callback, String guildId, boolean z16, int i3, String str, int i16, List list) {
        int collectionSizeOrDefault;
        List emptyList;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        ri1.a result = ri1.a.e(i3, str, null);
        boolean z17 = true;
        if (!result.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchGuildSpeakableRoles fail code=" + i3 + " msg=" + str + " guildId=" + guildId + " whiteList=" + z16;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callback.a(result, new RoleGroupListModel(guildId, emptyList, null, 4, null));
            return;
        }
        if (list == null) {
            z17 = false;
        }
        if (z17) {
            Intrinsics.checkNotNullExpressionValue(result, "result");
            List list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = list2.iterator();
            while (it5.hasNext()) {
                arrayList.add(RoleGroupModel.INSTANCE.b((IGProGuildRoleInfo) it5.next()));
            }
            callback.a(result, new RoleGroupListModel(guildId, arrayList, null, 4, null));
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(ResultDispatcher this_networkGuard, String guildId, String tinyId, int i3, String str, List roleInfoList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this_networkGuard, "$this_networkGuard");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        ri1.a result = ri1.a.e(i3, str, null);
        boolean z16 = true;
        if (!result.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchMemberRoles fail code=" + i3 + " msg=" + str + " list:" + roleInfoList + " guildId=" + guildId + " tinyId=" + tinyId;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            this_networkGuard.b(result);
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.rg.RealRoleGroupListRepository", "fetchMemberRoles original list: " + roleInfoList);
        }
        if (roleInfoList == null) {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(roleInfoList, "roleInfoList");
            List<IGProGuildRoleInfo> list = roleInfoList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (IGProGuildRoleInfo it5 : list) {
                RoleGroupModel.Companion companion = RoleGroupModel.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList.add(companion.b(it5));
            }
            this_networkGuard.c(arrayList);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(ResultDispatcher this_networkGuard, FetchRoleGroupParam fetchParam, int i3, String msg2, List roleList, List lvRoleList, List myRoles) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this_networkGuard, "$this_networkGuard");
        Intrinsics.checkNotNullParameter(fetchParam, "$fetchParam");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(roleList, "roleList");
        Intrinsics.checkNotNullParameter(lvRoleList, "lvRoleList");
        Intrinsics.checkNotNullParameter(myRoles, "myRoles");
        ri1.a errRes = ri1.a.e(i3, msg2, null);
        if (!errRes.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetchRoleWithPermission fail code=" + i3 + " msg=" + msg2 + " " + fetchParam;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(errRes, "errRes");
            this_networkGuard.b(errRes);
            return;
        }
        List list = roleList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList.add(RoleGroupModel.INSTANCE.f((IGProGuildRoleInfo) it5.next(), null, new ArrayList(), new ArrayList()));
        }
        t.h(myRoles, arrayList);
        this_networkGuard.c(new RoleGroupListModel(fetchParam.getGuildId(), new ArrayList(arrayList), lvRoleList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(ResultDispatcher this_networkGuard, FetchRoleGroupParam fetchParam, int i3, String msg2, IGProGuildRoleInfo iGProGuildRoleInfo, GProRolePermission allowPermission, List desc, List permissionCategories) {
        Intrinsics.checkNotNullParameter(this_networkGuard, "$this_networkGuard");
        Intrinsics.checkNotNullParameter(fetchParam, "$fetchParam");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(allowPermission, "allowPermission");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(permissionCategories, "permissionCategories");
        ri1.a errRes = ri1.a.e(i3, msg2, null);
        if (errRes.d() && iGProGuildRoleInfo != null) {
            this_networkGuard.c(RoleGroupModel.INSTANCE.f(iGProGuildRoleInfo, allowPermission, desc, permissionCategories));
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "fetchRoleWithPermission fail code=" + i3 + " msg=" + msg2 + " " + fetchParam + " role:" + iGProGuildRoleInfo;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
        }
        Intrinsics.checkNotNullExpressionValue(errRes, "errRes");
        this_networkGuard.b(errRes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ResultDispatcher this_withFunction, String guildId, String tinyId, int i3, String str, List roleInfoList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this_withFunction, "$this_withFunction");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        ri1.a result = ri1.a.e(i3, str, null);
        boolean z16 = true;
        if (!result.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "loadLocalMemberRoles fail code=" + i3 + " msg=" + str + " list:" + roleInfoList + " guildId=" + guildId + " tinyId=" + tinyId;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            this_withFunction.b(result);
            return;
        }
        if (roleInfoList == null) {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(roleInfoList, "roleInfoList");
            List<IGProGuildRoleInfo> list = roleInfoList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (IGProGuildRoleInfo it5 : list) {
                RoleGroupModel.Companion companion = RoleGroupModel.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                arrayList.add(companion.b(it5));
            }
            this_withFunction.c(arrayList);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(com.tencent.mobileqq.guild.base.repository.h callback, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ri1.a reqResult = ri1.a.e(i3, str, iGProSecurityResult);
        Intrinsics.checkNotNullExpressionValue(reqResult, "reqResult");
        callback.a(reqResult, Boolean.valueOf(reqResult.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(ResultDispatcher this_networkGuard, List addRoles, List removeRoles, String guildId, String tinyId, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this_networkGuard, "$this_networkGuard");
        Intrinsics.checkNotNullParameter(addRoles, "$addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "$removeRoles");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        ri1.a result = ri1.a.e(i3, str, iGProSecurityResult);
        boolean z17 = true;
        if (!result.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "updateRoleGroup fail code=" + i3 + " msg=" + str + " sec=" + iGProSecurityResult + " guildId=" + guildId + " tinyId=" + tinyId + " " + addRoles + " " + removeRoles;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            this_networkGuard.b(result);
            return;
        }
        List list = addRoles;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                if (Intrinsics.areEqual((String) it5.next(), "2")) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        List list2 = removeRoles;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it6 = list2.iterator();
            while (it6.hasNext()) {
                if (Intrinsics.areEqual((String) it6.next(), "2")) {
                    break;
                }
            }
        }
        z17 = false;
        if (z16 || z17) {
            com.tencent.mobileqq.guild.setting.mute.c.W(guildId, tinyId, z16);
        }
        this_networkGuard.c(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ResultDispatcher this_networkGuard, String guildId, String roleGroupId, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this_networkGuard, "$this_networkGuard");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(roleGroupId, "$roleGroupId");
        ri1.a result = ri1.a.e(i3, str, iGProSecurityResult);
        if (!result.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "updateRoleGroup fail code=" + i3 + " msg=" + str + " sec=" + iGProSecurityResult + " guildId=" + guildId + " roleId=" + roleGroupId;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            this_networkGuard.b(result);
            return;
        }
        this_networkGuard.c(Boolean.TRUE);
    }

    private final void K() {
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.roleService = (uh2.f) R0;
        IRuntimeService R02 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R02, "runtimeService(IGPSService::class.java)");
        this.permissionService = (uh2.d) R02;
        IRuntimeService R03 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R03, "runtimeService(IGPSService::class.java)");
        this.genService = (uh2.b) R03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ResultDispatcher this_networkGuard, String guildId, RoleGroupModel roleGroup, int i3, String str, IGProGuildRoleInfo iGProGuildRoleInfo, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this_networkGuard, "$this_networkGuard");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(roleGroup, "$roleGroup");
        ri1.a result = ri1.a.e(i3, str, iGProSecurityResult);
        boolean z16 = true;
        if (!result.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "createRole fail code=" + i3 + " msg=" + str + " sec=" + iGProSecurityResult + " guildId=" + guildId + " " + roleGroup;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            this_networkGuard.b(result);
            return;
        }
        if (iGProGuildRoleInfo == null) {
            z16 = false;
        }
        if (z16) {
            this_networkGuard.c(Boolean.TRUE);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void A(int code, @Nullable String errMsg, int totalRoleNum, @NotNull List<? extends IGProGuildRoleInfo> roleList, @NotNull ChannelPermissionTarget target, @NotNull ResultDispatcher<List<RoleGroupModel>> dispatcher) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(roleList, "roleList");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        ri1.a result = ri1.a.e(code, errMsg, null);
        if (!result.d()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetchRoleGroupForChannelPermission onFetch result:" + code + " errMsg:" + errMsg + " " + target;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.RealRoleGroupListRepository", 1, (String) it.next(), null);
            }
            Intrinsics.checkNotNullExpressionValue(result, "result");
            dispatcher.b(result);
            return;
        }
        List<? extends IGProGuildRoleInfo> list = roleList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList.add(RoleGroupModel.INSTANCE.b((IGProGuildRoleInfo) it5.next()));
        }
        dispatcher.c(arrayList);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void a(@NotNull final String guildId, @NotNull final String roleGroupId, @NotNull RoleGroupModel roleGroup, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Set set;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroupId, "roleGroupId");
        Intrinsics.checkNotNullParameter(roleGroup, "roleGroup");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultDispatcher resultDispatcher = new ResultDispatcher("updateRoleGroup", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        fn.a h16 = new fn.a().f(roleGroup.getColor()).g(roleGroup.getIsHoist()).h(roleGroup.getName());
        GProRolePermission.Companion companion = GProRolePermission.INSTANCE;
        List<Integer> n3 = roleGroup.n();
        set = CollectionsKt___CollectionsKt.toSet(roleGroup.getRolePermission().i());
        fn e16 = h16.i(GProRolePermission.Companion.b(companion, n3, set, false, 4, null)).e();
        uh2.f fVar = this.roleService;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleService");
            fVar = null;
        }
        fVar.setRoleInfo(guildId, roleGroupId, e16, new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.p
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                q.J(ResultDispatcher.this, guildId, roleGroupId, i3, str, iGProSecurityResult);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0067, code lost:
    
        if (r0 != false) goto L17;
     */
    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@NotNull ChannelPermissionTarget target, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        boolean z16;
        uh2.d dVar;
        uh2.d dVar2;
        uh2.d dVar3;
        uh2.b bVar;
        uh2.b bVar2;
        Long longOrNull;
        Long longOrNull2;
        boolean z17;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(addRoles, "addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ResultDispatcher resultDispatcher = new ResultDispatcher("modifyRoleGroupForChannelPermission", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        e eVar = new e(resultDispatcher, target, addRoles, removeRoles);
        String guildId = target.getGuildId();
        String channelId = target.getChannelId();
        boolean z18 = false;
        if (guildId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (target.getType() != ChannelPermissionType.SpeakPermission) {
                if (channelId.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z18 = true;
        }
        if (z18) {
            ArrayList<Long> arrayList = new ArrayList<>();
            Iterator<T> it = addRoles.iterator();
            while (it.hasNext()) {
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
                if (longOrNull2 != null) {
                    arrayList.add(longOrNull2);
                }
            }
            ArrayList<Long> arrayList2 = new ArrayList<>();
            Iterator<T> it5 = removeRoles.iterator();
            while (it5.hasNext()) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it5.next());
                if (longOrNull != null) {
                    arrayList2.add(longOrNull);
                }
            }
            int i3 = b.f232784a[target.getType().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                uh2.b bVar3 = this.genService;
                                if (bVar3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("genService");
                                    bVar2 = null;
                                } else {
                                    bVar2 = bVar3;
                                }
                                bVar2.setChannelAuthControlRoleList(Long.parseLong(guildId), Long.parseLong(channelId), arrayList, arrayList2, 4, eVar);
                                return;
                            }
                            return;
                        }
                        uh2.b bVar4 = this.genService;
                        if (bVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("genService");
                            bVar = null;
                        } else {
                            bVar = bVar4;
                        }
                        bVar.setChannelAuthControlRoleList(Long.parseLong(guildId), Long.parseLong(channelId), arrayList, arrayList2, 5, eVar);
                        return;
                    }
                    uh2.d dVar4 = this.permissionService;
                    if (dVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("permissionService");
                        dVar3 = null;
                    } else {
                        dVar3 = dVar4;
                    }
                    dVar3.setChannelLiveableRoleList(guildId, channelId, addRoles, removeRoles, eVar);
                    return;
                }
                uh2.d dVar5 = this.permissionService;
                if (dVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("permissionService");
                    dVar2 = null;
                } else {
                    dVar2 = dVar5;
                }
                dVar2.setChannelSpeakableRoleList(guildId, channelId, addRoles, removeRoles, eVar);
                return;
            }
            uh2.d dVar6 = this.permissionService;
            if (dVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionService");
                dVar = null;
            } else {
                dVar = dVar6;
            }
            dVar.setChannelVisibleRoleList(guildId, channelId, addRoles, removeRoles, eVar);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        if (r1 != false) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(@NotNull ChannelPermissionTarget target, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
        byte b16;
        byte b17;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ResultDispatcher resultDispatcher = new ResultDispatcher("fetchRoleGroupForChannelPermission", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b18 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b18, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b18);
            return;
        }
        c cVar = new c(target, resultDispatcher);
        String guildId = target.getGuildId();
        String channelId = target.getChannelId();
        boolean z16 = false;
        if (guildId.length() > 0) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 != false) {
            if (target.getType() != ChannelPermissionType.SpeakPermission) {
                if (channelId.length() > 0) {
                    b17 = true;
                } else {
                    b17 = false;
                }
            }
            z16 = true;
        }
        if (z16) {
            int i3 = b.f232784a[target.getType().ordinal()];
            uh2.d dVar = null;
            uh2.b bVar = null;
            uh2.b bVar2 = null;
            uh2.d dVar2 = null;
            uh2.d dVar3 = null;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                uh2.b bVar3 = this.genService;
                                if (bVar3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("genService");
                                } else {
                                    bVar = bVar3;
                                }
                                bVar.fetchChannelAuthControlRoleList(Long.parseLong(guildId), Long.parseLong(channelId), 4, cVar);
                                return;
                            }
                            return;
                        }
                        uh2.b bVar4 = this.genService;
                        if (bVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("genService");
                        } else {
                            bVar2 = bVar4;
                        }
                        bVar2.fetchChannelAuthControlRoleList(Long.parseLong(guildId), Long.parseLong(channelId), 5, cVar);
                        return;
                    }
                    uh2.d dVar4 = this.permissionService;
                    if (dVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("permissionService");
                    } else {
                        dVar2 = dVar4;
                    }
                    dVar2.fetchChannelLiveableRoleList(guildId, channelId, cVar);
                    return;
                }
                uh2.d dVar5 = this.permissionService;
                if (dVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("permissionService");
                } else {
                    dVar3 = dVar5;
                }
                dVar3.getChannelSpeakableRoleList(guildId, channelId, cVar);
                return;
            }
            uh2.d dVar6 = this.permissionService;
            if (dVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionService");
            } else {
                dVar = dVar6;
            }
            dVar.getChannelVisibleRoleList(guildId, channelId, cVar);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void d(@NotNull ChannelPermissionTargetForRole target, @NotNull List<String> addChannels, @NotNull List<String> removeChannels, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        boolean z16;
        uh2.f fVar;
        uh2.f fVar2;
        boolean z17;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(addChannels, "addChannels");
        Intrinsics.checkNotNullParameter(removeChannels, "removeChannels");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ResultDispatcher resultDispatcher = new ResultDispatcher("modifyChannelPermissionForRoleGroup", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        d dVar = new d(resultDispatcher, target, addChannels, removeChannels);
        String guildId = target.getGuildId();
        String roleId = target.getRoleId();
        boolean z18 = false;
        if (guildId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (roleId.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z18 = true;
            }
        }
        if (z18) {
            int i3 = b.f232784a[target.getType().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    uh2.f fVar3 = this.roleService;
                    if (fVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roleService");
                        fVar2 = null;
                    } else {
                        fVar2 = fVar3;
                    }
                    fVar2.setRoleSpeakableChannels(guildId, roleId, addChannels, removeChannels, dVar);
                    return;
                }
                return;
            }
            uh2.f fVar4 = this.roleService;
            if (fVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleService");
                fVar = null;
            } else {
                fVar = fVar4;
            }
            fVar.setRoleVisibleChannels(guildId, roleId, addChannels, removeChannels, dVar);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r0 != false) goto L14;
     */
    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RoleGroupModel e(@NotNull FetchRoleGroupParam fetchParam) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(fetchParam, "fetchParam");
        boolean z18 = true;
        if (fetchParam.getGuildId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (fetchParam.getRoleId().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z18 = false;
        if (z18) {
            uh2.f fVar = this.roleService;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleService");
                fVar = null;
            }
            IGProGuildRoleInfo roleInfo = fVar.getRoleInfo(fetchParam.getGuildId(), fetchParam.getRoleId());
            if (roleInfo == null) {
                return null;
            }
            return RoleGroupModel.INSTANCE.b(roleInfo);
        }
        throw new IllegalArgumentException(("invalid param:" + fetchParam).toString());
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void f(@NotNull final String guildId, @NotNull final String tinyId, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultDispatcher resultDispatcher = new ResultDispatcher("loadLocalMemberRoles", callback, this.inlineDispatcher);
        uh2.f fVar = this.roleService;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleService");
            fVar = null;
        }
        fVar.loadMemberRoleList(guildId, tinyId, new bx() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.h
            @Override // vh2.bx
            public final void a(int i3, String str, List list) {
                q.G(ResultDispatcher.this, guildId, tinyId, i3, str, list);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r7 != false) goto L17;
     */
    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(@NotNull final FetchRoleGroupParam fetchParam, @NotNull com.tencent.mobileqq.guild.base.repository.h<RoleGroupModel> callback) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(fetchParam, "fetchParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultDispatcher resultDispatcher = new ResultDispatcher("fetchRoleGroupWithPermission", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        boolean z18 = true;
        if (fetchParam.getGuildId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (fetchParam.getRoleId().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z18 = false;
        if (z18) {
            uh2.d dVar = this.permissionService;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionService");
                dVar = null;
            }
            dVar.fetchRoleWithPermission(fetchParam.getGuildId(), fetchParam.getRoleId(), fetchParam.getSourceType(), new xh2.b() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.g
                @Override // xh2.b
                public final void a(int i3, String str, IGProGuildRoleInfo iGProGuildRoleInfo, GProRolePermission gProRolePermission, List list, List list2) {
                    q.F(ResultDispatcher.this, fetchParam, i3, str, iGProGuildRoleInfo, gProRolePermission, list, list2);
                }
            });
            return;
        }
        throw new IllegalArgumentException(("invalid param:" + fetchParam).toString());
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    @NotNull
    public Permissions getCategoryPermission(@NotNull String guildId, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        uh2.d dVar = this.permissionService;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionService");
            dVar = null;
        }
        dx categoryPermission = dVar.getCategoryPermission(guildId, categoryId);
        Intrinsics.checkNotNullExpressionValue(categoryPermission, "permissionService.getCat\u2026sion(guildId, categoryId)");
        return new Permissions(categoryPermission, guildId, null, categoryId, 4, null);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    @NotNull
    public Permissions getChannelPermission(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        uh2.d dVar = this.permissionService;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionService");
            dVar = null;
        }
        dx channelPermission = dVar.getChannelPermission(guildId, channelId);
        Intrinsics.checkNotNullExpressionValue(channelPermission, "permissionService.getCha\u2026ssion(guildId, channelId)");
        return new Permissions(channelPermission, guildId, channelId, null, 8, null);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    @NotNull
    public Permissions getGuildPermission(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        uh2.d dVar = this.permissionService;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionService");
            dVar = null;
        }
        dx guildPermission = dVar.getGuildPermission(guildId);
        Intrinsics.checkNotNullExpressionValue(guildPermission, "permissionService.getGuildPermission(guildId)");
        return new Permissions(guildPermission, guildId, null, null, 12, null);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void h(@NotNull final FetchRoleGroupParam fetchParam, @NotNull com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fetchParam, "fetchParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultDispatcher resultDispatcher = new ResultDispatcher("fetchRoleGroupListWithPermission", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        if (fetchParam.getGuildId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            uh2.d dVar = this.permissionService;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionService");
                dVar = null;
            }
            dVar.fetchRoleListWithPermission(fetchParam.getGuildId(), fetchParam.getSourceType(), new xh2.a() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.j
                @Override // xh2.a
                public final void a(int i3, String str, List list, List list2, List list3) {
                    q.E(ResultDispatcher.this, fetchParam, i3, str, list, list2, list3);
                }
            });
            return;
        }
        throw new IllegalArgumentException("guildId must not be empty".toString());
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void i(@NotNull final String guildId, @NotNull final RoleGroupModel roleGroup, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Set set;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroup, "roleGroup");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultDispatcher resultDispatcher = new ResultDispatcher("createRoleGroup", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        fn.a h16 = new fn.a().f(roleGroup.getColor()).g(roleGroup.getIsHoist()).h(roleGroup.getName());
        GProRolePermission.Companion companion = GProRolePermission.INSTANCE;
        List<Integer> n3 = roleGroup.n();
        set = CollectionsKt___CollectionsKt.toSet(roleGroup.getRolePermission().i());
        fn e16 = h16.i(GProRolePermission.Companion.b(companion, n3, set, false, 4, null)).e();
        uh2.f fVar = this.roleService;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleService");
            fVar = null;
        }
        fVar.createRole(guildId, e16, roleGroup.r(), new vh2.i() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.o
            @Override // vh2.i
            public final void a(int i3, String str, IGProGuildRoleInfo iGProGuildRoleInfo, IGProSecurityResult iGProSecurityResult) {
                q.z(ResultDispatcher.this, guildId, roleGroup, i3, str, iGProGuildRoleInfo, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void j(@NotNull String guildId, @NotNull List<String> roleGroupIds, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroupIds, "roleGroupIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ResultDispatcher resultDispatcher = new ResultDispatcher("updateRoleGroupListOrder", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
        } else {
            uh2.f fVar = this.roleService;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleService");
                fVar = null;
            }
            fVar.setRoleOrder(guildId, roleGroupIds, new f(resultDispatcher, guildId));
        }
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void k(@NotNull final String guildId, final boolean whiteList, @NotNull final com.tencent.mobileqq.guild.base.repository.h<RoleGroupListModel> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        uh2.f fVar = this.roleService;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleService");
            fVar = null;
        }
        fVar.fetchGuildSpeakableRoleList(guildId, whiteList, new xh2.q() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.m
            @Override // xh2.q
            public final void a(int i3, String str, int i16, List list) {
                q.C(com.tencent.mobileqq.guild.base.repository.h.this, guildId, whiteList, i3, str, i16, list);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void l(@NotNull GuildTarget guildTarget, @NotNull final String tinyId, @NotNull final List<String> addRoles, @NotNull final List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildTarget, "guildTarget");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(addRoles, "addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultDispatcher resultDispatcher = new ResultDispatcher("modifyRolesForMember", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        final String guildId = guildTarget.getGuildId();
        uh2.f fVar = this.roleService;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleService");
            fVar = null;
        }
        fVar.setMemberRoles(guildId, tinyId, guildTarget.getChannelId(), guildTarget.getCategoryId(), addRoles, removeRoles, new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.k
            @Override // vh2.cd
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                q.I(ResultDispatcher.this, addRoles, removeRoles, guildId, tinyId, i3, str, iGProSecurityResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void m(@NotNull String guildId, @NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull final com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(addRoles, "addRoles");
        Intrinsics.checkNotNullParameter(removeRoles, "removeRoles");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (guildId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            uh2.f fVar = this.roleService;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleService");
                fVar = null;
            }
            fVar.modifyGuildSpeakableRoleList(guildId, addRoles, removeRoles, new dv() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.l
                @Override // wh2.dv
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                    q.H(com.tencent.mobileqq.guild.base.repository.h.this, i3, str, iGProSecurityResult);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void n(@NotNull GuildTarget guildTarget, @NotNull final String tinyId, @NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback) {
        Intrinsics.checkNotNullParameter(guildTarget, "guildTarget");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultDispatcher resultDispatcher = new ResultDispatcher("fetchMemberRoles", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
            return;
        }
        final String guildId = guildTarget.getGuildId();
        String channelId = guildTarget.getChannelId();
        uh2.f fVar = this.roleService;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleService");
            fVar = null;
        }
        fVar.fetchMemberRoleList(guildId, channelId, tinyId, 100, new ak() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.i
            @Override // vh2.ak
            public final void a(int i3, String str, List list) {
                q.D(ResultDispatcher.this, guildId, tinyId, i3, str, list);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.model.repositories.IRoleGroupListRepository
    public void o(@NotNull final String guildId, @NotNull final String roleGroupId, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roleGroupId, "roleGroupId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ResultDispatcher resultDispatcher = new ResultDispatcher("deleteRoleGroup", callback, this.inlineDispatcher);
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
        } else {
            uh2.f fVar = this.roleService;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleService");
                fVar = null;
            }
            fVar.deleteRole(guildId, roleGroupId, new cd() { // from class: com.tencent.mobileqq.guild.rolegroup.model.repositories.n
                @Override // vh2.cd
                public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                    q.B(ResultDispatcher.this, guildId, roleGroupId, i3, str, iGProSecurityResult);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        K();
    }
}
