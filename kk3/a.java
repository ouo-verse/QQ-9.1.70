package kk3;

import android.view.Surface;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.room.impl.meeting.QQMeetingPlayerImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J,\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J,\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lkk3/a;", "", "", "preInitTRTC", "", "userId", "playScreenCapture", "Landroid/view/Surface;", "surface", "", "width", "height", "playScreenCaptureWithSurface", "updateScreenCaptureSurface", "stopPlayScreenCapture", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = QQMeetingPlayerImpl.class)
/* loaded from: classes38.dex */
public interface a {
    void playScreenCapture(String userId);

    void playScreenCaptureWithSurface(String userId, Surface surface, int width, int height);

    void preInitTRTC();

    void stopPlayScreenCapture(String userId);

    void updateScreenCaptureSurface(String userId, Surface surface, int width, int height);
}
