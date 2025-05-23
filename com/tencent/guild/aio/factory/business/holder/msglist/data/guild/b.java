package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.api.list.IListUIOperationApi;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J8\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ6\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\bJ\u0010\u0010 \u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u000e\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002J\u0010\u0010#\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u0010\u0010$\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\bJA\u0010,\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\n2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00140&J\u0016\u0010-\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n\u00a8\u00060"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/b;", "", "", "focusMsgSeq", "Lcom/tencent/aio/api/list/IListUIOperationApi;", "helper", "", "a", "Landroid/os/Bundle;", "extra", "", tl.h.F, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "opType", "", "Lcom/tencent/aio/data/msglist/a;", "list", "from", "", DomainData.DOMAIN_NAME, "p", "checkCurrentFocus", "scrollAnimation", "b", "bundle", "j", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "k", "msgSeq", "f", "l", "g", "tag", "Lkotlin/Function1;", "Lat/b;", "Lkotlin/ParameterName;", "name", "intent", "intentSender", "i", "e", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a */
    @NotNull
    public static final b f110545a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/b$a", "Lxs/a$b;", "Landroid/view/View;", "targetView", "", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements a.b {

        /* renamed from: a */
        final /* synthetic */ String f110546a;

        /* renamed from: b */
        final /* synthetic */ Function1<at.b, Unit> f110547b;

        /* renamed from: c */
        final /* synthetic */ int f110548c;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Function1<? super at.b, Unit> function1, int i3) {
            this.f110546a = str;
            this.f110547b = function1;
            this.f110548c = i3;
        }

        @Override // xs.a.b
        public void b(@Nullable View targetView) {
            if (targetView == null) {
                QLog.i(this.f110546a, 1, "processFocusIndex, onScrollComplete targetView is null.");
            }
            this.f110547b.invoke(new bq0.c(this.f110548c, targetView));
            this.f110547b.invoke(a.r.f110486d);
        }
    }

    b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean a(long focusMsgSeq, IListUIOperationApi helper) {
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
        MviUIState mviUIState;
        MsgListItemState msgListItemState;
        com.tencent.aio.base.mvvm.a<?, ?> m3;
        BaseVM<?, ?, C> mUIModel;
        MutableLiveData<?> defaultState;
        try {
            AIOLayoutManager layoutManager = helper.i().getLayoutManager();
            int findFirstCompletelyVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
            QLog.i("GuildMsgListNotifyUtil", 1, "checkMsgInScreen, focusMsgSeq: " + focusMsgSeq + ", firstPos = " + findFirstCompletelyVisibleItemPosition + ", lastPos = " + findLastCompletelyVisibleItemPosition);
            if (findFirstCompletelyVisibleItemPosition > findLastCompletelyVisibleItemPosition) {
                return false;
            }
            while (true) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = helper.i().findViewHolderForAdapterPosition(findFirstCompletelyVisibleItemPosition);
                GuildMsgItem guildMsgItem = null;
                if (findViewHolderForAdapterPosition instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
                    aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition;
                } else {
                    aVar = null;
                }
                if (aVar != null && (m3 = aVar.m()) != null && (mUIModel = m3.getMUIModel()) != 0 && (defaultState = mUIModel.getDefaultState()) != null) {
                    mviUIState = (MviUIState) defaultState.getValue();
                } else {
                    mviUIState = null;
                }
                if (mviUIState instanceof MsgListItemState) {
                    msgListItemState = (MsgListItemState) mviUIState;
                } else {
                    msgListItemState = null;
                }
                if (msgListItemState != null) {
                    com.tencent.aio.data.msglist.a data = msgListItemState.getData();
                    if (data instanceof GuildMsgItem) {
                        guildMsgItem = (GuildMsgItem) data;
                    }
                    if (guildMsgItem != null && guildMsgItem.getMsgSeq() == focusMsgSeq) {
                        return true;
                    }
                }
                if (findFirstCompletelyVisibleItemPosition != findLastCompletelyVisibleItemPosition) {
                    findFirstCompletelyVisibleItemPosition++;
                } else {
                    return false;
                }
            }
        } catch (Exception e16) {
            QLog.e("GuildMsgListNotifyUtil", 1, "checkMsgInScreen exception: " + e16.getMessage());
            return false;
        }
    }

    public static /* synthetic */ Bundle c(b bVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        return bVar.b(z16, z17);
    }

    private final String h(Bundle bundle) {
        long j3;
        if (bundle != null) {
            j3 = bundle.getLong("KEY_NAVIGATE_SEQ", 0L);
        } else {
            j3 = 0;
        }
        boolean z16 = false;
        if (bundle != null) {
            z16 = bundle.getBoolean("KEY_SET_BOTTOM", false);
        }
        if (j3 > 0) {
            return " navigationSeq is " + j3;
        }
        if (z16) {
            return " setBottom";
        }
        return " refresh";
    }

    public static /* synthetic */ void o(b bVar, MsgListRepo msgListRepo, IMsgListRepository.MsgListRepoOpType msgListRepoOpType, List list, String str, Bundle bundle, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            bundle = null;
        }
        bVar.n(msgListRepo, msgListRepoOpType, list, str, bundle);
    }

    @NotNull
    public final Bundle b(boolean checkCurrentFocus, boolean scrollAnimation) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("KEY_SET_BOTTOM", true);
        bundle.putBoolean("check_current_focus", checkCurrentFocus);
        if (!scrollAnimation) {
            bundle.putBoolean("FOCUS_NO_ANIM", true);
        }
        return bundle;
    }

    @NotNull
    public final Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("KEY_SET_HEAD", true);
        return bundle;
    }

    @NotNull
    public final String e(@NotNull String tag, @NotNull String from) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(from, "from");
        String str = "(" + tag + "_" + from + ")";
        Intrinsics.checkNotNullExpressionValue(str, "sb.toString()");
        return str;
    }

    @NotNull
    public final Bundle f(long msgSeq) {
        Bundle bundle = new Bundle();
        if (msgSeq > 0) {
            bundle.putLong("KEY_NAVIGATE_SEQ", msgSeq);
        }
        return bundle;
    }

    public final long g(@Nullable Bundle bundle) {
        if (bundle == null) {
            return -1L;
        }
        return bundle.getLong("KEY_NAVIGATE_SEQ", -1L);
    }

    public final void i(@NotNull MsgListState state, @NotNull IListUIOperationApi helper, @NotNull String tag, @NotNull Function1<? super at.b, Unit> intentSender) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        long g16 = g(state.getExtra());
        Iterator<com.tencent.aio.data.msglist.a> it = state.iterator();
        int i16 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getMsgSeq() == g16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i3 = i16;
                    break;
                }
                i16++;
            } else {
                i3 = -1;
                break;
            }
        }
        QLog.i(tag, 1, "processFocusIndex, FOCUS msgSeq: " + g16 + ", state.size = " + state.size() + ", findIndex=" + i3 + ", opType: " + state.getUpdateType() + ",");
        if (i3 < 0) {
            intentSender.invoke(a.r.f110486d);
            return;
        }
        boolean a16 = a(g16, helper);
        QLog.i(tag, 1, "processFocusIndex, isMsgInScreen: " + a16);
        if (a16) {
            intentSender.invoke(new bq0.c(i3, null, 2, null));
            intentSender.invoke(a.r.f110486d);
        } else {
            helper.i().getLayoutManager().setNeedAnsyAnchor(true);
            a.C11562a.a(helper, i3, false, new a(tag, intentSender, i3), 2, null);
        }
    }

    public final boolean j(@Nullable Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean("KEY_SET_BOTTOM", false);
    }

    public final boolean k(@Nullable Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean("KEY_SET_HEAD", false);
    }

    public final boolean l(@Nullable Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return bundle.containsKey("KEY_NAVIGATE_SEQ");
    }

    public final boolean m(@NotNull MsgListState state, @NotNull IListUIOperationApi helper) {
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (helper.t().isEmpty()) {
            QLog.i("GuildMsgListNotifyUtil", 1, "[handleFocusBottom]: current list is empty.");
            return false;
        }
        Bundle extra = state.getExtra();
        if (extra != null) {
            z16 = extra.getBoolean("check_current_focus", true);
        } else {
            z16 = true;
        }
        Long f16 = helper.f();
        QLog.i("GuildMsgListNotifyUtil", 1, "[handleFocusBottom]: checkCurrentFocus: " + z16 + ", currentFocus is " + f16);
        if (z16 && (f16 == null || f16.longValue() != -1)) {
            return false;
        }
        return true;
    }

    public final void n(@NotNull MsgListRepo host, @NotNull IMsgListRepository.MsgListRepoOpType opType, @NotNull List<? extends com.tencent.aio.data.msglist.a> list, @NotNull String from, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(opType, "opType");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(from, "from");
        if (QLog.isDevelopLevel()) {
            QLog.i("GuildMsgListNotifyUtil", 4, "[notifyMsgChange] " + h(bundle) + ", from: " + from + ", opType: " + opType + ", listSize: " + list.size());
        }
        host.d(opType, list, bundle);
    }

    public final void p(@NotNull MsgListRepo host, @NotNull IMsgListRepository.MsgListRepoOpType opType, @NotNull List<? extends com.tencent.aio.data.msglist.a> list, @NotNull String from, @Nullable Bundle extra) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(opType, "opType");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("GuildMsgListNotifyUtil", 1, "[notifyMsgChange][withLocation] " + h(extra) + ", from: " + from + ", opType: " + opType + ", listSize: " + list.size());
        host.g(opType, list, extra);
    }
}
