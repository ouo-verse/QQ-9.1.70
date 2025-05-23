package com.tencent.mobileqq.matchfriend.aio.utils;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkView;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002\"\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"", "c", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "d", "Landroid/content/Context;", "ctx", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;", "e", "context", "model", "a", "b", "(Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;)Ljava/lang/String;", "lottieResUrl", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {
    private static final String a(Context context, QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        if (com.tencent.mobileqq.matchfriend.reborn.mark.c.f(qQStrangerInteractiveMarkModel)) {
            String string = context.getString(R.string.wz_);
            Intrinsics.checkNotNullExpressionValue(string, "{\n        context.getStr\u2026n_gain_mutual_mark)\n    }");
            return string;
        }
        String string2 = context.getString(R.string.wza);
        Intrinsics.checkNotNullExpressionValue(string2, "{\n        context.getStr\u2026pgrade_mutual_mark)\n    }");
        return string2;
    }

    public static final String b(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        return "https://downv6.qq.com/extendfriend/kl_confetti_flowers.json";
    }

    public static final String c() {
        a aVar = a.f243984a;
        return aVar.b(aVar.c(), "https://downv6.qq.com/extendfriend/kl_confetti_flowers.json", "lottie_");
    }

    public static final String d(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        a aVar = a.f243984a;
        return aVar.b(aVar.c(), com.tencent.mobileqq.matchfriend.reborn.mark.c.a(qQStrangerInteractiveMarkModel), "big_mutual_icon_");
    }

    public static final StrangerGainMutualMarkView.StrangerGainMutualMarkModel e(QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel, Context ctx) {
        Intrinsics.checkNotNullParameter(qQStrangerInteractiveMarkModel, "<this>");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        long j3 = qQStrangerInteractiveMarkModel.count;
        long j16 = qQStrangerInteractiveMarkModel.level;
        String d16 = d(qQStrangerInteractiveMarkModel);
        String string = ctx.getString(R.string.wzp, com.tencent.mobileqq.matchfriend.reborn.mark.c.c(qQStrangerInteractiveMarkModel));
        Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(\n         \u2026 getLevelName()\n        )");
        String a16 = a(ctx, qQStrangerInteractiveMarkModel);
        String c16 = c();
        long j17 = qQStrangerInteractiveMarkModel.level;
        return new StrangerGainMutualMarkView.StrangerGainMutualMarkModel(j3, j16, d16, "https://downv6.qq.com/extendfriend/stranger_mark_obtain_aperture.png", string, a16, c16, j17 == 1, j17 == 1, qQStrangerInteractiveMarkModel);
    }
}
