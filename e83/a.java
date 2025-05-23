package e83;

import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0002\"\u0015\u0010\b\u001a\u00020\u0000*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\n"}, d2 = {"", "b", "(I)I", "dp", "", "a", "(F)I", "d", "dpr", "c", "qq-wink-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    public static final int a(float f16) {
        return ImmersiveUtils.dpToPx(f16);
    }

    public static final int b(int i3) {
        return a(i3);
    }

    public static final int c(float f16) {
        return DisplayUtil.dip2px(BaseApplication.getContext(), f16);
    }

    public static final int d(int i3) {
        return c(i3);
    }
}
