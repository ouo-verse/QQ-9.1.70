package com.tencent.mobileqq.guild.setting.guildmanage.feedsquare;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.base.b;
import com.tencent.mobileqq.guild.setting.guildmanage.feedsquare.GuildFeedSquareViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import wh2.dv;
import wy1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/feedsquare/GuildFeedSquareViewModel;", "Lcom/tencent/mobileqq/guild/base/b;", "Lwy1/a;", "", "switchOn", "", "changeSwitch", "", "guildId", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "getSwitchOn", "()Landroidx/lifecycle/MutableLiveData;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildFeedSquareViewModel extends b<a> {

    @NotNull
    public static final String TAG = "GuildFeedSquareViewModel";

    @NotNull
    private final String guildId;

    @NotNull
    private final MutableLiveData<Boolean> switchOn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareViewModel(@NotNull String guildId) {
        super(new a());
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.switchOn = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeSwitch$lambda$2(GuildFeedSquareViewModel this$0, boolean z16, int i3, String str, IGProSecurityResult iGProSecurityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i(TAG, 1, "setTopicSquareEntranceSwitch result: " + i3 + ", errMsg: " + str);
        if (i3 != 0) {
            Logger.b bVar = new Logger.b();
            String str2 = "setTopicSquareEntranceSwitch error result: " + i3 + ", errMsg: " + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            aa.e(str);
            this$0.switchOn.setValue(Boolean.valueOf(!z16));
            return;
        }
        this$0.switchOn.setValue(Boolean.valueOf(z16));
    }

    public final void changeSwitch(final boolean switchOn) {
        ((IGPSService) ch.R0(IGPSService.class)).setTopicSquareEntranceSwitch(Long.parseLong(this.guildId), switchOn, new dv() { // from class: hz1.a
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                GuildFeedSquareViewModel.changeSwitch$lambda$2(GuildFeedSquareViewModel.this, switchOn, i3, str, iGProSecurityResult);
            }
        });
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final MutableLiveData<Boolean> getSwitchOn() {
        return this.switchOn;
    }
}
