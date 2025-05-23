package com.tencent.mobileqq.wink.preview;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.constant.PhotoWallConstant;
import com.tencent.mobileqq.wink.preview.viewmodel.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0014R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/WinkPhotoWallHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "handleGetPhotoWall", "onReceive", "", "", "getCommandList", "uin", "attachInfo", "getQzonePhotoWall", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkPhotoWallHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface app;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkPhotoWallHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
    }

    private final void handleGetPhotoWall(ToServiceMsg req, FromServiceMsg res, Object data) {
        mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar;
        boolean z16;
        Object attribute = req.getAttribute("uin");
        Intrinsics.checkNotNull(attribute, "null cannot be cast to non-null type kotlin.String");
        String str = (String) attribute;
        Object attribute2 = req.getAttribute("attachInfo");
        Intrinsics.checkNotNull(attribute2, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) attribute2;
        if (res.isSuccess() && (data instanceof mobile_sub_get_photo_wall_rsp)) {
            mobile_sub_get_photo_wall_rspVar = (mobile_sub_get_photo_wall_rsp) data;
            AppInterface appInterface = this.app;
            Intrinsics.checkNotNull(appInterface);
            EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            Intrinsics.checkNotNullExpressionValue(createEntityManager, "app!!.entityManagerFactory.createEntityManager()");
            QZonePhotoWall qZonePhotoWall = (QZonePhotoWall) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) QZonePhotoWall.class, str);
            if (qZonePhotoWall == null) {
                qZonePhotoWall = new QZonePhotoWall();
                qZonePhotoWall.uin = str;
            }
            qZonePhotoWall.updateQzonePhotoWall(str2, mobile_sub_get_photo_wall_rspVar);
            if (qZonePhotoWall.getStatus() == 1000) {
                createEntityManager.persist(qZonePhotoWall);
            } else {
                createEntityManager.update(qZonePhotoWall);
            }
            createEntityManager.close();
            z16 = true;
        } else {
            mobile_sub_get_photo_wall_rspVar = null;
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WinkPhotoWallHandler", 2, "handleGetPhotoWall isSuc:" + z16);
        }
        notifyUI(1, z16, new Object[]{str2, mobile_sub_get_photo_wall_rspVar, str});
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(PhotoWallConstant.CMD_GET_PHOTO_WALL);
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    public void getQzonePhotoWall(@NotNull String uin, @Nullable String attachInfo) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (QLog.isColorLevel()) {
            QLog.d("WinkPhotoWallHandler", 2, "getQzonePhotoWall uin:" + uin);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(PhotoWallConstant.CMD_GET_PHOTO_WALL);
        createToServiceMsg.addAttribute("uin", uin);
        createToServiceMsg.addAttribute("attachInfo", attachInfo);
        send(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @Nullable
    protected Class<? extends BusinessObserver> observerClass() {
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        Intrinsics.checkNotNull(res);
        String serviceCmd = res.getServiceCmd();
        if (!msgCmdFilter(serviceCmd) && Intrinsics.areEqual(PhotoWallConstant.CMD_GET_PHOTO_WALL, serviceCmd)) {
            Intrinsics.checkNotNull(req);
            Intrinsics.checkNotNull(data);
            handleGetPhotoWall(req, res, data);
        }
    }
}
