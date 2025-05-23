package com.tencent.guild.aio.article.data;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/article/data/f;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "b", "", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "msgRecord", "", "g", "", "e", "f", "", "c", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "mContact", "J", "mMainMsgSeq", "mRspMsgSeq", "I", "mLaunchFromType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mMainMsgRecord", "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;JJI)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Contact mContact;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long mMainMsgSeq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long mRspMsgSeq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mLaunchFromType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord mMainMsgRecord;

    public f(@NotNull Contact mContact, long j3, long j16, int i3) {
        Intrinsics.checkNotNullParameter(mContact, "mContact");
        this.mContact = mContact;
        this.mMainMsgSeq = j3;
        this.mRspMsgSeq = j16;
        this.mLaunchFromType = i3;
    }

    @NotNull
    public final String a() {
        String str = this.mContact.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "mContact.peerUid");
        return str;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Contact getMContact() {
        return this.mContact;
    }

    /* renamed from: c, reason: from getter */
    public final int getMLaunchFromType() {
        return this.mLaunchFromType;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final MsgRecord getMMainMsgRecord() {
        return this.mMainMsgRecord;
    }

    /* renamed from: e, reason: from getter */
    public final long getMMainMsgSeq() {
        return this.mMainMsgSeq;
    }

    /* renamed from: f, reason: from getter */
    public final long getMRspMsgSeq() {
        return this.mRspMsgSeq;
    }

    public final void g(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        this.mMainMsgRecord = msgRecord;
    }
}
