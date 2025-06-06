package com.tencent.mobileqq.richmedia.depend;

import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\f\u001a\u00020\u000bH&J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/richmedia/depend/e;", "Lcom/tencent/mobileqq/richmedia/depend/c;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mCurrentSelectedItem", "", "C6", "", "type", "currentSelectedItem", "", "A1", "", ICustomDataEditor.STRING_ARRAY_PARAM_5, "", "", "getReportParams", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface e extends c {
    void A1(int type, @Nullable RFWLayerItemMediaInfo currentSelectedItem);

    boolean C6(@Nullable RFWLayerItemMediaInfo mCurrentSelectedItem);

    @NotNull
    String a5();

    @Nullable
    Map<String, Object> getReportParams();
}
