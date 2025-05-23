package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/utils/h;", "Li83/b;", "", "path", "Li83/a;", "avatarContext", "", "c", "a", "release", "Ljava/lang/String;", "missionID", "b", com.heytap.mcssdk.a.a.f36094d, "Lcom/tencent/biz/qqcircle/immersive/personal/utils/b;", "Lcom/tencent/biz/qqcircle/immersive/personal/utils/b;", "mUploadCallback", "<init>", "()V", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h implements i83.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String missionID = "QCIRCLE_" + UUID.randomUUID();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String taskID = QQWinkConstants.WinkPublishTaskID.XSJ_TOUXIANG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.utils.b mUploadCallback = new com.tencent.biz.qqcircle.immersive.personal.utils.b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/utils/h$b", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements WinkPublishHelper2.Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f89083b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i83.a f89084c;

        b(String str, i83.a aVar) {
            this.f89083b = str;
            this.f89084c = aVar;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            QLog.d("QCircleMagicAvatarModifyDelegate", 1, "avatarContext onServiceConnected...");
            com.tencent.biz.qqcircle.immersive.personal.utils.b bVar = h.this.mUploadCallback;
            if (bVar != null) {
                bVar.Z(this.f89084c);
                service.addTaskListener2(bVar);
            }
            ja0.a.f409680a.f(this.f89083b);
        }
    }

    private final void c(String path, i83.a avatarContext) {
        WinkPublishHelper2.INSTANCE.bindService(3, new b(path, avatarContext));
    }

    @Override // i83.b
    public void a(@NotNull i83.a avatarContext) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(avatarContext, "avatarContext");
        QLog.d("QCircleMagicAvatarModifyDelegate", 1, "avatarContext isSharingSelected..." + avatarContext.m4());
        String y75 = avatarContext.y7();
        QLog.d("QCircleMagicAvatarModifyDelegate", 1, "avatarContext getResultPath..." + y75);
        Bundle bundle = avatarContext.getBundle();
        boolean z16 = bundle.getBoolean("key_is_preview");
        String string = bundle.getString("key_old_file");
        String str3 = "";
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        String string2 = bundle.getString("key_video_file");
        if (string2 == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        QLog.d("QCircleMagicAvatarModifyDelegate", 1, "avatarContext isPreview..." + z16);
        if (z16) {
            IQQWinkLauncher iQQWinkLauncher = (IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class);
            Context H8 = avatarContext.H8();
            String str4 = this.missionID;
            String str5 = this.taskID;
            String QCIRCLE_AVATAR = QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_AVATAR;
            Intrinsics.checkNotNullExpressionValue(QCIRCLE_AVATAR, "QCIRCLE_AVATAR");
            iQQWinkLauncher.jumpToWinkEditorAfterProcessContent(H8, "QCIRCLE", str4, str, str2, null, str5, QCIRCLE_AVATAR, false);
            avatarContext.X5(false, null);
            return;
        }
        boolean z17 = bundle.getBoolean("key_can_sethead");
        String string3 = bundle.getString("key_qcircle_limit_tip");
        if (string3 != null) {
            str3 = string3;
        }
        if (!z17) {
            QCircleToast.w(QCircleToast.f91645e, str3, 0);
            QLog.e("QCircleMagicAvatarModifyDelegate", 1, "avatarContext cannot set , limitTip = " + str3);
            avatarContext.X5(false, null);
            return;
        }
        if (avatarContext.m4()) {
            IQQWinkLauncher iQQWinkLauncher2 = (IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class);
            Context H82 = avatarContext.H8();
            String str6 = this.missionID;
            String str7 = this.taskID;
            String QCIRCLE_AVATAR2 = QQWinkConstants.WinkLowLevelTemplateShareConstant.QCIRCLE_AVATAR;
            Intrinsics.checkNotNullExpressionValue(QCIRCLE_AVATAR2, "QCIRCLE_AVATAR");
            iQQWinkLauncher2.jumpToWinkEditorAfterProcessContent(H82, "QCIRCLE", str6, str, str2, null, str7, QCIRCLE_AVATAR2, true);
        }
        c(y75, avatarContext);
    }

    @Override // i83.b
    public void release() {
        com.tencent.biz.qqcircle.immersive.personal.utils.b bVar = this.mUploadCallback;
        if (bVar != null) {
            bVar.Z(null);
        }
        this.mUploadCallback = null;
    }
}
