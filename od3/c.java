package od3;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u000bH&J\u0012\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u000bH&\u00a8\u0006\u0012"}, d2 = {"Lod3/c;", "", "Lod3/d;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lod3/b;", "portal", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", "j", "show", "", "outDuration", "f", "destroy", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface c extends d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(c cVar, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    j3 = -1;
                }
                cVar.f(j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hide");
        }
    }

    void destroy();

    void f(long outDuration);

    void j(@NotNull FragmentActivity activity, @Nullable QBaseFragment fragment, @Nullable b portal, @NotNull ViewGroup container);

    void show();
}
