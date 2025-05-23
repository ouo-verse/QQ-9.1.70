package oc1;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.flock.share.c;
import com.tencent.mobileqq.flock.share.e;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.util.QQCustomArkDialogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import y45.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Loc1/a;", "", "Landroid/content/Intent;", "Ly45/n;", "shareInfo", "", "a", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/flock/share/e;", "shareParam", "b", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f422443a = new a();

    a() {
    }

    private final void a(Intent intent, n nVar) {
        boolean contains$default;
        try {
            JSONObject jSONObject = new JSONObject(nVar.f449447f);
            String optString = jSONObject.optString("app");
            String optString2 = jSONObject.optString("ver");
            String optString3 = jSONObject.optString("view");
            String metaList = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
            String optString4 = jSONObject.optString("prompt");
            String optString5 = jSONObject.optString(DownloadInfo.spKey_Config);
            String optString6 = jSONObject.optString("desc");
            String optString7 = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
            intent.putExtra("forward_type", 27);
            intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 6);
            intent.putExtra("is_ark_display_share", true);
            intent.putExtra("forward_ark_app_name", optString);
            intent.putExtra("forward_ark_app_view", optString3);
            intent.putExtra("forward_ark_app_ver", optString2);
            intent.putExtra("forward_ark_app_prompt", optString4);
            intent.putExtra("forward_ark_app_meta", metaList);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optString5);
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString6);
            if (!TextUtils.isEmpty(metaList)) {
                Intrinsics.checkNotNullExpressionValue(metaList, "metaList");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) metaList, (CharSequence) "\"isAIO\":1", false, 2, (Object) null);
                if (contains$default) {
                    metaList = StringsKt__StringsJVMKt.replace$default(metaList, "\"isAIO\":1", "\"isAIO\":0", false, 4, (Object) null);
                }
            }
            intent.putExtras(QQCustomArkDialogUtil.zipArgs(optString, optString3, optString2, metaList, null));
            intent.putExtra("forward_ark_biz_src", optString7);
        } catch (JSONException e16) {
            RFWLog.fatal("FlockShareArkHelper", RFWLog.USR, e16);
        }
    }

    @Nullable
    public final Intent b(@NotNull Context context, @NotNull e shareParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        n n3 = shareParam.n();
        if (n3 != null) {
            Intent intent = new Intent(context, c.f210421a.b());
            f422443a.a(intent, n3);
            return intent;
        }
        return null;
    }
}
