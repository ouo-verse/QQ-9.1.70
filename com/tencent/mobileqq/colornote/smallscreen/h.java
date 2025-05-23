package com.tencent.mobileqq.colornote.smallscreen;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h implements l {
    private QQAppInterface b() {
        return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    private void c(List<ColorNote> list) {
        if (list != null && list.size() != 0) {
            z61.d dVar = (z61.d) b().getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER);
            if (dVar != null) {
                Iterator<ColorNote> it = list.iterator();
                while (it.hasNext()) {
                    dVar.u(it.next());
                }
                return;
            }
            QLog.e("ColorNoteUpcomingServic", 1, "manager not init");
            return;
        }
        QLog.e("ColorNoteUpcomingServic", 1, "note size 0");
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.n
    public void a(AppService appService) {
        b().addObserver(new ea1.b());
        ((ColorNoteHandler) b().getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).H2();
        c(((IColorNoteDataService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes());
    }
}
