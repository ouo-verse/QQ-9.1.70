package com.tencent.comic.api.hippy;

import android.app.Activity;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.a;
import com.tencent.comic.data.e;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IComicHippyBackEventInterceptor {
    boolean canShowCancelRedPoinDialog(a aVar);

    void doClear();

    List<ComicCancelRedPointPopItemData> getValidCancelRedPointDialogData();

    void openReader(Activity activity, String str);

    void prepareData();

    void recordDialogShowTime();

    void reportData(e eVar);
}
