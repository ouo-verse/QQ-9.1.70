package com.tencent.qqnt.chathistory.ui.category;

import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.CallSuper;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.category.c;
import com.tencent.qqnt.chathistory.ui.category.title.TitleRightUIProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\u0010\b\u0000\u0010\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0017\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/category/BaseSubCategoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "T", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "", OcrConfig.CHINESE, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BaseSubCategoryFragment<T extends BaseHistoryViewModel<?, ?>> extends BaseHistoryFragment<T> {
    static IPatchRedirector $redirector_;

    public BaseSubCategoryFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zh() {
        if ((getParentFragment() instanceof c.b) && (this instanceof c)) {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.ui.category.ICateTitleDelegateOwner.ICateTitleUIDelegate");
            new TitleRightUIProcessor(this, (c) this, (c.b) parentFragment);
        }
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            zh();
        }
    }
}
