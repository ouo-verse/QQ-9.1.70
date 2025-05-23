package com.tencent.mobileqq.aio.msglist.holder.component.file;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileState;
import com.tencent.mobileqq.aio.msglist.holder.component.file.b;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ai;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.am;
import com.tencent.qqnt.aio.menu.ao;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.menu.v;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J,\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J&\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0016H\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/FileMsgItem;", "", "M1", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "Landroid/view/View;", "clickedView", "", "isMute", "N1", "", "", "payloads", "K1", "", "msg", "payload", "P1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/file/b;", "I1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "e1", "importance", "l1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "J1", "()Landroid/widget/RelativeLayout;", "contentView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileViewer;", "D", "Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileViewer;", "fileViewer", "<init>", "(Landroid/content/Context;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOFileContentComponent extends BaseContentComponent<FileMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private AIOFileViewer fileViewer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/file/AIOFileContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileContentComponent$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60343);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOFileContentComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.AIOFileContentComponent$contentView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFileContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOFileContentComponent.this.context;
                return new RelativeLayout(context2);
            }
        });
        this.contentView = lazy;
    }

    private final RelativeLayout J1() {
        return (RelativeLayout) this.contentView.getValue();
    }

    private final boolean K1(List<Object> payloads) {
        a.aw awVar;
        FileTransNotifyInfo a16;
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                Object obj2 = map.get(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD);
                if (obj2 != null) {
                    if (obj2 instanceof a.aw) {
                        awVar = (a.aw) obj2;
                    } else {
                        awVar = null;
                    }
                    if (awVar != null && (a16 = awVar.a()) != null) {
                        P1("rich_media_state", a16);
                        if (AIOUtil.f194084a.t() && !((FileMsgItem) q1()).isSelf() && a16.fileDownType == 1 && a16.trasferStatus == 4) {
                            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.file.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    AIOFileContentComponent.L1(AIOFileContentComponent.this);
                                }
                            }, 100L);
                        }
                    }
                }
                Object obj3 = map.get(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD);
                if (obj3 != null) {
                    P1("msg_send_status_state", obj3);
                }
                Object obj4 = map.get(AIOMsgItemPayloadType.FILE_TRANSFER_STATUS_PAYLOAD);
                if (obj4 != null) {
                    P1("file_transfer_status_state", obj4);
                }
                Object obj5 = map.get(AIOMsgItemPayloadType.FILE_TRANSFER_PROGRESS_PAYLOAD);
                if (obj5 != null) {
                    P1("file_transfer_progress_status_state", obj5);
                }
                Object obj6 = map.get(AIOMsgItemPayloadType.FILE_TRANSFER_END_PAYLOAD);
                if (obj6 != null) {
                    P1("file_transfer_end_state", obj6);
                }
                z16 = false;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(AIOFileContentComponent this$0) {
        FileElement fileElement;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileMsgItem q16 = this$0.q1();
        MsgElement q26 = this$0.q1().q2();
        if (q26 != null) {
            fileElement = q26.fileElement;
        } else {
            fileElement = null;
        }
        AIOFileViewer aIOFileViewer = this$0.fileViewer;
        Intrinsics.checkNotNull(aIOFileViewer);
        this$0.sendIntent(new b.a(q16, fileElement, aIOFileViewer.F(), false));
    }

    private final void M1() {
        MsgElement firstTypeElement = q1().getFirstTypeElement(3);
        if (firstTypeElement == null) {
            q.e("AIOFileContentComponent", "initUIState, file element not exists, msg=" + q1());
            return;
        }
        AIOFileViewer aIOFileViewer = this.fileViewer;
        if (aIOFileViewer == null) {
            this.fileViewer = new AIOFileViewer(q1(), firstTypeElement, J1(), getMContext(), q1().isSelf(), new AIOFileContentComponent$initUIState$1(this));
        } else {
            Intrinsics.checkNotNull(aIOFileViewer);
            aIOFileViewer.u0(q1(), firstTypeElement);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002f, code lost:
    
        if (r2 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void N1(AIOMsgItem aioMsgItem, FileElement fileElement, View clickedView, boolean isMute) {
        com.tencent.aio.api.runtime.a aVar;
        q.d("AIOFileContentComponent", "on click file bubble, msg=" + aioMsgItem);
        C1();
        AIOUtil aIOUtil = AIOUtil.f194084a;
        if (aIOUtil.t()) {
            AIOFileViewer aIOFileViewer = this.fileViewer;
            boolean z16 = false;
            if (aIOFileViewer != null && !aIOFileViewer.S()) {
                z16 = true;
            }
        }
        sendIntent(new b.a(aioMsgItem, fileElement, clickedView, isMute));
        FrameworkVM mUIModel = getMUIModel();
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (mUIModel != null) {
            aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext();
        } else {
            aVar = null;
        }
        if (aIOUtil.y(aVar)) {
            FrameworkVM mUIModel2 = getMUIModel();
            if (mUIModel2 != null) {
                aVar2 = (com.tencent.aio.api.runtime.a) mUIModel2.getMContext();
            }
            aIOUtil.E(aVar2, aioMsgItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void O1(AIOFileContentComponent aIOFileContentComponent, AIOMsgItem aIOMsgItem, FileElement fileElement, View view, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        aIOFileContentComponent.N1(aIOMsgItem, fileElement, view, z16);
    }

    private final void P1(String msg2, Object payload) {
        AIOFileViewer aIOFileViewer = this.fileViewer;
        if (aIOFileViewer != null) {
            aIOFileViewer.t0(msg2, payload);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (MsgExtKt.B(q1().getMsgRecord())) {
            return;
        }
        AIOFileViewer aIOFileViewer = this.fileViewer;
        if (aIOFileViewer != null) {
            aIOFileViewer.z0(msgItem);
        }
        q1().E2();
        if (K1(payloads)) {
            if (x1()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AIOFileContentComponent", 4, "[bind] same data, this=" + this + " msg=" + msgItem);
                    return;
                }
                return;
            }
            M1();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return J1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        AIOFileViewer aIOFileViewer = this.fileViewer;
        if (aIOFileViewer != null) {
            return aIOFileViewer.D();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        RoundBubbleImageView N;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOFileState.MutePlay) {
            MsgElement firstTypeElement = q1().getFirstTypeElement(3);
            if (firstTypeElement == null) {
                q.e("AIOFileContentComponent", "mutePlay, file element not exists, msg=" + q1());
                return;
            }
            AIOFileViewer aIOFileViewer = this.fileViewer;
            if (aIOFileViewer != null && (N = aIOFileViewer.N()) != null) {
                N1(q1(), firstTypeElement.fileElement, N, true);
                return;
            }
            return;
        }
        if (state instanceof AIOFileState.UpdateFileState) {
            QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "handleUIState fileViewer?.updateFileState()");
            AIOFileViewer aIOFileViewer2 = this.fileViewer;
            if (aIOFileViewer2 != null) {
                aIOFileViewer2.w0();
                return;
            }
            return;
        }
        super.handleUIState(state);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, importance);
            return;
        }
        AIOFileViewer aIOFileViewer = this.fileViewer;
        if (aIOFileViewer != null) {
            view = aIOFileViewer.D();
        } else {
            view = null;
        }
        if (view != null) {
            view.setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        FileElement fileElement;
        boolean z16;
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf2;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (q1().getMsgRecord().chatType == 8) {
            FileElement n26 = q1().n2();
            if (n26 != null && (num = n26.transferStatus) != null && num.intValue() == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(new k(getMContext(), q1(), this, null, 8, null), new com.tencent.qqnt.aio.menu.i(getMContext(), q1()), new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new ai(getMContext(), q1(), this));
                return mutableListOf2;
            }
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this));
            return mutableListOf;
        }
        ArrayList arrayList = new ArrayList();
        MsgElement q26 = q1().q2();
        if (q26 != null && (fileElement = q26.fileElement) != null) {
            if (c81.a.j(fileElement) == 2) {
                if (c81.a.b(q1(), q1().n2())) {
                    arrayList.add(new v(getMContext(), q1(), this));
                }
                arrayList.add(new k(getMContext(), q1(), this, null, 8, null));
                arrayList.add(new com.tencent.qqnt.aio.menu.i(getMContext(), q1()));
                arrayList.add(new af(getMContext(), q1(), this));
                arrayList.add(new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this));
                arrayList.add(new u(getMContext(), q1(), this));
                arrayList.add(new ad(getMContext(), q1(), this));
                arrayList.add(new am(getMContext(), q1(), this));
                arrayList.add(new ap(getMContext(), q1(), this));
                arrayList.add(new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this));
                arrayList.add(new ao(getMContext(), q1()));
                arrayList.add(new aj(getMContext(), q1(), this));
            } else {
                arrayList.add(new k(getMContext(), q1(), this, null, 8, null));
                arrayList.add(new com.tencent.qqnt.aio.menu.i(getMContext(), q1()));
                arrayList.add(new ap(getMContext(), q1(), this));
                arrayList.add(new af(getMContext(), q1(), this));
                arrayList.add(new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this));
                arrayList.add(new u(getMContext(), q1(), this));
                arrayList.add(new ad(getMContext(), q1(), this));
                arrayList.add(new am(getMContext(), q1(), this));
                arrayList.add(new ai(getMContext(), q1(), this));
                arrayList.add(new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this));
                arrayList.add(new ao(getMContext(), q1()));
                arrayList.add(new aj(getMContext(), q1(), this));
            }
        }
        return arrayList;
    }
}
