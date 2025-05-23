package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAInjectUtil;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/p;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/c;", "", "objectType", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", "b", "type", QCircleLpReportDc010001.KEY_SUBTYPE, "", "", "", "c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/f;", "extInfo", "", "a", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class p implements com.tencent.mobileqq.aio.msglist.holder.component.msgreply.c {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final LIAActionItem b(int objectType) {
        LIAActionItem lIAActionItem = new LIAActionItem();
        lIAActionItem.j(objectType);
        return lIAActionItem;
    }

    private final Map<String, Object> c(int objectType, int type, int subType) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("object_type", Integer.valueOf(objectType)), TuplesKt.to("light_interaction_type", Integer.valueOf(type)), TuplesKt.to("sub_light_interaction_type", Integer.valueOf(subType)));
        return mapOf;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgreply.c
    public boolean a(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgreply.f extInfo) {
        com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) extInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        if (extInfo.b().a() == 0) {
            return false;
        }
        Object b16 = extInfo.b().b("lia_resource");
        if (b16 instanceof com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) {
            bVar = (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) b16;
        } else {
            bVar = null;
        }
        Object b17 = extInfo.b().b("lia_object_type");
        if (b17 instanceof Integer) {
            num = (Integer) b17;
        } else {
            num = null;
        }
        if (bVar == null || num == null) {
            return false;
        }
        LIAInjectUtil.f353125a.h(null, LIAScene.AIO, new LIAInjectUtil.a(b(num.intValue()), bVar, extInfo.a(), null, false));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_quick_reply_portal", c(num.intValue(), bVar.n(), bVar.m()));
        return true;
    }
}
