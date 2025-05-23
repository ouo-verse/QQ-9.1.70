package com.tencent.guild.aio.article.data;

import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/guild/aio/article/data/i;", "", "", "a", "Z", "e", "()Z", "isSuccess", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "msgRecordList", "d", "upIsFinish", "downIsFinish", "<init>", "(ZLjava/lang/String;Ljava/util/ArrayList;ZZ)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errorMsg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MsgRecord> msgRecordList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean upIsFinish;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean downIsFinish;

    public i(boolean z16, @NotNull String errorMsg, @NotNull ArrayList<MsgRecord> msgRecordList, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        this.isSuccess = z16;
        this.errorMsg = errorMsg;
        this.msgRecordList = msgRecordList;
        this.upIsFinish = z17;
        this.downIsFinish = z18;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDownIsFinish() {
        return this.downIsFinish;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @NotNull
    public final ArrayList<MsgRecord> c() {
        return this.msgRecordList;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getUpIsFinish() {
        return this.upIsFinish;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }
}
