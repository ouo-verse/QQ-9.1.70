package com.tencent.qqnt.aio.refresher;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/bc;", "Lcom/tencent/qqnt/aio/refresher/be;", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "vasData", "", "d", "Landroid/content/res/Resources;", "res", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "data", "Landroid/graphics/drawable/Drawable;", "c", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class bc extends be {
    static IPatchRedirector $redirector_;

    public bc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.refresher.be
    @Nullable
    protected Drawable c(@NotNull Resources res, @NotNull AIOMsgItem msgItem, @NotNull VASPersonalNamePlate data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, this, res, msgItem, data);
        }
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(data, "data");
        return ((IVipIconExFactory) QRoute.api(IVipIconExFactory.class)).getIconForAIO(res, data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.aio.refresher.be
    public boolean d(@NotNull VASPersonalNamePlate vasData) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) vasData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(vasData, "vasData");
        if (!super.d(vasData) || (num = vasData.extendNamePlateId) == null) {
            return false;
        }
        if (num != null && num.intValue() == 0) {
            return false;
        }
        return true;
    }
}
