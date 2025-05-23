package com.tencent.biz.richframework.monitor.sample;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0014\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleManager;", "", "getMeetStrategies", "", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "hitSample", "", "key", "", "monitor_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IRFWSampleManager {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static boolean hitSample(@NotNull IRFWSampleManager iRFWSampleManager, @Nullable String str) {
            Object obj;
            Iterator<T> it = iRFWSampleManager.getMeetStrategies().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((IRFWSampleMeetStrategy) obj).isTargetType()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((IRFWSampleMeetStrategy) obj) == null || Random.INSTANCE.nextDouble() >= r0.getSampleSize(str)) {
                return false;
            }
            return true;
        }

        public static /* synthetic */ boolean hitSample$default(IRFWSampleManager iRFWSampleManager, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = "";
                }
                return iRFWSampleManager.hitSample(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hitSample");
        }
    }

    @NotNull
    List<IRFWSampleMeetStrategy> getMeetStrategies();

    boolean hitSample(@Nullable String key);
}
