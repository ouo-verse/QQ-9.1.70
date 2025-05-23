package com.tencent.mobileqq.guild.media.thirdapp.share;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGproGetOpenShareInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.fp;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.cr;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/g;", "", "", "queryString", "imageUrl", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/b;", "callback", "", tl.h.F, "sessionId", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/a;", "e", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/share/g$a;", "", "", "queryString", "imageUrl", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/b;", "callback", "", "b", "sessionId", "Lcom/tencent/mobileqq/guild/media/thirdapp/share/a;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.share.g$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String sessionId, @Nullable a callback) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            new g().e(sessionId, callback);
        }

        public final void b(@NotNull String queryString, @Nullable String imageUrl, @Nullable b callback) {
            Intrinsics.checkNotNullParameter(queryString, "queryString");
            new g().h(queryString, imageUrl, callback);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final a aVar, final int i3, String str, IGproGetOpenShareInfoRsp iGproGetOpenShareInfoRsp) {
        Logger.f235387a.d().d("GuildMediaFetchShareUseCase", 1, "[requestSessionIdInfo] result " + i3 + ", errMsg " + str);
        final String queryStr = iGproGetOpenShareInfoRsp.getQueryStr();
        if (queryStr == null) {
            queryStr = "";
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.share.d
            @Override // java.lang.Runnable
            public final void run() {
                g.g(a.this, i3, queryStr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(a aVar, int i3, String queryParam) {
        Intrinsics.checkNotNullParameter(queryParam, "$queryParam");
        if (aVar != null) {
            aVar.onResult(i3, queryParam);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final b bVar, final int i3, String str, IGproGetOpenShareInfoRsp iGproGetOpenShareInfoRsp) {
        Logger.f235387a.d().d("GuildMediaFetchShareUseCase", 1, "[requestShareInfo] result " + i3 + ", errMsg " + str);
        final String fileId = iGproGetOpenShareInfoRsp.getFileId();
        final String str2 = "";
        if (fileId == null) {
            fileId = "";
        }
        String sessionId = iGproGetOpenShareInfoRsp.getSessionId();
        if (sessionId != null) {
            str2 = sessionId;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.thirdapp.share.f
            @Override // java.lang.Runnable
            public final void run() {
                g.j(b.this, i3, fileId, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(b bVar, int i3, String fileId, String sessionId) {
        Intrinsics.checkNotNullParameter(fileId, "$fileId");
        Intrinsics.checkNotNullParameter(sessionId, "$sessionId");
        if (bVar != null) {
            bVar.onResult(i3, fileId, sessionId);
        }
    }

    public final void e(@NotNull String sessionId, @Nullable final a callback) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        IRuntimeService runtimeService = ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime()\n           \u2026va, ProcessConstant.MAIN)");
        fp fpVar = new fp();
        fpVar.h(sessionId);
        fpVar.g(2);
        ((IGPSService) runtimeService).getOpenShareInfo(fpVar, new cr() { // from class: com.tencent.mobileqq.guild.media.thirdapp.share.c
            @Override // wh2.cr
            public final void a(int i3, String str, IGproGetOpenShareInfoRsp iGproGetOpenShareInfoRsp) {
                g.f(a.this, i3, str, iGproGetOpenShareInfoRsp);
            }
        });
    }

    public final void h(@NotNull String queryString, @Nullable String imageUrl, @Nullable final b callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(queryString, "queryString");
        IRuntimeService runtimeService = ch.m().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime()\n           \u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        fp fpVar = new fp();
        fpVar.f(queryString);
        if (imageUrl != null && imageUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            fpVar.e(imageUrl);
        }
        fpVar.g(1);
        iGPSService.getOpenShareInfo(fpVar, new cr() { // from class: com.tencent.mobileqq.guild.media.thirdapp.share.e
            @Override // wh2.cr
            public final void a(int i3, String str, IGproGetOpenShareInfoRsp iGproGetOpenShareInfoRsp) {
                g.i(b.this, i3, str, iGproGetOpenShareInfoRsp);
            }
        });
    }
}
