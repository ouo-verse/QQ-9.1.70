package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u00014\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002;<B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b8\u00109J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J(\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J&\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u001b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\fH\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016R\u001b\u0010,\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "", "", "payloads", "", "R1", "Landroid/widget/RelativeLayout;", "O1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer;", "N1", "", "P1", Constants.APK_CERTIFICATE, "Landroid/content/Context;", "context", "msgItem", "Landroid/view/View;", "videoView", "", "playPos", "S1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/a;", "M1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "c1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "e1", "importance", "l1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "Q1", "()Landroid/widget/RelativeLayout;", "contentView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoViewer;", "videoViewer", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent$b;", "D", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent$b;", "onVideoMuteChanged", "com/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent$c", "E", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent$c;", "mediaFocusHelper", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOVideoContentComponent extends BaseContentComponent<ShortVideoMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AIOVideoViewer videoViewer;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b onVideoMuteChanged;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c mediaFocusHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent$b;", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/a;", "", "isMute", "", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "weak", "host", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mobileqq.qqnt.videoplay.api.param.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<AIOVideoContentComponent> weak;

        public b(@NotNull AIOVideoContentComponent host) {
            Intrinsics.checkNotNullParameter(host, "host");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) host);
            } else {
                this.weak = new WeakReference<>(host);
            }
        }

        @Override // com.tencent.mobileqq.qqnt.videoplay.api.param.a
        public void a(boolean isMute) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isMute);
                return;
            }
            com.tencent.mobileqq.aio.utils.b.f194119a.k("em_bas_aio_video_message_mute_butten");
            if (isMute) {
                AIOVideoContentComponent aIOVideoContentComponent = this.weak.get();
                if (aIOVideoContentComponent != null) {
                    aIOVideoContentComponent.G1();
                    return;
                }
                return;
            }
            AIOVideoContentComponent aIOVideoContentComponent2 = this.weak.get();
            if (aIOVideoContentComponent2 != null) {
                aIOVideoContentComponent2.P1();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/video/AIOVideoContentComponent$c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/y;", "", "i", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends y {
        static IPatchRedirector $redirector_;

        c() {
            super("video-bubble");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOVideoContentComponent.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.video.y
        public void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOVideoViewer aIOVideoViewer = AIOVideoContentComponent.this.videoViewer;
                if (aIOVideoViewer != null) {
                    aIOVideoViewer.w0(true);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63833);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOVideoContentComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        setMContext(context);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoContentComponent$contentView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOVideoContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                RelativeLayout O1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                O1 = AIOVideoContentComponent.this.O1();
                return O1;
            }
        });
        this.contentView = lazy;
        this.onVideoMuteChanged = new b(this);
        this.mediaFocusHelper = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1() {
        this.mediaFocusHelper.d();
    }

    private final AIOVideoViewer N1() {
        RelativeLayout Q1 = Q1();
        Context context = Q1().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
        return new AIOVideoViewer(Q1, context, new AIOVideoContentComponent$createVideoViewer$1(this), this.onVideoMuteChanged);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout O1() {
        RelativeLayout relativeLayout = new RelativeLayout(getMContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        com.tencent.mobileqq.aio.msglist.holder.c cVar = com.tencent.mobileqq.aio.msglist.holder.c.f190651a;
        layoutParams.leftMargin = cVar.b();
        layoutParams.topMargin = cVar.d();
        layoutParams.rightMargin = cVar.c();
        layoutParams.bottomMargin = cVar.a();
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setContentDescription(HardCodeUtil.qqStr(R.string.ypf));
        relativeLayout.setAlpha(0.99f);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1() {
        this.mediaFocusHelper.f();
    }

    private final RelativeLayout Q1() {
        return (RelativeLayout) this.contentView.getValue();
    }

    private final boolean R1(List<Object> payloads) {
        AIOVideoViewer aIOVideoViewer;
        AIOVideoViewer aIOVideoViewer2;
        boolean z16 = false;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                Object obj2 = map.get(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD);
                if (obj2 != null && (aIOVideoViewer2 = this.videoViewer) != null) {
                    aIOVideoViewer2.M((a.aw) obj2);
                }
                Object obj3 = map.get(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD);
                if (obj3 != null && (aIOVideoViewer = this.videoViewer) != null) {
                    aIOVideoViewer.O((a.ay) obj3);
                }
                z16 = true;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(Context context, ShortVideoMsgItem msgItem, View videoView, long playPos) {
        C1();
        if (msgItem.U2() != null) {
            sendIntent(new d.ba(msgItem, videoView, playPos));
        } else if (msgItem.N2()) {
            QQToast.makeText(context, context.getString(R.string.yux), 1, 1).show();
        } else {
            sendIntent(new d.ba(msgItem, videoView, playPos));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public a createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (R1(payloads)) {
            return;
        }
        if (x1()) {
            QLog.i("AIOVideoContentComponent", 1, "[bind] is same data, msgId=" + msgItem.getMsgId());
            return;
        }
        if (this.videoViewer == null) {
            this.videoViewer = N1();
        }
        AIOVideoViewer aIOVideoViewer = this.videoViewer;
        Intrinsics.checkNotNull(aIOVideoViewer);
        aIOVideoViewer.C(q1());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return Q1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return Q1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOVideoEvent$VideoPlayState) {
            AIOVideoViewer aIOVideoViewer = this.videoViewer;
            if (aIOVideoViewer != null) {
                aIOVideoViewer.I0(((AIOVideoEvent$VideoPlayState) state).a());
                return;
            }
            return;
        }
        super.handleUIState(state);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, importance);
        } else {
            Q1().setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        AIOVideoViewer aIOVideoViewer = this.videoViewer;
        if (aIOVideoViewer != null) {
            aIOVideoViewer.onDestroy();
        }
        this.videoViewer = null;
        this.mediaFocusHelper.d();
        E1(new ShortVideoMsgItem(new MsgRecord()));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.qqnt.aio.menu.v(getMContext(), q1(), this));
        arrayList.add(new com.tencent.qqnt.aio.menu.k(getMContext(), q1(), this, null, 8, null));
        if (!q1().O2() && !q1().Q2() && com.tencent.mobileqq.aio.utils.aa.f194101a.b(q1())) {
            arrayList.add(new com.tencent.qqnt.aio.menu.i(getMContext(), q1()));
        }
        if (q1().P2()) {
            arrayList.add(new af(getMContext(), q1(), this));
        }
        arrayList.add(new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this));
        arrayList.add(new com.tencent.qqnt.aio.menu.u(getMContext(), q1(), this));
        if (q1().P2()) {
            arrayList.add(new ad(getMContext(), q1(), this));
        }
        arrayList.add(new ap(getMContext(), q1(), this));
        arrayList.add(new com.tencent.qqnt.aio.menu.j(getMContext(), q1(), this));
        arrayList.add(new ag(getMContext(), q1()));
        arrayList.add(new aj(getMContext(), q1(), this));
        return arrayList;
    }
}
