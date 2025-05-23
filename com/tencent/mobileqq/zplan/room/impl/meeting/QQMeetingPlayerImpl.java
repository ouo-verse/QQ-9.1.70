package com.tencent.mobileqq.zplan.room.impl.meeting;

import android.view.Surface;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import gk3.b;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J,\u0010\f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J,\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingPlayerImpl;", "Lkk3/a;", "", "preInitTRTC", "", "userId", "playScreenCapture", "Landroid/view/Surface;", "surface", "", "width", "height", "playScreenCaptureWithSurface", "updateScreenCaptureSurface", "stopPlayScreenCapture", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQMeetingPlayerImpl implements kk3.a {
    @Override // kk3.a
    public void playScreenCapture(String userId) {
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).t(userId, null, null);
    }

    @Override // kk3.a
    public void playScreenCaptureWithSurface(String userId, Surface surface, int width, int height) {
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).r(userId, surface, width, height, new a());
    }

    @Override // kk3.a
    public void preInitTRTC() {
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).q(new b());
    }

    @Override // kk3.a
    public void stopPlayScreenCapture(String userId) {
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).stopPlayScreenCapture(userId);
    }

    @Override // kk3.a
    public void updateScreenCaptureSurface(String userId, Surface surface, int width, int height) {
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).H(userId, surface, width, height, new c());
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingPlayerImpl$a", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements b.a {
        a() {
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingPlayerImpl$b", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements b.a {
        b() {
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/meeting/QQMeetingPlayerImpl$c", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements b.a {
        c() {
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
        }
    }
}
