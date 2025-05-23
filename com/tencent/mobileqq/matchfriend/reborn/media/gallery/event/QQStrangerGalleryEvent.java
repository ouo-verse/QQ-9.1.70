package com.tencent.mobileqq.matchfriend.reborn.media.gallery.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/event/QQStrangerGalleryEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "OnPhotoChangeEvent", "OnPhotoDeleteEvent", "Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/event/QQStrangerGalleryEvent$OnPhotoChangeEvent;", "Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/event/QQStrangerGalleryEvent$OnPhotoDeleteEvent;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class QQStrangerGalleryEvent extends SimpleBaseEvent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/event/QQStrangerGalleryEvent$OnPhotoDeleteEvent;", "Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/event/QQStrangerGalleryEvent;", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class OnPhotoDeleteEvent extends QQStrangerGalleryEvent {
        public static final OnPhotoDeleteEvent INSTANCE = new OnPhotoDeleteEvent();

        OnPhotoDeleteEvent() {
            super(null);
        }
    }

    public /* synthetic */ QQStrangerGalleryEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    QQStrangerGalleryEvent() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/event/QQStrangerGalleryEvent$OnPhotoChangeEvent;", "Lcom/tencent/mobileqq/matchfriend/reborn/media/gallery/event/QQStrangerGalleryEvent;", "newPath", "", "(Ljava/lang/String;)V", "getNewPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class OnPhotoChangeEvent extends QQStrangerGalleryEvent {
        private final String newPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPhotoChangeEvent(String newPath) {
            super(null);
            Intrinsics.checkNotNullParameter(newPath, "newPath");
            this.newPath = newPath;
        }

        /* renamed from: component1, reason: from getter */
        public final String getNewPath() {
            return this.newPath;
        }

        public final OnPhotoChangeEvent copy(String newPath) {
            Intrinsics.checkNotNullParameter(newPath, "newPath");
            return new OnPhotoChangeEvent(newPath);
        }

        public final String getNewPath() {
            return this.newPath;
        }

        public int hashCode() {
            return this.newPath.hashCode();
        }

        public String toString() {
            return "OnPhotoChangeEvent(newPath=" + this.newPath + ")";
        }

        public static /* synthetic */ OnPhotoChangeEvent copy$default(OnPhotoChangeEvent onPhotoChangeEvent, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = onPhotoChangeEvent.newPath;
            }
            return onPhotoChangeEvent.copy(str);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnPhotoChangeEvent) && Intrinsics.areEqual(this.newPath, ((OnPhotoChangeEvent) other).newPath);
        }
    }
}
