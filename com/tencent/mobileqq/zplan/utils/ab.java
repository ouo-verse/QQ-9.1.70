package com.tencent.mobileqq.zplan.utils;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.download.api.IZPlanHotPatchDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\u001a$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u001a\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b\u001a\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u001a\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/utils/UEDownloadSource;", "source", "Lkotlin/Function0;", "", "block", "a", "", "url", "", "c", "d", "b", "", "Ljava/util/Set;", "URL_SOURCE_SET", "zplan_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Set<String> f335754a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/utils/ab$a", "Lcom/tencent/mobileqq/zplan/download/api/IZPlanHotPatchDownloader$a;", "", "lastSource", "", "result", "", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements IZPlanHotPatchDownloader.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UEDownloadSource f335755a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f335756b;

        a(UEDownloadSource uEDownloadSource, Function0<Unit> function0) {
            this.f335755a = uEDownloadSource;
            this.f335756b = function0;
        }

        @Override // com.tencent.mobileqq.zplan.download.api.IZPlanHotPatchDownloader.a
        public void a(int lastSource, boolean result) {
            if (result && lastSource == this.f335755a.getValue()) {
                QLog.i("UEResourceLazyDownloadHelper", 1, "invoke source: " + lastSource);
                this.f335756b.invoke();
                return;
            }
            QLog.e("UEResourceLazyDownloadHelper", 1, "doAfterUEResourceReady checkHotPatch fail, result:" + result + ", source:" + this.f335755a);
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"ugcDress/createEntry", "ugcDress/designDraft"});
        f335754a = of5;
    }

    public static final void a(@NotNull Context context, @NotNull UEDownloadSource source, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(block, "block");
        QLog.i("UEResourceLazyDownloadHelper", 1, "doAfterUEResourceReady source:" + source + ", context:" + context);
        ((IZPlanHotPatchDownloader) QRoute.api(IZPlanHotPatchDownloader.class)).checkHotPatch(context, source.getValue(), new a(source, block));
    }

    @NotNull
    public static final UEDownloadSource b(@NotNull String url) {
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(url, "url");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "ugcDress/createEntry", false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "ugcDress/designDraft", false, 2, (Object) null);
            if (!contains$default2) {
                return UEDownloadSource.Other;
            }
        }
        return UEDownloadSource.UGC;
    }

    public static final boolean c(@Nullable String str) {
        boolean contains$default;
        if (str == null) {
            return false;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "superqqshow.qq.com", false, 2, (Object) null);
        return contains$default;
    }

    public static final boolean d(@NotNull String url) {
        Object obj;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Iterator<T> it = f335754a.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) next, false, 2, (Object) null);
            if (contains$default) {
                obj = next;
                break;
            }
        }
        if (obj == null) {
            return false;
        }
        return true;
    }
}
