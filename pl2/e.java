package pl2;

import android.net.Uri;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ErrDetail;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lpl2/e;", "Lpl2/g;", "", "retCode", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$ErrDetail;", "errorDetail", "", "a", "Landroid/net/Uri;", "btnUri", "", "retMsg", "", "b", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface e extends g {
    boolean a(int retCode, @NotNull PayGatewayProto$ErrDetail errorDetail);

    void b(@Nullable Uri btnUri, int retCode, @NotNull String retMsg);
}
