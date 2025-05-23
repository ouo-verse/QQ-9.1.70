package fj;

import android.text.TextUtils;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSpec;
import com.tencent.qqnt.kernel.nativeinterface.StPicSpecUrlEntry;
import com.tencent.qqnt.kernel.nativeinterface.StPicUrl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\r\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J&\u0010\u000e\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J \u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J(\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\u0013\u001a\u00020\u00122\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u0014\u001a\u00020\u00122\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u0015\u001a\u00020\u00122\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u0016\u001a\u00020\u00122\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005J(\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a8\u0006\u001c"}, d2 = {"Lfj/t;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/StPicSpecUrlEntry;", "urlEntryList", "Lcom/tencent/qqnt/kernel/nativeinterface/PhotoSpec;", "photoSpec", "", "isNeedCandidate", "", "i", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicSpecUrlEntry;", "commonUrlEntryList", "b", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/StPicUrl;", "e", "f", "", "d", "l", "a", tl.h.F, "j", "k", "g", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f399471a = new t();

    t() {
    }

    private final String i(List<StPicSpecUrlEntry> urlEntryList, PhotoSpec photoSpec, boolean isNeedCandidate) {
        StPicUrl k3 = k(urlEntryList, photoSpec, isNeedCandidate);
        String str = k3 != null ? k3.url : null;
        return str == null ? "" : str;
    }

    public final int a(List<CommonStPicSpecUrlEntry> commonUrlEntryList, PhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        ArrayList arrayList = new ArrayList();
        if (commonUrlEntryList != null) {
            Iterator<T> it = commonUrlEntryList.iterator();
            while (it.hasNext()) {
                arrayList.add(xh.h.j((CommonStPicSpecUrlEntry) it.next()));
            }
        }
        return h(arrayList, photoSpec);
    }

    public final String b(List<CommonStPicSpecUrlEntry> commonUrlEntryList, PhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        return c(commonUrlEntryList, photoSpec, true);
    }

    public final String c(List<CommonStPicSpecUrlEntry> commonUrlEntryList, PhotoSpec photoSpec, boolean isNeedCandidate) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        ArrayList arrayList = new ArrayList();
        if (commonUrlEntryList != null) {
            Iterator<T> it = commonUrlEntryList.iterator();
            while (it.hasNext()) {
                arrayList.add(xh.h.j((CommonStPicSpecUrlEntry) it.next()));
            }
        }
        return i(arrayList, photoSpec, isNeedCandidate);
    }

    public final int d(List<CommonStPicSpecUrlEntry> commonUrlEntryList, PhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        ArrayList arrayList = new ArrayList();
        if (commonUrlEntryList != null) {
            Iterator<T> it = commonUrlEntryList.iterator();
            while (it.hasNext()) {
                arrayList.add(xh.h.j((CommonStPicSpecUrlEntry) it.next()));
            }
        }
        return l(arrayList, photoSpec);
    }

    public final StPicUrl e(List<CommonStPicSpecUrlEntry> commonUrlEntryList, PhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        return f(commonUrlEntryList, photoSpec, true);
    }

    public final StPicUrl f(List<CommonStPicSpecUrlEntry> commonUrlEntryList, PhotoSpec photoSpec, boolean isNeedCandidate) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        ArrayList arrayList = new ArrayList();
        if (commonUrlEntryList != null) {
            Iterator<T> it = commonUrlEntryList.iterator();
            while (it.hasNext()) {
                arrayList.add(xh.h.j((CommonStPicSpecUrlEntry) it.next()));
            }
        }
        return k(arrayList, photoSpec, isNeedCandidate);
    }

    public final StPicUrl g(List<StPicSpecUrlEntry> urlEntryList) {
        StPicUrl j3 = j(urlEntryList, PhotoSpec.KPHOTOSPECCURRENT);
        if (u.a(j3)) {
            j3 = j(urlEntryList, PhotoSpec.KPHOTOSPECBIG);
        }
        if (!u.a(j3)) {
            j3 = j(urlEntryList, PhotoSpec.KPHOTOSPECDOWNLOAD);
        }
        return !u.a(j3) ? j(urlEntryList, PhotoSpec.KPHOTOSPECORIGIN) : j3;
    }

    public final int h(List<StPicSpecUrlEntry> urlEntryList, PhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        StPicUrl j3 = j(urlEntryList, photoSpec);
        if (j3 != null) {
            return j3.height;
        }
        return 0;
    }

    public final StPicUrl j(List<StPicSpecUrlEntry> urlEntryList, PhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        return k(urlEntryList, photoSpec, true);
    }

    public final StPicUrl k(List<StPicSpecUrlEntry> urlEntryList, PhotoSpec photoSpec, boolean isNeedCandidate) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        StPicUrl stPicUrl = null;
        if (urlEntryList != null) {
            for (StPicSpecUrlEntry stPicSpecUrlEntry : urlEntryList) {
                if (stPicSpecUrlEntry.spec == photoSpec.ordinal() && !TextUtils.isEmpty(stPicSpecUrlEntry.url.url)) {
                    return stPicSpecUrlEntry.url;
                }
                if (isNeedCandidate && stPicUrl == null && !TextUtils.isEmpty(stPicSpecUrlEntry.url.url)) {
                    stPicUrl = stPicSpecUrlEntry.url;
                }
            }
        }
        return stPicUrl;
    }

    public final int l(List<StPicSpecUrlEntry> urlEntryList, PhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        StPicUrl j3 = j(urlEntryList, photoSpec);
        if (j3 != null) {
            return j3.width;
        }
        return 0;
    }
}
