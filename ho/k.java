package ho;

import android.content.Context;
import android.content.Intent;
import com.qzone.common.activities.base.ak;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes38.dex */
public class k implements a {
    public void a(Context context, String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4, String str5) {
        if (context == null) {
            return;
        }
        Intent O = ak.O(context);
        O.putExtra(PeakConstants.VIDEO_THUMBNAIL_PATH, str2);
        O.putExtra("file_send_path", str3);
        O.putExtra(PeakConstants.VIDEO_TYPE, i3);
        O.putExtra(PeakConstants.VIDEO_THUMBNAIL_WIDTH, i16);
        O.putExtra(PeakConstants.VIDEO_THUMBNAIL_HEIGHT, i17);
        O.putExtra(PeakConstants.QZONE_ALBUM_VIDEO_ID, str);
        O.putExtra(PeakConstants.COVER_TYPE, i18);
        O.putExtra("COVER_STRING_TYPE", str4);
        O.putExtra("name", str5);
        O.setFlags(268435456);
        com.qzone.feed.utils.b.d(context, O);
    }
}
