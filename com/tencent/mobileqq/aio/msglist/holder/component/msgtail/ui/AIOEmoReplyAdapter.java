package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.AIOTailItemProcessors;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.EmoticonReplyHolder;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.aio.emoreply.g;
import com.tencent.qqnt.aio.emoreply.h;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001XB\u0015\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020100\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0006\u0010\u001e\u001a\u00020\rJ*\u0010$\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010'\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0016J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010)\u001a\u00020\u0006J\u001c\u0010/\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0006\u0012\u0004\u0018\u00010.0,2\u0006\u0010+\u001a\u00020*R\u001a\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R2\u0010>\u001a\u0012\u0012\u0004\u0012\u00020605j\b\u0012\u0004\u0012\u000206`78\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010R\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/AIOEmoReplyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/b;", "emojiItem", "", "j0", "s0", "", "serverId", "Lcom/tencent/qqnt/aio/emoreply/h;", "info", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "getItemCount", "position", "", "getItemId", "getItemViewType", "holder", "p0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "o0", "emojiId", "emojiType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "emoReplyAnimationInfo", "V", "Lkotlin/Function0;", "updateUI", "e0", "u0", "v0", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "emotionInfo", "Lkotlin/Pair;", "", "Landroid/view/View;", "n0", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/ref/WeakReference;", "parentVB", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "l0", "()Ljava/util/ArrayList;", "t0", "(Ljava/util/ArrayList;)V", "dataList", "D", "Z", "isSetResultBack", "()Z", "setSetResultBack", "(Z)V", "E", "Lcom/tencent/qqnt/aio/emoreply/h;", "m0", "()Lcom/tencent/qqnt/aio/emoreply/h;", "setEmoReplyAnimationInfo", "(Lcom/tencent/qqnt/aio/emoreply/h;)V", "Landroid/content/Context;", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "G", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Ljava/lang/ref/WeakReference;)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOEmoReplyAdapter extends RecyclerView.Adapter<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c> implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<g> dataList;

    /* renamed from: D, reason: from kotlin metadata */
    private volatile boolean isSetResultBack;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private h emoReplyAnimationInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<com.tencent.mobileqq.aio.msglist.holder.component.c> parentVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/AIOEmoReplyAdapter$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.AIOEmoReplyAdapter$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOEmoReplyAdapter(@NotNull WeakReference<com.tencent.mobileqq.aio.msglist.holder.component.c> parentVB) {
        Intrinsics.checkNotNullParameter(parentVB, "parentVB");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parentVB);
            return;
        }
        this.parentVB = parentVB;
        this.dataList = new ArrayList<>();
        this.isSetResultBack = true;
    }

    private final void j0(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b emojiItem) {
        Object obj;
        MsgRecord e16 = emojiItem.e();
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((g) obj) instanceof com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.a) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((g) obj) == null) {
            this.dataList.add(new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.a(e16));
        }
        ArrayList<g> arrayList = this.dataList;
        arrayList.add(arrayList.size() - 1, emojiItem);
        notifyItemRangeChanged(this.dataList.size() - 1, 1);
    }

    private final boolean k0(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b emojiItem, int serverId, h info) {
        boolean z16 = false;
        if (!MenuUtils.f351230a.l() || info == null || !emojiItem.g()) {
            return false;
        }
        ArrayList<MsgEmojiLikes> arrayList = emojiItem.e().emojiLikesList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "emojiItem.record.emojiLikesList");
        for (MsgEmojiLikes msgEmojiLikes : arrayList) {
            if (Intrinsics.areEqual(msgEmojiLikes.emojiId, String.valueOf(serverId)) && msgEmojiLikes.emojiType == emojiItem.d()) {
                msgEmojiLikes.likesCnt++;
                msgEmojiLikes.isClicked = emojiItem.g();
                z16 = true;
            }
        }
        MsgEmojiLikes msgEmojiLikes2 = new MsgEmojiLikes(String.valueOf(serverId), emojiItem.d(), emojiItem.b(), emojiItem.g());
        info.k(msgEmojiLikes2);
        if (!z16) {
            emojiItem.e().emojiLikesList.add(msgEmojiLikes2);
            info.l(true);
        }
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar = this.parentVB.get();
        if (cVar != null) {
            cVar.sendIntent(new g.a(info));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(AIOEmoReplyAdapter this$0, com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b emojiItem, int i3, String str) {
        com.tencent.mobileqq.aio.msglist.holder.component.c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(emojiItem, "$emojiItem");
        this$0.isSetResultBack = true;
        if (QLog.isColorLevel()) {
            QLog.d("AIOEmoReplyAdapter", 2, "msgseq:" + emojiItem.e().msgSeq + " setLikeCallback: result=" + i3 + ", errmsg=" + str);
        }
        if (i3 == 65020) {
            String toast = HardCodeUtil.qqStr(R.string.yps);
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(toast, "toast");
            com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context, toast);
        }
        if (i3 != 0 && (cVar = this$0.parentVB.get()) != null) {
            cVar.sendIntent(new g.a(null, 1, null));
        }
    }

    private final void s0(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b emojiItem) {
        Object obj;
        Object obj2;
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                if (emojiItem.j((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g) obj2)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g gVar = (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g) obj2;
        if (gVar != null) {
            int indexOf = this.dataList.indexOf(gVar);
            this.dataList.remove(gVar);
            notifyItemRemoved(indexOf);
        }
        Iterator<T> it5 = this.dataList.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g) next) instanceof com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) {
                obj = next;
                break;
            }
        }
        if (((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g) obj) == null) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.dataList, (Function1) AIOEmoReplyAdapter$removeEmojiReactionItem$4$1.INSTANCE);
            notifyItemRemoved(this.dataList.size());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e
    public boolean V(int emojiId, int emojiType, @NotNull MsgRecord msg2, @Nullable h emoReplyAnimationInfo) {
        Unit unit;
        Object obj;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(emojiId), Integer.valueOf(emojiType), msg2, emoReplyAnimationInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("AIOEmoReplyAdapter", 1, "msgseq:" + msg2.msgSeq + " onEmoticonSelected: emojiId:" + emojiId + ", emojiType:" + emojiType);
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        ITroopApi iTroopApi = (ITroopApi) companion.a(ITroopApi.class);
        String str = msg2.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msg.peerUid");
        if (!iTroopApi.isGagMode(str)) {
            ITroopApi iTroopApi2 = (ITroopApi) companion.a(ITroopApi.class);
            String str2 = msg2.peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msg.peerUid");
            if (!iTroopApi2.isExitTroop(str2)) {
                if (!this.isSetResultBack) {
                    QLog.d("AIOEmoReplyAdapter", 1, "onEmoticonSelected: isSetResultBack = false");
                    return false;
                }
                Iterator<T> it = this.dataList.iterator();
                while (true) {
                    unit = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g gVar = (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g) obj;
                        if ((gVar instanceof com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) && ((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) gVar).i(emojiId, emojiType)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                final com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g gVar2 = (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g) obj;
                if (gVar2 != null) {
                    if (gVar2 instanceof com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) {
                        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) gVar2;
                        if (bVar.g()) {
                            QLog.d("AIOEmoReplyAdapter", 1, "msgseq:" + msg2.msgSeq + " onEmoticonSelected: emojiId:" + emojiId + " is already Selected.");
                            String toast = HardCodeUtil.qqStr(R.string.ypp);
                            BaseApplication context = BaseApplication.getContext();
                            Intrinsics.checkNotNullExpressionValue(toast, "toast");
                            com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context, toast);
                        } else {
                            z16 = e0(bVar, emoReplyAnimationInfo, new Function0<Unit>(gVar2) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.AIOEmoReplyAdapter$onEmoticonSelected$2$updateUI$1
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g $existItem;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                    this.$existItem = gVar2;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOEmoReplyAdapter.this, (Object) gVar2);
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
                                        AIOEmoReplyAdapter aIOEmoReplyAdapter = AIOEmoReplyAdapter.this;
                                        aIOEmoReplyAdapter.notifyItemChanged(aIOEmoReplyAdapter.l0().indexOf(this.$existItem));
                                    }
                                }
                            });
                            unit = Unit.INSTANCE;
                        }
                    }
                    z16 = false;
                    unit = Unit.INSTANCE;
                } else {
                    z16 = false;
                }
                if (unit == null) {
                    if (msg2.emojiLikesList.size() >= 20) {
                        String toast2 = HardCodeUtil.qqStr(R.string.ypq);
                        BaseApplication context2 = BaseApplication.getContext();
                        Intrinsics.checkNotNullExpressionValue(toast2, "toast");
                        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context2, toast2);
                        return false;
                    }
                    final com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b bVar2 = new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b(false, emojiType, 0L, emojiId, msg2);
                    j0(bVar2);
                    return e0(bVar2, emoReplyAnimationInfo, new Function0<Unit>(bVar2) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.AIOEmoReplyAdapter$onEmoticonSelected$3$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b $emoReplyItem;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$emoReplyItem = bVar2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOEmoReplyAdapter.this, (Object) bVar2);
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
                                AIOEmoReplyAdapter aIOEmoReplyAdapter = AIOEmoReplyAdapter.this;
                                aIOEmoReplyAdapter.notifyItemChanged(aIOEmoReplyAdapter.l0().indexOf(this.$emoReplyItem));
                            }
                        }
                    });
                }
                return z16;
            }
        }
        String toast3 = HardCodeUtil.qqStr(R.string.ypr);
        BaseApplication context3 = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(toast3, "toast");
        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context3, toast3);
        QLog.d("AIOEmoReplyAdapter", 1, "onEmoticonSelected: isGagMode or isExitTroop");
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e
    public boolean e0(@NotNull final com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b emojiItem, @Nullable h emoReplyAnimationInfo, @NotNull Function0<Unit> updateUI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, emojiItem, emoReplyAnimationInfo, updateUI)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(emojiItem, "emojiItem");
        Intrinsics.checkNotNullParameter(updateUI, "updateUI");
        QLog.d("AIOEmoReplyAdapter", 1, "msgseq:" + emojiItem.e().msgSeq + " onReplyItemClick: emojiId:" + emojiItem.c() + ", emojiType:$" + emojiItem.d());
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        ITroopApi iTroopApi = (ITroopApi) companion.a(ITroopApi.class);
        String str = emojiItem.e().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "emojiItem.record.peerUid");
        if (!iTroopApi.isGagMode(str)) {
            ITroopApi iTroopApi2 = (ITroopApi) companion.a(ITroopApi.class);
            String str2 = emojiItem.e().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "emojiItem.record.peerUid");
            if (!iTroopApi2.isExitTroop(str2)) {
                if (!this.isSetResultBack) {
                    QLog.d("AIOEmoReplyAdapter", 1, "onReplyItemClick: isSetResultBack = false");
                    return false;
                }
                emojiItem.h();
                if (emojiItem.b() <= 0) {
                    s0(emojiItem);
                }
                if (emojiItem.g()) {
                    com.tencent.qqnt.aio.emoReply.c.f349875a.k(new SystemAndEmojiEmotionInfo(emojiItem.d(), emojiItem.c(), ""));
                }
                updateUI.invoke();
                this.isSetResultBack = false;
                int convertToServer = ((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToServer(emojiItem.c(), emojiItem.d());
                if (convertToServer < 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOEmoReplyAdapter", 2, "msgseq:" + emojiItem.e().msgSeq + " " + emojiItem + " serverId error:" + convertToServer);
                    }
                    return false;
                }
                boolean k06 = k0(emojiItem, convertToServer, emoReplyAnimationInfo);
                ((IAIOEmoReplyApi) companion.a(IAIOEmoReplyApi.class)).setEmojiLikes(emojiItem.e(), String.valueOf(convertToServer), emojiItem.d(), emojiItem.g(), new ISetMsgEmojiLikesCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.ISetMsgEmojiLikesCallback
                    public final void onSetMsgEmojiLikes(int i3, String str3) {
                        AIOEmoReplyAdapter.r0(AIOEmoReplyAdapter.this, emojiItem, i3, str3);
                    }
                });
                return k06;
            }
        }
        String toast = HardCodeUtil.qqStr(R.string.ypr);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(toast, "toast");
        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context, toast);
        QLog.d("AIOEmoReplyAdapter", 1, "onReplyItemClick: isGagMode or isExitTroop");
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this, position)).longValue();
        }
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, position)).intValue();
        }
        return this.dataList.get(position).getType();
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g> l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataList;
    }

    @Nullable
    public final h m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (h) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.emoReplyAnimationInfo;
    }

    @NotNull
    public final Pair<int[], View> n0(@NotNull SystemAndEmojiEmotionInfo emotionInfo) {
        View view;
        ViewGroup viewGroup;
        View view2;
        String joinToString$default;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        int lastIndex;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Pair) iPatchRedirector.redirect((short) 22, (Object) this, (Object) emotionInfo);
        }
        Intrinsics.checkNotNullParameter(emotionInfo, "emotionInfo");
        Iterator<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g next = it.next();
                if ((next instanceof com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) && ((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) next).i(emotionInfo.getCode(), emotionInfo.c())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        QLog.i("AIOEmoReplyAdapter", 1, "getEmoReplyImageViewLocation index:" + i3 + "  size:" + this.dataList.size());
        if (i3 == -1) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.dataList);
            i3 = lastIndex - 1;
        }
        if (i3 >= 0 && i3 < this.dataList.size()) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null && (findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i3)) != null) {
                view = findViewHolderForAdapterPosition.itemView;
            } else {
                view = null;
            }
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                view2 = viewGroup.findViewById(R.id.shc);
            } else {
                view2 = null;
            }
            if (view2 == null) {
                QLog.e("AIOEmoReplyAdapter", 1, "getEmoReplyImageViewLocation view not found index:" + i3);
                return new Pair<>(new int[]{0, 0}, null);
            }
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(iArr, (CharSequence) ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            QLog.i("AIOEmoReplyAdapter", 1, "getEmoReplyImageViewLocation location:" + joinToString$default);
            return new Pair<>(iArr, view);
        }
        QLog.e("AIOEmoReplyAdapter", 1, "getEmoReplyImageViewLocation index out of range index:" + i3);
        return new Pair<>(new int[]{0, 0}, null);
    }

    public final boolean o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.recyclerView != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) recyclerView);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) recyclerView);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g gVar = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(gVar, "dataList[position]");
        holder.n(gVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c) iPatchRedirector.redirect((short) 10, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.context = parent.getContext();
        AIOTailItemProcessors aIOTailItemProcessors = AIOTailItemProcessors.f191237a;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c a16 = aIOTailItemProcessors.a(context, viewType, this, this.parentVB.get());
        if (a16 == null) {
            if (viewType != 1) {
                if (viewType == 2) {
                    a.Companion companion = com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.a.INSTANCE;
                    Context context2 = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                    return new com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.a(companion.a(context2), this);
                }
                throw new IllegalArgumentException("Unknown viewType: " + viewType);
            }
            EmoticonReplyHolder.Companion companion2 = EmoticonReplyHolder.INSTANCE;
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
            return new EmoticonReplyHolder(companion2.a(context3), this);
        }
        return a16;
    }

    public final void t0(@NotNull ArrayList<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
        } else {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.dataList = arrayList;
        }
    }

    public final void u0(@NotNull h emoReplyAnimationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) emoReplyAnimationInfo);
        } else {
            Intrinsics.checkNotNullParameter(emoReplyAnimationInfo, "emoReplyAnimationInfo");
            this.emoReplyAnimationInfo = emoReplyAnimationInfo;
        }
    }

    public final void v0() {
        View view;
        ViewGroup viewGroup;
        View view2;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        int lastIndex;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        h hVar = this.emoReplyAnimationInfo;
        if (hVar != null) {
            int code = hVar.b().getCode();
            int c16 = hVar.b().c();
            Iterator<com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g> it = this.dataList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g next = it.next();
                    if ((next instanceof com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) && ((com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) next).i(code, c16)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 == -1) {
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.dataList);
                i3 = lastIndex - 1;
            }
            if (i3 >= 0 && i3 < this.dataList.size()) {
                RecyclerView recyclerView = this.recyclerView;
                if (recyclerView != null && (findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i3)) != null) {
                    view = findViewHolderForAdapterPosition.itemView;
                } else {
                    view = null;
                }
                if (view instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    view2 = viewGroup.findViewById(R.id.shc);
                } else {
                    view2 = null;
                }
                if (view2 == null) {
                    QLog.e("AIOEmoReplyAdapter", 1, "setNewlyAddedVisible view not found index:" + i3);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(view2, "(recyclerView?.findViewH\u2026     return\n            }");
                view2.setVisibility(0);
                this.emoReplyAnimationInfo = null;
                QLog.i("AIOEmoReplyAdapter", 1, "setNewlyAddedVisible");
                return;
            }
            QLog.e("AIOEmoReplyAdapter", 1, "setNewlyAddedVisible index out of range index:" + i3);
        }
    }
}
