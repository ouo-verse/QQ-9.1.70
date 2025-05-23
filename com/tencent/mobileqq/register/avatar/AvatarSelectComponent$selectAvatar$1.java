package com.tencent.mobileqq.register.avatar;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "avatarInfoList", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "isUpdate", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class AvatarSelectComponent$selectAvatar$1 extends Lambda implements Function2<List<? extends ZPlanAvatarInfo>, Boolean, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AvatarSelectComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarSelectComponent$selectAvatar$1(AvatarSelectComponent avatarSelectComponent) {
        super(2);
        this.this$0 = avatarSelectComponent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) avatarSelectComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AvatarSelectComponent this$0, List avatarInfoList) {
        h hVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(avatarInfoList, "$avatarInfoList");
        if (!this$0.e().isFinishing() || !this$0.e().isDestroyed()) {
            try {
                hVar = this$0.avatarSelectorDialog;
                if (hVar != null) {
                    hVar.g0(avatarInfoList);
                }
            } catch (Exception e16) {
                QLog.e("AvatarSelectComponent", 1, "updateZplanAvatarList error:" + e16);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZPlanAvatarInfo> list, Boolean bool) {
        invoke((List<ZPlanAvatarInfo>) list, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final List<ZPlanAvatarInfo> avatarInfoList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, avatarInfoList, Boolean.valueOf(z16));
            return;
        }
        Intrinsics.checkNotNullParameter(avatarInfoList, "avatarInfoList");
        if (z16) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final AvatarSelectComponent avatarSelectComponent = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.register.avatar.a
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarSelectComponent$selectAvatar$1.b(AvatarSelectComponent.this, avatarInfoList);
                }
            });
        }
    }
}
