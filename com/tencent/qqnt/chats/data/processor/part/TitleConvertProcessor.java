package com.tencent.qqnt.chats.data.processor.part;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.chats.api.IChatsTitleGetter;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.k;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/part/TitleConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", "", "a", "d", "", "originData", "b", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "update", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "Lkotlin/Lazy;", "c", "()Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "qqTextApi", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TitleConvertProcessor extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqTextApi;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/part/TitleConvertProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.data.processor.part.TitleConvertProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44853);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TitleConvertProcessor() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TitleConvertProcessor$qqTextApi$2.INSTANCE);
            this.qqTextApi = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(RecentContactInfo contact, com.tencent.qqnt.chats.data.converter.c params) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String currentUid = params.a().getCurrentUid();
        boolean z26 = false;
        if (currentUid != null && currentUid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && Intrinsics.areEqual(params.a().getCurrentUid(), contact.peerUid)) {
            z17 = true;
        } else {
            z17 = false;
        }
        String str = contact.remark;
        Intrinsics.checkNotNullExpressionValue(str, "contact.remark");
        if (str.length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 && !z17) {
            String str2 = contact.remark;
            Intrinsics.checkNotNullExpressionValue(str2, "contact.remark");
            return str2;
        }
        String str3 = contact.memberName;
        if (str3 != null && str3.length() != 0) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (!z19 && contact.chatType == 100) {
            String str4 = contact.memberName;
            Intrinsics.checkNotNullExpressionValue(str4, "contact.memberName");
            return str4;
        }
        String str5 = contact.peerName;
        Intrinsics.checkNotNullExpressionValue(str5, "contact.peerName");
        if (str5.length() > 0) {
            z26 = true;
        }
        if (z26) {
            String str6 = contact.peerName;
            Intrinsics.checkNotNullExpressionValue(str6, "contact.peerName");
            return str6;
        }
        return String.valueOf(contact.peerUin);
    }

    private final CharSequence b(CharSequence originData) {
        try {
            if (ChatsListConfig.f354433a.i()) {
                originData = IQQTextApi.a.c(c(), originData, 19, 16, null, null, 24, null);
            } else {
                originData = c().getQQTextPurePlainText(originData, 16);
            }
        } catch (Throwable unused) {
        }
        return originData;
    }

    private final IQQTextApi c() {
        return (IQQTextApi) this.qqTextApi.getValue();
    }

    private final String d(RecentContactInfo contact) {
        boolean z16;
        boolean z17;
        long j3 = contact.peerUin;
        String troopTitles = ((IChatsTitleGetter) QRoute.api(IChatsTitleGetter.class)).getTroopTitles(String.valueOf(j3));
        boolean z18 = false;
        if (troopTitles != null && troopTitles.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual(troopTitles, String.valueOf(j3))) {
            return troopTitles;
        }
        String str = contact.remark;
        Intrinsics.checkNotNullExpressionValue(str, "contact.remark");
        if (str.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            String str2 = contact.remark;
            Intrinsics.checkNotNullExpressionValue(str2, "contact.remark");
            return str2;
        }
        String str3 = contact.peerName;
        Intrinsics.checkNotNullExpressionValue(str3, "contact.peerName");
        if (str3.length() > 0) {
            z18 = true;
        }
        if (z18) {
            String str4 = contact.peerName;
            Intrinsics.checkNotNullExpressionValue(str4, "contact.peerName");
            return str4;
        }
        return String.valueOf(contact.peerUin);
    }

    private final void e(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        String a16;
        int i3 = item.s().chatType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    a16 = a(item.s(), params);
                } else {
                    a16 = d(item.s());
                }
            } else {
                a16 = d(item.s());
            }
        } else {
            a16 = a(item.s(), params);
        }
        item.w().i(b(a16).toString());
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
        e(item, params);
    }
}
