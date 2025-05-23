package com.tencent.mobileqq.guild.mainframe;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/i;", "Lcom/tencent/mobileqq/guild/mainframe/a;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/mainframe/b$a", "Lcom/tencent/mobileqq/guild/mainframe/e;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "a", "Lcom/tencent/mobileqq/guild/mainframe/i;", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f227292a;

        a(i iVar) {
            this.f227292a = iVar;
        }

        @Override // com.tencent.mobileqq.guild.mainframe.a
        @NotNull
        public GuildFacadeType a() {
            GuildFacadeType a16 = this.f227292a.a();
            Intrinsics.checkNotNullExpressionValue(a16, "this@toContextProvider.guildFacadeType");
            return a16;
        }

        @Override // com.tencent.mobileqq.guild.mainframe.e
        @NotNull
        /* renamed from: b, reason: from getter */
        public i getF227292a() {
            return this.f227292a;
        }

        @Override // com.tencent.mobileqq.guild.mainframe.a
        @Nullable
        public QBaseActivity getActivity() {
            return this.f227292a.getActivity();
        }
    }

    @NotNull
    public static final com.tencent.mobileqq.guild.mainframe.a a(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<this>");
        return new a(iVar);
    }
}
