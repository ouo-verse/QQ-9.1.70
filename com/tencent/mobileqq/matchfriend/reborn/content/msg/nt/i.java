package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/i;", "Lcom/tencent/qqnt/chats/core/uievent/b;", "<init>", "()V", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/i$a;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class i implements com.tencent.qqnt.chats.core.uievent.b {
    public /* synthetic */ i(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    i() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u0016\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/i$a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/i;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "a", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "d", "()Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "data", "Landroid/view/View;", "b", "Landroid/view/View;", "()Landroid/view/View;", "avatarView", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "c", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "()Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "action", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "bmp", "<init>", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;Landroid/view/View;Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;Landroid/graphics/Bitmap;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.i$a, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class QQStrangerShowLightInterActionAnim extends i {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final com.tencent.qqnt.chats.core.adapter.itemdata.g data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final View avatarView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final QQStrangerLIAItem action;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final Bitmap bmp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QQStrangerShowLightInterActionAnim(com.tencent.qqnt.chats.core.adapter.itemdata.g data, View avatarView, QQStrangerLIAItem action, Bitmap bmp) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(avatarView, "avatarView");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(bmp, "bmp");
            this.data = data;
            this.avatarView = avatarView;
            this.action = action;
            this.bmp = bmp;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerLIAItem getAction() {
            return this.action;
        }

        /* renamed from: b, reason: from getter */
        public final View getAvatarView() {
            return this.avatarView;
        }

        /* renamed from: c, reason: from getter */
        public final Bitmap getBmp() {
            return this.bmp;
        }

        /* renamed from: d, reason: from getter */
        public final com.tencent.qqnt.chats.core.adapter.itemdata.g getData() {
            return this.data;
        }

        public int hashCode() {
            return (((((this.data.hashCode() * 31) + this.avatarView.hashCode()) * 31) + this.action.hashCode()) * 31) + this.bmp.hashCode();
        }

        public String toString() {
            return "QQStrangerShowLightInterActionAnim(data=" + this.data + ", avatarView=" + this.avatarView + ", action=" + this.action + ", bmp=" + this.bmp + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QQStrangerShowLightInterActionAnim)) {
                return false;
            }
            QQStrangerShowLightInterActionAnim qQStrangerShowLightInterActionAnim = (QQStrangerShowLightInterActionAnim) other;
            return Intrinsics.areEqual(this.data, qQStrangerShowLightInterActionAnim.data) && Intrinsics.areEqual(this.avatarView, qQStrangerShowLightInterActionAnim.avatarView) && Intrinsics.areEqual(this.action, qQStrangerShowLightInterActionAnim.action) && Intrinsics.areEqual(this.bmp, qQStrangerShowLightInterActionAnim.bmp);
        }
    }
}
