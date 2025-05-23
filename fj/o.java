package fj;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R2\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lfj/o;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "a", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "()Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "c", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)V", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "d", "(Ljava/util/ArrayList;)V", "rightList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData businessData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Integer> rightList = new ArrayList<>();

    /* renamed from: a, reason: from getter */
    public final BusinessFeedData getBusinessData() {
        return this.businessData;
    }

    public final ArrayList<Integer> b() {
        return this.rightList;
    }

    public final void c(BusinessFeedData businessFeedData) {
        this.businessData = businessFeedData;
    }

    public final void d(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.rightList = arrayList;
    }
}
