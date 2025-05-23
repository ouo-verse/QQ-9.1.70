package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel;

import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingOptionResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a$a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a$b;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a$c;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a$d;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a$a;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "success", "<init>", "(Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class OnDeleteAllConversationsUIState extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean success;

        /* renamed from: a, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        public int hashCode() {
            boolean z16 = this.success;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public String toString() {
            return "OnDeleteAllConversationsUIState(success=" + this.success + ")";
        }

        public OnDeleteAllConversationsUIState(boolean z16) {
            super(null);
            this.success = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnDeleteAllConversationsUIState) && this.success == ((OnDeleteAllConversationsUIState) other).success;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a$b;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "data", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.a$b, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class OnSetHideModeOptionUIState extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final QQStrangerMsgSettingOptionResult data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSetHideModeOptionUIState(QQStrangerMsgSettingOptionResult data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerMsgSettingOptionResult getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "OnSetHideModeOptionUIState(data=" + this.data + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetHideModeOptionUIState) && Intrinsics.areEqual(this.data, ((OnSetHideModeOptionUIState) other).data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a$c;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "data", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.a$c, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class OnSetNewChatMsgNotifyOptionUIState extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final QQStrangerMsgSettingOptionResult data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSetNewChatMsgNotifyOptionUIState(QQStrangerMsgSettingOptionResult data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerMsgSettingOptionResult getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "OnSetNewChatMsgNotifyOptionUIState(data=" + this.data + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnSetNewChatMsgNotifyOptionUIState) && Intrinsics.areEqual(this.data, ((OnSetNewChatMsgNotifyOptionUIState) other).data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a$d;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "a", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "data", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.a$d, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class UpdateSettingDataOptionsUIState extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final QQStrangerMsgSettingOptionResult data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdateSettingDataOptionsUIState(QQStrangerMsgSettingOptionResult data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        /* renamed from: a, reason: from getter */
        public final QQStrangerMsgSettingOptionResult getData() {
            return this.data;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "UpdateSettingDataOptionsUIState(data=" + this.data + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof UpdateSettingDataOptionsUIState) && Intrinsics.areEqual(this.data, ((UpdateSettingDataOptionsUIState) other).data);
        }
    }
}
