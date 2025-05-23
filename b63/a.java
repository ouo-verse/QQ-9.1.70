package b63;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001f\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lb63/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "Landroid/content/Intent;", "intent", "", "M1", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "model", "N1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_interactiveModel", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "L1", "()Landroidx/lifecycle/LiveData;", "interactiveModelLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<InteractiveModel> _interactiveModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<InteractiveModel> interactiveModelLiveData;

    public a() {
        MutableLiveData<InteractiveModel> mutableLiveData = new MutableLiveData<>();
        this._interactiveModel = mutableLiveData;
        this.interactiveModelLiveData = mutableLiveData;
    }

    @NotNull
    public final LiveData<InteractiveModel> L1() {
        return this.interactiveModelLiveData;
    }

    public final void M1(@Nullable Intent intent) {
        TagRetriever tagRetriever = TagRetriever.f326413a;
        String i3 = tagRetriever.i(intent);
        if (i3 != null) {
            long h16 = tagRetriever.h(intent);
            b.a("WinkEditorChallengeViewModel", "initData... challenge_tag:" + i3 + " challenge_nums:" + h16);
            this._interactiveModel.postValue(new InteractiveModel(0.0f, 0.0f, 0.0f, 0.0f, i3, h16, 15, null));
        }
    }

    public final void N1(@Nullable InteractiveModel model) {
        b.a("WinkEditorChallengeViewModel", "postInteractiveModel... model:" + model);
        InteractiveModel value = this._interactiveModel.getValue();
        if (value != null && value.getJoinNums() != 0 && model != null) {
            model.setJoinNums(value.getJoinNums());
        }
        this._interactiveModel.postValue(model);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkEditorChallengeViewModel";
    }
}
