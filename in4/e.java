package in4;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.room.impl.test.TimiCfmTestFragment;
import com.tencent.timi.game.room.impl.test.TimiCodmTestFragment;
import com.tencent.timi.game.test.impl.TimiGameMainTestFragment;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.q;
import gh4.f;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e implements hn4.a {
    public static void N3(Context context, int i3) {
        ExpandHallLaunchParam expandHallLaunchParam = new ExpandHallLaunchParam();
        expandHallLaunchParam.f376303f = i3;
        ((f) mm4.b.b(f.class)).openExpandHall(context, expandHallLaunchParam);
    }

    @Override // hn4.a
    public void H1(View view) {
        try {
            q.e(Class.forName("hexin.androidbitmapcanary.ActivityDrawableWatcher"), "watchDrawable", new Class[]{View.class}, new Object[]{view});
        } catch (Exception unused) {
            l.m("TimiGameTestServiceImpl", "watchDrawable reflect error");
        }
    }

    @Override // hn4.a
    public void openTimiGameTestPage() {
        QBaseActivity b16 = vf4.a.b();
        l.i("TimiGameTestServiceImpl", "openTimiGameTestPage - " + b16);
        if (b16 == null) {
            com.tencent.timi.game.ui.widget.f.c("Context\u4e3a\u7a7a\uff01");
        } else {
            QPublicFragmentActivity.b.c(b16, QPublicFragmentActivity.class, TimiGameMainTestFragment.class);
        }
    }

    @Override // hn4.a
    public void openTimiGameTmpDebugTestPage(int i3) {
        int i16 = 101;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 101) {
                                if (i3 == 102) {
                                    TimiCfmTestFragment.ph(vf4.a.b());
                                }
                            } else {
                                TimiCodmTestFragment.ph(vf4.a.b());
                            }
                            i16 = 0;
                        } else {
                            i16 = 105;
                        }
                    } else {
                        i16 = 103;
                    }
                } else {
                    i16 = 104;
                }
            } else {
                i16 = 102;
            }
        }
        if (i16 > 0) {
            N3(vf4.a.b(), i16);
        }
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
