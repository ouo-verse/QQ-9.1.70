package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0003\u001a2\u0010\r\u001a\u00020\f*\u00020\u00062&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t`\n\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\u0006\u001a\n\u0010\u0010\u001a\u00020\u000e*\u00020\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "e", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/f;", "Landroid/graphics/drawable/Drawable;", "c", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "paramsMap", "", "a", "", "b", "d", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {
    public static final void a(g gVar, HashMap<String, Object> paramsMap) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter(paramsMap, "paramsMap");
        QQStrangerLIAItem u16 = QQStrangerLIAHelper.f245114a.u(new Contact(gVar.n(), gVar.k(), ""), 1);
        if (u16 != null && (gVar.x().b() <= 0 || d(u16))) {
            paramsMap.put("kl_type_id", String.valueOf(u16.getType()));
            paramsMap.put("kl_emoji_id", String.valueOf(u16.getResource().getEmojiId()));
        } else {
            paramsMap.put("kl_type_id", "");
            paramsMap.put("kl_emoji_id", "");
        }
    }

    public static final boolean b(g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        return QQStrangerLIAHelper.f245114a.u(new Contact(gVar.n(), gVar.k(), ""), 1) != null;
    }

    public static final Drawable c(QQStrangerLIAResource qQStrangerLIAResource) {
        Intrinsics.checkNotNullParameter(qQStrangerLIAResource, "<this>");
        if (qQStrangerLIAResource.getEmojiId() >= 0) {
            return QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.convertToLocal(qQStrangerLIAResource.getEmojiId()));
        }
        return null;
    }

    public static final boolean d(QQStrangerLIAItem qQStrangerLIAItem) {
        Intrinsics.checkNotNullParameter(qQStrangerLIAItem, "<this>");
        return qQStrangerLIAItem.getType() == 1 || qQStrangerLIAItem.getType() == 2;
    }

    public static final Contact e(QQStrangerLIAItem qQStrangerLIAItem) {
        Intrinsics.checkNotNullParameter(qQStrangerLIAItem, "<this>");
        return new Contact(qQStrangerLIAItem.getChatType(), String.valueOf(qQStrangerLIAItem.getPeerTinyId()), "");
    }
}
