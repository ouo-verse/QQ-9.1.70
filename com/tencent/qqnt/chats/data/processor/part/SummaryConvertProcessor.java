package com.tencent.qqnt.chats.data.processor.part;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.i;
import com.tencent.qqnt.chats.view.api.ISummaryApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0014B\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/part/SummaryConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/biz/summary/msg/a;", "originSummary", "", "c", "", "originData", "b", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "update", "a", "Z", "forGroupHelper", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "Lkotlin/Lazy;", "()Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "qqTextApi", "<init>", "(Z)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class SummaryConvertProcessor extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean forGroupHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqTextApi;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/part/SummaryConvertProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.data.processor.part.SummaryConvertProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44840);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ SummaryConvertProcessor(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final IQQTextApi a() {
        return (IQQTextApi) this.qqTextApi.getValue();
    }

    private final CharSequence b(CharSequence originData) {
        boolean z16;
        int i3;
        try {
            com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
            if (!bVar.isPublicVersion() && !bVar.isGrayVersion()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !((ISummaryApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(ISummaryApi.class)).isSupportSummaryNickEmojiAnimation()) {
                i3 = 19;
                return IQQTextApi.a.c(a(), originData, i3, 16, null, null, 24, null);
            }
            i3 = 23;
            return IQQTextApi.a.c(a(), originData, i3, 16, null, null, 24, null);
        } catch (Throwable unused) {
            return originData;
        }
    }

    private final void c(Context context, com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.biz.summary.msg.a originSummary) {
        CharSequence summary = originSummary.d(context);
        item.v().m(originSummary);
        if (!item.q().getBoolean("is_first_data", false)) {
            g.e v3 = item.v();
            Intrinsics.checkNotNullExpressionValue(summary, "summary");
            v3.l(b(summary));
            com.tencent.qqnt.chats.biz.summary.msg.a g16 = item.v().g();
            if (g16 != null) {
                CharSequence strContent = g16.f354410d;
                Intrinsics.checkNotNullExpressionValue(strContent, "strContent");
                g16.f354410d = b(strContent);
                return;
            }
            return;
        }
        g.e v16 = item.v();
        Intrinsics.checkNotNullExpressionValue(summary, "summary");
        v16.l(summary);
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) payload)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof i;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        com.tencent.qqnt.chats.biz.summary.msg.a a16;
        Integer a17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.forGroupHelper) {
            a16 = com.tencent.qqnt.chats.biz.summary.msg.b.f354415a.b(item.s(), params.b(), params.a());
        } else {
            a16 = com.tencent.qqnt.chats.biz.summary.msg.b.f354415a.a(item, params.b(), params.a());
        }
        c(params.b(), item, a16);
        if (item.q().getBoolean("is_summary_need_highlight", true)) {
            com.tencent.qqnt.chats.biz.summary.highlight.core.c.f354404a.b(item, params);
        }
        if (!item.q().getBoolean("is_first_data", false) && (a17 = com.tencent.qqnt.chats.biz.summary.state.core.b.f354416a.a(item, params.b(), params.a())) != null) {
            a17.intValue();
            item.v().n(a17.intValue());
        }
    }

    public SummaryConvertProcessor(boolean z16) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
            return;
        }
        this.forGroupHelper = z16;
        lazy = LazyKt__LazyJVMKt.lazy(SummaryConvertProcessor$qqTextApi$2.INSTANCE);
        this.qqTextApi = lazy;
    }
}
