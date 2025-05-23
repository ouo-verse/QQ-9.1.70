package com.tencent.aio.api.refreshLoad;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.refreshLoad.b;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/api/refreshLoad/c;", "Lcom/tencent/aio/api/refreshLoad/b;", "Lcom/tencent/aio/api/refreshLoad/c$b;", "listener", "", "l", "", "enable", "a", "setEnableLoadMore", "finishRefresh", "j", "k", "", "time", UserInfo.SEX_FEMALE, "c", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface c extends com.tencent.aio.api.refreshLoad.b {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class a {
        @Deprecated(message = "\u5e9f\u5f03")
        public static void a(@NotNull c cVar, int i3) {
            b.a.a(cVar, i3);
        }

        @Deprecated(message = "\u5e9f\u5f03")
        public static void b(@NotNull c cVar, int i3) {
            b.a.b(cVar, i3);
        }
    }

    void F(long time);

    void a(boolean enable);

    void c(long time);

    void finishRefresh();

    void j();

    void k();

    void l(@NotNull b listener);

    void setEnableLoadMore(boolean enable);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/api/refreshLoad/c$b;", "", "", HippyScrollViewEventHelper.EVENT_TYPE_REFRESH, ReportConstant.COSTREPORT_PREFIX, "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public interface b {
        void onRefresh();

        void s();

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes3.dex */
        public static final class a {
            public static void a(@NotNull b bVar) {
            }
        }
    }
}
