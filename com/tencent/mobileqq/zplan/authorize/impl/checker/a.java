package com.tencent.mobileqq.zplan.authorize.impl.checker;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/a;", BdhLogUtil.LogTag.Tag_Req, "T", "", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "checker", "a", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "b", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/tencent/mobileqq/zplan/authorize/api/a;)V", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "firstChecker", "currentChecker", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a<R, T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private BaseChecker<R, T> firstChecker;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private BaseChecker<R, T> currentChecker;

    public final a<R, T> a(BaseChecker<R, T> checker) {
        Intrinsics.checkNotNullParameter(checker, "checker");
        if (this.firstChecker == null) {
            this.firstChecker = checker;
            this.currentChecker = checker;
        } else {
            BaseChecker<R, T> baseChecker = this.currentChecker;
            if (baseChecker != null) {
                baseChecker.g(checker);
            }
            this.currentChecker = checker;
        }
        return this;
    }

    public void b(R request, T lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<T> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseChecker<R, T> baseChecker = this.firstChecker;
        String b16 = baseChecker != null ? baseChecker.b() : null;
        BaseChecker<R, T> baseChecker2 = this.currentChecker;
        QLog.i("Checker_Builder", 1, "check firstChecker:" + b16 + " currentChecker:" + (baseChecker2 != null ? baseChecker2.b() : null));
        BaseChecker<R, T> baseChecker3 = this.firstChecker;
        if (baseChecker3 != null) {
            baseChecker3.a(request, lastCheckResult, callback);
        }
    }
}
