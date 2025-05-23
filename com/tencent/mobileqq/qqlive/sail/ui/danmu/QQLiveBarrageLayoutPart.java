package com.tencent.mobileqq.qqlive.sail.ui.danmu;

import android.view.View;
import androidx.annotation.MainThread;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ur4.q;
import ur4.s;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0014J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveBarrageLayoutPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "na", "Lur4/n;", "msg", "", "la", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "getInitRelyViewStubId", "U9", "V9", "Lfp4/c;", "msgInfo", "onPush", "Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout;", "e", "Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout;", "barrageLayout", "", "f", "Z", "isRunning", "Ljava/util/LinkedList;", tl.h.F, "Ljava/util/LinkedList;", "barrages", "<init>", "()V", "i", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveBarrageLayoutPart extends com.tencent.mobileqq.qqlive.sail.base.c implements com.tencent.mobileqq.qqlive.sail.room.g {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GradientBarrageLayout barrageLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedList<ur4.n> barrages;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveBarrageLayoutPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveBarrageLayoutPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51685);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveBarrageLayoutPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.barrages = new LinkedList<>();
        }
    }

    private final int la(ur4.n msg2) {
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
    public static final void ma(QQLiveBarrageLayoutPart this$0, ur4.n it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.barrages.add(it);
        AegisLogger.INSTANCE.i("Open_Live|QQLiveBarrageLayoutPart", "onPush", "barrages.size=" + this$0.barrages.size());
        this$0.na();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void na() {
        ur4.n pollFirst;
        Object firstOrNull;
        byte[] bArr;
        long j3;
        List<String> list;
        List<String> list2;
        List<String> list3;
        List<String> list4;
        q qVar;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Open_Live|QQLiveBarrageLayoutPart", "shotNextBarrage", "invoke, isRunning=" + this.isRunning + ", barrages.size=" + this.barrages.size());
        if (!this.isRunning && (pollFirst = this.barrages.pollFirst()) != null) {
            boolean z16 = true;
            try {
                this.isRunning = true;
                ur4.l[] lVarArr = pollFirst.f439942e.f439925a;
                Intrinsics.checkNotNullExpressionValue(lVarArr, "it.msgContent.msgElements");
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(lVarArr);
                ur4.l lVar = (ur4.l) firstOrNull;
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
                companion.i("Open_Live|QQLiveBarrageLayoutPart", "shotNextBarrage", "msgId=" + pollFirst.f439943f + ", text=" + str2);
                ur4.b chatConfig = pollFirst.f439938a.f439913h;
                if (chatConfig != null) {
                    Intrinsics.checkNotNullExpressionValue(chatConfig, "chatConfig");
                    GradientBarrageLayout gradientBarrageLayout = this.barrageLayout;
                    if (gradientBarrageLayout != null) {
                        gradientBarrageLayout.setVisibility(4);
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
                        String[] wordColors2 = chatConfig.f439897e;
                        Intrinsics.checkNotNullExpressionValue(wordColors2, "wordColors");
                        list4 = ArraysKt___ArraysKt.toList(wordColors2);
                        gradientBarrageLayout.setSurroundTextColor(list4);
                        if (chatConfig.f439900h) {
                            z16 = false;
                        }
                        gradientBarrageLayout.setSingleLine(z16);
                    }
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
                String b16 = com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().b(pollFirst.f439941d, str3, j3, com.tencent.mobileqq.qqlive.sail.c.f272176a.d().f());
                if (b16 == null) {
                    b16 = "";
                }
                if (b16.length() > 7) {
                    String substring = b16.substring(0, 8);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    b16 = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                GradientBarrageLayout gradientBarrageLayout2 = this.barrageLayout;
                if (gradientBarrageLayout2 != null) {
                    gradientBarrageLayout2.setText(b16 + "\uff1a" + str2);
                    gradientBarrageLayout2.setSurroundText(str2);
                    gradientBarrageLayout2.S0(la(pollFirst));
                }
            } catch (Exception e16) {
                this.isRunning = false;
                AegisLogger.INSTANCE.e("Open_Live|QQLiveBarrageLayoutPart", "shotNextBarrage", "error", e16);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.p(285, this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.w("Open_Live|QQLiveBarrageLayoutPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.barrages.clear();
        com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
        GradientBarrageLayout gradientBarrageLayout = this.barrageLayout;
        if (gradientBarrageLayout != null) {
            gradientBarrageLayout.H0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f60272uz;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        GradientBarrageLayout gradientBarrageLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null && (gradientBarrageLayout = (GradientBarrageLayout) rootView.findViewById(R.id.f60272uz)) != null) {
            gradientBarrageLayout.setTextPadding(wi2.c.b(9), wi2.c.b(6), wi2.c.b(9), wi2.c.b(6));
            gradientBarrageLayout.setTextSizeDp(14.0f);
            gradientBarrageLayout.setTextOffset(wi2.c.b(200));
            gradientBarrageLayout.setSurroundingTextPadding(0, wi2.c.b(8), wi2.c.b(11), wi2.c.b(8));
            gradientBarrageLayout.setSurroundTextSizeDp(12.0f);
            gradientBarrageLayout.setSurroundingTextOffset(wi2.c.d(-5), wi2.c.d(-15));
            gradientBarrageLayout.setOnBarrageViewSlideOut(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveBarrageLayoutPart$onInitView$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveBarrageLayoutPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQLiveBarrageLayoutPart.this.isRunning = false;
                        QQLiveBarrageLayoutPart.this.na();
                    }
                }
            });
        } else {
            gradientBarrageLayout = null;
        }
        this.barrageLayout = gradientBarrageLayout;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        final ur4.n w3 = com.tencent.mobileqq.qqlive.sail.push.a.w(msgInfo);
        if (w3 != null) {
            try {
                long H9 = H9();
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("Open_Live|QQLiveBarrageLayoutPart", "onPush", "msgId=" + w3.f439943f + ", isHitBeat=" + w3.f439940c + ", isSendSuccess=" + w3.f439939b);
                long j3 = w3.f439941d;
                if (j3 != H9) {
                    companion.e("Open_Live|QQLiveBarrageLayoutPart", "onPush", "roomId not match, msg.roomid: " + j3 + ", room.roomId: " + H9);
                    return;
                }
                if (!w3.f439939b) {
                    companion.e("Open_Live|QQLiveBarrageLayoutPart", "onPush", "isSendSuccess: false");
                    return;
                }
                s sVar = w3.f439942e.f439927c;
                boolean z16 = false;
                if (sVar != null && sVar.f439954a == com.tencent.mobileqq.qqlive.sail.c.f272176a.G()) {
                    z16 = true;
                }
                if (w3.f439940c && !z16 && !com.tencent.mobileqq.qqlive.sail.c.K(com.tencent.mobileqq.qqlive.sail.c.f272176a, H9, 0, 2, null)) {
                    companion.i("Open_Live|QQLiveBarrageLayoutPart", "onPush", "isHitBeat, msgId=" + w3.f439943f);
                    return;
                }
                if (this.barrageLayout == null) {
                    startInit();
                }
                GradientBarrageLayout gradientBarrageLayout = this.barrageLayout;
                if (gradientBarrageLayout != null) {
                    gradientBarrageLayout.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQLiveBarrageLayoutPart.ma(QQLiveBarrageLayoutPart.this, w3);
                        }
                    });
                }
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Open_Live|QQLiveBarrageLayoutPart", "onPush", "mergeFrom error", e16);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
