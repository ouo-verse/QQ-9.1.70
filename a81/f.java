package a81;

import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"La81/f;", "", "", PublicAccountMessageUtilImpl.META_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/os/Bundle;", "bundle", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f25705a = new f();

    f() {
    }

    @NotNull
    public String a(@NotNull String meta, @NotNull MsgRecord msgRecord, @Nullable Bundle bundle) {
        String str = "";
        Intrinsics.checkNotNullParameter(meta, "meta");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (bundle == null) {
            return meta;
        }
        if (bundle.getInt("key_chat_type", -1) != 201) {
            return meta;
        }
        try {
            JSONObject jSONObject = new JSONObject(meta);
            JSONObject optJSONObject = jSONObject.optJSONObject(IMiniCardBeancurd.SIGN_PLAIN_TEXT);
            if (optJSONObject != null) {
                optJSONObject.put("avatar", "");
            }
            if (optJSONObject != null) {
                optJSONObject.put("nick", "");
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonRoot.toString()");
            str = jSONObject2;
        } catch (Throwable th5) {
            QLog.e("ArkNotifyServiceContentHelper", 1, "getQunProShareArkType e: ", th5);
        }
        QLog.d("ArkNotifyServiceContentHelper", 1, "[appendArkMsg] arkJsonString: " + str);
        return str;
    }
}
