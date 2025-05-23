package com.tencent.qqnt.aio.menu;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.aio.translate.api.IAIOTranslateApi;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/menu/an;", "Lcom/tencent/qqnt/aio/menu/ui/d;", "Lcom/tencent/mobileqq/text/QQText;", "text", "", "i", "Lnv3/b;", "content", "", "j", "f", "", "c", tl.h.F, "b", "e", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lnv3/b;", "selectContent", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class an extends com.tencent.qqnt.aio.menu.ui.d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private nv3.b selectContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/menu/an$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.an$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47604);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        super(msgItem);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) msgItem);
        } else {
            this.context = context;
        }
    }

    private final String i(QQText text) {
        StringBuilder sb5 = new StringBuilder(text);
        EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) text.getSpans(0, text.length(), EmoticonSpan.class);
        if (emoticonSpanArr == null) {
            return "";
        }
        int length = emoticonSpanArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                sb5.replace(text.getSpanStart(emoticonSpanArr[length]), text.getSpanEnd(emoticonSpanArr[length]), "");
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.drawable.jxd;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.id.z4r;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "TranslateMenuItem";
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    /* renamed from: f */
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.ozo);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.qqstr_particip_1e7160c5)");
        return qqStr;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public void h() {
        QQText qQText;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!(this.context instanceof Activity)) {
            return;
        }
        IAIOMsgItemApi iAIOMsgItemApi = (IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class);
        AIOMsgItem msgItem = d();
        Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
        CharSequence translateText = iAIOMsgItemApi.getTranslateText(msgItem);
        if (translateText == null) {
            translateText = "";
        }
        nv3.b bVar = this.selectContent;
        if (bVar != null && bVar.l() != bVar.contentLength()) {
            translateText = bVar.m();
            Intrinsics.checkNotNullExpressionValue(translateText, "it.selectContent");
        }
        CharSequence c16 = IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), translateText, 5, com.tencent.qqnt.emotion.constant.b.b(), null, null, 24, null);
        if (c16 instanceof QQText) {
            qQText = (QQText) c16;
        } else {
            qQText = null;
        }
        if (qQText != null) {
            qQText.toPurePlainText();
            c16 = i(qQText);
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(c16);
        if (isBlank) {
            QQToastUtil.showQQToast(0, "\u8be5\u6d88\u606f\u6682\u4e0d\u652f\u6301\u7ffb\u8bd1");
        } else {
            ((IAIOTranslateApi) QRoute.api(IAIOTranslateApi.class)).openTranslatePage((Activity) this.context, c16.toString());
        }
    }

    public final void j(@NotNull nv3.b content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
        } else {
            Intrinsics.checkNotNullParameter(content, "content");
            this.selectContent = content;
        }
    }
}
