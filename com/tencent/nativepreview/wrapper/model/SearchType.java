package com.tencent.nativepreview.wrapper.model;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/nativepreview/wrapper/model/SearchType;", "", "()V", "DOC_SEARCH_TYPE_EXACT", "", "DOC_SEARCH_TYPE_FUZZY", "DOC_SEARCH_TYPE_REGEX", "native_preview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class SearchType {
    static IPatchRedirector $redirector_ = null;
    public static final int DOC_SEARCH_TYPE_EXACT = 0;
    public static final int DOC_SEARCH_TYPE_FUZZY = 2;
    public static final int DOC_SEARCH_TYPE_REGEX = 1;

    @NotNull
    public static final SearchType INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new SearchType();
        }
    }

    SearchType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
