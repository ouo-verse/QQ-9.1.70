package com.tencent.mobileqq.zplan.aigc.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0005\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/a;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_backEvent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getBackEvent", "()Landroidx/lifecycle/MutableLiveData;", "backEvent", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Object> _backEvent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Object> backEvent;

    public a() {
        MutableLiveData<Object> mutableLiveData = new MutableLiveData<>();
        this._backEvent = mutableLiveData;
        this.backEvent = mutableLiveData;
    }
}
