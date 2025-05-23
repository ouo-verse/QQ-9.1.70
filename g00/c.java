package g00;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lg00/c;", "", "Landroid/os/Bundle;", "outState", "", "a", Constants.FILE_INSTANCE_STATE, "b", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {
    public void a(Bundle outState) {
        x.j("WSInstanceStateManager", "[onSaveInstanceState] outState = " + outState);
        if (outState == null) {
            return;
        }
        for (a aVar : b.f401020a.a()) {
            String key = aVar.getKey();
            String value = aVar.getValue();
            outState.putString(key, value);
            ai.p(key, value);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Bundle savedInstanceState) {
        boolean z16;
        boolean isBlank;
        x.j("WSInstanceStateManager", "[onViewStateRestored] savedInstanceState = " + savedInstanceState);
        if (savedInstanceState == null) {
            for (a aVar : b.f401020a.a()) {
                String key = aVar.getKey();
                String value = aVar.getValue();
                if (TextUtils.isEmpty(value)) {
                    String spValue = ai.i(key, "");
                    Intrinsics.checkNotNullExpressionValue(spValue, "spValue");
                    aVar.setValue(spValue);
                    x.j("WSInstanceStateManager", "[onViewStateRestored] key = " + key + ", value = " + value);
                }
            }
            return;
        }
        for (a aVar2 : b.f401020a.a()) {
            String key2 = aVar2.getKey();
            String string = savedInstanceState.getString(key2);
            if (string != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(string);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        aVar2.setValue(string);
                    }
                    x.j("WSInstanceStateManager", "[onViewStateRestored] key = " + key2 + ", value = " + string);
                }
            }
            z16 = true;
            if (z16) {
            }
            x.j("WSInstanceStateManager", "[onViewStateRestored] key = " + key2 + ", value = " + string);
        }
    }
}
