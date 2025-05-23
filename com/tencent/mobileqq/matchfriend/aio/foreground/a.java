package com.tencent.mobileqq.matchfriend.aio.foreground;

import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\u0003\u0010\rR$\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\t\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/foreground/a;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "getParam", "()Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "param", "Lm72/d;", "b", "Lm72/d;", "getLottieResLoadResult", "()Lm72/d;", "(Lm72/d;)V", "lottieResLoadResult", "c", "getMutualMarkResLoadResult", "mutualMarkResLoadResult", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerInteractiveMarkModel param;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private m72.d lottieResLoadResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private m72.d mutualMarkResLoadResult;

    public a(QQStrangerInteractiveMarkModel param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    public final void a(m72.d dVar) {
        this.lottieResLoadResult = dVar;
    }

    public final void b(m72.d dVar) {
        this.mutualMarkResLoadResult = dVar;
    }
}
