package lp1;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0004"}, d2 = {"Llp1/c;", "", "d", "c", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(SubTabData subTabData) {
        int type = subTabData.getType();
        if (type != 1) {
            if (type != 6) {
                if (type != 99) {
                    return "guild_home_unknown_tab";
                }
                return "feed_section";
            }
            int urlType = subTabData.getUrlType();
            if (urlType != 1) {
                if (urlType != 2) {
                    return "guild_home_common_unknown_tab";
                }
                return "Guild_Kuikly_Tab";
            }
            return "Guild_H5_Tab";
        }
        return "Guild_Main_Tab";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(SubTabData subTabData) {
        int type = subTabData.getType();
        if (type == 1) {
            return "stage_feed_tab";
        }
        if (type != 6) {
            if (type == 99) {
                return "stage_feed_tab";
            }
        } else {
            int urlType = subTabData.getUrlType();
            if (urlType != 1) {
                if (urlType == 2) {
                    return "stage_kuikly_tab";
                }
            } else {
                return "stage_h5_tab";
            }
        }
        return "stage_unknown_tab";
    }
}
