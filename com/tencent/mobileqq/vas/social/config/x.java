package com.tencent.mobileqq.vas.social.config;

import android.widget.ImageView;
import com.tencent.mobileqq.nearbypro.api.INearbyProAvatarService;
import com.tencent.state.square.api.ISquareNearbyAvatarService;
import com.tencent.util.NumberUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/x;", "Lcom/tencent/state/square/api/ISquareNearbyAvatarService;", "Landroid/widget/ImageView;", "avatarView", "", "uin", "", "loadAvatarWithTinyId", "Lcom/tencent/mobileqq/nearbypro/api/INearbyProAvatarService;", "a", "Lcom/tencent/mobileqq/nearbypro/api/INearbyProAvatarService;", "nearbyProAvatarService", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class x implements ISquareNearbyAvatarService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final INearbyProAvatarService nearbyProAvatarService;

    public x() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(INearbyProAvatarService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        this.nearbyProAvatarService = (INearbyProAvatarService) runtimeService;
    }

    @Override // com.tencent.state.square.api.ISquareNearbyAvatarService
    public void loadAvatarWithTinyId(ImageView avatarView, String uin) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(uin, "uin");
        long stringToLong = NumberUtil.stringToLong(uin);
        if (stringToLong == 0) {
            return;
        }
        this.nearbyProAvatarService.loadAvatarForTinyId(avatarView, stringToLong);
    }
}
