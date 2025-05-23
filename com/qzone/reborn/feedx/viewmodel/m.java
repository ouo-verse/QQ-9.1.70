package com.qzone.reborn.feedx.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedx/viewmodel/m;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "i", "Landroidx/lifecycle/MutableLiveData;", "L1", "()Landroidx/lifecycle/MutableLiveData;", "setLatestPostedFeedDataLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "latestPostedFeedDataLiveData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<BusinessFeedData> latestPostedFeedDataLiveData = new MutableLiveData<>();

    public final MutableLiveData<BusinessFeedData> L1() {
        return this.latestPostedFeedDataLiveData;
    }
}
