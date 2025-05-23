package bk;

import android.text.TextUtils;
import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010R>\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lbk/a;", "", "", "spaceId", "", "c", "e", "d", "Lcom/qzone/reborn/intimate/bean/QZIntimateSpaceVipInfoBean;", "bean", "", "g", "f", "", "spaceType", "a", "(Ljava/lang/Integer;)I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setVipInfoMap", "(Ljava/util/HashMap;)V", "vipInfoMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28490a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static HashMap<String, QZIntimateSpaceVipInfoBean> vipInfoMap = new HashMap<>();

    a() {
    }

    public final int a(Integer spaceType) {
        mk.d dVar = mk.d.f416875a;
        return dVar.y(spaceType) ? R.drawable.f16068r : dVar.w(spaceType) ? R.drawable.f16048p : dVar.H(spaceType) ? R.drawable.f16088t : dVar.t(spaceType) ? R.drawable.f16058q : dVar.F(spaceType) ? R.drawable.f16078s : R.drawable.f16068r;
    }

    public final HashMap<String, QZIntimateSpaceVipInfoBean> b() {
        return vipInfoMap;
    }

    public final boolean c(String spaceId) {
        QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean;
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        return vipInfoMap.containsKey(spaceId) && (qZIntimateSpaceVipInfoBean = vipInfoMap.get(spaceId)) != null && qZIntimateSpaceVipInfoBean.k();
    }

    public final String d(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        if (!c(spaceId) || !vipInfoMap.containsKey(spaceId)) {
            return "";
        }
        QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean = vipInfoMap.get(spaceId);
        if (TextUtils.isEmpty(qZIntimateSpaceVipInfoBean != null ? qZIntimateSpaceVipInfoBean.getFeedPraiseUrl() : null)) {
            return "";
        }
        Intrinsics.checkNotNull(qZIntimateSpaceVipInfoBean);
        return qZIntimateSpaceVipInfoBean.getFeedPraiseUrl();
    }

    public final String e(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        if (!c(spaceId) || !vipInfoMap.containsKey(spaceId)) {
            return "";
        }
        QZIntimateSpaceVipInfoBean qZIntimateSpaceVipInfoBean = vipInfoMap.get(spaceId);
        if (TextUtils.isEmpty(qZIntimateSpaceVipInfoBean != null ? qZIntimateSpaceVipInfoBean.getFeedAvatarUrl() : null)) {
            return "";
        }
        Intrinsics.checkNotNull(qZIntimateSpaceVipInfoBean);
        return qZIntimateSpaceVipInfoBean.getFeedAvatarUrl();
    }

    public final void f(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        if (TextUtils.isEmpty(spaceId)) {
            return;
        }
        vipInfoMap.remove(spaceId);
    }

    public final void g(QZIntimateSpaceVipInfoBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        vipInfoMap.put(bean.getSpaceId(), bean);
    }
}
