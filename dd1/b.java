package dd1;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J8\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J8\u0010\r\u001a\u00020\u00072.\u0010\f\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0005\u0012\u0004\u0012\u00020\u00070\u000bH&J\b\u0010\u000e\u001a\u00020\u0007H&\u00a8\u0006\u000f"}, d2 = {"Ldd1/b;", "", "", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extendParams", "", "b", "onResume", "a", "Lkotlin/Function1;", "reportHandler", "setReportHandler", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qqgamecenter-qa-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface b {
    void a();

    void b(@NotNull String url, @Nullable HashMap<String, Object> extendParams);

    void onDestroy();

    void onResume();

    void setReportHandler(@NotNull Function1<? super HashMap<String, String>, Unit> reportHandler);
}
