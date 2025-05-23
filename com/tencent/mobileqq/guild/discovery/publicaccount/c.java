package com.tencent.mobileqq.guild.discovery.publicaccount;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b*\u0001\u000e\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/publicaccount/c;", "Lef1/b;", "", "onCleared", "", "account", "onAccountChanged", "Lcom/tencent/mobileqq/guild/util/cn;", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/util/cn;", "N1", "()Lcom/tencent/mobileqq/guild/util/cn;", "themeChangedLiveData", "com/tencent/mobileqq/guild/discovery/publicaccount/c$b", "D", "Lcom/tencent/mobileqq/guild/discovery/publicaccount/c$b;", "mThemeChangedCallback", "Landroidx/lifecycle/MutableLiveData;", "", "E", "Landroidx/lifecycle/MutableLiveData;", "c2cUnReadCntLiveData", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final cn<Boolean> themeChangedLiveData = new cn<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b mThemeChangedCallback;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> c2cUnReadCntLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/discovery/publicaccount/c$b", "Lcom/tencent/mobileqq/guild/theme/d;", "", "onThemeChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.theme.d {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.theme.d
        public void onThemeChanged() {
            c.this.N1().setValue(Boolean.valueOf(GuildThemeManager.f235286a.b()));
        }
    }

    public c() {
        b bVar = new b();
        this.mThemeChangedCallback = bVar;
        GuildThemeManager.g(bVar);
        this.c2cUnReadCntLiveData = new MutableLiveData<>();
    }

    @NotNull
    public final cn<Boolean> N1() {
        return this.themeChangedLiveData;
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.c2cUnReadCntLiveData.setValue(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        GuildThemeManager.j(this.mThemeChangedCallback);
    }
}
