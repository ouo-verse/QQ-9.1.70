package com.tencent.guild.aio.article.input;

import android.os.Bundle;
import android.text.Spannable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.route.msg.InputMsg$InputEmojiMsg;
import com.tencent.aio.base.route.msg.InputMsg$ShowKeyboardMsg;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.result.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.article.input.GuildArticleAIOInputUIState;
import com.tencent.guild.aio.article.msglist.GuildArticleMsgListEvent;
import com.tencent.guild.aio.article.msglist.h;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.component.GuildBubbleAvatarLongClickEvent;
import com.tencent.guild.aio.reserve2.busi.navigate.GuildMsgNavigateEvent;
import com.tencent.guild.aio.sendmsg.SendMsgInterceptUtil;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.input.GuildAioInputMsgIntent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import fo0.e;
import fo0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kr0.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0004\n\u0002\b\u0007*\u0002SW\u0018\u0000 32\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\\B\u000f\u0012\u0006\u0010H\u001a\u00020E\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020\"H\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u0007H\u0002J\u0016\u0010)\u001a\u00020\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\b\u0010*\u001a\u00020\rH\u0002J\u0010\u0010+\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007H\u0002J\u001e\u0010.\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00172\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0&H\u0002J\u0010\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\rH\u0002J\u0010\u00103\u001a\u00020\r2\u0006\u00102\u001a\u00020\u0017H\u0002J\u001a\u00107\u001a\u00020\r2\u0006\u00104\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u000105H\u0002J\b\u00108\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\r2\u0006\u0010:\u001a\u000209H\u0002J\u0012\u0010<\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u000105H\u0002J\u001b\u0010=\u001a\u00020\r2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0017H\u0002\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010A\u001a\u00020\r2\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010B\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0002H\u0016J\b\u0010C\u001a\u00020\rH\u0016J\b\u0010D\u001a\u00020\u0005H\u0016R\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010\nR\u0016\u0010R\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010X\u00a8\u0006]"}, d2 = {"Lcom/tencent/guild/aio/article/input/GuildArticleAIOInputViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "H", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "y", "Lcom/tencent/aio/data/msglist/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/base/route/msg/InputMsg$InputEmojiMsg;", "action", HippyTKDListViewAdapter.X, NodeProps.ENABLED, "X", "L", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "M", "t", "u", "N", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lfo0/e$l;", "intent", "U", "Lfo0/e$k;", ExifInterface.LATITUDE_SOUTH, "msgIntent", "T", "", "Lsr0/b;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, BdhLogUtil.LogTag.Tag_Req, "r", "E", "lastPosition", "msgItemList", "W", "isMultiSelectMode", "K", "J", "permissions", "D", "isSuccess", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", BdhLogUtil.LogTag.Tag_Conn, "O", "", "mainMsgSeq", UserInfo.SEX_FEMALE, "B", "v", "(Ljava/lang/Integer;)V", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "Lcom/tencent/guild/aio/article/input/s;", "d", "Lcom/tencent/guild/aio/article/input/s;", "fetcher", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mMainMsgRecord", "f", "Ljava/util/List;", "mChatList", tl.h.F, "mLastPosition", "Z", "mCanShowInputBar", "com/tencent/guild/aio/article/input/GuildArticleAIOInputViewModel$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/article/input/GuildArticleAIOInputViewModel$b;", "mAction", "com/tencent/guild/aio/article/input/GuildArticleAIOInputViewModel$c", "Lcom/tencent/guild/aio/article/input/GuildArticleAIOInputViewModel$c;", "mActionR", "<init>", "(Lcom/tencent/guild/aio/article/input/s;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleAIOInputViewModel extends com.tencent.aio.base.mvvm.b<fo0.e, GuildAioDefaultInputUIState> implements com.tencent.aio.api.runtime.emitter.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c mActionR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final s fetcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord mMainMsgRecord;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends com.tencent.aio.data.msglist.a> mChatList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mLastPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mCanShowInputBar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/input/GuildArticleAIOInputViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildArticleAIOInputViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/input/GuildArticleAIOInputViewModel$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildArticleAIOInputViewModel.this.I(i3);
        }
    }

    public GuildArticleAIOInputViewModel(@NotNull s fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.fetcher = fetcher;
        this.mChatList = new ArrayList();
        this.mLastPosition = -1;
        this.mCanShowInputBar = true;
        this.mAction = new b();
        this.mActionR = new c();
    }

    private final void B(MsgRecord msgRecord) {
        this.mMainMsgRecord = msgRecord;
        w(this, null, 1, null);
    }

    private final void C(boolean isSuccess, MsgRecord msgRecord) {
        this.mMainMsgRecord = msgRecord;
        w(this, null, 1, null);
        if (msgRecord != null) {
            F(msgRecord.msgSeq);
        }
    }

    private final void D(int permissions) {
        v(Integer.valueOf(permissions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            K(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent).getIsSelectMode());
            return;
        }
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectCountChangeEvent) {
            J();
            return;
        }
        if (intent instanceof GuildArticleMsgListEvent.MainMsgRecordInitCompleted) {
            GuildArticleMsgListEvent.MainMsgRecordInitCompleted mainMsgRecordInitCompleted = (GuildArticleMsgListEvent.MainMsgRecordInitCompleted) intent;
            C(mainMsgRecordInitCompleted.getIsSuccess(), mainMsgRecordInitCompleted.getMsgRecord());
            return;
        }
        if (intent instanceof GuildArticleMsgListEvent.MainMsgInfoUpdated) {
            B(((GuildArticleMsgListEvent.MainMsgInfoUpdated) intent).getMsgRecord());
            return;
        }
        if (intent instanceof InputMsg$ShowKeyboardMsg) {
            updateUI(GuildAioDefaultInputUIState.GuildShowKeyboard.f110855e);
            return;
        }
        if (intent instanceof InputMsg$InputEmojiMsg) {
            x((InputMsg$InputEmojiMsg) intent);
            return;
        }
        if (intent instanceof GuildMsgSendEvent.MsgOnClickReplyEvent) {
            z(((GuildMsgSendEvent.MsgOnClickReplyEvent) intent).getMsgItem());
            return;
        }
        if (intent instanceof GuildBubbleAvatarLongClickEvent) {
            y(((GuildBubbleAvatarLongClickEvent) intent).getMsgItem());
            return;
        }
        if (intent instanceof PanelMsg.HideAllPanelAndKeyboard) {
            updateUI(GuildAioDefaultInputUIState.GuideInputHideState.f110831e);
            return;
        }
        if (intent instanceof GuildAioInputMsgIntent.InputDeleteEvent) {
            UIUtil.f112434a.i(this.fetcher.g());
            return;
        }
        if (intent instanceof GuildPermissionsChangeWrapperMsgIntent) {
            D(((GuildPermissionsChangeWrapperMsgIntent) intent).getPermissions());
            return;
        }
        if (intent instanceof GuildAioInputMsgIntent.UpdateSendBtnClickable) {
            X(((GuildAioInputMsgIntent.UpdateSendBtnClickable) intent).getClickable());
            return;
        }
        if (intent instanceof GuildMsgListIntent.ExposureVisibleMsgListEvent) {
            GuildMsgListIntent.ExposureVisibleMsgListEvent exposureVisibleMsgListEvent = (GuildMsgListIntent.ExposureVisibleMsgListEvent) intent;
            W(exposureVisibleMsgListEvent.getLastPosition(), exposureVisibleMsgListEvent.c());
        } else if (intent instanceof GuildArticleMsgListEvent.ArticleMsgListUpdated) {
            GuildArticleMsgListEvent.ArticleMsgListUpdated articleMsgListUpdated = (GuildArticleMsgListEvent.ArticleMsgListUpdated) intent;
            W(articleMsgListUpdated.getLastPosition(), articleMsgListUpdated.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F(long mainMsgSeq) {
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        final Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        ((IMsgService) QRoute.api(IMsgService.class)).getReplyDraft(contact, mainMsgSeq, new IGetDraftOperateCallback() { // from class: com.tencent.guild.aio.article.input.p
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, long j3) {
                GuildArticleAIOInputViewModel.G(Contact.this, this, i3, str, arrayList, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Contact contact, final GuildArticleAIOInputViewModel this$0, int i3, String str, ArrayList msgElements, long j3) {
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildArticleAIOInputViewModel", 4, "getDraft() result:" + i3 + ", errMsg:" + str + ", msgElements:" + msgElements + ", draftTime:" + j3);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        Intrinsics.checkNotNullExpressionValue(msgElements, "msgElements");
        guildDraftUtil.e(msgElements, contact, this$0.vmScope(), new Function1<com.tencent.aio.data.msglist.a, Unit>() { // from class: com.tencent.guild.aio.article.input.GuildArticleAIOInputViewModel$handleRecoverDraft$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.aio.data.msglist.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.aio.data.msglist.a msgItem) {
                Intrinsics.checkNotNullParameter(msgItem, "msgItem");
                GuildArticleAIOInputViewModel.this.updateUI(new GuildAioDefaultInputUIState.GuideInputReplyMsg(msgItem, false));
            }
        });
        this$0.updateUI(new GuildAioDefaultInputUIState.RecoverDraft(msgElements, false, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean H() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent i3) {
        if (i3 instanceof GuildMsgSendEvent.InputContainerHighGetEventR) {
            return new g.a(this.fetcher.b());
        }
        if (i3 instanceof GuildAioInputMsgIntent.GetInputEditTextEventR) {
            return new a.C10677a(this.fetcher.g());
        }
        return pn0.b.f426490a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J() {
        updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K(boolean isMultiSelectMode) {
        if (isMultiSelectMode) {
            updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
        }
        updateUI(new GuildAioDefaultInputUIState.GuildMultiSelectModeChanged(isMultiSelectMode, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext()), this.mCanShowInputBar));
    }

    private final void L() {
        int i3;
        List<? extends com.tencent.aio.data.msglist.a> list;
        int t16 = t();
        if (t16 >= 0 && (i3 = this.mLastPosition) >= 0 && i3 >= t16 && (list = this.mChatList) != null) {
            Intrinsics.checkNotNull(list);
            if (i3 <= list.size() - 1) {
                M(t16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M(int first) {
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        int i3 = this.mLastPosition + 1;
        while (true) {
            com.tencent.aio.data.msglist.a aVar = null;
            if (first < i3) {
                List<? extends com.tencent.aio.data.msglist.a> list = this.mChatList;
                if (list != null) {
                    aVar = list.get(first);
                }
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                GuildMultiMsgManager.Companion companion = GuildMultiMsgManager.INSTANCE;
                if (!companion.a().h(dVar, guildMsgItem) && !guildMsgItem.isWalletMsg() && guildMsgItem.getMsgRecord().msgType != 0) {
                    companion.a().b(dVar, guildMsgItem);
                }
                first++;
            } else {
                J();
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMsgListRefreshEvent("GuildArticleAIOInputViewModel", null, 2, null));
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N() {
        if (zp0.b.x(zp0.b.f452962a, (com.tencent.aio.api.runtime.a) getMContext(), 0, 2, null)) {
            q();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O() {
        List<e.InputSendTextIntent> emptyList;
        Bundle b16 = fetchVBState(t.a.f111174a).b();
        Long valueOf = Long.valueOf(b16.getLong("guild_draft_input_reply_msg_id"));
        e.ReplyData replyData = null;
        if (valueOf.longValue() == QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR) {
            valueOf = null;
        }
        String string = b16.getString("guild_draft_input_reply_nick");
        String str = "";
        if (string == null) {
            string = "";
        }
        String string2 = b16.getString("guild_draft_input_reply_content");
        if (string2 == null) {
            string2 = "";
        }
        CharSequence charSequence = b16.getCharSequence("guild_draft_input_editable_text");
        String string3 = b16.getString("guild_draft_input_text");
        if (string3 != null) {
            str = string3;
        }
        AIOParam it = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        if (!(charSequence instanceof Spannable)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = com.tencent.guild.aio.util.e.f112380a.b(str, (Spannable) charSequence);
        }
        if (valueOf != null) {
            replyData = new e.ReplyData(valueOf.longValue(), string, string2);
        }
        ArrayList<MsgElement> a16 = com.tencent.guild.api.msg.service.l.f112634a.a(lp0.a.f415333a.e(new e.InputSendMultiTextIntent(emptyList, replyData)));
        MsgRecord msgRecord = this.mMainMsgRecord;
        if (msgRecord != null) {
            if (a16.isEmpty()) {
                ((IMsgService) QRoute.api(IMsgService.class)).deleteReplyDraft(contact, msgRecord.msgSeq, new IOperateCallback() { // from class: com.tencent.guild.aio.article.input.n
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str2) {
                        GuildArticleAIOInputViewModel.P(i3, str2);
                    }
                });
            } else {
                ((IMsgService) QRoute.api(IMsgService.class)).setReplyDraft(contact, msgRecord.msgSeq, a16, new IOperateCallback() { // from class: com.tencent.guild.aio.article.input.o
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str2) {
                        GuildArticleAIOInputViewModel.Q(i3, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(int i3, String str) {
        QLog.i("GuildArticleAIOInputViewModel", 4, "deleteDraft() result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(int i3, String str) {
        QLog.i("GuildArticleAIOInputViewModel", 4, "saveDraft() result:" + i3 + ", errMsg:" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R(List<sr0.b> elements) {
        if (elements.isEmpty()) {
            return;
        }
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(SendMsgInterceptUtil.b(SendMsgInterceptUtil.f112285a, new com.tencent.aio.msgservice.k(((com.tencent.aio.api.runtime.a) getMContext()).g().r(), elements), (com.tencent.aio.api.runtime.a) getMContext(), null, 4, null), new GuildArticleAIOInputViewModel$sendMsg$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    private final void S(e.InputSendMultiTextIntent intent) {
        e.ReplyData replyData = intent.getReplyData();
        Intrinsics.checkNotNull(replyData);
        if (replyData.getReplyMsgId() == 0) {
            com.tencent.mvi.base.route.k T = T(GuildArticleMsgListEvent.MainMsgIdGet.f109913d);
            Intrinsics.checkNotNull(T, "null cannot be cast to non-null type com.tencent.guild.aio.article.msglist.GuildArticleMsgListResult.MainMsgIdGetResult");
            R(lp0.a.f415333a.e(new e.InputSendMultiTextIntent(intent.b(), new e.ReplyData(((h.a) T).getMsgId(), intent.getReplyData().getReplyNick(), intent.getReplyData().getReplyContent()))));
            return;
        }
        R(lp0.a.f415333a.e(intent));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.tencent.mvi.base.route.k T(MsgIntent msgIntent) {
        return ((com.tencent.aio.api.runtime.a) getMContext()).e().k(msgIntent);
    }

    private final void U(e.InputSendTextIntent intent) {
        R(lp0.a.f415333a.f(intent));
    }

    private final void W(int lastPosition, List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        this.mLastPosition = lastPosition;
        this.mChatList = msgItemList;
    }

    private final void X(boolean enabled) {
        updateUI(new GuildAioDefaultInputUIState.UpdateSendBtnClickable(enabled));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildArticleAIOInputViewModel", false));
        K(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        updateUI(new GuildAioDefaultInputUIState.GuideClearEditInput(false, 1, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        if (g16.isEmpty()) {
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), R.string.f139010a4, 0).show();
        } else {
            zp0.b.f452962a.t((com.tencent.aio.api.runtime.a) getMContext(), g16);
            q();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int t() {
        com.tencent.aio.data.msglist.a aVar;
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        List<? extends com.tencent.aio.data.msglist.a> list = this.mChatList;
        Intrinsics.checkNotNull(list);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            List<? extends com.tencent.aio.data.msglist.a> list2 = this.mChatList;
            if (list2 != null) {
                aVar = list2.get(i3);
            } else {
                aVar = null;
            }
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            if (GuildMultiMsgManager.INSTANCE.a().h(dVar, (GuildMsgItem) aVar)) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
    
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u() {
        List filterNotNull;
        com.tencent.mvi.base.route.k T = T(GuildArticleMsgListEvent.MainMsgRecordGet.f109915d);
        Intrinsics.checkNotNull(T, "null cannot be cast to non-null type com.tencent.guild.aio.article.msglist.GuildArticleMsgListResult.MainMsgRecordGetResult");
        MsgRecord msgRecord = ((h.b) T).getMsgRecord();
        ArrayList arrayList = new ArrayList();
        if (msgRecord != null && (r0 = msgRecord.elements) != null && filterNotNull != null) {
            Iterator it = filterNotNull.iterator();
            while (it.hasNext()) {
                arrayList.add((MsgElement) it.next());
            }
        }
        updateUI(new GuildAioDefaultInputUIState.GuildInputHint(iq0.a.p(arrayList, false, false, 4, null).toString(), false, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(Integer permissions) {
        boolean d16;
        MsgRecord msgRecord = this.mMainMsgRecord;
        boolean z16 = true;
        if (msgRecord != null) {
            Intrinsics.checkNotNull(msgRecord);
            if (msgRecord.msgType != 5) {
                MsgRecord msgRecord2 = this.mMainMsgRecord;
                Intrinsics.checkNotNull(msgRecord2);
                if (msgRecord2.msgType != 1) {
                    if (permissions == null) {
                        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
                        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                        String g17 = com.tencent.guild.aio.util.a.g(g16);
                        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
                        int a16 = fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18));
                        AIOParam g19 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                        Intrinsics.checkNotNullExpressionValue(g19, "mContext.aioParam");
                        d16 = companion.d(a16, com.tencent.guild.aio.util.a.g(g19));
                    } else {
                        GuildSpeakLimitStatus.Companion companion2 = GuildSpeakLimitStatus.INSTANCE;
                        int intValue = permissions.intValue();
                        AIOParam g26 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                        Intrinsics.checkNotNullExpressionValue(g26, "mContext.aioParam");
                        d16 = companion2.d(intValue, com.tencent.guild.aio.util.a.g(g26));
                    }
                    this.mCanShowInputBar = d16;
                    GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
                    if (this.mCanShowInputBar || GuildMultiMsgManager.INSTANCE.a().i(dVar)) {
                        z16 = false;
                    }
                    updateUI(new GuildArticleAIOInputUIState.ShowInputBar(z16));
                }
            }
        }
        this.mCanShowInputBar = false;
        GuildMultiMsgManager.d dVar2 = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        if (this.mCanShowInputBar) {
        }
        z16 = false;
        updateUI(new GuildArticleAIOInputUIState.ShowInputBar(z16));
    }

    static /* synthetic */ void w(GuildArticleAIOInputViewModel guildArticleAIOInputViewModel, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        guildArticleAIOInputViewModel.v(num);
    }

    private final void x(InputMsg$InputEmojiMsg action) {
        updateUI(new GuildAioDefaultInputUIState.GuideReplaceInputEmotion(action.a()));
    }

    private final void y(GuildMsgItem msgItem) {
        updateUI(new GuildAioDefaultInputUIState.GuildInputInsertAt(msgItem));
    }

    private final void z(com.tencent.aio.data.msglist.a msgItem) {
        updateUI(new GuildAioDefaultInputUIState.GuideInputReplyMsg(msgItem, false, 2, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.InputSendTextIntent) {
            U((e.InputSendTextIntent) intent);
            return;
        }
        if (intent instanceof e.InputSendMultiTextIntent) {
            S((e.InputSendMultiTextIntent) intent);
            return;
        }
        if (intent instanceof e.j) {
            N();
            return;
        }
        if (intent instanceof e.h) {
            s();
            return;
        }
        if (intent instanceof e.i) {
            u();
            return;
        }
        if (intent instanceof e.q) {
            L();
            return;
        }
        if (intent instanceof e.f) {
            updateUI(new GuildAioDefaultInputUIState.InitAtCluster((com.tencent.aio.api.runtime.a) getMContext()));
        } else if (intent instanceof e.b) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.ShowKeyboardAnyStatus("GuildArticleAIOInputViewModel"));
        } else if (intent instanceof e.c) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgNavigateEvent.GuildNavigateToMsgEvent("GuildArticleAIOInputViewModel", ((e.c) intent).getMsgItem().getMsgSeq()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        if (H()) {
            q();
            return true;
        }
        com.tencent.mvi.base.route.k T = T(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
        Intrinsics.checkNotNull(T, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
        a.C0653a c0653a = (a.C0653a) T;
        if (!Intrinsics.areEqual(c0653a.b(), Boolean.TRUE) && c0653a.a() == null) {
            return false;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildArticleAIOInputViewModel", false, 2, null));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(InputMsg$InputEmojiMsg.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildBubbleAvatarLongClickEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(InputMsg$ShowKeyboardMsg.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelMsg.HideAllPanelAndKeyboard.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.InputContainerHighGetEventR.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().a(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.GetInputEditTextEventR.class).getQualifiedName());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.InputDeleteEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgInfoUpdated.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.UpdateSendBtnClickable.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.ArticleMsgListUpdated.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        O();
        this.mMainMsgRecord = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectCountChangeEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgRecordInitCompleted.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.MainMsgInfoUpdated.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(InputMsg$InputEmojiMsg.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.MsgOnClickReplyEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildBubbleAvatarLongClickEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(InputMsg$ShowKeyboardMsg.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(PanelMsg.HideAllPanelAndKeyboard.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), this.mAction);
        context.e().j(Reflection.getOrCreateKotlinClass(GuildMsgSendEvent.InputContainerHighGetEventR.class).getQualifiedName(), this.mActionR);
        context.e().j(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.GetInputEditTextEventR.class).getQualifiedName(), this.mActionR);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.InputDeleteEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildAioInputMsgIntent.UpdateSendBtnClickable.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.ExposureVisibleMsgListEvent.class).getQualifiedName(), this.mAction);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildArticleMsgListEvent.ArticleMsgListUpdated.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        K(GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(context.g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))));
        com.tencent.guild.aio.util.ex.a.c((com.tencent.aio.api.runtime.a) getMContext());
    }
}
