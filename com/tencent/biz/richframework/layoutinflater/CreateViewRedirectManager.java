package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.richframework.layoutinflater.redirect.FragmentRedirectHandler;
import com.tencent.biz.richframework.layoutinflater.redirect.ICreateViewRedirectHandler;
import com.tencent.biz.richframework.layoutinflater.redirect.RecyclerViewRedirectHandler;
import com.tencent.biz.richframework.layoutinflater.redirect.StateListAnimatorRedirectHandler;
import com.tencent.biz.richframework.layoutinflater.redirect.WebViewRedirectHandler;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/richframework/layoutinflater/CreateViewRedirectManager;", "", "", "name", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "needRedirect", "", "Lcom/tencent/biz/richframework/layoutinflater/redirect/ICreateViewRedirectHandler;", "createViewRedirects", "Ljava/util/List;", "<init>", "()V", "layoutinflater_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class CreateViewRedirectManager {

    @NotNull
    public static final CreateViewRedirectManager INSTANCE = new CreateViewRedirectManager();
    private static final List<ICreateViewRedirectHandler> createViewRedirects;

    static {
        List<ICreateViewRedirectHandler> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new RecyclerViewRedirectHandler(), new StateListAnimatorRedirectHandler(), new WebViewRedirectHandler(), new FragmentRedirectHandler());
        createViewRedirects = mutableListOf;
    }

    CreateViewRedirectManager() {
    }

    public final boolean needRedirect(@NotNull String name, @NotNull Context context, @NotNull AttributeSet attr) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        Iterator<ICreateViewRedirectHandler> it = createViewRedirects.iterator();
        while (it.hasNext()) {
            if (it.next().needCreateViewInMain(name, context, attr)) {
                return true;
            }
        }
        return false;
    }
}
