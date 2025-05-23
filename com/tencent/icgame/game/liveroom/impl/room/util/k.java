package com.tencent.icgame.game.liveroom.impl.room.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fR&\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/util/k;", "", "", "roomId", "uin", "", "c", "", "e", "Landroid/content/Context;", "context", "", "index", "Landroid/graphics/drawable/Drawable;", "b", "Lcom/tencent/mobileqq/icgame/data/message/LiveMessageData;", "liveMessageData", "d", "a", "Ljava/util/HashMap;", "", "Ljava/util/HashMap;", "mRoomUinMap", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f115699a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, List<Long>> mRoomUinMap = new HashMap<>(2);

    k() {
    }

    @NotNull
    public final String a(@NotNull LiveMessageData liveMessageData) {
        Intrinsics.checkNotNullParameter(liveMessageData, "liveMessageData");
        LiveMessageData.MsgContent msgContent = liveMessageData.msgContent;
        if (msgContent == null) {
            return "";
        }
        Iterator<LiveMessageData.ExtData> it = msgContent.mExtDatas.iterator();
        while (it.hasNext()) {
            LiveMessageData.ExtData next = it.next();
            if (100010 == next.mId) {
                byte[] bArr = next.mValue;
                Intrinsics.checkNotNullExpressionValue(bArr, "ext.mValue");
                return new String(bArr, Charsets.UTF_8);
            }
        }
        return "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Nullable
    public final Drawable b(@NotNull Context context, @NotNull String index) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(index, "index");
        switch (index.hashCode()) {
            case 49:
                if (index.equals("1")) {
                    return ContextCompat.getDrawable(context, R.drawable.o8v);
                }
                return null;
            case 50:
                if (index.equals("2")) {
                    return ContextCompat.getDrawable(context, R.drawable.o8x);
                }
                return null;
            case 51:
                if (index.equals("3")) {
                    return ContextCompat.getDrawable(context, R.drawable.o8w);
                }
                return null;
            default:
                return null;
        }
    }

    public final int c(long roomId, long uin) {
        if (e(roomId, uin)) {
            List<Long> list = mRoomUinMap.get(Long.valueOf(roomId));
            Intrinsics.checkNotNull(list);
            return list.indexOf(Long.valueOf(uin)) + 1;
        }
        return -1;
    }

    public final boolean d(@NotNull LiveMessageData liveMessageData) {
        Intrinsics.checkNotNullParameter(liveMessageData, "liveMessageData");
        LiveMessageData.MsgContent msgContent = liveMessageData.msgContent;
        if (msgContent == null) {
            return false;
        }
        Iterator<LiveMessageData.ExtData> it = msgContent.mExtDatas.iterator();
        while (it.hasNext()) {
            if (100010 == it.next().mId) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(long roomId, long uin) {
        List<Long> list = mRoomUinMap.get(Long.valueOf(roomId));
        if (list != null) {
            return list.contains(Long.valueOf(uin));
        }
        return false;
    }
}
