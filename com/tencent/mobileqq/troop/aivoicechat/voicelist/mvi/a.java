package com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi;

import com.tencent.qqnt.kernel.nativeinterface.VoicePair;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/a$a;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {
    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/a$a;", "Lcom/tencent/mobileqq/troop/aivoicechat/voicelist/mvi/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/qqnt/kernel/nativeinterface/VoicePair;", "a", "Ljava/util/List;", "()Ljava/util/List;", "list", "<init>", "(Ljava/util/List;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.aivoicechat.voicelist.mvi.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class NoticeListUpdate extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<VoicePair> list;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoticeListUpdate(List<VoicePair> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        public final List<VoicePair> a() {
            return this.list;
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        public String toString() {
            return "NoticeListUpdate(list=" + this.list + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoticeListUpdate) && Intrinsics.areEqual(this.list, ((NoticeListUpdate) other).list);
        }
    }
}
