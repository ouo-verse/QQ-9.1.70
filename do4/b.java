package do4;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import io4.l;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;
import trpc.yes.common.UserProxyCmdOuterClass$BaseInfo;
import trpc.yes.common.UserProxyCmdOuterClass$UserGameOpenid;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0011\u0012\b\u00102\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\bD\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0019\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0002J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\n\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010#\u001a\u00020\u0007H\u0016J\n\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010&\u001a\u00020\u0015H\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0015H\u0016J\u0012\u0010)\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\b\u0010+\u001a\u00020\u000bH\u0016R$\u00102\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010>R\u0016\u0010A\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010@R\u0016\u0010B\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010@R\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010@\u00a8\u0006E"}, d2 = {"Ldo4/b;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "", "v", "u", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "", HippyTKDListViewAdapter.X, "y", "w", "", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "gender", "r", "(Ljava/lang/Integer;)Ljava/lang/String;", "content", ReportConstant.COSTREPORT_PREFIX, "", "c", "()Ljava/lang/Long;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", h.F, "f", "Ltrpc/yes/common/UserProxyCmdOuterClass$UserGameOpenid;", "l", "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "g", "Lbo4/b;", "t", DomainData.DOMAIN_NAME, "Ldo4/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "b", "id", "k", "e", "a", "toString", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "getEntity", "()Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "setEntity", "(Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;)V", "entity", "Ltrpc/yes/common/UserProxyCmdOuterClass$BaseInfo;", "Ltrpc/yes/common/UserProxyCmdOuterClass$BaseInfo;", "qqBaseInfo", "Ltrpc/yes/common/UserProxyCmdOuterClass$UserGameOpenid;", "userGameOpenid", "Ldo4/a;", "d", "Ldo4/a;", "allGroupProUserInfoModel", "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "smobaGameRoleExtInfo", "Ldo4/c;", "nearByUserInfo", "I", "CPDD_SEX_NONE", "CPDD_SEX_MALE", "CPDD_SEX_FEMALE", "<init>", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
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
    private GameRoleOuterClass$SmobaGameRoleInfo smobaGameRoleExtInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c nearByUserInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int CPDD_SEX_NONE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int CPDD_SEX_MALE = 1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int CPDD_SEX_FEMALE = 2;

    public b(@Nullable UserInfoEntity userInfoEntity) {
        this.entity = userInfoEntity;
        v();
        u();
    }

    private final String o() {
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

    private final String p() {
        Integer num;
        bo4.b t16 = t();
        if (t16 != null) {
            num = Integer.valueOf(t16.a());
        } else {
            num = null;
        }
        return r(num);
    }

    private final String q() {
        Integer num;
        c d16 = d();
        if (d16 != null) {
            num = Integer.valueOf(d16.d());
        } else {
            num = null;
        }
        return r(num);
    }

    private final String r(Integer gender) {
        if (gender != null && gender.intValue() == 1) {
            return "\u7537";
        }
        if (gender != null && gender.intValue() == 2) {
            return "\u5973";
        }
        return "\u672a\u77e5";
    }

    private final String s(String content) {
        if (content != null) {
            return content;
        }
        return "";
    }

    private final void u() {
        this.userGameOpenid = l.f408121a.e(this.entity);
    }

    private final void v() {
        this.qqBaseInfo = l.f408121a.a(this.entity);
    }

    private final boolean w(CommonOuterClass$QQUserId qqUserId) {
        PBInt32Field pBInt32Field;
        if (qqUserId == null || (pBInt32Field = qqUserId.user_from) == null || pBInt32Field.get() != 4) {
            return false;
        }
        return true;
    }

    private final boolean x(CommonOuterClass$QQUserId qqUserId) {
        PBInt32Field pBInt32Field;
        if (qqUserId == null || (pBInt32Field = qqUserId.user_from) == null || pBInt32Field.get() != 1) {
            return false;
        }
        return true;
    }

    private final boolean y(CommonOuterClass$QQUserId qqUserId) {
        PBInt32Field pBInt32Field;
        if (qqUserId == null || (pBInt32Field = qqUserId.user_from) == null || pBInt32Field.get() != 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    public long a() {
        UserInfoEntity userInfoEntity = this.entity;
        if (userInfoEntity != null) {
            return userInfoEntity.qqUin;
        }
        return 0L;
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    public long b() {
        UserInfoEntity userInfoEntity = this.entity;
        if (userInfoEntity != null) {
            return userInfoEntity.uid;
        }
        return 0L;
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @NotNull
    public Long c() {
        long j3;
        UserInfoEntity userInfoEntity = this.entity;
        long j16 = 0;
        if (userInfoEntity != null) {
            j3 = userInfoEntity.qqUin;
        } else {
            j3 = 0;
        }
        if (j3 != 0) {
            return Long.valueOf(j3);
        }
        if (userInfoEntity != null) {
            j16 = userInfoEntity.uid;
        }
        return Long.valueOf(j16);
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
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
        if (!k(j3)) {
            if (qqUserId != null && (pBUInt64Field = qqUserId.yes_uid) != null) {
                j16 = pBUInt64Field.get();
            }
            if (!k(j16)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @NotNull
    public String f(@Nullable CommonOuterClass$QQUserId qqUserId) {
        String str = null;
        if (x(qqUserId)) {
            UserInfoEntity userInfoEntity = this.entity;
            if (userInfoEntity != null) {
                str = userInfoEntity.extensionAvatar;
            }
            return s(str);
        }
        if (y(qqUserId)) {
            bo4.b t16 = t();
            if (t16 != null) {
                str = t16.b();
            }
            return s(str);
        }
        if (w(qqUserId)) {
            c d16 = d();
            if (d16 != null) {
                str = d16.c();
            }
            return s(str);
        }
        bo4.b t17 = t();
        if (t17 != null) {
            str = t17.b();
        }
        return s(str);
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @Nullable
    public GameRoleOuterClass$SmobaGameRoleInfo g() {
        if (this.smobaGameRoleExtInfo == null) {
            this.smobaGameRoleExtInfo = l.f408121a.d(this.entity);
        }
        return this.smobaGameRoleExtInfo;
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @NotNull
    public String h(@Nullable CommonOuterClass$QQUserId qqUserId) {
        String str;
        PBStringField pBStringField;
        if (x(qqUserId)) {
            UserProxyCmdOuterClass$BaseInfo userProxyCmdOuterClass$BaseInfo = this.qqBaseInfo;
            if (userProxyCmdOuterClass$BaseInfo != null && (pBStringField = userProxyCmdOuterClass$BaseInfo.city) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            return s(str);
        }
        return "";
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @NotNull
    public String i(@Nullable CommonOuterClass$QQUserId qqUserId) {
        PBUInt64Field pBUInt64Field;
        String a16;
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
        if (x(qqUserId)) {
            UserProxyCmdOuterClass$BaseInfo userProxyCmdOuterClass$BaseInfo = this.qqBaseInfo;
            if (userProxyCmdOuterClass$BaseInfo != null && (pBStringField = userProxyCmdOuterClass$BaseInfo.nick) != null) {
                str2 = pBStringField.get();
            }
            return s(str2);
        }
        if (y(qqUserId)) {
            bo4.b t16 = t();
            if (t16 != null) {
                if (qqUserId != null && (pBUInt64Field2 = qqUserId.guild_id) != null) {
                    l3 = Long.valueOf(pBUInt64Field2.get());
                }
                str3 = t16.c(l3);
            }
            if (str3 == null) {
                return "";
            }
            return str3;
        }
        if (w(qqUserId)) {
            c d16 = d();
            if (d16 == null || (a16 = d16.a()) == null) {
                return "";
            }
            return a16;
        }
        bo4.b t17 = t();
        if (t17 != null) {
            if (qqUserId != null && (pBUInt64Field = qqUserId.guild_id) != null) {
                l16 = Long.valueOf(pBUInt64Field.get());
            }
            str = t17.c(l16);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @NotNull
    public String j(@Nullable CommonOuterClass$QQUserId qqUserId) {
        String str;
        PBStringField pBStringField;
        if (x(qqUserId)) {
            UserProxyCmdOuterClass$BaseInfo userProxyCmdOuterClass$BaseInfo = this.qqBaseInfo;
            if (userProxyCmdOuterClass$BaseInfo != null && (pBStringField = userProxyCmdOuterClass$BaseInfo.constellation) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            return s(str);
        }
        return "";
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    public boolean k(long id5) {
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

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @Nullable
    /* renamed from: l, reason: from getter */
    public UserProxyCmdOuterClass$UserGameOpenid getUserGameOpenid() {
        return this.userGameOpenid;
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @NotNull
    public String m(@Nullable CommonOuterClass$QQUserId qqUserId) {
        if (x(qqUserId)) {
            return o();
        }
        if (y(qqUserId)) {
            return p();
        }
        if (w(qqUserId)) {
            return q();
        }
        return p();
    }

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    public boolean n() {
        GameRoleOuterClass$SmobaGameRoleInfo g16 = g();
        if (g16 != null && !TextUtils.isEmpty(g16.role_name.get())) {
            return true;
        }
        return false;
    }

    @Nullable
    public bo4.b t() {
        if (this.allGroupProUserInfoModel == null) {
            this.allGroupProUserInfoModel = new a(l.f408121a.c(this.entity));
        }
        return this.allGroupProUserInfoModel;
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

    @Override // com.tencent.timi.game.userinfo.api.IUserInfo
    @Nullable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public c d() {
        if (this.nearByUserInfo == null) {
            this.nearByUserInfo = new c(l.f408121a.b(this.entity));
        }
        return this.nearByUserInfo;
    }
}
