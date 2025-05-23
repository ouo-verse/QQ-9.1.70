package dr1;

import com.tencent.mobileqq.guild.base.RuntimeServiceHolder;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Ldr1/a;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "account", "", "onAccountChanged", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", "a", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "d", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder;", "serviceHolder", "Lnr1/a;", "e", "Lnr1/a;", "loadTask", "f", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", h.F, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "<init>", "()V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RuntimeServiceHolder serviceHolder = new RuntimeServiceHolder();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr1.a loadTask = new nr1.a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildFacadeType facadeType = GuildFacadeType.Tab;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FacadeArgsData facadeArgsData;

    public a() {
        AccountChangedNotifier.f214789d.a(this);
    }

    public final void a(@NotNull FacadeArgsData facadeArgsData, @NotNull GuildFacadeType facadeType) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        Intrinsics.checkNotNullParameter(facadeType, "facadeType");
        this.facadeArgsData = facadeArgsData;
        this.facadeType = facadeType;
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        this.serviceHolder = new RuntimeServiceHolder();
    }
}
