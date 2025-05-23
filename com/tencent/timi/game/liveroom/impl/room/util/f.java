package com.tencent.timi.game.liveroom.impl.room.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.LiveAudienceInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015R&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/util/f;", "", "", "roomId", "", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAudienceInfo;", "audienceInfos", "", "a", "uin", "", "e", "", "g", "b", "Landroid/content/Context;", "context", "", "index", "Landroid/graphics/drawable/Drawable;", "d", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "liveMessageData", "f", "c", "Ljava/util/HashMap;", "", "Ljava/util/HashMap;", "mRoomUinMap", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f378635a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, List<Long>> mRoomUinMap = new HashMap<>(2);

    f() {
    }

    public final void a(long roomId, @NotNull List<? extends LiveAudienceInfo> audienceInfos) {
        Intrinsics.checkNotNullParameter(audienceInfos, "audienceInfos");
        b(roomId);
        HashMap<Long, List<Long>> hashMap = mRoomUinMap;
        List<Long> list = hashMap.get(Long.valueOf(roomId));
        if (list == null) {
            list = new ArrayList<>(3);
            hashMap.put(Long.valueOf(roomId), list);
        }
        for (LiveAudienceInfo liveAudienceInfo : audienceInfos) {
            if (liveAudienceInfo.contribution > 0) {
                list.add(Long.valueOf(liveAudienceInfo.uid));
            }
        }
    }

    public final void b(long roomId) {
        mRoomUinMap.remove(Long.valueOf(roomId));
    }

    @NotNull
    public final String c(@NotNull LiveMessageData liveMessageData) {
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
    public final Drawable d(@NotNull Context context, @NotNull String index) {
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

    public final int e(long roomId, long uin) {
        if (g(roomId, uin)) {
            List<Long> list = mRoomUinMap.get(Long.valueOf(roomId));
            Intrinsics.checkNotNull(list);
            return list.indexOf(Long.valueOf(uin)) + 1;
        }
        return -1;
    }

    public final boolean f(@NotNull LiveMessageData liveMessageData) {
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

    public final boolean g(long roomId, long uin) {
        List<Long> list = mRoomUinMap.get(Long.valueOf(roomId));
        if (list != null) {
            return list.contains(Long.valueOf(uin));
        }
        return false;
    }
}
