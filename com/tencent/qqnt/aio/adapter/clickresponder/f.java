package com.tencent.qqnt.aio.adapter.clickresponder;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/clickresponder/f;", "Lcom/tencent/qqnt/aio/adapter/clickresponder/b;", "Landroid/content/Context;", "context", "", "isScaleChat", "Lcom/tencent/mobileqq/aio/msg/ah;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f extends b {
    /* JADX WARN: Removed duplicated region for block: B:6:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.qqnt.aio.adapter.clickresponder.b, com.tencent.qqnt.aio.adapter.clickresponder.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, boolean isScaleChat, ah item) {
        String optString;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("LoveGiftResponder", 1, "click tofu: " + item);
        QLog.d("LoveGiftResponder", 1, "click tofu");
        String l26 = item.l2();
        if (!TextUtils.isEmpty(l26)) {
            try {
                optString = new JSONObject(l26).optString(WadlProxyConsts.KEY_JUMP_URL);
                Intrinsics.checkNotNullExpressionValue(optString, "root.optString(\"jumpUrl\")");
            } catch (JSONException e16) {
                QLog.e("LoveGiftResponder", 1, "onClickBeancurd : " + e16);
            }
            if (TextUtils.isEmpty(optString)) {
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", optString);
                context.startActivity(intent);
                return;
            }
            return;
        }
        optString = "";
        if (TextUtils.isEmpty(optString)) {
        }
    }
}
