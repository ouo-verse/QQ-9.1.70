package b04;

import android.content.Intent;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.IBrowserBuilder;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    public void a(Intent intent, IBrowserBuilder iBrowserBuilder, List<RichMediaBrowserInfo> list, int i3) {
        new BrowserDirector().construct(iBrowserBuilder, intent);
        f04.b presenter = iBrowserBuilder.getPresenter();
        if (presenter instanceof MainBrowserPresenter) {
            MainBrowserPresenter mainBrowserPresenter = (MainBrowserPresenter) presenter;
            if (list != null && !list.isEmpty()) {
                mainBrowserPresenter.notifyImageListChanged(list, i3);
            } else {
                BrowserLogHelper.getInstance().getGalleryLog().i("RichMediaBrowserManager", 2, "lunchRichMediaBrowser dataList is null");
            }
        }
    }
}
