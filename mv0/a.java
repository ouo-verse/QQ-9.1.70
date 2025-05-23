package mv0;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.annotations.SerializedName;
import com.tencent.icgame.trpc.yes.common.PremadesTeamServerOuterClass$RoomTabInfo;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R?\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR/\u0010\u0016\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\fR0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c0\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\fR4\u0010 \u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\fR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0018\u00a8\u0006%"}, d2 = {"Lmv0/a;", "", "", "roomId", "", "b", "", "a", "Ljava/util/HashMap;", "", "Lcom/tencent/icgame/trpc/yes/common/PremadesTeamServerOuterClass$RoomTabInfo;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getRoomTabCongMap", "()Ljava/util/HashMap;", "roomTabCongMap", "Landroidx/lifecycle/MutableLiveData;", "", "c", "Landroidx/lifecycle/MutableLiveData;", "getRoomTabConfig", "()Landroidx/lifecycle/MutableLiveData;", "roomTabConfig", "d", "Ljava/lang/String;", "tips", "e", "roomTypeMap", "", "f", "showWarningMap", "g", "roomDefaultTabConfigMap", h.F, "curAnnounce", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f417650a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, List<PremadesTeamServerOuterClass$RoomTabInfo>> roomTabCongMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Map<Long, List<PremadesTeamServerOuterClass$RoomTabInfo>>> roomTabConfig = new MutableLiveData<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String tips = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Integer> roomTypeMap = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Boolean> showWarningMap = new HashMap<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, String> roomDefaultTabConfigMap = new HashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String curAnnounce = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lmv0/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "announce", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mv0.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes7.dex */
    private static final /* data */ class AnnouncementConfigBean {

        @SerializedName("announce")
        @NotNull
        private final String announce;

        public AnnouncementConfigBean(@NotNull String announce) {
            Intrinsics.checkNotNullParameter(announce, "announce");
            this.announce = announce;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAnnounce() {
            return this.announce;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AnnouncementConfigBean) && Intrinsics.areEqual(this.announce, ((AnnouncementConfigBean) other).announce)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.announce.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnnouncementConfigBean(announce=" + this.announce + ")";
        }
    }

    a() {
    }

    @NotNull
    public final String a() {
        if (TextUtils.isEmpty(curAnnounce)) {
            Object configBean = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getConfigBean(ICGameQMCCConfigKeysKt.KEY_ICGAME_ROOM_ANNOUNCE_CONFIG, AnnouncementConfigBean.class, new AnnouncementConfigBean("\u5e73\u53f0\u5bf9\u76f4\u64ad\u5185\u5bb9\u548c\u8bc4\u8bba\u8fdb\u884c24\u5c0f\u65f6\u5de1\u67e5\uff0c\u4e25\u7981\u4f20\u64ad\u653f\u6cbb\u3001\u5c01\u5efa\u8ff7\u4fe1\u3001\u66b4\u529b\u8840\u8165\u3001\u4f4e\u4fd7\u8272\u60c5\u3001\u62db\u5ad6\u8bc8\u9a97\u3001\u865a\u5047\u5145\u503c\u7b49\u4e0d\u826f\u5185\u5bb9\uff0c\u82e5\u6709\u8fdd\u53cd\uff0c\u5c06\u5e73\u53f0\u89c4\u5219\u7ed9\u4e88\u7981\u64ad\u3001\u5c01\u53f7\u7b49\u5904\u7406\u3002\u8bf7\u52ff\u8f7b\u4fe1\u5404\u7c7b\u62db\u8058\u5f81\u5a5a\u3001\u4ee3\u7ec3\u4ee3\u62bd\u3001\u8d2d\u4e70\u793c\u5305\u7801\u3001\u6e38\u620f\u5e01\u7b49\u5e7f\u544a\u4fe1\u606f\uff0c\u8bf7\u8c28\u614e\u5224\u65ad\u4ee5\u514d\u4e0a\u5f53\u53d7\u9a97\u3002"));
            Intrinsics.checkNotNullExpressionValue(configBean, "api(IICGameConfigApi::cl\u2026T_ANNOUNCE)\n            )");
            curAnnounce = ((AnnouncementConfigBean) configBean).getAnnounce();
        }
        return curAnnounce;
    }

    public final int b(long roomId) {
        Integer num = roomTypeMap.get(Long.valueOf(roomId));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
