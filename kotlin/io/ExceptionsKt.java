package kotlin.io;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002\u00a8\u0006\u0006"}, d2 = {"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ExceptionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String constructMessage(File file, File file2, String str) {
        StringBuilder sb5 = new StringBuilder(file.toString());
        if (file2 != null) {
            sb5.append(" -> " + file2);
        }
        if (str != null) {
            sb5.append(MsgSummary.STR_COLON + str);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }
}
