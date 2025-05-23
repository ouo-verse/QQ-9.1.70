package ja1;

import android.support.v4.util.ArrayMap;
import android.view.View;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.f;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.List;
import z61.e;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements f {
    @Override // com.tencent.mobileqq.colornote.list.f
    public void a(View view, ColorNote colorNote) {
        if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isRecentColorNote(colorNote)) {
            ReportController.o(null, "dc00898", "", "", "0X800A8AC", "0X800A8AC", com.tencent.mobileqq.colornote.a.a(((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).getOriginType(colorNote.getServiceType())), 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void c(View view, ColorNote colorNote) {
        if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isRecentColorNote(colorNote)) {
            ReportController.o(null, "dc00898", "", "", "0X800A8AB", "0X800A8AB", com.tencent.mobileqq.colornote.a.a(((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).getOriginType(colorNote.getServiceType())), 0, "", "", "", "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.colornote.list.f
    public void d(List<ColorNote> list) {
        int i3;
        int i16 = 0;
        if (list.size() > 0) {
            ColorNote colorNote = list.get(0);
            if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isRecentColorNote(colorNote)) {
                ReportController.o(null, "dc00898", "", "", "0X800A8AA", "0X800A8AA", com.tencent.mobileqq.colornote.a.a(((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).getOriginType(colorNote.getServiceType())), 0, "", "", "", "");
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        Iterator<ColorNote> it = list.iterator();
        while (true) {
            int i17 = 1;
            if (!it.hasNext()) {
                break;
            }
            int serviceType = it.next().getServiceType();
            Integer valueOf = Integer.valueOf(serviceType);
            if (arrayMap.containsValue(Integer.valueOf(serviceType))) {
                i17 = 1 + ((Integer) arrayMap.valueAt(serviceType)).intValue();
            }
            arrayMap.put(valueOf, Integer.valueOf(i17));
        }
        Iterator it5 = arrayMap.keySet().iterator();
        int i18 = 0;
        while (it5.hasNext()) {
            int intValue = ((Integer) it5.next()).intValue();
            if (((Integer) arrayMap.get(Integer.valueOf(intValue))).intValue() > i18) {
                i18 = ((Integer) arrayMap.get(Integer.valueOf(intValue))).intValue();
                i16 = intValue;
            }
        }
        ReportController.o(null, "dc00898", "", "", "0X800A6CD", "0X800A6CD", 0, 0, list.size() + "", com.tencent.mobileqq.colornote.a.b(i16) + "", "", "");
        for (ColorNote colorNote2 : list) {
            if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isUpcomingColorNote(colorNote2)) {
                UpComingMsgModel c16 = e.c(colorNote2);
                if (((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).isNeedNowNotify(colorNote2)) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ReportController.o(null, "dc00898", "", "", "0X800AE8E", "0X800AE8E", i3, c16.reportType, "", "", "", "");
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void b() {
    }
}
