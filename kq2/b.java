package kq2;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.account.api.IAccountManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0004j\b\u0012\u0004\u0012\u00020\u0001`\u0005H\u0016J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lkq2/b;", "Ljq2/c;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "title", "Landroid/content/Context;", "context", "id", "", "f", "<init>", "()V", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends jq2.c {
    @Override // jq2.c
    public ArrayList<jq2.c> c() {
        ArrayList<jq2.c> arrayList = new ArrayList<>();
        arrayList.add(new mq2.h());
        arrayList.add(new mq2.g());
        arrayList.add(new mq2.f());
        arrayList.add(new mq2.i());
        arrayList.add(new mq2.a());
        arrayList.add(new mq2.c());
        arrayList.add(new mq2.b());
        arrayList.add(new mq2.e());
        return arrayList;
    }

    @Override // jq2.c
    /* renamed from: e */
    public String getDetailTitle() {
        String string = BaseApplication.context.getString(R.string.f196784i9);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026.qq_account_and_security)");
        return string;
    }

    @Override // jq2.c
    public void f(String title, Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("AccountManagerNode", 2, "startRouteToPage");
        Intent intent = new Intent();
        intent.putExtra("setting_search_title", title);
        ((IAccountManagerApi) QRoute.api(IAccountManagerApi.class)).startAccountManagerFragment(context, intent);
    }
}
