package gy0;

import android.text.TextUtils;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$JoinedGuildInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQGroupProInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQGroupProUserInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lgy0/a;", "Ley0/b;", "", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$JoinedGuildInfo;", "d", "", "b", "", "a", "", "guildId", "e", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;", "getGroupProInfo", "()Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;", "groupProInfo", "<init>", "(Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a implements ey0.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final UserProxyCmdOuterClass$QQGroupProInfo groupProInfo;

    public a(@Nullable UserProxyCmdOuterClass$QQGroupProInfo userProxyCmdOuterClass$QQGroupProInfo) {
        this.groupProInfo = userProxyCmdOuterClass$QQGroupProInfo;
    }

    @Override // ey0.b
    public int a() {
        UserProxyCmdOuterClass$QQGroupProUserInfo userProxyCmdOuterClass$QQGroupProUserInfo;
        PBUInt32Field pBUInt32Field;
        UserProxyCmdOuterClass$QQGroupProInfo userProxyCmdOuterClass$QQGroupProInfo = this.groupProInfo;
        if (userProxyCmdOuterClass$QQGroupProInfo != null && (userProxyCmdOuterClass$QQGroupProUserInfo = userProxyCmdOuterClass$QQGroupProInfo.group_pro_user_info) != null && (pBUInt32Field = userProxyCmdOuterClass$QQGroupProUserInfo.gender) != null) {
            return pBUInt32Field.get();
        }
        return 0;
    }

    @Override // ey0.b
    @NotNull
    public String b() {
        UserProxyCmdOuterClass$QQGroupProUserInfo userProxyCmdOuterClass$QQGroupProUserInfo;
        PBStringField pBStringField;
        String str;
        UserProxyCmdOuterClass$QQGroupProInfo userProxyCmdOuterClass$QQGroupProInfo = this.groupProInfo;
        if (userProxyCmdOuterClass$QQGroupProInfo == null || (userProxyCmdOuterClass$QQGroupProUserInfo = userProxyCmdOuterClass$QQGroupProInfo.group_pro_user_info) == null || (pBStringField = userProxyCmdOuterClass$QQGroupProUserInfo.avatar) == null || (str = pBStringField.get()) == null) {
            return "";
        }
        return str;
    }

    @Override // ey0.b
    public /* bridge */ /* synthetic */ String c(Long l3) {
        return e(l3.longValue());
    }

    @NotNull
    public List<UserProxyCmdOuterClass$JoinedGuildInfo> d() {
        PBRepeatMessageField<UserProxyCmdOuterClass$JoinedGuildInfo> pBRepeatMessageField;
        List<UserProxyCmdOuterClass$JoinedGuildInfo> list;
        ArrayList arrayList = new ArrayList();
        UserProxyCmdOuterClass$QQGroupProInfo userProxyCmdOuterClass$QQGroupProInfo = this.groupProInfo;
        if (userProxyCmdOuterClass$QQGroupProInfo != null && (pBRepeatMessageField = userProxyCmdOuterClass$QQGroupProInfo.joined_guild_info_list) != null && (list = pBRepeatMessageField.get()) != null) {
            for (UserProxyCmdOuterClass$JoinedGuildInfo it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(it);
            }
        }
        return arrayList;
    }

    @NotNull
    public String e(long guildId) {
        String str;
        UserProxyCmdOuterClass$QQGroupProUserInfo userProxyCmdOuterClass$QQGroupProUserInfo;
        PBStringField pBStringField;
        Iterator<T> it = d().iterator();
        while (true) {
            String str2 = "";
            if (it.hasNext()) {
                UserProxyCmdOuterClass$JoinedGuildInfo userProxyCmdOuterClass$JoinedGuildInfo = (UserProxyCmdOuterClass$JoinedGuildInfo) it.next();
                if (guildId == userProxyCmdOuterClass$JoinedGuildInfo.guild_id.get()) {
                    String str3 = userProxyCmdOuterClass$JoinedGuildInfo.member_nick.get();
                    if (str3 != null) {
                        Intrinsics.checkNotNullExpressionValue(str3, "it.member_nick.get() ?: \"\"");
                        str2 = str3;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                }
            } else {
                UserProxyCmdOuterClass$QQGroupProInfo userProxyCmdOuterClass$QQGroupProInfo = this.groupProInfo;
                if (userProxyCmdOuterClass$QQGroupProInfo != null && (userProxyCmdOuterClass$QQGroupProUserInfo = userProxyCmdOuterClass$QQGroupProInfo.group_pro_user_info) != null && (pBStringField = userProxyCmdOuterClass$QQGroupProUserInfo.nick) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                if (str == null) {
                    return "";
                }
                return str;
            }
        }
    }
}
