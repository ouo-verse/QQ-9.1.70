package id;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lid/bw;", "Lid/b;", "Lhd/e;", tl.h.F, "g", "f", "", "i", "Landroid/content/Context;", "context", "", "Lhd/b;", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bw extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final bw f407502a = new bw();

    bw() {
    }

    private final hd.e f() {
        return new hd.e("\u5e38\u9a7b\u5730", com.qzone.reborn.albumx.qzone.local.l.f52668a.d("resident_login_city"));
    }

    private final hd.e g() {
        return new hd.e("\u6743\u9650", i());
    }

    private final hd.e h() {
        String uid = LoginData.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        return new hd.e("uid", uid);
    }

    private final String i() {
        boolean z16 = ContextCompat.checkSelfPermission(BaseApplication.getContext(), QQPermissionConstants.Permission.ACCESS_MEDIA_LOCATION) == 0;
        return "\u5b58\u50a8\u6743\u9650: " + (ContextCompat.checkSelfPermission(BaseApplication.getContext(), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && ContextCompat.checkSelfPermission(BaseApplication.getContext(), QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) + " \n\u56fe\u7247\u5730\u7406\u4f4d\u7f6e\u6743\u9650: " + z16;
    }

    @Override // id.b
    public List<hd.b> e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(h());
        arrayList.add(g());
        arrayList.add(f());
        return arrayList;
    }
}
