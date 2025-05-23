package com.tencent.mobileqq.kandian.biz.push.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/push/api/IKanDianMergeManager;", "Lmqq/app/api/IRuntimeService;", "Companion", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface IKanDianMergeManager extends IRuntimeService {
    public static final int APP_PUSH = 6;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f239414a;
    public static final int ILLEGAL_MSG = 0;
    public static final int KANDIAN_FAKE_MSG = 3;
    public static final int KANDIAN_REAL_MSG = 1;
    public static final int OX210_MSG = 5;
    public static final int SUBSCRIBE_FAKE_MSG = 4;
    public static final int SUBSCRIBE_REAL_MSG = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/push/api/IKanDianMergeManager$a;", "", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f239414a = new Companion();

        Companion() {
        }
    }
}
