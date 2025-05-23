package com.tencent.qqnt.aio.adapter.clickresponder;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/clickresponder/m;", "Lcom/tencent/qqnt/aio/adapter/clickresponder/b;", "Landroid/content/Context;", "context", "", "isScaleChat", "Lcom/tencent/mobileqq/aio/msg/ah;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class m extends b {
    /* JADX WARN: Removed duplicated region for block: B:5:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.qqnt.aio.adapter.clickresponder.b, com.tencent.qqnt.aio.adapter.clickresponder.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, boolean isScaleChat, ah item) {
        List split$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("VasBaseResponder", 1, "click tofu: " + item);
        String l26 = item.l2();
        String str = "";
        if (!TextUtils.isEmpty(l26)) {
            try {
                String optString = new JSONObject(l26).optString(WadlProxyConsts.KEY_JUMP_URL);
                Intrinsics.checkNotNullExpressionValue(optString, "root.optString(\"jumpUrl\")");
                try {
                    if (item.n2() == 6 && item.k2() == 3) {
                        IConfigProxy iConfigProxy = VasLongToggle.TOFU_BIRTHDAY_GIFT;
                        if (iConfigProxy.isEnable(false)) {
                            String stringData = iConfigProxy.getStringData("");
                            if (stringData.length() > 0) {
                                Scanner scanner = new Scanner(new URL(URLDecoder.decode(optString, "utf-8")).getQuery());
                                try {
                                    scanner.useDelimiter(ContainerUtils.FIELD_DELIMITER);
                                    String str2 = stringData;
                                    while (scanner.hasNext()) {
                                        String next = scanner.next();
                                        Intrinsics.checkNotNullExpressionValue(next, "it.next()");
                                        split$default = StringsKt__StringsKt.split$default((CharSequence) next, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                                        String str3 = (String) split$default.get(0);
                                        if (Intrinsics.areEqual(str3, "from")) {
                                            str2 = StringsKt__StringsJVMKt.replace$default(str2, "{from}", (String) split$default.get(1), false, 4, (Object) null);
                                        } else if (Intrinsics.areEqual(str3, "friends")) {
                                            str2 = StringsKt__StringsJVMKt.replace$default(str2, "{friends}", (String) split$default.get(1), false, 4, (Object) null);
                                        }
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    CloseableKt.closeFinally(scanner, null);
                                    ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(context, str2);
                                    return;
                                } finally {
                                }
                            }
                        }
                    }
                    str = optString;
                } catch (JSONException e16) {
                    e = e16;
                    str = optString;
                    QLog.e("VasBaseResponder", 1, "onClickBeancurd : " + e);
                    if (TextUtils.isEmpty(str)) {
                    }
                }
            } catch (JSONException e17) {
                e = e17;
            }
        }
        if (TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            context.startActivity(intent);
        }
    }
}
