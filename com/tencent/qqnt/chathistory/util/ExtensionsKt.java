package com.tencent.qqnt.chathistory.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.utils.TextContentBuildUtilKt;
import com.tencent.qqnt.chathistory.ui.base.d;
import com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaModel;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.SearchHitInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchMsgItem;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0000\u001a\f\u0010\t\u001a\u00020\b*\u00020\u0007H\u0000\u001a\f\u0010\f\u001a\u00020\u000b*\u00020\nH\u0000\u001a\u0099\u0001\u0010\u001e\u001a\u00020\u0017\"\u0004\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112,\u0010\u0019\u001a(\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00170\u0014\u00a2\u0006\u0002\b\u00182A\u0010\u001d\u001a=\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u001a\u00a2\u0006\u0002\b\u0018H\u0000\u001a\u0014\u0010\"\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010!\u001a\u00020 H\u0000\u001a\u0018\u0010&\u001a\u00020\u00012\u0006\u0010#\u001a\u00020 2\u0006\u0010%\u001a\u00020$H\u0002\u001a\f\u0010'\u001a\u00020\b*\u00020\u0000H\u0000\u001aH\u0010-\u001a\u00028\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010(*\u0004\u0018\u00018\u00002\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)\u00a2\u0006\u0002\b\u00182\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010+H\u0000\u00a2\u0006\u0004\b-\u0010.\u001a\u0010\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020$H\u0000\u001aE\u00108\u001a\u00020\u0017*\u0002012\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00112\u0006\u00105\u001a\u0002042!\u00107\u001a\u001d\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002010)H\u0000\u001a;\u00109\u001a\b\u0012\u0004\u0012\u0002010\u0011*\b\u0012\u0004\u0012\u0002020\u00112!\u00107\u001a\u001d\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002010)H\u0000\u001a\u0014\u0010;\u001a\u00020\u000b*\u00020\n2\u0006\u0010:\u001a\u00020\u0001H\u0000\u001a\u0014\u0010<\u001a\u00020\u000b*\u00020\n2\u0006\u0010:\u001a\u00020\u0001H\u0002\u001a\u001e\u0010>\u001a\u00020\u000b*\u00020\n2\u0006\u0010:\u001a\u00020\u00012\b\u0010=\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\f\u0010?\u001a\u00020\u0005*\u00020\nH\u0000\u001a\f\u0010@\u001a\u00020\u000b*\u00020\u000bH\u0002\u001a\u0014\u0010A\u001a\u00020\u000b*\u00020\n2\u0006\u0010:\u001a\u00020\u0001H\u0002\u001a\u0010\u0010C\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\u0001H\u0000\u001a(\u0010F\u001a\u00020\u0017*\u00020\u00072\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\b0+2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00170+H\u0000\u001a \u0010H\u001a\u00020\u0001*\u0002042\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0)H\u0000\u001a\u0010\u0010J\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u000fH\u0000\u001a\u0010\u0010K\u001a\u00020\b2\u0006\u0010I\u001a\u00020\u000fH\u0000\"\u0018\u0010O\u001a\u00020L*\u00020\u001f8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010N\"\u0014\u0010R\u001a\u00020\u00018@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010Q\u00a8\u0006S"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DomainData.DOMAIN_NAME, "", "l", "Landroidx/recyclerview/widget/RecyclerView;", "", "v", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchMsgItem;", "", "i", "T", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/c;", "Lcom/tencent/qqnt/expandRecyclerView/adapter/node/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "Lkotlin/ExtensionFunctionType;", "newBind", "Lkotlin/Function3;", "Lcom/tencent/qqnt/chathistory/util/i;", "payLoadMap", "updateBind", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "o", "fileInfo", "", "fileSize", "p", "u", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function1;", "yes", "Lkotlin/Function0;", "no", "c", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "lDeadTime", "e", "Lcom/tencent/qqnt/chathistory/ui/base/item/a;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "moreDatas", "Lcom/tencent/qqnt/expandRecyclerView/adapter/provider/b;", "adapter", "msgTime", "groupCreator", "g", "f", "chatType", ReportConstant.COSTREPORT_PREFIX, tl.h.F, "keyword", "t", "r", "d", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "spanCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "enableLoadMore", "preLoad", "w", "predicate", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "node", "y", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/chathistory/ui/base/d;", "k", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;)Lcom/tencent/qqnt/chathistory/ui/base/d;", "fileInvalidState", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "requestNextPageCount", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ExtensionsKt {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/util/ExtensionsKt$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Boolean> f354050d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecyclerView f354051e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f354052f;

        a(Function0<Boolean> function0, RecyclerView recyclerView, Function0<Unit> function02) {
            this.f354050d = function0;
            this.f354051e = recyclerView;
            this.f354052f = function02;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, function0, recyclerView, function02);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (dy5 <= 0 || !this.f354050d.invoke().booleanValue()) {
                return;
            }
            int computeVerticalScrollRange = this.f354051e.computeVerticalScrollRange();
            int computeVerticalScrollExtent = this.f354051e.computeVerticalScrollExtent();
            int computeVerticalScrollOffset = (computeVerticalScrollRange - computeVerticalScrollExtent) - this.f354051e.computeVerticalScrollOffset();
            d.f354054a.a("preLoad", " bottomOffset " + computeVerticalScrollOffset + "  computeVerticalScrollExtent " + computeVerticalScrollExtent + " ");
            if (computeVerticalScrollOffset <= computeVerticalScrollExtent) {
                this.f354052f.invoke();
            }
        }
    }

    private static final CharSequence A(SearchMsgItem searchMsgItem, int i3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<MsgAbstract> arrayList = searchMsgItem.msgAbstract;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.msgAbstract");
        for (MsgAbstract msgAbstract : arrayList) {
            l lVar = l.f354063a;
            ArrayList<MsgAbstractElement> arrayList2 = msgAbstract.elements;
            String peerUid = msgAbstract.peer.peerUid;
            String senderUid = searchMsgItem.senderUid;
            String r16 = r(searchMsgItem);
            BaseApplication context = BaseApplication.getContext();
            AnonymousExtInfo anonymousExtInfo = searchMsgItem.msgRecord.anonymousExtInfo;
            Intrinsics.checkNotNullExpressionValue(peerUid, "peerUid");
            Intrinsics.checkNotNullExpressionValue(senderUid, "senderUid");
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            spannableStringBuilder.append(l.b(lVar, arrayList2, peerUid, senderUid, r16, i3, context, null, anonymousExtInfo, 64, null));
        }
        d.f354054a.a("HistoryExt", "msgAbstract " + ((Object) spannableStringBuilder));
        return spannableStringBuilder;
    }

    public static final <T> void b(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.c cVar, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b item, @NotNull List<? extends Object> payloads, @NotNull Function2<? super com.tencent.qqnt.expandRecyclerView.adapter.provider.c, ? super T, Unit> newBind, @NotNull Function3<? super com.tencent.qqnt.expandRecyclerView.adapter.provider.c, ? super T, ? super i, Unit> updateBind) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Intrinsics.checkNotNullParameter(newBind, "newBind");
        Intrinsics.checkNotNullParameter(updateBind, "updateBind");
        if (payloads.isEmpty()) {
            newBind.invoke(cVar, item);
            return;
        }
        Object obj = payloads.get(0);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.util.PayLoadMap");
        updateBind.invoke(cVar, item, (i) obj);
    }

    public static final <T, R> R c(@Nullable T t16, @NotNull Function1<? super T, ? extends R> yes, @NotNull Function0<? extends R> no5) {
        Intrinsics.checkNotNullParameter(yes, "yes");
        Intrinsics.checkNotNullParameter(no5, "no");
        if (t16 == null) {
            return no5.invoke();
        }
        return yes.invoke(t16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence d(CharSequence charSequence) {
        return ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getQQText(charSequence, 13, com.tencent.qqnt.emotion.constant.b.b(), null, null);
    }

    @NotNull
    public static final String e(long j3) {
        long j16 = j3 * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (j16 <= currentTimeMillis) {
            return "\u5df2\u8fc7\u671f";
        }
        return (((j16 - currentTimeMillis) / 86400000) + 1) + "\u5929\u540e\u5230\u671f";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v13, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Object] */
    @NotNull
    public static final List<com.tencent.qqnt.chathistory.ui.base.item.a> f(@NotNull List<? extends com.tencent.qqnt.chathistory.ui.base.item.b> list, @NotNull Function1<? super Long, ? extends com.tencent.qqnt.chathistory.ui.base.item.a> groupCreator) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(groupCreator, "groupCreator");
        ArrayList arrayList = new ArrayList();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        for (com.tencent.qqnt.chathistory.ui.base.item.b bVar : list) {
            if (com.tencent.qqnt.chathistory.ui.base.j.e(bVar)) {
                if (objectRef.element == 0) {
                    ?? invoke = groupCreator.invoke(Long.valueOf(bVar.getMsgTime()));
                    arrayList.add((com.tencent.qqnt.chathistory.ui.base.item.a) invoke);
                    objectRef.element = invoke;
                }
                T t16 = objectRef.element;
                if (t16 != 0) {
                    ((com.tencent.qqnt.chathistory.ui.base.item.a) t16).f(bVar);
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else {
                if (objectRef2.element == 0) {
                    ?? invoke2 = groupCreator.invoke(Long.valueOf(bVar.getMsgTime()));
                    objectRef2.element = invoke2;
                    Intrinsics.checkNotNull(invoke2);
                    arrayList.add(invoke2);
                }
                T t17 = objectRef2.element;
                if (t17 != 0) {
                    com.tencent.qqnt.chathistory.ui.base.item.a aVar = (com.tencent.qqnt.chathistory.ui.base.item.a) t17;
                    if (com.tencent.qqnt.chathistory.ui.base.j.d(aVar) == com.tencent.qqnt.chathistory.ui.base.j.d(bVar) && com.tencent.qqnt.chathistory.ui.base.j.c(aVar) == com.tencent.qqnt.chathistory.ui.base.j.c(bVar)) {
                        aVar.f(bVar);
                    } else {
                        ?? invoke3 = groupCreator.invoke(Long.valueOf(bVar.getMsgTime()));
                        com.tencent.qqnt.chathistory.ui.base.item.a aVar2 = (com.tencent.qqnt.chathistory.ui.base.item.a) invoke3;
                        arrayList.add(aVar2);
                        aVar2.f(bVar);
                        objectRef2.element = invoke3;
                    }
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd A[LOOP:1: B:20:0x0085->B:25:0x00fd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0100 A[EDGE_INSN: B:26:0x0100->B:31:0x0100 BREAK  A[LOOP:1: B:20:0x0085->B:25:0x00fd], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void g(@NotNull com.tencent.qqnt.chathistory.ui.base.item.a aVar, @NotNull List<? extends com.tencent.qqnt.chathistory.ui.base.item.b> moreDatas, @NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.b adapter, @NotNull Function1<? super Long, ? extends com.tencent.qqnt.chathistory.ui.base.item.a> groupCreator) {
        int lastIndex;
        com.tencent.qqnt.chathistory.ui.base.item.a invoke;
        boolean f16;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(moreDatas, "moreDatas");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(groupCreator, "groupCreator");
        d.f354054a.a("HistoryExt", "lastParentNode " + aVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : moreDatas) {
            com.tencent.qqnt.chathistory.ui.base.item.b bVar = (com.tencent.qqnt.chathistory.ui.base.item.b) obj;
            if (com.tencent.qqnt.chathistory.ui.base.j.e(bVar)) {
                bVar.e(aVar);
                f16 = true;
            } else {
                f16 = com.tencent.qqnt.chathistory.ui.base.j.f(aVar, com.tencent.qqnt.chathistory.ui.base.j.d(bVar), com.tencent.qqnt.chathistory.ui.base.j.c(bVar));
                if (f16) {
                    bVar.e(aVar);
                }
            }
            if (f16) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(moreDatas);
        if (size <= lastIndex) {
            com.tencent.qqnt.chathistory.ui.base.item.a aVar2 = null;
            while (true) {
                com.tencent.qqnt.chathistory.ui.base.item.b bVar2 = moreDatas.get(size);
                d.f354054a.a("HistoryExt", "index " + size + " childNode " + com.tencent.qqnt.chathistory.ui.base.j.d(bVar2) + "- " + com.tencent.qqnt.chathistory.ui.base.j.c(bVar2));
                if (aVar2 == null) {
                    invoke = groupCreator.invoke(Long.valueOf(bVar2.getMsgTime()));
                    invoke.f(bVar2);
                    arrayList2.add(invoke);
                } else if (com.tencent.qqnt.chathistory.ui.base.j.f(aVar2, com.tencent.qqnt.chathistory.ui.base.j.d(bVar2), com.tencent.qqnt.chathistory.ui.base.j.c(bVar2))) {
                    aVar2.f(bVar2);
                    if (size != lastIndex) {
                        break;
                    } else {
                        size++;
                    }
                } else {
                    invoke = groupCreator.invoke(Long.valueOf(bVar2.getMsgTime()));
                    invoke.f(bVar2);
                    arrayList2.add(invoke);
                }
                aVar2 = invoke;
                if (size != lastIndex) {
                }
            }
        }
        if (!arrayList.isEmpty()) {
            adapter.Q0(aVar, aVar.b().size(), arrayList);
            d.f354054a.a("HistoryExt", " dealLoadMore \u62fc\u63a5\u5728\u4e0a\u4e00\u4e2a\u7236\u8282\u70b9  " + arrayList.size());
        }
        if (!arrayList2.isEmpty()) {
            adapter.j0(arrayList2);
            d.f354054a.a("HistoryExt", " dealLoadMore  \u65b0\u52a0\u8282\u70b9 " + arrayList2 + " ");
        }
    }

    private static final CharSequence h(SearchMsgItem searchMsgItem, int i3) {
        if (TextUtils.isEmpty(searchMsgItem.fieldText)) {
            return d(A(searchMsgItem, i3));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(searchMsgItem.fieldText);
        Iterator<SearchHitInfo> it = searchMsgItem.hitsInfo.iterator();
        while (it.hasNext()) {
            SearchHitInfo next = it.next();
            if (spannableStringBuilder.length() >= next.start && spannableStringBuilder.length() >= next.end) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.context, R.color.ac5)), next.start, next.end, 17);
            }
        }
        return d(spannableStringBuilder);
    }

    @NotNull
    public static final CharSequence i(@NotNull SearchMsgItem searchMsgItem) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        CharSequence displayName;
        Intrinsics.checkNotNullParameter(searchMsgItem, "<this>");
        ArrayList<SearchHitInfo> arrayList = searchMsgItem.senderRemarkHits;
        boolean z27 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String str = searchMsgItem.senderRemark;
            ArrayList<SearchHitInfo> senderRemarkHits = searchMsgItem.senderRemarkHits;
            Intrinsics.checkNotNullExpressionValue(senderRemarkHits, "senderRemarkHits");
            displayName = j(searchMsgItem, str, senderRemarkHits);
        } else {
            ArrayList<SearchHitInfo> arrayList2 = searchMsgItem.senderCardHits;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                String str2 = searchMsgItem.senderCard;
                ArrayList<SearchHitInfo> senderCardHits = searchMsgItem.senderCardHits;
                Intrinsics.checkNotNullExpressionValue(senderCardHits, "senderCardHits");
                displayName = j(searchMsgItem, str2, senderCardHits);
            } else {
                ArrayList<SearchHitInfo> arrayList3 = searchMsgItem.senderNickHits;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    String str3 = searchMsgItem.senderNick;
                    ArrayList<SearchHitInfo> senderNickHits = searchMsgItem.senderNickHits;
                    Intrinsics.checkNotNullExpressionValue(senderNickHits, "senderNickHits");
                    displayName = j(searchMsgItem, str3, senderNickHits);
                } else {
                    String str4 = searchMsgItem.senderRemark;
                    if (str4 != null && str4.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        displayName = searchMsgItem.senderRemark;
                    } else {
                        String str5 = searchMsgItem.senderCard;
                        if (str5 != null && str5.length() != 0) {
                            z26 = false;
                        } else {
                            z26 = true;
                        }
                        if (!z26) {
                            displayName = searchMsgItem.senderCard;
                        } else {
                            String str6 = searchMsgItem.senderNick;
                            if (str6 == null || str6.length() == 0) {
                                z27 = true;
                            }
                            if (!z27) {
                                displayName = searchMsgItem.senderNick;
                            } else {
                                d.f354054a.a("HistoryExt", "chat history search name is empty!! : senderRemark = [" + searchMsgItem.senderRemark + "], senderCard = [" + searchMsgItem.senderCard + "], senderNick = [" + searchMsgItem.senderNick + "]");
                                displayName = "";
                            }
                        }
                    }
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(displayName, "displayName");
        return d(displayName);
    }

    private static final SpannableStringBuilder j(SearchMsgItem searchMsgItem, CharSequence charSequence, List<SearchHitInfo> list) {
        boolean z16;
        if (charSequence == null) {
            charSequence = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        for (SearchHitInfo searchHitInfo : list) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(BaseApplication.context, R.color.ac5)), searchHitInfo.start, searchHitInfo.end, 17);
        }
        if (spannableStringBuilder.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            d.f354054a.a("HistoryExt", "chat history search name is empty!! : senderRemark = [" + searchMsgItem.senderRemark + "], senderCard = [" + searchMsgItem.senderCard + "], senderNick = [" + searchMsgItem.senderNick + "], senderRemarkHits = [" + searchMsgItem.senderRemarkHits + "], senderCardHits = [" + searchMsgItem.senderCardHits + "], senderNickHits = [" + searchMsgItem.senderNickHits + "]");
        }
        return spannableStringBuilder;
    }

    @NotNull
    public static final com.tencent.qqnt.chathistory.ui.base.d k(@NotNull FileElement fileElement) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Integer num = fileElement.invalidState;
        if (num != null && num.intValue() == 0) {
            return d.c.f353345a;
        }
        if (num != null && num.intValue() == 1) {
            return d.a.f353343a;
        }
        return d.b.f353344a;
    }

    @Nullable
    public static final String l(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.elements.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        for (MsgElement msgElement : elements) {
            if (msgElement.elementType == 1) {
                l lVar = l.f354063a;
                String str = msgElement.textElement.content;
                Intrinsics.checkNotNullExpressionValue(str, "element.textElement.content");
                for (String str2 : lVar.f(str)) {
                    if (str2 != null) {
                        arrayList.add(str2);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String) arrayList.get(0);
    }

    public static final int m(int i3) {
        int i16;
        double d16;
        k kVar = k.f354062a;
        int b16 = kVar.b();
        int c16 = kVar.c();
        if (b16 > c16) {
            i16 = c16 / 4;
        } else {
            i16 = b16 / 4;
        }
        if (b16 > c16) {
            d16 = b16;
        } else {
            d16 = c16;
        }
        return ((int) ((d16 * 1.5d) / i16)) * 4;
    }

    @Nullable
    public static final MsgElement n(@NotNull MsgRecord msgRecord, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Object obj = null;
        if (msgRecord.elements.isEmpty()) {
            return null;
        }
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((MsgElement) next).elementType == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (MsgElement) obj;
    }

    public static final int o(@NotNull FileElement fileElement, @NotNull FileTransNotifyInfo notifyInfo) {
        Intrinsics.checkNotNullParameter(fileElement, "<this>");
        Intrinsics.checkNotNullParameter(notifyInfo, "notifyInfo");
        return p(notifyInfo, fileElement.fileSize);
    }

    private static final int p(FileTransNotifyInfo fileTransNotifyInfo, long j3) {
        int coerceAtMost;
        if (j3 != 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((int) ((fileTransNotifyInfo.fileProgress * 100) / j3), 100);
            return coerceAtMost;
        }
        return 100;
    }

    public static final int q() {
        return 20;
    }

    @NotNull
    public static final String r(@NotNull SearchMsgItem searchMsgItem) {
        Intrinsics.checkNotNullParameter(searchMsgItem, "<this>");
        if (!TextUtils.isEmpty(searchMsgItem.senderRemark)) {
            String str = searchMsgItem.senderRemark;
            Intrinsics.checkNotNullExpressionValue(str, "this.senderRemark");
            return str;
        }
        if (!TextUtils.isEmpty(searchMsgItem.senderNick)) {
            String str2 = searchMsgItem.senderNick;
            Intrinsics.checkNotNullExpressionValue(str2, "this.senderNick");
            return str2;
        }
        return String.valueOf(searchMsgItem.senderUin);
    }

    @NotNull
    public static final CharSequence s(@NotNull SearchMsgItem searchMsgItem, int i3) {
        Intrinsics.checkNotNullParameter(searchMsgItem, "<this>");
        return h(searchMsgItem, i3);
    }

    @NotNull
    public static final CharSequence t(@NotNull final SearchMsgItem searchMsgItem, int i3, @Nullable final String str) {
        Intrinsics.checkNotNullParameter(searchMsgItem, "<this>");
        if (TextUtils.isEmpty(searchMsgItem.fieldText)) {
            return d(A(searchMsgItem, i3));
        }
        ArrayList<MsgElement> arrayList = searchMsgItem.msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.msgRecord.elements");
        return TextContentBuildUtilKt.b(arrayList, new Function2<Boolean, CharSequence, CharSequence>(str, searchMsgItem) { // from class: com.tencent.qqnt.chathistory.util.ExtensionsKt$getSummery$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $keyword;
            final /* synthetic */ SearchMsgItem $this_getSummery;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$keyword = str;
                this.$this_getSummery = searchMsgItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) searchMsgItem);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CharSequence invoke(Boolean bool, CharSequence charSequence) {
                return invoke(bool.booleanValue(), charSequence);
            }

            @NotNull
            public final CharSequence invoke(boolean z16, @NotNull CharSequence result) {
                CharSequence charSequence;
                CharSequence d16;
                CharSequence d17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (CharSequence) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), result);
                }
                Intrinsics.checkNotNullParameter(result, "result");
                if (z16) {
                    SpannableString b16 = b.b(result.toString(), this.$keyword);
                    Intrinsics.checkNotNullExpressionValue(b16, "getHeadEllipsizedString(\u2026sult.toString(), keyword)");
                    d17 = ExtensionsKt.d(b16);
                    String str2 = this.$keyword;
                    Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type android.text.Spannable");
                    b.c((Spannable) d17, ContextCompat.getColor(BaseApplication.context, R.color.ac5), str2);
                    return d17;
                }
                CharSequence charSequence2 = this.$this_getSummery.fieldText;
                Intrinsics.checkNotNullExpressionValue(charSequence2, "this.fieldText");
                d.f354054a.a("HistoryExt", " keyword " + this.$keyword + "  " + this.$this_getSummery);
                int i16 = this.$this_getSummery.prefixLen;
                if (i16 > 0) {
                    charSequence = charSequence2.subSequence(0, i16);
                    charSequence2 = charSequence2.subSequence(this.$this_getSummery.prefixLen, charSequence2.length());
                } else {
                    charSequence = "";
                }
                SpannableString b17 = b.b(charSequence2.toString(), this.$keyword);
                Intrinsics.checkNotNullExpressionValue(b17, "getHeadEllipsizedString(\u2026ent.toString(),  keyword)");
                d16 = ExtensionsKt.d(b17);
                String str3 = this.$keyword;
                Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type android.text.Spannable");
                b.c((Spannable) d16, ContextCompat.getColor(BaseApplication.context, R.color.ac5), str3);
                SpannableStringBuilder append = new SpannableStringBuilder(charSequence).append(d16);
                Intrinsics.checkNotNullExpressionValue(append, "getHeadEllipsizedString(\u2026.append(it)\n            }");
                return append;
            }
        });
    }

    public static final boolean u(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.sendType == 1) {
            return true;
        }
        return false;
    }

    public static final boolean v(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()) {
            return true;
        }
        return false;
    }

    public static final void w(@NotNull RecyclerView recyclerView, @NotNull Function0<Boolean> enableLoadMore, @NotNull Function0<Unit> preLoad) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(enableLoadMore, "enableLoadMore");
        Intrinsics.checkNotNullParameter(preLoad, "preLoad");
        recyclerView.addOnScrollListener(new a(enableLoadMore, recyclerView, preLoad));
    }

    public static final boolean x(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return node instanceof SearchMediaModel;
    }

    public static final boolean y(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.node.b node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return node instanceof com.tencent.qqnt.chathistory.ui.sticker.data.model.a;
    }

    public static final int z(@NotNull com.tencent.qqnt.expandRecyclerView.adapter.provider.b bVar, @NotNull Function1<? super com.tencent.qqnt.expandRecyclerView.adapter.node.b, Boolean> predicate) {
        Sequence asSequence;
        Sequence<com.tencent.qqnt.expandRecyclerView.adapter.node.b> filter;
        int i3;
        List<com.tencent.qqnt.expandRecyclerView.adapter.node.b> b16;
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        asSequence = CollectionsKt___CollectionsKt.asSequence(bVar.m0());
        filter = SequencesKt___SequencesKt.filter(asSequence, predicate);
        int i16 = 0;
        for (com.tencent.qqnt.expandRecyclerView.adapter.node.b bVar2 : filter) {
            if (bVar2 != null && (b16 = bVar2.b()) != null) {
                i3 = b16.size();
            } else {
                i3 = 0;
            }
            i16 += i3;
        }
        return i16;
    }
}
