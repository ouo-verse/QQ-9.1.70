package com.tencent.qqnt.qbasealbum.base.model;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/model/a;", "", "Landroid/view/View;", "v", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "", "layoutPosition", "", "b", "itemInfo", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {
    int a(@NotNull View v3, @NotNull LocalMediaInfo itemInfo, @NotNull PageType pageType, @NotNull SelectedMediaViewModel selectedMediaViewModel);

    void b(@NotNull View v3, @NotNull List<LocalMediaInfo> media, int layoutPosition);
}
