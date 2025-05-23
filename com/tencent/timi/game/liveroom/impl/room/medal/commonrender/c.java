package com.tencent.timi.game.liveroom.impl.room.medal.commonrender;

import android.content.Context;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.timi.game.liveroom.impl.room.medal.render.MsgMedalLoader;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/c;", "", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static ArrayList<WeakReference<MsgCommonMedalLoader>> f377981b = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0007J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eR2\u0010\u0016\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/c$a;", "", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "userMedalInfo", "", "b", "Landroid/content/Context;", "context", "", "roomId", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/c$b;", "callback", "", "d", "a", "c", "Ljava/util/ArrayList;", "Lmqq/util/WeakReference;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/MsgCommonMedalLoader;", "Lkotlin/collections/ArrayList;", "lsMedalLoaders", "Ljava/util/ArrayList;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(com.tencent.mobileqq.qqlive.widget.chat.data.b userMedalInfo) {
            boolean isBlank;
            List<g> list = userMedalInfo.f273762g;
            Intrinsics.checkNotNullExpressionValue(list, "userMedalInfo.medalInfoNewList");
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                g.a aVar = ((g) it.next()).B;
                if (aVar != null) {
                    String str = aVar.f434409a;
                    Intrinsics.checkNotNullExpressionValue(str, "it.layoutStyle.id");
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a() {
            Iterator it = c.f377981b.iterator();
            while (it.hasNext()) {
                MsgCommonMedalLoader msgCommonMedalLoader = (MsgCommonMedalLoader) ((WeakReference) it.next()).get();
                if (msgCommonMedalLoader != null) {
                    msgCommonMedalLoader.e();
                }
            }
            c.f377981b.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c() {
            boolean z16;
            boolean isBlank;
            String[] n3 = BusConfigHelper.f378723a.n(com.tencent.mobileqq.qqlive.sail.c.f272176a.p());
            if (n3 != null) {
                for (String str : n3) {
                    if (str != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str);
                        if (!isBlank) {
                            z16 = false;
                            if (z16) {
                                QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setPreferDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setSupportRecycler(true));
                            }
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                }
            }
        }

        @JvmStatic
        public final void d(@NotNull Context context, long roomId, @NotNull f msg2, @Nullable com.tencent.mobileqq.qqlive.widget.chat.data.b userMedalInfo, @NotNull b callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (userMedalInfo != null && userMedalInfo.f273762g.size() != 0) {
                if (b(userMedalInfo)) {
                    MsgCommonMedalLoader msgCommonMedalLoader = new MsgCommonMedalLoader();
                    msgCommonMedalLoader.h(roomId, userMedalInfo, callback);
                    c.f377981b.add(new WeakReference(msgCommonMedalLoader));
                    return;
                }
                new MsgMedalLoader(com.tencent.mobileqq.qqlive.sail.c.f272176a.p()).h(context, msg2, userMedalInfo, callback);
                return;
            }
            callback.a(userMedalInfo, "");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/c$b;", "", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "userMedalInfo", "", "result", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@Nullable com.tencent.mobileqq.qqlive.widget.chat.data.b userMedalInfo, @NotNull CharSequence result);
    }
}
