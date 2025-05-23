package com.tencent.qqnt.chats.biz.publicaccount.part;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.biz.publicaccount.IPublicAccountChatsApi;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.k;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/part/d;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", "", "getDefaultTitle", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "update", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/part/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.publicaccount.part.d$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        if (item.n() == 30) {
            item.w().i(((IPublicAccountChatsApi) QRoute.api(IPublicAccountChatsApi.class)).getPublicAccountFolderName());
        } else {
            item.w().i(getDefaultTitle(item.s()));
        }
    }

    private final String getDefaultTitle(RecentContactInfo contact) {
        boolean z16;
        String str = contact.peerName;
        Intrinsics.checkNotNullExpressionValue(str, "contact.peerName");
        boolean z17 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String str2 = contact.peerName;
            Intrinsics.checkNotNullExpressionValue(str2, "contact.peerName");
            return str2;
        }
        String str3 = contact.sendNickName;
        Intrinsics.checkNotNullExpressionValue(str3, "contact.sendNickName");
        if (str3.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            String str4 = contact.sendNickName;
            Intrinsics.checkNotNullExpressionValue(str4, "contact.sendNickName");
            return str4;
        }
        return "";
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) payload)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof k;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        a(item);
    }
}
