package com.qzone.widget;

import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.widget.EmoEditPanel;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e implements EmoEditPanel.ak {

    /* renamed from: a, reason: collision with root package name */
    private final int f60842a;

    public e(int i3) {
        this.f60842a = i3;
    }

    public static boolean b(Event event) {
        int[] iArr;
        if (!"ExoticPositionBag".equals(event.source.getName())) {
            return false;
        }
        try {
            iArr = (int[]) event.params;
        } catch (Exception e16) {
            QZLog.w("ExoticPositionBag", "onEventUIThread: failed to get param", e16);
            iArr = null;
        }
        if (iArr != null && iArr.length != 0) {
            EditPositionBag h16 = EditPositionBag.h(iArr[0]);
            if (h16 == null) {
                QZLog.i("ExoticPositionBag", "onEventUIThread: empty position bag " + event.what);
                return true;
            }
            switch (event.what) {
                case 54610:
                    if (iArr.length < 2) {
                        QZLog.w("ExoticPositionBag", "onEventUIThread: wrong show param " + event.what);
                        break;
                    } else {
                        h16.a(iArr[1]);
                        break;
                    }
                case 54611:
                    h16.onHide();
                    break;
                default:
                    QZLog.w("ExoticPositionBag", "onEventUIThread: wrong what " + event.what);
                    break;
            }
        }
        return true;
    }

    @Override // com.qzone.widget.EmoEditPanel.ak
    public void a(int i3) {
        EventCenter.getInstance().post("ExoticPositionBag", 54610, new int[]{this.f60842a, i3});
    }

    @Override // com.qzone.widget.EmoEditPanel.ak
    public void onHide() {
        EventCenter.getInstance().post("ExoticPositionBag", 54611, new int[]{this.f60842a});
    }
}
