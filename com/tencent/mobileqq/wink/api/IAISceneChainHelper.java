package com.tencent.mobileqq.wink.api;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IAISceneChainHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "path", "", "option", "Lcom/tencent/mobileqq/wink/model/a;", "detectAISceneChain", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "getAIDetectorVersion", "Companion", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IAISceneChainHelper extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f317954a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IAISceneChainHelper$a;", "", "", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "a", "()Ljava/util/List;", "REQUIRED_BUNDLES", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.api.IAISceneChainHelper$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f317954a = new Companion();

        Companion() {
        }

        @NotNull
        public final List<AEResInfo> a() {
            List<AEResInfo> listOf;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AEResInfo[]{AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE, AEResInfo.LIGHT_RES_BUNDLE_SCENE, AEResInfo.LIGHT_RES_FILAMENT, AEResInfo.LIGHT_RES_PAG, AEResInfo.LIGHT_RES_BASE_PACKAGE});
            return listOf;
        }
    }

    @Nullable
    com.tencent.mobileqq.wink.model.a detectAISceneChain(@NotNull Bitmap bitmap, int option);

    @Nullable
    com.tencent.mobileqq.wink.model.a detectAISceneChain(@NotNull String path, int option);

    int getAIDetectorVersion();
}
