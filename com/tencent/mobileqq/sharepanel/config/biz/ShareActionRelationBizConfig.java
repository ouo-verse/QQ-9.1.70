package com.tencent.mobileqq.sharepanel.config.biz;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/ShareActionRelationBizConfig;", "Lcom/tencent/mobileqq/sharepanel/config/biz/a;", "", "Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareActionRelationBizConfig implements a {
    static IPatchRedirector $redirector_;

    public ShareActionRelationBizConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.config.biz.a
    @NotNull
    public List<c> a() {
        List listOf;
        List listOf2;
        List listOf3;
        List listOf4;
        List listOf5;
        List listOf6;
        List listOf7;
        List listOf8;
        List<c> listOf9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "weixin", "weixincircle", "mypc"});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"save_to_phone", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK});
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "weixin", "weixincircle"});
            listOf4 = CollectionsKt__CollectionsJVMKt.listOf("save_to_phone");
            listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "weixin"});
            listOf6 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "weixin", "weixincircle"});
            listOf7 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"save_to_phone", "favorite", "avatar_switch_off", "avatar_switch_on"});
            listOf8 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"avatar_switch_off", "avatar_switch_on"});
            listOf9 = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{new c("relationship_qrcode", listOf, listOf2, null, null, 24, null), new c("relationship_close", listOf3, listOf4, null, null, 24, null), new c("relationship_recommend", listOf5, null, null, null, 28, null), new c("relationship_state", listOf6, listOf7, null, listOf8, 8, null)});
            return listOf9;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
