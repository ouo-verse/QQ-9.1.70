package com.tencent.mobileqq.activity.emogroupstore;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.activity.emogroupstore.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000f\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/activity/emogroupstore/k;", "Lcom/tencent/mobileqq/activity/emogroupstore/c;", "userIntent", "", "N1", "Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/emogroupstore/EmoticonGroupDataSource;", "emoticonGroupDataSource", "D", "Lcom/tencent/mobileqq/activity/emogroupstore/c;", "M1", "()Lcom/tencent/mobileqq/activity/emogroupstore/c;", "mNoneValueIntent", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class EmoticonGroupViewModel extends BaseViewModel<k, c> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final EmoticonGroupDataSource emoticonGroupDataSource;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c mNoneValueIntent;

    public EmoticonGroupViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.emoticonGroupDataSource = new EmoticonGroupDataSource();
            this.mNoneValueIntent = c.b.f182126a;
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public c getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull c userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (!Intrinsics.areEqual(userIntent, c.b.f182126a) && (userIntent instanceof c.a)) {
            c.a aVar = (c.a) userIntent;
            QLog.d("EmoticonGroupViewModel", 1, "handleIntent GetEmoListCompleted. userIntent.requestCount=" + aVar.a() + ", userIntent.filterMsgFromTime=" + aVar.b());
            FlowKt.launchIn(FlowKt.onEach(this.emoticonGroupDataSource.b(aVar.a(), aVar.b()), new EmoticonGroupViewModel$handleIntent$1(this, null)), ViewModelKt.getViewModelScope(this));
        }
    }
}
