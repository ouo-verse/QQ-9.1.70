package gy0;

import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$BaseInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$UserGameOpenid;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import ly0.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010)\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b9\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0019\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016R$\u0010)\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00103R\u0016\u00106\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00105R\u0016\u00107\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u00105R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00105\u00a8\u0006:"}, d2 = {"Lgy0/b;", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "o", "", "c", "d", "i", "", "gender", "j", "(Ljava/lang/Integer;)Ljava/lang/String;", "content", "k", h.F, "f", "g", "Ley0/b;", "l", "Lgy0/c;", ReportConstant.COSTREPORT_PREFIX, "", "b", "id", "p", "e", "a", "toString", "Lcom/tencent/icgame/game/userinfo/impl/db/UserInfoEntity;", "Lcom/tencent/icgame/game/userinfo/impl/db/UserInfoEntity;", "getEntity", "()Lcom/tencent/icgame/game/userinfo/impl/db/UserInfoEntity;", "setEntity", "(Lcom/tencent/icgame/game/userinfo/impl/db/UserInfoEntity;)V", "entity", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$BaseInfo;", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$BaseInfo;", "qqBaseInfo", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$UserGameOpenid;", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$UserGameOpenid;", "userGameOpenid", "Lgy0/a;", "Lgy0/a;", "allGroupProUserInfoModel", "Lgy0/c;", "nearByUserInfo", "I", "CPDD_SEX_NONE", "CPDD_SEX_MALE", "CPDD_SEX_FEMALE", "<init>", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b implements IUserInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UserInfoEntity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UserProxyCmdOuterClass$BaseInfo qqBaseInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UserProxyCmdOuterClass$UserGameOpenid userGameOpenid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a allGroupProUserInfoModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c nearByUserInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int CPDD_SEX_NONE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int CPDD_SEX_MALE = 1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int CPDD_SEX_FEMALE = 2;

    public b(@Nullable UserInfoEntity userInfoEntity) {
        this.entity = userInfoEntity;
        n();
        m();
    }

    private final String c() {
        int i3;
        PBUInt32Field pBUInt32Field;
        UserProxyCmdOuterClass$BaseInfo userProxyCmdOuterClass$BaseInfo = this.qqBaseInfo;
        if (userProxyCmdOuterClass$BaseInfo != null && (pBUInt32Field = userProxyCmdOuterClass$BaseInfo.gender) != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = this.CPDD_SEX_NONE;
        }
        if (i3 == this.CPDD_SEX_MALE) {
            return "\u7537";
        }
        if (i3 == this.CPDD_SEX_FEMALE) {
            return "\u5973";
        }
        return "\u672a\u77e5";
    }

    private final String d() {
        Integer num;
        ey0.b l3 = l();
        if (l3 != null) {
            num = Integer.valueOf(l3.a());
        } else {
            num = null;
        }
        return j(num);
    }

    private final String i() {
        Integer num;
        c s16 = s();
        if (s16 != null) {
            num = Integer.valueOf(s16.b());
        } else {
            num = null;
        }
        return j(num);
    }

    private final String j(Integer gender) {
        if (gender != null && gender.intValue() == 1) {
            return "\u7537";
        }
        if (gender != null && gender.intValue() == 2) {
            return "\u5973";
        }
        return "\u672a\u77e5";
    }

    private final String k(String content) {
        if (content != null) {
            return content;
        }
        return "";
    }

    private final void m() {
        this.userGameOpenid = l.f415771a.d(this.entity);
    }

    private final void n() {
        this.qqBaseInfo = l.f415771a.a(this.entity);
    }

    private final boolean o(CommonOuterClass$QQUserId qqUserId) {
        PBInt32Field pBInt32Field;
        if (qqUserId == null || (pBInt32Field = qqUserId.user_from) == null || pBInt32Field.get() != 4) {
            return false;
        }
        return true;
    }

    private final boolean q(CommonOuterClass$QQUserId qqUserId) {
        PBInt32Field pBInt32Field;
        if (qqUserId == null || (pBInt32Field = qqUserId.user_from) == null || pBInt32Field.get() != 1) {
            return false;
        }
        return true;
    }

    private final boolean r(CommonOuterClass$QQUserId qqUserId) {
        PBInt32Field pBInt32Field;
        if (qqUserId == null || (pBInt32Field = qqUserId.user_from) == null || pBInt32Field.get() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.icgame.game.userinfo.api.IUserInfo
    public long a() {
        UserInfoEntity userInfoEntity = this.entity;
        if (userInfoEntity != null) {
            return userInfoEntity.qqUin;
        }
        return 0L;
    }

    @Override // com.tencent.icgame.game.userinfo.api.IUserInfo
    public long b() {
        UserInfoEntity userInfoEntity = this.entity;
        if (userInfoEntity != null) {
            return userInfoEntity.uid;
        }
        return 0L;
    }

    @Override // com.tencent.icgame.game.userinfo.api.IUserInfo
    public boolean e(@Nullable CommonOuterClass$QQUserId qqUserId) {
        long j3;
        PBUInt64Field pBUInt64Field;
        PBUInt64Field pBUInt64Field2;
        long j16 = 0;
        if (qqUserId != null && (pBUInt64Field2 = qqUserId.uid) != null) {
            j3 = pBUInt64Field2.get();
        } else {
            j3 = 0;
        }
        if (!p(j3)) {
            if (qqUserId != null && (pBUInt64Field = qqUserId.yes_uid) != null) {
                j16 = pBUInt64Field.get();
            }
            if (!p(j16)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.icgame.game.userinfo.api.IUserInfo
    @NotNull
    public String f(@Nullable CommonOuterClass$QQUserId qqUserId) {
        if (q(qqUserId)) {
            return c();
        }
        if (r(qqUserId)) {
            return d();
        }
        if (o(qqUserId)) {
            return i();
        }
        return d();
    }

    @Override // com.tencent.icgame.game.userinfo.api.IUserInfo
    @NotNull
    public String g(@Nullable CommonOuterClass$QQUserId qqUserId) {
        String str = null;
        if (q(qqUserId)) {
            UserInfoEntity userInfoEntity = this.entity;
            if (userInfoEntity != null) {
                str = userInfoEntity.extensionAvatar;
            }
            return k(str);
        }
        if (r(qqUserId)) {
            ey0.b l3 = l();
            if (l3 != null) {
                str = l3.b();
            }
            return k(str);
        }
        if (o(qqUserId)) {
            c s16 = s();
            if (s16 != null) {
                str = s16.a();
            }
            return k(str);
        }
        ey0.b l16 = l();
        if (l16 != null) {
            str = l16.b();
        }
        return k(str);
    }

    @Override // com.tencent.icgame.game.userinfo.api.IUserInfo
    @NotNull
    public String h(@Nullable CommonOuterClass$QQUserId qqUserId) {
        PBUInt64Field pBUInt64Field;
        String c16;
        PBUInt64Field pBUInt64Field2;
        PBStringField pBStringField;
        String str = null;
        r1 = null;
        String str2 = null;
        r1 = null;
        Long l3 = null;
        String str3 = null;
        r1 = null;
        Long l16 = null;
        if (q(qqUserId)) {
            UserProxyCmdOuterClass$BaseInfo userProxyCmdOuterClass$BaseInfo = this.qqBaseInfo;
            if (userProxyCmdOuterClass$BaseInfo != null && (pBStringField = userProxyCmdOuterClass$BaseInfo.nick) != null) {
                str2 = pBStringField.get();
            }
            return k(str2);
        }
        if (r(qqUserId)) {
            ey0.b l17 = l();
            if (l17 != null) {
                if (qqUserId != null && (pBUInt64Field2 = qqUserId.guild_id) != null) {
                    l3 = Long.valueOf(pBUInt64Field2.get());
                }
                str3 = l17.c(l3);
            }
            if (str3 == null) {
                return "";
            }
            return str3;
        }
        if (o(qqUserId)) {
            c s16 = s();
            if (s16 == null || (c16 = s16.c()) == null) {
                return "";
            }
            return c16;
        }
        ey0.b l18 = l();
        if (l18 != null) {
            if (qqUserId != null && (pBUInt64Field = qqUserId.guild_id) != null) {
                l16 = Long.valueOf(pBUInt64Field.get());
            }
            str = l18.c(l16);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Nullable
    public ey0.b l() {
        if (this.allGroupProUserInfoModel == null) {
            this.allGroupProUserInfoModel = new a(l.f415771a.c(this.entity));
        }
        return this.allGroupProUserInfoModel;
    }

    public boolean p(long id5) {
        boolean z16;
        boolean z17;
        if (id5 == 0) {
            return false;
        }
        UserInfoEntity userInfoEntity = this.entity;
        if (userInfoEntity != null && id5 == userInfoEntity.uid) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (userInfoEntity != null && id5 == userInfoEntity.qqUin) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public c s() {
        if (this.nearByUserInfo == null) {
            this.nearByUserInfo = new c(l.f415771a.b(this.entity));
        }
        return this.nearByUserInfo;
    }

    @NotNull
    public String toString() {
        String str;
        UserInfoEntity userInfoEntity = this.entity;
        if (userInfoEntity != null) {
            str = userInfoEntity.toString();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
