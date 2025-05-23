package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/IColdPalaceUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getColdPalaceHelper", "", "app", "Lcom/tencent/common/app/AppInterface;", "getFaceHeadDrawable", "Lcom/tencent/mobileqq/app/face/FaceDrawable;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "uin", "", "getSvrShowGrayTipEntry", "", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IColdPalaceUtils extends QRouteApi {
    @NotNull
    Object getColdPalaceHelper(@NotNull AppInterface app);

    @NotNull
    FaceDrawable getFaceHeadDrawable(@NotNull BaseQQAppInterface app, @NotNull String uin);

    boolean getSvrShowGrayTipEntry(@NotNull AppInterface app);
}
