package com.tencent.qqnt.chats.data.converter;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/data/converter/e;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QZoneImageUtils.KEY_MATCH, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "update", "isFirst", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class e {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void update$default(e eVar, com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, c cVar, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            eVar.update(gVar, cVar, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
    }

    public abstract boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item);

    public abstract void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull c params);

    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull c params, boolean isFirst) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, item, params, Boolean.valueOf(isFirst));
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (isFirst) {
            update(item, params);
        }
    }
}
