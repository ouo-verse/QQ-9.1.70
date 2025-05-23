package com.tencent.qqnt.shortvideo.api;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0012J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH'J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H'J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/shortvideo/api/IVideoEncode;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "thumbPath", "thumbMD5", "videoPath", "Lcom/tencent/qqnt/shortvideo/api/IVideoEncode$a;", "cb", "", "encodeVideo", "removeEncodeTask", "Landroid/os/Bundle;", "bundle", "setEncodeParam", "a", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IVideoEncode extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/shortvideo/api/IVideoEncode$a;", "", "", "errorCode", "", "onError", "", "videoPath", "videoCodecFormatType", "a", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.qqnt.shortvideo.api.IVideoEncode$a$a, reason: collision with other inner class name */
        /* loaded from: classes25.dex */
        public static final class C9700a {
            public static /* synthetic */ void a(a aVar, String str, int i3, int i16, Object obj) {
                if (obj == null) {
                    if ((i16 & 2) != 0) {
                        i3 = 0;
                    }
                    aVar.a(str, i3);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
            }
        }

        void a(@Nullable String videoPath, int videoCodecFormatType);

        void onError(int errorCode);
    }

    @MainThread
    void encodeVideo(@NotNull Context context, long taskId, @NotNull String thumbPath, @NotNull String thumbMD5, @NotNull String videoPath, @NotNull a cb5);

    @MainThread
    void removeEncodeTask(long taskId);

    void setEncodeParam(@NotNull Bundle bundle);
}
