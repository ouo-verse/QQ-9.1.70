package com.tencent.mobileqq.zootopia.ue;

import android.view.ViewGroup;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/b;", "", "Landroid/view/ViewGroup;", "getRootView", "", "url", "", "needFinishFromJs", "needSilentLoad", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface b {
    void a(String url, boolean needFinishFromJs, boolean needSilentLoad);

    ViewGroup getRootView();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, String str, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    z17 = false;
                }
                bVar.a(str, z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openWebView");
        }
    }
}
