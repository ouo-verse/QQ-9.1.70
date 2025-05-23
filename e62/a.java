package e62;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\n\u0010\f\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&J\b\u0010\u001a\u001a\u00020\u0017H&J$\u0010\u001e\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001d\u001a\u00020\u0017H&J\n\u0010 \u001a\u0004\u0018\u00010\u001fH&J\u0012\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006#"}, d2 = {"Le62/a;", "", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "itemClickListener", "", "g", "", "url", "setUrl", "getUrl", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onConfigurationChanged", "e", "screenshotTitle", "j", h.F, "title", "a", "screenshotShareUrl", "d", "Lorg/json/JSONArray;", "actionSheetTitleArray", "l", "", "screenshotFromType", "i", "b", "photoPath", "originImagePath", "editType", "f", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "c", "imgPath", "k", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a {
    void a(@Nullable String title);

    int b();

    @Nullable
    QQProgressDialog c();

    void d(@Nullable String screenshotShareUrl);

    @Nullable
    String e();

    void f(@Nullable String photoPath, @Nullable String originImagePath, int editType);

    void g(@Nullable ShareActionSheet.OnItemClickListener itemClickListener);

    @Nullable
    String getUrl();

    @Nullable
    String h();

    void i(int screenshotFromType);

    void j(@Nullable String screenshotTitle);

    void k(@Nullable String imgPath);

    void l(@Nullable JSONArray actionSheetTitleArray);

    void onConfigurationChanged();

    void onDestroy();

    void setUrl(@Nullable String url);
}
