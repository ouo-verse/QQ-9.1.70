package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/q;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgreply/d;", "", "objectType", "type", QCircleLpReportDc010001.KEY_SUBTYPE, "", "", "", "b", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "", "a", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class q implements com.tencent.mobileqq.aio.msglist.holder.component.msgreply.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/q$a;", "", "", "LIGHT_INTERACTION_TYPE", "Ljava/lang/String;", "OBJECT_TYPE", "SUB_LIGHT_INTERACTION_TYPE", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.biz.lightbusiness.lightinteraction.q$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29779);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, Object> b(int objectType, int type, int subType) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("object_type", Integer.valueOf(objectType)), TuplesKt.to("light_interaction_type", Integer.valueOf(type)), TuplesKt.to("sub_light_interaction_type", Integer.valueOf(subType)));
        return mapOf;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgreply.d
    public boolean a(@NotNull AIOMsgItem aioMsgItem) {
        com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioMsgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        v l06 = aioMsgItem.l0();
        if (l06 == null) {
            return false;
        }
        Object b16 = l06.b("lia_resource");
        Integer num = null;
        if (b16 instanceof com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) {
            bVar = (com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b) b16;
        } else {
            bVar = null;
        }
        Object b17 = l06.b("lia_object_type");
        if (b17 instanceof Integer) {
            num = (Integer) b17;
        }
        if (l06.a() == 0 || bVar == null || num == null) {
            return false;
        }
        com.tencent.mobileqq.aio.utils.b.q("em_bas_quick_reply_portal", b(num.intValue(), bVar.n(), bVar.m()));
        return true;
    }
}
