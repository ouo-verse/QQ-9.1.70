package com.tencent.qqnt.markdown.data.multipic;

import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u000fB+\u0012\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/markdown/data/multipic/d;", "Lcom/tencent/qqnt/markdown/data/a;", "Lcom/tencent/android/androidbypass/viewgroup/c;", "extData", "Lcom/tencent/qqnt/markdown/data/d;", "options", "", "b", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/markdown/data/b;", "Lkotlin/collections/HashMap;", "dataMap", "<init>", "(Ljava/util/HashMap;)V", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends com.tencent.qqnt.markdown.data.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/markdown/data/multipic/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.data.multipic.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33030);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull HashMap<String, com.tencent.qqnt.markdown.data.b> dataMap) {
        super(dataMap);
        Intrinsics.checkNotNullParameter(dataMap, "dataMap");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dataMap);
        }
    }

    @Override // com.tencent.qqnt.markdown.data.a
    public void b(@NotNull com.tencent.android.androidbypass.viewgroup.c extData, @NotNull com.tencent.qqnt.markdown.data.d options) {
        Integer intOrNull;
        int i3;
        Integer intOrNull2;
        int i16;
        com.tencent.qqnt.markdown.data.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) extData, (Object) options);
            return;
        }
        Intrinsics.checkNotNullParameter(extData, "extData");
        Intrinsics.checkNotNullParameter(options, "options");
        String str = extData.a().get("itemsPerRow");
        if (str == null) {
            str = "";
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        int i17 = 0;
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        String str2 = extData.a().get("itemsNum");
        if (str2 == null) {
            str2 = "";
        }
        intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
        if (intOrNull2 != null) {
            i16 = intOrNull2.intValue();
        } else {
            i16 = 0;
        }
        if (!extData.c() && i16 == 0 && i3 == 0) {
            return;
        }
        com.tencent.qqnt.markdown.data.b a16 = a(extData);
        a16.n(new e());
        ArrayList arrayList = new ArrayList();
        if (!extData.c() && i16 > 0 && i3 > 0) {
            for (int i18 = 0; i18 < i16; i18++) {
                if (options.a() == 1) {
                    arrayList.add(ToastView.ICON_LOADING);
                } else {
                    arrayList.add("");
                }
            }
        } else {
            try {
                Iterator<T> it = extData.b().iterator();
                while (it.hasNext()) {
                    String queryParameter = Uri.parse((String) it.next()).getQueryParameter("picUrl");
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "it.getQueryParameter(\"picUrl\") ?: \"\"");
                    arrayList.add(queryParameter);
                }
            } catch (Exception e16) {
                QLog.i("MultiPicParser", 1, "[parse]: " + e16);
            }
        }
        if (i3 > 0) {
            i17 = 1;
        }
        if (i17 == 1) {
            cVar = new com.tencent.qqnt.markdown.data.c(arrayList, i17, i3);
        } else {
            cVar = new com.tencent.qqnt.markdown.data.c(arrayList, i17, 2);
        }
        a16.k(cVar);
    }
}
