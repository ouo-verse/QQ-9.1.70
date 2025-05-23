package fn1;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import en1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lfn1/b;", "Len1/a;", "Lorg/json/JSONObject;", "contentJson", "Len1/a$a;", "result", "", "a", "", "J", "b", "()J", "setCreateTime", "(J)V", WadlProxyConsts.CREATE_TIME, "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b implements en1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long createTime = -1;

    @Override // en1.a
    public void a(@NotNull JSONObject contentJson, @NotNull a.C10251a result) {
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            String it = contentJson.getString(WadlProxyConsts.CREATE_TIME);
            try {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.createTime = Long.parseLong(it);
            } catch (NumberFormatException e16) {
                QLog.i("FeedOtherInfoParser", 1, "parser fail, feed create time is not NumberFormat, value is " + it + ". ", e16);
            }
        } catch (JSONException e17) {
            QLog.i("FeedOtherInfoParser", 1, "parser fail, feed's json don't contain `createTime` field. contentJson=" + contentJson + TokenParser.SP, e17);
        }
    }

    /* renamed from: b, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }
}
