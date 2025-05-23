package com.tencent.mobileqq.kandian.base.video;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a {
    public static int b(ListView listView, int i3) {
        View childAt = listView.getChildAt((i3 + listView.getHeaderViewsCount()) - listView.getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getBottom() - BaseAIOUtils.f(175.0f, listView.getResources());
        }
        return 0;
    }

    public static String d(int i3, int i16) {
        if (i3 == 123) {
            if (i16 == 103) {
                return HardCodeUtil.qqStr(R.string.v5r) + i3 + "-" + i16;
            }
            if (i16 == 108) {
                return HardCodeUtil.qqStr(R.string.f2205269c) + MsgSummary.STR_COLON + i3 + "-" + i16;
            }
            return HardCodeUtil.qqStr(R.string.v65) + i3 + "-" + i16;
        }
        if (i3 == 122) {
            if (i16 == 204) {
                return HardCodeUtil.qqStr(R.string.f172899v61) + i3 + "-" + i16;
            }
            if (i16 == 202) {
                return HardCodeUtil.qqStr(R.string.v5u) + i3 + "-" + i16;
            }
            return HardCodeUtil.qqStr(R.string.v5h) + i3 + "-" + i16;
        }
        if (i3 != 101) {
            return HardCodeUtil.qqStr(R.string.v5p) + i3 + "-" + i16;
        }
        if (i16 == 80) {
            return HardCodeUtil.qqStr(R.string.v5t) + i3 + "-" + i16;
        }
        return HardCodeUtil.qqStr(R.string.v5j) + i3 + "-" + i16;
    }

    public static String c(int i3) {
        switch (i3) {
            case 0:
                return " PLAY_STATE_IDLE ";
            case 1:
                return " PLAY_STATE_PREPARING ";
            case 2:
                return " PLAY_STATE_PREPARED ";
            case 3:
                return " PLAY_STATE_PLAYING ";
            case 4:
                return " PLAY_STATE_BUFFERING ";
            case 5:
                return " PLAY_STATE_PAUSED ";
            case 6:
                return " PLAY_STATE_ERROR ";
            case 7:
                return " PLAY_STATE_COMPLETE ";
            case 8:
                return "PLAY_STATE_DESTORY";
            default:
                return " PLAY_STATE_UNKNOW ";
        }
    }

    public static long a(int i3, int i16, int i17) {
        if (i16 <= 0) {
            return 0L;
        }
        return (i16 * 512) + ((i3 * i17) / i16);
    }
}
