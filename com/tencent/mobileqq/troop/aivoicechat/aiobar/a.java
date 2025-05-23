package com.tencent.mobileqq.troop.aivoicechat.aiobar;

import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a;", "Lat/a;", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$a;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$b;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$c;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$d;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a implements at.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u0003\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u000b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$a;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a;", "", "d", "J", "c", "()J", "f", "(J)V", "troopUin", "", "e", "I", "a", "()I", "(I)V", "aiChatType", "", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "selectedVoiceId", "<init>", "(JILjava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.aivoicechat.aiobar.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8670a extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long troopUin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int aiChatType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private String selectedVoiceId;

        public C8670a() {
            this(0L, 0, null, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getAiChatType() {
            return this.aiChatType;
        }

        /* renamed from: b, reason: from getter */
        public final String getSelectedVoiceId() {
            return this.selectedVoiceId;
        }

        /* renamed from: c, reason: from getter */
        public final long getTroopUin() {
            return this.troopUin;
        }

        public final void d(int i3) {
            this.aiChatType = i3;
        }

        public final void e(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.selectedVoiceId = str;
        }

        public final void f(long j3) {
            this.troopUin = j3;
        }

        public /* synthetic */ C8670a(long j3, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0L : j3, (i16 & 2) != 0 ? AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal() : i3, (i16 & 4) != 0 ? "" : str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8670a(long j3, int i3, String selectedVoiceId) {
            super(null);
            Intrinsics.checkNotNullParameter(selectedVoiceId, "selectedVoiceId");
            this.troopUin = j3;
            this.aiChatType = i3;
            this.selectedVoiceId = selectedVoiceId;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$b;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends a {

        /* renamed from: d, reason: collision with root package name */
        public static final b f293858d = new b();

        b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$c;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a;", "", "d", "Z", "a", "()Z", "b", "(Z)V", "needShow", "<init>", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean needShow;

        public c() {
            this(false, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNeedShow() {
            return this.needShow;
        }

        public final void b(boolean z16) {
            this.needShow = z16;
        }

        public c(boolean z16) {
            super(null);
            this.needShow = z16;
        }

        public /* synthetic */ c(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$d;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "voiceItem", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final VoiceItem voiceItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VoiceItem voiceItem) {
            super(null);
            Intrinsics.checkNotNullParameter(voiceItem, "voiceItem");
            this.voiceItem = voiceItem;
        }

        /* renamed from: a, reason: from getter */
        public final VoiceItem getVoiceItem() {
            return this.voiceItem;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
