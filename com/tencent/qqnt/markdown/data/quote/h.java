package com.tencent.qqnt.markdown.data.quote;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u000fB+\u0012\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/markdown/data/quote/h;", "Lcom/tencent/qqnt/markdown/data/a;", "Lcom/tencent/android/androidbypass/viewgroup/c;", "extData", "Lcom/tencent/qqnt/markdown/data/d;", "options", "", "b", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/markdown/data/b;", "Lkotlin/collections/HashMap;", "dataMap", "<init>", "(Ljava/util/HashMap;)V", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h extends com.tencent.qqnt.markdown.data.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/markdown/data/quote/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.data.quote.h$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull HashMap<String, com.tencent.qqnt.markdown.data.b> dataMap) {
        super(dataMap);
        Intrinsics.checkNotNullParameter(dataMap, "dataMap");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dataMap);
        }
    }

    @Override // com.tencent.qqnt.markdown.data.a
    public void b(@NotNull com.tencent.android.androidbypass.viewgroup.c extData, @NotNull com.tencent.qqnt.markdown.data.d options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) extData, (Object) options);
            return;
        }
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(options, "options");
        try {
            com.tencent.qqnt.markdown.data.b a16 = a(extData);
            a16.n(new i());
            String str = extData.a().get("text");
            if (str == null) {
                str = "";
            }
            String decode = URLDecoder.decode(str, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(decode, "decode(extData.attrMap.get(\"text\") ?: \"\", \"UTF-8\")");
            a16.o(decode);
            Iterator<T> it = extData.b().iterator();
            while (it.hasNext()) {
                Uri parse = Uri.parse((String) it.next());
                String queryParameter = parse.getQueryParameter("url");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                Intrinsics.checkNotNullExpressionValue(queryParameter, "it.getQueryParameter(\"url\") ?: \"\"");
                String queryParameter2 = parse.getQueryParameter("text");
                if (queryParameter2 == null) {
                    queryParameter2 = "";
                }
                Intrinsics.checkNotNullExpressionValue(queryParameter2, "it.getQueryParameter(\"text\") ?: \"\"");
                a16.f().add(new com.tencent.qqnt.markdown.data.e(queryParameter2, queryParameter));
            }
        } catch (Exception e16) {
            QLog.i("QuoteParser", 1, "[parse]: " + e16);
        }
    }
}
