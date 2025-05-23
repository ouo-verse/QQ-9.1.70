package com.tencent.qqnt.chats.biz.publicaccount.part;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/part/PASummaryConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/g;", "", "originData", "b", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "update", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "a", "Lkotlin/Lazy;", "()Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "qqTextApi", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class PASummaryConvertProcessor extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqTextApi;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/part/PASummaryConvertProcessor$a;", "", "", "GRAB_COLOR_NICK", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.publicaccount.part.PASummaryConvertProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PASummaryConvertProcessor() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(PASummaryConvertProcessor$qqTextApi$2.INSTANCE);
            this.qqTextApi = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final IQQTextApi a() {
        return (IQQTextApi) this.qqTextApi.getValue();
    }

    private final CharSequence b(CharSequence originData) {
        try {
            return IQQTextApi.a.c(a(), originData, 19, 16, null, null, 24, null);
        } catch (Throwable unused) {
            return originData;
        }
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) payload)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof i;
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
        com.tencent.qqnt.chats.biz.summary.msg.a a16 = com.tencent.qqnt.chats.biz.summary.msg.b.f354415a.a(item, params.b(), params.a());
        CharSequence summary = a16.d(params.b());
        item.v().m(a16);
        if (!item.q().getBoolean("is_first_data", false)) {
            g.e v3 = item.v();
            Intrinsics.checkNotNullExpressionValue(summary, "summary");
            v3.l(b(summary));
            com.tencent.qqnt.chats.biz.summary.msg.a g16 = item.v().g();
            if (g16 != null) {
                CharSequence strContent = g16.f354410d;
                Intrinsics.checkNotNullExpressionValue(strContent, "strContent");
                g16.f354410d = b(strContent);
            }
        } else {
            g.e v16 = item.v();
            Intrinsics.checkNotNullExpressionValue(summary, "summary");
            v16.l(summary);
        }
        if (item.q().getBoolean("is_first_data", false)) {
            return;
        }
        com.tencent.qqnt.chats.biz.summary.highlight.core.c.f354404a.b(item, params);
        Integer a17 = com.tencent.qqnt.chats.biz.summary.state.core.b.f354416a.a(item, params.b(), params.a());
        if (a17 != null) {
            a17.intValue();
            item.v().n(a17.intValue());
        }
    }
}
