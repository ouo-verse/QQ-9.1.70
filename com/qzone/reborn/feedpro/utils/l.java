package com.qzone.reborn.feedpro.utils;

import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/l;", "", "", "a", "", "b", "c", "I", "getMAX_COVER_EXPAND_HEIGHT", "()I", "MAX_COVER_EXPAND_HEIGHT", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f54345a = new l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int MAX_COVER_EXPAND_HEIGHT = ef.d.b(100);

    l() {
    }

    public final String a() {
        if (QQTheme.isNowThemeIsNightForQzone()) {
            String config = CoverEnv.getConfig("QZoneSetting", QzoneCoverConst.SECOND_KEY_QZONE_DEFAULT_COVER_NIGHT, QzoneCoverConst.DEFAULT_COVER_NIGHT);
            Intrinsics.checkNotNullExpressionValue(config, "{\n            CoverEnv.g\u2026T\n            )\n        }");
            return config;
        }
        return "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/dazi/hashtag_bg/qecommerce_dazi_hashtag_Qzone-cover-day_v2.png";
    }

    public final int b() {
        return pl.a.f426446a.j();
    }

    public final int c() {
        return MAX_COVER_EXPAND_HEIGHT;
    }
}
