package com.tencent.mobileqq.teamwork.app;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.reshub.api.h;
import com.tencent.rdelivery.reshub.api.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJL\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022:\u0010\u000b\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/teamwork/app/DownLoadOfflinePackageFromShiplyHelper;", "", "", "bid", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "", "callback", "b", "a", "<init>", "()V", "OfflineFetcher", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class DownLoadOfflinePackageFromShiplyHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DownLoadOfflinePackageFromShiplyHelper f291873a = new DownLoadOfflinePackageFromShiplyHelper();

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004JB\u0010\u000e\u001a\u00020\f2:\u0010\r\u001a6\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006JB\u0010\u0010\u001a\u00020\f2:\u0010\r\u001a6\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/teamwork/app/DownLoadOfflinePackageFromShiplyHelper$OfflineFetcher;", "", "", tl.h.F, "", "g", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "errMsg", "", "callback", "e", "filePath", "f", "Lcom/tencent/rdelivery/reshub/api/i;", "a", "Lcom/tencent/rdelivery/reshub/api/i;", "resHub", "b", "Ljava/lang/String;", "resId", "Lcom/tencent/rdelivery/reshub/api/g;", "c", "Lcom/tencent/rdelivery/reshub/api/g;", "latestResInfo", "d", "Z", "isLoading", "<init>", "(Lcom/tencent/rdelivery/reshub/api/i;Ljava/lang/String;)V", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class OfflineFetcher {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.rdelivery.reshub.api.i resHub;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String resId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.rdelivery.reshub.api.g latestResInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isLoading;

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/teamwork/app/DownLoadOfflinePackageFromShiplyHelper$OfflineFetcher$b", "Lcom/tencent/rdelivery/reshub/api/h;", "", "isSuccess", "Lcom/tencent/rdelivery/reshub/api/g;", "result", "Lcom/tencent/rdelivery/reshub/api/n;", "error", "", "onComplete", "tencentdoc-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes18.dex */
        public static final class b implements com.tencent.rdelivery.reshub.api.h {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function2<Boolean, String, Unit> f291880b;

            /* JADX WARN: Multi-variable type inference failed */
            b(Function2<? super Boolean, ? super String, Unit> function2) {
                this.f291880b = function2;
            }

            @Override // com.tencent.rdelivery.reshub.api.h
            public void onComplete(boolean isSuccess, @Nullable com.tencent.rdelivery.reshub.api.g result, @NotNull com.tencent.rdelivery.reshub.api.n error) {
                Long l3;
                String str;
                String str2;
                Intrinsics.checkNotNullParameter(error, "error");
                com.tencent.rdelivery.reshub.api.g gVar = OfflineFetcher.this.latestResInfo;
                OfflineFetcher.this.latestResInfo = result;
                if (gVar != null) {
                    l3 = Long.valueOf(gVar.getVersion());
                } else {
                    l3 = null;
                }
                QLog.i("DownLoadOfflinePackageFromShiplyHelper OfflineFetcher", 2, "OfflineFetcher fetchRes currentVersion " + l3);
                long h16 = OfflineFetcher.this.h();
                if (l3 == null || l3.longValue() != h16) {
                    if (gVar != null) {
                        str = gVar.getTaskId();
                    } else {
                        str = null;
                    }
                    if (gVar != null) {
                        str2 = gVar.getResId();
                    } else {
                        str2 = null;
                    }
                    QLog.i("DownLoadOfflinePackageFromShiplyHelper OfflineFetcher", 2, "OfflineFetcher fetchRes currentTaskId " + str + ", currentResId" + str2);
                    if (str2 != null && str != null) {
                        QLog.i("DownLoadOfflinePackageFromShiplyHelper OfflineFetcher", 2, "OfflineFetcher fetchRes deleteSpecificTaskRes " + str);
                        OfflineFetcher.this.resHub.h(str2, Long.parseLong(str));
                    }
                }
                OfflineFetcher.this.isLoading = false;
                if (isSuccess && result != null) {
                    Function2<Boolean, String, Unit> function2 = this.f291880b;
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, null);
                        return;
                    }
                    return;
                }
                Function2<Boolean, String, Unit> function22 = this.f291880b;
                if (function22 != null) {
                    function22.invoke(Boolean.FALSE, "fetchRes error: " + error.b() + ", " + error.message());
                }
            }

            @Override // com.tencent.rdelivery.reshub.api.h
            public void onProgress(float f16) {
                h.a.a(this, f16);
            }
        }

        public OfflineFetcher(@NotNull com.tencent.rdelivery.reshub.api.i resHub, @NotNull String resId) {
            Intrinsics.checkNotNullParameter(resHub, "resHub");
            Intrinsics.checkNotNullParameter(resId, "resId");
            this.resHub = resHub;
            this.resId = resId;
            this.latestResInfo = i.a.b(resHub, resId, false, 2, null);
        }

        public final void e(@Nullable Function2<? super Boolean, ? super String, Unit> callback) {
            if (this.isLoading) {
                if (callback != null) {
                    callback.invoke(Boolean.FALSE, "\u5f53\u524dbid " + this.resId + " \u6b63\u5728\u52a0\u8f7d\u4e2d");
                    return;
                }
                return;
            }
            this.isLoading = true;
            this.resHub.j(this.resId, new b(callback), false);
        }

        public final void f(@Nullable final Function2<? super Boolean, ? super String, Unit> callback) {
            boolean z16;
            long h16 = h();
            String g16 = g();
            QLog.i("DownLoadOfflinePackageFromShiplyHelper OfflineFetcher", 2, "getFilePath " + g16);
            if (h16 > 0) {
                if (g16 != null && g16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (callback != null) {
                        callback.invoke(Boolean.TRUE, g16);
                    }
                    e(null);
                    return;
                }
            }
            e(new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.teamwork.app.DownLoadOfflinePackageFromShiplyHelper$OfflineFetcher$getFilePath$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, @Nullable String str) {
                    if (z17) {
                        Function2<Boolean, String, Unit> function2 = callback;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE, this.g());
                            return;
                        }
                        return;
                    }
                    Function2<Boolean, String, Unit> function22 = callback;
                    if (function22 != null) {
                        function22.invoke(Boolean.FALSE, str);
                    }
                }
            });
        }

        @Nullable
        public final String g() {
            String str;
            com.tencent.rdelivery.reshub.api.g gVar = this.latestResInfo;
            if (gVar != null) {
                str = gVar.e();
            } else {
                str = null;
            }
            QLog.i("DownLoadOfflinePackageFromShiplyHelper OfflineFetcher", 2, "OfflineFetcher getLocalFilePath localFilePath " + str);
            return str;
        }

        public final long h() {
            long j3;
            com.tencent.rdelivery.reshub.api.g gVar = this.latestResInfo;
            if (gVar != null) {
                j3 = gVar.getVersion();
            } else {
                j3 = -1;
            }
            QLog.i("DownLoadOfflinePackageFromShiplyHelper OfflineFetcher", 2, "OfflineFetcher getResVersion resVersion " + j3);
            return j3;
        }
    }

    DownLoadOfflinePackageFromShiplyHelper() {
    }

    @Nullable
    public final String a(@NotNull String bid) {
        boolean z16;
        Intrinsics.checkNotNullParameter(bid, "bid");
        QLog.i("DownLoadOfflinePackageFromShiplyHelper", 2, "loadOfflinePackage getOfflineResourcePath bid " + bid);
        OfflineFetcher offlineFetcher = new OfflineFetcher(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance(), bid);
        String g16 = offlineFetcher.g();
        if (offlineFetcher.h() > 0) {
            if (g16 != null && g16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                offlineFetcher.e(null);
                return g16;
            }
        }
        return null;
    }

    public final void b(@Nullable final String bid, @Nullable final Function2<? super Boolean, ? super String, Unit> callback) {
        boolean z16;
        QLog.i("DownLoadOfflinePackageFromShiplyHelper", 2, "loadOfflinePackage bid " + bid);
        if (bid != null && bid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.invoke(Boolean.FALSE, "loadOfflinePackage fail, bid " + bid + " isEmpty");
                return;
            }
            return;
        }
        new OfflineFetcher(((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance(), bid).f(new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.teamwork.app.DownLoadOfflinePackageFromShiplyHelper$loadOfflinePackage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17, @Nullable String str) {
                QLog.i("DownLoadOfflinePackageFromShiplyHelper", 2, "loadOfflinePackage start");
                if (z17) {
                    if (!(str == null || str.length() == 0)) {
                        QLog.i("DownLoadOfflinePackageFromShiplyHelper", 2, "loadOfflinePackage success bid " + bid + " filePath: " + str);
                        Function2<Boolean, String, Unit> function2 = callback;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE, null);
                            return;
                        }
                        return;
                    }
                }
                Function2<Boolean, String, Unit> function22 = callback;
                if (function22 != null) {
                    function22.invoke(Boolean.FALSE, "loadOfflinePackage bid " + bid + " fail: " + str);
                }
            }
        });
    }
}
