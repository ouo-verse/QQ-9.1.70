package com.tencent.biz.qqcircle.immersive.redpacket.util;

import android.view.View;
import com.tencent.libra.request.Option;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ.\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/util/a;", "", "Landroid/view/View;", "iv", "", "token", "", "isToken", "isNinePatch", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f89583a = new a();

    a() {
    }

    public static /* synthetic */ void b(a aVar, View view, String str, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            view = null;
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        aVar.a(view, str, z16, z17);
    }

    public final void a(@Nullable View iv5, @NotNull String token, boolean isToken, boolean isNinePatch) {
        int i3;
        Intrinsics.checkNotNullParameter(token, "token");
        if (isToken) {
            token = QCircleSkinHelper.getInstance().getUrl(token);
        }
        QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
        Option url = Option.obtain().setUrl(token);
        if (isNinePatch) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        Option picType = url.setPicType(i3);
        Intrinsics.checkNotNullExpressionValue(token, "url");
        g16.loadImage(picType, new e(iv5, token));
    }
}
