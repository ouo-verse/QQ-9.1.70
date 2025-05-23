package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020\u0002\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0001J\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eJ\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001c\u0010$\"\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0016\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001a\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "a", "", "getType", "", tl.h.F, "emoji", "", "j", "emojiId", "emojiType", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "k", "", "toString", "hashCode", "", "other", "equals", "Z", "g", "()Z", "setClicked", "(Z)V", "isClicked", "b", "I", "d", "()I", VasReportUtils.BUSINESS_TYPE_EMOTION, "", "c", "J", "()J", "setEmotionCount", "(J)V", "emotionCount", "emotionLocalId", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "f", "l", NodeProps.VISIBLE, "<init>", "(ZIJILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class b implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isClicked;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int emotionType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long emotionCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int emotionLocalId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord record;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    public b(boolean z16, int i3, long j3, int i16, @NotNull MsgRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), record);
            return;
        }
        this.isClicked = z16;
        this.emotionType = i3;
        this.emotionCount = j3;
        this.emotionLocalId = i16;
        this.record = record;
        this.visible = true;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g
    @NotNull
    public MsgRecord a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.record;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.emotionCount;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.emotionLocalId;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.emotionType;
    }

    @NotNull
    public final MsgRecord e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.record;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.isClicked == bVar.isClicked && this.emotionType == bVar.emotionType && this.emotionCount == bVar.emotionCount && this.emotionLocalId == bVar.emotionLocalId && Intrinsics.areEqual(this.record, bVar.record)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.visible;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isClicked;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 1;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        int i3 = 1;
        boolean z16 = !this.isClicked;
        this.isClicked = z16;
        long j3 = this.emotionCount;
        if (!z16) {
            i3 = -1;
        }
        this.emotionCount = j3 + i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        boolean z16 = this.isClicked;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((r06 * 31) + this.emotionType) * 31) + androidx.fragment.app.a.a(this.emotionCount)) * 31) + this.emotionLocalId) * 31) + this.record.hashCode();
    }

    public final boolean i(int emojiId, int emojiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(emojiId), Integer.valueOf(emojiType))).booleanValue();
        }
        if (this.emotionLocalId == emojiId && this.emotionType == emojiType) {
            return true;
        }
        return false;
    }

    public final boolean j(@NotNull g emoji) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) emoji)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        if (emoji instanceof b) {
            b bVar = (b) emoji;
            if (bVar.emotionLocalId == this.emotionLocalId && bVar.emotionType == this.emotionType) {
                return true;
            }
        }
        return false;
    }

    public final boolean k(@NotNull MsgEmojiLikes emoji) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) emoji)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        if (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.d(emoji) == this.emotionLocalId && ((int) emoji.emojiType) == this.emotionType) {
            return true;
        }
        return false;
    }

    public final void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.visible = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "EmoReplyItem(isClicked=" + this.isClicked + ", emotionType=" + this.emotionType + ", emotionCount=" + this.emotionCount + ", emotionLocalId=" + this.emotionLocalId + ", record=" + this.record + ")";
    }
}
