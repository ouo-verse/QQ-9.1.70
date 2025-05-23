package com.tencent.qqnt.aio.refresher;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconClick;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconSwitch;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASAIOPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/be;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/VASPersonalNamePlate;", "vasData", "", "d", "Landroid/content/res/Resources;", "res", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "data", "Landroid/graphics/drawable/Drawable;", "c", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class be extends com.tencent.mobileqq.aio.msglist.holder.external.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/be$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.refresher.be$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60589);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public be() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.d
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        VASPersonalNamePlate vASPersonalNamePlate;
        Object obj;
        VASAIOPersonalElement vASAIOPersonalElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof bf)) {
            return;
        }
        bf bfVar = (bf) request;
        AIOMsgItem a16 = bfVar.a();
        boolean z16 = true;
        MsgAttributeInfo msgAttributeInfo = a16.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo != null && (vASAIOPersonalElement = msgAttributeInfo.vasPersonalInfo) != null) {
            vASPersonalNamePlate = vASAIOPersonalElement.vasPersonalNamePlate;
        } else {
            vASPersonalNamePlate = null;
        }
        if (vASPersonalNamePlate != null && d(vASPersonalNamePlate)) {
            Resources resources = BaseApplication.context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            Drawable c16 = c(resources, a16, vASPersonalNamePlate);
            if (c16 == null) {
                if (QLog.isDebugVersion()) {
                    QLog.i("VipIconDrawableLoader", 4, "[getData]: msgId is " + a16.getMsgId() + ", drawable is null");
                    return;
                }
                return;
            }
            bfVar.c(new bg(c16));
            return;
        }
        if (QLog.isDebugVersion()) {
            long msgId = a16.getMsgId();
            if (vASPersonalNamePlate == null) {
                z16 = false;
            }
            if (vASPersonalNamePlate != null) {
                obj = Boolean.valueOf(d(vASPersonalNamePlate));
            } else {
                obj = "";
            }
            QLog.i("VipIconDrawableLoader", 4, "[getData]: msgId is " + msgId + ", data[" + z16 + "] " + obj);
        }
    }

    @Nullable
    protected Drawable c(@NotNull Resources res, @NotNull AIOMsgItem msgItem, @NotNull VASPersonalNamePlate data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, this, res, msgItem, data);
        }
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(data, "data");
        com.tencent.mobileqq.vas.image.c iconForAIO = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIconForAIO(res, data);
        if (iconForAIO != null) {
            IVipIconClick iVipIconClick = (IVipIconClick) QRoute.api(IVipIconClick.class);
            Integer num = data.namePlateId;
            Intrinsics.checkNotNullExpressionValue(num, "data.namePlateId");
            iVipIconClick.report04586(num.intValue(), false, "VIA_TROOP_AIO_MSG");
            return iconForAIO;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(@NotNull VASPersonalNamePlate vasData) {
        Integer num;
        Integer num2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) vasData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(vasData, "vasData");
        Integer num3 = vasData.isGray;
        if ((num3 != null && (num3 == null || num3.intValue() != 0)) || (num = vasData.namePlateId) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(num, "vasData.namePlateId");
        if (num.intValue() < 0 || !((IVipIconSwitch) QRoute.api(IVipIconSwitch.class)).showInGroup() || SimpleUIUtil.isNowSimpleMode()) {
            return false;
        }
        Integer num4 = vasData.vipStarFlag;
        if (num4 != null && num4.intValue() == 1) {
            return true;
        }
        Integer num5 = vasData.vipType;
        if ((num5 == null || num5.intValue() != 3) && ((num2 = vasData.vipType) == null || num2.intValue() != 259)) {
            return false;
        }
        return true;
    }
}
