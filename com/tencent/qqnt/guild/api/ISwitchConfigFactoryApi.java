package com.tencent.qqnt.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/guild/api/ISwitchConfigFactoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "tabName", "freesiaName", "Lax3/a;", OperateCustomButton.OPERATE_CREATE, "defaultSwitch", "appId", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface ISwitchConfigFactoryApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/guild/api/ISwitchConfigFactoryApi$a$a", "Lax3/a;", "", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.guild.api.ISwitchConfigFactoryApi$a$a, reason: collision with other inner class name */
        /* loaded from: classes24.dex */
        public static final class C9629a implements ax3.a {
            C9629a() {
            }

            @Override // ax3.a
            @NotNull
            /* renamed from: a */
            public String getF356919a() {
                return "0";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/guild/api/ISwitchConfigFactoryApi$a$b", "Lax3/a;", "", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes24.dex */
        public static final class b implements ax3.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f356919a;

            b(String str) {
                this.f356919a = str;
            }

            @Override // ax3.a
            @NotNull
            /* renamed from: a, reason: from getter */
            public String getF356919a() {
                return this.f356919a;
            }
        }

        @NotNull
        public static ax3.a a(@NotNull ISwitchConfigFactoryApi iSwitchConfigFactoryApi, @NotNull String tabName, @NotNull String freesiaName) {
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            Intrinsics.checkNotNullParameter(freesiaName, "freesiaName");
            return new C9629a();
        }

        @NotNull
        public static ax3.a b(@NotNull ISwitchConfigFactoryApi iSwitchConfigFactoryApi, @NotNull String tabName, @NotNull String freesiaName, @NotNull String defaultSwitch, @NotNull String appId) {
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            Intrinsics.checkNotNullParameter(freesiaName, "freesiaName");
            Intrinsics.checkNotNullParameter(defaultSwitch, "defaultSwitch");
            Intrinsics.checkNotNullParameter(appId, "appId");
            return new b(defaultSwitch);
        }
    }

    @NotNull
    ax3.a create(@NotNull String tabName, @NotNull String freesiaName);

    @NotNull
    ax3.a create(@NotNull String tabName, @NotNull String freesiaName, @NotNull String defaultSwitch, @NotNull String appId);
}
