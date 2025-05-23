package com.tencent.mobileqq.profilecard.bussiness.guide.action;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileGuideApi;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/action/ProfileGuideAction;", "", "app", "Lcom/tencent/common/app/AppInterface;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "(Lcom/tencent/common/app/AppInterface;Landroid/app/Activity;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;)V", "jumpLabelEdit", "", "jumpPhotoEdit", "jumpProfileEdit", "jumpSignEdit", "onAction", "guideId", "", "guideType", "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class ProfileGuideAction {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ProfileGuideAction";

    @NotNull
    private Activity activity;

    @NotNull
    private AppInterface app;

    @NotNull
    private ProfileCardInfo cardInfo;

    @NotNull
    private IComponentCenter componentCenter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/action/ProfileGuideAction$Companion;", "", "()V", "TAG", "", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18504);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ProfileGuideAction(@NotNull AppInterface app, @NotNull Activity activity, @NotNull ProfileCardInfo cardInfo, @NotNull IComponentCenter componentCenter) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        Intrinsics.checkNotNullParameter(componentCenter, "componentCenter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, app, activity, cardInfo, componentCenter);
            return;
        }
        this.app = app;
        this.activity = activity;
        this.cardInfo = cardInfo;
        this.componentCenter = componentCenter;
    }

    public final void jumpLabelEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IProfileGuideApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IProfileGuideApi::class.java)");
        ((IProfileGuideApi) api).jumpLabelEdit(this.componentCenter);
    }

    public final void jumpPhotoEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IProfileGuideApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IProfileGuideApi::class.java)");
        ((IProfileGuideApi) api).jumpPhotoEdit(this.activity, this.app.getCurrentUin(), true);
    }

    public final void jumpProfileEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IProfileGuideApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IProfileGuideApi::class.java)");
        ((IProfileGuideApi) api).jumpProfileEdit(this.app, this.activity, this.cardInfo);
    }

    public final void jumpSignEdit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IProfileGuideApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IProfileGuideApi::class.java)");
        ((IProfileGuideApi) api).jumpSignEdit(this.activity, this.cardInfo);
    }

    public final void onAction(int guideId, int guideType) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(guideId), Integer.valueOf(guideType));
            return;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("onAction guideId=%s guideType=%s", Arrays.copyOf(new Object[]{Integer.valueOf(guideId), Integer.valueOf(guideType)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(TAG, 2, format);
        }
        contains = ArraysKt___ArraysKt.contains(new Integer[]{1, 2, 3, 4, 5}, Integer.valueOf(guideId));
        if (contains) {
            jumpProfileEdit();
            return;
        }
        if (guideId == 7) {
            jumpSignEdit();
        } else if (guideId == 8) {
            jumpPhotoEdit();
        } else if (guideId == 9) {
            jumpLabelEdit();
        }
    }
}
