package e94;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.sqshow.zootopia.nativeui.data.OrientationMode;
import g94.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Le94/b;", "Lg94/g;", "", "d", h.F, "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "w", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", HippyTKDListViewAdapter.X, "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "orientationMode", "y", UserInfo.SEX_FEMALE, "mItemWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "mItemHeight", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends g {

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final OrientationMode orientationMode;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final float mItemWidth;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final float mItemHeight;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, OrientationMode orientationMode) {
        super(context, orientationMode);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orientationMode, "orientationMode");
        this.context = context;
        this.orientationMode = orientationMode;
        this.mItemWidth = context.getResources().getDimension(R.dimen.f11414p);
        this.mItemHeight = context.getResources().getDimension(R.dimen.f11404o);
    }

    @Override // g94.g
    /* renamed from: d, reason: from getter */
    public float getMItemHeight() {
        return this.mItemHeight;
    }

    @Override // g94.g
    /* renamed from: h, reason: from getter */
    public float getMItemWidth() {
        return this.mItemWidth;
    }

    @Override // g94.g
    /* renamed from: n */
    public int getCom.google.android.exoplayer2.text.ttml.TtmlNode.TAG_SPAN java.lang.String() {
        return 2;
    }
}
