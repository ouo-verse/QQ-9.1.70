package cm2;

import androidx.fragment.app.Fragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\b\u0010\tJ/\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH&\u00a2\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0013\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&\u00a2\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a2\u0006\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcm2/a;", "", "", "activateFriendsUin", "", "uinTypeActivateFriends", "", "Lcom/tencent/mobileqq/reminder/db/b;", "getMsgList", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "", "uniseq", "", "removeMsgByUniseq", "(Ljava/lang/String;Ljava/lang/Integer;J)V", "list", "account", "", "isBackgroundStop", "addMessage", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "Lcom/tencent/mobileqq/reminder/db/entity/b;", "getLastMessage", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/tencent/mobileqq/reminder/db/entity/b;", "setReaded", "(Ljava/lang/String;Ljava/lang/Integer;)V", "qqreminder-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: cm2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C0203a {
        public static /* synthetic */ com.tencent.mobileqq.reminder.db.entity.b a(a aVar, String str, Integer num, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = null;
                }
                if ((i3 & 2) != 0) {
                    num = null;
                }
                return aVar.getLastMessage(str, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLastMessage");
        }

        public static /* synthetic */ List b(a aVar, String str, Integer num, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = null;
                }
                if ((i3 & 2) != 0) {
                    num = null;
                }
                return aVar.getMsgList(str, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMsgList");
        }

        public static boolean c(@NotNull a aVar, @NotNull Fragment visitor) {
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            return false;
        }
    }

    void addMessage(@NotNull List<? extends com.tencent.mobileqq.reminder.db.b> list, @Nullable String account, @Nullable Boolean isBackgroundStop);

    @Nullable
    com.tencent.mobileqq.reminder.db.entity.b getLastMessage(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends);

    @NotNull
    List<com.tencent.mobileqq.reminder.db.b> getMsgList(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends);

    void removeMsgByUniseq(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends, long uniseq);

    void setReaded(@Nullable String activateFriendsUin, @Nullable Integer uinTypeActivateFriends);
}
