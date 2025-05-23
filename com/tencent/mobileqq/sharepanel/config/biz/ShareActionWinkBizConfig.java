package com.tencent.mobileqq.sharepanel.config.biz;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/ShareActionWinkBizConfig;", "Lcom/tencent/mobileqq/sharepanel/config/biz/a;", "", "Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareActionWinkBizConfig implements a {
    static IPatchRedirector $redirector_;

    public ShareActionWinkBizConfig() {
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
        List<c> listOf6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM, "weixin", "weixincircle", "qqchannel"});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"save_to_phone", "favorite"});
            listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "weixin", "weixincircle", "qqchannel"});
            listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "weixin", "weixincircle", "qqchannel"});
            listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qzoneshuoshuo", "weixin", "weixincircle", "qqchannel"});
            listOf6 = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{new c("qzone_aixiaochuresult", listOf, listOf2, null, null, 24, null), new c("qzone_aixiaochu", listOf3, null, null, null, 28, null), new c("qzone_aimiaohui", listOf4, null, null, null, 28, null), new c("ai_touxiang", listOf5, null, null, null, 28, null)});
            return listOf6;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
