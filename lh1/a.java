package lh1;

import android.net.Uri;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R'\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\bj\b\u0012\u0004\u0012\u00020\u0002`\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Llh1/a;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "originalUrl", "a", "account", "", "onAccountChanged", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "e", "Ljava/util/HashSet;", "getUrlSet", "()Ljava/util/HashSet;", "urlSet", "", "f", "I", "getRecyclerviewWidth", "()I", "setRecyclerviewWidth", "(I)V", "recyclerviewWidth", h.F, "getRecyclerviewWidthWithoutPadding", "setRecyclerviewWidthWithoutPadding", "recyclerviewWidthWithoutPadding", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f414590d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<String> urlSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int recyclerviewWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int recyclerviewWidthWithoutPadding;

    static {
        a aVar = new a();
        f414590d = aVar;
        urlSet = new HashSet<>();
        AccountChangedNotifier.f214789d.a(aVar);
    }

    a() {
    }

    @Nullable
    public final String a(@Nullable String originalUrl) {
        List split$default;
        try {
            Uri parse = Uri.parse(originalUrl);
            String query = parse.getQuery();
            Intrinsics.checkNotNull(query);
            split$default = StringsKt__StringsKt.split$default((CharSequence) query, new String[]{"/"}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            String str = "";
            int length = strArr.length - 1;
            for (int i3 = 0; i3 < length; i3++) {
                if (Intrinsics.areEqual(strArr[i3], "w") || Intrinsics.areEqual(strArr[i3], h.F)) {
                    strArr[i3 + 1] = String.valueOf((int) (Integer.parseInt(strArr[r6]) * 0.885f));
                }
                str = str + strArr[i3] + "/";
            }
            return parse.buildUpon().encodedQuery(str + strArr[strArr.length - 1]).build().toString();
        } catch (Exception unused) {
            return originalUrl;
        }
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        recyclerviewWidth = 0;
        recyclerviewWidthWithoutPadding = 0;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.mine.ImagePreloadHelper", 2, "onAccountChanged");
        }
    }
}
