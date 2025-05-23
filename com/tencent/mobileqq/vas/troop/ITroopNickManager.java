package com.tencent.mobileqq.vas.troop;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.nick.i;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/ITroopNickManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "scid", "Lcom/tencent/qqnt/aio/nick/i;", "drawInfo", "", NodeProps.MAX_WIDTH, "Lcom/tencent/qqnt/aio/nick/c;", "setCustomCloth", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ITroopNickManager extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ com.tencent.qqnt.aio.nick.c setCustomCloth$default(ITroopNickManager iTroopNickManager, long j3, i iVar, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = ViewUtils.dip2px(180.0f);
                }
                return iTroopNickManager.setCustomCloth(j3, iVar, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCustomCloth");
        }
    }

    @Nullable
    com.tencent.qqnt.aio.nick.c setCustomCloth(long scid, @NotNull i drawInfo, int maxWidth);
}
