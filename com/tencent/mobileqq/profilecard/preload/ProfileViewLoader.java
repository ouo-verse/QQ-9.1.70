package com.tencent.mobileqq.profilecard.preload;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/profilecard/preload/ProfileViewLoader;", "Lcom/tencent/mobileqq/profilecard/preload/IProfileViewLoader;", "()V", "mContext", "Landroid/content/Context;", "preloadResourceIdList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "preloadViewMap", "Ljava/util/HashMap;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "getViewById", "resId", "startPreload", "", "context", "Companion", "profilecard_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ProfileViewLoader implements IProfileViewLoader {
    private static final String tag = "ProfileViewLoader";
    private Context mContext;
    private final ArrayList<Integer> preloadResourceIdList;
    private final HashMap<Integer, View> preloadViewMap;

    public ProfileViewLoader() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.preloadResourceIdList = arrayList;
        arrayList.addAll(((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getPreloadResIds());
        arrayList.add(Integer.valueOf(R.layout.hhc));
        arrayList.add(Integer.valueOf(R.layout.hhd));
        arrayList.add(Integer.valueOf(R.layout.h0e));
        arrayList.add(Integer.valueOf(R.layout.b07));
        arrayList.add(Integer.valueOf(R.layout.f168841h10));
        this.preloadViewMap = new HashMap<>();
    }

    @Override // com.tencent.mobileqq.profilecard.preload.IProfileViewLoader
    public View getViewById(int resId) {
        if (!this.preloadViewMap.containsKey(Integer.valueOf(resId))) {
            Context context = this.mContext;
            if (context == null || !QLog.isColorLevel()) {
                return null;
            }
            QLog.i(tag, 2, "getViewById:" + context.getResources().getResourceName(resId) + ",not found!");
            return null;
        }
        Context context2 = this.mContext;
        if (context2 != null && QLog.isColorLevel()) {
            QLog.i(tag, 2, "getViewById:" + context2.getResources().getResourceName(resId) + ",found!");
        }
        return this.preloadViewMap.get(Integer.valueOf(resId));
    }

    @Override // com.tencent.mobileqq.profilecard.preload.IProfileViewLoader
    public void startPreload(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        RFWAsyncLayoutInflater rFWAsyncLayoutInflater = new RFWAsyncLayoutInflater(context);
        Iterator<T> it = this.preloadResourceIdList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            QLog.i(tag, 1, "preload:" + context.getResources().getResourceName(intValue));
            rFWAsyncLayoutInflater.inflate(intValue, null, new RFWAsyncLayoutInflater.OnInflateFinishedListener() { // from class: com.tencent.mobileqq.profilecard.preload.ProfileViewLoader$startPreload$1$1
                @Override // com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater.OnInflateFinishedListener
                public void onInflateError(Throwable e16) {
                    String str;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onInflateError:");
                    if (e16 == null || (str = e16.getMessage()) == null) {
                        str = "unknown";
                    }
                    sb5.append(str);
                    QLog.i("ProfileViewLoader", 1, sb5.toString());
                }

                @Override // com.tencent.biz.richframework.layoutinflater.RFWAsyncLayoutInflater.OnInflateFinishedListener
                public void onInflateFinished(View view, int resid, ViewGroup parent, boolean isMerge) {
                    HashMap hashMap;
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (QLog.isColorLevel()) {
                        QLog.i("ProfileViewLoader", 2, "onInflateFinished:" + context.getResources().getResourceName(resid));
                    }
                    Integer valueOf = Integer.valueOf(resid);
                    hashMap = this.preloadViewMap;
                    hashMap.put(valueOf, view);
                }
            });
        }
    }
}
