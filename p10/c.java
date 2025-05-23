package p10;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi.util.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lp10/c;", "Lp10/a;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c implements a {
    @Override // p10.a
    public boolean a(Context context, Bundle bundle) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        if (bundle == null) {
            x.j("WSDramaJumpHelper", "homeBundle is null");
            return false;
        }
        String redDotDramaId = bundle.getString("key_drama_id", "");
        String string = bundle.getString("key_drama_jump_schema", "");
        bundle.putString("key_drama_id", "");
        bundle.putString("key_drama_jump_schema", "");
        Intrinsics.checkNotNullExpressionValue(redDotDramaId, "redDotDramaId");
        isBlank = StringsKt__StringsJVMKt.isBlank(redDotDramaId);
        if (isBlank) {
            x.j("WSDramaJumpHelper", "drama id is null");
            return false;
        }
        WSDramaPageFragment.Vh(new com.tencent.biz.pubaccount.weishi.drama.e("aio_red_dot", context).i(redDotDramaId).j(string));
        return true;
    }
}
