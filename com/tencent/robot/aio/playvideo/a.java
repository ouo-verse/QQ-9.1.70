package com.tencent.robot.aio.playvideo;

import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/aio/playvideo/a;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class a implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\n\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/robot/aio/playvideo/a$a;", "Lcom/tencent/robot/aio/playvideo/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "(Ljava/lang/String;)V", AppConstants.Key.KEY_QZONE_VIDEO_URL, "e", "a", "c", "imageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.playvideo.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class GetVideoInfoIntent extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String videoUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String imageUrl;

        public GetVideoInfoIntent() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getVideoUrl() {
            return this.videoUrl;
        }

        public final void c(@Nullable String str) {
            this.imageUrl = str;
        }

        public final void d(@Nullable String str) {
            this.videoUrl = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetVideoInfoIntent)) {
                return false;
            }
            GetVideoInfoIntent getVideoInfoIntent = (GetVideoInfoIntent) other;
            if (Intrinsics.areEqual(this.videoUrl, getVideoInfoIntent.videoUrl) && Intrinsics.areEqual(this.imageUrl, getVideoInfoIntent.imageUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            String str = this.videoUrl;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.imageUrl;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "GetVideoInfoIntent(videoUrl=" + this.videoUrl + ", imageUrl=" + this.imageUrl + ")";
        }

        public GetVideoInfoIntent(@Nullable String str, @Nullable String str2) {
            this.videoUrl = str;
            this.imageUrl = str2;
        }

        public /* synthetic */ GetVideoInfoIntent(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/aio/playvideo/a$b;", "Lcom/tencent/robot/aio/playvideo/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "b", "()I", "f", "(I)V", "left", "e", "c", "g", "top", tl.h.F, "width", "a", "height", "<init>", "(IIII)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.playvideo.a$b, reason: from toString */
    /* loaded from: classes25.dex */
    public static final /* data */ class GetVideoMsgViewInfo extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int left;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int top;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int width;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private int height;

        public GetVideoMsgViewInfo() {
            this(0, 0, 0, 0, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: b, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: c, reason: from getter */
        public final int getTop() {
            return this.top;
        }

        /* renamed from: d, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public final void e(int i3) {
            this.height = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetVideoMsgViewInfo)) {
                return false;
            }
            GetVideoMsgViewInfo getVideoMsgViewInfo = (GetVideoMsgViewInfo) other;
            if (this.left == getVideoMsgViewInfo.left && this.top == getVideoMsgViewInfo.top && this.width == getVideoMsgViewInfo.width && this.height == getVideoMsgViewInfo.height) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            this.left = i3;
        }

        public final void g(int i3) {
            this.top = i3;
        }

        public final void h(int i3) {
            this.width = i3;
        }

        public int hashCode() {
            return (((((this.left * 31) + this.top) * 31) + this.width) * 31) + this.height;
        }

        @NotNull
        public String toString() {
            return "GetVideoMsgViewInfo(left=" + this.left + ", top=" + this.top + ", width=" + this.width + ", height=" + this.height + ")";
        }

        public GetVideoMsgViewInfo(int i3, int i16, int i17, int i18) {
            this.left = i3;
            this.top = i16;
            this.width = i17;
            this.height = i18;
        }

        public /* synthetic */ GetVideoMsgViewInfo(int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) != 0 ? 0 : i18);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/aio/playvideo/a$c;", "Lcom/tencent/robot/aio/playvideo/a;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final c f367296d = new c();

        c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/aio/playvideo/a$d;", "Lcom/tencent/robot/aio/playvideo/a;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final d f367297d = new d();

        d() {
        }
    }
}
