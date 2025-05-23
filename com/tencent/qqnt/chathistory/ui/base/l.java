package com.tencent.qqnt.chathistory.ui.base;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.datatracker.HistoryDtReportHelper;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel;
import com.tencent.qqnt.chathistory.ui.sticker.data.model.SearchStickerItemModel;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J/\u0010\r\u001a\u00020\u00042%\u0010\f\u001a!\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0007H\u0016J/\u0010\u000e\u001a\u00020\u000b2%\u0010\f\u001a!\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016Jp\u0010!\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000f26\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\"H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\"H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\"H\u0016R\"\u0010,\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010/R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010/R\u0014\u00105\u001a\u0002038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/l;", "", "", "msgId", "", "j", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "choose", "", "callBack", "d", "k", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cb", "c", "Landroid/view/View;", "itemView", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "msgItemModel", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Lkotlin/Function2;", "isEnabled", "isFavEnabled", "setBottomBarState", "Landroid/view/View$OnClickListener;", "listener", "", "elementId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "g", "i", tl.h.F, "a", "Z", "f", "()Z", "l", "(Z)V", "chooseModel", "", "b", "Ljava/util/List;", "chooseListData", "chooseItemModelList", "chooseRecordList", "", "I", "MULTI_SELECT_LIMIT", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean chooseModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Long> chooseListData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.qqnt.chathistory.ui.base.item.b> chooseItemModelList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MsgRecord> chooseRecordList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int MULTI_SELECT_LIMIT;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/chathistory/ui/base/l$a", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MsgRecord f353370b;

        a(MsgRecord msgRecord) {
            this.f353370b = msgRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this, (Object) msgRecord);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@Nullable View host, @Nullable AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) host, (Object) info);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (!l.this.f()) {
                if (info != null) {
                    info.setCheckable(false);
                }
            } else {
                if (info != null) {
                    info.setCheckable(true);
                }
                if (info != null) {
                    info.setChecked(l.this.j(this.f353370b.msgId));
                }
            }
        }
    }

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.chooseListData = new ArrayList();
        this.chooseItemModelList = new ArrayList();
        this.chooseRecordList = new ArrayList();
        this.MULTI_SELECT_LIMIT = 20;
    }

    private final boolean e() {
        if (this.chooseListData.size() >= this.MULTI_SELECT_LIMIT) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(long msgId) {
        return this.chooseListData.contains(Long.valueOf(msgId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(l this$0, View.OnClickListener listener, MsgRecord msgRecord, com.tencent.qqnt.chathistory.ui.base.item.b msgItemModel, Function2 setBottomBarState, View itemView, String elementId, QUICheckBox checkbox, View it) {
        String qqStr;
        boolean z16;
        HistoryDtReportHelper.MediaType mediaType;
        Map<String, Object> mutableMapOf;
        boolean z17;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(msgItemModel, "$msgItemModel");
        Intrinsics.checkNotNullParameter(setBottomBarState, "$setBottomBarState");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(checkbox, "$checkbox");
        if (!this$0.f()) {
            listener.onClick(it);
        } else {
            if (this$0.chooseListData.contains(Long.valueOf(msgRecord.msgId))) {
                this$0.chooseListData.remove(Long.valueOf(msgRecord.msgId));
                this$0.chooseItemModelList.remove(msgItemModel);
                this$0.chooseRecordList.remove(msgRecord);
                if (this$0.chooseRecordList.isEmpty()) {
                    Boolean bool = Boolean.FALSE;
                    setBottomBarState.invoke(bool, bool);
                } else {
                    boolean z18 = false;
                    loop0: while (true) {
                        z17 = z18;
                        for (com.tencent.qqnt.chathistory.ui.base.item.b bVar : this$0.chooseItemModelList) {
                            if (!(bVar instanceof FileItemModel)) {
                                break;
                            }
                            FileItemModel fileItemModel = (FileItemModel) bVar;
                            if (!fileItemModel.A()) {
                                z18 = true;
                            }
                            if (fileItemModel.E()) {
                                z17 = true;
                            }
                        }
                        z18 = true;
                    }
                    if (!z18) {
                        Boolean bool2 = Boolean.FALSE;
                        setBottomBarState.invoke(bool2, bool2);
                    } else {
                        setBottomBarState.invoke(Boolean.TRUE, Boolean.valueOf(z17));
                    }
                }
            } else if (this$0.e()) {
                try {
                    if (msgItemModel instanceof SearchMediaItemModel) {
                        qqStr = HardCodeUtil.qqStr(R.string.a1i);
                    } else if (msgItemModel instanceof SearchStickerItemModel) {
                        qqStr = HardCodeUtil.qqStr(R.string.a1f);
                    } else if (msgItemModel instanceof FileItemModel) {
                        qqStr = HardCodeUtil.qqStr(R.string.a1g);
                    } else if (msgItemModel instanceof com.tencent.qqnt.chathistory.ui.document.data.model.b) {
                        qqStr = HardCodeUtil.qqStr(R.string.zkw);
                    } else if (msgItemModel instanceof com.tencent.qqnt.chathistory.ui.link.data.model.a) {
                        qqStr = HardCodeUtil.qqStr(R.string.a1h);
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.a1g);
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String qqStr2 = HardCodeUtil.qqStr(R.string.zka);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.chat_history_multi_select_limit)");
                    String format = String.format(qqStr2, Arrays.copyOf(new Object[]{qqStr}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    QQToast.makeText(itemView.getContext(), format, 0).show();
                } catch (Throwable unused) {
                }
            } else {
                this$0.chooseListData.add(Long.valueOf(msgRecord.msgId));
                this$0.chooseItemModelList.add(msgItemModel);
                this$0.chooseRecordList.add(msgRecord);
                boolean z19 = false;
                loop2: while (true) {
                    z16 = z19;
                    for (com.tencent.qqnt.chathistory.ui.base.item.b bVar2 : this$0.chooseItemModelList) {
                        if (!(bVar2 instanceof FileItemModel)) {
                            break;
                        }
                        FileItemModel fileItemModel2 = (FileItemModel) bVar2;
                        if (!fileItemModel2.A()) {
                            z19 = true;
                        }
                        if (fileItemModel2.E()) {
                            z16 = true;
                        }
                    }
                    z19 = true;
                }
                if (!z19) {
                    Boolean bool3 = Boolean.FALSE;
                    setBottomBarState.invoke(bool3, bool3);
                } else {
                    setBottomBarState.invoke(Boolean.TRUE, Boolean.valueOf(z16));
                }
            }
            if (Intrinsics.areEqual(elementId, "em_bas_photovideo_entry")) {
                if (((SearchMediaItemModel) msgItemModel).p()) {
                    mediaType = HistoryDtReportHelper.MediaType.PIC;
                } else {
                    mediaType = HistoryDtReportHelper.MediaType.VIDEO;
                }
                HistoryDtReportHelper a16 = HistoryDtReportHelper.INSTANCE.a();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("operation_content", Integer.valueOf(HistoryDtReportHelper.OperationContent.SELECT.ordinal())), TuplesKt.to("entry_message_type", Integer.valueOf(mediaType.ordinal())));
                a16.m(it, elementId, mutableMapOf);
            } else {
                HistoryDtReportHelper a17 = HistoryDtReportHelper.INSTANCE.a();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                HistoryDtReportHelper.n(a17, it, elementId, null, 4, null);
            }
            this$0.c(checkbox, msgRecord.msgId);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    public boolean c(@NotNull QUICheckBox cb5, long msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, cb5, Long.valueOf(msgId))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (f()) {
            cb5.setVisibility(0);
            cb5.setChecked(j(msgId));
        } else {
            cb5.setVisibility(8);
        }
        if (cb5.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean d(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) callBack)).booleanValue();
        }
        l(!f());
        if (callBack != null) {
            callBack.invoke(Boolean.valueOf(f()));
        }
        if (!f()) {
            this.chooseListData.clear();
            this.chooseItemModelList.clear();
            this.chooseRecordList.clear();
        }
        return f();
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.chooseModel;
    }

    @NotNull
    public List<Long> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.chooseListData;
    }

    @NotNull
    public List<com.tencent.qqnt.chathistory.ui.base.item.b> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.chooseItemModelList;
    }

    @NotNull
    public List<MsgRecord> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.chooseRecordList;
    }

    public void k(@Nullable Function1<? super Boolean, Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callBack);
        } else {
            if (!f()) {
                return;
            }
            d(callBack);
        }
    }

    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.chooseModel = z16;
        }
    }

    public void m(@NotNull final View itemView, @NotNull final MsgRecord msgRecord, @NotNull final com.tencent.qqnt.chathistory.ui.base.item.b msgItemModel, @NotNull final QUICheckBox checkbox, @NotNull final Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState, @NotNull final View.OnClickListener listener, @NotNull final String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, itemView, msgRecord, msgItemModel, checkbox, setBottomBarState, listener, elementId);
            return;
        }
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgItemModel, "msgItemModel");
        Intrinsics.checkNotNullParameter(checkbox, "checkbox");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.chathistory.ui.base.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.n(l.this, listener, msgRecord, msgItemModel, setBottomBarState, itemView, elementId, checkbox, view);
            }
        });
        itemView.setAccessibilityDelegate(new a(msgRecord));
    }
}
