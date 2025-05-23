package com.tencent.aelight.camera.ae.flashshow.ui;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/aa;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Intent;", "intent", "", "M1", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "model", "N1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "interactiveModel", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "L1", "()Landroidx/lifecycle/LiveData;", "interactiveModelLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class aa extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<InteractiveModel> interactiveModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<InteractiveModel> interactiveModelLiveData;

    public aa() {
        MutableLiveData<InteractiveModel> mutableLiveData = new MutableLiveData<>();
        this.interactiveModel = mutableLiveData;
        this.interactiveModelLiveData = mutableLiveData;
    }

    public final LiveData<InteractiveModel> L1() {
        return this.interactiveModelLiveData;
    }

    public final void M1(Intent intent) {
        TagRetriever tagRetriever = TagRetriever.f326413a;
        String i3 = tagRetriever.i(intent);
        if (i3 != null) {
            long h16 = tagRetriever.h(intent);
            w53.b.a("AEFlashShowChallengeViewModel", "initData... challenge_tag:" + i3 + " challenge_nums:" + h16);
            this.interactiveModel.postValue(new InteractiveModel(0.0f, 0.0f, 0.0f, 0.0f, i3, h16, 15, null));
        }
    }

    public final void N1(InteractiveModel model) {
        w53.b.a("AEFlashShowChallengeViewModel", "postInteractiveModel... model:" + model);
        InteractiveModel value = this.interactiveModel.getValue();
        if (value != null && value.getJoinNums() != 0 && model != null) {
            model.setJoinNums(value.getJoinNums());
        }
        this.interactiveModel.postValue(model);
    }
}
