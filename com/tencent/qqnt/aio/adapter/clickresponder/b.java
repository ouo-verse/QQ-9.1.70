package com.tencent.qqnt.aio.adapter.clickresponder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/clickresponder/b;", "Lcom/tencent/qqnt/aio/adapter/clickresponder/e;", "Landroid/content/Context;", "context", "", "isScaleChat", "Lcom/tencent/mobileqq/aio/msg/ah;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "", AppConstants.Key.COLUMN_EXT_STR, "key", "b", QZoneDTLoginReporter.SCHEMA, "d", "url", "c", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class b implements e {
    @Override // com.tencent.qqnt.aio.adapter.clickresponder.e
    public void a(Context context, boolean isScaleChat, ah item) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("BaseResponder", 1, "click tofu: " + item);
        String b16 = b(item.l2(), "jump_h5");
        if (b16 != null) {
            if (!TextUtils.isEmpty(b16)) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(b16, "http://", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(b16, "https://", false, 2, null);
                    if (!startsWith$default2) {
                        return;
                    }
                }
            }
            c(context, b16);
        }
        String b17 = b(item.l2(), ChatsRevealApiImpl.KEY_JUMP_SCHEME);
        if (b17 == null || !TextUtils.isEmpty(b17)) {
            return;
        }
        d(context, b17);
    }

    public final String b(String extStr, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (extStr == null) {
            return null;
        }
        try {
            return new JSONObject(extStr).optString(key);
        } catch (Exception e16) {
            QLog.e(getClass().getSimpleName(), 1, "getValueFromBusiExtra : " + e16);
            return null;
        }
    }

    public final void c(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent();
        intent.putExtra("url", url);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public final void d(Context context, String schema) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intent intent = new Intent(context, (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(schema));
        context.startActivity(intent);
    }
}
