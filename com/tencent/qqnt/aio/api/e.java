package com.tencent.qqnt.aio.api;

import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/api/e;", "", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/widget/EditText;", "editText", "", "a", "Lcom/tencent/qqnt/aio/api/e$a;", "callback", "b", "c", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface e {

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J<\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/api/e$a;", "", "", "send", "", "path", "", QCircleLpReportDc010001.KEY_SUBTYPE, "textSummary", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "originalMd5", tl.h.F, "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMessage", "c", "serverId", "", "isSingleLottie", "e", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.qqnt.aio.api.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        public static final class C9450a {
            public static /* synthetic */ void a(a aVar, String str, int i3, String str2, com.tencent.qqnt.msg.data.g gVar, String str3, int i16, Object obj) {
                String str4;
                com.tencent.qqnt.msg.data.g gVar2;
                String str5;
                if (obj == null) {
                    if ((i16 & 4) != 0) {
                        str4 = null;
                    } else {
                        str4 = str2;
                    }
                    if ((i16 & 8) != 0) {
                        gVar2 = null;
                    } else {
                        gVar2 = gVar;
                    }
                    if ((i16 & 16) != 0) {
                        str5 = null;
                    } else {
                        str5 = str3;
                    }
                    aVar.h(str, i3, str4, gVar2, str5);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPicEmotion");
            }
        }

        void c(@NotNull MarkFaceMessage marketFaceMessage);

        void e(int serverId, boolean isSingleLottie);

        void h(@NotNull String path, int subType, @Nullable String textSummary, @Nullable com.tencent.qqnt.msg.data.g picExtBizInfo, @Nullable String originalMd5);

        void send();
    }

    void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull EditText editText);

    void b(@NotNull a callback);

    void c();

    @NotNull
    View createView();
}
