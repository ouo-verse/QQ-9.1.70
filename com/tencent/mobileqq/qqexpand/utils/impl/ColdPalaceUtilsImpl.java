package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.extendfriend.apollo.face.b;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/impl/ColdPalaceUtilsImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/IColdPalaceUtils;", "()V", "getColdPalaceHelper", "", "app", "Lcom/tencent/common/app/AppInterface;", "getFaceHeadDrawable", "Lcom/tencent/mobileqq/app/face/FaceDrawable;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "uin", "", "getSvrShowGrayTipEntry", "", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ColdPalaceUtilsImpl implements IColdPalaceUtils {
    @Override // com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils
    public Object getColdPalaceHelper(AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Manager manager = app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.ExpandManager");
        ColdPalaceHelper t06 = ((ExpandManager) manager).t0();
        Intrinsics.checkNotNullExpressionValue(t06, "extendFriendManager.coldPalaceHelper");
        return t06;
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils
    public FaceDrawable getFaceHeadDrawable(BaseQQAppInterface app, String uin) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uin, "uin");
        FaceDrawable d16 = b.d(app, uin);
        Intrinsics.checkNotNullExpressionValue(d16, "getFaceHeadDrawable(app, uin)");
        return d16;
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IColdPalaceUtils
    public boolean getSvrShowGrayTipEntry(AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Object coldPalaceHelper = getColdPalaceHelper(app);
        Intrinsics.checkNotNull(coldPalaceHelper, "null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper");
        return ((ColdPalaceHelper) coldPalaceHelper).getSvrShowGrayTipEntry();
    }
}
