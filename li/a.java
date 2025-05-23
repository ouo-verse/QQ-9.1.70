package li;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.media.QZoneMediaBusiness;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J$\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lli/a;", "Ltl/a;", "", "c", "Lcooperation/qzone/media/QZoneMediaBusiness;", "d", "", "i", "e", "g", "", "", "imageList", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends tl.a {
    @Override // tl.a
    public int c() {
        return 100;
    }

    @Override // tl.a
    public QZoneMediaBusiness d() {
        return QZoneMediaBusiness.QZONE_GROUP_RESHIP_ALBUM;
    }

    @Override // tl.a
    public boolean e() {
        return true;
    }

    @Override // tl.a
    public boolean g() {
        return true;
    }

    @Override // tl.a
    public boolean i() {
        return true;
    }

    @Override // tl.a
    public void a(List<String> imageList, Context context) {
        if (imageList == null || context == null || !(context instanceof Activity) || !imageList.isEmpty()) {
            return;
        }
        Activity activity = (Activity) context;
        QQToast.makeText(activity.getApplicationContext(), activity.getString(R.string.to7), 0).show();
        activity.finish();
    }
}
