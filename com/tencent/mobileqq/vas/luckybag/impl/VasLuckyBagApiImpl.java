package com.tencent.mobileqq.vas.luckybag.impl;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.kuikly.api.IVasKuiklyLogicApi;
import com.tencent.mobileqq.vas.luckybag.IVasLuckyBagApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s13.KuikLyConfig;
import w13.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/luckybag/impl/VasLuckyBagApiImpl;", "Lcom/tencent/mobileqq/vas/luckybag/IVasLuckyBagApi;", "()V", "handleLuckyBag", "", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "sendUin", "", "vas_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasLuckyBagApiImpl implements IVasLuckyBagApi {
    @Override // com.tencent.mobileqq.vas.luckybag.IVasLuckyBagApi
    public void handleLuckyBag(@NotNull Contact contact, long sendUin) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        int i3 = contact.chatType;
        int i16 = 2;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            } else {
                i16 = 4;
            }
        }
        if (!a.f444413a.e()) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = "";
        linkedHashMap.put("ark_id", "");
        linkedHashMap.put("scene", String.valueOf(i16));
        linkedHashMap.put(PhotoCacheData.OWNER_UIN, String.valueOf(sendUin));
        if (i16 == 4) {
            str = contact.peerUid;
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (scene == 4) contact.peerUid else \"\"");
        linkedHashMap.put("group_id", str);
        ((IVasKuiklyLogicApi) QRoute.api(IVasKuiklyLogicApi.class)).openLucky(new KuikLyConfig("LuckyLogicPage", "vas_lucky_bag", "openLuckyBag", linkedHashMap));
    }
}
