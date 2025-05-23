package com.tencent.mobileqq.guild.feed.data;

import android.util.LruCache;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.feed.util.m;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import common.config.service.QzoneConfig;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/data/GProStFeedMemoryKeepSerializer;", "Ljava/io/Externalizable;", "Ljava/io/ObjectOutput;", k.f247492f, "", "writeExternal", "Ljava/io/ObjectInput;", k.f247491e, "readExternal", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "getStFeed", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "setStFeed", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;)V", "<init>", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GProStFeedMemoryKeepSerializer implements Externalizable {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final LruCache<String, byte[]> f218347d = new LruCache<>(10);

    /* renamed from: e, reason: collision with root package name */
    private static final int f218348e = QQGuildMCParser.INSTANCE.d("100554", "--bug=130433307", QzoneConfig.DEFAULT_PHOTOVIEW_LIST_SIZE_TO_FINISH);
    private static final long serialVersionUID = 0;

    @NotNull
    private GProStFeed stFeed;

    public GProStFeedMemoryKeepSerializer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final GProStFeed getStFeed() {
        return this.stFeed;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput read) {
        Object m476constructorimpl;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(read, "read");
        try {
            Result.Companion companion = Result.INSTANCE;
            String readUTF = read.readUTF();
            if (read.readBoolean()) {
                bArr = new byte[read.readInt()];
                read.readFully(bArr);
            } else {
                LruCache<String, byte[]> lruCache = f218347d;
                byte[] bArr2 = lruCache.get(readUTF);
                byte[] bArr3 = bArr2;
                lruCache.remove(readUTF);
                bArr = bArr2;
            }
            this.stFeed = m.a(bArr);
            QLog.i("GProStFeedMemoryKeepSerializer", 1, "read: key:" + readUTF + " " + bArr.length);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("GProStFeedMemoryKeepSerializer", 1, "read err " + QLog.getStackTraceString(m479exceptionOrNullimpl) + "}");
        }
        Unit unit = Unit.INSTANCE;
        Result.m482isFailureimpl(m476constructorimpl);
    }

    public final void setStFeed(@NotNull GProStFeed gProStFeed) {
        Intrinsics.checkNotNullParameter(gProStFeed, "<set-?>");
        this.stFeed = gProStFeed;
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput write) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(write, "write");
        try {
            Result.Companion companion = Result.INSTANCE;
            String str = "GProStFeed_" + this.stFeed.idd + "_" + System.currentTimeMillis();
            write.writeUTF(str);
            byte[] d16 = m.d(this.stFeed);
            if (d16.length < f218348e) {
                write.writeBoolean(true);
                write.writeInt(d16.length);
                write.write(d16);
            } else {
                write.writeBoolean(false);
                f218347d.put(str, d16);
            }
            QLog.i("GProStFeedMemoryKeepSerializer", 1, "write: key:" + str + " " + d16.length);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("GProStFeedMemoryKeepSerializer", 1, "write err " + QLog.getStackTraceString(m479exceptionOrNullimpl) + "}");
        }
        Unit unit = Unit.INSTANCE;
        Result.m482isFailureimpl(m476constructorimpl);
    }

    public GProStFeedMemoryKeepSerializer(@NotNull GProStFeed stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        this.stFeed = stFeed;
    }

    public /* synthetic */ GProStFeedMemoryKeepSerializer(GProStFeed gProStFeed, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new GProStFeed() : gProStFeed);
    }
}
