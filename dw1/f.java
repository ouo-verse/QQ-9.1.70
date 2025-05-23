package dw1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalPrivacySwitchGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.de;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\u00a8\u0006\u001d"}, d2 = {"Ldw1/f;", "Landroidx/lifecycle/ViewModel;", "", "switchType", "", "show", "Landroidx/lifecycle/MutableLiveData;", "liveData", "", "S1", "N1", "W1", "U1", "i", "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "publishedFeedShowSwitchLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Q1", "joinedGuildShowSwitchLiveData", "Lri1/a;", BdhLogUtil.LogTag.Tag_Conn, "P1", "guildError", "<init>", "()V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> publishedFeedShowSwitchLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> joinedGuildShowSwitchLiveData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ri1.a> guildError = new MutableLiveData<>();

    public f() {
        N1();
    }

    private final void N1() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchGlobalPrivacySwitch(new de() { // from class: dw1.d
            @Override // wh2.de
            public final void a(int i3, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
                f.O1(f.this, i3, str, iGProGlobalPrivacySwitchGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(f this$0, int i3, String str, IGProGlobalPrivacySwitchGroup switchGroup) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(switchGroup, "switchGroup");
        boolean z17 = true;
        Logger.f235387a.d().i("GuildProfileVisibilitySwitchesViewModel", 1, "fetchGlobalPrivacySwitch result: " + i3 + ", errMsg:" + str + ", roomState:" + switchGroup.getRoomStateShowSwitch() + ", feed:" + switchGroup.getPublishedFeedShowSwitch() + ", guild:" + switchGroup.getJoinedGuildShowSwitch());
        if (i3 != 0) {
            MutableLiveData<ri1.a> mutableLiveData = this$0.guildError;
            if (str == null) {
                str = "";
            }
            mutableLiveData.setValue(ri1.a.b(i3, str));
            return;
        }
        MutableLiveData<Boolean> mutableLiveData2 = this$0.publishedFeedShowSwitchLiveData;
        if (switchGroup.getPublishedFeedShowSwitch() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData2.setValue(Boolean.valueOf(z16));
        MutableLiveData<Boolean> mutableLiveData3 = this$0.joinedGuildShowSwitchLiveData;
        if (switchGroup.getJoinedGuildShowSwitch() != 2) {
            z17 = false;
        }
        mutableLiveData3.setValue(Boolean.valueOf(z17));
    }

    private final void S1(int switchType, final boolean show, final MutableLiveData<Boolean> liveData) {
        int i3;
        liveData.setValue(Boolean.valueOf(show));
        if (show) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).setGlobalPrivacySwitch(i3, switchType, new de() { // from class: dw1.e
            @Override // wh2.de
            public final void a(int i16, String str, IGProGlobalPrivacySwitchGroup iGProGlobalPrivacySwitchGroup) {
                f.T1(MutableLiveData.this, show, this, i16, str, iGProGlobalPrivacySwitchGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(MutableLiveData liveData, boolean z16, f this$0, int i3, String str, IGProGlobalPrivacySwitchGroup switchGroup) {
        Intrinsics.checkNotNullParameter(liveData, "$liveData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(switchGroup, "switchGroup");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "result = " + i3 + ", errMsg=" + str + ", switchGroup=" + switchGroup;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildProfileVisibilitySwitchesViewModel", 1, (String) it.next(), null);
            }
            liveData.setValue(Boolean.valueOf(!z16));
            MutableLiveData<ri1.a> mutableLiveData = this$0.guildError;
            if (str == null) {
                str = "";
            }
            mutableLiveData.setValue(ri1.a.b(i3, str));
        }
    }

    @NotNull
    public final MutableLiveData<ri1.a> P1() {
        return this.guildError;
    }

    @NotNull
    public final MutableLiveData<Boolean> Q1() {
        return this.joinedGuildShowSwitchLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> R1() {
        return this.publishedFeedShowSwitchLiveData;
    }

    public final void U1(boolean show) {
        S1(2, show, this.joinedGuildShowSwitchLiveData);
    }

    public final void W1(boolean show) {
        S1(3, show, this.publishedFeedShowSwitchLiveData);
    }
}
