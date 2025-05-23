package an2;

import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.mobileqq.richmedialist.model.BaseItemInfo;
import com.tencent.mobileqq.richmedialist.model.FileItemInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH&\u00a8\u0006\u0013"}, d2 = {"Lan2/b;", "Lan2/c;", "", "isSelected", "Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", "itemInfo", "", "T1", "Vb", "Qb", "kf", "Lcom/tencent/mobileqq/richmedialist/model/FileItemInfo;", "fileItemInfo", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "imageView", "", "width", "height", "xf", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface b extends c {
    void Qb(@NotNull BaseItemInfo itemInfo);

    void T1(boolean isSelected, @NotNull BaseItemInfo itemInfo);

    void Vb(@NotNull BaseItemInfo itemInfo);

    void kf(@NotNull BaseItemInfo itemInfo);

    void xf(@NotNull FileItemInfo fileItemInfo, @NotNull RoundCornerImageView imageView, int width, int height);
}
