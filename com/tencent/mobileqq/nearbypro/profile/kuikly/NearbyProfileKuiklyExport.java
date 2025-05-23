package com.tencent.mobileqq.nearbypro.profile.kuikly;

import android.content.Context;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.KuiklyNearbyMineAvatarView;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.KuiklyNearbyProAvatarView;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.NBPKuiklyMapView;
import com.tencent.mobileqq.nearbypro.qqkuikly.view.NBPKuiklyQQEmojiView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e;
import i01.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/profile/kuikly/NearbyProfileKuiklyExport;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/e;", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "", "registerExternalModule", "registerExternalRenderView", "registerViewExternalPropHandler", "registerTDFlModule", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProfileKuiklyExport implements e {
    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerExternalModule(@NotNull b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        kuiklyRenderExport.a("NearbyProfileKuiklyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyExport$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new NearbyProfileKuiklyModule();
            }
        });
        kuiklyRenderExport.a("QQNearbyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyExport$registerExternalModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new QQNearbyModule();
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerExternalRenderView(@NotNull b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        b.a.a(kuiklyRenderExport, "NearbyMineAvatarView", new Function1<Context, c>() { // from class: com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyExport$registerExternalRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new KuiklyNearbyMineAvatarView(it);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "NearbyProAvatarView", new Function1<Context, c>() { // from class: com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyExport$registerExternalRenderView$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new KuiklyNearbyProAvatarView(it);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "NBPKuiklyMapView", new Function1<Context, c>() { // from class: com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyExport$registerExternalRenderView$1$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new NBPKuiklyMapView(it);
            }
        }, null, 4, null);
        b.a.a(kuiklyRenderExport, "NBPKuiklyQQEmojiView", new Function1<Context, c>() { // from class: com.tencent.mobileqq.nearbypro.profile.kuikly.NearbyProfileKuiklyExport$registerExternalRenderView$1$4
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new NBPKuiklyQQEmojiView(it);
            }
        }, null, 4, null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerTDFlModule(@NotNull b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e
    public void registerViewExternalPropHandler(@NotNull b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
    }
}
