package com.tencent.mobileqq.emoticonview.searchemo;

import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/SearchEmoFooterData;", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchEmoFooterData extends EmotionPanelData {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final SearchEmoFooterData INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22056);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new SearchEmoFooterData();
        }
    }

    SearchEmoFooterData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
