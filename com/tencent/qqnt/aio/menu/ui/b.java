package com.tencent.qqnt.aio.menu.ui;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.aio.menu.MenuWrapper;
import com.tencent.qqnt.aio.menu.m;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a(\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\"\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\"\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\"\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\"\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/menu/MenuWrapper;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "Landroid/view/View$OnClickListener;", "listener", "Lcom/tencent/qqnt/aio/menu/m;", "a", "", "I", "perLineCount", "b", "iconWidth", "c", "leftRightPadding", "d", "bottomPadding", "e", "clickTag", "aio_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final int f351552a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f351553b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f351554c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f351555d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f351556e;

    static {
        int i3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47738);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        if (e.f351563b == 5) {
            i3 = 7;
        } else {
            i3 = 6;
        }
        f351552a = i3;
        ViewUtils viewUtils = ViewUtils.f352270a;
        f351553b = viewUtils.b(40);
        f351554c = viewUtils.b(8);
        f351555d = viewUtils.a(4.5f);
        f351556e = R.id.z3r;
    }

    @NotNull
    public static final m a(@NotNull MenuWrapper menuWrapper, @Nullable com.tencent.aio.api.runtime.a aVar, @NotNull c menu, @Nullable View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(menuWrapper, "<this>");
        Intrinsics.checkNotNullParameter(menu, "menu");
        return menuWrapper;
    }

    public static /* synthetic */ m b(MenuWrapper menuWrapper, com.tencent.aio.api.runtime.a aVar, c cVar, View.OnClickListener onClickListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            onClickListener = null;
        }
        return a(menuWrapper, aVar, cVar, onClickListener);
    }
}
