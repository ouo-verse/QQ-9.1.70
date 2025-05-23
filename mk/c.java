package mk;

import android.text.TextUtils;
import com.qzone.reborn.util.k;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u001e\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\f\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\r\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0016"}, d2 = {"Lmk/c;", "", "", "Lqzone/QZoneBaseMeta$StPicSpecUrlEntry;", "urlEntryList", "", "photoSpec", "Lqzone/QZoneBaseMeta$StPicUrl;", "e", "a", "", "d", "f", "c", "Lqzone/QZoneBaseMeta$StMedia;", QAdVrReportParams.ParamKey.MEDIA, "", "g", "dayImgUrl", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f416874a = new c();

    c() {
    }

    public final int c(List<QZoneBaseMeta$StPicSpecUrlEntry> urlEntryList, int photoSpec) {
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl;
        PBInt32Field pBInt32Field;
        QZoneBaseMeta$StPicUrl e16 = e(urlEntryList, photoSpec);
        if (e16 == null || (qZoneBaseMeta$StPicUrl = e16.get()) == null || (pBInt32Field = qZoneBaseMeta$StPicUrl.height) == null) {
            return 0;
        }
        return pBInt32Field.get();
    }

    public final String d(List<QZoneBaseMeta$StPicSpecUrlEntry> urlEntryList, int photoSpec) {
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl;
        PBStringField pBStringField;
        QZoneBaseMeta$StPicUrl e16 = e(urlEntryList, photoSpec);
        String str = (e16 == null || (qZoneBaseMeta$StPicUrl = e16.get()) == null || (pBStringField = qZoneBaseMeta$StPicUrl.url) == null) ? null : pBStringField.get();
        return str == null ? "" : str;
    }

    public final int f(List<QZoneBaseMeta$StPicSpecUrlEntry> urlEntryList, int photoSpec) {
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl;
        PBInt32Field pBInt32Field;
        QZoneBaseMeta$StPicUrl e16 = e(urlEntryList, photoSpec);
        if (e16 == null || (qZoneBaseMeta$StPicUrl = e16.get()) == null || (pBInt32Field = qZoneBaseMeta$StPicUrl.width) == null) {
            return 0;
        }
        return pBInt32Field.get();
    }

    public final QZoneBaseMeta$StPicUrl a(List<QZoneBaseMeta$StPicSpecUrlEntry> urlEntryList) {
        QZoneBaseMeta$StPicUrl e16 = e(urlEntryList, 5);
        if (!ij.h.f(e16)) {
            e16 = e(urlEntryList, 1);
        }
        if (!ij.h.f(e16)) {
            e16 = e(urlEntryList, 6);
        }
        return !ij.h.f(e16) ? e(urlEntryList, 0) : e16;
    }

    public final String b(String dayImgUrl) {
        String replace$default;
        if (dayImgUrl == null || dayImgUrl.length() == 0) {
            dayImgUrl = "";
        }
        String str = dayImgUrl;
        if (!k.f59549a.f()) {
            return str;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(str, "/day/", "/night/", false, 4, (Object) null);
        return replace$default;
    }

    public final boolean g(QZoneBaseMeta$StMedia media) {
        return media != null && media.type.get() == 1;
    }

    public final QZoneBaseMeta$StPicUrl e(List<QZoneBaseMeta$StPicSpecUrlEntry> urlEntryList, int photoSpec) {
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = null;
        if (urlEntryList != null) {
            for (QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry : urlEntryList) {
                if (qZoneBaseMeta$StPicSpecUrlEntry.spec.get() == photoSpec && !TextUtils.isEmpty(qZoneBaseMeta$StPicSpecUrlEntry.url.url.get())) {
                    return qZoneBaseMeta$StPicSpecUrlEntry.url.get();
                }
                if (qZoneBaseMeta$StPicUrl == null && !TextUtils.isEmpty(qZoneBaseMeta$StPicSpecUrlEntry.url.url.get())) {
                    qZoneBaseMeta$StPicUrl = qZoneBaseMeta$StPicSpecUrlEntry.url.get();
                }
            }
        }
        return qZoneBaseMeta$StPicUrl;
    }
}
