package com.tencent.qqnt.aio.markdown.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J.\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00122\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0012H\u0016J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010#H\u0016J*\u0010$\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00122\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010#H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/aio/markdown/api/impl/MarkdownFeatureCompatApiNtImpl;", "Lcom/tencent/qqnt/aio/markdown/api/IMarkdownFeatureCompatApi;", "()V", "applyMarkdownStyle", "", "context", "Landroid/content/Context;", "styleSheet", "", "isVasTheme", "", "getInlineButtonStyleSheet", "", "btnModel", "supportVas", "parse", "", "markdownText", "", "parseExcludeExtData", "limit", "", "reportTimeCost", "scene", Node.ATTRS_ATTR, "", "duration", "", "shouldUseSimpleBreakStrategy", "startUrl", "url", "tryParse", "elem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "elemList", "", "tryParseForChats", "uid", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class MarkdownFeatureCompatApiNtImpl implements IMarkdownFeatureCompatApi {
    static IPatchRedirector $redirector_;

    public MarkdownFeatureCompatApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public void applyMarkdownStyle(@NotNull Context context, @NotNull Object styleSheet, boolean isVasTheme) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, context, styleSheet, Boolean.valueOf(isVasTheme));
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(styleSheet, "styleSheet");
        }
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @Nullable
    public Void getInlineButtonStyleSheet(@NotNull Context context, @NotNull Object btnModel, boolean supportVas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Void) iPatchRedirector.redirect((short) 4, this, context, btnModel, Boolean.valueOf(supportVas));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        return null;
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @NotNull
    public CharSequence parse(@NotNull String markdownText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this, (Object) markdownText);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        return "";
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @NotNull
    public CharSequence parseExcludeExtData(@NotNull String markdownText, int limit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this, (Object) markdownText, limit);
        }
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        return "";
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public void reportTimeCost(@NotNull String scene, @Nullable Map<String, String> attrs, double duration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, scene, attrs, Double.valueOf(duration));
        } else {
            Intrinsics.checkNotNullParameter(scene, "scene");
        }
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public boolean shouldUseSimpleBreakStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public void startUrl(@NotNull Context context, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) url);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
        }
    }

    @Nullable
    /* renamed from: tryParse, reason: collision with other method in class */
    public Void m248tryParse(@Nullable MsgAbstractElement elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return null;
        }
        return (Void) iPatchRedirector.redirect((short) 7, (Object) this, (Object) elem);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    @Nullable
    public String tryParseForChats(@NotNull Context context, @NotNull String uid, @Nullable List<MsgAbstractElement> elemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, context, uid, elemList);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uid, "uid");
        return null;
    }

    @Nullable
    /* renamed from: tryParse, reason: collision with other method in class */
    public Void m249tryParse(@Nullable List<MsgAbstractElement> elemList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return null;
        }
        return (Void) iPatchRedirector.redirect((short) 9, (Object) this, (Object) elemList);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public /* bridge */ /* synthetic */ String tryParse(MsgAbstractElement msgAbstractElement) {
        return (String) m248tryParse(msgAbstractElement);
    }

    @Override // com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi
    public /* bridge */ /* synthetic */ String tryParse(List list) {
        return (String) m249tryParse((List<MsgAbstractElement>) list);
    }
}
