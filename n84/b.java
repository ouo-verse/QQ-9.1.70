package n84;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.ZootopiaPlayerView;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pv4.s;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016\u00a8\u0006\u0019"}, d2 = {"Ln84/b;", "Lqa4/b;", "Lpv4/s;", "Ln84/a;", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "p0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "r0", "holder", "data", "position", "size", "", "q0", "", "bannerDataList", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends qa4.b<s, a> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, List<s> bannerDataList) {
        super(context, bannerDataList);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bannerDataList, "bannerDataList");
    }

    private final ZPlanMediaView p0(Context context) {
        ZPlanMediaView zPlanMediaView = new ZPlanMediaView(context);
        zPlanMediaView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ZootopiaPlayerView n3 = zPlanMediaView.n();
        ImageView n16 = n3 != null ? n3.n() : null;
        if (n16 != null) {
            n16.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        return zPlanMediaView;
    }

    @Override // qa4.c
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void d0(a holder, s data, int position, int size) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        g gVar = data.f427681b;
        if (gVar != null) {
            QLog.d("FloatBannerAdapter", 1, "onBindView: " + position + " -- " + gVar);
            ZPlanMediaView mediaView = holder.getMediaView();
            g gVar2 = data.f427681b;
            Intrinsics.checkNotNullExpressionValue(gVar2, "data.material");
            mediaView.J(gVar2);
        }
    }

    @Override // qa4.c
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public a u(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        ZPlanMediaView p06 = p0(context);
        p06.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        return new a(p06);
    }
}
