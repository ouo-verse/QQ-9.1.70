package com.tencent.mobileqq.aio.animation.egg;

import android.os.Handler;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.data.d;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J`\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0010j\b\u0012\u0004\u0012\u00020\f`\u00112\u0006\u0010\u0013\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\u0014H&J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&R\u0014\u0010\u001c\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/egg/c;", "", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/os/Handler;", "uiHandler", "Lcom/tencent/mobileqq/aio/animation/data/b;", "message", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", "animContainer", "", "delayTime", "Lcom/tencent/mobileqq/aio/animation/config/a;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "isNewMsg", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "rulesMatched", "index", "", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/animation/data/d;", "sessionInfo", "b", "getBizType", "()I", "bizType", "c", "playScope", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface c {
    void a(@NotNull BaseQQAppInterface app, @NotNull Handler uiHandler, @NotNull com.tencent.mobileqq.aio.animation.data.b message, @NotNull AIOAnimationContainer animContainer, int delayTime, @NotNull com.tencent.mobileqq.aio.animation.config.a rule, boolean isNewMsg, @NotNull ArrayList<com.tencent.mobileqq.aio.animation.config.a> rulesMatched, int index);

    void b(@NotNull com.tencent.mobileqq.aio.animation.data.b message, @NotNull BaseQQAppInterface app, @NotNull d sessionInfo);

    int c();

    int getBizType();

    void onDestroy();
}
