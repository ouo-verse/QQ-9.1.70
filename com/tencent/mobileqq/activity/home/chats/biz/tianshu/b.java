package com.tencent.mobileqq.activity.home.chats.biz.tianshu;

import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.ui.third.f;
import com.tencent.qqnt.chats.core.ui.third.g;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/tianshu/b;", "Lcom/tencent/qqnt/chats/core/ui/third/g$a;", "", "Lcom/tencent/qqnt/chats/core/ui/third/f;", "existList", "", "update", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b implements g.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "TianShuThirdViewPramsProvider";
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.third.g.a
    public void update(@NotNull List<f> existList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) existList);
            return;
        }
        Intrinsics.checkNotNullParameter(existList, "existList");
        QLog.i(this.TAG, 1, "update");
        f fVar = new f(ThirdViewEnum.TIANSHU_AD);
        fVar.e(new ViewGroup.LayoutParams(-2, -2));
        existList.add(fVar);
    }
}
