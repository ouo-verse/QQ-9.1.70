package com.tencent.timi.game.api.remoteres.impl;

import android.content.Context;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.timi.game.api.remoteres.BizId;
import com.tencent.timi.game.api.remoteres.IZipResDownloadApi;
import com.tencent.timi.game.api.remoteres.ZipInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rf4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/timi/game/api/remoteres/impl/ZipResDownloadApiImpl;", "Lcom/tencent/timi/game/api/remoteres/IZipResDownloadApi;", "Landroid/content/Context;", "context", "Lcom/tencent/timi/game/api/remoteres/BizId;", "bizId", "Lcom/tencent/timi/game/api/remoteres/b;", "zipInfo", "Lcom/tencent/timi/game/api/remoteres/a;", "callback", "", "download", "Lrf4/h;", QDLog.TAG_DOWNLOAD, "Lrf4/h;", "<init>", "()V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ZipResDownloadApiImpl implements IZipResDownloadApi {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String TAG = "ZipResDownloadApiImpl";

    @NotNull
    private final h downloader = new h();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/api/remoteres/impl/ZipResDownloadApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/api/remoteres/impl/ZipResDownloadApiImpl$b", "Lrf4/h$b;", "", "a", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements h.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.api.remoteres.a f376310a;

        b(com.tencent.timi.game.api.remoteres.a aVar) {
            this.f376310a = aVar;
        }

        @Override // rf4.h.b
        public void a() {
            this.f376310a.a();
        }

        @Override // rf4.h.b
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            this.f376310a.onFailed(errorCode, errorMsg);
        }

        @Override // rf4.h.b
        public void onSuccess() {
            this.f376310a.onSuccess();
        }
    }

    @Override // com.tencent.timi.game.api.remoteres.IZipResDownloadApi
    public void download(@NotNull Context context, @NotNull BizId bizId, @NotNull ZipInfo zipInfo, @NotNull com.tencent.timi.game.api.remoteres.a callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(zipInfo, "zipInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.downloader.m(new h.ResInfo(zipInfo.getUrl(), zipInfo.getMd5(), rf4.a.a(context, bizId), rf4.a.b(context)), new b(callback));
    }
}
