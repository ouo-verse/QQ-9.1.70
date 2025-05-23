package com.tencent.mobileqq.zplan.minixwconnected;

import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/c;", "", "param", "", OperateCustomButton.OPERATE_CREATE, HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "resume", "pause", "destroy", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface c {
    void create(@Nullable Object param);

    void createView();

    void destroy();

    void pause();

    void resume();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void b(c cVar, Object obj, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 1) != 0) {
                    obj = null;
                }
                cVar.create(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }

        public static void c(@NotNull c cVar) {
        }

        public static void d(@NotNull c cVar) {
        }

        public static void e(@NotNull c cVar) {
        }

        public static void a(@NotNull c cVar, @Nullable Object obj) {
        }
    }
}
