package com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo;

import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;
import tencent.im.oidb.cmd0x787.oidb_0x787$MsgNeedField;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopmemberinfo/a;", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "convertResultData", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class a implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopmemberinfo/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59472);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.f
    public void a(@NotNull com.tencent.mobileqq.nt.msgpush.factory.a convertResultData) {
        nt_im_msg_general_flags_body$ResvAttr g16;
        Map<String, Long> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) convertResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(convertResultData, "convertResultData");
        com.tencent.mobileqq.nt.msgpush.troop.processor.a b16 = convertResultData.b();
        if (b16 != null && (g16 = b16.g()) != null && g16.has() && g16.bytes_group_msg_busi_buf.has()) {
            oidb_0x787$MsgNeedField oidb_0x787_msgneedfield = new oidb_0x787$MsgNeedField();
            try {
                oidb_0x787_msgneedfield.mergeFrom(g16.bytes_group_msg_busi_buf.get().toByteArray());
                if (oidb_0x787_msgneedfield.uint32_cmduin_flagex3_grocery.has()) {
                    ITroopMemberExtDBApi iTroopMemberExtDBApi = (ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class);
                    String e16 = b16.e();
                    mapOf = MapsKt__MapsJVMKt.mapOf(new Pair(b16.h(), Long.valueOf(oidb_0x787_msgneedfield.uint32_cmduin_flagex3_grocery.get())));
                    iTroopMemberExtDBApi.updateTroopMemberFlagEx3(e16, mapOf, "FlagExt3Processor");
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }
}
