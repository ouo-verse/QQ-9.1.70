package com.tencent.qqnt.emotion.relatedemo.logic;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/logic/a;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "", "type", "", "isSuccess", "", "data", "", "onUpdate", "Lcom/tencent/qqnt/emotion/relatedemo/NTRelatedEmotionSearchResult;", "result", "b", "errorCode", "a", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(int errorCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, errorCode);
        }
    }

    public void b(@NotNull NTRelatedEmotionSearchResult result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(result, "result");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), Boolean.valueOf(isSuccess), data);
            return;
        }
        if (type == 1) {
            if (isSuccess && data != null) {
                b((NTRelatedEmotionSearchResult) data);
            } else if (data instanceof Integer) {
                a(((Integer) data).intValue());
            }
        }
    }
}
