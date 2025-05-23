package com.tencent.qqnt.chats.biz.gamebox.highlight;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.biz.summary.highlight.core.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.MsgBoxNecessaryMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/gamebox/highlight/a;", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/chats/biz/summary/highlight/core/b;", "a", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends com.tencent.qqnt.chats.biz.summary.highlight.core.a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.summary.highlight.core.a
    @Nullable
    public b a(@NotNull g item, @NotNull Context context, @NotNull AppRuntime appRuntime) {
        ArrayList<SpecificEventTypeInfoInMsgBox> arrayList;
        Object obj;
        ArrayList<MsgBoxNecessaryMsgInfo> arrayList2;
        Object orNull;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, this, item, context, appRuntime);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        if (item.n() != 116 || (arrayList = item.s().listOfSpecificEventTypeInfosInMsgBox) == null) {
            return null;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((SpecificEventTypeInfoInMsgBox) obj).eventTypeInMsgBox == 3000) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        SpecificEventTypeInfoInMsgBox specificEventTypeInfoInMsgBox = (SpecificEventTypeInfoInMsgBox) obj;
        if (specificEventTypeInfoInMsgBox != null && (arrayList2 = specificEventTypeInfoInMsgBox.msgInfos) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList2, 0);
            if (((MsgBoxNecessaryMsgInfo) orNull) == null) {
                return null;
            }
            b bVar = new b();
            bVar.e("[\u65b0\u6d88\u606f]");
            return bVar;
        }
        return null;
    }
}
