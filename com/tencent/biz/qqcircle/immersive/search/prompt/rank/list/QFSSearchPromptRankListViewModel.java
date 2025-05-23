package com.tencent.biz.qqcircle.immersive.search.prompt.rank.list;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import circlesearch.CircleSearchExhibition$TextIconStyleData;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankDataModel;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\f\u001a\u00020\u000bH\u0016R \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/list/QFSSearchPromptRankListViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "byteList", "Lcirclesearch/CircleSearchExhibition$TextIconStyleData;", "P1", "Landroid/os/Bundle;", "bundle", "", "O1", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_initLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "initLiveData", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankListViewModel extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData>> _initLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData>> initLiveData;

    public QFSSearchPromptRankListViewModel() {
        MutableLiveData<QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData>> mutableLiveData = new MutableLiveData<>();
        this._initLiveData = mutableLiveData;
        this.initLiveData = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<CircleSearchExhibition$TextIconStyleData> P1(List<ByteStringMicro> byteList) {
        ArrayList arrayList = new ArrayList();
        try {
            for (ByteStringMicro byteStringMicro : byteList) {
                CircleSearchExhibition$TextIconStyleData circleSearchExhibition$TextIconStyleData = new CircleSearchExhibition$TextIconStyleData();
                circleSearchExhibition$TextIconStyleData.mergeFrom(byteStringMicro.toByteArray());
                arrayList.add(circleSearchExhibition$TextIconStyleData);
            }
        } catch (Exception e16) {
            QLog.e(getLogTag(), 1, "[parseData] ", e16);
        }
        return arrayList;
    }

    @NotNull
    public final LiveData<QFSSearchPromptRankDataModel<CircleSearchExhibition$TextIconStyleData>> N1() {
        return this.initLiveData;
    }

    public final void O1(@Nullable Bundle bundle) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QFSSearchPromptRankListViewModel$initData$1(bundle, this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSSearchPromptRankListViewModel";
    }
}
