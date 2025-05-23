package ja1;

import android.view.View;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.f;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements f {
    private void e(List<ColorNote> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            try {
                ColorNote colorNote = list.get(i3);
                if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).getOriginType(colorNote.getServiceType()) == 16842752) {
                    ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportColorNoteExpoForMiniApp(colorNote.getSubType(), ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isRecentColorNote(colorNote));
                }
            } catch (Throwable th5) {
                QLog.e("MiniAppColorNoteListLis", 1, "reportColorNoteShow get a throwable", th5);
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void d(List<ColorNote> list) {
        e(list);
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void b() {
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void a(View view, ColorNote colorNote) {
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void c(View view, ColorNote colorNote) {
    }
}
