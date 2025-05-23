package com.tencent.timi.game.liveroom.impl.room.manager;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.MainThread;
import com.google.protobuf.nano.MessageNano;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ur4.l;
import ur4.n;
import ur4.q;
import ur4.s;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001(\u0018\u0000 \u001e2\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0003J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/manager/LiveBarrageMessageMgr;", "", "", "data", "", "j", "o", "Lur4/n;", "msg", "", "g", "", "iconUrl", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "a", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "room", "Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout;", "b", "Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout;", "barrageLayout", "c", "Lkotlin/Lazy;", "i", "()I", "startIconSize", "d", h.F, "startIconMargin", "", "e", "Z", "isRunning", "Ljava/util/LinkedList;", "f", "Ljava/util/LinkedList;", "barrages", "com/tencent/timi/game/liveroom/impl/room/manager/LiveBarrageMessageMgr$b", "Lcom/tencent/timi/game/liveroom/impl/room/manager/LiveBarrageMessageMgr$b;", "barrageMessagePushRev", "<init>", "(Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LiveBarrageMessageMgr {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ILiveRoom room;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GradientBarrageLayout barrageLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy startIconSize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy startIconMargin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedList<n> barrages;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b barrageMessagePushRev;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/manager/LiveBarrageMessageMgr$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IQQCmdPushCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.e("Open_Live|LiveBarrageMessageMgr", "barrageMessagePushRev", "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            bl4.a c16 = bl4.a.c(data);
            if (c16.f28641a == 108) {
                LiveBarrageMessageMgr.this.j(c16.f28643c);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/manager/LiveBarrageMessageMgr$c", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends QCirclePicStateListener {
        c() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            Bitmap resultBitMap;
            super.onStateChange(state, option);
            if (state == LoadState.STATE_SUCCESS && option != null && (resultBitMap = option.getResultBitMap()) != null) {
                LiveBarrageMessageMgr liveBarrageMessageMgr = LiveBarrageMessageMgr.this;
                try {
                    liveBarrageMessageMgr.barrageLayout.setStartIcon(new BitmapDrawable(liveBarrageMessageMgr.barrageLayout.getContext().getResources(), resultBitMap), liveBarrageMessageMgr.h());
                } catch (Exception e16) {
                    AegisLogger.INSTANCE.e("Open_Live|LiveBarrageMessageMgr", "setBarrageIcon", "error: " + e16.getMessage());
                }
            }
        }
    }

    public LiveBarrageMessageMgr(@NotNull ILiveRoom room, @NotNull GradientBarrageLayout barrageLayout) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(room, "room");
        Intrinsics.checkNotNullParameter(barrageLayout, "barrageLayout");
        this.room = room;
        this.barrageLayout = barrageLayout;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.timi.game.liveroom.impl.room.manager.LiveBarrageMessageMgr$startIconSize$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(wi2.c.b(16));
            }
        });
        this.startIconSize = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.timi.game.liveroom.impl.room.manager.LiveBarrageMessageMgr$startIconMargin$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(wi2.c.b(4));
            }
        });
        this.startIconMargin = lazy2;
        this.barrages = new LinkedList<>();
        barrageLayout.setTextPadding(wi2.c.b(9), wi2.c.b(6), wi2.c.b(9), wi2.c.b(6));
        barrageLayout.setTextSizeDp(14.0f);
        barrageLayout.setTextOffset(wi2.c.b(200));
        barrageLayout.setSurroundingTextPadding(0, wi2.c.b(8), wi2.c.b(11), wi2.c.b(8));
        barrageLayout.setSurroundTextSizeDp(12.0f);
        barrageLayout.setSurroundingTextOffset(wi2.c.d(-5), wi2.c.d(-15));
        barrageLayout.setOnBarrageViewSlideOut(new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.manager.LiveBarrageMessageMgr.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LiveBarrageMessageMgr.this.isRunning = false;
                LiveBarrageMessageMgr.this.o();
            }
        });
        this.barrageMessagePushRev = new b();
    }

    private final int g(n msg2) {
        switch (msg2.f439938a.f439906a) {
            case 1001:
                return 1;
            case 1002:
                return 2;
            case 1003:
            default:
                return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int h() {
        return ((Number) this.startIconMargin.getValue()).intValue();
    }

    private final int i() {
        return ((Number) this.startIconSize.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(byte[] data) {
        try {
            final n nVar = new n();
            MessageNano.mergeFrom(nVar, data);
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("Open_Live|LiveBarrageMessageMgr", "handleBarrageMessagePush", "msgId=" + nVar.f439943f + ", isHitBeat=" + nVar.f439940c + ", isSendSuccess=" + nVar.f439939b);
            if (nVar.f439941d != this.room.getRoomInfo().getRoomId()) {
                companion.e("Open_Live|LiveBarrageMessageMgr", "handleBarrageMessagePush", "roomId not match, msg.roomid: " + nVar.f439941d + ", room.roomId: " + this.room.getRoomInfo().getRoomId());
                return;
            }
            if (!nVar.f439939b) {
                companion.e("Open_Live|LiveBarrageMessageMgr", "handleBarrageMessagePush", "isSendSuccess: false");
                return;
            }
            s sVar = nVar.f439942e.f439927c;
            boolean z16 = false;
            if (sVar != null && sVar.f439954a == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                z16 = true;
            }
            if (nVar.f439940c && !z16 && !this.room.isAnchorRoom()) {
                companion.i("Open_Live|LiveBarrageMessageMgr", "handleBarrageMessagePush", "isHitBeat, msgId=" + nVar.f439943f);
                return;
            }
            this.barrageLayout.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.manager.c
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBarrageMessageMgr.k(LiveBarrageMessageMgr.this, nVar);
                }
            });
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|LiveBarrageMessageMgr", "handleBarrageMessagePush", "mergeFrom error: " + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LiveBarrageMessageMgr this$0, n msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        this$0.barrages.add(msg2);
        AegisLogger.INSTANCE.i("Open_Live|LiveBarrageMessageMgr", "handleBarrageMessagePush", "barrages.size=" + this$0.barrages.size());
        this$0.o();
    }

    private final void n(String iconUrl) {
        boolean z16;
        if (iconUrl != null && iconUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(iconUrl).setRequestWidth(i()).setRequestHeight(i()), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void o() {
        n pollFirst;
        Object firstOrNull;
        byte[] bArr;
        long j3;
        List<String> list;
        List<String> list2;
        List<String> list3;
        List<String> list4;
        q qVar;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|LiveBarrageMessageMgr", "shotNextBarrage", "invoke, isRunning=" + this.isRunning + ", barrages.size=" + this.barrages.size());
        if (!this.isRunning && (pollFirst = this.barrages.pollFirst()) != null) {
            boolean z16 = true;
            try {
                this.isRunning = true;
                l[] lVarArr = pollFirst.f439942e.f439925a;
                Intrinsics.checkNotNullExpressionValue(lVarArr, "it.msgContent.msgElements");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(lVarArr);
                l lVar = (l) firstOrNull;
                String str = null;
                if (lVar != null && (qVar = lVar.f439930b) != null) {
                    bArr = qVar.f439951a;
                } else {
                    bArr = null;
                }
                if (bArr == null) {
                    bArr = new byte[0];
                } else {
                    Intrinsics.checkNotNullExpressionValue(bArr, "it.msgContent.msgElement\u2026em?.text ?: byteArrayOf()");
                }
                String str2 = new String(bArr, Charsets.UTF_16LE);
                companion.i("Open_Live|LiveBarrageMessageMgr", "shotNextBarrage", "msgId=" + pollFirst.f439943f + ", text=" + str2);
                ur4.b chatConfig = pollFirst.f439938a.f439913h;
                if (chatConfig != null) {
                    Intrinsics.checkNotNullExpressionValue(chatConfig, "chatConfig");
                    this.barrageLayout.setVisibility(4);
                    GradientBarrageLayout gradientBarrageLayout = this.barrageLayout;
                    String[] wordColors = chatConfig.f439897e;
                    Intrinsics.checkNotNullExpressionValue(wordColors, "wordColors");
                    list = ArraysKt___ArraysKt.toList(wordColors);
                    String[] frameColors = chatConfig.f439895c;
                    Intrinsics.checkNotNullExpressionValue(frameColors, "frameColors");
                    list2 = ArraysKt___ArraysKt.toList(frameColors);
                    String[] backgroundColors = chatConfig.f439893a;
                    Intrinsics.checkNotNullExpressionValue(backgroundColors, "backgroundColors");
                    list3 = ArraysKt___ArraysKt.toList(backgroundColors);
                    gradientBarrageLayout.setColors(list, list2, list3);
                    GradientBarrageLayout gradientBarrageLayout2 = this.barrageLayout;
                    String[] wordColors2 = chatConfig.f439897e;
                    Intrinsics.checkNotNullExpressionValue(wordColors2, "wordColors");
                    list4 = ArraysKt___ArraysKt.toList(wordColors2);
                    gradientBarrageLayout2.setSurroundTextColor(list4);
                    GradientBarrageLayout gradientBarrageLayout3 = this.barrageLayout;
                    if (chatConfig.f439900h) {
                        z16 = false;
                    }
                    gradientBarrageLayout3.setSingleLine(z16);
                    n(chatConfig.f439899g);
                }
                s sVar = pollFirst.f439942e.f439927c;
                if (sVar != null) {
                    str = sVar.f439955b;
                }
                String str3 = str;
                if (sVar != null) {
                    j3 = sVar.f439954a;
                } else {
                    j3 = 0;
                }
                String b16 = e.INSTANCE.a().b(pollFirst.f439941d, str3, j3, this.room.getAnchorInfo().getAnchorUid());
                if (b16 == null) {
                    b16 = "";
                }
                if (b16.length() > 7) {
                    String substring = b16.substring(0, 8);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    b16 = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.barrageLayout.setText(b16 + "\uff1a" + str2);
                this.barrageLayout.setSurroundText(str2);
                this.barrageLayout.S0(g(pollFirst));
            } catch (Exception e16) {
                this.isRunning = false;
                AegisLogger.INSTANCE.e("Open_Live|LiveBarrageMessageMgr", "shotNextBarrage", "error: " + e16.getMessage());
            }
        }
    }

    public final void l() {
        this.room.registerLivePushChannel(285, this.barrageMessagePushRev);
    }

    public final void m() {
        this.barrages.clear();
        this.room.unRegisterLivePushChannel(this.barrageMessagePushRev);
        this.barrageLayout.H0();
    }
}
