package e02;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.member.view.GuildMemberAvatarInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineUsersInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wh2.ax;
import wh2.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\u00062\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R#\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Le02/c;", "Landroidx/lifecycle/ViewModel;", "", "guildId", "", "channelId", "", "P1", "N1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "Lkotlin/collections/ArrayList;", "activeChannels", "T1", "U1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/guild/setting/member/view/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "onlineUsersLiveData", "Ldg1/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "R1", "activeChannelLiveData", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<GuildMemberAvatarInfo>> onlineUsersLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<dg1.b>> activeChannelLiveData = new MutableLiveData<>();

    private final void N1(String guildId) {
        ((IGPSService) ch.R0(IGPSService.class)).fetchActiveChannels(guildId, new z() { // from class: e02.a
            @Override // wh2.z
            public final void onFetchActiveChannels(int i3, String str, ArrayList arrayList) {
                c.O1(c.this, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(c this$0, int i3, String str, ArrayList activeChannels) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Logger.f235387a.d().i("GuildLoopOnlineAvatarViewImpl", 1, "fetchActiveChannels: result[" + i3 + "] errMsg[" + str + "]");
            this$0.T1(new ArrayList<>());
            return;
        }
        Intrinsics.checkNotNullExpressionValue(activeChannels, "activeChannels");
        this$0.T1(activeChannels);
    }

    private final void P1(String guildId, long channelId) {
        ArrayList<Long> arrayListOf;
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(channelId));
        iGPSService.fetchOnlineUsers(guildId, 20, 2, arrayListOf, new ax() { // from class: e02.b
            @Override // wh2.ax
            public final void a(int i3, String str, IGProGuildOnlineUsersInfo iGProGuildOnlineUsersInfo) {
                c.Q1(c.this, i3, str, iGProGuildOnlineUsersInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(c this$0, int i3, String errMsg, IGProGuildOnlineUsersInfo usersInfo) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(usersInfo, "usersInfo");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "fetchActiveChannelData: result[" + i3 + "] errMsg[" + errMsg + "]";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildLoopOnlineAvatarViewImpl", 1, (String) it.next(), null);
            }
            return;
        }
        if (usersInfo.getGroupUsers() != null && usersInfo.getGroupUsers().size() != 0) {
            ArrayList<IGProUserInfo> users = usersInfo.getGroupUsers().get(0).getUsers();
            Intrinsics.checkNotNullExpressionValue(users, "usersInfo.groupUsers[0].users");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(users, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (IGProUserInfo iGProUserInfo : users) {
                String memberName = iGProUserInfo.getMemberName();
                if (memberName == null && (memberName = iGProUserInfo.getName()) == null) {
                    memberName = iGProUserInfo.getNickName();
                }
                String str2 = "";
                if (memberName == null) {
                    memberName = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(memberName, "it.memberName ?: it.disp\u2026Name ?: it.nickName ?: \"\"");
                }
                if (TextUtils.isEmpty(memberName)) {
                    String r16 = QQGuildUIUtil.r(R.string.f143020ky);
                    if (r16 != null) {
                        Intrinsics.checkNotNullExpressionValue(r16, "QQGuildUIUtil.getString(\u2026_default_nick_name) ?: \"\"");
                        str2 = r16;
                    }
                    memberName = str2;
                }
                String avatarMeta = iGProUserInfo.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "it.avatarMeta");
                String tinyId = iGProUserInfo.getTinyId();
                Intrinsics.checkNotNullExpressionValue(tinyId, "it.tinyId");
                arrayList.add(new GuildMemberAvatarInfo(avatarMeta, memberName, tinyId));
            }
            this$0.onlineUsersLiveData.setValue(arrayList);
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("fetchActiveChannelData: groupUsers is null or empty");
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("GuildLoopOnlineAvatarViewImpl", 1, (String) it5.next(), null);
        }
    }

    private final void T1(ArrayList<IGProRecommendItem> activeChannels) {
        this.activeChannelLiveData.setValue(dg1.a.d(activeChannels));
    }

    @NotNull
    public final MutableLiveData<List<dg1.b>> R1() {
        return this.activeChannelLiveData;
    }

    @NotNull
    public final MutableLiveData<List<GuildMemberAvatarInfo>> S1() {
        return this.onlineUsersLiveData;
    }

    public final void U1(@NotNull String guildId, long channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        P1(guildId, channelId);
        N1(guildId);
    }
}
