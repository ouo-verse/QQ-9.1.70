package i83;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.UiThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H'J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0010"}, d2 = {"Li83/a;", "", "", "isSuccess", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "", "X5", "", "y7", "m4", "Landroid/content/Context;", "H8", "Landroid/os/Bundle;", "getParams", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {
    @NotNull
    Context H8();

    @UiThread
    void X5(boolean isSuccess, @Nullable Exception error);

    @NotNull
    Bundle getParams();

    boolean m4();

    @NotNull
    String y7();
}
