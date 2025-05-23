package com.tencent.state.square.record;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.state.square.SquareBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 %2\u00020\u0001:\u0001%B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0006\u0010#\u001a\u00020\u0019J\b\u0010$\u001a\u00020\u0019H\u0016R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/record/RecordIdentifier;", "", "sender", "Lcom/tencent/state/square/record/UserIdentifier;", "receivers", "", "appId", "", "type", "Lcom/tencent/state/square/record/RecordType;", "needUpload", "", "(Lcom/tencent/state/square/record/UserIdentifier;Ljava/util/List;ILcom/tencent/state/square/record/RecordType;Z)V", "allUinList", "getAllUinList", "()Ljava/util/List;", "getAppId", "()I", "getNeedUpload", "()Z", "receiver", "getReceiver", "()Lcom/tencent/state/square/record/UserIdentifier;", "getReceivers", "receiversUin", "", "getReceiversUin", "getSender", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "getSenderUin", "()Ljava/lang/String;", "getType", "()Lcom/tencent/state/square/record/RecordType;", "equals", "other", "key", "toString", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class RecordIdentifier {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "RecordUin";

    @NotNull
    private final List<UserIdentifier> allUinList;
    private final int appId;
    private final boolean needUpload;

    @NotNull
    private final List<UserIdentifier> receivers;

    @NotNull
    private final List<String> receiversUin;

    @NotNull
    private final UserIdentifier sender;

    /* renamed from: senderUin, reason: from kotlin metadata and from toString */
    @NotNull
    private final String sender;

    @NotNull
    private final RecordType type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/state/square/record/RecordIdentifier$Companion;", "", "()V", "TAG", "", "getSelfUin", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final String getSelfUin() {
            return SquareBase.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RecordIdentifier(@NotNull UserIdentifier sender, @NotNull List<UserIdentifier> receivers, int i3, @NotNull RecordType type, boolean z16) {
        int collectionSizeOrDefault;
        List listOf;
        List<UserIdentifier> plus;
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(receivers, "receivers");
        Intrinsics.checkNotNullParameter(type, "type");
        this.sender = sender;
        this.receivers = receivers;
        this.appId = i3;
        this.type = type;
        this.needUpload = z16;
        this.sender = sender.getUin();
        List<UserIdentifier> list = receivers;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((UserIdentifier) it.next()).getUin());
        }
        this.receiversUin = arrayList;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(this.sender);
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) this.receivers);
        this.allUinList = plus;
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof RecordIdentifier)) {
            return false;
        }
        RecordIdentifier recordIdentifier = (RecordIdentifier) other;
        if (this.appId != recordIdentifier.appId || this.allUinList.size() != recordIdentifier.allUinList.size() || this.type != recordIdentifier.type || this.needUpload != recordIdentifier.needUpload) {
            return false;
        }
        int size = this.allUinList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (true ^ Intrinsics.areEqual(this.allUinList.get(i3), recordIdentifier.allUinList.get(i3))) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final List<UserIdentifier> getAllUinList() {
        return this.allUinList;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final boolean getNeedUpload() {
        return this.needUpload;
    }

    @Nullable
    public final UserIdentifier getReceiver() {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.receivers);
        return (UserIdentifier) firstOrNull;
    }

    @NotNull
    public final List<UserIdentifier> getReceivers() {
        return this.receivers;
    }

    @NotNull
    public final List<String> getReceiversUin() {
        return this.receiversUin;
    }

    @NotNull
    public final UserIdentifier getSender() {
        return this.sender;
    }

    @NotNull
    /* renamed from: getSenderUin, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    @NotNull
    public final RecordType getType() {
        return this.type;
    }

    @NotNull
    public final String key() {
        return "(sender=" + this.sender + ", receivers=" + this.receivers + ", appId=" + this.appId + ", type=" + this.type + ", needUpload=" + this.needUpload + ')';
    }

    @NotNull
    public String toString() {
        return "(sender=" + this.sender + ", receivers=" + this.receivers + ", appId=" + this.appId + ", type=" + this.type + ", needUpload=" + this.needUpload + ')';
    }

    public /* synthetic */ RecordIdentifier(UserIdentifier userIdentifier, List list, int i3, RecordType recordType, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(userIdentifier, (i16 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? RecordType.MP4_SQUARE : recordType, (i16 & 16) != 0 ? true : z16);
    }
}
