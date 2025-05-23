package eu2;

import android.text.TextUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tvideo.CurLoginToken;
import tvideo.TokenKeyType;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Leu2/f;", "", "Lbu2/a;", "account", "Ljava/util/ArrayList;", "Ltvideo/CurLoginToken;", "Lkotlin/collections/ArrayList;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f397149a = new f();

    f() {
    }

    @NotNull
    public final ArrayList<CurLoginToken> a(@NotNull bu2.a account) {
        Intrinsics.checkNotNullParameter(account, "account");
        ArrayList<CurLoginToken> arrayList = new ArrayList<>();
        if (account.getVideoUserId() != 0) {
            CurLoginToken build = new CurLoginToken.a().c("102031143").e(TokenKeyType.TOKEN_KEY_TYPE_VUID).f(account.getVideoUserId()).h(account.getOpenId()).g(account.getVideoSessionKey()).b(account.getRefreshToken()).d("").build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026                 .build()");
            arrayList.add(build);
        }
        if (!TextUtils.isEmpty(account.getOpenId()) && !TextUtils.isEmpty(account.getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String())) {
            CurLoginToken build2 = new CurLoginToken.a().c("102031143").e(TokenKeyType.TOKEN_KEY_TYPE_QQ_HULIAN).h(account.getOpenId()).g(account.getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String()).b(account.getRefreshToken()).build();
            Intrinsics.checkNotNullExpressionValue(build2, "Builder()\n              \u2026                 .build()");
            arrayList.add(build2);
        }
        return arrayList;
    }
}
