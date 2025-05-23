package dq2;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0004H\u0016J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Ldq2/g;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "", "isSingleStatusInSearch", "", "N1", "M1", "Landroidx/lifecycle/MutableLiveData;", "L1", "i", "Z", "getMIsSingleStatusInSearch", "()Z", "setMIsSingleStatusInSearch", "(Z)V", "mIsSingleStatusInSearch", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "addResultRecordLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSingleStatusInSearch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> addResultRecordLiveData = new MutableLiveData<>();

    public final MutableLiveData<Boolean> L1() {
        return this.addResultRecordLiveData;
    }

    /* renamed from: M1, reason: from getter */
    public boolean getMIsSingleStatusInSearch() {
        return this.mIsSingleStatusInSearch;
    }

    public final void N1(boolean isSingleStatusInSearch) {
        this.mIsSingleStatusInSearch = isSingleStatusInSearch;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "ForwardFriend..SelectedAndSearchViewModel";
    }
}
