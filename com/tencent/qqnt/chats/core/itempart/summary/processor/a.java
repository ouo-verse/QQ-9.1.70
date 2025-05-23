package com.tencent.qqnt.chats.core.itempart.summary.processor;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.utils.ChatsColorCache;
import com.tencent.qqnt.chats.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\rH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/summary/processor/a;", "Lcom/tencent/qqnt/chats/inject/summary/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g$e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/view/a;", "view", "", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "c", "Landroid/content/Context;", "context", "d", "Landroid/view/View;", "a", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends com.tencent.qqnt.chats.inject.summary.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/core/itempart/summary/processor/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.core.itempart.summary.processor.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46834);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(g.e item, com.tencent.qqnt.chats.view.a view) {
        Boolean bool;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        com.tencent.qqnt.chats.biz.summary.msg.a g16 = item.g();
        Integer num = null;
        if (g16 != null) {
            bool = Boolean.valueOf(g16.f354412f);
        } else {
            bool = null;
        }
        com.tencent.qqnt.chats.biz.summary.msg.a g17 = item.g();
        if (g17 != null) {
            charSequence = g17.f354413g;
        } else {
            charSequence = null;
        }
        CharSequence charSequence4 = "";
        if (charSequence == null) {
            charSequence = "";
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE) && !TextUtils.isEmpty(charSequence)) {
            view.setSummaryContent(charSequence);
        } else {
            com.tencent.qqnt.chats.biz.summary.msg.a g18 = item.g();
            if (g18 != null) {
                charSequence2 = g18.f354410d;
            } else {
                charSequence2 = null;
            }
            if (charSequence2 == null) {
                charSequence2 = "";
            }
            view.setSummaryContent(charSequence2);
            com.tencent.qqnt.chats.biz.summary.msg.a g19 = item.g();
            if (g19 != null) {
                charSequence3 = g19.f354407a;
            } else {
                charSequence3 = null;
            }
            if (charSequence3 != null) {
                charSequence4 = charSequence3;
            }
            view.setSummaryNick(charSequence4);
            com.tencent.qqnt.chats.biz.summary.msg.a g26 = item.g();
            if (g26 != null) {
                num = Integer.valueOf(g26.f354408b);
            }
            view.setSummarySendStatus(num);
        }
        view.setSummaryAllContent(item.f());
    }

    private final void c(g item, com.tencent.qqnt.chats.view.a view) {
        Integer d16 = item.v().d();
        String e16 = item.v().e();
        BaseApplication context = BaseApplication.getContext();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(e16);
        ChatsColorCache chatsColorCache = ChatsColorCache.f355526a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int defaultColor = chatsColorCache.g(context).getDefaultColor();
        if (d16 != null) {
            defaultColor = d16.intValue();
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(defaultColor), 0, e16.length(), 33);
        view.setSummaryPrefix(spannableStringBuilder);
    }

    private final void d(Context context, g.e item, com.tencent.qqnt.chats.view.a view) {
        view.setSummaryStatus(c.f355544a.b(context, item.h()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.chats.inject.summary.a
    public void a(@NotNull g item, @NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof com.tencent.qqnt.chats.view.a)) {
            return;
        }
        g.e v3 = item.v();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        com.tencent.qqnt.chats.view.a aVar = (com.tencent.qqnt.chats.view.a) view;
        d(context, v3, aVar);
        c(item, aVar);
        b(v3, aVar);
    }
}
